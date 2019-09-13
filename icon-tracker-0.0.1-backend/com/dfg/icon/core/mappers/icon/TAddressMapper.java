// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TAddress;
import com.dfg.icon.core.dao.icon.TAddressKey;
import com.dfg.icon.core.dao.icon.TAddressExample;

public interface TAddressMapper
{
    long countByExample(final TAddressExample p0);
    
    int deleteByExample(final TAddressExample p0);
    
    int deleteByPrimaryKey(final TAddressKey p0);
    
    int insert(final TAddress p0);
    
    int insertSelective(final TAddress p0);
    
    List<TAddress> selectByExampleWithRowbounds(final TAddressExample p0, final RowBounds p1);
    
    List<TAddress> selectByExample(final TAddressExample p0);
    
    TAddress selectByPrimaryKey(final TAddressKey p0);
    
    int updateByExampleSelective(@Param("record") final TAddress p0, @Param("example") final TAddressExample p1);
    
    int updateByExample(@Param("record") final TAddress p0, @Param("example") final TAddressExample p1);
    
    int updateByPrimaryKeySelective(final TAddress p0);
    
    int updateByPrimaryKey(final TAddress p0);
}
