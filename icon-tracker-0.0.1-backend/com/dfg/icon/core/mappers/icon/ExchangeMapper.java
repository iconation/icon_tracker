// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import com.dfg.icon.core.dao.icon.TCurrentExchange;
import java.util.List;

public interface ExchangeMapper
{
    int insertExchageInfoArray(final List<TCurrentExchange> p0);
    
    int deleteExchageInfoArray(final List<TCurrentExchange> p0);
    
    List<TCurrentExchange> selectExchageInfoList(final List<String> p0);
}
