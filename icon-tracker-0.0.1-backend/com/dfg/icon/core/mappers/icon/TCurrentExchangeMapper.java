// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TCurrentExchange;
import com.dfg.icon.core.dao.icon.TCurrentExchangeKey;
import com.dfg.icon.core.dao.icon.TCurrentExchangeExample;

public interface TCurrentExchangeMapper
{
    long countByExample(final TCurrentExchangeExample p0);
    
    int deleteByExample(final TCurrentExchangeExample p0);
    
    int deleteByPrimaryKey(final TCurrentExchangeKey p0);
    
    int insert(final TCurrentExchange p0);
    
    int insertSelective(final TCurrentExchange p0);
    
    List<TCurrentExchange> selectByExampleWithRowbounds(final TCurrentExchangeExample p0, final RowBounds p1);
    
    List<TCurrentExchange> selectByExample(final TCurrentExchangeExample p0);
    
    TCurrentExchange selectByPrimaryKey(final TCurrentExchangeKey p0);
    
    int updateByExampleSelective(@Param("record") final TCurrentExchange p0, @Param("example") final TCurrentExchangeExample p1);
    
    int updateByExample(@Param("record") final TCurrentExchange p0, @Param("example") final TCurrentExchangeExample p1);
    
    int updateByPrimaryKeySelective(final TCurrentExchange p0);
    
    int updateByPrimaryKey(final TCurrentExchange p0);
}
