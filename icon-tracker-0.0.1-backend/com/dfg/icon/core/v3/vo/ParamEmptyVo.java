// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ParamEmptyVo
{
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamEmptyVo)) {
            return false;
        }
        final ParamEmptyVo other = (ParamEmptyVo)o;
        return other.canEqual(this);
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamEmptyVo;
    }
    
    @Override
    public int hashCode() {
        final int result = 1;
        return result;
    }
}
