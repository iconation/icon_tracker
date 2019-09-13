// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.exception.IconCode;
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
import com.dfg.icon.core.v3.service.V3TransactionService;
import com.dfg.icon.core.v2.service.V2BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.V3AddressService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 address" })
@RequestMapping({ "v3/address" })
@RestController
public class V3SelectAddressController
{
    private static final Logger logger;
    @Autowired
    V3AddressService addressService;
    @Autowired
    V2BlockChainService blockChainService;
    @Autowired
    V3TransactionService transactionService;
    
    @ApiOperation(value = "\uc8fc\uc18c \ub9ac\uc2a4\ud2b8 \uc870\ud68c", notes = "address page, \uc8fc\uc18c \ub9ac\uc2a4\ud2b8 \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/list" })
    public CommonListRes addrList(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count) {
        try {
            V3SelectAddressController.logger.info("====================");
            V3SelectAddressController.logger.info("addressList : page = {}, count = {}", (Object)page, (Object)count);
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            return this.addressService.getAddressList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectAddressController.logger, "addrListError : {}", e);
            final CommonListRes cRes = new CommonListRes();
            cRes.setError();
            return cRes;
        }
    }
    
    @ApiOperation(value = "\uc8fc\uc18c \uc0c1\uc138\uc815\ubcf4 \uc870\ud68c", notes = "address page, \uc0c1\uc138 \uc815\ubcf4 \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/info" })
    public CommonRes addressInfo(@Valid @RequestParam("address") final String address) {
        try {
            final PageReq req = new PageReq();
            req.setAddress(address);
            V3SelectAddressController.logger.info("====================");
            V3SelectAddressController.logger.info("addressInfo : address = {}", (Object)address);
            return this.addressService.selectAddressInfo(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectAddressController.logger, "addressInfoError : {}", e);
            final CommonRes cRes = new CommonRes();
            cRes.setError();
            return cRes;
        }
    }
    
    @ApiOperation(value = "\uc8fc\uc18c\uc758 \uac70\ub798\ub0b4\uc5ed \uc870\ud68c", notes = "address page, \ud2b8\ub79c\uc7ad\uc158 \uc870\ud68c\n\ntxtype : 0 (icx transfer) \n\ntxType : 1 (token transfer) \n\ntxType : 2 (score call) \n\ntxType : 3 (score install) \n\ntxType : 4 (score update) \n\n\n\n pageKind : \uc774\uc804 \ud398\uc774\uc9c0\uba74 pre / \ub2e4\uc74c \ud398\uc774\uc9c0\uba74 next  \n\n id       : \uc774\uc804 \ud398\uc774\uc9c0\uba74 \ud604\uc7ac\ud654\uba74\uc758 \uccab\ubc88\uc9f8 \ub370\uc774\ud130 \uc544\uc774\ub514  / \ub2e4\uc74c \ud398\uc774\uc9c0\uba74 \uc774\uc804 \ud398\uc774\uc9c0\uba74 \ud604\uc7ac\ud654\uba74\uc758 \ub9c8\uc9c0\ub9c9 \ub370\uc774\ud130 \uc544\uc774\ub514 \n\n")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txList" })
    public CommonListRes addressTxList(@Valid @RequestParam("address") final String address, @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "type", required = false) final Integer type, @RequestParam(value = "id", required = false) final Integer id, @RequestParam(value = "pageKind", required = false) final String pageKind) {
        CommonListRes cRes = new CommonListRes();
        try {
            final PageReq req = new PageReq(10);
            if (count != null) {
                req.setCounting((int)count);
            }
            if (type != null && !"".equals(type)) {
                req.setTxType(type);
            }
            if (id != null && !"".equals(id)) {
                req.setId((int)id);
            }
            if (pageKind != null && !"".equals(pageKind)) {
                if (!pageKind.equals(IconCode.pageKind_Next) && !pageKind.equals(IconCode.pageKind_Pre)) {
                    throw new Exception();
                }
                req.setPageKind(pageKind);
            }
            req.setAddress(address);
            req.setPage(CommonUtil.changeUnderZero(page));
            V3SelectAddressController.logger.info("====================");
            V3SelectAddressController.logger.info("addressTxList : address = {} , page = {}, count = {} ", new Object[] { address, page, count });
            cRes = this.addressService.getAddressTxList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectAddressController.logger, "addressTxListError : {}", e);
            cRes.setError();
        }
        return cRes;
    }
    
    @ApiOperation(value = "\uc8fc\uc18c\uc758 \uac70\ub798\ub0b4\uc5ed \uc870\ud68c(\uc9c0\uac11\uc6a9)", notes = "address page, \ud2b8\ub79c\uc7ad\uc158 \uc870\ud68c\n\ntxtype : 0 (icx transfer) \n\ntxType : 1 (token transfer) \n\ntxType : 2 (score call) \n\ntxType : 3 (score install) \n\ntxType : 4 (score update) \n\n")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txListForWallet" })
    public CommonListRes addressTxListForWallet(@Valid @RequestParam("address") final String address, @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "type", required = false) final Integer type) {
        CommonListRes cRes = new CommonListRes();
        try {
            final PageReq req = new PageReq(10);
            if (count != null) {
                req.setCounting((int)count);
            }
            if (type != null && !"".equals(type)) {
                req.setTxType(type);
            }
            req.setAddress(address);
            req.setPage(CommonUtil.changeUnderZero(page));
            V3SelectAddressController.logger.info("====================");
            V3SelectAddressController.logger.info("addressTxListForWallet : address = {} , page = {}, count = {} ", new Object[] { address, page, count });
            cRes = this.addressService.getAddressTxListForWallet(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectAddressController.logger, "addressTxListError : {}", e);
            cRes.setError();
        }
        return cRes;
    }
    
    @ApiOperation(value = "\uc8fc\uc18c\uc758 \ud1a0\ud070 \uac70\ub798\ub0b4\uc5ed \uc870\ud68c", notes = "address page, \ud1a0\ud070 \ud2b8\ub79c\uc7ad\uc158 \uc870\ud68c\n\ncontractAddr\uc774 targetContractAddr\uacfc \ub3d9\uc77c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/tokenTxList" })
    public CommonListRes addressTokenTxList(@Valid @RequestParam("address") final String address, @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count) {
        CommonListRes cRes = new CommonListRes();
        try {
            final PageReq req = new PageReq();
            req.setAddress(address);
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            V3SelectAddressController.logger.info("====================");
            V3SelectAddressController.logger.info("addressTokenTxList :  page = {} , count = {}", (Object)page, (Object)count);
            cRes = this.addressService.selectAddressTokenTx(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectAddressController.logger, "addressTokenTxListError : {}", e);
            cRes.setError();
        }
        return cRes;
    }
    
    @ApiOperation(value = "\uc8fc\uc18c\uc758 Internal Tx \uc870\ud68c", notes = "address page, Internal Tx \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/internalTxList" })
    public CommonListRes addressInternalTxList(@Valid @RequestParam("address") final String address, @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count) {
        final CommonListRes cRes = new CommonListRes();
        try {
            V3SelectAddressController.logger.info("====================");
            V3SelectAddressController.logger.info("addressTokenTxList :  page = {} , count = {}", (Object)page, (Object)count);
            final PageReq req = new PageReq();
            req.setAddress2(address);
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            return this.transactionService.selectInternalTxList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectAddressController.logger, "addressTokenTxListError : {}", e);
            cRes.setError();
            return cRes;
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SelectAddressController.class);
    }
}
