// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TMainBlock extends TMainBlockKey
{
    private String hash;
    private String crepAddr;
    private Integer txCount;
    private Date createDate;
    
    public String getHash() {
        return this.hash;
    }
    
    public void setHash(final String hash) {
        this.hash = ((hash == null) ? null : hash.trim());
    }
    
    public String getCrepAddr() {
        return this.crepAddr;
    }
    
    public void setCrepAddr(final String crepAddr) {
        this.crepAddr = ((crepAddr == null) ? null : crepAddr.trim());
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
}
