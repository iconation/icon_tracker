// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.ByteArrayOutputStream;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.io.FilePermission;
import java.util.zip.ZipEntry;
import org.springframework.boot.loader.data.RandomAccessData;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.io.IOException;
import java.security.Permission;
import java.net.URL;
import java.io.FileNotFoundException;

final class JarURLConnection extends java.net.JarURLConnection
{
    private static ThreadLocal<Boolean> useFastExceptions;
    private static final FileNotFoundException FILE_NOT_FOUND_EXCEPTION;
    private static final IllegalStateException NOT_FOUND_CONNECTION_EXCEPTION;
    private static final String SEPARATOR = "!/";
    private static final URL EMPTY_JAR_URL;
    private static final JarEntryName EMPTY_JAR_ENTRY_NAME;
    private static final String READ_ACTION = "read";
    private static final JarURLConnection NOT_FOUND_CONNECTION;
    private final JarFile jarFile;
    private Permission permission;
    private URL jarFileUrl;
    private final JarEntryName jarEntryName;
    private JarEntry jarEntry;
    
    private JarURLConnection(final URL url, final JarFile jarFile, final JarEntryName jarEntryName) throws IOException {
        super(JarURLConnection.EMPTY_JAR_URL);
        this.url = url;
        this.jarFile = jarFile;
        this.jarEntryName = jarEntryName;
    }
    
    @Override
    public void connect() throws IOException {
        if (this.jarFile == null) {
            throw JarURLConnection.FILE_NOT_FOUND_EXCEPTION;
        }
        if (!this.jarEntryName.isEmpty() && this.jarEntry == null) {
            this.jarEntry = this.jarFile.getJarEntry(this.getEntryName());
            if (this.jarEntry == null) {
                this.throwFileNotFound(this.jarEntryName, this.jarFile);
            }
        }
        this.connected = true;
    }
    
    @Override
    public JarFile getJarFile() throws IOException {
        this.connect();
        return this.jarFile;
    }
    
    @Override
    public URL getJarFileURL() {
        if (this.jarFile == null) {
            throw JarURLConnection.NOT_FOUND_CONNECTION_EXCEPTION;
        }
        if (this.jarFileUrl == null) {
            this.jarFileUrl = this.buildJarFileUrl();
        }
        return this.jarFileUrl;
    }
    
