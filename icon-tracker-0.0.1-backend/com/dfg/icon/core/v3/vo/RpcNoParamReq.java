// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RpcNoParamReq
{
    @JsonProperty("jsonprc")
    String jsonrpc;
    @JsonProperty("method")
    String method;
    @JsonProperty("id")
    Integer id;
    
    public RpcNoParamReq() {
        this.jsonrpc = "2.0";
        this.id = 1234;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getJsonrpc() {
        return this.jsonrpc;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setJsonrpc(final String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
    
    public void setMethod(final String method) {
        this.method = method;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RpcNoParamReq)) {
            return false;
        }
        final RpcNoParamReq other = (RpcNoParamReq)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$jsonrpc = this.getJsonrpc();
        final Object other$jsonrpc = other.getJsonrpc();
        Label_0065: {
            if (this$jsonrpc == null) {
                if (other$jsonrpc == null) {
                    break Label_0065;
                }
            }
            else if (this$jsonrpc.equals(other$jsonrpc)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$method = this.getMethod();
        final Object other$method = other.getMethod();
        Label_0102: {
            if (this$method == null) {
                if (other$method == null) {
                    break Label_0102;
                }
            }
            else if (this$method.equals(other$method)) {
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
        return other instanceof RpcNoParamReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $jsonrpc = this.getJsonrpc();
        result = result * 59 + (($jsonrpc == null) ? 43 : $jsonrpc.hashCode());
        final Object $method = this.getMethod();
        result = result * 59 + (($method == null) ? 43 : $method.hashCode());
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        return result;
    }
}
