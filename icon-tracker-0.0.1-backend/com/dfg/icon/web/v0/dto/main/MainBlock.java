// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.main;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class MainBlock
{
    Integer blockHeight;
    String hash;
    Integer txCount;
    Date createDate;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getBlockHeight() {
        return this.blockHeight;
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setBlockHeight(final Integer blockHeight) {
        this.blockHeight = blockHeight;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MainBlock)) {
            return false;
        }
        final MainBlock other = (MainBlock)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$blockHeight = this.getBlockHeight();
        final Object other$blockHeight = other.getBlockHeight();
        Label_0065: {
            if (this$blockHeight == null) {
                if (other$blockHeight == null) {
                    break Label_0065;
                }
            }
            else if (this$blockHeight.equals(other$blockHeight)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        Label_0102: {
            if (this$hash == null) {
                if (other$hash == null) {
                    break Label_0102;
                }
            }
            else if (this$hash.equals(other$hash)) {
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
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        if (this$createDate == null) {
            if (other$createDate == null) {
                return true;
            }
        }
        else if (this$createDate.equals(other$createDate)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof MainBlock;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $blockHeight = this.getBlockHeight();
        result = result * 59 + (($blockHeight == null) ? 43 : $blockHeight.hashCode());
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        return result;
    }
}
