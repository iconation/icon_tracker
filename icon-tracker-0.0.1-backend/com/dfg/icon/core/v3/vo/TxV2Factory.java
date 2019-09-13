// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.util.CommonUtil;
import com.dfg.icon.util.FactoryUtil;
import java.util.ArrayList;
import com.dfg.icon.core.dao.icon.TBlock;
import com.google.gson.JsonObject;
import com.dfg.icon.core.dao.icon.TTxData;
import org.json.JSONObject;
import com.dfg.icon.core.dao.icon.TTransactionView;
import java.util.List;
import com.dfg.icon.core.dao.icon.TTransaction;

public class TxV2Factory implements TxFactory
{
    TTransaction tx;
    List<TTransactionView> txView;
    JSONObject jsonData;
    TTxData txData;
    JsonObject dataObject;
    
    public TxV2Factory() {
        this.tx = null;
        this.txView = null;
        this.jsonData = null;
        this.txData = null;
        this.dataObject = null;
    }
    
    public void init(final TBlock block, final JsonObject txInfo) throws Exception {
        this.txView = new ArrayList();
        (this.tx = new TTransaction()).setTxHash(HexType.toDBformatString(txInfo.get("tx_hash").getAsString()));
        this.tx.setHash(block.getHash());
        this.tx.setHeight(block.getHeight());
        if (txInfo.get("timestamp") == null) {
            this.tx.setCreateDate(block.getCreateDate());
        }
        else {
            this.tx.setCreateDate(FactoryUtil.changeTimeStampFormat(txInfo.get("timestamp").getAsString()));
        }
        this.tx.setFromAddr(CommonUtil.checkAddress(txInfo.get("from").getAsString()));
        this.tx.setToAddr(CommonUtil.checkAddress(txInfo.get("to").getAsString()));
        this.tx.setAmount(HexUtil.toDecimalString(txInfo.get("value").getAsString(), DecimalType.ICX.getValue()));
        this.tx.setFee(HexUtil.toDecimalString(txInfo.get("fee").getAsString(), DecimalType.ICX.getValue()));
        this.tx.setStepUsedTx(this.tx.getFee());
        this.tx.setStepPrice("1");
        this.tx.setVersion(IconCode.TXNVERSION_2.getCode());
        this.tx.setTxType(Integer.parseInt(IconCode.TX_TYPE_ICX.getCode()));
        this.tx.setDataType("icx");
        this.tx.setState(Integer.parseInt(IconCode.TX_RESULT_SUCCESS.getCode()));
        (this.txData = new TTxData()).setTxHash(this.tx.getTxHash());
        if (txInfo.get("data") != null) {
            final String data = txInfo.get("data").getAsString();
            this.txData.setDataBody(data);
        }
        else {
            this.txData.setDataBody("");
        }
    }
    
    public String getFee() {
        return this.tx.getFee();
    }
    
    public TTransaction getTransaction() {
        return this.tx;
    }
    
    public List<TTransactionView> getTransactionView() {
        return (List<TTransactionView>)this.txView;
    }
    
    public String getVersion() {
        return IconCode.TXNVERSION_2.getMessage();
    }
    
    public String getValue() {
        return this.tx.getAmount();
    }
    
    public TTxData getData() throws Exception {
        return this.txData;
    }
    
    public String getEtc(final String key) throws Exception {
        return this.jsonData.getString(key);
    }
    
    public String getDataJsonValueByKey(final String... key) throws Exception {
        JsonObject resultObject = this.dataObject;
        for (final String k : key) {
            resultObject = resultObject.get(k).getAsJsonObject();
        }
        return resultObject.getAsString();
    }
    
    public String getContentData() throws Exception {
        return null;
    }
}
