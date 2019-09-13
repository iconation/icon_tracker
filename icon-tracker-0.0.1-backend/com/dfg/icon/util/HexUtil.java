// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import java.text.DecimalFormat;
import java.math.BigInteger;
import com.dfg.icon.core.v3.vo.DecimalType;
import java.math.BigDecimal;

public class HexUtil
{
    public static BigDecimal getHexToDecimal(String hex, Integer decimals) {
        if (hex == null) {
            return null;
        }
        if (decimals == null) {
            decimals = DecimalType.ICX.getValue();
        }
        if (hex.length() > 2 && hex.substring(0, 2).toLowerCase().equals("0x")) {
            hex = hex.substring(2);
        }
        final BigInteger bigInt = new BigInteger(hex, 16);
        final BigInteger zero = new BigInteger("0");
        if (bigInt.compareTo(zero) == 0) {
            return new BigDecimal("0");
        }
        final BigDecimal bd = new BigDecimal(bigInt);
        final BigDecimal factor = BigDecimal.TEN.pow(decimals);
        return bd.divide(factor);
    }
    
    public static String applyDecimal(String value, final Integer decimals) {
        if (value == null) {
            return null;
        }
        if (value.length() > 2 && value.substring(0, 2).toLowerCase().equals("0x")) {
            return String.valueOf(getHexToDecimal(value, decimals));
        }
        final String bigHex = new BigInteger(value, 10).toString(16);
        value = "0x" + bigHex;
        return String.valueOf(getHexToDecimal(value, decimals));
    }
    
    public static String decimalPlusHex(final String decimal, final String hex, final Integer decimals) {
        if (decimal == null) {
            return null;
        }
        final BigDecimal val1 = new BigDecimal(decimal);
        final DecimalFormat df = new DecimalFormat(getDecimalFormat(decimals));
        if (hex != null) {
            return df.format(val1.add(getHexToDecimal(hex, decimals)));
        }
        return df.format(val1);
    }
    
    public static String decimalMinusHex(final String decimal, final String hex, final Integer decimals) {
        if (decimal == null) {
            return null;
        }
        final BigDecimal val1 = new BigDecimal(decimal);
        final DecimalFormat df = new DecimalFormat(getDecimalFormat(decimals));
        if (hex != null) {
            return df.format(val1.subtract(getHexToDecimal(hex, decimals)));
        }
        return df.format(val1);
    }
    
    public static String decimalPlusDecimal(final String decimal, final String decimal2, final Integer decimals) {
        if (decimal == null) {
            return null;
        }
        final BigDecimal val1 = new BigDecimal(decimal);
        final DecimalFormat df = new DecimalFormat(getDecimalFormat(decimals));
        if (decimal2 != null) {
            final BigDecimal val2 = new BigDecimal(decimal2);
            return df.format(val1.add(val2));
        }
        return df.format(val1);
    }
    
    public static String decimalMultiDecimal(final String decimal, final String decimal2, final Integer decimals) {
        if (decimal == null) {
            return null;
        }
        final BigDecimal val1 = new BigDecimal(decimal);
        final DecimalFormat df = new DecimalFormat(getDecimalFormat(decimals));
        if (decimal2 != null) {
            final BigDecimal val2 = new BigDecimal(decimal2);
            return df.format(val1.multiply(val2));
        }
        return df.format(val1);
    }
    
    public static String toDecimalString(String hex, final Integer decimals) {
        BigDecimal bd = new BigDecimal("1");
        if (hex.startsWith("-")) {
            bd = new BigDecimal("-1");
            hex = hex.substring(1);
        }
        final DecimalFormat df = new DecimalFormat(getDecimalFormat(decimals));
        if (hex != null) {
            return df.format(getHexToDecimal(hex, decimals).multiply(bd));
        }
        return "0";
    }
    
    public static String toHexString(final String decimal) {
        final BigInteger bigInt = new BigInteger(decimal);
        final BigInteger zero = new BigInteger("0");
        if (bigInt.compareTo(zero) == 0) {
            return "0x0";
        }
        return "0x" + bigInt.toString(16);
    }
    
    public static String decimalFormat(final String amount, final Integer decimals) {
        final BigDecimal bigAmount = new BigDecimal(amount);
        final DecimalFormat df = new DecimalFormat(getDecimalFormat(decimals));
        return df.format(bigAmount);
    }
    
    public static String getDecimalFormat(Integer decimals) {
        if (decimals == null) {
            decimals = DecimalType.ICX.getValue();
        }
        if (decimals <= 0) {
            return "##0";
        }
        String dFormat = "##0.";
        for (int i = 0; i < decimals; ++i) {
            dFormat += "#";
        }
        return dFormat;
    }
    
    public static int changeHexToInteger(String hexString) {
        if (hexString.startsWith("0x")) {
            hexString = hexString.substring(2);
        }
        return Integer.parseInt(hexString, 16);
    }
    
    public static int changeStringToInteger(String str) {
        if (str.startsWith("0x")) {
            str = str.substring(2);
            return Integer.parseInt(str, 16);
        }
        return Integer.parseInt(str);
    }
}
