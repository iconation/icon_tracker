// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service;

import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v3.dto.CommonRes;

public interface V3TokenService
{
    CommonRes selectTokenSummary(final String p0) throws Exception;
    
    CommonListRes selectTokenList(final PageReq p0) throws Exception;
    
    CommonListRes selectTokenHolders(final PageReq p0) throws Exception;
    
    CommonListRes selectTokenTransfers(final PageReq p0) throws Exception;
    
    TContract getTokenInfoByAddress(final String p0);
}
