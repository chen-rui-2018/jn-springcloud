package com.jn.enterprise.pd.enterprise.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdEnterpriseSelfEvaluaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdEnterpriseSelfEvaluaCriteria() {
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

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
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

        public Criteria andContactsNameIsNull() {
            addCriterion("contacts_name is null");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNotNull() {
            addCriterion("contacts_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactsNameEqualTo(String value) {
            addCriterion("contacts_name =", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotEqualTo(String value) {
            addCriterion("contacts_name <>", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThan(String value) {
            addCriterion("contacts_name >", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_name >=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThan(String value) {
            addCriterion("contacts_name <", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThanOrEqualTo(String value) {
            addCriterion("contacts_name <=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLike(String value) {
            addCriterion("contacts_name like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotLike(String value) {
            addCriterion("contacts_name not like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameIn(List<String> values) {
            addCriterion("contacts_name in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotIn(List<String> values) {
            addCriterion("contacts_name not in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameBetween(String value1, String value2) {
            addCriterion("contacts_name between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotBetween(String value1, String value2) {
            addCriterion("contacts_name not between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIsNull() {
            addCriterion("contacts_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIsNotNull() {
            addCriterion("contacts_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneEqualTo(String value) {
            addCriterion("contacts_phone =", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotEqualTo(String value) {
            addCriterion("contacts_phone <>", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneGreaterThan(String value) {
            addCriterion("contacts_phone >", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_phone >=", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLessThan(String value) {
            addCriterion("contacts_phone <", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLessThanOrEqualTo(String value) {
            addCriterion("contacts_phone <=", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneLike(String value) {
            addCriterion("contacts_phone like", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotLike(String value) {
            addCriterion("contacts_phone not like", value, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneIn(List<String> values) {
            addCriterion("contacts_phone in", values, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotIn(List<String> values) {
            addCriterion("contacts_phone not in", values, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneBetween(String value1, String value2) {
            addCriterion("contacts_phone between", value1, value2, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsPhoneNotBetween(String value1, String value2) {
            addCriterion("contacts_phone not between", value1, value2, "contactsPhone");
            return (Criteria) this;
        }

        public Criteria andContactsEmailIsNull() {
            addCriterion("contacts_email is null");
            return (Criteria) this;
        }

        public Criteria andContactsEmailIsNotNull() {
            addCriterion("contacts_email is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEmailEqualTo(String value) {
            addCriterion("contacts_email =", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailNotEqualTo(String value) {
            addCriterion("contacts_email <>", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailGreaterThan(String value) {
            addCriterion("contacts_email >", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_email >=", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailLessThan(String value) {
            addCriterion("contacts_email <", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailLessThanOrEqualTo(String value) {
            addCriterion("contacts_email <=", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailLike(String value) {
            addCriterion("contacts_email like", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailNotLike(String value) {
            addCriterion("contacts_email not like", value, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailIn(List<String> values) {
            addCriterion("contacts_email in", values, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailNotIn(List<String> values) {
            addCriterion("contacts_email not in", values, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailBetween(String value1, String value2) {
            addCriterion("contacts_email between", value1, value2, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andContactsEmailNotBetween(String value1, String value2) {
            addCriterion("contacts_email not between", value1, value2, "contactsEmail");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeIsNull() {
            addCriterion("enterprise_registration_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeIsNotNull() {
            addCriterion("enterprise_registration_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeEqualTo(Date value) {
            addCriterion("enterprise_registration_time =", value, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeNotEqualTo(Date value) {
            addCriterion("enterprise_registration_time <>", value, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeGreaterThan(Date value) {
            addCriterion("enterprise_registration_time >", value, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enterprise_registration_time >=", value, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeLessThan(Date value) {
            addCriterion("enterprise_registration_time <", value, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeLessThanOrEqualTo(Date value) {
            addCriterion("enterprise_registration_time <=", value, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeIn(List<Date> values) {
            addCriterion("enterprise_registration_time in", values, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeNotIn(List<Date> values) {
            addCriterion("enterprise_registration_time not in", values, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeBetween(Date value1, Date value2) {
            addCriterion("enterprise_registration_time between", value1, value2, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseRegistrationTimeNotBetween(Date value1, Date value2) {
            addCriterion("enterprise_registration_time not between", value1, value2, "enterpriseRegistrationTime");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryIsNull() {
            addCriterion("is_china_territory is null");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryIsNotNull() {
            addCriterion("is_china_territory is not null");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryEqualTo(Byte value) {
            addCriterion("is_china_territory =", value, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryNotEqualTo(Byte value) {
            addCriterion("is_china_territory <>", value, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryGreaterThan(Byte value) {
            addCriterion("is_china_territory >", value, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_china_territory >=", value, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryLessThan(Byte value) {
            addCriterion("is_china_territory <", value, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryLessThanOrEqualTo(Byte value) {
            addCriterion("is_china_territory <=", value, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryIn(List<Byte> values) {
            addCriterion("is_china_territory in", values, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryNotIn(List<Byte> values) {
            addCriterion("is_china_territory not in", values, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryBetween(Byte value1, Byte value2) {
            addCriterion("is_china_territory between", value1, value2, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andIsChinaTerritoryNotBetween(Byte value1, Byte value2) {
            addCriterion("is_china_territory not between", value1, value2, "isChinaTerritory");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyIsNull() {
            addCriterion("is_core_technology is null");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyIsNotNull() {
            addCriterion("is_core_technology is not null");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyEqualTo(Byte value) {
            addCriterion("is_core_technology =", value, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyNotEqualTo(Byte value) {
            addCriterion("is_core_technology <>", value, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyGreaterThan(Byte value) {
            addCriterion("is_core_technology >", value, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_core_technology >=", value, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyLessThan(Byte value) {
            addCriterion("is_core_technology <", value, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyLessThanOrEqualTo(Byte value) {
            addCriterion("is_core_technology <=", value, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyIn(List<Byte> values) {
            addCriterion("is_core_technology in", values, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyNotIn(List<Byte> values) {
            addCriterion("is_core_technology not in", values, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyBetween(Byte value1, Byte value2) {
            addCriterion("is_core_technology between", value1, value2, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andIsCoreTechnologyNotBetween(Byte value1, Byte value2) {
            addCriterion("is_core_technology not between", value1, value2, "isCoreTechnology");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodIsNull() {
            addCriterion("technical_neighborhood is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodIsNotNull() {
            addCriterion("technical_neighborhood is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodEqualTo(String value) {
            addCriterion("technical_neighborhood =", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodNotEqualTo(String value) {
            addCriterion("technical_neighborhood <>", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodGreaterThan(String value) {
            addCriterion("technical_neighborhood >", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodGreaterThanOrEqualTo(String value) {
            addCriterion("technical_neighborhood >=", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodLessThan(String value) {
            addCriterion("technical_neighborhood <", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodLessThanOrEqualTo(String value) {
            addCriterion("technical_neighborhood <=", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodLike(String value) {
            addCriterion("technical_neighborhood like", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodNotLike(String value) {
            addCriterion("technical_neighborhood not like", value, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodIn(List<String> values) {
            addCriterion("technical_neighborhood in", values, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodNotIn(List<String> values) {
            addCriterion("technical_neighborhood not in", values, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodBetween(String value1, String value2) {
            addCriterion("technical_neighborhood between", value1, value2, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andTechnicalNeighborhoodNotBetween(String value1, String value2) {
            addCriterion("technical_neighborhood not between", value1, value2, "technicalNeighborhood");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalIsNull() {
            addCriterion("workers_tatal is null");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalIsNotNull() {
            addCriterion("workers_tatal is not null");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalEqualTo(Integer value) {
            addCriterion("workers_tatal =", value, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalNotEqualTo(Integer value) {
            addCriterion("workers_tatal <>", value, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalGreaterThan(Integer value) {
            addCriterion("workers_tatal >", value, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalGreaterThanOrEqualTo(Integer value) {
            addCriterion("workers_tatal >=", value, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalLessThan(Integer value) {
            addCriterion("workers_tatal <", value, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalLessThanOrEqualTo(Integer value) {
            addCriterion("workers_tatal <=", value, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalIn(List<Integer> values) {
            addCriterion("workers_tatal in", values, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalNotIn(List<Integer> values) {
            addCriterion("workers_tatal not in", values, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalBetween(Integer value1, Integer value2) {
            addCriterion("workers_tatal between", value1, value2, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andWorkersTatalNotBetween(Integer value1, Integer value2) {
            addCriterion("workers_tatal not between", value1, value2, "workersTatal");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelIsNull() {
            addCriterion("technical_personnel is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelIsNotNull() {
            addCriterion("technical_personnel is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelEqualTo(Integer value) {
            addCriterion("technical_personnel =", value, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelNotEqualTo(Integer value) {
            addCriterion("technical_personnel <>", value, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelGreaterThan(Integer value) {
            addCriterion("technical_personnel >", value, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelGreaterThanOrEqualTo(Integer value) {
            addCriterion("technical_personnel >=", value, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelLessThan(Integer value) {
            addCriterion("technical_personnel <", value, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelLessThanOrEqualTo(Integer value) {
            addCriterion("technical_personnel <=", value, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelIn(List<Integer> values) {
            addCriterion("technical_personnel in", values, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelNotIn(List<Integer> values) {
            addCriterion("technical_personnel not in", values, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelBetween(Integer value1, Integer value2) {
            addCriterion("technical_personnel between", value1, value2, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andTechnicalPersonnelNotBetween(Integer value1, Integer value2) {
            addCriterion("technical_personnel not between", value1, value2, "technicalPersonnel");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesIsNull() {
            addCriterion("is_illegal_activities is null");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesIsNotNull() {
            addCriterion("is_illegal_activities is not null");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesEqualTo(Byte value) {
            addCriterion("is_illegal_activities =", value, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesNotEqualTo(Byte value) {
            addCriterion("is_illegal_activities <>", value, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesGreaterThan(Byte value) {
            addCriterion("is_illegal_activities >", value, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_illegal_activities >=", value, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesLessThan(Byte value) {
            addCriterion("is_illegal_activities <", value, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesLessThanOrEqualTo(Byte value) {
            addCriterion("is_illegal_activities <=", value, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesIn(List<Byte> values) {
            addCriterion("is_illegal_activities in", values, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesNotIn(List<Byte> values) {
            addCriterion("is_illegal_activities not in", values, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesBetween(Byte value1, Byte value2) {
            addCriterion("is_illegal_activities between", value1, value2, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andIsIllegalActivitiesNotBetween(Byte value1, Byte value2) {
            addCriterion("is_illegal_activities not between", value1, value2, "isIllegalActivities");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1IsNull() {
            addCriterion("corporate_income_1 is null");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1IsNotNull() {
            addCriterion("corporate_income_1 is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1EqualTo(BigDecimal value) {
            addCriterion("corporate_income_1 =", value, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1NotEqualTo(BigDecimal value) {
            addCriterion("corporate_income_1 <>", value, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1GreaterThan(BigDecimal value) {
            addCriterion("corporate_income_1 >", value, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("corporate_income_1 >=", value, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1LessThan(BigDecimal value) {
            addCriterion("corporate_income_1 <", value, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("corporate_income_1 <=", value, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1In(List<BigDecimal> values) {
            addCriterion("corporate_income_1 in", values, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1NotIn(List<BigDecimal> values) {
            addCriterion("corporate_income_1 not in", values, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("corporate_income_1 between", value1, value2, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("corporate_income_1 not between", value1, value2, "corporateIncome1");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2IsNull() {
            addCriterion("corporate_income_2 is null");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2IsNotNull() {
            addCriterion("corporate_income_2 is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2EqualTo(BigDecimal value) {
            addCriterion("corporate_income_2 =", value, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2NotEqualTo(BigDecimal value) {
            addCriterion("corporate_income_2 <>", value, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2GreaterThan(BigDecimal value) {
            addCriterion("corporate_income_2 >", value, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("corporate_income_2 >=", value, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2LessThan(BigDecimal value) {
            addCriterion("corporate_income_2 <", value, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("corporate_income_2 <=", value, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2In(List<BigDecimal> values) {
            addCriterion("corporate_income_2 in", values, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2NotIn(List<BigDecimal> values) {
            addCriterion("corporate_income_2 not in", values, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("corporate_income_2 between", value1, value2, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("corporate_income_2 not between", value1, value2, "corporateIncome2");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3IsNull() {
            addCriterion("corporate_income_3 is null");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3IsNotNull() {
            addCriterion("corporate_income_3 is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3EqualTo(BigDecimal value) {
            addCriterion("corporate_income_3 =", value, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3NotEqualTo(BigDecimal value) {
            addCriterion("corporate_income_3 <>", value, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3GreaterThan(BigDecimal value) {
            addCriterion("corporate_income_3 >", value, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("corporate_income_3 >=", value, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3LessThan(BigDecimal value) {
            addCriterion("corporate_income_3 <", value, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("corporate_income_3 <=", value, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3In(List<BigDecimal> values) {
            addCriterion("corporate_income_3 in", values, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3NotIn(List<BigDecimal> values) {
            addCriterion("corporate_income_3 not in", values, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("corporate_income_3 between", value1, value2, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andCorporateIncome3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("corporate_income_3 not between", value1, value2, "corporateIncome3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1IsNull() {
            addCriterion("total_sales_revenue_1 is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1IsNotNull() {
            addCriterion("total_sales_revenue_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1EqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_1 =", value, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1NotEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_1 <>", value, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1GreaterThan(BigDecimal value) {
            addCriterion("total_sales_revenue_1 >", value, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_1 >=", value, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1LessThan(BigDecimal value) {
            addCriterion("total_sales_revenue_1 <", value, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_1 <=", value, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1In(List<BigDecimal> values) {
            addCriterion("total_sales_revenue_1 in", values, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1NotIn(List<BigDecimal> values) {
            addCriterion("total_sales_revenue_1 not in", values, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_revenue_1 between", value1, value2, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_revenue_1 not between", value1, value2, "totalSalesRevenue1");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2IsNull() {
            addCriterion("total_sales_revenue_2 is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2IsNotNull() {
            addCriterion("total_sales_revenue_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2EqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_2 =", value, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2NotEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_2 <>", value, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2GreaterThan(BigDecimal value) {
            addCriterion("total_sales_revenue_2 >", value, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_2 >=", value, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2LessThan(BigDecimal value) {
            addCriterion("total_sales_revenue_2 <", value, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_2 <=", value, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2In(List<BigDecimal> values) {
            addCriterion("total_sales_revenue_2 in", values, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2NotIn(List<BigDecimal> values) {
            addCriterion("total_sales_revenue_2 not in", values, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_revenue_2 between", value1, value2, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_revenue_2 not between", value1, value2, "totalSalesRevenue2");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3IsNull() {
            addCriterion("total_sales_revenue_3 is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3IsNotNull() {
            addCriterion("total_sales_revenue_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3EqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_3 =", value, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3NotEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_3 <>", value, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3GreaterThan(BigDecimal value) {
            addCriterion("total_sales_revenue_3 >", value, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_3 >=", value, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3LessThan(BigDecimal value) {
            addCriterion("total_sales_revenue_3 <", value, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_sales_revenue_3 <=", value, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3In(List<BigDecimal> values) {
            addCriterion("total_sales_revenue_3 in", values, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3NotIn(List<BigDecimal> values) {
            addCriterion("total_sales_revenue_3 not in", values, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_revenue_3 between", value1, value2, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalSalesRevenue3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_sales_revenue_3 not between", value1, value2, "totalSalesRevenue3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1IsNull() {
            addCriterion("total_revenue_products_1 is null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1IsNotNull() {
            addCriterion("total_revenue_products_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1EqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_1 =", value, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1NotEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_1 <>", value, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1GreaterThan(BigDecimal value) {
            addCriterion("total_revenue_products_1 >", value, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_1 >=", value, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1LessThan(BigDecimal value) {
            addCriterion("total_revenue_products_1 <", value, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_1 <=", value, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1In(List<BigDecimal> values) {
            addCriterion("total_revenue_products_1 in", values, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1NotIn(List<BigDecimal> values) {
            addCriterion("total_revenue_products_1 not in", values, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue_products_1 between", value1, value2, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue_products_1 not between", value1, value2, "totalRevenueProducts1");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2IsNull() {
            addCriterion("total_revenue_products_2 is null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2IsNotNull() {
            addCriterion("total_revenue_products_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2EqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_2 =", value, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2NotEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_2 <>", value, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2GreaterThan(BigDecimal value) {
            addCriterion("total_revenue_products_2 >", value, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_2 >=", value, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2LessThan(BigDecimal value) {
            addCriterion("total_revenue_products_2 <", value, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_2 <=", value, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2In(List<BigDecimal> values) {
            addCriterion("total_revenue_products_2 in", values, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2NotIn(List<BigDecimal> values) {
            addCriterion("total_revenue_products_2 not in", values, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue_products_2 between", value1, value2, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue_products_2 not between", value1, value2, "totalRevenueProducts2");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3IsNull() {
            addCriterion("total_revenue_products_3 is null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3IsNotNull() {
            addCriterion("total_revenue_products_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3EqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_3 =", value, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3NotEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_3 <>", value, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3GreaterThan(BigDecimal value) {
            addCriterion("total_revenue_products_3 >", value, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_3 >=", value, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3LessThan(BigDecimal value) {
            addCriterion("total_revenue_products_3 <", value, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_revenue_products_3 <=", value, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3In(List<BigDecimal> values) {
            addCriterion("total_revenue_products_3 in", values, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3NotIn(List<BigDecimal> values) {
            addCriterion("total_revenue_products_3 not in", values, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue_products_3 between", value1, value2, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalRevenueProducts3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_revenue_products_3 not between", value1, value2, "totalRevenueProducts3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1IsNull() {
            addCriterion("total_amount_research_1 is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1IsNotNull() {
            addCriterion("total_amount_research_1 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1EqualTo(BigDecimal value) {
            addCriterion("total_amount_research_1 =", value, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1NotEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_1 <>", value, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1GreaterThan(BigDecimal value) {
            addCriterion("total_amount_research_1 >", value, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_1 >=", value, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1LessThan(BigDecimal value) {
            addCriterion("total_amount_research_1 <", value, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_1 <=", value, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1In(List<BigDecimal> values) {
            addCriterion("total_amount_research_1 in", values, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1NotIn(List<BigDecimal> values) {
            addCriterion("total_amount_research_1 not in", values, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_research_1 between", value1, value2, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_research_1 not between", value1, value2, "totalAmountResearch1");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2IsNull() {
            addCriterion("total_amount_research_2 is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2IsNotNull() {
            addCriterion("total_amount_research_2 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2EqualTo(BigDecimal value) {
            addCriterion("total_amount_research_2 =", value, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2NotEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_2 <>", value, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2GreaterThan(BigDecimal value) {
            addCriterion("total_amount_research_2 >", value, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_2 >=", value, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2LessThan(BigDecimal value) {
            addCriterion("total_amount_research_2 <", value, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_2 <=", value, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2In(List<BigDecimal> values) {
            addCriterion("total_amount_research_2 in", values, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2NotIn(List<BigDecimal> values) {
            addCriterion("total_amount_research_2 not in", values, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_research_2 between", value1, value2, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_research_2 not between", value1, value2, "totalAmountResearch2");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3IsNull() {
            addCriterion("total_amount_research_3 is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3IsNotNull() {
            addCriterion("total_amount_research_3 is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3EqualTo(BigDecimal value) {
            addCriterion("total_amount_research_3 =", value, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3NotEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_3 <>", value, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3GreaterThan(BigDecimal value) {
            addCriterion("total_amount_research_3 >", value, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_3 >=", value, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3LessThan(BigDecimal value) {
            addCriterion("total_amount_research_3 <", value, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount_research_3 <=", value, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3In(List<BigDecimal> values) {
            addCriterion("total_amount_research_3 in", values, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3NotIn(List<BigDecimal> values) {
            addCriterion("total_amount_research_3 not in", values, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_research_3 between", value1, value2, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andTotalAmountResearch3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount_research_3 not between", value1, value2, "totalAmountResearch3");
            return (Criteria) this;
        }

        public Criteria andResearchChina1IsNull() {
            addCriterion("research_china_1 is null");
            return (Criteria) this;
        }

        public Criteria andResearchChina1IsNotNull() {
            addCriterion("research_china_1 is not null");
            return (Criteria) this;
        }

        public Criteria andResearchChina1EqualTo(BigDecimal value) {
            addCriterion("research_china_1 =", value, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1NotEqualTo(BigDecimal value) {
            addCriterion("research_china_1 <>", value, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1GreaterThan(BigDecimal value) {
            addCriterion("research_china_1 >", value, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("research_china_1 >=", value, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1LessThan(BigDecimal value) {
            addCriterion("research_china_1 <", value, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("research_china_1 <=", value, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1In(List<BigDecimal> values) {
            addCriterion("research_china_1 in", values, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1NotIn(List<BigDecimal> values) {
            addCriterion("research_china_1 not in", values, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("research_china_1 between", value1, value2, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("research_china_1 not between", value1, value2, "researchChina1");
            return (Criteria) this;
        }

        public Criteria andResearchChina2IsNull() {
            addCriterion("research_china_2 is null");
            return (Criteria) this;
        }

        public Criteria andResearchChina2IsNotNull() {
            addCriterion("research_china_2 is not null");
            return (Criteria) this;
        }

        public Criteria andResearchChina2EqualTo(BigDecimal value) {
            addCriterion("research_china_2 =", value, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2NotEqualTo(BigDecimal value) {
            addCriterion("research_china_2 <>", value, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2GreaterThan(BigDecimal value) {
            addCriterion("research_china_2 >", value, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("research_china_2 >=", value, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2LessThan(BigDecimal value) {
            addCriterion("research_china_2 <", value, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("research_china_2 <=", value, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2In(List<BigDecimal> values) {
            addCriterion("research_china_2 in", values, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2NotIn(List<BigDecimal> values) {
            addCriterion("research_china_2 not in", values, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("research_china_2 between", value1, value2, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("research_china_2 not between", value1, value2, "researchChina2");
            return (Criteria) this;
        }

        public Criteria andResearchChina3IsNull() {
            addCriterion("research_china_3 is null");
            return (Criteria) this;
        }

        public Criteria andResearchChina3IsNotNull() {
            addCriterion("research_china_3 is not null");
            return (Criteria) this;
        }

        public Criteria andResearchChina3EqualTo(BigDecimal value) {
            addCriterion("research_china_3 =", value, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3NotEqualTo(BigDecimal value) {
            addCriterion("research_china_3 <>", value, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3GreaterThan(BigDecimal value) {
            addCriterion("research_china_3 >", value, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("research_china_3 >=", value, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3LessThan(BigDecimal value) {
            addCriterion("research_china_3 <", value, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("research_china_3 <=", value, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3In(List<BigDecimal> values) {
            addCriterion("research_china_3 in", values, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3NotIn(List<BigDecimal> values) {
            addCriterion("research_china_3 not in", values, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("research_china_3 between", value1, value2, "researchChina3");
            return (Criteria) this;
        }

        public Criteria andResearchChina3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("research_china_3 not between", value1, value2, "researchChina3");
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