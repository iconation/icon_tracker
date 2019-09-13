// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TAddressTotal extends TAddressTotalKey
{
    private String balance;
    private Integer txCount;
    private String nodeType;
    private Boolean isUpdate;
    
    public String getBalance() {
        return this.balance;
    }
    
    public void setBalance(final String balance) {
        this.balance = ((balance == null) ? null : balance.trim());
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public String getNodeType() {
        return this.nodeType;
    }
    
    public void setNodeType(final String nodeType) {
        this.nodeType = ((nodeType == null) ? null : nodeType.trim());
    }
    
    public Boolean getIsUpdate() {
        return this.isUpdate;
    }
    
    public void setIsUpdate(final Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
}
