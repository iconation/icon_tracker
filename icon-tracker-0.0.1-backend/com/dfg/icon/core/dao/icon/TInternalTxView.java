// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TInternalTxView extends TInternalTxViewKey
{
    private String parentTxHash;
    private Integer txIndex;
    private String contractAddr;
    private Date createDate;
    private Integer height;
    private String address;
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
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = ((address == null) ? null : address.trim());
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
}
