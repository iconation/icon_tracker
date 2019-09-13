// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TMainChart;
import com.dfg.icon.core.dao.icon.TMainChartKey;
import com.dfg.icon.core.dao.icon.TMainChartExample;

public interface TMainChartMapper
{
    long countByExample(final TMainChartExample p0);
    
    int deleteByExample(final TMainChartExample p0);
    
    int deleteByPrimaryKey(final TMainChartKey p0);
    
    int insert(final TMainChart p0);
    
    int insertSelective(final TMainChart p0);
    
    List<TMainChart> selectByExampleWithRowbounds(final TMainChartExample p0, final RowBounds p1);
    
    List<TMainChart> selectByExample(final TMainChartExample p0);
    
    TMainChart selectByPrimaryKey(final TMainChartKey p0);
    
    int updateByExampleSelective(@Param("record") final TMainChart p0, @Param("example") final TMainChartExample p1);
    
    int updateByExample(@Param("record") final TMainChart p0, @Param("example") final TMainChartExample p1);
    
    int updateByPrimaryKeySelective(final TMainChart p0);
    
    int updateByPrimaryKey(final TMainChart p0);
}
