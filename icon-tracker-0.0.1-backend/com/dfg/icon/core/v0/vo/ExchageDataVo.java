// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchageDataVo
{
    @JsonProperty("tradeName")
    String tradeName;
    @JsonProperty("marketName")
    String marketName;
    @JsonProperty("createDate")
    long createDate;
    @JsonProperty("price")
    String price;
    
    public String getTradeName() {
        return this.tradeName;
    }
    
    public String getMarketName() {
        return this.marketName;
    }
    
    public long getCreateDate() {
        return this.createDate;
    }
    
    public String getPrice() {
        return this.price;
    }
    
    public void setTradeName(final String tradeName) {
        this.tradeName = tradeName;
    }
    
    public void setMarketName(final String marketName) {
        this.marketName = marketName;
    }
    
    public void setCreateDate(final long createDate) {
        this.createDate = createDate;
    }
    
    public void setPrice(final String price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ExchageDataVo)) {
            return false;
        }
        final ExchageDataVo other = (ExchageDataVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$tradeName = this.getTradeName();
        final Object other$tradeName = other.getTradeName();
        Label_0065: {
            if (this$tradeName == null) {
                if (other$tradeName == null) {
                    break Label_0065;
                }
            }
            else if (this$tradeName.equals(other$tradeName)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$marketName = this.getMarketName();
        final Object other$marketName = other.getMarketName();
        Label_0102: {
            if (this$marketName == null) {
                if (other$marketName == null) {
                    break Label_0102;
                }
            }
            else if (this$marketName.equals(other$marketName)) {
                break Label_0102;
            }
            return false;
        }
        if (this.getCreateDate() != other.getCreateDate()) {
            return false;
        }
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null) {
            if (other$price == null) {
                return true;
            }
        }
        else if (this$price.equals(other$price)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ExchageDataVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tradeName = this.getTradeName();
        result = result * 59 + (($tradeName == null) ? 43 : $tradeName.hashCode());
        final Object $marketName = this.getMarketName();
        result = result * 59 + (($marketName == null) ? 43 : $marketName.hashCode());
        final long $createDate = this.getCreateDate();
        result = result * 59 + (int)($createDate >>> 32 ^ $createDate);
        final Object $price = this.getPrice();
        result = result * 59 + (($price == null) ? 43 : $price.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "ExchageDataVo(tradeName=" + this.getTradeName() + ", marketName=" + this.getMarketName() + ", createDate=" + this.getCreateDate() + ", price=" + this.getPrice() + ")";
    }
}
