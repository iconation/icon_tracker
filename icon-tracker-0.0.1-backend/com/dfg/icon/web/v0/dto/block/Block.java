// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.block;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class Block
{
    Integer height;
    String lastBlock;
    Date createDate;
    String cRep;
    Integer txCount;
    String hash;
    String prevHash;
    Integer blockSize;
    String amount;
    String fee;
    String message;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public String getLastBlock() {
        return this.lastBlock;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public String getCRep() {
        return this.cRep;
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public String getPrevHash() {
        return this.prevHash;
    }
    
    public Integer getBlockSize() {
        return this.blockSize;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setLastBlock(final String lastBlock) {
        this.lastBlock = lastBlock;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public void setCRep(final String cRep) {
        this.cRep = cRep;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    public void setPrevHash(final String prevHash) {
        this.prevHash = prevHash;
    }
    
    public void setBlockSize(final Integer blockSize) {
        this.blockSize = blockSize;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Block)) {
            return false;
        }
        final Block other = (Block)o;
        if (!other.canEqual((Object)this)) {
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
        final Object this$lastBlock = this.getLastBlock();
        final Object other$lastBlock = other.getLastBlock();
        Label_0102: {
            if (this$lastBlock == null) {
                if (other$lastBlock == null) {
                    break Label_0102;
                }
            }
            else if (this$lastBlock.equals(other$lastBlock)) {
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
        final Object this$cRep = this.getCRep();
        final Object other$cRep = other.getCRep();
        Label_0176: {
            if (this$cRep == null) {
                if (other$cRep == null) {
                    break Label_0176;
                }
            }
            else if (this$cRep.equals(other$cRep)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0213: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0213;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        Label_0250: {
            if (this$hash == null) {
                if (other$hash == null) {
                    break Label_0250;
                }
            }
            else if (this$hash.equals(other$hash)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$prevHash = this.getPrevHash();
        final Object other$prevHash = other.getPrevHash();
        Label_0287: {
            if (this$prevHash == null) {
                if (other$prevHash == null) {
                    break Label_0287;
                }
            }
            else if (this$prevHash.equals(other$prevHash)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$blockSize = this.getBlockSize();
        final Object other$blockSize = other.getBlockSize();
        Label_0324: {
            if (this$blockSize == null) {
                if (other$blockSize == null) {
                    break Label_0324;
                }
            }
            else if (this$blockSize.equals(other$blockSize)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0361: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0361;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0398: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0398;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null) {
            if (other$message == null) {
                return true;
            }
        }
        else if (this$message.equals(other$message)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof Block;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $lastBlock = this.getLastBlock();
        result = result * 59 + (($lastBlock == null) ? 43 : $lastBlock.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $cRep = this.getCRep();
        result = result * 59 + (($cRep == null) ? 43 : $cRep.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        final Object $prevHash = this.getPrevHash();
        result = result * 59 + (($prevHash == null) ? 43 : $prevHash.hashCode());
        final Object $blockSize = this.getBlockSize();
        result = result * 59 + (($blockSize == null) ? 43 : $blockSize.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        final Object $message = this.getMessage();
        result = result * 59 + (($message == null) ? 43 : $message.hashCode());
        return result;
    }
}
