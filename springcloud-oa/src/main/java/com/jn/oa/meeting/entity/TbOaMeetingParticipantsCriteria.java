package com.jn.oa.meeting.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOaMeetingParticipantsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOaMeetingParticipantsCriteria() {
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
            addCriterion("meetingparticipants.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("meetingparticipants.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("meetingparticipants.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("meetingparticipants.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("meetingparticipants.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("meetingparticipants.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("meetingparticipants.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("meetingparticipants.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("meetingparticipants.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("meetingparticipants.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("meetingparticipants.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("meetingparticipants.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMeetingIdIsNull() {
            addCriterion("meetingparticipants.meeting_id is null");
            return (Criteria) this;
        }

        public Criteria andMeetingIdIsNotNull() {
            addCriterion("meetingparticipants.meeting_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingIdEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_id =", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_id <>", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdGreaterThan(String value) {
            addCriterion("meetingparticipants.meeting_id >", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdGreaterThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_id >=", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdLessThan(String value) {
            addCriterion("meetingparticipants.meeting_id <", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdLessThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_id <=", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdLike(String value) {
            addCriterion("meetingparticipants.meeting_id like", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotLike(String value) {
            addCriterion("meetingparticipants.meeting_id not like", value, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdIn(List<String> values) {
            addCriterion("meetingparticipants.meeting_id in", values, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotIn(List<String> values) {
            addCriterion("meetingparticipants.meeting_id not in", values, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdBetween(String value1, String value2) {
            addCriterion("meetingparticipants.meeting_id between", value1, value2, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingIdNotBetween(String value1, String value2) {
            addCriterion("meetingparticipants.meeting_id not between", value1, value2, "meetingId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdIsNull() {
            addCriterion("meetingparticipants.meeting_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdIsNotNull() {
            addCriterion("meetingparticipants.meeting_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_user_id =", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdNotEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_user_id <>", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdGreaterThan(String value) {
            addCriterion("meetingparticipants.meeting_user_id >", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_user_id >=", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdLessThan(String value) {
            addCriterion("meetingparticipants.meeting_user_id <", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdLessThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.meeting_user_id <=", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdLike(String value) {
            addCriterion("meetingparticipants.meeting_user_id like", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdNotLike(String value) {
            addCriterion("meetingparticipants.meeting_user_id not like", value, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdIn(List<String> values) {
            addCriterion("meetingparticipants.meeting_user_id in", values, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdNotIn(List<String> values) {
            addCriterion("meetingparticipants.meeting_user_id not in", values, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdBetween(String value1, String value2) {
            addCriterion("meetingparticipants.meeting_user_id between", value1, value2, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andMeetingUserIdNotBetween(String value1, String value2) {
            addCriterion("meetingparticipants.meeting_user_id not between", value1, value2, "meetingUserId");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIsNull() {
            addCriterion("meetingparticipants.sign_in_time is null");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIsNotNull() {
            addCriterion("meetingparticipants.sign_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignInTimeEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_in_time =", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_in_time <>", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeGreaterThan(Date value) {
            addCriterion("meetingparticipants.sign_in_time >", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_in_time >=", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeLessThan(Date value) {
            addCriterion("meetingparticipants.sign_in_time <", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeLessThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_in_time <=", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIn(List<Date> values) {
            addCriterion("meetingparticipants.sign_in_time in", values, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotIn(List<Date> values) {
            addCriterion("meetingparticipants.sign_in_time not in", values, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.sign_in_time between", value1, value2, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.sign_in_time not between", value1, value2, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeIsNull() {
            addCriterion("meetingparticipants.sign_back_time is null");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeIsNotNull() {
            addCriterion("meetingparticipants.sign_back_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_back_time =", value, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeNotEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_back_time <>", value, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeGreaterThan(Date value) {
            addCriterion("meetingparticipants.sign_back_time >", value, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_back_time >=", value, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeLessThan(Date value) {
            addCriterion("meetingparticipants.sign_back_time <", value, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeLessThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.sign_back_time <=", value, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeIn(List<Date> values) {
            addCriterion("meetingparticipants.sign_back_time in", values, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeNotIn(List<Date> values) {
            addCriterion("meetingparticipants.sign_back_time not in", values, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.sign_back_time between", value1, value2, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andSignBackTimeNotBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.sign_back_time not between", value1, value2, "signBackTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusIsNull() {
            addCriterion("meetingparticipants.attendance_status is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusIsNotNull() {
            addCriterion("meetingparticipants.attendance_status is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusEqualTo(String value) {
            addCriterion("meetingparticipants.attendance_status =", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotEqualTo(String value) {
            addCriterion("meetingparticipants.attendance_status <>", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusGreaterThan(String value) {
            addCriterion("meetingparticipants.attendance_status >", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.attendance_status >=", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusLessThan(String value) {
            addCriterion("meetingparticipants.attendance_status <", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusLessThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.attendance_status <=", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusLike(String value) {
            addCriterion("meetingparticipants.attendance_status like", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotLike(String value) {
            addCriterion("meetingparticipants.attendance_status not like", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusIn(List<String> values) {
            addCriterion("meetingparticipants.attendance_status in", values, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotIn(List<String> values) {
            addCriterion("meetingparticipants.attendance_status not in", values, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusBetween(String value1, String value2) {
            addCriterion("meetingparticipants.attendance_status between", value1, value2, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotBetween(String value1, String value2) {
            addCriterion("meetingparticipants.attendance_status not between", value1, value2, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("meetingparticipants.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("meetingparticipants.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("meetingparticipants.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("meetingparticipants.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("meetingparticipants.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("meetingparticipants.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("meetingparticipants.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("meetingparticipants.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("meetingparticipants.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("meetingparticipants.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("meetingparticipants.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("meetingparticipants.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("meetingparticipants.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("meetingparticipants.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("meetingparticipants.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("meetingparticipants.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("meetingparticipants.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("meetingparticipants.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("meetingparticipants.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("meetingparticipants.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("meetingparticipants.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("meetingparticipants.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("meetingparticipants.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("meetingparticipants.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("meetingparticipants.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("meetingparticipants.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("meetingparticipants.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("meetingparticipants.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("meetingparticipants.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("meetingparticipants.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("meetingparticipants.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("meetingparticipants.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("meetingparticipants.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("meetingparticipants.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("meetingparticipants.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("meetingparticipants.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("meetingparticipants.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("meetingparticipants.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("meetingparticipants.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("meetingparticipants.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("meetingparticipants.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("meetingparticipants.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("meetingparticipants.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("meetingparticipants.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("meetingparticipants.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("meetingparticipants.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("meetingparticipants.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("meetingparticipants.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("meetingparticipants.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("meetingparticipants.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("meetingparticipants.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("meetingparticipants.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("meetingparticipants.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("meetingparticipants.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("meetingparticipants.modified_time not between", value1, value2, "modifiedTime");
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