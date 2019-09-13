// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockDataJsonVo
{
    @JsonProperty("prev_block_hash")
    String prevBlockHash;
    @JsonProperty("height")
    String height;
    @JsonProperty("block_hash")
    String blockHash;
    
    public String getPrevBlockHash() {
        return this.prevBlockHash;
    }
    
    public String getHeight() {
        return this.height;
    }
    
    public String getBlockHash() {
        return this.blockHash;
    }
    
    public void setPrevBlockHash(final String prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }
    
    public void setHeight(final String height) {
        this.height = height;
    }
    
    public void setBlockHash(final String blockHash) {
        this.blockHash = blockHash;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockDataJsonVo)) {
            return false;
        }
        final BlockDataJsonVo other = (BlockDataJsonVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$prevBlockHash = this.getPrevBlockHash();
        final Object other$prevBlockHash = other.getPrevBlockHash();
        Label_0065: {
            if (this$prevBlockHash == null) {
                if (other$prevBlockHash == null) {
                    break Label_0065;
                }
            }
            else if (this$prevBlockHash.equals(other$prevBlockHash)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0102: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0102;
                }
            }
            else if (this$height.equals(other$height)) {
                break Label_0102;
            }
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
        return other instanceof BlockDataJsonVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $prevBlockHash = this.getPrevBlockHash();
        result = result * 59 + (($prevBlockHash == null) ? 43 : $prevBlockHash.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $blockHash = this.getBlockHash();
        result = result * 59 + (($blockHash == null) ? 43 : $blockHash.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "BlockDataJsonVo(prevBlockHash=" + this.getPrevBlockHash() + ", height=" + this.getHeight() + ", blockHash=" + this.getBlockHash() + ")";
    }
}
