// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import java.util.Date;

public class ContractTx
{
    String txHash;
    String name;
    String symbol;
    String fromAddr;
    String toAddr;
    String tradeTokenAddr;
    String quantity;
    Date age;
    int state;
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public String getTradeTokenAddr() {
        return this.tradeTokenAddr;
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public Date getAge() {
        return this.age;
    }
    
    public int getState() {
        return this.state;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = toAddr;
    }
    
    public void setTradeTokenAddr(final String tradeTokenAddr) {
        this.tradeTokenAddr = tradeTokenAddr;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }
    
    public void setAge(final Date age) {
        this.age = age;
    }
    
    public void setState(final int state) {
        this.state = state;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContractTx)) {
            return false;
        }
        final ContractTx other = (ContractTx)o;
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
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0176: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0176;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0213: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0213;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$tradeTokenAddr = this.getTradeTokenAddr();
        final Object other$tradeTokenAddr = other.getTradeTokenAddr();
        Label_0250: {
            if (this$tradeTokenAddr == null) {
                if (other$tradeTokenAddr == null) {
                    break Label_0250;
                }
            }
            else if (this$tradeTokenAddr.equals(other$tradeTokenAddr)) {
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
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null) {
            if (other$age == null) {
                return this.getState() == other.getState();
            }
        }
        else if (this$age.equals(other$age)) {
            return this.getState() == other.getState();
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ContractTx;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $name = this.getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $tradeTokenAddr = this.getTradeTokenAddr();
        result = result * 59 + (($tradeTokenAddr == null) ? 43 : $tradeTokenAddr.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * 59 + (($quantity == null) ? 43 : $quantity.hashCode());
        final Object $age = this.getAge();
        result = result * 59 + (($age == null) ? 43 : $age.hashCode());
        result = result * 59 + this.getState();
        return result;
    }
    
    @Override
    public String toString() {
        return "ContractTx(txHash=" + this.getTxHash() + ", name=" + this.getName() + ", symbol=" + this.getSymbol() + ", fromAddr=" + this.getFromAddr() + ", toAddr=" + this.getToAddr() + ", tradeTokenAddr=" + this.getTradeTokenAddr() + ", quantity=" + this.getQuantity() + ", age=" + this.getAge() + ", state=" + this.getState() + ")";
    }
}
