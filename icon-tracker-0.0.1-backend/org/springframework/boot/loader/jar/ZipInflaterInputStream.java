// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

class ZipInflaterInputStream extends InflaterInputStream
{
    private boolean extraBytesWritten;
    private int available;
    
    ZipInflaterInputStream(final InputStream inputStream, final int size) {
        super(inputStream, new Inflater(true), getInflaterBufferSize(size));
        this.available = size;
    }
    
    @Override
    public int available() throws IOException {
        if (this.available < 0) {
            return super.available();
        }
        return this.available;
    }
    
    @Override
    public int read(final byte[] b, final int off, final int len) throws IOException {
        final int result = super.read(b, off, len);
        if (result != -1) {
            this.available -= result;
        }
        return result;
    }
    
    @Override
    protected void fill() throws IOException {
        try {
            super.fill();
        }
        catch (EOFException ex) {
            if (this.extraBytesWritten) {
                throw ex;
            }
            this.len = 1;
            this.buf[0] = 0;
            this.extraBytesWritten = true;
            this.inf.setInput(this.buf, 0, this.len);
        }
    }
    
    private static int getInflaterBufferSize(long size) {
        size += 2L;
        size = ((size > 65536L) ? 8192L : size);
        size = ((size <= 0L) ? 4096L : size);
        return (int)size;
    }
}
