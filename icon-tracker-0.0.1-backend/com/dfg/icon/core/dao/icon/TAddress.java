// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.math.BigDecimal;

public class TAddress extends TAddressKey
{
    private String balance;
    private Integer txCount;
    private String nodeType;
    private BigDecimal balanceOrder;
    
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
    
    public BigDecimal getBalanceOrder() {
        return this.balanceOrder;
    }
    
    public void setBalanceOrder(final BigDecimal balanceOrder) {
        this.balanceOrder = balanceOrder;
    }
}
