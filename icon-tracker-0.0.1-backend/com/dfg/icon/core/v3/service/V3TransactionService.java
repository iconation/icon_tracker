// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import com.dfg.icon.web.v3.dto.CommonRes;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;

public interface V3TransactionService
{
    CommonListRes selectRecentTx(final PageReq p0) throws Exception;
    
    CommonRes selectTxDetail(final String p0) throws Exception;
    
    CommonListRes selectInternalTxList(final PageReq p0) throws Exception;
    
    CommonListRes selectTxEventLogList(final PageReq p0) throws Exception;
}
