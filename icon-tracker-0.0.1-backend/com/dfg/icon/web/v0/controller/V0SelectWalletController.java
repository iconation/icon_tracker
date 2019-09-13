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
import org.springframework.beans.factory.annotation.Value;
import com.dfg.icon.core.mappers.icon.TransactionMapper;
import com.dfg.icon.core.mappers.icon.AddressMapper;
import com.dfg.icon.core.v2.service.V2BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0WalletDetailService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v0 wallet" })
@RequestMapping({ "v0/wallet" })
@RestController
public class V0SelectWalletController
{
    private static final Logger logger;
    @Autowired
    V0WalletDetailService walletDetailService;
    @Autowired
    V2BlockChainService blockChainService;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    TransactionMapper transactionMapper;
    @Value("${server.url}")
    String serverUrl;
    @Value("${qrCode.path}")
    String qrcodePath;
    
    @ApiOperation(value = "Addresses List", notes = "outputvalue [ data : \uacb0\uacfc , totalData: \ucd1d \uc8fc\uc18c \uac2f\uc218  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/addrList" })
    public CommonRes addrList(@Valid @RequestParam(value = "page", required = false) final Integer page) {
        final CommonRes cRes = new CommonRes();
        final PageReq req = new PageReq();
        try {
            req.setPage(page);
            if (req.getPage() == null) {
                req.setPage(Integer.valueOf(1));
            }
            V0SelectWalletController.logger.info("====================");
            V0SelectWalletController.logger.info("addrList : {}");
            return this.walletDetailService.selectAddrList(req);
        }
        catch (Exception e) {
            V0SelectWalletController.logger.error("addrList", (Throwable)e);
            cRes.setError();
            return cRes;
        }
    }
    
    @GetMapping({ "/balance" })
    public String getBalance(@Valid @RequestParam("address") final String address) {
        try {
            V0SelectWalletController.logger.info("====================");
            V0SelectWalletController.logger.info("[balance] address : {}", (Object)address);
            return this.blockChainService.getBalance(address);
        }
        catch (Exception e) {
            V0SelectWalletController.logger.error("balance", (Throwable)e);
            return null;
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0SelectWalletController.class);
    }
}
