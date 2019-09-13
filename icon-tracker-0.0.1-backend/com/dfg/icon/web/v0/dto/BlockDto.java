// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class BlockDto
{
    String hash;
    Integer height;
    Date createDate;
    Integer txCount;
    String cRep;
    String prevHash;
    String amount;
    String fee;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getHash() {
        return this.hash;
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
    
    public String getCRep() {
        return this.cRep;
    }
    
    public String getPrevHash() {
        return this.prevHash;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
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
    
    public void setCRep(final String cRep) {
        this.cRep = cRep;
    }
    
    public void setPrevHash(final String prevHash) {
        this.prevHash = prevHash;
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
        if (!(o instanceof BlockDto)) {
            return false;
        }
        final BlockDto other = (BlockDto)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        Label_0065: {
            if (this$hash == null) {
                if (other$hash == null) {
                    break Label_0065;
                }
            }
            else if (this$hash.equals(other$hash)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0102: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0102;
                }
            }
            else if (this$height.equals(other$height)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0139: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0139;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0176: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0176;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$cRep = this.getCRep();
        final Object other$cRep = other.getCRep();
        Label_0213: {
            if (this$cRep == null) {
                if (other$cRep == null) {
                    break Label_0213;
                }
            }
            else if (this$cRep.equals(other$cRep)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$prevHash = this.getPrevHash();
        final Object other$prevHash = other.getPrevHash();
        Label_0250: {
            if (this$prevHash == null) {
                if (other$prevHash == null) {
                    break Label_0250;
                }
            }
            else if (this$prevHash.equals(other$prevHash)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0287: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0287;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0287;
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
        return other instanceof BlockDto;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $cRep = this.getCRep();
        result = result * 59 + (($cRep == null) ? 43 : $cRep.hashCode());
        final Object $prevHash = this.getPrevHash();
        result = result * 59 + (($prevHash == null) ? 43 : $prevHash.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        return result;
    }
}
