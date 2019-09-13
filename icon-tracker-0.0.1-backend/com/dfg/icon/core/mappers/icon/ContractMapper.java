// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.web.v3.dto.ContractPendingInfo;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.web.v3.dto.ContractTx;
import com.dfg.icon.web.v3.dto.TokenTransfer;
import com.dfg.icon.web.v3.dto.TxResultLog;
import com.dfg.icon.web.v3.dto.ContractDetail;
import com.dfg.icon.web.v3.dto.ContractVersion;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.web.v3.dto.ContractInfo;
import org.apache.ibatis.annotations.Param;
import com.dfg.icon.web.v3.dto.ContractList;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;

public interface ContractMapper
{
    List<ContractList> selectContractList(final PageReq p0);
    
    int selectContractListCount(final PageReq p0);
    
    ContractInfo selectContractInfo(@Param("addr") final String p0);
    
    List<ContractVersion> selectContractVersion(final TContractHistory p0);
    
    ContractDetail selectContractDetail(final PageReq p0);
    
    List<TxResultLog> selectEventLogList(final PageReq p0);
    
    Integer selectTotalCountEventLog(final PageReq p0);
    
    String selectContractEqualToTxAddr(@Param("addr") final String p0);
    
    List<TokenTransfer> selectNoIrcContractTxList(@Param("addr") final String p0, @Param("page") final int p1, @Param("count") final int p2);
    
    int selectNoIrcContractTxListCount(@Param("addr") final String p0);
    
    List<ContractTx> selectContractTokenTransferList(@Param("addr") final String p0, @Param("page") final int p1, @Param("count") final int p2);
    
    int selectContractTokenTransferListCount(@Param("addr") final String p0);
    
    int insertContractArray(final List<TContract> p0);
    
    int insertContractHistoryArray(final List<TContractHistory> p0);
    
    int updateContractInfo(@Param("contractAddr") final String p0, @Param("state") final int p1, @Param("version") final int p2, @Param("ircVersion") final String p3, @Param("scoreName") final String p4);
    
    List<TContractHistory> selectHistoryForCancel(final TContractHistory p0);
    
    List<ContractPendingInfo> selectRequireContractList(final PageReq p0);
    
    int selectRequireContractListCount();
    
    int updateHistoryToCancel(final TContractHistory p0);
    
    int updateContractTxToCancel(final TContractHistory p0);
}
