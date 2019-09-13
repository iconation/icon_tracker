// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTxDataKey;
import com.dfg.icon.core.dao.icon.TTxDataExample;

public interface TTxDataMapper
{
    long countByExample(final TTxDataExample p0);
    
    int deleteByExample(final TTxDataExample p0);
    
    int deleteByPrimaryKey(final TTxDataKey p0);
    
    int insert(final TTxData p0);
    
    int insertSelective(final TTxData p0);
    
    List<TTxData> selectByExampleWithRowbounds(final TTxDataExample p0, final RowBounds p1);
    
    List<TTxData> selectByExample(final TTxDataExample p0);
    
    TTxData selectByPrimaryKey(final TTxDataKey p0);
    
    int updateByExampleSelective(@Param("record") final TTxData p0, @Param("example") final TTxDataExample p1);
    
    int updateByExample(@Param("record") final TTxData p0, @Param("example") final TTxDataExample p1);
    
    int updateByPrimaryKeySelective(final TTxData p0);
    
    int updateByPrimaryKey(final TTxData p0);
}
