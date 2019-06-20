package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerInsuredSchemeDetailedCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerInsuredSchemeDetailedCriteria() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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

        public Criteria andDefaultCardinalNumberIsNull() {
            addCriterion("default_cardinal_number is null");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberIsNotNull() {
            addCriterion("default_cardinal_number is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberEqualTo(Integer value) {
            addCriterion("default_cardinal_number =", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberNotEqualTo(Integer value) {
            addCriterion("default_cardinal_number <>", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberGreaterThan(Integer value) {
            addCriterion("default_cardinal_number >", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_cardinal_number >=", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberLessThan(Integer value) {
            addCriterion("default_cardinal_number <", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("default_cardinal_number <=", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberIn(List<Integer> values) {
            addCriterion("default_cardinal_number in", values, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberNotIn(List<Integer> values) {
            addCriterion("default_cardinal_number not in", values, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberBetween(Integer value1, Integer value2) {
            addCriterion("default_cardinal_number between", value1, value2, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("default_cardinal_number not between", value1, value2, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartIsNull() {
            addCriterion("optional_base_start is null");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartIsNotNull() {
            addCriterion("optional_base_start is not null");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartEqualTo(Integer value) {
            addCriterion("optional_base_start =", value, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartNotEqualTo(Integer value) {
            addCriterion("optional_base_start <>", value, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartGreaterThan(Integer value) {
            addCriterion("optional_base_start >", value, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("optional_base_start >=", value, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartLessThan(Integer value) {
            addCriterion("optional_base_start <", value, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartLessThanOrEqualTo(Integer value) {
            addCriterion("optional_base_start <=", value, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartIn(List<Integer> values) {
            addCriterion("optional_base_start in", values, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartNotIn(List<Integer> values) {
            addCriterion("optional_base_start not in", values, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartBetween(Integer value1, Integer value2) {
            addCriterion("optional_base_start between", value1, value2, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseStartNotBetween(Integer value1, Integer value2) {
            addCriterion("optional_base_start not between", value1, value2, "optionalBaseStart");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndIsNull() {
            addCriterion("optional_base_end is null");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndIsNotNull() {
            addCriterion("optional_base_end is not null");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndEqualTo(Integer value) {
            addCriterion("optional_base_end =", value, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndNotEqualTo(Integer value) {
            addCriterion("optional_base_end <>", value, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndGreaterThan(Integer value) {
            addCriterion("optional_base_end >", value, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("optional_base_end >=", value, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndLessThan(Integer value) {
            addCriterion("optional_base_end <", value, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndLessThanOrEqualTo(Integer value) {
            addCriterion("optional_base_end <=", value, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndIn(List<Integer> values) {
            addCriterion("optional_base_end in", values, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndNotIn(List<Integer> values) {
            addCriterion("optional_base_end not in", values, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndBetween(Integer value1, Integer value2) {
            addCriterion("optional_base_end between", value1, value2, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andOptionalBaseEndNotBetween(Integer value1, Integer value2) {
            addCriterion("optional_base_end not between", value1, value2, "optionalBaseEnd");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioIsNull() {
            addCriterion("corporate_contribution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioIsNotNull() {
            addCriterion("corporate_contribution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio =", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioNotEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio <>", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioGreaterThan(Integer value) {
            addCriterion("corporate_contribution_ratio >", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio >=", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioLessThan(Integer value) {
            addCriterion("corporate_contribution_ratio <", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioLessThanOrEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio <=", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioIn(List<Integer> values) {
            addCriterion("corporate_contribution_ratio in", values, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioNotIn(List<Integer> values) {
            addCriterion("corporate_contribution_ratio not in", values, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioBetween(Integer value1, Integer value2) {
            addCriterion("corporate_contribution_ratio between", value1, value2, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("corporate_contribution_ratio not between", value1, value2, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioIsNull() {
            addCriterion("individual_contribution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioIsNotNull() {
            addCriterion("individual_contribution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio =", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioNotEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio <>", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioGreaterThan(Integer value) {
            addCriterion("individual_contribution_ratio >", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio >=", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioLessThan(Integer value) {
            addCriterion("individual_contribution_ratio <", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioLessThanOrEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio <=", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioIn(List<Integer> values) {
            addCriterion("individual_contribution_ratio in", values, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioNotIn(List<Integer> values) {
            addCriterion("individual_contribution_ratio not in", values, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioBetween(Integer value1, Integer value2) {
            addCriterion("individual_contribution_ratio between", value1, value2, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("individual_contribution_ratio not between", value1, value2, "individualContributionRatio");
            return (Criteria) this;
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

        public Criteria andProvidentFundIdIsNull() {
            addCriterion("provident_fund_id is null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdIsNotNull() {
            addCriterion("provident_fund_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdEqualTo(String value) {
            addCriterion("provident_fund_id =", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdNotEqualTo(String value) {
            addCriterion("provident_fund_id <>", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdGreaterThan(String value) {
            addCriterion("provident_fund_id >", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdGreaterThanOrEqualTo(String value) {
            addCriterion("provident_fund_id >=", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdLessThan(String value) {
            addCriterion("provident_fund_id <", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdLessThanOrEqualTo(String value) {
            addCriterion("provident_fund_id <=", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdLike(String value) {
            addCriterion("provident_fund_id like", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdNotLike(String value) {
            addCriterion("provident_fund_id not like", value, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdIn(List<String> values) {
            addCriterion("provident_fund_id in", values, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdNotIn(List<String> values) {
            addCriterion("provident_fund_id not in", values, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdBetween(String value1, String value2) {
            addCriterion("provident_fund_id between", value1, value2, "providentFundId");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIdNotBetween(String value1, String value2) {
            addCriterion("provident_fund_id not between", value1, value2, "providentFundId");
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

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Byte value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Byte value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Byte value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Byte value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Byte value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Byte> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Byte> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Byte value1, Byte value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
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