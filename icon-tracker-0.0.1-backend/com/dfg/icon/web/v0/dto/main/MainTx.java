// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.main;

import com.dfg.icon.core.dao.icon.TMainTx;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class MainTx
{
    String txHash;
    String amount;
    String fee;
    String scoreYn;
    Date createDate;
    Integer state;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public void setMainTx(final TMainTx tMainTx) {
        this.txHash = tMainTx.getTxHash();
        this.amount = tMainTx.getAmount();
        this.fee = tMainTx.getFee();
        this.scoreYn = tMainTx.getScoreYn();
        this.state = tMainTx.getState();
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public String getScoreYn() {
        return this.scoreYn;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setScoreYn(final String scoreYn) {
        this.scoreYn = scoreYn;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MainTx)) {
            return false;
        }
        final MainTx other = (MainTx)o;
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
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0102: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0102;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0139: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0139;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$scoreYn = this.getScoreYn();
        final Object other$scoreYn = other.getScoreYn();
        Label_0176: {
            if (this$scoreYn == null) {
                if (other$scoreYn == null) {
                    break Label_0176;
                }
            }
            else if (this$scoreYn.equals(other$scoreYn)) {
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
        return other instanceof MainTx;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        final Object $scoreYn = this.getScoreYn();
        result = result * 59 + (($scoreYn == null) ? 43 : $scoreYn.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        return result;
    }
}
