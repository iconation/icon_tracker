// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamsHeightVo
{
    @JsonProperty("height")
    String height;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getHeight() {
        return this.height;
    }
    
    public void setHeight(final String height) {
        this.height = height;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamsHeightVo)) {
            return false;
        }
        final ParamsHeightVo other = (ParamsHeightVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        if (this$height == null) {
            if (other$height == null) {
                return true;
            }
        }
        else if (this$height.equals(other$height)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamsHeightVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        return result;
    }
}
