// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TCurrentExchangeExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TCurrentExchangeExample() {
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
        
        public Criteria andMarketNameIsNull() {
            this.addCriterion("market_name is null");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameIsNotNull() {
            this.addCriterion("market_name is not null");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameEqualTo(final String value) {
            this.addCriterion("market_name =", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameNotEqualTo(final String value) {
            this.addCriterion("market_name <>", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameGreaterThan(final String value) {
            this.addCriterion("market_name >", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("market_name >=", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameLessThan(final String value) {
            this.addCriterion("market_name <", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameLessThanOrEqualTo(final String value) {
            this.addCriterion("market_name <=", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameLike(final String value) {
            this.addCriterion("market_name like", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameNotLike(final String value) {
            this.addCriterion("market_name not like", value, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameIn(final List<String> values) {
            this.addCriterion("market_name in", values, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameNotIn(final List<String> values) {
            this.addCriterion("market_name not in", values, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameBetween(final String value1, final String value2) {
            this.addCriterion("market_name between", value1, value2, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andMarketNameNotBetween(final String value1, final String value2) {
            this.addCriterion("market_name not between", value1, value2, "marketName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameIsNull() {
            this.addCriterion("trade_name is null");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameIsNotNull() {
            this.addCriterion("trade_name is not null");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameEqualTo(final String value) {
            this.addCriterion("trade_name =", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameNotEqualTo(final String value) {
            this.addCriterion("trade_name <>", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameGreaterThan(final String value) {
            this.addCriterion("trade_name >", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameGreaterThanOrEqualTo(final String value) {
            this.addCriterion("trade_name >=", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameLessThan(final String value) {
            this.addCriterion("trade_name <", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameLessThanOrEqualTo(final String value) {
            this.addCriterion("trade_name <=", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameLike(final String value) {
            this.addCriterion("trade_name like", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameNotLike(final String value) {
            this.addCriterion("trade_name not like", value, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameIn(final List<String> values) {
            this.addCriterion("trade_name in", values, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameNotIn(final List<String> values) {
            this.addCriterion("trade_name not in", values, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameBetween(final String value1, final String value2) {
            this.addCriterion("trade_name between", value1, value2, "tradeName");
            return (Criteria)this;
        }
        
        public Criteria andTradeNameNotBetween(final String value1, final String value2) {
            this.addCriterion("trade_name not between", value1, value2, "tradeName");
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
        
        public Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (Criteria)this;
        }
        
        public Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (Criteria)this;
        }
        
        public Criteria andPriceEqualTo(final String value) {
            this.addCriterion("price =", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceNotEqualTo(final String value) {
            this.addCriterion("price <>", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceGreaterThan(final String value) {
            this.addCriterion("price >", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceGreaterThanOrEqualTo(final String value) {
            this.addCriterion("price >=", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceLessThan(final String value) {
            this.addCriterion("price <", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceLessThanOrEqualTo(final String value) {
            this.addCriterion("price <=", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceLike(final String value) {
            this.addCriterion("price like", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceNotLike(final String value) {
            this.addCriterion("price not like", value, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceIn(final List<String> values) {
            this.addCriterion("price in", values, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceNotIn(final List<String> values) {
            this.addCriterion("price not in", values, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceBetween(final String value1, final String value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (Criteria)this;
        }
        
        public Criteria andPriceNotBetween(final String value1, final String value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceIsNull() {
            this.addCriterion("pre_price is null");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceIsNotNull() {
            this.addCriterion("pre_price is not null");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceEqualTo(final String value) {
            this.addCriterion("pre_price =", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceNotEqualTo(final String value) {
            this.addCriterion("pre_price <>", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceGreaterThan(final String value) {
            this.addCriterion("pre_price >", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceGreaterThanOrEqualTo(final String value) {
            this.addCriterion("pre_price >=", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceLessThan(final String value) {
            this.addCriterion("pre_price <", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceLessThanOrEqualTo(final String value) {
            this.addCriterion("pre_price <=", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceLike(final String value) {
            this.addCriterion("pre_price like", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceNotLike(final String value) {
            this.addCriterion("pre_price not like", value, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceIn(final List<String> values) {
            this.addCriterion("pre_price in", values, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceNotIn(final List<String> values) {
            this.addCriterion("pre_price not in", values, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceBetween(final String value1, final String value2) {
            this.addCriterion("pre_price between", value1, value2, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andPrePriceNotBetween(final String value1, final String value2) {
            this.addCriterion("pre_price not between", value1, value2, "prePrice");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateIsNull() {
            this.addCriterion("daily_rate is null");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateIsNotNull() {
            this.addCriterion("daily_rate is not null");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateEqualTo(final String value) {
            this.addCriterion("daily_rate =", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateNotEqualTo(final String value) {
            this.addCriterion("daily_rate <>", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateGreaterThan(final String value) {
            this.addCriterion("daily_rate >", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateGreaterThanOrEqualTo(final String value) {
            this.addCriterion("daily_rate >=", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateLessThan(final String value) {
            this.addCriterion("daily_rate <", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateLessThanOrEqualTo(final String value) {
            this.addCriterion("daily_rate <=", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateLike(final String value) {
            this.addCriterion("daily_rate like", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateNotLike(final String value) {
            this.addCriterion("daily_rate not like", value, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateIn(final List<String> values) {
            this.addCriterion("daily_rate in", values, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateNotIn(final List<String> values) {
            this.addCriterion("daily_rate not in", values, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateBetween(final String value1, final String value2) {
            this.addCriterion("daily_rate between", value1, value2, "dailyRate");
            return (Criteria)this;
        }
        
        public Criteria andDailyRateNotBetween(final String value1, final String value2) {
            this.addCriterion("daily_rate not between", value1, value2, "dailyRate");
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
