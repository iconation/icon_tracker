// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader;

import org.springframework.boot.loader.archive.Archive;

public class JarLauncher extends ExecutableArchiveLauncher
{
    static final String BOOT_INF_CLASSES = "BOOT-INF/classes/";
    static final String BOOT_INF_LIB = "BOOT-INF/lib/";
    
    public JarLauncher() {
    }
    
    protected JarLauncher(final Archive archive) {
        super(archive);
    }
    
    @Override
    protected boolean isNestedArchive(final Archive.Entry entry) {
        if (entry.isDirectory()) {
            return entry.getName().equals("BOOT-INF/classes/");
        }
        return entry.getName().startsWith("BOOT-INF/lib/");
    }
    
    public static void main(final String[] args) throws Exception {
        new JarLauncher().launch(args);
    }
}
