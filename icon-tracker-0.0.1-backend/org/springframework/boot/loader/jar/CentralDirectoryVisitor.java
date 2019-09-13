// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import org.springframework.boot.loader.data.RandomAccessData;

interface CentralDirectoryVisitor
{
    void visitStart(final CentralDirectoryEndRecord p0, final RandomAccessData p1);
    
    void visitFileHeader(final CentralDirectoryFileHeader p0, final int p1);
    
    void visitEnd();
}
