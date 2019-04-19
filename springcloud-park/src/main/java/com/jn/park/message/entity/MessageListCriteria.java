package com.jn.park.message.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageListCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageListCriteria() {
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
            addCriterion("message.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("message.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("message.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("message.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("message.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("message.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("message.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("message.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("message.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("message.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMessageTitleIsNull() {
            addCriterion("message.message_title is null");
            return (Criteria) this;
        }

        public Criteria andMessageTitleIsNotNull() {
            addCriterion("message.message_title is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTitleEqualTo(String value) {
            addCriterion("message.message_title =", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotEqualTo(String value) {
            addCriterion("message.message_title <>", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleGreaterThan(String value) {
            addCriterion("message.message_title >", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleGreaterThanOrEqualTo(String value) {
            addCriterion("message.message_title >=", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleLessThan(String value) {
            addCriterion("message.message_title <", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleLessThanOrEqualTo(String value) {
            addCriterion("message.message_title <=", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleLike(String value) {
            addCriterion("message.message_title like", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotLike(String value) {
            addCriterion("message.message_title not like", value, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleIn(List<String> values) {
            addCriterion("message.message_title in", values, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotIn(List<String> values) {
            addCriterion("message.message_title not in", values, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleBetween(String value1, String value2) {
            addCriterion("message.message_title between", value1, value2, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageTitleNotBetween(String value1, String value2) {
            addCriterion("message.message_title not between", value1, value2, "messageTitle");
            return (Criteria) this;
        }

        public Criteria andMessageConnectIsNull() {
            addCriterion("message.message_connect is null");
            return (Criteria) this;
        }

        public Criteria andMessageConnectIsNotNull() {
            addCriterion("message.message_connect is not null");
            return (Criteria) this;
        }

        public Criteria andMessageConnectEqualTo(String value) {
            addCriterion("message.message_connect =", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectNotEqualTo(String value) {
            addCriterion("message.message_connect <>", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectGreaterThan(String value) {
            addCriterion("message.message_connect >", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectGreaterThanOrEqualTo(String value) {
            addCriterion("message.message_connect >=", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectLessThan(String value) {
            addCriterion("message.message_connect <", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectLessThanOrEqualTo(String value) {
            addCriterion("message.message_connect <=", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectLike(String value) {
            addCriterion("message.message_connect like", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectNotLike(String value) {
            addCriterion("message.message_connect not like", value, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectIn(List<String> values) {
            addCriterion("message.message_connect in", values, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectNotIn(List<String> values) {
            addCriterion("message.message_connect not in", values, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectBetween(String value1, String value2) {
            addCriterion("message.message_connect between", value1, value2, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andMessageConnectNotBetween(String value1, String value2) {
            addCriterion("message.message_connect not between", value1, value2, "messageConnect");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("message.is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("message.is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("message.is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("message.is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("message.is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("message.is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("message.is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("message.is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("message.is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("message.is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("message.is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("message.is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientIsNull() {
            addCriterion("message.message_recipient is null");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientIsNotNull() {
            addCriterion("message.message_recipient is not null");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientEqualTo(String value) {
            addCriterion("message.message_recipient =", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientNotEqualTo(String value) {
            addCriterion("message.message_recipient <>", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientGreaterThan(String value) {
            addCriterion("message.message_recipient >", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientGreaterThanOrEqualTo(String value) {
            addCriterion("message.message_recipient >=", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientLessThan(String value) {
            addCriterion("message.message_recipient <", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientLessThanOrEqualTo(String value) {
            addCriterion("message.message_recipient <=", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientLike(String value) {
            addCriterion("message.message_recipient like", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientNotLike(String value) {
            addCriterion("message.message_recipient not like", value, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientIn(List<String> values) {
            addCriterion("message.message_recipient in", values, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientNotIn(List<String> values) {
            addCriterion("message.message_recipient not in", values, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientBetween(String value1, String value2) {
            addCriterion("message.message_recipient between", value1, value2, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageRecipientNotBetween(String value1, String value2) {
            addCriterion("message.message_recipient not between", value1, value2, "messageRecipient");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIsNull() {
            addCriterion("message.message_sender is null");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIsNotNull() {
            addCriterion("message.message_sender is not null");
            return (Criteria) this;
        }

        public Criteria andMessageSenderEqualTo(String value) {
            addCriterion("message.message_sender =", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNotEqualTo(String value) {
            addCriterion("message.message_sender <>", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderGreaterThan(String value) {
            addCriterion("message.message_sender >", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderGreaterThanOrEqualTo(String value) {
            addCriterion("message.message_sender >=", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderLessThan(String value) {
            addCriterion("message.message_sender <", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderLessThanOrEqualTo(String value) {
            addCriterion("message.message_sender <=", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderLike(String value) {
            addCriterion("message.message_sender like", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNotLike(String value) {
            addCriterion("message.message_sender not like", value, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderIn(List<String> values) {
            addCriterion("message.message_sender in", values, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNotIn(List<String> values) {
            addCriterion("message.message_sender not in", values, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderBetween(String value1, String value2) {
            addCriterion("message.message_sender between", value1, value2, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageSenderNotBetween(String value1, String value2) {
            addCriterion("message.message_sender not between", value1, value2, "messageSender");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortIsNull() {
            addCriterion("message.message_one_sort is null");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortIsNotNull() {
            addCriterion("message.message_one_sort is not null");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortEqualTo(Integer value) {
            addCriterion("message.message_one_sort =", value, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortNotEqualTo(Integer value) {
            addCriterion("message.message_one_sort <>", value, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortGreaterThan(Integer value) {
            addCriterion("message.message_one_sort >", value, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("message.message_one_sort >=", value, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortLessThan(Integer value) {
            addCriterion("message.message_one_sort <", value, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortLessThanOrEqualTo(Integer value) {
            addCriterion("message.message_one_sort <=", value, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortIn(List<Integer> values) {
            addCriterion("message.message_one_sort in", values, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortNotIn(List<Integer> values) {
            addCriterion("message.message_one_sort not in", values, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortBetween(Integer value1, Integer value2) {
            addCriterion("message.message_one_sort between", value1, value2, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageOneSortNotBetween(Integer value1, Integer value2) {
            addCriterion("message.message_one_sort not between", value1, value2, "messageOneSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortIsNull() {
            addCriterion("message.message_tow_sort is null");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortIsNotNull() {
            addCriterion("message.message_tow_sort is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortEqualTo(Integer value) {
            addCriterion("message.message_tow_sort =", value, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortNotEqualTo(Integer value) {
            addCriterion("message.message_tow_sort <>", value, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortGreaterThan(Integer value) {
            addCriterion("message.message_tow_sort >", value, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("message.message_tow_sort >=", value, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortLessThan(Integer value) {
            addCriterion("message.message_tow_sort <", value, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortLessThanOrEqualTo(Integer value) {
            addCriterion("message.message_tow_sort <=", value, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortIn(List<Integer> values) {
            addCriterion("message.message_tow_sort in", values, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortNotIn(List<Integer> values) {
            addCriterion("message.message_tow_sort not in", values, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortBetween(Integer value1, Integer value2) {
            addCriterion("message.message_tow_sort between", value1, value2, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andMessageTowSortNotBetween(Integer value1, Integer value2) {
            addCriterion("message.message_tow_sort not between", value1, value2, "messageTowSort");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("message.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("message.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("message.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("message.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("message.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("message.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("message.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("message.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("message.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("message.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("message.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("message.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("message.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("message.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("message.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("message.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("message.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("message.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("message.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("message.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("message.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("message.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("message.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("message.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("message.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("message.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("message.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("message.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("message.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("message.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("message.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("message.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("message.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("message.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("message.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("message.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("message.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("message.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("message.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("message.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("message.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("message.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("message.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("message.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("message.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("message.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("message.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("message.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("message.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("message.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("message.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("message.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("message.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("message.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("message.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("message.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("message.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("message.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("message.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("message.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("message.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("message.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("message.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("message.modified_time not between", value1, value2, "modifiedTime");
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