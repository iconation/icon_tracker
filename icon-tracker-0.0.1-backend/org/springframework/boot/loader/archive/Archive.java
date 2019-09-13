// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.archive;

import java.util.List;
import java.io.IOException;
import java.util.jar.Manifest;
import java.net.MalformedURLException;
import java.net.URL;

public interface Archive extends Iterable<Entry>
{
    URL getUrl() throws MalformedURLException;
    
    Manifest getManifest() throws IOException;
    
    List<Archive> getNestedArchives(final EntryFilter p0) throws IOException;
    
    public interface EntryFilter
    {
        boolean matches(final Entry p0);
    }
    
    public interface Entry
    {
        boolean isDirectory();
        
        String getName();
    }
}
