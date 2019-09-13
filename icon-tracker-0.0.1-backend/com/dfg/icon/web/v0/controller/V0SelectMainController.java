// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.dao.icon.TMainChart;
import com.dfg.icon.web.v0.dto.SimpleRes;
import org.springframework.web.bind.annotation.GetMapping;
import com.dfg.icon.web.v0.dto.CommonRes;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v0.dto.main.MainBlock;
import com.dfg.icon.core.dao.icon.TMainTx;
import com.dfg.icon.web.v0.dto.main.MainInfo;
import java.util.List;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v0.dto.main.MainRes;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0MainService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v0 main" })
@RequestMapping({ "v0/main" })
@RestController
public class V0SelectMainController
{
    private static final Logger logger;
    @Autowired
    V0MainService mainService;
    
    @ApiOperation(value = "Information Summary , Daily Transactions , Recent Transactions , Recent Blocks ", notes = "outputvalue [ data : \uacb0\uacfc  ]")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/mainInfo" })
    public MainRes mainInfo() {
        final MainRes res = new MainRes();
        try {
            V0SelectMainController.logger.info("====================");
            V0SelectMainController.logger.info("main page information : {}");
            final MainInfo mainSummary = this.mainService.selectMainSummary();
            final List<TMainTx> mainTx = this.mainService.selectRecentTx();
            final List<MainBlock> mainBlock = this.mainService.selectRecentBlock();
            if (mainSummary == null || mainTx == null || mainBlock == null) {
                res.setCode(IconCode.NO_DATA);
            }
            else {
                res.setTmainInfo(mainSummary);
                res.setTmainTx((List)mainTx);
                res.setTmainBlock((List)mainBlock);
                res.setCode(IconCode.SUCCESS);
            }
            return res;
        }
        catch (Exception e) {
            V0SelectMainController.logger.error("mainInfo", (Throwable)e);
            res.setError();
            return res;
        }
    }
    
    @ApiOperation(value = "Daily Transactions", notes = "outputvalue [ data : \uacb0\uacfc  ]")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/mainChart" })
    public SimpleRes mainChart() {
        final SimpleRes res = new SimpleRes();
        try {
            V0SelectMainController.logger.info("====================");
            V0SelectMainController.logger.info("main page daily chart : {}");
            final List<TMainChart> dailyTx = this.mainService.SelectDailyTx();
            if (dailyTx == null) {
                res.setCode(IconCode.NO_DATA);
            }
            else {
                res.setData((Object)dailyTx);
                res.setCode(IconCode.SUCCESS);
            }
        }
        catch (Exception e) {
            V0SelectMainController.logger.error("mainChart", (Throwable)e);
            res.setError();
        }
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0SelectMainController.class);
    }
}
