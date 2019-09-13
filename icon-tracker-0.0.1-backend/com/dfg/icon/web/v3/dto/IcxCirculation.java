// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class IcxCirculation
{
    String icxCirculation;
    
    public String getIcxCirculation() {
        return this.icxCirculation;
    }
    
    public void setIcxCirculation(final String icxCirculation) {
        this.icxCirculation = icxCirculation;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IcxCirculation)) {
            return false;
        }
        final IcxCirculation other = (IcxCirculation)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$icxCirculation = this.getIcxCirculation();
        final Object other$icxCirculation = other.getIcxCirculation();
        if (this$icxCirculation == null) {
            if (other$icxCirculation == null) {
                return true;
            }
        }
        else if (this$icxCirculation.equals(other$icxCirculation)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof IcxCirculation;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $icxCirculation = this.getIcxCirculation();
        result = result * 59 + (($icxCirculation == null) ? 43 : $icxCirculation.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "IcxCirculation(icxCirculation=" + this.getIcxCirculation() + ")";
    }
}
