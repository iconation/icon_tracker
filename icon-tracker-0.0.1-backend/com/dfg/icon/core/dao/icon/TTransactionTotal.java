// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TTransactionTotal extends TTransactionTotalKey
{
    private String txHash;
    private String hash;
    private Date createDate;
    private String fromAddr;
    private String toAddr;
    private String fee;
    private String amount;
    private Integer state;
    private Integer txType;
    private String stepLimit;
    private String stepUsedTx;
    private String stepPrice;
    private String dataType;
    private String version;
    private String errorCode;
    private String errorMsg;
    private Integer internalTxCount;
    private String contractAddr;
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = ((txHash == null) ? null : txHash.trim());
    }
    
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
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public Integer getTxType() {
        return this.txType;
    }
    
    public void setTxType(final Integer txType) {
        this.txType = txType;
    }
    
    public String getStepLimit() {
        return this.stepLimit;
    }
    
    public void setStepLimit(final String stepLimit) {
        this.stepLimit = ((stepLimit == null) ? null : stepLimit.trim());
    }
    
    public String getStepUsedTx() {
        return this.stepUsedTx;
    }
    
    public void setStepUsedTx(final String stepUsedTx) {
        this.stepUsedTx = ((stepUsedTx == null) ? null : stepUsedTx.trim());
    }
    
    public String getStepPrice() {
        return this.stepPrice;
    }
    
    public void setStepPrice(final String stepPrice) {
        this.stepPrice = ((stepPrice == null) ? null : stepPrice.trim());
    }
    
    public String getDataType() {
        return this.dataType;
    }
    
    public void setDataType(final String dataType) {
        this.dataType = ((dataType == null) ? null : dataType.trim());
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(final String version) {
        this.version = ((version == null) ? null : version.trim());
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public void setErrorCode(final String errorCode) {
        this.errorCode = ((errorCode == null) ? null : errorCode.trim());
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = ((errorMsg == null) ? null : errorMsg.trim());
    }
    
    public Integer getInternalTxCount() {
        return this.internalTxCount;
    }
    
    public void setInternalTxCount(final Integer internalTxCount) {
        this.internalTxCount = internalTxCount;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = ((contractAddr == null) ? null : contractAddr.trim());
    }
}
