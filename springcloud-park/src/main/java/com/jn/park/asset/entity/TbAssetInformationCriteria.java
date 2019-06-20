package com.jn.park.asset.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbAssetInformationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAssetInformationCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andAssetNumberIsNull() {
            addCriterion("asset_number is null");
            return (Criteria) this;
        }

        public Criteria andAssetNumberIsNotNull() {
            addCriterion("asset_number is not null");
            return (Criteria) this;
        }

        public Criteria andAssetNumberEqualTo(String value) {
            addCriterion("asset_number =", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotEqualTo(String value) {
            addCriterion("asset_number <>", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberGreaterThan(String value) {
            addCriterion("asset_number >", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberGreaterThanOrEqualTo(String value) {
            addCriterion("asset_number >=", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberLessThan(String value) {
            addCriterion("asset_number <", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberLessThanOrEqualTo(String value) {
            addCriterion("asset_number <=", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberLike(String value) {
            addCriterion("asset_number like", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotLike(String value) {
            addCriterion("asset_number not like", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberIn(List<String> values) {
            addCriterion("asset_number in", values, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotIn(List<String> values) {
            addCriterion("asset_number not in", values, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberBetween(String value1, String value2) {
            addCriterion("asset_number between", value1, value2, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotBetween(String value1, String value2) {
            addCriterion("asset_number not between", value1, value2, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNameIsNull() {
            addCriterion("asset_name is null");
            return (Criteria) this;
        }

        public Criteria andAssetNameIsNotNull() {
            addCriterion("asset_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssetNameEqualTo(String value) {
            addCriterion("asset_name =", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotEqualTo(String value) {
            addCriterion("asset_name <>", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameGreaterThan(String value) {
            addCriterion("asset_name >", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameGreaterThanOrEqualTo(String value) {
            addCriterion("asset_name >=", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameLessThan(String value) {
            addCriterion("asset_name <", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameLessThanOrEqualTo(String value) {
            addCriterion("asset_name <=", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameLike(String value) {
            addCriterion("asset_name like", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotLike(String value) {
            addCriterion("asset_name not like", value, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameIn(List<String> values) {
            addCriterion("asset_name in", values, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotIn(List<String> values) {
            addCriterion("asset_name not in", values, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameBetween(String value1, String value2) {
            addCriterion("asset_name between", value1, value2, "assetName");
            return (Criteria) this;
        }

        public Criteria andAssetNameNotBetween(String value1, String value2) {
            addCriterion("asset_name not between", value1, value2, "assetName");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNull() {
            addCriterion("asset_type is null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNotNull() {
            addCriterion("asset_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeEqualTo(String value) {
            addCriterion("asset_type =", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotEqualTo(String value) {
            addCriterion("asset_type <>", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThan(String value) {
            addCriterion("asset_type >", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_type >=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThan(String value) {
            addCriterion("asset_type <", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThanOrEqualTo(String value) {
            addCriterion("asset_type <=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLike(String value) {
            addCriterion("asset_type like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotLike(String value) {
            addCriterion("asset_type not like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIn(List<String> values) {
            addCriterion("asset_type in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotIn(List<String> values) {
            addCriterion("asset_type not in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeBetween(String value1, String value2) {
            addCriterion("asset_type between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotBetween(String value1, String value2) {
            addCriterion("asset_type not between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andTowerIdIsNull() {
            addCriterion("tower_id is null");
            return (Criteria) this;
        }

        public Criteria andTowerIdIsNotNull() {
            addCriterion("tower_id is not null");
            return (Criteria) this;
        }

        public Criteria andTowerIdEqualTo(String value) {
            addCriterion("tower_id =", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotEqualTo(String value) {
            addCriterion("tower_id <>", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdGreaterThan(String value) {
            addCriterion("tower_id >", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdGreaterThanOrEqualTo(String value) {
            addCriterion("tower_id >=", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdLessThan(String value) {
            addCriterion("tower_id <", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdLessThanOrEqualTo(String value) {
            addCriterion("tower_id <=", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdLike(String value) {
            addCriterion("tower_id like", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotLike(String value) {
            addCriterion("tower_id not like", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdIn(List<String> values) {
            addCriterion("tower_id in", values, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotIn(List<String> values) {
            addCriterion("tower_id not in", values, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdBetween(String value1, String value2) {
            addCriterion("tower_id between", value1, value2, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotBetween(String value1, String value2) {
            addCriterion("tower_id not between", value1, value2, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerNameIsNull() {
            addCriterion("tower_name is null");
            return (Criteria) this;
        }

        public Criteria andTowerNameIsNotNull() {
            addCriterion("tower_name is not null");
            return (Criteria) this;
        }

        public Criteria andTowerNameEqualTo(String value) {
            addCriterion("tower_name =", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotEqualTo(String value) {
            addCriterion("tower_name <>", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameGreaterThan(String value) {
            addCriterion("tower_name >", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("tower_name >=", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameLessThan(String value) {
            addCriterion("tower_name <", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameLessThanOrEqualTo(String value) {
            addCriterion("tower_name <=", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameLike(String value) {
            addCriterion("tower_name like", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotLike(String value) {
            addCriterion("tower_name not like", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameIn(List<String> values) {
            addCriterion("tower_name in", values, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotIn(List<String> values) {
            addCriterion("tower_name not in", values, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameBetween(String value1, String value2) {
            addCriterion("tower_name between", value1, value2, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotBetween(String value1, String value2) {
            addCriterion("tower_name not between", value1, value2, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerAddressIsNull() {
            addCriterion("tower_address is null");
            return (Criteria) this;
        }

        public Criteria andTowerAddressIsNotNull() {
            addCriterion("tower_address is not null");
            return (Criteria) this;
        }

        public Criteria andTowerAddressEqualTo(String value) {
            addCriterion("tower_address =", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressNotEqualTo(String value) {
            addCriterion("tower_address <>", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressGreaterThan(String value) {
            addCriterion("tower_address >", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("tower_address >=", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressLessThan(String value) {
            addCriterion("tower_address <", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressLessThanOrEqualTo(String value) {
            addCriterion("tower_address <=", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressLike(String value) {
            addCriterion("tower_address like", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressNotLike(String value) {
            addCriterion("tower_address not like", value, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressIn(List<String> values) {
            addCriterion("tower_address in", values, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressNotIn(List<String> values) {
            addCriterion("tower_address not in", values, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressBetween(String value1, String value2) {
            addCriterion("tower_address between", value1, value2, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andTowerAddressNotBetween(String value1, String value2) {
            addCriterion("tower_address not between", value1, value2, "towerAddress");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status_ is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status_ is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status_ =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status_ <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status_ >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status_ >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status_ <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status_ <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status_ in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status_ not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status_ between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status_ not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNull() {
            addCriterion("input_type is null");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNotNull() {
            addCriterion("input_type is not null");
            return (Criteria) this;
        }

        public Criteria andInputTypeEqualTo(Byte value) {
            addCriterion("input_type =", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotEqualTo(Byte value) {
            addCriterion("input_type <>", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThan(Byte value) {
            addCriterion("input_type >", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("input_type >=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThan(Byte value) {
            addCriterion("input_type <", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThanOrEqualTo(Byte value) {
            addCriterion("input_type <=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeIn(List<Byte> values) {
            addCriterion("input_type in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotIn(List<Byte> values) {
            addCriterion("input_type not in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeBetween(Byte value1, Byte value2) {
            addCriterion("input_type between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("input_type not between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andIsLeaseIsNull() {
            addCriterion("is_lease is null");
            return (Criteria) this;
        }

        public Criteria andIsLeaseIsNotNull() {
            addCriterion("is_lease is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeaseEqualTo(Byte value) {
            addCriterion("is_lease =", value, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseNotEqualTo(Byte value) {
            addCriterion("is_lease <>", value, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseGreaterThan(Byte value) {
            addCriterion("is_lease >", value, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_lease >=", value, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseLessThan(Byte value) {
            addCriterion("is_lease <", value, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseLessThanOrEqualTo(Byte value) {
            addCriterion("is_lease <=", value, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseIn(List<Byte> values) {
            addCriterion("is_lease in", values, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseNotIn(List<Byte> values) {
            addCriterion("is_lease not in", values, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseBetween(Byte value1, Byte value2) {
            addCriterion("is_lease between", value1, value2, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsLeaseNotBetween(Byte value1, Byte value2) {
            addCriterion("is_lease not between", value1, value2, "isLease");
            return (Criteria) this;
        }

        public Criteria andIsMaintainIsNull() {
            addCriterion("is_maintain is null");
            return (Criteria) this;
        }

        public Criteria andIsMaintainIsNotNull() {
            addCriterion("is_maintain is not null");
            return (Criteria) this;
        }

        public Criteria andIsMaintainEqualTo(Byte value) {
            addCriterion("is_maintain =", value, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainNotEqualTo(Byte value) {
            addCriterion("is_maintain <>", value, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainGreaterThan(Byte value) {
            addCriterion("is_maintain >", value, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_maintain >=", value, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainLessThan(Byte value) {
            addCriterion("is_maintain <", value, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainLessThanOrEqualTo(Byte value) {
            addCriterion("is_maintain <=", value, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainIn(List<Byte> values) {
            addCriterion("is_maintain in", values, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainNotIn(List<Byte> values) {
            addCriterion("is_maintain not in", values, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainBetween(Byte value1, Byte value2) {
            addCriterion("is_maintain between", value1, value2, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andIsMaintainNotBetween(Byte value1, Byte value2) {
            addCriterion("is_maintain not between", value1, value2, "isMaintain");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeIsNull() {
            addCriterion("maintenance_time is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeIsNotNull() {
            addCriterion("maintenance_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeEqualTo(Date value) {
            addCriterionForJDBCDate("maintenance_time =", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("maintenance_time <>", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("maintenance_time >", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("maintenance_time >=", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeLessThan(Date value) {
            addCriterionForJDBCDate("maintenance_time <", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("maintenance_time <=", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeIn(List<Date> values) {
            addCriterionForJDBCDate("maintenance_time in", values, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("maintenance_time not in", values, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("maintenance_time between", value1, value2, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("maintenance_time not between", value1, value2, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodIsNull() {
            addCriterion("maintenance_period is null");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodIsNotNull() {
            addCriterion("maintenance_period is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodEqualTo(String value) {
            addCriterion("maintenance_period =", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotEqualTo(String value) {
            addCriterion("maintenance_period <>", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodGreaterThan(String value) {
            addCriterion("maintenance_period >", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_period >=", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodLessThan(String value) {
            addCriterion("maintenance_period <", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodLessThanOrEqualTo(String value) {
            addCriterion("maintenance_period <=", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodLike(String value) {
            addCriterion("maintenance_period like", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotLike(String value) {
            addCriterion("maintenance_period not like", value, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodIn(List<String> values) {
            addCriterion("maintenance_period in", values, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotIn(List<String> values) {
            addCriterion("maintenance_period not in", values, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodBetween(String value1, String value2) {
            addCriterion("maintenance_period between", value1, value2, "maintenancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintenancePeriodNotBetween(String value1, String value2) {
            addCriterion("maintenance_period not between", value1, value2, "maintenancePeriod");
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

        public Criteria andAssetExplainIsNull() {
            addCriterion("asset_explain is null");
            return (Criteria) this;
        }

        public Criteria andAssetExplainIsNotNull() {
            addCriterion("asset_explain is not null");
            return (Criteria) this;
        }

        public Criteria andAssetExplainEqualTo(String value) {
            addCriterion("asset_explain =", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainNotEqualTo(String value) {
            addCriterion("asset_explain <>", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainGreaterThan(String value) {
            addCriterion("asset_explain >", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainGreaterThanOrEqualTo(String value) {
            addCriterion("asset_explain >=", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainLessThan(String value) {
            addCriterion("asset_explain <", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainLessThanOrEqualTo(String value) {
            addCriterion("asset_explain <=", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainLike(String value) {
            addCriterion("asset_explain like", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainNotLike(String value) {
            addCriterion("asset_explain not like", value, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainIn(List<String> values) {
            addCriterion("asset_explain in", values, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainNotIn(List<String> values) {
            addCriterion("asset_explain not in", values, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainBetween(String value1, String value2) {
            addCriterion("asset_explain between", value1, value2, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andAssetExplainNotBetween(String value1, String value2) {
            addCriterion("asset_explain not between", value1, value2, "assetExplain");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNull() {
            addCriterion("production_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNotNull() {
            addCriterion("production_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeEqualTo(Date value) {
            addCriterionForJDBCDate("production_time =", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("production_time <>", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("production_time >", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("production_time >=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThan(Date value) {
            addCriterionForJDBCDate("production_time <", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("production_time <=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIn(List<Date> values) {
            addCriterionForJDBCDate("production_time in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("production_time not in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("production_time between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("production_time not between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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

        public Criteria andLeaseEnterpriseIdIsNull() {
            addCriterion("lease_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdIsNotNull() {
            addCriterion("lease_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdEqualTo(String value) {
            addCriterion("lease_enterprise_id =", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotEqualTo(String value) {
            addCriterion("lease_enterprise_id <>", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdGreaterThan(String value) {
            addCriterion("lease_enterprise_id >", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("lease_enterprise_id >=", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdLessThan(String value) {
            addCriterion("lease_enterprise_id <", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("lease_enterprise_id <=", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdLike(String value) {
            addCriterion("lease_enterprise_id like", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotLike(String value) {
            addCriterion("lease_enterprise_id not like", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdIn(List<String> values) {
            addCriterion("lease_enterprise_id in", values, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotIn(List<String> values) {
            addCriterion("lease_enterprise_id not in", values, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdBetween(String value1, String value2) {
            addCriterion("lease_enterprise_id between", value1, value2, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("lease_enterprise_id not between", value1, value2, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameIsNull() {
            addCriterion("lease_enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameIsNotNull() {
            addCriterion("lease_enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameEqualTo(String value) {
            addCriterion("lease_enterprise_name =", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameNotEqualTo(String value) {
            addCriterion("lease_enterprise_name <>", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameGreaterThan(String value) {
            addCriterion("lease_enterprise_name >", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("lease_enterprise_name >=", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameLessThan(String value) {
            addCriterion("lease_enterprise_name <", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("lease_enterprise_name <=", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameLike(String value) {
            addCriterion("lease_enterprise_name like", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameNotLike(String value) {
            addCriterion("lease_enterprise_name not like", value, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameIn(List<String> values) {
            addCriterion("lease_enterprise_name in", values, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameNotIn(List<String> values) {
            addCriterion("lease_enterprise_name not in", values, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameBetween(String value1, String value2) {
            addCriterion("lease_enterprise_name between", value1, value2, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("lease_enterprise_name not between", value1, value2, "leaseEnterpriseName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameIsNull() {
            addCriterion("lease_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameIsNotNull() {
            addCriterion("lease_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameEqualTo(String value) {
            addCriterion("lease_contact_name =", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameNotEqualTo(String value) {
            addCriterion("lease_contact_name <>", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameGreaterThan(String value) {
            addCriterion("lease_contact_name >", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("lease_contact_name >=", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameLessThan(String value) {
            addCriterion("lease_contact_name <", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameLessThanOrEqualTo(String value) {
            addCriterion("lease_contact_name <=", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameLike(String value) {
            addCriterion("lease_contact_name like", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameNotLike(String value) {
            addCriterion("lease_contact_name not like", value, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameIn(List<String> values) {
            addCriterion("lease_contact_name in", values, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameNotIn(List<String> values) {
            addCriterion("lease_contact_name not in", values, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameBetween(String value1, String value2) {
            addCriterion("lease_contact_name between", value1, value2, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactNameNotBetween(String value1, String value2) {
            addCriterion("lease_contact_name not between", value1, value2, "leaseContactName");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneIsNull() {
            addCriterion("lease_contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneIsNotNull() {
            addCriterion("lease_contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneEqualTo(String value) {
            addCriterion("lease_contact_phone =", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneNotEqualTo(String value) {
            addCriterion("lease_contact_phone <>", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneGreaterThan(String value) {
            addCriterion("lease_contact_phone >", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("lease_contact_phone >=", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneLessThan(String value) {
            addCriterion("lease_contact_phone <", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("lease_contact_phone <=", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneLike(String value) {
            addCriterion("lease_contact_phone like", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneNotLike(String value) {
            addCriterion("lease_contact_phone not like", value, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneIn(List<String> values) {
            addCriterion("lease_contact_phone in", values, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneNotIn(List<String> values) {
            addCriterion("lease_contact_phone not in", values, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneBetween(String value1, String value2) {
            addCriterion("lease_contact_phone between", value1, value2, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseContactPhoneNotBetween(String value1, String value2) {
            addCriterion("lease_contact_phone not between", value1, value2, "leaseContactPhone");
            return (Criteria) this;
        }

        public Criteria andLeaseCashIsNull() {
            addCriterion("lease_cash is null");
            return (Criteria) this;
        }

        public Criteria andLeaseCashIsNotNull() {
            addCriterion("lease_cash is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseCashEqualTo(BigDecimal value) {
            addCriterion("lease_cash =", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashNotEqualTo(BigDecimal value) {
            addCriterion("lease_cash <>", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashGreaterThan(BigDecimal value) {
            addCriterion("lease_cash >", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_cash >=", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashLessThan(BigDecimal value) {
            addCriterion("lease_cash <", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_cash <=", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashIn(List<BigDecimal> values) {
            addCriterion("lease_cash in", values, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashNotIn(List<BigDecimal> values) {
            addCriterion("lease_cash not in", values, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_cash between", value1, value2, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_cash not between", value1, value2, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeasePriceIsNull() {
            addCriterion("lease_price is null");
            return (Criteria) this;
        }

        public Criteria andLeasePriceIsNotNull() {
            addCriterion("lease_price is not null");
            return (Criteria) this;
        }

        public Criteria andLeasePriceEqualTo(BigDecimal value) {
            addCriterion("lease_price =", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceNotEqualTo(BigDecimal value) {
            addCriterion("lease_price <>", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceGreaterThan(BigDecimal value) {
            addCriterion("lease_price >", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_price >=", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceLessThan(BigDecimal value) {
            addCriterion("lease_price <", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_price <=", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceIn(List<BigDecimal> values) {
            addCriterion("lease_price in", values, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceNotIn(List<BigDecimal> values) {
            addCriterion("lease_price not in", values, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_price between", value1, value2, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_price not between", value1, value2, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeIsNull() {
            addCriterion("lease_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeIsNotNull() {
            addCriterion("lease_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeEqualTo(String value) {
            addCriterion("lease_time =", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeNotEqualTo(String value) {
            addCriterion("lease_time <>", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeGreaterThan(String value) {
            addCriterion("lease_time >", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("lease_time >=", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeLessThan(String value) {
            addCriterion("lease_time <", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeLessThanOrEqualTo(String value) {
            addCriterion("lease_time <=", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeLike(String value) {
            addCriterion("lease_time like", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeNotLike(String value) {
            addCriterion("lease_time not like", value, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeIn(List<String> values) {
            addCriterion("lease_time in", values, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeNotIn(List<String> values) {
            addCriterion("lease_time not in", values, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeBetween(String value1, String value2) {
            addCriterion("lease_time between", value1, value2, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseTimeNotBetween(String value1, String value2) {
            addCriterion("lease_time not between", value1, value2, "leaseTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusIsNull() {
            addCriterion("lease_status is null");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusIsNotNull() {
            addCriterion("lease_status is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusEqualTo(Byte value) {
            addCriterion("lease_status =", value, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusNotEqualTo(Byte value) {
            addCriterion("lease_status <>", value, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusGreaterThan(Byte value) {
            addCriterion("lease_status >", value, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("lease_status >=", value, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusLessThan(Byte value) {
            addCriterion("lease_status <", value, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusLessThanOrEqualTo(Byte value) {
            addCriterion("lease_status <=", value, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusIn(List<Byte> values) {
            addCriterion("lease_status in", values, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusNotIn(List<Byte> values) {
            addCriterion("lease_status not in", values, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusBetween(Byte value1, Byte value2) {
            addCriterion("lease_status between", value1, value2, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("lease_status not between", value1, value2, "leaseStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueIsNull() {
            addCriterion("lease_is_overdue is null");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueIsNotNull() {
            addCriterion("lease_is_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueEqualTo(Integer value) {
            addCriterion("lease_is_overdue =", value, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueNotEqualTo(Integer value) {
            addCriterion("lease_is_overdue <>", value, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueGreaterThan(Integer value) {
            addCriterion("lease_is_overdue >", value, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("lease_is_overdue >=", value, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueLessThan(Integer value) {
            addCriterion("lease_is_overdue <", value, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("lease_is_overdue <=", value, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueIn(List<Integer> values) {
            addCriterion("lease_is_overdue in", values, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueNotIn(List<Integer> values) {
            addCriterion("lease_is_overdue not in", values, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueBetween(Integer value1, Integer value2) {
            addCriterion("lease_is_overdue between", value1, value2, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseIsOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("lease_is_overdue not between", value1, value2, "leaseIsOverdue");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeIsNull() {
            addCriterion("lease_apply_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeIsNotNull() {
            addCriterion("lease_apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("lease_apply_time =", value, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("lease_apply_time <>", value, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("lease_apply_time >", value, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_apply_time >=", value, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeLessThan(Date value) {
            addCriterionForJDBCDate("lease_apply_time <", value, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_apply_time <=", value, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("lease_apply_time in", values, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("lease_apply_time not in", values, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_apply_time between", value1, value2, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_apply_time not between", value1, value2, "leaseApplyTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeIsNull() {
            addCriterion("lease_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeIsNotNull() {
            addCriterion("lease_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time =", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time <>", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("lease_start_time >", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time >=", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("lease_start_time <", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time <=", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("lease_start_time in", values, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("lease_start_time not in", values, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_start_time between", value1, value2, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_start_time not between", value1, value2, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeIsNull() {
            addCriterion("lease_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeIsNotNull() {
            addCriterion("lease_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time =", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time <>", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("lease_end_time >", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time >=", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("lease_end_time <", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time <=", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("lease_end_time in", values, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("lease_end_time not in", values, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_end_time between", value1, value2, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_end_time not between", value1, value2, "leaseEndTime");
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