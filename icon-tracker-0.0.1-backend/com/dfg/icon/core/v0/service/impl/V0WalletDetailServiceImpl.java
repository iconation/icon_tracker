// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import com.dfg.icon.web.v3.dto.TxDetail;
import com.dfg.icon.web.v0.dto.WalletInfoDto;
import com.dfg.icon.web.v0.dto.WalletTxReq;
import java.util.List;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.core.dao.icon.TMainInfo;
import com.dfg.icon.web.v0.dto.block.Address;
import java.math.BigDecimal;
import com.dfg.icon.core.dao.icon.TMainInfoExample;
import com.dfg.icon.core.dao.icon.TAddressExample;
import com.dfg.icon.web.v0.dto.CommonRes;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.mappers.icon.MainMapper;
import com.dfg.icon.core.mappers.icon.TMainInfoMapper;
import com.dfg.icon.core.mappers.icon.TransactionMapper;
import com.dfg.icon.core.mappers.icon.TAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.AddressMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.V0WalletDetailService;

@Service
public class V0WalletDetailServiceImpl implements V0WalletDetailService
{
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    TAddressMapper taddressMapper;
    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    TMainInfoMapper tMainInfoMapper;
    @Autowired
    MainMapper mainMapper;
    
    public CommonRes selectAddrList(final PageReq req) throws Exception {
        final CommonRes res = new CommonRes();
        final int page = (req.getPage() - 1) * 20;
        final List<Address> addr = this.addressMapper.selectAddrList(page);
        final String totalAddr = String.valueOf(this.taddressMapper.countByExample(new TAddressExample()));
        final TMainInfoExample mainInfo = new TMainInfoExample();
        final List<TMainInfo> info = this.tMainInfoMapper.selectByExample(mainInfo);
        final String rate = this.mainMapper.selectRate();
        final BigDecimal bigRate = new BigDecimal(rate);
        if (!info.isEmpty() && !addr.isEmpty()) {
            for (int i = 0; i < addr.size(); ++i) {
                final double icx = Double.parseDouble(addr.get(i).getBalance());
                final double totalIcx = Double.parseDouble(info.get(0).getIcxSupply());
                if (rate == null) {
                    res.setTotalData(totalAddr);
                    res.setCode(IconCode.NO_DATA);
                    return res;
                }
                final String balance = addr.get(i).getBalance();
                final BigDecimal bigBalance = new BigDecimal(balance);
                final BigDecimal icxUsd = bigRate.multiply(bigBalance);
                final String b = String.format("%.4f", bigBalance);
                addr.get(i).setBalance(b);
                addr.get(i).setIcxUsd(String.format("%.2f", icxUsd));
                addr.get(i).setPercentage(Double.parseDouble(String.format("%.2f", icx / totalIcx * 100.0)));
            }
            res.setData((Object)addr);
            res.setTotalData(totalAddr);
            res.setCode(IconCode.SUCCESS);
        }
        else {
            res.setTotalData(totalAddr);
            res.setCode(IconCode.NO_DATA);
        }
        return res;
    }
    
    public WalletInfoDto selectWalletDetail(final WalletTxReq req) throws Exception {
        final WalletInfoDto result = this.addressMapper.selectWalletInfo(req.getAddress());
        if (result == null) {
            return null;
        }
        if (this.mainMapper.selectRate() == null) {
            return null;
        }
        final String rate = this.mainMapper.selectRate();
        final BigDecimal bigRate = new BigDecimal(rate);
        final BigDecimal balance = new BigDecimal(result.getBalance());
        final BigDecimal icxUsd = bigRate.multiply(balance);
        result.setBalance(result.getBalance());
        result.setIcxUsd(String.format("%.2f", icxUsd));
        return result;
    }
    
    public List<TxDetail> selectWalletTx(final WalletTxReq req) throws Exception {
        final String fromAddr = req.getAddress();
        final String toAddr = req.getAddress();
        final String startDate = req.getStartDate() + " 00:00:00";
        final String endDate = req.getEndDate() + " 23:59:59";
        final PageReq pageReq = new PageReq(10);
        pageReq.setPage(Integer.valueOf((req.getPage() - 1) * pageReq.getCounting()));
        final List<TxDetail> result = this.transactionMapper.selectTotalTxList(pageReq);
        if (result == null) {
            return null;
        }
        return result;
    }
}
