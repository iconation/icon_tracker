// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import java.util.ArrayList;
import java.util.Iterator;
import com.dfg.icon.core.dao.icon.TTokenTx;
import java.util.List;

public class TokenTransfersList
{
    List<TokenTransfers> tokenTransferList;
    
    public void setTokenTransferList(final List<TTokenTx> tokenTx) {
        for (final TTokenTx tx : tokenTx) {
            final TokenTransfers transfer = new TokenTransfers();
            transfer.setTokenTransfer(tx);
            this.tokenTransferList.add(transfer);
        }
    }
    
    public TokenTransfersList() {
        this.tokenTransferList = new ArrayList<TokenTransfers>();
    }
    
    public List<TokenTransfers> getTokenTransferList() {
        return this.tokenTransferList;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenTransfersList)) {
            return false;
        }
        final TokenTransfersList other = (TokenTransfersList)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$tokenTransferList = this.getTokenTransferList();
        final Object other$tokenTransferList = other.getTokenTransferList();
        if (this$tokenTransferList == null) {
            if (other$tokenTransferList == null) {
                return true;
            }
        }
        else if (this$tokenTransferList.equals(other$tokenTransferList)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenTransfersList;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tokenTransferList = this.getTokenTransferList();
        result = result * 59 + (($tokenTransferList == null) ? 43 : $tokenTransferList.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenTransfersList(tokenTransferList=" + this.getTokenTransferList() + ")";
    }
}
