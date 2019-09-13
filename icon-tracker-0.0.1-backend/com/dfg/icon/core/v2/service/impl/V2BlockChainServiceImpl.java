// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.service.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTransactionTotal;
import com.dfg.icon.core.v2.vo.GenesisAccVo;
import com.dfg.icon.core.v2.vo.GenesisTransactionVo;
import com.dfg.icon.core.v2.vo.GenesisRpcResult;
import com.dfg.icon.core.dao.icon.TAddressTotalExample;
import com.dfg.icon.core.dao.icon.TAddressExample;
import com.dfg.icon.core.dao.icon.TBlockTotal;
import java.util.Date;
import com.dfg.icon.core.v2.vo.BlockVo;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import java.util.Iterator;
import java.util.List;
import org.springframework.transaction.TransactionStatus;
import com.dfg.icon.core.exception.IconException;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.v3.vo.DecimalType;
import com.dfg.icon.core.v2.vo.TransactionVo;
import java.util.ArrayList;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.dfg.icon.core.v2.vo.RpcResult;
import com.dfg.icon.core.dao.icon.TBlockKey;
import com.dfg.icon.core.dao.icon.TAddress;
import com.dfg.icon.core.dao.icon.TTransaction;
import com.dfg.icon.core.dao.icon.TTransactionExample;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dfg.icon.core.dao.icon.TBlockExample;
import com.dfg.icon.core.v2.vo.RpcRes;
import com.dfg.icon.core.v2.vo.GenesisRpcRes;
import com.dfg.icon.core.dao.icon.TBlock;
import org.springframework.transaction.PlatformTransactionManager;
import com.dfg.icon.core.mappers.icon.TTxDataMapper;
import com.dfg.icon.core.common.service.ScheduleService;
import com.dfg.icon.core.v0.service.V0MainService;
import com.dfg.icon.core.v2.adapter.V2BlockChainAdapter;
import com.dfg.icon.core.mappers.icon.TransactionMapper;
import com.dfg.icon.core.mappers.icon.AddressMapper;
import com.dfg.icon.core.mappers.icon.TAddressTotalMapper;
import com.dfg.icon.core.mappers.icon.TAddressMapper;
import com.dfg.icon.core.mappers.icon.TTransactionTotalMapper;
import com.dfg.icon.core.mappers.icon.TTransactionMapper;
import com.dfg.icon.core.mappers.icon.TBlockTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TBlockMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v2.service.V2BlockChainService;

@Service
public class V2BlockChainServiceImpl implements V2BlockChainService
{
    private static final Logger logger;
    private static final Logger sLogger;
    @Autowired
    TBlockMapper tBlockMapper;
    @Autowired
    TBlockTotalMapper tBlockTotalMapper;
    @Autowired
    TTransactionMapper tTransactionMapper;
    @Autowired
    TTransactionTotalMapper tTransactionTotalMapper;
    @Autowired
    TAddressMapper tAddressMapper;
    @Autowired
    TAddressTotalMapper tAddressTotalMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    V2BlockChainAdapter blockChainAdapter;
    @Autowired
    V0MainService v0MainService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    TTxDataMapper tTxDataMapper;
    @Autowired
    PlatformTransactionManager transactionManager;
    
