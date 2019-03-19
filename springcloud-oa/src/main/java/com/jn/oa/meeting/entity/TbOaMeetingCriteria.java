package com.jn.oa.meeting.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOaMeetingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOaMeetingCriteria() {
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
            addCriterion("meeting.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("meeting.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("meeting.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("meeting.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("meeting.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("meeting.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("meeting.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("meeting.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("meeting.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("meeting.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("meeting.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("meeting.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("meeting.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIsNull() {
            addCriterion("meeting.work_order_num is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIsNotNull() {
            addCriterion("meeting.work_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumEqualTo(String value) {
            addCriterion("meeting.work_order_num =", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotEqualTo(String value) {
            addCriterion("meeting.work_order_num <>", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumGreaterThan(String value) {
            addCriterion("meeting.work_order_num >", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.work_order_num >=", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLessThan(String value) {
            addCriterion("meeting.work_order_num <", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLessThanOrEqualTo(String value) {
            addCriterion("meeting.work_order_num <=", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLike(String value) {
            addCriterion("meeting.work_order_num like", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotLike(String value) {
            addCriterion("meeting.work_order_num not like", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIn(List<String> values) {
            addCriterion("meeting.work_order_num in", values, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotIn(List<String> values) {
            addCriterion("meeting.work_order_num not in", values, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumBetween(String value1, String value2) {
            addCriterion("meeting.work_order_num between", value1, value2, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotBetween(String value1, String value2) {
            addCriterion("meeting.work_order_num not between", value1, value2, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("meeting.start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("meeting.start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("meeting.start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("meeting.start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("meeting.start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meeting.start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("meeting.start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("meeting.start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("meeting.start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("meeting.start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("meeting.start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("meeting.start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("meeting.end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("meeting.end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("meeting.end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("meeting.end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("meeting.end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meeting.end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("meeting.end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("meeting.end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("meeting.end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("meeting.end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("meeting.end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("meeting.end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdIsNull() {
            addCriterion("meeting.meeting_room_id is null");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdIsNotNull() {
            addCriterion("meeting.meeting_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdEqualTo(String value) {
            addCriterion("meeting.meeting_room_id =", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdNotEqualTo(String value) {
            addCriterion("meeting.meeting_room_id <>", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdGreaterThan(String value) {
            addCriterion("meeting.meeting_room_id >", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.meeting_room_id >=", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdLessThan(String value) {
            addCriterion("meeting.meeting_room_id <", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdLessThanOrEqualTo(String value) {
            addCriterion("meeting.meeting_room_id <=", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdLike(String value) {
            addCriterion("meeting.meeting_room_id like", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdNotLike(String value) {
            addCriterion("meeting.meeting_room_id not like", value, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdIn(List<String> values) {
            addCriterion("meeting.meeting_room_id in", values, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdNotIn(List<String> values) {
            addCriterion("meeting.meeting_room_id not in", values, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdBetween(String value1, String value2) {
            addCriterion("meeting.meeting_room_id between", value1, value2, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andMeetingRoomIdNotBetween(String value1, String value2) {
            addCriterion("meeting.meeting_room_id not between", value1, value2, "meetingRoomId");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("meeting.approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("meeting.approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(String value) {
            addCriterion("meeting.approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(String value) {
            addCriterion("meeting.approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(String value) {
            addCriterion("meeting.approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(String value) {
            addCriterion("meeting.approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(String value) {
            addCriterion("meeting.approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLike(String value) {
            addCriterion("meeting.approval_status like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotLike(String value) {
            addCriterion("meeting.approval_status not like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<String> values) {
            addCriterion("meeting.approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<String> values) {
            addCriterion("meeting.approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(String value1, String value2) {
            addCriterion("meeting.approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(String value1, String value2) {
            addCriterion("meeting.approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("meeting.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("meeting.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("meeting.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("meeting.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("meeting.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("meeting.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("meeting.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("meeting.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("meeting.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("meeting.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("meeting.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("meeting.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("meeting.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("meeting.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("meeting.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("meeting.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("meeting.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("meeting.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("meeting.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("meeting.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("meeting.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("meeting.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("meeting.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("meeting.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("meeting.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("meeting.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("meeting.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("meeting.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("meeting.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("meeting.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meeting.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("meeting.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("meeting.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("meeting.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("meeting.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("meeting.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("meeting.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("meeting.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("meeting.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("meeting.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("meeting.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("meeting.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("meeting.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("meeting.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("meeting.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("meeting.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("meeting.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("meeting.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("meeting.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("meeting.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("meeting.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("meeting.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("meeting.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("meeting.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("meeting.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meeting.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("meeting.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("meeting.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("meeting.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("meeting.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("meeting.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("meeting.modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andUserIdStrIsNull() {
            addCriterion("meeting.user_id_str is null");
            return (Criteria) this;
        }

        public Criteria andUserIdStrIsNotNull() {
            addCriterion("meeting.user_id_str is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdStrEqualTo(String value) {
            addCriterion("meeting.user_id_str =", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrNotEqualTo(String value) {
            addCriterion("meeting.user_id_str <>", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrGreaterThan(String value) {
            addCriterion("meeting.user_id_str >", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.user_id_str >=", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrLessThan(String value) {
            addCriterion("meeting.user_id_str <", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrLessThanOrEqualTo(String value) {
            addCriterion("meeting.user_id_str <=", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrLike(String value) {
            addCriterion("meeting.user_id_str like", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrNotLike(String value) {
            addCriterion("meeting.user_id_str not like", value, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrIn(List<String> values) {
            addCriterion("meeting.user_id_str in", values, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrNotIn(List<String> values) {
            addCriterion("meeting.user_id_str not in", values, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrBetween(String value1, String value2) {
            addCriterion("meeting.user_id_str between", value1, value2, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andUserIdStrNotBetween(String value1, String value2) {
            addCriterion("meeting.user_id_str not between", value1, value2, "userIdStr");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("meeting.applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("meeting.applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("meeting.applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("meeting.applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("meeting.applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("meeting.applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("meeting.applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("meeting.applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("meeting.applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("meeting.applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("meeting.applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("meeting.applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("meeting.applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("meeting.application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("meeting.application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("meeting.application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Date value) {
            addCriterion("meeting.application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Date value) {
            addCriterion("meeting.application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("meeting.application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Date value) {
            addCriterion("meeting.application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("meeting.application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Date> values) {
            addCriterion("meeting.application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Date> values) {
            addCriterion("meeting.application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("meeting.application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("meeting.application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andSignInQrIsNull() {
            addCriterion("meeting.sign_in_QR is null");
            return (Criteria) this;
        }

        public Criteria andSignInQrIsNotNull() {
            addCriterion("meeting.sign_in_QR is not null");
            return (Criteria) this;
        }

        public Criteria andSignInQrEqualTo(String value) {
            addCriterion("meeting.sign_in_QR =", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrNotEqualTo(String value) {
            addCriterion("meeting.sign_in_QR <>", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrGreaterThan(String value) {
            addCriterion("meeting.sign_in_QR >", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.sign_in_QR >=", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrLessThan(String value) {
            addCriterion("meeting.sign_in_QR <", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrLessThanOrEqualTo(String value) {
            addCriterion("meeting.sign_in_QR <=", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrLike(String value) {
            addCriterion("meeting.sign_in_QR like", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrNotLike(String value) {
            addCriterion("meeting.sign_in_QR not like", value, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrIn(List<String> values) {
            addCriterion("meeting.sign_in_QR in", values, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrNotIn(List<String> values) {
            addCriterion("meeting.sign_in_QR not in", values, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrBetween(String value1, String value2) {
            addCriterion("meeting.sign_in_QR between", value1, value2, "signInQr");
            return (Criteria) this;
        }

        public Criteria andSignInQrNotBetween(String value1, String value2) {
            addCriterion("meeting.sign_in_QR not between", value1, value2, "signInQr");
            return (Criteria) this;
        }

        public Criteria andWechatRemindIsNull() {
            addCriterion("meeting.wechat_remind is null");
            return (Criteria) this;
        }

        public Criteria andWechatRemindIsNotNull() {
            addCriterion("meeting.wechat_remind is not null");
            return (Criteria) this;
        }

        public Criteria andWechatRemindEqualTo(String value) {
            addCriterion("meeting.wechat_remind =", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotEqualTo(String value) {
            addCriterion("meeting.wechat_remind <>", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindGreaterThan(String value) {
            addCriterion("meeting.wechat_remind >", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.wechat_remind >=", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindLessThan(String value) {
            addCriterion("meeting.wechat_remind <", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindLessThanOrEqualTo(String value) {
            addCriterion("meeting.wechat_remind <=", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindLike(String value) {
            addCriterion("meeting.wechat_remind like", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotLike(String value) {
            addCriterion("meeting.wechat_remind not like", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindIn(List<String> values) {
            addCriterion("meeting.wechat_remind in", values, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotIn(List<String> values) {
            addCriterion("meeting.wechat_remind not in", values, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindBetween(String value1, String value2) {
            addCriterion("meeting.wechat_remind between", value1, value2, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotBetween(String value1, String value2) {
            addCriterion("meeting.wechat_remind not between", value1, value2, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIsNull() {
            addCriterion("meeting.message_remind is null");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIsNotNull() {
            addCriterion("meeting.message_remind is not null");
            return (Criteria) this;
        }

        public Criteria andMessageRemindEqualTo(String value) {
            addCriterion("meeting.message_remind =", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotEqualTo(String value) {
            addCriterion("meeting.message_remind <>", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindGreaterThan(String value) {
            addCriterion("meeting.message_remind >", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.message_remind >=", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLessThan(String value) {
            addCriterion("meeting.message_remind <", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLessThanOrEqualTo(String value) {
            addCriterion("meeting.message_remind <=", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLike(String value) {
            addCriterion("meeting.message_remind like", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotLike(String value) {
            addCriterion("meeting.message_remind not like", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIn(List<String> values) {
            addCriterion("meeting.message_remind in", values, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotIn(List<String> values) {
            addCriterion("meeting.message_remind not in", values, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindBetween(String value1, String value2) {
            addCriterion("meeting.message_remind between", value1, value2, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotBetween(String value1, String value2) {
            addCriterion("meeting.message_remind not between", value1, value2, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindIsNull() {
            addCriterion("meeting.pc_remind is null");
            return (Criteria) this;
        }

        public Criteria andPcRemindIsNotNull() {
            addCriterion("meeting.pc_remind is not null");
            return (Criteria) this;
        }

        public Criteria andPcRemindEqualTo(String value) {
            addCriterion("meeting.pc_remind =", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotEqualTo(String value) {
            addCriterion("meeting.pc_remind <>", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindGreaterThan(String value) {
            addCriterion("meeting.pc_remind >", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.pc_remind >=", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindLessThan(String value) {
            addCriterion("meeting.pc_remind <", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindLessThanOrEqualTo(String value) {
            addCriterion("meeting.pc_remind <=", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindLike(String value) {
            addCriterion("meeting.pc_remind like", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotLike(String value) {
            addCriterion("meeting.pc_remind not like", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindIn(List<String> values) {
            addCriterion("meeting.pc_remind in", values, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotIn(List<String> values) {
            addCriterion("meeting.pc_remind not in", values, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindBetween(String value1, String value2) {
            addCriterion("meeting.pc_remind between", value1, value2, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotBetween(String value1, String value2) {
            addCriterion("meeting.pc_remind not between", value1, value2, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindIsNull() {
            addCriterion("meeting.app_remind is null");
            return (Criteria) this;
        }

        public Criteria andAppRemindIsNotNull() {
            addCriterion("meeting.app_remind is not null");
            return (Criteria) this;
        }

        public Criteria andAppRemindEqualTo(String value) {
            addCriterion("meeting.app_remind =", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotEqualTo(String value) {
            addCriterion("meeting.app_remind <>", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindGreaterThan(String value) {
            addCriterion("meeting.app_remind >", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.app_remind >=", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindLessThan(String value) {
            addCriterion("meeting.app_remind <", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindLessThanOrEqualTo(String value) {
            addCriterion("meeting.app_remind <=", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindLike(String value) {
            addCriterion("meeting.app_remind like", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotLike(String value) {
            addCriterion("meeting.app_remind not like", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindIn(List<String> values) {
            addCriterion("meeting.app_remind in", values, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotIn(List<String> values) {
            addCriterion("meeting.app_remind not in", values, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindBetween(String value1, String value2) {
            addCriterion("meeting.app_remind between", value1, value2, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotBetween(String value1, String value2) {
            addCriterion("meeting.app_remind not between", value1, value2, "appRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNull() {
            addCriterion("meeting.is_remind is null");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNotNull() {
            addCriterion("meeting.is_remind is not null");
            return (Criteria) this;
        }

        public Criteria andIsRemindEqualTo(String value) {
            addCriterion("meeting.is_remind =", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotEqualTo(String value) {
            addCriterion("meeting.is_remind <>", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThan(String value) {
            addCriterion("meeting.is_remind >", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.is_remind >=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThan(String value) {
            addCriterion("meeting.is_remind <", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThanOrEqualTo(String value) {
            addCriterion("meeting.is_remind <=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLike(String value) {
            addCriterion("meeting.is_remind like", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotLike(String value) {
            addCriterion("meeting.is_remind not like", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindIn(List<String> values) {
            addCriterion("meeting.is_remind in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotIn(List<String> values) {
            addCriterion("meeting.is_remind not in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindBetween(String value1, String value2) {
            addCriterion("meeting.is_remind between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotBetween(String value1, String value2) {
            addCriterion("meeting.is_remind not between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("meeting.title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("meeting.title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("meeting.title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("meeting.title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("meeting.title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("meeting.title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("meeting.title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("meeting.title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("meeting.title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("meeting.title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("meeting.title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("meeting.title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("meeting.title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleIsNull() {
            addCriterion("meeting.approval_role is null");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleIsNotNull() {
            addCriterion("meeting.approval_role is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleEqualTo(String value) {
            addCriterion("meeting.approval_role =", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleNotEqualTo(String value) {
            addCriterion("meeting.approval_role <>", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleGreaterThan(String value) {
            addCriterion("meeting.approval_role >", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.approval_role >=", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleLessThan(String value) {
            addCriterion("meeting.approval_role <", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleLessThanOrEqualTo(String value) {
            addCriterion("meeting.approval_role <=", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleLike(String value) {
            addCriterion("meeting.approval_role like", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleNotLike(String value) {
            addCriterion("meeting.approval_role not like", value, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleIn(List<String> values) {
            addCriterion("meeting.approval_role in", values, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleNotIn(List<String> values) {
            addCriterion("meeting.approval_role not in", values, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleBetween(String value1, String value2) {
            addCriterion("meeting.approval_role between", value1, value2, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalRoleNotBetween(String value1, String value2) {
            addCriterion("meeting.approval_role not between", value1, value2, "approvalRole");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIsNull() {
            addCriterion("meeting.approval_user is null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIsNotNull() {
            addCriterion("meeting.approval_user is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserEqualTo(String value) {
            addCriterion("meeting.approval_user =", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotEqualTo(String value) {
            addCriterion("meeting.approval_user <>", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserGreaterThan(String value) {
            addCriterion("meeting.approval_user >", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.approval_user >=", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLessThan(String value) {
            addCriterion("meeting.approval_user <", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLessThanOrEqualTo(String value) {
            addCriterion("meeting.approval_user <=", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLike(String value) {
            addCriterion("meeting.approval_user like", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotLike(String value) {
            addCriterion("meeting.approval_user not like", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIn(List<String> values) {
            addCriterion("meeting.approval_user in", values, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotIn(List<String> values) {
            addCriterion("meeting.approval_user not in", values, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserBetween(String value1, String value2) {
            addCriterion("meeting.approval_user between", value1, value2, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotBetween(String value1, String value2) {
            addCriterion("meeting.approval_user not between", value1, value2, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNull() {
            addCriterion("meeting.approval_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIsNotNull() {
            addCriterion("meeting.approval_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionEqualTo(String value) {
            addCriterion("meeting.approval_opinion =", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotEqualTo(String value) {
            addCriterion("meeting.approval_opinion <>", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThan(String value) {
            addCriterion("meeting.approval_opinion >", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.approval_opinion >=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThan(String value) {
            addCriterion("meeting.approval_opinion <", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLessThanOrEqualTo(String value) {
            addCriterion("meeting.approval_opinion <=", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionLike(String value) {
            addCriterion("meeting.approval_opinion like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotLike(String value) {
            addCriterion("meeting.approval_opinion not like", value, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionIn(List<String> values) {
            addCriterion("meeting.approval_opinion in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotIn(List<String> values) {
            addCriterion("meeting.approval_opinion not in", values, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionBetween(String value1, String value2) {
            addCriterion("meeting.approval_opinion between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andApprovalOpinionNotBetween(String value1, String value2) {
            addCriterion("meeting.approval_opinion not between", value1, value2, "approvalOpinion");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusIsNull() {
            addCriterion("meeting.meeting_status is null");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusIsNotNull() {
            addCriterion("meeting.meeting_status is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusEqualTo(String value) {
            addCriterion("meeting.meeting_status =", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusNotEqualTo(String value) {
            addCriterion("meeting.meeting_status <>", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusGreaterThan(String value) {
            addCriterion("meeting.meeting_status >", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("meeting.meeting_status >=", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusLessThan(String value) {
            addCriterion("meeting.meeting_status <", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusLessThanOrEqualTo(String value) {
            addCriterion("meeting.meeting_status <=", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusLike(String value) {
            addCriterion("meeting.meeting_status like", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusNotLike(String value) {
            addCriterion("meeting.meeting_status not like", value, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusIn(List<String> values) {
            addCriterion("meeting.meeting_status in", values, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusNotIn(List<String> values) {
            addCriterion("meeting.meeting_status not in", values, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusBetween(String value1, String value2) {
            addCriterion("meeting.meeting_status between", value1, value2, "meetingStatus");
            return (Criteria) this;
        }

        public Criteria andMeetingStatusNotBetween(String value1, String value2) {
            addCriterion("meeting.meeting_status not between", value1, value2, "meetingStatus");
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