// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RpcResult
{
    @JsonProperty("response_code")
    Integer responseCode;
    @JsonProperty("block")
    BlockVo block;
    @JsonProperty("response")
    String response;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getResponseCode() {
        return this.responseCode;
    }
    
    public BlockVo getBlock() {
        return this.block;
    }
    
    public String getResponse() {
        return this.response;
    }
    
    public void setResponseCode(final Integer responseCode) {
        this.responseCode = responseCode;
    }
    
    public void setBlock(final BlockVo block) {
        this.block = block;
    }
    
    public void setResponse(final String response) {
        this.response = response;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RpcResult)) {
            return false;
        }
        final RpcResult other = (RpcResult)o;
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
        Label_0102: {
            if (this$block == null) {
                if (other$block == null) {
                    break Label_0102;
                }
            }
            else if (this$block.equals(other$block)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$response = this.getResponse();
        final Object other$response = other.getResponse();
        if (this$response == null) {
            if (other$response == null) {
                return true;
            }
        }
        else if (this$response.equals(other$response)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof RpcResult;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $responseCode = this.getResponseCode();
        result = result * 59 + (($responseCode == null) ? 43 : $responseCode.hashCode());
        final Object $block = this.getBlock();
        result = result * 59 + (($block == null) ? 43 : $block.hashCode());
        final Object $response = this.getResponse();
        result = result * 59 + (($response == null) ? 43 : $response.hashCode());
        return result;
    }
}
