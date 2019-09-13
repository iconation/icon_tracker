// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.math.BigDecimal;

public class TTokenAddress extends TTokenAddressKey
{
    private Integer txCount;
    private String quantity;
    private BigDecimal quantityOrder;
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = ((quantity == null) ? null : quantity.trim());
    }
    
    public BigDecimal getQuantityOrder() {
        return this.quantityOrder;
    }
    
    public void setQuantityOrder(final BigDecimal quantityOrder) {
        this.quantityOrder = quantityOrder;
    }
}
