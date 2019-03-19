package com.jn.park.approve.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbApproveGuideContentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbApproveGuideContentCriteria() {
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

        public Criteria andGuideIdIsNull() {
            addCriterion("gc.guide_id is null");
            return (Criteria) this;
        }

        public Criteria andGuideIdIsNotNull() {
            addCriterion("gc.guide_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuideIdEqualTo(Integer value) {
            addCriterion("gc.guide_id =", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdNotEqualTo(Integer value) {
            addCriterion("gc.guide_id <>", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdGreaterThan(Integer value) {
            addCriterion("gc.guide_id >", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gc.guide_id >=", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdLessThan(Integer value) {
            addCriterion("gc.guide_id <", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdLessThanOrEqualTo(Integer value) {
            addCriterion("gc.guide_id <=", value, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdIn(List<Integer> values) {
            addCriterion("gc.guide_id in", values, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdNotIn(List<Integer> values) {
            addCriterion("gc.guide_id not in", values, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdBetween(Integer value1, Integer value2) {
            addCriterion("gc.guide_id between", value1, value2, "guideId");
            return (Criteria) this;
        }

        public Criteria andGuideIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gc.guide_id not between", value1, value2, "guideId");
            return (Criteria) this;
        }

        public Criteria andWordCountIsNull() {
            addCriterion("gc.word_count is null");
            return (Criteria) this;
        }

        public Criteria andWordCountIsNotNull() {
            addCriterion("gc.word_count is not null");
            return (Criteria) this;
        }

        public Criteria andWordCountEqualTo(String value) {
            addCriterion("gc.word_count =", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountNotEqualTo(String value) {
            addCriterion("gc.word_count <>", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountGreaterThan(String value) {
            addCriterion("gc.word_count >", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountGreaterThanOrEqualTo(String value) {
            addCriterion("gc.word_count >=", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountLessThan(String value) {
            addCriterion("gc.word_count <", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountLessThanOrEqualTo(String value) {
            addCriterion("gc.word_count <=", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountLike(String value) {
            addCriterion("gc.word_count like", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountNotLike(String value) {
            addCriterion("gc.word_count not like", value, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountIn(List<String> values) {
            addCriterion("gc.word_count in", values, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountNotIn(List<String> values) {
            addCriterion("gc.word_count not in", values, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountBetween(String value1, String value2) {
            addCriterion("gc.word_count between", value1, value2, "wordCount");
            return (Criteria) this;
        }

        public Criteria andWordCountNotBetween(String value1, String value2) {
            addCriterion("gc.word_count not between", value1, value2, "wordCount");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("gc.description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("gc.description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("gc.description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("gc.description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("gc.description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("gc.description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("gc.description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("gc.description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("gc.description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("gc.description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("gc.description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("gc.description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("gc.description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("gc.description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDealDaysIsNull() {
            addCriterion("gc.deal_days is null");
            return (Criteria) this;
        }

        public Criteria andDealDaysIsNotNull() {
            addCriterion("gc.deal_days is not null");
            return (Criteria) this;
        }

        public Criteria andDealDaysEqualTo(Integer value) {
            addCriterion("gc.deal_days =", value, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysNotEqualTo(Integer value) {
            addCriterion("gc.deal_days <>", value, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysGreaterThan(Integer value) {
            addCriterion("gc.deal_days >", value, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("gc.deal_days >=", value, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysLessThan(Integer value) {
            addCriterion("gc.deal_days <", value, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysLessThanOrEqualTo(Integer value) {
            addCriterion("gc.deal_days <=", value, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysIn(List<Integer> values) {
            addCriterion("gc.deal_days in", values, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysNotIn(List<Integer> values) {
            addCriterion("gc.deal_days not in", values, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysBetween(Integer value1, Integer value2) {
            addCriterion("gc.deal_days between", value1, value2, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("gc.deal_days not between", value1, value2, "dealDays");
            return (Criteria) this;
        }

        public Criteria andDealAddressIsNull() {
            addCriterion("gc.deal_address is null");
            return (Criteria) this;
        }

        public Criteria andDealAddressIsNotNull() {
            addCriterion("gc.deal_address is not null");
            return (Criteria) this;
        }

        public Criteria andDealAddressEqualTo(String value) {
            addCriterion("gc.deal_address =", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotEqualTo(String value) {
            addCriterion("gc.deal_address <>", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressGreaterThan(String value) {
            addCriterion("gc.deal_address >", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressGreaterThanOrEqualTo(String value) {
            addCriterion("gc.deal_address >=", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressLessThan(String value) {
            addCriterion("gc.deal_address <", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressLessThanOrEqualTo(String value) {
            addCriterion("gc.deal_address <=", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressLike(String value) {
            addCriterion("gc.deal_address like", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotLike(String value) {
            addCriterion("gc.deal_address not like", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressIn(List<String> values) {
            addCriterion("gc.deal_address in", values, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotIn(List<String> values) {
            addCriterion("gc.deal_address not in", values, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressBetween(String value1, String value2) {
            addCriterion("gc.deal_address between", value1, value2, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotBetween(String value1, String value2) {
            addCriterion("gc.deal_address not between", value1, value2, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("gc.deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("gc.deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(String value) {
            addCriterion("gc.deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(String value) {
            addCriterion("gc.deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(String value) {
            addCriterion("gc.deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("gc.deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(String value) {
            addCriterion("gc.deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(String value) {
            addCriterion("gc.deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLike(String value) {
            addCriterion("gc.deal_time like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotLike(String value) {
            addCriterion("gc.deal_time not like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<String> values) {
            addCriterion("gc.deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<String> values) {
            addCriterion("gc.deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(String value1, String value2) {
            addCriterion("gc.deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(String value1, String value2) {
            addCriterion("gc.deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("gc.link_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("gc.link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("gc.link_phone =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("gc.link_phone <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("gc.link_phone >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("gc.link_phone >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("gc.link_phone <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("gc.link_phone <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("gc.link_phone like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("gc.link_phone not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("gc.link_phone in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("gc.link_phone not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("gc.link_phone between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("gc.link_phone not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlIsNull() {
            addCriterion("gc.deal_online_url is null");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlIsNotNull() {
            addCriterion("gc.deal_online_url is not null");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlEqualTo(String value) {
            addCriterion("gc.deal_online_url =", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlNotEqualTo(String value) {
            addCriterion("gc.deal_online_url <>", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlGreaterThan(String value) {
            addCriterion("gc.deal_online_url >", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlGreaterThanOrEqualTo(String value) {
            addCriterion("gc.deal_online_url >=", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlLessThan(String value) {
            addCriterion("gc.deal_online_url <", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlLessThanOrEqualTo(String value) {
            addCriterion("gc.deal_online_url <=", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlLike(String value) {
            addCriterion("gc.deal_online_url like", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlNotLike(String value) {
            addCriterion("gc.deal_online_url not like", value, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlIn(List<String> values) {
            addCriterion("gc.deal_online_url in", values, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlNotIn(List<String> values) {
            addCriterion("gc.deal_online_url not in", values, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlBetween(String value1, String value2) {
            addCriterion("gc.deal_online_url between", value1, value2, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andDealOnlineUrlNotBetween(String value1, String value2) {
            addCriterion("gc.deal_online_url not between", value1, value2, "dealOnlineUrl");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageIsNull() {
            addCriterion("gc.is_deal_model_of_message is null");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageIsNotNull() {
            addCriterion("gc.is_deal_model_of_message is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_message =", value, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageNotEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_message <>", value, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageGreaterThan(Byte value) {
            addCriterion("gc.is_deal_model_of_message >", value, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageGreaterThanOrEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_message >=", value, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageLessThan(Byte value) {
            addCriterion("gc.is_deal_model_of_message <", value, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageLessThanOrEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_message <=", value, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageIn(List<Byte> values) {
            addCriterion("gc.is_deal_model_of_message in", values, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageNotIn(List<Byte> values) {
            addCriterion("gc.is_deal_model_of_message not in", values, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageBetween(Byte value1, Byte value2) {
            addCriterion("gc.is_deal_model_of_message between", value1, value2, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfMessageNotBetween(Byte value1, Byte value2) {
            addCriterion("gc.is_deal_model_of_message not between", value1, value2, "isDealModelOfMessage");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupIsNull() {
            addCriterion("gc.is_deal_model_of_qq_group is null");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupIsNotNull() {
            addCriterion("gc.is_deal_model_of_qq_group is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_qq_group =", value, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupNotEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_qq_group <>", value, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupGreaterThan(Byte value) {
            addCriterion("gc.is_deal_model_of_qq_group >", value, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupGreaterThanOrEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_qq_group >=", value, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupLessThan(Byte value) {
            addCriterion("gc.is_deal_model_of_qq_group <", value, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupLessThanOrEqualTo(Byte value) {
            addCriterion("gc.is_deal_model_of_qq_group <=", value, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupIn(List<Byte> values) {
            addCriterion("gc.is_deal_model_of_qq_group in", values, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupNotIn(List<Byte> values) {
            addCriterion("gc.is_deal_model_of_qq_group not in", values, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupBetween(Byte value1, Byte value2) {
            addCriterion("gc.is_deal_model_of_qq_group between", value1, value2, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andIsDealModelOfQqGroupNotBetween(Byte value1, Byte value2) {
            addCriterion("gc.is_deal_model_of_qq_group not between", value1, value2, "isDealModelOfQqGroup");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberIsNull() {
            addCriterion("gc.qq_group_number is null");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberIsNotNull() {
            addCriterion("gc.qq_group_number is not null");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberEqualTo(String value) {
            addCriterion("gc.qq_group_number =", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberNotEqualTo(String value) {
            addCriterion("gc.qq_group_number <>", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberGreaterThan(String value) {
            addCriterion("gc.qq_group_number >", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberGreaterThanOrEqualTo(String value) {
            addCriterion("gc.qq_group_number >=", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberLessThan(String value) {
            addCriterion("gc.qq_group_number <", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberLessThanOrEqualTo(String value) {
            addCriterion("gc.qq_group_number <=", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberLike(String value) {
            addCriterion("gc.qq_group_number like", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberNotLike(String value) {
            addCriterion("gc.qq_group_number not like", value, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberIn(List<String> values) {
            addCriterion("gc.qq_group_number in", values, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberNotIn(List<String> values) {
            addCriterion("gc.qq_group_number not in", values, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberBetween(String value1, String value2) {
            addCriterion("gc.qq_group_number between", value1, value2, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andQqGroupNumberNotBetween(String value1, String value2) {
            addCriterion("gc.qq_group_number not between", value1, value2, "qqGroupNumber");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("gc.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("gc.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("gc.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("gc.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("gc.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("gc.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("gc.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("gc.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("gc.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("gc.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("gc.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("gc.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("gc.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("gc.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("gc.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("gc.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("gc.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("gc.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("gc.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("gc.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("gc.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("gc.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("gc.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("gc.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("gc.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("gc.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("gc.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("gc.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("gc.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("gc.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("gc.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gc.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("gc.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("gc.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("gc.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("gc.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("gc.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("gc.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("gc.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("gc.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("gc.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("gc.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("gc.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("gc.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("gc.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("gc.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("gc.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("gc.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("gc.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("gc.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("gc.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("gc.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("gc.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("gc.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("gc.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("gc.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("gc.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gc.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("gc.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("gc.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("gc.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("gc.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("gc.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("gc.modified_time not between", value1, value2, "modifiedTime");
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