// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TContractKey
{
    private String contractAddr;
    
    public String getContractAddr() {
        return this.contractAddr;
    }
    
    public void setContractAddr(final String contractAddr) {
        this.contractAddr = ((contractAddr == null) ? null : contractAddr.trim());
    }
}
