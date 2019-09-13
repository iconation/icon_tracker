// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.boot.loader.util;

import java.util.Set;
import java.util.Properties;
import java.util.HashSet;

public abstract class SystemPropertyUtils
{
    public static final String PLACEHOLDER_PREFIX = "${";
    public static final String PLACEHOLDER_SUFFIX = "}";
    public static final String VALUE_SEPARATOR = ":";
    private static final String SIMPLE_PREFIX;
    
    public static String resolvePlaceholders(final String text) {
        if (text == null) {
            return text;
        }
        return parseStringValue(null, text, text, new HashSet<String>());
    }
    
    public static String resolvePlaceholders(final Properties properties, final String text) {
        if (text == null) {
            return text;
        }
        return parseStringValue(properties, text, text, new HashSet<String>());
    }
    
    private static String parseStringValue(final Properties properties, final String value, final String current, final Set<String> visitedPlaceholders) {
        final StringBuilder buf = new StringBuilder(current);
        int startIndex = current.indexOf("${");
        while (startIndex != -1) {
            final int endIndex = findPlaceholderEndIndex(buf, startIndex);
            if (endIndex != -1) {
                final String originalPlaceholder;
                String placeholder = originalPlaceholder = buf.substring(startIndex + "${".length(), endIndex);
                if (!visitedPlaceholders.add(originalPlaceholder)) {
                    throw new IllegalArgumentException("Circular placeholder reference '" + originalPlaceholder + "' in property definitions");
                }
                placeholder = parseStringValue(properties, value, placeholder, visitedPlaceholders);
                String propVal = resolvePlaceholder(properties, value, placeholder);
                if (propVal == null && ":" != null) {
                    final int separatorIndex = placeholder.indexOf(":");
                    if (separatorIndex != -1) {
                        final String actualPlaceholder = placeholder.substring(0, separatorIndex);
                        final String defaultValue = placeholder.substring(separatorIndex + ":".length());
                        propVal = resolvePlaceholder(properties, value, actualPlaceholder);
                        if (propVal == null) {
                            propVal = defaultValue;
                        }
                    }
                }
                if (propVal != null) {
                    propVal = parseStringValue(properties, value, propVal, visitedPlaceholders);
                    buf.replace(startIndex, endIndex + "}".length(), propVal);
                    startIndex = buf.indexOf("${", startIndex + propVal.length());
                }
                else {
                    startIndex = buf.indexOf("${", endIndex + "}".length());
                }
                visitedPlaceholders.remove(originalPlaceholder);
            }
            else {
                startIndex = -1;
            }
        }
        return buf.toString();
    }
    
    private static String resolvePlaceholder(final Properties properties, final String text, final String placeholderName) {
        final String propVal = getProperty(placeholderName, null, text);
        if (propVal != null) {
            return propVal;
        }
        return (properties == null) ? null : properties.getProperty(placeholderName);
    }
    
    public static String getProperty(final String key) {
        return getProperty(key, null, "");
    }
    
    public static String getProperty(final String key, final String defaultValue) {
        return getProperty(key, defaultValue, "");
    }
    
    public static String getProperty(final String key, final String defaultValue, final String text) {
        try {
            String propVal = System.getProperty(key);
            if (propVal == null) {
                propVal = System.getenv(key);
            }
            if (propVal == null) {
                propVal = System.getenv(key.replace('.', '_'));
            }
            if (propVal == null) {
                propVal = System.getenv(key.toUpperCase().replace('.', '_'));
            }
            if (propVal != null) {
                return propVal;
            }
        }
        catch (Throwable ex) {
            System.err.println("Could not resolve key '" + key + "' in '" + text + "' as system property or in environment: " + ex);
        }
        return defaultValue;
    }
    
    private static int findPlaceholderEndIndex(final CharSequence buf, final int startIndex) {
        int index = startIndex + "${".length();
        int withinNestedPlaceholder = 0;
        while (index < buf.length()) {
            if (substringMatch(buf, index, "}")) {
                if (withinNestedPlaceholder <= 0) {
                    return index;
                }
                --withinNestedPlaceholder;
                index += "}".length();
            }
            else if (substringMatch(buf, index, SystemPropertyUtils.SIMPLE_PREFIX)) {
                ++withinNestedPlaceholder;
                index += SystemPropertyUtils.SIMPLE_PREFIX.length();
            }
            else {
                ++index;
            }
        }
        return -1;
    }
    
    private static boolean substringMatch(final CharSequence str, final int index, final CharSequence substring) {
        for (int j = 0; j < substring.length(); ++j) {
            final int i = index + j;
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    static {
        SIMPLE_PREFIX = "${".substring(1);
    }
}
