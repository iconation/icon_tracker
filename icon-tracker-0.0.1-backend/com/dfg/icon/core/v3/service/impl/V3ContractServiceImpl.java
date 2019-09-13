// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.web.v3.dto.ContractPendingInfo;
import com.dfg.icon.web.v3.dto.TxDetailDto;
import com.dfg.icon.core.dao.icon.TAddressTotalKey;
import com.dfg.icon.core.dao.icon.TContractHistoryKey;
import java.util.Date;
import com.dfg.icon.web.v3.dto.TxResultLog;
import com.dfg.icon.web.v3.dto.CommonListRes;
import com.dfg.icon.core.dao.icon.TContractHistoryExample;
import com.dfg.icon.core.dao.icon.TContractExample;
import com.dfg.icon.core.dao.icon.TContractKey;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.web.v3.dto.ContractTx;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.web.v3.dto.TokenTransferList;
import com.dfg.icon.core.dao.icon.TTokenTxExample;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v3.dto.TokenTransfer;
import com.dfg.icon.web.v3.dto.ContractDetail;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.web.v3.dto.ContractInfo;
import com.dfg.icon.web.v3.dto.ContractList;
import java.util.List;
import com.dfg.icon.web.v3.dto.PageReq;
import com.dfg.icon.core.common.service.ResourceService;
import com.dfg.icon.core.mappers.icon.TAddressTotalMapper;
import com.dfg.icon.core.mappers.icon.TransactionV3Mapper;
import com.dfg.icon.core.mappers.icon.TContractHistoryMapper;
import com.dfg.icon.core.mappers.icon.TTokenTxMapper;
import com.dfg.icon.core.mappers.icon.TContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.ContractMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3ContractService;

@Service
public class V3ContractServiceImpl implements V3ContractService
{
    private static final Logger logger;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    TContractMapper tContractMapper;
    @Autowired
    TTokenTxMapper tokenTxMapper;
    @Autowired
    TContractHistoryMapper tContractHistoryMapper;
    @Autowired
    TransactionV3Mapper transactionV3Mapper;
    @Autowired
    TAddressTotalMapper tAddressTotalMapper;
    @Autowired
    ResourceService resourceService;
    
