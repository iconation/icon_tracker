// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TTransactionTotalExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TTransactionTotalExample() {
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
        
        public Criteria andHeightIsNull() {
            this.addCriterion("height is null");
            return (Criteria)this;
        }
        
        public Criteria andHeightIsNotNull() {
            this.addCriterion("height is not null");
            return (Criteria)this;
        }
        
        public Criteria andHeightEqualTo(final Integer value) {
            this.addCriterion("height =", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightNotEqualTo(final Integer value) {
            this.addCriterion("height <>", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightGreaterThan(final Integer value) {
            this.addCriterion("height >", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("height >=", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightLessThan(final Integer value) {
            this.addCriterion("height <", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightLessThanOrEqualTo(final Integer value) {
            this.addCriterion("height <=", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightIn(final List<Integer> values) {
            this.addCriterion("height in", values, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightNotIn(final List<Integer> values) {
            this.addCriterion("height not in", values, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightBetween(final Integer value1, final Integer value2) {
            this.addCriterion("height between", value1, value2, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("height not between", value1, value2, "height");
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
        
        public Criteria andHashIsNull() {
            this.addCriterion("hash is null");
            return (Criteria)this;
        }
        
        public Criteria andHashIsNotNull() {
            this.addCriterion("hash is not null");
            return (Criteria)this;
        }
        
        public Criteria andHashEqualTo(final String value) {
            this.addCriterion("hash =", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashNotEqualTo(final String value) {
            this.addCriterion("hash <>", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashGreaterThan(final String value) {
            this.addCriterion("hash >", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashGreaterThanOrEqualTo(final String value) {
            this.addCriterion("hash >=", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashLessThan(final String value) {
            this.addCriterion("hash <", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashLessThanOrEqualTo(final String value) {
            this.addCriterion("hash <=", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashLike(final String value) {
            this.addCriterion("hash like", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashNotLike(final String value) {
            this.addCriterion("hash not like", value, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashIn(final List<String> values) {
            this.addCriterion("hash in", values, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashNotIn(final List<String> values) {
            this.addCriterion("hash not in", values, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashBetween(final String value1, final String value2) {
            this.addCriterion("hash between", value1, value2, "hash");
            return (Criteria)this;
        }
        
        public Criteria andHashNotBetween(final String value1, final String value2) {
            this.addCriterion("hash not between", value1, value2, "hash");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateIsNull() {
            this.addCriterion("create_date is null");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateIsNotNull() {
            this.addCriterion("create_date is not null");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateEqualTo(final Date value) {
            this.addCriterion("create_date =", value, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateNotEqualTo(final Date value) {
            this.addCriterion("create_date <>", value, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateGreaterThan(final Date value) {
            this.addCriterion("create_date >", value, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("create_date >=", value, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateLessThan(final Date value) {
            this.addCriterion("create_date <", value, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateLessThanOrEqualTo(final Date value) {
            this.addCriterion("create_date <=", value, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateIn(final List<Date> values) {
            this.addCriterion("create_date in", values, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateNotIn(final List<Date> values) {
            this.addCriterion("create_date not in", values, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateBetween(final Date value1, final Date value2) {
            this.addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria)this;
        }
        
        public Criteria andCreateDateNotBetween(final Date value1, final Date value2) {
            this.addCriterion("create_date not between", value1, value2, "createDate");
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
        
        public Criteria andStepLimitIsNull() {
            this.addCriterion("step_limit is null");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitIsNotNull() {
            this.addCriterion("step_limit is not null");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitEqualTo(final String value) {
            this.addCriterion("step_limit =", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitNotEqualTo(final String value) {
            this.addCriterion("step_limit <>", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitGreaterThan(final String value) {
            this.addCriterion("step_limit >", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitGreaterThanOrEqualTo(final String value) {
            this.addCriterion("step_limit >=", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitLessThan(final String value) {
            this.addCriterion("step_limit <", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitLessThanOrEqualTo(final String value) {
            this.addCriterion("step_limit <=", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitLike(final String value) {
            this.addCriterion("step_limit like", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitNotLike(final String value) {
            this.addCriterion("step_limit not like", value, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitIn(final List<String> values) {
            this.addCriterion("step_limit in", values, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitNotIn(final List<String> values) {
            this.addCriterion("step_limit not in", values, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitBetween(final String value1, final String value2) {
            this.addCriterion("step_limit between", value1, value2, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepLimitNotBetween(final String value1, final String value2) {
            this.addCriterion("step_limit not between", value1, value2, "stepLimit");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxIsNull() {
            this.addCriterion("step_used_tx is null");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxIsNotNull() {
            this.addCriterion("step_used_tx is not null");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxEqualTo(final String value) {
            this.addCriterion("step_used_tx =", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxNotEqualTo(final String value) {
            this.addCriterion("step_used_tx <>", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxGreaterThan(final String value) {
            this.addCriterion("step_used_tx >", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxGreaterThanOrEqualTo(final String value) {
            this.addCriterion("step_used_tx >=", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxLessThan(final String value) {
            this.addCriterion("step_used_tx <", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxLessThanOrEqualTo(final String value) {
            this.addCriterion("step_used_tx <=", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxLike(final String value) {
            this.addCriterion("step_used_tx like", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxNotLike(final String value) {
            this.addCriterion("step_used_tx not like", value, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxIn(final List<String> values) {
            this.addCriterion("step_used_tx in", values, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxNotIn(final List<String> values) {
            this.addCriterion("step_used_tx not in", values, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxBetween(final String value1, final String value2) {
            this.addCriterion("step_used_tx between", value1, value2, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepUsedTxNotBetween(final String value1, final String value2) {
            this.addCriterion("step_used_tx not between", value1, value2, "stepUsedTx");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceIsNull() {
            this.addCriterion("step_price is null");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceIsNotNull() {
            this.addCriterion("step_price is not null");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceEqualTo(final String value) {
            this.addCriterion("step_price =", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceNotEqualTo(final String value) {
            this.addCriterion("step_price <>", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceGreaterThan(final String value) {
            this.addCriterion("step_price >", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceGreaterThanOrEqualTo(final String value) {
            this.addCriterion("step_price >=", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceLessThan(final String value) {
            this.addCriterion("step_price <", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceLessThanOrEqualTo(final String value) {
            this.addCriterion("step_price <=", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceLike(final String value) {
            this.addCriterion("step_price like", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceNotLike(final String value) {
            this.addCriterion("step_price not like", value, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceIn(final List<String> values) {
            this.addCriterion("step_price in", values, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceNotIn(final List<String> values) {
            this.addCriterion("step_price not in", values, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceBetween(final String value1, final String value2) {
            this.addCriterion("step_price between", value1, value2, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andStepPriceNotBetween(final String value1, final String value2) {
            this.addCriterion("step_price not between", value1, value2, "stepPrice");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeIsNull() {
            this.addCriterion("data_type is null");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeIsNotNull() {
            this.addCriterion("data_type is not null");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeEqualTo(final String value) {
            this.addCriterion("data_type =", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeNotEqualTo(final String value) {
            this.addCriterion("data_type <>", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeGreaterThan(final String value) {
            this.addCriterion("data_type >", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeGreaterThanOrEqualTo(final String value) {
            this.addCriterion("data_type >=", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeLessThan(final String value) {
            this.addCriterion("data_type <", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeLessThanOrEqualTo(final String value) {
            this.addCriterion("data_type <=", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeLike(final String value) {
            this.addCriterion("data_type like", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeNotLike(final String value) {
            this.addCriterion("data_type not like", value, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeIn(final List<String> values) {
            this.addCriterion("data_type in", values, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeNotIn(final List<String> values) {
            this.addCriterion("data_type not in", values, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeBetween(final String value1, final String value2) {
            this.addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria)this;
        }
        
        public Criteria andDataTypeNotBetween(final String value1, final String value2) {
            this.addCriterion("data_type not between", value1, value2, "dataType");
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
        
        public Criteria andVersionEqualTo(final String value) {
            this.addCriterion("version =", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotEqualTo(final String value) {
            this.addCriterion("version <>", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionGreaterThan(final String value) {
            this.addCriterion("version >", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionGreaterThanOrEqualTo(final String value) {
            this.addCriterion("version >=", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLessThan(final String value) {
            this.addCriterion("version <", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLessThanOrEqualTo(final String value) {
            this.addCriterion("version <=", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLike(final String value) {
            this.addCriterion("version like", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotLike(final String value) {
            this.addCriterion("version not like", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionIn(final List<String> values) {
            this.addCriterion("version in", values, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotIn(final List<String> values) {
            this.addCriterion("version not in", values, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionBetween(final String value1, final String value2) {
            this.addCriterion("version between", value1, value2, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotBetween(final String value1, final String value2) {
            this.addCriterion("version not between", value1, value2, "version");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeIsNull() {
            this.addCriterion("error_code is null");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeIsNotNull() {
            this.addCriterion("error_code is not null");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeEqualTo(final String value) {
            this.addCriterion("error_code =", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeNotEqualTo(final String value) {
            this.addCriterion("error_code <>", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeGreaterThan(final String value) {
            this.addCriterion("error_code >", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeGreaterThanOrEqualTo(final String value) {
            this.addCriterion("error_code >=", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeLessThan(final String value) {
            this.addCriterion("error_code <", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeLessThanOrEqualTo(final String value) {
            this.addCriterion("error_code <=", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeLike(final String value) {
            this.addCriterion("error_code like", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeNotLike(final String value) {
            this.addCriterion("error_code not like", value, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeIn(final List<String> values) {
            this.addCriterion("error_code in", values, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeNotIn(final List<String> values) {
            this.addCriterion("error_code not in", values, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeBetween(final String value1, final String value2) {
            this.addCriterion("error_code between", value1, value2, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorCodeNotBetween(final String value1, final String value2) {
            this.addCriterion("error_code not between", value1, value2, "errorCode");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgIsNull() {
            this.addCriterion("error_msg is null");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgIsNotNull() {
            this.addCriterion("error_msg is not null");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgEqualTo(final String value) {
            this.addCriterion("error_msg =", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgNotEqualTo(final String value) {
            this.addCriterion("error_msg <>", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgGreaterThan(final String value) {
            this.addCriterion("error_msg >", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgGreaterThanOrEqualTo(final String value) {
            this.addCriterion("error_msg >=", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgLessThan(final String value) {
            this.addCriterion("error_msg <", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgLessThanOrEqualTo(final String value) {
            this.addCriterion("error_msg <=", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgLike(final String value) {
            this.addCriterion("error_msg like", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgNotLike(final String value) {
            this.addCriterion("error_msg not like", value, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgIn(final List<String> values) {
            this.addCriterion("error_msg in", values, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgNotIn(final List<String> values) {
            this.addCriterion("error_msg not in", values, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgBetween(final String value1, final String value2) {
            this.addCriterion("error_msg between", value1, value2, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andErrorMsgNotBetween(final String value1, final String value2) {
            this.addCriterion("error_msg not between", value1, value2, "errorMsg");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountIsNull() {
            this.addCriterion("internal_tx_count is null");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountIsNotNull() {
            this.addCriterion("internal_tx_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountEqualTo(final Integer value) {
            this.addCriterion("internal_tx_count =", value, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountNotEqualTo(final Integer value) {
            this.addCriterion("internal_tx_count <>", value, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountGreaterThan(final Integer value) {
            this.addCriterion("internal_tx_count >", value, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("internal_tx_count >=", value, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountLessThan(final Integer value) {
            this.addCriterion("internal_tx_count <", value, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("internal_tx_count <=", value, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountIn(final List<Integer> values) {
            this.addCriterion("internal_tx_count in", values, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountNotIn(final List<Integer> values) {
            this.addCriterion("internal_tx_count not in", values, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("internal_tx_count between", value1, value2, "internalTxCount");
            return (Criteria)this;
        }
        
        public Criteria andInternalTxCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("internal_tx_count not between", value1, value2, "internalTxCount");
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
