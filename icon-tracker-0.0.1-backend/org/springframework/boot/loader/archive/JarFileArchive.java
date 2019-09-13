// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.archive;

import java.util.Enumeration;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import org.springframework.boot.loader.data.RandomAccessData;
import java.util.UUID;
import java.util.jar.JarEntry;
import java.util.zip.ZipEntry;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import org.springframework.boot.loader.jar.JarFile;

public class JarFileArchive implements Archive
{
    private static final String UNPACK_MARKER = "UNPACK:";
    private static final int BUFFER_SIZE = 32768;
    private final JarFile jarFile;
    private URL url;
    private File tempUnpackFolder;
    
    public JarFileArchive(final File file) throws IOException {
        this(file, null);
    }
    
    public JarFileArchive(final File file, final URL url) throws IOException {
        this(new JarFile(file));
        this.url = url;
    }
    
    public JarFileArchive(final JarFile jarFile) {
        this.jarFile = jarFile;
    }
    
    @Override
    public URL getUrl() throws MalformedURLException {
        if (this.url != null) {
            return this.url;
        }
        return this.jarFile.getUrl();
    }
    
    @Override
    public Manifest getManifest() throws IOException {
        return this.jarFile.getManifest();
    }
    
    @Override
    public List<Archive> getNestedArchives(final EntryFilter filter) throws IOException {
        final List<Archive> nestedArchives = new ArrayList<Archive>();
        for (final Entry entry : this) {
            if (filter.matches(entry)) {
                nestedArchives.add(this.getNestedArchive(entry));
            }
        }
        return Collections.unmodifiableList((List<? extends Archive>)nestedArchives);
    }
    
    @Override
    public Iterator<Entry> iterator() {
        return new EntryIterator(this.jarFile.entries());
    }
    
    protected Archive getNestedArchive(final Entry entry) throws IOException {
        final JarEntry jarEntry = ((JarFileEntry)entry).getJarEntry();
        if (jarEntry.getComment().startsWith("UNPACK:")) {
            return this.getUnpackedNestedArchive(jarEntry);
        }
        try {
            final JarFile jarFile = this.jarFile.getNestedJarFile(jarEntry);
            return new JarFileArchive(jarFile);
        }
        catch (Exception ex) {
            throw new IllegalStateException("Failed to get nested archive for entry " + entry.getName(), ex);
        }
    }
    
    private Archive getUnpackedNestedArchive(final JarEntry jarEntry) throws IOException {
        String name = jarEntry.getName();
        if (name.lastIndexOf("/") != -1) {
            name = name.substring(name.lastIndexOf("/") + 1);
        }
        final File file = new File(this.getTempUnpackFolder(), name);
        if (!file.exists() || file.length() != jarEntry.getSize()) {
            this.unpack(jarEntry, file);
        }
        return new JarFileArchive(file, file.toURI().toURL());
    }
    
    private File getTempUnpackFolder() {
        if (this.tempUnpackFolder == null) {
            final File tempFolder = new File(System.getProperty("java.io.tmpdir"));
            this.tempUnpackFolder = this.createUnpackFolder(tempFolder);
        }
        return this.tempUnpackFolder;
    }
    
    private File createUnpackFolder(final File parent) {
        int attempts = 0;
        while (attempts++ < 1000) {
            final String fileName = new File(this.jarFile.getName()).getName();
            final File unpackFolder = new File(parent, fileName + "-spring-boot-libs-" + UUID.randomUUID());
            if (unpackFolder.mkdirs()) {
                return unpackFolder;
            }
        }
        throw new IllegalStateException("Failed to create unpack folder in directory '" + parent + "'");
    }
    
    private void unpack(final JarEntry entry, final File file) throws IOException {
        final InputStream inputStream = this.jarFile.getInputStream(entry, RandomAccessData.ResourceAccess.ONCE);
        try {
            final OutputStream outputStream = new FileOutputStream(file);
            try {
                final byte[] buffer = new byte[32768];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }
            finally {
                outputStream.close();
            }
        }
        finally {
            inputStream.close();
        }
    }
    
    @Override
    public String toString() {
        try {
            return this.getUrl().toString();
        }
        catch (Exception ex) {
            return "jar archive";
        }
    }
    
    private static class EntryIterator implements Iterator<Entry>
    {
        private final Enumeration<JarEntry> enumeration;
        
        EntryIterator(final Enumeration<JarEntry> enumeration) {
            this.enumeration = enumeration;
        }
        
        @Override
        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }
        
        @Override
        public Entry next() {
            return new JarFileEntry(this.enumeration.nextElement());
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
    
    private static class JarFileEntry implements Entry
    {
        private final JarEntry jarEntry;
        
        JarFileEntry(final JarEntry jarEntry) {
            this.jarEntry = jarEntry;
        }
        
        public JarEntry getJarEntry() {
            return this.jarEntry;
        }
        
        @Override
        public boolean isDirectory() {
            return this.jarEntry.isDirectory();
        }
        
        @Override
        public String getName() {
            return this.jarEntry.getName();
        }
    }
}
