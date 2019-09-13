// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import com.dfg.icon.web.v0.dto.TxInBlock;
import java.util.List;
import com.dfg.icon.web.v0.dto.block.Block;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;

public interface V3BlockService
{
    CommonListRes selectRecentBlock(final PageReq p0) throws Exception;
    
    Block selectBlockDetail(final PageReq p0) throws Exception;
    
    List<TxInBlock> selectTxInBlock(final PageReq p0) throws Exception;
    
    Block selectBlockDetailByHash(final PageReq p0) throws Exception;
    
    List<TxInBlock> selectTxInBlockByHash(final PageReq p0) throws Exception;
}
