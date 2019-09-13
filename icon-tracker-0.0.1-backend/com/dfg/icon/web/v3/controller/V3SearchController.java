// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import com.dfg.icon.web.v0.dto.CommonRes;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v0.dto.SearchReq;
import com.dfg.icon.web.v0.dto.SearchRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0SearchService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 search" })
@RequestMapping({ "v3/search" })
@RestController
public class V3SearchController
{
    private static final Logger logger;
    @Autowired
    V0SearchService searchService;
    
    @ApiOperation(value = "Block Serch (height , hash) , Tx Search", notes = "inputvalue [Block Hash : \ube14\ub85d \ud574\uc26c \uac12 , Tx Hash : Tx \ud574\uc26c \uac12] \n\noutputvalue [ data : \ube14\ub85d \ud574\uc26c , \ud2b8\ub79c\uc7ad\uc158 \ud574\uc26c \ud310\ubcc4  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/Search" })
    public SearchRes search(@Valid @RequestParam("data") final String data) {
        final SearchRes res = new SearchRes();
        try {
            final SearchReq req = new SearchReq();
            req.setData(data);
            V3SearchController.logger.info("====================");
            V3SearchController.logger.info("search : {}");
            res.setData((Object)this.searchService.search(req));
        }
        catch (Exception e) {
            V3SearchController.logger.error("Search", (Throwable)e);
            res.setError();
        }
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SearchController.class);
    }
}
