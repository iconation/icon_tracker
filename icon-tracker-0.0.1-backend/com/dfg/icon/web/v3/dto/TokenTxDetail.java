// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

public class TokenTxDetail
{
    String txHash;
    String contractAddr;
    String contractName;
    String contractSymbol;
    String unit;
    Date createDate;
    String fromAddr;
    String toAddr;
    String quantity;
    String ircVersion;
    Integer state;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public String getContractName() {
        return this.contractName;
    }
    
    public String getContractSymbol() {
        return this.contractSymbol;
    }
    
    public String getUnit() {
        return this.unit;
    }
    
    public Date getCreateDate() {
        return this.createDate;
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
    
    public String getIrcVersion() {
        return this.ircVersion;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
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
    
    public void setUnit(final String unit) {
        this.unit = unit;
    }
    
    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
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
    
    public void setIrcVersion(final String ircVersion) {
        this.ircVersion = ircVersion;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenTxDetail)) {
            return false;
        }
        final TokenTxDetail other = (TokenTxDetail)o;
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
        final Object this$contractName = this.getContractName();
        final Object other$contractName = other.getContractName();
        Label_0139: {
            if (this$contractName == null) {
                if (other$contractName == null) {
                    break Label_0139;
                }
            }
            else if (this$contractName.equals(other$contractName)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$contractSymbol = this.getContractSymbol();
        final Object other$contractSymbol = other.getContractSymbol();
        Label_0176: {
            if (this$contractSymbol == null) {
                if (other$contractSymbol == null) {
                    break Label_0176;
                }
            }
            else if (this$contractSymbol.equals(other$contractSymbol)) {
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
        final Object this$createDate = this.getCreateDate();
        final Object other$createDate = other.getCreateDate();
        Label_0250: {
            if (this$createDate == null) {
                if (other$createDate == null) {
                    break Label_0250;
                }
            }
            else if (this$createDate.equals(other$createDate)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$fromAddr = this.getFromAddr();
        final Object other$fromAddr = other.getFromAddr();
        Label_0287: {
            if (this$fromAddr == null) {
                if (other$fromAddr == null) {
                    break Label_0287;
                }
            }
            else if (this$fromAddr.equals(other$fromAddr)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$toAddr = this.getToAddr();
        final Object other$toAddr = other.getToAddr();
        Label_0324: {
            if (this$toAddr == null) {
                if (other$toAddr == null) {
                    break Label_0324;
                }
            }
            else if (this$toAddr.equals(other$toAddr)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        Label_0361: {
            if (this$quantity == null) {
                if (other$quantity == null) {
                    break Label_0361;
                }
            }
            else if (this$quantity.equals(other$quantity)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$ircVersion = this.getIrcVersion();
        final Object other$ircVersion = other.getIrcVersion();
        Label_0398: {
            if (this$ircVersion == null) {
                if (other$ircVersion == null) {
                    break Label_0398;
                }
            }
            else if (this$ircVersion.equals(other$ircVersion)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$state = this.getState();
        final Object other$state = other.getState();
        if (this$state == null) {
            if (other$state == null) {
                return true;
            }
        }
        else if (this$state.equals(other$state)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenTxDetail;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $txHash = this.getTxHash();
        result = result * 59 + (($txHash == null) ? 43 : $txHash.hashCode());
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $contractName = this.getContractName();
        result = result * 59 + (($contractName == null) ? 43 : $contractName.hashCode());
        final Object $contractSymbol = this.getContractSymbol();
        result = result * 59 + (($contractSymbol == null) ? 43 : $contractSymbol.hashCode());
        final Object $unit = this.getUnit();
        result = result * 59 + (($unit == null) ? 43 : $unit.hashCode());
        final Object $createDate = this.getCreateDate();
        result = result * 59 + (($createDate == null) ? 43 : $createDate.hashCode());
        final Object $fromAddr = this.getFromAddr();
        result = result * 59 + (($fromAddr == null) ? 43 : $fromAddr.hashCode());
        final Object $toAddr = this.getToAddr();
        result = result * 59 + (($toAddr == null) ? 43 : $toAddr.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * 59 + (($quantity == null) ? 43 : $quantity.hashCode());
        final Object $ircVersion = this.getIrcVersion();
        result = result * 59 + (($ircVersion == null) ? 43 : $ircVersion.hashCode());
        final Object $state = this.getState();
        result = result * 59 + (($state == null) ? 43 : $state.hashCode());
        return result;
    }
}
