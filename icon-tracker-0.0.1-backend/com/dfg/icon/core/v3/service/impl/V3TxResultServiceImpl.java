// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.service.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.dao.icon.TInternalTxView;
import java.util.ArrayList;
import com.dfg.icon.core.dao.icon.TTokenTxView;
import com.dfg.icon.core.dao.icon.TTransactionView;
import com.dfg.icon.core.dao.icon.TTokenTx;
import com.dfg.icon.core.dao.icon.TInternalTx;
import java.util.List;
import com.dfg.icon.core.dao.icon.TTxResultLog;
import com.dfg.icon.core.v3.vo.EventLog;
import java.util.Iterator;
import com.google.gson.JsonArray;
import com.dfg.icon.core.v3.vo.TokenAddressGroupKey;
import com.dfg.icon.util.IRCUtil;
import java.util.Collection;
import com.dfg.icon.core.dao.icon.TContract;
import com.dfg.icon.util.FactoryUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.dfg.icon.core.dao.icon.TContractHistory;
import com.dfg.icon.core.v3.vo.TxResultFactory;
import java.util.Date;
import com.google.gson.JsonParser;
import com.dfg.icon.core.dao.icon.TTxData;
import com.dfg.icon.util.HexUtil;
import com.dfg.icon.core.v3.vo.DecimalType;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.core.dao.icon.TTransaction;
import com.dfg.icon.core.v3.vo.BlockFactory;
import org.springframework.beans.factory.annotation.Value;
import com.dfg.icon.core.common.service.ResourceService;
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
import com.dfg.icon.core.v3.service.V3TxResultService;

