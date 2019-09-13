// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TContractHistory extends TContractHistoryKey
{
    private String compiler;
    private String createTx;
    private Date createDate;
    private String verifiedTx;
    private Date verifiedDate;
    private String creator;
    private Integer state;
    
    public String getCompiler() {
        return this.compiler;
    }
    
    public void setCompiler(final String compiler) {
        this.compiler = ((compiler == null) ? null : compiler.trim());
    }
    
    public String getCreateTx() {
        return this.createTx;
    }
    
    public void setCreateTx(final String createTx) {
        this.createTx = ((createTx == null) ? null : createTx.trim());
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public String getVerifiedTx() {
        return this.verifiedTx;
    }
    
    public void setVerifiedTx(final String verifiedTx) {
        this.verifiedTx = ((verifiedTx == null) ? null : verifiedTx.trim());
    }
    
    public Date getVerifiedDate() {
        return this.verifiedDate;
    }
    
    public void setVerifiedDate(final Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }
    
    public String getCreator() {
        return this.creator;
    }
    
    public void setCreator(final String creator) {
        this.creator = ((creator == null) ? null : creator.trim());
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
}
