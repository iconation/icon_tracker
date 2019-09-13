// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TMainBlock;
import com.dfg.icon.core.dao.icon.TMainBlockKey;
import com.dfg.icon.core.dao.icon.TMainBlockExample;

public interface TMainBlockMapper
{
    long countByExample(final TMainBlockExample p0);
    
    int deleteByExample(final TMainBlockExample p0);
    
    int deleteByPrimaryKey(final TMainBlockKey p0);
    
    int insert(final TMainBlock p0);
    
    int insertSelective(final TMainBlock p0);
    
    List<TMainBlock> selectByExampleWithRowbounds(final TMainBlockExample p0, final RowBounds p1);
    
    List<TMainBlock> selectByExample(final TMainBlockExample p0);
    
    TMainBlock selectByPrimaryKey(final TMainBlockKey p0);
    
    int updateByExampleSelective(@Param("record") final TMainBlock p0, @Param("example") final TMainBlockExample p1);
    
    int updateByExample(@Param("record") final TMainBlock p0, @Param("example") final TMainBlockExample p1);
    
    int updateByPrimaryKeySelective(final TMainBlock p0);
    
    int updateByPrimaryKey(final TMainBlock p0);
}
