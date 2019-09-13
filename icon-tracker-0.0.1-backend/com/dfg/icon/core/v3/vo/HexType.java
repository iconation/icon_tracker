// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public enum HexType
{
    public static final HexType T_ADDR_EOA;
    public static final HexType T_ADDR_SCORE;
    public static final HexType T_HASH;
    public static final HexType UNPREFIX;
    private String prefix;
    private String description;
    
    public static HexType valueOf(final String name) {
        return Enum.valueOf(HexType.class, name);
    }
    
    private HexType(final String prefix, final String description) {
        this.prefix = prefix;
        this.description = description;
    }
    
    public static HexType getType(final String hex) {
        if (hex == null || hex.length() < 2) {
            return null;
        }
        final String prefix = hex.substring(0, 2);
        for (final HexType type : values()) {
            if (type.getPrefix().equals(prefix)) {
                return type;
            }
        }
        return HexType.UNPREFIX;
    }
    
    public static String toHexType(final String hex, final HexType type) {
        if (hex == null) {
            return null;
        }
        if (hex.length() < 2) {
            return type.getPrefix() + hex;
        }
        final String prefix = hex.substring(0, 2);
        for (final HexType hexType : values()) {
            if (hexType.getPrefix().equals(prefix)) {
                return type.getPrefix() + hex.substring(2);
            }
        }
        return type.getPrefix() + hex;
    }
    
    public static String toDBformatString(final String hex) {
        if (hex == null) {
            return null;
        }
        if (hex.length() < 2) {
            return hex;
        }
        final String prefix = hex.substring(0, 2);
        for (final HexType hexType : values()) {
            if (hexType.getPrefix().equals(prefix)) {
                return hex;
            }
        }
        return "0x" + hex;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    static {
        HexType.T_ADDR_EOA = new HexType("T_ADDR_EOA", 0, "hx", "hx + 40 digit HEX \ubb38\uc790\uc5f4");
        HexType.T_ADDR_SCORE = new HexType("T_ADDR_SCORE", 1, "cx", "cx + 40 digit HEX \ubb38\uc790\uc5f4");
        HexType.T_HASH = new HexType("T_HASH", 2, "0x", "0x + 64 digit HEX \ubb38\uc790\uc5f4");
        HexType.UNPREFIX = new HexType("UNPREFIX", 3, "", "Nothing prefix");
        HexType.$VALUES = new HexType[] { HexType.T_ADDR_EOA, HexType.T_ADDR_SCORE, HexType.T_HASH, HexType.UNPREFIX };
    }
}
