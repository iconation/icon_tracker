// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IrcParamVo
{
    @JsonProperty("type")
    String type;
    @JsonProperty("name")
    String name;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IrcParamVo)) {
            return false;
        }
        final IrcParamVo other = (IrcParamVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        Label_0065: {
            if (this$type == null) {
                if (other$type == null) {
                    break Label_0065;
                }
            }
            else if (this$type.equals(other$type)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null) {
            if (other$name == null) {
                return true;
            }
        }
        else if (this$name.equals(other$name)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof IrcParamVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $type = this.getType();
        result = result * 59 + (($type == null) ? 43 : $type.hashCode());
        final Object $name = this.getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        return result;
    }
}
