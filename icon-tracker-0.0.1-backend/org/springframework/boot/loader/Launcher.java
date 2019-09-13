// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader;

import java.net.URI;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import org.springframework.boot.loader.archive.JarFileArchive;
import org.springframework.boot.loader.archive.ExplodedArchive;
import java.io.File;
import java.util.Iterator;
import java.net.URL;
import java.util.ArrayList;
import org.springframework.boot.loader.archive.Archive;
import java.util.List;
import org.springframework.boot.loader.jar.JarFile;

public abstract class Launcher
{
    protected void launch(final String[] args) throws Exception {
        JarFile.registerUrlProtocolHandler();
        final ClassLoader classLoader = this.createClassLoader(this.getClassPathArchives());
        this.launch(args, this.getMainClass(), classLoader);
    }
    
    protected ClassLoader createClassLoader(final List<Archive> archives) throws Exception {
        final List<URL> urls = new ArrayList<URL>(archives.size());
        for (final Archive archive : archives) {
            urls.add(archive.getUrl());
        }
        return this.createClassLoader(urls.toArray(new URL[urls.size()]));
    }
    
    protected ClassLoader createClassLoader(final URL[] urls) throws Exception {
        return new LaunchedURLClassLoader(urls, this.getClass().getClassLoader());
    }
    
    protected void launch(final String[] args, final String mainClass, final ClassLoader classLoader) throws Exception {
        Thread.currentThread().setContextClassLoader(classLoader);
        this.createMainMethodRunner(mainClass, args, classLoader).run();
    }
    
    protected MainMethodRunner createMainMethodRunner(final String mainClass, final String[] args, final ClassLoader classLoader) {
        return new MainMethodRunner(mainClass, args);
    }
    
    protected abstract String getMainClass() throws Exception;
    
    protected abstract List<Archive> getClassPathArchives() throws Exception;
    
    protected final Archive createArchive() throws Exception {
        final ProtectionDomain protectionDomain = this.getClass().getProtectionDomain();
        final CodeSource codeSource = protectionDomain.getCodeSource();
        final URI location = (codeSource == null) ? null : codeSource.getLocation().toURI();
        final String path = (location == null) ? null : location.getSchemeSpecificPart();
        if (path == null) {
            throw new IllegalStateException("Unable to determine code source archive");
        }
        final File root = new File(path);
        if (!root.exists()) {
            throw new IllegalStateException("Unable to determine code source archive from " + root);
        }
        return root.isDirectory() ? new ExplodedArchive(root) : new JarFileArchive(root);
    }
}
