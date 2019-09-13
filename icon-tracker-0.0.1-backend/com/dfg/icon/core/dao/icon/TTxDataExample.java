// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.ArrayList;
import java.util.List;

public class TTxDataExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TTxDataExample() {
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
        
        public Criteria andTxHashIsNull() {
            this.addCriterion("TX_HASH is null");
            return (Criteria)this;
        }
        
        public Criteria andTxHashIsNotNull() {
            this.addCriterion("TX_HASH is not null");
            return (Criteria)this;
        }
        
        public Criteria andTxHashEqualTo(final String value) {
            this.addCriterion("TX_HASH =", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotEqualTo(final String value) {
            this.addCriterion("TX_HASH <>", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashGreaterThan(final String value) {
            this.addCriterion("TX_HASH >", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashGreaterThanOrEqualTo(final String value) {
            this.addCriterion("TX_HASH >=", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashLessThan(final String value) {
            this.addCriterion("TX_HASH <", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashLessThanOrEqualTo(final String value) {
            this.addCriterion("TX_HASH <=", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashLike(final String value) {
            this.addCriterion("TX_HASH like", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotLike(final String value) {
            this.addCriterion("TX_HASH not like", value, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashIn(final List<String> values) {
            this.addCriterion("TX_HASH in", values, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotIn(final List<String> values) {
            this.addCriterion("TX_HASH not in", values, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashBetween(final String value1, final String value2) {
            this.addCriterion("TX_HASH between", value1, value2, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andTxHashNotBetween(final String value1, final String value2) {
            this.addCriterion("TX_HASH not between", value1, value2, "txHash");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyIsNull() {
            this.addCriterion("DATA_BODY is null");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyIsNotNull() {
            this.addCriterion("DATA_BODY is not null");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyEqualTo(final String value) {
            this.addCriterion("DATA_BODY =", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyNotEqualTo(final String value) {
            this.addCriterion("DATA_BODY <>", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyGreaterThan(final String value) {
            this.addCriterion("DATA_BODY >", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyGreaterThanOrEqualTo(final String value) {
            this.addCriterion("DATA_BODY >=", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyLessThan(final String value) {
            this.addCriterion("DATA_BODY <", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyLessThanOrEqualTo(final String value) {
            this.addCriterion("DATA_BODY <=", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyLike(final String value) {
            this.addCriterion("DATA_BODY like", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyNotLike(final String value) {
            this.addCriterion("DATA_BODY not like", value, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyIn(final List<String> values) {
            this.addCriterion("DATA_BODY in", values, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyNotIn(final List<String> values) {
            this.addCriterion("DATA_BODY not in", values, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyBetween(final String value1, final String value2) {
            this.addCriterion("DATA_BODY between", value1, value2, "dataBody");
            return (Criteria)this;
        }
        
        public Criteria andDataBodyNotBetween(final String value1, final String value2) {
            this.addCriterion("DATA_BODY not between", value1, value2, "dataBody");
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
