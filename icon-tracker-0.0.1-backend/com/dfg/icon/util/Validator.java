// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import java.util.regex.Pattern;

public class Validator
{
    private static final String datePattern = "^([0-9]{4})\\-([0-9]{2})\\-([0-9]{2})$";
    private static final String downTypePattern = "^[0-1]{1}$";
    private static final int downMaxSize = 50000;
    
    public static boolean isValidDatePattern(final String date) {
        return date != null && Pattern.matches("^([0-9]{4})\\-([0-9]{2})\\-([0-9]{2})$", date);
    }
    
    public static boolean isValidDownType(final String type) {
        return type != null && Pattern.matches("^[0-1]{1}$", type);
    }
    
    public static boolean isValidMaxDownload(final Integer count) {
        return count <= 50000;
    }
}
