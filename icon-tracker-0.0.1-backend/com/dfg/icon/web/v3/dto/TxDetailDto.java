// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class TxDetailDto
{
    String txHash;
    int height;
    Date createDate;
    String fromAddr;
    String toAddr;
    String txType;
    String dataType;
    String amount;
    String fee;
    int state;
    String targetContractAddr;
    int id;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public String getTxType() {
        return this.txType;
    }
    
    public String getDataType() {
        return this.dataType;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public int getState() {
        return this.state;
    }
    
    public String getTargetContractAddr() {
        return this.targetContractAddr;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = toAddr;
    }
    
    public void setTxType(final String txType) {
        this.txType = txType;
    }
    
    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setState(final int state) {
        this.state = state;
    }
    
    public void setTargetContractAddr(final String targetContractAddr) {
        this.targetContractAddr = targetContractAddr;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxDetailDto)) {
            return false;
        }
        final TxDetailDto other = (TxDetailDto)o;
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
        if (this.getHeight() != other.getHeight()) {
            return false;
        }
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0115: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0115;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0115;
            }
            return false;
        }
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0152: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0152;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0152;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0189: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0189;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0189;
            }
            return false;
        }
        final Object this$txType = this.getTxType();
        final Object other$txType = other.getTxType();
        Label_0226: {
            if (this$txType == null) {
                if (other$txType == null) {
                    break Label_0226;
                }
            }
            else if (this$txType.equals(other$txType)) {
                break Label_0226;
            }
            return false;
        }
        final Object this$dataType = this.getDataType();
        final Object other$dataType = other.getDataType();
        Label_0263: {
            if (this$dataType == null) {
                if (other$dataType == null) {
                    break Label_0263;
                }
            }
            else if (this$dataType.equals(other$dataType)) {
                break Label_0263;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0300: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0300;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0300;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0337: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0337;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0337;
            }
            return false;
        }
        if (this.getState() != other.getState()) {
            return false;
        }
        final Object this$targetContractAddr = this.getTargetContractAddr();
        final Object other$targetContractAddr = other.getTargetContractAddr();
        if (this$targetContractAddr == null) {
            if (other$targetContractAddr == null) {
                return this.getId() == other.getId();
            }
        }
        else if (this$targetContractAddr.equals(other$targetContractAddr)) {
            return this.getId() == other.getId();
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TxDetailDto;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        result = result * 59 + this.getHeight();
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $txType = this.getTxType();
        result = result * 59 + (($txType == null) ? 43 : $txType.hashCode());
        final Object $dataType = this.getDataType();
        result = result * 59 + (($dataType == null) ? 43 : $dataType.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        result = result * 59 + this.getState();
        final Object $targetContractAddr = this.getTargetContractAddr();
        result = result * 59 + (($targetContractAddr == null) ? 43 : $targetContractAddr.hashCode());
        result = result * 59 + this.getId();
        return result;
    }
}
