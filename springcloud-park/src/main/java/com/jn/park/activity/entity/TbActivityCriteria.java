package com.jn.park.activity.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbActivityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbActivityCriteria() {
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

        public Criteria andActiTypeIsNull() {
            addCriterion("acti_type is null");
            return (Criteria) this;
        }

        public Criteria andActiTypeIsNotNull() {
            addCriterion("acti_type is not null");
            return (Criteria) this;
        }

        public Criteria andActiTypeEqualTo(String value) {
            addCriterion("acti_type =", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotEqualTo(String value) {
            addCriterion("acti_type <>", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeGreaterThan(String value) {
            addCriterion("acti_type >", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("acti_type >=", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeLessThan(String value) {
            addCriterion("acti_type <", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeLessThanOrEqualTo(String value) {
            addCriterion("acti_type <=", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeLike(String value) {
            addCriterion("acti_type like", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotLike(String value) {
            addCriterion("acti_type not like", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeIn(List<String> values) {
            addCriterion("acti_type in", values, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotIn(List<String> values) {
            addCriterion("acti_type not in", values, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeBetween(String value1, String value2) {
            addCriterion("acti_type between", value1, value2, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotBetween(String value1, String value2) {
            addCriterion("acti_type not between", value1, value2, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiNameIsNull() {
            addCriterion("acti_name is null");
            return (Criteria) this;
        }

        public Criteria andActiNameIsNotNull() {
            addCriterion("acti_name is not null");
            return (Criteria) this;
        }

        public Criteria andActiNameEqualTo(String value) {
            addCriterion("acti_name =", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotEqualTo(String value) {
            addCriterion("acti_name <>", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameGreaterThan(String value) {
            addCriterion("acti_name >", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameGreaterThanOrEqualTo(String value) {
            addCriterion("acti_name >=", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameLessThan(String value) {
            addCriterion("acti_name <", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameLessThanOrEqualTo(String value) {
            addCriterion("acti_name <=", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameLike(String value) {
            addCriterion("acti_name like", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotLike(String value) {
            addCriterion("acti_name not like", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameIn(List<String> values) {
            addCriterion("acti_name in", values, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotIn(List<String> values) {
            addCriterion("acti_name not in", values, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameBetween(String value1, String value2) {
            addCriterion("acti_name between", value1, value2, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotBetween(String value1, String value2) {
            addCriterion("acti_name not between", value1, value2, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeIsNull() {
            addCriterion("acti_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeIsNotNull() {
            addCriterion("acti_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeEqualTo(Date value) {
            addCriterion("acti_start_time =", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeNotEqualTo(Date value) {
            addCriterion("acti_start_time <>", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeGreaterThan(Date value) {
            addCriterion("acti_start_time >", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acti_start_time >=", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeLessThan(Date value) {
            addCriterion("acti_start_time <", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("acti_start_time <=", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeIn(List<Date> values) {
            addCriterion("acti_start_time in", values, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeNotIn(List<Date> values) {
            addCriterion("acti_start_time not in", values, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeBetween(Date value1, Date value2) {
            addCriterion("acti_start_time between", value1, value2, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("acti_start_time not between", value1, value2, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeIsNull() {
            addCriterion("acti_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeIsNotNull() {
            addCriterion("acti_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeEqualTo(Date value) {
            addCriterion("acti_end_time =", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeNotEqualTo(Date value) {
            addCriterion("acti_end_time <>", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeGreaterThan(Date value) {
            addCriterion("acti_end_time >", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acti_end_time >=", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeLessThan(Date value) {
            addCriterion("acti_end_time <", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("acti_end_time <=", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeIn(List<Date> values) {
            addCriterion("acti_end_time in", values, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeNotIn(List<Date> values) {
            addCriterion("acti_end_time not in", values, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeBetween(Date value1, Date value2) {
            addCriterion("acti_end_time between", value1, value2, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("acti_end_time not between", value1, value2, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNull() {
            addCriterion("apply_start_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNotNull() {
            addCriterion("apply_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeEqualTo(Date value) {
            addCriterion("apply_start_time =", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotEqualTo(Date value) {
            addCriterion("apply_start_time <>", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThan(Date value) {
            addCriterion("apply_start_time >", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_start_time >=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThan(Date value) {
            addCriterion("apply_start_time <", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_start_time <=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIn(List<Date> values) {
            addCriterion("apply_start_time in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotIn(List<Date> values) {
            addCriterion("apply_start_time not in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeBetween(Date value1, Date value2) {
            addCriterion("apply_start_time between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_start_time not between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIsNull() {
            addCriterion("apply_end_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIsNotNull() {
            addCriterion("apply_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeEqualTo(Date value) {
            addCriterion("apply_end_time =", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotEqualTo(Date value) {
            addCriterion("apply_end_time <>", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeGreaterThan(Date value) {
            addCriterion("apply_end_time >", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_end_time >=", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeLessThan(Date value) {
            addCriterion("apply_end_time <", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_end_time <=", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIn(List<Date> values) {
            addCriterion("apply_end_time in", values, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotIn(List<Date> values) {
            addCriterion("apply_end_time not in", values, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeBetween(Date value1, Date value2) {
            addCriterion("apply_end_time between", value1, value2, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_end_time not between", value1, value2, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeIsNull() {
            addCriterion("mes_send_time is null");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeIsNotNull() {
            addCriterion("mes_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeEqualTo(Date value) {
            addCriterion("mes_send_time =", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeNotEqualTo(Date value) {
            addCriterion("mes_send_time <>", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeGreaterThan(Date value) {
            addCriterion("mes_send_time >", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mes_send_time >=", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeLessThan(Date value) {
            addCriterion("mes_send_time <", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("mes_send_time <=", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeIn(List<Date> values) {
            addCriterion("mes_send_time in", values, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeNotIn(List<Date> values) {
            addCriterion("mes_send_time not in", values, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeBetween(Date value1, Date value2) {
            addCriterion("mes_send_time between", value1, value2, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("mes_send_time not between", value1, value2, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(String value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(String value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(String value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(String value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(String value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLike(String value) {
            addCriterion("park_id like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotLike(String value) {
            addCriterion("park_id not like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<String> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<String> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(String value1, String value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(String value1, String value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andActiAddressIsNull() {
            addCriterion("acti_address is null");
            return (Criteria) this;
        }

        public Criteria andActiAddressIsNotNull() {
            addCriterion("acti_address is not null");
            return (Criteria) this;
        }

        public Criteria andActiAddressEqualTo(String value) {
            addCriterion("acti_address =", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotEqualTo(String value) {
            addCriterion("acti_address <>", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressGreaterThan(String value) {
            addCriterion("acti_address >", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("acti_address >=", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressLessThan(String value) {
            addCriterion("acti_address <", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressLessThanOrEqualTo(String value) {
            addCriterion("acti_address <=", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressLike(String value) {
            addCriterion("acti_address like", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotLike(String value) {
            addCriterion("acti_address not like", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressIn(List<String> values) {
            addCriterion("acti_address in", values, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotIn(List<String> values) {
            addCriterion("acti_address not in", values, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressBetween(String value1, String value2) {
            addCriterion("acti_address between", value1, value2, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotBetween(String value1, String value2) {
            addCriterion("acti_address not between", value1, value2, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiCostIsNull() {
            addCriterion("acti_cost is null");
            return (Criteria) this;
        }

        public Criteria andActiCostIsNotNull() {
            addCriterion("acti_cost is not null");
            return (Criteria) this;
        }

        public Criteria andActiCostEqualTo(BigDecimal value) {
            addCriterion("acti_cost =", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostNotEqualTo(BigDecimal value) {
            addCriterion("acti_cost <>", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostGreaterThan(BigDecimal value) {
            addCriterion("acti_cost >", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("acti_cost >=", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostLessThan(BigDecimal value) {
            addCriterion("acti_cost <", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("acti_cost <=", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostIn(List<BigDecimal> values) {
            addCriterion("acti_cost in", values, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostNotIn(List<BigDecimal> values) {
            addCriterion("acti_cost not in", values, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("acti_cost between", value1, value2, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("acti_cost not between", value1, value2, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerIsNull() {
            addCriterion("acti_organizer is null");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerIsNotNull() {
            addCriterion("acti_organizer is not null");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerEqualTo(String value) {
            addCriterion("acti_organizer =", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotEqualTo(String value) {
            addCriterion("acti_organizer <>", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerGreaterThan(String value) {
            addCriterion("acti_organizer >", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("acti_organizer >=", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerLessThan(String value) {
            addCriterion("acti_organizer <", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerLessThanOrEqualTo(String value) {
            addCriterion("acti_organizer <=", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerLike(String value) {
            addCriterion("acti_organizer like", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotLike(String value) {
            addCriterion("acti_organizer not like", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerIn(List<String> values) {
            addCriterion("acti_organizer in", values, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotIn(List<String> values) {
            addCriterion("acti_organizer not in", values, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerBetween(String value1, String value2) {
            addCriterion("acti_organizer between", value1, value2, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotBetween(String value1, String value2) {
            addCriterion("acti_organizer not between", value1, value2, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiNumberIsNull() {
            addCriterion("acti_number is null");
            return (Criteria) this;
        }

        public Criteria andActiNumberIsNotNull() {
            addCriterion("acti_number is not null");
            return (Criteria) this;
        }

        public Criteria andActiNumberEqualTo(Integer value) {
            addCriterion("acti_number =", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberNotEqualTo(Integer value) {
            addCriterion("acti_number <>", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberGreaterThan(Integer value) {
            addCriterion("acti_number >", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("acti_number >=", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberLessThan(Integer value) {
            addCriterion("acti_number <", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberLessThanOrEqualTo(Integer value) {
            addCriterion("acti_number <=", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberIn(List<Integer> values) {
            addCriterion("acti_number in", values, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberNotIn(List<Integer> values) {
            addCriterion("acti_number not in", values, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberBetween(Integer value1, Integer value2) {
            addCriterion("acti_number between", value1, value2, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("acti_number not between", value1, value2, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlIsNull() {
            addCriterion("acti_poster_url is null");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlIsNotNull() {
            addCriterion("acti_poster_url is not null");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlEqualTo(String value) {
            addCriterion("acti_poster_url =", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotEqualTo(String value) {
            addCriterion("acti_poster_url <>", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlGreaterThan(String value) {
            addCriterion("acti_poster_url >", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlGreaterThanOrEqualTo(String value) {
            addCriterion("acti_poster_url >=", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlLessThan(String value) {
            addCriterion("acti_poster_url <", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlLessThanOrEqualTo(String value) {
            addCriterion("acti_poster_url <=", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlLike(String value) {
            addCriterion("acti_poster_url like", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotLike(String value) {
            addCriterion("acti_poster_url not like", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlIn(List<String> values) {
            addCriterion("acti_poster_url in", values, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotIn(List<String> values) {
            addCriterion("acti_poster_url not in", values, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlBetween(String value1, String value2) {
            addCriterion("acti_poster_url between", value1, value2, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotBetween(String value1, String value2) {
            addCriterion("acti_poster_url not between", value1, value2, "actiPosterUrl");
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

        public Criteria andCreateAccountIsNull() {
            addCriterion("create_account is null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNotNull() {
            addCriterion("create_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountEqualTo(String value) {
            addCriterion("create_account =", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotEqualTo(String value) {
            addCriterion("create_account <>", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThan(String value) {
            addCriterion("create_account >", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("create_account >=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThan(String value) {
            addCriterion("create_account <", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThanOrEqualTo(String value) {
            addCriterion("create_account <=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLike(String value) {
            addCriterion("create_account like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotLike(String value) {
            addCriterion("create_account not like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIn(List<String> values) {
            addCriterion("create_account in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotIn(List<String> values) {
            addCriterion("create_account not in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountBetween(String value1, String value2) {
            addCriterion("create_account between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotBetween(String value1, String value2) {
            addCriterion("create_account not between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNull() {
            addCriterion("update_account is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNotNull() {
            addCriterion("update_account is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountEqualTo(String value) {
            addCriterion("update_account =", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotEqualTo(String value) {
            addCriterion("update_account <>", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThan(String value) {
            addCriterion("update_account >", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("update_account >=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThan(String value) {
            addCriterion("update_account <", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThanOrEqualTo(String value) {
            addCriterion("update_account <=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLike(String value) {
            addCriterion("update_account like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotLike(String value) {
            addCriterion("update_account not like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIn(List<String> values) {
            addCriterion("update_account in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotIn(List<String> values) {
            addCriterion("update_account not in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountBetween(String value1, String value2) {
            addCriterion("update_account between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotBetween(String value1, String value2) {
            addCriterion("update_account not between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andActiViewsIsNull() {
            addCriterion("acti_views is null");
            return (Criteria) this;
        }

        public Criteria andActiViewsIsNotNull() {
            addCriterion("acti_views is not null");
            return (Criteria) this;
        }

        public Criteria andActiViewsEqualTo(Integer value) {
            addCriterion("acti_views =", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsNotEqualTo(Integer value) {
            addCriterion("acti_views <>", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsGreaterThan(Integer value) {
            addCriterion("acti_views >", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("acti_views >=", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsLessThan(Integer value) {
            addCriterion("acti_views <", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsLessThanOrEqualTo(Integer value) {
            addCriterion("acti_views <=", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsIn(List<Integer> values) {
            addCriterion("acti_views in", values, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsNotIn(List<Integer> values) {
            addCriterion("acti_views not in", values, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsBetween(Integer value1, Integer value2) {
            addCriterion("acti_views between", value1, value2, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("acti_views not between", value1, value2, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiLikeIsNull() {
            addCriterion("acti_like is null");
            return (Criteria) this;
        }

        public Criteria andActiLikeIsNotNull() {
            addCriterion("acti_like is not null");
            return (Criteria) this;
        }

        public Criteria andActiLikeEqualTo(Integer value) {
            addCriterion("acti_like =", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeNotEqualTo(Integer value) {
            addCriterion("acti_like <>", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeGreaterThan(Integer value) {
            addCriterion("acti_like >", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("acti_like >=", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeLessThan(Integer value) {
            addCriterion("acti_like <", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeLessThanOrEqualTo(Integer value) {
            addCriterion("acti_like <=", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeIn(List<Integer> values) {
            addCriterion("acti_like in", values, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeNotIn(List<Integer> values) {
            addCriterion("acti_like not in", values, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeBetween(Integer value1, Integer value2) {
            addCriterion("acti_like between", value1, value2, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("acti_like not between", value1, value2, "actiLike");
            return (Criteria) this;
        }

        public Criteria andApplyNumIsNull() {
            addCriterion("apply_num is null");
            return (Criteria) this;
        }

        public Criteria andApplyNumIsNotNull() {
            addCriterion("apply_num is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNumEqualTo(Integer value) {
            addCriterion("apply_num =", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotEqualTo(Integer value) {
            addCriterion("apply_num <>", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumGreaterThan(Integer value) {
            addCriterion("apply_num >", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_num >=", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumLessThan(Integer value) {
            addCriterion("apply_num <", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumLessThanOrEqualTo(Integer value) {
            addCriterion("apply_num <=", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumIn(List<Integer> values) {
            addCriterion("apply_num in", values, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotIn(List<Integer> values) {
            addCriterion("apply_num not in", values, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumBetween(Integer value1, Integer value2) {
            addCriterion("apply_num between", value1, value2, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_num not between", value1, value2, "applyNum");
            return (Criteria) this;
        }

        public Criteria andParticNumIsNull() {
            addCriterion("partic_num is null");
            return (Criteria) this;
        }

        public Criteria andParticNumIsNotNull() {
            addCriterion("partic_num is not null");
            return (Criteria) this;
        }

        public Criteria andParticNumEqualTo(Integer value) {
            addCriterion("partic_num =", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumNotEqualTo(Integer value) {
            addCriterion("partic_num <>", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumGreaterThan(Integer value) {
            addCriterion("partic_num >", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("partic_num >=", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumLessThan(Integer value) {
            addCriterion("partic_num <", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumLessThanOrEqualTo(Integer value) {
            addCriterion("partic_num <=", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumIn(List<Integer> values) {
            addCriterion("partic_num in", values, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumNotIn(List<Integer> values) {
            addCriterion("partic_num not in", values, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumBetween(Integer value1, Integer value2) {
            addCriterion("partic_num between", value1, value2, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumNotBetween(Integer value1, Integer value2) {
            addCriterion("partic_num not between", value1, value2, "particNum");
            return (Criteria) this;
        }

        public Criteria andIsIndexIsNull() {
            addCriterion("is_index is null");
            return (Criteria) this;
        }

        public Criteria andIsIndexIsNotNull() {
            addCriterion("is_index is not null");
            return (Criteria) this;
        }

        public Criteria andIsIndexEqualTo(String value) {
            addCriterion("is_index =", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexNotEqualTo(String value) {
            addCriterion("is_index <>", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexGreaterThan(String value) {
            addCriterion("is_index >", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexGreaterThanOrEqualTo(String value) {
            addCriterion("is_index >=", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexLessThan(String value) {
            addCriterion("is_index <", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexLessThanOrEqualTo(String value) {
            addCriterion("is_index <=", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexLike(String value) {
            addCriterion("is_index like", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexNotLike(String value) {
            addCriterion("is_index not like", value, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexIn(List<String> values) {
            addCriterion("is_index in", values, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexNotIn(List<String> values) {
            addCriterion("is_index not in", values, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexBetween(String value1, String value2) {
            addCriterion("is_index between", value1, value2, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsIndexNotBetween(String value1, String value2) {
            addCriterion("is_index not between", value1, value2, "isIndex");
            return (Criteria) this;
        }

        public Criteria andIsApplyIsNull() {
            addCriterion("is_apply is null");
            return (Criteria) this;
        }

        public Criteria andIsApplyIsNotNull() {
            addCriterion("is_apply is not null");
            return (Criteria) this;
        }

        public Criteria andIsApplyEqualTo(String value) {
            addCriterion("is_apply =", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotEqualTo(String value) {
            addCriterion("is_apply <>", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyGreaterThan(String value) {
            addCriterion("is_apply >", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyGreaterThanOrEqualTo(String value) {
            addCriterion("is_apply >=", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLessThan(String value) {
            addCriterion("is_apply <", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLessThanOrEqualTo(String value) {
            addCriterion("is_apply <=", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLike(String value) {
            addCriterion("is_apply like", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotLike(String value) {
            addCriterion("is_apply not like", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyIn(List<String> values) {
            addCriterion("is_apply in", values, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotIn(List<String> values) {
            addCriterion("is_apply not in", values, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyBetween(String value1, String value2) {
            addCriterion("is_apply between", value1, value2, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotBetween(String value1, String value2) {
            addCriterion("is_apply not between", value1, value2, "isApply");
            return (Criteria) this;
        }

        public Criteria andActiOrderIsNull() {
            addCriterion("acti_order is null");
            return (Criteria) this;
        }

        public Criteria andActiOrderIsNotNull() {
            addCriterion("acti_order is not null");
            return (Criteria) this;
        }

        public Criteria andActiOrderEqualTo(Integer value) {
            addCriterion("acti_order =", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderNotEqualTo(Integer value) {
            addCriterion("acti_order <>", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderGreaterThan(Integer value) {
            addCriterion("acti_order >", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("acti_order >=", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderLessThan(Integer value) {
            addCriterion("acti_order <", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderLessThanOrEqualTo(Integer value) {
            addCriterion("acti_order <=", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderIn(List<Integer> values) {
            addCriterion("acti_order in", values, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderNotIn(List<Integer> values) {
            addCriterion("acti_order not in", values, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderBetween(Integer value1, Integer value2) {
            addCriterion("acti_order between", value1, value2, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("acti_order not between", value1, value2, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNull() {
            addCriterion("issue_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNotNull() {
            addCriterion("issue_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeEqualTo(Date value) {
            addCriterion("issue_time =", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotEqualTo(Date value) {
            addCriterion("issue_time <>", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThan(Date value) {
            addCriterion("issue_time >", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_time >=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThan(Date value) {
            addCriterion("issue_time <", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThanOrEqualTo(Date value) {
            addCriterion("issue_time <=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIn(List<Date> values) {
            addCriterion("issue_time in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotIn(List<Date> values) {
            addCriterion("issue_time not in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeBetween(Date value1, Date value2) {
            addCriterion("issue_time between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotBetween(Date value1, Date value2) {
            addCriterion("issue_time not between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueAccountIsNull() {
            addCriterion("issue_account is null");
            return (Criteria) this;
        }

        public Criteria andIssueAccountIsNotNull() {
            addCriterion("issue_account is not null");
            return (Criteria) this;
        }

        public Criteria andIssueAccountEqualTo(String value) {
            addCriterion("issue_account =", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotEqualTo(String value) {
            addCriterion("issue_account <>", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountGreaterThan(String value) {
            addCriterion("issue_account >", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountGreaterThanOrEqualTo(String value) {
            addCriterion("issue_account >=", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountLessThan(String value) {
            addCriterion("issue_account <", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountLessThanOrEqualTo(String value) {
            addCriterion("issue_account <=", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountLike(String value) {
            addCriterion("issue_account like", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotLike(String value) {
            addCriterion("issue_account not like", value, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountIn(List<String> values) {
            addCriterion("issue_account in", values, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotIn(List<String> values) {
            addCriterion("issue_account not in", values, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountBetween(String value1, String value2) {
            addCriterion("issue_account between", value1, value2, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andIssueAccountNotBetween(String value1, String value2) {
            addCriterion("issue_account not between", value1, value2, "issueAccount");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumIsNull() {
            addCriterion("show_apply_num is null");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumIsNotNull() {
            addCriterion("show_apply_num is not null");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumEqualTo(String value) {
            addCriterion("show_apply_num =", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumNotEqualTo(String value) {
            addCriterion("show_apply_num <>", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumGreaterThan(String value) {
            addCriterion("show_apply_num >", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumGreaterThanOrEqualTo(String value) {
            addCriterion("show_apply_num >=", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumLessThan(String value) {
            addCriterion("show_apply_num <", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumLessThanOrEqualTo(String value) {
            addCriterion("show_apply_num <=", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumLike(String value) {
            addCriterion("show_apply_num like", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumNotLike(String value) {
            addCriterion("show_apply_num not like", value, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumIn(List<String> values) {
            addCriterion("show_apply_num in", values, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumNotIn(List<String> values) {
            addCriterion("show_apply_num not in", values, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumBetween(String value1, String value2) {
            addCriterion("show_apply_num between", value1, value2, "showApplyNum");
            return (Criteria) this;
        }

        public Criteria andShowApplyNumNotBetween(String value1, String value2) {
            addCriterion("show_apply_num not between", value1, value2, "showApplyNum");
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