// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v0.controller;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v0.dto.TxInBlock;
import com.dfg.icon.web.v0.dto.block.Block;
import java.util.List;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v0.dto.BlockRes;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.web.v0.dto.CommonRes;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import com.dfg.icon.core.mappers.icon.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.v0.service.V0BlockService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;

@Api(tags = { "v0 block" })
@RequestMapping({ "v0/block" })
@RestController
public class V0SelectBlockController
{
    private static final Logger logger;
    @Autowired
    V0BlockService blockService;
    @Autowired
    BlockMapper blockMapper;
    
    @ApiOperation(value = "RecentBlock List", notes = "inputvalue [ page : \ubcf4\ub824\ud558\ub294 \ud398\uc774\uc9c0 ] \n\noutputvalue [ data : \uacb0\uacfc  ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/recentBlock" })
    public CommonRes recentBlock(@Valid @RequestParam(value = "page", required = false) final Integer page) {
        final CommonRes res = new CommonRes();
        try {
            V0SelectBlockController.logger.info("====================");
            V0SelectBlockController.logger.info("recentBlock : {}", (Object)page);
            final PageReq req = new PageReq();
            req.setPage(CommonUtil.changeUnderZero(page));
            return this.blockService.selectRecentBlock(req);
        }
        catch (Exception e) {
            V0SelectBlockController.logger.error("recentBlock", (Throwable)e);
            res.setError();
            return res;
        }
    }
    
    @ApiOperation(value = "Block Detail and Transaction in the block", notes = "inputvalue [ height : \uc120\ud0dd\ud55c Block height \uac12  ] \n\noutputvalue [ data : \uacb0\uacfc (blockSize\ub294 \ud604\uc7ac \uc0ac\uc6a9\ud558\uc9c0 \uc54a\uc74c) , totalData: \ube14\ub85d\uc548\uc758 \ud2b8\ub79c\uc7ad\uc158 \uac2f\uc218 ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/blockDetail" })
    public CommonRes blockDetail(@Valid @RequestParam("height") final Integer height, @RequestParam(value = "page", required = false) final Integer page) {
        final CommonRes cRes = new CommonRes();
        try {
            final PageReq req = new PageReq();
            req.setHeight(height);
            req.setPage(CommonUtil.changeUnderZero(page));
            V0SelectBlockController.logger.info("====================");
            V0SelectBlockController.logger.info("blockDetail : {}");
            final BlockRes res = new BlockRes();
            final Block blockDetail = this.blockService.selectBlockDetail(req);
            final List<TxInBlock> txInBlock = this.blockService.selectTxInBlock(req);
            if (blockDetail == null) {
                cRes.setData((Object)res);
                cRes.setTotalData("");
                cRes.setCode(IconCode.NO_DATA);
            }
            else {
                res.setBlockDetail(blockDetail);
                res.setTxInBlock((List)txInBlock);
                cRes.setData((Object)res);
                cRes.setTotalData(String.valueOf(this.blockMapper.selectTotalTxInBlock(req.getHeight())));
                cRes.setCode(IconCode.SUCCESS);
            }
        }
        catch (Exception e) {
            V0SelectBlockController.logger.error("blockDetail", (Throwable)e);
            cRes.setError();
        }
        return cRes;
    }
    
    @ApiOperation(value = "Block Detail and Tx in the Block By hash", notes = "inputvalue [ hash : \uc120\ud0dd\ud55c Block hash \uac12  ] \n\noutputvalue [ data : \uacb0\uacfc (blockSize\ub294 \ud604\uc7ac \uc0ac\uc6a9\ud558\uc9c0 \uc54a\uc74c) , totalData: \ube14\ub85d\uc548\uc758 \ud2b8\ub79c\uc7ad\uc158 \uac2f\uc218 ] ")
    @ApiResponses({ @ApiResponse(code = 200, message = "Success", response = CommonRes.class) })
    @GetMapping({ "/blockDetailByHash" })
    public CommonRes blockDetailByHash(@Valid @RequestParam("hash") final String hash, @RequestParam(value = "page", required = false) final Integer page) {
        final CommonRes cRes = new CommonRes();
        try {
            final PageReq req = new PageReq();
            req.setHash(hash);
            req.setPage(page);
            if (req.getPage() == null) {
                req.setPage(Integer.valueOf(1));
            }
            V0SelectBlockController.logger.info("====================");
            V0SelectBlockController.logger.info("blockDetailByHash : {}");
            final BlockRes res = new BlockRes();
            final Block blockDetailByHash = this.blockService.selectBlockDetailByHash(req);
            final List<TxInBlock> txInBlockByHash = this.blockService.selectTxInBlockByHash(req);
            if (blockDetailByHash == null) {
                cRes.setData((Object)res);
                cRes.setTotalData("");
                cRes.setCode(IconCode.NO_DATA);
            }
            else {
                res.setBlockDetail(blockDetailByHash);
                res.setTxInBlock((List)txInBlockByHash);
                cRes.setData((Object)res);
                cRes.setTotalData(String.valueOf(this.blockMapper.selectTotalTxInBlockByHash(req.getHash())));
                cRes.setCode(IconCode.SUCCESS);
            }
        }
        catch (Exception e) {
            V0SelectBlockController.logger.error("blockDetailByHash", (Throwable)e);
            cRes.setError();
        }
        return cRes;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V0SelectBlockController.class);
    }
}
