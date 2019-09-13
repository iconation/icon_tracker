// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.net.URLStreamHandlerFactory;
import java.util.jar.JarInputStream;
import java.net.MalformedURLException;
import java.net.URLStreamHandler;
import java.util.zip.ZipEntry;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.Enumeration;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.util.jar.Manifest;
import java.lang.ref.SoftReference;
import java.net.URL;
import org.springframework.boot.loader.data.RandomAccessData;
import org.springframework.boot.loader.data.RandomAccessDataFile;

public class JarFile extends java.util.jar.JarFile
{
    private static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    private static final String PROTOCOL_HANDLER = "java.protocol.handler.pkgs";
    private static final String HANDLERS_PACKAGE = "org.springframework.boot.loader";
    private static final AsciiBytes META_INF;
    private static final AsciiBytes SIGNATURE_FILE_EXTENSION;
    private final RandomAccessDataFile rootFile;
    private final String pathFromRoot;
    private final RandomAccessData data;
    private final JarFileType type;
    private URL url;
    private JarFileEntries entries;
    private SoftReference<Manifest> manifest;
    private boolean signed;
    
    public JarFile(final File file) throws IOException {
        this(new RandomAccessDataFile(file));
    }
    
    JarFile(final RandomAccessDataFile file) throws IOException {
        this(file, "", file, JarFileType.DIRECT);
    }
    
    private JarFile(final RandomAccessDataFile rootFile, final String pathFromRoot, final RandomAccessData data, final JarFileType type) throws IOException {
        this(rootFile, pathFromRoot, data, null, type);
    }
    
    private JarFile(final RandomAccessDataFile rootFile, final String pathFromRoot, final RandomAccessData data, final JarEntryFilter filter, final JarFileType type) throws IOException {
        super(rootFile.getFile());
        this.rootFile = rootFile;
        this.pathFromRoot = pathFromRoot;
        final CentralDirectoryParser parser = new CentralDirectoryParser();
        this.entries = parser.addVisitor(new JarFileEntries(this, filter));
        parser.addVisitor(this.centralDirectoryVisitor());
        this.data = parser.parse(data, filter == null);
        this.type = type;
    }
    
    private CentralDirectoryVisitor centralDirectoryVisitor() {
        return new CentralDirectoryVisitor() {
            @Override
            public void visitStart(final CentralDirectoryEndRecord endRecord, final RandomAccessData centralDirectoryData) {
            }
            
            @Override
            public void visitFileHeader(final CentralDirectoryFileHeader fileHeader, final int dataOffset) {
                final AsciiBytes name = fileHeader.getName();
                if (name.startsWith(JarFile.META_INF) && name.endsWith(JarFile.SIGNATURE_FILE_EXTENSION)) {
                    JarFile.this.signed = true;
                }
            }
            
            @Override
            public void visitEnd() {
            }
        };
    }
    
    protected final RandomAccessDataFile getRootJarFile() {
        return this.rootFile;
    }
    
    RandomAccessData getData() {
        return this.data;
    }
    
    @Override
    public Manifest getManifest() throws IOException {
        Manifest manifest = (this.manifest == null) ? null : this.manifest.get();
        if (manifest == null) {
            if (this.type == JarFileType.NESTED_DIRECTORY) {
                manifest = new JarFile(this.getRootJarFile()).getManifest();
            }
            else {
                final InputStream inputStream = this.getInputStream("META-INF/MANIFEST.MF", RandomAccessData.ResourceAccess.ONCE);
                if (inputStream == null) {
                    return null;
                }
                try {
                    manifest = new Manifest(inputStream);
                }
                finally {
                    inputStream.close();
                }
            }
            this.manifest = new SoftReference<Manifest>(manifest);
        }
        return manifest;
    }
    
    @Override
    public Enumeration<JarEntry> entries() {
        final Iterator<org.springframework.boot.loader.jar.JarEntry> iterator = this.entries.iterator();
        return new Enumeration<JarEntry>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }
            
