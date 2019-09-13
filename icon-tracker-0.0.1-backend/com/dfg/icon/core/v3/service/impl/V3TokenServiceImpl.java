// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import com.dfg.icon.web.v3.dto.TokenHolder;
import com.dfg.icon.web.v3.dto.TokenTransfers;
import com.dfg.icon.core.dao.icon.TTokenTxViewExample;
import com.dfg.icon.web.v3.dto.TokenInfo;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;
import java.util.List;
import com.dfg.icon.core.dao.icon.TCurrentExchange;
import com.dfg.icon.core.dao.icon.TCurrentExchangeExample;
import com.dfg.icon.web.v3.dto.TokenSummary;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.core.dao.icon.TContractKey;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.web.v3.dto.CommonRes;
import com.dfg.icon.core.mappers.icon.ContractMapper;
import com.dfg.icon.core.mappers.icon.TCurrentExchangeMapper;
import com.dfg.icon.core.mappers.icon.TTxResultLogMapper;
import com.dfg.icon.core.mappers.icon.TTokenAddressMapper;
import com.dfg.icon.core.mappers.icon.TokenMapper;
import com.dfg.icon.core.mappers.icon.TTokenTxViewMapper;
import com.dfg.icon.core.mappers.icon.TTokenTxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TContractMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3TokenService;

@Service
public class V3TokenServiceImpl implements V3TokenService
{
    @Autowired
    TContractMapper tContractMapper;
    @Autowired
    TTokenTxMapper tTokenTxMapper;
    @Autowired
    TTokenTxViewMapper tTokenTxViewMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    TTokenAddressMapper tTokenAddressMapper;
    @Autowired
    TTxResultLogMapper tTxResultLogMapper;
    @Autowired
    TCurrentExchangeMapper tCurentExchangeMapper;
    @Autowired
    ContractMapper contractMapper;
    
    public CommonRes selectTokenSummary(final String contractAddr) throws Exception {
        final CommonRes res = new CommonRes();
        final TContract key = new TContract();
        key.setContractAddr(contractAddr);
        final TContract tokenInfo = this.tContractMapper.selectByPrimaryKey(key);
        if (tokenInfo == null) {
            res.setData((Object)"");
            res.setCode(IconCode.ERROR);
        }
        else {
            final TokenSummary summary = new TokenSummary();
            summary.setTokenSummary(tokenInfo);
            final String totalSupply = tokenInfo.getTotalSupply();
            final String symbol = tokenInfo.getSymbol();
            final String tradeName = symbol + "usd";
            final TCurrentExchangeExample exchange = new TCurrentExchangeExample();
            exchange.createCriteria().andTradeNameEqualTo(tradeName);
            final List<TCurrentExchange> exchangeList = this.tCurentExchangeMapper.selectByExample(exchange);
            if (exchangeList.size() > 0) {
                final String exchangePrice = exchangeList.get(0).getPrice();
                final Double usdPrice = Double.valueOf(exchangePrice);
                summary.setTotalSupplyUsd(Double.valueOf(Double.valueOf(totalSupply) * Double.valueOf(exchangePrice)));
                summary.setPriceUsd(usdPrice);
            }
            res.setData((Object)summary);
            res.setCode(IconCode.SUCCESS);
        }
        return res;
    }
    
    public CommonListRes selectTokenList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        final List<TokenInfo> tokenInfoList = this.tokenMapper.selectTokenInfoList(req);
        res.setData((Object)tokenInfoList);
        res.setListSize((int)this.tokenMapper.selectTokenInfoTotalCount(req));
        res.setTotalSize(res.getListSize());
        if (tokenInfoList == null || tokenInfoList.size() == 0) {
            res.setCode(IconCode.NO_DATA);
        }
        else {
            res.setCode(IconCode.SUCCESS);
        }
        return res;
    }
    
    public CommonListRes selectTokenTransfers(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        Integer totalTxCount = 0;
        if (req.getAddress() == null) {
            totalTxCount = this.tokenMapper.selectTotalTxCount();
        }
        else if (req.getAddress2() == null) {
            final TContract tokenInfo = this.getTokenInfoByAddress(req.getAddress());
            if (tokenInfo != null) {
                totalTxCount = tokenInfo.getTransferCount();
            }
            else {
                totalTxCount = 0;
            }
        }
        else {
            final TTokenTxViewExample txViewExample = new TTokenTxViewExample();
            txViewExample.createCriteria().andContractAddrEqualTo(req.getAddress()).andAddressEqualTo(req.getAddress2());
            totalTxCount = (int)this.tTokenTxViewMapper.countByExample(txViewExample);
        }
        if (totalTxCount == null || req.getPage() > totalTxCount) {
            res.setCode(IconCode.NO_DATA);
        }
        else {
            List<String> tokenTxHashList = null;
            if (req.getAddress2() == null) {
                tokenTxHashList = this.tokenMapper.selectTokenTransferListTxByTokenAddr(req);
            }
            else {
                tokenTxHashList = this.tokenMapper.selectTokenTransferListTx(req);
            }
            if (tokenTxHashList.size() > 0) {
                final List<TokenTransfers> tokenTxList = this.tokenMapper.selectTokenTransferListTxData(tokenTxHashList);
                res.setData((Object)tokenTxList);
                if (req.getAddress() == null) {
                    res.setListSize((int)totalTxCount);
                    res.setTotalSize((int)totalTxCount);
                }
                else {
                    res.setListSize((int)totalTxCount);
                    res.setTotalSize((int)totalTxCount);
                }
                res.setCode(IconCode.SUCCESS);
            }
            else {
                res.setListSize(0);
                res.setTotalSize(0);
                res.setCode(IconCode.NO_DATA);
            }
        }
        return res;
    }
    
    public CommonListRes selectTokenHolders(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        final TContract tokenInfo = this.getTokenInfoByAddress(req.getAddress());
        if (tokenInfo != null) {
            req.setIcxSupply(tokenInfo.getTotalSupply());
        }
        final List<TokenHolder> addrInfo = this.tokenMapper.selectTokenHolders(req);
        res.setData((Object)addrInfo);
        if (addrInfo == null) {
            res.setListSize(0);
            res.setTotalSize(0);
            res.setCode(IconCode.NO_DATA);
        }
        else {
            final Integer listSize = this.tokenMapper.selectTotalCountHoderList(req);
            res.setListSize((int)listSize);
            res.setTotalSize((int)listSize);
            res.setData((Object)addrInfo);
            res.setCode(IconCode.SUCCESS);
        }
        return res;
    }
    
    public TContract getTokenInfoByAddress(final String contractAddr) {
        final TContractKey key = new TContractKey();
        key.setContractAddr(contractAddr);
        return this.tContractMapper.selectByPrimaryKey(key);
    }
}
