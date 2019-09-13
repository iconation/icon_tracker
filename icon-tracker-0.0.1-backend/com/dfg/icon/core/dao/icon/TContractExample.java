// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.ArrayList;
import java.util.List;

public class TContractExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TContractExample() {
        this.oredCriteria = new ArrayList();
    }
    
    public void setOrderByClause(final String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    public String getOrderByClause() {
        return this.orderByClause;
    }
    
    public void setDistinct(final boolean distinct) {
        this.distinct = distinct;
    }
    
    public boolean isDistinct() {
        return this.distinct;
    }
    
    public List<Criteria> getOredCriteria() {
        return (List<Criteria>)this.oredCriteria;
    }
    
    public void or(final Criteria criteria) {
        this.oredCriteria.add(criteria);
    }
    
    public Criteria or() {
        final Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }
    
    public Criteria createCriteria() {
        final Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    protected Criteria createCriteriaInternal() {
        final Criteria criteria = new Criteria();
        return criteria;
    }
    
    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }
    
    protected abstract static class GeneratedCriteria
    {
        protected List<Criterion> criteria;
        
        protected GeneratedCriteria() {
            this.criteria = new ArrayList();
        }
        
        public boolean isValid() {
            return this.criteria.size() > 0;
        }
        
        public List<Criterion> getAllCriteria() {
            return (List<Criterion>)this.criteria;
        }
        
        public List<Criterion> getCriteria() {
            return (List<Criterion>)this.criteria;
        }
        
        protected void addCriterion(final String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            this.criteria.add(new Criterion(condition));
        }
        
        protected void addCriterion(final String condition, final Object value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value));
        }
        
        protected void addCriterion(final String condition, final Object value1, final Object value2, final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value1, value2));
        }
        
        public Criteria andContractAddrIsNull() {
            this.addCriterion("contract_addr is null");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrIsNotNull() {
            this.addCriterion("contract_addr is not null");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrEqualTo(final String value) {
            this.addCriterion("contract_addr =", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrNotEqualTo(final String value) {
            this.addCriterion("contract_addr <>", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrGreaterThan(final String value) {
            this.addCriterion("contract_addr >", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrGreaterThanOrEqualTo(final String value) {
            this.addCriterion("contract_addr >=", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrLessThan(final String value) {
            this.addCriterion("contract_addr <", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrLessThanOrEqualTo(final String value) {
            this.addCriterion("contract_addr <=", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrLike(final String value) {
            this.addCriterion("contract_addr like", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrNotLike(final String value) {
            this.addCriterion("contract_addr not like", value, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrIn(final List<String> values) {
            this.addCriterion("contract_addr in", values, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrNotIn(final List<String> values) {
            this.addCriterion("contract_addr not in", values, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrBetween(final String value1, final String value2) {
            this.addCriterion("contract_addr between", value1, value2, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andContractAddrNotBetween(final String value1, final String value2) {
            this.addCriterion("contract_addr not between", value1, value2, "contractAddr");
            return (Criteria)this;
        }
        
        public Criteria andVersionIsNull() {
            this.addCriterion("version is null");
            return (Criteria)this;
        }
        
        public Criteria andVersionIsNotNull() {
            this.addCriterion("version is not null");
            return (Criteria)this;
        }
        
        public Criteria andVersionEqualTo(final Integer value) {
            this.addCriterion("version =", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotEqualTo(final Integer value) {
            this.addCriterion("version <>", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionGreaterThan(final Integer value) {
            this.addCriterion("version >", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("version >=", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLessThan(final Integer value) {
            this.addCriterion("version <", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLessThanOrEqualTo(final Integer value) {
            this.addCriterion("version <=", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionIn(final List<Integer> values) {
            this.addCriterion("version in", values, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotIn(final List<Integer> values) {
            this.addCriterion("version not in", values, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionBetween(final Integer value1, final Integer value2) {
            this.addCriterion("version between", value1, value2, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("version not between", value1, value2, "version");
            return (Criteria)this;
        }
        
        public Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (Criteria)this;
        }
        
        public Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (Criteria)this;
        }
        
        public Criteria andNameEqualTo(final String value) {
            this.addCriterion("name =", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotEqualTo(final String value) {
            this.addCriterion("name <>", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameGreaterThan(final String value) {
            this.addCriterion("name >", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("name >=", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameLessThan(final String value) {
            this.addCriterion("name <", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameLessThanOrEqualTo(final String value) {
            this.addCriterion("name <=", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameLike(final String value) {
            this.addCriterion("name like", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotLike(final String value) {
            this.addCriterion("name not like", value, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameIn(final List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotIn(final List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameBetween(final String value1, final String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (Criteria)this;
        }
        
        public Criteria andNameNotBetween(final String value1, final String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionIsNull() {
            this.addCriterion("irc_version is null");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionIsNotNull() {
            this.addCriterion("irc_version is not null");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionEqualTo(final String value) {
            this.addCriterion("irc_version =", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionNotEqualTo(final String value) {
            this.addCriterion("irc_version <>", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionGreaterThan(final String value) {
            this.addCriterion("irc_version >", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionGreaterThanOrEqualTo(final String value) {
            this.addCriterion("irc_version >=", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionLessThan(final String value) {
            this.addCriterion("irc_version <", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionLessThanOrEqualTo(final String value) {
            this.addCriterion("irc_version <=", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionLike(final String value) {
            this.addCriterion("irc_version like", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionNotLike(final String value) {
            this.addCriterion("irc_version not like", value, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionIn(final List<String> values) {
            this.addCriterion("irc_version in", values, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionNotIn(final List<String> values) {
            this.addCriterion("irc_version not in", values, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionBetween(final String value1, final String value2) {
            this.addCriterion("irc_version between", value1, value2, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andIrcVersionNotBetween(final String value1, final String value2) {
            this.addCriterion("irc_version not between", value1, value2, "ircVersion");
            return (Criteria)this;
        }
        
        public Criteria andSymbolIsNull() {
            this.addCriterion("symbol is null");
            return (Criteria)this;
        }
        
        public Criteria andSymbolIsNotNull() {
            this.addCriterion("symbol is not null");
            return (Criteria)this;
        }
        
        public Criteria andSymbolEqualTo(final String value) {
            this.addCriterion("symbol =", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolNotEqualTo(final String value) {
            this.addCriterion("symbol <>", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolGreaterThan(final String value) {
            this.addCriterion("symbol >", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolGreaterThanOrEqualTo(final String value) {
            this.addCriterion("symbol >=", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolLessThan(final String value) {
            this.addCriterion("symbol <", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolLessThanOrEqualTo(final String value) {
            this.addCriterion("symbol <=", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolLike(final String value) {
            this.addCriterion("symbol like", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolNotLike(final String value) {
            this.addCriterion("symbol not like", value, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolIn(final List<String> values) {
            this.addCriterion("symbol in", values, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolNotIn(final List<String> values) {
            this.addCriterion("symbol not in", values, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolBetween(final String value1, final String value2) {
            this.addCriterion("symbol between", value1, value2, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andSymbolNotBetween(final String value1, final String value2) {
            this.addCriterion("symbol not between", value1, value2, "symbol");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrIsNull() {
            this.addCriterion("holder_addr is null");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrIsNotNull() {
            this.addCriterion("holder_addr is not null");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrEqualTo(final String value) {
            this.addCriterion("holder_addr =", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrNotEqualTo(final String value) {
            this.addCriterion("holder_addr <>", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrGreaterThan(final String value) {
            this.addCriterion("holder_addr >", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrGreaterThanOrEqualTo(final String value) {
            this.addCriterion("holder_addr >=", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrLessThan(final String value) {
            this.addCriterion("holder_addr <", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrLessThanOrEqualTo(final String value) {
            this.addCriterion("holder_addr <=", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrLike(final String value) {
            this.addCriterion("holder_addr like", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrNotLike(final String value) {
            this.addCriterion("holder_addr not like", value, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrIn(final List<String> values) {
            this.addCriterion("holder_addr in", values, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrNotIn(final List<String> values) {
            this.addCriterion("holder_addr not in", values, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrBetween(final String value1, final String value2) {
            this.addCriterion("holder_addr between", value1, value2, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderAddrNotBetween(final String value1, final String value2) {
            this.addCriterion("holder_addr not between", value1, value2, "holderAddr");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountIsNull() {
            this.addCriterion("holder_count is null");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountIsNotNull() {
            this.addCriterion("holder_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountEqualTo(final Integer value) {
            this.addCriterion("holder_count =", value, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountNotEqualTo(final Integer value) {
            this.addCriterion("holder_count <>", value, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountGreaterThan(final Integer value) {
            this.addCriterion("holder_count >", value, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("holder_count >=", value, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountLessThan(final Integer value) {
            this.addCriterion("holder_count <", value, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("holder_count <=", value, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountIn(final List<Integer> values) {
            this.addCriterion("holder_count in", values, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountNotIn(final List<Integer> values) {
            this.addCriterion("holder_count not in", values, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("holder_count between", value1, value2, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andHolderCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("holder_count not between", value1, value2, "holderCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountIsNull() {
            this.addCriterion("transfer_count is null");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountIsNotNull() {
            this.addCriterion("transfer_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountEqualTo(final Integer value) {
            this.addCriterion("transfer_count =", value, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountNotEqualTo(final Integer value) {
            this.addCriterion("transfer_count <>", value, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountGreaterThan(final Integer value) {
            this.addCriterion("transfer_count >", value, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("transfer_count >=", value, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountLessThan(final Integer value) {
            this.addCriterion("transfer_count <", value, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("transfer_count <=", value, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountIn(final List<Integer> values) {
            this.addCriterion("transfer_count in", values, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountNotIn(final List<Integer> values) {
            this.addCriterion("transfer_count not in", values, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("transfer_count between", value1, value2, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTransferCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("transfer_count not between", value1, value2, "transferCount");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyIsNull() {
            this.addCriterion("total_supply is null");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyIsNotNull() {
            this.addCriterion("total_supply is not null");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyEqualTo(final String value) {
            this.addCriterion("total_supply =", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyNotEqualTo(final String value) {
            this.addCriterion("total_supply <>", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyGreaterThan(final String value) {
            this.addCriterion("total_supply >", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyGreaterThanOrEqualTo(final String value) {
            this.addCriterion("total_supply >=", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyLessThan(final String value) {
            this.addCriterion("total_supply <", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyLessThanOrEqualTo(final String value) {
            this.addCriterion("total_supply <=", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyLike(final String value) {
            this.addCriterion("total_supply like", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyNotLike(final String value) {
            this.addCriterion("total_supply not like", value, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyIn(final List<String> values) {
            this.addCriterion("total_supply in", values, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyNotIn(final List<String> values) {
            this.addCriterion("total_supply not in", values, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyBetween(final String value1, final String value2) {
            this.addCriterion("total_supply between", value1, value2, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andTotalSupplyNotBetween(final String value1, final String value2) {
            this.addCriterion("total_supply not between", value1, value2, "totalSupply");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsIsNull() {
            this.addCriterion("decimals is null");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsIsNotNull() {
            this.addCriterion("decimals is not null");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsEqualTo(final Integer value) {
            this.addCriterion("decimals =", value, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsNotEqualTo(final Integer value) {
            this.addCriterion("decimals <>", value, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsGreaterThan(final Integer value) {
            this.addCriterion("decimals >", value, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("decimals >=", value, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsLessThan(final Integer value) {
            this.addCriterion("decimals <", value, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsLessThanOrEqualTo(final Integer value) {
            this.addCriterion("decimals <=", value, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsIn(final List<Integer> values) {
            this.addCriterion("decimals in", values, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsNotIn(final List<Integer> values) {
            this.addCriterion("decimals not in", values, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsBetween(final Integer value1, final Integer value2) {
            this.addCriterion("decimals between", value1, value2, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andDecimalsNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("decimals not between", value1, value2, "decimals");
            return (Criteria)this;
        }
        
        public Criteria andStateIsNull() {
            this.addCriterion("state is null");
            return (Criteria)this;
        }
        
        public Criteria andStateIsNotNull() {
            this.addCriterion("state is not null");
            return (Criteria)this;
        }
        
        public Criteria andStateEqualTo(final Integer value) {
            this.addCriterion("state =", value, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateNotEqualTo(final Integer value) {
            this.addCriterion("state <>", value, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateGreaterThan(final Integer value) {
            this.addCriterion("state >", value, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("state >=", value, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateLessThan(final Integer value) {
            this.addCriterion("state <", value, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateLessThanOrEqualTo(final Integer value) {
            this.addCriterion("state <=", value, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateIn(final List<Integer> values) {
            this.addCriterion("state in", values, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateNotIn(final List<Integer> values) {
            this.addCriterion("state not in", values, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateBetween(final Integer value1, final Integer value2) {
            this.addCriterion("state between", value1, value2, "state");
            return (Criteria)this;
        }
        
        public Criteria andStateNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("state not between", value1, value2, "state");
            return (Criteria)this;
        }
    }
    
    public static class Criteria extends GeneratedCriteria
    {
        protected Criteria() {
        }
    }
    
    public static class Criterion
    {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;
        
        public String getCondition() {
            return this.condition;
        }
        
        public Object getValue() {
            return this.value;
        }
        
        public Object getSecondValue() {
            return this.secondValue;
        }
        
        public boolean isNoValue() {
            return this.noValue;
        }
        
        public boolean isSingleValue() {
            return this.singleValue;
        }
        
        public boolean isBetweenValue() {
            return this.betweenValue;
        }
        
        public boolean isListValue() {
            return this.listValue;
        }
        
        public String getTypeHandler() {
            return this.typeHandler;
        }
        
        protected Criterion(final String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        
        protected Criterion(final String condition, final Object value, final String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List) {
                this.listValue = true;
            }
            else {
                this.singleValue = true;
            }
        }
        
        protected Criterion(final String condition, final Object value) {
            this(condition, value, null);
        }
        
        protected Criterion(final String condition, final Object value, final Object secondValue, final String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        
        protected Criterion(final String condition, final Object value, final Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
