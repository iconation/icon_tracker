// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.common.service;

import com.dfg.icon.core.dao.icon.TSchedulerFlag;

public interface ScheduleService
{
    TSchedulerFlag activeBlockSchedule(final String p0);
    
    TSchedulerFlag inActiveBlockSchedule(final String p0);
    
    void updateBlockScheduler(final String p0);
    
    void activeExchangeSchedule(final String p0);
    
    void inActiveExchangeSchedule(final String p0);
    
    TSchedulerFlag getBlockSchedule();
    
    TSchedulerFlag getExchangeSchedule();
    
    TSchedulerFlag getSchedule(final String p0);
}
