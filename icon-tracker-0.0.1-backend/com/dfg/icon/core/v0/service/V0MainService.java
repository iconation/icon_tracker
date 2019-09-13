// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service;

import com.dfg.icon.core.dao.icon.TMainInfo;
import com.dfg.icon.web.v0.dto.main.MainBlock;
import com.dfg.icon.core.dao.icon.TMainTx;
import com.dfg.icon.core.dao.icon.TMainChart;
import java.util.List;
import com.dfg.icon.web.v0.dto.main.MainInfo;

public interface V0MainService
{
    MainInfo selectMainSummary() throws Exception;
    
    List<TMainChart> SelectDailyTx() throws Exception;
    
    List<TMainTx> selectRecentTx() throws Exception;
    
    List<MainBlock> selectRecentBlock() throws Exception;
    
    void updateMainBlock() throws Exception;
    
    void updateMainChart() throws Exception;
    
    void updateMainTx() throws Exception;
    
    void updateMainInfo(final int p0) throws Exception;
    
    void updateMainInfo() throws Exception;
    
    void updateMainChartDaily() throws Exception;
    
    TMainInfo getMainInfo();
    
    String getIcxCirculationy();
}
