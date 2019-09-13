// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class TokenHolder
{
    String contractAddr;
    String symbol;
    String address;
    String quantity;
    Integer txCount;
    String percentage;
    Integer rank;
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public Integer getTxCount() {
        return this.txCount;
    }
    
    public String getPercentage() {
        return this.percentage;
    }
    
    public Integer getRank() {
        return this.rank;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }
    
    public void setTxCount(final Integer txCount) {
        this.txCount = txCount;
    }
    
    public void setPercentage(final String percentage) {
        this.percentage = percentage;
    }
    
    public void setRank(final Integer rank) {
        this.rank = rank;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenHolder)) {
            return false;
        }
        final TokenHolder other = (TokenHolder)o;
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
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        Label_0102: {
            if (this$symbol == null) {
                if (other$symbol == null) {
                    break Label_0102;
                }
            }
            else if (this$symbol.equals(other$symbol)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0139: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0139;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        Label_0176: {
            if (this$quantity == null) {
                if (other$quantity == null) {
                    break Label_0176;
                }
            }
            else if (this$quantity.equals(other$quantity)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$txCount = this.getTxCount();
        final Object other$txCount = other.getTxCount();
        Label_0213: {
            if (this$txCount == null) {
                if (other$txCount == null) {
                    break Label_0213;
                }
            }
            else if (this$txCount.equals(other$txCount)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$percentage = this.getPercentage();
        final Object other$percentage = other.getPercentage();
        Label_0250: {
            if (this$percentage == null) {
                if (other$percentage == null) {
                    break Label_0250;
                }
            }
            else if (this$percentage.equals(other$percentage)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$rank = this.getRank();
        final Object other$rank = other.getRank();
        if (this$rank == null) {
            if (other$rank == null) {
                return true;
            }
        }
        else if (this$rank.equals(other$rank)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenHolder;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * 59 + (($quantity == null) ? 43 : $quantity.hashCode());
        final Object $txCount = this.getTxCount();
        result = result * 59 + (($txCount == null) ? 43 : $txCount.hashCode());
        final Object $percentage = this.getPercentage();
        result = result * 59 + (($percentage == null) ? 43 : $percentage.hashCode());
        final Object $rank = this.getRank();
        result = result * 59 + (($rank == null) ? 43 : $rank.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenHolder(contractAddr=" + this.getContractAddr() + ", symbol=" + this.getSymbol() + ", address=" + this.getAddress() + ", quantity=" + this.getQuantity() + ", txCount=" + this.getTxCount() + ", percentage=" + this.getPercentage() + ", rank=" + this.getRank() + ")";
    }
}
