// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.Date;

public class TokenTxView
{
    String txHash;
    Integer txIndex;
    String contractAddr;
    String address;
    Integer blockHeight;
    Date age;
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public Integer getTxIndex() {
        return this.txIndex;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public Integer getBlockHeight() {
        return this.blockHeight;
    }
    
    public Date getAge() {
        return this.age;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setTxIndex(final Integer txIndex) {
        this.txIndex = txIndex;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setBlockHeight(final Integer blockHeight) {
        this.blockHeight = blockHeight;
    }
    
    public void setAge(final Date age) {
        this.age = age;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenTxView)) {
            return false;
        }
        final TokenTxView other = (TokenTxView)o;
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
        final Object this$txIndex = this.getTxIndex();
        final Object other$txIndex = other.getTxIndex();
        Label_0102: {
            if (this$txIndex == null) {
                if (other$txIndex == null) {
                    break Label_0102;
                }
            }
            else if (this$txIndex.equals(other$txIndex)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$contractAddr = this.getContractAddr();
        final Object other$contractAddr = other.getContractAddr();
        Label_0139: {
            if (this$contractAddr == null) {
                if (other$contractAddr == null) {
                    break Label_0139;
                }
            }
            else if (this$contractAddr.equals(other$contractAddr)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0176: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0176;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$blockHeight = this.getBlockHeight();
        final Object other$blockHeight = other.getBlockHeight();
        Label_0213: {
            if (this$blockHeight == null) {
                if (other$blockHeight == null) {
                    break Label_0213;
                }
            }
            else if (this$blockHeight.equals(other$blockHeight)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null) {
            if (other$age == null) {
                return true;
            }
        }
        else if (this$age.equals(other$age)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenTxView;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $txIndex = this.getTxIndex();
        result = result * 59 + (($txIndex == null) ? 43 : $txIndex.hashCode());
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $blockHeight = this.getBlockHeight();
        result = result * 59 + (($blockHeight == null) ? 43 : $blockHeight.hashCode());
        final Object $age = this.getAge();
        result = result * 59 + (($age == null) ? 43 : $age.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenTxView(txHash=" + this.getTxHash() + ", txIndex=" + this.getTxIndex() + ", contractAddr=" + this.getContractAddr() + ", address=" + this.getAddress() + ", blockHeight=" + this.getBlockHeight() + ", age=" + this.getAge() + ")";
    }
}
