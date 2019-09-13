// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import java.util.Set;
import java.math.BigDecimal;
import com.dfg.icon.core.dao.icon.TTransactionTotal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.dfg.icon.core.dao.icon.TBlock;
import com.dfg.icon.core.dao.icon.TBlockExample;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.core.dao.icon.TAddressTotalExample;
import com.theromus.sha.Parameters;
import com.theromus.sha.HexUtils;
import java.util.Random;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v0.dto.CommonRes;
import java.util.HashMap;
import com.theromus.sha.Keccak;
import com.dfg.icon.core.mappers.icon.TTransactionTotalMapper;
import com.dfg.icon.core.mappers.icon.TAddressTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.TBlockMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.DummyService;

@Service
public class DummyServiceImpl implements DummyService
{
    @Autowired
    TBlockMapper tBlockMapper;
    @Autowired
    TAddressTotalMapper tAddressTotalMapper;
    @Autowired
    TTransactionTotalMapper tTransactionTotalMapper;
    Keccak keccak;
    HashMap<String, Long> userMap;
    
    public DummyServiceImpl() {
        this.keccak = new Keccak();
        this.userMap = new HashMap<String, Long>();
    }
    
    @Override
    public CommonRes InitDummyData(final int size) throws Exception {
        final int block_height = 0;
        final long lDate = System.currentTimeMillis() - 1471228928L;
        final String prevBlockHash = "";
        this.userMap.clear();
        this.makeBlock(size, block_height, prevBlockHash, lDate);
        final CommonRes res = new CommonRes();
        res.setCode(IconCode.OK);
        return res;
    }
    
    public String getRandAddr() {
        final Random generator = new Random();
        final int rand = generator.nextInt(100000);
        final String randAddr = this.keccak.getHash(HexUtils.getHex(String.valueOf(rand).getBytes()), Parameters.KECCAK_256);
        return randAddr.substring(24);
    }
    
    @Override
    public CommonRes addDummyData(final int size) throws Exception {
        this.userMap.clear();
        final TAddressTotalExample tAddressTotalExample = new TAddressTotalExample();
        final List<TAddressTotal> tList = this.tAddressTotalMapper.selectByExample(tAddressTotalExample);
        for (final TAddressTotal t : tList) {
            this.userMap.put(t.getAddress(), Long.parseLong(t.getBalance()));
        }
        final TBlockExample bExample = new TBlockExample();
        bExample.setOrderByClause(" height desc limit 1");
        final TBlock tBlock = this.tBlockMapper.selectByExample(bExample).get(0);
        final int block_height = tBlock.getHeight() + 1;
        final long lDate = tBlock.getCreateDate().getTime() + 10000L;
        final String prevBlockHash = tBlock.getHash();
        this.makeBlock(size, block_height, prevBlockHash, lDate);
        final CommonRes res = new CommonRes();
        res.setCode(IconCode.OK);
        return res;
    }
    
    public void makeBlock(final int size, int block_height, String prevBlockHash, long lDate) {
        for (int i = 0; i < size; ++i) {
            final String newBlockHash = this.keccak.getHash(HexUtils.getHex(String.valueOf(lDate).getBytes()), Parameters.KECCAK_256);
            final TBlock tBlock = new TBlock();
            tBlock.setHash(newBlockHash);
            tBlock.setPrevHash(prevBlockHash);
            tBlock.setHeight(block_height);
            tBlock.setCreateDate(new Date(lDate));
            this.tBlockMapper.insert(tBlock);
            final Random generator = new Random();
            int tx_count = generator.nextInt(401);
            if (block_height == 0) {
                tx_count = 1;
            }
            Long sumAmount = 0L;
            Long sumFee = 0L;
            int x_tx_count = 0;
            for (int j = 0; j < tx_count; ++j) {
                final TTransactionTotal tTransactionTotal = new TTransactionTotal();
                tTransactionTotal.setHash(newBlockHash);
                tTransactionTotal.setHeight(Integer.valueOf(block_height));
                tTransactionTotal.setTxHash(this.keccak.getHash(HexUtils.getHex(String.valueOf(System.currentTimeMillis()).getBytes()), Parameters.KECCAK_256));
                tTransactionTotal.setCreateDate(new Date(System.currentTimeMillis()));
                if (block_height == 0) {
                    tTransactionTotal.setToAddr("044852b2a670ade5407e78fb2863c51de9fcb96542a07186fe3aeda6bb8a116d");
                    tTransactionTotal.setAmount("2000000000");
                    this.userMap.put("044852b2a670ade5407e78fb2863c51de9fcb96542a07186fe3aeda6bb8a116d", Long.parseLong("2000000000"));
                    sumAmount += 2000000000L;
                }
                else {
                    final int s = this.userMap.size();
                    int rand = 0;
                    if (s != 1) {
                        rand = generator.nextInt(s - 1);
                    }
                    final Set key = this.userMap.keySet();
                    final Object[] keyArray = key.toArray();
                    final String sendUserKey = keyArray[rand].toString();
                    final Long sendUserAmount = this.userMap.get(sendUserKey);
                    int sendAmount = 0;
                    if (sendUserAmount <= 100L) {
                        ++x_tx_count;
                        continue;
                    }
                    if (sendUserAmount >= 10000L) {
                        sendAmount = generator.nextInt(9999) + 1;
                    }
                    else {
                        sendAmount = generator.nextInt(new BigDecimal(sendUserAmount - 100L).intValueExact()) + 1;
                    }
                    tTransactionTotal.setFromAddr(sendUserKey);
                    tTransactionTotal.setAmount(String.valueOf(sendAmount));
                    String tarUserKey = this.getRandAddr();
                    if (tarUserKey.equals(sendUserKey)) {
                        tarUserKey = this.getRandAddr();
                    }
                    tTransactionTotal.setToAddr(tarUserKey);
                    final int fee = generator.nextInt(100) + 1;
                    tTransactionTotal.setFee(String.valueOf(fee));
                    this.userMap.put(sendUserKey, sendUserAmount - sendAmount - fee);
                    long targetUserAmount = 0L;
                    if (this.userMap.get(tarUserKey) != null) {
                        targetUserAmount = this.userMap.get(tarUserKey);
                    }
                    this.userMap.put(tarUserKey, targetUserAmount + sendAmount);
                    sumAmount += (Long)sendAmount;
                    sumFee += (Long)fee;
                }
                this.tTransactionTotalMapper.insert(tTransactionTotal);
            }
            prevBlockHash = newBlockHash;
            lDate += 10000L;
            tBlock.setAmount(String.valueOf(sumAmount));
            tBlock.setFee(String.valueOf(sumFee));
            tBlock.setTxCount(tx_count - x_tx_count);
            this.tBlockMapper.updateByPrimaryKey(tBlock);
            System.out.println(" Block Height :  " + block_height + " tx_count : " + (tx_count - x_tx_count));
            ++block_height;
        }
    }
}
