package com.jn.enterprise.pd.declaration.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdDeclarationPlatformManageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdDeclarationPlatformManageCriteria() {
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

        public Criteria andPlatformTitleIsNull() {
            addCriterion("platform_title is null");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleIsNotNull() {
            addCriterion("platform_title is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleEqualTo(String value) {
            addCriterion("platform_title =", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleNotEqualTo(String value) {
            addCriterion("platform_title <>", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleGreaterThan(String value) {
            addCriterion("platform_title >", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleGreaterThanOrEqualTo(String value) {
            addCriterion("platform_title >=", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleLessThan(String value) {
            addCriterion("platform_title <", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleLessThanOrEqualTo(String value) {
            addCriterion("platform_title <=", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleLike(String value) {
            addCriterion("platform_title like", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleNotLike(String value) {
            addCriterion("platform_title not like", value, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleIn(List<String> values) {
            addCriterion("platform_title in", values, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleNotIn(List<String> values) {
            addCriterion("platform_title not in", values, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleBetween(String value1, String value2) {
            addCriterion("platform_title between", value1, value2, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andPlatformTitleNotBetween(String value1, String value2) {
            addCriterion("platform_title not between", value1, value2, "platformTitle");
            return (Criteria) this;
        }

        public Criteria andLinkAddressIsNull() {
            addCriterion("link_address is null");
            return (Criteria) this;
        }

        public Criteria andLinkAddressIsNotNull() {
            addCriterion("link_address is not null");
            return (Criteria) this;
        }

        public Criteria andLinkAddressEqualTo(String value) {
            addCriterion("link_address =", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotEqualTo(String value) {
            addCriterion("link_address <>", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressGreaterThan(String value) {
            addCriterion("link_address >", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("link_address >=", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressLessThan(String value) {
            addCriterion("link_address <", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressLessThanOrEqualTo(String value) {
            addCriterion("link_address <=", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressLike(String value) {
            addCriterion("link_address like", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotLike(String value) {
            addCriterion("link_address not like", value, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressIn(List<String> values) {
            addCriterion("link_address in", values, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotIn(List<String> values) {
            addCriterion("link_address not in", values, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressBetween(String value1, String value2) {
            addCriterion("link_address between", value1, value2, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andLinkAddressNotBetween(String value1, String value2) {
            addCriterion("link_address not between", value1, value2, "linkAddress");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultIsNull() {
            addCriterion("business_consult is null");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultIsNotNull() {
            addCriterion("business_consult is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultEqualTo(String value) {
            addCriterion("business_consult =", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultNotEqualTo(String value) {
            addCriterion("business_consult <>", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultGreaterThan(String value) {
            addCriterion("business_consult >", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultGreaterThanOrEqualTo(String value) {
            addCriterion("business_consult >=", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultLessThan(String value) {
            addCriterion("business_consult <", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultLessThanOrEqualTo(String value) {
            addCriterion("business_consult <=", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultLike(String value) {
            addCriterion("business_consult like", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultNotLike(String value) {
            addCriterion("business_consult not like", value, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultIn(List<String> values) {
            addCriterion("business_consult in", values, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultNotIn(List<String> values) {
            addCriterion("business_consult not in", values, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultBetween(String value1, String value2) {
            addCriterion("business_consult between", value1, value2, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andBusinessConsultNotBetween(String value1, String value2) {
            addCriterion("business_consult not between", value1, value2, "businessConsult");
            return (Criteria) this;
        }

        public Criteria andSystemSupportIsNull() {
            addCriterion("system_support is null");
            return (Criteria) this;
        }

        public Criteria andSystemSupportIsNotNull() {
            addCriterion("system_support is not null");
            return (Criteria) this;
        }

        public Criteria andSystemSupportEqualTo(String value) {
            addCriterion("system_support =", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportNotEqualTo(String value) {
            addCriterion("system_support <>", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportGreaterThan(String value) {
            addCriterion("system_support >", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportGreaterThanOrEqualTo(String value) {
            addCriterion("system_support >=", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportLessThan(String value) {
            addCriterion("system_support <", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportLessThanOrEqualTo(String value) {
            addCriterion("system_support <=", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportLike(String value) {
            addCriterion("system_support like", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportNotLike(String value) {
            addCriterion("system_support not like", value, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportIn(List<String> values) {
            addCriterion("system_support in", values, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportNotIn(List<String> values) {
            addCriterion("system_support not in", values, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportBetween(String value1, String value2) {
            addCriterion("system_support between", value1, value2, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSystemSupportNotBetween(String value1, String value2) {
            addCriterion("system_support not between", value1, value2, "systemSupport");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdIsNull() {
            addCriterion("subordinate_platform_id is null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdIsNotNull() {
            addCriterion("subordinate_platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdEqualTo(String value) {
            addCriterion("subordinate_platform_id =", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotEqualTo(String value) {
            addCriterion("subordinate_platform_id <>", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdGreaterThan(String value) {
            addCriterion("subordinate_platform_id >", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdGreaterThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_id >=", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdLessThan(String value) {
            addCriterion("subordinate_platform_id <", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdLessThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_id <=", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdLike(String value) {
            addCriterion("subordinate_platform_id like", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotLike(String value) {
            addCriterion("subordinate_platform_id not like", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdIn(List<String> values) {
            addCriterion("subordinate_platform_id in", values, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotIn(List<String> values) {
            addCriterion("subordinate_platform_id not in", values, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdBetween(String value1, String value2) {
            addCriterion("subordinate_platform_id between", value1, value2, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotBetween(String value1, String value2) {
            addCriterion("subordinate_platform_id not between", value1, value2, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameIsNull() {
            addCriterion("subordinate_platform_name is null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameIsNotNull() {
            addCriterion("subordinate_platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameEqualTo(String value) {
            addCriterion("subordinate_platform_name =", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotEqualTo(String value) {
            addCriterion("subordinate_platform_name <>", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameGreaterThan(String value) {
            addCriterion("subordinate_platform_name >", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_name >=", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameLessThan(String value) {
            addCriterion("subordinate_platform_name <", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameLessThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_name <=", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameLike(String value) {
            addCriterion("subordinate_platform_name like", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotLike(String value) {
            addCriterion("subordinate_platform_name not like", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameIn(List<String> values) {
            addCriterion("subordinate_platform_name in", values, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotIn(List<String> values) {
            addCriterion("subordinate_platform_name not in", values, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameBetween(String value1, String value2) {
            addCriterion("subordinate_platform_name between", value1, value2, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotBetween(String value1, String value2) {
            addCriterion("subordinate_platform_name not between", value1, value2, "subordinatePlatformName");
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