// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamIcxCallDataVo
{
    @JsonProperty("method")
    String method;
    @JsonProperty("params")
    Object params;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public Object getParams() {
        return this.params;
    }
    
    public void setMethod(final String method) {
        this.method = method;
    }
    
    public void setParams(final Object params) {
        this.params = params;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamIcxCallDataVo)) {
            return false;
        }
        final ParamIcxCallDataVo other = (ParamIcxCallDataVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$method = this.getMethod();
        final Object other$method = other.getMethod();
        Label_0065: {
            if (this$method == null) {
                if (other$method == null) {
                    break Label_0065;
                }
            }
            else if (this$method.equals(other$method)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$params = this.getParams();
        final Object other$params = other.getParams();
        if (this$params == null) {
            if (other$params == null) {
                return true;
            }
        }
        else if (this$params.equals(other$params)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamIcxCallDataVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $method = this.getMethod();
        result = result * 59 + (($method == null) ? 43 : $method.hashCode());
        final Object $params = this.getParams();
        result = result * 59 + (($params == null) ? 43 : $params.hashCode());
        return result;
    }
}
