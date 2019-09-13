// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TCurrentExchangeKey
{
    private String marketName;
    private String tradeName;
    
    public String getMarketName() {
        return this.marketName;
    }
    
    public void setMarketName(final String marketName) {
        this.marketName = ((marketName == null) ? null : marketName.trim());
    }
    
    public String getTradeName() {
        return this.tradeName;
    }
    
    public void setTradeName(final String tradeName) {
        this.tradeName = ((tradeName == null) ? null : tradeName.trim());
    }
}
