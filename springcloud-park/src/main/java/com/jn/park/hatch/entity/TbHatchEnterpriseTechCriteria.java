package com.jn.park.hatch.entity;

import java.util.ArrayList;
import java.util.List;

public class TbHatchEnterpriseTechCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHatchEnterpriseTechCriteria() {
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

        public Criteria andEnterpriseTechIdIsNull() {
            addCriterion("enterprise_tech_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdIsNotNull() {
            addCriterion("enterprise_tech_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdEqualTo(String value) {
            addCriterion("enterprise_tech_id =", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotEqualTo(String value) {
            addCriterion("enterprise_tech_id <>", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdGreaterThan(String value) {
            addCriterion("enterprise_tech_id >", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_id >=", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdLessThan(String value) {
            addCriterion("enterprise_tech_id <", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_id <=", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdLike(String value) {
            addCriterion("enterprise_tech_id like", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotLike(String value) {
            addCriterion("enterprise_tech_id not like", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdIn(List<String> values) {
            addCriterion("enterprise_tech_id in", values, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotIn(List<String> values) {
            addCriterion("enterprise_tech_id not in", values, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdBetween(String value1, String value2) {
            addCriterion("enterprise_tech_id between", value1, value2, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_tech_id not between", value1, value2, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameIsNull() {
            addCriterion("enterprise_tech_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameIsNotNull() {
            addCriterion("enterprise_tech_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameEqualTo(String value) {
            addCriterion("enterprise_tech_name =", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotEqualTo(String value) {
            addCriterion("enterprise_tech_name <>", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameGreaterThan(String value) {
            addCriterion("enterprise_tech_name >", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_name >=", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameLessThan(String value) {
            addCriterion("enterprise_tech_name <", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_name <=", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameLike(String value) {
            addCriterion("enterprise_tech_name like", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotLike(String value) {
            addCriterion("enterprise_tech_name not like", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameIn(List<String> values) {
            addCriterion("enterprise_tech_name in", values, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotIn(List<String> values) {
            addCriterion("enterprise_tech_name not in", values, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameBetween(String value1, String value2) {
            addCriterion("enterprise_tech_name between", value1, value2, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_tech_name not between", value1, value2, "enterpriseTechName");
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