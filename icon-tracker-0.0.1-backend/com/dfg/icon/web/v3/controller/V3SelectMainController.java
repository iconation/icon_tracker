// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v3.dto.IcxCirculation;
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
import com.dfg.icon.core.common.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0MainService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 main" })
@RequestMapping({ "v3/main" })
@RestController
public class V3SelectMainController
{
    private static final Logger logger;
    @Autowired
    V0MainService mainService;
    @Autowired
    ResourceService resourceService;
    
    @ApiOperation(value = "Information Summary , Daily Transactions , Recent Transactions , Recent Blocks ", notes = "outputvalue [ data : \uacb0\uacfc  ]")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/mainInfo" })
    public MainRes mainInfo() {
        final MainRes res = new MainRes();
        try {
            V3SelectMainController.logger.info("====================");
            V3SelectMainController.logger.info("main page information : {}");
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
            V3SelectMainController.logger.error("mainInfo", (Throwable)e);
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
            V3SelectMainController.logger.info("====================");
            V3SelectMainController.logger.info("main page daily chart : {}");
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
            V3SelectMainController.logger.error("mainChart", (Throwable)e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "\uc2e4\uc81c \uc720\ud1b5\ub7c9", notes = "\uc2e4 \uc720\ud1b5\ub7c9 \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/summary" })
    public SimpleRes mainSummary() {
        final SimpleRes res = new SimpleRes();
        try {
            V3SelectMainController.logger.info("====================");
            V3SelectMainController.logger.info("icx circulation request : {}");
            final MainInfo info = this.mainService.selectMainSummary();
            final IcxCirculation icx = new IcxCirculation();
            icx.setIcxCirculation(info.getIcxCirculationy());
            res.setResult("200");
            res.setDescription("success");
            res.setData((Object)icx);
        }
        catch (Exception e) {
            V3SelectMainController.logger.error("mainChart", (Throwable)e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "tracker version", notes = "get tracker version")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/version" })
    public SimpleRes getVersion() {
        final SimpleRes res = new SimpleRes();
        res.setResult("200");
        res.setDescription("success");
        res.setData((Object)this.resourceService.getTrackerVersion());
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SelectMainController.class);
    }
}
