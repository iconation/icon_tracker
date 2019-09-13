// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TSchedulerFlag;
import com.dfg.icon.core.dao.icon.TSchedulerFlagKey;
import com.dfg.icon.core.dao.icon.TSchedulerFlagExample;

public interface TSchedulerFlagMapper
{
    long countByExample(final TSchedulerFlagExample p0);
    
    int deleteByExample(final TSchedulerFlagExample p0);
    
    int deleteByPrimaryKey(final TSchedulerFlagKey p0);
    
    int insert(final TSchedulerFlag p0);
    
    int insertSelective(final TSchedulerFlag p0);
    
    List<TSchedulerFlag> selectByExampleWithRowbounds(final TSchedulerFlagExample p0, final RowBounds p1);
    
    List<TSchedulerFlag> selectByExample(final TSchedulerFlagExample p0);
    
    TSchedulerFlag selectByPrimaryKey(final TSchedulerFlagKey p0);
    
    int updateByExampleSelective(@Param("record") final TSchedulerFlag p0, @Param("example") final TSchedulerFlagExample p1);
    
    int updateByExample(@Param("record") final TSchedulerFlag p0, @Param("example") final TSchedulerFlagExample p1);
    
    int updateByPrimaryKeySelective(final TSchedulerFlag p0);
    
    int updateByPrimaryKey(final TSchedulerFlag p0);
}
