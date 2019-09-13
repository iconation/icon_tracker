// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TBlock extends TBlockKey
{
    private String hash;
    private Date createDate;
    private String cRep;
    private Integer txCount;
    private String prevHash;
    private Integer blockSize;
    private String fee;
    private String amount;
    
    public String getHash() {
        return this.hash;
    }
    
    public void setHash(final String hash) {
        this.hash = ((hash == null) ? null : hash.trim());
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public String getcRep() {
        return this.cRep;
    }
    
    public void setcRep(final String cRep) {
        this.cRep = ((cRep == null) ? null : cRep.trim());
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public String getPrevHash() {
        return this.prevHash;
    }
    
    public void setPrevHash(final String prevHash) {
        this.prevHash = ((prevHash == null) ? null : prevHash.trim());
    }
    
    public Integer getBlockSize() {
        return this.blockSize;
    }
    
    public void setBlockSize(final Integer blockSize) {
        this.blockSize = blockSize;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setFee(final String fee) {
        this.fee = ((fee == null) ? null : fee.trim());
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = ((amount == null) ? null : amount.trim());
    }
}
