// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

public interface ResetMapper
{
    int stopScheduler();
    
    int stopSchedulerReal();
    
    int resetMainBlock();
    
    int resetMainTx();
    
    int resetMainInfo();
    
    int resetAddress();
    
    int resetAddressReal();
    
    int resetAddressTotal();
    
    int resetAddressTotalReal();
    
    int resetBlock();
    
    int resetBlockTotal();
    
    int resetTransaction();
    
    int resetTransactionTotal();
    
    int resetTransactionView();
    
    int resetInternalTx();
    
    int resetContract();
    
    int resetContractHistory();
    
    int resetTokenAddress();
    
    int resetTokenTx();
    
    int resetTokenTxView();
    
    int resetTxData();
    
    int resetTxResultLog();
    
    int startScheduler();
}
