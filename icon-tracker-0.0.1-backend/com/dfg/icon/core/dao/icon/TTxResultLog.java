// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TTxResultLog extends TTxResultLogKey
{
    private String txHash;
    private Integer txIndex;
    private String contractAddr;
    private Integer height;
    private Date age;
    private String method;
    private String eventLog;
    
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
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = ((contractAddr == null) ? null : contractAddr.trim());
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public Date getAge() {
        return this.age;
    }
    
    public void setAge(final Date age) {
        this.age = age;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public void setMethod(final String method) {
        this.method = ((method == null) ? null : method.trim());
    }
    
    public String getEventLog() {
        return this.eventLog;
    }
    
    public void setEventLog(final String eventLog) {
        this.eventLog = ((eventLog == null) ? null : eventLog.trim());
    }
}
