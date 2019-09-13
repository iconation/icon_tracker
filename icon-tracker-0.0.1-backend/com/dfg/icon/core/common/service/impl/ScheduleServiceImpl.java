// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.common.service.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.util.DateUtil;
import com.dfg.icon.core.dao.icon.TSchedulerFlagKey;
import com.dfg.icon.core.dao.icon.TSchedulerFlag;
import com.dfg.icon.core.common.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TSchedulerFlagMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.common.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService
{
    private static final Logger logger;
    @Autowired
    private TSchedulerFlagMapper tSchedulerFlagMapper;
    @Autowired
    private ResourceService resourceService;
    
    public TSchedulerFlag activeBlockSchedule(final String server) {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getBlockSchedulerName());
        TSchedulerFlag flag = this.tSchedulerFlagMapper.selectByPrimaryKey(key);
        if (flag == null) {
            flag = new TSchedulerFlag();
            flag.setScheduleName(this.resourceService.getBlockSchedulerName());
            flag.setActiveYn("Y");
            flag.setActiveServer(server);
            flag.setStartPosition("0");
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.insert(flag);
        }
        else if (!"P".equals(flag.getActiveYn())) {
            if (!"R".equals(flag.getActiveYn())) {
                flag.setActiveYn("Y");
                flag.setActiveServer(server);
                flag.setUpdateDate(DateUtil.getNowDate());
                this.tSchedulerFlagMapper.updateByPrimaryKey(flag);
            }
        }
        return flag;
    }
    
    public TSchedulerFlag inActiveBlockSchedule(final String server) {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getBlockSchedulerName());
        TSchedulerFlag flag = this.tSchedulerFlagMapper.selectByPrimaryKey(key);
        if (flag == null) {
            flag = new TSchedulerFlag();
            flag.setScheduleName(this.resourceService.getBlockSchedulerName());
            flag.setActiveYn("N");
            flag.setActiveServer(server);
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.insert(flag);
        }
        else {
            if ("Y".equals(flag.getActiveYn())) {
                flag.setActiveYn("N");
            }
            else if ("R".equals(flag.getActiveYn())) {
                flag.setActiveYn("P");
            }
            flag.setActiveServer(server);
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.updateByPrimaryKey(flag);
        }
        return flag;
    }
    
    public void updateBlockScheduler(final String nextPosition) {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getBlockSchedulerName());
        final TSchedulerFlag flag = this.tSchedulerFlagMapper.selectByPrimaryKey(key);
        flag.setStartPosition(nextPosition);
        this.tSchedulerFlagMapper.updateByPrimaryKey(flag);
    }
    
    public void activeExchangeSchedule(final String server) {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getExchangeSchedulerName());
        TSchedulerFlag flag = this.tSchedulerFlagMapper.selectByPrimaryKey(key);
        if (flag == null) {
            flag = new TSchedulerFlag();
            flag.setScheduleName(this.resourceService.getExchangeSchedulerName());
            flag.setActiveYn("Y");
            flag.setActiveServer(server);
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.insert(flag);
        }
        else {
            flag.setActiveYn("Y");
            flag.setActiveServer(server);
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.updateByPrimaryKey(flag);
        }
    }
    
    public void inActiveExchangeSchedule(final String server) {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getExchangeSchedulerName());
        TSchedulerFlag flag = this.tSchedulerFlagMapper.selectByPrimaryKey(key);
        if (flag == null) {
            flag = new TSchedulerFlag();
            flag.setScheduleName(this.resourceService.getExchangeSchedulerName());
            flag.setActiveYn("N");
            flag.setActiveServer(server);
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.insert(flag);
        }
        else {
            flag.setActiveYn("N");
            flag.setActiveServer(server);
            flag.setUpdateDate(DateUtil.getNowDate());
            this.tSchedulerFlagMapper.updateByPrimaryKey(flag);
        }
    }
    
    public TSchedulerFlag getBlockSchedule() {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getBlockSchedulerName());
        return this.tSchedulerFlagMapper.selectByPrimaryKey(key);
    }
    
    public TSchedulerFlag getExchangeSchedule() {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(this.resourceService.getExchangeSchedulerName());
        return this.tSchedulerFlagMapper.selectByPrimaryKey(key);
    }
    
    public TSchedulerFlag getSchedule(final String name) {
        final TSchedulerFlagKey key = new TSchedulerFlagKey();
        key.setScheduleName(name);
        return this.tSchedulerFlagMapper.selectByPrimaryKey(key);
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)ScheduleServiceImpl.class);
    }
}
