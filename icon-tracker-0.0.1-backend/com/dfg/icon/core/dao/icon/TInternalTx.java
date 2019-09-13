// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TInternalTx extends TInternalTxKey
{
    private String parentTxHash;
    private Integer txIndex;
    private String contractAddr;
    private Date createDate;
    private Integer height;
    private String fromAddr;
    private String toAddr;
    private String amount;
    private Integer state;
    
    public String getParentTxHash() {
        return this.parentTxHash;
    }
    
    public void setParentTxHash(final String parentTxHash) {
        this.parentTxHash = ((parentTxHash == null) ? null : parentTxHash.trim());
    }
    
    public Integer getTxIndex() {
        return this.txIndex;
    }
    
    public void setTxIndex(final Integer txIndex) {
        this.txIndex = txIndex;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = ((contractAddr == null) ? null : contractAddr.trim());
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = ((fromAddr == null) ? null : fromAddr.trim());
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = ((toAddr == null) ? null : toAddr.trim());
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = ((amount == null) ? null : amount.trim());
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
}
