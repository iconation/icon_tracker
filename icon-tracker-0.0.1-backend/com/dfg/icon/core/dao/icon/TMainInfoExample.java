// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.ArrayList;
import java.util.List;

public class TMainInfoExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TMainInfoExample() {
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
        
        public Criteria andMarketCapIsNull() {
            this.addCriterion("market_cap is null");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapIsNotNull() {
            this.addCriterion("market_cap is not null");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapEqualTo(final String value) {
            this.addCriterion("market_cap =", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapNotEqualTo(final String value) {
            this.addCriterion("market_cap <>", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapGreaterThan(final String value) {
            this.addCriterion("market_cap >", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapGreaterThanOrEqualTo(final String value) {
            this.addCriterion("market_cap >=", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapLessThan(final String value) {
            this.addCriterion("market_cap <", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapLessThanOrEqualTo(final String value) {
            this.addCriterion("market_cap <=", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapLike(final String value) {
            this.addCriterion("market_cap like", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapNotLike(final String value) {
            this.addCriterion("market_cap not like", value, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapIn(final List<String> values) {
            this.addCriterion("market_cap in", values, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapNotIn(final List<String> values) {
            this.addCriterion("market_cap not in", values, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapBetween(final String value1, final String value2) {
            this.addCriterion("market_cap between", value1, value2, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andMarketCapNotBetween(final String value1, final String value2) {
            this.addCriterion("market_cap not between", value1, value2, "marketCap");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyIsNull() {
            this.addCriterion("icx_supply is null");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyIsNotNull() {
            this.addCriterion("icx_supply is not null");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyEqualTo(final String value) {
            this.addCriterion("icx_supply =", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyNotEqualTo(final String value) {
            this.addCriterion("icx_supply <>", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyGreaterThan(final String value) {
            this.addCriterion("icx_supply >", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyGreaterThanOrEqualTo(final String value) {
            this.addCriterion("icx_supply >=", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyLessThan(final String value) {
            this.addCriterion("icx_supply <", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyLessThanOrEqualTo(final String value) {
            this.addCriterion("icx_supply <=", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyLike(final String value) {
            this.addCriterion("icx_supply like", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyNotLike(final String value) {
            this.addCriterion("icx_supply not like", value, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyIn(final List<String> values) {
            this.addCriterion("icx_supply in", values, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyNotIn(final List<String> values) {
            this.addCriterion("icx_supply not in", values, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyBetween(final String value1, final String value2) {
            this.addCriterion("icx_supply between", value1, value2, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxSupplyNotBetween(final String value1, final String value2) {
            this.addCriterion("icx_supply not between", value1, value2, "icxSupply");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyIsNull() {
            this.addCriterion("icx_circulationy is null");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyIsNotNull() {
            this.addCriterion("icx_circulationy is not null");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyEqualTo(final String value) {
            this.addCriterion("icx_circulationy =", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyNotEqualTo(final String value) {
            this.addCriterion("icx_circulationy <>", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyGreaterThan(final String value) {
            this.addCriterion("icx_circulationy >", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyGreaterThanOrEqualTo(final String value) {
            this.addCriterion("icx_circulationy >=", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyLessThan(final String value) {
            this.addCriterion("icx_circulationy <", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyLessThanOrEqualTo(final String value) {
            this.addCriterion("icx_circulationy <=", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyLike(final String value) {
            this.addCriterion("icx_circulationy like", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyNotLike(final String value) {
            this.addCriterion("icx_circulationy not like", value, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyIn(final List<String> values) {
            this.addCriterion("icx_circulationy in", values, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyNotIn(final List<String> values) {
            this.addCriterion("icx_circulationy not in", values, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyBetween(final String value1, final String value2) {
            this.addCriterion("icx_circulationy between", value1, value2, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andIcxCirculationyNotBetween(final String value1, final String value2) {
            this.addCriterion("icx_circulationy not between", value1, value2, "icxCirculationy");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountIsNull() {
            this.addCriterion("transaction_count is null");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountIsNotNull() {
            this.addCriterion("transaction_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountEqualTo(final Integer value) {
            this.addCriterion("transaction_count =", value, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountNotEqualTo(final Integer value) {
            this.addCriterion("transaction_count <>", value, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountGreaterThan(final Integer value) {
            this.addCriterion("transaction_count >", value, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("transaction_count >=", value, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountLessThan(final Integer value) {
            this.addCriterion("transaction_count <", value, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("transaction_count <=", value, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountIn(final List<Integer> values) {
            this.addCriterion("transaction_count in", values, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountNotIn(final List<Integer> values) {
            this.addCriterion("transaction_count not in", values, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("transaction_count between", value1, value2, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andTransactionCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("transaction_count not between", value1, value2, "transactionCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountIsNull() {
            this.addCriterion("crep_count is null");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountIsNotNull() {
            this.addCriterion("crep_count is not null");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountEqualTo(final Integer value) {
            this.addCriterion("crep_count =", value, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountNotEqualTo(final Integer value) {
            this.addCriterion("crep_count <>", value, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountGreaterThan(final Integer value) {
            this.addCriterion("crep_count >", value, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("crep_count >=", value, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountLessThan(final Integer value) {
            this.addCriterion("crep_count <", value, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountLessThanOrEqualTo(final Integer value) {
            this.addCriterion("crep_count <=", value, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountIn(final List<Integer> values) {
            this.addCriterion("crep_count in", values, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountNotIn(final List<Integer> values) {
            this.addCriterion("crep_count not in", values, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountBetween(final Integer value1, final Integer value2) {
            this.addCriterion("crep_count between", value1, value2, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andCrepCountNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("crep_count not between", value1, value2, "crepCount");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryIsNull() {
            this.addCriterion("public_treasury is null");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryIsNotNull() {
            this.addCriterion("public_treasury is not null");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryEqualTo(final String value) {
            this.addCriterion("public_treasury =", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryNotEqualTo(final String value) {
            this.addCriterion("public_treasury <>", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryGreaterThan(final String value) {
            this.addCriterion("public_treasury >", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryGreaterThanOrEqualTo(final String value) {
            this.addCriterion("public_treasury >=", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryLessThan(final String value) {
            this.addCriterion("public_treasury <", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryLessThanOrEqualTo(final String value) {
            this.addCriterion("public_treasury <=", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryLike(final String value) {
            this.addCriterion("public_treasury like", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryNotLike(final String value) {
            this.addCriterion("public_treasury not like", value, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryIn(final List<String> values) {
            this.addCriterion("public_treasury in", values, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryNotIn(final List<String> values) {
            this.addCriterion("public_treasury not in", values, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryBetween(final String value1, final String value2) {
            this.addCriterion("public_treasury between", value1, value2, "publicTreasury");
            return (Criteria)this;
        }
        
        public Criteria andPublicTreasuryNotBetween(final String value1, final String value2) {
            this.addCriterion("public_treasury not between", value1, value2, "publicTreasury");
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
