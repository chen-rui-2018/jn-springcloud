package com.jn.enterprise.pd.personnel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdPersonnelProjectBankCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdPersonnelProjectBankCriteria() {
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

        public Criteria andUnifiedSocialCreditIsNull() {
            addCriterion("unified_social_credit is null");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditIsNotNull() {
            addCriterion("unified_social_credit is not null");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditEqualTo(String value) {
            addCriterion("unified_social_credit =", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditNotEqualTo(String value) {
            addCriterion("unified_social_credit <>", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditGreaterThan(String value) {
            addCriterion("unified_social_credit >", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditGreaterThanOrEqualTo(String value) {
            addCriterion("unified_social_credit >=", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditLessThan(String value) {
            addCriterion("unified_social_credit <", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditLessThanOrEqualTo(String value) {
            addCriterion("unified_social_credit <=", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditLike(String value) {
            addCriterion("unified_social_credit like", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditNotLike(String value) {
            addCriterion("unified_social_credit not like", value, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditIn(List<String> values) {
            addCriterion("unified_social_credit in", values, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditNotIn(List<String> values) {
            addCriterion("unified_social_credit not in", values, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditBetween(String value1, String value2) {
            addCriterion("unified_social_credit between", value1, value2, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCreditNotBetween(String value1, String value2) {
            addCriterion("unified_social_credit not between", value1, value2, "unifiedSocialCredit");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdIsNull() {
            addCriterion("industrial_field_id is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdIsNotNull() {
            addCriterion("industrial_field_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdEqualTo(Integer value) {
            addCriterion("industrial_field_id =", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotEqualTo(Integer value) {
            addCriterion("industrial_field_id <>", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdGreaterThan(Integer value) {
            addCriterion("industrial_field_id >", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("industrial_field_id >=", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdLessThan(Integer value) {
            addCriterion("industrial_field_id <", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdLessThanOrEqualTo(Integer value) {
            addCriterion("industrial_field_id <=", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdIn(List<Integer> values) {
            addCriterion("industrial_field_id in", values, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotIn(List<Integer> values) {
            addCriterion("industrial_field_id not in", values, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdBetween(Integer value1, Integer value2) {
            addCriterion("industrial_field_id between", value1, value2, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("industrial_field_id not between", value1, value2, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameIsNull() {
            addCriterion("industrial_field_name is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameIsNotNull() {
            addCriterion("industrial_field_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameEqualTo(String value) {
            addCriterion("industrial_field_name =", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotEqualTo(String value) {
            addCriterion("industrial_field_name <>", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameGreaterThan(String value) {
            addCriterion("industrial_field_name >", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("industrial_field_name >=", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameLessThan(String value) {
            addCriterion("industrial_field_name <", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameLessThanOrEqualTo(String value) {
            addCriterion("industrial_field_name <=", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameLike(String value) {
            addCriterion("industrial_field_name like", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotLike(String value) {
            addCriterion("industrial_field_name not like", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameIn(List<String> values) {
            addCriterion("industrial_field_name in", values, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotIn(List<String> values) {
            addCriterion("industrial_field_name not in", values, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameBetween(String value1, String value2) {
            addCriterion("industrial_field_name between", value1, value2, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotBetween(String value1, String value2) {
            addCriterion("industrial_field_name not between", value1, value2, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonIsNull() {
            addCriterion("enterprise_legal_person is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonIsNotNull() {
            addCriterion("enterprise_legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonEqualTo(String value) {
            addCriterion("enterprise_legal_person =", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotEqualTo(String value) {
            addCriterion("enterprise_legal_person <>", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonGreaterThan(String value) {
            addCriterion("enterprise_legal_person >", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_legal_person >=", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonLessThan(String value) {
            addCriterion("enterprise_legal_person <", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("enterprise_legal_person <=", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonLike(String value) {
            addCriterion("enterprise_legal_person like", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotLike(String value) {
            addCriterion("enterprise_legal_person not like", value, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonIn(List<String> values) {
            addCriterion("enterprise_legal_person in", values, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotIn(List<String> values) {
            addCriterion("enterprise_legal_person not in", values, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonBetween(String value1, String value2) {
            addCriterion("enterprise_legal_person between", value1, value2, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLegalPersonNotBetween(String value1, String value2) {
            addCriterion("enterprise_legal_person not between", value1, value2, "enterpriseLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoIsNull() {
            addCriterion("company_logo is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoIsNotNull() {
            addCriterion("company_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoEqualTo(String value) {
            addCriterion("company_logo =", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotEqualTo(String value) {
            addCriterion("company_logo <>", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoGreaterThan(String value) {
            addCriterion("company_logo >", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoGreaterThanOrEqualTo(String value) {
            addCriterion("company_logo >=", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoLessThan(String value) {
            addCriterion("company_logo <", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoLessThanOrEqualTo(String value) {
            addCriterion("company_logo <=", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoLike(String value) {
            addCriterion("company_logo like", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotLike(String value) {
            addCriterion("company_logo not like", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoIn(List<String> values) {
            addCriterion("company_logo in", values, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotIn(List<String> values) {
            addCriterion("company_logo not in", values, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoBetween(String value1, String value2) {
            addCriterion("company_logo between", value1, value2, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotBetween(String value1, String value2) {
            addCriterion("company_logo not between", value1, value2, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileIsNull() {
            addCriterion("company_profile is null");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileIsNotNull() {
            addCriterion("company_profile is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileEqualTo(String value) {
            addCriterion("company_profile =", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotEqualTo(String value) {
            addCriterion("company_profile <>", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileGreaterThan(String value) {
            addCriterion("company_profile >", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileGreaterThanOrEqualTo(String value) {
            addCriterion("company_profile >=", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileLessThan(String value) {
            addCriterion("company_profile <", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileLessThanOrEqualTo(String value) {
            addCriterion("company_profile <=", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileLike(String value) {
            addCriterion("company_profile like", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotLike(String value) {
            addCriterion("company_profile not like", value, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileIn(List<String> values) {
            addCriterion("company_profile in", values, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotIn(List<String> values) {
            addCriterion("company_profile not in", values, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileBetween(String value1, String value2) {
            addCriterion("company_profile between", value1, value2, "companyProfile");
            return (Criteria) this;
        }

        public Criteria andCompanyProfileNotBetween(String value1, String value2) {
            addCriterion("company_profile not between", value1, value2, "companyProfile");
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

        public Criteria andProjectProfileIsNull() {
            addCriterion("project_profile is null");
            return (Criteria) this;
        }

        public Criteria andProjectProfileIsNotNull() {
            addCriterion("project_profile is not null");
            return (Criteria) this;
        }

        public Criteria andProjectProfileEqualTo(String value) {
            addCriterion("project_profile =", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileNotEqualTo(String value) {
            addCriterion("project_profile <>", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileGreaterThan(String value) {
            addCriterion("project_profile >", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileGreaterThanOrEqualTo(String value) {
            addCriterion("project_profile >=", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileLessThan(String value) {
            addCriterion("project_profile <", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileLessThanOrEqualTo(String value) {
            addCriterion("project_profile <=", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileLike(String value) {
            addCriterion("project_profile like", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileNotLike(String value) {
            addCriterion("project_profile not like", value, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileIn(List<String> values) {
            addCriterion("project_profile in", values, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileNotIn(List<String> values) {
            addCriterion("project_profile not in", values, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileBetween(String value1, String value2) {
            addCriterion("project_profile between", value1, value2, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andProjectProfileNotBetween(String value1, String value2) {
            addCriterion("project_profile not between", value1, value2, "projectProfile");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(String value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(String value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(String value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(String value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(String value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLike(String value) {
            addCriterion("team_id like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotLike(String value) {
            addCriterion("team_id not like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<String> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<String> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(String value1, String value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(String value1, String value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneIsNull() {
            addCriterion("contact_telephone is null");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneIsNotNull() {
            addCriterion("contact_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneEqualTo(String value) {
            addCriterion("contact_telephone =", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotEqualTo(String value) {
            addCriterion("contact_telephone <>", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneGreaterThan(String value) {
            addCriterion("contact_telephone >", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_telephone >=", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneLessThan(String value) {
            addCriterion("contact_telephone <", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneLessThanOrEqualTo(String value) {
            addCriterion("contact_telephone <=", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneLike(String value) {
            addCriterion("contact_telephone like", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotLike(String value) {
            addCriterion("contact_telephone not like", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneIn(List<String> values) {
            addCriterion("contact_telephone in", values, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotIn(List<String> values) {
            addCriterion("contact_telephone not in", values, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneBetween(String value1, String value2) {
            addCriterion("contact_telephone between", value1, value2, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotBetween(String value1, String value2) {
            addCriterion("contact_telephone not between", value1, value2, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNull() {
            addCriterion("contact_email is null");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNotNull() {
            addCriterion("contact_email is not null");
            return (Criteria) this;
        }

        public Criteria andContactEmailEqualTo(String value) {
            addCriterion("contact_email =", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotEqualTo(String value) {
            addCriterion("contact_email <>", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThan(String value) {
            addCriterion("contact_email >", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThanOrEqualTo(String value) {
            addCriterion("contact_email >=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThan(String value) {
            addCriterion("contact_email <", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThanOrEqualTo(String value) {
            addCriterion("contact_email <=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLike(String value) {
            addCriterion("contact_email like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotLike(String value) {
            addCriterion("contact_email not like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailIn(List<String> values) {
            addCriterion("contact_email in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotIn(List<String> values) {
            addCriterion("contact_email not in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailBetween(String value1, String value2) {
            addCriterion("contact_email between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotBetween(String value1, String value2) {
            addCriterion("contact_email not between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileIsNull() {
            addCriterion("project_introduction_file is null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileIsNotNull() {
            addCriterion("project_introduction_file is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileEqualTo(String value) {
            addCriterion("project_introduction_file =", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileNotEqualTo(String value) {
            addCriterion("project_introduction_file <>", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileGreaterThan(String value) {
            addCriterion("project_introduction_file >", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileGreaterThanOrEqualTo(String value) {
            addCriterion("project_introduction_file >=", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileLessThan(String value) {
            addCriterion("project_introduction_file <", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileLessThanOrEqualTo(String value) {
            addCriterion("project_introduction_file <=", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileLike(String value) {
            addCriterion("project_introduction_file like", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileNotLike(String value) {
            addCriterion("project_introduction_file not like", value, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileIn(List<String> values) {
            addCriterion("project_introduction_file in", values, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileNotIn(List<String> values) {
            addCriterion("project_introduction_file not in", values, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileBetween(String value1, String value2) {
            addCriterion("project_introduction_file between", value1, value2, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionFileNotBetween(String value1, String value2) {
            addCriterion("project_introduction_file not between", value1, value2, "projectIntroductionFile");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeIsNull() {
            addCriterion("policy_notice is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeIsNotNull() {
            addCriterion("policy_notice is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeEqualTo(String value) {
            addCriterion("policy_notice =", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeNotEqualTo(String value) {
            addCriterion("policy_notice <>", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeGreaterThan(String value) {
            addCriterion("policy_notice >", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("policy_notice >=", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeLessThan(String value) {
            addCriterion("policy_notice <", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeLessThanOrEqualTo(String value) {
            addCriterion("policy_notice <=", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeLike(String value) {
            addCriterion("policy_notice like", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeNotLike(String value) {
            addCriterion("policy_notice not like", value, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeIn(List<String> values) {
            addCriterion("policy_notice in", values, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeNotIn(List<String> values) {
            addCriterion("policy_notice not in", values, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeBetween(String value1, String value2) {
            addCriterion("policy_notice between", value1, value2, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyNoticeNotBetween(String value1, String value2) {
            addCriterion("policy_notice not between", value1, value2, "policyNotice");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutIsNull() {
            addCriterion("policy_is_send_out is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutIsNotNull() {
            addCriterion("policy_is_send_out is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutEqualTo(Byte value) {
            addCriterion("policy_is_send_out =", value, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutNotEqualTo(Byte value) {
            addCriterion("policy_is_send_out <>", value, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutGreaterThan(Byte value) {
            addCriterion("policy_is_send_out >", value, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutGreaterThanOrEqualTo(Byte value) {
            addCriterion("policy_is_send_out >=", value, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutLessThan(Byte value) {
            addCriterion("policy_is_send_out <", value, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutLessThanOrEqualTo(Byte value) {
            addCriterion("policy_is_send_out <=", value, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutIn(List<Byte> values) {
            addCriterion("policy_is_send_out in", values, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutNotIn(List<Byte> values) {
            addCriterion("policy_is_send_out not in", values, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutBetween(Byte value1, Byte value2) {
            addCriterion("policy_is_send_out between", value1, value2, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andPolicyIsSendOutNotBetween(Byte value1, Byte value2) {
            addCriterion("policy_is_send_out not between", value1, value2, "policyIsSendOut");
            return (Criteria) this;
        }

        public Criteria andLabelNameIsNull() {
            addCriterion("label_name is null");
            return (Criteria) this;
        }

        public Criteria andLabelNameIsNotNull() {
            addCriterion("label_name is not null");
            return (Criteria) this;
        }

        public Criteria andLabelNameEqualTo(String value) {
            addCriterion("label_name =", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotEqualTo(String value) {
            addCriterion("label_name <>", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameGreaterThan(String value) {
            addCriterion("label_name >", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameGreaterThanOrEqualTo(String value) {
            addCriterion("label_name >=", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameLessThan(String value) {
            addCriterion("label_name <", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameLessThanOrEqualTo(String value) {
            addCriterion("label_name <=", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameLike(String value) {
            addCriterion("label_name like", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotLike(String value) {
            addCriterion("label_name not like", value, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameIn(List<String> values) {
            addCriterion("label_name in", values, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotIn(List<String> values) {
            addCriterion("label_name not in", values, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameBetween(String value1, String value2) {
            addCriterion("label_name between", value1, value2, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelNameNotBetween(String value1, String value2) {
            addCriterion("label_name not between", value1, value2, "labelName");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNull() {
            addCriterion("label_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("label_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualTo(String value) {
            addCriterion("label_id =", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(String value) {
            addCriterion("label_id <>", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThan(String value) {
            addCriterion("label_id >", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(String value) {
            addCriterion("label_id >=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(String value) {
            addCriterion("label_id <", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(String value) {
            addCriterion("label_id <=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLike(String value) {
            addCriterion("label_id like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotLike(String value) {
            addCriterion("label_id not like", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIn(List<String> values) {
            addCriterion("label_id in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<String> values) {
            addCriterion("label_id not in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(String value1, String value2) {
            addCriterion("label_id between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(String value1, String value2) {
            addCriterion("label_id not between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameIsNull() {
            addCriterion("settle_is_complete_nuclear_name is null");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameIsNotNull() {
            addCriterion("settle_is_complete_nuclear_name is not null");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameEqualTo(Byte value) {
            addCriterion("settle_is_complete_nuclear_name =", value, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameNotEqualTo(Byte value) {
            addCriterion("settle_is_complete_nuclear_name <>", value, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameGreaterThan(Byte value) {
            addCriterion("settle_is_complete_nuclear_name >", value, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameGreaterThanOrEqualTo(Byte value) {
            addCriterion("settle_is_complete_nuclear_name >=", value, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameLessThan(Byte value) {
            addCriterion("settle_is_complete_nuclear_name <", value, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameLessThanOrEqualTo(Byte value) {
            addCriterion("settle_is_complete_nuclear_name <=", value, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameIn(List<Byte> values) {
            addCriterion("settle_is_complete_nuclear_name in", values, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameNotIn(List<Byte> values) {
            addCriterion("settle_is_complete_nuclear_name not in", values, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameBetween(Byte value1, Byte value2) {
            addCriterion("settle_is_complete_nuclear_name between", value1, value2, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompleteNuclearNameNotBetween(Byte value1, Byte value2) {
            addCriterion("settle_is_complete_nuclear_name not between", value1, value2, "settleIsCompleteNuclearName");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectIsNull() {
            addCriterion("settle_is_license_collect is null");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectIsNotNull() {
            addCriterion("settle_is_license_collect is not null");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectEqualTo(Byte value) {
            addCriterion("settle_is_license_collect =", value, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectNotEqualTo(Byte value) {
            addCriterion("settle_is_license_collect <>", value, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectGreaterThan(Byte value) {
            addCriterion("settle_is_license_collect >", value, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectGreaterThanOrEqualTo(Byte value) {
            addCriterion("settle_is_license_collect >=", value, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectLessThan(Byte value) {
            addCriterion("settle_is_license_collect <", value, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectLessThanOrEqualTo(Byte value) {
            addCriterion("settle_is_license_collect <=", value, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectIn(List<Byte> values) {
            addCriterion("settle_is_license_collect in", values, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectNotIn(List<Byte> values) {
            addCriterion("settle_is_license_collect not in", values, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectBetween(Byte value1, Byte value2) {
            addCriterion("settle_is_license_collect between", value1, value2, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsLicenseCollectNotBetween(Byte value1, Byte value2) {
            addCriterion("settle_is_license_collect not between", value1, value2, "settleIsLicenseCollect");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealIsNull() {
            addCriterion("settle_is_completion_seal is null");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealIsNotNull() {
            addCriterion("settle_is_completion_seal is not null");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealEqualTo(Byte value) {
            addCriterion("settle_is_completion_seal =", value, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealNotEqualTo(Byte value) {
            addCriterion("settle_is_completion_seal <>", value, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealGreaterThan(Byte value) {
            addCriterion("settle_is_completion_seal >", value, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealGreaterThanOrEqualTo(Byte value) {
            addCriterion("settle_is_completion_seal >=", value, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealLessThan(Byte value) {
            addCriterion("settle_is_completion_seal <", value, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealLessThanOrEqualTo(Byte value) {
            addCriterion("settle_is_completion_seal <=", value, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealIn(List<Byte> values) {
            addCriterion("settle_is_completion_seal in", values, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealNotIn(List<Byte> values) {
            addCriterion("settle_is_completion_seal not in", values, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealBetween(Byte value1, Byte value2) {
            addCriterion("settle_is_completion_seal between", value1, value2, "settleIsCompletionSeal");
            return (Criteria) this;
        }

        public Criteria andSettleIsCompletionSealNotBetween(Byte value1, Byte value2) {
            addCriterion("settle_is_completion_seal not between", value1, value2, "settleIsCompletionSeal");
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