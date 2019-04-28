package com.jn.enterprise.pd.personnel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPersonnelProjectCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPersonnelProjectCriteria() {
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

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id_ is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id_ =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id_ <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id_ >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id_ >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id_ <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id_ <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id_ like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id_ not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id_ in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id_ not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id_ between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id_ not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip_ is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip_ is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip_ =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip_ <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip_ >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip_ >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip_ <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip_ <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip_ like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip_ not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip_ in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip_ not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip_ between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip_ not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by_ is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by_ is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by_ =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by_ <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by_ >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by_ >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by_ <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by_ <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by_ like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by_ not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by_ in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by_ not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by_ between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by_ not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time_ is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time_ =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time_ <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time_ >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time_ >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time_ <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time_ <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time_ in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time_ not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time_ between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time_ not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by_ is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by_ =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by_ <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by_ >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by_ >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by_ <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by_ <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by_ like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by_ not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by_ in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by_ not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by_ between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by_ not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time_ is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time_ is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time_ =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time_ <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time_ >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time_ >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time_ <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time_ <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time_ in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time_ not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time_ between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time_ not between", value1, value2, "updateTime");
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

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIndustrialIsNull() {
            addCriterion("industrial is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialIsNotNull() {
            addCriterion("industrial is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialEqualTo(String value) {
            addCriterion("industrial =", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialNotEqualTo(String value) {
            addCriterion("industrial <>", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialGreaterThan(String value) {
            addCriterion("industrial >", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialGreaterThanOrEqualTo(String value) {
            addCriterion("industrial >=", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialLessThan(String value) {
            addCriterion("industrial <", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialLessThanOrEqualTo(String value) {
            addCriterion("industrial <=", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialLike(String value) {
            addCriterion("industrial like", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialNotLike(String value) {
            addCriterion("industrial not like", value, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialIn(List<String> values) {
            addCriterion("industrial in", values, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialNotIn(List<String> values) {
            addCriterion("industrial not in", values, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialBetween(String value1, String value2) {
            addCriterion("industrial between", value1, value2, "industrial");
            return (Criteria) this;
        }

        public Criteria andIndustrialNotBetween(String value1, String value2) {
            addCriterion("industrial not between", value1, value2, "industrial");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonIsNull() {
            addCriterion("company_person is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonIsNotNull() {
            addCriterion("company_person is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonEqualTo(String value) {
            addCriterion("company_person =", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotEqualTo(String value) {
            addCriterion("company_person <>", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonGreaterThan(String value) {
            addCriterion("company_person >", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("company_person >=", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonLessThan(String value) {
            addCriterion("company_person <", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonLessThanOrEqualTo(String value) {
            addCriterion("company_person <=", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonLike(String value) {
            addCriterion("company_person like", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotLike(String value) {
            addCriterion("company_person not like", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonIn(List<String> values) {
            addCriterion("company_person in", values, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotIn(List<String> values) {
            addCriterion("company_person not in", values, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonBetween(String value1, String value2) {
            addCriterion("company_person between", value1, value2, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotBetween(String value1, String value2) {
            addCriterion("company_person not between", value1, value2, "companyPerson");
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

        public Criteria andCompanyIntroduceIsNull() {
            addCriterion("company_introduce is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceIsNotNull() {
            addCriterion("company_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceEqualTo(String value) {
            addCriterion("company_introduce =", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotEqualTo(String value) {
            addCriterion("company_introduce <>", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceGreaterThan(String value) {
            addCriterion("company_introduce >", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("company_introduce >=", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceLessThan(String value) {
            addCriterion("company_introduce <", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceLessThanOrEqualTo(String value) {
            addCriterion("company_introduce <=", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceLike(String value) {
            addCriterion("company_introduce like", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotLike(String value) {
            addCriterion("company_introduce not like", value, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceIn(List<String> values) {
            addCriterion("company_introduce in", values, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotIn(List<String> values) {
            addCriterion("company_introduce not in", values, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceBetween(String value1, String value2) {
            addCriterion("company_introduce between", value1, value2, "companyIntroduce");
            return (Criteria) this;
        }

        public Criteria andCompanyIntroduceNotBetween(String value1, String value2) {
            addCriterion("company_introduce not between", value1, value2, "companyIntroduce");
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

        public Criteria andProjectIntroduceIsNull() {
            addCriterion("project_introduce is null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIsNotNull() {
            addCriterion("project_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceEqualTo(String value) {
            addCriterion("project_introduce =", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotEqualTo(String value) {
            addCriterion("project_introduce <>", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceGreaterThan(String value) {
            addCriterion("project_introduce >", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("project_introduce >=", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLessThan(String value) {
            addCriterion("project_introduce <", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLessThanOrEqualTo(String value) {
            addCriterion("project_introduce <=", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLike(String value) {
            addCriterion("project_introduce like", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotLike(String value) {
            addCriterion("project_introduce not like", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIn(List<String> values) {
            addCriterion("project_introduce in", values, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotIn(List<String> values) {
            addCriterion("project_introduce not in", values, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceBetween(String value1, String value2) {
            addCriterion("project_introduce between", value1, value2, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotBetween(String value1, String value2) {
            addCriterion("project_introduce not between", value1, value2, "projectIntroduce");
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

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
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

        public Criteria andProjectFileIsNull() {
            addCriterion("project_file is null");
            return (Criteria) this;
        }

        public Criteria andProjectFileIsNotNull() {
            addCriterion("project_file is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFileEqualTo(String value) {
            addCriterion("project_file =", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileNotEqualTo(String value) {
            addCriterion("project_file <>", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileGreaterThan(String value) {
            addCriterion("project_file >", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileGreaterThanOrEqualTo(String value) {
            addCriterion("project_file >=", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileLessThan(String value) {
            addCriterion("project_file <", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileLessThanOrEqualTo(String value) {
            addCriterion("project_file <=", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileLike(String value) {
            addCriterion("project_file like", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileNotLike(String value) {
            addCriterion("project_file not like", value, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileIn(List<String> values) {
            addCriterion("project_file in", values, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileNotIn(List<String> values) {
            addCriterion("project_file not in", values, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileBetween(String value1, String value2) {
            addCriterion("project_file between", value1, value2, "projectFile");
            return (Criteria) this;
        }

        public Criteria andProjectFileNotBetween(String value1, String value2) {
            addCriterion("project_file not between", value1, value2, "projectFile");
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

        public Criteria andRegisterIsCheckIsNull() {
            addCriterion("register_is_check is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckIsNotNull() {
            addCriterion("register_is_check is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckEqualTo(String value) {
            addCriterion("register_is_check =", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckNotEqualTo(String value) {
            addCriterion("register_is_check <>", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckGreaterThan(String value) {
            addCriterion("register_is_check >", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckGreaterThanOrEqualTo(String value) {
            addCriterion("register_is_check >=", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckLessThan(String value) {
            addCriterion("register_is_check <", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckLessThanOrEqualTo(String value) {
            addCriterion("register_is_check <=", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckLike(String value) {
            addCriterion("register_is_check like", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckNotLike(String value) {
            addCriterion("register_is_check not like", value, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckIn(List<String> values) {
            addCriterion("register_is_check in", values, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckNotIn(List<String> values) {
            addCriterion("register_is_check not in", values, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckBetween(String value1, String value2) {
            addCriterion("register_is_check between", value1, value2, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterIsCheckNotBetween(String value1, String value2) {
            addCriterion("register_is_check not between", value1, value2, "registerIsCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterFileIsNull() {
            addCriterion("register_file is null");
            return (Criteria) this;
        }

        public Criteria andRegisterFileIsNotNull() {
            addCriterion("register_file is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterFileEqualTo(String value) {
            addCriterion("register_file =", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileNotEqualTo(String value) {
            addCriterion("register_file <>", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileGreaterThan(String value) {
            addCriterion("register_file >", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileGreaterThanOrEqualTo(String value) {
            addCriterion("register_file >=", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileLessThan(String value) {
            addCriterion("register_file <", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileLessThanOrEqualTo(String value) {
            addCriterion("register_file <=", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileLike(String value) {
            addCriterion("register_file like", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileNotLike(String value) {
            addCriterion("register_file not like", value, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileIn(List<String> values) {
            addCriterion("register_file in", values, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileNotIn(List<String> values) {
            addCriterion("register_file not in", values, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileBetween(String value1, String value2) {
            addCriterion("register_file between", value1, value2, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterFileNotBetween(String value1, String value2) {
            addCriterion("register_file not between", value1, value2, "registerFile");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseIsNull() {
            addCriterion("register_license is null");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseIsNotNull() {
            addCriterion("register_license is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseEqualTo(String value) {
            addCriterion("register_license =", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseNotEqualTo(String value) {
            addCriterion("register_license <>", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseGreaterThan(String value) {
            addCriterion("register_license >", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("register_license >=", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseLessThan(String value) {
            addCriterion("register_license <", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseLessThanOrEqualTo(String value) {
            addCriterion("register_license <=", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseLike(String value) {
            addCriterion("register_license like", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseNotLike(String value) {
            addCriterion("register_license not like", value, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseIn(List<String> values) {
            addCriterion("register_license in", values, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseNotIn(List<String> values) {
            addCriterion("register_license not in", values, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseBetween(String value1, String value2) {
            addCriterion("register_license between", value1, value2, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterLicenseNotBetween(String value1, String value2) {
            addCriterion("register_license not between", value1, value2, "registerLicense");
            return (Criteria) this;
        }

        public Criteria andRegisterSealIsNull() {
            addCriterion("register_seal is null");
            return (Criteria) this;
        }

        public Criteria andRegisterSealIsNotNull() {
            addCriterion("register_seal is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterSealEqualTo(String value) {
            addCriterion("register_seal =", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealNotEqualTo(String value) {
            addCriterion("register_seal <>", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealGreaterThan(String value) {
            addCriterion("register_seal >", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealGreaterThanOrEqualTo(String value) {
            addCriterion("register_seal >=", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealLessThan(String value) {
            addCriterion("register_seal <", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealLessThanOrEqualTo(String value) {
            addCriterion("register_seal <=", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealLike(String value) {
            addCriterion("register_seal like", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealNotLike(String value) {
            addCriterion("register_seal not like", value, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealIn(List<String> values) {
            addCriterion("register_seal in", values, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealNotIn(List<String> values) {
            addCriterion("register_seal not in", values, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealBetween(String value1, String value2) {
            addCriterion("register_seal between", value1, value2, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andRegisterSealNotBetween(String value1, String value2) {
            addCriterion("register_seal not between", value1, value2, "registerSeal");
            return (Criteria) this;
        }

        public Criteria andTemplateFileIsNull() {
            addCriterion("template_file is null");
            return (Criteria) this;
        }

        public Criteria andTemplateFileIsNotNull() {
            addCriterion("template_file is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateFileEqualTo(String value) {
            addCriterion("template_file =", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotEqualTo(String value) {
            addCriterion("template_file <>", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileGreaterThan(String value) {
            addCriterion("template_file >", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileGreaterThanOrEqualTo(String value) {
            addCriterion("template_file >=", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileLessThan(String value) {
            addCriterion("template_file <", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileLessThanOrEqualTo(String value) {
            addCriterion("template_file <=", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileLike(String value) {
            addCriterion("template_file like", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotLike(String value) {
            addCriterion("template_file not like", value, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileIn(List<String> values) {
            addCriterion("template_file in", values, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotIn(List<String> values) {
            addCriterion("template_file not in", values, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileBetween(String value1, String value2) {
            addCriterion("template_file between", value1, value2, "templateFile");
            return (Criteria) this;
        }

        public Criteria andTemplateFileNotBetween(String value1, String value2) {
            addCriterion("template_file not between", value1, value2, "templateFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileIsNull() {
            addCriterion("apply_file is null");
            return (Criteria) this;
        }

        public Criteria andApplyFileIsNotNull() {
            addCriterion("apply_file is not null");
            return (Criteria) this;
        }

        public Criteria andApplyFileEqualTo(String value) {
            addCriterion("apply_file =", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileNotEqualTo(String value) {
            addCriterion("apply_file <>", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileGreaterThan(String value) {
            addCriterion("apply_file >", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileGreaterThanOrEqualTo(String value) {
            addCriterion("apply_file >=", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileLessThan(String value) {
            addCriterion("apply_file <", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileLessThanOrEqualTo(String value) {
            addCriterion("apply_file <=", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileLike(String value) {
            addCriterion("apply_file like", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileNotLike(String value) {
            addCriterion("apply_file not like", value, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileIn(List<String> values) {
            addCriterion("apply_file in", values, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileNotIn(List<String> values) {
            addCriterion("apply_file not in", values, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileBetween(String value1, String value2) {
            addCriterion("apply_file between", value1, value2, "applyFile");
            return (Criteria) this;
        }

        public Criteria andApplyFileNotBetween(String value1, String value2) {
            addCriterion("apply_file not between", value1, value2, "applyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileIsNull() {
            addCriterion("policy_file is null");
            return (Criteria) this;
        }

        public Criteria andPolicyFileIsNotNull() {
            addCriterion("policy_file is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyFileEqualTo(String value) {
            addCriterion("policy_file =", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileNotEqualTo(String value) {
            addCriterion("policy_file <>", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileGreaterThan(String value) {
            addCriterion("policy_file >", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileGreaterThanOrEqualTo(String value) {
            addCriterion("policy_file >=", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileLessThan(String value) {
            addCriterion("policy_file <", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileLessThanOrEqualTo(String value) {
            addCriterion("policy_file <=", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileLike(String value) {
            addCriterion("policy_file like", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileNotLike(String value) {
            addCriterion("policy_file not like", value, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileIn(List<String> values) {
            addCriterion("policy_file in", values, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileNotIn(List<String> values) {
            addCriterion("policy_file not in", values, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileBetween(String value1, String value2) {
            addCriterion("policy_file between", value1, value2, "policyFile");
            return (Criteria) this;
        }

        public Criteria andPolicyFileNotBetween(String value1, String value2) {
            addCriterion("policy_file not between", value1, value2, "policyFile");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeIsNull() {
            addCriterion("cur_record_type is null");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeIsNotNull() {
            addCriterion("cur_record_type is not null");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeEqualTo(String value) {
            addCriterion("cur_record_type =", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeNotEqualTo(String value) {
            addCriterion("cur_record_type <>", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeGreaterThan(String value) {
            addCriterion("cur_record_type >", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cur_record_type >=", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeLessThan(String value) {
            addCriterion("cur_record_type <", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeLessThanOrEqualTo(String value) {
            addCriterion("cur_record_type <=", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeLike(String value) {
            addCriterion("cur_record_type like", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeNotLike(String value) {
            addCriterion("cur_record_type not like", value, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeIn(List<String> values) {
            addCriterion("cur_record_type in", values, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeNotIn(List<String> values) {
            addCriterion("cur_record_type not in", values, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeBetween(String value1, String value2) {
            addCriterion("cur_record_type between", value1, value2, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCurRecordTypeNotBetween(String value1, String value2) {
            addCriterion("cur_record_type not between", value1, value2, "curRecordType");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(String value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(String value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(String value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(String value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(String value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLike(String value) {
            addCriterion("create_id like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotLike(String value) {
            addCriterion("create_id not like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<String> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<String> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(String value1, String value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(String value1, String value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameIsNull() {
            addCriterion("cur_record_name is null");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameIsNotNull() {
            addCriterion("cur_record_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameEqualTo(String value) {
            addCriterion("cur_record_name =", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameNotEqualTo(String value) {
            addCriterion("cur_record_name <>", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameGreaterThan(String value) {
            addCriterion("cur_record_name >", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameGreaterThanOrEqualTo(String value) {
            addCriterion("cur_record_name >=", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameLessThan(String value) {
            addCriterion("cur_record_name <", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameLessThanOrEqualTo(String value) {
            addCriterion("cur_record_name <=", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameLike(String value) {
            addCriterion("cur_record_name like", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameNotLike(String value) {
            addCriterion("cur_record_name not like", value, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameIn(List<String> values) {
            addCriterion("cur_record_name in", values, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameNotIn(List<String> values) {
            addCriterion("cur_record_name not in", values, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameBetween(String value1, String value2) {
            addCriterion("cur_record_name between", value1, value2, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andCurRecordNameNotBetween(String value1, String value2) {
            addCriterion("cur_record_name not between", value1, value2, "curRecordName");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNull() {
            addCriterion("step_id is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("step_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(Short value) {
            addCriterion("step_id =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(Short value) {
            addCriterion("step_id <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(Short value) {
            addCriterion("step_id >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(Short value) {
            addCriterion("step_id >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(Short value) {
            addCriterion("step_id <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(Short value) {
            addCriterion("step_id <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<Short> values) {
            addCriterion("step_id in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<Short> values) {
            addCriterion("step_id not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(Short value1, Short value2) {
            addCriterion("step_id between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(Short value1, Short value2) {
            addCriterion("step_id not between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdIsNull() {
            addCriterion("deal_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDealUserIdIsNotNull() {
            addCriterion("deal_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserIdEqualTo(String value) {
            addCriterion("deal_user_id =", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdNotEqualTo(String value) {
            addCriterion("deal_user_id <>", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdGreaterThan(String value) {
            addCriterion("deal_user_id >", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("deal_user_id >=", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdLessThan(String value) {
            addCriterion("deal_user_id <", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdLessThanOrEqualTo(String value) {
            addCriterion("deal_user_id <=", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdLike(String value) {
            addCriterion("deal_user_id like", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdNotLike(String value) {
            addCriterion("deal_user_id not like", value, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdIn(List<String> values) {
            addCriterion("deal_user_id in", values, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdNotIn(List<String> values) {
            addCriterion("deal_user_id not in", values, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdBetween(String value1, String value2) {
            addCriterion("deal_user_id between", value1, value2, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserIdNotBetween(String value1, String value2) {
            addCriterion("deal_user_id not between", value1, value2, "dealUserId");
            return (Criteria) this;
        }

        public Criteria andDealUserNameIsNull() {
            addCriterion("deal_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDealUserNameIsNotNull() {
            addCriterion("deal_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserNameEqualTo(String value) {
            addCriterion("deal_user_name =", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameNotEqualTo(String value) {
            addCriterion("deal_user_name <>", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameGreaterThan(String value) {
            addCriterion("deal_user_name >", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("deal_user_name >=", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameLessThan(String value) {
            addCriterion("deal_user_name <", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameLessThanOrEqualTo(String value) {
            addCriterion("deal_user_name <=", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameLike(String value) {
            addCriterion("deal_user_name like", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameNotLike(String value) {
            addCriterion("deal_user_name not like", value, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameIn(List<String> values) {
            addCriterion("deal_user_name in", values, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameNotIn(List<String> values) {
            addCriterion("deal_user_name not in", values, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameBetween(String value1, String value2) {
            addCriterion("deal_user_name between", value1, value2, "dealUserName");
            return (Criteria) this;
        }

        public Criteria andDealUserNameNotBetween(String value1, String value2) {
            addCriterion("deal_user_name not between", value1, value2, "dealUserName");
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