// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TTokenTxView extends TTokenTxViewKey
{
    private String contractAddr;
    private String txHash;
    private Integer txIndex;
    private String address;
    private Integer blockHeight;
    private Date age;
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = ((contractAddr == null) ? null : contractAddr.trim());
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = ((txHash == null) ? null : txHash.trim());
    }
    
    public Integer getTxIndex() {
        return this.txIndex;
    }
    
    public void setTxIndex(final Integer txIndex) {
        this.txIndex = txIndex;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = ((address == null) ? null : address.trim());
    }
    
    public Integer getBlockHeight() {
        return this.blockHeight;
    }
    
    public void setBlockHeight(final Integer blockHeight) {
        this.blockHeight = blockHeight;
    }
    
    public Date getAge() {
        return this.age;
    }
    
    public void setAge(final Date age) {
        this.age = age;
    }
}
