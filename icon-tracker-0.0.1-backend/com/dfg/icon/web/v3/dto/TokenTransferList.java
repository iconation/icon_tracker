// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import java.util.ArrayList;
import java.util.Iterator;
import com.dfg.icon.core.dao.icon.TTokenTx;
import java.util.List;

public class TokenTransferList
{
    List<TokenTransfer> tokenTransferList;
    String tokenSymbol;
    
    public void setTokenTransferList(final List<TTokenTx> tokenTx) {
        for (final TTokenTx tx : tokenTx) {
            final TokenTransfer transfer = new TokenTransfer();
            transfer.setTokenTransfer(tx);
            this.tokenTransferList.add(transfer);
        }
    }
    
    public TokenTransferList() {
        this.tokenTransferList = new ArrayList<TokenTransfer>();
    }
    
    public List<TokenTransfer> getTokenTransferList() {
        return this.tokenTransferList;
    }
    
    public String getTokenSymbol() {
        return this.tokenSymbol;
    }
    
    public void setTokenSymbol(final String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenTransferList)) {
            return false;
        }
        final TokenTransferList other = (TokenTransferList)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$tokenTransferList = this.getTokenTransferList();
        final Object other$tokenTransferList = other.getTokenTransferList();
        Label_0065: {
            if (this$tokenTransferList == null) {
                if (other$tokenTransferList == null) {
                    break Label_0065;
                }
            }
            else if (this$tokenTransferList.equals(other$tokenTransferList)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$tokenSymbol = this.getTokenSymbol();
        final Object other$tokenSymbol = other.getTokenSymbol();
        if (this$tokenSymbol == null) {
            if (other$tokenSymbol == null) {
                return true;
            }
        }
        else if (this$tokenSymbol.equals(other$tokenSymbol)) {
            return true;
        }
        return false;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof TokenTransferList;
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tokenTransferList = this.getTokenTransferList();
        result = result * 59 + (($tokenTransferList == null) ? 43 : $tokenTransferList.hashCode());
        final Object $tokenSymbol = this.getTokenSymbol();
        result = result * 59 + (($tokenSymbol == null) ? 43 : $tokenSymbol.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "TokenTransferList(tokenTransferList=" + this.getTokenTransferList() + ", tokenSymbol=" + this.getTokenSymbol() + ")";
    }
}
