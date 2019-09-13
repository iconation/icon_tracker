// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v3.dto.CommonListRes;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v3.dto.CommonRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.V3TokenService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 token" })
@RequestMapping({ "v3/token" })
@RestController
public class V3SelectTokenController
{
    private static final Logger logger;
    @Autowired
    V3TokenService tokenService;
    
    @ApiOperation(value = "Token Summary", notes = "inputvalue [contracktAddr : \ucee8\ud2b8\ub799\ud2b8 \uc8fc\uc18c] \n\n outputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/summary" })
    public CommonRes getTokenSummary(@Valid @RequestParam(value = "contractAddr", required = true) final String contractAddr) {
        CommonRes res = new CommonRes();
        try {
            V3SelectTokenController.logger.info("====================");
            V3SelectTokenController.logger.info("getTokenSummary : contractAddr = {}", (Object)contractAddr);
            res = this.tokenService.selectTokenSummary(contractAddr);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectTokenController.logger, "getTokenSummary error : {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Token List", notes = "inputvalue [page : \ud398\uc774\uc9c0, count : \ud398\uc774\uc9d5 \uac2f\uc218 ] \n\noutputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/list" })
    public CommonListRes getTokenList(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "keyword", required = false) final String keyword) {
        CommonListRes res = new CommonListRes();
        try {
            V3SelectTokenController.logger.info("====================");
            V3SelectTokenController.logger.info("getTokenList : page = {}, count = {}", (Object)page, (Object)count);
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (keyword != null && !"".equals(keyword)) {
                if (keyword.length() > 2) {
                    if ("cx".equals(keyword.toLowerCase().substring(0, 2))) {
                        req.setAddress(keyword);
                    }
                    else if ("hx".equals(keyword.toLowerCase().substring(0, 2))) {
                        req.setAddress2(keyword);
                    }
                    else {
                        req.setKeyword(keyword.toLowerCase());
                    }
                }
                else {
                    req.setKeyword(keyword.toLowerCase());
                }
            }
            res = this.tokenService.selectTokenList(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectTokenController.logger, "getTokenList error : {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Token Transfers", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 , count : \ud398\uc774\uc9d5 \uac2f\uc218 , contractAddr : \ucee8\ud2b8\ub799\ud2b8 \uc8fc\uc18c ] \n\noutputvalue [ data : \uacb0\uacfc  ] \n\ntoken TtxList\uc758 contractAddr\ub9cc targetContractAddr\uacfc \ub3d9\uc77c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txList" })
    public CommonListRes getTokenTransfers(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam(value = "contractAddr", required = false) final String contractAddr, @RequestParam(value = "tokenAddr", required = false) final String tokenAddr) {
        CommonListRes res = new CommonListRes();
        try {
            V3SelectTokenController.logger.info("====================");
            V3SelectTokenController.logger.info("getTokenTransfers : page ={} , count={} , contractAddr = {}, tokenAddr = {}", new Object[] { page, count, contractAddr, tokenAddr });
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            if (contractAddr != null && !"".equals(contractAddr)) {
                req.setAddress(contractAddr);
            }
            if (tokenAddr != null && !"".equals(tokenAddr)) {
                req.setAddress2(tokenAddr);
            }
            res = this.tokenService.selectTokenTransfers(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectTokenController.logger, "getTokenTransfers error : {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "Token Holders", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 ,count : \ud398\uc774\uc9d5 \uac2f\uc218 , contracktAddr : \ucee8\ud2b8\ub799\ud2b8 \uc8fc\uc18c] \n\n outputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/holders" })
    public CommonListRes getTokenHolders(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count, @RequestParam("contractAddr") final String contractAddr) {
        CommonListRes res = new CommonListRes();
        try {
            V3SelectTokenController.logger.info("====================");
            V3SelectTokenController.logger.info("getTokenHolders : page = {}, count = {}, contractAddr = {}", new Object[] { page, count, contractAddr });
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            req.setAddress(contractAddr);
            res = this.tokenService.selectTokenHolders(req);
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectTokenController.logger, "getTokenHolders error : {}", e);
            res.setError();
        }
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SelectTokenController.class);
    }
}
