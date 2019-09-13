// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TBlock;
import com.dfg.icon.core.dao.icon.TBlockKey;
import com.dfg.icon.core.dao.icon.TBlockExample;

public interface TBlockMapper
{
    long countByExample(final TBlockExample p0);
    
    int deleteByExample(final TBlockExample p0);
    
    int deleteByPrimaryKey(final TBlockKey p0);
    
    int insert(final TBlock p0);
    
    int insertSelective(final TBlock p0);
    
    List<TBlock> selectByExampleWithRowbounds(final TBlockExample p0, final RowBounds p1);
    
    List<TBlock> selectByExample(final TBlockExample p0);
    
    TBlock selectByPrimaryKey(final TBlockKey p0);
    
    int updateByExampleSelective(@Param("record") final TBlock p0, @Param("example") final TBlockExample p1);
    
    int updateByExample(@Param("record") final TBlock p0, @Param("example") final TBlockExample p1);
    
    int updateByPrimaryKeySelective(final TBlock p0);
    
    int updateByPrimaryKey(final TBlock p0);
}