@Service
public class V3TxResultServiceImpl implements V3TxResultService
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
    ResourceService resourceService;
    @Value("${score.path}")
    String SCORE_PATH;
    @Value("${irc.path}")
    String IRC_FILE_PATH;
    @Value("${scheduler.MaxTxCount}")
    Integer maxTxCount;
    
    public V3TxResultServiceImpl() {
        this.speedLogFlag = true;
    }
    
    public BlockFactory initTxResult(BlockFactory bf) throws Exception {
        String sumFee = "0";
        String sumAmount = "0";
        final Integer blockHeight = bf.getBlockInfo().getHeight();
        for (int i = 0; i < bf.getTransactionList().size(); bf = this.addTransactionView(bf, i), ++i) {
            final String txHash = bf.getTransactionList().get(i).getTxHash();
            final String txAmount = bf.getTransactionList().get(i).getAmount();
            String txFee = bf.getTransactionList().get(i).getFee();
            final String txToAddr = bf.getTransactionList().get(i).getToAddr();
            final String txFromAddr = bf.getTransactionList().get(i).getFromAddr();
            final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
            final TxResultFactory txResultfactory = this.blockChainAdapter.getTransactionResult(txHash);
            final int txStatus = txResultfactory.getStatus();
            bf.getTransactionList().get(i).setState(txStatus);
            bf.getTransactionList().get(i).setStepUsedTx(txResultfactory.getStepUsed());
            bf.getTransactionList().get(i).setStepPrice(txResultfactory.getStepPrice());
            if (txStatus == Integer.parseInt(IconCode.TX_RESULT_SUCCESS.getCode())) {
                sumAmount = HexUtil.decimalPlusDecimal(sumAmount, txAmount, DecimalType.ICX.getValue());
            }
            else if (txResultfactory.getFailure() != null) {
                bf.getTransactionList().get(i).setErrorCode(HexUtil.applyDecimal(txResultfactory.getFailure().getCode(), Integer.valueOf(0)));
                bf.getTransactionList().get(i).setErrorMsg(txResultfactory.getFailure().getMessage());
            }
            TContractHistory contractHistory = null;
            if (txResultfactory.getVersion().equals(IconCode.TXNVERSION_3.getCode())) {
                txFee = txResultfactory.getFee();
                bf.getTransactionList().get(i).setFee(txFee);
                bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_ICX.getCode()));
                if (txToAddr.startsWith("cx")) {
                    final String dataType = bf.getTransactionList().get(i).getDataType();
                    final String data = bf.getTransactionDataList().get(i).getDataBody();
                    final JsonParser parser = new JsonParser();
                    JsonElement dataElement = null;
                    if (dataType != null && !dataType.equals("message")) {
                        dataElement = parser.parse(data);
                    }
                    if (dataElement == null || dataElement.isJsonNull()) {
                        dataElement = parser.parse("{}");
                    }
                    final JsonObject rootObject = dataElement.getAsJsonObject();
                    bf.getTransactionList().get(i).setContractAddr(txToAddr);
                    if (IconCode.TXDATATYPE_DEPLOY.getCode().equals(dataType)) {
                        bf.setBreak(true);
                        if (IconCode.SCORE_INSTALL_ADDR.getCode().equals(txToAddr)) {
                            bf = this.installContract(i, bf, txResultfactory, rootObject);
                        }
                        else {
                            bf = this.updateContract(i, bf, txResultfactory, rootObject);
                        }
                    }
                    else if (IconCode.TXDATATYPE_CALL.getCode().equals(dataType)) {
                        if (IconCode.SCORE_CONTROL_ADDR.getCode().equals(txToAddr)) {
                            final String targetMethod = rootObject.get("method").getAsString();
                            if (IconCode.TX_METHOD_TYPE_ACCEPTSCORE.getCode().equals(targetMethod) || IconCode.TX_METHOD_TYPE_REJECTSCORE.getCode().equals(targetMethod)) {
                                String targetTxHash = null;
                                if (rootObject.get("params").getAsJsonObject().get("txHash") != null && !rootObject.get("params").getAsJsonObject().get("txHash").isJsonNull()) {
                                    targetTxHash = rootObject.get("params").getAsJsonObject().get("txHash").getAsString();
                                    contractHistory = this.contractService.getContractHistoryByCreateTx(targetTxHash);
                                }
                                bf.setBreak(true);
                                if (contractHistory == null) {
                                    V3TxResultServiceImpl.logger.error("[TxResultInit] targetTxHash contractHistory \uc815\ubcf4\uac00 \uc5c6\uc74c. txHash={}", (Object)targetTxHash);
                                    bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_CALL.getCode()));
                                }
                                else {
                                    bf.getTransactionList().get(i).setContractAddr(contractHistory.getContractAddr());
                                    if (IconCode.TX_METHOD_TYPE_ACCEPTSCORE.getCode().equals(targetMethod)) {
                                        bf = this.acceptContract(i, bf, txResultfactory, contractHistory);
                                    }
                                    else if (IconCode.TX_METHOD_TYPE_REJECTSCORE.getCode().equals(targetMethod)) {
                                        bf = this.rejectContract(i, bf, txResultfactory, contractHistory);
                                    }
                                }
                                bf = this.setEventResultLog(i, bf, txResultfactory);
                            }
                            else {
                                bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_CALL.getCode()));
                            }
                        }
                        else {
                            bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_TOKEN.getCode()));
                            final int bItxCount = bf.getInternalTransactionList().size();
                            bf = this.setTokenTxEventLog(i, bf, txResultfactory);
                            final int fItxCount = bf.getInternalTransactionList().size();
                            bf.getTransactionList().get(i).setInternalTxCount(fItxCount - bItxCount);
                        }
                    }
                    else {
                        final int bItxCount = bf.getInternalTransactionList().size();
                        bf = this.setTokenTxEventLog(i, bf, txResultfactory);
                        final int fItxCount = bf.getInternalTransactionList().size();
                        bf.getTransactionList().get(i).setInternalTxCount(fItxCount - bItxCount);
                    }
                }
            }
            sumFee = HexUtil.decimalPlusDecimal(sumFee, txFee, DecimalType.ICX.getValue());
        }
        bf.getBlockInfo().setAmount(sumAmount);
        bf.getBlockInfo().setFee(sumFee);
        return bf;
    }
    
    private BlockFactory installContract(final int i, BlockFactory bf, final TxResultFactory trf, final JsonObject rootObject) throws Exception {
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final String txFromAddr = bf.getTransactionList().get(i).getFromAddr();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        final String trfScoreAddress = trf.getScoreAddress();
        final int txStatus = trf.getStatus();
        final int scoreVersion = 1;
        bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_INSTALL.getCode()));
        if (txStatus == Integer.parseInt(IconCode.TX_RESULT_FAILURE.getCode())) {
            rootObject.remove("content");
            bf.getTransactionDataList().get(i).setDataBody(rootObject.toString());
            return bf;
        }
        bf.getTransactionList().get(i).setContractAddr(trfScoreAddress);
        if (this.resourceService.isAcceptMode()) {
            final TContractHistory contractHistory = this.contractService.getContractHistoryForInsert(trfScoreAddress, Integer.valueOf(scoreVersion), "-", txHash, txCreateDate, (String)null, (Date)null, txFromAddr, Integer.valueOf(Integer.parseInt(IconCode.SCORE_ACCEPT.getCode())));
            bf.getContractHistoryList().add(contractHistory);
            bf = this.assignScoreApi(i, bf, trf, contractHistory);
        }
        else {
            final TContractHistory contractHistory = this.contractService.getContractHistoryForInsert(trfScoreAddress, Integer.valueOf(scoreVersion), "-", txHash, txCreateDate, (String)null, (Date)null, txFromAddr, Integer.valueOf(Integer.parseInt(IconCode.SCORE_PENDING.getCode())));
            bf.getContractHistoryList().add(contractHistory);
            final TContract contract = this.contractService.getContractForInsert(trfScoreAddress, (String)null, Integer.valueOf(scoreVersion), (String)null, Integer.valueOf(Integer.parseInt(IconCode.SCORE_PENDING.getCode())));
            bf.getContractList().add(contract);
        }
        bf.getAddressGroup().add(trfScoreAddress);
        FactoryUtil.createZipFileFromByteArrayString(this.SCORE_PATH, trfScoreAddress + "_" + scoreVersion + ".zip", rootObject.get("content").getAsString());
        rootObject.remove("content");
        bf.getTransactionDataList().get(i).setDataBody(rootObject.toString());
        return bf;
    }
    
    private BlockFactory updateContract(final int i, BlockFactory bf, final TxResultFactory trf, final JsonObject rootObject) throws Exception {
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final String txFromAddr = bf.getTransactionList().get(i).getFromAddr();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        final String trfScoreAddress = trf.getScoreAddress();
        final int txStatus = trf.getStatus();
        bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_UPDATE.getCode()));
        if (txStatus == Integer.parseInt(IconCode.TX_RESULT_FAILURE.getCode())) {
            rootObject.remove("content");
            bf.getTransactionDataList().get(i).setDataBody(rootObject.toString());
            return bf;
        }
        final int updateVersion = this.contractService.getContractLastVersionForUpdate(trfScoreAddress);
        bf.getTransactionList().get(i).setContractAddr(trfScoreAddress);
        if (this.resourceService.isAcceptMode()) {
            final TContractHistory contractHistory = this.contractService.getContractHistoryForInsert(trfScoreAddress, Integer.valueOf(updateVersion), "-", txHash, txCreateDate, txHash, txCreateDate, txFromAddr, Integer.valueOf(Integer.parseInt(IconCode.SCORE_ACCEPT.getCode())));
            bf.getContractHistoryList().add(contractHistory);
            bf = this.assignScoreApi(i, bf, trf, contractHistory);
        }
        else {
            final TContractHistory contractHistory = this.contractService.getContractHistoryForInsert(trfScoreAddress, Integer.valueOf(updateVersion), "-", txHash, txCreateDate, (String)null, (Date)null, txFromAddr, Integer.valueOf(Integer.parseInt(IconCode.SCORE_PENDING.getCode())));
            bf.getContractHistoryList().add(contractHistory);
        }
        FactoryUtil.createZipFileFromByteArrayString(this.SCORE_PATH, trfScoreAddress + "_" + updateVersion + ".zip", rootObject.get("content").getAsString());
        rootObject.remove("content");
        bf.getTransactionDataList().get(i).setDataBody(rootObject.toString());
        return bf;
    }
    
    private BlockFactory acceptContract(final int i, BlockFactory bf, final TxResultFactory trf, final TContractHistory contractHistory) throws Exception {
        final int txStatus = trf.getStatus();
        final Integer historyVersion = contractHistory.getVersion();
        final String historyScoreAddress = contractHistory.getContractAddr();
        if (historyVersion == 1) {
            bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_INSTALL_ACCEPT.getCode()));
        }
        else {
            bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_UPDATE_ACCEPT.getCode()));
        }
        if (txStatus == Integer.parseInt(IconCode.TX_RESULT_FAILURE.getCode())) {
            return bf;
        }
        bf = this.assignScoreApi(i, bf, trf, contractHistory);
        if (!bf.getTokenInfoGroup().contains(historyScoreAddress)) {
            bf.getTokenInfoGroup().add(historyScoreAddress);
        }
        bf.getCanceledHistoryList().addAll(this.contractMapper.selectHistoryForCancel(contractHistory));
        return bf;
    }
    
    private BlockFactory rejectContract(final int i, final BlockFactory bf, final TxResultFactory trf, final TContractHistory contractHistory) throws Exception {
        final int txStatus = trf.getStatus();
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        final Integer historyVersion = contractHistory.getVersion();
        final String historyScoreAddress = contractHistory.getContractAddr();
        if (historyVersion == 1) {
            bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_INSTALL_REJECT.getCode()));
        }
        else {
            bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_UPDATE_REJECT.getCode()));
        }
        if (txStatus == Integer.parseInt(IconCode.TX_RESULT_FAILURE.getCode())) {
            return bf;
        }
        final int state = Integer.parseInt(IconCode.SCORE_REJECT.getCode());
        if (historyVersion == 1) {
            bf.getContractList().add(this.contractService.getContractForInsert(historyScoreAddress, (String)null, historyVersion, (String)null, Integer.valueOf(state)));
        }
        contractHistory.setState(state);
        contractHistory.setVerifiedDate(txCreateDate);
        contractHistory.setVerifiedTx(txHash);
        bf.getContractHistoryList().add(contractHistory);
        bf.getCanceledHistoryList().addAll(this.contractMapper.selectHistoryForCancel(contractHistory));
        return bf;
    }
    
    private BlockFactory assignScoreApi(final int i, final BlockFactory bf, final TxResultFactory trf, final TContractHistory contractHistory) throws Exception {
        final Integer historyVersion = contractHistory.getVersion();
        final String historyScoreAddress = contractHistory.getContractAddr();
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        JsonArray scoreApiArray = null;
        try {
            scoreApiArray = this.blockChainAdapter.getIcxScoreApi(historyScoreAddress);
        }
        catch (Exception e) {
            V3TxResultServiceImpl.logger.error("[TxResultInit] getIcxScoreApi scoreAddress = {}", (Object)historyScoreAddress);
            V3TxResultServiceImpl.logger.error(e.getMessage());
            if (historyVersion == 1) {
                TContract contract = this.contractService.getContractByAddress(historyScoreAddress);
                if (contract != null) {
                    contract.setState(Integer.parseInt(IconCode.SCORE_ERROR.getCode()));
                    bf.getContractList().add(contract);
                }
                else {
                    contract = this.contractService.getContractForInsert(historyScoreAddress, "-", Integer.valueOf(1), "-", Integer.valueOf(Integer.parseInt(IconCode.SCORE_ERROR.getCode())));
                    bf.getContractList().add(contract);
                }
            }
            contractHistory.setVerifiedTx(txHash);
            contractHistory.setVerifiedDate(txCreateDate);
            contractHistory.setState(Integer.parseInt(IconCode.SCORE_ERROR.getCode()));
            bf.getContractHistoryList().add(contractHistory);
            return bf;
        }
        Boolean nameFlag = false;
        for (final JsonElement jo : scoreApiArray) {
            if (jo.getAsJsonObject().get("name") != null) {
                final String namestr = jo.getAsJsonObject().get("name").getAsString();
                if ("name".equals(namestr)) {
                    nameFlag = true;
                    break;
                }
                continue;
            }
        }
        String scoreName = "-";
        if (nameFlag) {
            scoreName = this.blockChainAdapter.getIcxCall(historyScoreAddress, "name", new String[0]);
        }
        if (scoreName == null) {
            scoreName = "-";
        }
        else if (scoreName.length() > 256) {
            scoreName = scoreName.substring(0, 256);
        }
        final String ircVersion = IRCUtil.checkIRCVersion(scoreApiArray, this.IRC_FILE_PATH);
        final int state = Integer.parseInt(IconCode.SCORE_ACCEPT.getCode());
        bf.getContractList().add(this.contractService.getContractForInsert(historyScoreAddress, scoreName, historyVersion, ircVersion, Integer.valueOf(state)));
        contractHistory.setState(state);
        contractHistory.setVerifiedDate(txCreateDate);
        contractHistory.setVerifiedTx(txHash);
        bf.getContractHistoryList().add(contractHistory);
        if (IconCode.IRC2_TOKEN.getCode().equals(ircVersion) && historyVersion == 1) {
            String tokenDecimals = this.blockChainAdapter.getIcxCall(historyScoreAddress, "decimals", new String[0]);
            if (tokenDecimals == null) {
                tokenDecimals = IconCode.TOKEN_DEFAULT_DECIMALS.getCode();
            }
            final String tokenSymbol = this.blockChainAdapter.getIcxCall(historyScoreAddress, "symbol", new String[0]);
            String tokenTotalSupply = this.blockChainAdapter.getIcxCall(historyScoreAddress, "totalSupply", new String[0]);
            tokenTotalSupply = HexUtil.applyDecimal(tokenTotalSupply, Integer.valueOf(HexUtil.changeHexToInteger(tokenDecimals)));
            final TContract info = this.getContractForInsert(historyScoreAddress, historyVersion, scoreName, null, tokenSymbol, contractHistory.getCreator(), tokenTotalSupply, HexUtil.changeHexToInteger(tokenDecimals), null);
            bf.getContractList().add(info);
            final TokenAddressGroupKey key1 = new TokenAddressGroupKey(contractHistory.getCreator(), historyScoreAddress, Integer.valueOf(HexUtil.changeHexToInteger(tokenDecimals)));
            if (!bf.getTokenAddressGroup().contains(key1)) {
                bf.getTokenAddressGroup().add(key1);
            }
        }
        return bf;
    }
    
    private BlockFactory setEventResultLog(final int i, final BlockFactory bf, final TxResultFactory trf) throws Exception {
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final String txToAddr = bf.getTransactionList().get(i).getToAddr();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        final int blockHeight = bf.getBlockInfo().getHeight();
        final List<EventLog> txEventLog = (List<EventLog>)trf.getEventLogs();
        int indexCount = 0;
        for (final EventLog event : txEventLog) {
            if (event.getIndexed().size() > 0) {
                final String eventMethod = event.getIndexed().get(0);
                final TTxResultLog resultLog = new TTxResultLog();
                resultLog.setTxHash(txHash);
                resultLog.setMethod(eventMethod);
                resultLog.setContractAddr(txToAddr);
                resultLog.setHeight(blockHeight);
                resultLog.setAge(txCreateDate);
                resultLog.setTxIndex(indexCount);
                resultLog.setEventLog(event.toString());
                bf.getTxResultLogList().add(resultLog);
            }
            ++indexCount;
        }
        return bf;
    }
    
    private BlockFactory setTokenTxEventLog(final int i, final BlockFactory bf, final TxResultFactory trf) throws Exception {
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final String txFee = trf.getFee();
        final int txStatus = trf.getStatus();
        final String txToAddr = bf.getTransactionList().get(i).getToAddr();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        final int blockHeight = bf.getBlockInfo().getHeight();
        final List<EventLog> txEventLog = (List<EventLog>)trf.getEventLogs();
        int indexCount = 0;
        int indexInternalTx = 0;
        int indexTokenTx = 0;
        for (final EventLog event : txEventLog) {
            if (event.getIndexed().size() > 0) {
                final String eventMethod = event.getIndexed().get(0);
                final TTxResultLog resultLog = this.getTxResultLogForInsert(txHash, eventMethod, txToAddr, blockHeight, txCreateDate, indexCount, event.toString());
                bf.getTxResultLogList().add(resultLog);
                final String scoreAddress = event.getScoreAddress();
                if (IconCode.SCORE_METHOD_ICXSEND.getCode().equals(eventMethod)) {
                    bf.getTransactionList().get(i).setTxType(Integer.parseInt(IconCode.TX_TYPE_CALL.getCode()));
                    final TInternalTx tInternalTx = this.getInternalTxForInsert(txHash, indexInternalTx, scoreAddress, txCreateDate, blockHeight, event.getIndexed().get(1), event.getIndexed().get(2), HexUtil.toDecimalString((String)event.getIndexed().get(3), DecimalType.ICX.getValue()));
                    bf.getInternalTransactionList().add(tInternalTx);
                    bf.getInternalTxViewList().addAll(this.getInternalTxViewForInsert(tInternalTx));
                    ++indexInternalTx;
                    if (!bf.getAddressGroup().contains(tInternalTx.getFromAddr())) {
                        bf.getAddressGroup().add(tInternalTx.getFromAddr());
                    }
                    if (!bf.getAddressGroup().contains(tInternalTx.getToAddr())) {
                        bf.getAddressGroup().add(tInternalTx.getToAddr());
                    }
                }
                else if (IconCode.SCORE_METHOD_TRANSFER.getCode().equals(eventMethod)) {
                    TContract contractInfo = this.contractService.getContractByAddress(scoreAddress);
                    if (contractInfo == null) {
                        for (int idx = bf.getContractList().size() - 1; idx > -1; --idx) {
                            if (txToAddr.equals(bf.getContractList().get(idx).getContractAddr())) {
                                contractInfo = bf.getContractList().get(idx);
                                break;
                            }
                        }
                        if (contractInfo == null) {
                            V3TxResultServiceImpl.logger.error("[TxResultInit] contract \uc815\ubcf4\uac00 \uc5c6\uc74c.");
                            continue;
                        }
                    }
                    if (IconCode.IRC2_TOKEN.getCode().equals(contractInfo.getIrcVersion())) {
                        final TTokenTx tokenTx = this.getTokenTxForInsert(scoreAddress, txHash, indexTokenTx, txCreateDate, event.getIndexed().get(1), event.getIndexed().get(2), HexUtil.toDecimalString((String)event.getIndexed().get(3), contractInfo.getDecimals()), contractInfo.getIrcVersion(), txStatus, "0", blockHeight, txFee, Integer.parseInt(IconCode.TX_TYPE_TOKEN.getCode()));
                        bf.getTokenTxList().add(tokenTx);
                        bf.getTokenTxViewList().addAll(this.getTokenTxViewForInsert(tokenTx));
                        ++indexTokenTx;
                        final TokenAddressGroupKey key1 = new TokenAddressGroupKey(tokenTx.getFromAddr(), tokenTx.getContractAddr(), contractInfo.getDecimals());
                        final TokenAddressGroupKey key2 = new TokenAddressGroupKey(tokenTx.getToAddr(), tokenTx.getContractAddr(), contractInfo.getDecimals());
                        if (!bf.getAddressGroup().contains(tokenTx.getFromAddr())) {
                            bf.getAddressGroup().add(tokenTx.getFromAddr());
                        }
                        if (!bf.getAddressGroup().contains(tokenTx.getToAddr())) {
                            bf.getAddressGroup().add(tokenTx.getToAddr());
                        }
                        if (!bf.getTokenAddressGroup().contains(key1)) {
                            bf.getTokenAddressGroup().add(key1);
                        }
                        if (!bf.getTokenAddressGroup().contains(key2) && !IconCode.SCORE_INSTALL_ADDR.getCode().equals(key2.getTokenAddr())) {
                            bf.getTokenAddressGroup().add(key2);
                        }
                    }
                }
            }
            ++indexCount;
        }
        return bf;
    }
    
    private BlockFactory addTransactionView(final BlockFactory bf, final int i) throws Exception {
        final Integer blockHeight = bf.getBlockInfo().getHeight();
        final String txHash = bf.getTransactionList().get(i).getTxHash();
        final String txToAddr = bf.getTransactionList().get(i).getToAddr();
        final String txFromAddr = bf.getTransactionList().get(i).getFromAddr();
        final String contractAddr = bf.getTransactionList().get(i).getContractAddr();
        final Date txCreateDate = bf.getTransactionList().get(i).getCreateDate();
        final int txStatus = bf.getTransactionList().get(i).getState();
        final int txType = bf.getTransactionList().get(i).getTxType();
        final TTransactionView fromView = new TTransactionView();
        fromView.setTxHash(txHash);
        fromView.setAddress(txFromAddr);
        fromView.setHeight(blockHeight);
        fromView.setCreateDate(txCreateDate);
        fromView.setState(txStatus);
        fromView.setTxType(txType);
        bf.getTransactionViewList().add(fromView);
        if (!txFromAddr.equals(txToAddr)) {
            final TTransactionView toView = new TTransactionView();
            toView.setAddress(txToAddr);
            toView.setTxHash(txHash);
            toView.setHeight(blockHeight);
            toView.setCreateDate(txCreateDate);
            toView.setState(txStatus);
            toView.setTxType(txType);
            bf.getTransactionViewList().add(toView);
        }
        if (contractAddr != null && !txFromAddr.equals(contractAddr) && !txToAddr.equals(contractAddr)) {
            final TTransactionView contractView = new TTransactionView();
            contractView.setAddress(contractAddr);
            contractView.setTxHash(txHash);
            contractView.setHeight(blockHeight);
            contractView.setCreateDate(txCreateDate);
            contractView.setState(txStatus);
            contractView.setTxType(txType);
            bf.getTransactionViewList().add(contractView);
        }
        return bf;
    }
    
    private TTxResultLog getTxResultLogForInsert(final String txHash, final String method, final String contractAddr, final Integer height, final Date age, final Integer txIndex, final String eventLog) {
        final TTxResultLog resultLog = new TTxResultLog();
        resultLog.setTxHash(txHash);
        resultLog.setMethod(method);
        resultLog.setContractAddr(contractAddr);
        resultLog.setHeight(height);
        resultLog.setAge(age);
        resultLog.setTxIndex(txIndex);
        resultLog.setEventLog(eventLog);
        return resultLog;
    }
    
    private TContract getContractForInsert(final String contractAddr, final Integer version, final String name, final String ircVersion, final String symbol, final String holderAddr, final String totalSupply, final Integer decimals, final Integer state) {
        final TContract contract = new TContract();
        contract.setContractAddr(contractAddr);
        contract.setVersion(version);
        contract.setName(name);
        contract.setIrcVersion(ircVersion);
        contract.setSymbol(symbol);
        contract.setHolderAddr(holderAddr);
        contract.setTotalSupply(totalSupply);
        contract.setDecimals(decimals);
        contract.setState(state);
        return contract;
    }
    
    public TTokenTx getTokenTxForInsert(final String contractAddr, final String txHash, final Integer txIndex, final Date age, final String fromAddr, final String toAddr, final String quantity, final String ircVersion, final Integer state, final String amount, final Integer blockHeight, final String fee, final Integer txType) {
        final TTokenTx tokenTx = new TTokenTx();
        tokenTx.setContractAddr(contractAddr);
        tokenTx.setTxHash(txHash);
        tokenTx.setTxIndex(txIndex);
        tokenTx.setAge(age);
        tokenTx.setFromAddr(fromAddr);
        tokenTx.setToAddr(toAddr);
        tokenTx.setQuantity(quantity);
        tokenTx.setIrcVersion(ircVersion);
        tokenTx.setState(state);
        tokenTx.setAmount(amount);
        tokenTx.setBlockHeight(blockHeight);
        tokenTx.setFee(fee);
        tokenTx.setTxType(txType);
        return tokenTx;
    }
    
    public List<TTokenTxView> getTokenTxViewForInsert(final TTokenTx tx) {
        final List<TTokenTxView> viewList = new ArrayList<TTokenTxView>();
        final TTokenTxView txView = new TTokenTxView();
        txView.setTxHash(tx.getTxHash());
        txView.setTxIndex(tx.getTxIndex());
        txView.setContractAddr(tx.getContractAddr());
        txView.setBlockHeight(tx.getBlockHeight());
        txView.setAge(tx.getAge());
        txView.setAddress(tx.getFromAddr());
        viewList.add(txView);
        if (!tx.getToAddr().equals(tx.getFromAddr())) {
            final TTokenTxView txView2 = new TTokenTxView();
            txView2.setTxHash(tx.getTxHash());
            txView2.setTxIndex(tx.getTxIndex());
            txView2.setContractAddr(tx.getContractAddr());
            txView2.setBlockHeight(tx.getBlockHeight());
            txView2.setAge(tx.getAge());
            txView2.setAddress(tx.getToAddr());
            viewList.add(txView2);
        }
        return viewList;
    }
    
    private TInternalTx getInternalTxForInsert(final String txHash, final Integer txIndex, final String contractAddr, final Date createDate, final Integer height, final String fromAddr, final String toAddr, final String amount) {
        final TInternalTx tInternalTx = new TInternalTx();
        tInternalTx.setParentTxHash(txHash);
        tInternalTx.setTxIndex(txIndex);
        tInternalTx.setContractAddr(contractAddr);
        tInternalTx.setCreateDate(createDate);
        tInternalTx.setHeight(height);
        tInternalTx.setFromAddr(fromAddr);
        tInternalTx.setToAddr(toAddr);
        tInternalTx.setAmount(amount);
        tInternalTx.setState(1);
        return tInternalTx;
    }
    
    private List<TInternalTxView> getInternalTxViewForInsert(final TInternalTx tx) {
        final List<TInternalTxView> viewList = new ArrayList<TInternalTxView>();
        final TInternalTxView txView = new TInternalTxView();
        txView.setParentTxHash(tx.getParentTxHash());
        txView.setTxIndex(tx.getTxIndex());
        txView.setContractAddr(tx.getContractAddr());
        txView.setHeight(tx.getHeight());
        txView.setCreateDate(tx.getCreateDate());
        txView.setAddress(tx.getFromAddr());
        txView.setState(tx.getState());
        viewList.add(txView);
        if (!tx.getToAddr().equals(tx.getFromAddr())) {
            final TInternalTxView txView2 = new TInternalTxView();
            txView2.setParentTxHash(tx.getParentTxHash());
            txView2.setTxIndex(tx.getTxIndex());
            txView2.setContractAddr(tx.getContractAddr());
            txView2.setHeight(tx.getHeight());
            txView2.setCreateDate(tx.getCreateDate());
            txView2.setAddress(tx.getToAddr());
            txView2.setState(tx.getState());
            viewList.add(txView2);
        }
        return viewList;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3TxResultServiceImpl.class);
        sLogger = LoggerFactory.getLogger("ScheduleLogger");
    }
}