    public boolean blockChainSyncUpdate(Integer height, final Integer lastHeight) throws Exception {
        boolean isUpdate = false;
        int txAddedCount = 0;
        int blockSyncCount = 0;
        try {
            while (true) {
                while (height <= lastHeight) {
                    final TBlock block = this.getBlockByHeight(height);
                    if (block == null) {
                        if (height == 0) {
                            final GenesisRpcRes blockRes = this.blockChainAdapter.getBlockInfoByGenesis();
                            txAddedCount += this.insertBlockAndTransaction(blockRes.getResult(), blockRes.toString().getBytes().length);
                        }
                        else {
                            final RpcRes blockRes2 = this.blockChainAdapter.getBlockInfoByHeight(height);
                            txAddedCount += this.insertBlockAndTransaction(blockRes2.getResult(), blockRes2.toString().getBytes().length);
                        }
                    }
                    isUpdate = true;
                    ++height;
                    ++blockSyncCount;
                    this.scheduleService.updateBlockScheduler(String.valueOf(height));
                    if (blockSyncCount > 1000) {
                        if (isUpdate) {
                            this.v0MainService.updateMainInfo(txAddedCount);
                        }
                        return isUpdate;
                    }
                }
                continue;
            }
        }
        catch (Exception e) {
            V2BlockChainServiceImpl.sLogger.error("blockChainSync loop error : {}", (Object)e.getMessage());
            this.v0MainService.updateMainInfo();
        }
        return isUpdate;
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void blockLimit(final Integer limit) {
        if (limit == null) {
            return;
        }
        final long count = this.getBlockCount();
        if (limit < count) {
            V2BlockChainServiceImpl.logger.info("\ube14\ub85d \ucd08\uacfc\ub7c9 : {}", (Object)(count - limit));
            final TBlock block = this.getDateRowForDeleteInBlock(limit - 1);
            if (block != null) {
                final TBlockExample example = new TBlockExample();
                example.or().andCreateDateLessThan(block.getCreateDate());
                example.or().andCreateDateIsNull();
                this.tBlockMapper.deleteByExample(example);
            }
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void transactionLimit(final Integer limit) {
        if (limit == null) {
            return;
        }
        final long count = this.getTransactionCount();
        if (limit < count) {
            V2BlockChainServiceImpl.logger.info("\ud2b8\ub79c\uc7ad\uc158 \ucd08\uacfc\ub7c9 : {}", (Object)(count - limit));
            final TTransaction transaction = this.getDateRowForDeleteInTransaction(limit - 1);
            if (transaction != null) {
                final TTransactionExample example = new TTransactionExample();
                example.or().andCreateDateLessThan(transaction.getCreateDate());
                example.or().andCreateDateIsNull();
                this.tTransactionMapper.deleteByExample(example);
            }
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void addressLimit(final Integer limit) {
        if (limit == null) {
            return;
        }
        final long count = this.getAddressCount();
        if (limit < count) {
            V2BlockChainServiceImpl.logger.info("\uc5b4\ub4dc\ub808\uc2a4 \ucd08\uacfc\ub7c9 : {}", (Object)(count - limit));
            final TAddress address = this.getBalanceRowForDelete(limit - 1);
            if (address != null) {
                this.addressMapper.deleteAddressByBalanceLessThan(address.getBalance());
            }
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void updateMain() throws Exception {
        this.v0MainService.updateMainBlock();
        this.v0MainService.updateMainChart();
        this.v0MainService.updateMainTx();
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void updateChart() throws Exception {
        this.v0MainService.updateMainChartDaily();
    }
    
    private TBlock getBlockByHeight(final Integer height) {
        if (height == null) {
            return null;
        }
        final TBlockKey key = new TBlock();
        key.setHeight(height);
        return this.tBlockMapper.selectByPrimaryKey(key);
    }
    
    private int insertBlockAndTransaction(final RpcResult rpcResult, final Integer blockSize) throws Exception {
        final DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("BlockTxInsert");
        def.setPropagationBehavior(0);
        final TransactionStatus status = this.transactionManager.getTransaction((TransactionDefinition)def);
        try {
            String sumAmount = null;
            String sumFee = null;
            if (rpcResult.getBlock().getConfrimedTransactionList() != null) {
                final List<TTransaction> txList = new ArrayList<TTransaction>();
                for (final TransactionVo vo : rpcResult.getBlock().getConfrimedTransactionList()) {
                    if (sumAmount == null) {
                        sumAmount = HexUtil.toDecimalString(vo.getValue(), DecimalType.ICX.getValue());
                    }
                    else {
                        sumAmount = HexUtil.decimalPlusHex(sumAmount, vo.getValue(), DecimalType.ICX.getValue());
                    }
                    if (sumFee == null) {
                        sumFee = HexUtil.toDecimalString(vo.getFee(), DecimalType.ICX.getValue());
                    }
                    else {
                        sumFee = HexUtil.decimalPlusHex(sumFee, vo.getFee(), DecimalType.ICX.getValue());
                    }
                    final TTransaction tx = this.getTransactionForInsert(vo, rpcResult.getBlock().getBlockHash(), rpcResult.getBlock().getHeight(), rpcResult.getBlock().getTimestamp());
                    txList.add(tx);
                }
                this.transactionMapper.insertTxArray(txList);
                this.transactionMapper.insertTxTotalArray(txList);
                this.addressMapper.updateAddressTotalByTransaction(rpcResult.getBlock().getBlockHash());
                final TAddressTotal treasuryTotal = this.getTreasuryAddressTotal();
                treasuryTotal.setBalance(HexUtil.decimalPlusDecimal(treasuryTotal.getBalance(), sumFee, DecimalType.ICX.getValue()));
                this.tAddressTotalMapper.updateByPrimaryKey(treasuryTotal);
                this.addressMapper.updateAddressByTotal();
            }
            V2BlockChainServiceImpl.logger.info("insert block : {}", (Object)rpcResult.getBlock().getBlockHash());
            this.insertBlock(rpcResult.getBlock(), sumAmount, blockSize, sumFee);
            this.transactionManager.commit(status);
            return rpcResult.getBlock().getConfrimedTransactionList().size();
        }
        catch (Exception e) {
            this.transactionManager.rollback(status);
            V2BlockChainServiceImpl.sLogger.error("sync transaction error : height={}, hash={}, message={}", new Object[] { rpcResult.getBlock().getHeight(), rpcResult.getBlock().getBlockHash(), e.getMessage() });
            throw new IconException(IconCode.TRANSACTION_ERROR);
        }
    }
    
    @Transactional
    private void insertBlock(final BlockVo vo, final String amount, final Integer blockSize, final String fee) {
        final TBlock block = new TBlock();
        block.setHash(vo.getBlockHash());
        final String blockTimeStamp = String.valueOf(vo.getTimestamp());
        if (blockTimeStamp != null && blockTimeStamp.length() > 3) {
            block.setCreateDate(new Date(Long.parseLong(blockTimeStamp.substring(0, blockTimeStamp.length() - 3))));
        }
        else {
            block.setCreateDate(null);
        }
        block.setHeight(vo.getHeight());
        block.setPrevHash(vo.getPrevBlockHash());
        if (vo.getConfrimedTransactionList() != null) {
            block.setTxCount(vo.getConfrimedTransactionList().size());
        }
        block.setAmount(amount);
        block.setBlockSize(blockSize);
        block.setcRep(vo.getPeerId());
        block.setFee(fee);
        final TBlockTotal total = this.setBlockToTotal(block);
        this.tBlockMapper.insert(block);
        this.tBlockTotalMapper.insert(total);
    }
    
    private TTransaction getTransactionForInsert(final TransactionVo vo, final String blockHash, final Integer height, final Long timestamp) {
        final TTransaction transaction = new TTransaction();
        transaction.setTxHash(vo.getTxHash());
        transaction.setHash(blockHash);
        transaction.setHeight(height);
        String txTimeStamp = String.valueOf(timestamp);
        if (vo.getTimestamp() != null && vo.getTimestamp() > 1000L) {
            txTimeStamp = String.valueOf(vo.getTimestamp());
        }
        if (txTimeStamp != null && txTimeStamp.length() > 3) {
            transaction.setCreateDate(new Date(Long.parseLong(txTimeStamp.substring(0, txTimeStamp.length() - 3))));
        }
        else {
            transaction.setCreateDate(null);
        }
        transaction.setFromAddr(vo.getFrom());
        transaction.setToAddr(vo.getTo());
        transaction.setAmount(HexUtil.toDecimalString(vo.getValue(), DecimalType.ICX.getValue()));
        transaction.setFee(HexUtil.toDecimalString(vo.getFee(), DecimalType.ICX.getValue()));
        return transaction;
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
        example.setOrderByClause("create_date desc limit " + limit + ", 1");
        final List<TBlock> block = this.tBlockMapper.selectByExample(example);
        if (block != null && block.size() > 0) {
            return block.get(0);
        }
        return null;
    }
    
    private TTransaction getDateRowForDeleteInTransaction(final Integer limit) {
        final TTransactionExample example = new TTransactionExample();
        example.createCriteria();
        example.setOrderByClause("create_date desc limit " + limit + ", 1");
        final List<TTransaction> transaction = this.tTransactionMapper.selectByExample(example);
        if (transaction != null && transaction.size() > 0) {
            return transaction.get(0);
        }
        return null;
    }
    
    private TAddress getBalanceRowForDelete(final Integer limit) {
        final TAddressExample example = new TAddressExample();
        example.createCriteria();
        example.setOrderByClause("convert(balance, decimal(64,18)) desc limit " + limit + ", 1");
        final List<TAddress> address = this.tAddressMapper.selectByExample(example);
        if (address != null && address.size() > 0) {
            return address.get(0);
        }
        return null;
    }
    
    private TBlockTotal setBlockToTotal(final TBlock block) {
        final TBlockTotal total = new TBlockTotal();
        total.setTxCount(block.getTxCount());
        total.setAmount(block.getAmount());
        total.setBlockSize(block.getBlockSize());
        total.setCreateDate(block.getCreateDate());
        total.setcRep(block.getcRep());
        total.setFee(block.getFee());
        total.setHash(block.getHash());
        total.setHeight(block.getHeight());
        total.setPrevHash(block.getPrevHash());
        return total;
    }
    
    private TAddress getTreasuryAddress() {
        final TAddressExample example = new TAddressExample();
        example.createCriteria().andNodeTypeEqualTo("Treasury");
        final List<TAddress> treasury = this.tAddressMapper.selectByExample(example);
        if (treasury.size() > 0) {
            return treasury.get(0);
        }
        return null;
    }
    
    private TAddressTotal getTreasuryAddressTotal() {
        final TAddressTotalExample example = new TAddressTotalExample();
        example.createCriteria().andNodeTypeEqualTo("Treasury");
        return this.tAddressTotalMapper.selectByExample(example).get(0);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    private int insertBlockAndTransaction(final GenesisRpcResult rpcResult, final Integer blockSize) throws Exception {
        final String msg = rpcResult.getBlock().getConfrimedTransactionList().get(0).getMessage();
        for (final GenesisAccVo vo : rpcResult.getBlock().getConfrimedTransactionList().get(0).getAccounts()) {
            TAddress address = null;
            TAddressTotal addressTotal = null;
            if (vo.getName().equals("god")) {
                address = new TAddress();
                address.setAddress(vo.getAddress());
                address.setBalance(HexUtil.toDecimalString(vo.getBalance(), DecimalType.ICX.getValue()));
                address.setNodeType("Genesis");
                address.setTxCount(1);
                addressTotal = new TAddressTotal();
                addressTotal.setAddress(address.getAddress());
                addressTotal.setBalance(address.getBalance());
                addressTotal.setNodeType(address.getNodeType());
                addressTotal.setTxCount(address.getTxCount());
                final TTransaction transaction = new TTransaction();
                transaction.setHeight(0);
                transaction.setTxHash("-");
                transaction.setToAddr(address.getAddress());
                transaction.setFee("0");
                transaction.setAmount(address.getBalance());
                transaction.setHash(rpcResult.getBlock().getBlockHash());
                transaction.setCreateDate(null);
                transaction.setFromAddr(null);
                final TTransactionTotal transactionTotal = new TTransactionTotal();
                transactionTotal.setHeight(transaction.getHeight());
                transactionTotal.setTxHash(transaction.getTxHash());
                transactionTotal.setToAddr(transaction.getToAddr());
                transactionTotal.setFee(transaction.getFee());
                transactionTotal.setAmount(transaction.getAmount());
                transactionTotal.setHash(transaction.getHash());
                transactionTotal.setCreateDate(transaction.getCreateDate());
                transactionTotal.setFromAddr(transaction.getFromAddr());
                this.tTransactionMapper.insert(transaction);
                this.tTransactionTotalMapper.insert(transactionTotal);
                final TBlock block = new TBlock();
                block.setCreateDate(null);
                block.setTxCount(1);
                block.setPrevHash(rpcResult.getBlock().getPrevBlockHash());
                block.setHash(rpcResult.getBlock().getBlockHash());
                block.setHeight(rpcResult.getBlock().getHeight());
                block.setcRep("");
                block.setFee("0");
                block.setAmount(address.getBalance());
                block.setBlockSize(blockSize);
                final TBlockTotal blockTotal = new TBlockTotal();
                blockTotal.setCreateDate(block.getCreateDate());
                blockTotal.setTxCount(block.getTxCount());
                blockTotal.setPrevHash(block.getPrevHash());
                blockTotal.setHash(block.getHash());
                blockTotal.setHeight(block.getHeight());
                blockTotal.setcRep(block.getcRep());
                blockTotal.setFee(block.getFee());
                blockTotal.setAmount(block.getAmount());
                blockTotal.setBlockSize(block.getBlockSize());
                this.tBlockMapper.insert(block);
                this.tBlockTotalMapper.insert(blockTotal);
            }
            else if (vo.getName().equals("treasury")) {
                address = new TAddress();
                address.setAddress(vo.getAddress());
                address.setBalance(HexUtil.toDecimalString(vo.getBalance(), DecimalType.ICX.getValue()));
                address.setNodeType("Treasury");
                address.setTxCount(0);
                addressTotal = new TAddressTotal();
                addressTotal.setAddress(address.getAddress());
                addressTotal.setBalance(address.getBalance());
                addressTotal.setNodeType(address.getNodeType());
                addressTotal.setTxCount(address.getTxCount());
            }
            if (address != null) {
                this.tAddressMapper.insert(address);
                this.tAddressTotalMapper.insert(addressTotal);
            }
        }
        final TTxData genesis = new TTxData();
        genesis.setTxHash(rpcResult.getBlock().getBlockHash());
        genesis.setDataBody(msg);
        this.tTxDataMapper.insert(genesis);
        return 1;
    }
    
    public String getBalance(final String address) throws Exception {
        final RpcRes res = this.blockChainAdapter.getBalance(address);
        return HexUtil.toDecimalString(res.getResult().getResponse(), DecimalType.ICX.getValue());
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V2BlockChainServiceImpl.class);
        sLogger = LoggerFactory.getLogger("ScheduleLogger");
    }
}
