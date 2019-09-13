// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenesisAccVo
{
    @JsonProperty("name")
    String name;
    @JsonProperty("address")
    String address;
    @JsonProperty("balance")
    String balance;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GenesisAccVo)) {
            return false;
        }
        final GenesisAccVo other = (GenesisAccVo)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        Label_0065: {
            if (this$name == null) {
                if (other$name == null) {
                    break Label_0065;
                }
            }
            else if (this$name.equals(other$name)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0102: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0102;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$balance = this.getBalance();
        final Object other$balance = other.getBalance();
        if (this$balance == null) {
            if (other$balance == null) {
                return true;
            }
        }
        else if (this$balance.equals(other$balance)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof GenesisAccVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        return result;
    }
}
