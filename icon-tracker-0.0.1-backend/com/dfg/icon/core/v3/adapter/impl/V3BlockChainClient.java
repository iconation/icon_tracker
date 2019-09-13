// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v3.adapter.impl;

import org.slf4j.LoggerFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.dfg.icon.core.v3.vo.RepRes;
import com.dfg.icon.core.v3.vo.RpcBalanceRes;
import com.google.gson.JsonArray;
import java.util.List;
import com.dfg.icon.core.v2.vo.GenesisAccVo;
import com.dfg.icon.core.v3.vo.GenesisTransactionVo;
import java.util.ArrayList;
import com.dfg.icon.core.v3.vo.GenesisRpcResult;
import com.dfg.icon.core.v3.vo.GenesisRpcRes;
import com.dfg.icon.core.v3.vo.TxResultV3Factory;
import com.dfg.icon.core.v3.vo.TxResultV2Factory;
import com.dfg.icon.core.v3.vo.TxResultFactory;
import com.dfg.icon.core.v3.vo.RpcNoParamReq;
import com.google.gson.JsonObject;
import org.springframework.web.client.HttpClientErrorException;
import com.dfg.icon.core.exception.IconException;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.core.v3.vo.BlockV3Factory;
import com.dfg.icon.core.v3.vo.BlockV2Factory;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import com.dfg.icon.core.v3.vo.RpcReq;
import com.dfg.icon.core.v3.vo.BlockFactory;
import javax.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v3.adapter.V3BlockChainAdapter;

@Service
public class V3BlockChainClient implements V3BlockChainAdapter
{
    private static final Logger logger;
    @Value("${block.host}")
    String BLOCK_CHAIN_HOST;
    @Value("${block.api.channel}")
    String BLOCK_CHAIN_API;
    String API_URL;
    @Autowired
    private RestTemplate restTemplate;
    HttpHeaders defaultHeader;
    
    public V3BlockChainClient() {
        this.defaultHeader = null;
    }
    
    @PostConstruct
    public void init() {
        if (this.BLOCK_CHAIN_HOST.contains("api/")) {
            this.API_URL = this.BLOCK_CHAIN_HOST;
        }
        else {
            this.API_URL = new StringBuffer().append(this.BLOCK_CHAIN_HOST).append("/").append(this.BLOCK_CHAIN_API).toString();
        }
        V3BlockChainClient.logger.info("V3BlockChain URL = {}", (Object)this.API_URL);
        (this.defaultHeader = new HttpHeaders()).setContentType(MediaType.APPLICATION_JSON);
    }
    
