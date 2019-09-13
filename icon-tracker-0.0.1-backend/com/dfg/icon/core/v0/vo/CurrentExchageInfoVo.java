// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.vo;

import com.dfg.icon.core.dao.icon.TCurrentExchange;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentExchageInfoVo
{
    @JsonProperty("result")
    String result;
    @JsonProperty("description")
    String description;
    @JsonProperty("data")
    List<TCurrentExchange> data;
    
    public String getResult() {
        return this.result;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public List<TCurrentExchange> getData() {
        return this.data;
    }
    
    public void setResult(final String result) {
        this.result = result;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public void setData(final List<TCurrentExchange> data) {
        this.data = data;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CurrentExchageInfoVo)) {
            return false;
        }
        final CurrentExchageInfoVo other = (CurrentExchageInfoVo)o;
        if (!other.canEqual(this)) {
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
        return other instanceof CurrentExchageInfoVo;
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
    
    @Override
    public String toString() {
        return "CurrentExchageInfoVo(result=" + this.getResult() + ", description=" + this.getDescription() + ", data=" + this.getData() + ")";
    }
}
