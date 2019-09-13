// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public class TokenAddressGroupKey
{
    String tokenAddr;
    String contractAddr;
    Integer decimals;
    
    public TokenAddressGroupKey() {
    }
    
    public TokenAddressGroupKey(final String tokenAddr, final String contractAddr, final Integer decimals) {
        this.tokenAddr = tokenAddr;
        this.contractAddr = contractAddr;
        this.decimals = decimals;
    }
    
    public String getTokenAddr() {
        return this.tokenAddr;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public Integer getDecimals() {
        return this.decimals;
    }
    
    public void setTokenAddr(final String tokenAddr) {
        this.tokenAddr = tokenAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setDecimals(final Integer decimals) {
        this.decimals = decimals;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenAddressGroupKey)) {
            return false;
        }
        final TokenAddressGroupKey other = (TokenAddressGroupKey)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$tokenAddr = this.getTokenAddr();
        final Object other$tokenAddr = other.getTokenAddr();
        Label_0065: {
            if (this$tokenAddr == null) {
                if (other$tokenAddr == null) {
                    break Label_0065;
                }
            }
            else if (this$tokenAddr.equals(other$tokenAddr)) {
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
        return other instanceof TokenAddressGroupKey;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tokenAddr = this.getTokenAddr();
        result = result * 59 + (($tokenAddr == null) ? 43 : $tokenAddr.hashCode());
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $decimals = this.getDecimals();
        result = result * 59 + (($decimals == null) ? 43 : $decimals.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenAddressGroupKey(tokenAddr=" + this.getTokenAddr() + ", contractAddr=" + this.getContractAddr() + ", decimals=" + this.getDecimals() + ")";
    }
}
