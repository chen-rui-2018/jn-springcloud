package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerHolidayRuleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerHolidayRuleCriteria() {
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

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(String value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(String value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(String value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(String value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(String value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLike(String value) {
            addCriterion("rule_id like", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotLike(String value) {
            addCriterion("rule_id not like", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<String> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<String> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(String value1, String value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(String value1, String value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andReachedYearIsNull() {
            addCriterion("reached_year is null");
            return (Criteria) this;
        }

        public Criteria andReachedYearIsNotNull() {
            addCriterion("reached_year is not null");
            return (Criteria) this;
        }

        public Criteria andReachedYearEqualTo(Integer value) {
            addCriterion("reached_year =", value, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearNotEqualTo(Integer value) {
            addCriterion("reached_year <>", value, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearGreaterThan(Integer value) {
            addCriterion("reached_year >", value, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("reached_year >=", value, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearLessThan(Integer value) {
            addCriterion("reached_year <", value, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearLessThanOrEqualTo(Integer value) {
            addCriterion("reached_year <=", value, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearIn(List<Integer> values) {
            addCriterion("reached_year in", values, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearNotIn(List<Integer> values) {
            addCriterion("reached_year not in", values, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearBetween(Integer value1, Integer value2) {
            addCriterion("reached_year between", value1, value2, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andReachedYearNotBetween(Integer value1, Integer value2) {
            addCriterion("reached_year not between", value1, value2, "reachedYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearIsNull() {
            addCriterion("not_full_year is null");
            return (Criteria) this;
        }

        public Criteria andNotFullYearIsNotNull() {
            addCriterion("not_full_year is not null");
            return (Criteria) this;
        }

        public Criteria andNotFullYearEqualTo(Integer value) {
            addCriterion("not_full_year =", value, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearNotEqualTo(Integer value) {
            addCriterion("not_full_year <>", value, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearGreaterThan(Integer value) {
            addCriterion("not_full_year >", value, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("not_full_year >=", value, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearLessThan(Integer value) {
            addCriterion("not_full_year <", value, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearLessThanOrEqualTo(Integer value) {
            addCriterion("not_full_year <=", value, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearIn(List<Integer> values) {
            addCriterion("not_full_year in", values, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearNotIn(List<Integer> values) {
            addCriterion("not_full_year not in", values, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearBetween(Integer value1, Integer value2) {
            addCriterion("not_full_year between", value1, value2, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andNotFullYearNotBetween(Integer value1, Integer value2) {
            addCriterion("not_full_year not between", value1, value2, "notFullYear");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIsNull() {
            addCriterion("annual_leave is null");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIsNotNull() {
            addCriterion("annual_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveEqualTo(Integer value) {
            addCriterion("annual_leave =", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotEqualTo(Integer value) {
            addCriterion("annual_leave <>", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveGreaterThan(Integer value) {
            addCriterion("annual_leave >", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_leave >=", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveLessThan(Integer value) {
            addCriterion("annual_leave <", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveLessThanOrEqualTo(Integer value) {
            addCriterion("annual_leave <=", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIn(List<Integer> values) {
            addCriterion("annual_leave in", values, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotIn(List<Integer> values) {
            addCriterion("annual_leave not in", values, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveBetween(Integer value1, Integer value2) {
            addCriterion("annual_leave between", value1, value2, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_leave not between", value1, value2, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(Integer value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(Integer value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(Integer value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(Integer value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<Integer> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<Integer> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
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