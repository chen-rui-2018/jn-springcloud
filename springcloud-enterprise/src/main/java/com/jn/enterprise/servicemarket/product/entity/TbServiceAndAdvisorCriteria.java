package com.jn.enterprise.servicemarket.product.entity;

import java.util.ArrayList;
import java.util.List;

public class TbServiceAndAdvisorCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceAndAdvisorCriteria() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id_ is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id_ =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id_ <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id_ >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id_ >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id_ <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id_ <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id_ like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id_ not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id_ in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id_ not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id_ between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id_ not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountIsNull() {
            addCriterion("advisor_account is null");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountIsNotNull() {
            addCriterion("advisor_account is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountEqualTo(String value) {
            addCriterion("advisor_account =", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotEqualTo(String value) {
            addCriterion("advisor_account <>", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountGreaterThan(String value) {
            addCriterion("advisor_account >", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("advisor_account >=", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountLessThan(String value) {
            addCriterion("advisor_account <", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountLessThanOrEqualTo(String value) {
            addCriterion("advisor_account <=", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountLike(String value) {
            addCriterion("advisor_account like", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotLike(String value) {
            addCriterion("advisor_account not like", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountIn(List<String> values) {
            addCriterion("advisor_account in", values, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotIn(List<String> values) {
            addCriterion("advisor_account not in", values, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountBetween(String value1, String value2) {
            addCriterion("advisor_account between", value1, value2, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotBetween(String value1, String value2) {
            addCriterion("advisor_account not between", value1, value2, "advisorAccount");
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