    public List<ContractList> selectContractList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        return this.contractMapper.selectContractList(req);
    }
    
    public int selectContractListCount(final PageReq req) throws Exception {
        return this.contractMapper.selectContractListCount(req);
    }
    
    public ContractInfo selectContractInfo(final String addr) throws Exception {
        final ContractInfo info = this.contractMapper.selectContractInfo(addr);
        if (this.resourceService.isAcceptMode()) {
            info.setContractVersion(info.getNewVersion());
            info.setNewVersion("-");
        }
        else if (info.getContractVersion().equals(info.getNewVersion())) {
            info.setNewVersion("-");
        }
        if (info != null) {
            final TContractHistory history = new TContractHistory();
            history.setContractAddr(addr);
            info.setVersionList((List)this.contractMapper.selectContractVersion(history));
        }
        return info;
    }
    
    public ContractDetail selectContractDetail(final PageReq req) throws Exception {
        return this.contractMapper.selectContractDetail(req);
    }
    
    public List<TokenTransfer> selectContractTransactionList(final String addr, final PageReq req) throws Exception {
        List<TokenTransfer> returnList = null;
        final int count = req.getCounting();
        final int page = (req.getPage() - 1) * count;
        final String ircVersion = this.getIrcTypeByAddress(addr);
        if (ircVersion.equals(IconCode.IRC2_TOKEN.getCode().toString())) {
            final TTokenTxExample tokenTx = new TTokenTxExample();
            tokenTx.createCriteria().andContractAddrEqualTo(addr);
            tokenTx.setOrderByClause(" age desc limit " + page + ", " + count);
            final List<TTokenTx> tokenTxList = this.tokenTxMapper.selectByExample(tokenTx);
            final TokenTransferList transferList = new TokenTransferList();
            transferList.setTokenTransferList((List)tokenTxList);
            returnList = (List<TokenTransfer>)transferList.getTokenTransferList();
        }
        else {
            returnList = this.contractMapper.selectNoIrcContractTxList(addr, page, count);
        }
        return returnList;
    }
    
    public int selectContractTransactionListCount(final String addr) throws Exception {
        int count = 0;
        final String ircVersion = this.getIrcTypeByAddress(addr);
        if (ircVersion.equals(IconCode.IRC2_TOKEN.getCode().toString())) {
            final TTokenTxExample tokenTx = new TTokenTxExample();
            tokenTx.createCriteria().andContractAddrEqualTo(addr);
            final List<TTokenTx> tokenTxList = this.tokenTxMapper.selectByExample(tokenTx);
            count = tokenTxList.size();
        }
        else {
            count = this.contractMapper.selectNoIrcContractTxListCount(addr);
        }
        return count;
    }
    
    public List<ContractTx> selectContractTokenTransferList(final String addr, final PageReq req) throws Exception {
        final int count = req.getCounting();
        return this.contractMapper.selectContractTokenTransferList(addr, (req.getPage() - 1) * count, count);
    }
    
    public int selectContractTokenTransferListCount(final String addr) throws Exception {
        return this.contractMapper.selectContractTokenTransferListCount(addr);
    }
    
    public String getIrcTypeByAddress(final String contractAddr) {
        TContract tContract = new TContract();
        tContract.setContractAddr(contractAddr);
        tContract = this.tContractMapper.selectByPrimaryKey(tContract);
        if (tContract == null) {
            return IconCode.IRC_NOIRC.getCode();
        }
        final String ircVersion = this.tContractMapper.selectByPrimaryKey(tContract).getIrcVersion();
        return (ircVersion != null) ? ircVersion : IconCode.IRC_NOIRC.getCode();
    }
    
    public TContract getContractByAddress(final String contractAddr) {
        final TContractExample example = new TContractExample();
        example.createCriteria().andContractAddrEqualTo(contractAddr);
        final List<TContract> list = this.tContractMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    public TContractHistory getContractHistoryByCreateTx(final String txHash) {
        final TContractHistoryExample tContractHistoryExample = new TContractHistoryExample();
        tContractHistoryExample.createCriteria().andCreateTxEqualTo(txHash);
        final List<TContractHistory> list = this.tContractHistoryMapper.selectByExample(tContractHistoryExample);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    public List<TContractHistory> selectContractHistoryList(final String addr, int page, final int count) throws Exception {
        final TContractHistoryExample example = new TContractHistoryExample();
        if (addr != null && !addr.equals("")) {
            example.createCriteria().andContractAddrEqualTo(addr);
        }
        page = (page - 1) * count;
        example.setOrderByClause(" create_Date  desc limit " + page + " , " + count);
        return this.tContractHistoryMapper.selectByExample(example);
    }
    
    public int selectContractHistoryListCount(final String addr) throws Exception {
        final TContractHistoryExample example = new TContractHistoryExample();
        if (addr != null && !addr.equals("")) {
            example.createCriteria().andContractAddrEqualTo(addr);
        }
        return (int)this.tContractHistoryMapper.countByExample(example);
    }
    
    public CommonListRes selectTokenEventLogList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        final List<TxResultLog> resultLog = this.contractMapper.selectEventLogList(req);
        if (resultLog == null) {
            res.setData((Object)"");
            res.setListSize(0);
            res.setTotalSize(0);
            res.setCode(IconCode.ERROR);
        }
        else {
            final Integer listSize = this.contractMapper.selectTotalCountEventLog(req);
            res.setData((Object)resultLog);
            res.setListSize((int)listSize);
            res.setTotalSize((int)listSize);
            res.setCode(IconCode.SUCCESS);
        }
        return res;
    }
    
    public TContract getContractForInsert(final String contractAddr, final String name, final Integer version, final String ircVersion, final Integer state) {
        final TContract c = new TContract();
        c.setContractAddr(contractAddr);
        c.setName(name);
        c.setVersion(version);
        c.setIrcVersion(ircVersion);
        c.setState(state);
        return c;
    }
    
    public TContractHistory getContractHistoryForInsert(final String contractAddr, final Integer version, final String compiler, final String createTx, final Date createDate, final String verifiedTx, final Date verifiedDate, final String creator, final Integer state) {
        final TContractHistory cHistory = new TContractHistory();
        cHistory.setContractAddr(contractAddr);
        cHistory.setVersion(version);
        cHistory.setCompiler(compiler);
        cHistory.setCreateTx(createTx);
        cHistory.setCreateDate(createDate);
        cHistory.setVerifiedTx(verifiedTx);
        cHistory.setVerifiedDate(verifiedDate);
        cHistory.setCreator(creator);
        cHistory.setState(state);
        return cHistory;
    }
    
    public int getContractLastVersionForUpdate(final String contractAddr) {
        final TContractHistoryExample example = new TContractHistoryExample();
        example.createCriteria().andContractAddrEqualTo(contractAddr);
        example.setOrderByClause(" version desc limit 1 ");
        final List<TContractHistory> list = this.tContractHistoryMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return 1;
        }
        return list.get(0).getVersion() + 1;
    }
    
    public void initContractInfo() {
        TContract installScore = new TContract();
        installScore.setContractAddr(IconCode.SCORE_INSTALL_ADDR.getCode());
        installScore = this.tContractMapper.selectByPrimaryKey(installScore);
        if (installScore == null) {
            V3ContractServiceImpl.logger.info("[Contract] Init Install Score : ");
            installScore = new TContract();
            installScore.setContractAddr(IconCode.SCORE_INSTALL_ADDR.getCode());
            installScore.setVersion(1);
            installScore.setName(IconCode.SCORE_INSTALL_ADDR.getMessage());
            installScore.setState(1);
            installScore.setIrcVersion("-");
            this.tContractMapper.insert(installScore);
        }
        TContractHistory installScoreHistory = new TContractHistory();
        installScoreHistory.setContractAddr(IconCode.SCORE_INSTALL_ADDR.getCode());
        installScoreHistory.setVersion(1);
        installScoreHistory = this.tContractHistoryMapper.selectByPrimaryKey(installScoreHistory);
        if (installScoreHistory == null) {
            V3ContractServiceImpl.logger.info("[Contract] Init Install Score History : ");
            installScoreHistory = new TContractHistory();
            installScoreHistory.setContractAddr(IconCode.SCORE_INSTALL_ADDR.getCode());
            installScoreHistory.setVersion(1);
            installScoreHistory.setState(1);
            this.tContractHistoryMapper.insert(installScoreHistory);
        }
        TContract controlScore = new TContract();
        controlScore.setContractAddr(IconCode.SCORE_CONTROL_ADDR.getCode());
        controlScore = this.tContractMapper.selectByPrimaryKey(controlScore);
        if (controlScore == null) {
            V3ContractServiceImpl.logger.info("[Contract] Init Control Score : ");
            controlScore = new TContract();
            controlScore.setContractAddr(IconCode.SCORE_CONTROL_ADDR.getCode());
            controlScore.setVersion(1);
            controlScore.setName(IconCode.SCORE_CONTROL_ADDR.getMessage());
            controlScore.setState(1);
            controlScore.setIrcVersion("-");
            this.tContractMapper.insert(controlScore);
        }
        TContractHistory controlScoreHistory = new TContractHistory();
        controlScoreHistory.setContractAddr(IconCode.SCORE_CONTROL_ADDR.getCode());
        controlScoreHistory.setVersion(1);
        controlScoreHistory = this.tContractHistoryMapper.selectByPrimaryKey(controlScoreHistory);
        if (controlScoreHistory == null) {
            V3ContractServiceImpl.logger.info("[Contract] Init Control Score History : ");
            controlScoreHistory = new TContractHistory();
            controlScoreHistory.setContractAddr(IconCode.SCORE_CONTROL_ADDR.getCode());
            controlScoreHistory.setVersion(1);
            controlScoreHistory.setState(1);
            this.tContractHistoryMapper.insert(controlScoreHistory);
        }
    }
    
    public CommonListRes selectContractTxList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        final CommonListRes res = new CommonListRes();
        final List<TxDetailDto> addressTxList = this.transactionV3Mapper.selectTotalContractTxList(req);
        res.setData((Object)addressTxList);
        if (addressTxList == null || addressTxList.size() == 0) {
            res.setListSize(0);
            res.setCode(IconCode.NO_DATA);
        }
        else {
            final TAddressTotalKey addrKey = new TAddressTotalKey();
            addrKey.setAddress(req.getAddress());
            final int txCount = this.tAddressTotalMapper.selectByPrimaryKey(addrKey).getTxCount();
            res.setListSize(txCount);
            res.setCode(IconCode.SUCCESS);
        }
        res.setTotalSize(res.getListSize());
        return res;
    }
    
    public List<ContractPendingInfo> selectRequireContractList(final PageReq req) throws Exception {
        req.setPage(Integer.valueOf((req.getPage() - 1) * req.getCounting()));
        return this.contractMapper.selectRequireContractList(req);
    }
    
    public int selectRequireContractListCount() throws Exception {
        return this.contractMapper.selectRequireContractListCount();
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3ContractServiceImpl.class);
    }
}
