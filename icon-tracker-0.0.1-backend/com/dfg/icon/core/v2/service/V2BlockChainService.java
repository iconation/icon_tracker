// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.service;

public interface V2BlockChainService
{
    boolean blockChainSyncUpdate(final Integer p0, final Integer p1) throws Exception;
    
    void blockLimit(final Integer p0);
    
    void transactionLimit(final Integer p0);
    
    void addressLimit(final Integer p0);
    
    void updateMain() throws Exception;
    
    void updateChart() throws Exception;
    
    String getBalance(final String p0) throws Exception;
}
