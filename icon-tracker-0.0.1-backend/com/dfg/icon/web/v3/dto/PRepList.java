// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class PRepList
{
    String address;
    String repName;
    int blockCount;
    
    public String getAddress() {
        return this.address;
    }
    
    public String getRepName() {
        return this.repName;
    }
    
    public int getBlockCount() {
        return this.blockCount;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setRepName(final String repName) {
        this.repName = repName;
    }
    
    public void setBlockCount(final int blockCount) {
        this.blockCount = blockCount;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PRepList)) {
            return false;
        }
        final PRepList other = (PRepList)o;
        if (!other.canEqual(this)) {
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
        final Object this$repName = this.getRepName();
        final Object other$repName = other.getRepName();
        if (this$repName == null) {
            if (other$repName == null) {
                return this.getBlockCount() == other.getBlockCount();
            }
        }
        else if (this$repName.equals(other$repName)) {
            return this.getBlockCount() == other.getBlockCount();
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof PRepList;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $repName = this.getRepName();
        result = result * 59 + (($repName == null) ? 43 : $repName.hashCode());
        result = result * 59 + this.getBlockCount();
        return result;
    }
    
    @Override
    public String toString() {
        return "PRepList(address=" + this.getAddress() + ", repName=" + this.getRepName() + ", blockCount=" + this.getBlockCount() + ")";
    }
}
