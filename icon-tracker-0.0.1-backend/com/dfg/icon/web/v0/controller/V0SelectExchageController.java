// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v0.dto.CommonRes;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0ExchangeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "V0SelectExchageController" })
@RequestMapping({ "v0/exchange" })
@RestController
public class V0SelectExchageController
{
    @Autowired
    V0ExchangeService exchangeService;
    private static final Logger logger;
    
    @ApiOperation(value = "currentAllExchange", notes = "\ubaa8\ub4e0 \ucf54\uc778 \uc870\ud68c")
    @GetMapping({ "/currentAllExchange" })
    public CommonRes selectCurrentAllExchange() {
        final CommonRes res = new CommonRes();
        try {
            return this.exchangeService.selectCurrentAllExchange();
        }
        catch (Exception e) {
            V0SelectExchageController.logger.error("currentAllExchange", (Throwable)e);
            res.setError();
            return res;
        }
    }
    
    @ApiOperation(value = "currentExchange", notes = "\ud2b9\uc815 \ucf54\uc778  \uc870\ud68c/ ")
    @GetMapping({ "/currentExchange" })
    public CommonRes selectCurrentExchange(@Valid @RequestParam("code") final String code) {
        final CommonRes res = new CommonRes();
        try {
            return this.exchangeService.selectCurrentExchange(code);
        }
        catch (Exception e) {
            V0SelectExchageController.logger.error("currentExchange", (Throwable)e);
            res.setError();
            return res;
        }
    }
    
    @ApiOperation(value = "currentExchangeList", notes = "\ud2b9\uc815 \ucf54\uc778  \ub9ac\uc2a4\ud2b8\ub85c \uc870\ud68c/ \ucf64\ub9c8\ub85c \uad6c\ubd84 ")
    @GetMapping({ "/currentExchangeList" })
    public CommonRes selectCurrentExchangeList(@Valid @RequestParam("codeList") final String codeList) {
        final CommonRes res = new CommonRes();
        try {
            return this.exchangeService.selectCurrentExchangeList(codeList);
        }
        catch (Exception e) {
            V0SelectExchageController.logger.error("currentExchangeList", (Throwable)e);
            res.setError();
            return res;
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0SelectExchageController.class);
    }
}
