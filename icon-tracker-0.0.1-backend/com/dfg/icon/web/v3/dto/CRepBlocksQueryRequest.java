// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

public class CRepBlocksQueryRequest
{
    String cRepAddress;
    Integer page;
    Integer count;
    
    public CRepBlocksQueryRequest(final String cRepAddress, final Integer page, final Integer count) {
        this.cRepAddress = cRepAddress;
        this.page = page;
        this.count = count;
    }
    
    public String getCRepAddress() {
        return this.cRepAddress;
    }
    
    public Integer getPage() {
        return this.page;
    }
    
    public Integer getCount() {
        return this.count;
    }
    
    public void setCRepAddress(final String cRepAddress) {
        this.cRepAddress = cRepAddress;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    public void setCount(final Integer count) {
        this.count = count;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CRepBlocksQueryRequest)) {
            return false;
        }
        final CRepBlocksQueryRequest other = (CRepBlocksQueryRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$cRepAddress = this.getCRepAddress();
        final Object other$cRepAddress = other.getCRepAddress();
        Label_0065: {
            if (this$cRepAddress == null) {
                if (other$cRepAddress == null) {
                    break Label_0065;
                }
            }
            else if (this$cRepAddress.equals(other$cRepAddress)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$page = this.getPage();
        final Object other$page = other.getPage();
        Label_0102: {
            if (this$page == null) {
                if (other$page == null) {
                    break Label_0102;
                }
            }
            else if (this$page.equals(other$page)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$count = this.getCount();
        final Object other$count = other.getCount();
        if (this$count == null) {
            if (other$count == null) {
                return true;
            }
        }
        else if (this$count.equals(other$count)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof CRepBlocksQueryRequest;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $cRepAddress = this.getCRepAddress();
        result = result * 59 + (($cRepAddress == null) ? 43 : $cRepAddress.hashCode());
        final Object $page = this.getPage();
        result = result * 59 + (($page == null) ? 43 : $page.hashCode());
        final Object $count = this.getCount();
        result = result * 59 + (($count == null) ? 43 : $count.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "CRepBlocksQueryRequest(cRepAddress=" + this.getCRepAddress() + ", page=" + this.getPage() + ", count=" + this.getCount() + ")";
    }
}
