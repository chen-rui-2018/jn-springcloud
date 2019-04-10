package com.jn.enterprise.data.entity;

import java.util.ArrayList;
import java.util.List;

public class TbDataReportingSnapshotModelTabCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataReportingSnapshotModelTabCriteria() {
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

        public Criteria andTaskBatchIsNull() {
            addCriterion("task_batch is null");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIsNotNull() {
            addCriterion("task_batch is not null");
            return (Criteria) this;
        }

        public Criteria andTaskBatchEqualTo(String value) {
            addCriterion("task_batch =", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotEqualTo(String value) {
            addCriterion("task_batch <>", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchGreaterThan(String value) {
            addCriterion("task_batch >", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchGreaterThanOrEqualTo(String value) {
            addCriterion("task_batch >=", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLessThan(String value) {
            addCriterion("task_batch <", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLessThanOrEqualTo(String value) {
            addCriterion("task_batch <=", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLike(String value) {
            addCriterion("task_batch like", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotLike(String value) {
            addCriterion("task_batch not like", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIn(List<String> values) {
            addCriterion("task_batch in", values, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotIn(List<String> values) {
            addCriterion("task_batch not in", values, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchBetween(String value1, String value2) {
            addCriterion("task_batch between", value1, value2, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotBetween(String value1, String value2) {
            addCriterion("task_batch not between", value1, value2, "taskBatch");
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

        public Criteria andOrderIsNull() {
            addCriterion("order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(String value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(String value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(String value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(String value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(String value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(String value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLike(String value) {
            addCriterion("order like", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotLike(String value) {
            addCriterion("order not like", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<String> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<String> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(String value1, String value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(String value1, String value2) {
            addCriterion("order not between", value1, value2, "order");
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