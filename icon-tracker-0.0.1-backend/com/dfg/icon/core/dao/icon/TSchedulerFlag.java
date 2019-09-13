// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;

public class TSchedulerFlag extends TSchedulerFlagKey
{
    private String activeYn;
    private String activeServer;
    private String startPosition;
    private Date updateDate;
    
    public String getActiveYn() {
        return this.activeYn;
    }
    
    public void setActiveYn(final String activeYn) {
        this.activeYn = ((activeYn == null) ? null : activeYn.trim());
    }
    
    public String getActiveServer() {
        return this.activeServer;
    }
    
    public void setActiveServer(final String activeServer) {
        this.activeServer = ((activeServer == null) ? null : activeServer.trim());
    }
    
    public String getStartPosition() {
        return this.startPosition;
    }
    
    public void setStartPosition(final String startPosition) {
        this.startPosition = ((startPosition == null) ? null : startPosition.trim());
    }
    
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }
}
