// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RpcRes
{
    @JsonProperty("jsonrpc")
    String jsonRpc;
    @JsonProperty("result")
    RpcResult result;
    @JsonProperty("id")
    Integer id;
    @JsonProperty("error")
    RpcError error;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getJsonRpc() {
        return this.jsonRpc;
    }
    
    public RpcResult getResult() {
        return this.result;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public RpcError getError() {
        return this.error;
    }
    
    public void setJsonRpc(final String jsonRpc) {
        this.jsonRpc = jsonRpc;
    }
    
    public void setResult(final RpcResult result) {
        this.result = result;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public void setError(final RpcError error) {
        this.error = error;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RpcRes)) {
            return false;
        }
        final RpcRes other = (RpcRes)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$jsonRpc = this.getJsonRpc();
        final Object other$jsonRpc = other.getJsonRpc();
        Label_0065: {
            if (this$jsonRpc == null) {
                if (other$jsonRpc == null) {
                    break Label_0065;
                }
            }
            else if (this$jsonRpc.equals(other$jsonRpc)) {
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
        Label_0139: {
            if (this$id == null) {
                if (other$id == null) {
                    break Label_0139;
                }
            }
            else if (this$id.equals(other$id)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$error = this.getError();
        final Object other$error = other.getError();
        if (this$error == null) {
            if (other$error == null) {
                return true;
            }
        }
        else if (this$error.equals(other$error)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof RpcRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $jsonRpc = this.getJsonRpc();
        result = result * 59 + (($jsonRpc == null) ? 43 : $jsonRpc.hashCode());
        final Object $result = this.getResult();
        result = result * 59 + (($result == null) ? 43 : $result.hashCode());
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $error = this.getError();
        result = result * 59 + (($error == null) ? 43 : $error.hashCode());
        return result;
    }
}
