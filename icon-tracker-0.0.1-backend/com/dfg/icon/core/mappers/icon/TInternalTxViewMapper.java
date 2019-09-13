// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TInternalTxView;
import com.dfg.icon.core.dao.icon.TInternalTxViewKey;
import com.dfg.icon.core.dao.icon.TInternalTxViewExample;

public interface TInternalTxViewMapper
{
    long countByExample(final TInternalTxViewExample p0);
    
    int deleteByExample(final TInternalTxViewExample p0);
    
    int deleteByPrimaryKey(final TInternalTxViewKey p0);
    
    int insert(final TInternalTxView p0);
    
    int insertSelective(final TInternalTxView p0);
    
    List<TInternalTxView> selectByExampleWithRowbounds(final TInternalTxViewExample p0, final RowBounds p1);
    
    List<TInternalTxView> selectByExample(final TInternalTxViewExample p0);
    
    TInternalTxView selectByPrimaryKey(final TInternalTxViewKey p0);
    
    int updateByExampleSelective(@Param("record") final TInternalTxView p0, @Param("example") final TInternalTxViewExample p1);
    
    int updateByExample(@Param("record") final TInternalTxView p0, @Param("example") final TInternalTxViewExample p1);
    
    int updateByPrimaryKeySelective(final TInternalTxView p0);
    
    int updateByPrimaryKey(final TInternalTxView p0);
}