    private URL buildJarFileUrl() {
        try {
            String spec = this.jarFile.getUrl().getFile();
            if (spec.endsWith("!/")) {
                spec = spec.substring(0, spec.length() - "!/".length());
            }
            if (spec.indexOf("!/") == -1) {
                return new URL(spec);
            }
            return new URL("jar:" + spec);
        }
        catch (MalformedURLException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public JarEntry getJarEntry() throws IOException {
        if (this.jarEntryName == null || this.jarEntryName.isEmpty()) {
            return null;
        }
        this.connect();
        return this.jarEntry;
    }
    
    @Override
    public String getEntryName() {
        if (this.jarFile == null) {
            throw JarURLConnection.NOT_FOUND_CONNECTION_EXCEPTION;
        }
        return this.jarEntryName.toString();
    }
    
    @Override
    public InputStream getInputStream() throws IOException {
        if (this.jarFile == null) {
            throw JarURLConnection.FILE_NOT_FOUND_EXCEPTION;
        }
        if (this.jarEntryName.isEmpty() && this.jarFile.getType() == JarFile.JarFileType.DIRECT) {
            throw new IOException("no entry name specified");
        }
        this.connect();
        final InputStream inputStream = this.jarEntryName.isEmpty() ? this.jarFile.getData().getInputStream(RandomAccessData.ResourceAccess.ONCE) : this.jarFile.getInputStream(this.jarEntry);
        if (inputStream == null) {
            this.throwFileNotFound(this.jarEntryName, this.jarFile);
        }
        return inputStream;
    }
    
    private void throwFileNotFound(final Object entry, final JarFile jarFile) throws FileNotFoundException {
        if (Boolean.TRUE.equals(JarURLConnection.useFastExceptions.get())) {
            throw JarURLConnection.FILE_NOT_FOUND_EXCEPTION;
        }
        throw new FileNotFoundException("JAR entry " + entry + " not found in " + jarFile.getName());
    }
    
    @Override
    public int getContentLength() {
        final long length = this.getContentLengthLong();
        if (length > 2147483647L) {
            return -1;
        }
        return (int)length;
    }
    
    @Override
    public long getContentLengthLong() {
        if (this.jarFile == null) {
            return -1L;
        }
        try {
            if (this.jarEntryName.isEmpty()) {
                return this.jarFile.size();
            }
            final JarEntry entry = this.getJarEntry();
            return (entry == null) ? -1 : ((int)entry.getSize());
        }
        catch (IOException ex) {
            return -1L;
        }
    }
    
    @Override
    public Object getContent() throws IOException {
        this.connect();
        return this.jarEntryName.isEmpty() ? this.jarFile : super.getContent();
    }
    
    @Override
    public String getContentType() {
        return (this.jarEntryName == null) ? null : this.jarEntryName.getContentType();
    }
    
    @Override
    public Permission getPermission() throws IOException {
        if (this.jarFile == null) {
            throw JarURLConnection.FILE_NOT_FOUND_EXCEPTION;
        }
        if (this.permission == null) {
            this.permission = new FilePermission(this.jarFile.getRootJarFile().getFile().getPath(), "read");
        }
        return this.permission;
    }
    
    @Override
    public long getLastModified() {
        if (this.jarFile == null || this.jarEntryName.isEmpty()) {
            return 0L;
        }
        try {
            final JarEntry entry = this.getJarEntry();
            return (entry == null) ? 0L : entry.getTime();
        }
        catch (IOException ex) {
            return 0L;
        }
    }
    
    static void setUseFastExceptions(final boolean useFastExceptions) {
        JarURLConnection.useFastExceptions.set(useFastExceptions);
    }
    
    static JarURLConnection get(final URL url, JarFile jarFile) throws IOException {
        String spec;
        int index;
        int separator;
        String entryName;
        JarEntry jarEntry;
        for (spec = extractFullSpec(url, jarFile.getPathFromRoot()), index = 0; (separator = spec.indexOf("!/", index)) > 0; index += separator + "!/".length()) {
            entryName = spec.substring(index, separator);
            jarEntry = jarFile.getJarEntry(entryName);
            if (jarEntry == null) {
                return notFound(jarFile, JarEntryName.get(entryName));
            }
            jarFile = jarFile.getNestedJarFile(jarEntry);
        }
        final JarEntryName jarEntryName = JarEntryName.get(spec, index);
        if (Boolean.TRUE.equals(JarURLConnection.useFastExceptions.get()) && !jarEntryName.isEmpty() && !jarFile.containsEntry(jarEntryName.toString())) {
            return JarURLConnection.NOT_FOUND_CONNECTION;
        }
        return new JarURLConnection(url, jarFile, jarEntryName);
    }
    
    private static String extractFullSpec(final URL url, final String pathFromRoot) {
        final String file = url.getFile();
        final int separatorIndex = file.indexOf("!/");
        if (separatorIndex < 0) {
            return "";
        }
        final int specIndex = separatorIndex + "!/".length() + pathFromRoot.length();
        return file.substring(specIndex);
    }
    
    private static JarURLConnection notFound() {
        try {
            return notFound(null, null);
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private static JarURLConnection notFound(final JarFile jarFile, final JarEntryName jarEntryName) throws IOException {
        if (Boolean.TRUE.equals(JarURLConnection.useFastExceptions.get())) {
            return JarURLConnection.NOT_FOUND_CONNECTION;
        }
        return new JarURLConnection(null, jarFile, jarEntryName);
    }
    
    static {
        JarURLConnection.useFastExceptions = new ThreadLocal<Boolean>();
        FILE_NOT_FOUND_EXCEPTION = new FileNotFoundException("Jar file or entry not found");
        NOT_FOUND_CONNECTION_EXCEPTION = new IllegalStateException(JarURLConnection.FILE_NOT_FOUND_EXCEPTION);
        try {
            EMPTY_JAR_URL = new URL("jar:", null, 0, "file:!/", new URLStreamHandler() {
                @Override
                protected URLConnection openConnection(final URL u) throws IOException {
                    return null;
                }
            });
        }
        catch (MalformedURLException ex) {
            throw new IllegalStateException(ex);
        }
        EMPTY_JAR_ENTRY_NAME = new JarEntryName("");
        NOT_FOUND_CONNECTION = notFound();
    }
    
    static class JarEntryName
    {
        private final String name;
        private String contentType;
        
        JarEntryName(final String spec) {
            this.name = this.decode(spec);
        }
        
        private String decode(final String source) {
            if (source.isEmpty() || source.indexOf(37) < 0) {
                return source;
            }
            final ByteArrayOutputStream bos = new ByteArrayOutputStream(source.length());
            this.write(source, bos);
            return AsciiBytes.toString(bos.toByteArray());
        }
        
        private void write(final String source, final ByteArrayOutputStream outputStream) {
            for (int length = source.length(), i = 0; i < length; ++i) {
                int c = source.charAt(i);
                if (c > 127) {
                    try {
                        final String encoded = URLEncoder.encode(String.valueOf((char)c), "UTF-8");
                        this.write(encoded, outputStream);
                        continue;
                    }
                    catch (UnsupportedEncodingException ex) {
                        throw new IllegalStateException(ex);
                    }
                }
                if (c == 37) {
                    if (i + 2 >= length) {
                        throw new IllegalArgumentException("Invalid encoded sequence \"" + source.substring(i) + "\"");
                    }
                    c = this.decodeEscapeSequence(source, i);
                    i += 2;
                }
                outputStream.write(c);
            }
        }
        
        private char decodeEscapeSequence(final String source, final int i) {
            final int hi = Character.digit(source.charAt(i + 1), 16);
            final int lo = Character.digit(source.charAt(i + 2), 16);
            if (hi == -1 || lo == -1) {
                throw new IllegalArgumentException("Invalid encoded sequence \"" + source.substring(i) + "\"");
            }
            return (char)((hi << 4) + lo);
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public boolean isEmpty() {
            return this.name.isEmpty();
        }
        
        public String getContentType() {
            if (this.contentType == null) {
                this.contentType = this.deduceContentType();
            }
            return this.contentType;
        }
        
        private String deduceContentType() {
            String type = this.isEmpty() ? "x-java/jar" : null;
            type = ((type != null) ? type : URLConnection.guessContentTypeFromName(this.toString()));
            type = ((type != null) ? type : "content/unknown");
            return type;
        }
        
        public static JarEntryName get(final String spec) {
            return get(spec, 0);
        }
        
        public static JarEntryName get(final String spec, final int beginIndex) {
            if (spec.length() <= beginIndex) {
                return JarURLConnection.EMPTY_JAR_ENTRY_NAME;
            }
            return new JarEntryName(spec.substring(beginIndex));
        }
    }
}
