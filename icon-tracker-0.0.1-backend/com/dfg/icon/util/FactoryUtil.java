// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import java.io.FileOutputStream;
import com.dfg.icon.core.exception.IconCode;
import com.google.gson.JsonObject;
import java.math.BigInteger;
import java.util.Date;

public class FactoryUtil
{
    public static Date changeTimeStampFormat(final String timestamp) {
        if (timestamp != null && timestamp.length() > 3) {
            return new Date(Long.parseLong(timestamp.substring(0, timestamp.length() - 3)));
        }
        return null;
    }
    
    public static Date changeHexTimeStampFormat(String hexString) {
        if (hexString.startsWith("0x")) {
            hexString = hexString.substring(2);
        }
        final BigInteger bi = new BigInteger(hexString, 16);
        final String timestamp = bi.toString();
        return new Date(Long.parseLong(timestamp.substring(0, timestamp.length() - 3)));
    }
    
    public static Date changeStringTimeStampFormat(String timeString) {
        if (timeString.startsWith("0x")) {
            timeString = timeString.substring(2);
            final BigInteger bi = new BigInteger(timeString, 16);
            final String timestamp = bi.toString();
            return new Date(Long.parseLong(timestamp.substring(0, timestamp.length() - 3)));
        }
        if (timeString != null && timeString.length() > 3) {
            return new Date(Long.parseLong(timeString.substring(0, timeString.length() - 3)));
        }
        return null;
    }
    
    public static Date changeHexStringTimeStampFormat(String timestamp) {
        timestamp = String.valueOf(HexUtil.changeHexToInteger(timestamp));
        if (timestamp != null && timestamp.length() > 3) {
            return new Date(Long.parseLong(timestamp.substring(0, timestamp.length() - 3)));
        }
        return null;
    }
    
    public static String getTxVersion(final JsonObject txObject) {
        if (txObject.get("version") == null) {
            return IconCode.TXNVERSION_2.getCode();
        }
        return txObject.get("version").getAsString();
    }
    
    public static void createZipFileFromByteArrayString(final String filepath, final String contextAddr, String hexString) throws Exception {
        if (hexString != null && hexString.length() > 1 && hexString.startsWith("0x")) {
            hexString = hexString.substring(2, hexString.length());
        }
        byte[] bData = null;
        try {
            bData = new BigInteger(hexString, 16).toByteArray();
        }
        catch (Exception e) {
            e.printStackTrace();
            bData = new BigInteger("0", 16).toByteArray();
        }
        final FileOutputStream stream = new FileOutputStream(filepath + contextAddr);
        try {
            stream.write(bData);
        }
        finally {
            stream.close();
        }
    }
}
