// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TMainTx;
import com.dfg.icon.core.dao.icon.TMainTxKey;
import com.dfg.icon.core.dao.icon.TMainTxExample;

public interface TMainTxMapper
{
    long countByExample(final TMainTxExample p0);
    
    int deleteByExample(final TMainTxExample p0);
    
    int deleteByPrimaryKey(final TMainTxKey p0);
    
    int insert(final TMainTx p0);
    
    int insertSelective(final TMainTx p0);
    
    List<TMainTx> selectByExampleWithRowbounds(final TMainTxExample p0, final RowBounds p1);
    
    List<TMainTx> selectByExample(final TMainTxExample p0);
    
    TMainTx selectByPrimaryKey(final TMainTxKey p0);
    
    int updateByExampleSelective(@Param("record") final TMainTx p0, @Param("example") final TMainTxExample p1);
    
    int updateByExample(@Param("record") final TMainTx p0, @Param("example") final TMainTxExample p1);
    
    int updateByPrimaryKeySelective(final TMainTx p0);
    
    int updateByPrimaryKey(final TMainTx p0);
}
