// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTokenAddress;
import com.dfg.icon.core.dao.icon.TTokenAddressKey;
import com.dfg.icon.core.dao.icon.TTokenAddressExample;

public interface TTokenAddressMapper
{
    long countByExample(final TTokenAddressExample p0);
    
    int deleteByExample(final TTokenAddressExample p0);
    
    int deleteByPrimaryKey(final TTokenAddressKey p0);
    
    int insert(final TTokenAddress p0);
    
    int insertSelective(final TTokenAddress p0);
    
    List<TTokenAddress> selectByExampleWithRowbounds(final TTokenAddressExample p0, final RowBounds p1);
    
    List<TTokenAddress> selectByExample(final TTokenAddressExample p0);
    
    TTokenAddress selectByPrimaryKey(final TTokenAddressKey p0);
    
    int updateByExampleSelective(@Param("record") final TTokenAddress p0, @Param("example") final TTokenAddressExample p1);
    
    int updateByExample(@Param("record") final TTokenAddress p0, @Param("example") final TTokenAddressExample p1);
    
    int updateByPrimaryKeySelective(final TTokenAddress p0);
    
    int updateByPrimaryKey(final TTokenAddress p0);
}
