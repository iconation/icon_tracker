// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamsHashVo
{
    @JsonProperty("hash")
    String hash;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamsHashVo)) {
            return false;
        }
        final ParamsHashVo other = (ParamsHashVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        if (this$hash == null) {
            if (other$hash == null) {
                return true;
            }
        }
        else if (this$hash.equals(other$hash)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamsHashVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        return result;
    }
}
