// 
// Decompiled by Procyon v0.5.36
// 

package com.theromus.sha;

public class HexUtils
{
    private static final char[] DIGITS;
    
    public static String getHex(final byte[] data) {
        final int l = data.length;
        final char[] outData = new char[l << 1];
        int i = 0;
        int j = 0;
        while (i < l) {
            outData[j++] = HexUtils.DIGITS[(0xF0 & data[i]) >>> 4];
            outData[j++] = HexUtils.DIGITS[0xF & data[i]];
            ++i;
        }
        return new String(outData);
    }
    
    public static String getReverseHex(final byte[] data) {
        return getHex(reverse(data));
    }
    
    private static byte[] reverse(final byte[] data) {
        for (int i = 0, j = data.length - 1; j > i; --j, ++i) {
            final byte tmp = data[j];
            data[j] = data[i];
            data[i] = tmp;
        }
        return data;
    }
    
    static {
        DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
}
