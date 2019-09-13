// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import com.dfg.icon.core.dao.icon.TInternalTxView;
import com.dfg.icon.core.dao.icon.TInternalTx;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TContract;
import java.util.Iterator;
import com.google.gson.JsonArray;
import java.util.Collection;
import com.dfg.icon.util.HexUtil;
import com.google.gson.JsonElement;
import com.dfg.icon.util.FactoryUtil;
import com.dfg.icon.core.exception.IconCode;
import java.util.ArrayList;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.google.gson.JsonObject;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TTransaction;
import java.util.List;
import com.dfg.icon.core.dao.icon.TBlock;

public class BlockV2Factory implements BlockFactory
{
    private TBlock blockInfo;
    private List<TTransaction> txList;
    private List<TTransactionView> txViewList;
    private List<TTxData> txDataList;
    private JsonObject blockObject;
    private List<JsonObject> txJsonList;
    private List<TAddressTotal> addressList;
    private List<String> addressGroup;
    private List<String> tokenInfoGroup;
    private String version;
    private boolean isBreak;
    
    public void init(final JsonObject resultObject, final int blockSize) throws Exception {
        this.isBreak = false;
        this.blockInfo = new TBlock();
        this.txList = new ArrayList();
        this.txJsonList = new ArrayList();
        this.txDataList = new ArrayList();
        this.addressGroup = new ArrayList();
        this.tokenInfoGroup = new ArrayList();
        this.version = IconCode.TXNVERSION_2.getCode();
        this.blockObject = resultObject.get("block").getAsJsonObject();
        final String blockHash = this.blockObject.get("block_hash").getAsString();
        final int blockHeight = this.blockObject.get("height").getAsInt();
        this.blockInfo.setHash(HexType.toDBformatString(blockHash));
        this.blockInfo.setHeight(blockHeight);
        this.blockInfo.setCreateDate(FactoryUtil.changeTimeStampFormat(this.blockObject.get("time_stamp").getAsString()));
        this.blockInfo.setcRep(this.blockObject.get("peer_id").getAsString());
        this.blockInfo.setPrevHash(HexType.toDBformatString(this.blockObject.get("prev_block_hash").getAsString()));
        this.blockInfo.setBlockSize(blockSize);
        final JsonArray txJsonArray = this.blockObject.get("confirmed_transaction_list").getAsJsonArray();
        String sumFee = "0";
        String sumAmount = "0";
        for (final JsonElement confirmedTransactionListElement : txJsonArray) {
            final JsonObject txObject = confirmedTransactionListElement.getAsJsonObject();
            this.txJsonList.add(txObject);
            TxFactory txFactory = null;
            final String txVersion = FactoryUtil.getTxVersion(txObject);
            if (txVersion.equals(IconCode.TXNVERSION_3.getCode())) {
                txFactory = (TxFactory)new TxV3Factory();
                txFactory.init(this.blockInfo, txObject);
            }
            else {
                txFactory = (TxFactory)new TxV2Factory();
                txFactory.init(this.blockInfo, txObject);
                sumFee = HexUtil.decimalPlusDecimal(sumFee, txFactory.getFee(), DecimalType.ICX.getValue());
                sumAmount = HexUtil.decimalPlusDecimal(sumAmount, txFactory.getValue(), DecimalType.ICX.getValue());
            }
            this.txList.add(txFactory.getTransaction());
            this.txViewList.addAll(txFactory.getTransactionView());
            this.txDataList.add(txFactory.getData());
            if (!this.addressGroup.contains(txFactory.getTransaction().getFromAddr())) {
                this.addressGroup.add(txFactory.getTransaction().getFromAddr());
            }
            if (!this.addressGroup.contains(txFactory.getTransaction().getToAddr())) {
                this.addressGroup.add(txFactory.getTransaction().getToAddr());
            }
        }
        this.blockInfo.setTxCount(this.txList.size());
        this.blockInfo.setFee(sumFee);
        this.blockInfo.setAmount(sumAmount);
    }
    
    public List<TContract> getContractList() throws Exception {
        return null;
    }
    
    public List<TContractHistory> getContractHistoryList() throws Exception {
        return null;
    }
    
    public List<TContractHistory> getCanceledHistoryList() throws Exception {
        return null;
    }
    
    public List<TTokenTx> getTokenTxList() throws Exception {
        return null;
    }
    
    public List<TTokenTxView> getTokenTxViewList() throws Exception {
        return null;
    }
    
    public List<TTxResultLog> getTxResultLogList() throws Exception {
        return null;
    }
    
    public List<TokenAddressGroupKey> getTokenAddressGroup() throws Exception {
        return new ArrayList<TokenAddressGroupKey>();
    }
    
    public List<String> getAddressGroup() throws Exception {
        return (List<String>)this.addressGroup;
    }
    
    public List<String> getTokenInfoGroup() throws Exception {
        return (List<String>)this.tokenInfoGroup;
    }
    
    public TBlock getBlockInfo() throws Exception {
        return this.blockInfo;
    }
    
    public String getVersion() throws Exception {
        return this.version;
    }
    
    public List<TTransaction> getTransactionList() throws Exception {
        return (List<TTransaction>)this.txList;
    }
    
    public List<TTransactionView> getTransactionViewList() throws Exception {
        return (List<TTransactionView>)this.txViewList;
    }
    
    public List<TTxData> getTransactionDataList() throws Exception {
        return (List<TTxData>)this.txDataList;
    }
    
    public List<TInternalTx> getInternalTransactionList() throws Exception {
        return null;
    }
    
    public List<TInternalTxView> getInternalTxViewList() throws Exception {
        return null;
    }
    
    public boolean isBreak() {
        return this.isBreak;
    }
    
    public void setBreak(final boolean isBreak) {
        this.isBreak = isBreak;
    }
}
