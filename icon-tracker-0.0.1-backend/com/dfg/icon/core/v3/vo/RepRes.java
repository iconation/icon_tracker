// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RepRes
{
    String jsonrcp;
    RepResult result;
    Integer id;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getJsonrcp() {
        return this.jsonrcp;
    }
    
    public RepResult getResult() {
        return this.result;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setJsonrcp(final String jsonrcp) {
        this.jsonrcp = jsonrcp;
    }
    
    public void setResult(final RepResult result) {
        this.result = result;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RepRes)) {
            return false;
        }
        final RepRes other = (RepRes)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$jsonrcp = this.getJsonrcp();
        final Object other$jsonrcp = other.getJsonrcp();
        Label_0065: {
            if (this$jsonrcp == null) {
                if (other$jsonrcp == null) {
                    break Label_0065;
                }
            }
            else if (this$jsonrcp.equals(other$jsonrcp)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        Label_0102: {
            if (this$result == null) {
                if (other$result == null) {
                    break Label_0102;
                }
            }
            else if (this$result.equals(other$result)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null) {
            if (other$id == null) {
                return true;
            }
        }
        else if (this$id.equals(other$id)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof RepRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $jsonrcp = this.getJsonrcp();
        result = result * 59 + (($jsonrcp == null) ? 43 : $jsonrcp.hashCode());
        final Object $result = this.getResult();
        result = result * 59 + (($result == null) ? 43 : $result.hashCode());
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        return result;
    }
}
