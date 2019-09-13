// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TInternalTxViewExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TInternalTxViewExample() {
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
        
        public Criteria andParentTxHashIsNull() {
            this.addCriterion("parent_tx_hash is null");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashIsNotNull() {
            this.addCriterion("parent_tx_hash is not null");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashEqualTo(final String value) {
            this.addCriterion("parent_tx_hash =", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashNotEqualTo(final String value) {
            this.addCriterion("parent_tx_hash <>", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashGreaterThan(final String value) {
            this.addCriterion("parent_tx_hash >", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashGreaterThanOrEqualTo(final String value) {
            this.addCriterion("parent_tx_hash >=", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashLessThan(final String value) {
            this.addCriterion("parent_tx_hash <", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashLessThanOrEqualTo(final String value) {
            this.addCriterion("parent_tx_hash <=", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashLike(final String value) {
            this.addCriterion("parent_tx_hash like", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashNotLike(final String value) {
            this.addCriterion("parent_tx_hash not like", value, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashIn(final List<String> values) {
            this.addCriterion("parent_tx_hash in", values, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashNotIn(final List<String> values) {
            this.addCriterion("parent_tx_hash not in", values, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashBetween(final String value1, final String value2) {
            this.addCriterion("parent_tx_hash between", value1, value2, "parentTxHash");
            return (Criteria)this;
        }
        
        public Criteria andParentTxHashNotBetween(final String value1, final String value2) {
            this.addCriterion("parent_tx_hash not between", value1, value2, "parentTxHash");
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
        
        public Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (Criteria)this;
        }
        
        public Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (Criteria)this;
        }
        
        public Criteria andAddressEqualTo(final String value) {
            this.addCriterion("address =", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressNotEqualTo(final String value) {
            this.addCriterion("address <>", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressGreaterThan(final String value) {
            this.addCriterion("address >", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressGreaterThanOrEqualTo(final String value) {
            this.addCriterion("address >=", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressLessThan(final String value) {
            this.addCriterion("address <", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressLessThanOrEqualTo(final String value) {
            this.addCriterion("address <=", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressLike(final String value) {
            this.addCriterion("address like", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressNotLike(final String value) {
            this.addCriterion("address not like", value, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressIn(final List<String> values) {
            this.addCriterion("address in", values, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressNotIn(final List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressBetween(final String value1, final String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (Criteria)this;
        }
        
        public Criteria andAddressNotBetween(final String value1, final String value2) {
            this.addCriterion("address not between", value1, value2, "address");
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
