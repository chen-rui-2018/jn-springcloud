package com.jn.park.finance.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFinanceIncomeMonthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFinanceIncomeMonthExample() {
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
            addCriterion("imonth.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("imonth.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("imonth.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("imonth.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("imonth.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("imonth.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("imonth.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("imonth.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("imonth.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("imonth.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("imonth.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("imonth.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthIsNull() {
            addCriterion("imonth.income_month is null");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthIsNotNull() {
            addCriterion("imonth.income_month is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthEqualTo(String value) {
            addCriterion("imonth.income_month =", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotEqualTo(String value) {
            addCriterion("imonth.income_month <>", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthGreaterThan(String value) {
            addCriterion("imonth.income_month >", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthGreaterThanOrEqualTo(String value) {
            addCriterion("imonth.income_month >=", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthLessThan(String value) {
            addCriterion("imonth.income_month <", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthLessThanOrEqualTo(String value) {
            addCriterion("imonth.income_month <=", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthLike(String value) {
            addCriterion("imonth.income_month like", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotLike(String value) {
            addCriterion("imonth.income_month not like", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthIn(List<String> values) {
            addCriterion("imonth.income_month in", values, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotIn(List<String> values) {
            addCriterion("imonth.income_month not in", values, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthBetween(String value1, String value2) {
            addCriterion("imonth.income_month between", value1, value2, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotBetween(String value1, String value2) {
            addCriterion("imonth.income_month not between", value1, value2, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeIsNull() {
            addCriterion("imonth.income_type is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeIsNotNull() {
            addCriterion("imonth.income_type is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeEqualTo(Integer value) {
            addCriterion("imonth.income_type =", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotEqualTo(Integer value) {
            addCriterion("imonth.income_type <>", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeGreaterThan(Integer value) {
            addCriterion("imonth.income_type >", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("imonth.income_type >=", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeLessThan(Integer value) {
            addCriterion("imonth.income_type <", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("imonth.income_type <=", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeIn(List<Integer> values) {
            addCriterion("imonth.income_type in", values, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotIn(List<Integer> values) {
            addCriterion("imonth.income_type not in", values, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeBetween(Integer value1, Integer value2) {
            addCriterion("imonth.income_type between", value1, value2, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("imonth.income_type not between", value1, value2, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameIsNull() {
            addCriterion("imonth.income_typename is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameIsNotNull() {
            addCriterion("imonth.income_typename is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameEqualTo(String value) {
            addCriterion("imonth.income_typename =", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameNotEqualTo(String value) {
            addCriterion("imonth.income_typename <>", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameGreaterThan(String value) {
            addCriterion("imonth.income_typename >", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("imonth.income_typename >=", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameLessThan(String value) {
            addCriterion("imonth.income_typename <", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameLessThanOrEqualTo(String value) {
            addCriterion("imonth.income_typename <=", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameLike(String value) {
            addCriterion("imonth.income_typename like", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameNotLike(String value) {
            addCriterion("imonth.income_typename not like", value, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameIn(List<String> values) {
            addCriterion("imonth.income_typename in", values, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameNotIn(List<String> values) {
            addCriterion("imonth.income_typename not in", values, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameBetween(String value1, String value2) {
            addCriterion("imonth.income_typename between", value1, value2, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeTypenameNotBetween(String value1, String value2) {
            addCriterion("imonth.income_typename not between", value1, value2, "incomeTypename");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("imonth.income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("imonth.income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(BigDecimal value) {
            addCriterion("imonth.income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(BigDecimal value) {
            addCriterion("imonth.income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(BigDecimal value) {
            addCriterion("imonth.income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("imonth.income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(BigDecimal value) {
            addCriterion("imonth.income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("imonth.income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<BigDecimal> values) {
            addCriterion("imonth.income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<BigDecimal> values) {
            addCriterion("imonth.income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("imonth.income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("imonth.income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("imonth.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("imonth.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("imonth.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("imonth.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("imonth.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("imonth.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("imonth.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("imonth.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("imonth.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("imonth.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("imonth.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("imonth.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("imonth.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("imonth.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("imonth.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("imonth.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("imonth.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("imonth.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("imonth.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("imonth.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("imonth.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("imonth.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("imonth.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("imonth.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("imonth.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("imonth.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("imonth.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("imonth.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("imonth.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("imonth.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("imonth.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("imonth.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("imonth.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("imonth.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("imonth.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("imonth.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("imonth.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("imonth.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("imonth.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("imonth.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("imonth.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("imonth.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("imonth.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("imonth.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("imonth.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("imonth.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("imonth.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("imonth.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("imonth.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("imonth.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("imonth.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("imonth.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("imonth.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("imonth.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("imonth.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("imonth.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("imonth.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("imonth.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("imonth.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("imonth.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("imonth.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("imonth.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("imonth.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("imonth.modified_time not between", value1, value2, "modifiedTime");
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