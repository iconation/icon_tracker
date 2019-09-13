// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.core.dao.icon;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TContractHistoryExample
{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    
    public TContractHistoryExample() {
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
        
        public Criteria andVersionIsNull() {
            this.addCriterion("version is null");
            return (Criteria)this;
        }
        
        public Criteria andVersionIsNotNull() {
            this.addCriterion("version is not null");
            return (Criteria)this;
        }
        
        public Criteria andVersionEqualTo(final Integer value) {
            this.addCriterion("version =", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotEqualTo(final Integer value) {
            this.addCriterion("version <>", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionGreaterThan(final Integer value) {
            this.addCriterion("version >", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionGreaterThanOrEqualTo(final Integer value) {
            this.addCriterion("version >=", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLessThan(final Integer value) {
            this.addCriterion("version <", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionLessThanOrEqualTo(final Integer value) {
            this.addCriterion("version <=", value, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionIn(final List<Integer> values) {
            this.addCriterion("version in", values, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotIn(final List<Integer> values) {
            this.addCriterion("version not in", values, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionBetween(final Integer value1, final Integer value2) {
            this.addCriterion("version between", value1, value2, "version");
            return (Criteria)this;
        }
        
        public Criteria andVersionNotBetween(final Integer value1, final Integer value2) {
            this.addCriterion("version not between", value1, value2, "version");
            return (Criteria)this;
        }
        
        public Criteria andCompilerIsNull() {
            this.addCriterion("compiler is null");
            return (Criteria)this;
        }
        
        public Criteria andCompilerIsNotNull() {
            this.addCriterion("compiler is not null");
            return (Criteria)this;
        }
        
        public Criteria andCompilerEqualTo(final String value) {
            this.addCriterion("compiler =", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerNotEqualTo(final String value) {
            this.addCriterion("compiler <>", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerGreaterThan(final String value) {
            this.addCriterion("compiler >", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerGreaterThanOrEqualTo(final String value) {
            this.addCriterion("compiler >=", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerLessThan(final String value) {
            this.addCriterion("compiler <", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerLessThanOrEqualTo(final String value) {
            this.addCriterion("compiler <=", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerLike(final String value) {
            this.addCriterion("compiler like", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerNotLike(final String value) {
            this.addCriterion("compiler not like", value, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerIn(final List<String> values) {
            this.addCriterion("compiler in", values, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerNotIn(final List<String> values) {
            this.addCriterion("compiler not in", values, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerBetween(final String value1, final String value2) {
            this.addCriterion("compiler between", value1, value2, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCompilerNotBetween(final String value1, final String value2) {
            this.addCriterion("compiler not between", value1, value2, "compiler");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxIsNull() {
            this.addCriterion("create_tx is null");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxIsNotNull() {
            this.addCriterion("create_tx is not null");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxEqualTo(final String value) {
            this.addCriterion("create_tx =", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxNotEqualTo(final String value) {
            this.addCriterion("create_tx <>", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxGreaterThan(final String value) {
            this.addCriterion("create_tx >", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxGreaterThanOrEqualTo(final String value) {
            this.addCriterion("create_tx >=", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxLessThan(final String value) {
            this.addCriterion("create_tx <", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxLessThanOrEqualTo(final String value) {
            this.addCriterion("create_tx <=", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxLike(final String value) {
            this.addCriterion("create_tx like", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxNotLike(final String value) {
            this.addCriterion("create_tx not like", value, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxIn(final List<String> values) {
            this.addCriterion("create_tx in", values, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxNotIn(final List<String> values) {
            this.addCriterion("create_tx not in", values, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxBetween(final String value1, final String value2) {
            this.addCriterion("create_tx between", value1, value2, "createTx");
            return (Criteria)this;
        }
        
        public Criteria andCreateTxNotBetween(final String value1, final String value2) {
            this.addCriterion("create_tx not between", value1, value2, "createTx");
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
        
        public Criteria andVerifiedTxIsNull() {
            this.addCriterion("verified_tx is null");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxIsNotNull() {
            this.addCriterion("verified_tx is not null");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxEqualTo(final String value) {
            this.addCriterion("verified_tx =", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxNotEqualTo(final String value) {
            this.addCriterion("verified_tx <>", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxGreaterThan(final String value) {
            this.addCriterion("verified_tx >", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxGreaterThanOrEqualTo(final String value) {
            this.addCriterion("verified_tx >=", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxLessThan(final String value) {
            this.addCriterion("verified_tx <", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxLessThanOrEqualTo(final String value) {
            this.addCriterion("verified_tx <=", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxLike(final String value) {
            this.addCriterion("verified_tx like", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxNotLike(final String value) {
            this.addCriterion("verified_tx not like", value, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxIn(final List<String> values) {
            this.addCriterion("verified_tx in", values, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxNotIn(final List<String> values) {
            this.addCriterion("verified_tx not in", values, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxBetween(final String value1, final String value2) {
            this.addCriterion("verified_tx between", value1, value2, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedTxNotBetween(final String value1, final String value2) {
            this.addCriterion("verified_tx not between", value1, value2, "verifiedTx");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateIsNull() {
            this.addCriterion("verified_date is null");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateIsNotNull() {
            this.addCriterion("verified_date is not null");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateEqualTo(final Date value) {
            this.addCriterion("verified_date =", value, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateNotEqualTo(final Date value) {
            this.addCriterion("verified_date <>", value, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateGreaterThan(final Date value) {
            this.addCriterion("verified_date >", value, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateGreaterThanOrEqualTo(final Date value) {
            this.addCriterion("verified_date >=", value, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateLessThan(final Date value) {
            this.addCriterion("verified_date <", value, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateLessThanOrEqualTo(final Date value) {
            this.addCriterion("verified_date <=", value, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateIn(final List<Date> values) {
            this.addCriterion("verified_date in", values, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateNotIn(final List<Date> values) {
            this.addCriterion("verified_date not in", values, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateBetween(final Date value1, final Date value2) {
            this.addCriterion("verified_date between", value1, value2, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andVerifiedDateNotBetween(final Date value1, final Date value2) {
            this.addCriterion("verified_date not between", value1, value2, "verifiedDate");
            return (Criteria)this;
        }
        
        public Criteria andCreatorIsNull() {
            this.addCriterion("creator is null");
            return (Criteria)this;
        }
        
        public Criteria andCreatorIsNotNull() {
            this.addCriterion("creator is not null");
            return (Criteria)this;
        }
        
        public Criteria andCreatorEqualTo(final String value) {
            this.addCriterion("creator =", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorNotEqualTo(final String value) {
            this.addCriterion("creator <>", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorGreaterThan(final String value) {
            this.addCriterion("creator >", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorGreaterThanOrEqualTo(final String value) {
            this.addCriterion("creator >=", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorLessThan(final String value) {
            this.addCriterion("creator <", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorLessThanOrEqualTo(final String value) {
            this.addCriterion("creator <=", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorLike(final String value) {
            this.addCriterion("creator like", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorNotLike(final String value) {
            this.addCriterion("creator not like", value, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorIn(final List<String> values) {
            this.addCriterion("creator in", values, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorNotIn(final List<String> values) {
            this.addCriterion("creator not in", values, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorBetween(final String value1, final String value2) {
            this.addCriterion("creator between", value1, value2, "creator");
            return (Criteria)this;
        }
        
        public Criteria andCreatorNotBetween(final String value1, final String value2) {
            this.addCriterion("creator not between", value1, value2, "creator");
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
