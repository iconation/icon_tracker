// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IcxSupplyVo
{
    String node;
    String balance;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getNode() {
        return this.node;
    }
    
    public String getBalance() {
        return this.balance;
    }
    
    public void setNode(final String node) {
        this.node = node;
    }
    
    public void setBalance(final String balance) {
        this.balance = balance;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IcxSupplyVo)) {
            return false;
        }
        final IcxSupplyVo other = (IcxSupplyVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$node = this.getNode();
        final Object other$node = other.getNode();
        Label_0065: {
            if (this$node == null) {
                if (other$node == null) {
                    break Label_0065;
                }
            }
            else if (this$node.equals(other$node)) {
                break Label_0065;
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
        return other instanceof IcxSupplyVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $node = this.getNode();
        result = result * 59 + (($node == null) ? 43 : $node.hashCode());
        final Object $balance = this.getBalance();
        result = result * 59 + (($balance == null) ? 43 : $balance.hashCode());
        return result;
    }
}
