package com.jn.unionpay.paybill.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPaymentBillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPaymentBillCriteria() {
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

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("bill_id like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("bill_id not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillNumIsNull() {
            addCriterion("bill_num is null");
            return (Criteria) this;
        }

        public Criteria andBillNumIsNotNull() {
            addCriterion("bill_num is not null");
            return (Criteria) this;
        }

        public Criteria andBillNumEqualTo(String value) {
            addCriterion("bill_num =", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotEqualTo(String value) {
            addCriterion("bill_num <>", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumGreaterThan(String value) {
            addCriterion("bill_num >", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumGreaterThanOrEqualTo(String value) {
            addCriterion("bill_num >=", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLessThan(String value) {
            addCriterion("bill_num <", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLessThanOrEqualTo(String value) {
            addCriterion("bill_num <=", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLike(String value) {
            addCriterion("bill_num like", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotLike(String value) {
            addCriterion("bill_num not like", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumIn(List<String> values) {
            addCriterion("bill_num in", values, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotIn(List<String> values) {
            addCriterion("bill_num not in", values, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumBetween(String value1, String value2) {
            addCriterion("bill_num between", value1, value2, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotBetween(String value1, String value2) {
            addCriterion("bill_num not between", value1, value2, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNameIsNull() {
            addCriterion("bill_name is null");
            return (Criteria) this;
        }

        public Criteria andBillNameIsNotNull() {
            addCriterion("bill_name is not null");
            return (Criteria) this;
        }

        public Criteria andBillNameEqualTo(String value) {
            addCriterion("bill_name =", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotEqualTo(String value) {
            addCriterion("bill_name <>", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameGreaterThan(String value) {
            addCriterion("bill_name >", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameGreaterThanOrEqualTo(String value) {
            addCriterion("bill_name >=", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameLessThan(String value) {
            addCriterion("bill_name <", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameLessThanOrEqualTo(String value) {
            addCriterion("bill_name <=", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameLike(String value) {
            addCriterion("bill_name like", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotLike(String value) {
            addCriterion("bill_name not like", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameIn(List<String> values) {
            addCriterion("bill_name in", values, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotIn(List<String> values) {
            addCriterion("bill_name not in", values, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameBetween(String value1, String value2) {
            addCriterion("bill_name between", value1, value2, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotBetween(String value1, String value2) {
            addCriterion("bill_name not between", value1, value2, "billName");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("bill_type like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("bill_type not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeIsNull() {
            addCriterion("bill_obj_type is null");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeIsNotNull() {
            addCriterion("bill_obj_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeEqualTo(String value) {
            addCriterion("bill_obj_type =", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeNotEqualTo(String value) {
            addCriterion("bill_obj_type <>", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeGreaterThan(String value) {
            addCriterion("bill_obj_type >", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_obj_type >=", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeLessThan(String value) {
            addCriterion("bill_obj_type <", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_obj_type <=", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeLike(String value) {
            addCriterion("bill_obj_type like", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeNotLike(String value) {
            addCriterion("bill_obj_type not like", value, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeIn(List<String> values) {
            addCriterion("bill_obj_type in", values, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeNotIn(List<String> values) {
            addCriterion("bill_obj_type not in", values, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeBetween(String value1, String value2) {
            addCriterion("bill_obj_type between", value1, value2, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjTypeNotBetween(String value1, String value2) {
            addCriterion("bill_obj_type not between", value1, value2, "billObjType");
            return (Criteria) this;
        }

        public Criteria andBillObjIdIsNull() {
            addCriterion("bill_obj_id is null");
            return (Criteria) this;
        }

        public Criteria andBillObjIdIsNotNull() {
            addCriterion("bill_obj_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillObjIdEqualTo(String value) {
            addCriterion("bill_obj_id =", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdNotEqualTo(String value) {
            addCriterion("bill_obj_id <>", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdGreaterThan(String value) {
            addCriterion("bill_obj_id >", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_obj_id >=", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdLessThan(String value) {
            addCriterion("bill_obj_id <", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdLessThanOrEqualTo(String value) {
            addCriterion("bill_obj_id <=", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdLike(String value) {
            addCriterion("bill_obj_id like", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdNotLike(String value) {
            addCriterion("bill_obj_id not like", value, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdIn(List<String> values) {
            addCriterion("bill_obj_id in", values, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdNotIn(List<String> values) {
            addCriterion("bill_obj_id not in", values, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdBetween(String value1, String value2) {
            addCriterion("bill_obj_id between", value1, value2, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjIdNotBetween(String value1, String value2) {
            addCriterion("bill_obj_id not between", value1, value2, "billObjId");
            return (Criteria) this;
        }

        public Criteria andBillObjNameIsNull() {
            addCriterion("bill_obj_name is null");
            return (Criteria) this;
        }

        public Criteria andBillObjNameIsNotNull() {
            addCriterion("bill_obj_name is not null");
            return (Criteria) this;
        }

        public Criteria andBillObjNameEqualTo(String value) {
            addCriterion("bill_obj_name =", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameNotEqualTo(String value) {
            addCriterion("bill_obj_name <>", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameGreaterThan(String value) {
            addCriterion("bill_obj_name >", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameGreaterThanOrEqualTo(String value) {
            addCriterion("bill_obj_name >=", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameLessThan(String value) {
            addCriterion("bill_obj_name <", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameLessThanOrEqualTo(String value) {
            addCriterion("bill_obj_name <=", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameLike(String value) {
            addCriterion("bill_obj_name like", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameNotLike(String value) {
            addCriterion("bill_obj_name not like", value, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameIn(List<String> values) {
            addCriterion("bill_obj_name in", values, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameNotIn(List<String> values) {
            addCriterion("bill_obj_name not in", values, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameBetween(String value1, String value2) {
            addCriterion("bill_obj_name between", value1, value2, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillObjNameNotBetween(String value1, String value2) {
            addCriterion("bill_obj_name not between", value1, value2, "billObjName");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNull() {
            addCriterion("bill_amount is null");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNotNull() {
            addCriterion("bill_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBillAmountEqualTo(Double value) {
            addCriterion("bill_amount =", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotEqualTo(Double value) {
            addCriterion("bill_amount <>", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThan(Double value) {
            addCriterion("bill_amount >", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("bill_amount >=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThan(Double value) {
            addCriterion("bill_amount <", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThanOrEqualTo(Double value) {
            addCriterion("bill_amount <=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountIn(List<Double> values) {
            addCriterion("bill_amount in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotIn(List<Double> values) {
            addCriterion("bill_amount not in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountBetween(Double value1, Double value2) {
            addCriterion("bill_amount between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotBetween(Double value1, Double value2) {
            addCriterion("bill_amount not between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNull() {
            addCriterion("bill_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNotNull() {
            addCriterion("bill_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeEqualTo(Date value) {
            addCriterion("bill_create_time =", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotEqualTo(Date value) {
            addCriterion("bill_create_time <>", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThan(Date value) {
            addCriterion("bill_create_time >", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_create_time >=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThan(Date value) {
            addCriterion("bill_create_time <", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("bill_create_time <=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIn(List<Date> values) {
            addCriterion("bill_create_time in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotIn(List<Date> values) {
            addCriterion("bill_create_time not in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeBetween(Date value1, Date value2) {
            addCriterion("bill_create_time between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("bill_create_time not between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeIsNull() {
            addCriterion("pay_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeIsNotNull() {
            addCriterion("pay_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeEqualTo(Date value) {
            addCriterion("pay_end_time =", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeNotEqualTo(Date value) {
            addCriterion("pay_end_time <>", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeGreaterThan(Date value) {
            addCriterion("pay_end_time >", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_end_time >=", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeLessThan(Date value) {
            addCriterion("pay_end_time <", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_end_time <=", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeIn(List<Date> values) {
            addCriterion("pay_end_time in", values, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeNotIn(List<Date> values) {
            addCriterion("pay_end_time not in", values, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeBetween(Date value1, Date value2) {
            addCriterion("pay_end_time between", value1, value2, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_end_time not between", value1, value2, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountIsNull() {
            addCriterion("bill_create_account is null");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountIsNotNull() {
            addCriterion("bill_create_account is not null");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountEqualTo(String value) {
            addCriterion("bill_create_account =", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountNotEqualTo(String value) {
            addCriterion("bill_create_account <>", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountGreaterThan(String value) {
            addCriterion("bill_create_account >", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bill_create_account >=", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountLessThan(String value) {
            addCriterion("bill_create_account <", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountLessThanOrEqualTo(String value) {
            addCriterion("bill_create_account <=", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountLike(String value) {
            addCriterion("bill_create_account like", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountNotLike(String value) {
            addCriterion("bill_create_account not like", value, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountIn(List<String> values) {
            addCriterion("bill_create_account in", values, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountNotIn(List<String> values) {
            addCriterion("bill_create_account not in", values, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountBetween(String value1, String value2) {
            addCriterion("bill_create_account between", value1, value2, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillCreateAccountNotBetween(String value1, String value2) {
            addCriterion("bill_create_account not between", value1, value2, "billCreateAccount");
            return (Criteria) this;
        }

        public Criteria andBillRemarkIsNull() {
            addCriterion("bill_remark is null");
            return (Criteria) this;
        }

        public Criteria andBillRemarkIsNotNull() {
            addCriterion("bill_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBillRemarkEqualTo(String value) {
            addCriterion("bill_remark =", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotEqualTo(String value) {
            addCriterion("bill_remark <>", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkGreaterThan(String value) {
            addCriterion("bill_remark >", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("bill_remark >=", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkLessThan(String value) {
            addCriterion("bill_remark <", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkLessThanOrEqualTo(String value) {
            addCriterion("bill_remark <=", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkLike(String value) {
            addCriterion("bill_remark like", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotLike(String value) {
            addCriterion("bill_remark not like", value, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkIn(List<String> values) {
            addCriterion("bill_remark in", values, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotIn(List<String> values) {
            addCriterion("bill_remark not in", values, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkBetween(String value1, String value2) {
            addCriterion("bill_remark between", value1, value2, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillRemarkNotBetween(String value1, String value2) {
            addCriterion("bill_remark not between", value1, value2, "billRemark");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("bill_status like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("bill_status not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andIsUrgeIsNull() {
            addCriterion("is_urge is null");
            return (Criteria) this;
        }

        public Criteria andIsUrgeIsNotNull() {
            addCriterion("is_urge is not null");
            return (Criteria) this;
        }

        public Criteria andIsUrgeEqualTo(String value) {
            addCriterion("is_urge =", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeNotEqualTo(String value) {
            addCriterion("is_urge <>", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeGreaterThan(String value) {
            addCriterion("is_urge >", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeGreaterThanOrEqualTo(String value) {
            addCriterion("is_urge >=", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeLessThan(String value) {
            addCriterion("is_urge <", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeLessThanOrEqualTo(String value) {
            addCriterion("is_urge <=", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeLike(String value) {
            addCriterion("is_urge like", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeNotLike(String value) {
            addCriterion("is_urge not like", value, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeIn(List<String> values) {
            addCriterion("is_urge in", values, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeNotIn(List<String> values) {
            addCriterion("is_urge not in", values, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeBetween(String value1, String value2) {
            addCriterion("is_urge between", value1, value2, "isUrge");
            return (Criteria) this;
        }

        public Criteria andIsUrgeNotBetween(String value1, String value2) {
            addCriterion("is_urge not between", value1, value2, "isUrge");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIsNull() {
            addCriterion("urge_time is null");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIsNotNull() {
            addCriterion("urge_time is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeEqualTo(Date value) {
            addCriterion("urge_time =", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotEqualTo(Date value) {
            addCriterion("urge_time <>", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeGreaterThan(Date value) {
            addCriterion("urge_time >", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("urge_time >=", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeLessThan(Date value) {
            addCriterion("urge_time <", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeLessThanOrEqualTo(Date value) {
            addCriterion("urge_time <=", value, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeIn(List<Date> values) {
            addCriterion("urge_time in", values, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotIn(List<Date> values) {
            addCriterion("urge_time not in", values, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeBetween(Date value1, Date value2) {
            addCriterion("urge_time between", value1, value2, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeTimeNotBetween(Date value1, Date value2) {
            addCriterion("urge_time not between", value1, value2, "urgeTime");
            return (Criteria) this;
        }

        public Criteria andUrgeNumIsNull() {
            addCriterion("urge_num is null");
            return (Criteria) this;
        }

        public Criteria andUrgeNumIsNotNull() {
            addCriterion("urge_num is not null");
            return (Criteria) this;
        }

        public Criteria andUrgeNumEqualTo(Integer value) {
            addCriterion("urge_num =", value, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumNotEqualTo(Integer value) {
            addCriterion("urge_num <>", value, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumGreaterThan(Integer value) {
            addCriterion("urge_num >", value, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("urge_num >=", value, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumLessThan(Integer value) {
            addCriterion("urge_num <", value, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumLessThanOrEqualTo(Integer value) {
            addCriterion("urge_num <=", value, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumIn(List<Integer> values) {
            addCriterion("urge_num in", values, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumNotIn(List<Integer> values) {
            addCriterion("urge_num not in", values, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumBetween(Integer value1, Integer value2) {
            addCriterion("urge_num between", value1, value2, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andUrgeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("urge_num not between", value1, value2, "urgeNum");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNull() {
            addCriterion("is_remind is null");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNotNull() {
            addCriterion("is_remind is not null");
            return (Criteria) this;
        }

        public Criteria andIsRemindEqualTo(String value) {
            addCriterion("is_remind =", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotEqualTo(String value) {
            addCriterion("is_remind <>", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThan(String value) {
            addCriterion("is_remind >", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThanOrEqualTo(String value) {
            addCriterion("is_remind >=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThan(String value) {
            addCriterion("is_remind <", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThanOrEqualTo(String value) {
            addCriterion("is_remind <=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLike(String value) {
            addCriterion("is_remind like", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotLike(String value) {
            addCriterion("is_remind not like", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindIn(List<String> values) {
            addCriterion("is_remind in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotIn(List<String> values) {
            addCriterion("is_remind not in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindBetween(String value1, String value2) {
            addCriterion("is_remind between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotBetween(String value1, String value2) {
            addCriterion("is_remind not between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNull() {
            addCriterion("remind_time is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNotNull() {
            addCriterion("remind_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeEqualTo(Date value) {
            addCriterion("remind_time =", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotEqualTo(Date value) {
            addCriterion("remind_time <>", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThan(Date value) {
            addCriterion("remind_time >", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remind_time >=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThan(Date value) {
            addCriterion("remind_time <", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThanOrEqualTo(Date value) {
            addCriterion("remind_time <=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIn(List<Date> values) {
            addCriterion("remind_time in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotIn(List<Date> values) {
            addCriterion("remind_time not in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeBetween(Date value1, Date value2) {
            addCriterion("remind_time between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotBetween(Date value1, Date value2) {
            addCriterion("remind_time not between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindIdIsNull() {
            addCriterion("remind_id is null");
            return (Criteria) this;
        }

        public Criteria andRemindIdIsNotNull() {
            addCriterion("remind_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemindIdEqualTo(String value) {
            addCriterion("remind_id =", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotEqualTo(String value) {
            addCriterion("remind_id <>", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdGreaterThan(String value) {
            addCriterion("remind_id >", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdGreaterThanOrEqualTo(String value) {
            addCriterion("remind_id >=", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdLessThan(String value) {
            addCriterion("remind_id <", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdLessThanOrEqualTo(String value) {
            addCriterion("remind_id <=", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdLike(String value) {
            addCriterion("remind_id like", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotLike(String value) {
            addCriterion("remind_id not like", value, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdIn(List<String> values) {
            addCriterion("remind_id in", values, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotIn(List<String> values) {
            addCriterion("remind_id not in", values, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdBetween(String value1, String value2) {
            addCriterion("remind_id between", value1, value2, "remindId");
            return (Criteria) this;
        }

        public Criteria andRemindIdNotBetween(String value1, String value2) {
            addCriterion("remind_id not between", value1, value2, "remindId");
            return (Criteria) this;
        }

        public Criteria andCheckAccountIsNull() {
            addCriterion("check_account is null");
            return (Criteria) this;
        }

        public Criteria andCheckAccountIsNotNull() {
            addCriterion("check_account is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAccountEqualTo(String value) {
            addCriterion("check_account =", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountNotEqualTo(String value) {
            addCriterion("check_account <>", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountGreaterThan(String value) {
            addCriterion("check_account >", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountGreaterThanOrEqualTo(String value) {
            addCriterion("check_account >=", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountLessThan(String value) {
            addCriterion("check_account <", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountLessThanOrEqualTo(String value) {
            addCriterion("check_account <=", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountLike(String value) {
            addCriterion("check_account like", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountNotLike(String value) {
            addCriterion("check_account not like", value, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountIn(List<String> values) {
            addCriterion("check_account in", values, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountNotIn(List<String> values) {
            addCriterion("check_account not in", values, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountBetween(String value1, String value2) {
            addCriterion("check_account between", value1, value2, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckAccountNotBetween(String value1, String value2) {
            addCriterion("check_account not between", value1, value2, "checkAccount");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkIsNull() {
            addCriterion("check_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkIsNotNull() {
            addCriterion("check_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkEqualTo(String value) {
            addCriterion("check_remark =", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotEqualTo(String value) {
            addCriterion("check_remark <>", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkGreaterThan(String value) {
            addCriterion("check_remark >", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_remark >=", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLessThan(String value) {
            addCriterion("check_remark <", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_remark <=", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLike(String value) {
            addCriterion("check_remark like", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotLike(String value) {
            addCriterion("check_remark not like", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkIn(List<String> values) {
            addCriterion("check_remark in", values, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotIn(List<String> values) {
            addCriterion("check_remark not in", values, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkBetween(String value1, String value2) {
            addCriterion("check_remark between", value1, value2, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotBetween(String value1, String value2) {
            addCriterion("check_remark not between", value1, value2, "checkRemark");
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