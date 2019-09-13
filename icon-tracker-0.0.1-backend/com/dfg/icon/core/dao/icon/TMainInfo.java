// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TMainInfo extends TMainInfoKey
{
    private String icxSupply;
    private String icxCirculationy;
    private Integer transactionCount;
    private Integer crepCount;
    private String publicTreasury;
    
    public String getIcxSupply() {
        return this.icxSupply;
    }
    
    public void setIcxSupply(final String icxSupply) {
        this.icxSupply = ((icxSupply == null) ? null : icxSupply.trim());
    }
    
    public String getIcxCirculationy() {
        return this.icxCirculationy;
    }
    
    public void setIcxCirculationy(final String icxCirculationy) {
        this.icxCirculationy = ((icxCirculationy == null) ? null : icxCirculationy.trim());
    }
    
    public Integer getTransactionCount() {
        return this.transactionCount;
    }
    
    public void setTransactionCount(final Integer transactionCount) {
        this.transactionCount = transactionCount;
    }
    
    public Integer getCrepCount() {
        return this.crepCount;
    }
    
    public void setCrepCount(final Integer crepCount) {
        this.crepCount = crepCount;
    }
    
    public String getPublicTreasury() {
        return this.publicTreasury;
    }
    
    public void setPublicTreasury(final String publicTreasury) {
        this.publicTreasury = ((publicTreasury == null) ? null : publicTreasury.trim());
    }
}
