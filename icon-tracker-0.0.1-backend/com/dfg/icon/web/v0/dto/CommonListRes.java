// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import com.dfg.icon.core.exception.IconCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommonListRes
{
    Object data;
    int listSize;
    String result;
    String description;
    
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
    
    public Object getData() {
        return this.data;
    }
    
    public int getListSize() {
        return this.listSize;
    }
    
    public String getResult() {
        return this.result;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setData(final Object data) {
        this.data = data;
    }
    
    public void setListSize(final int listSize) {
        this.listSize = listSize;
    }
    
    public void setResult(final String result) {
        this.result = result;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CommonListRes)) {
            return false;
        }
        final CommonListRes other = (CommonListRes)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        Label_0065: {
            if (this$data == null) {
                if (other$data == null) {
                    break Label_0065;
                }
            }
            else if (this$data.equals(other$data)) {
                break Label_0065;
            }
            return false;
        }
        if (this.getListSize() != other.getListSize()) {
            return false;
        }
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        Label_0115: {
            if (this$result == null) {
                if (other$result == null) {
                    break Label_0115;
                }
            }
            else if (this$result.equals(other$result)) {
                break Label_0115;
            }
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null) {
            if (other$description == null) {
                return true;
            }
        }
        else if (this$description.equals(other$description)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof CommonListRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $data = this.getData();
        result = result * 59 + (($data == null) ? 43 : $data.hashCode());
        result = result * 59 + this.getListSize();
        final Object $result = this.getResult();
        result = result * 59 + (($result == null) ? 43 : $result.hashCode());
        final Object $description = this.getDescription();
        result = result * 59 + (($description == null) ? 43 : $description.hashCode());
        return result;
    }
}
