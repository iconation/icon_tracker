// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TSchedulerFlagExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TSchedulerFlagExample() {
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
        
        public Criteria andScheduleNameIsNull() {
            this.addCriterion("schedule_name is null");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameIsNotNull() {
            this.addCriterion("schedule_name is not null");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameEqualTo(final String value) {
            this.addCriterion("schedule_name =", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameNotEqualTo(final String value) {
            this.addCriterion("schedule_name <>", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameGreaterThan(final String value) {
            this.addCriterion("schedule_name >", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("schedule_name >=", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameLessThan(final String value) {
            this.addCriterion("schedule_name <", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameLessThanOrEqualTo(final String value) {
            this.addCriterion("schedule_name <=", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameLike(final String value) {
            this.addCriterion("schedule_name like", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameNotLike(final String value) {
            this.addCriterion("schedule_name not like", value, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameIn(final List<String> values) {
            this.addCriterion("schedule_name in", values, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameNotIn(final List<String> values) {
            this.addCriterion("schedule_name not in", values, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameBetween(final String value1, final String value2) {
            this.addCriterion("schedule_name between", value1, value2, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andScheduleNameNotBetween(final String value1, final String value2) {
            this.addCriterion("schedule_name not between", value1, value2, "scheduleName");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnIsNull() {
            this.addCriterion("active_yn is null");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnIsNotNull() {
            this.addCriterion("active_yn is not null");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnEqualTo(final String value) {
            this.addCriterion("active_yn =", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnNotEqualTo(final String value) {
            this.addCriterion("active_yn <>", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnGreaterThan(final String value) {
            this.addCriterion("active_yn >", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnGreaterThanOrEqualTo(final String value) {
            this.addCriterion("active_yn >=", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnLessThan(final String value) {
            this.addCriterion("active_yn <", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnLessThanOrEqualTo(final String value) {
            this.addCriterion("active_yn <=", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnLike(final String value) {
            this.addCriterion("active_yn like", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnNotLike(final String value) {
            this.addCriterion("active_yn not like", value, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnIn(final List<String> values) {
            this.addCriterion("active_yn in", values, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnNotIn(final List<String> values) {
            this.addCriterion("active_yn not in", values, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnBetween(final String value1, final String value2) {
            this.addCriterion("active_yn between", value1, value2, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveYnNotBetween(final String value1, final String value2) {
            this.addCriterion("active_yn not between", value1, value2, "activeYn");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerIsNull() {
            this.addCriterion("active_server is null");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerIsNotNull() {
            this.addCriterion("active_server is not null");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerEqualTo(final String value) {
            this.addCriterion("active_server =", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerNotEqualTo(final String value) {
            this.addCriterion("active_server <>", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerGreaterThan(final String value) {
            this.addCriterion("active_server >", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerGreaterThanOrEqualTo(final String value) {
            this.addCriterion("active_server >=", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerLessThan(final String value) {
            this.addCriterion("active_server <", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerLessThanOrEqualTo(final String value) {
            this.addCriterion("active_server <=", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerLike(final String value) {
            this.addCriterion("active_server like", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerNotLike(final String value) {
            this.addCriterion("active_server not like", value, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerIn(final List<String> values) {
            this.addCriterion("active_server in", values, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerNotIn(final List<String> values) {
            this.addCriterion("active_server not in", values, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerBetween(final String value1, final String value2) {
            this.addCriterion("active_server between", value1, value2, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andActiveServerNotBetween(final String value1, final String value2) {
            this.addCriterion("active_server not between", value1, value2, "activeServer");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionIsNull() {
            this.addCriterion("start_position is null");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionIsNotNull() {
            this.addCriterion("start_position is not null");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionEqualTo(final String value) {
            this.addCriterion("start_position =", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionNotEqualTo(final String value) {
            this.addCriterion("start_position <>", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionGreaterThan(final String value) {
            this.addCriterion("start_position >", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionGreaterThanOrEqualTo(final String value) {
            this.addCriterion("start_position >=", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionLessThan(final String value) {
            this.addCriterion("start_position <", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionLessThanOrEqualTo(final String value) {
            this.addCriterion("start_position <=", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionLike(final String value) {
            this.addCriterion("start_position like", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionNotLike(final String value) {
            this.addCriterion("start_position not like", value, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionIn(final List<String> values) {
            this.addCriterion("start_position in", values, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionNotIn(final List<String> values) {
            this.addCriterion("start_position not in", values, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionBetween(final String value1, final String value2) {
            this.addCriterion("start_position between", value1, value2, "startPosition");
            return (Criteria)this;
        }
        
        public Criteria andStartPositionNotBetween(final String value1, final String value2) {
            this.addCriterion("start_position not between", value1, value2, "startPosition");
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
