// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import java.util.Date;

public class TxEventLogList
{
    String txHash;
    String contractAddr;
    Integer height;
    Integer txIndex;
    Date age;
    String method;
    String eventLog;
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public Integer getTxIndex() {
        return this.txIndex;
    }
    
    public Date getAge() {
        return this.age;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public String getEventLog() {
        return this.eventLog;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setTxIndex(final Integer txIndex) {
        this.txIndex = txIndex;
    }
    
    public void setAge(final Date age) {
        this.age = age;
    }
    
    public void setMethod(final String method) {
        this.method = method;
    }
    
    public void setEventLog(final String eventLog) {
        this.eventLog = eventLog;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxEventLogList)) {
            return false;
        }
        final TxEventLogList other = (TxEventLogList)o;
        if (!other.canEqual(this)) {
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
        final Object this$contractAddr = this.getContractAddr();
        final Object other$contractAddr = other.getContractAddr();
        Label_0102: {
            if (this$contractAddr == null) {
                if (other$contractAddr == null) {
                    break Label_0102;
                }
            }
            else if (this$contractAddr.equals(other$contractAddr)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0139: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0139;
                }
            }
            else if (this$height.equals(other$height)) {
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
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        Label_0213: {
            if (this$age == null) {
                if (other$age == null) {
                    break Label_0213;
                }
            }
            else if (this$age.equals(other$age)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$method = this.getMethod();
        final Object other$method = other.getMethod();
        Label_0250: {
            if (this$method == null) {
                if (other$method == null) {
                    break Label_0250;
                }
            }
            else if (this$method.equals(other$method)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$eventLog = this.getEventLog();
        final Object other$eventLog = other.getEventLog();
        if (this$eventLog == null) {
            if (other$eventLog == null) {
                return true;
            }
        }
        else if (this$eventLog.equals(other$eventLog)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TxEventLogList;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $txIndex = this.getTxIndex();
        result = result * 59 + (($txIndex == null) ? 43 : $txIndex.hashCode());
        final Object $age = this.getAge();
        result = result * 59 + (($age == null) ? 43 : $age.hashCode());
        final Object $method = this.getMethod();
        result = result * 59 + (($method == null) ? 43 : $method.hashCode());
        final Object $eventLog = this.getEventLog();
        result = result * 59 + (($eventLog == null) ? 43 : $eventLog.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TxEventLogList(txHash=" + this.getTxHash() + ", contractAddr=" + this.getContractAddr() + ", height=" + this.getHeight() + ", txIndex=" + this.getTxIndex() + ", age=" + this.getAge() + ", method=" + this.getMethod() + ", eventLog=" + this.getEventLog() + ")";
    }
}
