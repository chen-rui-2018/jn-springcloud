package com.jn.oa.schedule.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOaScheduleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOaScheduleCriteria() {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andRemindTimeIsNull() {
            addCriterion("remind_time is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNotNull() {
            addCriterion("remind_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeEqualTo(Date value) {
            addCriterion("remind_time =", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotEqualTo(Date value) {
            addCriterion("remind_time <>", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThan(Date value) {
            addCriterion("remind_time >", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remind_time >=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThan(Date value) {
            addCriterion("remind_time <", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThanOrEqualTo(Date value) {
            addCriterion("remind_time <=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIn(List<Date> values) {
            addCriterion("remind_time in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotIn(List<Date> values) {
            addCriterion("remind_time not in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeBetween(Date value1, Date value2) {
            addCriterion("remind_time between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotBetween(Date value1, Date value2) {
            addCriterion("remind_time not between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNull() {
            addCriterion("is_remind is null");
            return (Criteria) this;
        }

        public Criteria andIsRemindIsNotNull() {
            addCriterion("is_remind is not null");
            return (Criteria) this;
        }

        public Criteria andIsRemindEqualTo(String value) {
            addCriterion("is_remind =", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotEqualTo(String value) {
            addCriterion("is_remind <>", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThan(String value) {
            addCriterion("is_remind >", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindGreaterThanOrEqualTo(String value) {
            addCriterion("is_remind >=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThan(String value) {
            addCriterion("is_remind <", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLessThanOrEqualTo(String value) {
            addCriterion("is_remind <=", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindLike(String value) {
            addCriterion("is_remind like", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotLike(String value) {
            addCriterion("is_remind not like", value, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindIn(List<String> values) {
            addCriterion("is_remind in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotIn(List<String> values) {
            addCriterion("is_remind not in", values, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindBetween(String value1, String value2) {
            addCriterion("is_remind between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andIsRemindNotBetween(String value1, String value2) {
            addCriterion("is_remind not between", value1, value2, "isRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindIsNull() {
            addCriterion("wechat_remind is null");
            return (Criteria) this;
        }

        public Criteria andWechatRemindIsNotNull() {
            addCriterion("wechat_remind is not null");
            return (Criteria) this;
        }

        public Criteria andWechatRemindEqualTo(String value) {
            addCriterion("wechat_remind =", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotEqualTo(String value) {
            addCriterion("wechat_remind <>", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindGreaterThan(String value) {
            addCriterion("wechat_remind >", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_remind >=", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindLessThan(String value) {
            addCriterion("wechat_remind <", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindLessThanOrEqualTo(String value) {
            addCriterion("wechat_remind <=", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindLike(String value) {
            addCriterion("wechat_remind like", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotLike(String value) {
            addCriterion("wechat_remind not like", value, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindIn(List<String> values) {
            addCriterion("wechat_remind in", values, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotIn(List<String> values) {
            addCriterion("wechat_remind not in", values, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindBetween(String value1, String value2) {
            addCriterion("wechat_remind between", value1, value2, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andWechatRemindNotBetween(String value1, String value2) {
            addCriterion("wechat_remind not between", value1, value2, "wechatRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIsNull() {
            addCriterion("message_remind is null");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIsNotNull() {
            addCriterion("message_remind is not null");
            return (Criteria) this;
        }

        public Criteria andMessageRemindEqualTo(String value) {
            addCriterion("message_remind =", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotEqualTo(String value) {
            addCriterion("message_remind <>", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindGreaterThan(String value) {
            addCriterion("message_remind >", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindGreaterThanOrEqualTo(String value) {
            addCriterion("message_remind >=", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLessThan(String value) {
            addCriterion("message_remind <", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLessThanOrEqualTo(String value) {
            addCriterion("message_remind <=", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindLike(String value) {
            addCriterion("message_remind like", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotLike(String value) {
            addCriterion("message_remind not like", value, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindIn(List<String> values) {
            addCriterion("message_remind in", values, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotIn(List<String> values) {
            addCriterion("message_remind not in", values, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindBetween(String value1, String value2) {
            addCriterion("message_remind between", value1, value2, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andMessageRemindNotBetween(String value1, String value2) {
            addCriterion("message_remind not between", value1, value2, "messageRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindIsNull() {
            addCriterion("pc_remind is null");
            return (Criteria) this;
        }

        public Criteria andPcRemindIsNotNull() {
            addCriterion("pc_remind is not null");
            return (Criteria) this;
        }

        public Criteria andPcRemindEqualTo(String value) {
            addCriterion("pc_remind =", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotEqualTo(String value) {
            addCriterion("pc_remind <>", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindGreaterThan(String value) {
            addCriterion("pc_remind >", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindGreaterThanOrEqualTo(String value) {
            addCriterion("pc_remind >=", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindLessThan(String value) {
            addCriterion("pc_remind <", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindLessThanOrEqualTo(String value) {
            addCriterion("pc_remind <=", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindLike(String value) {
            addCriterion("pc_remind like", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotLike(String value) {
            addCriterion("pc_remind not like", value, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindIn(List<String> values) {
            addCriterion("pc_remind in", values, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotIn(List<String> values) {
            addCriterion("pc_remind not in", values, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindBetween(String value1, String value2) {
            addCriterion("pc_remind between", value1, value2, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andPcRemindNotBetween(String value1, String value2) {
            addCriterion("pc_remind not between", value1, value2, "pcRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindIsNull() {
            addCriterion("app_remind is null");
            return (Criteria) this;
        }

        public Criteria andAppRemindIsNotNull() {
            addCriterion("app_remind is not null");
            return (Criteria) this;
        }

        public Criteria andAppRemindEqualTo(String value) {
            addCriterion("app_remind =", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotEqualTo(String value) {
            addCriterion("app_remind <>", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindGreaterThan(String value) {
            addCriterion("app_remind >", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindGreaterThanOrEqualTo(String value) {
            addCriterion("app_remind >=", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindLessThan(String value) {
            addCriterion("app_remind <", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindLessThanOrEqualTo(String value) {
            addCriterion("app_remind <=", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindLike(String value) {
            addCriterion("app_remind like", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotLike(String value) {
            addCriterion("app_remind not like", value, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindIn(List<String> values) {
            addCriterion("app_remind in", values, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotIn(List<String> values) {
            addCriterion("app_remind not in", values, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindBetween(String value1, String value2) {
            addCriterion("app_remind between", value1, value2, "appRemind");
            return (Criteria) this;
        }

        public Criteria andAppRemindNotBetween(String value1, String value2) {
            addCriterion("app_remind not between", value1, value2, "appRemind");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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