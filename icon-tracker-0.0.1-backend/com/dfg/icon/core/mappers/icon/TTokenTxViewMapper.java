// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTokenTxViewKey;
import com.dfg.icon.core.dao.icon.TTokenTxViewExample;

public interface TTokenTxViewMapper
{
    long countByExample(final TTokenTxViewExample p0);
    
    int deleteByExample(final TTokenTxViewExample p0);
    
    int deleteByPrimaryKey(final TTokenTxViewKey p0);
    
    int insert(final TTokenTxView p0);
    
    int insertSelective(final TTokenTxView p0);
    
    List<TTokenTxView> selectByExampleWithRowbounds(final TTokenTxViewExample p0, final RowBounds p1);
    
    List<TTokenTxView> selectByExample(final TTokenTxViewExample p0);
    
    TTokenTxView selectByPrimaryKey(final TTokenTxViewKey p0);
    
    int updateByExampleSelective(@Param("record") final TTokenTxView p0, @Param("example") final TTokenTxViewExample p1);
    
    int updateByExample(@Param("record") final TTokenTxView p0, @Param("example") final TTokenTxViewExample p1);
    
    int updateByPrimaryKeySelective(final TTokenTxView p0);
    
    int updateByPrimaryKey(final TTokenTxView p0);
}
