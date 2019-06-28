package com.jn.enterprise.pay.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPayBillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayBillCriteria() {
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
            addCriterion("BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("BILL_ID =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("BILL_ID <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("BILL_ID >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_ID >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("BILL_ID <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("BILL_ID <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("BILL_ID like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("BILL_ID not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("BILL_ID in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("BILL_ID not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("BILL_ID between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("BILL_ID not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdIsNull() {
            addCriterion("AC_BOOK_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcBookIdIsNotNull() {
            addCriterion("AC_BOOK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcBookIdEqualTo(String value) {
            addCriterion("AC_BOOK_ID =", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdNotEqualTo(String value) {
            addCriterion("AC_BOOK_ID <>", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdGreaterThan(String value) {
            addCriterion("AC_BOOK_ID >", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("AC_BOOK_ID >=", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdLessThan(String value) {
            addCriterion("AC_BOOK_ID <", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdLessThanOrEqualTo(String value) {
            addCriterion("AC_BOOK_ID <=", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdLike(String value) {
            addCriterion("AC_BOOK_ID like", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdNotLike(String value) {
            addCriterion("AC_BOOK_ID not like", value, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdIn(List<String> values) {
            addCriterion("AC_BOOK_ID in", values, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdNotIn(List<String> values) {
            addCriterion("AC_BOOK_ID not in", values, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdBetween(String value1, String value2) {
            addCriterion("AC_BOOK_ID between", value1, value2, "acBookId");
            return (Criteria) this;
        }

        public Criteria andAcBookIdNotBetween(String value1, String value2) {
            addCriterion("AC_BOOK_ID not between", value1, value2, "acBookId");
            return (Criteria) this;
        }

        public Criteria andBillNameIsNull() {
            addCriterion("BILL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBillNameIsNotNull() {
            addCriterion("BILL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBillNameEqualTo(String value) {
            addCriterion("BILL_NAME =", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotEqualTo(String value) {
            addCriterion("BILL_NAME <>", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameGreaterThan(String value) {
            addCriterion("BILL_NAME >", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_NAME >=", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameLessThan(String value) {
            addCriterion("BILL_NAME <", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameLessThanOrEqualTo(String value) {
            addCriterion("BILL_NAME <=", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameLike(String value) {
            addCriterion("BILL_NAME like", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotLike(String value) {
            addCriterion("BILL_NAME not like", value, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameIn(List<String> values) {
            addCriterion("BILL_NAME in", values, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotIn(List<String> values) {
            addCriterion("BILL_NAME not in", values, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameBetween(String value1, String value2) {
            addCriterion("BILL_NAME between", value1, value2, "billName");
            return (Criteria) this;
        }

        public Criteria andBillNameNotBetween(String value1, String value2) {
            addCriterion("BILL_NAME not between", value1, value2, "billName");
            return (Criteria) this;
        }

        public Criteria andBillSourceIsNull() {
            addCriterion("BILL_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andBillSourceIsNotNull() {
            addCriterion("BILL_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andBillSourceEqualTo(String value) {
            addCriterion("BILL_SOURCE =", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotEqualTo(String value) {
            addCriterion("BILL_SOURCE <>", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceGreaterThan(String value) {
            addCriterion("BILL_SOURCE >", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_SOURCE >=", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceLessThan(String value) {
            addCriterion("BILL_SOURCE <", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceLessThanOrEqualTo(String value) {
            addCriterion("BILL_SOURCE <=", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceLike(String value) {
            addCriterion("BILL_SOURCE like", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotLike(String value) {
            addCriterion("BILL_SOURCE not like", value, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceIn(List<String> values) {
            addCriterion("BILL_SOURCE in", values, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotIn(List<String> values) {
            addCriterion("BILL_SOURCE not in", values, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceBetween(String value1, String value2) {
            addCriterion("BILL_SOURCE between", value1, value2, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillSourceNotBetween(String value1, String value2) {
            addCriterion("BILL_SOURCE not between", value1, value2, "billSource");
            return (Criteria) this;
        }

        public Criteria andBillExpenseIsNull() {
            addCriterion("BILL_EXPENSE is null");
            return (Criteria) this;
        }

        public Criteria andBillExpenseIsNotNull() {
            addCriterion("BILL_EXPENSE is not null");
            return (Criteria) this;
        }

        public Criteria andBillExpenseEqualTo(BigDecimal value) {
            addCriterion("BILL_EXPENSE =", value, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseNotEqualTo(BigDecimal value) {
            addCriterion("BILL_EXPENSE <>", value, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseGreaterThan(BigDecimal value) {
            addCriterion("BILL_EXPENSE >", value, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_EXPENSE >=", value, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseLessThan(BigDecimal value) {
            addCriterion("BILL_EXPENSE <", value, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BILL_EXPENSE <=", value, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseIn(List<BigDecimal> values) {
            addCriterion("BILL_EXPENSE in", values, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseNotIn(List<BigDecimal> values) {
            addCriterion("BILL_EXPENSE not in", values, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_EXPENSE between", value1, value2, "billExpense");
            return (Criteria) this;
        }

        public Criteria andBillExpenseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BILL_EXPENSE not between", value1, value2, "billExpense");
            return (Criteria) this;
        }

        public Criteria andReminderNumberIsNull() {
            addCriterion("REMINDER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andReminderNumberIsNotNull() {
            addCriterion("REMINDER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andReminderNumberEqualTo(Integer value) {
            addCriterion("REMINDER_NUMBER =", value, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberNotEqualTo(Integer value) {
            addCriterion("REMINDER_NUMBER <>", value, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberGreaterThan(Integer value) {
            addCriterion("REMINDER_NUMBER >", value, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("REMINDER_NUMBER >=", value, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberLessThan(Integer value) {
            addCriterion("REMINDER_NUMBER <", value, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("REMINDER_NUMBER <=", value, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberIn(List<Integer> values) {
            addCriterion("REMINDER_NUMBER in", values, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberNotIn(List<Integer> values) {
            addCriterion("REMINDER_NUMBER not in", values, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberBetween(Integer value1, Integer value2) {
            addCriterion("REMINDER_NUMBER between", value1, value2, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andReminderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("REMINDER_NUMBER not between", value1, value2, "reminderNumber");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeIsNull() {
            addCriterion("modified_reminder_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeIsNotNull() {
            addCriterion("modified_reminder_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeEqualTo(Date value) {
            addCriterion("modified_reminder_time =", value, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeNotEqualTo(Date value) {
            addCriterion("modified_reminder_time <>", value, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeGreaterThan(Date value) {
            addCriterion("modified_reminder_time >", value, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_reminder_time >=", value, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeLessThan(Date value) {
            addCriterion("modified_reminder_time <", value, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_reminder_time <=", value, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeIn(List<Date> values) {
            addCriterion("modified_reminder_time in", values, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeNotIn(List<Date> values) {
            addCriterion("modified_reminder_time not in", values, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeBetween(Date value1, Date value2) {
            addCriterion("modified_reminder_time between", value1, value2, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andModifiedReminderTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_reminder_time not between", value1, value2, "modifiedReminderTime");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNull() {
            addCriterion("OBJ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNotNull() {
            addCriterion("OBJ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjTypeEqualTo(String value) {
            addCriterion("OBJ_TYPE =", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotEqualTo(String value) {
            addCriterion("OBJ_TYPE <>", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThan(String value) {
            addCriterion("OBJ_TYPE >", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OBJ_TYPE >=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThan(String value) {
            addCriterion("OBJ_TYPE <", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThanOrEqualTo(String value) {
            addCriterion("OBJ_TYPE <=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLike(String value) {
            addCriterion("OBJ_TYPE like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotLike(String value) {
            addCriterion("OBJ_TYPE not like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeIn(List<String> values) {
            addCriterion("OBJ_TYPE in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotIn(List<String> values) {
            addCriterion("OBJ_TYPE not in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeBetween(String value1, String value2) {
            addCriterion("OBJ_TYPE between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotBetween(String value1, String value2) {
            addCriterion("OBJ_TYPE not between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNull() {
            addCriterion("obj_id is null");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNotNull() {
            addCriterion("obj_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjIdEqualTo(String value) {
            addCriterion("obj_id =", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotEqualTo(String value) {
            addCriterion("obj_id <>", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThan(String value) {
            addCriterion("obj_id >", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThanOrEqualTo(String value) {
            addCriterion("obj_id >=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThan(String value) {
            addCriterion("obj_id <", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThanOrEqualTo(String value) {
            addCriterion("obj_id <=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLike(String value) {
            addCriterion("obj_id like", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotLike(String value) {
            addCriterion("obj_id not like", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdIn(List<String> values) {
            addCriterion("obj_id in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotIn(List<String> values) {
            addCriterion("obj_id not in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdBetween(String value1, String value2) {
            addCriterion("obj_id between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotBetween(String value1, String value2) {
            addCriterion("obj_id not between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjNameIsNull() {
            addCriterion("OBJ_NAME is null");
            return (Criteria) this;
        }

        public Criteria andObjNameIsNotNull() {
            addCriterion("OBJ_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andObjNameEqualTo(String value) {
            addCriterion("OBJ_NAME =", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotEqualTo(String value) {
            addCriterion("OBJ_NAME <>", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameGreaterThan(String value) {
            addCriterion("OBJ_NAME >", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameGreaterThanOrEqualTo(String value) {
            addCriterion("OBJ_NAME >=", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameLessThan(String value) {
            addCriterion("OBJ_NAME <", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameLessThanOrEqualTo(String value) {
            addCriterion("OBJ_NAME <=", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameLike(String value) {
            addCriterion("OBJ_NAME like", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotLike(String value) {
            addCriterion("OBJ_NAME not like", value, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameIn(List<String> values) {
            addCriterion("OBJ_NAME in", values, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotIn(List<String> values) {
            addCriterion("OBJ_NAME not in", values, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameBetween(String value1, String value2) {
            addCriterion("OBJ_NAME between", value1, value2, "objName");
            return (Criteria) this;
        }

        public Criteria andObjNameNotBetween(String value1, String value2) {
            addCriterion("OBJ_NAME not between", value1, value2, "objName");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNull() {
            addCriterion("PAYMENT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIsNotNull() {
            addCriterion("PAYMENT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStateEqualTo(String value) {
            addCriterion("PAYMENT_STATE =", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotEqualTo(String value) {
            addCriterion("PAYMENT_STATE <>", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThan(String value) {
            addCriterion("PAYMENT_STATE >", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATE >=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThan(String value) {
            addCriterion("PAYMENT_STATE <", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATE <=", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateLike(String value) {
            addCriterion("PAYMENT_STATE like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotLike(String value) {
            addCriterion("PAYMENT_STATE not like", value, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateIn(List<String> values) {
            addCriterion("PAYMENT_STATE in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotIn(List<String> values) {
            addCriterion("PAYMENT_STATE not in", values, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATE between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentStateNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATE not between", value1, value2, "paymentState");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("PAYMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("PAYMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("PAYMENT_TYPE =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("PAYMENT_TYPE <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("PAYMENT_TYPE >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_TYPE >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("PAYMENT_TYPE <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_TYPE <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("PAYMENT_TYPE like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("PAYMENT_TYPE not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("PAYMENT_TYPE in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("PAYMENT_TYPE not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("PAYMENT_TYPE between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_TYPE not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeIsNull() {
            addCriterion("AC_BOOK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeIsNotNull() {
            addCriterion("AC_BOOK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeEqualTo(String value) {
            addCriterion("AC_BOOK_TYPE =", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeNotEqualTo(String value) {
            addCriterion("AC_BOOK_TYPE <>", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeGreaterThan(String value) {
            addCriterion("AC_BOOK_TYPE >", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeGreaterThanOrEqualTo(String value) {
            addCriterion("AC_BOOK_TYPE >=", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeLessThan(String value) {
            addCriterion("AC_BOOK_TYPE <", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeLessThanOrEqualTo(String value) {
            addCriterion("AC_BOOK_TYPE <=", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeLike(String value) {
            addCriterion("AC_BOOK_TYPE like", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeNotLike(String value) {
            addCriterion("AC_BOOK_TYPE not like", value, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeIn(List<String> values) {
            addCriterion("AC_BOOK_TYPE in", values, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeNotIn(List<String> values) {
            addCriterion("AC_BOOK_TYPE not in", values, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeBetween(String value1, String value2) {
            addCriterion("AC_BOOK_TYPE between", value1, value2, "acBookType");
            return (Criteria) this;
        }

        public Criteria andAcBookTypeNotBetween(String value1, String value2) {
            addCriterion("AC_BOOK_TYPE not between", value1, value2, "acBookType");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNull() {
            addCriterion("callback_url is null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNotNull() {
            addCriterion("callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlEqualTo(String value) {
            addCriterion("callback_url =", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotEqualTo(String value) {
            addCriterion("callback_url <>", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThan(String value) {
            addCriterion("callback_url >", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("callback_url >=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThan(String value) {
            addCriterion("callback_url <", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("callback_url <=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLike(String value) {
            addCriterion("callback_url like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotLike(String value) {
            addCriterion("callback_url not like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIn(List<String> values) {
            addCriterion("callback_url in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotIn(List<String> values) {
            addCriterion("callback_url not in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlBetween(String value1, String value2) {
            addCriterion("callback_url between", value1, value2, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("callback_url not between", value1, value2, "callbackUrl");
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

        public Criteria andLatePaymentIsNull() {
            addCriterion("LATE_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andLatePaymentIsNotNull() {
            addCriterion("LATE_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andLatePaymentEqualTo(Date value) {
            addCriterion("LATE_PAYMENT =", value, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentNotEqualTo(Date value) {
            addCriterion("LATE_PAYMENT <>", value, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentGreaterThan(Date value) {
            addCriterion("LATE_PAYMENT >", value, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentGreaterThanOrEqualTo(Date value) {
            addCriterion("LATE_PAYMENT >=", value, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentLessThan(Date value) {
            addCriterion("LATE_PAYMENT <", value, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentLessThanOrEqualTo(Date value) {
            addCriterion("LATE_PAYMENT <=", value, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentIn(List<Date> values) {
            addCriterion("LATE_PAYMENT in", values, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentNotIn(List<Date> values) {
            addCriterion("LATE_PAYMENT not in", values, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentBetween(Date value1, Date value2) {
            addCriterion("LATE_PAYMENT between", value1, value2, "latePayment");
            return (Criteria) this;
        }

        public Criteria andLatePaymentNotBetween(Date value1, Date value2) {
            addCriterion("LATE_PAYMENT not between", value1, value2, "latePayment");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmIsNull() {
            addCriterion("PAYMENT_AFFIRM is null");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmIsNotNull() {
            addCriterion("PAYMENT_AFFIRM is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmEqualTo(String value) {
            addCriterion("PAYMENT_AFFIRM =", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmNotEqualTo(String value) {
            addCriterion("PAYMENT_AFFIRM <>", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmGreaterThan(String value) {
            addCriterion("PAYMENT_AFFIRM >", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_AFFIRM >=", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmLessThan(String value) {
            addCriterion("PAYMENT_AFFIRM <", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_AFFIRM <=", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmLike(String value) {
            addCriterion("PAYMENT_AFFIRM like", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmNotLike(String value) {
            addCriterion("PAYMENT_AFFIRM not like", value, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmIn(List<String> values) {
            addCriterion("PAYMENT_AFFIRM in", values, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmNotIn(List<String> values) {
            addCriterion("PAYMENT_AFFIRM not in", values, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmBetween(String value1, String value2) {
            addCriterion("PAYMENT_AFFIRM between", value1, value2, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andPaymentAffirmNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_AFFIRM not between", value1, value2, "paymentAffirm");
            return (Criteria) this;
        }

        public Criteria andAffirmPartIsNull() {
            addCriterion("AFFIRM_PART is null");
            return (Criteria) this;
        }

        public Criteria andAffirmPartIsNotNull() {
            addCriterion("AFFIRM_PART is not null");
            return (Criteria) this;
        }

        public Criteria andAffirmPartEqualTo(String value) {
            addCriterion("AFFIRM_PART =", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartNotEqualTo(String value) {
            addCriterion("AFFIRM_PART <>", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartGreaterThan(String value) {
            addCriterion("AFFIRM_PART >", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartGreaterThanOrEqualTo(String value) {
            addCriterion("AFFIRM_PART >=", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartLessThan(String value) {
            addCriterion("AFFIRM_PART <", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartLessThanOrEqualTo(String value) {
            addCriterion("AFFIRM_PART <=", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartLike(String value) {
            addCriterion("AFFIRM_PART like", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartNotLike(String value) {
            addCriterion("AFFIRM_PART not like", value, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartIn(List<String> values) {
            addCriterion("AFFIRM_PART in", values, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartNotIn(List<String> values) {
            addCriterion("AFFIRM_PART not in", values, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartBetween(String value1, String value2) {
            addCriterion("AFFIRM_PART between", value1, value2, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmPartNotBetween(String value1, String value2) {
            addCriterion("AFFIRM_PART not between", value1, value2, "affirmPart");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeIsNull() {
            addCriterion("AFFIRM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeIsNotNull() {
            addCriterion("AFFIRM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeEqualTo(Date value) {
            addCriterion("AFFIRM_TIME =", value, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeNotEqualTo(Date value) {
            addCriterion("AFFIRM_TIME <>", value, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeGreaterThan(Date value) {
            addCriterion("AFFIRM_TIME >", value, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AFFIRM_TIME >=", value, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeLessThan(Date value) {
            addCriterion("AFFIRM_TIME <", value, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeLessThanOrEqualTo(Date value) {
            addCriterion("AFFIRM_TIME <=", value, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeIn(List<Date> values) {
            addCriterion("AFFIRM_TIME in", values, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeNotIn(List<Date> values) {
            addCriterion("AFFIRM_TIME not in", values, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeBetween(Date value1, Date value2) {
            addCriterion("AFFIRM_TIME between", value1, value2, "affirmTime");
            return (Criteria) this;
        }

        public Criteria andAffirmTimeNotBetween(Date value1, Date value2) {
            addCriterion("AFFIRM_TIME not between", value1, value2, "affirmTime");
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

        public Criteria andCallbackIdIsNull() {
            addCriterion("callback_id is null");
            return (Criteria) this;
        }

        public Criteria andCallbackIdIsNotNull() {
            addCriterion("callback_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackIdEqualTo(String value) {
            addCriterion("callback_id =", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdNotEqualTo(String value) {
            addCriterion("callback_id <>", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdGreaterThan(String value) {
            addCriterion("callback_id >", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdGreaterThanOrEqualTo(String value) {
            addCriterion("callback_id >=", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdLessThan(String value) {
            addCriterion("callback_id <", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdLessThanOrEqualTo(String value) {
            addCriterion("callback_id <=", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdLike(String value) {
            addCriterion("callback_id like", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdNotLike(String value) {
            addCriterion("callback_id not like", value, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdIn(List<String> values) {
            addCriterion("callback_id in", values, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdNotIn(List<String> values) {
            addCriterion("callback_id not in", values, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdBetween(String value1, String value2) {
            addCriterion("callback_id between", value1, value2, "callbackId");
            return (Criteria) this;
        }

        public Criteria andCallbackIdNotBetween(String value1, String value2) {
            addCriterion("callback_id not between", value1, value2, "callbackId");
            return (Criteria) this;
        }

        public Criteria andBillReceiverIsNull() {
            addCriterion("bill_receiver is null");
            return (Criteria) this;
        }

        public Criteria andBillReceiverIsNotNull() {
            addCriterion("bill_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andBillReceiverEqualTo(String value) {
            addCriterion("bill_receiver =", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverNotEqualTo(String value) {
            addCriterion("bill_receiver <>", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverGreaterThan(String value) {
            addCriterion("bill_receiver >", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("bill_receiver >=", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverLessThan(String value) {
            addCriterion("bill_receiver <", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverLessThanOrEqualTo(String value) {
            addCriterion("bill_receiver <=", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverLike(String value) {
            addCriterion("bill_receiver like", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverNotLike(String value) {
            addCriterion("bill_receiver not like", value, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverIn(List<String> values) {
            addCriterion("bill_receiver in", values, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverNotIn(List<String> values) {
            addCriterion("bill_receiver not in", values, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverBetween(String value1, String value2) {
            addCriterion("bill_receiver between", value1, value2, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBillReceiverNotBetween(String value1, String value2) {
            addCriterion("bill_receiver not between", value1, value2, "billReceiver");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNull() {
            addCriterion("build_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNotNull() {
            addCriterion("build_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildIdEqualTo(String value) {
            addCriterion("build_id =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(String value) {
            addCriterion("build_id <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(String value) {
            addCriterion("build_id >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(String value) {
            addCriterion("build_id >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(String value) {
            addCriterion("build_id <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(String value) {
            addCriterion("build_id <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLike(String value) {
            addCriterion("build_id like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotLike(String value) {
            addCriterion("build_id not like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<String> values) {
            addCriterion("build_id in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<String> values) {
            addCriterion("build_id not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(String value1, String value2) {
            addCriterion("build_id between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(String value1, String value2) {
            addCriterion("build_id not between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNull() {
            addCriterion("build_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNotNull() {
            addCriterion("build_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildNameEqualTo(String value) {
            addCriterion("build_name =", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotEqualTo(String value) {
            addCriterion("build_name <>", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThan(String value) {
            addCriterion("build_name >", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
            addCriterion("build_name >=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThan(String value) {
            addCriterion("build_name <", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThanOrEqualTo(String value) {
            addCriterion("build_name <=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLike(String value) {
            addCriterion("build_name like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotLike(String value) {
            addCriterion("build_name not like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameIn(List<String> values) {
            addCriterion("build_name in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotIn(List<String> values) {
            addCriterion("build_name not in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameBetween(String value1, String value2) {
            addCriterion("build_name between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotBetween(String value1, String value2) {
            addCriterion("build_name not between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIsNull() {
            addCriterion("meter_code is null");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIsNotNull() {
            addCriterion("meter_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeterCodeEqualTo(String value) {
            addCriterion("meter_code =", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotEqualTo(String value) {
            addCriterion("meter_code <>", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeGreaterThan(String value) {
            addCriterion("meter_code >", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("meter_code >=", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLessThan(String value) {
            addCriterion("meter_code <", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLessThanOrEqualTo(String value) {
            addCriterion("meter_code <=", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLike(String value) {
            addCriterion("meter_code like", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotLike(String value) {
            addCriterion("meter_code not like", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIn(List<String> values) {
            addCriterion("meter_code in", values, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotIn(List<String> values) {
            addCriterion("meter_code not in", values, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeBetween(String value1, String value2) {
            addCriterion("meter_code between", value1, value2, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotBetween(String value1, String value2) {
            addCriterion("meter_code not between", value1, value2, "meterCode");
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