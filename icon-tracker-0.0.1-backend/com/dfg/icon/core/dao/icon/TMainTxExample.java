// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TMainTxExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TMainTxExample() {
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
        
        public Criteria andScoreYnIsNull() {
            this.addCriterion("score_yn is null");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnIsNotNull() {
            this.addCriterion("score_yn is not null");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnEqualTo(final String value) {
            this.addCriterion("score_yn =", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnNotEqualTo(final String value) {
            this.addCriterion("score_yn <>", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnGreaterThan(final String value) {
            this.addCriterion("score_yn >", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnGreaterThanOrEqualTo(final String value) {
            this.addCriterion("score_yn >=", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnLessThan(final String value) {
            this.addCriterion("score_yn <", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnLessThanOrEqualTo(final String value) {
            this.addCriterion("score_yn <=", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnLike(final String value) {
            this.addCriterion("score_yn like", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnNotLike(final String value) {
            this.addCriterion("score_yn not like", value, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnIn(final List<String> values) {
            this.addCriterion("score_yn in", values, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnNotIn(final List<String> values) {
            this.addCriterion("score_yn not in", values, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnBetween(final String value1, final String value2) {
            this.addCriterion("score_yn between", value1, value2, "scoreYn");
            return (Criteria)this;
        }
        
        public Criteria andScoreYnNotBetween(final String value1, final String value2) {
            this.addCriterion("score_yn not between", value1, value2, "scoreYn");
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
