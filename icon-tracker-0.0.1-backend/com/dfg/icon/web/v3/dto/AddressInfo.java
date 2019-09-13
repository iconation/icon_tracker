// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;

public class AddressInfo
{
    String address;
    String balance;
    String icxUsd;
    Integer txCount;
    Integer tokenTxCount;
    String nodeType;
    List<TokenAddress> tokenList;
    Integer internalTxCount;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public String getIcxUsd() {
        return this.icxUsd;
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public Integer getTokenTxCount() {
        return this.tokenTxCount;
    }
    
    public String getNodeType() {
        return this.nodeType;
    }
    
    public List<TokenAddress> getTokenList() {
        return this.tokenList;
    }
    
    public Integer getInternalTxCount() {
        return this.internalTxCount;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    
    public void setIcxUsd(final String icxUsd) {
        this.icxUsd = icxUsd;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public void setTokenTxCount(final Integer tokenTxCount) {
        this.tokenTxCount = tokenTxCount;
    }
    
    public void setNodeType(final String nodeType) {
        this.nodeType = nodeType;
    }
    
    public void setTokenList(final List<TokenAddress> tokenList) {
        this.tokenList = tokenList;
    }
    
    public void setInternalTxCount(final Integer internalTxCount) {
        this.internalTxCount = internalTxCount;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddressInfo)) {
            return false;
        }
        final AddressInfo other = (AddressInfo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0065: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0065;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$balance = this.getBalance();
        final Object other$balance = other.getBalance();
        Label_0102: {
            if (this$balance == null) {
                if (other$balance == null) {
                    break Label_0102;
                }
            }
            else if (this$balance.equals(other$balance)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$icxUsd = this.getIcxUsd();
        final Object other$icxUsd = other.getIcxUsd();
        Label_0139: {
            if (this$icxUsd == null) {
                if (other$icxUsd == null) {
                    break Label_0139;
                }
            }
            else if (this$icxUsd.equals(other$icxUsd)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0176: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0176;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$tokenTxCount = this.getTokenTxCount();
        final Object other$tokenTxCount = other.getTokenTxCount();
        Label_0213: {
            if (this$tokenTxCount == null) {
                if (other$tokenTxCount == null) {
                    break Label_0213;
                }
            }
            else if (this$tokenTxCount.equals(other$tokenTxCount)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$nodeType = this.getNodeType();
        final Object other$nodeType = other.getNodeType();
        Label_0250: {
            if (this$nodeType == null) {
                if (other$nodeType == null) {
                    break Label_0250;
                }
            }
            else if (this$nodeType.equals(other$nodeType)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$tokenList = this.getTokenList();
        final Object other$tokenList = other.getTokenList();
        Label_0287: {
            if (this$tokenList == null) {
                if (other$tokenList == null) {
                    break Label_0287;
                }
            }
            else if (this$tokenList.equals(other$tokenList)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$internalTxCount = this.getInternalTxCount();
        final Object other$internalTxCount = other.getInternalTxCount();
        if (this$internalTxCount == null) {
            if (other$internalTxCount == null) {
                return true;
            }
        }
        else if (this$internalTxCount.equals(other$internalTxCount)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof AddressInfo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        final Object $icxUsd = this.getIcxUsd();
        result = result * 59 + (($icxUsd == null) ? 43 : $icxUsd.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $tokenTxCount = this.getTokenTxCount();
        result = result * 59 + (($tokenTxCount == null) ? 43 : $tokenTxCount.hashCode());
        final Object $nodeType = this.getNodeType();
        result = result * 59 + (($nodeType == null) ? 43 : $nodeType.hashCode());
        final Object $tokenList = this.getTokenList();
        result = result * 59 + (($tokenList == null) ? 43 : $tokenList.hashCode());
        final Object $internalTxCount = this.getInternalTxCount();
        result = result * 59 + (($internalTxCount == null) ? 43 : $internalTxCount.hashCode());
        return result;
    }
}
