package com.jn.enterprise.data.entity;

import java.util.ArrayList;
import java.util.List;

public class TbDataReportingTaskDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataReportingTaskDataCriteria() {
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

        public Criteria andFallInFormIdIsNull() {
            addCriterion("fall_in_form_id is null");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdIsNotNull() {
            addCriterion("fall_in_form_id is not null");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdEqualTo(String value) {
            addCriterion("fall_in_form_id =", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdNotEqualTo(String value) {
            addCriterion("fall_in_form_id <>", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdGreaterThan(String value) {
            addCriterion("fall_in_form_id >", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdGreaterThanOrEqualTo(String value) {
            addCriterion("fall_in_form_id >=", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdLessThan(String value) {
            addCriterion("fall_in_form_id <", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdLessThanOrEqualTo(String value) {
            addCriterion("fall_in_form_id <=", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdLike(String value) {
            addCriterion("fall_in_form_id like", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdNotLike(String value) {
            addCriterion("fall_in_form_id not like", value, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdIn(List<String> values) {
            addCriterion("fall_in_form_id in", values, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdNotIn(List<String> values) {
            addCriterion("fall_in_form_id not in", values, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdBetween(String value1, String value2) {
            addCriterion("fall_in_form_id between", value1, value2, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andFallInFormIdNotBetween(String value1, String value2) {
            addCriterion("fall_in_form_id not between", value1, value2, "fallInFormId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(String value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(String value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(String value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(String value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(String value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLike(String value) {
            addCriterion("target_id like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotLike(String value) {
            addCriterion("target_id not like", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<String> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<String> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(String value1, String value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(String value1, String value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("data is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("data is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("data =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("data <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("data >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("data >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("data <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("data <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("data like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("data not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("data in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("data not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("data between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("data not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNull() {
            addCriterion("form_id is null");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNotNull() {
            addCriterion("form_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormIdEqualTo(String value) {
            addCriterion("form_id =", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotEqualTo(String value) {
            addCriterion("form_id <>", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThan(String value) {
            addCriterion("form_id >", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThanOrEqualTo(String value) {
            addCriterion("form_id >=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThan(String value) {
            addCriterion("form_id <", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThanOrEqualTo(String value) {
            addCriterion("form_id <=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLike(String value) {
            addCriterion("form_id like", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotLike(String value) {
            addCriterion("form_id not like", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdIn(List<String> values) {
            addCriterion("form_id in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotIn(List<String> values) {
            addCriterion("form_id not in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdBetween(String value1, String value2) {
            addCriterion("form_id between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotBetween(String value1, String value2) {
            addCriterion("form_id not between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFillIdIsNull() {
            addCriterion("fill_id is null");
            return (Criteria) this;
        }

        public Criteria andFillIdIsNotNull() {
            addCriterion("fill_id is not null");
            return (Criteria) this;
        }

        public Criteria andFillIdEqualTo(String value) {
            addCriterion("fill_id =", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotEqualTo(String value) {
            addCriterion("fill_id <>", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdGreaterThan(String value) {
            addCriterion("fill_id >", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdGreaterThanOrEqualTo(String value) {
            addCriterion("fill_id >=", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdLessThan(String value) {
            addCriterion("fill_id <", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdLessThanOrEqualTo(String value) {
            addCriterion("fill_id <=", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdLike(String value) {
            addCriterion("fill_id like", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotLike(String value) {
            addCriterion("fill_id not like", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdIn(List<String> values) {
            addCriterion("fill_id in", values, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotIn(List<String> values) {
            addCriterion("fill_id not in", values, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdBetween(String value1, String value2) {
            addCriterion("fill_id between", value1, value2, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotBetween(String value1, String value2) {
            addCriterion("fill_id not between", value1, value2, "fillId");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNull() {
            addCriterion("tab_id is null");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNotNull() {
            addCriterion("tab_id is not null");
            return (Criteria) this;
        }

        public Criteria andTabIdEqualTo(String value) {
            addCriterion("tab_id =", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotEqualTo(String value) {
            addCriterion("tab_id <>", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThan(String value) {
            addCriterion("tab_id >", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThanOrEqualTo(String value) {
            addCriterion("tab_id >=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThan(String value) {
            addCriterion("tab_id <", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThanOrEqualTo(String value) {
            addCriterion("tab_id <=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLike(String value) {
            addCriterion("tab_id like", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotLike(String value) {
            addCriterion("tab_id not like", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdIn(List<String> values) {
            addCriterion("tab_id in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotIn(List<String> values) {
            addCriterion("tab_id not in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdBetween(String value1, String value2) {
            addCriterion("tab_id between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotBetween(String value1, String value2) {
            addCriterion("tab_id not between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andRowNumIsNull() {
            addCriterion("row_num is null");
            return (Criteria) this;
        }

        public Criteria andRowNumIsNotNull() {
            addCriterion("row_num is not null");
            return (Criteria) this;
        }

        public Criteria andRowNumEqualTo(Integer value) {
            addCriterion("row_num =", value, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumNotEqualTo(Integer value) {
            addCriterion("row_num <>", value, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumGreaterThan(Integer value) {
            addCriterion("row_num >", value, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("row_num >=", value, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumLessThan(Integer value) {
            addCriterion("row_num <", value, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumLessThanOrEqualTo(Integer value) {
            addCriterion("row_num <=", value, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumIn(List<Integer> values) {
            addCriterion("row_num in", values, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumNotIn(List<Integer> values) {
            addCriterion("row_num not in", values, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumBetween(Integer value1, Integer value2) {
            addCriterion("row_num between", value1, value2, "rowNum");
            return (Criteria) this;
        }

        public Criteria andRowNumNotBetween(Integer value1, Integer value2) {
            addCriterion("row_num not between", value1, value2, "rowNum");
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