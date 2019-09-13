// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TTokenTxExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TTokenTxExample() {
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
        
        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria)this;
        }
        
        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria)this;
        }
        
        public Criteria andIdEqualTo(final Integer value) {
            this.addCriterion("id =", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdNotEqualTo(final Integer value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdGreaterThan(final Integer value) {
            this.addCriterion("id >", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdLessThan(final Integer value) {
            this.addCriterion("id <", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdLessThanOrEqualTo(final Integer value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdIn(final List<Integer> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdNotIn(final List<Integer> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdBetween(final Integer value1, final Integer value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }
        
        public Criteria andIdNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
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
        
        public Criteria andTxHashIsNull() {
            this.addCriterion("tx_hash is null");
            return (Criteria)this;
        }
        
        public Criteria andTxHashIsNotNull() {
            this.addCriterion("tx_hash is not null");
            return (Criteria)this;
        }
        
        public Criteria andTxHashEqualTo(final String value) {
            this.addCriterion("tx_hash =", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotEqualTo(final String value) {
            this.addCriterion("tx_hash <>", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashGreaterThan(final String value) {
            this.addCriterion("tx_hash >", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashGreaterThanOrEqualTo(final String value) {
            this.addCriterion("tx_hash >=", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashLessThan(final String value) {
            this.addCriterion("tx_hash <", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashLessThanOrEqualTo(final String value) {
            this.addCriterion("tx_hash <=", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashLike(final String value) {
            this.addCriterion("tx_hash like", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotLike(final String value) {
            this.addCriterion("tx_hash not like", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashIn(final List<String> values) {
            this.addCriterion("tx_hash in", values, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotIn(final List<String> values) {
            this.addCriterion("tx_hash not in", values, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashBetween(final String value1, final String value2) {
            this.addCriterion("tx_hash between", value1, value2, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotBetween(final String value1, final String value2) {
            this.addCriterion("tx_hash not between", value1, value2, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexIsNull() {
            this.addCriterion("tx_index is null");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexIsNotNull() {
            this.addCriterion("tx_index is not null");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexEqualTo(final Integer value) {
            this.addCriterion("tx_index =", value, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexNotEqualTo(final Integer value) {
            this.addCriterion("tx_index <>", value, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexGreaterThan(final Integer value) {
            this.addCriterion("tx_index >", value, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("tx_index >=", value, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexLessThan(final Integer value) {
            this.addCriterion("tx_index <", value, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexLessThanOrEqualTo(final Integer value) {
            this.addCriterion("tx_index <=", value, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexIn(final List<Integer> values) {
            this.addCriterion("tx_index in", values, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexNotIn(final List<Integer> values) {
            this.addCriterion("tx_index not in", values, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexBetween(final Integer value1, final Integer value2) {
            this.addCriterion("tx_index between", value1, value2, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andTxIndexNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("tx_index not between", value1, value2, "txIndex");
            return (Criteria)this;
        }
        
        public Criteria andAgeIsNull() {
            this.addCriterion("age is null");
            return (Criteria)this;
        }
        
        public Criteria andAgeIsNotNull() {
            this.addCriterion("age is not null");
            return (Criteria)this;
        }
        
        public Criteria andAgeEqualTo(final Date value) {
            this.addCriterion("age =", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeNotEqualTo(final Date value) {
            this.addCriterion("age <>", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeGreaterThan(final Date value) {
            this.addCriterion("age >", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("age >=", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeLessThan(final Date value) {
            this.addCriterion("age <", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeLessThanOrEqualTo(final Date value) {
            this.addCriterion("age <=", value, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeIn(final List<Date> values) {
            this.addCriterion("age in", values, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeNotIn(final List<Date> values) {
            this.addCriterion("age not in", values, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeBetween(final Date value1, final Date value2) {
            this.addCriterion("age between", value1, value2, "age");
            return (Criteria)this;
        }
        
        public Criteria andAgeNotBetween(final Date value1, final Date value2) {
            this.addCriterion("age not between", value1, value2, "age");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrIsNull() {
            this.addCriterion("from_addr is null");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrIsNotNull() {
            this.addCriterion("from_addr is not null");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrEqualTo(final String value) {
            this.addCriterion("from_addr =", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrNotEqualTo(final String value) {
            this.addCriterion("from_addr <>", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrGreaterThan(final String value) {
            this.addCriterion("from_addr >", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrGreaterThanOrEqualTo(final String value) {
            this.addCriterion("from_addr >=", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrLessThan(final String value) {
            this.addCriterion("from_addr <", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrLessThanOrEqualTo(final String value) {
            this.addCriterion("from_addr <=", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrLike(final String value) {
            this.addCriterion("from_addr like", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrNotLike(final String value) {
            this.addCriterion("from_addr not like", value, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrIn(final List<String> values) {
            this.addCriterion("from_addr in", values, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrNotIn(final List<String> values) {
            this.addCriterion("from_addr not in", values, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrBetween(final String value1, final String value2) {
            this.addCriterion("from_addr between", value1, value2, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andFromAddrNotBetween(final String value1, final String value2) {
            this.addCriterion("from_addr not between", value1, value2, "fromAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrIsNull() {
            this.addCriterion("to_addr is null");
            return (Criteria)this;
        }
        
        public Criteria andToAddrIsNotNull() {
            this.addCriterion("to_addr is not null");
            return (Criteria)this;
        }
        
        public Criteria andToAddrEqualTo(final String value) {
            this.addCriterion("to_addr =", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrNotEqualTo(final String value) {
            this.addCriterion("to_addr <>", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrGreaterThan(final String value) {
            this.addCriterion("to_addr >", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrGreaterThanOrEqualTo(final String value) {
            this.addCriterion("to_addr >=", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrLessThan(final String value) {
            this.addCriterion("to_addr <", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrLessThanOrEqualTo(final String value) {
            this.addCriterion("to_addr <=", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrLike(final String value) {
            this.addCriterion("to_addr like", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrNotLike(final String value) {
            this.addCriterion("to_addr not like", value, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrIn(final List<String> values) {
            this.addCriterion("to_addr in", values, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrNotIn(final List<String> values) {
            this.addCriterion("to_addr not in", values, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrBetween(final String value1, final String value2) {
            this.addCriterion("to_addr between", value1, value2, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andToAddrNotBetween(final String value1, final String value2) {
            this.addCriterion("to_addr not between", value1, value2, "toAddr");
            return (Criteria)this;
        }
        
        public Criteria andQuantityIsNull() {
            this.addCriterion("quantity is null");
            return (Criteria)this;
        }
        
        public Criteria andQuantityIsNotNull() {
            this.addCriterion("quantity is not null");
            return (Criteria)this;
        }
        
        public Criteria andQuantityEqualTo(final String value) {
            this.addCriterion("quantity =", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotEqualTo(final String value) {
            this.addCriterion("quantity <>", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityGreaterThan(final String value) {
            this.addCriterion("quantity >", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityGreaterThanOrEqualTo(final String value) {
            this.addCriterion("quantity >=", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityLessThan(final String value) {
            this.addCriterion("quantity <", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityLessThanOrEqualTo(final String value) {
            this.addCriterion("quantity <=", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityLike(final String value) {
            this.addCriterion("quantity like", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotLike(final String value) {
            this.addCriterion("quantity not like", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityIn(final List<String> values) {
            this.addCriterion("quantity in", values, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotIn(final List<String> values) {
            this.addCriterion("quantity not in", values, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityBetween(final String value1, final String value2) {
            this.addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotBetween(final String value1, final String value2) {
            this.addCriterion("quantity not between", value1, value2, "quantity");
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
        
        public Criteria andAmountIsNull() {
            this.addCriterion("amount is null");
            return (Criteria)this;
        }
        
        public Criteria andAmountIsNotNull() {
            this.addCriterion("amount is not null");
            return (Criteria)this;
        }
        
        public Criteria andAmountEqualTo(final String value) {
            this.addCriterion("amount =", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountNotEqualTo(final String value) {
            this.addCriterion("amount <>", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountGreaterThan(final String value) {
            this.addCriterion("amount >", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountGreaterThanOrEqualTo(final String value) {
            this.addCriterion("amount >=", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountLessThan(final String value) {
            this.addCriterion("amount <", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountLessThanOrEqualTo(final String value) {
            this.addCriterion("amount <=", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountLike(final String value) {
            this.addCriterion("amount like", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountNotLike(final String value) {
            this.addCriterion("amount not like", value, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountIn(final List<String> values) {
            this.addCriterion("amount in", values, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountNotIn(final List<String> values) {
            this.addCriterion("amount not in", values, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountBetween(final String value1, final String value2) {
            this.addCriterion("amount between", value1, value2, "amount");
            return (Criteria)this;
        }
        
        public Criteria andAmountNotBetween(final String value1, final String value2) {
            this.addCriterion("amount not between", value1, value2, "amount");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightIsNull() {
            this.addCriterion("block_height is null");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightIsNotNull() {
            this.addCriterion("block_height is not null");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightEqualTo(final Integer value) {
            this.addCriterion("block_height =", value, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightNotEqualTo(final Integer value) {
            this.addCriterion("block_height <>", value, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightGreaterThan(final Integer value) {
            this.addCriterion("block_height >", value, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("block_height >=", value, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightLessThan(final Integer value) {
            this.addCriterion("block_height <", value, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightLessThanOrEqualTo(final Integer value) {
            this.addCriterion("block_height <=", value, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightIn(final List<Integer> values) {
            this.addCriterion("block_height in", values, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightNotIn(final List<Integer> values) {
            this.addCriterion("block_height not in", values, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightBetween(final Integer value1, final Integer value2) {
            this.addCriterion("block_height between", value1, value2, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andBlockHeightNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("block_height not between", value1, value2, "blockHeight");
            return (Criteria)this;
        }
        
        public Criteria andFeeIsNull() {
            this.addCriterion("fee is null");
            return (Criteria)this;
        }
        
        public Criteria andFeeIsNotNull() {
            this.addCriterion("fee is not null");
            return (Criteria)this;
        }
        
        public Criteria andFeeEqualTo(final String value) {
            this.addCriterion("fee =", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeNotEqualTo(final String value) {
            this.addCriterion("fee <>", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeGreaterThan(final String value) {
            this.addCriterion("fee >", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeGreaterThanOrEqualTo(final String value) {
            this.addCriterion("fee >=", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeLessThan(final String value) {
            this.addCriterion("fee <", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeLessThanOrEqualTo(final String value) {
            this.addCriterion("fee <=", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeLike(final String value) {
            this.addCriterion("fee like", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeNotLike(final String value) {
            this.addCriterion("fee not like", value, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeIn(final List<String> values) {
            this.addCriterion("fee in", values, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeNotIn(final List<String> values) {
            this.addCriterion("fee not in", values, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeBetween(final String value1, final String value2) {
            this.addCriterion("fee between", value1, value2, "fee");
            return (Criteria)this;
        }
        
        public Criteria andFeeNotBetween(final String value1, final String value2) {
            this.addCriterion("fee not between", value1, value2, "fee");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeIsNull() {
            this.addCriterion("tx_type is null");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeIsNotNull() {
            this.addCriterion("tx_type is not null");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeEqualTo(final Integer value) {
            this.addCriterion("tx_type =", value, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeNotEqualTo(final Integer value) {
            this.addCriterion("tx_type <>", value, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeGreaterThan(final Integer value) {
            this.addCriterion("tx_type >", value, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("tx_type >=", value, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeLessThan(final Integer value) {
            this.addCriterion("tx_type <", value, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeLessThanOrEqualTo(final Integer value) {
            this.addCriterion("tx_type <=", value, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeIn(final List<Integer> values) {
            this.addCriterion("tx_type in", values, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeNotIn(final List<Integer> values) {
            this.addCriterion("tx_type not in", values, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeBetween(final Integer value1, final Integer value2) {
            this.addCriterion("tx_type between", value1, value2, "txType");
            return (Criteria)this;
        }
        
        public Criteria andTxTypeNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("tx_type not between", value1, value2, "txType");
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
