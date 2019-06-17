package com.jn.park.attractinvest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProjectInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProjectInfoCriteria() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andIntroducerIsNull() {
            addCriterion("introducer is null");
            return (Criteria) this;
        }

        public Criteria andIntroducerIsNotNull() {
            addCriterion("introducer is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducerEqualTo(String value) {
            addCriterion("introducer =", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotEqualTo(String value) {
            addCriterion("introducer <>", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerGreaterThan(String value) {
            addCriterion("introducer >", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerGreaterThanOrEqualTo(String value) {
            addCriterion("introducer >=", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerLessThan(String value) {
            addCriterion("introducer <", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerLessThanOrEqualTo(String value) {
            addCriterion("introducer <=", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerLike(String value) {
            addCriterion("introducer like", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotLike(String value) {
            addCriterion("introducer not like", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerIn(List<String> values) {
            addCriterion("introducer in", values, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotIn(List<String> values) {
            addCriterion("introducer not in", values, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerBetween(String value1, String value2) {
            addCriterion("introducer between", value1, value2, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotBetween(String value1, String value2) {
            addCriterion("introducer not between", value1, value2, "introducer");
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

        public Criteria andIndustryAssessmentIsNull() {
            addCriterion("industry_assessment is null");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentIsNotNull() {
            addCriterion("industry_assessment is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentEqualTo(String value) {
            addCriterion("industry_assessment =", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentNotEqualTo(String value) {
            addCriterion("industry_assessment <>", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentGreaterThan(String value) {
            addCriterion("industry_assessment >", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentGreaterThanOrEqualTo(String value) {
            addCriterion("industry_assessment >=", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentLessThan(String value) {
            addCriterion("industry_assessment <", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentLessThanOrEqualTo(String value) {
            addCriterion("industry_assessment <=", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentLike(String value) {
            addCriterion("industry_assessment like", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentNotLike(String value) {
            addCriterion("industry_assessment not like", value, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentIn(List<String> values) {
            addCriterion("industry_assessment in", values, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentNotIn(List<String> values) {
            addCriterion("industry_assessment not in", values, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentBetween(String value1, String value2) {
            addCriterion("industry_assessment between", value1, value2, "industryAssessment");
            return (Criteria) this;
        }

        public Criteria andIndustryAssessmentNotBetween(String value1, String value2) {
            addCriterion("industry_assessment not between", value1, value2, "industryAssessment");
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

        public Criteria andProjectProcessIsNull() {
            addCriterion("project_process is null");
            return (Criteria) this;
        }

        public Criteria andProjectProcessIsNotNull() {
            addCriterion("project_process is not null");
            return (Criteria) this;
        }

        public Criteria andProjectProcessEqualTo(String value) {
            addCriterion("project_process =", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessNotEqualTo(String value) {
            addCriterion("project_process <>", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessGreaterThan(String value) {
            addCriterion("project_process >", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessGreaterThanOrEqualTo(String value) {
            addCriterion("project_process >=", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessLessThan(String value) {
            addCriterion("project_process <", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessLessThanOrEqualTo(String value) {
            addCriterion("project_process <=", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessLike(String value) {
            addCriterion("project_process like", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessNotLike(String value) {
            addCriterion("project_process not like", value, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessIn(List<String> values) {
            addCriterion("project_process in", values, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessNotIn(List<String> values) {
            addCriterion("project_process not in", values, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessBetween(String value1, String value2) {
            addCriterion("project_process between", value1, value2, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andProjectProcessNotBetween(String value1, String value2) {
            addCriterion("project_process not between", value1, value2, "projectProcess");
            return (Criteria) this;
        }

        public Criteria andCompactStatusIsNull() {
            addCriterion("compact_status is null");
            return (Criteria) this;
        }

        public Criteria andCompactStatusIsNotNull() {
            addCriterion("compact_status is not null");
            return (Criteria) this;
        }

        public Criteria andCompactStatusEqualTo(String value) {
            addCriterion("compact_status =", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusNotEqualTo(String value) {
            addCriterion("compact_status <>", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusGreaterThan(String value) {
            addCriterion("compact_status >", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusGreaterThanOrEqualTo(String value) {
            addCriterion("compact_status >=", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusLessThan(String value) {
            addCriterion("compact_status <", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusLessThanOrEqualTo(String value) {
            addCriterion("compact_status <=", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusLike(String value) {
            addCriterion("compact_status like", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusNotLike(String value) {
            addCriterion("compact_status not like", value, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusIn(List<String> values) {
            addCriterion("compact_status in", values, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusNotIn(List<String> values) {
            addCriterion("compact_status not in", values, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusBetween(String value1, String value2) {
            addCriterion("compact_status between", value1, value2, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStatusNotBetween(String value1, String value2) {
            addCriterion("compact_status not between", value1, value2, "compactStatus");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeIsNull() {
            addCriterion("compact_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeIsNotNull() {
            addCriterion("compact_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeEqualTo(Date value) {
            addCriterion("compact_start_time =", value, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeNotEqualTo(Date value) {
            addCriterion("compact_start_time <>", value, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeGreaterThan(Date value) {
            addCriterion("compact_start_time >", value, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("compact_start_time >=", value, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeLessThan(Date value) {
            addCriterion("compact_start_time <", value, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("compact_start_time <=", value, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeIn(List<Date> values) {
            addCriterion("compact_start_time in", values, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeNotIn(List<Date> values) {
            addCriterion("compact_start_time not in", values, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeBetween(Date value1, Date value2) {
            addCriterion("compact_start_time between", value1, value2, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("compact_start_time not between", value1, value2, "compactStartTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeIsNull() {
            addCriterion("compact_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeIsNotNull() {
            addCriterion("compact_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeEqualTo(Date value) {
            addCriterion("compact_end_time =", value, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeNotEqualTo(Date value) {
            addCriterion("compact_end_time <>", value, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeGreaterThan(Date value) {
            addCriterion("compact_end_time >", value, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("compact_end_time >=", value, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeLessThan(Date value) {
            addCriterion("compact_end_time <", value, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("compact_end_time <=", value, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeIn(List<Date> values) {
            addCriterion("compact_end_time in", values, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeNotIn(List<Date> values) {
            addCriterion("compact_end_time not in", values, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeBetween(Date value1, Date value2) {
            addCriterion("compact_end_time between", value1, value2, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andCompactEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("compact_end_time not between", value1, value2, "compactEndTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverIsNull() {
            addCriterion("Investment_approver is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverIsNotNull() {
            addCriterion("Investment_approver is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverEqualTo(String value) {
            addCriterion("Investment_approver =", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverNotEqualTo(String value) {
            addCriterion("Investment_approver <>", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverGreaterThan(String value) {
            addCriterion("Investment_approver >", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverGreaterThanOrEqualTo(String value) {
            addCriterion("Investment_approver >=", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverLessThan(String value) {
            addCriterion("Investment_approver <", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverLessThanOrEqualTo(String value) {
            addCriterion("Investment_approver <=", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverLike(String value) {
            addCriterion("Investment_approver like", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverNotLike(String value) {
            addCriterion("Investment_approver not like", value, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverIn(List<String> values) {
            addCriterion("Investment_approver in", values, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverNotIn(List<String> values) {
            addCriterion("Investment_approver not in", values, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverBetween(String value1, String value2) {
            addCriterion("Investment_approver between", value1, value2, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverNotBetween(String value1, String value2) {
            addCriterion("Investment_approver not between", value1, value2, "investmentApprover");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeIsNull() {
            addCriterion("Investment_approver_time is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeIsNotNull() {
            addCriterion("Investment_approver_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeEqualTo(Date value) {
            addCriterion("Investment_approver_time =", value, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeNotEqualTo(Date value) {
            addCriterion("Investment_approver_time <>", value, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeGreaterThan(Date value) {
            addCriterion("Investment_approver_time >", value, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Investment_approver_time >=", value, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeLessThan(Date value) {
            addCriterion("Investment_approver_time <", value, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeLessThanOrEqualTo(Date value) {
            addCriterion("Investment_approver_time <=", value, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeIn(List<Date> values) {
            addCriterion("Investment_approver_time in", values, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeNotIn(List<Date> values) {
            addCriterion("Investment_approver_time not in", values, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeBetween(Date value1, Date value2) {
            addCriterion("Investment_approver_time between", value1, value2, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andInvestmentApproverTimeNotBetween(Date value1, Date value2) {
            addCriterion("Investment_approver_time not between", value1, value2, "investmentApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverIsNull() {
            addCriterion("property_approver is null");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverIsNotNull() {
            addCriterion("property_approver is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverEqualTo(String value) {
            addCriterion("property_approver =", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverNotEqualTo(String value) {
            addCriterion("property_approver <>", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverGreaterThan(String value) {
            addCriterion("property_approver >", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverGreaterThanOrEqualTo(String value) {
            addCriterion("property_approver >=", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverLessThan(String value) {
            addCriterion("property_approver <", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverLessThanOrEqualTo(String value) {
            addCriterion("property_approver <=", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverLike(String value) {
            addCriterion("property_approver like", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverNotLike(String value) {
            addCriterion("property_approver not like", value, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverIn(List<String> values) {
            addCriterion("property_approver in", values, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverNotIn(List<String> values) {
            addCriterion("property_approver not in", values, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverBetween(String value1, String value2) {
            addCriterion("property_approver between", value1, value2, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverNotBetween(String value1, String value2) {
            addCriterion("property_approver not between", value1, value2, "propertyApprover");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeIsNull() {
            addCriterion("property_approver_time is null");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeIsNotNull() {
            addCriterion("property_approver_time is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeEqualTo(Date value) {
            addCriterion("property_approver_time =", value, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeNotEqualTo(Date value) {
            addCriterion("property_approver_time <>", value, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeGreaterThan(Date value) {
            addCriterion("property_approver_time >", value, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("property_approver_time >=", value, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeLessThan(Date value) {
            addCriterion("property_approver_time <", value, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeLessThanOrEqualTo(Date value) {
            addCriterion("property_approver_time <=", value, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeIn(List<Date> values) {
            addCriterion("property_approver_time in", values, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeNotIn(List<Date> values) {
            addCriterion("property_approver_time not in", values, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeBetween(Date value1, Date value2) {
            addCriterion("property_approver_time between", value1, value2, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPropertyApproverTimeNotBetween(Date value1, Date value2) {
            addCriterion("property_approver_time not between", value1, value2, "propertyApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverIsNull() {
            addCriterion("pm_approver is null");
            return (Criteria) this;
        }

        public Criteria andPmApproverIsNotNull() {
            addCriterion("pm_approver is not null");
            return (Criteria) this;
        }

        public Criteria andPmApproverEqualTo(String value) {
            addCriterion("pm_approver =", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverNotEqualTo(String value) {
            addCriterion("pm_approver <>", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverGreaterThan(String value) {
            addCriterion("pm_approver >", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverGreaterThanOrEqualTo(String value) {
            addCriterion("pm_approver >=", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverLessThan(String value) {
            addCriterion("pm_approver <", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverLessThanOrEqualTo(String value) {
            addCriterion("pm_approver <=", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverLike(String value) {
            addCriterion("pm_approver like", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverNotLike(String value) {
            addCriterion("pm_approver not like", value, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverIn(List<String> values) {
            addCriterion("pm_approver in", values, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverNotIn(List<String> values) {
            addCriterion("pm_approver not in", values, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverBetween(String value1, String value2) {
            addCriterion("pm_approver between", value1, value2, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverNotBetween(String value1, String value2) {
            addCriterion("pm_approver not between", value1, value2, "pmApprover");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeIsNull() {
            addCriterion("pm_approver_time is null");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeIsNotNull() {
            addCriterion("pm_approver_time is not null");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeEqualTo(Date value) {
            addCriterion("pm_approver_time =", value, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeNotEqualTo(Date value) {
            addCriterion("pm_approver_time <>", value, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeGreaterThan(Date value) {
            addCriterion("pm_approver_time >", value, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pm_approver_time >=", value, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeLessThan(Date value) {
            addCriterion("pm_approver_time <", value, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeLessThanOrEqualTo(Date value) {
            addCriterion("pm_approver_time <=", value, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeIn(List<Date> values) {
            addCriterion("pm_approver_time in", values, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeNotIn(List<Date> values) {
            addCriterion("pm_approver_time not in", values, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeBetween(Date value1, Date value2) {
            addCriterion("pm_approver_time between", value1, value2, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andPmApproverTimeNotBetween(Date value1, Date value2) {
            addCriterion("pm_approver_time not between", value1, value2, "pmApproverTime");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andRentInfoIsNull() {
            addCriterion("rent_info is null");
            return (Criteria) this;
        }

        public Criteria andRentInfoIsNotNull() {
            addCriterion("rent_info is not null");
            return (Criteria) this;
        }

        public Criteria andRentInfoEqualTo(String value) {
            addCriterion("rent_info =", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoNotEqualTo(String value) {
            addCriterion("rent_info <>", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoGreaterThan(String value) {
            addCriterion("rent_info >", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoGreaterThanOrEqualTo(String value) {
            addCriterion("rent_info >=", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoLessThan(String value) {
            addCriterion("rent_info <", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoLessThanOrEqualTo(String value) {
            addCriterion("rent_info <=", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoLike(String value) {
            addCriterion("rent_info like", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoNotLike(String value) {
            addCriterion("rent_info not like", value, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoIn(List<String> values) {
            addCriterion("rent_info in", values, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoNotIn(List<String> values) {
            addCriterion("rent_info not in", values, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoBetween(String value1, String value2) {
            addCriterion("rent_info between", value1, value2, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andRentInfoNotBetween(String value1, String value2) {
            addCriterion("rent_info not between", value1, value2, "rentInfo");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeIsNull() {
            addCriterion("expect_enter_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeIsNotNull() {
            addCriterion("expect_enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeEqualTo(Date value) {
            addCriterion("expect_enter_time =", value, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeNotEqualTo(Date value) {
            addCriterion("expect_enter_time <>", value, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeGreaterThan(Date value) {
            addCriterion("expect_enter_time >", value, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expect_enter_time >=", value, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeLessThan(Date value) {
            addCriterion("expect_enter_time <", value, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeLessThanOrEqualTo(Date value) {
            addCriterion("expect_enter_time <=", value, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeIn(List<Date> values) {
            addCriterion("expect_enter_time in", values, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeNotIn(List<Date> values) {
            addCriterion("expect_enter_time not in", values, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeBetween(Date value1, Date value2) {
            addCriterion("expect_enter_time between", value1, value2, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andExpectEnterTimeNotBetween(Date value1, Date value2) {
            addCriterion("expect_enter_time not between", value1, value2, "expectEnterTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeIsNull() {
            addCriterion("sure_time is null");
            return (Criteria) this;
        }

        public Criteria andSureTimeIsNotNull() {
            addCriterion("sure_time is not null");
            return (Criteria) this;
        }

        public Criteria andSureTimeEqualTo(Date value) {
            addCriterion("sure_time =", value, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeNotEqualTo(Date value) {
            addCriterion("sure_time <>", value, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeGreaterThan(Date value) {
            addCriterion("sure_time >", value, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sure_time >=", value, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeLessThan(Date value) {
            addCriterion("sure_time <", value, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeLessThanOrEqualTo(Date value) {
            addCriterion("sure_time <=", value, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeIn(List<Date> values) {
            addCriterion("sure_time in", values, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeNotIn(List<Date> values) {
            addCriterion("sure_time not in", values, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeBetween(Date value1, Date value2) {
            addCriterion("sure_time between", value1, value2, "sureTime");
            return (Criteria) this;
        }

        public Criteria andSureTimeNotBetween(Date value1, Date value2) {
            addCriterion("sure_time not between", value1, value2, "sureTime");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionIsNull() {
            addCriterion("approval_opioion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionIsNotNull() {
            addCriterion("approval_opioion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionEqualTo(String value) {
            addCriterion("approval_opioion =", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionNotEqualTo(String value) {
            addCriterion("approval_opioion <>", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionGreaterThan(String value) {
            addCriterion("approval_opioion >", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionGreaterThanOrEqualTo(String value) {
            addCriterion("approval_opioion >=", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionLessThan(String value) {
            addCriterion("approval_opioion <", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionLessThanOrEqualTo(String value) {
            addCriterion("approval_opioion <=", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionLike(String value) {
            addCriterion("approval_opioion like", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionNotLike(String value) {
            addCriterion("approval_opioion not like", value, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionIn(List<String> values) {
            addCriterion("approval_opioion in", values, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionNotIn(List<String> values) {
            addCriterion("approval_opioion not in", values, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionBetween(String value1, String value2) {
            addCriterion("approval_opioion between", value1, value2, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpioionNotBetween(String value1, String value2) {
            addCriterion("approval_opioion not between", value1, value2, "approvalOpioion");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerIsNull() {
            addCriterion("legal_personer is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerIsNotNull() {
            addCriterion("legal_personer is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerEqualTo(String value) {
            addCriterion("legal_personer =", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerNotEqualTo(String value) {
            addCriterion("legal_personer <>", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerGreaterThan(String value) {
            addCriterion("legal_personer >", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerGreaterThanOrEqualTo(String value) {
            addCriterion("legal_personer >=", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerLessThan(String value) {
            addCriterion("legal_personer <", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerLessThanOrEqualTo(String value) {
            addCriterion("legal_personer <=", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerLike(String value) {
            addCriterion("legal_personer like", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerNotLike(String value) {
            addCriterion("legal_personer not like", value, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerIn(List<String> values) {
            addCriterion("legal_personer in", values, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerNotIn(List<String> values) {
            addCriterion("legal_personer not in", values, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerBetween(String value1, String value2) {
            addCriterion("legal_personer between", value1, value2, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonerNotBetween(String value1, String value2) {
            addCriterion("legal_personer not between", value1, value2, "legalPersoner");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIsNull() {
            addCriterion("legal_phone is null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIsNotNull() {
            addCriterion("legal_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneEqualTo(String value) {
            addCriterion("legal_phone =", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotEqualTo(String value) {
            addCriterion("legal_phone <>", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneGreaterThan(String value) {
            addCriterion("legal_phone >", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("legal_phone >=", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLessThan(String value) {
            addCriterion("legal_phone <", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLessThanOrEqualTo(String value) {
            addCriterion("legal_phone <=", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLike(String value) {
            addCriterion("legal_phone like", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotLike(String value) {
            addCriterion("legal_phone not like", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIn(List<String> values) {
            addCriterion("legal_phone in", values, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotIn(List<String> values) {
            addCriterion("legal_phone not in", values, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneBetween(String value1, String value2) {
            addCriterion("legal_phone between", value1, value2, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotBetween(String value1, String value2) {
            addCriterion("legal_phone not between", value1, value2, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andComAdminIsNull() {
            addCriterion("com_admin is null");
            return (Criteria) this;
        }

        public Criteria andComAdminIsNotNull() {
            addCriterion("com_admin is not null");
            return (Criteria) this;
        }

        public Criteria andComAdminEqualTo(String value) {
            addCriterion("com_admin =", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotEqualTo(String value) {
            addCriterion("com_admin <>", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminGreaterThan(String value) {
            addCriterion("com_admin >", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminGreaterThanOrEqualTo(String value) {
            addCriterion("com_admin >=", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminLessThan(String value) {
            addCriterion("com_admin <", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminLessThanOrEqualTo(String value) {
            addCriterion("com_admin <=", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminLike(String value) {
            addCriterion("com_admin like", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotLike(String value) {
            addCriterion("com_admin not like", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminIn(List<String> values) {
            addCriterion("com_admin in", values, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotIn(List<String> values) {
            addCriterion("com_admin not in", values, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminBetween(String value1, String value2) {
            addCriterion("com_admin between", value1, value2, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotBetween(String value1, String value2) {
            addCriterion("com_admin not between", value1, value2, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andLinkerIsNull() {
            addCriterion("linker is null");
            return (Criteria) this;
        }

        public Criteria andLinkerIsNotNull() {
            addCriterion("linker is not null");
            return (Criteria) this;
        }

        public Criteria andLinkerEqualTo(String value) {
            addCriterion("linker =", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotEqualTo(String value) {
            addCriterion("linker <>", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerGreaterThan(String value) {
            addCriterion("linker >", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerGreaterThanOrEqualTo(String value) {
            addCriterion("linker >=", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerLessThan(String value) {
            addCriterion("linker <", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerLessThanOrEqualTo(String value) {
            addCriterion("linker <=", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerLike(String value) {
            addCriterion("linker like", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotLike(String value) {
            addCriterion("linker not like", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerIn(List<String> values) {
            addCriterion("linker in", values, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotIn(List<String> values) {
            addCriterion("linker not in", values, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerBetween(String value1, String value2) {
            addCriterion("linker between", value1, value2, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotBetween(String value1, String value2) {
            addCriterion("linker not between", value1, value2, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneIsNull() {
            addCriterion("linker_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneIsNotNull() {
            addCriterion("linker_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneEqualTo(String value) {
            addCriterion("linker_phone =", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneNotEqualTo(String value) {
            addCriterion("linker_phone <>", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneGreaterThan(String value) {
            addCriterion("linker_phone >", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("linker_phone >=", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneLessThan(String value) {
            addCriterion("linker_phone <", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneLessThanOrEqualTo(String value) {
            addCriterion("linker_phone <=", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneLike(String value) {
            addCriterion("linker_phone like", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneNotLike(String value) {
            addCriterion("linker_phone not like", value, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneIn(List<String> values) {
            addCriterion("linker_phone in", values, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneNotIn(List<String> values) {
            addCriterion("linker_phone not in", values, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneBetween(String value1, String value2) {
            addCriterion("linker_phone between", value1, value2, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andLinkerPhoneNotBetween(String value1, String value2) {
            addCriterion("linker_phone not between", value1, value2, "linkerPhone");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyIsNull() {
            addCriterion("enterprise_property is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyIsNotNull() {
            addCriterion("enterprise_property is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyEqualTo(String value) {
            addCriterion("enterprise_property =", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyNotEqualTo(String value) {
            addCriterion("enterprise_property <>", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyGreaterThan(String value) {
            addCriterion("enterprise_property >", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_property >=", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyLessThan(String value) {
            addCriterion("enterprise_property <", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyLessThanOrEqualTo(String value) {
            addCriterion("enterprise_property <=", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyLike(String value) {
            addCriterion("enterprise_property like", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyNotLike(String value) {
            addCriterion("enterprise_property not like", value, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyIn(List<String> values) {
            addCriterion("enterprise_property in", values, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyNotIn(List<String> values) {
            addCriterion("enterprise_property not in", values, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyBetween(String value1, String value2) {
            addCriterion("enterprise_property between", value1, value2, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andEnterprisePropertyNotBetween(String value1, String value2) {
            addCriterion("enterprise_property not between", value1, value2, "enterpriseProperty");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameIsNull() {
            addCriterion("industry_type_name is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameIsNotNull() {
            addCriterion("industry_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameEqualTo(String value) {
            addCriterion("industry_type_name =", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotEqualTo(String value) {
            addCriterion("industry_type_name <>", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameGreaterThan(String value) {
            addCriterion("industry_type_name >", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("industry_type_name >=", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameLessThan(String value) {
            addCriterion("industry_type_name <", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameLessThanOrEqualTo(String value) {
            addCriterion("industry_type_name <=", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameLike(String value) {
            addCriterion("industry_type_name like", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotLike(String value) {
            addCriterion("industry_type_name not like", value, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameIn(List<String> values) {
            addCriterion("industry_type_name in", values, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotIn(List<String> values) {
            addCriterion("industry_type_name not in", values, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameBetween(String value1, String value2) {
            addCriterion("industry_type_name between", value1, value2, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNameNotBetween(String value1, String value2) {
            addCriterion("industry_type_name not between", value1, value2, "industryTypeName");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNull() {
            addCriterion("industry_type is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("industry_type is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(String value) {
            addCriterion("industry_type =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(String value) {
            addCriterion("industry_type <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(String value) {
            addCriterion("industry_type >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_type >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(String value) {
            addCriterion("industry_type <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(String value) {
            addCriterion("industry_type <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLike(String value) {
            addCriterion("industry_type like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotLike(String value) {
            addCriterion("industry_type not like", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<String> values) {
            addCriterion("industry_type in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<String> values) {
            addCriterion("industry_type not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(String value1, String value2) {
            addCriterion("industry_type between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(String value1, String value2) {
            addCriterion("industry_type not between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeIsNull() {
            addCriterion("rent_start_time is null");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeIsNotNull() {
            addCriterion("rent_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeEqualTo(Date value) {
            addCriterion("rent_start_time =", value, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeNotEqualTo(Date value) {
            addCriterion("rent_start_time <>", value, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeGreaterThan(Date value) {
            addCriterion("rent_start_time >", value, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rent_start_time >=", value, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeLessThan(Date value) {
            addCriterion("rent_start_time <", value, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("rent_start_time <=", value, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeIn(List<Date> values) {
            addCriterion("rent_start_time in", values, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeNotIn(List<Date> values) {
            addCriterion("rent_start_time not in", values, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeBetween(Date value1, Date value2) {
            addCriterion("rent_start_time between", value1, value2, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andRentStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("rent_start_time not between", value1, value2, "rentStartTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeIsNull() {
            addCriterion("com_ent_time is null");
            return (Criteria) this;
        }

        public Criteria andComEntTimeIsNotNull() {
            addCriterion("com_ent_time is not null");
            return (Criteria) this;
        }

        public Criteria andComEntTimeEqualTo(Date value) {
            addCriterion("com_ent_time =", value, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeNotEqualTo(Date value) {
            addCriterion("com_ent_time <>", value, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeGreaterThan(Date value) {
            addCriterion("com_ent_time >", value, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("com_ent_time >=", value, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeLessThan(Date value) {
            addCriterion("com_ent_time <", value, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeLessThanOrEqualTo(Date value) {
            addCriterion("com_ent_time <=", value, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeIn(List<Date> values) {
            addCriterion("com_ent_time in", values, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeNotIn(List<Date> values) {
            addCriterion("com_ent_time not in", values, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeBetween(Date value1, Date value2) {
            addCriterion("com_ent_time between", value1, value2, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andComEntTimeNotBetween(Date value1, Date value2) {
            addCriterion("com_ent_time not between", value1, value2, "comEntTime");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumIsNull() {
            addCriterion("rent_month_num is null");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumIsNotNull() {
            addCriterion("rent_month_num is not null");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumEqualTo(Integer value) {
            addCriterion("rent_month_num =", value, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumNotEqualTo(Integer value) {
            addCriterion("rent_month_num <>", value, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumGreaterThan(Integer value) {
            addCriterion("rent_month_num >", value, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_month_num >=", value, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumLessThan(Integer value) {
            addCriterion("rent_month_num <", value, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumLessThanOrEqualTo(Integer value) {
            addCriterion("rent_month_num <=", value, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumIn(List<Integer> values) {
            addCriterion("rent_month_num in", values, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumNotIn(List<Integer> values) {
            addCriterion("rent_month_num not in", values, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumBetween(Integer value1, Integer value2) {
            addCriterion("rent_month_num between", value1, value2, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRentMonthNumNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_month_num not between", value1, value2, "rentMonthNum");
            return (Criteria) this;
        }

        public Criteria andRemerkIsNull() {
            addCriterion("remerk is null");
            return (Criteria) this;
        }

        public Criteria andRemerkIsNotNull() {
            addCriterion("remerk is not null");
            return (Criteria) this;
        }

        public Criteria andRemerkEqualTo(String value) {
            addCriterion("remerk =", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkNotEqualTo(String value) {
            addCriterion("remerk <>", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkGreaterThan(String value) {
            addCriterion("remerk >", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkGreaterThanOrEqualTo(String value) {
            addCriterion("remerk >=", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkLessThan(String value) {
            addCriterion("remerk <", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkLessThanOrEqualTo(String value) {
            addCriterion("remerk <=", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkLike(String value) {
            addCriterion("remerk like", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkNotLike(String value) {
            addCriterion("remerk not like", value, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkIn(List<String> values) {
            addCriterion("remerk in", values, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkNotIn(List<String> values) {
            addCriterion("remerk not in", values, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkBetween(String value1, String value2) {
            addCriterion("remerk between", value1, value2, "remerk");
            return (Criteria) this;
        }

        public Criteria andRemerkNotBetween(String value1, String value2) {
            addCriterion("remerk not between", value1, value2, "remerk");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountIsNull() {
            addCriterion("actual_total_account is null");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountIsNotNull() {
            addCriterion("actual_total_account is not null");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountEqualTo(BigDecimal value) {
            addCriterion("actual_total_account =", value, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountNotEqualTo(BigDecimal value) {
            addCriterion("actual_total_account <>", value, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountGreaterThan(BigDecimal value) {
            addCriterion("actual_total_account >", value, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_total_account >=", value, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountLessThan(BigDecimal value) {
            addCriterion("actual_total_account <", value, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_total_account <=", value, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountIn(List<BigDecimal> values) {
            addCriterion("actual_total_account in", values, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountNotIn(List<BigDecimal> values) {
            addCriterion("actual_total_account not in", values, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_total_account between", value1, value2, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andActualTotalAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_total_account not between", value1, value2, "actualTotalAccount");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdIsNull() {
            addCriterion("room_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdIsNotNull() {
            addCriterion("room_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdEqualTo(String value) {
            addCriterion("room_bill_id =", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdNotEqualTo(String value) {
            addCriterion("room_bill_id <>", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdGreaterThan(String value) {
            addCriterion("room_bill_id >", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_bill_id >=", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdLessThan(String value) {
            addCriterion("room_bill_id <", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdLessThanOrEqualTo(String value) {
            addCriterion("room_bill_id <=", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdLike(String value) {
            addCriterion("room_bill_id like", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdNotLike(String value) {
            addCriterion("room_bill_id not like", value, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdIn(List<String> values) {
            addCriterion("room_bill_id in", values, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdNotIn(List<String> values) {
            addCriterion("room_bill_id not in", values, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdBetween(String value1, String value2) {
            addCriterion("room_bill_id between", value1, value2, "roomBillId");
            return (Criteria) this;
        }

        public Criteria andRoomBillIdNotBetween(String value1, String value2) {
            addCriterion("room_bill_id not between", value1, value2, "roomBillId");
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