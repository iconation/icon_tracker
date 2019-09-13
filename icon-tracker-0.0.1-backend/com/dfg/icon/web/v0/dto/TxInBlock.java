// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TxInBlock
{
    String txHash;
    String fromAddr;
    String toAddr;
    String amount;
    String fee;
    Integer state;
    String dataType;
    String txType;
    String targetContractAddr;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public String getDataType() {
        return this.dataType;
    }
    
    public String getTxType() {
        return this.txType;
    }
    
    public String getTargetContractAddr() {
        return this.targetContractAddr;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = toAddr;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }
    
    public void setTxType(final String txType) {
        this.txType = txType;
    }
    
    public void setTargetContractAddr(final String targetContractAddr) {
        this.targetContractAddr = targetContractAddr;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxInBlock)) {
            return false;
        }
        final TxInBlock other = (TxInBlock)o;
        if (!other.canEqual((Object)this)) {
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
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0102: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0102;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0139: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0139;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0176: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0176;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0213: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0213;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        Label_0250: {
            if (this$state == null) {
                if (other$state == null) {
                    break Label_0250;
                }
            }
            else if (this$state.equals(other$state)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$dataType = this.getDataType();
        final Object other$dataType = other.getDataType();
        Label_0287: {
            if (this$dataType == null) {
                if (other$dataType == null) {
                    break Label_0287;
                }
            }
            else if (this$dataType.equals(other$dataType)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$txType = this.getTxType();
        final Object other$txType = other.getTxType();
        Label_0324: {
            if (this$txType == null) {
                if (other$txType == null) {
                    break Label_0324;
                }
            }
            else if (this$txType.equals(other$txType)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$targetContractAddr = this.getTargetContractAddr();
        final Object other$targetContractAddr = other.getTargetContractAddr();
        if (this$targetContractAddr == null) {
            if (other$targetContractAddr == null) {
                return true;
            }
        }
        else if (this$targetContractAddr.equals(other$targetContractAddr)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TxInBlock;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        final Object $dataType = this.getDataType();
        result = result * 59 + (($dataType == null) ? 43 : $dataType.hashCode());
        final Object $txType = this.getTxType();
        result = result * 59 + (($txType == null) ? 43 : $txType.hashCode());
        final Object $targetContractAddr = this.getTargetContractAddr();
        result = result * 59 + (($targetContractAddr == null) ? 43 : $targetContractAddr.hashCode());
        return result;
    }
}
