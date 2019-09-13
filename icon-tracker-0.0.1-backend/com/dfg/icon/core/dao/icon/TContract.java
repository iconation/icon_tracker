// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TContract extends TContractKey
{
    private Integer version;
    private String name;
    private String ircVersion;
    private String symbol;
    private String holderAddr;
    private Integer holderCount;
    private Integer transferCount;
    private String totalSupply;
    private Integer decimals;
    private Integer state;
    
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(final Integer version) {
        this.version = version;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = ((name == null) ? null : name.trim());
    }
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ((ircVersion == null) ? null : ircVersion.trim());
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = ((symbol == null) ? null : symbol.trim());
    }
    
    public String getHolderAddr() {
        return this.holderAddr;
    }
    
    public void setHolderAddr(final String holderAddr) {
        this.holderAddr = ((holderAddr == null) ? null : holderAddr.trim());
    }
    
    public Integer getHolderCount() {
        return this.holderCount;
    }
    
    public void setHolderCount(final Integer holderCount) {
        this.holderCount = holderCount;
    }
    
    public Integer getTransferCount() {
        return this.transferCount;
    }
    
    public void setTransferCount(final Integer transferCount) {
        this.transferCount = transferCount;
    }
    
    public String getTotalSupply() {
        return this.totalSupply;
    }
    
    public void setTotalSupply(final String totalSupply) {
        this.totalSupply = ((totalSupply == null) ? null : totalSupply.trim());
    }
    
    public Integer getDecimals() {
        return this.decimals;
    }
    
    public void setDecimals(final Integer decimals) {
        this.decimals = decimals;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
}
