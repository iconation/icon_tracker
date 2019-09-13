// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.adapter;

import com.dfg.icon.core.v2.vo.GenesisRpcRes;
import com.dfg.icon.core.v2.vo.RpcRes;

public interface V2BlockChainAdapter
{
    RpcRes getLastBlock() throws Exception;
    
    RpcRes getBlockInfoByHeight(final Integer p0) throws Exception;
    
    GenesisRpcRes getBlockInfoByGenesis() throws Exception;
    
    RpcRes getBalance(final String p0) throws Exception;
}
