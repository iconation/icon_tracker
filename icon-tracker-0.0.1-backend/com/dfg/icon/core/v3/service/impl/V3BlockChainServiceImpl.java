// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.v3.vo.GenesisRpcRes;
import com.dfg.icon.core.v3.vo.RpcBalanceRes;
import com.dfg.icon.core.v3.vo.HexType;
import java.math.BigDecimal;
import com.dfg.icon.core.v2.vo.GenesisAccVo;
import com.dfg.icon.core.v3.vo.GenesisTransactionVo;
import com.dfg.icon.core.v3.vo.GenesisRpcResult;
import com.dfg.icon.core.dao.icon.TAddressTotalExample;
import com.dfg.icon.core.dao.icon.TAddressExample;
import com.dfg.icon.core.dao.icon.TTransactionExample;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.dfg.icon.core.dao.icon.TMainTx;
import com.dfg.icon.core.dao.icon.TMainBlock;
import com.dfg.icon.core.v3.vo.DecimalType;
import java.util.Collection;
import com.dfg.icon.core.v3.vo.TokenAddressGroupKey;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TInternalTxView;
import com.dfg.icon.core.dao.icon.TInternalTx;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.core.dao.icon.TTokenAddress;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTransaction;
import com.dfg.icon.core.v3.vo.BlockFactory;
import com.dfg.icon.core.dao.icon.TBlockKey;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import com.dfg.icon.core.v3.vo.RepRes;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.v3.vo.RepVo;
import com.dfg.icon.util.DateUtil;
import com.dfg.icon.core.dao.icon.TAddressPrep;
import java.util.ArrayList;
import com.dfg.icon.core.dao.icon.TAddress;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dfg.icon.core.dao.icon.TBlock;
import com.dfg.icon.core.dao.icon.TBlockExample;
import org.springframework.beans.factory.annotation.Value;
import com.dfg.icon.core.common.service.ResourceService;
import com.dfg.icon.core.v3.service.V3TxResultService;
import com.dfg.icon.core.v3.service.V3ContractService;
import com.dfg.icon.core.mappers.icon.TContractMapper;
import com.dfg.icon.core.mappers.icon.TContractHistoryMapper;
import com.dfg.icon.core.v3.service.V3AddressService;
import com.dfg.icon.core.mappers.icon.TMainBlockMapper;
import com.dfg.icon.core.mappers.icon.MainMapper;
import org.springframework.transaction.PlatformTransactionManager;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.v0.service.V0MainService;
import com.dfg.icon.core.v3.adapter.V3BlockChainAdapter;
import com.dfg.icon.core.mappers.icon.TokenMapper;
import com.dfg.icon.core.mappers.icon.ContractMapper;
import com.dfg.icon.core.mappers.icon.TTxDataMapper;
import com.dfg.icon.core.mappers.icon.TransactionMapper;
import com.dfg.icon.core.mappers.icon.BlockMapper;
import com.dfg.icon.core.mappers.icon.AddressMapper;
import com.dfg.icon.core.mappers.icon.TAddressTotalMapper;
import com.dfg.icon.core.mappers.icon.TAddressMapper;
import com.dfg.icon.core.v3.service.V3TokenService;
import com.dfg.icon.core.mappers.icon.TTransactionTotalMapper;
import com.dfg.icon.core.mappers.icon.TTransactionMapper;
import com.dfg.icon.core.mappers.icon.TBlockTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TBlockMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.service.V3BlockChainService;

@Service
public class V3BlockChainServiceImpl implements V3BlockChainService
{
    private static final Logger logger;
    private static final Logger sLogger;
    boolean speedLogFlag;
    @Autowired
    TBlockMapper tBlockMapper;
    @Autowired
    TBlockTotalMapper tBlockTotalMapper;
    @Autowired
    TTransactionMapper tTransactionMapper;
    @Autowired
    TTransactionTotalMapper tTransactionTotalMapper;
    @Autowired
    V3TokenService tokenService;
    @Autowired
    TAddressMapper tAddressMapper;
    @Autowired
    TAddressTotalMapper tAddressTotalMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    BlockMapper blockMapper;
    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    TTxDataMapper tTxDataMapper;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    V3BlockChainAdapter blockChainAdapter;
    @Autowired
    V0MainService v0MainService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    MainMapper mainMapper;
    @Autowired
    TMainBlockMapper tMainBlockMapper;
    @Autowired
    V3AddressService addressService;
    @Autowired
    TContractHistoryMapper tContractHistoryMapper;
    @Autowired
    TContractMapper tContractMapper;
    @Autowired
    V3ContractService contractService;
    @Autowired
    V3TxResultService txResultService;
    @Autowired
    ResourceService resourceService;
    @Value("${score.path}")
    String SCORE_PATH;
    @Value("${irc.path}")
    String IRC_FILE_PATH;
    @Value("${line}")
    Integer isLine;
    @Value("${scheduler.MaxTxCount}")
    Integer maxTxCount;
    
