// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ParamsOwnerVo
{
    String _owner;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String get_owner() {
        return this._owner;
    }
    
    public void set_owner(final String _owner) {
        this._owner = _owner;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamsOwnerVo)) {
            return false;
        }
        final ParamsOwnerVo other = (ParamsOwnerVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$_owner = this.get_owner();
        final Object other$_owner = other.get_owner();
        if (this$_owner == null) {
            if (other$_owner == null) {
                return true;
            }
        }
        else if (this$_owner.equals(other$_owner)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamsOwnerVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $_owner = this.get_owner();
        result = result * 59 + (($_owner == null) ? 43 : $_owner.hashCode());
        return result;
    }
}
