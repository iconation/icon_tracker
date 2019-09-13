// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto.main;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MainInfo
{
    Double marketCap;
    String icxSupply;
    String icxCirculationy;
    Integer transactionCount;
    Integer crepCount;
    String publicTreasury;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Double getMarketCap() {
        return this.marketCap;
    }
    
    public String getIcxSupply() {
        return this.icxSupply;
    }
    
    public String getIcxCirculationy() {
        return this.icxCirculationy;
    }
    
    public Integer getTransactionCount() {
        return this.transactionCount;
    }
    
    public Integer getCrepCount() {
        return this.crepCount;
    }
    
    public String getPublicTreasury() {
        return this.publicTreasury;
    }
    
    public void setMarketCap(final Double marketCap) {
        this.marketCap = marketCap;
    }
    
    public void setIcxSupply(final String icxSupply) {
        this.icxSupply = icxSupply;
    }
    
    public void setIcxCirculationy(final String icxCirculationy) {
        this.icxCirculationy = icxCirculationy;
    }
    
    public void setTransactionCount(final Integer transactionCount) {
        this.transactionCount = transactionCount;
    }
    
    public void setCrepCount(final Integer crepCount) {
        this.crepCount = crepCount;
    }
    
    public void setPublicTreasury(final String publicTreasury) {
        this.publicTreasury = publicTreasury;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MainInfo)) {
            return false;
        }
        final MainInfo other = (MainInfo)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$marketCap = this.getMarketCap();
        final Object other$marketCap = other.getMarketCap();
        Label_0065: {
            if (this$marketCap == null) {
                if (other$marketCap == null) {
                    break Label_0065;
                }
            }
            else if (this$marketCap.equals(other$marketCap)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$icxSupply = this.getIcxSupply();
        final Object other$icxSupply = other.getIcxSupply();
        Label_0102: {
            if (this$icxSupply == null) {
                if (other$icxSupply == null) {
                    break Label_0102;
                }
            }
            else if (this$icxSupply.equals(other$icxSupply)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$icxCirculationy = this.getIcxCirculationy();
        final Object other$icxCirculationy = other.getIcxCirculationy();
        Label_0139: {
            if (this$icxCirculationy == null) {
                if (other$icxCirculationy == null) {
                    break Label_0139;
                }
            }
            else if (this$icxCirculationy.equals(other$icxCirculationy)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$transactionCount = this.getTransactionCount();
        final Object other$transactionCount = other.getTransactionCount();
        Label_0176: {
            if (this$transactionCount == null) {
                if (other$transactionCount == null) {
                    break Label_0176;
                }
            }
            else if (this$transactionCount.equals(other$transactionCount)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$crepCount = this.getCrepCount();
        final Object other$crepCount = other.getCrepCount();
        Label_0213: {
            if (this$crepCount == null) {
                if (other$crepCount == null) {
                    break Label_0213;
                }
            }
            else if (this$crepCount.equals(other$crepCount)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$publicTreasury = this.getPublicTreasury();
        final Object other$publicTreasury = other.getPublicTreasury();
        if (this$publicTreasury == null) {
            if (other$publicTreasury == null) {
                return true;
            }
        }
        else if (this$publicTreasury.equals(other$publicTreasury)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof MainInfo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $marketCap = this.getMarketCap();
        result = result * 59 + (($marketCap == null) ? 43 : $marketCap.hashCode());
        final Object $icxSupply = this.getIcxSupply();
        result = result * 59 + (($icxSupply == null) ? 43 : $icxSupply.hashCode());
        final Object $icxCirculationy = this.getIcxCirculationy();
        result = result * 59 + (($icxCirculationy == null) ? 43 : $icxCirculationy.hashCode());
        final Object $transactionCount = this.getTransactionCount();
        result = result * 59 + (($transactionCount == null) ? 43 : $transactionCount.hashCode());
        final Object $crepCount = this.getCrepCount();
        result = result * 59 + (($crepCount == null) ? 43 : $crepCount.hashCode());
        final Object $publicTreasury = this.getPublicTreasury();
        result = result * 59 + (($publicTreasury == null) ? 43 : $publicTreasury.hashCode());
        return result;
    }
}
