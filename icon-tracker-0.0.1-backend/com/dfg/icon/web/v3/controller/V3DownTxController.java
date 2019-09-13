// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.util.Validator;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.impl.V3DownloadServiceImpl;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 download" })
@RequestMapping({ "v3/download" })
@RestController
public class V3DownTxController
{
    private static final Logger logger;
    @Autowired
    V3DownloadServiceImpl v3DownloadService;
    
    @ApiOperation(value = "byAddress/byDate, txList download", notes = "byAddress/byDate, txList download")
    @GetMapping({ "/txList" })
    public void downloadTxListCSV(final HttpServletResponse response, @RequestParam(value = "fromAddr", required = false) final String address, @RequestParam(value = "toAddr", required = false) final String address2, @RequestParam("startDate") final String startDate, @RequestParam("endDate") final String endDate) throws Exception {
        if (!Validator.isValidDatePattern(startDate)) {
            response.sendError(400, "wrong startDate");
        }
        else if (!Validator.isValidDatePattern(endDate)) {
            response.sendError(400, "wrong endDate");
        }
        else {
            final PageReq req = new PageReq();
            req.setAddress(address);
            req.setAddress2(address2);
            req.setStartDate(startDate);
            req.setEndDate(endDate);
            this.v3DownloadService.downloadList(req, response);
        }
    }
    
    @ApiOperation(value = "byAddress/byDate, txCount download", notes = "byAddress/byDate, txCount download \n\n type 0:fromAddr, 1:toAddr")
    @GetMapping({ "/txCount" })
    public void downloadTxCountCSV(final HttpServletResponse response, @RequestParam("startDate") final String startDate, @RequestParam("endDate") final String endDate, @RequestParam(value = "type", defaultValue = "0") final String type) throws Exception {
        if (!Validator.isValidDatePattern(startDate)) {
            response.sendError(400, "wrong startDate");
        }
        else if (!Validator.isValidDatePattern(endDate)) {
            response.sendError(400, "wrong endDate");
        }
        else if (!Validator.isValidDownType(type)) {
            response.sendError(400, "wrong type");
        }
        else {
            final PageReq req = new PageReq();
            req.setStartDate(startDate);
            req.setEndDate(endDate);
            req.setType(type);
            this.v3DownloadService.downloadCount(req, response);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3DownTxController.class);
    }
}
