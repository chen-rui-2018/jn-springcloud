package com.jn.park.sp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSpMessageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSpMessageCriteria() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andConcatNameIsNull() {
            addCriterion("concat_name is null");
            return (Criteria) this;
        }

        public Criteria andConcatNameIsNotNull() {
            addCriterion("concat_name is not null");
            return (Criteria) this;
        }

        public Criteria andConcatNameEqualTo(String value) {
            addCriterion("concat_name =", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameNotEqualTo(String value) {
            addCriterion("concat_name <>", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameGreaterThan(String value) {
            addCriterion("concat_name >", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameGreaterThanOrEqualTo(String value) {
            addCriterion("concat_name >=", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameLessThan(String value) {
            addCriterion("concat_name <", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameLessThanOrEqualTo(String value) {
            addCriterion("concat_name <=", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameLike(String value) {
            addCriterion("concat_name like", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameNotLike(String value) {
            addCriterion("concat_name not like", value, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameIn(List<String> values) {
            addCriterion("concat_name in", values, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameNotIn(List<String> values) {
            addCriterion("concat_name not in", values, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameBetween(String value1, String value2) {
            addCriterion("concat_name between", value1, value2, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatNameNotBetween(String value1, String value2) {
            addCriterion("concat_name not between", value1, value2, "concatName");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneIsNull() {
            addCriterion("concat_phone is null");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneIsNotNull() {
            addCriterion("concat_phone is not null");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneEqualTo(String value) {
            addCriterion("concat_phone =", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneNotEqualTo(String value) {
            addCriterion("concat_phone <>", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneGreaterThan(String value) {
            addCriterion("concat_phone >", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("concat_phone >=", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneLessThan(String value) {
            addCriterion("concat_phone <", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneLessThanOrEqualTo(String value) {
            addCriterion("concat_phone <=", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneLike(String value) {
            addCriterion("concat_phone like", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneNotLike(String value) {
            addCriterion("concat_phone not like", value, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneIn(List<String> values) {
            addCriterion("concat_phone in", values, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneNotIn(List<String> values) {
            addCriterion("concat_phone not in", values, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneBetween(String value1, String value2) {
            addCriterion("concat_phone between", value1, value2, "concatPhone");
            return (Criteria) this;
        }

        public Criteria andConcatPhoneNotBetween(String value1, String value2) {
            addCriterion("concat_phone not between", value1, value2, "concatPhone");
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

        public Criteria andFromBusiIdIsNull() {
            addCriterion("from_busi_id is null");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdIsNotNull() {
            addCriterion("from_busi_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdEqualTo(String value) {
            addCriterion("from_busi_id =", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdNotEqualTo(String value) {
            addCriterion("from_busi_id <>", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdGreaterThan(String value) {
            addCriterion("from_busi_id >", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_busi_id >=", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdLessThan(String value) {
            addCriterion("from_busi_id <", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdLessThanOrEqualTo(String value) {
            addCriterion("from_busi_id <=", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdLike(String value) {
            addCriterion("from_busi_id like", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdNotLike(String value) {
            addCriterion("from_busi_id not like", value, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdIn(List<String> values) {
            addCriterion("from_busi_id in", values, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdNotIn(List<String> values) {
            addCriterion("from_busi_id not in", values, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdBetween(String value1, String value2) {
            addCriterion("from_busi_id between", value1, value2, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andFromBusiIdNotBetween(String value1, String value2) {
            addCriterion("from_busi_id not between", value1, value2, "fromBusiId");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNull() {
            addCriterion("reply_status is null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNotNull() {
            addCriterion("reply_status is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusEqualTo(String value) {
            addCriterion("reply_status =", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotEqualTo(String value) {
            addCriterion("reply_status <>", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThan(String value) {
            addCriterion("reply_status >", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("reply_status >=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThan(String value) {
            addCriterion("reply_status <", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThanOrEqualTo(String value) {
            addCriterion("reply_status <=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLike(String value) {
            addCriterion("reply_status like", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotLike(String value) {
            addCriterion("reply_status not like", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIn(List<String> values) {
            addCriterion("reply_status in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotIn(List<String> values) {
            addCriterion("reply_status not in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusBetween(String value1, String value2) {
            addCriterion("reply_status between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotBetween(String value1, String value2) {
            addCriterion("reply_status not between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountIsNull() {
            addCriterion("reply_user_account is null");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountIsNotNull() {
            addCriterion("reply_user_account is not null");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountEqualTo(String value) {
            addCriterion("reply_user_account =", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountNotEqualTo(String value) {
            addCriterion("reply_user_account <>", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountGreaterThan(String value) {
            addCriterion("reply_user_account >", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("reply_user_account >=", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountLessThan(String value) {
            addCriterion("reply_user_account <", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountLessThanOrEqualTo(String value) {
            addCriterion("reply_user_account <=", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountLike(String value) {
            addCriterion("reply_user_account like", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountNotLike(String value) {
            addCriterion("reply_user_account not like", value, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountIn(List<String> values) {
            addCriterion("reply_user_account in", values, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountNotIn(List<String> values) {
            addCriterion("reply_user_account not in", values, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountBetween(String value1, String value2) {
            addCriterion("reply_user_account between", value1, value2, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyUserAccountNotBetween(String value1, String value2) {
            addCriterion("reply_user_account not between", value1, value2, "replyUserAccount");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIsNull() {
            addCriterion("reply_message is null");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIsNotNull() {
            addCriterion("reply_message is not null");
            return (Criteria) this;
        }

        public Criteria andReplyMessageEqualTo(String value) {
            addCriterion("reply_message =", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotEqualTo(String value) {
            addCriterion("reply_message <>", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageGreaterThan(String value) {
            addCriterion("reply_message >", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageGreaterThanOrEqualTo(String value) {
            addCriterion("reply_message >=", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLessThan(String value) {
            addCriterion("reply_message <", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLessThanOrEqualTo(String value) {
            addCriterion("reply_message <=", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLike(String value) {
            addCriterion("reply_message like", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotLike(String value) {
            addCriterion("reply_message not like", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIn(List<String> values) {
            addCriterion("reply_message in", values, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotIn(List<String> values) {
            addCriterion("reply_message not in", values, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageBetween(String value1, String value2) {
            addCriterion("reply_message between", value1, value2, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotBetween(String value1, String value2) {
            addCriterion("reply_message not between", value1, value2, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusIsNull() {
            addCriterion("solution_status is null");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusIsNotNull() {
            addCriterion("solution_status is not null");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusEqualTo(String value) {
            addCriterion("solution_status =", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusNotEqualTo(String value) {
            addCriterion("solution_status <>", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusGreaterThan(String value) {
            addCriterion("solution_status >", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusGreaterThanOrEqualTo(String value) {
            addCriterion("solution_status >=", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusLessThan(String value) {
            addCriterion("solution_status <", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusLessThanOrEqualTo(String value) {
            addCriterion("solution_status <=", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusLike(String value) {
            addCriterion("solution_status like", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusNotLike(String value) {
            addCriterion("solution_status not like", value, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusIn(List<String> values) {
            addCriterion("solution_status in", values, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusNotIn(List<String> values) {
            addCriterion("solution_status not in", values, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusBetween(String value1, String value2) {
            addCriterion("solution_status between", value1, value2, "solutionStatus");
            return (Criteria) this;
        }

        public Criteria andSolutionStatusNotBetween(String value1, String value2) {
            addCriterion("solution_status not between", value1, value2, "solutionStatus");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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