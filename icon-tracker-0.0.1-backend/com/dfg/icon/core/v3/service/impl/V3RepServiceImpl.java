// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v3.dto.RecentBlock;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v3.dto.CRepBlocksQueryRequest;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PRepList;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.mappers.icon.CRepBlocksMapper;
import com.dfg.icon.core.mappers.icon.PRepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TAddressPrepMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class V3RepServiceImpl
{
    private static final Logger logger;
    @Autowired
    TAddressPrepMapper tAddressPrepMapper;
    @Autowired
    PRepMapper pRepMapper;
    @Autowired
    CRepBlocksMapper cRepBlocksMapper;
    
    public List<PRepList> selectAddressPrepList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        return this.pRepMapper.selectPRepList(req);
    }
    
    public int selectAddressPrepListCount(final PageReq req) throws Exception {
        return this.pRepMapper.selectPRepListCount(req);
    }
    
    public CommonListRes findBlocksByCRepAddress(final String cRepAddress, final Integer page, final Integer count) {
        V3RepServiceImpl.logger.info("====================");
        V3RepServiceImpl.logger.info("findBlocksByCRepId : cRepId = {} page = {}, count = {}", new Object[] { cRepAddress, page, count });
        final int formattedPage = CommonUtil.changeUnderZero(page);
        final CRepBlocksQueryRequest request = new CRepBlocksQueryRequest(cRepAddress, Integer.valueOf((formattedPage - 1) * count), count);
        final List<RecentBlock> cRepBlocks = this.cRepBlocksMapper.selectBlocksProducedByCRep(request);
        final CommonListRes response = new CommonListRes();
        if (cRepBlocks.size() == 0 || cRepBlocks == null) {
            response.setData((Object)"");
            response.setListSize(0);
            response.setTotalSize(0);
            response.setCode(IconCode.NO_DATA);
        }
        else {
            response.setData((Object)cRepBlocks);
            response.setListSize(cRepBlocks.size());
            response.setTotalSize(response.getListSize());
            response.setCode(IconCode.SUCCESS);
        }
        return response;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3RepServiceImpl.class);
    }
}
