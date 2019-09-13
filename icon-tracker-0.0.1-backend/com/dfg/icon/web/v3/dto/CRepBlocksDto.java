// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class CRepBlocksDto
{
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CRepBlocksDto)) {
            return false;
        }
        final CRepBlocksDto other = (CRepBlocksDto)o;
        return other.canEqual(this);
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof CRepBlocksDto;
    }
    
    @Override
    public int hashCode() {
        final int result = 1;
        return result;
    }
    
    @Override
    public String toString() {
        return "CRepBlocksDto()";
    }
}
