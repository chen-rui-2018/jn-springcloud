package com.jn.hr.assessment.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerAssessmentManageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAssessmentManageCriteria() {
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

        public Criteria andAssessmentStartTimeIsNull() {
            addCriterion("assessment_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeIsNotNull() {
            addCriterion("assessment_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeEqualTo(Date value) {
            addCriterion("assessment_start_time =", value, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeNotEqualTo(Date value) {
            addCriterion("assessment_start_time <>", value, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeGreaterThan(Date value) {
            addCriterion("assessment_start_time >", value, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("assessment_start_time >=", value, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeLessThan(Date value) {
            addCriterion("assessment_start_time <", value, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("assessment_start_time <=", value, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeIn(List<Date> values) {
            addCriterion("assessment_start_time in", values, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeNotIn(List<Date> values) {
            addCriterion("assessment_start_time not in", values, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeBetween(Date value1, Date value2) {
            addCriterion("assessment_start_time between", value1, value2, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("assessment_start_time not between", value1, value2, "assessmentStartTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeIsNull() {
            addCriterion("assessment_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeIsNotNull() {
            addCriterion("assessment_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeEqualTo(Date value) {
            addCriterion("assessment_end_time =", value, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeNotEqualTo(Date value) {
            addCriterion("assessment_end_time <>", value, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeGreaterThan(Date value) {
            addCriterion("assessment_end_time >", value, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("assessment_end_time >=", value, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeLessThan(Date value) {
            addCriterion("assessment_end_time <", value, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("assessment_end_time <=", value, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeIn(List<Date> values) {
            addCriterion("assessment_end_time in", values, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeNotIn(List<Date> values) {
            addCriterion("assessment_end_time not in", values, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeBetween(Date value1, Date value2) {
            addCriterion("assessment_end_time between", value1, value2, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("assessment_end_time not between", value1, value2, "assessmentEndTime");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectIsNull() {
            addCriterion("assessment_object is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectIsNotNull() {
            addCriterion("assessment_object is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectEqualTo(String value) {
            addCriterion("assessment_object =", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectNotEqualTo(String value) {
            addCriterion("assessment_object <>", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectGreaterThan(String value) {
            addCriterion("assessment_object >", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_object >=", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectLessThan(String value) {
            addCriterion("assessment_object <", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectLessThanOrEqualTo(String value) {
            addCriterion("assessment_object <=", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectLike(String value) {
            addCriterion("assessment_object like", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectNotLike(String value) {
            addCriterion("assessment_object not like", value, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectIn(List<String> values) {
            addCriterion("assessment_object in", values, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectNotIn(List<String> values) {
            addCriterion("assessment_object not in", values, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectBetween(String value1, String value2) {
            addCriterion("assessment_object between", value1, value2, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentObjectNotBetween(String value1, String value2) {
            addCriterion("assessment_object not between", value1, value2, "assessmentObject");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleIsNull() {
            addCriterion("assessment_people is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleIsNotNull() {
            addCriterion("assessment_people is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleEqualTo(String value) {
            addCriterion("assessment_people =", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleNotEqualTo(String value) {
            addCriterion("assessment_people <>", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleGreaterThan(String value) {
            addCriterion("assessment_people >", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("assessment_people >=", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleLessThan(String value) {
            addCriterion("assessment_people <", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleLessThanOrEqualTo(String value) {
            addCriterion("assessment_people <=", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleLike(String value) {
            addCriterion("assessment_people like", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleNotLike(String value) {
            addCriterion("assessment_people not like", value, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleIn(List<String> values) {
            addCriterion("assessment_people in", values, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleNotIn(List<String> values) {
            addCriterion("assessment_people not in", values, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleBetween(String value1, String value2) {
            addCriterion("assessment_people between", value1, value2, "assessmentPeople");
            return (Criteria) this;
        }

        public Criteria andAssessmentPeopleNotBetween(String value1, String value2) {
            addCriterion("assessment_people not between", value1, value2, "assessmentPeople");
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

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template_name like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template_name not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
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

        public Criteria andCreatorAccountIsNull() {
            addCriterion("creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
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