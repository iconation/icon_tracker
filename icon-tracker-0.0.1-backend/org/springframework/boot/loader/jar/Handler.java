// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.util.concurrent.ConcurrentHashMap;
import java.net.URLDecoder;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;
import java.io.File;
import java.util.Map;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.net.URLStreamHandler;

public class Handler extends URLStreamHandler
{
    private static final String JAR_PROTOCOL = "jar:";
    private static final String FILE_PROTOCOL = "file:";
    private static final String SEPARATOR = "!/";
    private static final String CURRENT_DIR = "/./";
    private static final Pattern CURRENT_DIR_PATTERN;
    private static final String PARENT_DIR = "/../";
    private static final String[] FALLBACK_HANDLERS;
    private static final Method OPEN_CONNECTION_METHOD;
    private static SoftReference<Map<File, JarFile>> rootFileCache;
    private final JarFile jarFile;
    private URLStreamHandler fallbackHandler;
    
    public Handler() {
        this(null);
    }
    
    public Handler(final JarFile jarFile) {
        this.jarFile = jarFile;
    }
    
    @Override
    protected URLConnection openConnection(final URL url) throws IOException {
        if (this.jarFile != null) {
            return JarURLConnection.get(url, this.jarFile);
        }
        try {
            return JarURLConnection.get(url, this.getRootJarFileFromUrl(url));
        }
        catch (Exception ex) {
            return this.openFallbackConnection(url, ex);
        }
    }
    
    private URLConnection openFallbackConnection(final URL url, final Exception reason) throws IOException {
        try {
            return this.openConnection(this.getFallbackHandler(), url);
        }
        catch (Exception ex) {
            if (reason instanceof IOException) {
                this.log(false, "Unable to open fallback handler", ex);
                throw (IOException)reason;
            }
            this.log(true, "Unable to open fallback handler", ex);
            if (reason instanceof RuntimeException) {
                throw (RuntimeException)reason;
            }
            throw new IllegalStateException(reason);
        }
    }
    
    private void log(final boolean warning, final String message, final Exception cause) {
        try {
            Logger.getLogger(this.getClass().getName()).log(warning ? Level.WARNING : Level.FINEST, message, cause);
        }
        catch (Exception ex) {
            if (warning) {
                System.err.println("WARNING: " + message);
            }
        }
    }
    
    private URLStreamHandler getFallbackHandler() {
        if (this.fallbackHandler != null) {
            return this.fallbackHandler;
        }
        final String[] fallback_HANDLERS = Handler.FALLBACK_HANDLERS;
        final int length = fallback_HANDLERS.length;
        int i = 0;
        while (i < length) {
            final String handlerClassName = fallback_HANDLERS[i];
            try {
                final Class<?> handlerClass = Class.forName(handlerClassName);
                return this.fallbackHandler = (URLStreamHandler)handlerClass.newInstance();
            }
            catch (Exception ex) {
                ++i;
                continue;
            }
            break;
        }
        throw new IllegalStateException("Unable to find fallback handler");
    }
    
    private URLConnection openConnection(final URLStreamHandler handler, final URL url) throws Exception {
        if (Handler.OPEN_CONNECTION_METHOD == null) {
            throw new IllegalStateException("Unable to invoke fallback open connection method");
        }
        Handler.OPEN_CONNECTION_METHOD.setAccessible(true);
        return (URLConnection)Handler.OPEN_CONNECTION_METHOD.invoke(handler, url);
    }
    
    @Override
    protected void parseURL(final URL context, final String spec, final int start, final int limit) {
        if (spec.regionMatches(true, 0, "jar:", 0, "jar:".length())) {
            this.setFile(context, this.getFileFromSpec(spec.substring(start, limit)));
        }
        else {
            this.setFile(context, this.getFileFromContext(context, spec.substring(start, limit)));
        }
    }
    
    private String getFileFromSpec(final String spec) {
        final int separatorIndex = spec.lastIndexOf("!/");
        if (separatorIndex == -1) {
            throw new IllegalArgumentException("No !/ in spec '" + spec + "'");
        }
        try {
            new URL(spec.substring(0, separatorIndex));
            return spec;
        }
        catch (MalformedURLException ex) {
            throw new IllegalArgumentException("Invalid spec URL '" + spec + "'", ex);
        }
    }
    
    private String getFileFromContext(final URL context, final String spec) {
        final String file = context.getFile();
        if (spec.startsWith("/")) {
            return this.trimToJarRoot(file) + "!/" + spec.substring(1);
        }
        if (file.endsWith("/")) {
            return file + spec;
        }
        final int lastSlashIndex = file.lastIndexOf(47);
        if (lastSlashIndex == -1) {
            throw new IllegalArgumentException("No / found in context URL's file '" + file + "'");
        }
        return file.substring(0, lastSlashIndex + 1) + spec;
    }
    
    private String trimToJarRoot(final String file) {
        final int lastSeparatorIndex = file.lastIndexOf("!/");
        if (lastSeparatorIndex == -1) {
            throw new IllegalArgumentException("No !/ found in context URL's file '" + file + "'");
        }
        return file.substring(0, lastSeparatorIndex);
    }
    
