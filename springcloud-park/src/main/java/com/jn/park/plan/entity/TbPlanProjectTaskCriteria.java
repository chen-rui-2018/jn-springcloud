package com.jn.park.plan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPlanProjectTaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPlanProjectTaskCriteria() {
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
            addCriterion("project_task.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("project_task.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("project_task.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("project_task.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("project_task.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("project_task.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("project_task.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("project_task.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("project_task.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("project_task.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("project_task.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("project_task.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("project_task.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_task.project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_task.project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_task.project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_task.project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_task.project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_task.project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_task.project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_task.project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_task.project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_task.project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_task.project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_task.project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_task.project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNumberIsNull() {
            addCriterion("project_task.project_number is null");
            return (Criteria) this;
        }

        public Criteria andProjectNumberIsNotNull() {
            addCriterion("project_task.project_number is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNumberEqualTo(String value) {
            addCriterion("project_task.project_number =", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotEqualTo(String value) {
            addCriterion("project_task.project_number <>", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberGreaterThan(String value) {
            addCriterion("project_task.project_number >", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.project_number >=", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberLessThan(String value) {
            addCriterion("project_task.project_number <", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberLessThanOrEqualTo(String value) {
            addCriterion("project_task.project_number <=", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberLike(String value) {
            addCriterion("project_task.project_number like", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotLike(String value) {
            addCriterion("project_task.project_number not like", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberIn(List<String> values) {
            addCriterion("project_task.project_number in", values, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotIn(List<String> values) {
            addCriterion("project_task.project_number not in", values, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberBetween(String value1, String value2) {
            addCriterion("project_task.project_number between", value1, value2, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotBetween(String value1, String value2) {
            addCriterion("project_task.project_number not between", value1, value2, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_task.project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_task.project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_task.project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_task.project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_task.project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_task.project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_task.project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_task.project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_task.project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_task.project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_task.project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_task.project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_task.project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("project_task.task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("project_task.task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("project_task.task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("project_task.task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("project_task.task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("project_task.task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("project_task.task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("project_task.task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("project_task.task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("project_task.task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("project_task.task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("project_task.task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("project_task.task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNumberIsNull() {
            addCriterion("project_task.task_number is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberIsNotNull() {
            addCriterion("project_task.task_number is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumberEqualTo(String value) {
            addCriterion("project_task.task_number =", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotEqualTo(String value) {
            addCriterion("project_task.task_number <>", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberGreaterThan(String value) {
            addCriterion("project_task.task_number >", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.task_number >=", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberLessThan(String value) {
            addCriterion("project_task.task_number <", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberLessThanOrEqualTo(String value) {
            addCriterion("project_task.task_number <=", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberLike(String value) {
            addCriterion("project_task.task_number like", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotLike(String value) {
            addCriterion("project_task.task_number not like", value, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberIn(List<String> values) {
            addCriterion("project_task.task_number in", values, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotIn(List<String> values) {
            addCriterion("project_task.task_number not in", values, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberBetween(String value1, String value2) {
            addCriterion("project_task.task_number between", value1, value2, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andTaskNumberNotBetween(String value1, String value2) {
            addCriterion("project_task.task_number not between", value1, value2, "taskNumber");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("project_task.plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("project_task.plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("project_task.plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("project_task.plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("project_task.plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_task.plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("project_task.plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_task.plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("project_task.plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("project_task.plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("project_task.plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_task.plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeIsNull() {
            addCriterion("project_task.plan_stop_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeIsNotNull() {
            addCriterion("project_task.plan_stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeEqualTo(Date value) {
            addCriterion("project_task.plan_stop_time =", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeNotEqualTo(Date value) {
            addCriterion("project_task.plan_stop_time <>", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeGreaterThan(Date value) {
            addCriterion("project_task.plan_stop_time >", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_task.plan_stop_time >=", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeLessThan(Date value) {
            addCriterion("project_task.plan_stop_time <", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_task.plan_stop_time <=", value, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeIn(List<Date> values) {
            addCriterion("project_task.plan_stop_time in", values, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeNotIn(List<Date> values) {
            addCriterion("project_task.plan_stop_time not in", values, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeBetween(Date value1, Date value2) {
            addCriterion("project_task.plan_stop_time between", value1, value2, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andPlanStopTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_task.plan_stop_time not between", value1, value2, "planStopTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNull() {
            addCriterion("project_task.limit_time is null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNotNull() {
            addCriterion("project_task.limit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeEqualTo(Integer value) {
            addCriterion("project_task.limit_time =", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotEqualTo(Integer value) {
            addCriterion("project_task.limit_time <>", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThan(Integer value) {
            addCriterion("project_task.limit_time >", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_task.limit_time >=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThan(Integer value) {
            addCriterion("project_task.limit_time <", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThanOrEqualTo(Integer value) {
            addCriterion("project_task.limit_time <=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIn(List<Integer> values) {
            addCriterion("project_task.limit_time in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotIn(List<Integer> values) {
            addCriterion("project_task.limit_time not in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeBetween(Integer value1, Integer value2) {
            addCriterion("project_task.limit_time between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("project_task.limit_time not between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressIsNull() {
            addCriterion("project_task.nowadays_progress is null");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressIsNotNull() {
            addCriterion("project_task.nowadays_progress is not null");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressEqualTo(Long value) {
            addCriterion("project_task.nowadays_progress =", value, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressNotEqualTo(Long value) {
            addCriterion("project_task.nowadays_progress <>", value, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressGreaterThan(Long value) {
            addCriterion("project_task.nowadays_progress >", value, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressGreaterThanOrEqualTo(Long value) {
            addCriterion("project_task.nowadays_progress >=", value, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressLessThan(Long value) {
            addCriterion("project_task.nowadays_progress <", value, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressLessThanOrEqualTo(Long value) {
            addCriterion("project_task.nowadays_progress <=", value, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressIn(List<Long> values) {
            addCriterion("project_task.nowadays_progress in", values, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressNotIn(List<Long> values) {
            addCriterion("project_task.nowadays_progress not in", values, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressBetween(Long value1, Long value2) {
            addCriterion("project_task.nowadays_progress between", value1, value2, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andNowadaysProgressNotBetween(Long value1, Long value2) {
            addCriterion("project_task.nowadays_progress not between", value1, value2, "nowadaysProgress");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("project_task.task_state is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("project_task.task_state is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(Integer value) {
            addCriterion("project_task.task_state =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(Integer value) {
            addCriterion("project_task.task_state <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(Integer value) {
            addCriterion("project_task.task_state >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_task.task_state >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(Integer value) {
            addCriterion("project_task.task_state <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(Integer value) {
            addCriterion("project_task.task_state <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<Integer> values) {
            addCriterion("project_task.task_state in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<Integer> values) {
            addCriterion("project_task.task_state not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(Integer value1, Integer value2) {
            addCriterion("project_task.task_state between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(Integer value1, Integer value2) {
            addCriterion("project_task.task_state not between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeIsNull() {
            addCriterion("project_task.expect_differ_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeIsNotNull() {
            addCriterion("project_task.expect_differ_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeEqualTo(String value) {
            addCriterion("project_task.expect_differ_time =", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeNotEqualTo(String value) {
            addCriterion("project_task.expect_differ_time <>", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeGreaterThan(String value) {
            addCriterion("project_task.expect_differ_time >", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.expect_differ_time >=", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeLessThan(String value) {
            addCriterion("project_task.expect_differ_time <", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeLessThanOrEqualTo(String value) {
            addCriterion("project_task.expect_differ_time <=", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeLike(String value) {
            addCriterion("project_task.expect_differ_time like", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeNotLike(String value) {
            addCriterion("project_task.expect_differ_time not like", value, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeIn(List<String> values) {
            addCriterion("project_task.expect_differ_time in", values, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeNotIn(List<String> values) {
            addCriterion("project_task.expect_differ_time not in", values, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeBetween(String value1, String value2) {
            addCriterion("project_task.expect_differ_time between", value1, value2, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andExpectDifferTimeNotBetween(String value1, String value2) {
            addCriterion("project_task.expect_differ_time not between", value1, value2, "expectDifferTime");
            return (Criteria) this;
        }

        public Criteria andAppraiseIsNull() {
            addCriterion("project_task.appraise is null");
            return (Criteria) this;
        }

        public Criteria andAppraiseIsNotNull() {
            addCriterion("project_task.appraise is not null");
            return (Criteria) this;
        }

        public Criteria andAppraiseEqualTo(Integer value) {
            addCriterion("project_task.appraise =", value, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseNotEqualTo(Integer value) {
            addCriterion("project_task.appraise <>", value, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseGreaterThan(Integer value) {
            addCriterion("project_task.appraise >", value, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_task.appraise >=", value, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseLessThan(Integer value) {
            addCriterion("project_task.appraise <", value, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseLessThanOrEqualTo(Integer value) {
            addCriterion("project_task.appraise <=", value, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseIn(List<Integer> values) {
            addCriterion("project_task.appraise in", values, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseNotIn(List<Integer> values) {
            addCriterion("project_task.appraise not in", values, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseBetween(Integer value1, Integer value2) {
            addCriterion("project_task.appraise between", value1, value2, "appraise");
            return (Criteria) this;
        }

        public Criteria andAppraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("project_task.appraise not between", value1, value2, "appraise");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeIsNull() {
            addCriterion("project_task.actual_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeIsNotNull() {
            addCriterion("project_task.actual_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeEqualTo(Date value) {
            addCriterion("project_task.actual_begin_time =", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeNotEqualTo(Date value) {
            addCriterion("project_task.actual_begin_time <>", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeGreaterThan(Date value) {
            addCriterion("project_task.actual_begin_time >", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_task.actual_begin_time >=", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeLessThan(Date value) {
            addCriterion("project_task.actual_begin_time <", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_task.actual_begin_time <=", value, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeIn(List<Date> values) {
            addCriterion("project_task.actual_begin_time in", values, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeNotIn(List<Date> values) {
            addCriterion("project_task.actual_begin_time not in", values, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeBetween(Date value1, Date value2) {
            addCriterion("project_task.actual_begin_time between", value1, value2, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_task.actual_begin_time not between", value1, value2, "actualBeginTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNull() {
            addCriterion("project_task.actual_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIsNotNull() {
            addCriterion("project_task.actual_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeEqualTo(Date value) {
            addCriterion("project_task.actual_end_time =", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotEqualTo(Date value) {
            addCriterion("project_task.actual_end_time <>", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThan(Date value) {
            addCriterion("project_task.actual_end_time >", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_task.actual_end_time >=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThan(Date value) {
            addCriterion("project_task.actual_end_time <", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_task.actual_end_time <=", value, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeIn(List<Date> values) {
            addCriterion("project_task.actual_end_time in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotIn(List<Date> values) {
            addCriterion("project_task.actual_end_time not in", values, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeBetween(Date value1, Date value2) {
            addCriterion("project_task.actual_end_time between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andActualEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_task.actual_end_time not between", value1, value2, "actualEndTime");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("project_task.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("project_task.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Integer value) {
            addCriterion("project_task.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Integer value) {
            addCriterion("project_task.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Integer value) {
            addCriterion("project_task.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_task.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Integer value) {
            addCriterion("project_task.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("project_task.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Integer> values) {
            addCriterion("project_task.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Integer> values) {
            addCriterion("project_task.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("project_task.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("project_task.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("project_task.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("project_task.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("project_task.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("project_task.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("project_task.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("project_task.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("project_task.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("project_task.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("project_task.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("project_task.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("project_task.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("project_task.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("project_task.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("project_task.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("project_task.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("project_task.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("project_task.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("project_task.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_task.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("project_task.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_task.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("project_task.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("project_task.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("project_task.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_task.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("project_task.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("project_task.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("project_task.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("project_task.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("project_task.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("project_task.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("project_task.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("project_task.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("project_task.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("project_task.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("project_task.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("project_task.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("project_task.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("project_task.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("project_task.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("project_task.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("project_task.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("project_task.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("project_task.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_task.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("project_task.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_task.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("project_task.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("project_task.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("project_task.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_task.modified_time not between", value1, value2, "modifiedTime");
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