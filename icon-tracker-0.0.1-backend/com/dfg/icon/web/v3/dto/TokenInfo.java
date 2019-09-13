// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TokenInfo
{
    String contractAddr;
    String name;
    String symbol;
    String holderAddr;
    Integer holderCount;
    Integer transferCount;
    String totalSupply;
    Integer decimals;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getHolderAddr() {
        return this.holderAddr;
    }
    
    public Integer getHolderCount() {
        return this.holderCount;
    }
    
    public Integer getTransferCount() {
        return this.transferCount;
    }
    
    public String getTotalSupply() {
        return this.totalSupply;
    }
    
    public Integer getDecimals() {
        return this.decimals;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setHolderAddr(final String holderAddr) {
        this.holderAddr = holderAddr;
    }
    
    public void setHolderCount(final Integer holderCount) {
        this.holderCount = holderCount;
    }
    
    public void setTransferCount(final Integer transferCount) {
        this.transferCount = transferCount;
    }
    
    public void setTotalSupply(final String totalSupply) {
        this.totalSupply = totalSupply;
    }
    
    public void setDecimals(final Integer decimals) {
        this.decimals = decimals;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenInfo)) {
            return false;
        }
        final TokenInfo other = (TokenInfo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$contractAddr = this.getContractAddr();
        final Object other$contractAddr = other.getContractAddr();
        Label_0065: {
            if (this$contractAddr == null) {
                if (other$contractAddr == null) {
                    break Label_0065;
                }
            }
            else if (this$contractAddr.equals(other$contractAddr)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        Label_0102: {
            if (this$name == null) {
                if (other$name == null) {
                    break Label_0102;
                }
            }
            else if (this$name.equals(other$name)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        Label_0139: {
            if (this$symbol == null) {
                if (other$symbol == null) {
                    break Label_0139;
                }
            }
            else if (this$symbol.equals(other$symbol)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$holderAddr = this.getHolderAddr();
        final Object other$holderAddr = other.getHolderAddr();
        Label_0176: {
            if (this$holderAddr == null) {
                if (other$holderAddr == null) {
                    break Label_0176;
                }
            }
            else if (this$holderAddr.equals(other$holderAddr)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$holderCount = this.getHolderCount();
        final Object other$holderCount = other.getHolderCount();
        Label_0213: {
            if (this$holderCount == null) {
                if (other$holderCount == null) {
                    break Label_0213;
                }
            }
            else if (this$holderCount.equals(other$holderCount)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$transferCount = this.getTransferCount();
        final Object other$transferCount = other.getTransferCount();
        Label_0250: {
            if (this$transferCount == null) {
                if (other$transferCount == null) {
                    break Label_0250;
                }
            }
            else if (this$transferCount.equals(other$transferCount)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$totalSupply = this.getTotalSupply();
        final Object other$totalSupply = other.getTotalSupply();
        Label_0287: {
            if (this$totalSupply == null) {
                if (other$totalSupply == null) {
                    break Label_0287;
                }
            }
            else if (this$totalSupply.equals(other$totalSupply)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$decimals = this.getDecimals();
        final Object other$decimals = other.getDecimals();
        if (this$decimals == null) {
            if (other$decimals == null) {
                return true;
            }
        }
        else if (this$decimals.equals(other$decimals)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenInfo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $name = this.getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $holderAddr = this.getHolderAddr();
        result = result * 59 + (($holderAddr == null) ? 43 : $holderAddr.hashCode());
        final Object $holderCount = this.getHolderCount();
        result = result * 59 + (($holderCount == null) ? 43 : $holderCount.hashCode());
        final Object $transferCount = this.getTransferCount();
        result = result * 59 + (($transferCount == null) ? 43 : $transferCount.hashCode());
        final Object $totalSupply = this.getTotalSupply();
        result = result * 59 + (($totalSupply == null) ? 43 : $totalSupply.hashCode());
        final Object $decimals = this.getDecimals();
        result = result * 59 + (($decimals == null) ? 43 : $decimals.hashCode());
        return result;
    }
}
