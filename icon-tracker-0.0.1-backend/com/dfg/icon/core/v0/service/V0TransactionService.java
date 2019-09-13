// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service;

import com.dfg.icon.web.v0.dto.CommonRes;
import com.dfg.icon.web.v3.dto.PageReq;

public interface V0TransactionService
{
    CommonRes selectRecentTx(final PageReq p0) throws Exception;
    
    CommonRes selectTxDetail(final PageReq p0) throws Exception;
}
