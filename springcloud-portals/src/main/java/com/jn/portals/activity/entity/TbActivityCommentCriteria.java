package com.jn.portals.activity.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbActivityCommentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbActivityCommentCriteria() {
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
            addCriterion("activityComment.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("activityComment.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("activityComment.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("activityComment.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("activityComment.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityComment.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("activityComment.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("activityComment.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("activityComment.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("activityComment.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("activityComment.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("activityComment.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("activityComment.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("activityComment.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("activityComment.p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("activityComment.p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(String value) {
            addCriterion("activityComment.p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(String value) {
            addCriterion("activityComment.p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(String value) {
            addCriterion("activityComment.p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityComment.p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(String value) {
            addCriterion("activityComment.p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(String value) {
            addCriterion("activityComment.p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLike(String value) {
            addCriterion("activityComment.p_id like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotLike(String value) {
            addCriterion("activityComment.p_id not like", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<String> values) {
            addCriterion("activityComment.p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<String> values) {
            addCriterion("activityComment.p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(String value1, String value2) {
            addCriterion("activityComment.p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(String value1, String value2) {
            addCriterion("activityComment.p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andComUserIdIsNull() {
            addCriterion("activityComment.com_user_id is null");
            return (Criteria) this;
        }

        public Criteria andComUserIdIsNotNull() {
            addCriterion("activityComment.com_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andComUserIdEqualTo(String value) {
            addCriterion("activityComment.com_user_id =", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdNotEqualTo(String value) {
            addCriterion("activityComment.com_user_id <>", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdGreaterThan(String value) {
            addCriterion("activityComment.com_user_id >", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityComment.com_user_id >=", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdLessThan(String value) {
            addCriterion("activityComment.com_user_id <", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdLessThanOrEqualTo(String value) {
            addCriterion("activityComment.com_user_id <=", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdLike(String value) {
            addCriterion("activityComment.com_user_id like", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdNotLike(String value) {
            addCriterion("activityComment.com_user_id not like", value, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdIn(List<String> values) {
            addCriterion("activityComment.com_user_id in", values, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdNotIn(List<String> values) {
            addCriterion("activityComment.com_user_id not in", values, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdBetween(String value1, String value2) {
            addCriterion("activityComment.com_user_id between", value1, value2, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComUserIdNotBetween(String value1, String value2) {
            addCriterion("activityComment.com_user_id not between", value1, value2, "comUserId");
            return (Criteria) this;
        }

        public Criteria andComTimeIsNull() {
            addCriterion("activityComment.com_time is null");
            return (Criteria) this;
        }

        public Criteria andComTimeIsNotNull() {
            addCriterion("activityComment.com_time is not null");
            return (Criteria) this;
        }

        public Criteria andComTimeEqualTo(Date value) {
            addCriterion("activityComment.com_time =", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotEqualTo(Date value) {
            addCriterion("activityComment.com_time <>", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeGreaterThan(Date value) {
            addCriterion("activityComment.com_time >", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityComment.com_time >=", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeLessThan(Date value) {
            addCriterion("activityComment.com_time <", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeLessThanOrEqualTo(Date value) {
            addCriterion("activityComment.com_time <=", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeIn(List<Date> values) {
            addCriterion("activityComment.com_time in", values, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotIn(List<Date> values) {
            addCriterion("activityComment.com_time not in", values, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeBetween(Date value1, Date value2) {
            addCriterion("activityComment.com_time between", value1, value2, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotBetween(Date value1, Date value2) {
            addCriterion("activityComment.com_time not between", value1, value2, "comTime");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNull() {
            addCriterion("activityComment.like_num is null");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNotNull() {
            addCriterion("activityComment.like_num is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNumEqualTo(Integer value) {
            addCriterion("activityComment.like_num =", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotEqualTo(Integer value) {
            addCriterion("activityComment.like_num <>", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThan(Integer value) {
            addCriterion("activityComment.like_num >", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activityComment.like_num >=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThan(Integer value) {
            addCriterion("activityComment.like_num <", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("activityComment.like_num <=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumIn(List<Integer> values) {
            addCriterion("activityComment.like_num in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotIn(List<Integer> values) {
            addCriterion("activityComment.like_num not in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumBetween(Integer value1, Integer value2) {
            addCriterion("activityComment.like_num between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("activityComment.like_num not between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("activityComment.state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("activityComment.state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("activityComment.state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("activityComment.state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("activityComment.state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("activityComment.state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("activityComment.state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("activityComment.state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("activityComment.state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("activityComment.state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("activityComment.state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("activityComment.state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("activityComment.state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("activityComment.state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNull() {
            addCriterion("activityComment.com_type is null");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNotNull() {
            addCriterion("activityComment.com_type is not null");
            return (Criteria) this;
        }

        public Criteria andComTypeEqualTo(String value) {
            addCriterion("activityComment.com_type =", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotEqualTo(String value) {
            addCriterion("activityComment.com_type <>", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThan(String value) {
            addCriterion("activityComment.com_type >", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThanOrEqualTo(String value) {
            addCriterion("activityComment.com_type >=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThan(String value) {
            addCriterion("activityComment.com_type <", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThanOrEqualTo(String value) {
            addCriterion("activityComment.com_type <=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLike(String value) {
            addCriterion("activityComment.com_type like", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotLike(String value) {
            addCriterion("activityComment.com_type not like", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeIn(List<String> values) {
            addCriterion("activityComment.com_type in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotIn(List<String> values) {
            addCriterion("activityComment.com_type not in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeBetween(String value1, String value2) {
            addCriterion("activityComment.com_type between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotBetween(String value1, String value2) {
            addCriterion("activityComment.com_type not between", value1, value2, "comType");
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