// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.v0.service.impl;

import java.util.Arrays;
import com.dfg.icon.core.exception.IconCode;
import com.dfg.icon.web.v0.dto.CommonRes;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.dfg.icon.core.dao.icon.TCurrentExchangeKey;
import com.dfg.icon.core.dao.icon.TCurrentExchange;
import java.util.ArrayList;
import com.dfg.icon.core.dao.icon.TCurrentExchangeExample;
import com.dfg.icon.core.v0.vo.CurrentExchageInfoVo;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import com.dfg.icon.core.mappers.icon.TCurrentExchangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.dfg.icon.core.mappers.icon.ExchangeMapper;
import org.springframework.stereotype.Service;
import com.dfg.icon.core.v0.service.V0ExchangeService;

@Service
public class V0ExchangeServiceImpl implements V0ExchangeService
{
    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    private TCurrentExchangeMapper tCurrentExchangeMapper;
    @Autowired
    Environment env;
    @Value("${exchange.url}")
    String exchageUrl;
    HttpHeaders defaultHeader;
    @Autowired
    private RestTemplate restTemplate;
    
    public V0ExchangeServiceImpl() {
        this.defaultHeader = null;
    }
    
    public void updateExchange() throws Exception {
        final String url = this.exchageUrl + "/selectinfo/currentAllExchange";
        final HttpEntity requestEntity = new HttpEntity((MultiValueMap)this.defaultHeader);
        final ResponseEntity<CurrentExchageInfoVo> response = (ResponseEntity<CurrentExchageInfoVo>)this.restTemplate.exchange(url, HttpMethod.GET, requestEntity, (Class)CurrentExchageInfoVo.class, new Object[0]);
        final CurrentExchageInfoVo cExchageVo = (CurrentExchageInfoVo)response.getBody();
        final TCurrentExchangeExample ce = new TCurrentExchangeExample();
        ce.createCriteria();
        final List<TCurrentExchange> oldDataList = this.tCurrentExchangeMapper.selectByExample(ce);
        final List<TCurrentExchange> rmDataList = new ArrayList<TCurrentExchange>();
        final List<TCurrentExchange> eList = (List<TCurrentExchange>)cExchageVo.getData();
        for (final TCurrentExchange evo : eList) {
            for (final TCurrentExchange oldevo : oldDataList) {
                if (oldevo.getTradeName().equals(evo.getTradeName())) {
                    rmDataList.add(oldevo);
                }
            }
        }
        for (final TCurrentExchange rmevo : rmDataList) {
            oldDataList.remove(rmevo);
        }
        this.exchangeMapper.insertExchageInfoArray(eList);
        for (final TCurrentExchange oldevo2 : oldDataList) {
            final TCurrentExchangeKey tKey = new TCurrentExchangeKey();
            tKey.setMarketName(oldevo2.getMarketName());
            tKey.setTradeName(oldevo2.getTradeName());
            this.tCurrentExchangeMapper.deleteByPrimaryKey(tKey);
        }
    }
    
    public CommonRes selectCurrentAllExchange() throws Exception {
        final TCurrentExchangeExample cExample = new TCurrentExchangeExample();
        cExample.createCriteria();
        final CommonRes cRes = new CommonRes();
        cRes.setCode(IconCode.SUCCESS);
        cRes.setData((Object)this.tCurrentExchangeMapper.selectByExample(cExample));
        return cRes;
    }
    
    public CommonRes selectCurrentExchange(final String code) throws Exception {
        final CommonRes cRes = new CommonRes();
        final TCurrentExchangeExample cExample = new TCurrentExchangeExample();
        cExample.createCriteria().andTradeNameEqualTo(code);
        final List<TCurrentExchange> cList = this.tCurrentExchangeMapper.selectByExample(cExample);
        if (cList.size() == 0) {
            cRes.setCode(IconCode.NO_DATA);
            return cRes;
        }
        cRes.setCode(IconCode.SUCCESS);
        cRes.setData((Object)cList.get(0));
        return cRes;
    }
    
    public CommonRes selectCurrentExchangeList(final String inputCodeList) throws Exception {
        final String[] codeArray = inputCodeList.split(",");
        final List<String> codeList = Arrays.asList(codeArray);
        final List<TCurrentExchange> dbList = this.exchangeMapper.selectExchageInfoList(codeList);
        final List<TCurrentExchange> returnList = new ArrayList<TCurrentExchange>();
        for (final String code : codeList) {
            boolean codeCheck = true;
            for (final TCurrentExchange tCurrentExchange : dbList) {
                if (tCurrentExchange.getTradeName().equals(code)) {
                    codeCheck = false;
                    returnList.add(tCurrentExchange);
                    break;
                }
            }
            if (codeCheck) {
                final TCurrentExchange exchage = new TCurrentExchange();
                exchage.setTradeName(code);
                exchage.setPrice("0");
                exchage.setDailyRate("0");
                returnList.add(exchage);
            }
        }
        final CommonRes cRes = new CommonRes();
        cRes.setCode(IconCode.SUCCESS);
        cRes.setData((Object)returnList);
        return cRes;
    }
}
