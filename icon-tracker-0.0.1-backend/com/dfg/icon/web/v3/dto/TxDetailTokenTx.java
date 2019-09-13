// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TxDetailTokenTx
{
    String quantity;
    String symbol;
    String tokenName;
    String fromAddr;
    String toAddr;
    Integer state;
    String targetContractAddr;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getQuantity() {
        return this.quantity;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public String getTokenName() {
        return this.tokenName;
    }
    
    public String getFromAddr() {
        return this.fromAddr;
    }
    
    public String getToAddr() {
        return this.toAddr;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public String getTargetContractAddr() {
        return this.targetContractAddr;
    }
    
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }
    
    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }
    
    public void setTokenName(final String tokenName) {
        this.tokenName = tokenName;
    }
    
    public void setFromAddr(final String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public void setToAddr(final String toAddr) {
        this.toAddr = toAddr;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public void setTargetContractAddr(final String targetContractAddr) {
        this.targetContractAddr = targetContractAddr;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxDetailTokenTx)) {
            return false;
        }
        final TxDetailTokenTx other = (TxDetailTokenTx)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        Label_0065: {
            if (this$quantity == null) {
                if (other$quantity == null) {
                    break Label_0065;
                }
            }
            else if (this$quantity.equals(other$quantity)) {
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
        final Object this$tokenName = this.getTokenName();
        final Object other$tokenName = other.getTokenName();
        Label_0139: {
            if (this$tokenName == null) {
                if (other$tokenName == null) {
                    break Label_0139;
                }
            }
            else if (this$tokenName.equals(other$tokenName)) {
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
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        Label_0250: {
            if (this$state == null) {
                if (other$state == null) {
                    break Label_0250;
                }
            }
            else if (this$state.equals(other$state)) {
                break Label_0250;
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
        return other instanceof TxDetailTokenTx;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $quantity = this.getQuantity();
        result = result * 59 + (($quantity == null) ? 43 : $quantity.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * 59 + (($symbol == null) ? 43 : $symbol.hashCode());
        final Object $tokenName = this.getTokenName();
        result = result * 59 + (($tokenName == null) ? 43 : $tokenName.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        final Object $targetContractAddr = this.getTargetContractAddr();
        result = result * 59 + (($targetContractAddr == null) ? 43 : $targetContractAddr.hashCode());
        return result;
    }
}
