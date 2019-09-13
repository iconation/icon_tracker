// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTransactionView;
import java.util.List;
import com.dfg.icon.core.dao.icon.TTransaction;
import com.google.gson.JsonObject;
import com.dfg.icon.core.dao.icon.TBlock;

public interface TxFactory
{
    void init(final TBlock p0, final JsonObject p1) throws Exception;
    
    String getFee() throws Exception;
    
    TTransaction getTransaction() throws Exception;
    
    List<TTransactionView> getTransactionView() throws Exception;
    
    String getVersion() throws Exception;
    
    String getValue() throws Exception;
    
    TTxData getData() throws Exception;
    
    String getContentData() throws Exception;
    
    String getEtc(final String p0) throws Exception;
    
    String getDataJsonValueByKey(final String... p0) throws Exception;
}
