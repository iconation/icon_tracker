// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import com.dfg.icon.core.exception.IconCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommonRes
{
    String result;
    String description;
    String totalData;
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
        this.totalData = null;
        this.data = null;
    }
    
    public String getResult() {
        return this.result;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getTotalData() {
        return this.totalData;
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
    
    public void setTotalData(final String totalData) {
        this.totalData = totalData;
    }
    
    public void setData(final Object data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CommonRes)) {
            return false;
        }
        final CommonRes other = (CommonRes)o;
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
        final Object this$totalData = this.getTotalData();
        final Object other$totalData = other.getTotalData();
        Label_0139: {
            if (this$totalData == null) {
                if (other$totalData == null) {
                    break Label_0139;
                }
            }
            else if (this$totalData.equals(other$totalData)) {
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
        return other instanceof CommonRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $result = this.getResult();
        result = result * 59 + (($result == null) ? 43 : $result.hashCode());
        final Object $description = this.getDescription();
        result = result * 59 + (($description == null) ? 43 : $description.hashCode());
        final Object $totalData = this.getTotalData();
        result = result * 59 + (($totalData == null) ? 43 : $totalData.hashCode());
        final Object $data = this.getData();
        result = result * 59 + (($data == null) ? 43 : $data.hashCode());
        return result;
    }
}
