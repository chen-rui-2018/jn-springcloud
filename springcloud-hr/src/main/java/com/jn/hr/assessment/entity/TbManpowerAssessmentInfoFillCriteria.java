package com.jn.hr.assessment.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerAssessmentInfoFillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAssessmentInfoFillCriteria() {
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

        public Criteria andTemplateDetailIdIsNull() {
            addCriterion("template_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdIsNotNull() {
            addCriterion("template_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdEqualTo(String value) {
            addCriterion("template_detail_id =", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdNotEqualTo(String value) {
            addCriterion("template_detail_id <>", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdGreaterThan(String value) {
            addCriterion("template_detail_id >", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_detail_id >=", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdLessThan(String value) {
            addCriterion("template_detail_id <", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdLessThanOrEqualTo(String value) {
            addCriterion("template_detail_id <=", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdLike(String value) {
            addCriterion("template_detail_id like", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdNotLike(String value) {
            addCriterion("template_detail_id not like", value, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdIn(List<String> values) {
            addCriterion("template_detail_id in", values, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdNotIn(List<String> values) {
            addCriterion("template_detail_id not in", values, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdBetween(String value1, String value2) {
            addCriterion("template_detail_id between", value1, value2, "templateDetailId");
            return (Criteria) this;
        }

        public Criteria andTemplateDetailIdNotBetween(String value1, String value2) {
            addCriterion("template_detail_id not between", value1, value2, "templateDetailId");
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

        public Criteria andJobNumberIsNull() {
            addCriterion("job_number is null");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNotNull() {
            addCriterion("job_number is not null");
            return (Criteria) this;
        }

        public Criteria andJobNumberEqualTo(String value) {
            addCriterion("job_number =", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotEqualTo(String value) {
            addCriterion("job_number <>", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThan(String value) {
            addCriterion("job_number >", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThanOrEqualTo(String value) {
            addCriterion("job_number >=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThan(String value) {
            addCriterion("job_number <", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThanOrEqualTo(String value) {
            addCriterion("job_number <=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLike(String value) {
            addCriterion("job_number like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotLike(String value) {
            addCriterion("job_number not like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberIn(List<String> values) {
            addCriterion("job_number in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotIn(List<String> values) {
            addCriterion("job_number not in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberBetween(String value1, String value2) {
            addCriterion("job_number between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotBetween(String value1, String value2) {
            addCriterion("job_number not between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreIsNull() {
            addCriterion("assessment_score is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreIsNotNull() {
            addCriterion("assessment_score is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreEqualTo(Integer value) {
            addCriterion("assessment_score =", value, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreNotEqualTo(Integer value) {
            addCriterion("assessment_score <>", value, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreGreaterThan(Integer value) {
            addCriterion("assessment_score >", value, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("assessment_score >=", value, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreLessThan(Integer value) {
            addCriterion("assessment_score <", value, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreLessThanOrEqualTo(Integer value) {
            addCriterion("assessment_score <=", value, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreIn(List<Integer> values) {
            addCriterion("assessment_score in", values, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreNotIn(List<Integer> values) {
            addCriterion("assessment_score not in", values, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreBetween(Integer value1, Integer value2) {
            addCriterion("assessment_score between", value1, value2, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andAssessmentScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("assessment_score not between", value1, value2, "assessmentScore");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionIsNull() {
            addCriterion("cause_deduction is null");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionIsNotNull() {
            addCriterion("cause_deduction is not null");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionEqualTo(String value) {
            addCriterion("cause_deduction =", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionNotEqualTo(String value) {
            addCriterion("cause_deduction <>", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionGreaterThan(String value) {
            addCriterion("cause_deduction >", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionGreaterThanOrEqualTo(String value) {
            addCriterion("cause_deduction >=", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionLessThan(String value) {
            addCriterion("cause_deduction <", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionLessThanOrEqualTo(String value) {
            addCriterion("cause_deduction <=", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionLike(String value) {
            addCriterion("cause_deduction like", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionNotLike(String value) {
            addCriterion("cause_deduction not like", value, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionIn(List<String> values) {
            addCriterion("cause_deduction in", values, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionNotIn(List<String> values) {
            addCriterion("cause_deduction not in", values, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionBetween(String value1, String value2) {
            addCriterion("cause_deduction between", value1, value2, "causeDeduction");
            return (Criteria) this;
        }

        public Criteria andCauseDeductionNotBetween(String value1, String value2) {
            addCriterion("cause_deduction not between", value1, value2, "causeDeduction");
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