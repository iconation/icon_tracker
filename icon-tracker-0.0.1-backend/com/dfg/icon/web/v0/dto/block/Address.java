// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.block;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Address
{
    String address;
    String balance;
    String icxUsd;
    double percentage;
    Integer txCount;
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
    
    public String getIcxUsd() {
        return this.icxUsd;
    }
    
    public double getPercentage() {
        return this.percentage;
    }
    
    public Integer getTxCount() {
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
    
    public void setIcxUsd(final String icxUsd) {
        this.icxUsd = icxUsd;
    }
    
    public void setPercentage(final double percentage) {
        this.percentage = percentage;
    }
    
    public void setTxCount(final Integer txCount) {
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
        if (!(o instanceof Address)) {
            return false;
        }
        final Address other = (Address)o;
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
        final Object this$icxUsd = this.getIcxUsd();
        final Object other$icxUsd = other.getIcxUsd();
        Label_0139: {
            if (this$icxUsd == null) {
                if (other$icxUsd == null) {
                    break Label_0139;
                }
            }
            else if (this$icxUsd.equals(other$icxUsd)) {
                break Label_0139;
            }
            return false;
        }
        if (Double.compare(this.getPercentage(), other.getPercentage()) != 0) {
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0192: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0192;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0192;
            }
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
        return other instanceof Address;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        final Object $icxUsd = this.getIcxUsd();
        result = result * 59 + (($icxUsd == null) ? 43 : $icxUsd.hashCode());
        final long $percentage = Double.doubleToLongBits(this.getPercentage());
        result = result * 59 + (int)($percentage >>> 32 ^ $percentage);
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $nodeType = this.getNodeType();
        result = result * 59 + (($nodeType == null) ? 43 : $nodeType.hashCode());
        return result;
    }
}
