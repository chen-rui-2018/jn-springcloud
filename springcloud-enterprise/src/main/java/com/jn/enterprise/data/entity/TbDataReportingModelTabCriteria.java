package com.jn.enterprise.data.entity;

import java.util.ArrayList;
import java.util.List;

public class TbDataReportingModelTabCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataReportingModelTabCriteria() {
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

        public Criteria andTabNameIsNull() {
            addCriterion("tab_name is null");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNotNull() {
            addCriterion("tab_name is not null");
            return (Criteria) this;
        }

        public Criteria andTabNameEqualTo(String value) {
            addCriterion("tab_name =", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotEqualTo(String value) {
            addCriterion("tab_name <>", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThan(String value) {
            addCriterion("tab_name >", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThanOrEqualTo(String value) {
            addCriterion("tab_name >=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThan(String value) {
            addCriterion("tab_name <", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThanOrEqualTo(String value) {
            addCriterion("tab_name <=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLike(String value) {
            addCriterion("tab_name like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotLike(String value) {
            addCriterion("tab_name not like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameIn(List<String> values) {
            addCriterion("tab_name in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotIn(List<String> values) {
            addCriterion("tab_name not in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameBetween(String value1, String value2) {
            addCriterion("tab_name between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotBetween(String value1, String value2) {
            addCriterion("tab_name not between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowIsNull() {
            addCriterion("tab_clumn_target_show is null");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowIsNotNull() {
            addCriterion("tab_clumn_target_show is not null");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowEqualTo(String value) {
            addCriterion("tab_clumn_target_show =", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowNotEqualTo(String value) {
            addCriterion("tab_clumn_target_show <>", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowGreaterThan(String value) {
            addCriterion("tab_clumn_target_show >", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowGreaterThanOrEqualTo(String value) {
            addCriterion("tab_clumn_target_show >=", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowLessThan(String value) {
            addCriterion("tab_clumn_target_show <", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowLessThanOrEqualTo(String value) {
            addCriterion("tab_clumn_target_show <=", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowLike(String value) {
            addCriterion("tab_clumn_target_show like", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowNotLike(String value) {
            addCriterion("tab_clumn_target_show not like", value, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowIn(List<String> values) {
            addCriterion("tab_clumn_target_show in", values, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowNotIn(List<String> values) {
            addCriterion("tab_clumn_target_show not in", values, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowBetween(String value1, String value2) {
            addCriterion("tab_clumn_target_show between", value1, value2, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTargetShowNotBetween(String value1, String value2) {
            addCriterion("tab_clumn_target_show not between", value1, value2, "tabClumnTargetShow");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeIsNull() {
            addCriterion("tab_clumn_type is null");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeIsNotNull() {
            addCriterion("tab_clumn_type is not null");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeEqualTo(Byte value) {
            addCriterion("tab_clumn_type =", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeNotEqualTo(Byte value) {
            addCriterion("tab_clumn_type <>", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeGreaterThan(Byte value) {
            addCriterion("tab_clumn_type >", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tab_clumn_type >=", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeLessThan(Byte value) {
            addCriterion("tab_clumn_type <", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeLessThanOrEqualTo(Byte value) {
            addCriterion("tab_clumn_type <=", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeIn(List<Byte> values) {
            addCriterion("tab_clumn_type in", values, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeNotIn(List<Byte> values) {
            addCriterion("tab_clumn_type not in", values, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeBetween(Byte value1, Byte value2) {
            addCriterion("tab_clumn_type between", value1, value2, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tab_clumn_type not between", value1, value2, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeIsNull() {
            addCriterion("tab_create_type is null");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeIsNotNull() {
            addCriterion("tab_create_type is not null");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeEqualTo(Byte value) {
            addCriterion("tab_create_type =", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeNotEqualTo(Byte value) {
            addCriterion("tab_create_type <>", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeGreaterThan(Byte value) {
            addCriterion("tab_create_type >", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tab_create_type >=", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeLessThan(Byte value) {
            addCriterion("tab_create_type <", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("tab_create_type <=", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeIn(List<Byte> values) {
            addCriterion("tab_create_type in", values, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeNotIn(List<Byte> values) {
            addCriterion("tab_create_type not in", values, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeBetween(Byte value1, Byte value2) {
            addCriterion("tab_create_type between", value1, value2, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tab_create_type not between", value1, value2, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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