// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import com.dfg.icon.core.dao.icon.TInternalTxView;
import com.dfg.icon.core.dao.icon.TInternalTx;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TTransaction;
import com.dfg.icon.core.dao.icon.TBlock;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TContract;
import java.util.List;
import com.google.gson.JsonObject;

public interface BlockFactory
{
    void init(final JsonObject p0, final int p1) throws Exception;
    
    List<TContract> getContractList() throws Exception;
    
    List<TContractHistory> getContractHistoryList() throws Exception;
    
    List<TContractHistory> getCanceledHistoryList() throws Exception;
    
    List<TTokenTx> getTokenTxList() throws Exception;
    
    List<TTokenTxView> getTokenTxViewList() throws Exception;
    
    List<TokenAddressGroupKey> getTokenAddressGroup() throws Exception;
    
    List<TTxResultLog> getTxResultLogList() throws Exception;
    
    TBlock getBlockInfo() throws Exception;
    
    String getVersion() throws Exception;
    
    List<TTransaction> getTransactionList() throws Exception;
    
    List<TTransactionView> getTransactionViewList() throws Exception;
    
    List<TTxData> getTransactionDataList() throws Exception;
    
    List<String> getAddressGroup() throws Exception;
    
    List<String> getTokenInfoGroup() throws Exception;
    
    List<TInternalTx> getInternalTransactionList() throws Exception;
    
    List<TInternalTxView> getInternalTxViewList() throws Exception;
    
    boolean isBreak();
    
    void setBreak(final boolean p0);
}
