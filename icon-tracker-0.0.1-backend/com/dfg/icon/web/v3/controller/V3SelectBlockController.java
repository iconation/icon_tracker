// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v0.dto.TxInBlock;
import java.util.List;
import com.dfg.icon.web.v0.dto.block.Block;
import com.dfg.icon.core.exception.IconException;
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
import com.dfg.icon.core.mappers.icon.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v3.service.V3BlockService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v3 block" })
@RequestMapping({ "v3/block" })
@RestController
public class V3SelectBlockController
{
    private static final Logger logger;
    @Autowired
    V3BlockService blockService;
    @Autowired
    BlockMapper blockMapper;
    
    @ApiOperation(value = "RecentBlock List \ud398\uc774\uc9d5 \uc870\ud68c", notes = "recentBlock list \uc870\ud68c")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/list" })
    public CommonListRes recentBlock(@Valid @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count) {
        try {
            V3SelectBlockController.logger.info("====================");
            V3SelectBlockController.logger.info("recentBlock : {}", (Object)page);
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            return this.blockService.selectRecentBlock(req);
        }
        catch (Exception e) {
            final CommonListRes res = new CommonListRes();
            CommonUtil.printException(V3SelectBlockController.logger, "recentBlockError : {}", e);
            res.setError();
            return res;
        }
    }
    
    @ApiOperation(value = "Block Detail and Transaction in the block", notes = "inputvalue [ height : \uc120\ud0dd\ud55c Block height \uac12  ] \n\noutputvalue [ data : \uacb0\uacfc (blockSize\ub294 \ud604\uc7ac \uc0ac\uc6a9\ud558\uc9c0 \uc54a\uc74c) , totalData: \ube14\ub85d\uc548\uc758 \ud2b8\ub79c\uc7ad\uc158 \uac2f\uc218 ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/info" })
    public CommonRes getBlockDetail(@Valid @RequestParam(value = "height", required = false) Integer height, @RequestParam(value = "hash", required = false) String hash, @RequestParam(value = "page", required = false) final Integer page) {
        final CommonRes cRes = new CommonRes();
        try {
            if ("".equals(height)) {
                height = null;
            }
            if ("".equals(hash)) {
                hash = null;
            }
            if (height == null && hash == null) {
                throw new IconException(IconCode.BLOCK_ERROR);
            }
            final PageReq req = new PageReq(10);
            req.setHeight(height);
            req.setHash(hash);
            req.setPage(CommonUtil.changeUnderZero(page));
            V3SelectBlockController.logger.info("====================");
            V3SelectBlockController.logger.info("blockDetail : {}");
            final Block blockDetail = this.blockService.selectBlockDetail(req);
            cRes.setData((Object)blockDetail);
            if (blockDetail == null) {
                cRes.setCode(IconCode.NO_DATA);
            }
            else {
                cRes.setCode(IconCode.SUCCESS);
            }
        }
        catch (Exception e) {
            V3SelectBlockController.logger.error("blockDetail", (Throwable)e);
            cRes.setError();
        }
        return cRes;
    }
    
    @ApiOperation(value = "Block Detail and Transaction in the block", notes = "inputvalue [ height : \uc120\ud0dd\ud55c Block height \uac12  ] \n\noutputvalue [ data : \uacb0\uacfc (blockSize\ub294 \ud604\uc7ac \uc0ac\uc6a9\ud558\uc9c0 \uc54a\uc74c) , totalData: \ube14\ub85d\uc548\uc758 \ud2b8\ub79c\uc7ad\uc158 \uac2f\uc218 ] \n\n\n\ntxType\n\ntype : 0 (icx transfer) \n\ntype : 1 (token transfer) \n\ntype : 2 (score call) \n\ntype : 3 (score install) \n\ntype : 4 (score update) \n\n")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/txList" })
    public CommonListRes getBlockTxList(@Valid @RequestParam(value = "height", required = false) final Integer height, @RequestParam(value = "hash", required = false) final String hash, @RequestParam(value = "page", required = false) final Integer page, @RequestParam(value = "count", required = false) final Integer count) {
        final CommonListRes cRes = new CommonListRes();
        try {
            if (height == null && hash == null) {
                throw new IconException(IconCode.BLOCK_ERROR);
            }
            final PageReq req = new PageReq(10);
            req.setHeight(height);
            req.setHash(hash);
            req.setPage(CommonUtil.changeUnderZero(page));
            if (count != null) {
                req.setCounting((int)count);
            }
            V3SelectBlockController.logger.info("====================");
            V3SelectBlockController.logger.info("blockDetail : {}");
            final List<TxInBlock> txInBlock = this.blockService.selectTxInBlock(req);
            cRes.setData((Object)txInBlock);
            if (txInBlock == null || txInBlock.size() == 0) {
                cRes.setListSize(0);
                cRes.setCode(IconCode.NO_DATA);
            }
            else {
                cRes.setListSize((int)this.blockMapper.selectTxCountInBlock(req));
                cRes.setCode(IconCode.SUCCESS);
            }
        }
        catch (Exception e) {
            V3SelectBlockController.logger.error("blockDetail", (Throwable)e);
            cRes.setError();
        }
        return cRes;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3SelectBlockController.class);
    }
}
