// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TMainTx extends TMainTxKey
{
    private String amount;
    private String fee;
    private String scoreYn;
    private Date createDate;
    private Integer state;
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = ((amount == null) ? null : amount.trim());
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setFee(final String fee) {
        this.fee = ((fee == null) ? null : fee.trim());
    }
    
    public String getScoreYn() {
        return this.scoreYn;
    }
    
    public void setScoreYn(final String scoreYn) {
        this.scoreYn = ((scoreYn == null) ? null : scoreYn.trim());
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
}
