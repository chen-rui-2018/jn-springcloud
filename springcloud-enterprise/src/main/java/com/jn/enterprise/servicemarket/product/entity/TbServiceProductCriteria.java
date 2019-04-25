package com.jn.enterprise.servicemarket.product.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceProductCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceProductCriteria() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id_ is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id_ =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id_ <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id_ >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id_ >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id_ <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id_ <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id_ like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id_ not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id_ in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id_ not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id_ between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id_ not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
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

        public Criteria andReferPriceIsNull() {
            addCriterion("refer_price is null");
            return (Criteria) this;
        }

        public Criteria andReferPriceIsNotNull() {
            addCriterion("refer_price is not null");
            return (Criteria) this;
        }

        public Criteria andReferPriceEqualTo(String value) {
            addCriterion("refer_price =", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotEqualTo(String value) {
            addCriterion("refer_price <>", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceGreaterThan(String value) {
            addCriterion("refer_price >", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceGreaterThanOrEqualTo(String value) {
            addCriterion("refer_price >=", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceLessThan(String value) {
            addCriterion("refer_price <", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceLessThanOrEqualTo(String value) {
            addCriterion("refer_price <=", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceLike(String value) {
            addCriterion("refer_price like", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotLike(String value) {
            addCriterion("refer_price not like", value, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceIn(List<String> values) {
            addCriterion("refer_price in", values, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotIn(List<String> values) {
            addCriterion("refer_price not in", values, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceBetween(String value1, String value2) {
            addCriterion("refer_price between", value1, value2, "referPrice");
            return (Criteria) this;
        }

        public Criteria andReferPriceNotBetween(String value1, String value2) {
            addCriterion("refer_price not between", value1, value2, "referPrice");
            return (Criteria) this;
        }

        public Criteria andSignoryIdIsNull() {
            addCriterion("signory_id is null");
            return (Criteria) this;
        }

        public Criteria andSignoryIdIsNotNull() {
            addCriterion("signory_id is not null");
            return (Criteria) this;
        }

        public Criteria andSignoryIdEqualTo(String value) {
            addCriterion("signory_id =", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdNotEqualTo(String value) {
            addCriterion("signory_id <>", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdGreaterThan(String value) {
            addCriterion("signory_id >", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("signory_id >=", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdLessThan(String value) {
            addCriterion("signory_id <", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdLessThanOrEqualTo(String value) {
            addCriterion("signory_id <=", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdLike(String value) {
            addCriterion("signory_id like", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdNotLike(String value) {
            addCriterion("signory_id not like", value, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdIn(List<String> values) {
            addCriterion("signory_id in", values, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdNotIn(List<String> values) {
            addCriterion("signory_id not in", values, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdBetween(String value1, String value2) {
            addCriterion("signory_id between", value1, value2, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryIdNotBetween(String value1, String value2) {
            addCriterion("signory_id not between", value1, value2, "signoryId");
            return (Criteria) this;
        }

        public Criteria andSignoryNameIsNull() {
            addCriterion("signory_name is null");
            return (Criteria) this;
        }

        public Criteria andSignoryNameIsNotNull() {
            addCriterion("signory_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignoryNameEqualTo(String value) {
            addCriterion("signory_name =", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameNotEqualTo(String value) {
            addCriterion("signory_name <>", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameGreaterThan(String value) {
            addCriterion("signory_name >", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("signory_name >=", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameLessThan(String value) {
            addCriterion("signory_name <", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameLessThanOrEqualTo(String value) {
            addCriterion("signory_name <=", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameLike(String value) {
            addCriterion("signory_name like", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameNotLike(String value) {
            addCriterion("signory_name not like", value, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameIn(List<String> values) {
            addCriterion("signory_name in", values, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameNotIn(List<String> values) {
            addCriterion("signory_name not in", values, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameBetween(String value1, String value2) {
            addCriterion("signory_name between", value1, value2, "signoryName");
            return (Criteria) this;
        }

        public Criteria andSignoryNameNotBetween(String value1, String value2) {
            addCriterion("signory_name not between", value1, value2, "signoryName");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
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

        public Criteria andServiceCycleIsNull() {
            addCriterion("service_cycle is null");
            return (Criteria) this;
        }

        public Criteria andServiceCycleIsNotNull() {
            addCriterion("service_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCycleEqualTo(String value) {
            addCriterion("service_cycle =", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleNotEqualTo(String value) {
            addCriterion("service_cycle <>", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleGreaterThan(String value) {
            addCriterion("service_cycle >", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleGreaterThanOrEqualTo(String value) {
            addCriterion("service_cycle >=", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleLessThan(String value) {
            addCriterion("service_cycle <", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleLessThanOrEqualTo(String value) {
            addCriterion("service_cycle <=", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleLike(String value) {
            addCriterion("service_cycle like", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleNotLike(String value) {
            addCriterion("service_cycle not like", value, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleIn(List<String> values) {
            addCriterion("service_cycle in", values, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleNotIn(List<String> values) {
            addCriterion("service_cycle not in", values, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleBetween(String value1, String value2) {
            addCriterion("service_cycle between", value1, value2, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andServiceCycleNotBetween(String value1, String value2) {
            addCriterion("service_cycle not between", value1, value2, "serviceCycle");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNull() {
            addCriterion("picture_url is null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNotNull() {
            addCriterion("picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlEqualTo(String value) {
            addCriterion("picture_url =", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotEqualTo(String value) {
            addCriterion("picture_url <>", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThan(String value) {
            addCriterion("picture_url >", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("picture_url >=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThan(String value) {
            addCriterion("picture_url <", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("picture_url <=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLike(String value) {
            addCriterion("picture_url like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotLike(String value) {
            addCriterion("picture_url not like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIn(List<String> values) {
            addCriterion("picture_url in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotIn(List<String> values) {
            addCriterion("picture_url not in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlBetween(String value1, String value2) {
            addCriterion("picture_url between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotBetween(String value1, String value2) {
            addCriterion("picture_url not between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Integer value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Integer value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Integer value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Integer value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Integer value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Integer> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Integer> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Integer value1, Integer value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
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

        public Criteria andApprovalAccountIsNull() {
            addCriterion("approval_account is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountIsNotNull() {
            addCriterion("approval_account is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountEqualTo(String value) {
            addCriterion("approval_account =", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotEqualTo(String value) {
            addCriterion("approval_account <>", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountGreaterThan(String value) {
            addCriterion("approval_account >", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountGreaterThanOrEqualTo(String value) {
            addCriterion("approval_account >=", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountLessThan(String value) {
            addCriterion("approval_account <", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountLessThanOrEqualTo(String value) {
            addCriterion("approval_account <=", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountLike(String value) {
            addCriterion("approval_account like", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotLike(String value) {
            addCriterion("approval_account not like", value, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountIn(List<String> values) {
            addCriterion("approval_account in", values, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotIn(List<String> values) {
            addCriterion("approval_account not in", values, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountBetween(String value1, String value2) {
            addCriterion("approval_account between", value1, value2, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalAccountNotBetween(String value1, String value2) {
            addCriterion("approval_account not between", value1, value2, "approvalAccount");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsIsNull() {
            addCriterion("approval_comments is null");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsIsNotNull() {
            addCriterion("approval_comments is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsEqualTo(String value) {
            addCriterion("approval_comments =", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsNotEqualTo(String value) {
            addCriterion("approval_comments <>", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsGreaterThan(String value) {
            addCriterion("approval_comments >", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("approval_comments >=", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsLessThan(String value) {
            addCriterion("approval_comments <", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsLessThanOrEqualTo(String value) {
            addCriterion("approval_comments <=", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsLike(String value) {
            addCriterion("approval_comments like", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsNotLike(String value) {
            addCriterion("approval_comments not like", value, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsIn(List<String> values) {
            addCriterion("approval_comments in", values, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsNotIn(List<String> values) {
            addCriterion("approval_comments not in", values, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsBetween(String value1, String value2) {
            addCriterion("approval_comments between", value1, value2, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalCommentsNotBetween(String value1, String value2) {
            addCriterion("approval_comments not between", value1, value2, "approvalComments");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approval_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approval_time =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approval_time <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approval_time >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_time >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approval_time <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_time <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approval_time in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approval_time not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approval_time between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_time not between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andRefRateMinIsNull() {
            addCriterion("ref_rate_min is null");
            return (Criteria) this;
        }

        public Criteria andRefRateMinIsNotNull() {
            addCriterion("ref_rate_min is not null");
            return (Criteria) this;
        }

        public Criteria andRefRateMinEqualTo(Double value) {
            addCriterion("ref_rate_min =", value, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinNotEqualTo(Double value) {
            addCriterion("ref_rate_min <>", value, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinGreaterThan(Double value) {
            addCriterion("ref_rate_min >", value, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinGreaterThanOrEqualTo(Double value) {
            addCriterion("ref_rate_min >=", value, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinLessThan(Double value) {
            addCriterion("ref_rate_min <", value, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinLessThanOrEqualTo(Double value) {
            addCriterion("ref_rate_min <=", value, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinIn(List<Double> values) {
            addCriterion("ref_rate_min in", values, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinNotIn(List<Double> values) {
            addCriterion("ref_rate_min not in", values, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinBetween(Double value1, Double value2) {
            addCriterion("ref_rate_min between", value1, value2, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMinNotBetween(Double value1, Double value2) {
            addCriterion("ref_rate_min not between", value1, value2, "refRateMin");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxIsNull() {
            addCriterion("ref_rate_max is null");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxIsNotNull() {
            addCriterion("ref_rate_max is not null");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxEqualTo(Double value) {
            addCriterion("ref_rate_max =", value, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxNotEqualTo(Double value) {
            addCriterion("ref_rate_max <>", value, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxGreaterThan(Double value) {
            addCriterion("ref_rate_max >", value, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("ref_rate_max >=", value, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxLessThan(Double value) {
            addCriterion("ref_rate_max <", value, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxLessThanOrEqualTo(Double value) {
            addCriterion("ref_rate_max <=", value, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxIn(List<Double> values) {
            addCriterion("ref_rate_max in", values, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxNotIn(List<Double> values) {
            addCriterion("ref_rate_max not in", values, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxBetween(Double value1, Double value2) {
            addCriterion("ref_rate_max between", value1, value2, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andRefRateMaxNotBetween(Double value1, Double value2) {
            addCriterion("ref_rate_max not between", value1, value2, "refRateMax");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanIsNull() {
            addCriterion("is_online_loan is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanIsNotNull() {
            addCriterion("is_online_loan is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanEqualTo(String value) {
            addCriterion("is_online_loan =", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanNotEqualTo(String value) {
            addCriterion("is_online_loan <>", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanGreaterThan(String value) {
            addCriterion("is_online_loan >", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanGreaterThanOrEqualTo(String value) {
            addCriterion("is_online_loan >=", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanLessThan(String value) {
            addCriterion("is_online_loan <", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanLessThanOrEqualTo(String value) {
            addCriterion("is_online_loan <=", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanLike(String value) {
            addCriterion("is_online_loan like", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanNotLike(String value) {
            addCriterion("is_online_loan not like", value, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanIn(List<String> values) {
            addCriterion("is_online_loan in", values, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanNotIn(List<String> values) {
            addCriterion("is_online_loan not in", values, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanBetween(String value1, String value2) {
            addCriterion("is_online_loan between", value1, value2, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLoanNotBetween(String value1, String value2) {
            addCriterion("is_online_loan not between", value1, value2, "isOnlineLoan");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProIsNull() {
            addCriterion("is_policy_pro is null");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProIsNotNull() {
            addCriterion("is_policy_pro is not null");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProEqualTo(String value) {
            addCriterion("is_policy_pro =", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProNotEqualTo(String value) {
            addCriterion("is_policy_pro <>", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProGreaterThan(String value) {
            addCriterion("is_policy_pro >", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProGreaterThanOrEqualTo(String value) {
            addCriterion("is_policy_pro >=", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProLessThan(String value) {
            addCriterion("is_policy_pro <", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProLessThanOrEqualTo(String value) {
            addCriterion("is_policy_pro <=", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProLike(String value) {
            addCriterion("is_policy_pro like", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProNotLike(String value) {
            addCriterion("is_policy_pro not like", value, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProIn(List<String> values) {
            addCriterion("is_policy_pro in", values, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProNotIn(List<String> values) {
            addCriterion("is_policy_pro not in", values, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProBetween(String value1, String value2) {
            addCriterion("is_policy_pro between", value1, value2, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsPolicyProNotBetween(String value1, String value2) {
            addCriterion("is_policy_pro not between", value1, value2, "isPolicyPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProIsNull() {
            addCriterion("is_general_pro is null");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProIsNotNull() {
            addCriterion("is_general_pro is not null");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProEqualTo(String value) {
            addCriterion("is_general_pro =", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProNotEqualTo(String value) {
            addCriterion("is_general_pro <>", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProGreaterThan(String value) {
            addCriterion("is_general_pro >", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProGreaterThanOrEqualTo(String value) {
            addCriterion("is_general_pro >=", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProLessThan(String value) {
            addCriterion("is_general_pro <", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProLessThanOrEqualTo(String value) {
            addCriterion("is_general_pro <=", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProLike(String value) {
            addCriterion("is_general_pro like", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProNotLike(String value) {
            addCriterion("is_general_pro not like", value, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProIn(List<String> values) {
            addCriterion("is_general_pro in", values, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProNotIn(List<String> values) {
            addCriterion("is_general_pro not in", values, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProBetween(String value1, String value2) {
            addCriterion("is_general_pro between", value1, value2, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsGeneralProNotBetween(String value1, String value2) {
            addCriterion("is_general_pro not between", value1, value2, "isGeneralPro");
            return (Criteria) this;
        }

        public Criteria andIsRmbIsNull() {
            addCriterion("is_rmb is null");
            return (Criteria) this;
        }

        public Criteria andIsRmbIsNotNull() {
            addCriterion("is_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andIsRmbEqualTo(String value) {
            addCriterion("is_rmb =", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbNotEqualTo(String value) {
            addCriterion("is_rmb <>", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbGreaterThan(String value) {
            addCriterion("is_rmb >", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbGreaterThanOrEqualTo(String value) {
            addCriterion("is_rmb >=", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbLessThan(String value) {
            addCriterion("is_rmb <", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbLessThanOrEqualTo(String value) {
            addCriterion("is_rmb <=", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbLike(String value) {
            addCriterion("is_rmb like", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbNotLike(String value) {
            addCriterion("is_rmb not like", value, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbIn(List<String> values) {
            addCriterion("is_rmb in", values, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbNotIn(List<String> values) {
            addCriterion("is_rmb not in", values, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbBetween(String value1, String value2) {
            addCriterion("is_rmb between", value1, value2, "isRmb");
            return (Criteria) this;
        }

        public Criteria andIsRmbNotBetween(String value1, String value2) {
            addCriterion("is_rmb not between", value1, value2, "isRmb");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeIsNull() {
            addCriterion("loan_category_code is null");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeIsNotNull() {
            addCriterion("loan_category_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeEqualTo(String value) {
            addCriterion("loan_category_code =", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeNotEqualTo(String value) {
            addCriterion("loan_category_code <>", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeGreaterThan(String value) {
            addCriterion("loan_category_code >", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_category_code >=", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeLessThan(String value) {
            addCriterion("loan_category_code <", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("loan_category_code <=", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeLike(String value) {
            addCriterion("loan_category_code like", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeNotLike(String value) {
            addCriterion("loan_category_code not like", value, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeIn(List<String> values) {
            addCriterion("loan_category_code in", values, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeNotIn(List<String> values) {
            addCriterion("loan_category_code not in", values, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeBetween(String value1, String value2) {
            addCriterion("loan_category_code between", value1, value2, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("loan_category_code not between", value1, value2, "loanCategoryCode");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameIsNull() {
            addCriterion("loan_category_name is null");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameIsNotNull() {
            addCriterion("loan_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameEqualTo(String value) {
            addCriterion("loan_category_name =", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameNotEqualTo(String value) {
            addCriterion("loan_category_name <>", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameGreaterThan(String value) {
            addCriterion("loan_category_name >", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("loan_category_name >=", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameLessThan(String value) {
            addCriterion("loan_category_name <", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("loan_category_name <=", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameLike(String value) {
            addCriterion("loan_category_name like", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameNotLike(String value) {
            addCriterion("loan_category_name not like", value, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameIn(List<String> values) {
            addCriterion("loan_category_name in", values, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameNotIn(List<String> values) {
            addCriterion("loan_category_name not in", values, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameBetween(String value1, String value2) {
            addCriterion("loan_category_name between", value1, value2, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanCategoryNameNotBetween(String value1, String value2) {
            addCriterion("loan_category_name not between", value1, value2, "loanCategoryName");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinIsNull() {
            addCriterion("loan_amount_min is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinIsNotNull() {
            addCriterion("loan_amount_min is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinEqualTo(Double value) {
            addCriterion("loan_amount_min =", value, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinNotEqualTo(Double value) {
            addCriterion("loan_amount_min <>", value, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinGreaterThan(Double value) {
            addCriterion("loan_amount_min >", value, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_amount_min >=", value, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinLessThan(Double value) {
            addCriterion("loan_amount_min <", value, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinLessThanOrEqualTo(Double value) {
            addCriterion("loan_amount_min <=", value, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinIn(List<Double> values) {
            addCriterion("loan_amount_min in", values, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinNotIn(List<Double> values) {
            addCriterion("loan_amount_min not in", values, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinBetween(Double value1, Double value2) {
            addCriterion("loan_amount_min between", value1, value2, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMinNotBetween(Double value1, Double value2) {
            addCriterion("loan_amount_min not between", value1, value2, "loanAmountMin");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxIsNull() {
            addCriterion("loan_amount_max is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxIsNotNull() {
            addCriterion("loan_amount_max is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxEqualTo(Double value) {
            addCriterion("loan_amount_max =", value, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxNotEqualTo(Double value) {
            addCriterion("loan_amount_max <>", value, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxGreaterThan(Double value) {
            addCriterion("loan_amount_max >", value, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_amount_max >=", value, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxLessThan(Double value) {
            addCriterion("loan_amount_max <", value, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxLessThanOrEqualTo(Double value) {
            addCriterion("loan_amount_max <=", value, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxIn(List<Double> values) {
            addCriterion("loan_amount_max in", values, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxNotIn(List<Double> values) {
            addCriterion("loan_amount_max not in", values, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxBetween(Double value1, Double value2) {
            addCriterion("loan_amount_max between", value1, value2, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanAmountMaxNotBetween(Double value1, Double value2) {
            addCriterion("loan_amount_max not between", value1, value2, "loanAmountMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinIsNull() {
            addCriterion("loan_term_min is null");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinIsNotNull() {
            addCriterion("loan_term_min is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinEqualTo(Integer value) {
            addCriterion("loan_term_min =", value, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinNotEqualTo(Integer value) {
            addCriterion("loan_term_min <>", value, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinGreaterThan(Integer value) {
            addCriterion("loan_term_min >", value, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_term_min >=", value, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinLessThan(Integer value) {
            addCriterion("loan_term_min <", value, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinLessThanOrEqualTo(Integer value) {
            addCriterion("loan_term_min <=", value, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinIn(List<Integer> values) {
            addCriterion("loan_term_min in", values, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinNotIn(List<Integer> values) {
            addCriterion("loan_term_min not in", values, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinBetween(Integer value1, Integer value2) {
            addCriterion("loan_term_min between", value1, value2, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMinNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_term_min not between", value1, value2, "loanTermMin");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxIsNull() {
            addCriterion("loan_term_max is null");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxIsNotNull() {
            addCriterion("loan_term_max is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxEqualTo(Integer value) {
            addCriterion("loan_term_max =", value, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxNotEqualTo(Integer value) {
            addCriterion("loan_term_max <>", value, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxGreaterThan(Integer value) {
            addCriterion("loan_term_max >", value, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_term_max >=", value, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxLessThan(Integer value) {
            addCriterion("loan_term_max <", value, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxLessThanOrEqualTo(Integer value) {
            addCriterion("loan_term_max <=", value, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxIn(List<Integer> values) {
            addCriterion("loan_term_max in", values, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxNotIn(List<Integer> values) {
            addCriterion("loan_term_max not in", values, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxBetween(Integer value1, Integer value2) {
            addCriterion("loan_term_max between", value1, value2, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andLoanTermMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_term_max not between", value1, value2, "loanTermMax");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeIsNull() {
            addCriterion("assure_method_code is null");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeIsNotNull() {
            addCriterion("assure_method_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeEqualTo(String value) {
            addCriterion("assure_method_code =", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeNotEqualTo(String value) {
            addCriterion("assure_method_code <>", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeGreaterThan(String value) {
            addCriterion("assure_method_code >", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeGreaterThanOrEqualTo(String value) {
            addCriterion("assure_method_code >=", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeLessThan(String value) {
            addCriterion("assure_method_code <", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeLessThanOrEqualTo(String value) {
            addCriterion("assure_method_code <=", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeLike(String value) {
            addCriterion("assure_method_code like", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeNotLike(String value) {
            addCriterion("assure_method_code not like", value, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeIn(List<String> values) {
            addCriterion("assure_method_code in", values, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeNotIn(List<String> values) {
            addCriterion("assure_method_code not in", values, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeBetween(String value1, String value2) {
            addCriterion("assure_method_code between", value1, value2, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodCodeNotBetween(String value1, String value2) {
            addCriterion("assure_method_code not between", value1, value2, "assureMethodCode");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameIsNull() {
            addCriterion("assure_method_name is null");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameIsNotNull() {
            addCriterion("assure_method_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameEqualTo(String value) {
            addCriterion("assure_method_name =", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameNotEqualTo(String value) {
            addCriterion("assure_method_name <>", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameGreaterThan(String value) {
            addCriterion("assure_method_name >", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("assure_method_name >=", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameLessThan(String value) {
            addCriterion("assure_method_name <", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameLessThanOrEqualTo(String value) {
            addCriterion("assure_method_name <=", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameLike(String value) {
            addCriterion("assure_method_name like", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameNotLike(String value) {
            addCriterion("assure_method_name not like", value, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameIn(List<String> values) {
            addCriterion("assure_method_name in", values, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameNotIn(List<String> values) {
            addCriterion("assure_method_name not in", values, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameBetween(String value1, String value2) {
            addCriterion("assure_method_name between", value1, value2, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andAssureMethodNameNotBetween(String value1, String value2) {
            addCriterion("assure_method_name not between", value1, value2, "assureMethodName");
            return (Criteria) this;
        }

        public Criteria andProductFeatureIsNull() {
            addCriterion("product_feature is null");
            return (Criteria) this;
        }

        public Criteria andProductFeatureIsNotNull() {
            addCriterion("product_feature is not null");
            return (Criteria) this;
        }

        public Criteria andProductFeatureEqualTo(String value) {
            addCriterion("product_feature =", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureNotEqualTo(String value) {
            addCriterion("product_feature <>", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureGreaterThan(String value) {
            addCriterion("product_feature >", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("product_feature >=", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureLessThan(String value) {
            addCriterion("product_feature <", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureLessThanOrEqualTo(String value) {
            addCriterion("product_feature <=", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureLike(String value) {
            addCriterion("product_feature like", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureNotLike(String value) {
            addCriterion("product_feature not like", value, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureIn(List<String> values) {
            addCriterion("product_feature in", values, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureNotIn(List<String> values) {
            addCriterion("product_feature not in", values, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureBetween(String value1, String value2) {
            addCriterion("product_feature between", value1, value2, "productFeature");
            return (Criteria) this;
        }

        public Criteria andProductFeatureNotBetween(String value1, String value2) {
            addCriterion("product_feature not between", value1, value2, "productFeature");
            return (Criteria) this;
        }

        public Criteria andApplyConditionIsNull() {
            addCriterion("apply_condition is null");
            return (Criteria) this;
        }

        public Criteria andApplyConditionIsNotNull() {
            addCriterion("apply_condition is not null");
            return (Criteria) this;
        }

        public Criteria andApplyConditionEqualTo(String value) {
            addCriterion("apply_condition =", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionNotEqualTo(String value) {
            addCriterion("apply_condition <>", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionGreaterThan(String value) {
            addCriterion("apply_condition >", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionGreaterThanOrEqualTo(String value) {
            addCriterion("apply_condition >=", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionLessThan(String value) {
            addCriterion("apply_condition <", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionLessThanOrEqualTo(String value) {
            addCriterion("apply_condition <=", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionLike(String value) {
            addCriterion("apply_condition like", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionNotLike(String value) {
            addCriterion("apply_condition not like", value, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionIn(List<String> values) {
            addCriterion("apply_condition in", values, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionNotIn(List<String> values) {
            addCriterion("apply_condition not in", values, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionBetween(String value1, String value2) {
            addCriterion("apply_condition between", value1, value2, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andApplyConditionNotBetween(String value1, String value2) {
            addCriterion("apply_condition not between", value1, value2, "applyCondition");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialIsNull() {
            addCriterion("submit_material is null");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialIsNotNull() {
            addCriterion("submit_material is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialEqualTo(String value) {
            addCriterion("submit_material =", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialNotEqualTo(String value) {
            addCriterion("submit_material <>", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialGreaterThan(String value) {
            addCriterion("submit_material >", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("submit_material >=", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialLessThan(String value) {
            addCriterion("submit_material <", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialLessThanOrEqualTo(String value) {
            addCriterion("submit_material <=", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialLike(String value) {
            addCriterion("submit_material like", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialNotLike(String value) {
            addCriterion("submit_material not like", value, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialIn(List<String> values) {
            addCriterion("submit_material in", values, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialNotIn(List<String> values) {
            addCriterion("submit_material not in", values, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialBetween(String value1, String value2) {
            addCriterion("submit_material between", value1, value2, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andSubmitMaterialNotBetween(String value1, String value2) {
            addCriterion("submit_material not between", value1, value2, "submitMaterial");
            return (Criteria) this;
        }

        public Criteria andApplicableCustIsNull() {
            addCriterion("applicable_cust is null");
            return (Criteria) this;
        }

        public Criteria andApplicableCustIsNotNull() {
            addCriterion("applicable_cust is not null");
            return (Criteria) this;
        }

        public Criteria andApplicableCustEqualTo(String value) {
            addCriterion("applicable_cust =", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustNotEqualTo(String value) {
            addCriterion("applicable_cust <>", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustGreaterThan(String value) {
            addCriterion("applicable_cust >", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustGreaterThanOrEqualTo(String value) {
            addCriterion("applicable_cust >=", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustLessThan(String value) {
            addCriterion("applicable_cust <", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustLessThanOrEqualTo(String value) {
            addCriterion("applicable_cust <=", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustLike(String value) {
            addCriterion("applicable_cust like", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustNotLike(String value) {
            addCriterion("applicable_cust not like", value, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustIn(List<String> values) {
            addCriterion("applicable_cust in", values, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustNotIn(List<String> values) {
            addCriterion("applicable_cust not in", values, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustBetween(String value1, String value2) {
            addCriterion("applicable_cust between", value1, value2, "applicableCust");
            return (Criteria) this;
        }

        public Criteria andApplicableCustNotBetween(String value1, String value2) {
            addCriterion("applicable_cust not between", value1, value2, "applicableCust");
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