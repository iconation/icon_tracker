// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import java.util.Date;
import com.dfg.icon.web.v3.dto.ContractPendingInfo;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.web.v3.dto.ContractTx;
import com.dfg.icon.web.v3.dto.TokenTransfer;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.ContractDetail;
import com.dfg.icon.web.v3.dto.ContractInfo;
import com.dfg.icon.web.v3.dto.ContractList;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;

public interface V3ContractService
{
    List<ContractList> selectContractList(final PageReq p0) throws Exception;
    
    int selectContractListCount(final PageReq p0) throws Exception;
    
    ContractInfo selectContractInfo(final String p0) throws Exception;
    
    ContractDetail selectContractDetail(final PageReq p0) throws Exception;
    
    CommonListRes selectContractTxList(final PageReq p0) throws Exception;
    
    List<TokenTransfer> selectContractTransactionList(final String p0, final PageReq p1) throws Exception;
    
    int selectContractTransactionListCount(final String p0) throws Exception;
    
    List<ContractTx> selectContractTokenTransferList(final String p0, final PageReq p1) throws Exception;
    
    int selectContractTokenTransferListCount(final String p0) throws Exception;
    
    String getIrcTypeByAddress(final String p0);
    
    TContract getContractByAddress(final String p0);
    
    TContractHistory getContractHistoryByCreateTx(final String p0);
    
    List<TContractHistory> selectContractHistoryList(final String p0, final int p1, final int p2) throws Exception;
    
    int selectContractHistoryListCount(final String p0) throws Exception;
    
    CommonListRes selectTokenEventLogList(final PageReq p0) throws Exception;
    
    List<ContractPendingInfo> selectRequireContractList(final PageReq p0) throws Exception;
    
    int selectRequireContractListCount() throws Exception;
    
    TContract getContractForInsert(final String p0, final String p1, final Integer p2, final String p3, final Integer p4);
    
    TContractHistory getContractHistoryForInsert(final String p0, final Integer p1, final String p2, final String p3, final Date p4, final String p5, final Date p6, final String p7, final Integer p8);
    
    int getContractLastVersionForUpdate(final String p0);
    
    void initContractInfo();
}
