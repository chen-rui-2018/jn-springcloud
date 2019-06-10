package com.jn.park.finance.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFinanceExpensesTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFinanceExpensesTempExample() {
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
            addCriterion("etemp.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("etemp.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("etemp.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("etemp.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("etemp.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("etemp.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("etemp.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("etemp.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("etemp.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("etemp.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("etemp.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("etemp.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeIsNull() {
            addCriterion("etemp.cost_happend_time is null");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeIsNotNull() {
            addCriterion("etemp.cost_happend_time is not null");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeEqualTo(String value) {
            addCriterion("etemp.cost_happend_time =", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeNotEqualTo(String value) {
            addCriterion("etemp.cost_happend_time <>", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeGreaterThan(String value) {
            addCriterion("etemp.cost_happend_time >", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.cost_happend_time >=", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeLessThan(String value) {
            addCriterion("etemp.cost_happend_time <", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeLessThanOrEqualTo(String value) {
            addCriterion("etemp.cost_happend_time <=", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeLike(String value) {
            addCriterion("etemp.cost_happend_time like", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeNotLike(String value) {
            addCriterion("etemp.cost_happend_time not like", value, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeIn(List<String> values) {
            addCriterion("etemp.cost_happend_time in", values, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeNotIn(List<String> values) {
            addCriterion("etemp.cost_happend_time not in", values, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeBetween(String value1, String value2) {
            addCriterion("etemp.cost_happend_time between", value1, value2, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostHappendTimeNotBetween(String value1, String value2) {
            addCriterion("etemp.cost_happend_time not between", value1, value2, "costHappendTime");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("etemp.cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("etemp.cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("etemp.cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("etemp.cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("etemp.cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("etemp.cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("etemp.cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("etemp.cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("etemp.cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("etemp.cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("etemp.cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("etemp.cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIdIsNull() {
            addCriterion("etemp.cost_id is null");
            return (Criteria) this;
        }

        public Criteria andCostIdIsNotNull() {
            addCriterion("etemp.cost_id is not null");
            return (Criteria) this;
        }

        public Criteria andCostIdEqualTo(String value) {
            addCriterion("etemp.cost_id =", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotEqualTo(String value) {
            addCriterion("etemp.cost_id <>", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdGreaterThan(String value) {
            addCriterion("etemp.cost_id >", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.cost_id >=", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdLessThan(String value) {
            addCriterion("etemp.cost_id <", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdLessThanOrEqualTo(String value) {
            addCriterion("etemp.cost_id <=", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdLike(String value) {
            addCriterion("etemp.cost_id like", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotLike(String value) {
            addCriterion("etemp.cost_id not like", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdIn(List<String> values) {
            addCriterion("etemp.cost_id in", values, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotIn(List<String> values) {
            addCriterion("etemp.cost_id not in", values, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdBetween(String value1, String value2) {
            addCriterion("etemp.cost_id between", value1, value2, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotBetween(String value1, String value2) {
            addCriterion("etemp.cost_id not between", value1, value2, "costId");
            return (Criteria) this;
        }

        public Criteria andExcelIdIsNull() {
            addCriterion("etemp.excel_id is null");
            return (Criteria) this;
        }

        public Criteria andExcelIdIsNotNull() {
            addCriterion("etemp.excel_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcelIdEqualTo(String value) {
            addCriterion("etemp.excel_id =", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotEqualTo(String value) {
            addCriterion("etemp.excel_id <>", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdGreaterThan(String value) {
            addCriterion("etemp.excel_id >", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.excel_id >=", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLessThan(String value) {
            addCriterion("etemp.excel_id <", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLessThanOrEqualTo(String value) {
            addCriterion("etemp.excel_id <=", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLike(String value) {
            addCriterion("etemp.excel_id like", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotLike(String value) {
            addCriterion("etemp.excel_id not like", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdIn(List<String> values) {
            addCriterion("etemp.excel_id in", values, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotIn(List<String> values) {
            addCriterion("etemp.excel_id not in", values, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdBetween(String value1, String value2) {
            addCriterion("etemp.excel_id between", value1, value2, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotBetween(String value1, String value2) {
            addCriterion("etemp.excel_id not between", value1, value2, "excelId");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameIsNull() {
            addCriterion("etemp.cost_before_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameIsNotNull() {
            addCriterion("etemp.cost_before_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameEqualTo(String value) {
            addCriterion("etemp.cost_before_type_name =", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameNotEqualTo(String value) {
            addCriterion("etemp.cost_before_type_name <>", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameGreaterThan(String value) {
            addCriterion("etemp.cost_before_type_name >", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.cost_before_type_name >=", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameLessThan(String value) {
            addCriterion("etemp.cost_before_type_name <", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameLessThanOrEqualTo(String value) {
            addCriterion("etemp.cost_before_type_name <=", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameLike(String value) {
            addCriterion("etemp.cost_before_type_name like", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameNotLike(String value) {
            addCriterion("etemp.cost_before_type_name not like", value, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameIn(List<String> values) {
            addCriterion("etemp.cost_before_type_name in", values, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameNotIn(List<String> values) {
            addCriterion("etemp.cost_before_type_name not in", values, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameBetween(String value1, String value2) {
            addCriterion("etemp.cost_before_type_name between", value1, value2, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostBeforeTypeNameNotBetween(String value1, String value2) {
            addCriterion("etemp.cost_before_type_name not between", value1, value2, "costBeforeTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdIsNull() {
            addCriterion("etemp.cost_after_type_id is null");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdIsNotNull() {
            addCriterion("etemp.cost_after_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdEqualTo(String value) {
            addCriterion("etemp.cost_after_type_id =", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdNotEqualTo(String value) {
            addCriterion("etemp.cost_after_type_id <>", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdGreaterThan(String value) {
            addCriterion("etemp.cost_after_type_id >", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.cost_after_type_id >=", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdLessThan(String value) {
            addCriterion("etemp.cost_after_type_id <", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdLessThanOrEqualTo(String value) {
            addCriterion("etemp.cost_after_type_id <=", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdLike(String value) {
            addCriterion("etemp.cost_after_type_id like", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdNotLike(String value) {
            addCriterion("etemp.cost_after_type_id not like", value, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdIn(List<String> values) {
            addCriterion("etemp.cost_after_type_id in", values, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdNotIn(List<String> values) {
            addCriterion("etemp.cost_after_type_id not in", values, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdBetween(String value1, String value2) {
            addCriterion("etemp.cost_after_type_id between", value1, value2, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeIdNotBetween(String value1, String value2) {
            addCriterion("etemp.cost_after_type_id not between", value1, value2, "costAfterTypeId");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameIsNull() {
            addCriterion("etemp.cost_after_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameIsNotNull() {
            addCriterion("etemp.cost_after_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameEqualTo(String value) {
            addCriterion("etemp.cost_after_type_name =", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameNotEqualTo(String value) {
            addCriterion("etemp.cost_after_type_name <>", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameGreaterThan(String value) {
            addCriterion("etemp.cost_after_type_name >", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.cost_after_type_name >=", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameLessThan(String value) {
            addCriterion("etemp.cost_after_type_name <", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameLessThanOrEqualTo(String value) {
            addCriterion("etemp.cost_after_type_name <=", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameLike(String value) {
            addCriterion("etemp.cost_after_type_name like", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameNotLike(String value) {
            addCriterion("etemp.cost_after_type_name not like", value, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameIn(List<String> values) {
            addCriterion("etemp.cost_after_type_name in", values, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameNotIn(List<String> values) {
            addCriterion("etemp.cost_after_type_name not in", values, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameBetween(String value1, String value2) {
            addCriterion("etemp.cost_after_type_name between", value1, value2, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andCostAfterTypeNameNotBetween(String value1, String value2) {
            addCriterion("etemp.cost_after_type_name not between", value1, value2, "costAfterTypeName");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("etemp.department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("etemp.department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("etemp.department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("etemp.department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("etemp.department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("etemp.department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("etemp.department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("etemp.department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("etemp.department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("etemp.department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("etemp.department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("etemp.department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("etemp.department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("etemp.department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("etemp.department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("etemp.department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("etemp.department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("etemp.department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("etemp.department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("etemp.department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("etemp.department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("etemp.department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("etemp.department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("etemp.department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("etemp.department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("etemp.department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("etemp.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("etemp.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("etemp.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("etemp.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("etemp.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("etemp.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("etemp.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("etemp.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("etemp.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("etemp.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("etemp.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("etemp.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("etemp.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("etemp.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("etemp.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("etemp.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("etemp.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("etemp.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("etemp.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("etemp.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("etemp.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("etemp.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("etemp.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("etemp.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("etemp.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("etemp.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("etemp.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("etemp.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("etemp.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("etemp.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etemp.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("etemp.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("etemp.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("etemp.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("etemp.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("etemp.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("etemp.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("etemp.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("etemp.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("etemp.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("etemp.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("etemp.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("etemp.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("etemp.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("etemp.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("etemp.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("etemp.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("etemp.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("etemp.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("etemp.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("etemp.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("etemp.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("etemp.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("etemp.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("etemp.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("etemp.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("etemp.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("etemp.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("etemp.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("etemp.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("etemp.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("etemp.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("etemp.modified_time not between", value1, value2, "modifiedTime");
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