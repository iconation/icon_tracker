// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TMainTxKey
{
    private String txHash;
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = ((txHash == null) ? null : txHash.trim());
    }
}
