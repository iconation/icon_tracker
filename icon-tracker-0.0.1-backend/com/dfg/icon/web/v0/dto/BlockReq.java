// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BlockReq
{
    Integer height;
    Integer page;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public Integer getPage() {
        return this.page;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockReq)) {
            return false;
        }
        final BlockReq other = (BlockReq)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        Label_0065: {
            if (this$height == null) {
                if (other$height == null) {
                    break Label_0065;
                }
            }
            else if (this$height.equals(other$height)) {
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
        return other instanceof BlockReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $height = this.getHeight();
        result = result * 59 + (($height == null) ? 43 : $height.hashCode());
        final Object $page = this.getPage();
        result = result * 59 + (($page == null) ? 43 : $page.hashCode());
        return result;
    }
}
