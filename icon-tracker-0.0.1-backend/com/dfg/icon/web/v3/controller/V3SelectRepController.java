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
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v3.dto.CommonListRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.impl.V3RepServiceImpl;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@Api(tags = { "v3 Rep" })
@RestController
@RequestMapping({ "v3/rep" })
public class V3SelectRepController
{
    private static final Logger log;
    @Autowired
    V3RepServiceImpl v3RepService;
    
    @ApiOperation(value = "PRep List \ud398\uc774\uc9d5 \uc870\ud68c", notes = "PRep list \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/pRepList" })
    public CommonListRes selectPRepList(@Valid @RequestParam(value = "page", required = false, defaultValue = "1") final Integer page, @RequestParam(value = "count", required = false, defaultValue = "20") final Integer count) {
        final CommonListRes res = new CommonListRes();
        try {
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            res.setListSize(this.v3RepService.selectAddressPrepListCount(req));
            if (res.getListSize() > 0) {
                res.setData((Object)this.v3RepService.selectAddressPrepList(req));
                res.setCode(IconCode.SUCCESS);
            }
            else {
                res.setCode(IconCode.NO_DATA);
            }
        }
        catch (Exception e) {
            CommonUtil.printException(V3SelectRepController.log, "selectPRepList :: {}", e);
            res.setError();
        }
        return res;
    }
    
    @ApiOperation(value = "\ud2b9\uc815 C-Rep\uac00 \uc0dd\uc131\ud55c \ube14\ub85d \ubaa9\ub85d \uc870\ud68c", notes = "\ud2b9\uc815 C-Rep\uac00 \uc0dd\uc131\ud55c \ube14\ub85d \ubaa9\ub85d \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/producedBlock/list" })
    public CommonListRes retreiveBlocksByCRepAddress(@Valid @RequestParam final String cRepAddress, @RequestParam(value = "page", required = false, defaultValue = "1") final Integer page, @RequestParam(value = "count", required = false, defaultValue = "20") final Integer count) {
        try {
            return this.v3RepService.findBlocksByCRepAddress(cRepAddress, page, count);
        }
        catch (Exception e) {
            final CommonListRes errorResponse = new CommonListRes();
            errorResponse.setError();
            return errorResponse;
        }
    }
    
    static {
        log = LoggerFactory.getLogger((Class)V3SelectRepController.class);
    }
}
