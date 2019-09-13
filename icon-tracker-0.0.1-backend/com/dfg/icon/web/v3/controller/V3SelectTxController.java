// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import com.dfg.icon.web.v3.dto.CommonRes;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v3.dto.CommonListRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.V3TransactionService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 transaction" })
@RequestMapping({ "v3/transaction" })
@RestController
public class V3SelectTxController
{
    private static final Logger logger;
    @Autowired
    V3TransactionService transactionService;
    
    @ApiOperation(value = "tx \ud398\uc774\uc9d5 \uc870\ud68c", notes = "tx page, \ub9ac\uc2a4\ud2b8 \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/recentTx" })
    public CommonListRes recentTxList(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count) {
        try {
            V3SelectTxController.logger.info("====================");
            V3SelectTxController.logger.info("recentTx : {}");
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            return this.transactionService.selectRecentTx(req);
        }
        catch (Exception e) {
            final CommonListRes cRes = new CommonListRes();
            CommonUtil.printException(V3SelectTxController.logger, "recentTxList Error {}", e);
            cRes.setError();
            return cRes;
        }
    }
    
    @ApiOperation(value = "Tx \uc0c1\uc138 \uc870\ud68c", notes = "txType\n\ntype : 0 (icx transfer) \n\ntype : 1 (token transfer) \n\ntype : 2 (score call) \n\ntype : 3 (score install) \n\ntype : 4 (score update) \n\n")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txDetail" })
    public CommonRes getTxDetail(@Valid @RequestParam("txHash") String txHash) {
        try {
            V3SelectTxController.logger.info("====================");
            V3SelectTxController.logger.info("txDetail : {}", (Object)txHash);
            final StringBuffer hexPrefixSb = new StringBuffer();
            hexPrefixSb.append("0x");
            if (!txHash.startsWith(hexPrefixSb.toString())) {
                txHash = hexPrefixSb.append(txHash).toString();
            }
            return this.transactionService.selectTxDetail(txHash);
        }
        catch (Exception e) {
            final CommonRes cRes = new CommonRes();
            CommonUtil.printException(V3SelectTxController.logger, "getTxDetail Error {}", e);
            cRes.setError();
            return cRes;
        }
    }
    
    @ApiOperation(value = "Internal Transaction List", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 , count : \ud398\uc774\uc9d5 \uac1c\uc218, txHash : \ud2b8\ub79c\uc7ad\uc158 \ud574\uc2dc] \n\noutputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/internalTxList" })
    public CommonListRes getInternalTxList(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "txHash", required = false) final String txHash) {
        CommonListRes res = new CommonListRes();
        try {
            V3SelectTxController.logger.info("====================");
            V3SelectTxController.logger.info("getInternalTxList : page={} , count={} , txHash={} ", new Object[] { page, count, txHash });
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (txHash != null && !"".equals(txHash)) {
                req.setTxHash(txHash);
            }
            res = this.transactionService.selectInternalTxList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectTxController.logger, "getInternalTxList error : {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Transaction EventLogList", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 , count : \ud398\uc774\uc9d5 \uac2f\uc218  , txHash: txHash] \n\noutputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/eventLogList" })
    public CommonListRes getTxEventLogList(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "txHash", required = false) final String txHash) {
        CommonListRes res = new CommonListRes();
        try {
            V3SelectTxController.logger.info("====================");
            V3SelectTxController.logger.info("getTokenEventLogList : page={} , count={} , txHash={} ", new Object[] { page, count, txHash });
            final PageReq req = new PageReq(10);
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (txHash != null && !"".equals(txHash)) {
                req.setTxHash(txHash);
            }
            res = this.transactionService.selectTxEventLogList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectTxController.logger, "getTokenEventLogList error : {}", e);
            res.setError();
        }
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SelectTxController.class);
    }
}
