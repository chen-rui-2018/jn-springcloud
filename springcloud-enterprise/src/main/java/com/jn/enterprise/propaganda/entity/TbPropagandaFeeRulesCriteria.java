package com.jn.enterprise.propaganda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPropagandaFeeRulesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPropagandaFeeRulesCriteria() {
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

        public Criteria andProFeeRuleCodeIsNull() {
            addCriterion("pro_fee_rule_code is null");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeIsNotNull() {
            addCriterion("pro_fee_rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeEqualTo(String value) {
            addCriterion("pro_fee_rule_code =", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotEqualTo(String value) {
            addCriterion("pro_fee_rule_code <>", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeGreaterThan(String value) {
            addCriterion("pro_fee_rule_code >", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_fee_rule_code >=", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeLessThan(String value) {
            addCriterion("pro_fee_rule_code <", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeLessThanOrEqualTo(String value) {
            addCriterion("pro_fee_rule_code <=", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeLike(String value) {
            addCriterion("pro_fee_rule_code like", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotLike(String value) {
            addCriterion("pro_fee_rule_code not like", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeIn(List<String> values) {
            addCriterion("pro_fee_rule_code in", values, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotIn(List<String> values) {
            addCriterion("pro_fee_rule_code not in", values, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeBetween(String value1, String value2) {
            addCriterion("pro_fee_rule_code between", value1, value2, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotBetween(String value1, String value2) {
            addCriterion("pro_fee_rule_code not between", value1, value2, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsIsNull() {
            addCriterion("pro_fee_rule_details is null");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsIsNotNull() {
            addCriterion("pro_fee_rule_details is not null");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsEqualTo(String value) {
            addCriterion("pro_fee_rule_details =", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsNotEqualTo(String value) {
            addCriterion("pro_fee_rule_details <>", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsGreaterThan(String value) {
            addCriterion("pro_fee_rule_details >", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("pro_fee_rule_details >=", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsLessThan(String value) {
            addCriterion("pro_fee_rule_details <", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsLessThanOrEqualTo(String value) {
            addCriterion("pro_fee_rule_details <=", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsLike(String value) {
            addCriterion("pro_fee_rule_details like", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsNotLike(String value) {
            addCriterion("pro_fee_rule_details not like", value, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsIn(List<String> values) {
            addCriterion("pro_fee_rule_details in", values, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsNotIn(List<String> values) {
            addCriterion("pro_fee_rule_details not in", values, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsBetween(String value1, String value2) {
            addCriterion("pro_fee_rule_details between", value1, value2, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleDetailsNotBetween(String value1, String value2) {
            addCriterion("pro_fee_rule_details not between", value1, value2, "proFeeRuleDetails");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeIsNull() {
            addCriterion("propaganda_fee is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeIsNotNull() {
            addCriterion("propaganda_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeEqualTo(Double value) {
            addCriterion("propaganda_fee =", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeNotEqualTo(Double value) {
            addCriterion("propaganda_fee <>", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeGreaterThan(Double value) {
            addCriterion("propaganda_fee >", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("propaganda_fee >=", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeLessThan(Double value) {
            addCriterion("propaganda_fee <", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeLessThanOrEqualTo(Double value) {
            addCriterion("propaganda_fee <=", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeIn(List<Double> values) {
            addCriterion("propaganda_fee in", values, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeNotIn(List<Double> values) {
            addCriterion("propaganda_fee not in", values, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeBetween(Double value1, Double value2) {
            addCriterion("propaganda_fee between", value1, value2, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeNotBetween(Double value1, Double value2) {
            addCriterion("propaganda_fee not between", value1, value2, "propagandaFee");
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