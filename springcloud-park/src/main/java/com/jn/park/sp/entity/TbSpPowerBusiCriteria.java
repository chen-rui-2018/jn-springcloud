package com.jn.park.sp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSpPowerBusiCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSpPowerBusiCriteria() {
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

        public Criteria andPowerIdIsNull() {
            addCriterion("power_id is null");
            return (Criteria) this;
        }

        public Criteria andPowerIdIsNotNull() {
            addCriterion("power_id is not null");
            return (Criteria) this;
        }

        public Criteria andPowerIdEqualTo(String value) {
            addCriterion("power_id =", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotEqualTo(String value) {
            addCriterion("power_id <>", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdGreaterThan(String value) {
            addCriterion("power_id >", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdGreaterThanOrEqualTo(String value) {
            addCriterion("power_id >=", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdLessThan(String value) {
            addCriterion("power_id <", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdLessThanOrEqualTo(String value) {
            addCriterion("power_id <=", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdLike(String value) {
            addCriterion("power_id like", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotLike(String value) {
            addCriterion("power_id not like", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdIn(List<String> values) {
            addCriterion("power_id in", values, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotIn(List<String> values) {
            addCriterion("power_id not in", values, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdBetween(String value1, String value2) {
            addCriterion("power_id between", value1, value2, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotBetween(String value1, String value2) {
            addCriterion("power_id not between", value1, value2, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerNameIsNull() {
            addCriterion("power_name is null");
            return (Criteria) this;
        }

        public Criteria andPowerNameIsNotNull() {
            addCriterion("power_name is not null");
            return (Criteria) this;
        }

        public Criteria andPowerNameEqualTo(String value) {
            addCriterion("power_name =", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotEqualTo(String value) {
            addCriterion("power_name <>", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameGreaterThan(String value) {
            addCriterion("power_name >", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("power_name >=", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLessThan(String value) {
            addCriterion("power_name <", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLessThanOrEqualTo(String value) {
            addCriterion("power_name <=", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLike(String value) {
            addCriterion("power_name like", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotLike(String value) {
            addCriterion("power_name not like", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameIn(List<String> values) {
            addCriterion("power_name in", values, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotIn(List<String> values) {
            addCriterion("power_name not in", values, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameBetween(String value1, String value2) {
            addCriterion("power_name between", value1, value2, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotBetween(String value1, String value2) {
            addCriterion("power_name not between", value1, value2, "powerName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(String value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(String value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(String value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(String value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(String value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLike(String value) {
            addCriterion("deal_time like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotLike(String value) {
            addCriterion("deal_time not like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<String> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<String> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(String value1, String value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(String value1, String value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealAddressIsNull() {
            addCriterion("deal_address is null");
            return (Criteria) this;
        }

        public Criteria andDealAddressIsNotNull() {
            addCriterion("deal_address is not null");
            return (Criteria) this;
        }

        public Criteria andDealAddressEqualTo(String value) {
            addCriterion("deal_address =", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotEqualTo(String value) {
            addCriterion("deal_address <>", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressGreaterThan(String value) {
            addCriterion("deal_address >", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressGreaterThanOrEqualTo(String value) {
            addCriterion("deal_address >=", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressLessThan(String value) {
            addCriterion("deal_address <", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressLessThanOrEqualTo(String value) {
            addCriterion("deal_address <=", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressLike(String value) {
            addCriterion("deal_address like", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotLike(String value) {
            addCriterion("deal_address not like", value, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressIn(List<String> values) {
            addCriterion("deal_address in", values, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotIn(List<String> values) {
            addCriterion("deal_address not in", values, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressBetween(String value1, String value2) {
            addCriterion("deal_address between", value1, value2, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealAddressNotBetween(String value1, String value2) {
            addCriterion("deal_address not between", value1, value2, "dealAddress");
            return (Criteria) this;
        }

        public Criteria andDealUrlIsNull() {
            addCriterion("deal_url is null");
            return (Criteria) this;
        }

        public Criteria andDealUrlIsNotNull() {
            addCriterion("deal_url is not null");
            return (Criteria) this;
        }

        public Criteria andDealUrlEqualTo(String value) {
            addCriterion("deal_url =", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlNotEqualTo(String value) {
            addCriterion("deal_url <>", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlGreaterThan(String value) {
            addCriterion("deal_url >", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlGreaterThanOrEqualTo(String value) {
            addCriterion("deal_url >=", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlLessThan(String value) {
            addCriterion("deal_url <", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlLessThanOrEqualTo(String value) {
            addCriterion("deal_url <=", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlLike(String value) {
            addCriterion("deal_url like", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlNotLike(String value) {
            addCriterion("deal_url not like", value, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlIn(List<String> values) {
            addCriterion("deal_url in", values, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlNotIn(List<String> values) {
            addCriterion("deal_url not in", values, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlBetween(String value1, String value2) {
            addCriterion("deal_url between", value1, value2, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andDealUrlNotBetween(String value1, String value2) {
            addCriterion("deal_url not between", value1, value2, "dealUrl");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("link_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("link_phone =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("link_phone <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("link_phone >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("link_phone >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("link_phone <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("link_phone <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("link_phone like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("link_phone not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("link_phone in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("link_phone not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("link_phone between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("link_phone not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysIsNull() {
            addCriterion("deal_limit_days is null");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysIsNotNull() {
            addCriterion("deal_limit_days is not null");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysEqualTo(Byte value) {
            addCriterion("deal_limit_days =", value, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysNotEqualTo(Byte value) {
            addCriterion("deal_limit_days <>", value, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysGreaterThan(Byte value) {
            addCriterion("deal_limit_days >", value, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysGreaterThanOrEqualTo(Byte value) {
            addCriterion("deal_limit_days >=", value, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysLessThan(Byte value) {
            addCriterion("deal_limit_days <", value, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysLessThanOrEqualTo(Byte value) {
            addCriterion("deal_limit_days <=", value, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysIn(List<Byte> values) {
            addCriterion("deal_limit_days in", values, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysNotIn(List<Byte> values) {
            addCriterion("deal_limit_days not in", values, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysBetween(Byte value1, Byte value2) {
            addCriterion("deal_limit_days between", value1, value2, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andDealLimitDaysNotBetween(Byte value1, Byte value2) {
            addCriterion("deal_limit_days not between", value1, value2, "dealLimitDays");
            return (Criteria) this;
        }

        public Criteria andFlowPicIsNull() {
            addCriterion("flow_pic is null");
            return (Criteria) this;
        }

        public Criteria andFlowPicIsNotNull() {
            addCriterion("flow_pic is not null");
            return (Criteria) this;
        }

        public Criteria andFlowPicEqualTo(String value) {
            addCriterion("flow_pic =", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicNotEqualTo(String value) {
            addCriterion("flow_pic <>", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicGreaterThan(String value) {
            addCriterion("flow_pic >", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicGreaterThanOrEqualTo(String value) {
            addCriterion("flow_pic >=", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicLessThan(String value) {
            addCriterion("flow_pic <", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicLessThanOrEqualTo(String value) {
            addCriterion("flow_pic <=", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicLike(String value) {
            addCriterion("flow_pic like", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicNotLike(String value) {
            addCriterion("flow_pic not like", value, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicIn(List<String> values) {
            addCriterion("flow_pic in", values, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicNotIn(List<String> values) {
            addCriterion("flow_pic not in", values, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicBetween(String value1, String value2) {
            addCriterion("flow_pic between", value1, value2, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFlowPicNotBetween(String value1, String value2) {
            addCriterion("flow_pic not between", value1, value2, "flowPic");
            return (Criteria) this;
        }

        public Criteria andFeeStandardIsNull() {
            addCriterion("fee_standard is null");
            return (Criteria) this;
        }

        public Criteria andFeeStandardIsNotNull() {
            addCriterion("fee_standard is not null");
            return (Criteria) this;
        }

        public Criteria andFeeStandardEqualTo(String value) {
            addCriterion("fee_standard =", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardNotEqualTo(String value) {
            addCriterion("fee_standard <>", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardGreaterThan(String value) {
            addCriterion("fee_standard >", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardGreaterThanOrEqualTo(String value) {
            addCriterion("fee_standard >=", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardLessThan(String value) {
            addCriterion("fee_standard <", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardLessThanOrEqualTo(String value) {
            addCriterion("fee_standard <=", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardLike(String value) {
            addCriterion("fee_standard like", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardNotLike(String value) {
            addCriterion("fee_standard not like", value, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardIn(List<String> values) {
            addCriterion("fee_standard in", values, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardNotIn(List<String> values) {
            addCriterion("fee_standard not in", values, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardBetween(String value1, String value2) {
            addCriterion("fee_standard between", value1, value2, "feeStandard");
            return (Criteria) this;
        }

        public Criteria andFeeStandardNotBetween(String value1, String value2) {
            addCriterion("fee_standard not between", value1, value2, "feeStandard");
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