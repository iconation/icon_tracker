// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.core.dao.icon.TAddressTotalKey;
import com.dfg.icon.core.dao.icon.TAddressTotalExample;

public interface TAddressTotalMapper
{
    long countByExample(final TAddressTotalExample p0);
    
    int deleteByExample(final TAddressTotalExample p0);
    
    int deleteByPrimaryKey(final TAddressTotalKey p0);
    
    int insert(final TAddressTotal p0);
    
    int insertSelective(final TAddressTotal p0);
    
    List<TAddressTotal> selectByExampleWithRowbounds(final TAddressTotalExample p0, final RowBounds p1);
    
    List<TAddressTotal> selectByExample(final TAddressTotalExample p0);
    
    TAddressTotal selectByPrimaryKey(final TAddressTotalKey p0);
    
    int updateByExampleSelective(@Param("record") final TAddressTotal p0, @Param("example") final TAddressTotalExample p1);
    
    int updateByExample(@Param("record") final TAddressTotal p0, @Param("example") final TAddressTotalExample p1);
    
    int updateByPrimaryKeySelective(final TAddressTotal p0);
    
    int updateByPrimaryKey(final TAddressTotal p0);
}
