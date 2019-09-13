// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.core.dao.icon.TContractKey;
import com.dfg.icon.core.dao.icon.TContractExample;

public interface TContractMapper
{
    long countByExample(final TContractExample p0);
    
    int deleteByExample(final TContractExample p0);
    
    int deleteByPrimaryKey(final TContractKey p0);
    
    int insert(final TContract p0);
    
    int insertSelective(final TContract p0);
    
    List<TContract> selectByExampleWithRowbounds(final TContractExample p0, final RowBounds p1);
    
    List<TContract> selectByExample(final TContractExample p0);
    
    TContract selectByPrimaryKey(final TContractKey p0);
    
    int updateByExampleSelective(@Param("record") final TContract p0, @Param("example") final TContractExample p1);
    
    int updateByExample(@Param("record") final TContract p0, @Param("example") final TContractExample p1);
    
    int updateByPrimaryKeySelective(final TContract p0);
    
    int updateByPrimaryKey(final TContract p0);
}
