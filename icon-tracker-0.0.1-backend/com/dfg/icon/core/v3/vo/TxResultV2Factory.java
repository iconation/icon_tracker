// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import java.util.List;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.exception.IconCode;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class TxResultV2Factory implements TxResultFactory
{
    TxResult txResult;
    TxResultFailure txResultFailure;
    JSONObject jsonData;
    JsonObject dataObject;
    
    public TxResultV2Factory() {
        this.txResult = null;
        this.txResultFailure = null;
        this.jsonData = null;
        this.dataObject = null;
    }
    
    public void init(final JsonObject txResultInfo) throws Exception {
        this.txResult = new TxResult();
        final int code = txResultInfo.get("code").getAsInt();
        if (code == 0) {
            this.txResult.setStatus(Integer.valueOf(1));
            this.txResult.setStepPrice("10000000000");
            this.txResult.setStepUsed("1000000");
        }
        else {
            this.txResult.setStatus(Integer.valueOf(0));
            (this.txResultFailure = new TxResultFailure()).setCode(txResultInfo.get("code").getAsString());
            this.txResultFailure.setMessage(txResultInfo.get("message").getAsString());
            this.txResult.setFailure(this.txResultFailure);
        }
        this.txResult.setVersion(IconCode.TXNVERSION_2.getCode());
    }
    
    public Integer getStatus() throws Exception {
        return this.txResult.getStatus();
    }
    
    public TxResultFailure getFailure() throws Exception {
        if (this.txResult.getStatus() == 0) {
            return this.txResultFailure;
        }
        return null;
    }
    
    public String getTxHash() throws Exception {
        return this.txResult.getTxHash();
    }
    
    public Integer getTxIndex() throws Exception {
        return this.txResult.getTxIndex();
    }
    
    public Integer getBlockHeight() throws Exception {
        return this.txResult.getBlockHeight();
    }
    
    public String getBlockHash() throws Exception {
        return this.txResult.getBlockHash();
    }
    
    public String getCumulativeStepUsed() throws Exception {
        return this.txResult.getCumulativeStepUsed();
    }
    
    public String getStepUsed() throws Exception {
        return this.txResult.getStepUsed();
    }
    
    public String getStepPrice() throws Exception {
        return this.txResult.getStepPrice();
    }
    
    public String getFee() throws Exception {
        if (this.txResult.getStepUsed() != null && this.txResult.getStepPrice() != null) {
            return HexUtil.decimalMultiDecimal(this.txResult.getStepUsed(), HexUtil.applyDecimal(this.txResult.getStepPrice(), DecimalType.ICX.getValue()), DecimalType.ICX.getValue());
        }
        return "0";
    }
    
    public String getScoreAddress() throws Exception {
        return this.txResult.getScoreAddress();
    }
    
    public String getTo() throws Exception {
        return this.txResult.getTo();
    }
    
    public List<EventLog> getEventLogs() throws Exception {
        return (List<EventLog>)this.txResult.getEventLogList();
    }
    
    public String getVersion() {
        return this.txResult.getVersion();
    }
}
