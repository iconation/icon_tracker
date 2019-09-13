// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import org.springframework.transaction.annotation.Transactional;
import com.dfg.icon.core.dao.icon.TSchedulerFlag;
import com.dfg.icon.web.v3.dto.CommonRes;
import com.dfg.icon.core.mappers.icon.TSchedulerFlagMapper;
import com.dfg.icon.core.v3.service.V3ContractService;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.common.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.ResetMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.V0ResetService;

@Service
public class V0ResetServiceImpl implements V0ResetService
{
    @Autowired
    ResetMapper resetMapper;
    @Autowired
    ResourceService resourceService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    V3ContractService contractService;
    @Autowired
    TSchedulerFlagMapper tSchedulerFlagMapper;
    
    @Transactional
    public CommonRes privateDevReset() throws Exception {
        final CommonRes res = new CommonRes();
        if (!"localdev".equals(this.resourceService.getServerName()) && !"test".equals(this.resourceService.getServerName())) {
            res.setResult("not localdev");
            return res;
        }
        final TSchedulerFlag flag = this.scheduleService.getBlockSchedule();
        if (flag.getActiveYn().equals("P")) {
            this.resetMapper.stopScheduler();
            this.resetMapper.resetMainBlock();
            this.resetMapper.resetMainTx();
            this.resetMapper.resetAddress();
            this.resetMapper.resetAddressTotal();
            this.resetMapper.resetBlock();
            this.resetMapper.resetBlockTotal();
            this.resetMapper.resetTransaction();
            this.resetMapper.resetTransactionTotal();
            this.resetMapper.resetTransactionView();
            this.resetMapper.resetMainInfo();
            this.resetMapper.resetInternalTx();
            this.resetMapper.resetContract();
            this.resetMapper.resetTokenAddress();
            this.resetMapper.resetTokenTx();
            this.resetMapper.resetTokenTxView();
            this.resetMapper.resetTxData();
            this.resetMapper.resetTxResultLog();
            this.resetMapper.resetContractHistory();
            this.resetMapper.resetMainTx();
            this.contractService.initContractInfo();
            this.resetMapper.startScheduler();
            res.setResult("OK");
            return res;
        }
        flag.setActiveYn("R");
        this.tSchedulerFlagMapper.updateByPrimaryKey(flag);
        res.setResult("Not Yet. Call api again.");
        return res;
    }
}
