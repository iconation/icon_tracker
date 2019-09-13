// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TAddressPrepExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TAddressPrepExample() {
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
        
        public Criteria andRepNameIsNull() {
            this.addCriterion("rep_name is null");
            return (Criteria)this;
        }
        
        public Criteria andRepNameIsNotNull() {
            this.addCriterion("rep_name is not null");
            return (Criteria)this;
        }
        
        public Criteria andRepNameEqualTo(final String value) {
            this.addCriterion("rep_name =", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameNotEqualTo(final String value) {
            this.addCriterion("rep_name <>", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameGreaterThan(final String value) {
            this.addCriterion("rep_name >", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("rep_name >=", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameLessThan(final String value) {
            this.addCriterion("rep_name <", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameLessThanOrEqualTo(final String value) {
            this.addCriterion("rep_name <=", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameLike(final String value) {
            this.addCriterion("rep_name like", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameNotLike(final String value) {
            this.addCriterion("rep_name not like", value, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameIn(final List<String> values) {
            this.addCriterion("rep_name in", values, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameNotIn(final List<String> values) {
            this.addCriterion("rep_name not in", values, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameBetween(final String value1, final String value2) {
            this.addCriterion("rep_name between", value1, value2, "repName");
            return (Criteria)this;
        }
        
        public Criteria andRepNameNotBetween(final String value1, final String value2) {
            this.addCriterion("rep_name not between", value1, value2, "repName");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountIsNull() {
            this.addCriterion("block_count is null");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountIsNotNull() {
            this.addCriterion("block_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountEqualTo(final Integer value) {
            this.addCriterion("block_count =", value, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountNotEqualTo(final Integer value) {
            this.addCriterion("block_count <>", value, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountGreaterThan(final Integer value) {
            this.addCriterion("block_count >", value, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("block_count >=", value, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountLessThan(final Integer value) {
            this.addCriterion("block_count <", value, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("block_count <=", value, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountIn(final List<Integer> values) {
            this.addCriterion("block_count in", values, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountNotIn(final List<Integer> values) {
            this.addCriterion("block_count not in", values, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("block_count between", value1, value2, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andBlockCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("block_count not between", value1, value2, "blockCount");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepIsNull() {
            this.addCriterion("is_prep is null");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepIsNotNull() {
            this.addCriterion("is_prep is not null");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepEqualTo(final Boolean value) {
            this.addCriterion("is_prep =", value, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepNotEqualTo(final Boolean value) {
            this.addCriterion("is_prep <>", value, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepGreaterThan(final Boolean value) {
            this.addCriterion("is_prep >", value, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepGreaterThanOrEqualTo(final Boolean value) {
            this.addCriterion("is_prep >=", value, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepLessThan(final Boolean value) {
            this.addCriterion("is_prep <", value, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepLessThanOrEqualTo(final Boolean value) {
            this.addCriterion("is_prep <=", value, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepIn(final List<Boolean> values) {
            this.addCriterion("is_prep in", values, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepNotIn(final List<Boolean> values) {
            this.addCriterion("is_prep not in", values, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepBetween(final Boolean value1, final Boolean value2) {
            this.addCriterion("is_prep between", value1, value2, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andIsPrepNotBetween(final Boolean value1, final Boolean value2) {
            this.addCriterion("is_prep not between", value1, value2, "isPrep");
            return (Criteria)this;
        }
        
        public Criteria andStartTermIsNull() {
            this.addCriterion("start_term is null");
            return (Criteria)this;
        }
        
        public Criteria andStartTermIsNotNull() {
            this.addCriterion("start_term is not null");
            return (Criteria)this;
        }
        
        public Criteria andStartTermEqualTo(final Integer value) {
            this.addCriterion("start_term =", value, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermNotEqualTo(final Integer value) {
            this.addCriterion("start_term <>", value, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermGreaterThan(final Integer value) {
            this.addCriterion("start_term >", value, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("start_term >=", value, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermLessThan(final Integer value) {
            this.addCriterion("start_term <", value, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermLessThanOrEqualTo(final Integer value) {
            this.addCriterion("start_term <=", value, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermIn(final List<Integer> values) {
            this.addCriterion("start_term in", values, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermNotIn(final List<Integer> values) {
            this.addCriterion("start_term not in", values, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermBetween(final Integer value1, final Integer value2) {
            this.addCriterion("start_term between", value1, value2, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andStartTermNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("start_term not between", value1, value2, "startTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermIsNull() {
            this.addCriterion("end_term is null");
            return (Criteria)this;
        }
        
        public Criteria andEndTermIsNotNull() {
            this.addCriterion("end_term is not null");
            return (Criteria)this;
        }
        
        public Criteria andEndTermEqualTo(final Integer value) {
            this.addCriterion("end_term =", value, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermNotEqualTo(final Integer value) {
            this.addCriterion("end_term <>", value, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermGreaterThan(final Integer value) {
            this.addCriterion("end_term >", value, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("end_term >=", value, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermLessThan(final Integer value) {
            this.addCriterion("end_term <", value, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermLessThanOrEqualTo(final Integer value) {
            this.addCriterion("end_term <=", value, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermIn(final List<Integer> values) {
            this.addCriterion("end_term in", values, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermNotIn(final List<Integer> values) {
            this.addCriterion("end_term not in", values, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermBetween(final Integer value1, final Integer value2) {
            this.addCriterion("end_term between", value1, value2, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andEndTermNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("end_term not between", value1, value2, "endTerm");
            return (Criteria)this;
        }
        
        public Criteria andUrlIsNull() {
            this.addCriterion("url is null");
            return (Criteria)this;
        }
        
        public Criteria andUrlIsNotNull() {
            this.addCriterion("url is not null");
            return (Criteria)this;
        }
        
        public Criteria andUrlEqualTo(final String value) {
            this.addCriterion("url =", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlNotEqualTo(final String value) {
            this.addCriterion("url <>", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlGreaterThan(final String value) {
            this.addCriterion("url >", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlGreaterThanOrEqualTo(final String value) {
            this.addCriterion("url >=", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlLessThan(final String value) {
            this.addCriterion("url <", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlLessThanOrEqualTo(final String value) {
            this.addCriterion("url <=", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlLike(final String value) {
            this.addCriterion("url like", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlNotLike(final String value) {
            this.addCriterion("url not like", value, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlIn(final List<String> values) {
            this.addCriterion("url in", values, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlNotIn(final List<String> values) {
            this.addCriterion("url not in", values, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlBetween(final String value1, final String value2) {
            this.addCriterion("url between", value1, value2, "url");
            return (Criteria)this;
        }
        
        public Criteria andUrlNotBetween(final String value1, final String value2) {
            this.addCriterion("url not between", value1, value2, "url");
            return (Criteria)this;
        }
        
        public Criteria andRepHashIsNull() {
            this.addCriterion("rep_hash is null");
            return (Criteria)this;
        }
        
        public Criteria andRepHashIsNotNull() {
            this.addCriterion("rep_hash is not null");
            return (Criteria)this;
        }
        
        public Criteria andRepHashEqualTo(final String value) {
            this.addCriterion("rep_hash =", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashNotEqualTo(final String value) {
            this.addCriterion("rep_hash <>", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashGreaterThan(final String value) {
            this.addCriterion("rep_hash >", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashGreaterThanOrEqualTo(final String value) {
            this.addCriterion("rep_hash >=", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashLessThan(final String value) {
            this.addCriterion("rep_hash <", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashLessThanOrEqualTo(final String value) {
            this.addCriterion("rep_hash <=", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashLike(final String value) {
            this.addCriterion("rep_hash like", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashNotLike(final String value) {
            this.addCriterion("rep_hash not like", value, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashIn(final List<String> values) {
            this.addCriterion("rep_hash in", values, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashNotIn(final List<String> values) {
            this.addCriterion("rep_hash not in", values, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashBetween(final String value1, final String value2) {
            this.addCriterion("rep_hash between", value1, value2, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andRepHashNotBetween(final String value1, final String value2) {
            this.addCriterion("rep_hash not between", value1, value2, "repHash");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateIsNull() {
            this.addCriterion("update_date is null");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateIsNotNull() {
            this.addCriterion("update_date is not null");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateEqualTo(final Date value) {
            this.addCriterion("update_date =", value, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateNotEqualTo(final Date value) {
            this.addCriterion("update_date <>", value, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateGreaterThan(final Date value) {
            this.addCriterion("update_date >", value, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("update_date >=", value, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateLessThan(final Date value) {
            this.addCriterion("update_date <", value, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateLessThanOrEqualTo(final Date value) {
            this.addCriterion("update_date <=", value, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateIn(final List<Date> values) {
            this.addCriterion("update_date in", values, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateNotIn(final List<Date> values) {
            this.addCriterion("update_date not in", values, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateBetween(final Date value1, final Date value2) {
            this.addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria)this;
        }
        
        public Criteria andUpdateDateNotBetween(final Date value1, final Date value2) {
            this.addCriterion("update_date not between", value1, value2, "updateDate");
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
