package com.jn.hr.attendance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerAttendanceTimeSetCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAttendanceTimeSetCriteria() {
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

        public Criteria andShiftIsNull() {
            addCriterion("shift is null");
            return (Criteria) this;
        }

        public Criteria andShiftIsNotNull() {
            addCriterion("shift is not null");
            return (Criteria) this;
        }

        public Criteria andShiftEqualTo(String value) {
            addCriterion("shift =", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotEqualTo(String value) {
            addCriterion("shift <>", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftGreaterThan(String value) {
            addCriterion("shift >", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftGreaterThanOrEqualTo(String value) {
            addCriterion("shift >=", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLessThan(String value) {
            addCriterion("shift <", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLessThanOrEqualTo(String value) {
            addCriterion("shift <=", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLike(String value) {
            addCriterion("shift like", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotLike(String value) {
            addCriterion("shift not like", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftIn(List<String> values) {
            addCriterion("shift in", values, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotIn(List<String> values) {
            addCriterion("shift not in", values, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftBetween(String value1, String value2) {
            addCriterion("shift between", value1, value2, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotBetween(String value1, String value2) {
            addCriterion("shift not between", value1, value2, "shift");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeIsNull() {
            addCriterion("attendance_type is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeIsNotNull() {
            addCriterion("attendance_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeEqualTo(String value) {
            addCriterion("attendance_type =", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotEqualTo(String value) {
            addCriterion("attendance_type <>", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeGreaterThan(String value) {
            addCriterion("attendance_type >", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_type >=", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeLessThan(String value) {
            addCriterion("attendance_type <", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeLessThanOrEqualTo(String value) {
            addCriterion("attendance_type <=", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeLike(String value) {
            addCriterion("attendance_type like", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotLike(String value) {
            addCriterion("attendance_type not like", value, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeIn(List<String> values) {
            addCriterion("attendance_type in", values, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotIn(List<String> values) {
            addCriterion("attendance_type not in", values, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeBetween(String value1, String value2) {
            addCriterion("attendance_type between", value1, value2, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andAttendanceTypeNotBetween(String value1, String value2) {
            addCriterion("attendance_type not between", value1, value2, "attendanceType");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeIsNull() {
            addCriterion("work_attendance_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeIsNotNull() {
            addCriterion("work_attendance_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeEqualTo(String value) {
            addCriterion("work_attendance_time =", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeNotEqualTo(String value) {
            addCriterion("work_attendance_time <>", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeGreaterThan(String value) {
            addCriterion("work_attendance_time >", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_attendance_time >=", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeLessThan(String value) {
            addCriterion("work_attendance_time <", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeLessThanOrEqualTo(String value) {
            addCriterion("work_attendance_time <=", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeLike(String value) {
            addCriterion("work_attendance_time like", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeNotLike(String value) {
            addCriterion("work_attendance_time not like", value, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeIn(List<String> values) {
            addCriterion("work_attendance_time in", values, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeNotIn(List<String> values) {
            addCriterion("work_attendance_time not in", values, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeBetween(String value1, String value2) {
            addCriterion("work_attendance_time between", value1, value2, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andWorkAttendanceTimeNotBetween(String value1, String value2) {
            addCriterion("work_attendance_time not between", value1, value2, "workAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeIsNull() {
            addCriterion("duty_attendance_time is null");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeIsNotNull() {
            addCriterion("duty_attendance_time is not null");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeEqualTo(String value) {
            addCriterion("duty_attendance_time =", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeNotEqualTo(String value) {
            addCriterion("duty_attendance_time <>", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeGreaterThan(String value) {
            addCriterion("duty_attendance_time >", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("duty_attendance_time >=", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeLessThan(String value) {
            addCriterion("duty_attendance_time <", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeLessThanOrEqualTo(String value) {
            addCriterion("duty_attendance_time <=", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeLike(String value) {
            addCriterion("duty_attendance_time like", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeNotLike(String value) {
            addCriterion("duty_attendance_time not like", value, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeIn(List<String> values) {
            addCriterion("duty_attendance_time in", values, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeNotIn(List<String> values) {
            addCriterion("duty_attendance_time not in", values, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeBetween(String value1, String value2) {
            addCriterion("duty_attendance_time between", value1, value2, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceTimeNotBetween(String value1, String value2) {
            addCriterion("duty_attendance_time not between", value1, value2, "dutyAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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