package com.jn.park.electricmeter.entity;

import java.util.ArrayList;
import java.util.List;

public class VElectricRulesInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VElectricRulesInfoCriteria() {
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

        public Criteria andMonitorObjectIsNull() {
            addCriterion("monitor_object is null");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectIsNotNull() {
            addCriterion("monitor_object is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectEqualTo(String value) {
            addCriterion("monitor_object =", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectNotEqualTo(String value) {
            addCriterion("monitor_object <>", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectGreaterThan(String value) {
            addCriterion("monitor_object >", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_object >=", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectLessThan(String value) {
            addCriterion("monitor_object <", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectLessThanOrEqualTo(String value) {
            addCriterion("monitor_object <=", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectLike(String value) {
            addCriterion("monitor_object like", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectNotLike(String value) {
            addCriterion("monitor_object not like", value, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectIn(List<String> values) {
            addCriterion("monitor_object in", values, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectNotIn(List<String> values) {
            addCriterion("monitor_object not in", values, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectBetween(String value1, String value2) {
            addCriterion("monitor_object between", value1, value2, "monitorObject");
            return (Criteria) this;
        }

        public Criteria andMonitorObjectNotBetween(String value1, String value2) {
            addCriterion("monitor_object not between", value1, value2, "monitorObject");
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

        public Criteria andRuleDescIsNull() {
            addCriterion("rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andRuleDescIsNotNull() {
            addCriterion("rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRuleDescEqualTo(String value) {
            addCriterion("rule_desc =", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotEqualTo(String value) {
            addCriterion("rule_desc <>", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThan(String value) {
            addCriterion("rule_desc >", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThanOrEqualTo(String value) {
            addCriterion("rule_desc >=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThan(String value) {
            addCriterion("rule_desc <", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThanOrEqualTo(String value) {
            addCriterion("rule_desc <=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLike(String value) {
            addCriterion("rule_desc like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotLike(String value) {
            addCriterion("rule_desc not like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescIn(List<String> values) {
            addCriterion("rule_desc in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotIn(List<String> values) {
            addCriterion("rule_desc not in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescBetween(String value1, String value2) {
            addCriterion("rule_desc between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotBetween(String value1, String value2) {
            addCriterion("rule_desc not between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueIsNull() {
            addCriterion("rule_show_value is null");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueIsNotNull() {
            addCriterion("rule_show_value is not null");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueEqualTo(String value) {
            addCriterion("rule_show_value =", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueNotEqualTo(String value) {
            addCriterion("rule_show_value <>", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueGreaterThan(String value) {
            addCriterion("rule_show_value >", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueGreaterThanOrEqualTo(String value) {
            addCriterion("rule_show_value >=", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueLessThan(String value) {
            addCriterion("rule_show_value <", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueLessThanOrEqualTo(String value) {
            addCriterion("rule_show_value <=", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueLike(String value) {
            addCriterion("rule_show_value like", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueNotLike(String value) {
            addCriterion("rule_show_value not like", value, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueIn(List<String> values) {
            addCriterion("rule_show_value in", values, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueNotIn(List<String> values) {
            addCriterion("rule_show_value not in", values, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueBetween(String value1, String value2) {
            addCriterion("rule_show_value between", value1, value2, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andRuleShowValueNotBetween(String value1, String value2) {
            addCriterion("rule_show_value not between", value1, value2, "ruleShowValue");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsIsNull() {
            addCriterion("monitor_user_ids is null");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsIsNotNull() {
            addCriterion("monitor_user_ids is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsEqualTo(String value) {
            addCriterion("monitor_user_ids =", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsNotEqualTo(String value) {
            addCriterion("monitor_user_ids <>", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsGreaterThan(String value) {
            addCriterion("monitor_user_ids >", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_user_ids >=", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsLessThan(String value) {
            addCriterion("monitor_user_ids <", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsLessThanOrEqualTo(String value) {
            addCriterion("monitor_user_ids <=", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsLike(String value) {
            addCriterion("monitor_user_ids like", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsNotLike(String value) {
            addCriterion("monitor_user_ids not like", value, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsIn(List<String> values) {
            addCriterion("monitor_user_ids in", values, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsNotIn(List<String> values) {
            addCriterion("monitor_user_ids not in", values, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsBetween(String value1, String value2) {
            addCriterion("monitor_user_ids between", value1, value2, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andMonitorUserIdsNotBetween(String value1, String value2) {
            addCriterion("monitor_user_ids not between", value1, value2, "monitorUserIds");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNull() {
            addCriterion("threshold is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNotNull() {
            addCriterion("threshold is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdEqualTo(String value) {
            addCriterion("threshold =", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotEqualTo(String value) {
            addCriterion("threshold <>", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThan(String value) {
            addCriterion("threshold >", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThanOrEqualTo(String value) {
            addCriterion("threshold >=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThan(String value) {
            addCriterion("threshold <", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThanOrEqualTo(String value) {
            addCriterion("threshold <=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLike(String value) {
            addCriterion("threshold like", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotLike(String value) {
            addCriterion("threshold not like", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdIn(List<String> values) {
            addCriterion("threshold in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotIn(List<String> values) {
            addCriterion("threshold not in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdBetween(String value1, String value2) {
            addCriterion("threshold between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotBetween(String value1, String value2) {
            addCriterion("threshold not between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("operation is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("operation is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(String value) {
            addCriterion("operation =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(String value) {
            addCriterion("operation <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(String value) {
            addCriterion("operation >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(String value) {
            addCriterion("operation >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(String value) {
            addCriterion("operation <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(String value) {
            addCriterion("operation <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLike(String value) {
            addCriterion("operation like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotLike(String value) {
            addCriterion("operation not like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<String> values) {
            addCriterion("operation in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<String> values) {
            addCriterion("operation not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(String value1, String value2) {
            addCriterion("operation between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(String value1, String value2) {
            addCriterion("operation not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNull() {
            addCriterion("type_code is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("type_code is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("type_code =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("type_code <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("type_code >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("type_code >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("type_code <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("type_code <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("type_code like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("type_code not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("type_code in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("type_code not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("type_code between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("type_code not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andValIsNull() {
            addCriterion("val is null");
            return (Criteria) this;
        }

        public Criteria andValIsNotNull() {
            addCriterion("val is not null");
            return (Criteria) this;
        }

        public Criteria andValEqualTo(String value) {
            addCriterion("val =", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotEqualTo(String value) {
            addCriterion("val <>", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThan(String value) {
            addCriterion("val >", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThanOrEqualTo(String value) {
            addCriterion("val >=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThan(String value) {
            addCriterion("val <", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThanOrEqualTo(String value) {
            addCriterion("val <=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLike(String value) {
            addCriterion("val like", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotLike(String value) {
            addCriterion("val not like", value, "val");
            return (Criteria) this;
        }

        public Criteria andValIn(List<String> values) {
            addCriterion("val in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValNotIn(List<String> values) {
            addCriterion("val not in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValBetween(String value1, String value2) {
            addCriterion("val between", value1, value2, "val");
            return (Criteria) this;
        }

        public Criteria andValNotBetween(String value1, String value2) {
            addCriterion("val not between", value1, value2, "val");
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