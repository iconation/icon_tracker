// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IrcVo
{
    @JsonProperty("type")
    String type;
    @JsonProperty("name")
    String name;
    @JsonProperty("readonly")
    String readonly;
    @JsonProperty("inputs")
    List<IrcParamVo> inputs;
    @JsonProperty("outputs")
    List<IrcParamVo> outputs;
    
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
    
    public String getReadonly() {
        return this.readonly;
    }
    
    public List<IrcParamVo> getInputs() {
        return this.inputs;
    }
    
    public List<IrcParamVo> getOutputs() {
        return this.outputs;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setReadonly(final String readonly) {
        this.readonly = readonly;
    }
    
    public void setInputs(final List<IrcParamVo> inputs) {
        this.inputs = inputs;
    }
    
    public void setOutputs(final List<IrcParamVo> outputs) {
        this.outputs = outputs;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IrcVo)) {
            return false;
        }
        final IrcVo other = (IrcVo)o;
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
        Label_0102: {
            if (this$name == null) {
                if (other$name == null) {
                    break Label_0102;
                }
            }
            else if (this$name.equals(other$name)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$readonly = this.getReadonly();
        final Object other$readonly = other.getReadonly();
        Label_0139: {
            if (this$readonly == null) {
                if (other$readonly == null) {
                    break Label_0139;
                }
            }
            else if (this$readonly.equals(other$readonly)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$inputs = this.getInputs();
        final Object other$inputs = other.getInputs();
        Label_0176: {
            if (this$inputs == null) {
                if (other$inputs == null) {
                    break Label_0176;
                }
            }
            else if (this$inputs.equals(other$inputs)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$outputs = this.getOutputs();
        final Object other$outputs = other.getOutputs();
        if (this$outputs == null) {
            if (other$outputs == null) {
                return true;
            }
        }
        else if (this$outputs.equals(other$outputs)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof IrcVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $type = this.getType();
        result = result * 59 + (($type == null) ? 43 : $type.hashCode());
        final Object $name = this.getName();
        result = result * 59 + (($name == null) ? 43 : $name.hashCode());
        final Object $readonly = this.getReadonly();
        result = result * 59 + (($readonly == null) ? 43 : $readonly.hashCode());
        final Object $inputs = this.getInputs();
        result = result * 59 + (($inputs == null) ? 43 : $inputs.hashCode());
        final Object $outputs = this.getOutputs();
        result = result * 59 + (($outputs == null) ? 43 : $outputs.hashCode());
        return result;
    }
}
