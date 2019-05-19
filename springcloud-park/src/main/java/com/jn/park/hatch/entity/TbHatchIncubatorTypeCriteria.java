package com.jn.park.hatch.entity;

import java.util.ArrayList;
import java.util.List;

public class TbHatchIncubatorTypeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHatchIncubatorTypeCriteria() {
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

        public Criteria andIncubatorCodeIsNull() {
            addCriterion("incubator_code is null");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeIsNotNull() {
            addCriterion("incubator_code is not null");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeEqualTo(String value) {
            addCriterion("incubator_code =", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeNotEqualTo(String value) {
            addCriterion("incubator_code <>", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeGreaterThan(String value) {
            addCriterion("incubator_code >", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("incubator_code >=", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeLessThan(String value) {
            addCriterion("incubator_code <", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeLessThanOrEqualTo(String value) {
            addCriterion("incubator_code <=", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeLike(String value) {
            addCriterion("incubator_code like", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeNotLike(String value) {
            addCriterion("incubator_code not like", value, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeIn(List<String> values) {
            addCriterion("incubator_code in", values, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeNotIn(List<String> values) {
            addCriterion("incubator_code not in", values, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeBetween(String value1, String value2) {
            addCriterion("incubator_code between", value1, value2, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorCodeNotBetween(String value1, String value2) {
            addCriterion("incubator_code not between", value1, value2, "incubatorCode");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameIsNull() {
            addCriterion("incubator_name is null");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameIsNotNull() {
            addCriterion("incubator_name is not null");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameEqualTo(String value) {
            addCriterion("incubator_name =", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameNotEqualTo(String value) {
            addCriterion("incubator_name <>", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameGreaterThan(String value) {
            addCriterion("incubator_name >", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("incubator_name >=", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameLessThan(String value) {
            addCriterion("incubator_name <", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameLessThanOrEqualTo(String value) {
            addCriterion("incubator_name <=", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameLike(String value) {
            addCriterion("incubator_name like", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameNotLike(String value) {
            addCriterion("incubator_name not like", value, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameIn(List<String> values) {
            addCriterion("incubator_name in", values, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameNotIn(List<String> values) {
            addCriterion("incubator_name not in", values, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameBetween(String value1, String value2) {
            addCriterion("incubator_name between", value1, value2, "incubatorName");
            return (Criteria) this;
        }

        public Criteria andIncubatorNameNotBetween(String value1, String value2) {
            addCriterion("incubator_name not between", value1, value2, "incubatorName");
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