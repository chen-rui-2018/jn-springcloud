package com.jn.servicemarket.advisor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceRatingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceRatingCriteria() {
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

        public Criteria andCommentObjIdIsNull() {
            addCriterion("comment_obj_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdIsNotNull() {
            addCriterion("comment_obj_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdEqualTo(String value) {
            addCriterion("comment_obj_id =", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdNotEqualTo(String value) {
            addCriterion("comment_obj_id <>", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdGreaterThan(String value) {
            addCriterion("comment_obj_id >", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdGreaterThanOrEqualTo(String value) {
            addCriterion("comment_obj_id >=", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdLessThan(String value) {
            addCriterion("comment_obj_id <", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdLessThanOrEqualTo(String value) {
            addCriterion("comment_obj_id <=", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdLike(String value) {
            addCriterion("comment_obj_id like", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdNotLike(String value) {
            addCriterion("comment_obj_id not like", value, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdIn(List<String> values) {
            addCriterion("comment_obj_id in", values, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdNotIn(List<String> values) {
            addCriterion("comment_obj_id not in", values, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdBetween(String value1, String value2) {
            addCriterion("comment_obj_id between", value1, value2, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjIdNotBetween(String value1, String value2) {
            addCriterion("comment_obj_id not between", value1, value2, "commentObjId");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameIsNull() {
            addCriterion("comment_obj_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameIsNotNull() {
            addCriterion("comment_obj_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameEqualTo(String value) {
            addCriterion("comment_obj_name =", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameNotEqualTo(String value) {
            addCriterion("comment_obj_name <>", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameGreaterThan(String value) {
            addCriterion("comment_obj_name >", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameGreaterThanOrEqualTo(String value) {
            addCriterion("comment_obj_name >=", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameLessThan(String value) {
            addCriterion("comment_obj_name <", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameLessThanOrEqualTo(String value) {
            addCriterion("comment_obj_name <=", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameLike(String value) {
            addCriterion("comment_obj_name like", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameNotLike(String value) {
            addCriterion("comment_obj_name not like", value, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameIn(List<String> values) {
            addCriterion("comment_obj_name in", values, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameNotIn(List<String> values) {
            addCriterion("comment_obj_name not in", values, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameBetween(String value1, String value2) {
            addCriterion("comment_obj_name between", value1, value2, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andCommentObjNameNotBetween(String value1, String value2) {
            addCriterion("comment_obj_name not between", value1, value2, "commentObjName");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreIsNull() {
            addCriterion("attitude_score is null");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreIsNotNull() {
            addCriterion("attitude_score is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreEqualTo(String value) {
            addCriterion("attitude_score =", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreNotEqualTo(String value) {
            addCriterion("attitude_score <>", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreGreaterThan(String value) {
            addCriterion("attitude_score >", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreGreaterThanOrEqualTo(String value) {
            addCriterion("attitude_score >=", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreLessThan(String value) {
            addCriterion("attitude_score <", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreLessThanOrEqualTo(String value) {
            addCriterion("attitude_score <=", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreLike(String value) {
            addCriterion("attitude_score like", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreNotLike(String value) {
            addCriterion("attitude_score not like", value, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreIn(List<String> values) {
            addCriterion("attitude_score in", values, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreNotIn(List<String> values) {
            addCriterion("attitude_score not in", values, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreBetween(String value1, String value2) {
            addCriterion("attitude_score between", value1, value2, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andAttitudeScoreNotBetween(String value1, String value2) {
            addCriterion("attitude_score not between", value1, value2, "attitudeScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreIsNull() {
            addCriterion("profession_score is null");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreIsNotNull() {
            addCriterion("profession_score is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreEqualTo(String value) {
            addCriterion("profession_score =", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreNotEqualTo(String value) {
            addCriterion("profession_score <>", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreGreaterThan(String value) {
            addCriterion("profession_score >", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreGreaterThanOrEqualTo(String value) {
            addCriterion("profession_score >=", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreLessThan(String value) {
            addCriterion("profession_score <", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreLessThanOrEqualTo(String value) {
            addCriterion("profession_score <=", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreLike(String value) {
            addCriterion("profession_score like", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreNotLike(String value) {
            addCriterion("profession_score not like", value, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreIn(List<String> values) {
            addCriterion("profession_score in", values, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreNotIn(List<String> values) {
            addCriterion("profession_score not in", values, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreBetween(String value1, String value2) {
            addCriterion("profession_score between", value1, value2, "professionScore");
            return (Criteria) this;
        }

        public Criteria andProfessionScoreNotBetween(String value1, String value2) {
            addCriterion("profession_score not between", value1, value2, "professionScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreIsNull() {
            addCriterion("response_score is null");
            return (Criteria) this;
        }

        public Criteria andResponseScoreIsNotNull() {
            addCriterion("response_score is not null");
            return (Criteria) this;
        }

        public Criteria andResponseScoreEqualTo(String value) {
            addCriterion("response_score =", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreNotEqualTo(String value) {
            addCriterion("response_score <>", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreGreaterThan(String value) {
            addCriterion("response_score >", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreGreaterThanOrEqualTo(String value) {
            addCriterion("response_score >=", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreLessThan(String value) {
            addCriterion("response_score <", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreLessThanOrEqualTo(String value) {
            addCriterion("response_score <=", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreLike(String value) {
            addCriterion("response_score like", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreNotLike(String value) {
            addCriterion("response_score not like", value, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreIn(List<String> values) {
            addCriterion("response_score in", values, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreNotIn(List<String> values) {
            addCriterion("response_score not in", values, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreBetween(String value1, String value2) {
            addCriterion("response_score between", value1, value2, "responseScore");
            return (Criteria) this;
        }

        public Criteria andResponseScoreNotBetween(String value1, String value2) {
            addCriterion("response_score not between", value1, value2, "responseScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreIsNull() {
            addCriterion("price_score is null");
            return (Criteria) this;
        }

        public Criteria andPriceScoreIsNotNull() {
            addCriterion("price_score is not null");
            return (Criteria) this;
        }

        public Criteria andPriceScoreEqualTo(String value) {
            addCriterion("price_score =", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotEqualTo(String value) {
            addCriterion("price_score <>", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreGreaterThan(String value) {
            addCriterion("price_score >", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreGreaterThanOrEqualTo(String value) {
            addCriterion("price_score >=", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreLessThan(String value) {
            addCriterion("price_score <", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreLessThanOrEqualTo(String value) {
            addCriterion("price_score <=", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreLike(String value) {
            addCriterion("price_score like", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotLike(String value) {
            addCriterion("price_score not like", value, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreIn(List<String> values) {
            addCriterion("price_score in", values, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotIn(List<String> values) {
            addCriterion("price_score not in", values, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreBetween(String value1, String value2) {
            addCriterion("price_score between", value1, value2, "priceScore");
            return (Criteria) this;
        }

        public Criteria andPriceScoreNotBetween(String value1, String value2) {
            addCriterion("price_score not between", value1, value2, "priceScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescIsNull() {
            addCriterion("evaluation_desc is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescIsNotNull() {
            addCriterion("evaluation_desc is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescEqualTo(String value) {
            addCriterion("evaluation_desc =", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescNotEqualTo(String value) {
            addCriterion("evaluation_desc <>", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescGreaterThan(String value) {
            addCriterion("evaluation_desc >", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation_desc >=", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescLessThan(String value) {
            addCriterion("evaluation_desc <", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescLessThanOrEqualTo(String value) {
            addCriterion("evaluation_desc <=", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescLike(String value) {
            addCriterion("evaluation_desc like", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescNotLike(String value) {
            addCriterion("evaluation_desc not like", value, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescIn(List<String> values) {
            addCriterion("evaluation_desc in", values, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescNotIn(List<String> values) {
            addCriterion("evaluation_desc not in", values, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescBetween(String value1, String value2) {
            addCriterion("evaluation_desc between", value1, value2, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andEvaluationDescNotBetween(String value1, String value2) {
            addCriterion("evaluation_desc not between", value1, value2, "evaluationDesc");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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