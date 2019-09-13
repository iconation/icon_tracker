// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader;

import java.util.jar.Manifest;
import org.springframework.lang.UsesJava7;
import java.security.PrivilegedActionException;
import java.security.AccessController;
import java.util.jar.JarFile;
import java.net.URLConnection;
import java.net.JarURLConnection;
import java.security.PrivilegedExceptionAction;
import java.io.IOException;
import java.util.Enumeration;
import org.springframework.boot.loader.jar.Handler;
import java.net.URL;
import java.net.URLClassLoader;

public class LaunchedURLClassLoader extends URLClassLoader
{
    public LaunchedURLClassLoader(final URL[] urls, final ClassLoader parent) {
        super(urls, parent);
    }
    
    @Override
    public URL findResource(final String name) {
        Handler.setUseFastConnectionExceptions(true);
        try {
            return super.findResource(name);
        }
        finally {
            Handler.setUseFastConnectionExceptions(false);
        }
    }
    
    @Override
    public Enumeration<URL> findResources(final String name) throws IOException {
        Handler.setUseFastConnectionExceptions(true);
        try {
            return super.findResources(name);
        }
        finally {
            Handler.setUseFastConnectionExceptions(false);
        }
    }
    
    @Override
    protected Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
        Handler.setUseFastConnectionExceptions(true);
        try {
            try {
                this.definePackageIfNecessary(name);
            }
            catch (IllegalArgumentException ex) {
                if (this.getPackage(name) == null) {
                    throw new AssertionError((Object)("Package " + name + " has already been defined but it could not be found"));
                }
            }
            return super.loadClass(name, resolve);
        }
        finally {
            Handler.setUseFastConnectionExceptions(false);
        }
    }
    
    private void definePackageIfNecessary(final String className) {
        final int lastDot = className.lastIndexOf(46);
        if (lastDot >= 0) {
            final String packageName = className.substring(0, lastDot);
            if (this.getPackage(packageName) == null) {
                try {
                    this.definePackage(className, packageName);
                }
                catch (IllegalArgumentException ex) {
                    if (this.getPackage(packageName) == null) {
                        throw new AssertionError((Object)("Package " + packageName + " has already been defined but it could not be found"));
                    }
                }
            }
        }
    }
    
    private void definePackage(final String className, final String packageName) {
        try {
            AccessController.doPrivileged((PrivilegedExceptionAction<Object>)new PrivilegedExceptionAction<Object>() {
                @Override
                public Object run() throws ClassNotFoundException {
                    final String packageEntryName = packageName.replace('.', '/') + "/";
                    final String classEntryName = className.replace('.', '/') + ".class";
                    for (final URL url : LaunchedURLClassLoader.this.getURLs()) {
                        try {
                            final URLConnection connection = url.openConnection();
                            if (connection instanceof JarURLConnection) {
                                final JarFile jarFile = ((JarURLConnection)connection).getJarFile();
                                if (jarFile.getEntry(classEntryName) != null && jarFile.getEntry(packageEntryName) != null && jarFile.getManifest() != null) {
                                    URLClassLoader.this.definePackage(packageName, jarFile.getManifest(), url);
                                    return null;
                                }
                            }
                        }
                        catch (IOException ex) {}
                    }
                    return null;
                }
            }, AccessController.getContext());
        }
        catch (PrivilegedActionException ex) {}
    }
    
    public void clearCache() {
        for (final URL url : this.getURLs()) {
            try {
                final URLConnection connection = url.openConnection();
                if (connection instanceof JarURLConnection) {
                    this.clearCache(connection);
                }
            }
            catch (IOException ex) {}
        }
    }
    
    private void clearCache(final URLConnection connection) throws IOException {
        final Object jarFile = ((JarURLConnection)connection).getJarFile();
        if (jarFile instanceof org.springframework.boot.loader.jar.JarFile) {
            ((org.springframework.boot.loader.jar.JarFile)jarFile).clearCache();
        }
    }
    
    @UsesJava7
    private static void performParallelCapableRegistration() {
        try {
            ClassLoader.registerAsParallelCapable();
        }
        catch (NoSuchMethodError noSuchMethodError) {}
    }
    
    static {
        performParallelCapableRegistration();
    }
}
