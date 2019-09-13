// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TInternalTx;
import com.dfg.icon.core.dao.icon.TInternalTxKey;
import com.dfg.icon.core.dao.icon.TInternalTxExample;

public interface TInternalTxMapper
{
    long countByExample(final TInternalTxExample p0);
    
    int deleteByExample(final TInternalTxExample p0);
    
    int deleteByPrimaryKey(final TInternalTxKey p0);
    
    int insert(final TInternalTx p0);
    
    int insertSelective(final TInternalTx p0);
    
    List<TInternalTx> selectByExampleWithRowbounds(final TInternalTxExample p0, final RowBounds p1);
    
    List<TInternalTx> selectByExample(final TInternalTxExample p0);
    
    TInternalTx selectByPrimaryKey(final TInternalTxKey p0);
    
    int updateByExampleSelective(@Param("record") final TInternalTx p0, @Param("example") final TInternalTxExample p1);
    
    int updateByExample(@Param("record") final TInternalTx p0, @Param("example") final TInternalTxExample p1);
    
    int updateByPrimaryKeySelective(final TInternalTx p0);
    
    int updateByPrimaryKey(final TInternalTx p0);
}
