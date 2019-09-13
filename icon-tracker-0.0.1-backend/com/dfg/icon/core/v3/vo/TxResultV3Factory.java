// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.vo;

import org.slf4j.LoggerFactory;
import java.util.List;
import com.google.gson.JsonArray;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.util.HexUtil;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.slf4j.Logger;

public class TxResultV3Factory implements TxResultFactory
{
    private static final Logger logger;
    TxResult txResult;
    TxResultFailure txResultFailure;
    JSONObject jsonData;
    JsonObject dataObject;
    
    public TxResultV3Factory() {
        this.txResult = null;
        this.txResultFailure = null;
        this.jsonData = null;
        this.dataObject = null;
    }
    
    public void init(final JsonObject txResultInfo) throws Exception {
        (this.txResult = new TxResult()).setStatus(Integer.valueOf(HexUtil.changeHexToInteger(txResultInfo.get("status").getAsString())));
        this.txResult.setStepUsed(String.valueOf(HexUtil.applyDecimal(txResultInfo.get("stepUsed").getAsString(), Integer.valueOf(0))));
        this.txResult.setStepPrice(String.valueOf(HexUtil.applyDecimal(txResultInfo.get("stepPrice").getAsString(), Integer.valueOf(0))));
        this.txResult.setVersion(IconCode.TXNVERSION_3.getCode());
        if (this.txResult.getStatus() == 0) {
            this.txResultFailure = new TxResultFailure();
            final JsonObject failure = txResultInfo.get("failure").getAsJsonObject();
            this.txResultFailure.setCode(failure.get("code").getAsString());
            this.txResultFailure.setMessage(failure.get("message").getAsString());
            this.txResult.setFailure(this.txResultFailure);
            return;
        }
        this.txResult.setTxHash(txResultInfo.get("txHash").getAsString());
        this.txResult.setTxIndex(Integer.valueOf(HexUtil.changeHexToInteger(txResultInfo.get("txIndex").getAsString())));
        this.txResult.setBlockHeight(Integer.valueOf(HexUtil.changeHexToInteger(txResultInfo.get("blockHeight").getAsString())));
        if (txResultInfo.get("blockHash") == null || txResultInfo.get("blockHash").isJsonNull()) {
            this.txResult.setBlockHash("");
        }
        else {
            this.txResult.setBlockHash(txResultInfo.get("blockHash").getAsString());
        }
        this.txResult.setTo(txResultInfo.get("to").getAsString());
        if (txResultInfo.get("scoreAddress") == null || txResultInfo.get("scoreAddress").isJsonNull()) {
            this.txResult.setScoreAddress("-");
        }
        else {
            this.txResult.setScoreAddress(txResultInfo.get("scoreAddress").getAsString());
        }
        final JsonArray el = txResultInfo.get("eventLogs").getAsJsonArray();
        for (int i = 0; i < el.size(); ++i) {
            final JsonObject elo = el.get(i).getAsJsonObject();
            final EventLog log = new EventLog();
            if (elo.get("scoreAddress") != null && !elo.get("scoreAddress").isJsonNull()) {
                log.setScoreAddress(elo.get("scoreAddress").getAsString());
            }
            if (elo.get("indexed") != null && !elo.get("indexed").isJsonNull()) {
                final JsonArray idxArray = elo.get("indexed").getAsJsonArray();
                for (int j = 0; j < idxArray.size(); ++j) {
                    log.getIndexed().add(idxArray.get(j).getAsString());
                }
            }
            if (elo.get("data") != null && !elo.get("data").isJsonNull()) {
                final JsonArray dataArray = elo.get("data").getAsJsonArray();
                for (int j = 0; j < dataArray.size(); ++j) {
                    try {
                        if (dataArray.get(j) != null && !dataArray.get(j).isJsonNull()) {
                            log.getData().add(dataArray.get(j).getAsString());
                        }
                        else {
                            log.getData().add(null);
                        }
                    }
                    catch (Exception e) {
                        TxResultV3Factory.logger.error("[TxResultInit] data obj json parsing error = [{}]", (Object)e.getMessage());
                        log.getData().add(null);
                    }
                }
            }
            this.txResult.getEventLogList().add(log);
        }
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
    
    static {
        TxResultV3Factory.logger = LoggerFactory.getLogger((Class)TxResultV3Factory.class);
    }
}
