// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamIcxCallVo
{
    @JsonProperty("from")
    String from;
    @JsonProperty("to")
    String to;
    @JsonProperty("dataType")
    String dataType;
    @JsonProperty("data")
    Object data;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getFrom() {
        return this.from;
    }
    
    public String getTo() {
        return this.to;
    }
    
    public String getDataType() {
        return this.dataType;
    }
    
    public Object getData() {
        return this.data;
    }
    
    public void setFrom(final String from) {
        this.from = from;
    }
    
    public void setTo(final String to) {
        this.to = to;
    }
    
    public void setDataType(final String dataType) {
        this.dataType = dataType;
    }
    
    public void setData(final Object data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ParamIcxCallVo)) {
            return false;
        }
        final ParamIcxCallVo other = (ParamIcxCallVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$from = this.getFrom();
        final Object other$from = other.getFrom();
        Label_0065: {
            if (this$from == null) {
                if (other$from == null) {
                    break Label_0065;
                }
            }
            else if (this$from.equals(other$from)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$to = this.getTo();
        final Object other$to = other.getTo();
        Label_0102: {
            if (this$to == null) {
                if (other$to == null) {
                    break Label_0102;
                }
            }
            else if (this$to.equals(other$to)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$dataType = this.getDataType();
        final Object other$dataType = other.getDataType();
        Label_0139: {
            if (this$dataType == null) {
                if (other$dataType == null) {
                    break Label_0139;
                }
            }
            else if (this$dataType.equals(other$dataType)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null) {
            if (other$data == null) {
                return true;
            }
        }
        else if (this$data.equals(other$data)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ParamIcxCallVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $from = this.getFrom();
        result = result * 59 + (($from == null) ? 43 : $from.hashCode());
        final Object $to = this.getTo();
        result = result * 59 + (($to == null) ? 43 : $to.hashCode());
        final Object $dataType = this.getDataType();
        result = result * 59 + (($dataType == null) ? 43 : $dataType.hashCode());
        final Object $data = this.getData();
        result = result * 59 + (($data == null) ? 43 : $data.hashCode());
        return result;
    }
}
