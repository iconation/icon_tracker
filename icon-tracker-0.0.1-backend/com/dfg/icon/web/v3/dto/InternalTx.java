// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dfg.icon.core.dao.icon.TInternalTx;
import java.util.Date;

public class InternalTx
{
    String txHash;
    Integer txIndex;
    Integer height;
    String contractAddr;
    Date createDate;
    String fromAddr;
    String toAddr;
    String amount;
    Integer state;
    
    public InternalTx() {
    }
    
    public InternalTx(final TInternalTx tx) {
        this.txHash = tx.getParentTxHash();
        this.txIndex = tx.getTxIndex();
        this.height = tx.getHeight();
        this.contractAddr = tx.getContractAddr();
        this.createDate = tx.getCreateDate();
        this.fromAddr = tx.getFromAddr();
        this.toAddr = tx.getToAddr();
        this.amount = tx.getAmount();
        this.state = tx.getState();
    }
    
    public void setInternalTx(final TInternalTx tx) {
        this.txHash = tx.getParentTxHash();
        this.txIndex = tx.getTxIndex();
        this.height = tx.getHeight();
        this.contractAddr = tx.getContractAddr();
        this.createDate = tx.getCreateDate();
        this.fromAddr = tx.getFromAddr();
        this.toAddr = tx.getToAddr();
        this.amount = tx.getAmount();
        this.state = tx.getState();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public Integer getTxIndex() {
        return this.txIndex;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
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
    
    public String getAmount() {
        return this.amount;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setTxIndex(final Integer txIndex) {
        this.txIndex = txIndex;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
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
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InternalTx)) {
            return false;
        }
        final InternalTx other = (InternalTx)o;
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
        final Object this$contractAddr = this.getContractAddr();
        final Object other$contractAddr = other.getContractAddr();
        Label_0176: {
            if (this$contractAddr == null) {
                if (other$contractAddr == null) {
                    break Label_0176;
                }
            }
            else if (this$contractAddr.equals(other$contractAddr)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0213: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0213;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0250: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0250;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0287: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0287;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0324: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0324;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        if (this$state == null) {
            if (other$state == null) {
                return true;
            }
        }
        else if (this$state.equals(other$state)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof InternalTx;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $txIndex = this.getTxIndex();
        result = result * 59 + (($txIndex == null) ? 43 : $txIndex.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        return result;
    }
}
