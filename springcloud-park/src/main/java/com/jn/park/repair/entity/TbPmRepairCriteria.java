package com.jn.park.repair.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPmRepairCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPmRepairCriteria() {
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(String value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(String value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(String value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(String value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLike(String value) {
            addCriterion("enterprise_id like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotLike(String value) {
            addCriterion("enterprise_id not like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<String> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<String> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(String value1, String value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
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

        public Criteria andContactManIsNull() {
            addCriterion("contact_man is null");
            return (Criteria) this;
        }

        public Criteria andContactManIsNotNull() {
            addCriterion("contact_man is not null");
            return (Criteria) this;
        }

        public Criteria andContactManEqualTo(String value) {
            addCriterion("contact_man =", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManNotEqualTo(String value) {
            addCriterion("contact_man <>", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManGreaterThan(String value) {
            addCriterion("contact_man >", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManGreaterThanOrEqualTo(String value) {
            addCriterion("contact_man >=", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManLessThan(String value) {
            addCriterion("contact_man <", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManLessThanOrEqualTo(String value) {
            addCriterion("contact_man <=", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManLike(String value) {
            addCriterion("contact_man like", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManNotLike(String value) {
            addCriterion("contact_man not like", value, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManIn(List<String> values) {
            addCriterion("contact_man in", values, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManNotIn(List<String> values) {
            addCriterion("contact_man not in", values, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManBetween(String value1, String value2) {
            addCriterion("contact_man between", value1, value2, "contactMan");
            return (Criteria) this;
        }

        public Criteria andContactManNotBetween(String value1, String value2) {
            addCriterion("contact_man not between", value1, value2, "contactMan");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairIsNull() {
            addCriterion("is_free_repair is null");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairIsNotNull() {
            addCriterion("is_free_repair is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairEqualTo(String value) {
            addCriterion("is_free_repair =", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairNotEqualTo(String value) {
            addCriterion("is_free_repair <>", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairGreaterThan(String value) {
            addCriterion("is_free_repair >", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairGreaterThanOrEqualTo(String value) {
            addCriterion("is_free_repair >=", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairLessThan(String value) {
            addCriterion("is_free_repair <", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairLessThanOrEqualTo(String value) {
            addCriterion("is_free_repair <=", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairLike(String value) {
            addCriterion("is_free_repair like", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairNotLike(String value) {
            addCriterion("is_free_repair not like", value, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairIn(List<String> values) {
            addCriterion("is_free_repair in", values, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairNotIn(List<String> values) {
            addCriterion("is_free_repair not in", values, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairBetween(String value1, String value2) {
            addCriterion("is_free_repair between", value1, value2, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andIsFreeRepairNotBetween(String value1, String value2) {
            addCriterion("is_free_repair not between", value1, value2, "isFreeRepair");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceIsNull() {
            addCriterion("materiel_total_price is null");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceIsNotNull() {
            addCriterion("materiel_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceEqualTo(Long value) {
            addCriterion("materiel_total_price =", value, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceNotEqualTo(Long value) {
            addCriterion("materiel_total_price <>", value, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceGreaterThan(Long value) {
            addCriterion("materiel_total_price >", value, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("materiel_total_price >=", value, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceLessThan(Long value) {
            addCriterion("materiel_total_price <", value, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("materiel_total_price <=", value, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceIn(List<Long> values) {
            addCriterion("materiel_total_price in", values, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceNotIn(List<Long> values) {
            addCriterion("materiel_total_price not in", values, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceBetween(Long value1, Long value2) {
            addCriterion("materiel_total_price between", value1, value2, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andMaterielTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("materiel_total_price not between", value1, value2, "materielTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyIsNull() {
            addCriterion("asset_company is null");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyIsNotNull() {
            addCriterion("asset_company is not null");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyEqualTo(String value) {
            addCriterion("asset_company =", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyNotEqualTo(String value) {
            addCriterion("asset_company <>", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyGreaterThan(String value) {
            addCriterion("asset_company >", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("asset_company >=", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyLessThan(String value) {
            addCriterion("asset_company <", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyLessThanOrEqualTo(String value) {
            addCriterion("asset_company <=", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyLike(String value) {
            addCriterion("asset_company like", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyNotLike(String value) {
            addCriterion("asset_company not like", value, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyIn(List<String> values) {
            addCriterion("asset_company in", values, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyNotIn(List<String> values) {
            addCriterion("asset_company not in", values, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyBetween(String value1, String value2) {
            addCriterion("asset_company between", value1, value2, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompanyNotBetween(String value1, String value2) {
            addCriterion("asset_company not between", value1, value2, "assetCompany");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateIsNull() {
            addCriterion("asset_complete_date is null");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateIsNotNull() {
            addCriterion("asset_complete_date is not null");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateEqualTo(Date value) {
            addCriterion("asset_complete_date =", value, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateNotEqualTo(Date value) {
            addCriterion("asset_complete_date <>", value, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateGreaterThan(Date value) {
            addCriterion("asset_complete_date >", value, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("asset_complete_date >=", value, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateLessThan(Date value) {
            addCriterion("asset_complete_date <", value, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateLessThanOrEqualTo(Date value) {
            addCriterion("asset_complete_date <=", value, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateIn(List<Date> values) {
            addCriterion("asset_complete_date in", values, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateNotIn(List<Date> values) {
            addCriterion("asset_complete_date not in", values, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateBetween(Date value1, Date value2) {
            addCriterion("asset_complete_date between", value1, value2, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andAssetCompleteDateNotBetween(Date value1, Date value2) {
            addCriterion("asset_complete_date not between", value1, value2, "assetCompleteDate");
            return (Criteria) this;
        }

        public Criteria andRepairDepartIsNull() {
            addCriterion("repair_depart is null");
            return (Criteria) this;
        }

        public Criteria andRepairDepartIsNotNull() {
            addCriterion("repair_depart is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDepartEqualTo(String value) {
            addCriterion("repair_depart =", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartNotEqualTo(String value) {
            addCriterion("repair_depart <>", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartGreaterThan(String value) {
            addCriterion("repair_depart >", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartGreaterThanOrEqualTo(String value) {
            addCriterion("repair_depart >=", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartLessThan(String value) {
            addCriterion("repair_depart <", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartLessThanOrEqualTo(String value) {
            addCriterion("repair_depart <=", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartLike(String value) {
            addCriterion("repair_depart like", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartNotLike(String value) {
            addCriterion("repair_depart not like", value, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartIn(List<String> values) {
            addCriterion("repair_depart in", values, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartNotIn(List<String> values) {
            addCriterion("repair_depart not in", values, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartBetween(String value1, String value2) {
            addCriterion("repair_depart between", value1, value2, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andRepairDepartNotBetween(String value1, String value2) {
            addCriterion("repair_depart not between", value1, value2, "repairDepart");
            return (Criteria) this;
        }

        public Criteria andFlowNoIsNull() {
            addCriterion("flow_no is null");
            return (Criteria) this;
        }

        public Criteria andFlowNoIsNotNull() {
            addCriterion("flow_no is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNoEqualTo(String value) {
            addCriterion("flow_no =", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotEqualTo(String value) {
            addCriterion("flow_no <>", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThan(String value) {
            addCriterion("flow_no >", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoGreaterThanOrEqualTo(String value) {
            addCriterion("flow_no >=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThan(String value) {
            addCriterion("flow_no <", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLessThanOrEqualTo(String value) {
            addCriterion("flow_no <=", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoLike(String value) {
            addCriterion("flow_no like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotLike(String value) {
            addCriterion("flow_no not like", value, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoIn(List<String> values) {
            addCriterion("flow_no in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotIn(List<String> values) {
            addCriterion("flow_no not in", values, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoBetween(String value1, String value2) {
            addCriterion("flow_no between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowNoNotBetween(String value1, String value2) {
            addCriterion("flow_no not between", value1, value2, "flowNo");
            return (Criteria) this;
        }

        public Criteria andFlowTitleIsNull() {
            addCriterion("flow_title is null");
            return (Criteria) this;
        }

        public Criteria andFlowTitleIsNotNull() {
            addCriterion("flow_title is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTitleEqualTo(String value) {
            addCriterion("flow_title =", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleNotEqualTo(String value) {
            addCriterion("flow_title <>", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleGreaterThan(String value) {
            addCriterion("flow_title >", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleGreaterThanOrEqualTo(String value) {
            addCriterion("flow_title >=", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleLessThan(String value) {
            addCriterion("flow_title <", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleLessThanOrEqualTo(String value) {
            addCriterion("flow_title <=", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleLike(String value) {
            addCriterion("flow_title like", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleNotLike(String value) {
            addCriterion("flow_title not like", value, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleIn(List<String> values) {
            addCriterion("flow_title in", values, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleNotIn(List<String> values) {
            addCriterion("flow_title not in", values, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleBetween(String value1, String value2) {
            addCriterion("flow_title between", value1, value2, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowTitleNotBetween(String value1, String value2) {
            addCriterion("flow_title not between", value1, value2, "flowTitle");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNull() {
            addCriterion("flow_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNotNull() {
            addCriterion("flow_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusEqualTo(String value) {
            addCriterion("flow_status =", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotEqualTo(String value) {
            addCriterion("flow_status <>", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThan(String value) {
            addCriterion("flow_status >", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("flow_status >=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThan(String value) {
            addCriterion("flow_status <", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThanOrEqualTo(String value) {
            addCriterion("flow_status <=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLike(String value) {
            addCriterion("flow_status like", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotLike(String value) {
            addCriterion("flow_status not like", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIn(List<String> values) {
            addCriterion("flow_status in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotIn(List<String> values) {
            addCriterion("flow_status not in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusBetween(String value1, String value2) {
            addCriterion("flow_status between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotBetween(String value1, String value2) {
            addCriterion("flow_status not between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameIsNull() {
            addCriterion("flow_node_name is null");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameIsNotNull() {
            addCriterion("flow_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameEqualTo(String value) {
            addCriterion("flow_node_name =", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameNotEqualTo(String value) {
            addCriterion("flow_node_name <>", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameGreaterThan(String value) {
            addCriterion("flow_node_name >", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("flow_node_name >=", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameLessThan(String value) {
            addCriterion("flow_node_name <", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameLessThanOrEqualTo(String value) {
            addCriterion("flow_node_name <=", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameLike(String value) {
            addCriterion("flow_node_name like", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameNotLike(String value) {
            addCriterion("flow_node_name not like", value, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameIn(List<String> values) {
            addCriterion("flow_node_name in", values, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameNotIn(List<String> values) {
            addCriterion("flow_node_name not in", values, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameBetween(String value1, String value2) {
            addCriterion("flow_node_name between", value1, value2, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowNodeNameNotBetween(String value1, String value2) {
            addCriterion("flow_node_name not between", value1, value2, "flowNodeName");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeIsNull() {
            addCriterion("flow_start_time is null");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeIsNotNull() {
            addCriterion("flow_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeEqualTo(Date value) {
            addCriterion("flow_start_time =", value, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeNotEqualTo(Date value) {
            addCriterion("flow_start_time <>", value, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeGreaterThan(Date value) {
            addCriterion("flow_start_time >", value, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flow_start_time >=", value, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeLessThan(Date value) {
            addCriterion("flow_start_time <", value, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("flow_start_time <=", value, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeIn(List<Date> values) {
            addCriterion("flow_start_time in", values, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeNotIn(List<Date> values) {
            addCriterion("flow_start_time not in", values, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeBetween(Date value1, Date value2) {
            addCriterion("flow_start_time between", value1, value2, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("flow_start_time not between", value1, value2, "flowStartTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeIsNull() {
            addCriterion("flow_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeIsNotNull() {
            addCriterion("flow_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeEqualTo(Date value) {
            addCriterion("flow_complete_time =", value, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeNotEqualTo(Date value) {
            addCriterion("flow_complete_time <>", value, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeGreaterThan(Date value) {
            addCriterion("flow_complete_time >", value, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flow_complete_time >=", value, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeLessThan(Date value) {
            addCriterion("flow_complete_time <", value, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("flow_complete_time <=", value, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeIn(List<Date> values) {
            addCriterion("flow_complete_time in", values, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeNotIn(List<Date> values) {
            addCriterion("flow_complete_time not in", values, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("flow_complete_time between", value1, value2, "flowCompleteTime");
            return (Criteria) this;
        }

        public Criteria andFlowCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("flow_complete_time not between", value1, value2, "flowCompleteTime");
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

        public Criteria andRecordStatusEqualTo(String value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(String value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(String value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(String value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(String value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(String value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLike(String value) {
            addCriterion("record_status like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotLike(String value) {
            addCriterion("record_status not like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<String> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<String> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(String value1, String value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(String value1, String value2) {
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andPhotoUrlIsNull() {
            addCriterion("photo_url is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photo_url =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photo_url <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photo_url >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photo_url >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photo_url <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photo_url <=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photo_url like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photo_url not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photo_url in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photo_url not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photo_url between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photo_url not between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Date value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Date value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Date value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Date> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Date> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielIsNull() {
            addCriterion("is_need_repair_materiel is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielIsNotNull() {
            addCriterion("is_need_repair_materiel is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielEqualTo(String value) {
            addCriterion("is_need_repair_materiel =", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielNotEqualTo(String value) {
            addCriterion("is_need_repair_materiel <>", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielGreaterThan(String value) {
            addCriterion("is_need_repair_materiel >", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielGreaterThanOrEqualTo(String value) {
            addCriterion("is_need_repair_materiel >=", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielLessThan(String value) {
            addCriterion("is_need_repair_materiel <", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielLessThanOrEqualTo(String value) {
            addCriterion("is_need_repair_materiel <=", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielLike(String value) {
            addCriterion("is_need_repair_materiel like", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielNotLike(String value) {
            addCriterion("is_need_repair_materiel not like", value, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielIn(List<String> values) {
            addCriterion("is_need_repair_materiel in", values, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielNotIn(List<String> values) {
            addCriterion("is_need_repair_materiel not in", values, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielBetween(String value1, String value2) {
            addCriterion("is_need_repair_materiel between", value1, value2, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andIsNeedRepairMaterielNotBetween(String value1, String value2) {
            addCriterion("is_need_repair_materiel not between", value1, value2, "isNeedRepairMateriel");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateIsNull() {
            addCriterion("feedback_complete_date is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateIsNotNull() {
            addCriterion("feedback_complete_date is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateEqualTo(Date value) {
            addCriterion("feedback_complete_date =", value, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateNotEqualTo(Date value) {
            addCriterion("feedback_complete_date <>", value, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateGreaterThan(Date value) {
            addCriterion("feedback_complete_date >", value, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("feedback_complete_date >=", value, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateLessThan(Date value) {
            addCriterion("feedback_complete_date <", value, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateLessThanOrEqualTo(Date value) {
            addCriterion("feedback_complete_date <=", value, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateIn(List<Date> values) {
            addCriterion("feedback_complete_date in", values, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateNotIn(List<Date> values) {
            addCriterion("feedback_complete_date not in", values, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateBetween(Date value1, Date value2) {
            addCriterion("feedback_complete_date between", value1, value2, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCompleteDateNotBetween(Date value1, Date value2) {
            addCriterion("feedback_complete_date not between", value1, value2, "feedbackCompleteDate");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeIsNull() {
            addCriterion("evaluate_service_attitude is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeIsNotNull() {
            addCriterion("evaluate_service_attitude is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeEqualTo(String value) {
            addCriterion("evaluate_service_attitude =", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeNotEqualTo(String value) {
            addCriterion("evaluate_service_attitude <>", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeGreaterThan(String value) {
            addCriterion("evaluate_service_attitude >", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_service_attitude >=", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeLessThan(String value) {
            addCriterion("evaluate_service_attitude <", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeLessThanOrEqualTo(String value) {
            addCriterion("evaluate_service_attitude <=", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeLike(String value) {
            addCriterion("evaluate_service_attitude like", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeNotLike(String value) {
            addCriterion("evaluate_service_attitude not like", value, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeIn(List<String> values) {
            addCriterion("evaluate_service_attitude in", values, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeNotIn(List<String> values) {
            addCriterion("evaluate_service_attitude not in", values, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeBetween(String value1, String value2) {
            addCriterion("evaluate_service_attitude between", value1, value2, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceAttitudeNotBetween(String value1, String value2) {
            addCriterion("evaluate_service_attitude not between", value1, value2, "evaluateServiceAttitude");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyIsNull() {
            addCriterion("evaluate_service_efficiency is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyIsNotNull() {
            addCriterion("evaluate_service_efficiency is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyEqualTo(String value) {
            addCriterion("evaluate_service_efficiency =", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyNotEqualTo(String value) {
            addCriterion("evaluate_service_efficiency <>", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyGreaterThan(String value) {
            addCriterion("evaluate_service_efficiency >", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_service_efficiency >=", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyLessThan(String value) {
            addCriterion("evaluate_service_efficiency <", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyLessThanOrEqualTo(String value) {
            addCriterion("evaluate_service_efficiency <=", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyLike(String value) {
            addCriterion("evaluate_service_efficiency like", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyNotLike(String value) {
            addCriterion("evaluate_service_efficiency not like", value, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyIn(List<String> values) {
            addCriterion("evaluate_service_efficiency in", values, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyNotIn(List<String> values) {
            addCriterion("evaluate_service_efficiency not in", values, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyBetween(String value1, String value2) {
            addCriterion("evaluate_service_efficiency between", value1, value2, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceEfficiencyNotBetween(String value1, String value2) {
            addCriterion("evaluate_service_efficiency not between", value1, value2, "evaluateServiceEfficiency");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityIsNull() {
            addCriterion("evaluate_service_quality is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityIsNotNull() {
            addCriterion("evaluate_service_quality is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityEqualTo(String value) {
            addCriterion("evaluate_service_quality =", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityNotEqualTo(String value) {
            addCriterion("evaluate_service_quality <>", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityGreaterThan(String value) {
            addCriterion("evaluate_service_quality >", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_service_quality >=", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityLessThan(String value) {
            addCriterion("evaluate_service_quality <", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityLessThanOrEqualTo(String value) {
            addCriterion("evaluate_service_quality <=", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityLike(String value) {
            addCriterion("evaluate_service_quality like", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityNotLike(String value) {
            addCriterion("evaluate_service_quality not like", value, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityIn(List<String> values) {
            addCriterion("evaluate_service_quality in", values, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityNotIn(List<String> values) {
            addCriterion("evaluate_service_quality not in", values, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityBetween(String value1, String value2) {
            addCriterion("evaluate_service_quality between", value1, value2, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andEvaluateServiceQualityNotBetween(String value1, String value2) {
            addCriterion("evaluate_service_quality not between", value1, value2, "evaluateServiceQuality");
            return (Criteria) this;
        }

        public Criteria andFinishExplainIsNull() {
            addCriterion("finish_explain is null");
            return (Criteria) this;
        }

        public Criteria andFinishExplainIsNotNull() {
            addCriterion("finish_explain is not null");
            return (Criteria) this;
        }

        public Criteria andFinishExplainEqualTo(String value) {
            addCriterion("finish_explain =", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainNotEqualTo(String value) {
            addCriterion("finish_explain <>", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainGreaterThan(String value) {
            addCriterion("finish_explain >", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainGreaterThanOrEqualTo(String value) {
            addCriterion("finish_explain >=", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainLessThan(String value) {
            addCriterion("finish_explain <", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainLessThanOrEqualTo(String value) {
            addCriterion("finish_explain <=", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainLike(String value) {
            addCriterion("finish_explain like", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainNotLike(String value) {
            addCriterion("finish_explain not like", value, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainIn(List<String> values) {
            addCriterion("finish_explain in", values, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainNotIn(List<String> values) {
            addCriterion("finish_explain not in", values, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainBetween(String value1, String value2) {
            addCriterion("finish_explain between", value1, value2, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishExplainNotBetween(String value1, String value2) {
            addCriterion("finish_explain not between", value1, value2, "finishExplain");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlIsNull() {
            addCriterion("finish_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlIsNotNull() {
            addCriterion("finish_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlEqualTo(String value) {
            addCriterion("finish_photo_url =", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlNotEqualTo(String value) {
            addCriterion("finish_photo_url <>", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlGreaterThan(String value) {
            addCriterion("finish_photo_url >", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("finish_photo_url >=", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlLessThan(String value) {
            addCriterion("finish_photo_url <", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("finish_photo_url <=", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlLike(String value) {
            addCriterion("finish_photo_url like", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlNotLike(String value) {
            addCriterion("finish_photo_url not like", value, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlIn(List<String> values) {
            addCriterion("finish_photo_url in", values, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlNotIn(List<String> values) {
            addCriterion("finish_photo_url not in", values, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlBetween(String value1, String value2) {
            addCriterion("finish_photo_url between", value1, value2, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andFinishPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("finish_photo_url not between", value1, value2, "finishPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(String value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(String value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(String value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(String value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(String value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(String value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLike(String value) {
            addCriterion("is_pay like", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotLike(String value) {
            addCriterion("is_pay not like", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<String> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<String> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(String value1, String value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(String value1, String value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainIsNull() {
            addCriterion("evaluate_explain is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainIsNotNull() {
            addCriterion("evaluate_explain is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainEqualTo(String value) {
            addCriterion("evaluate_explain =", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainNotEqualTo(String value) {
            addCriterion("evaluate_explain <>", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainGreaterThan(String value) {
            addCriterion("evaluate_explain >", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_explain >=", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainLessThan(String value) {
            addCriterion("evaluate_explain <", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainLessThanOrEqualTo(String value) {
            addCriterion("evaluate_explain <=", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainLike(String value) {
            addCriterion("evaluate_explain like", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainNotLike(String value) {
            addCriterion("evaluate_explain not like", value, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainIn(List<String> values) {
            addCriterion("evaluate_explain in", values, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainNotIn(List<String> values) {
            addCriterion("evaluate_explain not in", values, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainBetween(String value1, String value2) {
            addCriterion("evaluate_explain between", value1, value2, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluateExplainNotBetween(String value1, String value2) {
            addCriterion("evaluate_explain not between", value1, value2, "evaluateExplain");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlIsNull() {
            addCriterion("evaluate_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlIsNotNull() {
            addCriterion("evaluate_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlEqualTo(String value) {
            addCriterion("evaluate_photo_url =", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlNotEqualTo(String value) {
            addCriterion("evaluate_photo_url <>", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlGreaterThan(String value) {
            addCriterion("evaluate_photo_url >", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_photo_url >=", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlLessThan(String value) {
            addCriterion("evaluate_photo_url <", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("evaluate_photo_url <=", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlLike(String value) {
            addCriterion("evaluate_photo_url like", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlNotLike(String value) {
            addCriterion("evaluate_photo_url not like", value, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlIn(List<String> values) {
            addCriterion("evaluate_photo_url in", values, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlNotIn(List<String> values) {
            addCriterion("evaluate_photo_url not in", values, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlBetween(String value1, String value2) {
            addCriterion("evaluate_photo_url between", value1, value2, "evaluatePhotoUrl");
            return (Criteria) this;
        }

        public Criteria andEvaluatePhotoUrlNotBetween(String value1, String value2) {
            addCriterion("evaluate_photo_url not between", value1, value2, "evaluatePhotoUrl");
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