            @Override
            public JarEntry nextElement() {
                return iterator.next();
            }
        };
    }
    
    @Override
    public org.springframework.boot.loader.jar.JarEntry getJarEntry(final String name) {
        return (org.springframework.boot.loader.jar.JarEntry)this.getEntry(name);
    }
    
    public boolean containsEntry(final String name) {
        return this.entries.containsEntry(name);
    }
    
    @Override
    public ZipEntry getEntry(final String name) {
        return this.entries.getEntry(name);
    }
    
    @Override
    public synchronized InputStream getInputStream(final ZipEntry ze) throws IOException {
        return this.getInputStream(ze, RandomAccessData.ResourceAccess.PER_READ);
    }
    
    public InputStream getInputStream(final ZipEntry ze, final RandomAccessData.ResourceAccess access) throws IOException {
        if (ze instanceof org.springframework.boot.loader.jar.JarEntry) {
            return this.entries.getInputStream((FileHeader)ze, access);
        }
        return this.getInputStream((ze == null) ? null : ze.getName(), access);
    }
    
    InputStream getInputStream(final String name, final RandomAccessData.ResourceAccess access) throws IOException {
        return this.entries.getInputStream(name, access);
    }
    
    public synchronized JarFile getNestedJarFile(final ZipEntry entry) throws IOException {
        return this.getNestedJarFile((org.springframework.boot.loader.jar.JarEntry)entry);
    }
    
    public synchronized JarFile getNestedJarFile(final org.springframework.boot.loader.jar.JarEntry entry) throws IOException {
        try {
            return this.createJarFileFromEntry(entry);
        }
        catch (Exception ex) {
            throw new IOException("Unable to open nested jar file '" + entry.getName() + "'", ex);
        }
    }
    
    private JarFile createJarFileFromEntry(final org.springframework.boot.loader.jar.JarEntry entry) throws IOException {
        if (entry.isDirectory()) {
            return this.createJarFileFromDirectoryEntry(entry);
        }
        return this.createJarFileFromFileEntry(entry);
    }
    
    private JarFile createJarFileFromDirectoryEntry(final org.springframework.boot.loader.jar.JarEntry entry) throws IOException {
        final AsciiBytes sourceName = new AsciiBytes(entry.getName());
        final JarEntryFilter filter = new JarEntryFilter() {
            @Override
            public AsciiBytes apply(final AsciiBytes name) {
                if (name.startsWith(sourceName) && !name.equals(sourceName)) {
                    return name.substring(sourceName.length());
                }
                return null;
            }
        };
        return new JarFile(this.rootFile, this.pathFromRoot + "!/" + entry.getName().substring(0, sourceName.length() - 1), this.data, filter, JarFileType.NESTED_DIRECTORY);
    }
    
    private JarFile createJarFileFromFileEntry(final org.springframework.boot.loader.jar.JarEntry entry) throws IOException {
        if (entry.getMethod() != 0) {
            throw new IllegalStateException("Unable to open nested entry '" + entry.getName() + "'. It has been compressed and nested jar files must be stored without compression. Please check the mechanism used to create your executable jar file");
        }
        final RandomAccessData entryData = this.entries.getEntryData(entry.getName());
        return new JarFile(this.rootFile, this.pathFromRoot + "!/" + entry.getName(), entryData, JarFileType.NESTED_JAR);
    }
    
    @Override
    public int size() {
        return (int)this.data.getSize();
    }
    
    @Override
    public void close() throws IOException {
        super.close();
        this.rootFile.close();
    }
    
    public URL getUrl() throws MalformedURLException {
        if (this.url == null) {
            final Handler handler = new Handler(this);
            String file = this.rootFile.getFile().toURI() + this.pathFromRoot + "!/";
            file = file.replace("file:////", "file://");
            this.url = new URL("jar", "", -1, file, handler);
        }
        return this.url;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
    @Override
    public String getName() {
        return this.rootFile.getFile() + this.pathFromRoot;
    }
    
    boolean isSigned() {
        return this.signed;
    }
    
    void setupEntryCertificates(final org.springframework.boot.loader.jar.JarEntry entry) {
        try {
            final JarInputStream inputStream = new JarInputStream(this.getData().getInputStream(RandomAccessData.ResourceAccess.ONCE));
            try {
                for (JarEntry certEntry = inputStream.getNextJarEntry(); certEntry != null; certEntry = inputStream.getNextJarEntry()) {
                    inputStream.closeEntry();
                    if (entry.getName().equals(certEntry.getName())) {
                        this.setCertificates(entry, certEntry);
                    }
                    this.setCertificates(this.getJarEntry(certEntry.getName()), certEntry);
                }
            }
            finally {
                inputStream.close();
            }
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private void setCertificates(final org.springframework.boot.loader.jar.JarEntry entry, final JarEntry certEntry) {
        if (entry != null) {
            entry.setCertificates(certEntry);
        }
    }
    
    public void clearCache() {
        this.entries.clearCache();
    }
    
    protected String getPathFromRoot() {
        return this.pathFromRoot;
    }
    
    JarFileType getType() {
        return this.type;
    }
    
    public static void registerUrlProtocolHandler() {
        final String handlers = System.getProperty("java.protocol.handler.pkgs", "");
        System.setProperty("java.protocol.handler.pkgs", "".equals(handlers) ? "org.springframework.boot.loader" : (handlers + "|" + "org.springframework.boot.loader"));
        resetCachedUrlHandlers();
    }
    
    private static void resetCachedUrlHandlers() {
        try {
            URL.setURLStreamHandlerFactory(null);
        }
        catch (Error error) {}
    }
    
    static {
        META_INF = new AsciiBytes("META-INF/");
        SIGNATURE_FILE_EXTENSION = new AsciiBytes(".SF");
    }
    
    enum JarFileType
    {
        DIRECT, 
        NESTED_DIRECTORY, 
        NESTED_JAR;
    }
}
