// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public enum DecimalType
{
    public static final DecimalType LOOP;
    public static final DecimalType KWEI;
    public static final DecimalType MWEI;
    public static final DecimalType GWEI;
    public static final DecimalType SZABO;
    public static final DecimalType FINNEY;
    public static final DecimalType ETHER;
    public static final DecimalType ICX;
    public static final DecimalType KETHER;
    public static final DecimalType METHER;
    public static final DecimalType GETHER;
    private String type;
    private Integer value;
    
    public static DecimalType valueOf(final String name) {
        return Enum.valueOf(DecimalType.class, name);
    }
    
    private DecimalType(final String type, final Integer value) {
        this.type = type;
        this.value = value;
    }
    
    public static DecimalType getType(final String type) {
        if (type == null) {
            return null;
        }
        for (final DecimalType d : values()) {
            if (d.getType().equals(type)) {
                return d;
            }
        }
        return null;
    }
    
    public String getType() {
        return this.type;
    }
    
    public Integer getValue() {
        return this.value;
    }
    
    static {
        DecimalType.LOOP = new DecimalType("LOOP", 0, "loop", Integer.valueOf(0));
        DecimalType.KWEI = new DecimalType("KWEI", 1, "kwei", Integer.valueOf(3));
        DecimalType.MWEI = new DecimalType("MWEI", 2, "mwei", Integer.valueOf(6));
        DecimalType.GWEI = new DecimalType("GWEI", 3, "gwei", Integer.valueOf(9));
        DecimalType.SZABO = new DecimalType("SZABO", 4, "szabo", Integer.valueOf(12));
        DecimalType.FINNEY = new DecimalType("FINNEY", 5, "finney", Integer.valueOf(15));
        DecimalType.ETHER = new DecimalType("ETHER", 6, "ether", Integer.valueOf(18));
        DecimalType.ICX = new DecimalType("ICX", 7, "icon", Integer.valueOf(18));
        DecimalType.KETHER = new DecimalType("KETHER", 8, "kether", Integer.valueOf(21));
        DecimalType.METHER = new DecimalType("METHER", 9, "mether", Integer.valueOf(24));
        DecimalType.GETHER = new DecimalType("GETHER", 10, "gether", Integer.valueOf(27));
        DecimalType.$VALUES = new DecimalType[] { DecimalType.LOOP, DecimalType.KWEI, DecimalType.MWEI, DecimalType.GWEI, DecimalType.SZABO, DecimalType.FINNEY, DecimalType.ETHER, DecimalType.ICX, DecimalType.KETHER, DecimalType.METHER, DecimalType.GETHER };
    }
}
