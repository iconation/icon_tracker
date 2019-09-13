// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.dao.icon.TTxResultLogKey;
import com.dfg.icon.core.dao.icon.TTxResultLogExample;

public interface TTxResultLogMapper
{
    long countByExample(final TTxResultLogExample p0);
    
    int deleteByExample(final TTxResultLogExample p0);
    
    int deleteByPrimaryKey(final TTxResultLogKey p0);
    
    int insert(final TTxResultLog p0);
    
    int insertSelective(final TTxResultLog p0);
    
    List<TTxResultLog> selectByExampleWithRowbounds(final TTxResultLogExample p0, final RowBounds p1);
    
    List<TTxResultLog> selectByExample(final TTxResultLogExample p0);
    
    TTxResultLog selectByPrimaryKey(final TTxResultLogKey p0);
    
    int updateByExampleSelective(@Param("record") final TTxResultLog p0, @Param("example") final TTxResultLogExample p1);
    
    int updateByExample(@Param("record") final TTxResultLog p0, @Param("example") final TTxResultLogExample p1);
    
    int updateByPrimaryKeySelective(final TTxResultLog p0);
    
    int updateByPrimaryKey(final TTxResultLog p0);
}
