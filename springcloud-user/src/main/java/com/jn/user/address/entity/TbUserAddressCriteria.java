package com.jn.user.address.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserAddressCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserAddressCriteria() {
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

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(String value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(String value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(String value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(String value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(String value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(String value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLike(String value) {
            addCriterion("address_id like", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotLike(String value) {
            addCriterion("address_id not like", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<String> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<String> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(String value1, String value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(String value1, String value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneIsNull() {
            addCriterion("reveiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneIsNotNull() {
            addCriterion("reveiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneEqualTo(String value) {
            addCriterion("reveiver_phone =", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneNotEqualTo(String value) {
            addCriterion("reveiver_phone <>", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneGreaterThan(String value) {
            addCriterion("reveiver_phone >", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("reveiver_phone >=", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneLessThan(String value) {
            addCriterion("reveiver_phone <", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("reveiver_phone <=", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneLike(String value) {
            addCriterion("reveiver_phone like", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneNotLike(String value) {
            addCriterion("reveiver_phone not like", value, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneIn(List<String> values) {
            addCriterion("reveiver_phone in", values, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneNotIn(List<String> values) {
            addCriterion("reveiver_phone not in", values, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneBetween(String value1, String value2) {
            addCriterion("reveiver_phone between", value1, value2, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverPhoneNotBetween(String value1, String value2) {
            addCriterion("reveiver_phone not between", value1, value2, "reveiverPhone");
            return (Criteria) this;
        }

        public Criteria andReveiverTelIsNull() {
            addCriterion("reveiver_tel is null");
            return (Criteria) this;
        }

        public Criteria andReveiverTelIsNotNull() {
            addCriterion("reveiver_tel is not null");
            return (Criteria) this;
        }

        public Criteria andReveiverTelEqualTo(String value) {
            addCriterion("reveiver_tel =", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelNotEqualTo(String value) {
            addCriterion("reveiver_tel <>", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelGreaterThan(String value) {
            addCriterion("reveiver_tel >", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelGreaterThanOrEqualTo(String value) {
            addCriterion("reveiver_tel >=", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelLessThan(String value) {
            addCriterion("reveiver_tel <", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelLessThanOrEqualTo(String value) {
            addCriterion("reveiver_tel <=", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelLike(String value) {
            addCriterion("reveiver_tel like", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelNotLike(String value) {
            addCriterion("reveiver_tel not like", value, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelIn(List<String> values) {
            addCriterion("reveiver_tel in", values, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelNotIn(List<String> values) {
            addCriterion("reveiver_tel not in", values, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelBetween(String value1, String value2) {
            addCriterion("reveiver_tel between", value1, value2, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andReveiverTelNotBetween(String value1, String value2) {
            addCriterion("reveiver_tel not between", value1, value2, "reveiverTel");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIsNull() {
            addCriterion("address_province is null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIsNotNull() {
            addCriterion("address_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceEqualTo(String value) {
            addCriterion("address_province =", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotEqualTo(String value) {
            addCriterion("address_province <>", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThan(String value) {
            addCriterion("address_province >", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("address_province >=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThan(String value) {
            addCriterion("address_province <", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLessThanOrEqualTo(String value) {
            addCriterion("address_province <=", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceLike(String value) {
            addCriterion("address_province like", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotLike(String value) {
            addCriterion("address_province not like", value, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceIn(List<String> values) {
            addCriterion("address_province in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotIn(List<String> values) {
            addCriterion("address_province not in", values, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceBetween(String value1, String value2) {
            addCriterion("address_province between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceNotBetween(String value1, String value2) {
            addCriterion("address_province not between", value1, value2, "addressProvince");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNull() {
            addCriterion("address_city is null");
            return (Criteria) this;
        }

        public Criteria andAddressCityIsNotNull() {
            addCriterion("address_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCityEqualTo(String value) {
            addCriterion("address_city =", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotEqualTo(String value) {
            addCriterion("address_city <>", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThan(String value) {
            addCriterion("address_city >", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("address_city >=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThan(String value) {
            addCriterion("address_city <", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLessThanOrEqualTo(String value) {
            addCriterion("address_city <=", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityLike(String value) {
            addCriterion("address_city like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotLike(String value) {
            addCriterion("address_city not like", value, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityIn(List<String> values) {
            addCriterion("address_city in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotIn(List<String> values) {
            addCriterion("address_city not in", values, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityBetween(String value1, String value2) {
            addCriterion("address_city between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressCityNotBetween(String value1, String value2) {
            addCriterion("address_city not between", value1, value2, "addressCity");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIsNull() {
            addCriterion("address_area is null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIsNotNull() {
            addCriterion("address_area is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaEqualTo(String value) {
            addCriterion("address_area =", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotEqualTo(String value) {
            addCriterion("address_area <>", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaGreaterThan(String value) {
            addCriterion("address_area >", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaGreaterThanOrEqualTo(String value) {
            addCriterion("address_area >=", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLessThan(String value) {
            addCriterion("address_area <", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLessThanOrEqualTo(String value) {
            addCriterion("address_area <=", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaLike(String value) {
            addCriterion("address_area like", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotLike(String value) {
            addCriterion("address_area not like", value, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaIn(List<String> values) {
            addCriterion("address_area in", values, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotIn(List<String> values) {
            addCriterion("address_area not in", values, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaBetween(String value1, String value2) {
            addCriterion("address_area between", value1, value2, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressAreaNotBetween(String value1, String value2) {
            addCriterion("address_area not between", value1, value2, "addressArea");
            return (Criteria) this;
        }

        public Criteria andAddressStreetIsNull() {
            addCriterion("address_street is null");
            return (Criteria) this;
        }

        public Criteria andAddressStreetIsNotNull() {
            addCriterion("address_street is not null");
            return (Criteria) this;
        }

        public Criteria andAddressStreetEqualTo(String value) {
            addCriterion("address_street =", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetNotEqualTo(String value) {
            addCriterion("address_street <>", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetGreaterThan(String value) {
            addCriterion("address_street >", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetGreaterThanOrEqualTo(String value) {
            addCriterion("address_street >=", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetLessThan(String value) {
            addCriterion("address_street <", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetLessThanOrEqualTo(String value) {
            addCriterion("address_street <=", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetLike(String value) {
            addCriterion("address_street like", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetNotLike(String value) {
            addCriterion("address_street not like", value, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetIn(List<String> values) {
            addCriterion("address_street in", values, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetNotIn(List<String> values) {
            addCriterion("address_street not in", values, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetBetween(String value1, String value2) {
            addCriterion("address_street between", value1, value2, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressStreetNotBetween(String value1, String value2) {
            addCriterion("address_street not between", value1, value2, "addressStreet");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNull() {
            addCriterion("address_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNotNull() {
            addCriterion("address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailEqualTo(String value) {
            addCriterion("address_detail =", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotEqualTo(String value) {
            addCriterion("address_detail <>", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThan(String value) {
            addCriterion("address_detail >", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("address_detail >=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThan(String value) {
            addCriterion("address_detail <", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("address_detail <=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLike(String value) {
            addCriterion("address_detail like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotLike(String value) {
            addCriterion("address_detail not like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIn(List<String> values) {
            addCriterion("address_detail in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotIn(List<String> values) {
            addCriterion("address_detail not in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailBetween(String value1, String value2) {
            addCriterion("address_detail between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotBetween(String value1, String value2) {
            addCriterion("address_detail not between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressStatusIsNull() {
            addCriterion("address_status is null");
            return (Criteria) this;
        }

        public Criteria andAddressStatusIsNotNull() {
            addCriterion("address_status is not null");
            return (Criteria) this;
        }

        public Criteria andAddressStatusEqualTo(String value) {
            addCriterion("address_status =", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotEqualTo(String value) {
            addCriterion("address_status <>", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusGreaterThan(String value) {
            addCriterion("address_status >", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusGreaterThanOrEqualTo(String value) {
            addCriterion("address_status >=", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusLessThan(String value) {
            addCriterion("address_status <", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusLessThanOrEqualTo(String value) {
            addCriterion("address_status <=", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusLike(String value) {
            addCriterion("address_status like", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotLike(String value) {
            addCriterion("address_status not like", value, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusIn(List<String> values) {
            addCriterion("address_status in", values, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotIn(List<String> values) {
            addCriterion("address_status not in", values, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusBetween(String value1, String value2) {
            addCriterion("address_status between", value1, value2, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andAddressStatusNotBetween(String value1, String value2) {
            addCriterion("address_status not between", value1, value2, "addressStatus");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(String value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(String value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(String value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(String value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(String value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(String value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLike(String value) {
            addCriterion("is_default like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotLike(String value) {
            addCriterion("is_default not like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<String> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<String> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(String value1, String value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(String value1, String value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
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