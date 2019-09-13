// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;
import java.util.Date;

public class TxDetail
{
    String txHash;
    String status;
    String errorCode;
    String errorMsg;
    String dataString;
    int height;
    Date createDate;
    String fromAddr;
    String toAddr;
    String txType;
    String dataType;
    String amount;
    String fee;
    String feeUsd;
    int state;
    String stepLimit;
    String stepUsedByTxn;
    String stepPrice;
    Integer confirmation;
    String targetContractAddr;
    String contractVersion;
    List<TxDetailTokenTx> tokenTxList;
    List<InternalTx> internalTxList;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorMsg() {
        return this.errorMsg;
    }
    
    public String getDataString() {
        return this.dataString;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public String getTxType() {
        return this.txType;
    }
    
    public String getDataType() {
        return this.dataType;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public String getFeeUsd() {
        return this.feeUsd;
    }
    
    public int getState() {
        return this.state;
    }
    
    public String getStepLimit() {
        return this.stepLimit;
    }
    
    public String getStepUsedByTxn() {
        return this.stepUsedByTxn;
    }
    
    public String getStepPrice() {
        return this.stepPrice;
    }
    
    public Integer getConfirmation() {
        return this.confirmation;
    }
    
    public String getTargetContractAddr() {
        return this.targetContractAddr;
    }
    
    public String getContractVersion() {
        return this.contractVersion;
    }
    
    public List<TxDetailTokenTx> getTokenTxList() {
        return (List<TxDetailTokenTx>)this.tokenTxList;
    }
    
    public List<InternalTx> getInternalTxList() {
        return (List<InternalTx>)this.internalTxList;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public void setDataString(final String dataString) {
        this.dataString = dataString;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = toAddr;
    }
    
    public void setTxType(final String txType) {
        this.txType = txType;
    }
    
    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setFeeUsd(final String feeUsd) {
        this.feeUsd = feeUsd;
    }
    
    public void setState(final int state) {
        this.state = state;
    }
    
    public void setStepLimit(final String stepLimit) {
        this.stepLimit = stepLimit;
    }
    
    public void setStepUsedByTxn(final String stepUsedByTxn) {
        this.stepUsedByTxn = stepUsedByTxn;
    }
    
    public void setStepPrice(final String stepPrice) {
        this.stepPrice = stepPrice;
    }
    
    public void setConfirmation(final Integer confirmation) {
        this.confirmation = confirmation;
    }
    
    public void setTargetContractAddr(final String targetContractAddr) {
        this.targetContractAddr = targetContractAddr;
    }
    
    public void setContractVersion(final String contractVersion) {
        this.contractVersion = contractVersion;
    }
    
    public void setTokenTxList(final List<TxDetailTokenTx> tokenTxList) {
        this.tokenTxList = tokenTxList;
    }
    
    public void setInternalTxList(final List<InternalTx> internalTxList) {
        this.internalTxList = internalTxList;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxDetail)) {
            return false;
        }
        final TxDetail other = (TxDetail)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$txHash = this.getTxHash();
        final Object other$txHash = other.getTxHash();
        Label_0065: {
            if (this$txHash == null) {
                if (other$txHash == null) {
                    break Label_0065;
                }
            }
            else if (this$txHash.equals(other$txHash)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        Label_0102: {
            if (this$status == null) {
                if (other$status == null) {
                    break Label_0102;
                }
            }
            else if (this$status.equals(other$status)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$errorCode = this.getErrorCode();
        final Object other$errorCode = other.getErrorCode();
        Label_0139: {
            if (this$errorCode == null) {
                if (other$errorCode == null) {
                    break Label_0139;
                }
            }
            else if (this$errorCode.equals(other$errorCode)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$errorMsg = this.getErrorMsg();
        final Object other$errorMsg = other.getErrorMsg();
        Label_0176: {
            if (this$errorMsg == null) {
                if (other$errorMsg == null) {
                    break Label_0176;
                }
            }
            else if (this$errorMsg.equals(other$errorMsg)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$dataString = this.getDataString();
        final Object other$dataString = other.getDataString();
        Label_0213: {
            if (this$dataString == null) {
                if (other$dataString == null) {
                    break Label_0213;
                }
            }
            else if (this$dataString.equals(other$dataString)) {
                break Label_0213;
            }
            return false;
        }
        if (this.getHeight() != other.getHeight()) {
            return false;
        }
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0263: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0263;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0263;
            }
            return false;
        }
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0300: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0300;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0300;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0337: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0337;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0337;
            }
            return false;
        }
        final Object this$txType = this.getTxType();
        final Object other$txType = other.getTxType();
        Label_0374: {
            if (this$txType == null) {
                if (other$txType == null) {
                    break Label_0374;
                }
            }
            else if (this$txType.equals(other$txType)) {
                break Label_0374;
            }
            return false;
        }
        final Object this$dataType = this.getDataType();
        final Object other$dataType = other.getDataType();
        Label_0411: {
            if (this$dataType == null) {
                if (other$dataType == null) {
                    break Label_0411;
                }
            }
            else if (this$dataType.equals(other$dataType)) {
                break Label_0411;
            }
            return false;
        }
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        Label_0448: {
            if (this$amount == null) {
                if (other$amount == null) {
                    break Label_0448;
                }
            }
            else if (this$amount.equals(other$amount)) {
                break Label_0448;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0485: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0485;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0485;
            }
            return false;
        }
        final Object this$feeUsd = this.getFeeUsd();
        final Object other$feeUsd = other.getFeeUsd();
        Label_0522: {
            if (this$feeUsd == null) {
                if (other$feeUsd == null) {
                    break Label_0522;
                }
            }
            else if (this$feeUsd.equals(other$feeUsd)) {
                break Label_0522;
            }
            return false;
        }
        if (this.getState() != other.getState()) {
            return false;
        }
        final Object this$stepLimit = this.getStepLimit();
        final Object other$stepLimit = other.getStepLimit();
        Label_0572: {
            if (this$stepLimit == null) {
                if (other$stepLimit == null) {
                    break Label_0572;
                }
            }
            else if (this$stepLimit.equals(other$stepLimit)) {
                break Label_0572;
            }
            return false;
        }
        final Object this$stepUsedByTxn = this.getStepUsedByTxn();
        final Object other$stepUsedByTxn = other.getStepUsedByTxn();
        Label_0609: {
            if (this$stepUsedByTxn == null) {
                if (other$stepUsedByTxn == null) {
                    break Label_0609;
                }
            }
            else if (this$stepUsedByTxn.equals(other$stepUsedByTxn)) {
                break Label_0609;
            }
            return false;
        }
        final Object this$stepPrice = this.getStepPrice();
        final Object other$stepPrice = other.getStepPrice();
        Label_0646: {
            if (this$stepPrice == null) {
                if (other$stepPrice == null) {
                    break Label_0646;
                }
            }
            else if (this$stepPrice.equals(other$stepPrice)) {
                break Label_0646;
            }
            return false;
        }
        final Object this$confirmation = this.getConfirmation();
        final Object other$confirmation = other.getConfirmation();
        Label_0683: {
            if (this$confirmation == null) {
                if (other$confirmation == null) {
                    break Label_0683;
                }
            }
            else if (this$confirmation.equals(other$confirmation)) {
                break Label_0683;
            }
            return false;
        }
        final Object this$targetContractAddr = this.getTargetContractAddr();
        final Object other$targetContractAddr = other.getTargetContractAddr();
        Label_0720: {
            if (this$targetContractAddr == null) {
                if (other$targetContractAddr == null) {
                    break Label_0720;
                }
            }
            else if (this$targetContractAddr.equals(other$targetContractAddr)) {
                break Label_0720;
            }
            return false;
        }
        final Object this$contractVersion = this.getContractVersion();
        final Object other$contractVersion = other.getContractVersion();
        Label_0757: {
            if (this$contractVersion == null) {
                if (other$contractVersion == null) {
                    break Label_0757;
                }
            }
            else if (this$contractVersion.equals(other$contractVersion)) {
                break Label_0757;
            }
            return false;
        }
        final Object this$tokenTxList = this.getTokenTxList();
        final Object other$tokenTxList = other.getTokenTxList();
        Label_0794: {
            if (this$tokenTxList == null) {
                if (other$tokenTxList == null) {
                    break Label_0794;
                }
            }
            else if (this$tokenTxList.equals(other$tokenTxList)) {
                break Label_0794;
            }
            return false;
        }
        final Object this$internalTxList = this.getInternalTxList();
        final Object other$internalTxList = other.getInternalTxList();
        if (this$internalTxList == null) {
            if (other$internalTxList == null) {
                return true;
            }
        }
        else if (this$internalTxList.equals(other$internalTxList)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TxDetail;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $status = this.getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        final Object $errorCode = this.getErrorCode();
        result = result * 59 + (($errorCode == null) ? 43 : $errorCode.hashCode());
        final Object $errorMsg = this.getErrorMsg();
        result = result * 59 + (($errorMsg == null) ? 43 : $errorMsg.hashCode());
        final Object $dataString = this.getDataString();
        result = result * 59 + (($dataString == null) ? 43 : $dataString.hashCode());
        result = result * 59 + this.getHeight();
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $txType = this.getTxType();
        result = result * 59 + (($txType == null) ? 43 : $txType.hashCode());
        final Object $dataType = this.getDataType();
        result = result * 59 + (($dataType == null) ? 43 : $dataType.hashCode());
        final Object $amount = this.getAmount();
        result = result * 59 + (($amount == null) ? 43 : $amount.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        final Object $feeUsd = this.getFeeUsd();
        result = result * 59 + (($feeUsd == null) ? 43 : $feeUsd.hashCode());
        result = result * 59 + this.getState();
        final Object $stepLimit = this.getStepLimit();
        result = result * 59 + (($stepLimit == null) ? 43 : $stepLimit.hashCode());
        final Object $stepUsedByTxn = this.getStepUsedByTxn();
        result = result * 59 + (($stepUsedByTxn == null) ? 43 : $stepUsedByTxn.hashCode());
        final Object $stepPrice = this.getStepPrice();
        result = result * 59 + (($stepPrice == null) ? 43 : $stepPrice.hashCode());
        final Object $confirmation = this.getConfirmation();
        result = result * 59 + (($confirmation == null) ? 43 : $confirmation.hashCode());
        final Object $targetContractAddr = this.getTargetContractAddr();
        result = result * 59 + (($targetContractAddr == null) ? 43 : $targetContractAddr.hashCode());
        final Object $contractVersion = this.getContractVersion();
        result = result * 59 + (($contractVersion == null) ? 43 : $contractVersion.hashCode());
        final Object $tokenTxList = this.getTokenTxList();
        result = result * 59 + (($tokenTxList == null) ? 43 : $tokenTxList.hashCode());
        final Object $internalTxList = this.getInternalTxList();
        result = result * 59 + (($internalTxList == null) ? 43 : $internalTxList.hashCode());
        return result;
    }
}
