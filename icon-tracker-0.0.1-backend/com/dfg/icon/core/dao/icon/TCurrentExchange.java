// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TCurrentExchange extends TCurrentExchangeKey
{
    private Date createDate;
    private String price;
    private String prePrice;
    private String dailyRate;
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(final String price) {
        this.price = ((price == null) ? null : price.trim());
    }
    
    public String getPrePrice() {
        return this.prePrice;
    }
    
    public void setPrePrice(final String prePrice) {
        this.prePrice = ((prePrice == null) ? null : prePrice.trim());
    }
    
    public String getDailyRate() {
        return this.dailyRate;
    }
    
    public void setDailyRate(final String dailyRate) {
        this.dailyRate = ((dailyRate == null) ? null : dailyRate.trim());
    }
}
