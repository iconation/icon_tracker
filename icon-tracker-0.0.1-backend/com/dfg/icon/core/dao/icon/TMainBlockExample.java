// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TMainBlockExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TMainBlockExample() {
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
        
        public Criteria andCrepAddrIsNull() {
            this.addCriterion("crep_addr is null");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrIsNotNull() {
            this.addCriterion("crep_addr is not null");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrEqualTo(final String value) {
            this.addCriterion("crep_addr =", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrNotEqualTo(final String value) {
            this.addCriterion("crep_addr <>", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrGreaterThan(final String value) {
            this.addCriterion("crep_addr >", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrGreaterThanOrEqualTo(final String value) {
            this.addCriterion("crep_addr >=", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrLessThan(final String value) {
            this.addCriterion("crep_addr <", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrLessThanOrEqualTo(final String value) {
            this.addCriterion("crep_addr <=", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrLike(final String value) {
            this.addCriterion("crep_addr like", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrNotLike(final String value) {
            this.addCriterion("crep_addr not like", value, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrIn(final List<String> values) {
            this.addCriterion("crep_addr in", values, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrNotIn(final List<String> values) {
            this.addCriterion("crep_addr not in", values, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrBetween(final String value1, final String value2) {
            this.addCriterion("crep_addr between", value1, value2, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andCrepAddrNotBetween(final String value1, final String value2) {
            this.addCriterion("crep_addr not between", value1, value2, "crepAddr");
            return (Criteria)this;
        }
        
        public Criteria andTxCountIsNull() {
            this.addCriterion("tx_count is null");
            return (Criteria)this;
        }
        
        public Criteria andTxCountIsNotNull() {
            this.addCriterion("tx_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andTxCountEqualTo(final Integer value) {
            this.addCriterion("tx_count =", value, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountNotEqualTo(final Integer value) {
            this.addCriterion("tx_count <>", value, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountGreaterThan(final Integer value) {
            this.addCriterion("tx_count >", value, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("tx_count >=", value, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountLessThan(final Integer value) {
            this.addCriterion("tx_count <", value, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("tx_count <=", value, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountIn(final List<Integer> values) {
            this.addCriterion("tx_count in", values, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountNotIn(final List<Integer> values) {
            this.addCriterion("tx_count not in", values, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("tx_count between", value1, value2, "txCount");
            return (Criteria)this;
        }
        
        public Criteria andTxCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("tx_count not between", value1, value2, "txCount");
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
