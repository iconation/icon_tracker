// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.web.v3.dto.SearchQuickInfo;
import java.util.List;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v3.dto.CommonListRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.V3SelectQuickSearchService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 selectQuickSearch" })
@RequestMapping({ "v3/selectQuickSearch" })
@RestController
public class V3selectQuickSearch
{
    private static final Logger logger;
    @Autowired
    V3SelectQuickSearchService v3SelectQuickSearchService;
    
    @ApiOperation(value = "selectQuickSearch", notes = "inputvalue [ text : \ud398\uc774\uc9c0   ]  outputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonListRes.class) })
    @GetMapping({ "/selectQuickSearch" })
    public CommonListRes selectQuickSearch(@Valid @RequestParam(value = "text", required = true) final String text) {
        final CommonListRes res = new CommonListRes();
        try {
            final List<SearchQuickInfo> searchDataList = this.v3SelectQuickSearchService.selectQuickSearch(text);
            res.setData((Object)searchDataList);
            res.setListSize(searchDataList.size());
            res.setCode(IconCode.SUCCESS);
        }
        catch (Exception e) {
            CommonUtil.printException(V3selectQuickSearch.logger, "selectQuickSearch :: {}", e);
            res.setError();
        }
        return res;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3selectQuickSearch.class);
    }
}
