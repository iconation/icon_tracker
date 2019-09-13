// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TTokenAddressExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TTokenAddressExample() {
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
        
        public Criteria andQuantityIsNull() {
            this.addCriterion("quantity is null");
            return (Criteria)this;
        }
        
        public Criteria andQuantityIsNotNull() {
            this.addCriterion("quantity is not null");
            return (Criteria)this;
        }
        
        public Criteria andQuantityEqualTo(final String value) {
            this.addCriterion("quantity =", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotEqualTo(final String value) {
            this.addCriterion("quantity <>", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityGreaterThan(final String value) {
            this.addCriterion("quantity >", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityGreaterThanOrEqualTo(final String value) {
            this.addCriterion("quantity >=", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityLessThan(final String value) {
            this.addCriterion("quantity <", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityLessThanOrEqualTo(final String value) {
            this.addCriterion("quantity <=", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityLike(final String value) {
            this.addCriterion("quantity like", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotLike(final String value) {
            this.addCriterion("quantity not like", value, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityIn(final List<String> values) {
            this.addCriterion("quantity in", values, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotIn(final List<String> values) {
            this.addCriterion("quantity not in", values, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityBetween(final String value1, final String value2) {
            this.addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityNotBetween(final String value1, final String value2) {
            this.addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderIsNull() {
            this.addCriterion("quantity_order is null");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderIsNotNull() {
            this.addCriterion("quantity_order is not null");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderEqualTo(final BigDecimal value) {
            this.addCriterion("quantity_order =", value, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderNotEqualTo(final BigDecimal value) {
            this.addCriterion("quantity_order <>", value, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderGreaterThan(final BigDecimal value) {
            this.addCriterion("quantity_order >", value, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderGreaterThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("quantity_order >=", value, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderLessThan(final BigDecimal value) {
            this.addCriterion("quantity_order <", value, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderLessThanOrEqualTo(final BigDecimal value) {
            this.addCriterion("quantity_order <=", value, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderIn(final List<BigDecimal> values) {
            this.addCriterion("quantity_order in", values, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderNotIn(final List<BigDecimal> values) {
            this.addCriterion("quantity_order not in", values, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("quantity_order between", value1, value2, "quantityOrder");
            return (Criteria)this;
        }
        
        public Criteria andQuantityOrderNotBetween(final BigDecimal value1, final BigDecimal value2) {
            this.addCriterion("quantity_order not between", value1, value2, "quantityOrder");
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