    public V3BlockChainServiceImpl() {
        this.speedLogFlag = true;
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void blockLimit(final Integer limit) {
        if (limit == null) {
            return;
        }
        final long count = this.getBlockCount();
        if (limit < count) {
            V3BlockChainServiceImpl.sLogger.info("block limit over : {}", (Object)(count - limit));
            final TBlock block = this.getDateRowForDeleteInBlock(limit - 1);
            if (block != null) {
                final TBlockExample example = new TBlockExample();
                example.createCriteria().andHeightLessThan(block.getHeight());
                this.tBlockMapper.deleteByExample(example);
            }
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void transactionLimit(final Integer limit) {
        if (limit == null) {
            return;
        }
        final String height = this.transactionMapper.selectCreateDateByLimit(limit);
        if (height != null && !height.equals("")) {
            this.transactionMapper.deleteCreateDateByLimit(height);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void addressLimit(final Integer limit) {
        if (limit == null) {
            return;
        }
        final long count = this.getAddressCount();
        if (limit < count) {
            V3BlockChainServiceImpl.sLogger.info("address limit over : {}", (Object)(count - limit));
            final TAddress address = this.getBalanceRowForDelete(limit - 1);
            if (address != null) {
                this.addressMapper.deleteAddressByBalanceLessThan(address.getBalance());
            }
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void updateMain() throws Exception {
        this.v0MainService.updateMainBlock();
        this.v0MainService.updateMainTx();
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void updatePrepTerm() throws Exception {
        final RepRes repRes = this.blockChainAdapter.repGetList();
        if (repRes != null && repRes.getResult() != null && repRes.getResult().getRep() != null) {
            final List<String> prepList = this.addressMapper.selectCurrentPrep();
            final List<RepVo> repList = (List<RepVo>)repRes.getResult().getRep();
            final List<TAddressPrep> updateList = new ArrayList<TAddressPrep>();
            final Date now = DateUtil.getNowDate();
            for (final RepVo vo : repList) {
                final TAddressPrep prep = new TAddressPrep();
                prep.setAddress(vo.getId());
                prep.setStartTerm(HexUtil.changeHexToInteger(repRes.getResult().getStartTermHeight()));
                prep.setEndTerm(HexUtil.changeHexToInteger(repRes.getResult().getEndTermHeight()));
                prep.setRepHash(repRes.getResult().getRepHash());
                prep.setIsPrep(true);
                prep.setUpdateDate(now);
                updateList.add(prep);
                prepList.remove(vo.getId());
            }
            for (final String noPrep : prepList) {
                final TAddressPrep prep = new TAddressPrep();
                prep.setAddress(noPrep);
                prep.setIsPrep(false);
                prep.setUpdateDate(now);
                updateList.add(prep);
            }
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void updateChart() throws Exception {
        this.mainMapper.deleteOldDataDaliyChart();
        this.mainMapper.insertNewChartData();
    }
    
    private TBlock getBlockByHeightInDB(final Integer height) {
        if (height == null) {
            return null;
        }
        final TBlockKey key = new TBlock();
        key.setHeight(height);
        return this.tBlockMapper.selectByPrimaryKey(key);
    }
    
    private int insertBlockFactory(final List<BlockFactory> bfList) throws Exception {
        final int txCount = this.getSumBlockTxCount(bfList);
        final int startHeight = bfList.get(0).getBlockInfo().getHeight();
        final int endHeight = bfList.get(bfList.size() - 1).getBlockInfo().getHeight();
        long middleTime;
        final long startTime = middleTime = System.currentTimeMillis();
        final List<TTransaction> txList = new ArrayList<TTransaction>();
        final List<TTxData> txDataList = new ArrayList<TTxData>();
        final List<TContract> contractList = new ArrayList<TContract>();
        final List<TContractHistory> contractHistoryList = new ArrayList<TContractHistory>();
        final List<TContractHistory> canceledHistoryList = new ArrayList<TContractHistory>();
        final List<TTokenTx> tokenTxList = new ArrayList<TTokenTx>();
        final List<TTxResultLog> txResultLogList = new ArrayList<TTxResultLog>();
        final List<TTokenAddress> tokenAddressList = new ArrayList<TTokenAddress>();
        final List<TAddressTotal> addressList = new ArrayList<TAddressTotal>();
        final List<TInternalTx> tInternalTxList = new ArrayList<TInternalTx>();
        final List<TInternalTxView> tInternalTxViewList = new ArrayList<TInternalTxView>();
        final List<String> tokenInfoGroup = new ArrayList<String>();
        final List<TTransactionView> txViewList = new ArrayList<TTransactionView>();
        final List<TTokenTxView> tokenTxViewList = new ArrayList<TTokenTxView>();
        final List<TBlock> blockList = new ArrayList<TBlock>();
        final List<String> addressGroupList = new ArrayList<String>();
        final List<TokenAddressGroupKey> tokenAddressGroupList = new ArrayList<TokenAddressGroupKey>();
        TAddressTotal treasuryTotal = this.getTreasuryAddressTotal();
        if (treasuryTotal == null) {
            treasuryTotal = this.addressService.initTreasuryTotal();
            this.tAddressTotalMapper.insert(treasuryTotal);
        }
        addressGroupList.add(treasuryTotal.getAddress());
        for (final BlockFactory bf : bfList) {
            txList.addAll(bf.getTransactionList());
            txDataList.addAll(bf.getTransactionDataList());
            contractList.addAll(bf.getContractList());
            contractHistoryList.addAll(bf.getContractHistoryList());
            canceledHistoryList.addAll(bf.getCanceledHistoryList());
            tokenTxList.addAll(bf.getTokenTxList());
            txResultLogList.addAll(bf.getTxResultLogList());
            for (final String addr : bf.getAddressGroup()) {
                if (!addressGroupList.contains(addr)) {
                    addressGroupList.add(addr);
                }
            }
            for (final TokenAddressGroupKey key : bf.getTokenAddressGroup()) {
                if (!tokenAddressGroupList.contains(key)) {
                    tokenAddressGroupList.add(key);
                }
            }
            tInternalTxList.addAll(bf.getInternalTransactionList());
            tInternalTxViewList.addAll(bf.getInternalTxViewList());
            tokenInfoGroup.addAll(bf.getTokenInfoGroup());
            txViewList.addAll(bf.getTransactionViewList());
            tokenTxViewList.addAll(bf.getTokenTxViewList());
            blockList.add(bf.getBlockInfo());
        }
        for (final TokenAddressGroupKey key2 : tokenAddressGroupList) {
            final TTokenAddress tokenAddress = new TTokenAddress();
            tokenAddress.setAddress(key2.getTokenAddr());
            tokenAddress.setContractAddr(key2.getContractAddr());
            tokenAddress.setQuantity(this.getTokenBalance(key2.getTokenAddr(), key2.getContractAddr(), key2.getDecimals()));
            tokenAddressList.add(tokenAddress);
        }
        for (final String addr2 : addressGroupList) {
            final TAddressTotal addrTotal = new TAddressTotal();
            addrTotal.setAddress(addr2);
            addrTotal.setBalance(this.getBalance(addr2, DecimalType.ICX.getValue()));
            addressList.add(addrTotal);
        }
        if (this.resourceService.isLogSpeed()) {
            V3BlockChainServiceImpl.sLogger.info("[Speed] Insert Array preWork {}s ", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f));
            middleTime = System.currentTimeMillis();
        }
        final long startInsertTime = System.currentTimeMillis();
        if (txList.size() > 0) {
            this.transactionMapper.insertTxTotalArray(txList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] txTotal {}, {}s, {}s", new Object[] { txList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
            this.transactionMapper.insertTxArray(txList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] tx {}, {}s, {}s", new Object[] { txList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
            this.transactionMapper.insertTxViewArray(txViewList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] txView {}, {}s, {}s", new Object[] { txViewList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (txDataList != null && txDataList.size() > 0) {
            this.transactionMapper.insertTxDataArray(txDataList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] txData {}, {}s, {}s", new Object[] { txDataList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (contractList.size() > 0) {
            this.contractMapper.insertContractArray(contractList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] contract {}, {}s, {}s", new Object[] { contractList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (contractHistoryList != null && contractHistoryList.size() > 0) {
            this.contractMapper.insertContractHistoryArray(contractHistoryList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] contractHistory {}, {}s, {}s", new Object[] { contractHistoryList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (tokenTxList != null && tokenTxList.size() > 0) {
            this.tokenMapper.insertTokenTxArray(tokenTxList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] tokenTx {}, {}s, {}s", new Object[] { tokenTxList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (tokenTxViewList != null && tokenTxViewList.size() > 0) {
            this.transactionMapper.insertTxTokenViewArray(tokenTxViewList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] tokenTxView {}, {}s, {}s", new Object[] { tokenTxViewList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (txResultLogList != null && txResultLogList.size() > 0) {
            this.tokenMapper.insertTxResultLogArray(txResultLogList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] txResultLog {}, {}s, {}s", new Object[] { txResultLogList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (tokenAddressList != null && tokenAddressList.size() > 0) {
            this.addressMapper.upsertTokenAddressArray(tokenAddressList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] tokenAddress quantity {}, {}s, {}s", new Object[] { tokenAddressList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (addressList != null && addressList.size() > 0) {
            this.addressMapper.upsertAddressArray(addressList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] address balance {}, {}s, {}s", new Object[] { addressList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        if (tInternalTxList != null && tInternalTxList.size() > 0) {
            this.transactionMapper.insertInternalTx(tInternalTxList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] internalTx {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                middleTime = System.currentTimeMillis();
            }
        }
        if (tInternalTxViewList != null && tInternalTxViewList.size() > 0) {
            this.transactionMapper.insertInternalTxView(tInternalTxViewList);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] internalTxView {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                middleTime = System.currentTimeMillis();
            }
        }
        if (canceledHistoryList != null) {
            for (final TContractHistory history : canceledHistoryList) {
                this.contractMapper.updateHistoryToCancel(history);
                this.contractMapper.updateContractTxToCancel(history);
                this.transactionMapper.updateTxTotalCancel(history);
                this.transactionMapper.updateTxCancel(history);
                this.transactionMapper.updateTxViewCancel(history);
            }
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] ContractHistoryCancel {}, {}s, {}s", new Object[] { canceledHistoryList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
                middleTime = System.currentTimeMillis();
            }
        }
        this.addressMapper.upsertTokenTxCountByTokenTransactionRange(startHeight, endHeight);
        if (this.resourceService.isLogSpeed()) {
            V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] tokenAddress txCount Refresh {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
            middleTime = System.currentTimeMillis();
        }
        this.addressMapper.upsertTxCountByTransactionRange(startHeight, endHeight);
        if (this.resourceService.isLogSpeed()) {
            V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] address txCount Refresh {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
            middleTime = System.currentTimeMillis();
        }
        this.addressMapper.updateAddressByTotal();
        this.addressMapper.initUpdateAddressTotal();
        if (this.resourceService.isLogSpeed()) {
            V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] addressTotal To Address {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
            middleTime = System.currentTimeMillis();
        }
        if (tokenInfoGroup != null && tokenInfoGroup.size() > 0) {
            this.tokenMapper.updateTokenInfoHolderCountAndTxCountRange(startHeight, endHeight);
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] tokenHolder&tokenTxCount {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
                middleTime = System.currentTimeMillis();
            }
        }
        this.blockMapper.insertBlockArray(blockList);
        this.blockMapper.insertBlockTotalArray(blockList);
        if (this.resourceService.isLogSpeed()) {
            V3BlockChainServiceImpl.sLogger.info("[InsertSpeed] block&blockTotal {}, {}s, {}s", new Object[] { blockList.size(), (System.currentTimeMillis() - middleTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
            middleTime = System.currentTimeMillis();
        }
        this.addressMapper.upsertPRepBlockCountByBlockRange(startHeight, endHeight);
        if (this.resourceService.isLogSpeed()) {
            V3BlockChainServiceImpl.sLogger.info("[UpdateSpeed] address prep blockCount Refresh {}s, {}s", (Object)((System.currentTimeMillis() - middleTime) / 1000.0f), (Object)((System.currentTimeMillis() - startTime) / 1000.0f));
            middleTime = System.currentTimeMillis();
        }
        V3BlockChainServiceImpl.sLogger.info("###DB checkSpeed InsertBlock={}, InsertTx={}, time={}", new Object[] { bfList.size(), txCount, (System.currentTimeMillis() - startInsertTime) / 1000.0f });
        final int blockListSize = blockList.size();
        int startindex = 0;
        int endindex;
        if ((endindex = blockListSize) > 20) {
            startindex = endindex - 20;
        }
        final List<TBlock> top20BlockList = blockList.subList(startindex, endindex);
        final List<TMainBlock> mainBlockList = new ArrayList<TMainBlock>();
        for (final TBlock block : top20BlockList) {
            mainBlockList.add(this.setMainBlockToTotal(block));
        }
        this.mainMapper.insertMainBlockList(mainBlockList);
        if (this.speedLogFlag) {
            V3BlockChainServiceImpl.sLogger.info("###DB checkSpeed tMainBlockMapper.insert = {}", (Object)((System.currentTimeMillis() - startInsertTime) / 1000.0f));
        }
        final int txListSize = txList.size();
        startindex = 0;
        if ((endindex = txListSize) > 20) {
            startindex = endindex - 20;
        }
        final List<TTransaction> top20TxList = txList.subList(startindex, endindex);
        final List<TMainTx> mainTxList = new ArrayList<TMainTx>();
        for (final TTransaction tx : top20TxList) {
            mainTxList.add(this.setTransactionToTotal(tx));
        }
        this.mainMapper.insertMainTxList(mainTxList);
        if (this.speedLogFlag) {
            V3BlockChainServiceImpl.sLogger.info("###DB checkSpeed insertMainTxList = {}", (Object)((System.currentTimeMillis() - startInsertTime) / 1000.0f));
        }
        this.v0MainService.updateMainInfo(txList.size());
        V3BlockChainServiceImpl.sLogger.info("###CHAIN checkSpeed cycleEnd  = blockCount {}, {}->{} txCount {}, DB {}s, time: {}s", new Object[] { bfList.size(), startHeight, endHeight, txCount, (System.currentTimeMillis() - startInsertTime) / 1000.0f, (System.currentTimeMillis() - startTime) / 1000.0f });
        return bfList.size();
    }
    
    private String checkAddress(final String addr) {
        final Pattern p = Pattern.compile("^[A-Fa-f0-9]{40}$");
        final Matcher m = p.matcher(addr);
        if (m.find()) {
            return "hx" + addr;
        }
        return addr;
    }
    
    private long getBlockCount() {
        return this.tBlockMapper.countByExample(new TBlockExample());
    }
    
    private long getTransactionCount() {
        return this.tTransactionMapper.countByExample(new TTransactionExample());
    }
    
    private long getAddressCount() {
        return this.tAddressMapper.countByExample(new TAddressExample());
    }
    
    private TBlock getDateRowForDeleteInBlock(final Integer limit) {
        final TBlockExample example = new TBlockExample();
        example.createCriteria();
        example.setOrderByClause("height desc limit " + limit + ", 1");
        final List<TBlock> block = this.tBlockMapper.selectByExample(example);
        if (block != null && block.size() > 0) {
            return block.get(0);
        }
        return null;
    }
    
    private TAddress getBalanceRowForDelete(final Integer limit) {
        final TAddressExample example = new TAddressExample();
        example.createCriteria();
        example.setOrderByClause("balance_order desc limit " + limit + ", 1");
        final List<TAddress> address = this.tAddressMapper.selectByExample(example);
        if (address != null && address.size() > 0) {
            return address.get(0);
        }
        return null;
    }
    
    private TMainBlock setMainBlockToTotal(final TBlock block) {
        final TMainBlock tMainBlock = new TMainBlock();
        tMainBlock.setBlockHeight(block.getHeight());
        tMainBlock.setHash(block.getHash());
        tMainBlock.setCrepAddr(block.getcRep());
        tMainBlock.setTxCount(block.getTxCount());
        tMainBlock.setCreateDate(block.getCreateDate());
        return tMainBlock;
    }
    
    private TMainTx setTransactionToTotal(final TTransaction tx) {
        final TMainTx mainTx = new TMainTx();
        mainTx.setTxHash(tx.getTxHash());
        mainTx.setAmount(tx.getAmount());
        mainTx.setFee(tx.getFee());
        mainTx.setCreateDate(tx.getCreateDate());
        mainTx.setState(tx.getState());
        return mainTx;
    }
    
    private TAddressTotal getTreasuryAddressTotal() {
        final TAddressTotalExample example = new TAddressTotalExample();
        example.createCriteria().andNodeTypeEqualTo("Treasury");
        final List<TAddressTotal> treasury = this.tAddressTotalMapper.selectByExample(example);
        if (treasury != null && treasury.size() > 0) {
            return treasury.get(0);
        }
        return null;
    }
    
    private int insertGenesis(final GenesisRpcResult rpcResult, final Integer blockSize) throws Exception {
        final String msg = rpcResult.getConfrimedTransactionList().get(0).getMessage();
        String genesisFeeSum = "0";
        int txCount = 0;
        final List<TTransactionView> viewList = new ArrayList<TTransactionView>();
        final List<TTransaction> txList = new ArrayList<TTransaction>();
        final List<TBlock> blockList = new ArrayList<TBlock>();
        for (final GenesisAccVo vo : rpcResult.getConfrimedTransactionList().get(0).getAccounts()) {
            TAddress address = null;
            TAddressTotal addressTotal = null;
            address = new TAddress();
            address.setAddress(vo.getAddress());
            address.setBalance(HexUtil.toDecimalString(vo.getBalance(), DecimalType.ICX.getValue()));
            address.setBalanceOrder(new BigDecimal(address.getBalance()));
            if (vo.getName().equals("god")) {
                address.setNodeType("Genesis");
            }
            else if (vo.getName().equals("treasury")) {
                address.setNodeType("Treasury");
            }
            if ("0".equals(address.getBalance())) {
                address.setTxCount(0);
            }
            else {
                address.setTxCount(1);
                genesisFeeSum = HexUtil.decimalPlusDecimal(genesisFeeSum, address.getBalance(), DecimalType.ICX.getValue());
                final TTransaction transaction = new TTransaction();
                transaction.setHeight(0);
                transaction.setTxHash("genesistx " + txCount);
                ++txCount;
                transaction.setToAddr(address.getAddress());
                transaction.setFee("0");
                transaction.setAmount(address.getBalance());
                transaction.setHash(HexType.toDBformatString(rpcResult.getBlockHash()));
                transaction.setCreateDate(null);
                transaction.setFromAddr(null);
                transaction.setTxType(0);
                transaction.setState(1);
                transaction.setStepLimit("0");
                transaction.setStepUsedTx("0");
                transaction.setStepPrice("0");
                transaction.setInternalTxCount(0);
                txList.add(transaction);
                final TTransactionView view = new TTransactionView();
                view.setTxHash(transaction.getTxHash());
                view.setAddress(transaction.getToAddr());
                view.setHeight(transaction.getHeight());
                view.setCreateDate(transaction.getCreateDate());
                view.setState(transaction.getState());
                view.setTxType(transaction.getTxType());
                viewList.add(view);
            }
            addressTotal = new TAddressTotal();
            addressTotal.setAddress(address.getAddress());
            addressTotal.setBalance(address.getBalance());
            addressTotal.setNodeType(address.getNodeType());
            addressTotal.setTxCount(address.getTxCount());
            if (address != null) {
                this.tAddressMapper.insert(address);
                this.tAddressTotalMapper.insert(addressTotal);
            }
        }
        this.transactionMapper.insertTxArray(txList);
        this.transactionMapper.insertTxTotalArray(txList);
        this.transactionMapper.insertTxViewArray(viewList);
        final TBlock block = new TBlock();
        block.setCreateDate(null);
        block.setTxCount(txCount);
        block.setPrevHash(rpcResult.getPrevBlockHash());
        block.setHash(HexType.toDBformatString(rpcResult.getBlockHash()));
        block.setHeight(rpcResult.getHeight());
        block.setcRep("");
        block.setFee("0");
        block.setAmount(genesisFeeSum);
        block.setBlockSize(blockSize);
        blockList.add(block);
        this.blockMapper.insertBlockArray(blockList);
        this.blockMapper.insertBlockTotalArray(blockList);
        final TTxData txData = new TTxData();
        txData.setTxHash(HexType.toDBformatString(rpcResult.getBlockHash()));
        txData.setDataBody(msg);
        this.tTxDataMapper.insert(txData);
        this.v0MainService.updateMainInfo(txCount);
        return 1;
    }
    
    public String getBalance(final String address, final Integer decimals) throws Exception {
        final RpcBalanceRes res = this.blockChainAdapter.getBalance(address);
        return HexUtil.toDecimalString(res.getResult(), decimals);
    }
    
    public String getTokenBalance(final String address, final String contractAddr, final Integer decimals) throws Exception {
        String result = this.blockChainAdapter.getIcxCall(contractAddr, "balanceOf", new String[] { address });
        if (result == null) {
            result = "0x0";
        }
        return HexUtil.toDecimalString(result, decimals);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void blockChainSyncUpdateAllinOne(Integer height, final Integer lastHeight, final Date updateDate) throws Exception {
        Integer updateHeight = height;
        final List<BlockFactory> bfList = new ArrayList<BlockFactory>();
        int txViewSum = 0;
        int txTotalCount = 0;
        long startTime = System.currentTimeMillis();
        Integer startHeight = height;
        while (height <= lastHeight) {
            updateHeight = height + 1;
            final TBlock block = this.getBlockByHeightInDB(height);
            if (block == null) {
                if (height == 0) {
                    final GenesisRpcRes blockRes = this.blockChainAdapter.getBlockInfoByGenesis();
                    this.insertGenesis(blockRes.getResult(), blockRes.toString().getBytes().length);
                }
                else {
                    final BlockFactory blockFactory = this.blockChainAdapter.getBlockFactoryByHeight(height);
                    final BlockFactory bf = this.txResultService.initTxResult(blockFactory);
                    bfList.add(bf);
                    if (bf.isBreak()) {
                        if (this.resourceService.isLogSpeed()) {
                            V3BlockChainServiceImpl.sLogger.info("[Speed] getBlockByHeight & getTxResult block {} -> {} : {}s ", new Object[] { startHeight, height, (System.currentTimeMillis() - startTime) / 1000.0f });
                        }
                        this.insertBlockFactory(bfList);
                        bfList.clear();
                        startTime = System.currentTimeMillis();
                        startHeight = height + 1;
                    }
                }
            }
            if (bfList.size() != 0) {
                txViewSum += bfList.get(bfList.size() - 1).getTransactionViewList().size();
                txTotalCount += bfList.get(bfList.size() - 1).getTransactionList().size();
                if (txViewSum > this.maxTxCount || txTotalCount > this.maxTxCount) {
                    V3BlockChainServiceImpl.sLogger.info("XXXXX CHAIN MaxTxCount OVER  = block {}  , count   {}  / {}", new Object[] { updateHeight, txViewSum, txTotalCount });
                    break;
                }
                if (DateUtil.getNowDate().getTime() - updateDate.getTime() > 60000L) {
                    V3BlockChainServiceImpl.sLogger.info("XXXXX Scheduler time too late!!");
                    break;
                }
            }
            ++height;
        }
        if (bfList.size() > 0) {
            if (this.resourceService.isLogSpeed()) {
                V3BlockChainServiceImpl.sLogger.info("[Speed] getBlockByHeight & getTxResult block {} -> {} : {}s ", new Object[] { startHeight, height, (System.currentTimeMillis() - startTime) / 1000.0f });
            }
            this.insertBlockFactory(bfList);
        }
        this.scheduleService.updateBlockScheduler(String.valueOf(updateHeight));
    }
    
    public int getSumBlockTxCount(final List<BlockFactory> bfList) throws Exception {
        int txCount = 0;
        for (final BlockFactory bf : bfList) {
            txCount += bf.getTransactionList().size();
        }
        return txCount;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3BlockChainServiceImpl.class);
        sLogger = LoggerFactory.getLogger("ScheduleLogger");
    }
}
