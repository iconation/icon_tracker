// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.dao.icon.TTokenTx;
import java.util.Date;

public class TokenTransfer
{
    String txHash;
    String symbol;
    Integer height;
    Date age;
    String fromAddr;
    String toAddr;
    String quantity;
    String fee;
    
    public void setTokenTransfer(final TTokenTx tokenTx) {
        this.txHash = tokenTx.getTxHash();
        this.height = tokenTx.getBlockHeight();
        this.age = tokenTx.getAge();
        this.fromAddr = tokenTx.getFromAddr();
        this.toAddr = tokenTx.getToAddr();
        this.quantity = HexUtil.decimalPlusDecimal(String.valueOf(tokenTx.getQuantity()), "0", Integer.valueOf(18));
        this.fee = tokenTx.getFee();
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getSymbol() {
        return this.symbol;
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
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
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
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenTransfer)) {
            return false;
        }
        final TokenTransfer other = (TokenTransfer)o;
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
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        Label_0176: {
            if (this$age == null) {
                if (other$age == null) {
                    break Label_0176;
                }
            }
            else if (this$age.equals(other$age)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0213: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0213;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0250: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0250;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        Label_0287: {
            if (this$quantity == null) {
                if (other$quantity == null) {
                    break Label_0287;
                }
            }
            else if (this$quantity.equals(other$quantity)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$fee = this.getFee();
        final Object other$fee = other.getFee();
        if (this$fee == null) {
            if (other$fee == null) {
                return true;
            }
        }
        else if (this$fee.equals(other$fee)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenTransfer;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
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
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenTransfer(txHash=" + this.getTxHash() + ", symbol=" + this.getSymbol() + ", height=" + this.getHeight() + ", age=" + this.getAge() + ", fromAddr=" + this.getFromAddr() + ", toAddr=" + this.getToAddr() + ", quantity=" + this.getQuantity() + ", fee=" + this.getFee() + ")";
    }
}
