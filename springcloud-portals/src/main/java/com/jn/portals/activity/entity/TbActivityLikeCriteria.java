package com.jn.portals.activity.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbActivityLikeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbActivityLikeCriteria() {
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
            addCriterion("activityLike.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("activityLike.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("activityLike.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("activityLike.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("activityLike.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityLike.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("activityLike.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("activityLike.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("activityLike.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("activityLike.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("activityLike.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("activityLike.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("activityLike.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("activityLike.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activityLike.activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activityLike.activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activityLike.activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activityLike.activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activityLike.activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityLike.activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activityLike.activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activityLike.activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activityLike.activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activityLike.activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activityLike.activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activityLike.activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activityLike.activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activityLike.activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNull() {
            addCriterion("activityLike.like_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIsNotNull() {
            addCriterion("activityLike.like_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdEqualTo(String value) {
            addCriterion("activityLike.like_user_id =", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotEqualTo(String value) {
            addCriterion("activityLike.like_user_id <>", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThan(String value) {
            addCriterion("activityLike.like_user_id >", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityLike.like_user_id >=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThan(String value) {
            addCriterion("activityLike.like_user_id <", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLessThanOrEqualTo(String value) {
            addCriterion("activityLike.like_user_id <=", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdLike(String value) {
            addCriterion("activityLike.like_user_id like", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotLike(String value) {
            addCriterion("activityLike.like_user_id not like", value, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdIn(List<String> values) {
            addCriterion("activityLike.like_user_id in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotIn(List<String> values) {
            addCriterion("activityLike.like_user_id not in", values, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdBetween(String value1, String value2) {
            addCriterion("activityLike.like_user_id between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeUserIdNotBetween(String value1, String value2) {
            addCriterion("activityLike.like_user_id not between", value1, value2, "likeUserId");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("activityLike.like_time is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("activityLike.like_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("activityLike.like_time =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("activityLike.like_time <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("activityLike.like_time >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityLike.like_time >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("activityLike.like_time <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("activityLike.like_time <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("activityLike.like_time in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("activityLike.like_time not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("activityLike.like_time between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("activityLike.like_time not between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("activityLike.state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("activityLike.state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("activityLike.state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("activityLike.state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("activityLike.state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("activityLike.state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("activityLike.state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("activityLike.state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("activityLike.state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("activityLike.state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("activityLike.state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("activityLike.state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("activityLike.state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("activityLike.state not between", value1, value2, "state");
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