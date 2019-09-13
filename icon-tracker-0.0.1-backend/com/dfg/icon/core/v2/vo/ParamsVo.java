// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamsVo
{
    @JsonProperty("height")
    Integer height;
    @JsonProperty("hash")
    String hash;
    @JsonProperty("txHash")
    String txHash;
    @JsonProperty("address")
    String address;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamsVo)) {
            return false;
        }
        final ParamsVo other = (ParamsVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0065: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0065;
                }
            }
            else if (this$height.equals(other$height)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        Label_0102: {
            if (this$hash == null) {
                if (other$hash == null) {
                    break Label_0102;
                }
            }
            else if (this$hash.equals(other$hash)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$txHash = this.getTxHash();
        final Object other$txHash = other.getTxHash();
        Label_0139: {
            if (this$txHash == null) {
                if (other$txHash == null) {
                    break Label_0139;
                }
            }
            else if (this$txHash.equals(other$txHash)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null) {
            if (other$address == null) {
                return true;
            }
        }
        else if (this$address.equals(other$address)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamsVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        return result;
    }
}
