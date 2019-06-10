package com.jn.enterprise.servicemarket.org.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceOrgElementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceOrgElementCriteria() {
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

        public Criteria andStaffCountIsNull() {
            addCriterion("staff_count is null");
            return (Criteria) this;
        }

        public Criteria andStaffCountIsNotNull() {
            addCriterion("staff_count is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCountEqualTo(Integer value) {
            addCriterion("staff_count =", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountNotEqualTo(Integer value) {
            addCriterion("staff_count <>", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountGreaterThan(Integer value) {
            addCriterion("staff_count >", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_count >=", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountLessThan(Integer value) {
            addCriterion("staff_count <", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountLessThanOrEqualTo(Integer value) {
            addCriterion("staff_count <=", value, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountIn(List<Integer> values) {
            addCriterion("staff_count in", values, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountNotIn(List<Integer> values) {
            addCriterion("staff_count not in", values, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountBetween(Integer value1, Integer value2) {
            addCriterion("staff_count between", value1, value2, "staffCount");
            return (Criteria) this;
        }

        public Criteria andStaffCountNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_count not between", value1, value2, "staffCount");
            return (Criteria) this;
        }

        public Criteria andProfessionNumIsNull() {
            addCriterion("profession_num is null");
            return (Criteria) this;
        }

        public Criteria andProfessionNumIsNotNull() {
            addCriterion("profession_num is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionNumEqualTo(Integer value) {
            addCriterion("profession_num =", value, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumNotEqualTo(Integer value) {
            addCriterion("profession_num <>", value, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumGreaterThan(Integer value) {
            addCriterion("profession_num >", value, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("profession_num >=", value, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumLessThan(Integer value) {
            addCriterion("profession_num <", value, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumLessThanOrEqualTo(Integer value) {
            addCriterion("profession_num <=", value, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumIn(List<Integer> values) {
            addCriterion("profession_num in", values, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumNotIn(List<Integer> values) {
            addCriterion("profession_num not in", values, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumBetween(Integer value1, Integer value2) {
            addCriterion("profession_num between", value1, value2, "professionNum");
            return (Criteria) this;
        }

        public Criteria andProfessionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("profession_num not between", value1, value2, "professionNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumIsNull() {
            addCriterion("bachelor_num is null");
            return (Criteria) this;
        }

        public Criteria andBachelorNumIsNotNull() {
            addCriterion("bachelor_num is not null");
            return (Criteria) this;
        }

        public Criteria andBachelorNumEqualTo(Integer value) {
            addCriterion("bachelor_num =", value, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumNotEqualTo(Integer value) {
            addCriterion("bachelor_num <>", value, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumGreaterThan(Integer value) {
            addCriterion("bachelor_num >", value, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bachelor_num >=", value, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumLessThan(Integer value) {
            addCriterion("bachelor_num <", value, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumLessThanOrEqualTo(Integer value) {
            addCriterion("bachelor_num <=", value, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumIn(List<Integer> values) {
            addCriterion("bachelor_num in", values, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumNotIn(List<Integer> values) {
            addCriterion("bachelor_num not in", values, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumBetween(Integer value1, Integer value2) {
            addCriterion("bachelor_num between", value1, value2, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andBachelorNumNotBetween(Integer value1, Integer value2) {
            addCriterion("bachelor_num not between", value1, value2, "bachelorNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumIsNull() {
            addCriterion("master_num is null");
            return (Criteria) this;
        }

        public Criteria andMasterNumIsNotNull() {
            addCriterion("master_num is not null");
            return (Criteria) this;
        }

        public Criteria andMasterNumEqualTo(Integer value) {
            addCriterion("master_num =", value, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumNotEqualTo(Integer value) {
            addCriterion("master_num <>", value, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumGreaterThan(Integer value) {
            addCriterion("master_num >", value, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("master_num >=", value, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumLessThan(Integer value) {
            addCriterion("master_num <", value, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumLessThanOrEqualTo(Integer value) {
            addCriterion("master_num <=", value, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumIn(List<Integer> values) {
            addCriterion("master_num in", values, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumNotIn(List<Integer> values) {
            addCriterion("master_num not in", values, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumBetween(Integer value1, Integer value2) {
            addCriterion("master_num between", value1, value2, "masterNum");
            return (Criteria) this;
        }

        public Criteria andMasterNumNotBetween(Integer value1, Integer value2) {
            addCriterion("master_num not between", value1, value2, "masterNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumIsNull() {
            addCriterion("doctor_num is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNumIsNotNull() {
            addCriterion("doctor_num is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNumEqualTo(Integer value) {
            addCriterion("doctor_num =", value, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumNotEqualTo(Integer value) {
            addCriterion("doctor_num <>", value, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumGreaterThan(Integer value) {
            addCriterion("doctor_num >", value, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_num >=", value, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumLessThan(Integer value) {
            addCriterion("doctor_num <", value, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_num <=", value, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumIn(List<Integer> values) {
            addCriterion("doctor_num in", values, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumNotIn(List<Integer> values) {
            addCriterion("doctor_num not in", values, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumBetween(Integer value1, Integer value2) {
            addCriterion("doctor_num between", value1, value2, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andDoctorNumNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_num not between", value1, value2, "doctorNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumIsNull() {
            addCriterion("returnee_num is null");
            return (Criteria) this;
        }

        public Criteria andReturneeNumIsNotNull() {
            addCriterion("returnee_num is not null");
            return (Criteria) this;
        }

        public Criteria andReturneeNumEqualTo(Integer value) {
            addCriterion("returnee_num =", value, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumNotEqualTo(Integer value) {
            addCriterion("returnee_num <>", value, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumGreaterThan(Integer value) {
            addCriterion("returnee_num >", value, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("returnee_num >=", value, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumLessThan(Integer value) {
            addCriterion("returnee_num <", value, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumLessThanOrEqualTo(Integer value) {
            addCriterion("returnee_num <=", value, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumIn(List<Integer> values) {
            addCriterion("returnee_num in", values, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumNotIn(List<Integer> values) {
            addCriterion("returnee_num not in", values, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumBetween(Integer value1, Integer value2) {
            addCriterion("returnee_num between", value1, value2, "returneeNum");
            return (Criteria) this;
        }

        public Criteria andReturneeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("returnee_num not between", value1, value2, "returneeNum");
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