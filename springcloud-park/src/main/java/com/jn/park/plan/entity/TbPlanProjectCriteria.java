package com.jn.park.plan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPlanProjectCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPlanProjectCriteria() {
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
            addCriterion("project.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("project.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("project.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("project.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("project.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("project.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("project.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("project.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("project.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("project.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("project.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("project.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("project.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("project.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project.project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project.project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project.project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project.project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project.project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project.project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project.project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project.project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project.project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project.project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project.project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project.project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project.project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project.project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNull() {
            addCriterion("project.project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project.project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("project.project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("project.project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("project.project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("project.project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("project.project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("project.project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("project.project_no like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("project.project_no not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("project.project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("project.project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("project.project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("project.project_no not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("project.owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("project.owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("project.owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("project.owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("project.owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("project.owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("project.owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("project.owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("project.owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("project.owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("project.owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("project.owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("project.owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("project.owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentIsNull() {
            addCriterion("project.owner_department is null");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentIsNotNull() {
            addCriterion("project.owner_department is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentEqualTo(String value) {
            addCriterion("project.owner_department =", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotEqualTo(String value) {
            addCriterion("project.owner_department <>", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentGreaterThan(String value) {
            addCriterion("project.owner_department >", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("project.owner_department >=", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentLessThan(String value) {
            addCriterion("project.owner_department <", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentLessThanOrEqualTo(String value) {
            addCriterion("project.owner_department <=", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentLike(String value) {
            addCriterion("project.owner_department like", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotLike(String value) {
            addCriterion("project.owner_department not like", value, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentIn(List<String> values) {
            addCriterion("project.owner_department in", values, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotIn(List<String> values) {
            addCriterion("project.owner_department not in", values, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentBetween(String value1, String value2) {
            addCriterion("project.owner_department between", value1, value2, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andOwnerDepartmentNotBetween(String value1, String value2) {
            addCriterion("project.owner_department not between", value1, value2, "ownerDepartment");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("project.plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("project.plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("project.plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("project.plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("project.plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project.plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("project.plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("project.plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("project.plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("project.plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("project.plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("project.plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeIsNull() {
            addCriterion("project.plan_stop_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeIsNotNull() {
            addCriterion("project.plan_stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeEqualTo(Date value) {
            addCriterion("project.plan_stop_time =", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeNotEqualTo(Date value) {
            addCriterion("project.plan_stop_time <>", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeGreaterThan(Date value) {
            addCriterion("project.plan_stop_time >", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project.plan_stop_time >=", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeLessThan(Date value) {
            addCriterion("project.plan_stop_time <", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("project.plan_stop_time <=", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeIn(List<Date> values) {
            addCriterion("project.plan_stop_time in", values, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeNotIn(List<Date> values) {
            addCriterion("project.plan_stop_time not in", values, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeBetween(Date value1, Date value2) {
            addCriterion("project.plan_stop_time between", value1, value2, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("project.plan_stop_time not between", value1, value2, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNull() {
            addCriterion("project.limit_time is null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNotNull() {
            addCriterion("project.limit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeEqualTo(Integer value) {
            addCriterion("project.limit_time =", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotEqualTo(Integer value) {
            addCriterion("project.limit_time <>", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThan(Integer value) {
            addCriterion("project.limit_time >", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project.limit_time >=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThan(Integer value) {
            addCriterion("project.limit_time <", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThanOrEqualTo(Integer value) {
            addCriterion("project.limit_time <=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIn(List<Integer> values) {
            addCriterion("project.limit_time in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotIn(List<Integer> values) {
            addCriterion("project.limit_time not in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeBetween(Integer value1, Integer value2) {
            addCriterion("project.limit_time between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("project.limit_time not between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeIsNull() {
            addCriterion("project.surplus_time is null");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeIsNotNull() {
            addCriterion("project.surplus_time is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeEqualTo(Integer value) {
            addCriterion("project.surplus_time =", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotEqualTo(Integer value) {
            addCriterion("project.surplus_time <>", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeGreaterThan(Integer value) {
            addCriterion("project.surplus_time >", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project.surplus_time >=", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeLessThan(Integer value) {
            addCriterion("project.surplus_time <", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeLessThanOrEqualTo(Integer value) {
            addCriterion("project.surplus_time <=", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeIn(List<Integer> values) {
            addCriterion("project.surplus_time in", values, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotIn(List<Integer> values) {
            addCriterion("project.surplus_time not in", values, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeBetween(Integer value1, Integer value2) {
            addCriterion("project.surplus_time between", value1, value2, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("project.surplus_time not between", value1, value2, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andProjectStateIsNull() {
            addCriterion("project.project_state is null");
            return (Criteria) this;
        }

        public Criteria andProjectStateIsNotNull() {
            addCriterion("project.project_state is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStateEqualTo(Integer value) {
            addCriterion("project.project_state =", value, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateNotEqualTo(Integer value) {
            addCriterion("project.project_state <>", value, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateGreaterThan(Integer value) {
            addCriterion("project.project_state >", value, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("project.project_state >=", value, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateLessThan(Integer value) {
            addCriterion("project.project_state <", value, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateLessThanOrEqualTo(Integer value) {
            addCriterion("project.project_state <=", value, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateIn(List<Integer> values) {
            addCriterion("project.project_state in", values, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateNotIn(List<Integer> values) {
            addCriterion("project.project_state not in", values, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateBetween(Integer value1, Integer value2) {
            addCriterion("project.project_state between", value1, value2, "projectState");
            return (Criteria) this;
        }

        public Criteria andProjectStateNotBetween(Integer value1, Integer value2) {
            addCriterion("project.project_state not between", value1, value2, "projectState");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeIsNull() {
            addCriterion("project.actual_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeIsNotNull() {
            addCriterion("project.actual_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeEqualTo(Date value) {
            addCriterion("project.actual_begin_time =", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeNotEqualTo(Date value) {
            addCriterion("project.actual_begin_time <>", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeGreaterThan(Date value) {
            addCriterion("project.actual_begin_time >", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project.actual_begin_time >=", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeLessThan(Date value) {
            addCriterion("project.actual_begin_time <", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("project.actual_begin_time <=", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeIn(List<Date> values) {
            addCriterion("project.actual_begin_time in", values, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeNotIn(List<Date> values) {
            addCriterion("project.actual_begin_time not in", values, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeBetween(Date value1, Date value2) {
            addCriterion("project.actual_begin_time between", value1, value2, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("project.actual_begin_time not between", value1, value2, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNull() {
            addCriterion("project.actual_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNotNull() {
            addCriterion("project.actual_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeEqualTo(Date value) {
            addCriterion("project.actual_end_time =", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotEqualTo(Date value) {
            addCriterion("project.actual_end_time <>", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThan(Date value) {
            addCriterion("project.actual_end_time >", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project.actual_end_time >=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThan(Date value) {
            addCriterion("project.actual_end_time <", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("project.actual_end_time <=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIn(List<Date> values) {
            addCriterion("project.actual_end_time in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotIn(List<Date> values) {
            addCriterion("project.actual_end_time not in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeBetween(Date value1, Date value2) {
            addCriterion("project.actual_end_time between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("project.actual_end_time not between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andProgressIsNull() {
            addCriterion("project.progress is null");
            return (Criteria) this;
        }

        public Criteria andProgressIsNotNull() {
            addCriterion("project.progress is not null");
            return (Criteria) this;
        }

        public Criteria andProgressEqualTo(Long value) {
            addCriterion("project.progress =", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotEqualTo(Long value) {
            addCriterion("project.progress <>", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressGreaterThan(Long value) {
            addCriterion("project.progress >", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressGreaterThanOrEqualTo(Long value) {
            addCriterion("project.progress >=", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressLessThan(Long value) {
            addCriterion("project.progress <", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressLessThanOrEqualTo(Long value) {
            addCriterion("project.progress <=", value, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressIn(List<Long> values) {
            addCriterion("project.progress in", values, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotIn(List<Long> values) {
            addCriterion("project.progress not in", values, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressBetween(Long value1, Long value2) {
            addCriterion("project.progress between", value1, value2, "progress");
            return (Criteria) this;
        }

        public Criteria andProgressNotBetween(Long value1, Long value2) {
            addCriterion("project.progress not between", value1, value2, "progress");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskIsNull() {
            addCriterion("project.project_surplus_task is null");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskIsNotNull() {
            addCriterion("project.project_surplus_task is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskEqualTo(Integer value) {
            addCriterion("project.project_surplus_task =", value, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskNotEqualTo(Integer value) {
            addCriterion("project.project_surplus_task <>", value, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskGreaterThan(Integer value) {
            addCriterion("project.project_surplus_task >", value, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskGreaterThanOrEqualTo(Integer value) {
            addCriterion("project.project_surplus_task >=", value, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskLessThan(Integer value) {
            addCriterion("project.project_surplus_task <", value, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskLessThanOrEqualTo(Integer value) {
            addCriterion("project.project_surplus_task <=", value, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskIn(List<Integer> values) {
            addCriterion("project.project_surplus_task in", values, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskNotIn(List<Integer> values) {
            addCriterion("project.project_surplus_task not in", values, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskBetween(Integer value1, Integer value2) {
            addCriterion("project.project_surplus_task between", value1, value2, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andProjectSurplusTaskNotBetween(Integer value1, Integer value2) {
            addCriterion("project.project_surplus_task not between", value1, value2, "projectSurplusTask");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringIsNull() {
            addCriterion("project.material_is_entering is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringIsNotNull() {
            addCriterion("project.material_is_entering is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringEqualTo(Integer value) {
            addCriterion("project.material_is_entering =", value, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringNotEqualTo(Integer value) {
            addCriterion("project.material_is_entering <>", value, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringGreaterThan(Integer value) {
            addCriterion("project.material_is_entering >", value, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringGreaterThanOrEqualTo(Integer value) {
            addCriterion("project.material_is_entering >=", value, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringLessThan(Integer value) {
            addCriterion("project.material_is_entering <", value, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringLessThanOrEqualTo(Integer value) {
            addCriterion("project.material_is_entering <=", value, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringIn(List<Integer> values) {
            addCriterion("project.material_is_entering in", values, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringNotIn(List<Integer> values) {
            addCriterion("project.material_is_entering not in", values, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringBetween(Integer value1, Integer value2) {
            addCriterion("project.material_is_entering between", value1, value2, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andMaterialIsEnteringNotBetween(Integer value1, Integer value2) {
            addCriterion("project.material_is_entering not between", value1, value2, "materialIsEntering");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("project.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("project.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Integer value) {
            addCriterion("project.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Integer value) {
            addCriterion("project.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Integer value) {
            addCriterion("project.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Integer value) {
            addCriterion("project.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Integer> values) {
            addCriterion("project.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Integer> values) {
            addCriterion("project.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("project.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("project.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("project.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("project.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("project.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("project.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("project.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("project.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("project.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("project.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("project.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("project.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("project.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("project.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("project.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("project.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("project.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("project.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("project.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("project.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("project.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("project.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("project.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("project.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("project.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("project.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("project.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("project.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("project.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("project.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("project.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("project.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("project.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("project.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("project.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("project.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("project.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("project.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("project.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("project.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("project.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("project.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("project.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("project.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("project.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("project.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("project.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("project.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("project.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("project.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("project.modified_time not between", value1, value2, "modifiedTime");
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