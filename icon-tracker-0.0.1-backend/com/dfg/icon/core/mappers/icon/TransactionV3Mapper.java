// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.core.v3.vo.TxCount;
import com.dfg.icon.core.dao.icon.TTransactionTotal;
import com.dfg.icon.web.v3.dto.InternalTx;
import com.dfg.icon.web.v3.dto.TxDetail;
import com.dfg.icon.web.v3.dto.TxEventLogList;
import com.dfg.icon.web.v3.dto.TxDetailTokenTx;
import org.apache.ibatis.annotations.Param;
import com.dfg.icon.web.v3.dto.IdAndHashDto;
import com.dfg.icon.web.v3.dto.TxDetailDto;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;

public interface TransactionV3Mapper
{
    List<TxDetailDto> selectRecentTxList(final PageReq p0);
    
    List<TxDetailDto> selectTotalTxList(final PageReq p0);
    
    List<IdAndHashDto> selectTotalTxListGetTx(final PageReq p0);
    
    List<IdAndHashDto> selectTotalTxListGetTxById(final PageReq p0);
    
    List<String> selectTotalTxListGetTxForWallet(final PageReq p0);
    
    List<TxDetailDto> selectTotalTxListGetTxData(final List<IdAndHashDto> p0);
    
    List<TxDetailDto> selectTotalTxListGetTxDataForWallet(final List<String> p0);
    
    List<TxDetailDto> selectTotalContractTxList(final PageReq p0);
    
    List<TxDetailTokenTx> selectTokenTx(@Param("txHash") final String p0);
    
    List<TxEventLogList> selectEventLogList(final PageReq p0);
    
    Integer selectTotalCountEventLog(final PageReq p0);
    
    Integer selectTotalTxCount(final PageReq p0);
    
    Integer selectTotalTxCountForWallet(final PageReq p0);
    
    Integer selectTotalContractTxCount(final PageReq p0);
    
    Integer selectLastBlockHeight();
    
    TxDetail selectTxDetail(@Param("txHash") final String p0);
    
    List<InternalTx> selectInternalTx(@Param("txHash") final String p0);
    
    List<InternalTx> selectInternalTxPaging(final PageReq p0);
    
    Integer selectInternalTxCount(final PageReq p0);
    
    List<TTransactionTotal> selectTxListForDownload(final PageReq p0);
    
    List<TxCount> selectTxCountForDownload(final PageReq p0);
}
