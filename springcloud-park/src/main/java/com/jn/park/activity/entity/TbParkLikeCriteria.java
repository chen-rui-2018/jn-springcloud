package com.jn.park.activity.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParkLikeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkLikeCriteria() {
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

        public Criteria andLikeParentIdIsNull() {
            addCriterion("like_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdIsNotNull() {
            addCriterion("like_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdEqualTo(String value) {
            addCriterion("like_parent_id =", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdNotEqualTo(String value) {
            addCriterion("like_parent_id <>", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdGreaterThan(String value) {
            addCriterion("like_parent_id >", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("like_parent_id >=", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdLessThan(String value) {
            addCriterion("like_parent_id <", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdLessThanOrEqualTo(String value) {
            addCriterion("like_parent_id <=", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdLike(String value) {
            addCriterion("like_parent_id like", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdNotLike(String value) {
            addCriterion("like_parent_id not like", value, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdIn(List<String> values) {
            addCriterion("like_parent_id in", values, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdNotIn(List<String> values) {
            addCriterion("like_parent_id not in", values, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdBetween(String value1, String value2) {
            addCriterion("like_parent_id between", value1, value2, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeParentIdNotBetween(String value1, String value2) {
            addCriterion("like_parent_id not between", value1, value2, "likeParentId");
            return (Criteria) this;
        }

        public Criteria andLikeAccountIsNull() {
            addCriterion("like_account is null");
            return (Criteria) this;
        }

        public Criteria andLikeAccountIsNotNull() {
            addCriterion("like_account is not null");
            return (Criteria) this;
        }

        public Criteria andLikeAccountEqualTo(String value) {
            addCriterion("like_account =", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountNotEqualTo(String value) {
            addCriterion("like_account <>", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountGreaterThan(String value) {
            addCriterion("like_account >", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountGreaterThanOrEqualTo(String value) {
            addCriterion("like_account >=", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountLessThan(String value) {
            addCriterion("like_account <", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountLessThanOrEqualTo(String value) {
            addCriterion("like_account <=", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountLike(String value) {
            addCriterion("like_account like", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountNotLike(String value) {
            addCriterion("like_account not like", value, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountIn(List<String> values) {
            addCriterion("like_account in", values, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountNotIn(List<String> values) {
            addCriterion("like_account not in", values, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountBetween(String value1, String value2) {
            addCriterion("like_account between", value1, value2, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeAccountNotBetween(String value1, String value2) {
            addCriterion("like_account not between", value1, value2, "likeAccount");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("like_time is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("like_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("like_time =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("like_time <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("like_time >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("like_time >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("like_time <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("like_time <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("like_time in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("like_time not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("like_time between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("like_time not between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeStatusIsNull() {
            addCriterion("like_status is null");
            return (Criteria) this;
        }

        public Criteria andLikeStatusIsNotNull() {
            addCriterion("like_status is not null");
            return (Criteria) this;
        }

        public Criteria andLikeStatusEqualTo(String value) {
            addCriterion("like_status =", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusNotEqualTo(String value) {
            addCriterion("like_status <>", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusGreaterThan(String value) {
            addCriterion("like_status >", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("like_status >=", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusLessThan(String value) {
            addCriterion("like_status <", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusLessThanOrEqualTo(String value) {
            addCriterion("like_status <=", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusLike(String value) {
            addCriterion("like_status like", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusNotLike(String value) {
            addCriterion("like_status not like", value, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusIn(List<String> values) {
            addCriterion("like_status in", values, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusNotIn(List<String> values) {
            addCriterion("like_status not in", values, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusBetween(String value1, String value2) {
            addCriterion("like_status between", value1, value2, "likeStatus");
            return (Criteria) this;
        }

        public Criteria andLikeStatusNotBetween(String value1, String value2) {
            addCriterion("like_status not between", value1, value2, "likeStatus");
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

        public Criteria andRecordStatusEqualTo(Boolean value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Boolean value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Boolean value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Boolean value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Boolean> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Boolean> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Boolean value1, Boolean value2) {
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