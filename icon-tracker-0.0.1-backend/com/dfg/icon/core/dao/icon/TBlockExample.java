// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TBlockExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TBlockExample() {
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
        
        public Criteria andHeightIsNull() {
            this.addCriterion("height is null");
            return (Criteria)this;
        }
        
        public Criteria andHeightIsNotNull() {
            this.addCriterion("height is not null");
            return (Criteria)this;
        }
        
        public Criteria andHeightEqualTo(final Integer value) {
            this.addCriterion("height =", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightNotEqualTo(final Integer value) {
            this.addCriterion("height <>", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightGreaterThan(final Integer value) {
            this.addCriterion("height >", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("height >=", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightLessThan(final Integer value) {
            this.addCriterion("height <", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightLessThanOrEqualTo(final Integer value) {
            this.addCriterion("height <=", value, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightIn(final List<Integer> values) {
            this.addCriterion("height in", values, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightNotIn(final List<Integer> values) {
            this.addCriterion("height not in", values, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightBetween(final Integer value1, final Integer value2) {
            this.addCriterion("height between", value1, value2, "height");
            return (Criteria)this;
        }
        
        public Criteria andHeightNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("height not between", value1, value2, "height");
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
        
        public Criteria andCRepIsNull() {
            this.addCriterion("c_rep is null");
            return (Criteria)this;
        }
        
        public Criteria andCRepIsNotNull() {
            this.addCriterion("c_rep is not null");
            return (Criteria)this;
        }
        
        public Criteria andCRepEqualTo(final String value) {
            this.addCriterion("c_rep =", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepNotEqualTo(final String value) {
            this.addCriterion("c_rep <>", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepGreaterThan(final String value) {
            this.addCriterion("c_rep >", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepGreaterThanOrEqualTo(final String value) {
            this.addCriterion("c_rep >=", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepLessThan(final String value) {
            this.addCriterion("c_rep <", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepLessThanOrEqualTo(final String value) {
            this.addCriterion("c_rep <=", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepLike(final String value) {
            this.addCriterion("c_rep like", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepNotLike(final String value) {
            this.addCriterion("c_rep not like", value, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepIn(final List<String> values) {
            this.addCriterion("c_rep in", values, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepNotIn(final List<String> values) {
            this.addCriterion("c_rep not in", values, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepBetween(final String value1, final String value2) {
            this.addCriterion("c_rep between", value1, value2, "cRep");
            return (Criteria)this;
        }
        
        public Criteria andCRepNotBetween(final String value1, final String value2) {
            this.addCriterion("c_rep not between", value1, value2, "cRep");
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
        
        public Criteria andPrevHashIsNull() {
            this.addCriterion("prev_hash is null");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashIsNotNull() {
            this.addCriterion("prev_hash is not null");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashEqualTo(final String value) {
            this.addCriterion("prev_hash =", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashNotEqualTo(final String value) {
            this.addCriterion("prev_hash <>", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashGreaterThan(final String value) {
            this.addCriterion("prev_hash >", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashGreaterThanOrEqualTo(final String value) {
            this.addCriterion("prev_hash >=", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashLessThan(final String value) {
            this.addCriterion("prev_hash <", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashLessThanOrEqualTo(final String value) {
            this.addCriterion("prev_hash <=", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashLike(final String value) {
            this.addCriterion("prev_hash like", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashNotLike(final String value) {
            this.addCriterion("prev_hash not like", value, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashIn(final List<String> values) {
            this.addCriterion("prev_hash in", values, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashNotIn(final List<String> values) {
            this.addCriterion("prev_hash not in", values, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashBetween(final String value1, final String value2) {
            this.addCriterion("prev_hash between", value1, value2, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andPrevHashNotBetween(final String value1, final String value2) {
            this.addCriterion("prev_hash not between", value1, value2, "prevHash");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeIsNull() {
            this.addCriterion("block_size is null");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeIsNotNull() {
            this.addCriterion("block_size is not null");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeEqualTo(final Integer value) {
            this.addCriterion("block_size =", value, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeNotEqualTo(final Integer value) {
            this.addCriterion("block_size <>", value, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeGreaterThan(final Integer value) {
            this.addCriterion("block_size >", value, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("block_size >=", value, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeLessThan(final Integer value) {
            this.addCriterion("block_size <", value, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeLessThanOrEqualTo(final Integer value) {
            this.addCriterion("block_size <=", value, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeIn(final List<Integer> values) {
            this.addCriterion("block_size in", values, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeNotIn(final List<Integer> values) {
            this.addCriterion("block_size not in", values, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeBetween(final Integer value1, final Integer value2) {
            this.addCriterion("block_size between", value1, value2, "blockSize");
            return (Criteria)this;
        }
        
        public Criteria andBlockSizeNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("block_size not between", value1, value2, "blockSize");
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
