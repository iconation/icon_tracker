// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader;

import java.lang.reflect.Method;

public class MainMethodRunner
{
    private final String mainClassName;
    private final String[] args;
    
    public MainMethodRunner(final String mainClass, final String[] args) {
        this.mainClassName = mainClass;
        this.args = (String[])((args == null) ? null : ((String[])args.clone()));
    }
    
    public void run() throws Exception {
        final Class<?> mainClass = Thread.currentThread().getContextClassLoader().loadClass(this.mainClassName);
        final Method mainMethod = mainClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, this.args);
    }
}
