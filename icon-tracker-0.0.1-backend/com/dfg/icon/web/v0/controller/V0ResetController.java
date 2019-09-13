// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v3.dto.CommonRes;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0ResetService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v1 reset" })
@RequestMapping({ "v1/reset" })
@RestController
public class V0ResetController
{
    @Autowired
    V0ResetService resetService;
    private static final Logger logger;
    
    @ApiOperation("privateDev DB \ucd08\uae30\ud654 ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = String.class), @ApiResponse(code = 400, message = "fail", response = String.class) })
    @RequestMapping(value = { "privateDevReset" }, method = { RequestMethod.POST }, produces = { "application/json" })
    public CommonRes privateDevReset() throws Exception {
        V0ResetController.logger.info("====================");
        V0ResetController.logger.info("PrivateDev DB Reset");
        return this.resetService.privateDevReset();
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0ResetController.class);
    }
}
