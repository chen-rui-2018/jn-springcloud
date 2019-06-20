package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerInsuredSchemeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerInsuredSchemeCriteria() {
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

        public Criteria andSchemeIdIsNull() {
            addCriterion("scheme_id is null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIsNotNull() {
            addCriterion("scheme_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdEqualTo(String value) {
            addCriterion("scheme_id =", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotEqualTo(String value) {
            addCriterion("scheme_id <>", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThan(String value) {
            addCriterion("scheme_id >", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThanOrEqualTo(String value) {
            addCriterion("scheme_id >=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThan(String value) {
            addCriterion("scheme_id <", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThanOrEqualTo(String value) {
            addCriterion("scheme_id <=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLike(String value) {
            addCriterion("scheme_id like", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotLike(String value) {
            addCriterion("scheme_id not like", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIn(List<String> values) {
            addCriterion("scheme_id in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotIn(List<String> values) {
            addCriterion("scheme_id not in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdBetween(String value1, String value2) {
            addCriterion("scheme_id between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotBetween(String value1, String value2) {
            addCriterion("scheme_id not between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeNameIsNull() {
            addCriterion("scheme_name is null");
            return (Criteria) this;
        }

        public Criteria andSchemeNameIsNotNull() {
            addCriterion("scheme_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeNameEqualTo(String value) {
            addCriterion("scheme_name =", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameNotEqualTo(String value) {
            addCriterion("scheme_name <>", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameGreaterThan(String value) {
            addCriterion("scheme_name >", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameGreaterThanOrEqualTo(String value) {
            addCriterion("scheme_name >=", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameLessThan(String value) {
            addCriterion("scheme_name <", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameLessThanOrEqualTo(String value) {
            addCriterion("scheme_name <=", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameLike(String value) {
            addCriterion("scheme_name like", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameNotLike(String value) {
            addCriterion("scheme_name not like", value, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameIn(List<String> values) {
            addCriterion("scheme_name in", values, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameNotIn(List<String> values) {
            addCriterion("scheme_name not in", values, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameBetween(String value1, String value2) {
            addCriterion("scheme_name between", value1, value2, "schemeName");
            return (Criteria) this;
        }

        public Criteria andSchemeNameNotBetween(String value1, String value2) {
            addCriterion("scheme_name not between", value1, value2, "schemeName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdIsNull() {
            addCriterion("insured_city_id is null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdIsNotNull() {
            addCriterion("insured_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdEqualTo(String value) {
            addCriterion("insured_city_id =", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotEqualTo(String value) {
            addCriterion("insured_city_id <>", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdGreaterThan(String value) {
            addCriterion("insured_city_id >", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("insured_city_id >=", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdLessThan(String value) {
            addCriterion("insured_city_id <", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdLessThanOrEqualTo(String value) {
            addCriterion("insured_city_id <=", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdLike(String value) {
            addCriterion("insured_city_id like", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotLike(String value) {
            addCriterion("insured_city_id not like", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdIn(List<String> values) {
            addCriterion("insured_city_id in", values, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotIn(List<String> values) {
            addCriterion("insured_city_id not in", values, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdBetween(String value1, String value2) {
            addCriterion("insured_city_id between", value1, value2, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotBetween(String value1, String value2) {
            addCriterion("insured_city_id not between", value1, value2, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameIsNull() {
            addCriterion("insured_city_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameIsNotNull() {
            addCriterion("insured_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameEqualTo(String value) {
            addCriterion("insured_city_name =", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotEqualTo(String value) {
            addCriterion("insured_city_name <>", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameGreaterThan(String value) {
            addCriterion("insured_city_name >", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_city_name >=", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameLessThan(String value) {
            addCriterion("insured_city_name <", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameLessThanOrEqualTo(String value) {
            addCriterion("insured_city_name <=", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameLike(String value) {
            addCriterion("insured_city_name like", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotLike(String value) {
            addCriterion("insured_city_name not like", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameIn(List<String> values) {
            addCriterion("insured_city_name in", values, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotIn(List<String> values) {
            addCriterion("insured_city_name not in", values, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameBetween(String value1, String value2) {
            addCriterion("insured_city_name between", value1, value2, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotBetween(String value1, String value2) {
            addCriterion("insured_city_name not between", value1, value2, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdIsNull() {
            addCriterion("social_security_id is null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdIsNotNull() {
            addCriterion("social_security_id is not null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdEqualTo(String value) {
            addCriterion("social_security_id =", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdNotEqualTo(String value) {
            addCriterion("social_security_id <>", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdGreaterThan(String value) {
            addCriterion("social_security_id >", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdGreaterThanOrEqualTo(String value) {
            addCriterion("social_security_id >=", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdLessThan(String value) {
            addCriterion("social_security_id <", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdLessThanOrEqualTo(String value) {
            addCriterion("social_security_id <=", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdLike(String value) {
            addCriterion("social_security_id like", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdNotLike(String value) {
            addCriterion("social_security_id not like", value, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdIn(List<String> values) {
            addCriterion("social_security_id in", values, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdNotIn(List<String> values) {
            addCriterion("social_security_id not in", values, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdBetween(String value1, String value2) {
            addCriterion("social_security_id between", value1, value2, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityIdNotBetween(String value1, String value2) {
            addCriterion("social_security_id not between", value1, value2, "socialSecurityId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdIsNull() {
            addCriterion("accumulation_fund_id is null");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdIsNotNull() {
            addCriterion("accumulation_fund_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdEqualTo(String value) {
            addCriterion("accumulation_fund_id =", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdNotEqualTo(String value) {
            addCriterion("accumulation_fund_id <>", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdGreaterThan(String value) {
            addCriterion("accumulation_fund_id >", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdGreaterThanOrEqualTo(String value) {
            addCriterion("accumulation_fund_id >=", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdLessThan(String value) {
            addCriterion("accumulation_fund_id <", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdLessThanOrEqualTo(String value) {
            addCriterion("accumulation_fund_id <=", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdLike(String value) {
            addCriterion("accumulation_fund_id like", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdNotLike(String value) {
            addCriterion("accumulation_fund_id not like", value, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdIn(List<String> values) {
            addCriterion("accumulation_fund_id in", values, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdNotIn(List<String> values) {
            addCriterion("accumulation_fund_id not in", values, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdBetween(String value1, String value2) {
            addCriterion("accumulation_fund_id between", value1, value2, "accumulationFundId");
            return (Criteria) this;
        }

        public Criteria andAccumulationFundIdNotBetween(String value1, String value2) {
            addCriterion("accumulation_fund_id not between", value1, value2, "accumulationFundId");
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