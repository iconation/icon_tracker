// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.mappers.icon;

import org.apache.ibatis.annotations.Param;
import com.dfg.icon.core.dao.icon.TMainBlock;
import com.dfg.icon.core.dao.icon.TMainTx;
import java.util.List;
import com.dfg.icon.web.v0.dto.main.MainInfo;

public interface MainMapper
{
    MainInfo selectMainInfo();
    
    String selectRate();
    
    Integer countByCrep();
    
    Integer sumByTxCount();
    
    int insertMainTxList(final List<TMainTx> p0);
    
    int insertMainBlockList(final List<TMainBlock> p0);
    
    int deleteMainBlock(@Param("count") final int p0);
    
    int deleteMainTx(@Param("count") final int p0);
    
    int deleteOldDataDaliyChart();
    
    int insertNewChartData();
}
