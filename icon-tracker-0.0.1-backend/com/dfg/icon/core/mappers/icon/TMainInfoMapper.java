// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TMainInfo;
import com.dfg.icon.core.dao.icon.TMainInfoKey;
import com.dfg.icon.core.dao.icon.TMainInfoExample;

public interface TMainInfoMapper
{
    long countByExample(final TMainInfoExample p0);
    
    int deleteByExample(final TMainInfoExample p0);
    
    int deleteByPrimaryKey(final TMainInfoKey p0);
    
    int insert(final TMainInfo p0);
    
    int insertSelective(final TMainInfo p0);
    
    List<TMainInfo> selectByExampleWithRowbounds(final TMainInfoExample p0, final RowBounds p1);
    
    List<TMainInfo> selectByExample(final TMainInfoExample p0);
    
    TMainInfo selectByPrimaryKey(final TMainInfoKey p0);
    
    int updateByExampleSelective(@Param("record") final TMainInfo p0, @Param("example") final TMainInfoExample p1);
    
    int updateByExample(@Param("record") final TMainInfo p0, @Param("example") final TMainInfoExample p1);
    
    int updateByPrimaryKeySelective(final TMainInfo p0);
    
    int updateByPrimaryKey(final TMainInfo p0);
}
