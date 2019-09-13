// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.common.service;

public interface ResourceService
{
    String getServerName();
    
    String getBlockSchedulerName();
    
    String getBlockSchedulerVersion();
    
    String getExchangeSchedulerName();
    
    Integer getLimitBlock();
    
    Integer getLimitTx();
    
    Integer getLimitAddress();
    
    Integer getLimitMainBlock();
    
    Integer getLimitMainTx();
    
    Boolean isIcxStatic();
    
    Boolean isAcceptMode();
    
    Boolean isLogSpeed();
    
    Boolean isExchangeActive();
    
    String getTrackerVersion();
}
