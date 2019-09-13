// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.web.v3.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PageReq
{
    String hash;
    Integer height;
    String txHash;
    Integer page;
    int counting;
    String address;
    String address2;
    String nodeType;
    Integer txType;
    Integer state;
    String startDate;
    String endDate;
    String type;
    String icxSupply;
    String icxUsd;
    String keyword;
    int id;
    String pageKind;
    
    public PageReq() {
        this.counting = 20;
    }
    
    public PageReq(int counting) {
        if (counting > 100) {
            counting = 100;
        }
        this.counting = counting;
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public void setHash(final String hash) {
        this.hash = hash;
    }
    
    public Integer getHeight() {
        return this.height;
    }
    
    public void setHeight(final Integer height) {
        this.height = height;
    }
    
    public String getTxHash() {
        return this.txHash;
    }
    
    public void setTxHash(final String txHash) {
        this.txHash = txHash;
    }
    
    public Integer getPage() {
        return this.page;
    }
    
    public void setPage(final Integer page) {
        this.page = page;
    }
    
    public int getCounting() {
        return this.counting;
    }
    
    public void setCounting(int counting) {
        if (counting > 100) {
            counting = 100;
        }
        this.counting = counting;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(final String address2) {
        this.address2 = address2;
    }
    
    public String getNodeType() {
        return this.nodeType;
    }
    
    public void setNodeType(final String nodeType) {
        this.nodeType = nodeType;
    }
    
    public Integer getTxType() {
        return this.txType;
    }
    
    public void setTxType(final Integer txType) {
        this.txType = txType;
    }
    
    public Integer getState() {
        return this.state;
    }
    
    public void setState(final Integer state) {
        this.state = state;
    }
    
    public String getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }
    
    public String getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getIcxSupply() {
        return this.icxSupply;
    }
    
    public void setIcxSupply(final String icxSupply) {
        this.icxSupply = icxSupply;
    }
    
    public String getIcxUsd() {
        return this.icxUsd;
    }
    
    public void setIcxUsd(final String icxUsd) {
        this.icxUsd = icxUsd;
    }
    
    public String getKeyword() {
        return this.keyword;
    }
    
    public void setKeyword(final String keyword) {
        this.keyword = keyword;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getPageKind() {
        return this.pageKind;
    }
    
    public void setPageKind(final String pageKind) {
        this.pageKind = pageKind;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, ToStringStyle.JSON_STYLE);
    }
}
