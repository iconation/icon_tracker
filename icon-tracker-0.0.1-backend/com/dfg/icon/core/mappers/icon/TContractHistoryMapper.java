// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TContractHistoryKey;
import com.dfg.icon.core.dao.icon.TContractHistoryExample;

public interface TContractHistoryMapper
{
    long countByExample(final TContractHistoryExample p0);
    
    int deleteByExample(final TContractHistoryExample p0);
    
    int deleteByPrimaryKey(final TContractHistoryKey p0);
    
    int insert(final TContractHistory p0);
    
    int insertSelective(final TContractHistory p0);
    
    List<TContractHistory> selectByExampleWithRowbounds(final TContractHistoryExample p0, final RowBounds p1);
    
    List<TContractHistory> selectByExample(final TContractHistoryExample p0);
    
    TContractHistory selectByPrimaryKey(final TContractHistoryKey p0);
    
    int updateByExampleSelective(@Param("record") final TContractHistory p0, @Param("example") final TContractHistoryExample p1);
    
    int updateByExample(@Param("record") final TContractHistory p0, @Param("example") final TContractHistoryExample p1);
    
    int updateByPrimaryKeySelective(final TContractHistory p0);
    
    int updateByPrimaryKey(final TContractHistory p0);
}
