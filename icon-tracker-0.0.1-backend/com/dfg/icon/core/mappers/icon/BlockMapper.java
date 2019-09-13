// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.core.dao.icon.TBlock;
import com.dfg.icon.core.dao.icon.TMainChart;
import com.dfg.icon.web.v0.dto.main.MainBlock;
import com.dfg.icon.web.v0.dto.TxInBlock;
import com.dfg.icon.web.v0.dto.block.Block;
import com.dfg.icon.web.v3.dto.RecentBlock;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v0.dto.RecentBlockDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlockMapper
{
    List<RecentBlockDto> selectRecentBlock(@Param("page") final int p0);
    
    List<RecentBlock> selectRecentBlock(final PageReq p0);
    
    String selectTotalBlock();
    
    String selectTotalTxInBlock(@Param("height") final int p0);
    
    String selectTotalTxInBlockByHash(@Param("hash") final String p0);
    
    Block selectBlockDetail(final PageReq p0);
    
    List<TxInBlock> selectTxInBlock(final PageReq p0);
    
    Integer selectTxCountInBlock(final PageReq p0);
    
    Block selectBlockDetailByHash(final PageReq p0);
    
    List<TxInBlock> selectTxInBlockByHash(final PageReq p0);
    
    Block selectLastBlock();
    
    boolean selectBlockHeight(@Param("height") final int p0);
    
    List<MainBlock> selectMainBlock();
    
    List<TMainChart> selectBlockChartDaily();
    
    List<TMainChart> selectBlockChart();
    
    int insertBlockArray(final List<TBlock> p0);
    
    int insertBlockTotalArray(final List<TBlock> p0);
}
