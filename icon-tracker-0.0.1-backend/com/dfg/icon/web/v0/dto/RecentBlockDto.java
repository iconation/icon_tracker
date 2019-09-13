// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class RecentBlockDto
{
    Integer height;
    Date createDate;
    Integer txCount;
    String hash;
    String amount;
    String fee;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
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
        if (!(o instanceof RecentBlockDto)) {
            return false;
        }
        final RecentBlockDto other = (RecentBlockDto)o;
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
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0102: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0102;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0139: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0139;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        Label_0176: {
            if (this$hash == null) {
                if (other$hash == null) {
                    break Label_0176;
                }
            }
            else if (this$hash.equals(other$hash)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0213: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0213;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0213;
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
        return other instanceof RecentBlockDto;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        return result;
    }
}
