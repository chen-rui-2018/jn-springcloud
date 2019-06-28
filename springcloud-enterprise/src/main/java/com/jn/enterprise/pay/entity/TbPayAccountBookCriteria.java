package com.jn.enterprise.pay.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPayAccountBookCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayAccountBookCriteria() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("ACCOUNT_ID like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("ACCOUNT_ID not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAcBookNameIsNull() {
            addCriterion("AC_BOOK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAcBookNameIsNotNull() {
            addCriterion("AC_BOOK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAcBookNameEqualTo(String value) {
            addCriterion("AC_BOOK_NAME =", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameNotEqualTo(String value) {
            addCriterion("AC_BOOK_NAME <>", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameGreaterThan(String value) {
            addCriterion("AC_BOOK_NAME >", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("AC_BOOK_NAME >=", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameLessThan(String value) {
            addCriterion("AC_BOOK_NAME <", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameLessThanOrEqualTo(String value) {
            addCriterion("AC_BOOK_NAME <=", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameLike(String value) {
            addCriterion("AC_BOOK_NAME like", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameNotLike(String value) {
            addCriterion("AC_BOOK_NAME not like", value, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameIn(List<String> values) {
            addCriterion("AC_BOOK_NAME in", values, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameNotIn(List<String> values) {
            addCriterion("AC_BOOK_NAME not in", values, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameBetween(String value1, String value2) {
            addCriterion("AC_BOOK_NAME between", value1, value2, "acBookName");
            return (Criteria) this;
        }

        public Criteria andAcBookNameNotBetween(String value1, String value2) {
            addCriterion("AC_BOOK_NAME not between", value1, value2, "acBookName");
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

        public Criteria andBalanceIsNull() {
            addCriterion("BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("BALANCE =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("BALANCE <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("BALANCE >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("BALANCE <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("BALANCE in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("BALANCE not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsIsNull() {
            addCriterion("AUTOMATIC_DEDUCTIONS is null");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsIsNotNull() {
            addCriterion("AUTOMATIC_DEDUCTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsEqualTo(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS =", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsNotEqualTo(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS <>", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsGreaterThan(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS >", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsGreaterThanOrEqualTo(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS >=", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsLessThan(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS <", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsLessThanOrEqualTo(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS <=", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsLike(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS like", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsNotLike(String value) {
            addCriterion("AUTOMATIC_DEDUCTIONS not like", value, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsIn(List<String> values) {
            addCriterion("AUTOMATIC_DEDUCTIONS in", values, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsNotIn(List<String> values) {
            addCriterion("AUTOMATIC_DEDUCTIONS not in", values, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsBetween(String value1, String value2) {
            addCriterion("AUTOMATIC_DEDUCTIONS between", value1, value2, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andAutomaticDeductionsNotBetween(String value1, String value2) {
            addCriterion("AUTOMATIC_DEDUCTIONS not between", value1, value2, "automaticDeductions");
            return (Criteria) this;
        }

        public Criteria andCanRechargeIsNull() {
            addCriterion("CAN_RECHARGE is null");
            return (Criteria) this;
        }

        public Criteria andCanRechargeIsNotNull() {
            addCriterion("CAN_RECHARGE is not null");
            return (Criteria) this;
        }

        public Criteria andCanRechargeEqualTo(String value) {
            addCriterion("CAN_RECHARGE =", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeNotEqualTo(String value) {
            addCriterion("CAN_RECHARGE <>", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeGreaterThan(String value) {
            addCriterion("CAN_RECHARGE >", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeGreaterThanOrEqualTo(String value) {
            addCriterion("CAN_RECHARGE >=", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeLessThan(String value) {
            addCriterion("CAN_RECHARGE <", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeLessThanOrEqualTo(String value) {
            addCriterion("CAN_RECHARGE <=", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeLike(String value) {
            addCriterion("CAN_RECHARGE like", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeNotLike(String value) {
            addCriterion("CAN_RECHARGE not like", value, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeIn(List<String> values) {
            addCriterion("CAN_RECHARGE in", values, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeNotIn(List<String> values) {
            addCriterion("CAN_RECHARGE not in", values, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeBetween(String value1, String value2) {
            addCriterion("CAN_RECHARGE between", value1, value2, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andCanRechargeNotBetween(String value1, String value2) {
            addCriterion("CAN_RECHARGE not between", value1, value2, "canRecharge");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("is_show like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("is_show not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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

        public Criteria andEntIdIsNull() {
            addCriterion("ent_id is null");
            return (Criteria) this;
        }

        public Criteria andEntIdIsNotNull() {
            addCriterion("ent_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntIdEqualTo(String value) {
            addCriterion("ent_id =", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotEqualTo(String value) {
            addCriterion("ent_id <>", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdGreaterThan(String value) {
            addCriterion("ent_id >", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdGreaterThanOrEqualTo(String value) {
            addCriterion("ent_id >=", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdLessThan(String value) {
            addCriterion("ent_id <", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdLessThanOrEqualTo(String value) {
            addCriterion("ent_id <=", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdLike(String value) {
            addCriterion("ent_id like", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotLike(String value) {
            addCriterion("ent_id not like", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdIn(List<String> values) {
            addCriterion("ent_id in", values, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotIn(List<String> values) {
            addCriterion("ent_id not in", values, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdBetween(String value1, String value2) {
            addCriterion("ent_id between", value1, value2, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotBetween(String value1, String value2) {
            addCriterion("ent_id not between", value1, value2, "entId");
            return (Criteria) this;
        }

        public Criteria andEntNameIsNull() {
            addCriterion("ent_name is null");
            return (Criteria) this;
        }

        public Criteria andEntNameIsNotNull() {
            addCriterion("ent_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntNameEqualTo(String value) {
            addCriterion("ent_name =", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotEqualTo(String value) {
            addCriterion("ent_name <>", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameGreaterThan(String value) {
            addCriterion("ent_name >", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameGreaterThanOrEqualTo(String value) {
            addCriterion("ent_name >=", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameLessThan(String value) {
            addCriterion("ent_name <", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameLessThanOrEqualTo(String value) {
            addCriterion("ent_name <=", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameLike(String value) {
            addCriterion("ent_name like", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotLike(String value) {
            addCriterion("ent_name not like", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameIn(List<String> values) {
            addCriterion("ent_name in", values, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotIn(List<String> values) {
            addCriterion("ent_name not in", values, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameBetween(String value1, String value2) {
            addCriterion("ent_name between", value1, value2, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotBetween(String value1, String value2) {
            addCriterion("ent_name not between", value1, value2, "entName");
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