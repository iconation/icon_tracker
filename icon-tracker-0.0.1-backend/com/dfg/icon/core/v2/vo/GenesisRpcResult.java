// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenesisRpcResult
{
    @JsonProperty("response_code")
    Integer responseCode;
    @JsonProperty("block")
    GenesisBlockVo block;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getResponseCode() {
        return this.responseCode;
    }
    
    public GenesisBlockVo getBlock() {
        return this.block;
    }
    
    public void setResponseCode(final Integer responseCode) {
        this.responseCode = responseCode;
    }
    
    public void setBlock(final GenesisBlockVo block) {
        this.block = block;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GenesisRpcResult)) {
            return false;
        }
        final GenesisRpcResult other = (GenesisRpcResult)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$responseCode = this.getResponseCode();
        final Object other$responseCode = other.getResponseCode();
        Label_0065: {
            if (this$responseCode == null) {
                if (other$responseCode == null) {
                    break Label_0065;
                }
            }
            else if (this$responseCode.equals(other$responseCode)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$block = this.getBlock();
        final Object other$block = other.getBlock();
        if (this$block == null) {
            if (other$block == null) {
                return true;
            }
        }
        else if (this$block.equals(other$block)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof GenesisRpcResult;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $responseCode = this.getResponseCode();
        result = result * 59 + (($responseCode == null) ? 43 : $responseCode.hashCode());
        final Object $block = this.getBlock();
        result = result * 59 + (($block == null) ? 43 : $block.hashCode());
        return result;
    }
}
