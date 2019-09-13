// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v0.dto.CommonRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0TransactionService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v0 transaction" })
@RequestMapping({ "v0/transaction" })
@RestController
public class V0SelectTxController
{
    private static final Logger logger;
    @Autowired
    V0TransactionService transactionService;
    
    @ApiOperation(value = "RecentTx List", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 ] \n\noutputvalue [ data : \uacb0\uacfc  , totalData: \ud2b8\ub79c\uc7ad\uc158 \ucd1d \uac2f\uc218 ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/recentTx" })
    public CommonRes recentTxList(@Valid @RequestParam(value = "page", required = false) final Integer page) {
        final CommonRes cRes = new CommonRes();
        try {
            final PageReq req = new PageReq();
            req.setPage(page);
            if (req.getPage() == null) {
                req.setPage(Integer.valueOf(1));
            }
            V0SelectTxController.logger.info("====================");
            V0SelectTxController.logger.info("recentTx : {}");
            return this.transactionService.selectRecentTx(req);
        }
        catch (Exception e) {
            V0SelectTxController.logger.error("recentTx", (Throwable)e);
            cRes.setError();
            return cRes;
        }
    }
    
    @ApiOperation(value = "Transaction Detail", notes = "inputvalue [ txHash : \uc120\ud0dd\ud55c txHash \uac12  ] \n\noutputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txDetail" })
    public CommonRes txDetail(@Valid @RequestParam("txHash") final String txHash) {
        final CommonRes cRes = new CommonRes();
        try {
            final PageReq req = new PageReq();
            req.setTxHash(txHash);
            V0SelectTxController.logger.info("====================");
            V0SelectTxController.logger.info("txDetail : {}", (Object)req.toString());
            return this.transactionService.selectTxDetail(req);
        }
        catch (Exception e) {
            V0SelectTxController.logger.error("txDetail", (Throwable)e);
            cRes.setError();
            return cRes;
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0SelectTxController.class);
    }
}
