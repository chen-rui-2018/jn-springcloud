package com.jn.park.gamtopic.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPersonCareCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPersonCareCriteria() {
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

        public Criteria andCareIdIsNull() {
            addCriterion("care_id is null");
            return (Criteria) this;
        }

        public Criteria andCareIdIsNotNull() {
            addCriterion("care_id is not null");
            return (Criteria) this;
        }

        public Criteria andCareIdEqualTo(String value) {
            addCriterion("care_id =", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotEqualTo(String value) {
            addCriterion("care_id <>", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdGreaterThan(String value) {
            addCriterion("care_id >", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdGreaterThanOrEqualTo(String value) {
            addCriterion("care_id >=", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLessThan(String value) {
            addCriterion("care_id <", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLessThanOrEqualTo(String value) {
            addCriterion("care_id <=", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdLike(String value) {
            addCriterion("care_id like", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotLike(String value) {
            addCriterion("care_id not like", value, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdIn(List<String> values) {
            addCriterion("care_id in", values, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotIn(List<String> values) {
            addCriterion("care_id not in", values, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdBetween(String value1, String value2) {
            addCriterion("care_id between", value1, value2, "careId");
            return (Criteria) this;
        }

        public Criteria andCareIdNotBetween(String value1, String value2) {
            addCriterion("care_id not between", value1, value2, "careId");
            return (Criteria) this;
        }

        public Criteria andCareAccountIsNull() {
            addCriterion("care_account is null");
            return (Criteria) this;
        }

        public Criteria andCareAccountIsNotNull() {
            addCriterion("care_account is not null");
            return (Criteria) this;
        }

        public Criteria andCareAccountEqualTo(String value) {
            addCriterion("care_account =", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotEqualTo(String value) {
            addCriterion("care_account <>", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountGreaterThan(String value) {
            addCriterion("care_account >", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountGreaterThanOrEqualTo(String value) {
            addCriterion("care_account >=", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountLessThan(String value) {
            addCriterion("care_account <", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountLessThanOrEqualTo(String value) {
            addCriterion("care_account <=", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountLike(String value) {
            addCriterion("care_account like", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotLike(String value) {
            addCriterion("care_account not like", value, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountIn(List<String> values) {
            addCriterion("care_account in", values, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotIn(List<String> values) {
            addCriterion("care_account not in", values, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountBetween(String value1, String value2) {
            addCriterion("care_account between", value1, value2, "careAccount");
            return (Criteria) this;
        }

        public Criteria andCareAccountNotBetween(String value1, String value2) {
            addCriterion("care_account not between", value1, value2, "careAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountIsNull() {
            addCriterion("receive_account is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountIsNotNull() {
            addCriterion("receive_account is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountEqualTo(String value) {
            addCriterion("receive_account =", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotEqualTo(String value) {
            addCriterion("receive_account <>", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountGreaterThan(String value) {
            addCriterion("receive_account >", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountGreaterThanOrEqualTo(String value) {
            addCriterion("receive_account >=", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountLessThan(String value) {
            addCriterion("receive_account <", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountLessThanOrEqualTo(String value) {
            addCriterion("receive_account <=", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountLike(String value) {
            addCriterion("receive_account like", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotLike(String value) {
            addCriterion("receive_account not like", value, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountIn(List<String> values) {
            addCriterion("receive_account in", values, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotIn(List<String> values) {
            addCriterion("receive_account not in", values, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountBetween(String value1, String value2) {
            addCriterion("receive_account between", value1, value2, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveAccountNotBetween(String value1, String value2) {
            addCriterion("receive_account not between", value1, value2, "receiveAccount");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIsNull() {
            addCriterion("receive_type is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIsNotNull() {
            addCriterion("receive_type is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeEqualTo(String value) {
            addCriterion("receive_type =", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotEqualTo(String value) {
            addCriterion("receive_type <>", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeGreaterThan(String value) {
            addCriterion("receive_type >", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("receive_type >=", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLessThan(String value) {
            addCriterion("receive_type <", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLessThanOrEqualTo(String value) {
            addCriterion("receive_type <=", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeLike(String value) {
            addCriterion("receive_type like", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotLike(String value) {
            addCriterion("receive_type not like", value, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeIn(List<String> values) {
            addCriterion("receive_type in", values, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotIn(List<String> values) {
            addCriterion("receive_type not in", values, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeBetween(String value1, String value2) {
            addCriterion("receive_type between", value1, value2, "receiveType");
            return (Criteria) this;
        }

        public Criteria andReceiveTypeNotBetween(String value1, String value2) {
            addCriterion("receive_type not between", value1, value2, "receiveType");
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