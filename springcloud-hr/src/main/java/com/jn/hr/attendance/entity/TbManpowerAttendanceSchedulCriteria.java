package com.jn.hr.attendance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerAttendanceSchedulCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAttendanceSchedulCriteria() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthIsNull() {
            addCriterion("schedul_month is null");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthIsNotNull() {
            addCriterion("schedul_month is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthEqualTo(String value) {
            addCriterion("schedul_month =", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthNotEqualTo(String value) {
            addCriterion("schedul_month <>", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthGreaterThan(String value) {
            addCriterion("schedul_month >", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthGreaterThanOrEqualTo(String value) {
            addCriterion("schedul_month >=", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthLessThan(String value) {
            addCriterion("schedul_month <", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthLessThanOrEqualTo(String value) {
            addCriterion("schedul_month <=", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthLike(String value) {
            addCriterion("schedul_month like", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthNotLike(String value) {
            addCriterion("schedul_month not like", value, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthIn(List<String> values) {
            addCriterion("schedul_month in", values, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthNotIn(List<String> values) {
            addCriterion("schedul_month not in", values, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthBetween(String value1, String value2) {
            addCriterion("schedul_month between", value1, value2, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andSchedulMonthNotBetween(String value1, String value2) {
            addCriterion("schedul_month not between", value1, value2, "schedulMonth");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNull() {
            addCriterion("job_number is null");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNotNull() {
            addCriterion("job_number is not null");
            return (Criteria) this;
        }

        public Criteria andJobNumberEqualTo(String value) {
            addCriterion("job_number =", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotEqualTo(String value) {
            addCriterion("job_number <>", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThan(String value) {
            addCriterion("job_number >", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThanOrEqualTo(String value) {
            addCriterion("job_number >=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThan(String value) {
            addCriterion("job_number <", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThanOrEqualTo(String value) {
            addCriterion("job_number <=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLike(String value) {
            addCriterion("job_number like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotLike(String value) {
            addCriterion("job_number not like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberIn(List<String> values) {
            addCriterion("job_number in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotIn(List<String> values) {
            addCriterion("job_number not in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberBetween(String value1, String value2) {
            addCriterion("job_number between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotBetween(String value1, String value2) {
            addCriterion("job_number not between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNumber1IsNull() {
            addCriterion("number_1 is null");
            return (Criteria) this;
        }

        public Criteria andNumber1IsNotNull() {
            addCriterion("number_1 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber1EqualTo(Integer value) {
            addCriterion("number_1 =", value, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1NotEqualTo(Integer value) {
            addCriterion("number_1 <>", value, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1GreaterThan(Integer value) {
            addCriterion("number_1 >", value, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_1 >=", value, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1LessThan(Integer value) {
            addCriterion("number_1 <", value, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1LessThanOrEqualTo(Integer value) {
            addCriterion("number_1 <=", value, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1In(List<Integer> values) {
            addCriterion("number_1 in", values, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1NotIn(List<Integer> values) {
            addCriterion("number_1 not in", values, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1Between(Integer value1, Integer value2) {
            addCriterion("number_1 between", value1, value2, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber1NotBetween(Integer value1, Integer value2) {
            addCriterion("number_1 not between", value1, value2, "number1");
            return (Criteria) this;
        }

        public Criteria andNumber2IsNull() {
            addCriterion("number_2 is null");
            return (Criteria) this;
        }

        public Criteria andNumber2IsNotNull() {
            addCriterion("number_2 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber2EqualTo(Integer value) {
            addCriterion("number_2 =", value, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2NotEqualTo(Integer value) {
            addCriterion("number_2 <>", value, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2GreaterThan(Integer value) {
            addCriterion("number_2 >", value, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_2 >=", value, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2LessThan(Integer value) {
            addCriterion("number_2 <", value, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2LessThanOrEqualTo(Integer value) {
            addCriterion("number_2 <=", value, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2In(List<Integer> values) {
            addCriterion("number_2 in", values, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2NotIn(List<Integer> values) {
            addCriterion("number_2 not in", values, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2Between(Integer value1, Integer value2) {
            addCriterion("number_2 between", value1, value2, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber2NotBetween(Integer value1, Integer value2) {
            addCriterion("number_2 not between", value1, value2, "number2");
            return (Criteria) this;
        }

        public Criteria andNumber3IsNull() {
            addCriterion("number_3 is null");
            return (Criteria) this;
        }

        public Criteria andNumber3IsNotNull() {
            addCriterion("number_3 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber3EqualTo(Integer value) {
            addCriterion("number_3 =", value, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3NotEqualTo(Integer value) {
            addCriterion("number_3 <>", value, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3GreaterThan(Integer value) {
            addCriterion("number_3 >", value, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_3 >=", value, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3LessThan(Integer value) {
            addCriterion("number_3 <", value, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3LessThanOrEqualTo(Integer value) {
            addCriterion("number_3 <=", value, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3In(List<Integer> values) {
            addCriterion("number_3 in", values, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3NotIn(List<Integer> values) {
            addCriterion("number_3 not in", values, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3Between(Integer value1, Integer value2) {
            addCriterion("number_3 between", value1, value2, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber3NotBetween(Integer value1, Integer value2) {
            addCriterion("number_3 not between", value1, value2, "number3");
            return (Criteria) this;
        }

        public Criteria andNumber4IsNull() {
            addCriterion("number_4 is null");
            return (Criteria) this;
        }

        public Criteria andNumber4IsNotNull() {
            addCriterion("number_4 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber4EqualTo(Integer value) {
            addCriterion("number_4 =", value, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4NotEqualTo(Integer value) {
            addCriterion("number_4 <>", value, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4GreaterThan(Integer value) {
            addCriterion("number_4 >", value, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_4 >=", value, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4LessThan(Integer value) {
            addCriterion("number_4 <", value, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4LessThanOrEqualTo(Integer value) {
            addCriterion("number_4 <=", value, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4In(List<Integer> values) {
            addCriterion("number_4 in", values, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4NotIn(List<Integer> values) {
            addCriterion("number_4 not in", values, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4Between(Integer value1, Integer value2) {
            addCriterion("number_4 between", value1, value2, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber4NotBetween(Integer value1, Integer value2) {
            addCriterion("number_4 not between", value1, value2, "number4");
            return (Criteria) this;
        }

        public Criteria andNumber5IsNull() {
            addCriterion("number_5 is null");
            return (Criteria) this;
        }

        public Criteria andNumber5IsNotNull() {
            addCriterion("number_5 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber5EqualTo(Integer value) {
            addCriterion("number_5 =", value, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5NotEqualTo(Integer value) {
            addCriterion("number_5 <>", value, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5GreaterThan(Integer value) {
            addCriterion("number_5 >", value, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_5 >=", value, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5LessThan(Integer value) {
            addCriterion("number_5 <", value, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5LessThanOrEqualTo(Integer value) {
            addCriterion("number_5 <=", value, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5In(List<Integer> values) {
            addCriterion("number_5 in", values, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5NotIn(List<Integer> values) {
            addCriterion("number_5 not in", values, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5Between(Integer value1, Integer value2) {
            addCriterion("number_5 between", value1, value2, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber5NotBetween(Integer value1, Integer value2) {
            addCriterion("number_5 not between", value1, value2, "number5");
            return (Criteria) this;
        }

        public Criteria andNumber6IsNull() {
            addCriterion("number_6 is null");
            return (Criteria) this;
        }

        public Criteria andNumber6IsNotNull() {
            addCriterion("number_6 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber6EqualTo(Integer value) {
            addCriterion("number_6 =", value, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6NotEqualTo(Integer value) {
            addCriterion("number_6 <>", value, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6GreaterThan(Integer value) {
            addCriterion("number_6 >", value, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_6 >=", value, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6LessThan(Integer value) {
            addCriterion("number_6 <", value, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6LessThanOrEqualTo(Integer value) {
            addCriterion("number_6 <=", value, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6In(List<Integer> values) {
            addCriterion("number_6 in", values, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6NotIn(List<Integer> values) {
            addCriterion("number_6 not in", values, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6Between(Integer value1, Integer value2) {
            addCriterion("number_6 between", value1, value2, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber6NotBetween(Integer value1, Integer value2) {
            addCriterion("number_6 not between", value1, value2, "number6");
            return (Criteria) this;
        }

        public Criteria andNumber7IsNull() {
            addCriterion("number_7 is null");
            return (Criteria) this;
        }

        public Criteria andNumber7IsNotNull() {
            addCriterion("number_7 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber7EqualTo(Integer value) {
            addCriterion("number_7 =", value, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7NotEqualTo(Integer value) {
            addCriterion("number_7 <>", value, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7GreaterThan(Integer value) {
            addCriterion("number_7 >", value, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_7 >=", value, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7LessThan(Integer value) {
            addCriterion("number_7 <", value, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7LessThanOrEqualTo(Integer value) {
            addCriterion("number_7 <=", value, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7In(List<Integer> values) {
            addCriterion("number_7 in", values, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7NotIn(List<Integer> values) {
            addCriterion("number_7 not in", values, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7Between(Integer value1, Integer value2) {
            addCriterion("number_7 between", value1, value2, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber7NotBetween(Integer value1, Integer value2) {
            addCriterion("number_7 not between", value1, value2, "number7");
            return (Criteria) this;
        }

        public Criteria andNumber8IsNull() {
            addCriterion("number_8 is null");
            return (Criteria) this;
        }

        public Criteria andNumber8IsNotNull() {
            addCriterion("number_8 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber8EqualTo(Integer value) {
            addCriterion("number_8 =", value, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8NotEqualTo(Integer value) {
            addCriterion("number_8 <>", value, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8GreaterThan(Integer value) {
            addCriterion("number_8 >", value, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_8 >=", value, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8LessThan(Integer value) {
            addCriterion("number_8 <", value, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8LessThanOrEqualTo(Integer value) {
            addCriterion("number_8 <=", value, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8In(List<Integer> values) {
            addCriterion("number_8 in", values, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8NotIn(List<Integer> values) {
            addCriterion("number_8 not in", values, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8Between(Integer value1, Integer value2) {
            addCriterion("number_8 between", value1, value2, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber8NotBetween(Integer value1, Integer value2) {
            addCriterion("number_8 not between", value1, value2, "number8");
            return (Criteria) this;
        }

        public Criteria andNumber9IsNull() {
            addCriterion("number_9 is null");
            return (Criteria) this;
        }

        public Criteria andNumber9IsNotNull() {
            addCriterion("number_9 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber9EqualTo(Integer value) {
            addCriterion("number_9 =", value, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9NotEqualTo(Integer value) {
            addCriterion("number_9 <>", value, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9GreaterThan(Integer value) {
            addCriterion("number_9 >", value, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_9 >=", value, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9LessThan(Integer value) {
            addCriterion("number_9 <", value, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9LessThanOrEqualTo(Integer value) {
            addCriterion("number_9 <=", value, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9In(List<Integer> values) {
            addCriterion("number_9 in", values, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9NotIn(List<Integer> values) {
            addCriterion("number_9 not in", values, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9Between(Integer value1, Integer value2) {
            addCriterion("number_9 between", value1, value2, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber9NotBetween(Integer value1, Integer value2) {
            addCriterion("number_9 not between", value1, value2, "number9");
            return (Criteria) this;
        }

        public Criteria andNumber10IsNull() {
            addCriterion("number_10 is null");
            return (Criteria) this;
        }

        public Criteria andNumber10IsNotNull() {
            addCriterion("number_10 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber10EqualTo(Integer value) {
            addCriterion("number_10 =", value, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10NotEqualTo(Integer value) {
            addCriterion("number_10 <>", value, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10GreaterThan(Integer value) {
            addCriterion("number_10 >", value, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_10 >=", value, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10LessThan(Integer value) {
            addCriterion("number_10 <", value, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10LessThanOrEqualTo(Integer value) {
            addCriterion("number_10 <=", value, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10In(List<Integer> values) {
            addCriterion("number_10 in", values, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10NotIn(List<Integer> values) {
            addCriterion("number_10 not in", values, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10Between(Integer value1, Integer value2) {
            addCriterion("number_10 between", value1, value2, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber10NotBetween(Integer value1, Integer value2) {
            addCriterion("number_10 not between", value1, value2, "number10");
            return (Criteria) this;
        }

        public Criteria andNumber11IsNull() {
            addCriterion("number_11 is null");
            return (Criteria) this;
        }

        public Criteria andNumber11IsNotNull() {
            addCriterion("number_11 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber11EqualTo(Integer value) {
            addCriterion("number_11 =", value, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11NotEqualTo(Integer value) {
            addCriterion("number_11 <>", value, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11GreaterThan(Integer value) {
            addCriterion("number_11 >", value, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_11 >=", value, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11LessThan(Integer value) {
            addCriterion("number_11 <", value, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11LessThanOrEqualTo(Integer value) {
            addCriterion("number_11 <=", value, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11In(List<Integer> values) {
            addCriterion("number_11 in", values, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11NotIn(List<Integer> values) {
            addCriterion("number_11 not in", values, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11Between(Integer value1, Integer value2) {
            addCriterion("number_11 between", value1, value2, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber11NotBetween(Integer value1, Integer value2) {
            addCriterion("number_11 not between", value1, value2, "number11");
            return (Criteria) this;
        }

        public Criteria andNumber12IsNull() {
            addCriterion("number_12 is null");
            return (Criteria) this;
        }

        public Criteria andNumber12IsNotNull() {
            addCriterion("number_12 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber12EqualTo(Integer value) {
            addCriterion("number_12 =", value, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12NotEqualTo(Integer value) {
            addCriterion("number_12 <>", value, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12GreaterThan(Integer value) {
            addCriterion("number_12 >", value, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_12 >=", value, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12LessThan(Integer value) {
            addCriterion("number_12 <", value, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12LessThanOrEqualTo(Integer value) {
            addCriterion("number_12 <=", value, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12In(List<Integer> values) {
            addCriterion("number_12 in", values, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12NotIn(List<Integer> values) {
            addCriterion("number_12 not in", values, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12Between(Integer value1, Integer value2) {
            addCriterion("number_12 between", value1, value2, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber12NotBetween(Integer value1, Integer value2) {
            addCriterion("number_12 not between", value1, value2, "number12");
            return (Criteria) this;
        }

        public Criteria andNumber13IsNull() {
            addCriterion("number_13 is null");
            return (Criteria) this;
        }

        public Criteria andNumber13IsNotNull() {
            addCriterion("number_13 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber13EqualTo(Integer value) {
            addCriterion("number_13 =", value, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13NotEqualTo(Integer value) {
            addCriterion("number_13 <>", value, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13GreaterThan(Integer value) {
            addCriterion("number_13 >", value, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_13 >=", value, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13LessThan(Integer value) {
            addCriterion("number_13 <", value, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13LessThanOrEqualTo(Integer value) {
            addCriterion("number_13 <=", value, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13In(List<Integer> values) {
            addCriterion("number_13 in", values, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13NotIn(List<Integer> values) {
            addCriterion("number_13 not in", values, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13Between(Integer value1, Integer value2) {
            addCriterion("number_13 between", value1, value2, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber13NotBetween(Integer value1, Integer value2) {
            addCriterion("number_13 not between", value1, value2, "number13");
            return (Criteria) this;
        }

        public Criteria andNumber14IsNull() {
            addCriterion("number_14 is null");
            return (Criteria) this;
        }

        public Criteria andNumber14IsNotNull() {
            addCriterion("number_14 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber14EqualTo(Integer value) {
            addCriterion("number_14 =", value, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14NotEqualTo(Integer value) {
            addCriterion("number_14 <>", value, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14GreaterThan(Integer value) {
            addCriterion("number_14 >", value, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_14 >=", value, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14LessThan(Integer value) {
            addCriterion("number_14 <", value, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14LessThanOrEqualTo(Integer value) {
            addCriterion("number_14 <=", value, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14In(List<Integer> values) {
            addCriterion("number_14 in", values, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14NotIn(List<Integer> values) {
            addCriterion("number_14 not in", values, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14Between(Integer value1, Integer value2) {
            addCriterion("number_14 between", value1, value2, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber14NotBetween(Integer value1, Integer value2) {
            addCriterion("number_14 not between", value1, value2, "number14");
            return (Criteria) this;
        }

        public Criteria andNumber15IsNull() {
            addCriterion("number_15 is null");
            return (Criteria) this;
        }

        public Criteria andNumber15IsNotNull() {
            addCriterion("number_15 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber15EqualTo(Integer value) {
            addCriterion("number_15 =", value, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15NotEqualTo(Integer value) {
            addCriterion("number_15 <>", value, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15GreaterThan(Integer value) {
            addCriterion("number_15 >", value, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_15 >=", value, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15LessThan(Integer value) {
            addCriterion("number_15 <", value, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15LessThanOrEqualTo(Integer value) {
            addCriterion("number_15 <=", value, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15In(List<Integer> values) {
            addCriterion("number_15 in", values, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15NotIn(List<Integer> values) {
            addCriterion("number_15 not in", values, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15Between(Integer value1, Integer value2) {
            addCriterion("number_15 between", value1, value2, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber15NotBetween(Integer value1, Integer value2) {
            addCriterion("number_15 not between", value1, value2, "number15");
            return (Criteria) this;
        }

        public Criteria andNumber16IsNull() {
            addCriterion("number_16 is null");
            return (Criteria) this;
        }

        public Criteria andNumber16IsNotNull() {
            addCriterion("number_16 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber16EqualTo(Integer value) {
            addCriterion("number_16 =", value, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16NotEqualTo(Integer value) {
            addCriterion("number_16 <>", value, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16GreaterThan(Integer value) {
            addCriterion("number_16 >", value, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_16 >=", value, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16LessThan(Integer value) {
            addCriterion("number_16 <", value, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16LessThanOrEqualTo(Integer value) {
            addCriterion("number_16 <=", value, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16In(List<Integer> values) {
            addCriterion("number_16 in", values, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16NotIn(List<Integer> values) {
            addCriterion("number_16 not in", values, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16Between(Integer value1, Integer value2) {
            addCriterion("number_16 between", value1, value2, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber16NotBetween(Integer value1, Integer value2) {
            addCriterion("number_16 not between", value1, value2, "number16");
            return (Criteria) this;
        }

        public Criteria andNumber17IsNull() {
            addCriterion("number_17 is null");
            return (Criteria) this;
        }

        public Criteria andNumber17IsNotNull() {
            addCriterion("number_17 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber17EqualTo(Integer value) {
            addCriterion("number_17 =", value, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17NotEqualTo(Integer value) {
            addCriterion("number_17 <>", value, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17GreaterThan(Integer value) {
            addCriterion("number_17 >", value, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_17 >=", value, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17LessThan(Integer value) {
            addCriterion("number_17 <", value, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17LessThanOrEqualTo(Integer value) {
            addCriterion("number_17 <=", value, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17In(List<Integer> values) {
            addCriterion("number_17 in", values, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17NotIn(List<Integer> values) {
            addCriterion("number_17 not in", values, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17Between(Integer value1, Integer value2) {
            addCriterion("number_17 between", value1, value2, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber17NotBetween(Integer value1, Integer value2) {
            addCriterion("number_17 not between", value1, value2, "number17");
            return (Criteria) this;
        }

        public Criteria andNumber18IsNull() {
            addCriterion("number_18 is null");
            return (Criteria) this;
        }

        public Criteria andNumber18IsNotNull() {
            addCriterion("number_18 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber18EqualTo(Integer value) {
            addCriterion("number_18 =", value, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18NotEqualTo(Integer value) {
            addCriterion("number_18 <>", value, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18GreaterThan(Integer value) {
            addCriterion("number_18 >", value, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_18 >=", value, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18LessThan(Integer value) {
            addCriterion("number_18 <", value, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18LessThanOrEqualTo(Integer value) {
            addCriterion("number_18 <=", value, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18In(List<Integer> values) {
            addCriterion("number_18 in", values, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18NotIn(List<Integer> values) {
            addCriterion("number_18 not in", values, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18Between(Integer value1, Integer value2) {
            addCriterion("number_18 between", value1, value2, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber18NotBetween(Integer value1, Integer value2) {
            addCriterion("number_18 not between", value1, value2, "number18");
            return (Criteria) this;
        }

        public Criteria andNumber19IsNull() {
            addCriterion("number_19 is null");
            return (Criteria) this;
        }

        public Criteria andNumber19IsNotNull() {
            addCriterion("number_19 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber19EqualTo(Integer value) {
            addCriterion("number_19 =", value, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19NotEqualTo(Integer value) {
            addCriterion("number_19 <>", value, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19GreaterThan(Integer value) {
            addCriterion("number_19 >", value, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_19 >=", value, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19LessThan(Integer value) {
            addCriterion("number_19 <", value, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19LessThanOrEqualTo(Integer value) {
            addCriterion("number_19 <=", value, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19In(List<Integer> values) {
            addCriterion("number_19 in", values, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19NotIn(List<Integer> values) {
            addCriterion("number_19 not in", values, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19Between(Integer value1, Integer value2) {
            addCriterion("number_19 between", value1, value2, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber19NotBetween(Integer value1, Integer value2) {
            addCriterion("number_19 not between", value1, value2, "number19");
            return (Criteria) this;
        }

        public Criteria andNumber20IsNull() {
            addCriterion("number_20 is null");
            return (Criteria) this;
        }

        public Criteria andNumber20IsNotNull() {
            addCriterion("number_20 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber20EqualTo(Integer value) {
            addCriterion("number_20 =", value, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20NotEqualTo(Integer value) {
            addCriterion("number_20 <>", value, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20GreaterThan(Integer value) {
            addCriterion("number_20 >", value, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_20 >=", value, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20LessThan(Integer value) {
            addCriterion("number_20 <", value, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20LessThanOrEqualTo(Integer value) {
            addCriterion("number_20 <=", value, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20In(List<Integer> values) {
            addCriterion("number_20 in", values, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20NotIn(List<Integer> values) {
            addCriterion("number_20 not in", values, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20Between(Integer value1, Integer value2) {
            addCriterion("number_20 between", value1, value2, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber20NotBetween(Integer value1, Integer value2) {
            addCriterion("number_20 not between", value1, value2, "number20");
            return (Criteria) this;
        }

        public Criteria andNumber21IsNull() {
            addCriterion("number_21 is null");
            return (Criteria) this;
        }

        public Criteria andNumber21IsNotNull() {
            addCriterion("number_21 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber21EqualTo(Integer value) {
            addCriterion("number_21 =", value, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21NotEqualTo(Integer value) {
            addCriterion("number_21 <>", value, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21GreaterThan(Integer value) {
            addCriterion("number_21 >", value, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_21 >=", value, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21LessThan(Integer value) {
            addCriterion("number_21 <", value, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21LessThanOrEqualTo(Integer value) {
            addCriterion("number_21 <=", value, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21In(List<Integer> values) {
            addCriterion("number_21 in", values, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21NotIn(List<Integer> values) {
            addCriterion("number_21 not in", values, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21Between(Integer value1, Integer value2) {
            addCriterion("number_21 between", value1, value2, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber21NotBetween(Integer value1, Integer value2) {
            addCriterion("number_21 not between", value1, value2, "number21");
            return (Criteria) this;
        }

        public Criteria andNumber22IsNull() {
            addCriterion("number_22 is null");
            return (Criteria) this;
        }

        public Criteria andNumber22IsNotNull() {
            addCriterion("number_22 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber22EqualTo(Integer value) {
            addCriterion("number_22 =", value, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22NotEqualTo(Integer value) {
            addCriterion("number_22 <>", value, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22GreaterThan(Integer value) {
            addCriterion("number_22 >", value, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_22 >=", value, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22LessThan(Integer value) {
            addCriterion("number_22 <", value, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22LessThanOrEqualTo(Integer value) {
            addCriterion("number_22 <=", value, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22In(List<Integer> values) {
            addCriterion("number_22 in", values, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22NotIn(List<Integer> values) {
            addCriterion("number_22 not in", values, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22Between(Integer value1, Integer value2) {
            addCriterion("number_22 between", value1, value2, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber22NotBetween(Integer value1, Integer value2) {
            addCriterion("number_22 not between", value1, value2, "number22");
            return (Criteria) this;
        }

        public Criteria andNumber23IsNull() {
            addCriterion("number_23 is null");
            return (Criteria) this;
        }

        public Criteria andNumber23IsNotNull() {
            addCriterion("number_23 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber23EqualTo(Integer value) {
            addCriterion("number_23 =", value, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23NotEqualTo(Integer value) {
            addCriterion("number_23 <>", value, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23GreaterThan(Integer value) {
            addCriterion("number_23 >", value, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_23 >=", value, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23LessThan(Integer value) {
            addCriterion("number_23 <", value, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23LessThanOrEqualTo(Integer value) {
            addCriterion("number_23 <=", value, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23In(List<Integer> values) {
            addCriterion("number_23 in", values, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23NotIn(List<Integer> values) {
            addCriterion("number_23 not in", values, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23Between(Integer value1, Integer value2) {
            addCriterion("number_23 between", value1, value2, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber23NotBetween(Integer value1, Integer value2) {
            addCriterion("number_23 not between", value1, value2, "number23");
            return (Criteria) this;
        }

        public Criteria andNumber24IsNull() {
            addCriterion("number_24 is null");
            return (Criteria) this;
        }

        public Criteria andNumber24IsNotNull() {
            addCriterion("number_24 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber24EqualTo(Integer value) {
            addCriterion("number_24 =", value, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24NotEqualTo(Integer value) {
            addCriterion("number_24 <>", value, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24GreaterThan(Integer value) {
            addCriterion("number_24 >", value, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_24 >=", value, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24LessThan(Integer value) {
            addCriterion("number_24 <", value, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24LessThanOrEqualTo(Integer value) {
            addCriterion("number_24 <=", value, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24In(List<Integer> values) {
            addCriterion("number_24 in", values, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24NotIn(List<Integer> values) {
            addCriterion("number_24 not in", values, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24Between(Integer value1, Integer value2) {
            addCriterion("number_24 between", value1, value2, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber24NotBetween(Integer value1, Integer value2) {
            addCriterion("number_24 not between", value1, value2, "number24");
            return (Criteria) this;
        }

        public Criteria andNumber25IsNull() {
            addCriterion("number_25 is null");
            return (Criteria) this;
        }

        public Criteria andNumber25IsNotNull() {
            addCriterion("number_25 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber25EqualTo(Integer value) {
            addCriterion("number_25 =", value, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25NotEqualTo(Integer value) {
            addCriterion("number_25 <>", value, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25GreaterThan(Integer value) {
            addCriterion("number_25 >", value, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_25 >=", value, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25LessThan(Integer value) {
            addCriterion("number_25 <", value, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25LessThanOrEqualTo(Integer value) {
            addCriterion("number_25 <=", value, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25In(List<Integer> values) {
            addCriterion("number_25 in", values, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25NotIn(List<Integer> values) {
            addCriterion("number_25 not in", values, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25Between(Integer value1, Integer value2) {
            addCriterion("number_25 between", value1, value2, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber25NotBetween(Integer value1, Integer value2) {
            addCriterion("number_25 not between", value1, value2, "number25");
            return (Criteria) this;
        }

        public Criteria andNumber26IsNull() {
            addCriterion("number_26 is null");
            return (Criteria) this;
        }

        public Criteria andNumber26IsNotNull() {
            addCriterion("number_26 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber26EqualTo(Integer value) {
            addCriterion("number_26 =", value, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26NotEqualTo(Integer value) {
            addCriterion("number_26 <>", value, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26GreaterThan(Integer value) {
            addCriterion("number_26 >", value, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_26 >=", value, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26LessThan(Integer value) {
            addCriterion("number_26 <", value, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26LessThanOrEqualTo(Integer value) {
            addCriterion("number_26 <=", value, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26In(List<Integer> values) {
            addCriterion("number_26 in", values, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26NotIn(List<Integer> values) {
            addCriterion("number_26 not in", values, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26Between(Integer value1, Integer value2) {
            addCriterion("number_26 between", value1, value2, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber26NotBetween(Integer value1, Integer value2) {
            addCriterion("number_26 not between", value1, value2, "number26");
            return (Criteria) this;
        }

        public Criteria andNumber27IsNull() {
            addCriterion("number_27 is null");
            return (Criteria) this;
        }

        public Criteria andNumber27IsNotNull() {
            addCriterion("number_27 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber27EqualTo(Integer value) {
            addCriterion("number_27 =", value, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27NotEqualTo(Integer value) {
            addCriterion("number_27 <>", value, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27GreaterThan(Integer value) {
            addCriterion("number_27 >", value, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_27 >=", value, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27LessThan(Integer value) {
            addCriterion("number_27 <", value, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27LessThanOrEqualTo(Integer value) {
            addCriterion("number_27 <=", value, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27In(List<Integer> values) {
            addCriterion("number_27 in", values, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27NotIn(List<Integer> values) {
            addCriterion("number_27 not in", values, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27Between(Integer value1, Integer value2) {
            addCriterion("number_27 between", value1, value2, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber27NotBetween(Integer value1, Integer value2) {
            addCriterion("number_27 not between", value1, value2, "number27");
            return (Criteria) this;
        }

        public Criteria andNumber28IsNull() {
            addCriterion("number_28 is null");
            return (Criteria) this;
        }

        public Criteria andNumber28IsNotNull() {
            addCriterion("number_28 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber28EqualTo(Integer value) {
            addCriterion("number_28 =", value, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28NotEqualTo(Integer value) {
            addCriterion("number_28 <>", value, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28GreaterThan(Integer value) {
            addCriterion("number_28 >", value, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_28 >=", value, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28LessThan(Integer value) {
            addCriterion("number_28 <", value, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28LessThanOrEqualTo(Integer value) {
            addCriterion("number_28 <=", value, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28In(List<Integer> values) {
            addCriterion("number_28 in", values, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28NotIn(List<Integer> values) {
            addCriterion("number_28 not in", values, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28Between(Integer value1, Integer value2) {
            addCriterion("number_28 between", value1, value2, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber28NotBetween(Integer value1, Integer value2) {
            addCriterion("number_28 not between", value1, value2, "number28");
            return (Criteria) this;
        }

        public Criteria andNumber29IsNull() {
            addCriterion("number_29 is null");
            return (Criteria) this;
        }

        public Criteria andNumber29IsNotNull() {
            addCriterion("number_29 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber29EqualTo(Integer value) {
            addCriterion("number_29 =", value, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29NotEqualTo(Integer value) {
            addCriterion("number_29 <>", value, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29GreaterThan(Integer value) {
            addCriterion("number_29 >", value, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_29 >=", value, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29LessThan(Integer value) {
            addCriterion("number_29 <", value, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29LessThanOrEqualTo(Integer value) {
            addCriterion("number_29 <=", value, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29In(List<Integer> values) {
            addCriterion("number_29 in", values, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29NotIn(List<Integer> values) {
            addCriterion("number_29 not in", values, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29Between(Integer value1, Integer value2) {
            addCriterion("number_29 between", value1, value2, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber29NotBetween(Integer value1, Integer value2) {
            addCriterion("number_29 not between", value1, value2, "number29");
            return (Criteria) this;
        }

        public Criteria andNumber30IsNull() {
            addCriterion("number_30 is null");
            return (Criteria) this;
        }

        public Criteria andNumber30IsNotNull() {
            addCriterion("number_30 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber30EqualTo(Integer value) {
            addCriterion("number_30 =", value, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30NotEqualTo(Integer value) {
            addCriterion("number_30 <>", value, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30GreaterThan(Integer value) {
            addCriterion("number_30 >", value, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_30 >=", value, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30LessThan(Integer value) {
            addCriterion("number_30 <", value, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30LessThanOrEqualTo(Integer value) {
            addCriterion("number_30 <=", value, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30In(List<Integer> values) {
            addCriterion("number_30 in", values, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30NotIn(List<Integer> values) {
            addCriterion("number_30 not in", values, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30Between(Integer value1, Integer value2) {
            addCriterion("number_30 between", value1, value2, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber30NotBetween(Integer value1, Integer value2) {
            addCriterion("number_30 not between", value1, value2, "number30");
            return (Criteria) this;
        }

        public Criteria andNumber31IsNull() {
            addCriterion("number_31 is null");
            return (Criteria) this;
        }

        public Criteria andNumber31IsNotNull() {
            addCriterion("number_31 is not null");
            return (Criteria) this;
        }

        public Criteria andNumber31EqualTo(Integer value) {
            addCriterion("number_31 =", value, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31NotEqualTo(Integer value) {
            addCriterion("number_31 <>", value, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31GreaterThan(Integer value) {
            addCriterion("number_31 >", value, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31GreaterThanOrEqualTo(Integer value) {
            addCriterion("number_31 >=", value, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31LessThan(Integer value) {
            addCriterion("number_31 <", value, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31LessThanOrEqualTo(Integer value) {
            addCriterion("number_31 <=", value, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31In(List<Integer> values) {
            addCriterion("number_31 in", values, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31NotIn(List<Integer> values) {
            addCriterion("number_31 not in", values, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31Between(Integer value1, Integer value2) {
            addCriterion("number_31 between", value1, value2, "number31");
            return (Criteria) this;
        }

        public Criteria andNumber31NotBetween(Integer value1, Integer value2) {
            addCriterion("number_31 not between", value1, value2, "number31");
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