    public BlockFactory getBlockFactoryByHeight(final Integer height) throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        V3BlockChainClient.logger.info("[V3 BlockChain] getBlockByHeight. url = {}, height = {}", (Object)url, (Object)height);
        try {
            final RpcReq request = new RpcReq();
            request.setMethodGetBlockByHeight(height);
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final JsonObject resultObject = this.getRootObject(jsonStr).get("result").getAsJsonObject();
            BlockFactory blockFactory = null;
            if (resultObject.get("block") != null) {
                V3BlockChainClient.logger.info("[V3 BlockChain] Check Block Format V2 height = {}", (Object)height);
                blockFactory = (BlockFactory)new BlockV2Factory();
            }
            else {
                V3BlockChainClient.logger.info("[V3 BlockChain] Check Block Format V3 height = {}", (Object)height);
                blockFactory = (BlockFactory)new BlockV3Factory();
            }
            blockFactory.init(resultObject, jsonStr.length());
            return blockFactory;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getBlockByHeight. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.TRANSACTION_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getBlockByHeight. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.TRANSACTION_ERROR, re2.getMessage());
        }
    }
    
    public Integer getHeightByBlock(final Integer height) throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        try {
            HttpEntity requestEntity = null;
            if (height == null) {
                V3BlockChainClient.logger.info("[V3 BlockChain] getHeightByBlock. url = {}, height = lastBlock", (Object)url);
                final RpcNoParamReq request = new RpcNoParamReq();
                request.setMethod("icx_getLastBlock");
                requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            }
            else {
                V3BlockChainClient.logger.info("[V3 BlockChain] getHeightByBlock. url = {}, height = {}", (Object)url, (Object)height);
                final RpcReq request2 = new RpcReq();
                request2.setMethodGetBlockByHeight(height);
                requestEntity = new HttpEntity((Object)request2.toString(), (MultiValueMap)this.defaultHeader);
            }
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final JsonObject resultObject = this.getRootObject(jsonStr).get("result").getAsJsonObject();
            if (resultObject.get("block") != null) {
                final Integer blockHeight = resultObject.get("block").getAsJsonObject().get("height").getAsInt();
                V3BlockChainClient.logger.info("[V3 BlockChain] getHeightByBlock V2 height = {}", (Object)blockHeight);
                return blockHeight;
            }
            final Integer blockHeight = resultObject.get("height").getAsInt();
            V3BlockChainClient.logger.info("[V3 BlockChain] getHeightByBlock V3 height = {}", (Object)blockHeight);
            return blockHeight;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getHeightByBlock. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.TRANSACTION_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getHeightByBlock. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.TRANSACTION_ERROR, re2.getMessage());
        }
    }
    
    public TxResultFactory getTransactionResult(final String txHash) throws Exception {
        final String url = this.API_URL;
        final RpcReq request = new RpcReq();
        request.setMethodGetTransactionResult(txHash);
        try {
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final JsonObject rootObject = this.getRootObject(jsonStr);
            if (rootObject.get("result") != null) {
                final JsonObject resultObject = rootObject.get("result").getAsJsonObject();
                TxResultFactory txResultFactory = null;
                if (resultObject.get("code") != null) {
                    txResultFactory = (TxResultFactory)new TxResultV2Factory();
                }
                else {
                    txResultFactory = (TxResultFactory)new TxResultV3Factory();
                }
                txResultFactory.init(resultObject);
                return txResultFactory;
            }
            final JsonObject errorObject = rootObject.get("error").getAsJsonObject();
            final TxResultV2Factory txResultFactory2 = new TxResultV2Factory();
            txResultFactory2.init(errorObject);
            return (TxResultFactory)txResultFactory2;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getTransactionResult. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.TRANSACTION_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getTransactionResult. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.TRANSACTION_ERROR, re2.getMessage());
        }
    }
    
    public GenesisRpcRes getBlockInfoByGenesis() throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        V3BlockChainClient.logger.info("[V3 BlockChain] getGenesis. url = {}", (Object)url);
        final RpcReq request = new RpcReq();
        request.setMethodGetGenesisBlock();
        final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
        try {
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final JsonObject resultObject = this.getRootObject(jsonStr).get("result").getAsJsonObject();
            if (resultObject.get("block") != null) {
                V3BlockChainClient.logger.info("[V3 BlockChain] getGenesisV2");
                return this.getBlockInfoByGenesisV2();
            }
            V3BlockChainClient.logger.info("[V3 BlockChain] getGenesisV3");
            final GenesisRpcRes response = (GenesisRpcRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)GenesisRpcRes.class, new Object[0]);
            return response;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getBlockInfoByGenesis. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.BLOCK_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getBlockInfoByGenesis. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.BLOCK_ERROR, re2.getMessage());
        }
    }
    
    public GenesisRpcRes getBlockInfoByGenesisV2() throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        V3BlockChainClient.logger.info("[V3 BlockChain] getGenesis V2. url = {}", (Object)url);
        try {
            final RpcReq request = new RpcReq();
            request.setMethodGetGenesisBlock();
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final GenesisRpcRes response = new GenesisRpcRes();
            final JsonObject rootObject = this.getRootObject(jsonStr);
            response.setJsonRpc(rootObject.get("jsonrpc").getAsString());
            response.setId(Integer.valueOf(rootObject.get("id").getAsInt()));
            final JsonObject resultObject = rootObject.get("result").getAsJsonObject();
            final JsonObject blockObj = resultObject.get("block").getAsJsonObject();
            final GenesisRpcResult rpcResult = new GenesisRpcResult();
            rpcResult.setBlockHash("0x" + blockObj.get("block_hash").getAsString());
            rpcResult.setVersion(blockObj.get("version").getAsString());
            rpcResult.setPrevBlockHash(blockObj.get("prev_block_hash").getAsString());
            rpcResult.setMerkleTreeRootHash(blockObj.get("merkle_tree_root_hash").getAsString());
            rpcResult.setTimestamp(Long.valueOf(blockObj.get("time_stamp").getAsLong()));
            rpcResult.setHeight(Integer.valueOf(blockObj.get("height").getAsInt()));
            rpcResult.setPeerId(blockObj.get("peer_id").getAsString());
            rpcResult.setSignature(blockObj.get("signature").getAsString());
            final List<GenesisTransactionVo> txList = new ArrayList<GenesisTransactionVo>();
            final JsonObject txObj = blockObj.get("confirmed_transaction_list").getAsJsonArray().get(0).getAsJsonObject();
            final GenesisTransactionVo txVo = new GenesisTransactionVo();
            txVo.setMessage(txObj.get("message").getAsString());
            final JsonArray accObjArray = txObj.get("accounts").getAsJsonArray();
            final List<GenesisAccVo> accVoList = new ArrayList<GenesisAccVo>();
            for (int i = 0; i < accObjArray.size(); ++i) {
                final JsonObject accObj = accObjArray.get(i).getAsJsonObject();
                final GenesisAccVo vo = new GenesisAccVo();
                vo.setAddress(accObj.get("address").getAsString());
                vo.setBalance(accObj.get("balance").getAsString());
                vo.setName(accObj.get("name").getAsString());
                accVoList.add(vo);
            }
            txVo.setAccounts((List)accVoList);
            txList.add(txVo);
            rpcResult.setConfrimedTransactionList((List)txList);
            response.setResult(rpcResult);
            return response;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getBlockInfoByGenesisV2. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.BLOCK_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getBlockInfoByGenesisV2. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.BLOCK_ERROR, re2.getMessage());
        }
    }
    
    public RpcBalanceRes getBalance(final String address) throws Exception {
        final String url = this.API_URL;
        final RpcReq request = new RpcReq();
        request.setMethodGetBalance(address);
        try {
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RpcBalanceRes response = (RpcBalanceRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RpcBalanceRes.class, new Object[0]);
            return response;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getBalance. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.TRANSACTION_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getBalance. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.TRANSACTION_ERROR, re2.getMessage());
        }
    }
    
    public JsonArray getIcxScoreApi(final String address) throws Exception {
        final String url = this.API_URL;
        try {
            final RpcReq request = new RpcReq();
            request.setMethodScoreApi(address);
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final JsonObject rootObject = this.getRootObject(jsonStr);
            if (rootObject.get("result") == null) {
                V3BlockChainClient.logger.error("result is null");
                throw new Exception();
            }
            return rootObject.get("result").getAsJsonArray();
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getIcxScoreApi. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.TRANSACTION_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getIcxScoreApi. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.TRANSACTION_ERROR, re2.getMessage());
        }
    }
    
    public String getIcxCall(final String toAddress, final String method, final String... tokenAddress) throws Exception {
        final String url = this.API_URL;
        final RpcReq request = new RpcReq();
        request.setMethodIcxCall(toAddress, method, tokenAddress);
        try {
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final String jsonStr = (String)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)String.class, new Object[0]);
            final JsonObject rootObject = this.getRootObject(jsonStr);
            if (rootObject == null || rootObject.get("result") == null || rootObject.get("result").isJsonNull()) {
                return null;
            }
            return rootObject.get("result").getAsString();
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError getIcxCall. errMsg = [{}]", (Object)re.getResponseBodyAsString());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception getIcxCall. errMsg = [{}]", (Object)re2.getMessage());
        }
        return null;
    }
    
    public RepRes repGetList() throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        try {
            HttpEntity requestEntity = null;
            V3BlockChainClient.logger.info("[V3 BlockChain] repGetList. url = {}", (Object)url);
            final RpcNoParamReq request = new RpcNoParamReq();
            request.setMethod("rep_getList");
            requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RepRes res = (RepRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RepRes.class, new Object[0]);
            return res;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError repGetList. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            return null;
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception regGetList. errMsg = [{}]", (Object)re2.getMessage());
            return null;
        }
    }
    
    public RepRes repGetListByHeight(final Integer height) throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        try {
            HttpEntity requestEntity = null;
            V3BlockChainClient.logger.info("[V3 BlockChain] repGetListByHeight. url = {}, height = {}", (Object)url, (Object)height);
            final RpcReq request = new RpcReq();
            request.setMethodRepGetListByHeight(height);
            requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RepRes res = (RepRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RepRes.class, new Object[0]);
            return res;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError repGetListByHeight. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.PREP_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception regGetListByHeight. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.PREP_ERROR, re2.getMessage());
        }
    }
    
    public RepRes repGetListByRepRootHash(final String hash) throws Exception {
        final String url = this.API_URL;
        V3BlockChainClient.logger.info("--------------------");
        try {
            HttpEntity requestEntity = null;
            V3BlockChainClient.logger.info("[V3 BlockChain] repGetListByRootHash. url = {}, hash = {}", (Object)url, (Object)hash);
            final RpcReq request = new RpcReq();
            request.setMethodRepGetListByRepRootHash(hash);
            requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RepRes res = (RepRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RepRes.class, new Object[0]);
            return res;
        }
        catch (HttpClientErrorException re) {
            V3BlockChainClient.logger.error("HttpClientError repGetListByRepRootHash. errMsg = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.PREP_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V3BlockChainClient.logger.error("Exception regGetListByRepRootHash. errMsg = [{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.PREP_ERROR, re2.getMessage());
        }
    }
    
    private JsonObject getRootObject(final String jsonStr) {
        final JsonParser parser = new JsonParser();
        final JsonElement element = parser.parse(jsonStr);
        final JsonObject rootObject = element.getAsJsonObject();
        return rootObject;
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V3BlockChainClient.class);
    }
}