    private void setFile(final URL context, final String file) {
        this.setURL(context, "jar:", null, -1, null, null, this.normalize(file), null, null);
    }
    
    private String normalize(final String file) {
        if (!file.contains("/./") && !file.contains("/../")) {
            return file;
        }
        final int afterLastSeparatorIndex = file.lastIndexOf("!/") + "!/".length();
        String afterSeparator = file.substring(afterLastSeparatorIndex);
        afterSeparator = this.replaceParentDir(afterSeparator);
        afterSeparator = this.replaceCurrentDir(afterSeparator);
        return file.substring(0, afterLastSeparatorIndex) + afterSeparator;
    }
    
    private String replaceParentDir(String file) {
        int parentDirIndex;
        while ((parentDirIndex = file.indexOf("/../")) >= 0) {
            final int precedingSlashIndex = file.lastIndexOf(47, parentDirIndex - 1);
            if (precedingSlashIndex >= 0) {
                file = file.substring(0, precedingSlashIndex) + file.substring(parentDirIndex + 3);
            }
            else {
                file = file.substring(parentDirIndex + 4);
            }
        }
        return file;
    }
    
    private String replaceCurrentDir(final String file) {
        return Handler.CURRENT_DIR_PATTERN.matcher(file).replaceAll("/");
    }
    
    @Override
    protected int hashCode(final URL u) {
        return this.hashCode(u.getProtocol(), u.getFile());
    }
    
    private int hashCode(final String protocol, final String file) {
        int result = (protocol == null) ? 0 : protocol.hashCode();
        final int separatorIndex = file.indexOf("!/");
        if (separatorIndex == -1) {
            return result + file.hashCode();
        }
        final String source = file.substring(0, separatorIndex);
        final String entry = this.canonicalize(file.substring(separatorIndex + 2));
        try {
            result += new URL(source).hashCode();
        }
        catch (MalformedURLException ex) {
            result += source.hashCode();
        }
        result += entry.hashCode();
        return result;
    }
    
    @Override
    protected boolean sameFile(final URL u1, final URL u2) {
        if (!u1.getProtocol().equals("jar") || !u2.getProtocol().equals("jar")) {
            return false;
        }
        final int separator1 = u1.getFile().indexOf("!/");
        final int separator2 = u2.getFile().indexOf("!/");
        if (separator1 == -1 || separator2 == -1) {
            return super.sameFile(u1, u2);
        }
        final String nested1 = u1.getFile().substring(separator1 + "!/".length());
        final String nested2 = u2.getFile().substring(separator2 + "!/".length());
        if (!nested1.equals(nested2)) {
            final String canonical1 = this.canonicalize(nested1);
            final String canonical2 = this.canonicalize(nested2);
            if (!canonical1.equals(canonical2)) {
                return false;
            }
        }
        final String root1 = u1.getFile().substring(0, separator1);
        final String root2 = u2.getFile().substring(0, separator2);
        try {
            return super.sameFile(new URL(root1), new URL(root2));
        }
        catch (MalformedURLException ex) {
            return super.sameFile(u1, u2);
        }
    }
    
    private String canonicalize(final String path) {
        return path.replace("!/", "/");
    }
    
    public JarFile getRootJarFileFromUrl(final URL url) throws IOException {
        final String spec = url.getFile();
        final int separatorIndex = spec.indexOf("!/");
        if (separatorIndex == -1) {
            throw new MalformedURLException("Jar URL does not contain !/ separator");
        }
        final String name = spec.substring(0, separatorIndex);
        return this.getRootJarFile(name);
    }
    
    private JarFile getRootJarFile(final String name) throws IOException {
        try {
            if (!name.startsWith("file:")) {
                throw new IllegalStateException("Not a file URL");
            }
            final String path = name.substring("file:".length());
            final File file = new File(URLDecoder.decode(path, "UTF-8"));
            final Map<File, JarFile> cache = Handler.rootFileCache.get();
            JarFile result = (cache == null) ? null : cache.get(file);
            if (result == null) {
                result = new JarFile(file);
                addToRootFileCache(file, result);
            }
            return result;
        }
        catch (Exception ex) {
            throw new IOException("Unable to open root Jar file '" + name + "'", ex);
        }
    }
    
    static void addToRootFileCache(final File sourceFile, final JarFile jarFile) {
        Map<File, JarFile> cache = Handler.rootFileCache.get();
        if (cache == null) {
            cache = new ConcurrentHashMap<File, JarFile>();
            Handler.rootFileCache = new SoftReference<Map<File, JarFile>>(cache);
        }
        cache.put(sourceFile, jarFile);
    }
    
    public static void setUseFastConnectionExceptions(final boolean useFastConnectionExceptions) {
        JarURLConnection.setUseFastExceptions(useFastConnectionExceptions);
    }
    
    static {
        CURRENT_DIR_PATTERN = Pattern.compile("/./");
        FALLBACK_HANDLERS = new String[] { "sun.net.www.protocol.jar.Handler" };
        Method method = null;
        try {
            method = URLStreamHandler.class.getDeclaredMethod("openConnection", URL.class);
        }
        catch (Exception ex) {}
        OPEN_CONNECTION_METHOD = method;
        Handler.rootFileCache = new SoftReference<Map<File, JarFile>>(null);
    }
}
