package com.jn.park.parking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParkingRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkingRecordCriteria() {
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

        public Criteria andParkingIdIsNull() {
            addCriterion("parking_id_ is null");
            return (Criteria) this;
        }

        public Criteria andParkingIdIsNotNull() {
            addCriterion("parking_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andParkingIdEqualTo(String value) {
            addCriterion("parking_id_ =", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotEqualTo(String value) {
            addCriterion("parking_id_ <>", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThan(String value) {
            addCriterion("parking_id_ >", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThanOrEqualTo(String value) {
            addCriterion("parking_id_ >=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThan(String value) {
            addCriterion("parking_id_ <", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThanOrEqualTo(String value) {
            addCriterion("parking_id_ <=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLike(String value) {
            addCriterion("parking_id_ like", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotLike(String value) {
            addCriterion("parking_id_ not like", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdIn(List<String> values) {
            addCriterion("parking_id_ in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotIn(List<String> values) {
            addCriterion("parking_id_ not in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdBetween(String value1, String value2) {
            addCriterion("parking_id_ between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotBetween(String value1, String value2) {
            addCriterion("parking_id_ not between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(String value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(String value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(String value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(String value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(String value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(String value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLike(String value) {
            addCriterion("message_id like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotLike(String value) {
            addCriterion("message_id not like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<String> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<String> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(String value1, String value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(String value1, String value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andCarLicenseIsNull() {
            addCriterion("car_license is null");
            return (Criteria) this;
        }

        public Criteria andCarLicenseIsNotNull() {
            addCriterion("car_license is not null");
            return (Criteria) this;
        }

        public Criteria andCarLicenseEqualTo(String value) {
            addCriterion("car_license =", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseNotEqualTo(String value) {
            addCriterion("car_license <>", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseGreaterThan(String value) {
            addCriterion("car_license >", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("car_license >=", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseLessThan(String value) {
            addCriterion("car_license <", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseLessThanOrEqualTo(String value) {
            addCriterion("car_license <=", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseLike(String value) {
            addCriterion("car_license like", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseNotLike(String value) {
            addCriterion("car_license not like", value, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseIn(List<String> values) {
            addCriterion("car_license in", values, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseNotIn(List<String> values) {
            addCriterion("car_license not in", values, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseBetween(String value1, String value2) {
            addCriterion("car_license between", value1, value2, "carLicense");
            return (Criteria) this;
        }

        public Criteria andCarLicenseNotBetween(String value1, String value2) {
            addCriterion("car_license not between", value1, value2, "carLicense");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
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

        public Criteria andAdmissionTimeIsNull() {
            addCriterion("admission_time is null");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeIsNotNull() {
            addCriterion("admission_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeEqualTo(Date value) {
            addCriterion("admission_time =", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeNotEqualTo(Date value) {
            addCriterion("admission_time <>", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeGreaterThan(Date value) {
            addCriterion("admission_time >", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("admission_time >=", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeLessThan(Date value) {
            addCriterion("admission_time <", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeLessThanOrEqualTo(Date value) {
            addCriterion("admission_time <=", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeIn(List<Date> values) {
            addCriterion("admission_time in", values, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeNotIn(List<Date> values) {
            addCriterion("admission_time not in", values, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeBetween(Date value1, Date value2) {
            addCriterion("admission_time between", value1, value2, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeNotBetween(Date value1, Date value2) {
            addCriterion("admission_time not between", value1, value2, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeIsNull() {
            addCriterion("start_billing_time is null");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeIsNotNull() {
            addCriterion("start_billing_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeEqualTo(Date value) {
            addCriterion("start_billing_time =", value, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeNotEqualTo(Date value) {
            addCriterion("start_billing_time <>", value, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeGreaterThan(Date value) {
            addCriterion("start_billing_time >", value, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_billing_time >=", value, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeLessThan(Date value) {
            addCriterion("start_billing_time <", value, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_billing_time <=", value, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeIn(List<Date> values) {
            addCriterion("start_billing_time in", values, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeNotIn(List<Date> values) {
            addCriterion("start_billing_time not in", values, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeBetween(Date value1, Date value2) {
            addCriterion("start_billing_time between", value1, value2, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andStartBillingTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_billing_time not between", value1, value2, "startBillingTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterion("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterion("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterion("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterion("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterion("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterion("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterion("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterion("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterion("departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andParkingStatusIsNull() {
            addCriterion("parking_status is null");
            return (Criteria) this;
        }

        public Criteria andParkingStatusIsNotNull() {
            addCriterion("parking_status is not null");
            return (Criteria) this;
        }

        public Criteria andParkingStatusEqualTo(String value) {
            addCriterion("parking_status =", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusNotEqualTo(String value) {
            addCriterion("parking_status <>", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusGreaterThan(String value) {
            addCriterion("parking_status >", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("parking_status >=", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusLessThan(String value) {
            addCriterion("parking_status <", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusLessThanOrEqualTo(String value) {
            addCriterion("parking_status <=", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusLike(String value) {
            addCriterion("parking_status like", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusNotLike(String value) {
            addCriterion("parking_status not like", value, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusIn(List<String> values) {
            addCriterion("parking_status in", values, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusNotIn(List<String> values) {
            addCriterion("parking_status not in", values, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusBetween(String value1, String value2) {
            addCriterion("parking_status between", value1, value2, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingStatusNotBetween(String value1, String value2) {
            addCriterion("parking_status not between", value1, value2, "parkingStatus");
            return (Criteria) this;
        }

        public Criteria andParkingTimeIsNull() {
            addCriterion("parking_time is null");
            return (Criteria) this;
        }

        public Criteria andParkingTimeIsNotNull() {
            addCriterion("parking_time is not null");
            return (Criteria) this;
        }

        public Criteria andParkingTimeEqualTo(String value) {
            addCriterion("parking_time =", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeNotEqualTo(String value) {
            addCriterion("parking_time <>", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeGreaterThan(String value) {
            addCriterion("parking_time >", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("parking_time >=", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeLessThan(String value) {
            addCriterion("parking_time <", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeLessThanOrEqualTo(String value) {
            addCriterion("parking_time <=", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeLike(String value) {
            addCriterion("parking_time like", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeNotLike(String value) {
            addCriterion("parking_time not like", value, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeIn(List<String> values) {
            addCriterion("parking_time in", values, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeNotIn(List<String> values) {
            addCriterion("parking_time not in", values, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeBetween(String value1, String value2) {
            addCriterion("parking_time between", value1, value2, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andParkingTimeNotBetween(String value1, String value2) {
            addCriterion("parking_time not between", value1, value2, "parkingTime");
            return (Criteria) this;
        }

        public Criteria andDueMoneyIsNull() {
            addCriterion("due_money is null");
            return (Criteria) this;
        }

        public Criteria andDueMoneyIsNotNull() {
            addCriterion("due_money is not null");
            return (Criteria) this;
        }

        public Criteria andDueMoneyEqualTo(Double value) {
            addCriterion("due_money =", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyNotEqualTo(Double value) {
            addCriterion("due_money <>", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyGreaterThan(Double value) {
            addCriterion("due_money >", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("due_money >=", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyLessThan(Double value) {
            addCriterion("due_money <", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyLessThanOrEqualTo(Double value) {
            addCriterion("due_money <=", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyIn(List<Double> values) {
            addCriterion("due_money in", values, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyNotIn(List<Double> values) {
            addCriterion("due_money not in", values, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyBetween(Double value1, Double value2) {
            addCriterion("due_money between", value1, value2, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyNotBetween(Double value1, Double value2) {
            addCriterion("due_money not between", value1, value2, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andUseIntegralIsNull() {
            addCriterion("use_integral is null");
            return (Criteria) this;
        }

        public Criteria andUseIntegralIsNotNull() {
            addCriterion("use_integral is not null");
            return (Criteria) this;
        }

        public Criteria andUseIntegralEqualTo(Double value) {
            addCriterion("use_integral =", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralNotEqualTo(Double value) {
            addCriterion("use_integral <>", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralGreaterThan(Double value) {
            addCriterion("use_integral >", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralGreaterThanOrEqualTo(Double value) {
            addCriterion("use_integral >=", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralLessThan(Double value) {
            addCriterion("use_integral <", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralLessThanOrEqualTo(Double value) {
            addCriterion("use_integral <=", value, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralIn(List<Double> values) {
            addCriterion("use_integral in", values, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralNotIn(List<Double> values) {
            addCriterion("use_integral not in", values, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralBetween(Double value1, Double value2) {
            addCriterion("use_integral between", value1, value2, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andUseIntegralNotBetween(Double value1, Double value2) {
            addCriterion("use_integral not between", value1, value2, "useIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyIsNull() {
            addCriterion("deduction_money is null");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyIsNotNull() {
            addCriterion("deduction_money is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyEqualTo(Double value) {
            addCriterion("deduction_money =", value, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyNotEqualTo(Double value) {
            addCriterion("deduction_money <>", value, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyGreaterThan(Double value) {
            addCriterion("deduction_money >", value, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("deduction_money >=", value, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyLessThan(Double value) {
            addCriterion("deduction_money <", value, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyLessThanOrEqualTo(Double value) {
            addCriterion("deduction_money <=", value, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyIn(List<Double> values) {
            addCriterion("deduction_money in", values, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyNotIn(List<Double> values) {
            addCriterion("deduction_money not in", values, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyBetween(Double value1, Double value2) {
            addCriterion("deduction_money between", value1, value2, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andDeductionMoneyNotBetween(Double value1, Double value2) {
            addCriterion("deduction_money not between", value1, value2, "deductionMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNull() {
            addCriterion("actual_money is null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNotNull() {
            addCriterion("actual_money is not null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyEqualTo(Double value) {
            addCriterion("actual_money =", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotEqualTo(Double value) {
            addCriterion("actual_money <>", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThan(Double value) {
            addCriterion("actual_money >", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("actual_money >=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThan(Double value) {
            addCriterion("actual_money <", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThanOrEqualTo(Double value) {
            addCriterion("actual_money <=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIn(List<Double> values) {
            addCriterion("actual_money in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotIn(List<Double> values) {
            addCriterion("actual_money not in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyBetween(Double value1, Double value2) {
            addCriterion("actual_money between", value1, value2, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotBetween(Double value1, Double value2) {
            addCriterion("actual_money not between", value1, value2, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumIsNull() {
            addCriterion("order_bill_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumIsNotNull() {
            addCriterion("order_bill_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumEqualTo(String value) {
            addCriterion("order_bill_num =", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumNotEqualTo(String value) {
            addCriterion("order_bill_num <>", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumGreaterThan(String value) {
            addCriterion("order_bill_num >", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_bill_num >=", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumLessThan(String value) {
            addCriterion("order_bill_num <", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumLessThanOrEqualTo(String value) {
            addCriterion("order_bill_num <=", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumLike(String value) {
            addCriterion("order_bill_num like", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumNotLike(String value) {
            addCriterion("order_bill_num not like", value, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumIn(List<String> values) {
            addCriterion("order_bill_num in", values, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumNotIn(List<String> values) {
            addCriterion("order_bill_num not in", values, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumBetween(String value1, String value2) {
            addCriterion("order_bill_num between", value1, value2, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andOrderBillNumNotBetween(String value1, String value2) {
            addCriterion("order_bill_num not between", value1, value2, "orderBillNum");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
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

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id_ is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(String value) {
            addCriterion("area_id_ =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(String value) {
            addCriterion("area_id_ <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(String value) {
            addCriterion("area_id_ >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("area_id_ >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(String value) {
            addCriterion("area_id_ <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(String value) {
            addCriterion("area_id_ <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLike(String value) {
            addCriterion("area_id_ like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotLike(String value) {
            addCriterion("area_id_ not like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<String> values) {
            addCriterion("area_id_ in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<String> values) {
            addCriterion("area_id_ not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(String value1, String value2) {
            addCriterion("area_id_ between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(String value1, String value2) {
            addCriterion("area_id_ not between", value1, value2, "areaId");
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