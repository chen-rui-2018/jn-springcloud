package com.jn.park.park.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParkCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkCriteria() {
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
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParkNameIsNull() {
            addCriterion("park_name is null");
            return (Criteria) this;
        }

        public Criteria andParkNameIsNotNull() {
            addCriterion("park_name is not null");
            return (Criteria) this;
        }

        public Criteria andParkNameEqualTo(String value) {
            addCriterion("park_name =", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotEqualTo(String value) {
            addCriterion("park_name <>", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameGreaterThan(String value) {
            addCriterion("park_name >", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameGreaterThanOrEqualTo(String value) {
            addCriterion("park_name >=", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLessThan(String value) {
            addCriterion("park_name <", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLessThanOrEqualTo(String value) {
            addCriterion("park_name <=", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameLike(String value) {
            addCriterion("park_name like", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotLike(String value) {
            addCriterion("park_name not like", value, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameIn(List<String> values) {
            addCriterion("park_name in", values, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotIn(List<String> values) {
            addCriterion("park_name not in", values, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameBetween(String value1, String value2) {
            addCriterion("park_name between", value1, value2, "parkName");
            return (Criteria) this;
        }

        public Criteria andParkNameNotBetween(String value1, String value2) {
            addCriterion("park_name not between", value1, value2, "parkName");
            return (Criteria) this;
        }

        public Criteria andMainPictureIsNull() {
            addCriterion("main_picture is null");
            return (Criteria) this;
        }

        public Criteria andMainPictureIsNotNull() {
            addCriterion("main_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMainPictureEqualTo(String value) {
            addCriterion("main_picture =", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotEqualTo(String value) {
            addCriterion("main_picture <>", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureGreaterThan(String value) {
            addCriterion("main_picture >", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureGreaterThanOrEqualTo(String value) {
            addCriterion("main_picture >=", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLessThan(String value) {
            addCriterion("main_picture <", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLessThanOrEqualTo(String value) {
            addCriterion("main_picture <=", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLike(String value) {
            addCriterion("main_picture like", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotLike(String value) {
            addCriterion("main_picture not like", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureIn(List<String> values) {
            addCriterion("main_picture in", values, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotIn(List<String> values) {
            addCriterion("main_picture not in", values, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureBetween(String value1, String value2) {
            addCriterion("main_picture between", value1, value2, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotBetween(String value1, String value2) {
            addCriterion("main_picture not between", value1, value2, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureIsNull() {
            addCriterion("minor_picture is null");
            return (Criteria) this;
        }

        public Criteria andMinorPictureIsNotNull() {
            addCriterion("minor_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMinorPictureEqualTo(String value) {
            addCriterion("minor_picture =", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureNotEqualTo(String value) {
            addCriterion("minor_picture <>", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureGreaterThan(String value) {
            addCriterion("minor_picture >", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureGreaterThanOrEqualTo(String value) {
            addCriterion("minor_picture >=", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureLessThan(String value) {
            addCriterion("minor_picture <", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureLessThanOrEqualTo(String value) {
            addCriterion("minor_picture <=", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureLike(String value) {
            addCriterion("minor_picture like", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureNotLike(String value) {
            addCriterion("minor_picture not like", value, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureIn(List<String> values) {
            addCriterion("minor_picture in", values, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureNotIn(List<String> values) {
            addCriterion("minor_picture not in", values, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureBetween(String value1, String value2) {
            addCriterion("minor_picture between", value1, value2, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andMinorPictureNotBetween(String value1, String value2) {
            addCriterion("minor_picture not between", value1, value2, "minorPicture");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceIsNull() {
            addCriterion("short_introduce is null");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceIsNotNull() {
            addCriterion("short_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceEqualTo(String value) {
            addCriterion("short_introduce =", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceNotEqualTo(String value) {
            addCriterion("short_introduce <>", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceGreaterThan(String value) {
            addCriterion("short_introduce >", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("short_introduce >=", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceLessThan(String value) {
            addCriterion("short_introduce <", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceLessThanOrEqualTo(String value) {
            addCriterion("short_introduce <=", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceLike(String value) {
            addCriterion("short_introduce like", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceNotLike(String value) {
            addCriterion("short_introduce not like", value, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceIn(List<String> values) {
            addCriterion("short_introduce in", values, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceNotIn(List<String> values) {
            addCriterion("short_introduce not in", values, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceBetween(String value1, String value2) {
            addCriterion("short_introduce between", value1, value2, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andShortIntroduceNotBetween(String value1, String value2) {
            addCriterion("short_introduce not between", value1, value2, "shortIntroduce");
            return (Criteria) this;
        }

        public Criteria andParkStateIsNull() {
            addCriterion("park_state is null");
            return (Criteria) this;
        }

        public Criteria andParkStateIsNotNull() {
            addCriterion("park_state is not null");
            return (Criteria) this;
        }

        public Criteria andParkStateEqualTo(String value) {
            addCriterion("park_state =", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateNotEqualTo(String value) {
            addCriterion("park_state <>", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateGreaterThan(String value) {
            addCriterion("park_state >", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateGreaterThanOrEqualTo(String value) {
            addCriterion("park_state >=", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateLessThan(String value) {
            addCriterion("park_state <", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateLessThanOrEqualTo(String value) {
            addCriterion("park_state <=", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateLike(String value) {
            addCriterion("park_state like", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateNotLike(String value) {
            addCriterion("park_state not like", value, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateIn(List<String> values) {
            addCriterion("park_state in", values, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateNotIn(List<String> values) {
            addCriterion("park_state not in", values, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateBetween(String value1, String value2) {
            addCriterion("park_state between", value1, value2, "parkState");
            return (Criteria) this;
        }

        public Criteria andParkStateNotBetween(String value1, String value2) {
            addCriterion("park_state not between", value1, value2, "parkState");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNull() {
            addCriterion("show_order is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderIsNotNull() {
            addCriterion("show_order is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderEqualTo(Integer value) {
            addCriterion("show_order =", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotEqualTo(Integer value) {
            addCriterion("show_order <>", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThan(Integer value) {
            addCriterion("show_order >", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_order >=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThan(Integer value) {
            addCriterion("show_order <", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderLessThanOrEqualTo(Integer value) {
            addCriterion("show_order <=", value, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderIn(List<Integer> values) {
            addCriterion("show_order in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotIn(List<Integer> values) {
            addCriterion("show_order not in", values, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderBetween(Integer value1, Integer value2) {
            addCriterion("show_order between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andShowOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("show_order not between", value1, value2, "showOrder");
            return (Criteria) this;
        }

        public Criteria andIsEnterIsNull() {
            addCriterion("is_enter is null");
            return (Criteria) this;
        }

        public Criteria andIsEnterIsNotNull() {
            addCriterion("is_enter is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnterEqualTo(String value) {
            addCriterion("is_enter =", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterNotEqualTo(String value) {
            addCriterion("is_enter <>", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterGreaterThan(String value) {
            addCriterion("is_enter >", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterGreaterThanOrEqualTo(String value) {
            addCriterion("is_enter >=", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterLessThan(String value) {
            addCriterion("is_enter <", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterLessThanOrEqualTo(String value) {
            addCriterion("is_enter <=", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterLike(String value) {
            addCriterion("is_enter like", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterNotLike(String value) {
            addCriterion("is_enter not like", value, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterIn(List<String> values) {
            addCriterion("is_enter in", values, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterNotIn(List<String> values) {
            addCriterion("is_enter not in", values, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterBetween(String value1, String value2) {
            addCriterion("is_enter between", value1, value2, "isEnter");
            return (Criteria) this;
        }

        public Criteria andIsEnterNotBetween(String value1, String value2) {
            addCriterion("is_enter not between", value1, value2, "isEnter");
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

        public Criteria andRecordStatusEqualTo(String value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(String value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(String value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(String value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(String value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(String value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLike(String value) {
            addCriterion("record_status like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotLike(String value) {
            addCriterion("record_status not like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<String> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<String> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(String value1, String value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(String value1, String value2) {
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