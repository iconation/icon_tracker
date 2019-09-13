// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.Iterator;
import com.google.gson.JsonArray;
import java.util.Collection;
import com.google.gson.JsonElement;
import com.dfg.icon.util.FactoryUtil;
import com.dfg.icon.util.HexUtil;
import java.util.ArrayList;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.core.dao.icon.TInternalTxView;
import com.dfg.icon.core.dao.icon.TInternalTx;
import com.dfg.icon.core.dao.icon.TAddressTotal;
import com.dfg.icon.core.dao.icon.TTokenAddress;
import com.google.gson.JsonObject;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TTransaction;
import java.util.List;
import com.dfg.icon.core.dao.icon.TBlock;

public class BlockV3Factory implements BlockFactory
{
    private TBlock blockInfo;
    private String version;
    private List<TTransaction> txList;
    private List<TTransactionView> txViewList;
    private List<TTxData> txDataList;
    private List<TContract> contractList;
    private List<TContractHistory> contractHistoryList;
    private List<TContractHistory> canceledHistoryList;
    private List<TTokenTx> tokenTxList;
    private List<TTokenTxView> tokenTxViewList;
    private List<TTxResultLog> txResultLogList;
    private List<JsonObject> txJsonList;
    private List<TTokenAddress> tokenAddressList;
    private List<TokenAddressGroupKey> tokenAddressGroup;
    private List<TAddressTotal> addressList;
    private List<String> addressGroup;
    private List<String> tokenInfoGroup;
    private List<TInternalTx> internalTxList;
    private List<TInternalTxView> internalTxViewList;
    private JsonObject blockObject;
    private boolean isBreak;
    
    public void init(final JsonObject resultObject, final int blockSize) throws Exception {
        this.isBreak = false;
        this.version = IconCode.TXNVERSION_3.getCode();
        this.blockInfo = new TBlock();
        this.txList = new ArrayList();
        this.txViewList = new ArrayList();
        this.txJsonList = new ArrayList();
        this.txDataList = new ArrayList();
        this.contractList = new ArrayList();
        this.tokenTxList = new ArrayList();
        this.tokenTxViewList = new ArrayList();
        this.contractHistoryList = new ArrayList();
        this.canceledHistoryList = new ArrayList();
        this.txResultLogList = new ArrayList();
        this.tokenAddressList = new ArrayList();
        this.tokenAddressGroup = new ArrayList();
        this.addressList = new ArrayList();
        this.addressGroup = new ArrayList();
        this.tokenInfoGroup = new ArrayList();
        this.internalTxList = new ArrayList();
        this.internalTxViewList = new ArrayList();
        this.blockObject = resultObject;
        this.blockInfo.setHash(HexType.toDBformatString(this.blockObject.get("block_hash").getAsString()));
        this.blockInfo.setHeight(HexUtil.changeStringToInteger(this.blockObject.get("height").getAsString()));
        this.blockInfo.setCreateDate(FactoryUtil.changeStringTimeStampFormat(this.blockObject.get("time_stamp").getAsString()));
        this.blockInfo.setcRep(this.blockObject.get("peer_id").getAsString());
        this.blockInfo.setPrevHash(HexType.toDBformatString(this.blockObject.get("prev_block_hash").getAsString()));
        this.blockInfo.setBlockSize(blockSize);
        final JsonArray txJsonArray = this.blockObject.get("confirmed_transaction_list").getAsJsonArray();
        for (final JsonElement confirmedTransactionListElement : txJsonArray) {
            final JsonObject txObject = confirmedTransactionListElement.getAsJsonObject();
            this.txJsonList.add(txObject);
            TxFactory txFactory = null;
            final String txVersion = FactoryUtil.getTxVersion(txObject);
            if (txVersion.equals(IconCode.TXNVERSION_3.getCode())) {
                txFactory = (TxFactory)new TxV3Factory();
            }
            else {
                txFactory = (TxFactory)new TxV2Factory();
            }
            txFactory.init(this.blockInfo, txObject);
            this.txList.add(txFactory.getTransaction());
            this.txViewList.addAll(txFactory.getTransactionView());
            this.txDataList.add(txFactory.getData());
            final String fromAddr = txFactory.getTransaction().getFromAddr();
            final String toAddr = txFactory.getTransaction().getToAddr();
            if (fromAddr != null && fromAddr.length() > 2 && "cx".equals(fromAddr.substring(0, 2)) && !this.tokenInfoGroup.contains(fromAddr)) {
                this.tokenInfoGroup.add(fromAddr);
            }
            if (toAddr != null && toAddr.length() > 2 && "cx".equals(toAddr.substring(0, 2)) && !this.tokenInfoGroup.contains(toAddr)) {
                this.tokenInfoGroup.add(toAddr);
            }
            if (!this.addressGroup.contains(fromAddr)) {
                this.addressGroup.add(fromAddr);
            }
            if (!this.addressGroup.contains(toAddr)) {
                this.addressGroup.add(toAddr);
            }
        }
        this.blockInfo.setTxCount(this.txList.size());
    }
    
    public List<TContract> getContractList() throws Exception {
        return (List<TContract>)this.contractList;
    }
    
    public List<TContractHistory> getContractHistoryList() throws Exception {
        return (List<TContractHistory>)this.contractHistoryList;
    }
    
    public List<TContractHistory> getCanceledHistoryList() throws Exception {
        return (List<TContractHistory>)this.canceledHistoryList;
    }
    
    public List<TTokenTx> getTokenTxList() throws Exception {
        return (List<TTokenTx>)this.tokenTxList;
    }
    
    public List<TTokenTxView> getTokenTxViewList() throws Exception {
        return (List<TTokenTxView>)this.tokenTxViewList;
    }
    
    public List<TTxResultLog> getTxResultLogList() throws Exception {
        return (List<TTxResultLog>)this.txResultLogList;
    }
    
    public List<TokenAddressGroupKey> getTokenAddressGroup() throws Exception {
        return (List<TokenAddressGroupKey>)this.tokenAddressGroup;
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
    
    public List<TTransaction> getTransactionList() throws Exception {
        return (List<TTransaction>)this.txList;
    }
    
    public List<TTransactionView> getTransactionViewList() throws Exception {
        return (List<TTransactionView>)this.txViewList;
    }
    
    public List<TTxData> getTransactionDataList() throws Exception {
        return (List<TTxData>)this.txDataList;
    }
    
    public String getVersion() throws Exception {
        return this.version;
    }
    
    public List<TInternalTx> getInternalTransactionList() throws Exception {
        return (List<TInternalTx>)this.internalTxList;
    }
    
    public List<TInternalTxView> getInternalTxViewList() throws Exception {
        return (List<TInternalTxView>)this.internalTxViewList;
    }
    
    public boolean isBreak() {
        return this.isBreak;
    }
    
    public void setBreak(final boolean isBreak) {
        this.isBreak = isBreak;
    }
}
