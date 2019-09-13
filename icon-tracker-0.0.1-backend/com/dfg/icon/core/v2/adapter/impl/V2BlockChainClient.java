// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v2.adapter.impl;

import org.slf4j.LoggerFactory;
import com.dfg.icon.core.v2.vo.GenesisRpcRes;
import org.springframework.web.client.HttpClientErrorException;
import com.dfg.icon.core.exception.IconException;
import com.dfg.icon.core.exception.IconCode;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import com.dfg.icon.core.v2.vo.RpcReq;
import com.dfg.icon.core.v2.vo.RpcRes;
import javax.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v2.adapter.V2BlockChainAdapter;

@Service
public class V2BlockChainClient implements V2BlockChainAdapter
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
    
    public V2BlockChainClient() {
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
        V2BlockChainClient.logger.info("V2BlockChain URL = {}", (Object)this.API_URL);
        (this.defaultHeader = new HttpHeaders()).setContentType(MediaType.APPLICATION_JSON);
    }
    
    public RpcRes getLastBlock() throws Exception {
        final String url = this.API_URL;
        V2BlockChainClient.logger.info("--------------------");
        V2BlockChainClient.logger.info("[V2 BlockChain] getLastBlock. url = {}", (Object)url);
        try {
            final RpcReq request = new RpcReq();
            request.setMethodLastBlock();
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RpcRes response = (RpcRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RpcRes.class, new Object[0]);
            return response;
        }
        catch (HttpClientErrorException re) {
            V2BlockChainClient.logger.error("BlockChain API rest-template call, responseBody = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V2BlockChainClient.logger.error("A error occurred during BlockChain API rest-template call, errorMsg[{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re2.getMessage());
        }
    }
    
    public RpcRes getBlockInfoByHeight(final Integer height) throws Exception {
        final String url = this.API_URL;
        V2BlockChainClient.logger.info("--------------------");
        V2BlockChainClient.logger.info("[V2 BlockChain] getBlockByHeight. url = {}, height = {}", (Object)url, (Object)height);
        final RpcReq request = new RpcReq();
        request.setMethodGetBlockByHeight(height);
        try {
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RpcRes response = (RpcRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RpcRes.class, new Object[0]);
            return response;
        }
        catch (HttpClientErrorException re) {
            V2BlockChainClient.logger.error("BlockChain API rest-template call, responseBody = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V2BlockChainClient.logger.error("A error occurred during BlockChain API rest-template call, errorMsg[{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re2.getMessage());
        }
    }
    
    public GenesisRpcRes getBlockInfoByGenesis() throws Exception {
        final String url = this.API_URL;
        V2BlockChainClient.logger.info("--------------------");
        V2BlockChainClient.logger.info("[V2 BlockChain] getGenesis. url = {}", (Object)url);
        final RpcReq request = new RpcReq();
        request.setMethodGetGenesisBlock();
        try {
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final GenesisRpcRes response = (GenesisRpcRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)GenesisRpcRes.class, new Object[0]);
            return response;
        }
        catch (HttpClientErrorException re) {
            V2BlockChainClient.logger.error("BlockChain API rest-template call, responseBody = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V2BlockChainClient.logger.error("A error occurred during BlockChain API rest-template call, errorMsg[{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re2.getMessage());
        }
    }
    
    public RpcRes getBalance(final String address) throws Exception {
        final String url = this.API_URL;
        V2BlockChainClient.logger.info("--------------------");
        V2BlockChainClient.logger.info("[V2 BlockChain] getBalance. url = {}, address = {}", (Object)url, (Object)address);
        final RpcReq request = new RpcReq();
        request.setMethodGetBalance(address);
        try {
            final HttpEntity requestEntity = new HttpEntity((Object)request.toString(), (MultiValueMap)this.defaultHeader);
            final RpcRes response = (RpcRes)this.restTemplate.postForObject(url, (Object)requestEntity, (Class)RpcRes.class, new Object[0]);
            return response;
        }
        catch (HttpClientErrorException re) {
            V2BlockChainClient.logger.error("BlockChain API rest-template call, responseBody = [{}]", (Object)re.getResponseBodyAsString());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re.getMessage());
        }
        catch (Exception re2) {
            re2.printStackTrace();
            V2BlockChainClient.logger.error("A error occurred during BlockChain API rest-template call, errorMsg[{}]", (Object)re2.getMessage());
            throw new IconException(IconCode.EXCHANGE_ACCESS_ERROR, re2.getMessage());
        }
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)V2BlockChainClient.class);
    }
}
