package com.jn.enterprise.servicemarket.require.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceRequireCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceRequireCriteria() {
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

        public Criteria andReqNumIsNull() {
            addCriterion("req_num is null");
            return (Criteria) this;
        }

        public Criteria andReqNumIsNotNull() {
            addCriterion("req_num is not null");
            return (Criteria) this;
        }

        public Criteria andReqNumEqualTo(String value) {
            addCriterion("req_num =", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotEqualTo(String value) {
            addCriterion("req_num <>", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumGreaterThan(String value) {
            addCriterion("req_num >", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumGreaterThanOrEqualTo(String value) {
            addCriterion("req_num >=", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLessThan(String value) {
            addCriterion("req_num <", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLessThanOrEqualTo(String value) {
            addCriterion("req_num <=", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLike(String value) {
            addCriterion("req_num like", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotLike(String value) {
            addCriterion("req_num not like", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumIn(List<String> values) {
            addCriterion("req_num in", values, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotIn(List<String> values) {
            addCriterion("req_num not in", values, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumBetween(String value1, String value2) {
            addCriterion("req_num between", value1, value2, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotBetween(String value1, String value2) {
            addCriterion("req_num not between", value1, value2, "reqNum");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaIsNull() {
            addCriterion("business_area is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaIsNotNull() {
            addCriterion("business_area is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaEqualTo(String value) {
            addCriterion("business_area =", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotEqualTo(String value) {
            addCriterion("business_area <>", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaGreaterThan(String value) {
            addCriterion("business_area >", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaGreaterThanOrEqualTo(String value) {
            addCriterion("business_area >=", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaLessThan(String value) {
            addCriterion("business_area <", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaLessThanOrEqualTo(String value) {
            addCriterion("business_area <=", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaLike(String value) {
            addCriterion("business_area like", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotLike(String value) {
            addCriterion("business_area not like", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaIn(List<String> values) {
            addCriterion("business_area in", values, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotIn(List<String> values) {
            addCriterion("business_area not in", values, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaBetween(String value1, String value2) {
            addCriterion("business_area between", value1, value2, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotBetween(String value1, String value2) {
            addCriterion("business_area not between", value1, value2, "businessArea");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountIsNull() {
            addCriterion("advisor_account is null");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountIsNotNull() {
            addCriterion("advisor_account is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountEqualTo(String value) {
            addCriterion("advisor_account =", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotEqualTo(String value) {
            addCriterion("advisor_account <>", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountGreaterThan(String value) {
            addCriterion("advisor_account >", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("advisor_account >=", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountLessThan(String value) {
            addCriterion("advisor_account <", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountLessThanOrEqualTo(String value) {
            addCriterion("advisor_account <=", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountLike(String value) {
            addCriterion("advisor_account like", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotLike(String value) {
            addCriterion("advisor_account not like", value, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountIn(List<String> values) {
            addCriterion("advisor_account in", values, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotIn(List<String> values) {
            addCriterion("advisor_account not in", values, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountBetween(String value1, String value2) {
            addCriterion("advisor_account between", value1, value2, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorAccountNotBetween(String value1, String value2) {
            addCriterion("advisor_account not between", value1, value2, "advisorAccount");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameIsNull() {
            addCriterion("advisor_name is null");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameIsNotNull() {
            addCriterion("advisor_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameEqualTo(String value) {
            addCriterion("advisor_name =", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameNotEqualTo(String value) {
            addCriterion("advisor_name <>", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameGreaterThan(String value) {
            addCriterion("advisor_name >", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameGreaterThanOrEqualTo(String value) {
            addCriterion("advisor_name >=", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameLessThan(String value) {
            addCriterion("advisor_name <", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameLessThanOrEqualTo(String value) {
            addCriterion("advisor_name <=", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameLike(String value) {
            addCriterion("advisor_name like", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameNotLike(String value) {
            addCriterion("advisor_name not like", value, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameIn(List<String> values) {
            addCriterion("advisor_name in", values, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameNotIn(List<String> values) {
            addCriterion("advisor_name not in", values, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameBetween(String value1, String value2) {
            addCriterion("advisor_name between", value1, value2, "advisorName");
            return (Criteria) this;
        }

        public Criteria andAdvisorNameNotBetween(String value1, String value2) {
            addCriterion("advisor_name not between", value1, value2, "advisorName");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneIsNull() {
            addCriterion("org_telephone is null");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneIsNotNull() {
            addCriterion("org_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneEqualTo(String value) {
            addCriterion("org_telephone =", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneNotEqualTo(String value) {
            addCriterion("org_telephone <>", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneGreaterThan(String value) {
            addCriterion("org_telephone >", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("org_telephone >=", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneLessThan(String value) {
            addCriterion("org_telephone <", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneLessThanOrEqualTo(String value) {
            addCriterion("org_telephone <=", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneLike(String value) {
            addCriterion("org_telephone like", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneNotLike(String value) {
            addCriterion("org_telephone not like", value, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneIn(List<String> values) {
            addCriterion("org_telephone in", values, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneNotIn(List<String> values) {
            addCriterion("org_telephone not in", values, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneBetween(String value1, String value2) {
            addCriterion("org_telephone between", value1, value2, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgTelephoneNotBetween(String value1, String value2) {
            addCriterion("org_telephone not between", value1, value2, "orgTelephone");
            return (Criteria) this;
        }

        public Criteria andOrgEmailIsNull() {
            addCriterion("org_email is null");
            return (Criteria) this;
        }

        public Criteria andOrgEmailIsNotNull() {
            addCriterion("org_email is not null");
            return (Criteria) this;
        }

        public Criteria andOrgEmailEqualTo(String value) {
            addCriterion("org_email =", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotEqualTo(String value) {
            addCriterion("org_email <>", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailGreaterThan(String value) {
            addCriterion("org_email >", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailGreaterThanOrEqualTo(String value) {
            addCriterion("org_email >=", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailLessThan(String value) {
            addCriterion("org_email <", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailLessThanOrEqualTo(String value) {
            addCriterion("org_email <=", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailLike(String value) {
            addCriterion("org_email like", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotLike(String value) {
            addCriterion("org_email not like", value, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailIn(List<String> values) {
            addCriterion("org_email in", values, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotIn(List<String> values) {
            addCriterion("org_email not in", values, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailBetween(String value1, String value2) {
            addCriterion("org_email between", value1, value2, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andOrgEmailNotBetween(String value1, String value2) {
            addCriterion("org_email not between", value1, value2, "orgEmail");
            return (Criteria) this;
        }

        public Criteria andReqDetailIsNull() {
            addCriterion("req_detail is null");
            return (Criteria) this;
        }

        public Criteria andReqDetailIsNotNull() {
            addCriterion("req_detail is not null");
            return (Criteria) this;
        }

        public Criteria andReqDetailEqualTo(String value) {
            addCriterion("req_detail =", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailNotEqualTo(String value) {
            addCriterion("req_detail <>", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailGreaterThan(String value) {
            addCriterion("req_detail >", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailGreaterThanOrEqualTo(String value) {
            addCriterion("req_detail >=", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailLessThan(String value) {
            addCriterion("req_detail <", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailLessThanOrEqualTo(String value) {
            addCriterion("req_detail <=", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailLike(String value) {
            addCriterion("req_detail like", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailNotLike(String value) {
            addCriterion("req_detail not like", value, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailIn(List<String> values) {
            addCriterion("req_detail in", values, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailNotIn(List<String> values) {
            addCriterion("req_detail not in", values, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailBetween(String value1, String value2) {
            addCriterion("req_detail between", value1, value2, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqDetailNotBetween(String value1, String value2) {
            addCriterion("req_detail not between", value1, value2, "reqDetail");
            return (Criteria) this;
        }

        public Criteria andReqNameIsNull() {
            addCriterion("req_name is null");
            return (Criteria) this;
        }

        public Criteria andReqNameIsNotNull() {
            addCriterion("req_name is not null");
            return (Criteria) this;
        }

        public Criteria andReqNameEqualTo(String value) {
            addCriterion("req_name =", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotEqualTo(String value) {
            addCriterion("req_name <>", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameGreaterThan(String value) {
            addCriterion("req_name >", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameGreaterThanOrEqualTo(String value) {
            addCriterion("req_name >=", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameLessThan(String value) {
            addCriterion("req_name <", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameLessThanOrEqualTo(String value) {
            addCriterion("req_name <=", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameLike(String value) {
            addCriterion("req_name like", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotLike(String value) {
            addCriterion("req_name not like", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameIn(List<String> values) {
            addCriterion("req_name in", values, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotIn(List<String> values) {
            addCriterion("req_name not in", values, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameBetween(String value1, String value2) {
            addCriterion("req_name between", value1, value2, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotBetween(String value1, String value2) {
            addCriterion("req_name not between", value1, value2, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqPostIsNull() {
            addCriterion("req_post is null");
            return (Criteria) this;
        }

        public Criteria andReqPostIsNotNull() {
            addCriterion("req_post is not null");
            return (Criteria) this;
        }

        public Criteria andReqPostEqualTo(String value) {
            addCriterion("req_post =", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostNotEqualTo(String value) {
            addCriterion("req_post <>", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostGreaterThan(String value) {
            addCriterion("req_post >", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostGreaterThanOrEqualTo(String value) {
            addCriterion("req_post >=", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostLessThan(String value) {
            addCriterion("req_post <", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostLessThanOrEqualTo(String value) {
            addCriterion("req_post <=", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostLike(String value) {
            addCriterion("req_post like", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostNotLike(String value) {
            addCriterion("req_post not like", value, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostIn(List<String> values) {
            addCriterion("req_post in", values, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostNotIn(List<String> values) {
            addCriterion("req_post not in", values, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostBetween(String value1, String value2) {
            addCriterion("req_post between", value1, value2, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPostNotBetween(String value1, String value2) {
            addCriterion("req_post not between", value1, value2, "reqPost");
            return (Criteria) this;
        }

        public Criteria andReqPhoneIsNull() {
            addCriterion("req_phone is null");
            return (Criteria) this;
        }

        public Criteria andReqPhoneIsNotNull() {
            addCriterion("req_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReqPhoneEqualTo(String value) {
            addCriterion("req_phone =", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneNotEqualTo(String value) {
            addCriterion("req_phone <>", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneGreaterThan(String value) {
            addCriterion("req_phone >", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("req_phone >=", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneLessThan(String value) {
            addCriterion("req_phone <", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneLessThanOrEqualTo(String value) {
            addCriterion("req_phone <=", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneLike(String value) {
            addCriterion("req_phone like", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneNotLike(String value) {
            addCriterion("req_phone not like", value, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneIn(List<String> values) {
            addCriterion("req_phone in", values, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneNotIn(List<String> values) {
            addCriterion("req_phone not in", values, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneBetween(String value1, String value2) {
            addCriterion("req_phone between", value1, value2, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqPhoneNotBetween(String value1, String value2) {
            addCriterion("req_phone not between", value1, value2, "reqPhone");
            return (Criteria) this;
        }

        public Criteria andReqEmailIsNull() {
            addCriterion("req_email is null");
            return (Criteria) this;
        }

        public Criteria andReqEmailIsNotNull() {
            addCriterion("req_email is not null");
            return (Criteria) this;
        }

        public Criteria andReqEmailEqualTo(String value) {
            addCriterion("req_email =", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailNotEqualTo(String value) {
            addCriterion("req_email <>", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailGreaterThan(String value) {
            addCriterion("req_email >", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailGreaterThanOrEqualTo(String value) {
            addCriterion("req_email >=", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailLessThan(String value) {
            addCriterion("req_email <", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailLessThanOrEqualTo(String value) {
            addCriterion("req_email <=", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailLike(String value) {
            addCriterion("req_email like", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailNotLike(String value) {
            addCriterion("req_email not like", value, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailIn(List<String> values) {
            addCriterion("req_email in", values, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailNotIn(List<String> values) {
            addCriterion("req_email not in", values, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailBetween(String value1, String value2) {
            addCriterion("req_email between", value1, value2, "reqEmail");
            return (Criteria) this;
        }

        public Criteria andReqEmailNotBetween(String value1, String value2) {
            addCriterion("req_email not between", value1, value2, "reqEmail");
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

        public Criteria andIssueTimeEqualTo(Date value) {
            addCriterion("issue_time =", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotEqualTo(Date value) {
            addCriterion("issue_time <>", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThan(Date value) {
            addCriterion("issue_time >", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_time >=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThan(Date value) {
            addCriterion("issue_time <", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThanOrEqualTo(Date value) {
            addCriterion("issue_time <=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIn(List<Date> values) {
            addCriterion("issue_time in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotIn(List<Date> values) {
            addCriterion("issue_time not in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeBetween(Date value1, Date value2) {
            addCriterion("issue_time between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotBetween(Date value1, Date value2) {
            addCriterion("issue_time not between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueAccountIsNull() {
            addCriterion("issue_account is null");
            return (Criteria) this;
        }

        public Criteria andIssueAccountIsNotNull() {
            addCriterion("issue_account is not null");
            return (Criteria) this;
        }

        public Criteria andIssueAccountEqualTo(String value) {
            addCriterion("issue_account =", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotEqualTo(String value) {
            addCriterion("issue_account <>", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountGreaterThan(String value) {
            addCriterion("issue_account >", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountGreaterThanOrEqualTo(String value) {
            addCriterion("issue_account >=", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountLessThan(String value) {
            addCriterion("issue_account <", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountLessThanOrEqualTo(String value) {
            addCriterion("issue_account <=", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountLike(String value) {
            addCriterion("issue_account like", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotLike(String value) {
            addCriterion("issue_account not like", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountIn(List<String> values) {
            addCriterion("issue_account in", values, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotIn(List<String> values) {
            addCriterion("issue_account not in", values, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountBetween(String value1, String value2) {
            addCriterion("issue_account between", value1, value2, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotBetween(String value1, String value2) {
            addCriterion("issue_account not between", value1, value2, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNull() {
            addCriterion("contract_amount is null");
            return (Criteria) this;
        }

        public Criteria andContractAmountIsNotNull() {
            addCriterion("contract_amount is not null");
            return (Criteria) this;
        }

        public Criteria andContractAmountEqualTo(String value) {
            addCriterion("contract_amount =", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotEqualTo(String value) {
            addCriterion("contract_amount <>", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThan(String value) {
            addCriterion("contract_amount >", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountGreaterThanOrEqualTo(String value) {
            addCriterion("contract_amount >=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThan(String value) {
            addCriterion("contract_amount <", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLessThanOrEqualTo(String value) {
            addCriterion("contract_amount <=", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountLike(String value) {
            addCriterion("contract_amount like", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotLike(String value) {
            addCriterion("contract_amount not like", value, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountIn(List<String> values) {
            addCriterion("contract_amount in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotIn(List<String> values) {
            addCriterion("contract_amount not in", values, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountBetween(String value1, String value2) {
            addCriterion("contract_amount between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andContractAmountNotBetween(String value1, String value2) {
            addCriterion("contract_amount not between", value1, value2, "contractAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIsNull() {
            addCriterion("financing_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIsNotNull() {
            addCriterion("financing_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountEqualTo(String value) {
            addCriterion("financing_amount =", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotEqualTo(String value) {
            addCriterion("financing_amount <>", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountGreaterThan(String value) {
            addCriterion("financing_amount >", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountGreaterThanOrEqualTo(String value) {
            addCriterion("financing_amount >=", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLessThan(String value) {
            addCriterion("financing_amount <", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLessThanOrEqualTo(String value) {
            addCriterion("financing_amount <=", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountLike(String value) {
            addCriterion("financing_amount like", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotLike(String value) {
            addCriterion("financing_amount not like", value, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountIn(List<String> values) {
            addCriterion("financing_amount in", values, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotIn(List<String> values) {
            addCriterion("financing_amount not in", values, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountBetween(String value1, String value2) {
            addCriterion("financing_amount between", value1, value2, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingAmountNotBetween(String value1, String value2) {
            addCriterion("financing_amount not between", value1, value2, "financingAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountIsNull() {
            addCriterion("actual_loan_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountIsNotNull() {
            addCriterion("actual_loan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountEqualTo(String value) {
            addCriterion("actual_loan_amount =", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountNotEqualTo(String value) {
            addCriterion("actual_loan_amount <>", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountGreaterThan(String value) {
            addCriterion("actual_loan_amount >", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountGreaterThanOrEqualTo(String value) {
            addCriterion("actual_loan_amount >=", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountLessThan(String value) {
            addCriterion("actual_loan_amount <", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountLessThanOrEqualTo(String value) {
            addCriterion("actual_loan_amount <=", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountLike(String value) {
            addCriterion("actual_loan_amount like", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountNotLike(String value) {
            addCriterion("actual_loan_amount not like", value, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountIn(List<String> values) {
            addCriterion("actual_loan_amount in", values, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountNotIn(List<String> values) {
            addCriterion("actual_loan_amount not in", values, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountBetween(String value1, String value2) {
            addCriterion("actual_loan_amount between", value1, value2, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andActualLoanAmountNotBetween(String value1, String value2) {
            addCriterion("actual_loan_amount not between", value1, value2, "actualLoanAmount");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodIsNull() {
            addCriterion("financing_period is null");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodIsNotNull() {
            addCriterion("financing_period is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodEqualTo(String value) {
            addCriterion("financing_period =", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodNotEqualTo(String value) {
            addCriterion("financing_period <>", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodGreaterThan(String value) {
            addCriterion("financing_period >", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("financing_period >=", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodLessThan(String value) {
            addCriterion("financing_period <", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodLessThanOrEqualTo(String value) {
            addCriterion("financing_period <=", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodLike(String value) {
            addCriterion("financing_period like", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodNotLike(String value) {
            addCriterion("financing_period not like", value, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodIn(List<String> values) {
            addCriterion("financing_period in", values, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodNotIn(List<String> values) {
            addCriterion("financing_period not in", values, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodBetween(String value1, String value2) {
            addCriterion("financing_period between", value1, value2, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andFinancingPeriodNotBetween(String value1, String value2) {
            addCriterion("financing_period not between", value1, value2, "financingPeriod");
            return (Criteria) this;
        }

        public Criteria andExpectedDateIsNull() {
            addCriterion("expected_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectedDateIsNotNull() {
            addCriterion("expected_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedDateEqualTo(Date value) {
            addCriterion("expected_date =", value, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateNotEqualTo(Date value) {
            addCriterion("expected_date <>", value, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateGreaterThan(Date value) {
            addCriterion("expected_date >", value, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expected_date >=", value, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateLessThan(Date value) {
            addCriterion("expected_date <", value, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateLessThanOrEqualTo(Date value) {
            addCriterion("expected_date <=", value, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateIn(List<Date> values) {
            addCriterion("expected_date in", values, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateNotIn(List<Date> values) {
            addCriterion("expected_date not in", values, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateBetween(Date value1, Date value2) {
            addCriterion("expected_date between", value1, value2, "expectedDate");
            return (Criteria) this;
        }

        public Criteria andExpectedDateNotBetween(Date value1, Date value2) {
            addCriterion("expected_date not between", value1, value2, "expectedDate");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleResultIsNull() {
            addCriterion("handle_result is null");
            return (Criteria) this;
        }

        public Criteria andHandleResultIsNotNull() {
            addCriterion("handle_result is not null");
            return (Criteria) this;
        }

        public Criteria andHandleResultEqualTo(String value) {
            addCriterion("handle_result =", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotEqualTo(String value) {
            addCriterion("handle_result <>", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultGreaterThan(String value) {
            addCriterion("handle_result >", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultGreaterThanOrEqualTo(String value) {
            addCriterion("handle_result >=", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLessThan(String value) {
            addCriterion("handle_result <", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLessThanOrEqualTo(String value) {
            addCriterion("handle_result <=", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLike(String value) {
            addCriterion("handle_result like", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotLike(String value) {
            addCriterion("handle_result not like", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultIn(List<String> values) {
            addCriterion("handle_result in", values, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotIn(List<String> values) {
            addCriterion("handle_result not in", values, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultBetween(String value1, String value2) {
            addCriterion("handle_result between", value1, value2, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotBetween(String value1, String value2) {
            addCriterion("handle_result not between", value1, value2, "handleResult");
            return (Criteria) this;
        }

        public Criteria andResultDetailIsNull() {
            addCriterion("result_detail is null");
            return (Criteria) this;
        }

        public Criteria andResultDetailIsNotNull() {
            addCriterion("result_detail is not null");
            return (Criteria) this;
        }

        public Criteria andResultDetailEqualTo(String value) {
            addCriterion("result_detail =", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailNotEqualTo(String value) {
            addCriterion("result_detail <>", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailGreaterThan(String value) {
            addCriterion("result_detail >", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailGreaterThanOrEqualTo(String value) {
            addCriterion("result_detail >=", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailLessThan(String value) {
            addCriterion("result_detail <", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailLessThanOrEqualTo(String value) {
            addCriterion("result_detail <=", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailLike(String value) {
            addCriterion("result_detail like", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailNotLike(String value) {
            addCriterion("result_detail not like", value, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailIn(List<String> values) {
            addCriterion("result_detail in", values, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailNotIn(List<String> values) {
            addCriterion("result_detail not in", values, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailBetween(String value1, String value2) {
            addCriterion("result_detail between", value1, value2, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andResultDetailNotBetween(String value1, String value2) {
            addCriterion("result_detail not between", value1, value2, "resultDetail");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNull() {
            addCriterion("is_comment is null");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNotNull() {
            addCriterion("is_comment is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommentEqualTo(String value) {
            addCriterion("is_comment =", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotEqualTo(String value) {
            addCriterion("is_comment <>", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThan(String value) {
            addCriterion("is_comment >", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThanOrEqualTo(String value) {
            addCriterion("is_comment >=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThan(String value) {
            addCriterion("is_comment <", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThanOrEqualTo(String value) {
            addCriterion("is_comment <=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLike(String value) {
            addCriterion("is_comment like", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotLike(String value) {
            addCriterion("is_comment not like", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentIn(List<String> values) {
            addCriterion("is_comment in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotIn(List<String> values) {
            addCriterion("is_comment not in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentBetween(String value1, String value2) {
            addCriterion("is_comment between", value1, value2, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotBetween(String value1, String value2) {
            addCriterion("is_comment not between", value1, value2, "isComment");
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