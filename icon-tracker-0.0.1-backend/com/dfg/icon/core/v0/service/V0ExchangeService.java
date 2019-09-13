// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service;

import com.dfg.icon.web.v0.dto.CommonRes;

public interface V0ExchangeService
{
    void updateExchange() throws Exception;
    
    CommonRes selectCurrentAllExchange() throws Exception;
    
    CommonRes selectCurrentExchange(final String p0) throws Exception;
    
    CommonRes selectCurrentExchangeList(final String p0) throws Exception;
}
