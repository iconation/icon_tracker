// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TBlockTotal;
import com.dfg.icon.core.dao.icon.TBlockTotalKey;
import com.dfg.icon.core.dao.icon.TBlockTotalExample;

public interface TBlockTotalMapper
{
    long countByExample(final TBlockTotalExample p0);
    
    int deleteByExample(final TBlockTotalExample p0);
    
    int deleteByPrimaryKey(final TBlockTotalKey p0);
    
    int insert(final TBlockTotal p0);
    
    int insertSelective(final TBlockTotal p0);
    
    List<TBlockTotal> selectByExampleWithRowbounds(final TBlockTotalExample p0, final RowBounds p1);
    
    List<TBlockTotal> selectByExample(final TBlockTotalExample p0);
    
    TBlockTotal selectByPrimaryKey(final TBlockTotalKey p0);
    
    int updateByExampleSelective(@Param("record") final TBlockTotal p0, @Param("example") final TBlockTotalExample p1);
    
    int updateByExample(@Param("record") final TBlockTotal p0, @Param("example") final TBlockTotalExample p1);
    
    int updateByPrimaryKeySelective(final TBlockTotal p0);
    
    int updateByPrimaryKey(final TBlockTotal p0);
}
