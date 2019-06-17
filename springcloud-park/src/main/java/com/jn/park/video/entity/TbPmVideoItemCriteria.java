package com.jn.park.video.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPmVideoItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPmVideoItemCriteria() {
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

        public Criteria andVideoIdIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(String value) {
            addCriterion("video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(String value) {
            addCriterion("video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(String value) {
            addCriterion("video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(String value) {
            addCriterion("video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(String value) {
            addCriterion("video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(String value) {
            addCriterion("video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLike(String value) {
            addCriterion("video_id like", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotLike(String value) {
            addCriterion("video_id not like", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<String> values) {
            addCriterion("video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<String> values) {
            addCriterion("video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(String value1, String value2) {
            addCriterion("video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(String value1, String value2) {
            addCriterion("video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIsNull() {
            addCriterion("video_title is null");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIsNotNull() {
            addCriterion("video_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideoTitleEqualTo(String value) {
            addCriterion("video_title =", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotEqualTo(String value) {
            addCriterion("video_title <>", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleGreaterThan(String value) {
            addCriterion("video_title >", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("video_title >=", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLessThan(String value) {
            addCriterion("video_title <", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLessThanOrEqualTo(String value) {
            addCriterion("video_title <=", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLike(String value) {
            addCriterion("video_title like", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotLike(String value) {
            addCriterion("video_title not like", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIn(List<String> values) {
            addCriterion("video_title in", values, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotIn(List<String> values) {
            addCriterion("video_title not in", values, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleBetween(String value1, String value2) {
            addCriterion("video_title between", value1, value2, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotBetween(String value1, String value2) {
            addCriterion("video_title not between", value1, value2, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("operation is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("operation is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(String value) {
            addCriterion("operation =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(String value) {
            addCriterion("operation <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(String value) {
            addCriterion("operation >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(String value) {
            addCriterion("operation >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(String value) {
            addCriterion("operation <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(String value) {
            addCriterion("operation <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLike(String value) {
            addCriterion("operation like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotLike(String value) {
            addCriterion("operation not like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<String> values) {
            addCriterion("operation in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<String> values) {
            addCriterion("operation not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(String value1, String value2) {
            addCriterion("operation between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(String value1, String value2) {
            addCriterion("operation not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlIsNull() {
            addCriterion("video_play_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlIsNotNull() {
            addCriterion("video_play_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlEqualTo(String value) {
            addCriterion("video_play_url =", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlNotEqualTo(String value) {
            addCriterion("video_play_url <>", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlGreaterThan(String value) {
            addCriterion("video_play_url >", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_play_url >=", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlLessThan(String value) {
            addCriterion("video_play_url <", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlLessThanOrEqualTo(String value) {
            addCriterion("video_play_url <=", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlLike(String value) {
            addCriterion("video_play_url like", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlNotLike(String value) {
            addCriterion("video_play_url not like", value, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlIn(List<String> values) {
            addCriterion("video_play_url in", values, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlNotIn(List<String> values) {
            addCriterion("video_play_url not in", values, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlBetween(String value1, String value2) {
            addCriterion("video_play_url between", value1, value2, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoPlayUrlNotBetween(String value1, String value2) {
            addCriterion("video_play_url not between", value1, value2, "videoPlayUrl");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeIsNull() {
            addCriterion("video_start_time is null");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeIsNotNull() {
            addCriterion("video_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeEqualTo(Date value) {
            addCriterion("video_start_time =", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotEqualTo(Date value) {
            addCriterion("video_start_time <>", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeGreaterThan(Date value) {
            addCriterion("video_start_time >", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("video_start_time >=", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeLessThan(Date value) {
            addCriterion("video_start_time <", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("video_start_time <=", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeIn(List<Date> values) {
            addCriterion("video_start_time in", values, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotIn(List<Date> values) {
            addCriterion("video_start_time not in", values, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeBetween(Date value1, Date value2) {
            addCriterion("video_start_time between", value1, value2, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("video_start_time not between", value1, value2, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeIsNull() {
            addCriterion("video_end_time is null");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeIsNotNull() {
            addCriterion("video_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeEqualTo(Date value) {
            addCriterion("video_end_time =", value, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeNotEqualTo(Date value) {
            addCriterion("video_end_time <>", value, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeGreaterThan(Date value) {
            addCriterion("video_end_time >", value, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("video_end_time >=", value, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeLessThan(Date value) {
            addCriterion("video_end_time <", value, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("video_end_time <=", value, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeIn(List<Date> values) {
            addCriterion("video_end_time in", values, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeNotIn(List<Date> values) {
            addCriterion("video_end_time not in", values, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeBetween(Date value1, Date value2) {
            addCriterion("video_end_time between", value1, value2, "videoEndTime");
            return (Criteria) this;
        }

        public Criteria andVideoEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("video_end_time not between", value1, value2, "videoEndTime");
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