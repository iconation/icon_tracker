// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import com.dfg.icon.core.v3.vo.GenesisRpcRes;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.v3.vo.DecimalType;
import com.dfg.icon.core.v2.vo.GenesisAccVo;
import com.dfg.icon.core.v3.vo.GenesisTransactionVo;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.core.dao.icon.TTokenTxExample;
import com.dfg.icon.web.v3.dto.TokenTxDetail;
import java.util.Iterator;
import com.dfg.icon.web.v3.dto.IdAndHashDto;
import com.dfg.icon.web.v3.dto.TxDetailDto;
import com.dfg.icon.web.v3.dto.TokenAddress;
import com.dfg.icon.web.v3.dto.AddressInfo;
import com.dfg.icon.web.v3.dto.CommonRes;
import com.dfg.icon.web.v3.dto.AddressDto;
import java.util.List;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.core.dao.icon.TMainInfo;
import com.dfg.icon.core.dao.icon.TMainInfoExample;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.mappers.icon.ContractMapper;
import com.dfg.icon.core.v3.adapter.V3BlockChainAdapter;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.mappers.icon.ResetMapper;
import com.dfg.icon.core.mappers.icon.MainMapper;
import com.dfg.icon.core.mappers.icon.TMainInfoMapper;
import com.dfg.icon.core.mappers.icon.TTokenTxMapper;
import com.dfg.icon.core.mappers.icon.TTokenAddressMapper;
import com.dfg.icon.core.mappers.icon.TAddressTotalMapper;
import com.dfg.icon.core.mappers.icon.TAddressMapper;
import com.dfg.icon.core.mappers.icon.TransactionV3Mapper;
import com.dfg.icon.core.mappers.icon.TTransactionTotalMapper;
import com.dfg.icon.core.mappers.icon.TokenMapper;
import com.dfg.icon.core.mappers.icon.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3AddressService;

@Service
public class V3AddressServiceImpl implements V3AddressService
{
    @Autowired
    V3AddressService addressService;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    TTransactionTotalMapper tTransactionTotalMapper;
    @Autowired
    TransactionV3Mapper transactionV3Mapper;
    @Autowired
    TAddressMapper tAddressMapper;
    @Autowired
    TAddressTotalMapper tAddressTotalMapper;
    @Autowired
    TTokenAddressMapper tTokenAddressMapper;
    @Autowired
    TTokenTxMapper tTokenTxMapper;
    @Autowired
    TMainInfoMapper tMainInfoMapper;
    @Autowired
    MainMapper mainMapper;
    @Autowired
    ResetMapper resetMapper;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    V3BlockChainAdapter blockChainAdapter;
    @Autowired
    ContractMapper contractMapper;
    
    public CommonListRes getAddressList(final PageReq req) throws Exception {
        final CommonListRes res = new CommonListRes();
        final int page = (req.getPage() - 1) * req.getCounting();
        req.setPage(Integer.valueOf(page));
        final List<TMainInfo> mainInfo = this.tMainInfoMapper.selectByExample(new TMainInfoExample());
        if (mainInfo != null && mainInfo.size() > 0) {
            req.setIcxSupply(mainInfo.get(0).getIcxSupply());
        }
        req.setIcxUsd(this.mainMapper.selectRate());
        final List<AddressDto> addr = this.addressMapper.selectAddrListV3(req);
        final Integer totalAddr = this.addressMapper.selectCountAddrlist();
        res.setData((Object)addr);
        res.setListSize((int)totalAddr);
        if (addr != null || addr.size() > 0) {
            res.setCode(IconCode.SUCCESS);
        }
        else {
            res.setCode(IconCode.NO_DATA);
        }
        return res;
    }
    
    public CommonRes selectAddressInfo(final PageReq req) throws Exception {
        final CommonRes res = new CommonRes();
        final String rate = this.mainMapper.selectRate();
        req.setIcxUsd(rate);
        AddressInfo result = this.addressMapper.selectAddressInfo(req);
        final List<TokenAddress> tokenAddrList = this.tokenMapper.selectQuantityByAddress(req);
        final Integer tokenTxCount = this.tokenMapper.selectTokenAddrCount(req);
        if (result == null) {
            if (tokenAddrList == null || tokenAddrList.size() == 0) {
                res.setCode(IconCode.NO_DATA);
                return res;
            }
            result = new AddressInfo();
            result.setAddress(req.getAddress());
            result.setBalance("0");
            result.setIcxUsd("0");
            result.setNodeType("-");
            result.setTxCount(Integer.valueOf(0));
        }
        result.setTokenList((List)tokenAddrList);
        result.setTokenTxCount(tokenTxCount);
        req.setAddress2(req.getAddress());
        req.setAddress((String)null);
        final Integer internalTxCount = this.transactionV3Mapper.selectInternalTxCount(req);
        result.setInternalTxCount(internalTxCount);
        res.setCode(IconCode.SUCCESS);
        res.setData((Object)result);
        return res;
    }
    
