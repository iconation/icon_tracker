// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

public class SelectTxReq
{
    Integer page;
    String contractAddr;
    Integer txType;
    
    public Integer getPage() {
        return this.page;
    }
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public Integer getTxType() {
        return this.txType;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = contractAddr;
    }
    
    public void setTxType(final Integer txType) {
        this.txType = txType;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SelectTxReq)) {
            return false;
        }
        final SelectTxReq other = (SelectTxReq)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$page = this.getPage();
        final Object other$page = other.getPage();
        Label_0065: {
            if (this$page == null) {
                if (other$page == null) {
                    break Label_0065;
                }
            }
            else if (this$page.equals(other$page)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$contractAddr = this.getContractAddr();
        final Object other$contractAddr = other.getContractAddr();
        Label_0102: {
            if (this$contractAddr == null) {
                if (other$contractAddr == null) {
                    break Label_0102;
                }
            }
            else if (this$contractAddr.equals(other$contractAddr)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$txType = this.getTxType();
        final Object other$txType = other.getTxType();
        if (this$txType == null) {
            if (other$txType == null) {
                return true;
            }
        }
        else if (this$txType.equals(other$txType)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof SelectTxReq;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $page = this.getPage();
        result = result * 59 + (($page == null) ? 43 : $page.hashCode());
        final Object $contractAddr = this.getContractAddr();
        result = result * 59 + (($contractAddr == null) ? 43 : $contractAddr.hashCode());
        final Object $txType = this.getTxType();
        result = result * 59 + (($txType == null) ? 43 : $txType.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "SelectTxReq(page=" + this.getPage() + ", contractAddr=" + this.getContractAddr() + ", txType=" + this.getTxType() + ")";
    }
}
