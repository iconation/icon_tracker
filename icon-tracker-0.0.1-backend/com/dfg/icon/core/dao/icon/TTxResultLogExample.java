// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TTxResultLogExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TTxResultLogExample() {
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
        
        public Criteria andEIndexIsNull() {
            this.addCriterion("e_index is null");
            return (Criteria)this;
        }
        
        public Criteria andEIndexIsNotNull() {
            this.addCriterion("e_index is not null");
            return (Criteria)this;
        }
        
        public Criteria andEIndexEqualTo(final Integer value) {
            this.addCriterion("e_index =", value, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexNotEqualTo(final Integer value) {
            this.addCriterion("e_index <>", value, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexGreaterThan(final Integer value) {
            this.addCriterion("e_index >", value, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("e_index >=", value, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexLessThan(final Integer value) {
            this.addCriterion("e_index <", value, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexLessThanOrEqualTo(final Integer value) {
            this.addCriterion("e_index <=", value, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexIn(final List<Integer> values) {
            this.addCriterion("e_index in", values, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexNotIn(final List<Integer> values) {
            this.addCriterion("e_index not in", values, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexBetween(final Integer value1, final Integer value2) {
            this.addCriterion("e_index between", value1, value2, "eIndex");
            return (Criteria)this;
        }
        
        public Criteria andEIndexNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("e_index not between", value1, value2, "eIndex");
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
        
        public Criteria andMethodIsNull() {
            this.addCriterion("method is null");
            return (Criteria)this;
        }
        
        public Criteria andMethodIsNotNull() {
            this.addCriterion("method is not null");
            return (Criteria)this;
        }
        
        public Criteria andMethodEqualTo(final String value) {
            this.addCriterion("method =", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodNotEqualTo(final String value) {
            this.addCriterion("method <>", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodGreaterThan(final String value) {
            this.addCriterion("method >", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodGreaterThanOrEqualTo(final String value) {
            this.addCriterion("method >=", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodLessThan(final String value) {
            this.addCriterion("method <", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodLessThanOrEqualTo(final String value) {
            this.addCriterion("method <=", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodLike(final String value) {
            this.addCriterion("method like", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodNotLike(final String value) {
            this.addCriterion("method not like", value, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodIn(final List<String> values) {
            this.addCriterion("method in", values, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodNotIn(final List<String> values) {
            this.addCriterion("method not in", values, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodBetween(final String value1, final String value2) {
            this.addCriterion("method between", value1, value2, "method");
            return (Criteria)this;
        }
        
        public Criteria andMethodNotBetween(final String value1, final String value2) {
            this.addCriterion("method not between", value1, value2, "method");
            return (Criteria)this;
        }
        
        public Criteria andEventLogIsNull() {
            this.addCriterion("event_log is null");
            return (Criteria)this;
        }
        
        public Criteria andEventLogIsNotNull() {
            this.addCriterion("event_log is not null");
            return (Criteria)this;
        }
        
        public Criteria andEventLogEqualTo(final String value) {
            this.addCriterion("event_log =", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogNotEqualTo(final String value) {
            this.addCriterion("event_log <>", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogGreaterThan(final String value) {
            this.addCriterion("event_log >", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogGreaterThanOrEqualTo(final String value) {
            this.addCriterion("event_log >=", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogLessThan(final String value) {
            this.addCriterion("event_log <", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogLessThanOrEqualTo(final String value) {
            this.addCriterion("event_log <=", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogLike(final String value) {
            this.addCriterion("event_log like", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogNotLike(final String value) {
            this.addCriterion("event_log not like", value, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogIn(final List<String> values) {
            this.addCriterion("event_log in", values, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogNotIn(final List<String> values) {
            this.addCriterion("event_log not in", values, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogBetween(final String value1, final String value2) {
            this.addCriterion("event_log between", value1, value2, "eventLog");
            return (Criteria)this;
        }
        
        public Criteria andEventLogNotBetween(final String value1, final String value2) {
            this.addCriterion("event_log not between", value1, value2, "eventLog");
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
