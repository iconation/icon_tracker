// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public class TxCount
{
    String address;
    String cnt;
    
    public String getAddress() {
        return this.address;
    }
    
    public String getCnt() {
        return this.cnt;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setCnt(final String cnt) {
        this.cnt = cnt;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TxCount)) {
            return false;
        }
        final TxCount other = (TxCount)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0065: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0065;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$cnt = this.getCnt();
        final Object other$cnt = other.getCnt();
        if (this$cnt == null) {
            if (other$cnt == null) {
                return true;
            }
        }
        else if (this$cnt.equals(other$cnt)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TxCount;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $cnt = this.getCnt();
        result = result * 59 + (($cnt == null) ? 43 : $cnt.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TxCount(address=" + this.getAddress() + ", cnt=" + this.getCnt() + ")";
    }
}
