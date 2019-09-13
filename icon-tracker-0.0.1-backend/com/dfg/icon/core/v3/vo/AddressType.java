// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public enum AddressType
{
    Genesis(1, "\uc81c\ub124\uc2dc\uc2a4 \uc8fc\uc18c"), 
    Treasury(2, "\uc218\uc218\ub8cc \uc218\uc2e0 \uc8fc\uc18c"), 
    C_rep(3, "C-rep \ub178\ub4dc \uc8fc\uc18c"), 
    Normal(0, "\uc77c\ubc18 \uc8fc\uc18c");
    
    private int nodeType;
    private String description;
    
    private AddressType(final int nodeType, final String description) {
        this.nodeType = nodeType;
        this.description = description;
    }
    
    public static AddressType getType(final int nodeType) {
        for (final AddressType type : values()) {
            if (type.getNodeType() == nodeType) {
                return type;
            }
        }
        return AddressType.Normal;
    }
    
    public int getNodeType() {
        return this.nodeType;
    }
    
    public String getDescription() {
        return this.description;
    }
}
