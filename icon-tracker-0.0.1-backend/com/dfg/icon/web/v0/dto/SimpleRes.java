// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import com.dfg.icon.core.exception.IconCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SimpleRes
{
    String result;
    String description;
    Object data;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public void setCode(final IconCode code) {
        this.result = code.getCode();
        this.description = code.getMessage();
    }
    
    public void setError() {
        this.result = IconCode.ERROR.getCode();
        this.description = IconCode.ERROR.getMessage();
        this.data = null;
    }
    
    public String getResult() {
        return this.result;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Object getData() {
        return this.data;
    }
    
    public void setResult(final String result) {
        this.result = result;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public void setData(final Object data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SimpleRes)) {
            return false;
        }
        final SimpleRes other = (SimpleRes)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        Label_0065: {
            if (this$result == null) {
                if (other$result == null) {
                    break Label_0065;
                }
            }
            else if (this$result.equals(other$result)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        Label_0102: {
            if (this$description == null) {
                if (other$description == null) {
                    break Label_0102;
                }
            }
            else if (this$description.equals(other$description)) {
                break Label_0102;
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
        return other instanceof SimpleRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $result = this.getResult();
        result = result * 59 + (($result == null) ? 43 : $result.hashCode());
        final Object $description = this.getDescription();
        result = result * 59 + (($description == null) ? 43 : $description.hashCode());
        final Object $data = this.getData();
        result = result * 59 + (($data == null) ? 43 : $data.hashCode());
        return result;
    }
}
