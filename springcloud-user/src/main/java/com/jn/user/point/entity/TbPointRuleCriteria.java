package com.jn.user.point.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPointRuleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPointRuleCriteria() {
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

        public Criteria andRuleCodeIsNull() {
            addCriterion("rule_code is null");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIsNotNull() {
            addCriterion("rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCodeEqualTo(String value) {
            addCriterion("rule_code =", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotEqualTo(String value) {
            addCriterion("rule_code <>", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeGreaterThan(String value) {
            addCriterion("rule_code >", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_code >=", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLessThan(String value) {
            addCriterion("rule_code <", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLessThanOrEqualTo(String value) {
            addCriterion("rule_code <=", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeLike(String value) {
            addCriterion("rule_code like", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotLike(String value) {
            addCriterion("rule_code not like", value, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeIn(List<String> values) {
            addCriterion("rule_code in", values, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotIn(List<String> values) {
            addCriterion("rule_code not in", values, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeBetween(String value1, String value2) {
            addCriterion("rule_code between", value1, value2, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleCodeNotBetween(String value1, String value2) {
            addCriterion("rule_code not between", value1, value2, "ruleCode");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNull() {
            addCriterion("rule_name is null");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNotNull() {
            addCriterion("rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNameEqualTo(String value) {
            addCriterion("rule_name =", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotEqualTo(String value) {
            addCriterion("rule_name <>", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThan(String value) {
            addCriterion("rule_name >", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_name >=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThan(String value) {
            addCriterion("rule_name <", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThanOrEqualTo(String value) {
            addCriterion("rule_name <=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLike(String value) {
            addCriterion("rule_name like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotLike(String value) {
            addCriterion("rule_name not like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameIn(List<String> values) {
            addCriterion("rule_name in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotIn(List<String> values) {
            addCriterion("rule_name not in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameBetween(String value1, String value2) {
            addCriterion("rule_name between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotBetween(String value1, String value2) {
            addCriterion("rule_name not between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andIntegralNumIsNull() {
            addCriterion("integral_num is null");
            return (Criteria) this;
        }

        public Criteria andIntegralNumIsNotNull() {
            addCriterion("integral_num is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralNumEqualTo(Double value) {
            addCriterion("integral_num =", value, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumNotEqualTo(Double value) {
            addCriterion("integral_num <>", value, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumGreaterThan(Double value) {
            addCriterion("integral_num >", value, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumGreaterThanOrEqualTo(Double value) {
            addCriterion("integral_num >=", value, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumLessThan(Double value) {
            addCriterion("integral_num <", value, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumLessThanOrEqualTo(Double value) {
            addCriterion("integral_num <=", value, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumIn(List<Double> values) {
            addCriterion("integral_num in", values, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumNotIn(List<Double> values) {
            addCriterion("integral_num not in", values, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumBetween(Double value1, Double value2) {
            addCriterion("integral_num between", value1, value2, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralNumNotBetween(Double value1, Double value2) {
            addCriterion("integral_num not between", value1, value2, "integralNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleIsNull() {
            addCriterion("integral_cycle is null");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleIsNotNull() {
            addCriterion("integral_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleEqualTo(Integer value) {
            addCriterion("integral_cycle =", value, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleNotEqualTo(Integer value) {
            addCriterion("integral_cycle <>", value, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleGreaterThan(Integer value) {
            addCriterion("integral_cycle >", value, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_cycle >=", value, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleLessThan(Integer value) {
            addCriterion("integral_cycle <", value, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleLessThanOrEqualTo(Integer value) {
            addCriterion("integral_cycle <=", value, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleIn(List<Integer> values) {
            addCriterion("integral_cycle in", values, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleNotIn(List<Integer> values) {
            addCriterion("integral_cycle not in", values, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleBetween(Integer value1, Integer value2) {
            addCriterion("integral_cycle between", value1, value2, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andIntegralCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_cycle not between", value1, value2, "integralCycle");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumIsNull() {
            addCriterion("cycle_unit_num is null");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumIsNotNull() {
            addCriterion("cycle_unit_num is not null");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumEqualTo(Integer value) {
            addCriterion("cycle_unit_num =", value, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumNotEqualTo(Integer value) {
            addCriterion("cycle_unit_num <>", value, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumGreaterThan(Integer value) {
            addCriterion("cycle_unit_num >", value, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle_unit_num >=", value, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumLessThan(Integer value) {
            addCriterion("cycle_unit_num <", value, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumLessThanOrEqualTo(Integer value) {
            addCriterion("cycle_unit_num <=", value, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumIn(List<Integer> values) {
            addCriterion("cycle_unit_num in", values, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumNotIn(List<Integer> values) {
            addCriterion("cycle_unit_num not in", values, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumBetween(Integer value1, Integer value2) {
            addCriterion("cycle_unit_num between", value1, value2, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle_unit_num not between", value1, value2, "cycleUnitNum");
            return (Criteria) this;
        }

        public Criteria andCycleUnitIsNull() {
            addCriterion("cycle_unit is null");
            return (Criteria) this;
        }

        public Criteria andCycleUnitIsNotNull() {
            addCriterion("cycle_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCycleUnitEqualTo(String value) {
            addCriterion("cycle_unit =", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNotEqualTo(String value) {
            addCriterion("cycle_unit <>", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitGreaterThan(String value) {
            addCriterion("cycle_unit >", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitGreaterThanOrEqualTo(String value) {
            addCriterion("cycle_unit >=", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitLessThan(String value) {
            addCriterion("cycle_unit <", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitLessThanOrEqualTo(String value) {
            addCriterion("cycle_unit <=", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitLike(String value) {
            addCriterion("cycle_unit like", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNotLike(String value) {
            addCriterion("cycle_unit not like", value, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitIn(List<String> values) {
            addCriterion("cycle_unit in", values, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNotIn(List<String> values) {
            addCriterion("cycle_unit not in", values, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitBetween(String value1, String value2) {
            addCriterion("cycle_unit between", value1, value2, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleUnitNotBetween(String value1, String value2) {
            addCriterion("cycle_unit not between", value1, value2, "cycleUnit");
            return (Criteria) this;
        }

        public Criteria andCycleStatusIsNull() {
            addCriterion("cycle_status is null");
            return (Criteria) this;
        }

        public Criteria andCycleStatusIsNotNull() {
            addCriterion("cycle_status is not null");
            return (Criteria) this;
        }

        public Criteria andCycleStatusEqualTo(String value) {
            addCriterion("cycle_status =", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusNotEqualTo(String value) {
            addCriterion("cycle_status <>", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusGreaterThan(String value) {
            addCriterion("cycle_status >", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("cycle_status >=", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusLessThan(String value) {
            addCriterion("cycle_status <", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusLessThanOrEqualTo(String value) {
            addCriterion("cycle_status <=", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusLike(String value) {
            addCriterion("cycle_status like", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusNotLike(String value) {
            addCriterion("cycle_status not like", value, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusIn(List<String> values) {
            addCriterion("cycle_status in", values, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusNotIn(List<String> values) {
            addCriterion("cycle_status not in", values, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusBetween(String value1, String value2) {
            addCriterion("cycle_status between", value1, value2, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andCycleStatusNotBetween(String value1, String value2) {
            addCriterion("cycle_status not between", value1, value2, "cycleStatus");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumIsNull() {
            addCriterion("integral_count_num is null");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumIsNotNull() {
            addCriterion("integral_count_num is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumEqualTo(Integer value) {
            addCriterion("integral_count_num =", value, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumNotEqualTo(Integer value) {
            addCriterion("integral_count_num <>", value, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumGreaterThan(Integer value) {
            addCriterion("integral_count_num >", value, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_count_num >=", value, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumLessThan(Integer value) {
            addCriterion("integral_count_num <", value, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumLessThanOrEqualTo(Integer value) {
            addCriterion("integral_count_num <=", value, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumIn(List<Integer> values) {
            addCriterion("integral_count_num in", values, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumNotIn(List<Integer> values) {
            addCriterion("integral_count_num not in", values, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumBetween(Integer value1, Integer value2) {
            addCriterion("integral_count_num between", value1, value2, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andIntegralCountNumNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_count_num not between", value1, value2, "integralCountNum");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNull() {
            addCriterion("rule_type is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNotNull() {
            addCriterion("rule_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeEqualTo(String value) {
            addCriterion("rule_type =", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotEqualTo(String value) {
            addCriterion("rule_type <>", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThan(String value) {
            addCriterion("rule_type >", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_type >=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThan(String value) {
            addCriterion("rule_type <", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThanOrEqualTo(String value) {
            addCriterion("rule_type <=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLike(String value) {
            addCriterion("rule_type like", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotLike(String value) {
            addCriterion("rule_type not like", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIn(List<String> values) {
            addCriterion("rule_type in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotIn(List<String> values) {
            addCriterion("rule_type not in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeBetween(String value1, String value2) {
            addCriterion("rule_type between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotBetween(String value1, String value2) {
            addCriterion("rule_type not between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNull() {
            addCriterion("is_status is null");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNotNull() {
            addCriterion("is_status is not null");
            return (Criteria) this;
        }

        public Criteria andIsStatusEqualTo(String value) {
            addCriterion("is_status =", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotEqualTo(String value) {
            addCriterion("is_status <>", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThan(String value) {
            addCriterion("is_status >", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("is_status >=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThan(String value) {
            addCriterion("is_status <", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThanOrEqualTo(String value) {
            addCriterion("is_status <=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLike(String value) {
            addCriterion("is_status like", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotLike(String value) {
            addCriterion("is_status not like", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusIn(List<String> values) {
            addCriterion("is_status in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotIn(List<String> values) {
            addCriterion("is_status not in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusBetween(String value1, String value2) {
            addCriterion("is_status between", value1, value2, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotBetween(String value1, String value2) {
            addCriterion("is_status not between", value1, value2, "isStatus");
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