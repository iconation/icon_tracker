// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class TokenAddress
{
    String contractAddr;
    String contractName;
    String contractSymbol;
    String quantity;
    String unit;
    String totalTokenPrice;
    String oneTokenPrice;
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public String getContractName() {
        return this.contractName;
    }
    
    public String getContractSymbol() {
        return this.contractSymbol;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public String getUnit() {
        return this.unit;
    }
    
    public String getTotalTokenPrice() {
        return this.totalTokenPrice;
    }
    
    public String getOneTokenPrice() {
        return this.oneTokenPrice;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setContractName(final String contractName) {
        this.contractName = contractName;
    }
    
    public void setContractSymbol(final String contractSymbol) {
        this.contractSymbol = contractSymbol;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }
    
    public void setUnit(final String unit) {
        this.unit = unit;
    }
    
    public void setTotalTokenPrice(final String totalTokenPrice) {
        this.totalTokenPrice = totalTokenPrice;
    }
    
    public void setOneTokenPrice(final String oneTokenPrice) {
        this.oneTokenPrice = oneTokenPrice;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenAddress)) {
            return false;
        }
        final TokenAddress other = (TokenAddress)o;
        if (!other.canEqual((Object)this)) {
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
        final Object this$contractName = this.getContractName();
        final Object other$contractName = other.getContractName();
        Label_0102: {
            if (this$contractName == null) {
                if (other$contractName == null) {
                    break Label_0102;
                }
            }
            else if (this$contractName.equals(other$contractName)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$contractSymbol = this.getContractSymbol();
        final Object other$contractSymbol = other.getContractSymbol();
        Label_0139: {
            if (this$contractSymbol == null) {
                if (other$contractSymbol == null) {
                    break Label_0139;
                }
            }
            else if (this$contractSymbol.equals(other$contractSymbol)) {
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
        final Object this$unit = this.getUnit();
        final Object other$unit = other.getUnit();
        Label_0213: {
            if (this$unit == null) {
                if (other$unit == null) {
                    break Label_0213;
                }
            }
            else if (this$unit.equals(other$unit)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$totalTokenPrice = this.getTotalTokenPrice();
        final Object other$totalTokenPrice = other.getTotalTokenPrice();
        Label_0250: {
            if (this$totalTokenPrice == null) {
                if (other$totalTokenPrice == null) {
                    break Label_0250;
                }
            }
            else if (this$totalTokenPrice.equals(other$totalTokenPrice)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$oneTokenPrice = this.getOneTokenPrice();
        final Object other$oneTokenPrice = other.getOneTokenPrice();
        if (this$oneTokenPrice == null) {
            if (other$oneTokenPrice == null) {
                return true;
            }
        }
        else if (this$oneTokenPrice.equals(other$oneTokenPrice)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenAddress;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $contractName = this.getContractName();
        result = result * 59 + (($contractName == null) ? 43 : $contractName.hashCode());
        final Object $contractSymbol = this.getContractSymbol();
        result = result * 59 + (($contractSymbol == null) ? 43 : $contractSymbol.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * 59 + (($quantity == null) ? 43 : $quantity.hashCode());
        final Object $unit = this.getUnit();
        result = result * 59 + (($unit == null) ? 43 : $unit.hashCode());
        final Object $totalTokenPrice = this.getTotalTokenPrice();
        result = result * 59 + (($totalTokenPrice == null) ? 43 : $totalTokenPrice.hashCode());
        final Object $oneTokenPrice = this.getOneTokenPrice();
        result = result * 59 + (($oneTokenPrice == null) ? 43 : $oneTokenPrice.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenAddress(contractAddr=" + this.getContractAddr() + ", contractName=" + this.getContractName() + ", contractSymbol=" + this.getContractSymbol() + ", quantity=" + this.getQuantity() + ", unit=" + this.getUnit() + ", totalTokenPrice=" + this.getTotalTokenPrice() + ", oneTokenPrice=" + this.getOneTokenPrice() + ")";
    }
}
