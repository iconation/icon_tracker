// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WalletDetailReq
{
    String address;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WalletDetailReq)) {
            return false;
        }
        final WalletDetailReq other = (WalletDetailReq)o;
        if (!other.canEqual(this)) {
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
        return other instanceof WalletDetailReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        return result;
    }
}
