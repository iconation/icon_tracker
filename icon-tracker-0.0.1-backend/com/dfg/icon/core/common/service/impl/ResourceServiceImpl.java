// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.common.service.impl;

import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.common.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService
{
    private static final Logger logger;
    @Value("${server.name}")
    private String serverName;
    @Value("${block.scheduler.name}")
    private String blockSchedulerName;
    @Value("${block.scheduler.version}")
    private String blockSchedulerVersion;
    @Value("${exchange.scheduler.name}")
    private String exchangeSchedulerName;
    @Value("${limit.block}")
    private Integer limitBlock;
    @Value("${limit.transaction}")
    private Integer limitTransaction;
    @Value("${limit.address}")
    private Integer limitAddress;
    @Value("${limit.main.block}")
    private Integer limitMainBlock;
    @Value("${limit.main.tx}")
    private Integer limitMainTx;
    @Value("${config.useyn}")
    private Boolean configUseYn;
    @Value("${circulation.static}")
    private Integer circulationStatic;
    @Value("${line}")
    private Integer scoreAcceptMode;
    @Value("${log.speed}")
    private Integer logSpeed;
    @Value("${exchange.scheduler.active}")
    private Integer exchangeActive;
    @Value("${tracker.version}")
    private String trackerVersion;
    
    @PostConstruct
    private void init() {
        ResourceServiceImpl.logger.info("---------------");
        ResourceServiceImpl.logger.info("ServerName : {}", (Object)this.blockSchedulerName);
        ResourceServiceImpl.logger.info("SchedulerName : {}, {}", (Object)this.blockSchedulerName, (Object)this.exchangeSchedulerName);
        ResourceServiceImpl.logger.info("SchedulerVersion : {}", (Object)this.blockSchedulerVersion);
        ResourceServiceImpl.logger.info("limitBlock : {}", (Object)this.limitBlock);
        ResourceServiceImpl.logger.info("limitTx : {}", (Object)this.limitTransaction);
        ResourceServiceImpl.logger.info("limitAddress : {}", (Object)this.limitAddress);
        ResourceServiceImpl.logger.info("limitMainBlock : {}", (Object)this.limitMainBlock);
        ResourceServiceImpl.logger.info("limitMainTx : {}", (Object)this.limitMainTx);
        ResourceServiceImpl.logger.info("configUseYn : {}", (Object)this.configUseYn);
    }
    
    public String getServerName() {
        return this.serverName;
    }
    
    public String getBlockSchedulerName() {
        return this.blockSchedulerName;
    }
    
    public String getBlockSchedulerVersion() {
        return this.blockSchedulerVersion;
    }
    
    public String getExchangeSchedulerName() {
        return this.exchangeSchedulerName;
    }
    
    public Integer getLimitBlock() {
        return this.limitBlock;
    }
    
    public Integer getLimitTx() {
        return this.limitTransaction;
    }
    
    public Integer getLimitAddress() {
        return this.limitAddress;
    }
    
    public Integer getLimitMainBlock() {
        return this.limitMainBlock;
    }
    
    public Integer getLimitMainTx() {
        return this.limitMainTx;
    }
    
    public Boolean isAcceptMode() {
        return this.scoreAcceptMode > 0;
    }
    
    public Boolean isIcxStatic() {
        return this.circulationStatic > 0;
    }
    
    public Boolean isLogSpeed() {
        return this.logSpeed > 0;
    }
    
    public Boolean isExchangeActive() {
        return this.exchangeActive > 0;
    }
    
    public String getTrackerVersion() {
        return this.trackerVersion;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)ResourceServiceImpl.class);
    }
}
