// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import com.dfg.icon.core.dao.icon.TTransactionExample;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.v3.vo.DecimalType;
import com.dfg.icon.web.v3.dto.TxDetail;
import com.dfg.icon.core.exception.IconCode;
import java.util.List;
import com.dfg.icon.util.FormatUtil;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.web.v0.dto.CommonRes;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.mappers.icon.TTransactionMapper;
import com.dfg.icon.core.mappers.icon.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TMainTxMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.V0TransactionService;

@Service
public class V0TransactionServiceImpl implements V0TransactionService
{
    @Autowired
    TMainTxMapper tMainTxMapper;
    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    TTransactionMapper tTransactionMapper;
    
    public CommonRes selectRecentTx(final PageReq req) throws Exception {
        final CommonRes res = new CommonRes();
        req.setPage(Integer.valueOf((CommonUtil.changeUnderZero(req.getPage()) - 1) * 20));
        List<TxDetail> list = this.transactionMapper.selectRecentTxList(req);
        if (!list.isEmpty()) {
            final String total = this.getTxCount();
            list = (List<TxDetail>)FormatUtil.txDetailFormat((List)list);
            res.setData((Object)list);
            res.setTotalData(total);
            res.setCode(IconCode.SUCCESS);
        }
        else {
            res.setData((Object)list);
            res.setTotalData("");
            res.setCode(IconCode.NO_DATA);
        }
        return res;
    }
    
    public CommonRes selectTxDetail(final PageReq req) throws Exception {
        final CommonRes res = new CommonRes();
        final TxDetail result = this.transactionMapper.selectTxDetail(req.getTxHash());
        final Integer height = this.transactionMapper.selectTxHeight(req.getTxHash());
        final Integer lastHeight = this.transactionMapper.selectLastBlockHeight();
        if (result != null && height != null && lastHeight != null) {
            final int confirmation = lastHeight - height + 1;
            final String amount = HexUtil.decimalFormat(result.getAmount(), DecimalType.ICX.getValue());
            result.setStatus("Successfully Confirmed");
            result.setConfirmation(Integer.valueOf(confirmation));
            result.setAmount(amount);
            res.setData((Object)result);
            res.setTotalData("");
            res.setCode(IconCode.SUCCESS);
        }
        else {
            res.setData((Object)result);
            res.setTotalData("");
            res.setCode(IconCode.NO_DATA);
        }
        return res;
    }
    
    private String getTxCount() {
        final long txCnt = this.tTransactionMapper.countByExample(new TTransactionExample());
        return String.valueOf(txCnt);
    }
}
