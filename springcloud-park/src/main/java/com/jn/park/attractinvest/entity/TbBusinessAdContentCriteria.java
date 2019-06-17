package com.jn.park.attractinvest.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbBusinessAdContentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbBusinessAdContentCriteria() {
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

        public Criteria andModifierAccounIsNull() {
            addCriterion("modifier_accoun is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccounIsNotNull() {
            addCriterion("modifier_accoun is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccounEqualTo(String value) {
            addCriterion("modifier_accoun =", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounNotEqualTo(String value) {
            addCriterion("modifier_accoun <>", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounGreaterThan(String value) {
            addCriterion("modifier_accoun >", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounGreaterThanOrEqualTo(String value) {
            addCriterion("modifier_accoun >=", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounLessThan(String value) {
            addCriterion("modifier_accoun <", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounLessThanOrEqualTo(String value) {
            addCriterion("modifier_accoun <=", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounLike(String value) {
            addCriterion("modifier_accoun like", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounNotLike(String value) {
            addCriterion("modifier_accoun not like", value, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounIn(List<String> values) {
            addCriterion("modifier_accoun in", values, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounNotIn(List<String> values) {
            addCriterion("modifier_accoun not in", values, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounBetween(String value1, String value2) {
            addCriterion("modifier_accoun between", value1, value2, "modifierAccoun");
            return (Criteria) this;
        }

        public Criteria andModifierAccounNotBetween(String value1, String value2) {
            addCriterion("modifier_accoun not between", value1, value2, "modifierAccoun");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAdCoverIsNull() {
            addCriterion("ad_cover is null");
            return (Criteria) this;
        }

        public Criteria andAdCoverIsNotNull() {
            addCriterion("ad_cover is not null");
            return (Criteria) this;
        }

        public Criteria andAdCoverEqualTo(String value) {
            addCriterion("ad_cover =", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverNotEqualTo(String value) {
            addCriterion("ad_cover <>", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverGreaterThan(String value) {
            addCriterion("ad_cover >", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverGreaterThanOrEqualTo(String value) {
            addCriterion("ad_cover >=", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverLessThan(String value) {
            addCriterion("ad_cover <", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverLessThanOrEqualTo(String value) {
            addCriterion("ad_cover <=", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverLike(String value) {
            addCriterion("ad_cover like", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverNotLike(String value) {
            addCriterion("ad_cover not like", value, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverIn(List<String> values) {
            addCriterion("ad_cover in", values, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverNotIn(List<String> values) {
            addCriterion("ad_cover not in", values, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverBetween(String value1, String value2) {
            addCriterion("ad_cover between", value1, value2, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdCoverNotBetween(String value1, String value2) {
            addCriterion("ad_cover not between", value1, value2, "adCover");
            return (Criteria) this;
        }

        public Criteria andAdPositionIsNull() {
            addCriterion("ad_position is null");
            return (Criteria) this;
        }

        public Criteria andAdPositionIsNotNull() {
            addCriterion("ad_position is not null");
            return (Criteria) this;
        }

        public Criteria andAdPositionEqualTo(String value) {
            addCriterion("ad_position =", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionNotEqualTo(String value) {
            addCriterion("ad_position <>", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionGreaterThan(String value) {
            addCriterion("ad_position >", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionGreaterThanOrEqualTo(String value) {
            addCriterion("ad_position >=", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionLessThan(String value) {
            addCriterion("ad_position <", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionLessThanOrEqualTo(String value) {
            addCriterion("ad_position <=", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionLike(String value) {
            addCriterion("ad_position like", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionNotLike(String value) {
            addCriterion("ad_position not like", value, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionIn(List<String> values) {
            addCriterion("ad_position in", values, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionNotIn(List<String> values) {
            addCriterion("ad_position not in", values, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionBetween(String value1, String value2) {
            addCriterion("ad_position between", value1, value2, "adPosition");
            return (Criteria) this;
        }

        public Criteria andAdPositionNotBetween(String value1, String value2) {
            addCriterion("ad_position not between", value1, value2, "adPosition");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNull() {
            addCriterion("sub_title is null");
            return (Criteria) this;
        }

        public Criteria andSubTitleIsNotNull() {
            addCriterion("sub_title is not null");
            return (Criteria) this;
        }

        public Criteria andSubTitleEqualTo(String value) {
            addCriterion("sub_title =", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotEqualTo(String value) {
            addCriterion("sub_title <>", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThan(String value) {
            addCriterion("sub_title >", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleGreaterThanOrEqualTo(String value) {
            addCriterion("sub_title >=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThan(String value) {
            addCriterion("sub_title <", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLessThanOrEqualTo(String value) {
            addCriterion("sub_title <=", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleLike(String value) {
            addCriterion("sub_title like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotLike(String value) {
            addCriterion("sub_title not like", value, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleIn(List<String> values) {
            addCriterion("sub_title in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotIn(List<String> values) {
            addCriterion("sub_title not in", values, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleBetween(String value1, String value2) {
            addCriterion("sub_title between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andSubTitleNotBetween(String value1, String value2) {
            addCriterion("sub_title not between", value1, value2, "subTitle");
            return (Criteria) this;
        }

        public Criteria andAdFlagIsNull() {
            addCriterion("ad_flag is null");
            return (Criteria) this;
        }

        public Criteria andAdFlagIsNotNull() {
            addCriterion("ad_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAdFlagEqualTo(String value) {
            addCriterion("ad_flag =", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagNotEqualTo(String value) {
            addCriterion("ad_flag <>", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagGreaterThan(String value) {
            addCriterion("ad_flag >", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ad_flag >=", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagLessThan(String value) {
            addCriterion("ad_flag <", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagLessThanOrEqualTo(String value) {
            addCriterion("ad_flag <=", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagLike(String value) {
            addCriterion("ad_flag like", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagNotLike(String value) {
            addCriterion("ad_flag not like", value, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagIn(List<String> values) {
            addCriterion("ad_flag in", values, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagNotIn(List<String> values) {
            addCriterion("ad_flag not in", values, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagBetween(String value1, String value2) {
            addCriterion("ad_flag between", value1, value2, "adFlag");
            return (Criteria) this;
        }

        public Criteria andAdFlagNotBetween(String value1, String value2) {
            addCriterion("ad_flag not between", value1, value2, "adFlag");
            return (Criteria) this;
        }

        public Criteria andParkIsNull() {
            addCriterion("park is null");
            return (Criteria) this;
        }

        public Criteria andParkIsNotNull() {
            addCriterion("park is not null");
            return (Criteria) this;
        }

        public Criteria andParkEqualTo(String value) {
            addCriterion("park =", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkNotEqualTo(String value) {
            addCriterion("park <>", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkGreaterThan(String value) {
            addCriterion("park >", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkGreaterThanOrEqualTo(String value) {
            addCriterion("park >=", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkLessThan(String value) {
            addCriterion("park <", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkLessThanOrEqualTo(String value) {
            addCriterion("park <=", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkLike(String value) {
            addCriterion("park like", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkNotLike(String value) {
            addCriterion("park not like", value, "park");
            return (Criteria) this;
        }

        public Criteria andParkIn(List<String> values) {
            addCriterion("park in", values, "park");
            return (Criteria) this;
        }

        public Criteria andParkNotIn(List<String> values) {
            addCriterion("park not in", values, "park");
            return (Criteria) this;
        }

        public Criteria andParkBetween(String value1, String value2) {
            addCriterion("park between", value1, value2, "park");
            return (Criteria) this;
        }

        public Criteria andParkNotBetween(String value1, String value2) {
            addCriterion("park not between", value1, value2, "park");
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

        public Criteria andModAccounIsNull() {
            addCriterion("mod_accoun is null");
            return (Criteria) this;
        }

        public Criteria andModAccounIsNotNull() {
            addCriterion("mod_accoun is not null");
            return (Criteria) this;
        }

        public Criteria andModAccounEqualTo(String value) {
            addCriterion("mod_accoun =", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounNotEqualTo(String value) {
            addCriterion("mod_accoun <>", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounGreaterThan(String value) {
            addCriterion("mod_accoun >", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounGreaterThanOrEqualTo(String value) {
            addCriterion("mod_accoun >=", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounLessThan(String value) {
            addCriterion("mod_accoun <", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounLessThanOrEqualTo(String value) {
            addCriterion("mod_accoun <=", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounLike(String value) {
            addCriterion("mod_accoun like", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounNotLike(String value) {
            addCriterion("mod_accoun not like", value, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounIn(List<String> values) {
            addCriterion("mod_accoun in", values, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounNotIn(List<String> values) {
            addCriterion("mod_accoun not in", values, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounBetween(String value1, String value2) {
            addCriterion("mod_accoun between", value1, value2, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModAccounNotBetween(String value1, String value2) {
            addCriterion("mod_accoun not between", value1, value2, "modAccoun");
            return (Criteria) this;
        }

        public Criteria andModTimeIsNull() {
            addCriterion("mod_time is null");
            return (Criteria) this;
        }

        public Criteria andModTimeIsNotNull() {
            addCriterion("mod_time is not null");
            return (Criteria) this;
        }

        public Criteria andModTimeEqualTo(String value) {
            addCriterion("mod_time =", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotEqualTo(String value) {
            addCriterion("mod_time <>", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeGreaterThan(String value) {
            addCriterion("mod_time >", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeGreaterThanOrEqualTo(String value) {
            addCriterion("mod_time >=", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLessThan(String value) {
            addCriterion("mod_time <", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLessThanOrEqualTo(String value) {
            addCriterion("mod_time <=", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLike(String value) {
            addCriterion("mod_time like", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotLike(String value) {
            addCriterion("mod_time not like", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeIn(List<String> values) {
            addCriterion("mod_time in", values, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotIn(List<String> values) {
            addCriterion("mod_time not in", values, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeBetween(String value1, String value2) {
            addCriterion("mod_time between", value1, value2, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotBetween(String value1, String value2) {
            addCriterion("mod_time not between", value1, value2, "modTime");
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