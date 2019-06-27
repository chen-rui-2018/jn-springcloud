package com.jn.enterprise.servicemarket.org.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceOrgTeamTempCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceOrgTeamTempCriteria() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id_ is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id_ =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id_ <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id_ >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id_ >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id_ <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id_ <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id_ like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id_ not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id_ in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id_ not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id_ between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id_ not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andConNameIsNull() {
            addCriterion("con_name is null");
            return (Criteria) this;
        }

        public Criteria andConNameIsNotNull() {
            addCriterion("con_name is not null");
            return (Criteria) this;
        }

        public Criteria andConNameEqualTo(String value) {
            addCriterion("con_name =", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotEqualTo(String value) {
            addCriterion("con_name <>", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameGreaterThan(String value) {
            addCriterion("con_name >", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameGreaterThanOrEqualTo(String value) {
            addCriterion("con_name >=", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLessThan(String value) {
            addCriterion("con_name <", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLessThanOrEqualTo(String value) {
            addCriterion("con_name <=", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLike(String value) {
            addCriterion("con_name like", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotLike(String value) {
            addCriterion("con_name not like", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameIn(List<String> values) {
            addCriterion("con_name in", values, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotIn(List<String> values) {
            addCriterion("con_name not in", values, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameBetween(String value1, String value2) {
            addCriterion("con_name between", value1, value2, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotBetween(String value1, String value2) {
            addCriterion("con_name not between", value1, value2, "conName");
            return (Criteria) this;
        }

        public Criteria andConPositionIsNull() {
            addCriterion("con_position is null");
            return (Criteria) this;
        }

        public Criteria andConPositionIsNotNull() {
            addCriterion("con_position is not null");
            return (Criteria) this;
        }

        public Criteria andConPositionEqualTo(String value) {
            addCriterion("con_position =", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionNotEqualTo(String value) {
            addCriterion("con_position <>", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionGreaterThan(String value) {
            addCriterion("con_position >", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionGreaterThanOrEqualTo(String value) {
            addCriterion("con_position >=", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionLessThan(String value) {
            addCriterion("con_position <", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionLessThanOrEqualTo(String value) {
            addCriterion("con_position <=", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionLike(String value) {
            addCriterion("con_position like", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionNotLike(String value) {
            addCriterion("con_position not like", value, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionIn(List<String> values) {
            addCriterion("con_position in", values, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionNotIn(List<String> values) {
            addCriterion("con_position not in", values, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionBetween(String value1, String value2) {
            addCriterion("con_position between", value1, value2, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConPositionNotBetween(String value1, String value2) {
            addCriterion("con_position not between", value1, value2, "conPosition");
            return (Criteria) this;
        }

        public Criteria andConQualiIsNull() {
            addCriterion("con_quali is null");
            return (Criteria) this;
        }

        public Criteria andConQualiIsNotNull() {
            addCriterion("con_quali is not null");
            return (Criteria) this;
        }

        public Criteria andConQualiEqualTo(String value) {
            addCriterion("con_quali =", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiNotEqualTo(String value) {
            addCriterion("con_quali <>", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiGreaterThan(String value) {
            addCriterion("con_quali >", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiGreaterThanOrEqualTo(String value) {
            addCriterion("con_quali >=", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiLessThan(String value) {
            addCriterion("con_quali <", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiLessThanOrEqualTo(String value) {
            addCriterion("con_quali <=", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiLike(String value) {
            addCriterion("con_quali like", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiNotLike(String value) {
            addCriterion("con_quali not like", value, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiIn(List<String> values) {
            addCriterion("con_quali in", values, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiNotIn(List<String> values) {
            addCriterion("con_quali not in", values, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiBetween(String value1, String value2) {
            addCriterion("con_quali between", value1, value2, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConQualiNotBetween(String value1, String value2) {
            addCriterion("con_quali not between", value1, value2, "conQuali");
            return (Criteria) this;
        }

        public Criteria andConTimeIsNull() {
            addCriterion("con_time is null");
            return (Criteria) this;
        }

        public Criteria andConTimeIsNotNull() {
            addCriterion("con_time is not null");
            return (Criteria) this;
        }

        public Criteria andConTimeEqualTo(String value) {
            addCriterion("con_time =", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeNotEqualTo(String value) {
            addCriterion("con_time <>", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeGreaterThan(String value) {
            addCriterion("con_time >", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeGreaterThanOrEqualTo(String value) {
            addCriterion("con_time >=", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeLessThan(String value) {
            addCriterion("con_time <", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeLessThanOrEqualTo(String value) {
            addCriterion("con_time <=", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeLike(String value) {
            addCriterion("con_time like", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeNotLike(String value) {
            addCriterion("con_time not like", value, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeIn(List<String> values) {
            addCriterion("con_time in", values, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeNotIn(List<String> values) {
            addCriterion("con_time not in", values, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeBetween(String value1, String value2) {
            addCriterion("con_time between", value1, value2, "conTime");
            return (Criteria) this;
        }

        public Criteria andConTimeNotBetween(String value1, String value2) {
            addCriterion("con_time not between", value1, value2, "conTime");
            return (Criteria) this;
        }

        public Criteria andConSpecialityIsNull() {
            addCriterion("con_speciality is null");
            return (Criteria) this;
        }

        public Criteria andConSpecialityIsNotNull() {
            addCriterion("con_speciality is not null");
            return (Criteria) this;
        }

        public Criteria andConSpecialityEqualTo(String value) {
            addCriterion("con_speciality =", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityNotEqualTo(String value) {
            addCriterion("con_speciality <>", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityGreaterThan(String value) {
            addCriterion("con_speciality >", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("con_speciality >=", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityLessThan(String value) {
            addCriterion("con_speciality <", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityLessThanOrEqualTo(String value) {
            addCriterion("con_speciality <=", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityLike(String value) {
            addCriterion("con_speciality like", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityNotLike(String value) {
            addCriterion("con_speciality not like", value, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityIn(List<String> values) {
            addCriterion("con_speciality in", values, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityNotIn(List<String> values) {
            addCriterion("con_speciality not in", values, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityBetween(String value1, String value2) {
            addCriterion("con_speciality between", value1, value2, "conSpeciality");
            return (Criteria) this;
        }

        public Criteria andConSpecialityNotBetween(String value1, String value2) {
            addCriterion("con_speciality not between", value1, value2, "conSpeciality");
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