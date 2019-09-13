// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import com.dfg.icon.core.dao.icon.TContract;

public class TokenSummary
{
    Double totalSupplyUsd;
    Double priceUsd;
    String symbol;
    String tokenName;
    String totalSupply;
    String contract;
    Integer decimals;
    String holderAddr;
    Integer transfers;
    Integer holders;
    
    public void setTokenSummary(final TContract tokenInfo) {
        this.symbol = tokenInfo.getSymbol();
        this.tokenName = tokenInfo.getName();
        this.totalSupply = tokenInfo.getTotalSupply();
        this.contract = tokenInfo.getContractAddr();
        this.decimals = tokenInfo.getDecimals();
        this.holderAddr = tokenInfo.getHolderAddr();
        this.transfers = tokenInfo.getTransferCount();
        this.holders = tokenInfo.getHolderCount();
    }
    
    public Double getTotalSupplyUsd() {
        return this.totalSupplyUsd;
    }
    
    public Double getPriceUsd() {
        return this.priceUsd;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getTokenName() {
        return this.tokenName;
    }
    
    public String getTotalSupply() {
        return this.totalSupply;
    }
    
    public String getContract() {
        return this.contract;
    }
    
    public Integer getDecimals() {
        return this.decimals;
    }
    
    public String getHolderAddr() {
        return this.holderAddr;
    }
    
    public Integer getTransfers() {
        return this.transfers;
    }
    
    public Integer getHolders() {
        return this.holders;
    }
    
    public void setTotalSupplyUsd(final Double totalSupplyUsd) {
        this.totalSupplyUsd = totalSupplyUsd;
    }
    
    public void setPriceUsd(final Double priceUsd) {
        this.priceUsd = priceUsd;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setTokenName(final String tokenName) {
        this.tokenName = tokenName;
    }
    
    public void setTotalSupply(final String totalSupply) {
        this.totalSupply = totalSupply;
    }
    
    public void setContract(final String contract) {
        this.contract = contract;
    }
    
    public void setDecimals(final Integer decimals) {
        this.decimals = decimals;
    }
    
    public void setHolderAddr(final String holderAddr) {
        this.holderAddr = holderAddr;
    }
    
    public void setTransfers(final Integer transfers) {
        this.transfers = transfers;
    }
    
    public void setHolders(final Integer holders) {
        this.holders = holders;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenSummary)) {
            return false;
        }
        final TokenSummary other = (TokenSummary)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$totalSupplyUsd = this.getTotalSupplyUsd();
        final Object other$totalSupplyUsd = other.getTotalSupplyUsd();
        Label_0065: {
            if (this$totalSupplyUsd == null) {
                if (other$totalSupplyUsd == null) {
                    break Label_0065;
                }
            }
            else if (this$totalSupplyUsd.equals(other$totalSupplyUsd)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$priceUsd = this.getPriceUsd();
        final Object other$priceUsd = other.getPriceUsd();
        Label_0102: {
            if (this$priceUsd == null) {
                if (other$priceUsd == null) {
                    break Label_0102;
                }
            }
            else if (this$priceUsd.equals(other$priceUsd)) {
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
        final Object this$tokenName = this.getTokenName();
        final Object other$tokenName = other.getTokenName();
        Label_0176: {
            if (this$tokenName == null) {
                if (other$tokenName == null) {
                    break Label_0176;
                }
            }
            else if (this$tokenName.equals(other$tokenName)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$totalSupply = this.getTotalSupply();
        final Object other$totalSupply = other.getTotalSupply();
        Label_0213: {
            if (this$totalSupply == null) {
                if (other$totalSupply == null) {
                    break Label_0213;
                }
            }
            else if (this$totalSupply.equals(other$totalSupply)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$contract = this.getContract();
        final Object other$contract = other.getContract();
        Label_0250: {
            if (this$contract == null) {
                if (other$contract == null) {
                    break Label_0250;
                }
            }
            else if (this$contract.equals(other$contract)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$decimals = this.getDecimals();
        final Object other$decimals = other.getDecimals();
        Label_0287: {
            if (this$decimals == null) {
                if (other$decimals == null) {
                    break Label_0287;
                }
            }
            else if (this$decimals.equals(other$decimals)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$holderAddr = this.getHolderAddr();
        final Object other$holderAddr = other.getHolderAddr();
        Label_0324: {
            if (this$holderAddr == null) {
                if (other$holderAddr == null) {
                    break Label_0324;
                }
            }
            else if (this$holderAddr.equals(other$holderAddr)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$transfers = this.getTransfers();
        final Object other$transfers = other.getTransfers();
        Label_0361: {
            if (this$transfers == null) {
                if (other$transfers == null) {
                    break Label_0361;
                }
            }
            else if (this$transfers.equals(other$transfers)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$holders = this.getHolders();
        final Object other$holders = other.getHolders();
        if (this$holders == null) {
            if (other$holders == null) {
                return true;
            }
        }
        else if (this$holders.equals(other$holders)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenSummary;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $totalSupplyUsd = this.getTotalSupplyUsd();
        result = result * 59 + (($totalSupplyUsd == null) ? 43 : $totalSupplyUsd.hashCode());
        final Object $priceUsd = this.getPriceUsd();
        result = result * 59 + (($priceUsd == null) ? 43 : $priceUsd.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $tokenName = this.getTokenName();
        result = result * 59 + (($tokenName == null) ? 43 : $tokenName.hashCode());
        final Object $totalSupply = this.getTotalSupply();
        result = result * 59 + (($totalSupply == null) ? 43 : $totalSupply.hashCode());
        final Object $contract = this.getContract();
        result = result * 59 + (($contract == null) ? 43 : $contract.hashCode());
        final Object $decimals = this.getDecimals();
        result = result * 59 + (($decimals == null) ? 43 : $decimals.hashCode());
        final Object $holderAddr = this.getHolderAddr();
        result = result * 59 + (($holderAddr == null) ? 43 : $holderAddr.hashCode());
        final Object $transfers = this.getTransfers();
        result = result * 59 + (($transfers == null) ? 43 : $transfers.hashCode());
        final Object $holders = this.getHolders();
        result = result * 59 + (($holders == null) ? 43 : $holders.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenSummary(totalSupplyUsd=" + this.getTotalSupplyUsd() + ", priceUsd=" + this.getPriceUsd() + ", symbol=" + this.getSymbol() + ", tokenName=" + this.getTokenName() + ", totalSupply=" + this.getTotalSupply() + ", contract=" + this.getContract() + ", decimals=" + this.getDecimals() + ", holderAddr=" + this.getHolderAddr() + ", transfers=" + this.getTransfers() + ", holders=" + this.getHolders() + ")";
    }
}
