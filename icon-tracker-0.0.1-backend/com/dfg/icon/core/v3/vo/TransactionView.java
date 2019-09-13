// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.Date;

public class TransactionView
{
    String txHash;
    String address;
    Integer height;
    Date createDate;
    Integer state;
    Integer txType;
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public Integer getTxType() {
        return this.txType;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public void setTxType(final Integer txType) {
        this.txType = txType;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TransactionView)) {
            return false;
        }
        final TransactionView other = (TransactionView)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$txHash = this.getTxHash();
        final Object other$txHash = other.getTxHash();
        Label_0065: {
            if (this$txHash == null) {
                if (other$txHash == null) {
                    break Label_0065;
                }
            }
            else if (this$txHash.equals(other$txHash)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0102: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0102;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0139: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0139;
                }
            }
            else if (this$height.equals(other$height)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0176: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0176;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        Label_0213: {
            if (this$state == null) {
                if (other$state == null) {
                    break Label_0213;
                }
            }
            else if (this$state.equals(other$state)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$txType = this.getTxType();
        final Object other$txType = other.getTxType();
        if (this$txType == null) {
            if (other$txType == null) {
                return true;
            }
        }
        else if (this$txType.equals(other$txType)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TransactionView;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        final Object $txType = this.getTxType();
        result = result * 59 + (($txType == null) ? 43 : $txType.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TransactionView(txHash=" + this.getTxHash() + ", address=" + this.getAddress() + ", height=" + this.getHeight() + ", createDate=" + this.getCreateDate() + ", state=" + this.getState() + ", txType=" + this.getTxType() + ")";
    }
}
