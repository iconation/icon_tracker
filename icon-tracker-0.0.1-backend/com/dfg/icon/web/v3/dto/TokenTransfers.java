// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import com.dfg.icon.core.dao.icon.TTokenTx;
import java.util.Date;

public class TokenTransfers
{
    String contractAddr;
    String symbol;
    String txHash;
    Integer height;
    Date age;
    String fromAddr;
    String toAddr;
    String quantity;
    String fee;
    String txType;
    Integer state;
    String tokenName;
    String targetContractAddr;
    
    public void setTokenTransfer(final TTokenTx tokenTx) {
        this.contractAddr = tokenTx.getContractAddr();
        this.txHash = tokenTx.getTxHash();
        this.height = tokenTx.getBlockHeight();
        this.age = tokenTx.getAge();
        this.fromAddr = tokenTx.getFromAddr();
        this.toAddr = tokenTx.getToAddr();
        this.quantity = tokenTx.getQuantity();
        this.fee = tokenTx.getFee();
        this.state = tokenTx.getState();
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public Date getAge() {
        return this.age;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public String getFee() {
        return this.fee;
    }
    
    public String getTxType() {
        return this.txType;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public String getTokenName() {
        return this.tokenName;
    }
    
    public String getTargetContractAddr() {
        return this.targetContractAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setAge(final Date age) {
        this.age = age;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = toAddr;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }
    
    public void setFee(final String fee) {
        this.fee = fee;
    }
    
    public void setTxType(final String txType) {
        this.txType = txType;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public void setTokenName(final String tokenName) {
        this.tokenName = tokenName;
    }
    
    public void setTargetContractAddr(final String targetContractAddr) {
        this.targetContractAddr = targetContractAddr;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenTransfers)) {
            return false;
        }
        final TokenTransfers other = (TokenTransfers)o;
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
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0176: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0176;
                }
            }
            else if (this$height.equals(other$height)) {
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
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0250: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0250;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0287: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0287;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        Label_0324: {
            if (this$quantity == null) {
                if (other$quantity == null) {
                    break Label_0324;
                }
            }
            else if (this$quantity.equals(other$quantity)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        Label_0361: {
            if (this$fee == null) {
                if (other$fee == null) {
                    break Label_0361;
                }
            }
            else if (this$fee.equals(other$fee)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$txType = this.getTxType();
        final Object other$txType = other.getTxType();
        Label_0398: {
            if (this$txType == null) {
                if (other$txType == null) {
                    break Label_0398;
                }
            }
            else if (this$txType.equals(other$txType)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        Label_0435: {
            if (this$state == null) {
                if (other$state == null) {
                    break Label_0435;
                }
            }
            else if (this$state.equals(other$state)) {
                break Label_0435;
            }
            return false;
        }
        final Object this$tokenName = this.getTokenName();
        final Object other$tokenName = other.getTokenName();
        Label_0472: {
            if (this$tokenName == null) {
                if (other$tokenName == null) {
                    break Label_0472;
                }
            }
            else if (this$tokenName.equals(other$tokenName)) {
                break Label_0472;
            }
            return false;
        }
        final Object this$targetContractAddr = this.getTargetContractAddr();
        final Object other$targetContractAddr = other.getTargetContractAddr();
        if (this$targetContractAddr == null) {
            if (other$targetContractAddr == null) {
                return true;
            }
        }
        else if (this$targetContractAddr.equals(other$targetContractAddr)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenTransfers;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $age = this.getAge();
        result = result * 59 + (($age == null) ? 43 : $age.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * 59 + (($quantity == null) ? 43 : $quantity.hashCode());
        final Object $fee = this.getFee();
        result = result * 59 + (($fee == null) ? 43 : $fee.hashCode());
        final Object $txType = this.getTxType();
        result = result * 59 + (($txType == null) ? 43 : $txType.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        final Object $tokenName = this.getTokenName();
        result = result * 59 + (($tokenName == null) ? 43 : $tokenName.hashCode());
        final Object $targetContractAddr = this.getTargetContractAddr();
        result = result * 59 + (($targetContractAddr == null) ? 43 : $targetContractAddr.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenTransfers(contractAddr=" + this.getContractAddr() + ", symbol=" + this.getSymbol() + ", txHash=" + this.getTxHash() + ", height=" + this.getHeight() + ", age=" + this.getAge() + ", fromAddr=" + this.getFromAddr() + ", toAddr=" + this.getToAddr() + ", quantity=" + this.getQuantity() + ", fee=" + this.getFee() + ", txType=" + this.getTxType() + ", state=" + this.getState() + ", tokenName=" + this.getTokenName() + ", targetContractAddr=" + this.getTargetContractAddr() + ")";
    }
}
