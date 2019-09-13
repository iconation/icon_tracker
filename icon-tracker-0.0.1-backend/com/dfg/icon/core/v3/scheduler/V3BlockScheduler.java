// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.scheduler;

import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import com.dfg.icon.util.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import com.dfg.icon.core.dao.icon.TSchedulerFlag;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.core.exception.IconCode;
import java.util.Arrays;
import java.util.Random;
import com.dfg.icon.core.v3.service.V3ContractService;
import com.dfg.icon.core.common.service.ResourceService;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.v2.service.V2BlockChainService;
import com.dfg.icon.core.v3.service.V3BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.adapter.V3BlockChainAdapter;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class V3BlockScheduler
{
    private static final Logger logger;
    private static final Logger sLogger;
    @Autowired
    private V3BlockChainAdapter blockChainAdapter;
    @Autowired
    private V3BlockChainService blockChainService;
    @Autowired
    private V2BlockChainService v2blockChainService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private V3ContractService contractService;
    private int accessTime;
    private final String[] schedulerServerList;
    private int limitBlockCountByOneScheduler;
    private int ignoreSchedulerTime;
    
    public V3BlockScheduler() {
        this.accessTime = 0;
        this.schedulerServerList = new String[] { "dev1", "dev2", "server1", "server2", "server3", "server4", "test", "localdev" };
        this.limitBlockCountByOneScheduler = 99;
        this.ignoreSchedulerTime = 120000;
    }
    
    @Scheduled(cron = "${block.cron.pattern}")
    public void updateBlockSync() {
        V3BlockScheduler.sLogger.info("--------------------");
        final Random generator = new Random();
        final int randomKey = generator.nextInt();
        V3BlockScheduler.sLogger.info("block_sync_start " + randomKey);
        if (!Arrays.asList(this.schedulerServerList).contains(this.resourceService.getServerName())) {
            return;
        }
        if (!IconCode.SCHEDULER_VER3.getCode().equals(this.resourceService.getBlockSchedulerVersion())) {
            return;
        }
        final TSchedulerFlag flag = this.checkSchedulingOuterServer(randomKey);
        if (flag == null) {
            return;
        }
        try {
            Integer lastHeight = this.blockChainAdapter.getHeightByBlock((Integer)null);
            final String nextHeight = flag.getStartPosition();
            V3BlockScheduler.sLogger.info("[Block] LastBlock : {}", (Object)lastHeight);
            final int iNextHeight = Integer.parseInt(nextHeight);
            if (lastHeight - iNextHeight > this.limitBlockCountByOneScheduler) {
                lastHeight = iNextHeight + this.limitBlockCountByOneScheduler;
            }
            try {
                this.blockChainService.blockChainSyncUpdateAllinOne(Integer.valueOf(iNextHeight), lastHeight, flag.getUpdateDate());
            }
            catch (Exception e) {
                CommonUtil.printException(V3BlockScheduler.sLogger, "SyncUpdate error : {}", e);
            }
            V3BlockScheduler.sLogger.info("[Block] nextHeight : {} , lastHeight : {} ", (Object)Integer.parseInt(nextHeight), (Object)lastHeight);
            long startTime = System.currentTimeMillis();
            if (Integer.parseInt(nextHeight) <= lastHeight) {
                this.blockChainService.blockLimit(this.resourceService.getLimitBlock());
                V3BlockScheduler.sLogger.info("[Block] limit block time : {} s ", (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                startTime = System.currentTimeMillis();
                this.blockChainService.transactionLimit(this.resourceService.getLimitTx());
                V3BlockScheduler.sLogger.info("[Block] limit transaction time : {} s ", (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                startTime = System.currentTimeMillis();
                this.blockChainService.addressLimit(this.resourceService.getLimitAddress());
                V3BlockScheduler.sLogger.info("[Block] limit address time : {} s ", (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                startTime = System.currentTimeMillis();
                this.blockChainService.updateMain();
                V3BlockScheduler.sLogger.info("[Block] update main time : {} s ", (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                this.blockChainService.updatePrepTerm();
                V3BlockScheduler.sLogger.info("[Block] update prepTerm time : {} s ", (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
            }
        }
        catch (Exception e2) {
            CommonUtil.printException(V3BlockScheduler.sLogger, "[Block] Update ERROR : {}", e2);
        }
        finally {
            this.scheduleService.inActiveBlockSchedule(this.resourceService.getServerName());
            V3BlockScheduler.sLogger.info("block_ end" + randomKey);
        }
    }
    
    private TSchedulerFlag checkSchedulingOuterServer(final int randomKey) {
        TSchedulerFlag flag = this.scheduleService.getBlockSchedule();
        if (flag == null || "N".equals(flag.getActiveYn())) {
            flag = this.scheduleService.activeBlockSchedule(this.resourceService.getServerName());
        }
        else {
            if ("P".equals(flag.getActiveYn())) {
                V3BlockScheduler.sLogger.info("block_start pause");
                return null;
            }
            if ("R".equals(flag.getActiveYn())) {
                if (flag.getActiveServer().equals(this.resourceService.getServerName())) {
                    this.scheduleService.inActiveBlockSchedule(this.resourceService.getServerName());
                }
                return null;
            }
            if (DateUtil.getNowDate().getTime() - flag.getUpdateDate().getTime() < this.ignoreSchedulerTime) {
                V3BlockScheduler.sLogger.info("block_start end type using " + randomKey);
                return null;
            }
            flag = this.scheduleService.activeBlockSchedule(this.resourceService.getServerName());
            V3BlockScheduler.sLogger.info("block_start ignore flag and continue schedule : ");
        }
        return flag;
    }
    
    @Scheduled(cron = "${maintx.cron.pattern}")
    public void updateMainChartDailySync() {
        V3BlockScheduler.sLogger.info("--------------------");
        V3BlockScheduler.sLogger.info("[Main] DailyChart Update : {}", (Object)this.resourceService.getServerName());
        try {
            this.blockChainService.updateChart();
        }
        catch (Exception e) {
            V3BlockScheduler.sLogger.error("[Main] DailyChart Update ERROR : {}", (Object)e.getMessage());
        }
    }
    
    @PostConstruct
    public void initMain() throws Exception {
        if (Arrays.asList(this.schedulerServerList).contains(this.resourceService.getServerName())) {
            V3BlockScheduler.sLogger.info("--------------------");
            V3BlockScheduler.sLogger.info("[Main] Init Update : ");
            try {
                this.blockChainService.updateMain();
                this.v2blockChainService.updateChart();
                this.contractService.initContractInfo();
            }
            catch (Exception e) {
                V3BlockScheduler.sLogger.error("[Main] Init Update ERROR : {}", (Object)e.getMessage());
            }
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3BlockScheduler.class);
        sLogger = LoggerFactory.getLogger("ScheduleLogger");
    }
}
