package com.jn.enterprise.pay.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPayCheckReminderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayCheckReminderCriteria() {
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

        public Criteria andPaymentIdIsNull() {
            addCriterion("PAYMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("PAYMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(String value) {
            addCriterion("PAYMENT_ID =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(String value) {
            addCriterion("PAYMENT_ID <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(String value) {
            addCriterion("PAYMENT_ID >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_ID >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(String value) {
            addCriterion("PAYMENT_ID <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_ID <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLike(String value) {
            addCriterion("PAYMENT_ID like", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotLike(String value) {
            addCriterion("PAYMENT_ID not like", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<String> values) {
            addCriterion("PAYMENT_ID in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<String> values) {
            addCriterion("PAYMENT_ID not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(String value1, String value2) {
            addCriterion("PAYMENT_ID between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_ID not between", value1, value2, "paymentId");
            return (Criteria) this;
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

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("ENTERPRISE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("ENTERPRISE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("ENTERPRISE_NAME >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("ENTERPRISE_NAME <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_NAME <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("ENTERPRISE_NAME like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("ENTERPRISE_NAME not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("ENTERPRISE_NAME in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("ENTERPRISE_NAME not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_NAME between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_NAME not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("BANK_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("BANK_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("BANK_ACCOUNT =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("BANK_ACCOUNT >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("BANK_ACCOUNT <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("BANK_ACCOUNT like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("BANK_ACCOUNT not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("BANK_ACCOUNT in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("BANK_ACCOUNT not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyIsNull() {
            addCriterion("PAYMENT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyIsNotNull() {
            addCriterion("PAYMENT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyEqualTo(BigDecimal value) {
            addCriterion("PAYMENT_MONEY =", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyNotEqualTo(BigDecimal value) {
            addCriterion("PAYMENT_MONEY <>", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyGreaterThan(BigDecimal value) {
            addCriterion("PAYMENT_MONEY >", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYMENT_MONEY >=", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyLessThan(BigDecimal value) {
            addCriterion("PAYMENT_MONEY <", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYMENT_MONEY <=", value, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyIn(List<BigDecimal> values) {
            addCriterion("PAYMENT_MONEY in", values, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyNotIn(List<BigDecimal> values) {
            addCriterion("PAYMENT_MONEY not in", values, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYMENT_MONEY between", value1, value2, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYMENT_MONEY not between", value1, value2, "paymentMoney");
            return (Criteria) this;
        }

        public Criteria andPaymentDescIsNull() {
            addCriterion("PAYMENT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPaymentDescIsNotNull() {
            addCriterion("PAYMENT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentDescEqualTo(String value) {
            addCriterion("PAYMENT_DESC =", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescNotEqualTo(String value) {
            addCriterion("PAYMENT_DESC <>", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescGreaterThan(String value) {
            addCriterion("PAYMENT_DESC >", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_DESC >=", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescLessThan(String value) {
            addCriterion("PAYMENT_DESC <", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_DESC <=", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescLike(String value) {
            addCriterion("PAYMENT_DESC like", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescNotLike(String value) {
            addCriterion("PAYMENT_DESC not like", value, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescIn(List<String> values) {
            addCriterion("PAYMENT_DESC in", values, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescNotIn(List<String> values) {
            addCriterion("PAYMENT_DESC not in", values, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescBetween(String value1, String value2) {
            addCriterion("PAYMENT_DESC between", value1, value2, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentDescNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_DESC not between", value1, value2, "paymentDesc");
            return (Criteria) this;
        }

        public Criteria andPicturePathIsNull() {
            addCriterion("PICTURE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andPicturePathIsNotNull() {
            addCriterion("PICTURE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andPicturePathEqualTo(String value) {
            addCriterion("PICTURE_PATH =", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotEqualTo(String value) {
            addCriterion("PICTURE_PATH <>", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathGreaterThan(String value) {
            addCriterion("PICTURE_PATH >", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathGreaterThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH >=", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathLessThan(String value) {
            addCriterion("PICTURE_PATH <", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathLessThanOrEqualTo(String value) {
            addCriterion("PICTURE_PATH <=", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathLike(String value) {
            addCriterion("PICTURE_PATH like", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotLike(String value) {
            addCriterion("PICTURE_PATH not like", value, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathIn(List<String> values) {
            addCriterion("PICTURE_PATH in", values, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotIn(List<String> values) {
            addCriterion("PICTURE_PATH not in", values, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH between", value1, value2, "picturePath");
            return (Criteria) this;
        }

        public Criteria andPicturePathNotBetween(String value1, String value2) {
            addCriterion("PICTURE_PATH not between", value1, value2, "picturePath");
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