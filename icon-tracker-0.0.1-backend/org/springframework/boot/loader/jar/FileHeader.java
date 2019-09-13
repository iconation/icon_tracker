// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

interface FileHeader
{
    boolean hasName(final String p0, final String p1);
    
    long getLocalHeaderOffset();
    
    long getCompressedSize();
    
    long getSize();
    
    int getMethod();
}
