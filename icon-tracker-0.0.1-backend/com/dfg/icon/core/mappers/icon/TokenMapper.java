// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.web.v3.dto.TokenTxDetail;
import com.dfg.icon.web.v3.dto.TokenAddress;
import com.dfg.icon.web.v3.dto.TokenHolder;
import com.dfg.icon.web.v3.dto.TokenTransfers;
import com.dfg.icon.web.v3.dto.TokenInfo;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;

public interface TokenMapper
{
    List<TokenInfo> selectTokenInfoList(final PageReq p0);
    
    Integer selectTokenInfoTotalCount(final PageReq p0);
    
    List<TokenTransfers> selectTokenTransferList(final PageReq p0);
    
    List<String> selectTokenTransferListTxByTokenAddr(final PageReq p0);
    
    List<String> selectTokenTransferListTx(final PageReq p0);
    
    List<TokenTransfers> selectTokenTransferListTxData(final List<String> p0);
    
    Integer selectTotalCountTransfers(final PageReq p0);
    
    Integer selectTotalTxCount();
    
    Integer selectAddrTokenTxCount(final PageReq p0);
    
    List<TokenHolder> selectTokenHolders(final PageReq p0);
    
    Integer selectTotalCountHoderList(final PageReq p0);
    
    List<TokenAddress> selectQuantityByAddress(final PageReq p0);
    
    Integer selectTokenAddrCount(final PageReq p0);
    
    List<TokenTxDetail> selectTokenTxByAddress(final PageReq p0);
    
    List<TokenTxDetail> selectTokenTxByAddressTxData(final PageReq p0);
    
    int insertTokenTxArray(final List<TTokenTx> p0);
    
    int insertTxResultLogArray(final List<TTxResultLog> p0);
    
    int updateTokenInfoHolderCountAndTxCountRange(@Param("height1") final Integer p0, @Param("height2") final Integer p1);
}
