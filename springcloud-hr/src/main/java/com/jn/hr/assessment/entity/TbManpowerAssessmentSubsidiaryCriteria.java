package com.jn.hr.assessment.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerAssessmentSubsidiaryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAssessmentSubsidiaryCriteria() {
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

        public Criteria andAssessmentIdIsNull() {
            addCriterion("assessment_id is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdIsNotNull() {
            addCriterion("assessment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdEqualTo(String value) {
            addCriterion("assessment_id =", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotEqualTo(String value) {
            addCriterion("assessment_id <>", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdGreaterThan(String value) {
            addCriterion("assessment_id >", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_id >=", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdLessThan(String value) {
            addCriterion("assessment_id <", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdLessThanOrEqualTo(String value) {
            addCriterion("assessment_id <=", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdLike(String value) {
            addCriterion("assessment_id like", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotLike(String value) {
            addCriterion("assessment_id not like", value, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdIn(List<String> values) {
            addCriterion("assessment_id in", values, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotIn(List<String> values) {
            addCriterion("assessment_id not in", values, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdBetween(String value1, String value2) {
            addCriterion("assessment_id between", value1, value2, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andAssessmentIdNotBetween(String value1, String value2) {
            addCriterion("assessment_id not between", value1, value2, "assessmentId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentIsNull() {
            addCriterion("assessment_department is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentIsNotNull() {
            addCriterion("assessment_department is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentEqualTo(String value) {
            addCriterion("assessment_department =", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentNotEqualTo(String value) {
            addCriterion("assessment_department <>", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentGreaterThan(String value) {
            addCriterion("assessment_department >", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_department >=", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentLessThan(String value) {
            addCriterion("assessment_department <", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentLessThanOrEqualTo(String value) {
            addCriterion("assessment_department <=", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentLike(String value) {
            addCriterion("assessment_department like", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentNotLike(String value) {
            addCriterion("assessment_department not like", value, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentIn(List<String> values) {
            addCriterion("assessment_department in", values, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentNotIn(List<String> values) {
            addCriterion("assessment_department not in", values, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentBetween(String value1, String value2) {
            addCriterion("assessment_department between", value1, value2, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentDepartmentNotBetween(String value1, String value2) {
            addCriterion("assessment_department not between", value1, value2, "assessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameIsNull() {
            addCriterion("assessment_name is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameIsNotNull() {
            addCriterion("assessment_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameEqualTo(String value) {
            addCriterion("assessment_name =", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameNotEqualTo(String value) {
            addCriterion("assessment_name <>", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameGreaterThan(String value) {
            addCriterion("assessment_name >", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_name >=", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameLessThan(String value) {
            addCriterion("assessment_name <", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameLessThanOrEqualTo(String value) {
            addCriterion("assessment_name <=", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameLike(String value) {
            addCriterion("assessment_name like", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameNotLike(String value) {
            addCriterion("assessment_name not like", value, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameIn(List<String> values) {
            addCriterion("assessment_name in", values, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameNotIn(List<String> values) {
            addCriterion("assessment_name not in", values, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameBetween(String value1, String value2) {
            addCriterion("assessment_name between", value1, value2, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andAssessmentNameNotBetween(String value1, String value2) {
            addCriterion("assessment_name not between", value1, value2, "assessmentName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusIsNull() {
            addCriterion("assessment_status is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusIsNotNull() {
            addCriterion("assessment_status is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusEqualTo(Byte value) {
            addCriterion("assessment_status =", value, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusNotEqualTo(Byte value) {
            addCriterion("assessment_status <>", value, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusGreaterThan(Byte value) {
            addCriterion("assessment_status >", value, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("assessment_status >=", value, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusLessThan(Byte value) {
            addCriterion("assessment_status <", value, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("assessment_status <=", value, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusIn(List<Byte> values) {
            addCriterion("assessment_status in", values, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusNotIn(List<Byte> values) {
            addCriterion("assessment_status not in", values, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusBetween(Byte value1, Byte value2) {
            addCriterion("assessment_status between", value1, value2, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("assessment_status not between", value1, value2, "assessmentStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberIsNull() {
            addCriterion("assessment_job_number is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberIsNotNull() {
            addCriterion("assessment_job_number is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberEqualTo(String value) {
            addCriterion("assessment_job_number =", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberNotEqualTo(String value) {
            addCriterion("assessment_job_number <>", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberGreaterThan(String value) {
            addCriterion("assessment_job_number >", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_job_number >=", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberLessThan(String value) {
            addCriterion("assessment_job_number <", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberLessThanOrEqualTo(String value) {
            addCriterion("assessment_job_number <=", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberLike(String value) {
            addCriterion("assessment_job_number like", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberNotLike(String value) {
            addCriterion("assessment_job_number not like", value, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberIn(List<String> values) {
            addCriterion("assessment_job_number in", values, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberNotIn(List<String> values) {
            addCriterion("assessment_job_number not in", values, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberBetween(String value1, String value2) {
            addCriterion("assessment_job_number between", value1, value2, "assessmentJobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentJobNumberNotBetween(String value1, String value2) {
            addCriterion("assessment_job_number not between", value1, value2, "assessmentJobNumber");
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