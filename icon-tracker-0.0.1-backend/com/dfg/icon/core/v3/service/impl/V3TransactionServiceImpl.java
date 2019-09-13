// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import com.dfg.icon.web.v0.dto.main.MainInfo;
import com.dfg.icon.web.v3.dto.TxEventLogList;
import com.dfg.icon.web.v3.dto.InternalTx;
import java.util.Iterator;
import com.dfg.icon.web.v3.dto.TxDetail;
import com.dfg.icon.web.v3.dto.ContractVersion;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.web.v3.dto.TxDetailTokenTx;
import com.dfg.icon.core.v3.vo.TxStateEnum;
import com.dfg.icon.core.dao.icon.TCurrentExchange;
import com.dfg.icon.core.dao.icon.TCurrentExchangeExample;
import com.dfg.icon.web.v3.dto.CommonRes;
import com.dfg.icon.web.v3.dto.TxDetailDto;
import java.util.List;
import com.dfg.icon.util.FormatUtil;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.common.service.ResourceService;
import com.dfg.icon.core.mappers.icon.MainMapper;
import com.dfg.icon.core.mappers.icon.TCurrentExchangeMapper;
import com.dfg.icon.core.mappers.icon.ContractMapper;
import com.dfg.icon.core.mappers.icon.TTransactionMapper;
import com.dfg.icon.core.mappers.icon.TransactionV3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TMainTxMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3TransactionService;

@Service
public class V3TransactionServiceImpl implements V3TransactionService
{
    @Autowired
    TMainTxMapper tMainTxMapper;
    @Autowired
    TransactionV3Mapper transactionV3Mapper;
    @Autowired
    TTransactionMapper tTransactionMapper;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    TCurrentExchangeMapper tCurentExchangeMapper;
    @Autowired
    MainMapper mainMapper;
    @Autowired
    private ResourceService resourceService;
    
    public CommonListRes selectRecentTx(final PageReq req) throws Exception {
        final CommonListRes res = new CommonListRes();
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final int totalTxCount = this.getTxCount().intValue();
        if (req.getPage() > totalTxCount) {
            res.setCode(IconCode.NO_DATA);
        }
        else {
            final List<TxDetailDto> list = this.transactionV3Mapper.selectRecentTxList(req);
            if (!list.isEmpty()) {
                res.setData((Object)FormatUtil.txDetailV3Format((List)list));
                if (this.resourceService.getLimitTx() > totalTxCount) {
                    res.setListSize(totalTxCount);
                }
                else {
                    res.setListSize((int)this.resourceService.getLimitTx());
                }
                res.setTotalSize(totalTxCount);
                res.setCode(IconCode.SUCCESS);
            }
            else {
                res.setData((Object)list);
                res.setListSize(0);
                res.setTotalSize(0);
                res.setCode(IconCode.NO_DATA);
            }
        }
        return res;
    }
    
    public CommonRes selectTxDetail(final String txHash) throws Exception {
        final CommonRes res = new CommonRes();
        final TxDetail result = this.transactionV3Mapper.selectTxDetail(txHash);
        final Integer lastHeightTx = this.transactionV3Mapper.selectLastBlockHeight();
        if (result != null && lastHeightTx != null) {
            final Integer txHeight = result.getHeight();
            final int confirmation = lastHeightTx - txHeight + 1;
            final TCurrentExchangeExample exchange = new TCurrentExchangeExample();
            exchange.createCriteria().andTradeNameEqualTo("icxusd");
            final String icxUsd = this.tCurentExchangeMapper.selectByExample(exchange).get(0).getPrice();
            final Double feeUsd = Double.parseDouble(icxUsd) * Double.parseDouble(result.getFee());
            result.setFeeUsd(String.valueOf(feeUsd));
            result.setStatus(TxStateEnum.getDetailByState(result.getState()));
            result.setConfirmation(Integer.valueOf(confirmation));
            result.setInternalTxList((List)this.transactionV3Mapper.selectInternalTx(txHash));
            result.setTokenTxList((List)this.transactionV3Mapper.selectTokenTx(txHash));
            for (final TxDetailTokenTx tx : result.getTokenTxList()) {
                tx.setTargetContractAddr(result.getTargetContractAddr());
            }
            final TContractHistory history = new TContractHistory();
            List<ContractVersion> versionList = null;
            if (IconCode.SCORE_INSTALL_ADDR.getCode().equals(result.getToAddr())) {
                history.setCreateTx(txHash);
                versionList = this.contractMapper.selectContractVersion(history);
            }
            else if (IconCode.SCORE_CONTROL_ADDR.getCode().equals(result.getToAddr())) {
                history.setVerifiedTx(txHash);
                versionList = this.contractMapper.selectContractVersion(history);
            }
            else if (result.getToAddr().startsWith("cx") && IconCode.TX_TYPE_UPDATE.getCode().equals(result.getTxType())) {
                history.setCreateTx(txHash);
                versionList = this.contractMapper.selectContractVersion(history);
            }
            if (versionList != null && versionList.size() > 0) {
                result.setContractVersion(versionList.get(0).getVersion());
            }
            res.setCode(IconCode.SUCCESS);
        }
        else {
            res.setCode(IconCode.NO_DATA);
        }
        res.setData((Object)result);
        return res;
    }
    
    public CommonListRes selectInternalTxList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        final List<InternalTx> txList = this.transactionV3Mapper.selectInternalTxPaging(req);
        if (txList != null && txList.size() > 0) {
            res.setCode(IconCode.SUCCESS);
            res.setListSize((int)this.transactionV3Mapper.selectInternalTxCount(req));
            res.setTotalSize(res.getListSize());
        }
        else {
            res.setCode(IconCode.NO_DATA);
            res.setListSize(0);
            res.setTotalSize(0);
        }
        res.setData((Object)txList);
        return res;
    }
    
    public CommonListRes selectTxEventLogList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        final List<TxEventLogList> resultLog = this.transactionV3Mapper.selectEventLogList(req);
        res.setData((Object)resultLog);
        if (resultLog == null) {
            res.setListSize(0);
            res.setTotalSize(0);
            res.setCode(IconCode.NO_DATA);
        }
        else {
            final Integer listSize = this.transactionV3Mapper.selectTotalCountEventLog(req);
            res.setListSize((int)listSize);
            res.setTotalSize((int)listSize);
            res.setCode(IconCode.SUCCESS);
        }
        return res;
    }
    
    private Long getTxCount() {
        final MainInfo mainInfo = this.mainMapper.selectMainInfo();
        return (long)mainInfo.getTransactionCount();
    }
}
