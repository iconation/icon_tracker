// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.ArrayList;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;

public class TxResult
{
    Integer status;
    TxResultFailure failure;
    String txHash;
    Integer txIndex;
    Integer blockHeight;
    String blockHash;
    String cumulativeStepUsed;
    String stepUsed;
    String stepPrice;
    String scoreAddress;
    String to;
    String version;
    List<EventLog> eventLogList;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public TxResult() {
        this.eventLogList = new ArrayList();
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public TxResultFailure getFailure() {
        return this.failure;
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public Integer getTxIndex() {
        return this.txIndex;
    }
    
    public Integer getBlockHeight() {
        return this.blockHeight;
    }
    
    public String getBlockHash() {
        return this.blockHash;
    }
    
    public String getCumulativeStepUsed() {
        return this.cumulativeStepUsed;
    }
    
    public String getStepUsed() {
        return this.stepUsed;
    }
    
    public String getStepPrice() {
        return this.stepPrice;
    }
    
    public String getScoreAddress() {
        return this.scoreAddress;
    }
    
    public String getTo() {
        return this.to;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public List<EventLog> getEventLogList() {
        return (List<EventLog>)this.eventLogList;
    }
    
    public void setStatus(final Integer status) {
        this.status = status;
    }
    
    public void setFailure(final TxResultFailure failure) {
        this.failure = failure;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setTxIndex(final Integer txIndex) {
        this.txIndex = txIndex;
    }
    
    public void setBlockHeight(final Integer blockHeight) {
        this.blockHeight = blockHeight;
    }
    
    public void setBlockHash(final String blockHash) {
        this.blockHash = blockHash;
    }
    
    public void setCumulativeStepUsed(final String cumulativeStepUsed) {
        this.cumulativeStepUsed = cumulativeStepUsed;
    }
    
    public void setStepUsed(final String stepUsed) {
        this.stepUsed = stepUsed;
    }
    
    public void setStepPrice(final String stepPrice) {
        this.stepPrice = stepPrice;
    }
    
    public void setScoreAddress(final String scoreAddress) {
        this.scoreAddress = scoreAddress;
    }
    
    public void setTo(final String to) {
        this.to = to;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public void setEventLogList(final List<EventLog> eventLogList) {
        this.eventLogList = eventLogList;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxResult)) {
            return false;
        }
        final TxResult other = (TxResult)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        Label_0065: {
            if (this$status == null) {
                if (other$status == null) {
                    break Label_0065;
                }
            }
            else if (this$status.equals(other$status)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$failure = this.getFailure();
        final Object other$failure = other.getFailure();
        Label_0102: {
            if (this$failure == null) {
                if (other$failure == null) {
                    break Label_0102;
                }
            }
            else if (this$failure.equals(other$failure)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$txHash = this.getTxHash();
        final Object other$txHash = other.getTxHash();
        Label_0139: {
            if (this$txHash == null) {
                if (other$txHash == null) {
                    break Label_0139;
                }
            }
            else if (this$txHash.equals(other$txHash)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$txIndex = this.getTxIndex();
        final Object other$txIndex = other.getTxIndex();
        Label_0176: {
            if (this$txIndex == null) {
                if (other$txIndex == null) {
                    break Label_0176;
                }
            }
            else if (this$txIndex.equals(other$txIndex)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$blockHeight = this.getBlockHeight();
        final Object other$blockHeight = other.getBlockHeight();
        Label_0213: {
            if (this$blockHeight == null) {
                if (other$blockHeight == null) {
                    break Label_0213;
                }
            }
            else if (this$blockHeight.equals(other$blockHeight)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$blockHash = this.getBlockHash();
        final Object other$blockHash = other.getBlockHash();
        Label_0250: {
            if (this$blockHash == null) {
                if (other$blockHash == null) {
                    break Label_0250;
                }
            }
            else if (this$blockHash.equals(other$blockHash)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$cumulativeStepUsed = this.getCumulativeStepUsed();
        final Object other$cumulativeStepUsed = other.getCumulativeStepUsed();
        Label_0287: {
            if (this$cumulativeStepUsed == null) {
                if (other$cumulativeStepUsed == null) {
                    break Label_0287;
                }
            }
            else if (this$cumulativeStepUsed.equals(other$cumulativeStepUsed)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$stepUsed = this.getStepUsed();
        final Object other$stepUsed = other.getStepUsed();
        Label_0324: {
            if (this$stepUsed == null) {
                if (other$stepUsed == null) {
                    break Label_0324;
                }
            }
            else if (this$stepUsed.equals(other$stepUsed)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$stepPrice = this.getStepPrice();
        final Object other$stepPrice = other.getStepPrice();
        Label_0361: {
            if (this$stepPrice == null) {
                if (other$stepPrice == null) {
                    break Label_0361;
                }
            }
            else if (this$stepPrice.equals(other$stepPrice)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$scoreAddress = this.getScoreAddress();
        final Object other$scoreAddress = other.getScoreAddress();
        Label_0398: {
            if (this$scoreAddress == null) {
                if (other$scoreAddress == null) {
                    break Label_0398;
                }
            }
            else if (this$scoreAddress.equals(other$scoreAddress)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$to = this.getTo();
        final Object other$to = other.getTo();
        Label_0435: {
            if (this$to == null) {
                if (other$to == null) {
                    break Label_0435;
                }
            }
            else if (this$to.equals(other$to)) {
                break Label_0435;
            }
            return false;
        }
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        Label_0472: {
            if (this$version == null) {
                if (other$version == null) {
                    break Label_0472;
                }
            }
            else if (this$version.equals(other$version)) {
                break Label_0472;
            }
            return false;
        }
        final Object this$eventLogList = this.getEventLogList();
        final Object other$eventLogList = other.getEventLogList();
        if (this$eventLogList == null) {
            if (other$eventLogList == null) {
                return true;
            }
        }
        else if (this$eventLogList.equals(other$eventLogList)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TxResult;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $status = this.getStatus();
        result = result * 59 + (($status == null) ? 43 : $status.hashCode());
        final Object $failure = this.getFailure();
        result = result * 59 + (($failure == null) ? 43 : $failure.hashCode());
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $txIndex = this.getTxIndex();
        result = result * 59 + (($txIndex == null) ? 43 : $txIndex.hashCode());
        final Object $blockHeight = this.getBlockHeight();
        result = result * 59 + (($blockHeight == null) ? 43 : $blockHeight.hashCode());
        final Object $blockHash = this.getBlockHash();
        result = result * 59 + (($blockHash == null) ? 43 : $blockHash.hashCode());
        final Object $cumulativeStepUsed = this.getCumulativeStepUsed();
        result = result * 59 + (($cumulativeStepUsed == null) ? 43 : $cumulativeStepUsed.hashCode());
        final Object $stepUsed = this.getStepUsed();
        result = result * 59 + (($stepUsed == null) ? 43 : $stepUsed.hashCode());
        final Object $stepPrice = this.getStepPrice();
        result = result * 59 + (($stepPrice == null) ? 43 : $stepPrice.hashCode());
        final Object $scoreAddress = this.getScoreAddress();
        result = result * 59 + (($scoreAddress == null) ? 43 : $scoreAddress.hashCode());
        final Object $to = this.getTo();
        result = result * 59 + (($to == null) ? 43 : $to.hashCode());
        final Object $version = this.getVersion();
        result = result * 59 + (($version == null) ? 43 : $version.hashCode());
        final Object $eventLogList = this.getEventLogList();
        result = result * 59 + (($eventLogList == null) ? 43 : $eventLogList.hashCode());
        return result;
    }
}
