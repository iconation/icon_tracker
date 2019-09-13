// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader;

import org.springframework.boot.loader.archive.Archive;

public class WarLauncher extends ExecutableArchiveLauncher
{
    private static final String WEB_INF = "WEB-INF/";
    private static final String WEB_INF_CLASSES = "WEB-INF/classes/";
    private static final String WEB_INF_LIB = "WEB-INF/lib/";
    private static final String WEB_INF_LIB_PROVIDED = "WEB-INF/lib-provided/";
    
    public WarLauncher() {
    }
    
    protected WarLauncher(final Archive archive) {
        super(archive);
    }
    
    public boolean isNestedArchive(final Archive.Entry entry) {
        if (entry.isDirectory()) {
            return entry.getName().equals("WEB-INF/classes/");
        }
        return entry.getName().startsWith("WEB-INF/lib/") || entry.getName().startsWith("WEB-INF/lib-provided/");
    }
    
    public static void main(final String[] args) throws Exception {
        new WarLauncher().launch(args);
    }
}
