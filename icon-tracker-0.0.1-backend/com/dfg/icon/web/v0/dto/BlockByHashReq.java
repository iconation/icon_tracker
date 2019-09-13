// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BlockByHashReq
{
    String hash;
    Integer page;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public Integer getPage() {
        return this.page;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockByHashReq)) {
            return false;
        }
        final BlockByHashReq other = (BlockByHashReq)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$hash = this.getHash();
        final Object other$hash = other.getHash();
        Label_0065: {
            if (this$hash == null) {
                if (other$hash == null) {
                    break Label_0065;
                }
            }
            else if (this$hash.equals(other$hash)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$page = this.getPage();
        final Object other$page = other.getPage();
        if (this$page == null) {
            if (other$page == null) {
                return true;
            }
        }
        else if (this$page.equals(other$page)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof BlockByHashReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $hash = this.getHash();
        result = result * 59 + (($hash == null) ? 43 : $hash.hashCode());
        final Object $page = this.getPage();
        result = result * 59 + (($page == null) ? 43 : $page.hashCode());
        return result;
    }
}
