// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import com.dfg.icon.web.v0.dto.TxInBlock;
import com.dfg.icon.core.dao.icon.TTxDataKey;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.v3.vo.DecimalType;
import com.dfg.icon.web.v0.dto.block.Block;
import com.dfg.icon.web.v3.dto.RecentBlock;
import java.util.List;
import com.dfg.icon.util.FormatUtil;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.mappers.icon.TTxDataMapper;
import com.dfg.icon.core.mappers.icon.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TMainTxMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3BlockService;

@Service
public class V3BlockServiceImpl implements V3BlockService
{
    @Autowired
    TMainTxMapper tMainTxMapper;
    @Autowired
    BlockMapper blockMapper;
    @Autowired
    TTxDataMapper tTxDataMapper;
    
    public CommonListRes selectRecentBlock(final PageReq req) throws Exception {
        final CommonListRes res = new CommonListRes();
        final int count = req.getCounting();
        req.setPage(Integer.valueOf((req.getPage() - 1) * count));
        final String total = this.blockMapper.selectTotalBlock();
        if (total == null) {
            res.setData((Object)"");
            res.setListSize(0);
            res.setTotalSize(0);
            res.setCode(IconCode.NO_DATA);
        }
        else {
            List<RecentBlock> list = this.blockMapper.selectRecentBlock(req);
            list = (List<RecentBlock>)FormatUtil.blockFormat((List)list);
            res.setData((Object)list);
            res.setListSize((int)Integer.valueOf(total));
            res.setTotalSize((int)Integer.valueOf(total));
            res.setCode(IconCode.SUCCESS);
        }
        return res;
    }
    
    public Block selectBlockDetail(final PageReq req) throws Exception {
        final Block result = this.blockMapper.selectBlockDetail(req);
        if (result == null) {
            return result;
        }
        final Block data = this.blockMapper.selectLastBlock();
        if (!"".equals(result.getAmount()) && !"-".equals(result.getAmount())) {
            final String amount = HexUtil.decimalFormat(result.getAmount(), DecimalType.ICX.getValue());
            result.setAmount(amount);
        }
        final int lastBlock = data.getHeight();
        if (result.getHeight() == lastBlock) {
            result.setLastBlock("Last Block");
        }
        else {
            result.setLastBlock("-");
        }
        if (result.getHeight() == 0) {
            final TTxDataKey key = new TTxData();
            key.setTxHash(result.getHash());
            final TTxData genesis = this.tTxDataMapper.selectByPrimaryKey(key);
            result.setMessage(genesis.getDataBody());
        }
        return result;
    }
    
    public List<TxInBlock> selectTxInBlock(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final List<TxInBlock> result = this.blockMapper.selectTxInBlock(req);
        for (int i = 0; i < result.size(); ++i) {
            final double amount = Double.parseDouble(result.get(i).getAmount());
            final String b = String.format("%.4f", amount);
            result.get(i).setAmount(b);
        }
        return result;
    }
    
    public Block selectBlockDetailByHash(final PageReq req) throws Exception {
        final Block result = this.blockMapper.selectBlockDetail(req);
        if (result == null) {
            return result;
        }
        final Block data = this.blockMapper.selectLastBlock();
        final int lastBlock = data.getHeight();
        if (result.getHeight() == lastBlock) {
            result.setLastBlock("Last Block");
        }
        else {
            result.setLastBlock("-");
        }
        if (result.getHeight() == 0) {
            final TTxDataKey key = new TTxData();
            key.setTxHash(result.getHash());
            final TTxData genesis = this.tTxDataMapper.selectByPrimaryKey(key);
            result.setMessage(genesis.getDataBody());
        }
        return result;
    }
    
    public List<TxInBlock> selectTxInBlockByHash(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final List<TxInBlock> result = this.blockMapper.selectTxInBlockByHash(req);
        return result;
    }
}
