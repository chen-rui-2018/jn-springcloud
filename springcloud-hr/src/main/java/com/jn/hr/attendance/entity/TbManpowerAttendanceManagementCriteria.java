package com.jn.hr.attendance.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerAttendanceManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAttendanceManagementCriteria() {
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

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNull() {
            addCriterion("attendance is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNotNull() {
            addCriterion("attendance is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEqualTo(Integer value) {
            addCriterion("attendance =", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotEqualTo(Integer value) {
            addCriterion("attendance <>", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThan(Integer value) {
            addCriterion("attendance >", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("attendance >=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThan(Integer value) {
            addCriterion("attendance <", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("attendance <=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceIn(List<Integer> values) {
            addCriterion("attendance in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotIn(List<Integer> values) {
            addCriterion("attendance not in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("attendance between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("attendance not between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andLateIsNull() {
            addCriterion("late is null");
            return (Criteria) this;
        }

        public Criteria andLateIsNotNull() {
            addCriterion("late is not null");
            return (Criteria) this;
        }

        public Criteria andLateEqualTo(Integer value) {
            addCriterion("late =", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotEqualTo(Integer value) {
            addCriterion("late <>", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateGreaterThan(Integer value) {
            addCriterion("late >", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateGreaterThanOrEqualTo(Integer value) {
            addCriterion("late >=", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateLessThan(Integer value) {
            addCriterion("late <", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateLessThanOrEqualTo(Integer value) {
            addCriterion("late <=", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateIn(List<Integer> values) {
            addCriterion("late in", values, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotIn(List<Integer> values) {
            addCriterion("late not in", values, "late");
            return (Criteria) this;
        }

        public Criteria andLateBetween(Integer value1, Integer value2) {
            addCriterion("late between", value1, value2, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotBetween(Integer value1, Integer value2) {
            addCriterion("late not between", value1, value2, "late");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyIsNull() {
            addCriterion("leave_early is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyIsNotNull() {
            addCriterion("leave_early is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyEqualTo(Integer value) {
            addCriterion("leave_early =", value, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyNotEqualTo(Integer value) {
            addCriterion("leave_early <>", value, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyGreaterThan(Integer value) {
            addCriterion("leave_early >", value, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_early >=", value, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyLessThan(Integer value) {
            addCriterion("leave_early <", value, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyLessThanOrEqualTo(Integer value) {
            addCriterion("leave_early <=", value, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyIn(List<Integer> values) {
            addCriterion("leave_early in", values, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyNotIn(List<Integer> values) {
            addCriterion("leave_early not in", values, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyBetween(Integer value1, Integer value2) {
            addCriterion("leave_early between", value1, value2, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andLeaveEarlyNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_early not between", value1, value2, "leaveEarly");
            return (Criteria) this;
        }

        public Criteria andStartMissCardIsNull() {
            addCriterion("start_miss_card is null");
            return (Criteria) this;
        }

        public Criteria andStartMissCardIsNotNull() {
            addCriterion("start_miss_card is not null");
            return (Criteria) this;
        }

        public Criteria andStartMissCardEqualTo(Integer value) {
            addCriterion("start_miss_card =", value, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardNotEqualTo(Integer value) {
            addCriterion("start_miss_card <>", value, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardGreaterThan(Integer value) {
            addCriterion("start_miss_card >", value, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_miss_card >=", value, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardLessThan(Integer value) {
            addCriterion("start_miss_card <", value, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardLessThanOrEqualTo(Integer value) {
            addCriterion("start_miss_card <=", value, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardIn(List<Integer> values) {
            addCriterion("start_miss_card in", values, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardNotIn(List<Integer> values) {
            addCriterion("start_miss_card not in", values, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardBetween(Integer value1, Integer value2) {
            addCriterion("start_miss_card between", value1, value2, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andStartMissCardNotBetween(Integer value1, Integer value2) {
            addCriterion("start_miss_card not between", value1, value2, "startMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardIsNull() {
            addCriterion("end_miss_card is null");
            return (Criteria) this;
        }

        public Criteria andEndMissCardIsNotNull() {
            addCriterion("end_miss_card is not null");
            return (Criteria) this;
        }

        public Criteria andEndMissCardEqualTo(Integer value) {
            addCriterion("end_miss_card =", value, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardNotEqualTo(Integer value) {
            addCriterion("end_miss_card <>", value, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardGreaterThan(Integer value) {
            addCriterion("end_miss_card >", value, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_miss_card >=", value, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardLessThan(Integer value) {
            addCriterion("end_miss_card <", value, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardLessThanOrEqualTo(Integer value) {
            addCriterion("end_miss_card <=", value, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardIn(List<Integer> values) {
            addCriterion("end_miss_card in", values, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardNotIn(List<Integer> values) {
            addCriterion("end_miss_card not in", values, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardBetween(Integer value1, Integer value2) {
            addCriterion("end_miss_card between", value1, value2, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andEndMissCardNotBetween(Integer value1, Integer value2) {
            addCriterion("end_miss_card not between", value1, value2, "endMissCard");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNull() {
            addCriterion("absenteeism is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNotNull() {
            addCriterion("absenteeism is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismEqualTo(Integer value) {
            addCriterion("absenteeism =", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotEqualTo(Integer value) {
            addCriterion("absenteeism <>", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThan(Integer value) {
            addCriterion("absenteeism >", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThanOrEqualTo(Integer value) {
            addCriterion("absenteeism >=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThan(Integer value) {
            addCriterion("absenteeism <", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThanOrEqualTo(Integer value) {
            addCriterion("absenteeism <=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIn(List<Integer> values) {
            addCriterion("absenteeism in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotIn(List<Integer> values) {
            addCriterion("absenteeism not in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismBetween(Integer value1, Integer value2) {
            addCriterion("absenteeism between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotBetween(Integer value1, Integer value2) {
            addCriterion("absenteeism not between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveIsNull() {
            addCriterion("compassionate_leave is null");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveIsNotNull() {
            addCriterion("compassionate_leave is not null");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveEqualTo(Integer value) {
            addCriterion("compassionate_leave =", value, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveNotEqualTo(Integer value) {
            addCriterion("compassionate_leave <>", value, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveGreaterThan(Integer value) {
            addCriterion("compassionate_leave >", value, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("compassionate_leave >=", value, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveLessThan(Integer value) {
            addCriterion("compassionate_leave <", value, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveLessThanOrEqualTo(Integer value) {
            addCriterion("compassionate_leave <=", value, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveIn(List<Integer> values) {
            addCriterion("compassionate_leave in", values, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveNotIn(List<Integer> values) {
            addCriterion("compassionate_leave not in", values, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveBetween(Integer value1, Integer value2) {
            addCriterion("compassionate_leave between", value1, value2, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andCompassionateLeaveNotBetween(Integer value1, Integer value2) {
            addCriterion("compassionate_leave not between", value1, value2, "compassionateLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIsNull() {
            addCriterion("sick_leave is null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIsNotNull() {
            addCriterion("sick_leave is not null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveEqualTo(Integer value) {
            addCriterion("sick_leave =", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotEqualTo(Integer value) {
            addCriterion("sick_leave <>", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveGreaterThan(Integer value) {
            addCriterion("sick_leave >", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("sick_leave >=", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveLessThan(Integer value) {
            addCriterion("sick_leave <", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveLessThanOrEqualTo(Integer value) {
            addCriterion("sick_leave <=", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIn(List<Integer> values) {
            addCriterion("sick_leave in", values, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotIn(List<Integer> values) {
            addCriterion("sick_leave not in", values, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveBetween(Integer value1, Integer value2) {
            addCriterion("sick_leave between", value1, value2, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotBetween(Integer value1, Integer value2) {
            addCriterion("sick_leave not between", value1, value2, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayIsNull() {
            addCriterion("marriage_holiday is null");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayIsNotNull() {
            addCriterion("marriage_holiday is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayEqualTo(Integer value) {
            addCriterion("marriage_holiday =", value, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayNotEqualTo(Integer value) {
            addCriterion("marriage_holiday <>", value, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayGreaterThan(Integer value) {
            addCriterion("marriage_holiday >", value, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayGreaterThanOrEqualTo(Integer value) {
            addCriterion("marriage_holiday >=", value, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayLessThan(Integer value) {
            addCriterion("marriage_holiday <", value, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayLessThanOrEqualTo(Integer value) {
            addCriterion("marriage_holiday <=", value, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayIn(List<Integer> values) {
            addCriterion("marriage_holiday in", values, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayNotIn(List<Integer> values) {
            addCriterion("marriage_holiday not in", values, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayBetween(Integer value1, Integer value2) {
            addCriterion("marriage_holiday between", value1, value2, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andMarriageHolidayNotBetween(Integer value1, Integer value2) {
            addCriterion("marriage_holiday not between", value1, value2, "marriageHoliday");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIsNull() {
            addCriterion("funeral_leave is null");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIsNotNull() {
            addCriterion("funeral_leave is not null");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveEqualTo(Integer value) {
            addCriterion("funeral_leave =", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotEqualTo(Integer value) {
            addCriterion("funeral_leave <>", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveGreaterThan(Integer value) {
            addCriterion("funeral_leave >", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("funeral_leave >=", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveLessThan(Integer value) {
            addCriterion("funeral_leave <", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveLessThanOrEqualTo(Integer value) {
            addCriterion("funeral_leave <=", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIn(List<Integer> values) {
            addCriterion("funeral_leave in", values, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotIn(List<Integer> values) {
            addCriterion("funeral_leave not in", values, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveBetween(Integer value1, Integer value2) {
            addCriterion("funeral_leave between", value1, value2, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotBetween(Integer value1, Integer value2) {
            addCriterion("funeral_leave not between", value1, value2, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIsNull() {
            addCriterion("maternity_leave is null");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIsNotNull() {
            addCriterion("maternity_leave is not null");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveEqualTo(Integer value) {
            addCriterion("maternity_leave =", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotEqualTo(Integer value) {
            addCriterion("maternity_leave <>", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveGreaterThan(Integer value) {
            addCriterion("maternity_leave >", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("maternity_leave >=", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveLessThan(Integer value) {
            addCriterion("maternity_leave <", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveLessThanOrEqualTo(Integer value) {
            addCriterion("maternity_leave <=", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIn(List<Integer> values) {
            addCriterion("maternity_leave in", values, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotIn(List<Integer> values) {
            addCriterion("maternity_leave not in", values, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveBetween(Integer value1, Integer value2) {
            addCriterion("maternity_leave between", value1, value2, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotBetween(Integer value1, Integer value2) {
            addCriterion("maternity_leave not between", value1, value2, "maternityLeave");
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

        public Criteria andAttendanceDateIsNull() {
            addCriterion("attendance_date is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateIsNotNull() {
            addCriterion("attendance_date is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateEqualTo(String value) {
            addCriterion("attendance_date =", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotEqualTo(String value) {
            addCriterion("attendance_date <>", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateGreaterThan(String value) {
            addCriterion("attendance_date >", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_date >=", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateLessThan(String value) {
            addCriterion("attendance_date <", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateLessThanOrEqualTo(String value) {
            addCriterion("attendance_date <=", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateLike(String value) {
            addCriterion("attendance_date like", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotLike(String value) {
            addCriterion("attendance_date not like", value, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateIn(List<String> values) {
            addCriterion("attendance_date in", values, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotIn(List<String> values) {
            addCriterion("attendance_date not in", values, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateBetween(String value1, String value2) {
            addCriterion("attendance_date between", value1, value2, "attendanceDate");
            return (Criteria) this;
        }

        public Criteria andAttendanceDateNotBetween(String value1, String value2) {
            addCriterion("attendance_date not between", value1, value2, "attendanceDate");
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