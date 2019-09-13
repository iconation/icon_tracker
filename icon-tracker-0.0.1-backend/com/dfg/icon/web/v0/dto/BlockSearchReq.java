// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BlockSearchReq
{
    String blockHash;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getBlockHash() {
        return this.blockHash;
    }
    
    public void setBlockHash(final String blockHash) {
        this.blockHash = blockHash;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockSearchReq)) {
            return false;
        }
        final BlockSearchReq other = (BlockSearchReq)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$blockHash = this.getBlockHash();
        final Object other$blockHash = other.getBlockHash();
        if (this$blockHash == null) {
            if (other$blockHash == null) {
                return true;
            }
        }
        else if (this$blockHash.equals(other$blockHash)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof BlockSearchReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $blockHash = this.getBlockHash();
        result = result * 59 + (($blockHash == null) ? 43 : $blockHash.hashCode());
        return result;
    }
}
