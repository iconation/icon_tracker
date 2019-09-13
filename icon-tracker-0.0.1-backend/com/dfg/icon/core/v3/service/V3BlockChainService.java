// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import java.util.Date;

public interface V3BlockChainService
{
    void blockLimit(final Integer p0);
    
    void transactionLimit(final Integer p0);
    
    void addressLimit(final Integer p0);
    
    void updateMain() throws Exception;
    
    void updateChart() throws Exception;
    
    void updatePrepTerm() throws Exception;
    
    String getBalance(final String p0, final Integer p1) throws Exception;
    
    String getTokenBalance(final String p0, final String p1, final Integer p2) throws Exception;
    
    void blockChainSyncUpdateAllinOne(final Integer p0, final Integer p1, final Date p2) throws Exception;
}
