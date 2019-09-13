// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.scheduler;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import com.dfg.icon.core.dao.icon.TSchedulerFlag;
import com.dfg.icon.util.CommonUtil;
import java.util.Random;
import com.dfg.icon.util.DateUtil;
import com.dfg.icon.core.v3.service.V3SelectQuickSearchService;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.common.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0ExchangeService;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class V0ExchangeScheduler
{
    private static final Logger logger;
    private static final Logger sLogger;
    @Autowired
    private V0ExchangeService v0ExchangeService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private V3SelectQuickSearchService v3SelectQuickSearchService;
    
    @Scheduled(cron = "${exchange.cron.pattern}")
    public void exchangeUpdate() {
        if (!this.resourceService.isExchangeActive()) {
            return;
        }
        final TSchedulerFlag flag = this.scheduleService.getExchangeSchedule();
        if (flag == null || "N".equals(flag.getActiveYn())) {
            this.scheduleService.activeExchangeSchedule(this.resourceService.getServerName());
        }
        else {
            if (DateUtil.getNowDate().getTime() - flag.getUpdateDate().getTime() < 180000L) {
                return;
            }
            this.scheduleService.activeExchangeSchedule(this.resourceService.getServerName());
            V0ExchangeScheduler.sLogger.info("--------------------");
            V0ExchangeScheduler.sLogger.info("[Exchange] Ignore flag and continue schedule : ");
        }
        final Random generator = new Random();
        final int randomKey = generator.nextInt();
        try {
            V0ExchangeScheduler.sLogger.info("Exchage_update_start " + randomKey);
            this.v0ExchangeService.updateExchange();
        }
        catch (Exception e) {
            CommonUtil.printException(V0ExchangeScheduler.sLogger, "[Exchange] Update Error : {}", e);
        }
        finally {
            this.scheduleService.inActiveExchangeSchedule(this.resourceService.getServerName());
            V0ExchangeScheduler.sLogger.info("Exchage_update_start end" + randomKey);
        }
    }
    
    public void quickSearchUpdate() {
        try {
            this.v3SelectQuickSearchService.selectSearchMapData();
        }
        catch (Exception e) {
            CommonUtil.printException(V0ExchangeScheduler.sLogger, "searchMapUpdate : {}", e);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0ExchangeScheduler.class);
        sLogger = LoggerFactory.getLogger("ScheduleLogger");
    }
}
