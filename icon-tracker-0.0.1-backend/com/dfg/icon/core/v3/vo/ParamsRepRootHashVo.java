// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamsRepRootHashVo
{
    @JsonProperty("repRootHash")
    String repRootHash;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getRepRootHash() {
        return this.repRootHash;
    }
    
    public void setRepRootHash(final String repRootHash) {
        this.repRootHash = repRootHash;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamsRepRootHashVo)) {
            return false;
        }
        final ParamsRepRootHashVo other = (ParamsRepRootHashVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$repRootHash = this.getRepRootHash();
        final Object other$repRootHash = other.getRepRootHash();
        if (this$repRootHash == null) {
            if (other$repRootHash == null) {
                return true;
            }
        }
        else if (this$repRootHash.equals(other$repRootHash)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamsRepRootHashVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $repRootHash = this.getRepRootHash();
        result = result * 59 + (($repRootHash == null) ? 43 : $repRootHash.hashCode());
        return result;
    }
}
