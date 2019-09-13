// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.scheduler;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.dao.icon.TSchedulerFlag;
import com.dfg.icon.util.DateUtil;
import java.util.Random;
import com.dfg.icon.core.common.service.ResourceService;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.v2.service.V2BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v2.adapter.V2BlockChainAdapter;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class V2BlockScheduler
{
    private static final Logger logger;
    private static final Logger sLogger;
    @Autowired
    private V2BlockChainAdapter blockChainAdapter;
    @Autowired
    private V2BlockChainService blockChainService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ResourceService resourceService;
    private int accessTime;
    
    public V2BlockScheduler() {
        this.accessTime = 0;
    }
    
    public void updateBlockSync() {
        V2BlockScheduler.sLogger.info("--------------------");
        final Random generator = new Random();
        final int i = generator.nextInt();
        V2BlockScheduler.sLogger.info("block_start " + i);
        if (!this.resourceService.getServerName().equals("dev1") && !this.resourceService.getServerName().equals("dev2") && !this.resourceService.getServerName().equals("server1") && !this.resourceService.getServerName().equals("server2") && !this.resourceService.getServerName().equals("server3") && !this.resourceService.getServerName().equals("server4") && !this.resourceService.getServerName().equals("test") && !this.resourceService.getServerName().equals("privateDev")) {
            return;
        }
        V2BlockScheduler.sLogger.info("--------------------");
        V2BlockScheduler.sLogger.info("scheduler flag check");
        if (!"v2".equals(this.resourceService.getBlockSchedulerVersion())) {
            return;
        }
        TSchedulerFlag flag = this.scheduleService.getBlockSchedule();
        if (flag == null || "N".equals(flag.getActiveYn())) {
            flag = this.scheduleService.activeBlockSchedule(this.resourceService.getServerName());
        }
        else {
            if ("P".equals(flag.getActiveYn())) {
                V2BlockScheduler.sLogger.info("block_start pause");
                return;
            }
            if (DateUtil.getNowDate().getTime() - flag.getUpdateDate().getTime() < 30000L) {
                V2BlockScheduler.sLogger.info("block_start end type using " + i);
                return;
            }
            flag = this.scheduleService.activeBlockSchedule(this.resourceService.getServerName());
            V2BlockScheduler.sLogger.info("block_start ignore flag and continue schedule : ");
        }
        try {
            Integer lastHeight = 0;
            String nextHeight = flag.getStartPosition();
            if (nextHeight == null || "".equals(nextHeight)) {
                nextHeight = "0";
            }
            else {
                lastHeight = this.blockChainAdapter.getLastBlock().getResult().getBlock().getHeight();
                V2BlockScheduler.sLogger.info("[Block] LastBlock : {}", (Object)lastHeight);
            }
            try {
                final boolean isUpdate = this.blockChainService.blockChainSyncUpdate(Integer.valueOf(Integer.parseInt(nextHeight)), lastHeight);
                if (!isUpdate) {
                    this.scheduleService.inActiveBlockSchedule(this.resourceService.getServerName());
                    V2BlockScheduler.sLogger.info("block_start end type 1 " + i);
                    return;
                }
            }
            catch (Exception e) {
                V2BlockScheduler.sLogger.error("SyncUpdate error : {}", (Object)e.getMessage());
            }
            try {
                this.blockChainService.blockLimit(this.resourceService.getLimitBlock());
            }
            catch (Exception e) {
                V2BlockScheduler.sLogger.error("[Block] Excess Delete ERROR : {}", (Object)e.getMessage());
            }
            try {
                this.blockChainService.transactionLimit(this.resourceService.getLimitTx());
            }
            catch (Exception e) {
                V2BlockScheduler.sLogger.error("[Tx] Excess Delete ERROR : {}", (Object)e.getMessage());
            }
            try {
                this.blockChainService.addressLimit(this.resourceService.getLimitAddress());
            }
            catch (Exception e) {
                V2BlockScheduler.sLogger.error("[Address] Excess Delete ERROR : {}", (Object)e.getMessage());
            }
            try {
                this.blockChainService.updateMain();
            }
            catch (Exception e) {
                V2BlockScheduler.sLogger.error("[Main] Update ERROR : {}", (Object)e.getMessage());
            }
        }
        catch (Exception e2) {
            V2BlockScheduler.sLogger.error("[Block] Update ERROR : {}", (Object)e2.getMessage());
        }
        this.scheduleService.inActiveBlockSchedule(this.resourceService.getServerName());
        V2BlockScheduler.sLogger.info("block_start end" + i);
    }
    
    public void updateMainChartDailySync() {
        V2BlockScheduler.sLogger.info("--------------------");
        V2BlockScheduler.sLogger.info("[Main] DailyChart Update : {}", (Object)this.resourceService.getServerName());
        try {
            this.blockChainService.updateChart();
        }
        catch (Exception e) {
            V2BlockScheduler.sLogger.error("[Main] DailyChart Update ERROR : {}", (Object)e.getMessage());
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V2BlockScheduler.class);
        sLogger = LoggerFactory.getLogger("ScheduleLogger");
    }
}
