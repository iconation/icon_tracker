// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.block;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class Transaction
{
    String txHash;
    int height;
    Date createDate;
    String fromAddr;
    String toAddr;
    String amount;
    String fee;
    
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
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
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
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Transaction)) {
            return false;
        }
        final Transaction other = (Transaction)o;
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
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0226: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0226;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0226;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        if (this$fee == null) {
            if (other$fee == null) {
                return true;
            }
        }
        else if (this$fee.equals(other$fee)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof Transaction;
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
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        return result;
    }
}
