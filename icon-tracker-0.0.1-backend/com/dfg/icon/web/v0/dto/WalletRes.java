// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dfg.icon.web.v3.dto.TxDetail;
import java.util.List;

public class WalletRes
{
    WalletInfoDto walletDetail;
    List<TxDetail> walletTx;
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
    
    public WalletInfoDto getWalletDetail() {
        return this.walletDetail;
    }
    
    public List<TxDetail> getWalletTx() {
        return this.walletTx;
    }
    
    public void setWalletDetail(final WalletInfoDto walletDetail) {
        this.walletDetail = walletDetail;
    }
    
    public void setWalletTx(final List<TxDetail> walletTx) {
        this.walletTx = walletTx;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WalletRes)) {
            return false;
        }
        final WalletRes other = (WalletRes)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$walletDetail = this.getWalletDetail();
        final Object other$walletDetail = other.getWalletDetail();
        Label_0065: {
            if (this$walletDetail == null) {
                if (other$walletDetail == null) {
                    break Label_0065;
                }
            }
            else if (this$walletDetail.equals(other$walletDetail)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$walletTx = this.getWalletTx();
        final Object other$walletTx = other.getWalletTx();
        if (this$walletTx == null) {
            if (other$walletTx == null) {
                return true;
            }
        }
        else if (this$walletTx.equals(other$walletTx)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof WalletRes;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $walletDetail = this.getWalletDetail();
        result = result * 59 + (($walletDetail == null) ? 43 : $walletDetail.hashCode());
        final Object $walletTx = this.getWalletTx();
        result = result * 59 + (($walletTx == null) ? 43 : $walletTx.hashCode());
        return result;
    }
}
