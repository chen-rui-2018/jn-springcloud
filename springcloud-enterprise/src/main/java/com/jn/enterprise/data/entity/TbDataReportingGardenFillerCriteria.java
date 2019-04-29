package com.jn.enterprise.data.entity;

import java.util.ArrayList;
import java.util.List;

public class TbDataReportingGardenFillerCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataReportingGardenFillerCriteria() {
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

        public Criteria andFillerIsNull() {
            addCriterion("filler is null");
            return (Criteria) this;
        }

        public Criteria andFillerIsNotNull() {
            addCriterion("filler is not null");
            return (Criteria) this;
        }

        public Criteria andFillerEqualTo(String value) {
            addCriterion("filler =", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotEqualTo(String value) {
            addCriterion("filler <>", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThan(String value) {
            addCriterion("filler >", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThanOrEqualTo(String value) {
            addCriterion("filler >=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThan(String value) {
            addCriterion("filler <", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThanOrEqualTo(String value) {
            addCriterion("filler <=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLike(String value) {
            addCriterion("filler like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotLike(String value) {
            addCriterion("filler not like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerIn(List<String> values) {
            addCriterion("filler in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotIn(List<String> values) {
            addCriterion("filler not in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerBetween(String value1, String value2) {
            addCriterion("filler between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotBetween(String value1, String value2) {
            addCriterion("filler not between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerTelIsNull() {
            addCriterion("filler_tel is null");
            return (Criteria) this;
        }

        public Criteria andFillerTelIsNotNull() {
            addCriterion("filler_tel is not null");
            return (Criteria) this;
        }

        public Criteria andFillerTelEqualTo(String value) {
            addCriterion("filler_tel =", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotEqualTo(String value) {
            addCriterion("filler_tel <>", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelGreaterThan(String value) {
            addCriterion("filler_tel >", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelGreaterThanOrEqualTo(String value) {
            addCriterion("filler_tel >=", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelLessThan(String value) {
            addCriterion("filler_tel <", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelLessThanOrEqualTo(String value) {
            addCriterion("filler_tel <=", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelLike(String value) {
            addCriterion("filler_tel like", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotLike(String value) {
            addCriterion("filler_tel not like", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelIn(List<String> values) {
            addCriterion("filler_tel in", values, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotIn(List<String> values) {
            addCriterion("filler_tel not in", values, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelBetween(String value1, String value2) {
            addCriterion("filler_tel between", value1, value2, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotBetween(String value1, String value2) {
            addCriterion("filler_tel not between", value1, value2, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
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

        public Criteria andRecordStatusIsNull() {
            addCriterion("record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsIsNull() {
            addCriterion("garden_examine_stauts is null");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsIsNotNull() {
            addCriterion("garden_examine_stauts is not null");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsEqualTo(Byte value) {
            addCriterion("garden_examine_stauts =", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsNotEqualTo(Byte value) {
            addCriterion("garden_examine_stauts <>", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsGreaterThan(Byte value) {
            addCriterion("garden_examine_stauts >", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsGreaterThanOrEqualTo(Byte value) {
            addCriterion("garden_examine_stauts >=", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsLessThan(Byte value) {
            addCriterion("garden_examine_stauts <", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsLessThanOrEqualTo(Byte value) {
            addCriterion("garden_examine_stauts <=", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsIn(List<Byte> values) {
            addCriterion("garden_examine_stauts in", values, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsNotIn(List<Byte> values) {
            addCriterion("garden_examine_stauts not in", values, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsBetween(Byte value1, Byte value2) {
            addCriterion("garden_examine_stauts between", value1, value2, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsNotBetween(Byte value1, Byte value2) {
            addCriterion("garden_examine_stauts not between", value1, value2, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andExamineCommentIsNull() {
            addCriterion("examine_comment is null");
            return (Criteria) this;
        }

        public Criteria andExamineCommentIsNotNull() {
            addCriterion("examine_comment is not null");
            return (Criteria) this;
        }

        public Criteria andExamineCommentEqualTo(String value) {
            addCriterion("examine_comment =", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotEqualTo(String value) {
            addCriterion("examine_comment <>", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentGreaterThan(String value) {
            addCriterion("examine_comment >", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentGreaterThanOrEqualTo(String value) {
            addCriterion("examine_comment >=", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentLessThan(String value) {
            addCriterion("examine_comment <", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentLessThanOrEqualTo(String value) {
            addCriterion("examine_comment <=", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentLike(String value) {
            addCriterion("examine_comment like", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotLike(String value) {
            addCriterion("examine_comment not like", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentIn(List<String> values) {
            addCriterion("examine_comment in", values, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotIn(List<String> values) {
            addCriterion("examine_comment not in", values, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentBetween(String value1, String value2) {
            addCriterion("examine_comment between", value1, value2, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotBetween(String value1, String value2) {
            addCriterion("examine_comment not between", value1, value2, "examineComment");
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