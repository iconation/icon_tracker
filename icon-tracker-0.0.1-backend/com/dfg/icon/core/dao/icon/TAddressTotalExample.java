// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.ArrayList;
import java.util.List;

public class TAddressTotalExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TAddressTotalExample() {
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
        
        public Criteria andBalanceIsNull() {
            this.addCriterion("balance is null");
            return (Criteria)this;
        }
        
        public Criteria andBalanceIsNotNull() {
            this.addCriterion("balance is not null");
            return (Criteria)this;
        }
        
        public Criteria andBalanceEqualTo(final String value) {
            this.addCriterion("balance =", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceNotEqualTo(final String value) {
            this.addCriterion("balance <>", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceGreaterThan(final String value) {
            this.addCriterion("balance >", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceGreaterThanOrEqualTo(final String value) {
            this.addCriterion("balance >=", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceLessThan(final String value) {
            this.addCriterion("balance <", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceLessThanOrEqualTo(final String value) {
            this.addCriterion("balance <=", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceLike(final String value) {
            this.addCriterion("balance like", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceNotLike(final String value) {
            this.addCriterion("balance not like", value, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceIn(final List<String> values) {
            this.addCriterion("balance in", values, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceNotIn(final List<String> values) {
            this.addCriterion("balance not in", values, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceBetween(final String value1, final String value2) {
            this.addCriterion("balance between", value1, value2, "balance");
            return (Criteria)this;
        }
        
        public Criteria andBalanceNotBetween(final String value1, final String value2) {
            this.addCriterion("balance not between", value1, value2, "balance");
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
        
        public Criteria andNodeTypeIsNull() {
            this.addCriterion("node_type is null");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeIsNotNull() {
            this.addCriterion("node_type is not null");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeEqualTo(final String value) {
            this.addCriterion("node_type =", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeNotEqualTo(final String value) {
            this.addCriterion("node_type <>", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeGreaterThan(final String value) {
            this.addCriterion("node_type >", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeGreaterThanOrEqualTo(final String value) {
            this.addCriterion("node_type >=", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeLessThan(final String value) {
            this.addCriterion("node_type <", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeLessThanOrEqualTo(final String value) {
            this.addCriterion("node_type <=", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeLike(final String value) {
            this.addCriterion("node_type like", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeNotLike(final String value) {
            this.addCriterion("node_type not like", value, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeIn(final List<String> values) {
            this.addCriterion("node_type in", values, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeNotIn(final List<String> values) {
            this.addCriterion("node_type not in", values, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeBetween(final String value1, final String value2) {
            this.addCriterion("node_type between", value1, value2, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andNodeTypeNotBetween(final String value1, final String value2) {
            this.addCriterion("node_type not between", value1, value2, "nodeType");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateIsNull() {
            this.addCriterion("is_update is null");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateIsNotNull() {
            this.addCriterion("is_update is not null");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateEqualTo(final Boolean value) {
            this.addCriterion("is_update =", value, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateNotEqualTo(final Boolean value) {
            this.addCriterion("is_update <>", value, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateGreaterThan(final Boolean value) {
            this.addCriterion("is_update >", value, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateGreaterThanOrEqualTo(final Boolean value) {
            this.addCriterion("is_update >=", value, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateLessThan(final Boolean value) {
            this.addCriterion("is_update <", value, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateLessThanOrEqualTo(final Boolean value) {
            this.addCriterion("is_update <=", value, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateIn(final List<Boolean> values) {
            this.addCriterion("is_update in", values, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateNotIn(final List<Boolean> values) {
            this.addCriterion("is_update not in", values, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateBetween(final Boolean value1, final Boolean value2) {
            this.addCriterion("is_update between", value1, value2, "isUpdate");
            return (Criteria)this;
        }
        
        public Criteria andIsUpdateNotBetween(final Boolean value1, final Boolean value2) {
            this.addCriterion("is_update not between", value1, value2, "isUpdate");
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
