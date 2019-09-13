// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTransaction;
import com.dfg.icon.core.dao.icon.TTransactionKey;
import com.dfg.icon.core.dao.icon.TTransactionExample;

public interface TTransactionMapper
{
    long countByExample(final TTransactionExample p0);
    
    int deleteByExample(final TTransactionExample p0);
    
    int deleteByPrimaryKey(final TTransactionKey p0);
    
    int insert(final TTransaction p0);
    
    int insertSelective(final TTransaction p0);
    
    List<TTransaction> selectByExampleWithRowbounds(final TTransactionExample p0, final RowBounds p1);
    
    List<TTransaction> selectByExample(final TTransactionExample p0);
    
    TTransaction selectByPrimaryKey(final TTransactionKey p0);
    
    int updateByExampleSelective(@Param("record") final TTransaction p0, @Param("example") final TTransactionExample p1);
    
    int updateByExample(@Param("record") final TTransaction p0, @Param("example") final TTransactionExample p1);
    
    int updateByPrimaryKeySelective(final TTransaction p0);
    
    int updateByPrimaryKey(final TTransaction p0);
}
