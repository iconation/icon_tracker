// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import com.dfg.icon.core.v3.vo.IcxSupplyVo;
import java.util.Iterator;
import com.dfg.icon.util.DateUtil;
import com.dfg.icon.core.dao.icon.TMainInfoExample;
import com.dfg.icon.core.dao.icon.TMainInfo;
import com.dfg.icon.web.v0.dto.main.MainBlock;
import com.dfg.icon.core.dao.icon.TMainTxExample;
import com.dfg.icon.core.dao.icon.TMainTx;
import com.dfg.icon.core.dao.icon.TMainChartExample;
import com.dfg.icon.core.dao.icon.TMainChart;
import java.util.List;
import com.dfg.icon.web.v0.dto.main.MainInfo;
import com.dfg.icon.core.common.service.ResourceService;
import com.dfg.icon.core.mappers.icon.AddressMapper;
import com.dfg.icon.core.mappers.icon.TMainBlockMapper;
import com.dfg.icon.core.mappers.icon.TMainTxMapper;
import com.dfg.icon.core.mappers.icon.TMainChartMapper;
import com.dfg.icon.core.mappers.icon.TMainInfoMapper;
import com.dfg.icon.core.mappers.icon.MainMapper;
import com.dfg.icon.core.mappers.icon.BlockMapper;
import com.dfg.icon.core.mappers.icon.TTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TBlockMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.V0MainService;

@Service
public class V0MainServiceImpl implements V0MainService
{
    @Autowired
    TBlockMapper tBlockMapper;
    @Autowired
    TTransactionMapper tTransactionMapper;
    @Autowired
    BlockMapper blockMapper;
    @Autowired
    MainMapper mainMapper;
    @Autowired
    TMainInfoMapper tMainInfoMapper;
    @Autowired
    TMainChartMapper tMainChartMapper;
    @Autowired
    TMainTxMapper tMainTxMapper;
    @Autowired
    TMainBlockMapper tMainBlockMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    ResourceService resourceService;
    
    public MainInfo selectMainSummary() throws Exception {
        final MainInfo mainInfo = this.mainMapper.selectMainInfo();
        if (mainInfo == null) {
            return null;
        }
        final double rate = Double.parseDouble(this.mainMapper.selectRate());
        double icxCirculationy = Double.parseDouble(mainInfo.getIcxSupply());
        if (mainInfo.getIcxCirculationy() != null) {
            icxCirculationy = Double.parseDouble(mainInfo.getIcxCirculationy());
        }
        mainInfo.setMarketCap(Double.valueOf(rate * icxCirculationy));
        return mainInfo;
    }
    
    public List<TMainChart> SelectDailyTx() throws Exception {
        final TMainChartExample example = new TMainChartExample();
        final List<TMainChart> chart = this.tMainChartMapper.selectByExample(example);
        if (chart.isEmpty()) {
            return null;
        }
        return chart;
    }
    
    public List<TMainTx> selectRecentTx() throws Exception {
        final TMainTxExample example = new TMainTxExample();
        example.setOrderByClause("create_date desc limit 20");
        final List<TMainTx> recentTx = this.tMainTxMapper.selectByExample(example);
        for (int i = 0; i < recentTx.size(); ++i) {
            final double amount = Double.parseDouble(recentTx.get(i).getAmount());
            final String b = String.format("%.4f", amount);
            recentTx.get(i).setAmount(b);
        }
        if (recentTx.isEmpty()) {
            return null;
        }
        return recentTx;
    }
    
    public List<MainBlock> selectRecentBlock() throws Exception {
        final List<MainBlock> recentBlock = this.blockMapper.selectMainBlock();
        if (recentBlock.isEmpty()) {
            return null;
        }
        return recentBlock;
    }
    
    public void updateMainBlock() throws Exception {
        this.mainMapper.deleteMainBlock(this.resourceService.getLimitMainBlock());
    }
    
    public void updateMainChart() throws Exception {
        final List<TMainChart> chart = this.blockMapper.selectBlockChart();
        if (chart != null && chart.size() > 0 && chart.get(0) != null) {
            final TMainChartExample example = new TMainChartExample();
            example.createCriteria().andTargetDateEqualTo(chart.get(0).getTargetDate());
            this.tMainChartMapper.updateByExampleSelective(chart.get(0), example);
        }
    }
    
    public void updateMainTx() throws Exception {
        this.mainMapper.deleteMainTx(this.resourceService.getLimitMainTx());
    }
    
