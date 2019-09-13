// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;

public class CommonUtil
{
    public static Integer changeUnderZero(Integer i) {
        if (i == null || i < 1) {
            i = 1;
        }
        return i;
    }
    
    public static String appendZeroTime(String date) {
        if (date != null && !"".equals(date)) {
            date += " 00:00:00";
        }
        return date;
    }
    
    public static String appendMaxTime(String date) {
        if (date != null && !"".equals(date)) {
            date += " 23:59:59";
        }
        return date;
    }
    
    public static void printException(final Logger logger, final String message, final Exception e) {
        final StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.error(message, (Object)sw);
    }
    
    public static String checkAddress(final String addr) {
        final Pattern p = Pattern.compile("^[A-Fa-f0-9]{40}$");
        final Matcher m = p.matcher(addr);
        if (m.find()) {
            return "hx" + addr;
        }
        return addr;
    }
    
    public static String invisibleAddress(String addr) {
        if ("cx0000000000000000000000000000000000000000".equals(addr)) {
            addr = "-";
        }
        return addr;
    }
}
