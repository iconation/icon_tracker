// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Iterator;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TMainChartExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TMainChartExample() {
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
        
        protected void addCriterionForJDBCDate(final String condition, final Date value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }
        
        protected void addCriterionForJDBCDate(final String condition, final List<Date> values, final String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            final List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            final Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            this.addCriterion(condition, dateList, property);
        }
        
        protected void addCriterionForJDBCDate(final String condition, final Date value1, final Date value2, final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }
        
        public Criteria andTargetDateIsNull() {
            this.addCriterion("target_date is null");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateIsNotNull() {
            this.addCriterion("target_date is not null");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateEqualTo(final Date value) {
            this.addCriterionForJDBCDate("target_date =", value, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateNotEqualTo(final Date value) {
            this.addCriterionForJDBCDate("target_date <>", value, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateGreaterThan(final Date value) {
            this.addCriterionForJDBCDate("target_date >", value, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateGreaterThanOrEqualTo(final Date value) {
            this.addCriterionForJDBCDate("target_date >=", value, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateLessThan(final Date value) {
            this.addCriterionForJDBCDate("target_date <", value, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateLessThanOrEqualTo(final Date value) {
            this.addCriterionForJDBCDate("target_date <=", value, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateIn(final List<Date> values) {
            this.addCriterionForJDBCDate("target_date in", values, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateNotIn(final List<Date> values) {
            this.addCriterionForJDBCDate("target_date not in", values, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateBetween(final Date value1, final Date value2) {
            this.addCriterionForJDBCDate("target_date between", value1, value2, "targetDate");
            return (Criteria)this;
        }
        
        public Criteria andTargetDateNotBetween(final Date value1, final Date value2) {
            this.addCriterionForJDBCDate("target_date not between", value1, value2, "targetDate");
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
