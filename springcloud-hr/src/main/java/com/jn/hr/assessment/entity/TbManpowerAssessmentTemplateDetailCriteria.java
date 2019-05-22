package com.jn.hr.assessment.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerAssessmentTemplateDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAssessmentTemplateDetailCriteria() {
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

        public Criteria andTargetCategoryIsNull() {
            addCriterion("target_category is null");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryIsNotNull() {
            addCriterion("target_category is not null");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryEqualTo(String value) {
            addCriterion("target_category =", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryNotEqualTo(String value) {
            addCriterion("target_category <>", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryGreaterThan(String value) {
            addCriterion("target_category >", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("target_category >=", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryLessThan(String value) {
            addCriterion("target_category <", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryLessThanOrEqualTo(String value) {
            addCriterion("target_category <=", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryLike(String value) {
            addCriterion("target_category like", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryNotLike(String value) {
            addCriterion("target_category not like", value, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryIn(List<String> values) {
            addCriterion("target_category in", values, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryNotIn(List<String> values) {
            addCriterion("target_category not in", values, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryBetween(String value1, String value2) {
            addCriterion("target_category between", value1, value2, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andTargetCategoryNotBetween(String value1, String value2) {
            addCriterion("target_category not between", value1, value2, "targetCategory");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(Integer value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(Integer value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(Integer value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(Integer value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<Integer> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<Integer> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetIsNull() {
            addCriterion("assessment_target is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetIsNotNull() {
            addCriterion("assessment_target is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetEqualTo(String value) {
            addCriterion("assessment_target =", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetNotEqualTo(String value) {
            addCriterion("assessment_target <>", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetGreaterThan(String value) {
            addCriterion("assessment_target >", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_target >=", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetLessThan(String value) {
            addCriterion("assessment_target <", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetLessThanOrEqualTo(String value) {
            addCriterion("assessment_target <=", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetLike(String value) {
            addCriterion("assessment_target like", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetNotLike(String value) {
            addCriterion("assessment_target not like", value, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetIn(List<String> values) {
            addCriterion("assessment_target in", values, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetNotIn(List<String> values) {
            addCriterion("assessment_target not in", values, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetBetween(String value1, String value2) {
            addCriterion("assessment_target between", value1, value2, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andAssessmentTargetNotBetween(String value1, String value2) {
            addCriterion("assessment_target not between", value1, value2, "assessmentTarget");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreRubricIsNull() {
            addCriterion("score_rubric is null");
            return (Criteria) this;
        }

        public Criteria andScoreRubricIsNotNull() {
            addCriterion("score_rubric is not null");
            return (Criteria) this;
        }

        public Criteria andScoreRubricEqualTo(String value) {
            addCriterion("score_rubric =", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricNotEqualTo(String value) {
            addCriterion("score_rubric <>", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricGreaterThan(String value) {
            addCriterion("score_rubric >", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricGreaterThanOrEqualTo(String value) {
            addCriterion("score_rubric >=", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricLessThan(String value) {
            addCriterion("score_rubric <", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricLessThanOrEqualTo(String value) {
            addCriterion("score_rubric <=", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricLike(String value) {
            addCriterion("score_rubric like", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricNotLike(String value) {
            addCriterion("score_rubric not like", value, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricIn(List<String> values) {
            addCriterion("score_rubric in", values, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricNotIn(List<String> values) {
            addCriterion("score_rubric not in", values, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricBetween(String value1, String value2) {
            addCriterion("score_rubric between", value1, value2, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andScoreRubricNotBetween(String value1, String value2) {
            addCriterion("score_rubric not between", value1, value2, "scoreRubric");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentIsNull() {
            addCriterion("lead_assessment_department is null");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentIsNotNull() {
            addCriterion("lead_assessment_department is not null");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentEqualTo(String value) {
            addCriterion("lead_assessment_department =", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentNotEqualTo(String value) {
            addCriterion("lead_assessment_department <>", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentGreaterThan(String value) {
            addCriterion("lead_assessment_department >", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("lead_assessment_department >=", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentLessThan(String value) {
            addCriterion("lead_assessment_department <", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentLessThanOrEqualTo(String value) {
            addCriterion("lead_assessment_department <=", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentLike(String value) {
            addCriterion("lead_assessment_department like", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentNotLike(String value) {
            addCriterion("lead_assessment_department not like", value, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentIn(List<String> values) {
            addCriterion("lead_assessment_department in", values, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentNotIn(List<String> values) {
            addCriterion("lead_assessment_department not in", values, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentBetween(String value1, String value2) {
            addCriterion("lead_assessment_department between", value1, value2, "leadAssessmentDepartment");
            return (Criteria) this;
        }

        public Criteria andLeadAssessmentDepartmentNotBetween(String value1, String value2) {
            addCriterion("lead_assessment_department not between", value1, value2, "leadAssessmentDepartment");
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