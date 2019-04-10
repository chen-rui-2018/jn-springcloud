package com.jn.enterprise.pd.personnel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdPersonnelQualificationsHonoursCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdPersonnelQualificationsHonoursCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameIsNull() {
            addCriterion("qualifications_honours_name is null");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameIsNotNull() {
            addCriterion("qualifications_honours_name is not null");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameEqualTo(String value) {
            addCriterion("qualifications_honours_name =", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameNotEqualTo(String value) {
            addCriterion("qualifications_honours_name <>", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameGreaterThan(String value) {
            addCriterion("qualifications_honours_name >", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameGreaterThanOrEqualTo(String value) {
            addCriterion("qualifications_honours_name >=", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameLessThan(String value) {
            addCriterion("qualifications_honours_name <", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameLessThanOrEqualTo(String value) {
            addCriterion("qualifications_honours_name <=", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameLike(String value) {
            addCriterion("qualifications_honours_name like", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameNotLike(String value) {
            addCriterion("qualifications_honours_name not like", value, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameIn(List<String> values) {
            addCriterion("qualifications_honours_name in", values, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameNotIn(List<String> values) {
            addCriterion("qualifications_honours_name not in", values, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameBetween(String value1, String value2) {
            addCriterion("qualifications_honours_name between", value1, value2, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andQualificationsHonoursNameNotBetween(String value1, String value2) {
            addCriterion("qualifications_honours_name not between", value1, value2, "qualificationsHonoursName");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsIsNull() {
            addCriterion("featured_labels is null");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsIsNotNull() {
            addCriterion("featured_labels is not null");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsEqualTo(String value) {
            addCriterion("featured_labels =", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsNotEqualTo(String value) {
            addCriterion("featured_labels <>", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsGreaterThan(String value) {
            addCriterion("featured_labels >", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsGreaterThanOrEqualTo(String value) {
            addCriterion("featured_labels >=", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsLessThan(String value) {
            addCriterion("featured_labels <", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsLessThanOrEqualTo(String value) {
            addCriterion("featured_labels <=", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsLike(String value) {
            addCriterion("featured_labels like", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsNotLike(String value) {
            addCriterion("featured_labels not like", value, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsIn(List<String> values) {
            addCriterion("featured_labels in", values, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsNotIn(List<String> values) {
            addCriterion("featured_labels not in", values, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsBetween(String value1, String value2) {
            addCriterion("featured_labels between", value1, value2, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andFeaturedLabelsNotBetween(String value1, String value2) {
            addCriterion("featured_labels not between", value1, value2, "featuredLabels");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNull() {
            addCriterion("issue_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNotNull() {
            addCriterion("issue_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeEqualTo(String value) {
            addCriterion("issue_time =", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotEqualTo(String value) {
            addCriterion("issue_time <>", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThan(String value) {
            addCriterion("issue_time >", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThanOrEqualTo(String value) {
            addCriterion("issue_time >=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThan(String value) {
            addCriterion("issue_time <", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThanOrEqualTo(String value) {
            addCriterion("issue_time <=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLike(String value) {
            addCriterion("issue_time like", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotLike(String value) {
            addCriterion("issue_time not like", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIn(List<String> values) {
            addCriterion("issue_time in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotIn(List<String> values) {
            addCriterion("issue_time not in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeBetween(String value1, String value2) {
            addCriterion("issue_time between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotBetween(String value1, String value2) {
            addCriterion("issue_time not between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentIsNull() {
            addCriterion("competent_department is null");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentIsNotNull() {
            addCriterion("competent_department is not null");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentEqualTo(String value) {
            addCriterion("competent_department =", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentNotEqualTo(String value) {
            addCriterion("competent_department <>", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentGreaterThan(String value) {
            addCriterion("competent_department >", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("competent_department >=", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentLessThan(String value) {
            addCriterion("competent_department <", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentLessThanOrEqualTo(String value) {
            addCriterion("competent_department <=", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentLike(String value) {
            addCriterion("competent_department like", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentNotLike(String value) {
            addCriterion("competent_department not like", value, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentIn(List<String> values) {
            addCriterion("competent_department in", values, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentNotIn(List<String> values) {
            addCriterion("competent_department not in", values, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentBetween(String value1, String value2) {
            addCriterion("competent_department between", value1, value2, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andCompetentDepartmentNotBetween(String value1, String value2) {
            addCriterion("competent_department not between", value1, value2, "competentDepartment");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlIsNull() {
            addCriterion("enclosure_url is null");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlIsNotNull() {
            addCriterion("enclosure_url is not null");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlEqualTo(String value) {
            addCriterion("enclosure_url =", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotEqualTo(String value) {
            addCriterion("enclosure_url <>", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlGreaterThan(String value) {
            addCriterion("enclosure_url >", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("enclosure_url >=", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlLessThan(String value) {
            addCriterion("enclosure_url <", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlLessThanOrEqualTo(String value) {
            addCriterion("enclosure_url <=", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlLike(String value) {
            addCriterion("enclosure_url like", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotLike(String value) {
            addCriterion("enclosure_url not like", value, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlIn(List<String> values) {
            addCriterion("enclosure_url in", values, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotIn(List<String> values) {
            addCriterion("enclosure_url not in", values, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlBetween(String value1, String value2) {
            addCriterion("enclosure_url between", value1, value2, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andEnclosureUrlNotBetween(String value1, String value2) {
            addCriterion("enclosure_url not between", value1, value2, "enclosureUrl");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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