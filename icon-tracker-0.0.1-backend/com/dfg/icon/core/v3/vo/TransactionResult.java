// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TransactionResult
{
    String jsonrpc;
    Integer id;
    TxResult result;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getJsonrpc() {
        return this.jsonrpc;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public TxResult getResult() {
        return this.result;
    }
    
    public void setJsonrpc(final String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public void setResult(final TxResult result) {
        this.result = result;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TransactionResult)) {
            return false;
        }
        final TransactionResult other = (TransactionResult)o;
        if (!other.canEqual(this)) {
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
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        Label_0102: {
            if (this$id == null) {
                if (other$id == null) {
                    break Label_0102;
                }
            }
            else if (this$id.equals(other$id)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        if (this$result == null) {
            if (other$result == null) {
                return true;
            }
        }
        else if (this$result.equals(other$result)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TransactionResult;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $jsonrpc = this.getJsonrpc();
        result = result * 59 + (($jsonrpc == null) ? 43 : $jsonrpc.hashCode());
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $result = this.getResult();
        result = result * 59 + (($result == null) ? 43 : $result.hashCode());
        return result;
    }
}
