package com.jn.park.parking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParkingSpaceRentalCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkingSpaceRentalCriteria() {
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

        public Criteria andRentIdIsNull() {
            addCriterion("rent_id_ is null");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNotNull() {
            addCriterion("rent_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andRentIdEqualTo(String value) {
            addCriterion("rent_id_ =", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotEqualTo(String value) {
            addCriterion("rent_id_ <>", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThan(String value) {
            addCriterion("rent_id_ >", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThanOrEqualTo(String value) {
            addCriterion("rent_id_ >=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThan(String value) {
            addCriterion("rent_id_ <", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThanOrEqualTo(String value) {
            addCriterion("rent_id_ <=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLike(String value) {
            addCriterion("rent_id_ like", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotLike(String value) {
            addCriterion("rent_id_ not like", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdIn(List<String> values) {
            addCriterion("rent_id_ in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotIn(List<String> values) {
            addCriterion("rent_id_ not in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdBetween(String value1, String value2) {
            addCriterion("rent_id_ between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotBetween(String value1, String value2) {
            addCriterion("rent_id_ not between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialIsNull() {
            addCriterion("space_serial is null");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialIsNotNull() {
            addCriterion("space_serial is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialEqualTo(String value) {
            addCriterion("space_serial =", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialNotEqualTo(String value) {
            addCriterion("space_serial <>", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialGreaterThan(String value) {
            addCriterion("space_serial >", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialGreaterThanOrEqualTo(String value) {
            addCriterion("space_serial >=", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialLessThan(String value) {
            addCriterion("space_serial <", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialLessThanOrEqualTo(String value) {
            addCriterion("space_serial <=", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialLike(String value) {
            addCriterion("space_serial like", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialNotLike(String value) {
            addCriterion("space_serial not like", value, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialIn(List<String> values) {
            addCriterion("space_serial in", values, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialNotIn(List<String> values) {
            addCriterion("space_serial not in", values, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialBetween(String value1, String value2) {
            addCriterion("space_serial between", value1, value2, "spaceSerial");
            return (Criteria) this;
        }

        public Criteria andSpaceSerialNotBetween(String value1, String value2) {
            addCriterion("space_serial not between", value1, value2, "spaceSerial");
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

        public Criteria andRentPriceIsNull() {
            addCriterion("rent_price is null");
            return (Criteria) this;
        }

        public Criteria andRentPriceIsNotNull() {
            addCriterion("rent_price is not null");
            return (Criteria) this;
        }

        public Criteria andRentPriceEqualTo(String value) {
            addCriterion("rent_price =", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotEqualTo(String value) {
            addCriterion("rent_price <>", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceGreaterThan(String value) {
            addCriterion("rent_price >", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceGreaterThanOrEqualTo(String value) {
            addCriterion("rent_price >=", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceLessThan(String value) {
            addCriterion("rent_price <", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceLessThanOrEqualTo(String value) {
            addCriterion("rent_price <=", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceLike(String value) {
            addCriterion("rent_price like", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotLike(String value) {
            addCriterion("rent_price not like", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceIn(List<String> values) {
            addCriterion("rent_price in", values, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotIn(List<String> values) {
            addCriterion("rent_price not in", values, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceBetween(String value1, String value2) {
            addCriterion("rent_price between", value1, value2, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotBetween(String value1, String value2) {
            addCriterion("rent_price not between", value1, value2, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andApprovalNameIsNull() {
            addCriterion("approval_name is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIsNotNull() {
            addCriterion("approval_name is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNameEqualTo(String value) {
            addCriterion("approval_name =", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotEqualTo(String value) {
            addCriterion("approval_name <>", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameGreaterThan(String value) {
            addCriterion("approval_name >", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameGreaterThanOrEqualTo(String value) {
            addCriterion("approval_name >=", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLessThan(String value) {
            addCriterion("approval_name <", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLessThanOrEqualTo(String value) {
            addCriterion("approval_name <=", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameLike(String value) {
            addCriterion("approval_name like", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotLike(String value) {
            addCriterion("approval_name not like", value, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameIn(List<String> values) {
            addCriterion("approval_name in", values, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotIn(List<String> values) {
            addCriterion("approval_name not in", values, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameBetween(String value1, String value2) {
            addCriterion("approval_name between", value1, value2, "approvalName");
            return (Criteria) this;
        }

        public Criteria andApprovalNameNotBetween(String value1, String value2) {
            addCriterion("approval_name not between", value1, value2, "approvalName");
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

        public Criteria andContractAttachmentIsNull() {
            addCriterion("contract_attachment is null");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentIsNotNull() {
            addCriterion("contract_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentEqualTo(String value) {
            addCriterion("contract_attachment =", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentNotEqualTo(String value) {
            addCriterion("contract_attachment <>", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentGreaterThan(String value) {
            addCriterion("contract_attachment >", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("contract_attachment >=", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentLessThan(String value) {
            addCriterion("contract_attachment <", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentLessThanOrEqualTo(String value) {
            addCriterion("contract_attachment <=", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentLike(String value) {
            addCriterion("contract_attachment like", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentNotLike(String value) {
            addCriterion("contract_attachment not like", value, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentIn(List<String> values) {
            addCriterion("contract_attachment in", values, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentNotIn(List<String> values) {
            addCriterion("contract_attachment not in", values, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentBetween(String value1, String value2) {
            addCriterion("contract_attachment between", value1, value2, "contractAttachment");
            return (Criteria) this;
        }

        public Criteria andContractAttachmentNotBetween(String value1, String value2) {
            addCriterion("contract_attachment not between", value1, value2, "contractAttachment");
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