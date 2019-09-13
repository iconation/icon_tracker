// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TInternalTxView;
import com.dfg.icon.core.dao.icon.TInternalTx;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TTransaction;
import org.apache.ibatis.annotations.Param;
import com.dfg.icon.web.v3.dto.TxDetail;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;

public interface TransactionMapper
{
    List<TxDetail> selectRecentTxList(final PageReq p0);
    
    List<TxDetail> selectTotalTxList(final PageReq p0);
    
    Integer selectTotalTxCount(final PageReq p0);
    
    Integer selectTxHeight(@Param("txHash") final String p0);
    
    Integer selectLastBlockHeight();
    
    TxDetail selectTxDetail(@Param("txHash") final String p0);
    
    String selectTxErrorCode(@Param("txHash") final String p0);
    
    int insertTxArray(final List<TTransaction> p0);
    
    int insertTxTotalArray(final List<TTransaction> p0);
    
    int insertTxViewArray(final List<TTransactionView> p0);
    
    int insertTxTokenViewArray(final List<TTokenTxView> p0);
    
    int insertInternalTx(final List<TInternalTx> p0);
    
    int insertInternalTxView(final List<TInternalTxView> p0);
    
    int insertTxDataArray(final List<TTxData> p0);
    
    String selectCreateDateByLimit(@Param("limit") final int p0);
    
    int deleteCreateDateByLimit(@Param("height") final String p0);
    
    int updateTxCancel(final TContractHistory p0);
    
    int updateTxTotalCancel(final TContractHistory p0);
    
    int updateTxViewCancel(final TContractHistory p0);
}
