// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionVo
{
    @JsonProperty("version")
    String version;
    @JsonProperty("from")
    String from;
    @JsonProperty("to")
    String to;
    @JsonProperty("value")
    String value;
    @JsonProperty("stepLimit")
    String stepLimit;
    @JsonProperty("fee")
    String fee;
    @JsonProperty("timestamp")
    Long timestamp;
    @JsonProperty("nonce")
    String nonce;
    @JsonProperty("signature")
    String signature;
    @JsonProperty("tx_hash")
    String txHash;
    @JsonProperty("dataType")
    String dataType;
    @JsonProperty("method")
    String method;
    @JsonProperty("data")
    String data;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public String getFrom() {
        return this.from;
    }
    
    public String getTo() {
        return this.to;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public String getStepLimit() {
        return this.stepLimit;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public Long getTimestamp() {
        return this.timestamp;
    }
    
    public String getNonce() {
        return this.nonce;
    }
    
    public String getSignature() {
        return this.signature;
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getDataType() {
        return this.dataType;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public String getData() {
        return this.data;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public void setFrom(final String from) {
        this.from = from;
    }
    
    public void setTo(final String to) {
        this.to = to;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
    
    public void setStepLimit(final String stepLimit) {
        this.stepLimit = stepLimit;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setNonce(final String nonce) {
        this.nonce = nonce;
    }
    
    public void setSignature(final String signature) {
        this.signature = signature;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }
    
    public void setMethod(final String method) {
        this.method = method;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TransactionVo)) {
            return false;
        }
        final TransactionVo other = (TransactionVo)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        Label_0065: {
            if (this$version == null) {
                if (other$version == null) {
                    break Label_0065;
                }
            }
            else if (this$version.equals(other$version)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$from = this.getFrom();
        final Object other$from = other.getFrom();
        Label_0102: {
            if (this$from == null) {
                if (other$from == null) {
                    break Label_0102;
                }
            }
            else if (this$from.equals(other$from)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$to = this.getTo();
        final Object other$to = other.getTo();
        Label_0139: {
            if (this$to == null) {
                if (other$to == null) {
                    break Label_0139;
                }
            }
            else if (this$to.equals(other$to)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        Label_0176: {
            if (this$value == null) {
                if (other$value == null) {
                    break Label_0176;
                }
            }
            else if (this$value.equals(other$value)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$stepLimit = this.getStepLimit();
        final Object other$stepLimit = other.getStepLimit();
        Label_0213: {
            if (this$stepLimit == null) {
                if (other$stepLimit == null) {
                    break Label_0213;
                }
            }
            else if (this$stepLimit.equals(other$stepLimit)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0250: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0250;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        Label_0287: {
            if (this$timestamp == null) {
                if (other$timestamp == null) {
                    break Label_0287;
                }
            }
            else if (this$timestamp.equals(other$timestamp)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$nonce = this.getNonce();
        final Object other$nonce = other.getNonce();
        Label_0324: {
            if (this$nonce == null) {
                if (other$nonce == null) {
                    break Label_0324;
                }
            }
            else if (this$nonce.equals(other$nonce)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$signature = this.getSignature();
        final Object other$signature = other.getSignature();
        Label_0361: {
            if (this$signature == null) {
                if (other$signature == null) {
                    break Label_0361;
                }
            }
            else if (this$signature.equals(other$signature)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$txHash = this.getTxHash();
        final Object other$txHash = other.getTxHash();
        Label_0398: {
            if (this$txHash == null) {
                if (other$txHash == null) {
                    break Label_0398;
                }
            }
            else if (this$txHash.equals(other$txHash)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$dataType = this.getDataType();
        final Object other$dataType = other.getDataType();
        Label_0435: {
            if (this$dataType == null) {
                if (other$dataType == null) {
                    break Label_0435;
                }
            }
            else if (this$dataType.equals(other$dataType)) {
                break Label_0435;
            }
            return false;
        }
        final Object this$method = this.getMethod();
        final Object other$method = other.getMethod();
        Label_0472: {
            if (this$method == null) {
                if (other$method == null) {
                    break Label_0472;
                }
            }
            else if (this$method.equals(other$method)) {
                break Label_0472;
            }
            return false;
        }
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null) {
            if (other$data == null) {
                return true;
            }
        }
        else if (this$data.equals(other$data)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TransactionVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $version = this.getVersion();
        result = result * 59 + (($version == null) ? 43 : $version.hashCode());
        final Object $from = this.getFrom();
        result = result * 59 + (($from == null) ? 43 : $from.hashCode());
        final Object $to = this.getTo();
        result = result * 59 + (($to == null) ? 43 : $to.hashCode());
        final Object $value = this.getValue();
        result = result * 59 + (($value == null) ? 43 : $value.hashCode());
        final Object $stepLimit = this.getStepLimit();
        result = result * 59 + (($stepLimit == null) ? 43 : $stepLimit.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * 59 + (($timestamp == null) ? 43 : $timestamp.hashCode());
        final Object $nonce = this.getNonce();
        result = result * 59 + (($nonce == null) ? 43 : $nonce.hashCode());
        final Object $signature = this.getSignature();
        result = result * 59 + (($signature == null) ? 43 : $signature.hashCode());
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $dataType = this.getDataType();
        result = result * 59 + (($dataType == null) ? 43 : $dataType.hashCode());
        final Object $method = this.getMethod();
        result = result * 59 + (($method == null) ? 43 : $method.hashCode());
        final Object $data = this.getData();
        result = result * 59 + (($data == null) ? 43 : $data.hashCode());
        return result;
    }
}
