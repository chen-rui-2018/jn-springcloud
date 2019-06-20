package com.jn.park.finance.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFinanceBudgetHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFinanceBudgetHistoryExample() {
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
            addCriterion("bh.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("bh.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("bh.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("bh.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("bh.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bh.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("bh.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("bh.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("bh.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("bh.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("bh.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bh.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdIsNull() {
            addCriterion("bh.cost_type_id is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdIsNotNull() {
            addCriterion("bh.cost_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdEqualTo(String value) {
            addCriterion("bh.cost_type_id =", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotEqualTo(String value) {
            addCriterion("bh.cost_type_id <>", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdGreaterThan(String value) {
            addCriterion("bh.cost_type_id >", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("bh.cost_type_id >=", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdLessThan(String value) {
            addCriterion("bh.cost_type_id <", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdLessThanOrEqualTo(String value) {
            addCriterion("bh.cost_type_id <=", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdLike(String value) {
            addCriterion("bh.cost_type_id like", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotLike(String value) {
            addCriterion("bh.cost_type_id not like", value, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdIn(List<String> values) {
            addCriterion("bh.cost_type_id in", values, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotIn(List<String> values) {
            addCriterion("bh.cost_type_id not in", values, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdBetween(String value1, String value2) {
            addCriterion("bh.cost_type_id between", value1, value2, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIdNotBetween(String value1, String value2) {
            addCriterion("bh.cost_type_id not between", value1, value2, "costTypeId");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameIsNull() {
            addCriterion("bh.cost_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameIsNotNull() {
            addCriterion("bh.cost_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameEqualTo(String value) {
            addCriterion("bh.cost_type_name =", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotEqualTo(String value) {
            addCriterion("bh.cost_type_name <>", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameGreaterThan(String value) {
            addCriterion("bh.cost_type_name >", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("bh.cost_type_name >=", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameLessThan(String value) {
            addCriterion("bh.cost_type_name <", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameLessThanOrEqualTo(String value) {
            addCriterion("bh.cost_type_name <=", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameLike(String value) {
            addCriterion("bh.cost_type_name like", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotLike(String value) {
            addCriterion("bh.cost_type_name not like", value, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameIn(List<String> values) {
            addCriterion("bh.cost_type_name in", values, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotIn(List<String> values) {
            addCriterion("bh.cost_type_name not in", values, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameBetween(String value1, String value2) {
            addCriterion("bh.cost_type_name between", value1, value2, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andCostTypeNameNotBetween(String value1, String value2) {
            addCriterion("bh.cost_type_name not between", value1, value2, "costTypeName");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("bh.department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("bh.department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("bh.department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("bh.department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("bh.department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("bh.department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("bh.department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("bh.department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("bh.department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("bh.department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("bh.department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("bh.department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("bh.department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("bh.department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("bh.department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("bh.department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("bh.department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("bh.department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("bh.department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("bh.department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("bh.department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("bh.department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("bh.department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("bh.department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("bh.department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("bh.department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("bh.department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("bh.department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthIsNull() {
            addCriterion("bh.budget_month is null");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthIsNotNull() {
            addCriterion("bh.budget_month is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthEqualTo(String value) {
            addCriterion("bh.budget_month =", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthNotEqualTo(String value) {
            addCriterion("bh.budget_month <>", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthGreaterThan(String value) {
            addCriterion("bh.budget_month >", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthGreaterThanOrEqualTo(String value) {
            addCriterion("bh.budget_month >=", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthLessThan(String value) {
            addCriterion("bh.budget_month <", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthLessThanOrEqualTo(String value) {
            addCriterion("bh.budget_month <=", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthLike(String value) {
            addCriterion("bh.budget_month like", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthNotLike(String value) {
            addCriterion("bh.budget_month not like", value, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthIn(List<String> values) {
            addCriterion("bh.budget_month in", values, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthNotIn(List<String> values) {
            addCriterion("bh.budget_month not in", values, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthBetween(String value1, String value2) {
            addCriterion("bh.budget_month between", value1, value2, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMonthNotBetween(String value1, String value2) {
            addCriterion("bh.budget_month not between", value1, value2, "budgetMonth");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyIsNull() {
            addCriterion("bh.budget_money is null");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyIsNotNull() {
            addCriterion("bh.budget_money is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyEqualTo(BigDecimal value) {
            addCriterion("bh.budget_money =", value, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyNotEqualTo(BigDecimal value) {
            addCriterion("bh.budget_money <>", value, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyGreaterThan(BigDecimal value) {
            addCriterion("bh.budget_money >", value, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bh.budget_money >=", value, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyLessThan(BigDecimal value) {
            addCriterion("bh.budget_money <", value, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bh.budget_money <=", value, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyIn(List<BigDecimal> values) {
            addCriterion("bh.budget_money in", values, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyNotIn(List<BigDecimal> values) {
            addCriterion("bh.budget_money not in", values, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bh.budget_money between", value1, value2, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bh.budget_money not between", value1, value2, "budgetMoney");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeIsNull() {
            addCriterion("bh.budget_Type is null");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeIsNotNull() {
            addCriterion("bh.budget_Type is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeEqualTo(Byte value) {
            addCriterion("bh.budget_Type =", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNotEqualTo(Byte value) {
            addCriterion("bh.budget_Type <>", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeGreaterThan(Byte value) {
            addCriterion("bh.budget_Type >", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bh.budget_Type >=", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeLessThan(Byte value) {
            addCriterion("bh.budget_Type <", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bh.budget_Type <=", value, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeIn(List<Byte> values) {
            addCriterion("bh.budget_Type in", values, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNotIn(List<Byte> values) {
            addCriterion("bh.budget_Type not in", values, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeBetween(Byte value1, Byte value2) {
            addCriterion("bh.budget_Type between", value1, value2, "budgetType");
            return (Criteria) this;
        }

        public Criteria andBudgetTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bh.budget_Type not between", value1, value2, "budgetType");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("bh.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("bh.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("bh.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("bh.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("bh.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("bh.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("bh.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("bh.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("bh.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("bh.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("bh.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("bh.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("bh.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("bh.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("bh.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("bh.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("bh.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bh.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("bh.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("bh.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("bh.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("bh.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("bh.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("bh.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("bh.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("bh.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("bh.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("bh.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("bh.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bh.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("bh.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("bh.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("bh.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("bh.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("bh.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("bh.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("bh.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("bh.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("bh.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("bh.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("bh.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("bh.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("bh.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bh.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("bh.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("bh.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("bh.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("bh.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("bh.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("bh.modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("bh.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("bh.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("bh.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("bh.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("bh.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bh.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("bh.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("bh.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("bh.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("bh.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("bh.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("bh.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("bh.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("bh.creator_account not between", value1, value2, "creatorAccount");
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