package com.jn.enterprise.servicemarket.org.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceOrgInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceOrgInfoCriteria() {
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

        public Criteria andOrgProvinceIsNull() {
            addCriterion("org_province is null");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceIsNotNull() {
            addCriterion("org_province is not null");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceEqualTo(String value) {
            addCriterion("org_province =", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceNotEqualTo(String value) {
            addCriterion("org_province <>", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceGreaterThan(String value) {
            addCriterion("org_province >", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("org_province >=", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceLessThan(String value) {
            addCriterion("org_province <", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceLessThanOrEqualTo(String value) {
            addCriterion("org_province <=", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceLike(String value) {
            addCriterion("org_province like", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceNotLike(String value) {
            addCriterion("org_province not like", value, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceIn(List<String> values) {
            addCriterion("org_province in", values, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceNotIn(List<String> values) {
            addCriterion("org_province not in", values, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceBetween(String value1, String value2) {
            addCriterion("org_province between", value1, value2, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgProvinceNotBetween(String value1, String value2) {
            addCriterion("org_province not between", value1, value2, "orgProvince");
            return (Criteria) this;
        }

        public Criteria andOrgCityIsNull() {
            addCriterion("org_city is null");
            return (Criteria) this;
        }

        public Criteria andOrgCityIsNotNull() {
            addCriterion("org_city is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCityEqualTo(String value) {
            addCriterion("org_city =", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityNotEqualTo(String value) {
            addCriterion("org_city <>", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityGreaterThan(String value) {
            addCriterion("org_city >", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityGreaterThanOrEqualTo(String value) {
            addCriterion("org_city >=", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityLessThan(String value) {
            addCriterion("org_city <", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityLessThanOrEqualTo(String value) {
            addCriterion("org_city <=", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityLike(String value) {
            addCriterion("org_city like", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityNotLike(String value) {
            addCriterion("org_city not like", value, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityIn(List<String> values) {
            addCriterion("org_city in", values, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityNotIn(List<String> values) {
            addCriterion("org_city not in", values, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityBetween(String value1, String value2) {
            addCriterion("org_city between", value1, value2, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgCityNotBetween(String value1, String value2) {
            addCriterion("org_city not between", value1, value2, "orgCity");
            return (Criteria) this;
        }

        public Criteria andOrgAreaIsNull() {
            addCriterion("org_area is null");
            return (Criteria) this;
        }

        public Criteria andOrgAreaIsNotNull() {
            addCriterion("org_area is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAreaEqualTo(String value) {
            addCriterion("org_area =", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaNotEqualTo(String value) {
            addCriterion("org_area <>", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaGreaterThan(String value) {
            addCriterion("org_area >", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaGreaterThanOrEqualTo(String value) {
            addCriterion("org_area >=", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaLessThan(String value) {
            addCriterion("org_area <", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaLessThanOrEqualTo(String value) {
            addCriterion("org_area <=", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaLike(String value) {
            addCriterion("org_area like", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaNotLike(String value) {
            addCriterion("org_area not like", value, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaIn(List<String> values) {
            addCriterion("org_area in", values, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaNotIn(List<String> values) {
            addCriterion("org_area not in", values, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaBetween(String value1, String value2) {
            addCriterion("org_area between", value1, value2, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAreaNotBetween(String value1, String value2) {
            addCriterion("org_area not between", value1, value2, "orgArea");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIsNull() {
            addCriterion("org_address is null");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIsNotNull() {
            addCriterion("org_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAddressEqualTo(String value) {
            addCriterion("org_address =", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotEqualTo(String value) {
            addCriterion("org_address <>", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressGreaterThan(String value) {
            addCriterion("org_address >", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressGreaterThanOrEqualTo(String value) {
            addCriterion("org_address >=", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLessThan(String value) {
            addCriterion("org_address <", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLessThanOrEqualTo(String value) {
            addCriterion("org_address <=", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLike(String value) {
            addCriterion("org_address like", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotLike(String value) {
            addCriterion("org_address not like", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIn(List<String> values) {
            addCriterion("org_address in", values, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotIn(List<String> values) {
            addCriterion("org_address not in", values, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressBetween(String value1, String value2) {
            addCriterion("org_address between", value1, value2, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotBetween(String value1, String value2) {
            addCriterion("org_address not between", value1, value2, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIsNull() {
            addCriterion("org_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIsNotNull() {
            addCriterion("org_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneEqualTo(String value) {
            addCriterion("org_phone =", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotEqualTo(String value) {
            addCriterion("org_phone <>", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneGreaterThan(String value) {
            addCriterion("org_phone >", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("org_phone >=", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLessThan(String value) {
            addCriterion("org_phone <", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLessThanOrEqualTo(String value) {
            addCriterion("org_phone <=", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLike(String value) {
            addCriterion("org_phone like", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotLike(String value) {
            addCriterion("org_phone not like", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIn(List<String> values) {
            addCriterion("org_phone in", values, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotIn(List<String> values) {
            addCriterion("org_phone not in", values, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneBetween(String value1, String value2) {
            addCriterion("org_phone between", value1, value2, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotBetween(String value1, String value2) {
            addCriterion("org_phone not between", value1, value2, "orgPhone");
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

        public Criteria andOrgWebIsNull() {
            addCriterion("org_web is null");
            return (Criteria) this;
        }

        public Criteria andOrgWebIsNotNull() {
            addCriterion("org_web is not null");
            return (Criteria) this;
        }

        public Criteria andOrgWebEqualTo(String value) {
            addCriterion("org_web =", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotEqualTo(String value) {
            addCriterion("org_web <>", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebGreaterThan(String value) {
            addCriterion("org_web >", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebGreaterThanOrEqualTo(String value) {
            addCriterion("org_web >=", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebLessThan(String value) {
            addCriterion("org_web <", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebLessThanOrEqualTo(String value) {
            addCriterion("org_web <=", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebLike(String value) {
            addCriterion("org_web like", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotLike(String value) {
            addCriterion("org_web not like", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebIn(List<String> values) {
            addCriterion("org_web in", values, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotIn(List<String> values) {
            addCriterion("org_web not in", values, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebBetween(String value1, String value2) {
            addCriterion("org_web between", value1, value2, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotBetween(String value1, String value2) {
            addCriterion("org_web not between", value1, value2, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andConPhoneIsNull() {
            addCriterion("con_phone is null");
            return (Criteria) this;
        }

        public Criteria andConPhoneIsNotNull() {
            addCriterion("con_phone is not null");
            return (Criteria) this;
        }

        public Criteria andConPhoneEqualTo(String value) {
            addCriterion("con_phone =", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotEqualTo(String value) {
            addCriterion("con_phone <>", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneGreaterThan(String value) {
            addCriterion("con_phone >", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("con_phone >=", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneLessThan(String value) {
            addCriterion("con_phone <", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneLessThanOrEqualTo(String value) {
            addCriterion("con_phone <=", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneLike(String value) {
            addCriterion("con_phone like", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotLike(String value) {
            addCriterion("con_phone not like", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneIn(List<String> values) {
            addCriterion("con_phone in", values, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotIn(List<String> values) {
            addCriterion("con_phone not in", values, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneBetween(String value1, String value2) {
            addCriterion("con_phone between", value1, value2, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotBetween(String value1, String value2) {
            addCriterion("con_phone not between", value1, value2, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConEmailIsNull() {
            addCriterion("con_email is null");
            return (Criteria) this;
        }

        public Criteria andConEmailIsNotNull() {
            addCriterion("con_email is not null");
            return (Criteria) this;
        }

        public Criteria andConEmailEqualTo(String value) {
            addCriterion("con_email =", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotEqualTo(String value) {
            addCriterion("con_email <>", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailGreaterThan(String value) {
            addCriterion("con_email >", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailGreaterThanOrEqualTo(String value) {
            addCriterion("con_email >=", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailLessThan(String value) {
            addCriterion("con_email <", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailLessThanOrEqualTo(String value) {
            addCriterion("con_email <=", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailLike(String value) {
            addCriterion("con_email like", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotLike(String value) {
            addCriterion("con_email not like", value, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailIn(List<String> values) {
            addCriterion("con_email in", values, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotIn(List<String> values) {
            addCriterion("con_email not in", values, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailBetween(String value1, String value2) {
            addCriterion("con_email between", value1, value2, "conEmail");
            return (Criteria) this;
        }

        public Criteria andConEmailNotBetween(String value1, String value2) {
            addCriterion("con_email not between", value1, value2, "conEmail");
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