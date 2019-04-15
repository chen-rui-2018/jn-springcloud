package com.jn.park.gamtopic.entity;

import java.util.ArrayList;
import java.util.List;

public class TbPersonCareCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPersonCareCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCareIdIsNull() {
            addCriterion("care_id is null");
            return (Criteria) this;
        }

        public Criteria andCareIdIsNotNull() {
            addCriterion("care_id is not null");
            return (Criteria) this;
        }

        public Criteria andCareIdEqualTo(String value) {
            addCriterion("care_id =", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotEqualTo(String value) {
            addCriterion("care_id <>", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdGreaterThan(String value) {
            addCriterion("care_id >", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdGreaterThanOrEqualTo(String value) {
            addCriterion("care_id >=", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLessThan(String value) {
            addCriterion("care_id <", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLessThanOrEqualTo(String value) {
            addCriterion("care_id <=", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLike(String value) {
            addCriterion("care_id like", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotLike(String value) {
            addCriterion("care_id not like", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdIn(List<String> values) {
            addCriterion("care_id in", values, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotIn(List<String> values) {
            addCriterion("care_id not in", values, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdBetween(String value1, String value2) {
            addCriterion("care_id between", value1, value2, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotBetween(String value1, String value2) {
            addCriterion("care_id not between", value1, value2, "careId");
            return (Criteria) this;
        }

        public Criteria andCareAccountIsNull() {
            addCriterion("care_account is null");
            return (Criteria) this;
        }

        public Criteria andCareAccountIsNotNull() {
            addCriterion("care_account is not null");
            return (Criteria) this;
        }

        public Criteria andCareAccountEqualTo(String value) {
            addCriterion("care_account =", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotEqualTo(String value) {
            addCriterion("care_account <>", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountGreaterThan(String value) {
            addCriterion("care_account >", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountGreaterThanOrEqualTo(String value) {
            addCriterion("care_account >=", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountLessThan(String value) {
            addCriterion("care_account <", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountLessThanOrEqualTo(String value) {
            addCriterion("care_account <=", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountLike(String value) {
            addCriterion("care_account like", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotLike(String value) {
            addCriterion("care_account not like", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountIn(List<String> values) {
            addCriterion("care_account in", values, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotIn(List<String> values) {
            addCriterion("care_account not in", values, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountBetween(String value1, String value2) {
            addCriterion("care_account between", value1, value2, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotBetween(String value1, String value2) {
            addCriterion("care_account not between", value1, value2, "careAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountIsNull() {
            addCriterion("receive_account is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountIsNotNull() {
            addCriterion("receive_account is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountEqualTo(String value) {
            addCriterion("receive_account =", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotEqualTo(String value) {
            addCriterion("receive_account <>", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountGreaterThan(String value) {
            addCriterion("receive_account >", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountGreaterThanOrEqualTo(String value) {
            addCriterion("receive_account >=", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountLessThan(String value) {
            addCriterion("receive_account <", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountLessThanOrEqualTo(String value) {
            addCriterion("receive_account <=", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountLike(String value) {
            addCriterion("receive_account like", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotLike(String value) {
            addCriterion("receive_account not like", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountIn(List<String> values) {
            addCriterion("receive_account in", values, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotIn(List<String> values) {
            addCriterion("receive_account not in", values, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountBetween(String value1, String value2) {
            addCriterion("receive_account between", value1, value2, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotBetween(String value1, String value2) {
            addCriterion("receive_account not between", value1, value2, "receiveAccount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}