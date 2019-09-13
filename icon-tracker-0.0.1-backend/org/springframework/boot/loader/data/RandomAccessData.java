// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.data;

import java.io.IOException;
import java.io.InputStream;

public interface RandomAccessData
{
    InputStream getInputStream(final ResourceAccess p0) throws IOException;
    
    RandomAccessData getSubsection(final long p0, final long p1);
    
    long getSize();
    
    public enum ResourceAccess
    {
        ONCE, 
        PER_READ;
    }
}