    public void updateMainInfo(final int txAddedCount) throws Exception {
        TMainInfo mainInfo = this.getMainInfo();
        if (mainInfo == null) {
            mainInfo = new TMainInfo();
            mainInfo.setTransactionCount(this.mainMapper.sumByTxCount());
            mainInfo.setIcxSupply(this.addressMapper.selectSumIcx());
            if (!this.resourceService.isIcxStatic()) {
                String icxSupply = this.getIcxCirculationy();
                if ("0".equals(icxSupply)) {
                    icxSupply = mainInfo.getIcxSupply();
                }
                mainInfo.setIcxCirculationy(icxSupply);
            }
            mainInfo.setMarketCap("0");
            mainInfo.setCrepCount(40);
            this.tMainInfoMapper.insert(mainInfo);
        }
        else {
            if (!this.resourceService.isIcxStatic()) {
                String icxSupply = this.getIcxCirculationy();
                if ("0".equals(icxSupply)) {
                    icxSupply = mainInfo.getIcxSupply();
                }
                mainInfo.setIcxCirculationy(icxSupply);
            }
            else if (mainInfo.getIcxCirculationy() == null || "0".equals(mainInfo.getIcxCirculationy())) {
                mainInfo.setIcxCirculationy(mainInfo.getIcxSupply());
            }
            mainInfo.setTransactionCount(mainInfo.getTransactionCount() + txAddedCount);
            this.tMainInfoMapper.updateByExample(mainInfo, new TMainInfoExample());
        }
    }
    
    public void updateMainInfo() throws Exception {
        TMainInfo mainInfo = this.getMainInfo();
        if (mainInfo == null) {
            mainInfo = new TMainInfo();
            mainInfo.setTransactionCount(this.mainMapper.sumByTxCount());
            mainInfo.setIcxSupply(this.addressMapper.selectSumIcx());
            if (!this.resourceService.isIcxStatic()) {
                String icxSupply = this.getIcxCirculationy();
                if ("0".equals(icxSupply)) {
                    icxSupply = mainInfo.getIcxSupply();
                }
                mainInfo.setIcxCirculationy(icxSupply);
            }
            else if (mainInfo.getIcxCirculationy() == null || "0".equals(mainInfo.getIcxCirculationy())) {
                mainInfo.setIcxCirculationy(mainInfo.getIcxSupply());
            }
            mainInfo.setMarketCap("0");
            mainInfo.setCrepCount(40);
            this.tMainInfoMapper.insert(mainInfo);
        }
        else {
            if (!this.resourceService.isIcxStatic()) {
                String icxSupply = this.getIcxCirculationy();
                if ("0".equals(icxSupply)) {
                    icxSupply = mainInfo.getIcxSupply();
                }
                mainInfo.setIcxCirculationy(icxSupply);
            }
            else if (mainInfo.getIcxCirculationy() == null || "0".equals(mainInfo.getIcxCirculationy())) {
                mainInfo.setIcxCirculationy(mainInfo.getIcxSupply());
            }
            mainInfo.setTransactionCount(this.mainMapper.sumByTxCount());
            this.tMainInfoMapper.updateByExample(mainInfo, new TMainInfoExample());
        }
    }
    
    public void updateMainChartDaily() throws Exception {
        final TMainChartExample example = new TMainChartExample();
        example.createCriteria();
        this.tMainChartMapper.deleteByExample(example);
        final List<TMainChart> chartList = this.blockMapper.selectBlockChartDaily();
        final List<String> dayList = (List<String>)DateUtil.getChartDailyList();
        for (final String day : dayList) {
            final TMainChart mainChart = new TMainChart();
            mainChart.setTargetDate(DateUtil.getFormattedDate(day, "yyyy-MM-dd"));
            for (final TMainChart chart : chartList) {
                if (chart.getTargetDate().getTime() == mainChart.getTargetDate().getTime()) {
                    mainChart.setTxCount(chart.getTxCount());
                    break;
                }
            }
            if (mainChart.getTxCount() == null) {
                mainChart.setTxCount(0);
            }
            this.tMainChartMapper.insert(mainChart);
        }
    }
    
    public TMainInfo getMainInfo() {
        final TMainInfoExample infoExample = new TMainInfoExample();
        infoExample.createCriteria();
        final List<TMainInfo> mainInfo = this.tMainInfoMapper.selectByExample(infoExample);
        if (mainInfo != null && mainInfo.size() > 0) {
            return mainInfo.get(0);
        }
        return null;
    }
    
    public String getIcxCirculationy() {
        String icxSupply = "0";
        final List<IcxSupplyVo> icxList = this.addressMapper.sumIcxCirculationy();
        for (final IcxSupplyVo vo : icxList) {
            if ("icxCirculationy".equals(vo.getNode())) {
                icxSupply = vo.getBalance();
                break;
            }
        }
        return icxSupply;
    }
}
