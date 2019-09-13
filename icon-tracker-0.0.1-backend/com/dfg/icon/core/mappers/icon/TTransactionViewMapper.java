// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TTransactionViewKey;
import com.dfg.icon.core.dao.icon.TTransactionViewExample;

public interface TTransactionViewMapper
{
    long countByExample(final TTransactionViewExample p0);
    
    int deleteByExample(final TTransactionViewExample p0);
    
    int deleteByPrimaryKey(final TTransactionViewKey p0);
    
    int insert(final TTransactionView p0);
    
    int insertSelective(final TTransactionView p0);
    
    List<TTransactionView> selectByExampleWithRowbounds(final TTransactionViewExample p0, final RowBounds p1);
    
    List<TTransactionView> selectByExample(final TTransactionViewExample p0);
    
    TTransactionView selectByPrimaryKey(final TTransactionViewKey p0);
    
    int updateByExampleSelective(@Param("record") final TTransactionView p0, @Param("example") final TTransactionViewExample p1);
    
    int updateByExample(@Param("record") final TTransactionView p0, @Param("example") final TTransactionViewExample p1);
    
    int updateByPrimaryKeySelective(final TTransactionView p0);
    
    int updateByPrimaryKey(final TTransactionView p0);
}
