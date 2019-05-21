package com.jn.hr.exam.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerExaminaExamQuestionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerExaminaExamQuestionCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExaminaIdIsNull() {
            addCriterion("examina_id is null");
            return (Criteria) this;
        }

        public Criteria andExaminaIdIsNotNull() {
            addCriterion("examina_id is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaIdEqualTo(String value) {
            addCriterion("examina_id =", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotEqualTo(String value) {
            addCriterion("examina_id <>", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdGreaterThan(String value) {
            addCriterion("examina_id >", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdGreaterThanOrEqualTo(String value) {
            addCriterion("examina_id >=", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdLessThan(String value) {
            addCriterion("examina_id <", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdLessThanOrEqualTo(String value) {
            addCriterion("examina_id <=", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdLike(String value) {
            addCriterion("examina_id like", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotLike(String value) {
            addCriterion("examina_id not like", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdIn(List<String> values) {
            addCriterion("examina_id in", values, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotIn(List<String> values) {
            addCriterion("examina_id not in", values, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdBetween(String value1, String value2) {
            addCriterion("examina_id between", value1, value2, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotBetween(String value1, String value2) {
            addCriterion("examina_id not between", value1, value2, "examinaId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdIsNull() {
            addCriterion("test_question_id is null");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdIsNotNull() {
            addCriterion("test_question_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdEqualTo(String value) {
            addCriterion("test_question_id =", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotEqualTo(String value) {
            addCriterion("test_question_id <>", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdGreaterThan(String value) {
            addCriterion("test_question_id >", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdGreaterThanOrEqualTo(String value) {
            addCriterion("test_question_id >=", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdLessThan(String value) {
            addCriterion("test_question_id <", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdLessThanOrEqualTo(String value) {
            addCriterion("test_question_id <=", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdLike(String value) {
            addCriterion("test_question_id like", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotLike(String value) {
            addCriterion("test_question_id not like", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdIn(List<String> values) {
            addCriterion("test_question_id in", values, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotIn(List<String> values) {
            addCriterion("test_question_id not in", values, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdBetween(String value1, String value2) {
            addCriterion("test_question_id between", value1, value2, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotBetween(String value1, String value2) {
            addCriterion("test_question_id not between", value1, value2, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andFractionIsNull() {
            addCriterion("fraction is null");
            return (Criteria) this;
        }

        public Criteria andFractionIsNotNull() {
            addCriterion("fraction is not null");
            return (Criteria) this;
        }

        public Criteria andFractionEqualTo(String value) {
            addCriterion("fraction =", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotEqualTo(String value) {
            addCriterion("fraction <>", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThan(String value) {
            addCriterion("fraction >", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThanOrEqualTo(String value) {
            addCriterion("fraction >=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThan(String value) {
            addCriterion("fraction <", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThanOrEqualTo(String value) {
            addCriterion("fraction <=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLike(String value) {
            addCriterion("fraction like", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotLike(String value) {
            addCriterion("fraction not like", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionIn(List<String> values) {
            addCriterion("fraction in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotIn(List<String> values) {
            addCriterion("fraction not in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionBetween(String value1, String value2) {
            addCriterion("fraction between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotBetween(String value1, String value2) {
            addCriterion("fraction not between", value1, value2, "fraction");
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