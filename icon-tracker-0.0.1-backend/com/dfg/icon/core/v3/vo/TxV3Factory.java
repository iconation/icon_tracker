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

public class TxV3Factory implements TxFactory
{
    TTransaction tx;
    List<TTransactionView> txView;
    JSONObject jsonData;
    TTxData txData;
    JsonObject dataObject;
    String dataContentObject;
    
    public TxV3Factory() {
        this.tx = null;
        this.txView = null;
        this.jsonData = null;
        this.txData = null;
        this.dataObject = null;
        this.dataContentObject = null;
    }
    
    public void init(final TBlock block, final JsonObject txInfo) throws Exception {
        this.txView = new ArrayList();
        (this.tx = new TTransaction()).setTxHash(txInfo.get("txHash").getAsString());
        this.tx.setHash(block.getHash());
        this.tx.setHeight(block.getHeight());
        this.tx.setCreateDate(FactoryUtil.changeStringTimeStampFormat(txInfo.get("timestamp").getAsString()));
        this.tx.setFromAddr(CommonUtil.checkAddress(txInfo.get("from").getAsString()));
        this.tx.setToAddr(CommonUtil.checkAddress(txInfo.get("to").getAsString()));
        if (txInfo.get("value") == null || txInfo.get("value").isJsonNull()) {
            this.tx.setAmount("0");
        }
        else {
            this.tx.setAmount(HexUtil.toDecimalString(txInfo.get("value").getAsString(), DecimalType.ICX.getValue()));
        }
        this.tx.setStepLimit(HexUtil.applyDecimal(txInfo.get("stepLimit").getAsString(), Integer.valueOf(0)));
        if (txInfo.get("dataType") == null) {
            this.tx.setDataType("icx");
        }
        else {
            this.tx.setDataType(txInfo.get("dataType").getAsString());
        }
        this.tx.setFee("");
        this.tx.setVersion(IconCode.TXNVERSION_3.getCode());
        (this.txData = new TTxData()).setTxHash(this.tx.getTxHash());
        if (txInfo.get("data") != null) {
            final String data = txInfo.get("data").toString();
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
        return IconCode.TXNVERSION_3.getMessage();
    }
    
    public String getValue() throws Exception {
        return this.tx.getAmount();
    }
    
    public TTxData getData() throws Exception {
        return this.txData;
    }
    
    public String getContentData() throws Exception {
        return this.dataContentObject.toString();
    }
    
    public String getDataJsonValueByKey(final String... key) throws Exception {
        JsonObject resultObject = this.dataObject;
        for (final String k : key) {
            resultObject = resultObject.get(k).getAsJsonObject();
        }
        return resultObject.getAsString();
    }
    
    public String getEtc(final String key) throws Exception {
        return this.jsonData.getString(key);
    }
}
