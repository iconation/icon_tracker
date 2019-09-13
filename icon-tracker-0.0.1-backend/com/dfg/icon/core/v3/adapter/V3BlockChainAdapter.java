// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.adapter;

import com.dfg.icon.core.v3.vo.RepRes;
import com.google.gson.JsonArray;
import com.dfg.icon.core.v3.vo.RpcBalanceRes;
import com.dfg.icon.core.v3.vo.GenesisRpcRes;
import com.dfg.icon.core.v3.vo.TxResultFactory;
import com.dfg.icon.core.v3.vo.BlockFactory;

public interface V3BlockChainAdapter
{
    BlockFactory getBlockFactoryByHeight(final Integer p0) throws Exception;
    
    Integer getHeightByBlock(final Integer p0) throws Exception;
    
    TxResultFactory getTransactionResult(final String p0) throws Exception;
    
    GenesisRpcRes getBlockInfoByGenesis() throws Exception;
    
    RpcBalanceRes getBalance(final String p0) throws Exception;
    
    JsonArray getIcxScoreApi(final String p0) throws Exception;
    
    String getIcxCall(final String p0, final String p1, final String... p2) throws Exception;
    
    RepRes repGetList() throws Exception;
    
    RepRes repGetListByHeight(final Integer p0) throws Exception;
    
    RepRes repGetListByRepRootHash(final String p0) throws Exception;
}
