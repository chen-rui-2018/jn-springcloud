package com.jn.park.connect.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceConnectManageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceConnectManageCriteria() {
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
            addCriterion("connect.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("connect.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("connect.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("connect.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("connect.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("connect.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("connect.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("connect.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("connect.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("connect.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("connect.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("connect.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("connect.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("connect.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIsNull() {
            addCriterion("connect.entrance_name is null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIsNotNull() {
            addCriterion("connect.entrance_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameEqualTo(String value) {
            addCriterion("connect.entrance_name =", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotEqualTo(String value) {
            addCriterion("connect.entrance_name <>", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameGreaterThan(String value) {
            addCriterion("connect.entrance_name >", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameGreaterThanOrEqualTo(String value) {
            addCriterion("connect.entrance_name >=", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLessThan(String value) {
            addCriterion("connect.entrance_name <", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLessThanOrEqualTo(String value) {
            addCriterion("connect.entrance_name <=", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameLike(String value) {
            addCriterion("connect.entrance_name like", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotLike(String value) {
            addCriterion("connect.entrance_name not like", value, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameIn(List<String> values) {
            addCriterion("connect.entrance_name in", values, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotIn(List<String> values) {
            addCriterion("connect.entrance_name not in", values, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameBetween(String value1, String value2) {
            addCriterion("connect.entrance_name between", value1, value2, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameNotBetween(String value1, String value2) {
            addCriterion("connect.entrance_name not between", value1, value2, "entranceName");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeIsNull() {
            addCriterion("connect.entrance_name_code is null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeIsNotNull() {
            addCriterion("connect.entrance_name_code is not null");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeEqualTo(String value) {
            addCriterion("connect.entrance_name_code =", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeNotEqualTo(String value) {
            addCriterion("connect.entrance_name_code <>", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeGreaterThan(String value) {
            addCriterion("connect.entrance_name_code >", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeGreaterThanOrEqualTo(String value) {
            addCriterion("connect.entrance_name_code >=", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeLessThan(String value) {
            addCriterion("connect.entrance_name_code <", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeLessThanOrEqualTo(String value) {
            addCriterion("connect.entrance_name_code <=", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeLike(String value) {
            addCriterion("connect.entrance_name_code like", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeNotLike(String value) {
            addCriterion("connect.entrance_name_code not like", value, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeIn(List<String> values) {
            addCriterion("connect.entrance_name_code in", values, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeNotIn(List<String> values) {
            addCriterion("connect.entrance_name_code not in", values, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeBetween(String value1, String value2) {
            addCriterion("connect.entrance_name_code between", value1, value2, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andEntranceNameCodeNotBetween(String value1, String value2) {
            addCriterion("connect.entrance_name_code not between", value1, value2, "entranceNameCode");
            return (Criteria) this;
        }

        public Criteria andServiceConnectIsNull() {
            addCriterion("connect.service_connect is null");
            return (Criteria) this;
        }

        public Criteria andServiceConnectIsNotNull() {
            addCriterion("connect.service_connect is not null");
            return (Criteria) this;
        }

        public Criteria andServiceConnectEqualTo(String value) {
            addCriterion("connect.service_connect =", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectNotEqualTo(String value) {
            addCriterion("connect.service_connect <>", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectGreaterThan(String value) {
            addCriterion("connect.service_connect >", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectGreaterThanOrEqualTo(String value) {
            addCriterion("connect.service_connect >=", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectLessThan(String value) {
            addCriterion("connect.service_connect <", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectLessThanOrEqualTo(String value) {
            addCriterion("connect.service_connect <=", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectLike(String value) {
            addCriterion("connect.service_connect like", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectNotLike(String value) {
            addCriterion("connect.service_connect not like", value, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectIn(List<String> values) {
            addCriterion("connect.service_connect in", values, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectNotIn(List<String> values) {
            addCriterion("connect.service_connect not in", values, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectBetween(String value1, String value2) {
            addCriterion("connect.service_connect between", value1, value2, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andServiceConnectNotBetween(String value1, String value2) {
            addCriterion("connect.service_connect not between", value1, value2, "serviceConnect");
            return (Criteria) this;
        }

        public Criteria andConnectAddressIsNull() {
            addCriterion("connect.connect_address is null");
            return (Criteria) this;
        }

        public Criteria andConnectAddressIsNotNull() {
            addCriterion("connect.connect_address is not null");
            return (Criteria) this;
        }

        public Criteria andConnectAddressEqualTo(String value) {
            addCriterion("connect.connect_address =", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotEqualTo(String value) {
            addCriterion("connect.connect_address <>", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressGreaterThan(String value) {
            addCriterion("connect.connect_address >", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("connect.connect_address >=", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressLessThan(String value) {
            addCriterion("connect.connect_address <", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressLessThanOrEqualTo(String value) {
            addCriterion("connect.connect_address <=", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressLike(String value) {
            addCriterion("connect.connect_address like", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotLike(String value) {
            addCriterion("connect.connect_address not like", value, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressIn(List<String> values) {
            addCriterion("connect.connect_address in", values, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotIn(List<String> values) {
            addCriterion("connect.connect_address not in", values, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressBetween(String value1, String value2) {
            addCriterion("connect.connect_address between", value1, value2, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andConnectAddressNotBetween(String value1, String value2) {
            addCriterion("connect.connect_address not between", value1, value2, "connectAddress");
            return (Criteria) this;
        }

        public Criteria andShowImgIsNull() {
            addCriterion("connect.show_img is null");
            return (Criteria) this;
        }

        public Criteria andShowImgIsNotNull() {
            addCriterion("connect.show_img is not null");
            return (Criteria) this;
        }

        public Criteria andShowImgEqualTo(String value) {
            addCriterion("connect.show_img =", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotEqualTo(String value) {
            addCriterion("connect.show_img <>", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgGreaterThan(String value) {
            addCriterion("connect.show_img >", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgGreaterThanOrEqualTo(String value) {
            addCriterion("connect.show_img >=", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLessThan(String value) {
            addCriterion("connect.show_img <", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLessThanOrEqualTo(String value) {
            addCriterion("connect.show_img <=", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLike(String value) {
            addCriterion("connect.show_img like", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotLike(String value) {
            addCriterion("connect.show_img not like", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgIn(List<String> values) {
            addCriterion("connect.show_img in", values, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotIn(List<String> values) {
            addCriterion("connect.show_img not in", values, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgBetween(String value1, String value2) {
            addCriterion("connect.show_img between", value1, value2, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotBetween(String value1, String value2) {
            addCriterion("connect.show_img not between", value1, value2, "showImg");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("connect.sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("connect.sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("connect.sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("connect.sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("connect.sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("connect.sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("connect.sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("connect.sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("connect.sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("connect.sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("connect.sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("connect.sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("connect.sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("connect.sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("connect.is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("connect.is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(Byte value) {
            addCriterion("connect.is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(Byte value) {
            addCriterion("connect.is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(Byte value) {
            addCriterion("connect.is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(Byte value) {
            addCriterion("connect.is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(Byte value) {
            addCriterion("connect.is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(Byte value) {
            addCriterion("connect.is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<Byte> values) {
            addCriterion("connect.is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<Byte> values) {
            addCriterion("connect.is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(Byte value1, Byte value2) {
            addCriterion("connect.is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(Byte value1, Byte value2) {
            addCriterion("connect.is_valid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdIsNull() {
            addCriterion("connect.creator_account_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdIsNotNull() {
            addCriterion("connect.creator_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdEqualTo(String value) {
            addCriterion("connect.creator_account_id =", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdNotEqualTo(String value) {
            addCriterion("connect.creator_account_id <>", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdGreaterThan(String value) {
            addCriterion("connect.creator_account_id >", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("connect.creator_account_id >=", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdLessThan(String value) {
            addCriterion("connect.creator_account_id <", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdLessThanOrEqualTo(String value) {
            addCriterion("connect.creator_account_id <=", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdLike(String value) {
            addCriterion("connect.creator_account_id like", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdNotLike(String value) {
            addCriterion("connect.creator_account_id not like", value, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdIn(List<String> values) {
            addCriterion("connect.creator_account_id in", values, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdNotIn(List<String> values) {
            addCriterion("connect.creator_account_id not in", values, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdBetween(String value1, String value2) {
            addCriterion("connect.creator_account_id between", value1, value2, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIdNotBetween(String value1, String value2) {
            addCriterion("connect.creator_account_id not between", value1, value2, "creatorAccountId");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("connect.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("connect.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("connect.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("connect.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("connect.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("connect.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("connect.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("connect.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("connect.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("connect.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("connect.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("connect.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("connect.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("connect.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("connect.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("connect.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("connect.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("connect.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("connect.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("connect.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("connect.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("connect.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("connect.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("connect.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("connect.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("connect.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("connect.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("connect.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("connect.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("connect.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("connect.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("connect.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("connect.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("connect.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("connect.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("connect.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("connect.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("connect.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("connect.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("connect.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("connect.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("connect.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("connect.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("connect.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("connect.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("connect.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("connect.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("connect.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("connect.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("connect.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("connect.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("connect.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("connect.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("connect.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("connect.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("connect.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("connect.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("connect.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("connect.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("connect.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("connect.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("connect.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("connect.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("connect.modified_time not between", value1, value2, "modifiedTime");
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