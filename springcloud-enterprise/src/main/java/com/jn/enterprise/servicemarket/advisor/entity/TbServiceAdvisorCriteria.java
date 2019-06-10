package com.jn.enterprise.servicemarket.advisor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceAdvisorCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceAdvisorCriteria() {
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
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id_ not between", value1, value2, "id");
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

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andIsCertificationIsNull() {
            addCriterion("is_certification is null");
            return (Criteria) this;
        }

        public Criteria andIsCertificationIsNotNull() {
            addCriterion("is_certification is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertificationEqualTo(String value) {
            addCriterion("is_certification =", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotEqualTo(String value) {
            addCriterion("is_certification <>", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationGreaterThan(String value) {
            addCriterion("is_certification >", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationGreaterThanOrEqualTo(String value) {
            addCriterion("is_certification >=", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationLessThan(String value) {
            addCriterion("is_certification <", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationLessThanOrEqualTo(String value) {
            addCriterion("is_certification <=", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationLike(String value) {
            addCriterion("is_certification like", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotLike(String value) {
            addCriterion("is_certification not like", value, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationIn(List<String> values) {
            addCriterion("is_certification in", values, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotIn(List<String> values) {
            addCriterion("is_certification not in", values, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationBetween(String value1, String value2) {
            addCriterion("is_certification between", value1, value2, "isCertification");
            return (Criteria) this;
        }

        public Criteria andIsCertificationNotBetween(String value1, String value2) {
            addCriterion("is_certification not between", value1, value2, "isCertification");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolIsNull() {
            addCriterion("graduated_school is null");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolIsNotNull() {
            addCriterion("graduated_school is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolEqualTo(String value) {
            addCriterion("graduated_school =", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolNotEqualTo(String value) {
            addCriterion("graduated_school <>", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolGreaterThan(String value) {
            addCriterion("graduated_school >", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("graduated_school >=", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolLessThan(String value) {
            addCriterion("graduated_school <", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolLessThanOrEqualTo(String value) {
            addCriterion("graduated_school <=", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolLike(String value) {
            addCriterion("graduated_school like", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolNotLike(String value) {
            addCriterion("graduated_school not like", value, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolIn(List<String> values) {
            addCriterion("graduated_school in", values, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolNotIn(List<String> values) {
            addCriterion("graduated_school not in", values, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolBetween(String value1, String value2) {
            addCriterion("graduated_school between", value1, value2, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andGraduatedSchoolNotBetween(String value1, String value2) {
            addCriterion("graduated_school not between", value1, value2, "graduatedSchool");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIsNull() {
            addCriterion("personal_profile is null");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIsNotNull() {
            addCriterion("personal_profile is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileEqualTo(String value) {
            addCriterion("personal_profile =", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotEqualTo(String value) {
            addCriterion("personal_profile <>", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileGreaterThan(String value) {
            addCriterion("personal_profile >", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileGreaterThanOrEqualTo(String value) {
            addCriterion("personal_profile >=", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLessThan(String value) {
            addCriterion("personal_profile <", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLessThanOrEqualTo(String value) {
            addCriterion("personal_profile <=", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLike(String value) {
            addCriterion("personal_profile like", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotLike(String value) {
            addCriterion("personal_profile not like", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIn(List<String> values) {
            addCriterion("personal_profile in", values, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotIn(List<String> values) {
            addCriterion("personal_profile not in", values, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileBetween(String value1, String value2) {
            addCriterion("personal_profile between", value1, value2, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotBetween(String value1, String value2) {
            addCriterion("personal_profile not between", value1, value2, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIsNull() {
            addCriterion("working_years is null");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIsNotNull() {
            addCriterion("working_years is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsEqualTo(Float value) {
            addCriterion("working_years =", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotEqualTo(Float value) {
            addCriterion("working_years <>", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsGreaterThan(Float value) {
            addCriterion("working_years >", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsGreaterThanOrEqualTo(Float value) {
            addCriterion("working_years >=", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLessThan(Float value) {
            addCriterion("working_years <", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsLessThanOrEqualTo(Float value) {
            addCriterion("working_years <=", value, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsIn(List<Float> values) {
            addCriterion("working_years in", values, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotIn(List<Float> values) {
            addCriterion("working_years not in", values, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsBetween(Float value1, Float value2) {
            addCriterion("working_years between", value1, value2, "workingYears");
            return (Criteria) this;
        }

        public Criteria andWorkingYearsNotBetween(Float value1, Float value2) {
            addCriterion("working_years not between", value1, value2, "workingYears");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationIsNull() {
            addCriterion("practice_qualification is null");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationIsNotNull() {
            addCriterion("practice_qualification is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationEqualTo(String value) {
            addCriterion("practice_qualification =", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationNotEqualTo(String value) {
            addCriterion("practice_qualification <>", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationGreaterThan(String value) {
            addCriterion("practice_qualification >", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationGreaterThanOrEqualTo(String value) {
            addCriterion("practice_qualification >=", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationLessThan(String value) {
            addCriterion("practice_qualification <", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationLessThanOrEqualTo(String value) {
            addCriterion("practice_qualification <=", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationLike(String value) {
            addCriterion("practice_qualification like", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationNotLike(String value) {
            addCriterion("practice_qualification not like", value, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationIn(List<String> values) {
            addCriterion("practice_qualification in", values, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationNotIn(List<String> values) {
            addCriterion("practice_qualification not in", values, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationBetween(String value1, String value2) {
            addCriterion("practice_qualification between", value1, value2, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andPracticeQualificationNotBetween(String value1, String value2) {
            addCriterion("practice_qualification not between", value1, value2, "practiceQualification");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessIsNull() {
            addCriterion("good_at_business is null");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessIsNotNull() {
            addCriterion("good_at_business is not null");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessEqualTo(String value) {
            addCriterion("good_at_business =", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessNotEqualTo(String value) {
            addCriterion("good_at_business <>", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessGreaterThan(String value) {
            addCriterion("good_at_business >", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("good_at_business >=", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessLessThan(String value) {
            addCriterion("good_at_business <", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessLessThanOrEqualTo(String value) {
            addCriterion("good_at_business <=", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessLike(String value) {
            addCriterion("good_at_business like", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessNotLike(String value) {
            addCriterion("good_at_business not like", value, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessIn(List<String> values) {
            addCriterion("good_at_business in", values, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessNotIn(List<String> values) {
            addCriterion("good_at_business not in", values, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessBetween(String value1, String value2) {
            addCriterion("good_at_business between", value1, value2, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andGoodAtBusinessNotBetween(String value1, String value2) {
            addCriterion("good_at_business not between", value1, value2, "goodAtBusiness");
            return (Criteria) this;
        }

        public Criteria andTransactionNumIsNull() {
            addCriterion("transaction_num is null");
            return (Criteria) this;
        }

        public Criteria andTransactionNumIsNotNull() {
            addCriterion("transaction_num is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionNumEqualTo(Integer value) {
            addCriterion("transaction_num =", value, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumNotEqualTo(Integer value) {
            addCriterion("transaction_num <>", value, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumGreaterThan(Integer value) {
            addCriterion("transaction_num >", value, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_num >=", value, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumLessThan(Integer value) {
            addCriterion("transaction_num <", value, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_num <=", value, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumIn(List<Integer> values) {
            addCriterion("transaction_num in", values, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumNotIn(List<Integer> values) {
            addCriterion("transaction_num not in", values, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumBetween(Integer value1, Integer value2) {
            addCriterion("transaction_num between", value1, value2, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andTransactionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_num not between", value1, value2, "transactionNum");
            return (Criteria) this;
        }

        public Criteria andPageViewsIsNull() {
            addCriterion("page_views is null");
            return (Criteria) this;
        }

        public Criteria andPageViewsIsNotNull() {
            addCriterion("page_views is not null");
            return (Criteria) this;
        }

        public Criteria andPageViewsEqualTo(Integer value) {
            addCriterion("page_views =", value, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsNotEqualTo(Integer value) {
            addCriterion("page_views <>", value, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsGreaterThan(Integer value) {
            addCriterion("page_views >", value, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_views >=", value, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsLessThan(Integer value) {
            addCriterion("page_views <", value, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsLessThanOrEqualTo(Integer value) {
            addCriterion("page_views <=", value, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsIn(List<Integer> values) {
            addCriterion("page_views in", values, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsNotIn(List<Integer> values) {
            addCriterion("page_views not in", values, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsBetween(Integer value1, Integer value2) {
            addCriterion("page_views between", value1, value2, "pageViews");
            return (Criteria) this;
        }

        public Criteria andPageViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("page_views not between", value1, value2, "pageViews");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyIsNull() {
            addCriterion("is_have_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyIsNotNull() {
            addCriterion("is_have_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyEqualTo(String value) {
            addCriterion("is_have_subsidy =", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyNotEqualTo(String value) {
            addCriterion("is_have_subsidy <>", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyGreaterThan(String value) {
            addCriterion("is_have_subsidy >", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("is_have_subsidy >=", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyLessThan(String value) {
            addCriterion("is_have_subsidy <", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyLessThanOrEqualTo(String value) {
            addCriterion("is_have_subsidy <=", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyLike(String value) {
            addCriterion("is_have_subsidy like", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyNotLike(String value) {
            addCriterion("is_have_subsidy not like", value, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyIn(List<String> values) {
            addCriterion("is_have_subsidy in", values, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyNotIn(List<String> values) {
            addCriterion("is_have_subsidy not in", values, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyBetween(String value1, String value2) {
            addCriterion("is_have_subsidy between", value1, value2, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andIsHaveSubsidyNotBetween(String value1, String value2) {
            addCriterion("is_have_subsidy not between", value1, value2, "isHaveSubsidy");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(String value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(String value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(String value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(String value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(String value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLike(String value) {
            addCriterion("approval_status like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotLike(String value) {
            addCriterion("approval_status not like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<String> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<String> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(String value1, String value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(String value1, String value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIsNull() {
            addCriterion("approval_desc is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIsNotNull() {
            addCriterion("approval_desc is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDescEqualTo(String value) {
            addCriterion("approval_desc =", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotEqualTo(String value) {
            addCriterion("approval_desc <>", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescGreaterThan(String value) {
            addCriterion("approval_desc >", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescGreaterThanOrEqualTo(String value) {
            addCriterion("approval_desc >=", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLessThan(String value) {
            addCriterion("approval_desc <", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLessThanOrEqualTo(String value) {
            addCriterion("approval_desc <=", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLike(String value) {
            addCriterion("approval_desc like", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotLike(String value) {
            addCriterion("approval_desc not like", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIn(List<String> values) {
            addCriterion("approval_desc in", values, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotIn(List<String> values) {
            addCriterion("approval_desc not in", values, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescBetween(String value1, String value2) {
            addCriterion("approval_desc between", value1, value2, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotBetween(String value1, String value2) {
            addCriterion("approval_desc not between", value1, value2, "approvalDesc");
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