package com.jn.park.hatch.entity;

import java.util.ArrayList;
import java.util.List;

public class TbHatchEnterpriseTypeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHatchEnterpriseTypeCriteria() {
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

        public Criteria andEnterpriseTypeIdIsNull() {
            addCriterion("enterprise_type_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdIsNotNull() {
            addCriterion("enterprise_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdEqualTo(String value) {
            addCriterion("enterprise_type_id =", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotEqualTo(String value) {
            addCriterion("enterprise_type_id <>", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdGreaterThan(String value) {
            addCriterion("enterprise_type_id >", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_type_id >=", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdLessThan(String value) {
            addCriterion("enterprise_type_id <", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_type_id <=", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdLike(String value) {
            addCriterion("enterprise_type_id like", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotLike(String value) {
            addCriterion("enterprise_type_id not like", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdIn(List<String> values) {
            addCriterion("enterprise_type_id in", values, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotIn(List<String> values) {
            addCriterion("enterprise_type_id not in", values, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdBetween(String value1, String value2) {
            addCriterion("enterprise_type_id between", value1, value2, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_type_id not between", value1, value2, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameIsNull() {
            addCriterion("enterprise_type_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameIsNotNull() {
            addCriterion("enterprise_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameEqualTo(String value) {
            addCriterion("enterprise_type_name =", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotEqualTo(String value) {
            addCriterion("enterprise_type_name <>", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameGreaterThan(String value) {
            addCriterion("enterprise_type_name >", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_type_name >=", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameLessThan(String value) {
            addCriterion("enterprise_type_name <", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_type_name <=", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameLike(String value) {
            addCriterion("enterprise_type_name like", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotLike(String value) {
            addCriterion("enterprise_type_name not like", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameIn(List<String> values) {
            addCriterion("enterprise_type_name in", values, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotIn(List<String> values) {
            addCriterion("enterprise_type_name not in", values, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameBetween(String value1, String value2) {
            addCriterion("enterprise_type_name between", value1, value2, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_type_name not between", value1, value2, "enterpriseTypeName");
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