    public CommonListRes getAddressTxList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes cRes = new CommonListRes();
        final int totalTxCount = this.getTxCount(req.getAddress()).intValue();
        if (req.getPage() > totalTxCount) {
            cRes.setCode(IconCode.NO_DATA);
        }
        else {
            List<IdAndHashDto> addressTxListtx = null;
            if (req.getId() != 0 && req.getPageKind() != null) {
                addressTxListtx = this.transactionV3Mapper.selectTotalTxListGetTxById(req);
            }
            else {
                addressTxListtx = this.transactionV3Mapper.selectTotalTxListGetTx(req);
            }
            if (addressTxListtx == null || addressTxListtx.size() == 0) {
                cRes.setListSize(0);
                cRes.setCode(IconCode.NO_DATA);
                cRes.setData((Object)null);
            }
            else {
                final List<TxDetailDto> addressDataList = this.transactionV3Mapper.selectTotalTxListGetTxData(addressTxListtx);
                for (int i = 0; i < addressDataList.size(); ++i) {
                    final String targetTxHash = addressDataList.get(i).getTxHash();
                    for (final IdAndHashDto idHashlist : addressTxListtx) {
                        if (targetTxHash.equals(idHashlist.getHash())) {
                            addressDataList.get(i).setId(idHashlist.getId());
                            break;
                        }
                    }
                }
                cRes.setData((Object)addressDataList);
                cRes.setListSize(totalTxCount);
                cRes.setCode(IconCode.SUCCESS);
            }
            cRes.setTotalSize(cRes.getListSize());
        }
        return cRes;
    }
    
    public CommonListRes getAddressTxListForWallet(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes cRes = new CommonListRes();
        final int totalTxCount = this.getTxCount(req.getAddress()).intValue();
        if (req.getPage() > totalTxCount) {
            cRes.setCode(IconCode.NO_DATA);
        }
        else {
            final List<String> addressTxListtx = this.transactionV3Mapper.selectTotalTxListGetTxForWallet(req);
            List<TxDetailDto> addressTxList = null;
            if (addressTxListtx != null && addressTxListtx.size() != 0) {
                addressTxList = this.transactionV3Mapper.selectTotalTxListGetTxDataForWallet(addressTxListtx);
            }
            cRes.setData((Object)addressTxList);
            if (addressTxList == null || addressTxList.size() == 0) {
                cRes.setListSize(0);
                cRes.setCode(IconCode.NO_DATA);
            }
            else {
                cRes.setListSize((int)this.transactionV3Mapper.selectTotalTxCountForWallet(req));
                cRes.setCode(IconCode.SUCCESS);
            }
            cRes.setTotalSize(cRes.getListSize());
        }
        return cRes;
    }
    
    public CommonListRes selectAddressTokenTx(final PageReq req) throws Exception {
        final CommonListRes cRes = new CommonListRes();
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final Integer totalTxCount = this.tokenMapper.selectAddrTokenTxCount(req);
        if (req.getPage() > totalTxCount) {
            cRes.setCode(IconCode.NO_DATA);
        }
        else {
            final List<TokenTxDetail> addressTokenTxList = this.tokenMapper.selectTokenTxByAddressTxData(req);
            cRes.setData((Object)addressTokenTxList);
            if (addressTokenTxList == null || addressTokenTxList.size() == 0) {
                cRes.setListSize(0);
                cRes.setCode(IconCode.NO_DATA);
            }
            else {
                cRes.setListSize((int)totalTxCount);
                cRes.setCode(IconCode.SUCCESS);
            }
        }
        return cRes;
    }
    
    public Integer getTotalTxCount(final PageReq req) throws Exception {
        return this.transactionV3Mapper.selectTotalTxCount(req);
    }
    
    public Integer getTotalTokenTxCount(final PageReq req) throws Exception {
        final TTokenTxExample example = new TTokenTxExample();
        example.or().andFromAddrEqualTo(req.getAddress());
        example.or().andToAddrEqualTo(req.getAddress());
        final Long totalData = this.tTokenTxMapper.countByExample(example);
        return totalData.intValue();
    }
    
    public TAddressTotal initGenesisTotal() throws Exception {
        final TAddressTotal genesis = new TAddressTotal();
        final GenesisRpcRes rpcRes = this.blockChainAdapter.getBlockInfoByGenesis();
        for (final GenesisAccVo vo : rpcRes.getResult().getConfrimedTransactionList().get(0).getAccounts()) {
            if (vo.getName().equals("god")) {
                genesis.setAddress(vo.getAddress());
                genesis.setBalance(HexUtil.toDecimalString(vo.getBalance(), DecimalType.ICX.getValue()));
                genesis.setNodeType("Genesis");
                genesis.setTxCount(1);
                break;
            }
        }
        return genesis;
    }
    
    public TAddressTotal initTreasuryTotal() throws Exception {
        final TAddressTotal treasury = new TAddressTotal();
        final GenesisRpcRes rpcRes = this.blockChainAdapter.getBlockInfoByGenesis();
        for (final GenesisAccVo vo : rpcRes.getResult().getConfrimedTransactionList().get(0).getAccounts()) {
            if (vo.getName().equals("treasury")) {
                treasury.setAddress(vo.getAddress());
                treasury.setBalance(HexUtil.toDecimalString(vo.getBalance(), DecimalType.ICX.getValue()));
                treasury.setNodeType("Treasury");
                treasury.setTxCount(0);
                break;
            }
        }
        return treasury;
    }
    
    private Long getTxCount(final String address) {
        Integer txCount = this.addressMapper.selectxCountAddrTx(address);
        if (txCount == null) {
            txCount = 0;
        }
        return (long)txCount;
    }
}
