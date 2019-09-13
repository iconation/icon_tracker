// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v3.dto.ContractInfo;
import com.dfg.icon.web.v3.dto.CommonRes;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v3.dto.CommonListRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import com.dfg.icon.core.v3.service.V3TransactionService;
import com.dfg.icon.core.v3.service.V3AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.V3ContractService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 Contract" })
@RequestMapping({ "v3/contract" })
@RestController
public class V3SelectContractController
{
    private static final Logger logger;
    @Autowired
    V3ContractService v3ContractService;
    @Autowired
    V3AddressService addressService;
    @Autowired
    V3TransactionService transactionService;
    
    @ApiOperation(value = "Contract List", notes = "inputvalue [ page : \ud398\uc774\uc9c0   ]  outputvalue [ data : \uacb0\uacfc   ( state ->[0: \ub300\uae30 1: \uc131\uacf5 2: \uc2e4\ud328]  ) ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/list" })
    public CommonListRes selectContractList(@Valid @RequestParam(value = "page", required = false, defaultValue = "1") final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "status", required = false) final Integer status, @RequestParam(value = "keyword", required = false) final String keyword) {
        final CommonListRes res = new CommonListRes();
        try {
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (status != null) {
                req.setState(status);
            }
            if (keyword != null && !"".equals(keyword)) {
                if (keyword.length() > 2 && "cx".equals(keyword.toLowerCase().substring(0, 2))) {
                    req.setAddress(keyword);
                }
                else {
                    req.setKeyword(keyword.toLowerCase());
                }
            }
            res.setListSize(this.v3ContractService.selectContractListCount(req));
            if (res.getListSize() > 0) {
                res.setData((Object)this.v3ContractService.selectContractList(req));
                res.setCode(IconCode.SUCCESS);
            }
            else {
                res.setCode(IconCode.NO_DATA);
            }
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract Info", notes = "inputvalue [ addr : \uc8fc\uc18c]  outputvalue [ data : \uacb0\uacfc  ( state ->[0: \ub300\uae30 1: \uc131\uacf5 2: \uc2e4\ud328]  ) ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/info" })
    public CommonRes selectContractInfo(@Valid @RequestParam(value = "addr", required = true) final String addr) {
        final CommonRes res = new CommonRes();
        try {
            final ContractInfo result = this.v3ContractService.selectContractInfo(addr);
            res.setData((result == null) ? IconCode.NO_DATA : result);
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractInfo :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract Detail", notes = " outputvalue [ data : \uacb0\uacfc   ( state ->[0: \ub300\uae30 1: \uc131\uacf5 2: \uc2e4\ud328]  ) ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/detail" })
    public CommonRes selectContractDetail(@Valid @RequestParam(value = "contractAddr", required = true) final String contractAddr) {
        final CommonRes res = new CommonRes();
        try {
            final PageReq req = new PageReq();
            req.setAddress(contractAddr);
            res.setData((Object)this.v3ContractService.selectContractDetail(req));
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract Transaction \uc870\ud68c ", notes = "inputvalue [addr : \ucee8\ud2b8\ub809\ud2b8 \uc8fc\uc18c , page : \ud398\uc774\uc9c0 ]  outputvalue [ data : \uacb0\uacfc  ] \n\n\n\ntxType\n\ntype : 0 (icx transfer) \n\ntype : 1 (token transfer) \n\ntype : 2 (score call) \n\ntype : 3 (score install) \n\ntype : 4 (score update) \n\n")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txList" })
    public CommonListRes selectContractTransactionList(@Valid @RequestParam(value = "addr", required = true) final String addr, @RequestParam(value = "page", required = false, defaultValue = "1") final int page, @RequestParam(value = "count", required = false) final Integer count) {
        CommonListRes res = new CommonListRes();
        try {
            final PageReq req = new PageReq(10);
            if (count != null) {
                req.setCounting((int)count);
            }
            req.setAddress(addr);
            req.setPage(CommonUtil.changeUnderZero(page));
            res = this.v3ContractService.selectContractTxList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractTransactionList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract Token Transfers \uc870\ud68c ", notes = "inputvalue [addr : \ucee8\ud2b8\ub809\ud2b8 \uc8fc\uc18c , page : \ud398\uc774\uc9c0 ]  outputvalue [ data : \uacb0\uacfc   ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/tokenTxList" })
    public CommonListRes selectContractTokenTransferList(@Valid @RequestParam(value = "addr", required = true) final String addr, @RequestParam(value = "page", required = false, defaultValue = "1") final int page, @RequestParam(value = "count", required = false, defaultValue = "10") final Integer count) {
        final CommonListRes res = new CommonListRes();
        try {
            res.setListSize(this.v3ContractService.selectContractTokenTransferListCount(addr));
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (res.getListSize() != 0) {
                res.setData((Object)this.v3ContractService.selectContractTokenTransferList(addr, req));
            }
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractTokenTransferList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract Internal Tx \uc870\ud68c ", notes = "inputvalue [addr : \ucee8\ud2b8\ub809\ud2b8 \uc8fc\uc18c , page : \ud398\uc774\uc9c0 ]  outputvalue [ data : \uacb0\uacfc   ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/internalTxList" })
    public CommonListRes selectContractInternalTransferList(@Valid @RequestParam(value = "addr", required = true) final String addr, @RequestParam(value = "page", required = false, defaultValue = "1") final int page, @RequestParam(value = "count", required = false, defaultValue = "10") final Integer count) {
        CommonListRes res = new CommonListRes();
        try {
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            req.setAddress(addr);
            res = this.transactionService.selectInternalTxList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractInternalTxList Error : {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract History \uc870\ud68c ", notes = "inputvalue [addr : \ucee8\ud2b8\ub809\ud2b8 \uc8fc\uc18c , page : \ud398\uc774\uc9c0 ]  outputvalue [ data : \uacb0\uacfc  ( state ->[0: \ub300\uae30 1: \uc131\uacf5 2: \uc2e4\ud328]  )  ]  ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/historyList" })
    public CommonListRes selectContractHistoryList(@Valid @RequestParam(value = "addr", required = false) final String addr, @RequestParam(value = "page", required = false, defaultValue = "1") final int page, @RequestParam(value = "count", required = false, defaultValue = "10") final Integer count) {
        final CommonListRes res = new CommonListRes();
        try {
            final int listpage = CommonUtil.changeUnderZero(page);
            res.setData((Object)this.v3ContractService.selectContractHistoryList(addr, listpage, count));
            res.setListSize(this.v3ContractService.selectContractHistoryListCount(addr));
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractTokenTransferList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract EventLogList", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 , count : \ud398\uc774\uc9d5 \uac2f\uc218  ,contractAddr: \ucee8\ud2b8\ub799\ud2b8 \uc8fc\uc18c ,txHash: txHash] \n\noutputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/eventLogList" })
    public CommonListRes getTokenEventLogList(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "contractAddr", required = false) final String contractAddr, @RequestParam(value = "txHash", required = false) final String txHash) {
        CommonListRes res = new CommonListRes();
        try {
            V3SelectContractController.logger.info("====================");
            V3SelectContractController.logger.info("getTokenEventLogList : page={} , count={} ,contractHash={}, txHash={} ", new Object[] { page, count, contractAddr, txHash });
            final PageReq req = new PageReq(10);
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (contractAddr != null && !"".equals(contractAddr)) {
                req.setAddress(contractAddr);
            }
            if (txHash != null && !"".equals(txHash)) {
                req.setTxHash(txHash);
            }
            res = this.v3ContractService.selectTokenEventLogList(req);
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "getTokenEventLogList error : {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Contract History \uc870\ud68c ", notes = "inputvalue [addr : \ucee8\ud2b8\ub809\ud2b8 \uc8fc\uc18c , page : \ud398\uc774\uc9c0 ]  outputvalue [ data : \uacb0\uacfc  ( state ->[0: \ub300\uae30 1: \uc131\uacf5 2: \uc2e4\ud328]  )  ]  ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/pendingList" })
    public CommonListRes selectRequireContractList(@Valid @RequestParam(value = "page", required = false, defaultValue = "1") final int page, @RequestParam(value = "count", required = false, defaultValue = "10") final Integer count) {
        final CommonListRes res = new CommonListRes();
        try {
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            req.setCounting((int)count);
            res.setData((Object)this.v3ContractService.selectRequireContractList(req));
            res.setListSize(this.v3ContractService.selectRequireContractListCount());
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectContractController.logger, "selectContractTokenTransferList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SelectContractController.class);
    }
}
