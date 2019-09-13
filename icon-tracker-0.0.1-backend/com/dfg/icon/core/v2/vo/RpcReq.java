// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RpcReq
{
    @JsonProperty("jsonprc")
    String jsonrpc;
    @JsonProperty("method")
    String method;
    @JsonProperty("id")
    Integer id;
    @JsonProperty("params")
    ParamsVo params;
    
    public RpcReq() {
        this.jsonrpc = "2.0";
    }
    
    public void setMethodLastBlock() {
        this.method = "icx_getLastBlock";
        this.id = 1234;
        this.params = new ParamsVo();
    }
    
    public void setMethodGetBlockByHeight(final Integer height) {
        this.method = "icx_getBlockByHeight";
        this.id = 1234;
        final ParamsVo vo = new ParamsVo();
        vo.setHeight(height);
        this.params = vo;
    }
    
    public void setMethodGetGenesisBlock() {
        this.method = "icx_getBlockByHeight";
        final ParamsVo vo = new ParamsVo();
        vo.setHeight(0);
        this.id = 1234;
        this.params = vo;
    }
    
    public void setMethodGetTransactionResult(final String txHash) {
        this.method = "icx_getTransactionResult";
        final ParamsVo vo = new ParamsVo();
        vo.setTxHash(txHash);
        this.id = 1234;
        this.params = vo;
    }
    
    public void setMethodGetBalance(final String address) {
        this.method = "icx_getBalance";
        this.id = 1234;
        final ParamsVo vo = new ParamsVo();
        vo.setAddress(address);
        this.params = vo;
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
    
    public ParamsVo getParams() {
        return this.params;
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
    
    public void setParams(final ParamsVo params) {
        this.params = params;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RpcReq)) {
            return false;
        }
        final RpcReq other = (RpcReq)o;
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
        return other instanceof RpcReq;
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
        final Object $params = this.getParams();
        result = result * 59 + (($params == null) ? 43 : $params.hashCode());
        return result;
    }
}
