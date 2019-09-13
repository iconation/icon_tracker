// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

public class TTxData extends TTxDataKey
{
    private String dataBody;
    
    public String getDataBody() {
        return this.dataBody;
    }
    
    public void setDataBody(final String dataBody) {
        this.dataBody = ((dataBody == null) ? null : dataBody.trim());
    }
}
