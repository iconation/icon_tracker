// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.List;
import com.google.gson.JsonObject;

public interface TxResultFactory
{
    void init(final JsonObject p0) throws Exception;
    
    Integer getStatus() throws Exception;
    
    TxResultFailure getFailure() throws Exception;
    
    String getTxHash() throws Exception;
    
    Integer getTxIndex() throws Exception;
    
    Integer getBlockHeight() throws Exception;
    
    String getBlockHash() throws Exception;
    
    String getCumulativeStepUsed() throws Exception;
    
    String getStepUsed() throws Exception;
    
    String getStepPrice() throws Exception;
    
    String getFee() throws Exception;
    
    String getScoreAddress() throws Exception;
    
    String getTo() throws Exception;
    
    List<EventLog> getEventLogs() throws Exception;
    
    String getVersion();
}
