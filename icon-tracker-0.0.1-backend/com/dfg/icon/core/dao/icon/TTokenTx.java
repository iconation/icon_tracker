// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TTokenTx extends TTokenTxKey
{
    private String contractAddr;
    private String txHash;
    private Integer txIndex;
    private Date age;
    private String fromAddr;
    private String toAddr;
    private String quantity;
    private String ircVersion;
    private Integer state;
    private String amount;
    private Integer blockHeight;
    private String fee;
    private Integer txType;
    
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
    
    public Date getAge() {
        return this.age;
    }
    
    public void setAge(final Date age) {
        this.age = age;
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
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = ((quantity == null) ? null : quantity.trim());
    }
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ((ircVersion == null) ? null : ircVersion.trim());
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = ((amount == null) ? null : amount.trim());
    }
    
    public Integer getBlockHeight() {
        return this.blockHeight;
    }
    
    public void setBlockHeight(final Integer blockHeight) {
        this.blockHeight = blockHeight;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public void setFee(final String fee) {
        this.fee = ((fee == null) ? null : fee.trim());
    }
    
    public Integer getTxType() {
        return this.txType;
    }
    
    public void setTxType(final Integer txType) {
        this.txType = txType;
    }
}
