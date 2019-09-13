// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WalletTxReq
{
    String address;
    String startDate;
    String endDate;
    Integer page;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getStartDate() {
        return this.startDate;
    }
    
    public String getEndDate() {
        return this.endDate;
    }
    
    public Integer getPage() {
        return this.page;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WalletTxReq)) {
            return false;
        }
        final WalletTxReq other = (WalletTxReq)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        Label_0065: {
            if (this$address == null) {
                if (other$address == null) {
                    break Label_0065;
                }
            }
            else if (this$address.equals(other$address)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        Label_0102: {
            if (this$startDate == null) {
                if (other$startDate == null) {
                    break Label_0102;
                }
            }
            else if (this$startDate.equals(other$startDate)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$endDate = this.getEndDate();
        final Object other$endDate = other.getEndDate();
        Label_0139: {
            if (this$endDate == null) {
                if (other$endDate == null) {
                    break Label_0139;
                }
            }
            else if (this$endDate.equals(other$endDate)) {
                break Label_0139;
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
        return other instanceof WalletTxReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $address = this.getAddress();
        result = result * 59 + (($address == null) ? 43 : $address.hashCode());
        final Object $startDate = this.getStartDate();
        result = result * 59 + (($startDate == null) ? 43 : $startDate.hashCode());
        final Object $endDate = this.getEndDate();
        result = result * 59 + (($endDate == null) ? 43 : $endDate.hashCode());
        final Object $page = this.getPage();
        result = result * 59 + (($page == null) ? 43 : $page.hashCode());
        return result;
    }
}
