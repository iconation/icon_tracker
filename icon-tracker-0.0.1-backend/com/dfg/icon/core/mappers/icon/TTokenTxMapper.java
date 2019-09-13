// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.core.dao.icon.TTokenTxKey;
import com.dfg.icon.core.dao.icon.TTokenTxExample;

public interface TTokenTxMapper
{
    long countByExample(final TTokenTxExample p0);
    
    int deleteByExample(final TTokenTxExample p0);
    
    int deleteByPrimaryKey(final TTokenTxKey p0);
    
    int insert(final TTokenTx p0);
    
    int insertSelective(final TTokenTx p0);
    
    List<TTokenTx> selectByExampleWithRowbounds(final TTokenTxExample p0, final RowBounds p1);
    
    List<TTokenTx> selectByExample(final TTokenTxExample p0);
    
    TTokenTx selectByPrimaryKey(final TTokenTxKey p0);
    
    int updateByExampleSelective(@Param("record") final TTokenTx p0, @Param("example") final TTokenTxExample p1);
    
    int updateByExample(@Param("record") final TTokenTx p0, @Param("example") final TTokenTxExample p1);
    
    int updateByPrimaryKeySelective(final TTokenTx p0);
    
    int updateByPrimaryKey(final TTokenTx p0);
}
