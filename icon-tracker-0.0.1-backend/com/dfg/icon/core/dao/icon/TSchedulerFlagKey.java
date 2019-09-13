// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TSchedulerFlagKey
{
    private String scheduleName;
    
    public String getScheduleName() {
        return this.scheduleName;
    }
    
    public void setScheduleName(final String scheduleName) {
        this.scheduleName = ((scheduleName == null) ? null : scheduleName.trim());
    }
}
