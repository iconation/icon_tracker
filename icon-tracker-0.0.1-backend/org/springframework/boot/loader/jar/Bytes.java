// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.jar;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.boot.loader.data.RandomAccessData;

final class Bytes
{
    private static final byte[] EMPTY_BYTES;
    
    private Bytes() {
    }
    
    public static byte[] get(final RandomAccessData data) throws IOException {
        final InputStream inputStream = data.getInputStream(RandomAccessData.ResourceAccess.ONCE);
        try {
            return get(inputStream, data.getSize());
        }
        finally {
            inputStream.close();
        }
    }
    
    public static byte[] get(final InputStream inputStream, final long length) throws IOException {
        if (length == 0L) {
            return Bytes.EMPTY_BYTES;
        }
        final byte[] bytes = new byte[(int)length];
        if (!fill(inputStream, bytes)) {
            throw new IOException("Unable to read bytes");
        }
        return bytes;
    }
    
    public static boolean fill(final InputStream inputStream, final byte[] bytes) throws IOException {
        return fill(inputStream, bytes, 0, bytes.length);
    }
    
    private static boolean fill(final InputStream inputStream, final byte[] bytes, int offset, int length) throws IOException {
        while (length > 0) {
            final int read = inputStream.read(bytes, offset, length);
            if (read == -1) {
                return false;
            }
            offset += read;
            length = -read;
        }
        return true;
    }
    
    public static long littleEndianValue(final byte[] bytes, final int offset, final int length) {
        long value = 0L;
        for (int i = length - 1; i >= 0; --i) {
            value = (value << 8 | (long)(bytes[offset + i] & 0xFF));
        }
        return value;
    }
    
    static {
        EMPTY_BYTES = new byte[0];
    }
}
