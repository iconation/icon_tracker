// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GenesisTransactionVo
{
    @JsonProperty("accounts")
    List<GenesisAccVo> accounts;
    @JsonProperty("message")
    String message;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public List<GenesisAccVo> getAccounts() {
        return (List<GenesisAccVo>)this.accounts;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setAccounts(final List<GenesisAccVo> accounts) {
        this.accounts = accounts;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GenesisTransactionVo)) {
            return false;
        }
        final GenesisTransactionVo other = (GenesisTransactionVo)o;
        if (!other.canEqual((Object)this)) {
            return false;
        }
        final Object this$accounts = this.getAccounts();
        final Object other$accounts = other.getAccounts();
        Label_0065: {
            if (this$accounts == null) {
                if (other$accounts == null) {
                    break Label_0065;
                }
            }
            else if (this$accounts.equals(other$accounts)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null) {
            if (other$message == null) {
                return true;
            }
        }
        else if (this$message.equals(other$message)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof GenesisTransactionVo;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $accounts = this.getAccounts();
        result = result * 59 + (($accounts == null) ? 43 : $accounts.hashCode());
        final Object $message = this.getMessage();
        result = result * 59 + (($message == null) ? 43 : $message.hashCode());
        return result;
    }
}
