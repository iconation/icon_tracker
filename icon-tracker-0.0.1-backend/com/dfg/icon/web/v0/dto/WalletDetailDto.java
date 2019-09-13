// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WalletDetailDto
{
    String address;
    String balance;
    int txCount;
    String nodeType;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public int getTxCount() {
        return this.txCount;
    }
    
    public String getNodeType() {
        return this.nodeType;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    
    public void setTxCount(final int txCount) {
        this.txCount = txCount;
    }
    
    public void setNodeType(final String nodeType) {
        this.nodeType = nodeType;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WalletDetailDto)) {
            return false;
        }
        final WalletDetailDto other = (WalletDetailDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0065: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0065;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$balance = this.getBalance();
        final Object other$balance = other.getBalance();
        Label_0102: {
            if (this$balance == null) {
                if (other$balance == null) {
                    break Label_0102;
                }
            }
            else if (this$balance.equals(other$balance)) {
                break Label_0102;
            }
            return false;
        }
        if (this.getTxCount() != other.getTxCount()) {
            return false;
        }
        final Object this$nodeType = this.getNodeType();
        final Object other$nodeType = other.getNodeType();
        if (this$nodeType == null) {
            if (other$nodeType == null) {
                return true;
            }
        }
        else if (this$nodeType.equals(other$nodeType)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof WalletDetailDto;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        result = result * 59 + this.getTxCount();
        final Object $nodeType = this.getNodeType();
        result = result * 59 + (($nodeType == null) ? 43 : $nodeType.hashCode());
        return result;
    }
}
