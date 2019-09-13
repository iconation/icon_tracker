// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTransactionTotal;
import com.dfg.icon.core.dao.icon.TTransactionTotalKey;
import com.dfg.icon.core.dao.icon.TTransactionTotalExample;

public interface TTransactionTotalMapper
{
    long countByExample(final TTransactionTotalExample p0);
    
    int deleteByExample(final TTransactionTotalExample p0);
    
    int deleteByPrimaryKey(final TTransactionTotalKey p0);
    
    int insert(final TTransactionTotal p0);
    
    int insertSelective(final TTransactionTotal p0);
    
    List<TTransactionTotal> selectByExampleWithRowbounds(final TTransactionTotalExample p0, final RowBounds p1);
    
    List<TTransactionTotal> selectByExample(final TTransactionTotalExample p0);
    
    TTransactionTotal selectByPrimaryKey(final TTransactionTotalKey p0);
    
    int updateByExampleSelective(@Param("record") final TTransactionTotal p0, @Param("example") final TTransactionTotalExample p1);
    
    int updateByExample(@Param("record") final TTransactionTotal p0, @Param("example") final TTransactionTotalExample p1);
    
    int updateByPrimaryKeySelective(final TTransactionTotal p0);
    
    int updateByPrimaryKey(final TTransactionTotal p0);
}
