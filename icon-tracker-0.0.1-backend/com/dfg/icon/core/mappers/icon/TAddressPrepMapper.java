// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TAddressPrep;
import com.dfg.icon.core.dao.icon.TAddressPrepKey;
import com.dfg.icon.core.dao.icon.TAddressPrepExample;

public interface TAddressPrepMapper
{
    long countByExample(final TAddressPrepExample p0);
    
    int deleteByExample(final TAddressPrepExample p0);
    
    int deleteByPrimaryKey(final TAddressPrepKey p0);
    
    int insert(final TAddressPrep p0);
    
    int insertSelective(final TAddressPrep p0);
    
    List<TAddressPrep> selectByExampleWithRowbounds(final TAddressPrepExample p0, final RowBounds p1);
    
    List<TAddressPrep> selectByExample(final TAddressPrepExample p0);
    
    TAddressPrep selectByPrimaryKey(final TAddressPrepKey p0);
    
    int updateByExampleSelective(@Param("record") final TAddressPrep p0, @Param("example") final TAddressPrepExample p1);
    
    int updateByExample(@Param("record") final TAddressPrep p0, @Param("example") final TAddressPrepExample p1);
    
    int updateByPrimaryKeySelective(final TAddressPrep p0);
    
    int updateByPrimaryKey(final TAddressPrep p0);
}
