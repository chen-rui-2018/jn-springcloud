package com.jn.portals.activity.entity;

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
            addCriterion("activity.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("activity.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("activity.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("activity.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("activity.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("activity.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("activity.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("activity.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("activity.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("activity.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("activity.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("activity.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("activity.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andActiTypeIsNull() {
            addCriterion("activity.acti_type is null");
            return (Criteria) this;
        }

        public Criteria andActiTypeIsNotNull() {
            addCriterion("activity.acti_type is not null");
            return (Criteria) this;
        }

        public Criteria andActiTypeEqualTo(String value) {
            addCriterion("activity.acti_type =", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotEqualTo(String value) {
            addCriterion("activity.acti_type <>", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeGreaterThan(String value) {
            addCriterion("activity.acti_type >", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("activity.acti_type >=", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeLessThan(String value) {
            addCriterion("activity.acti_type <", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeLessThanOrEqualTo(String value) {
            addCriterion("activity.acti_type <=", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeLike(String value) {
            addCriterion("activity.acti_type like", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotLike(String value) {
            addCriterion("activity.acti_type not like", value, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeIn(List<String> values) {
            addCriterion("activity.acti_type in", values, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotIn(List<String> values) {
            addCriterion("activity.acti_type not in", values, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeBetween(String value1, String value2) {
            addCriterion("activity.acti_type between", value1, value2, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiTypeNotBetween(String value1, String value2) {
            addCriterion("activity.acti_type not between", value1, value2, "actiType");
            return (Criteria) this;
        }

        public Criteria andActiNameIsNull() {
            addCriterion("activity.acti_name is null");
            return (Criteria) this;
        }

        public Criteria andActiNameIsNotNull() {
            addCriterion("activity.acti_name is not null");
            return (Criteria) this;
        }

        public Criteria andActiNameEqualTo(String value) {
            addCriterion("activity.acti_name =", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotEqualTo(String value) {
            addCriterion("activity.acti_name <>", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameGreaterThan(String value) {
            addCriterion("activity.acti_name >", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity.acti_name >=", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameLessThan(String value) {
            addCriterion("activity.acti_name <", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameLessThanOrEqualTo(String value) {
            addCriterion("activity.acti_name <=", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameLike(String value) {
            addCriterion("activity.acti_name like", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotLike(String value) {
            addCriterion("activity.acti_name not like", value, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameIn(List<String> values) {
            addCriterion("activity.acti_name in", values, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotIn(List<String> values) {
            addCriterion("activity.acti_name not in", values, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameBetween(String value1, String value2) {
            addCriterion("activity.acti_name between", value1, value2, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiNameNotBetween(String value1, String value2) {
            addCriterion("activity.acti_name not between", value1, value2, "actiName");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeIsNull() {
            addCriterion("activity.acti_start_time is null");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeIsNotNull() {
            addCriterion("activity.acti_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeEqualTo(Date value) {
            addCriterion("activity.acti_start_time =", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeNotEqualTo(Date value) {
            addCriterion("activity.acti_start_time <>", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeGreaterThan(Date value) {
            addCriterion("activity.acti_start_time >", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.acti_start_time >=", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeLessThan(Date value) {
            addCriterion("activity.acti_start_time <", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.acti_start_time <=", value, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeIn(List<Date> values) {
            addCriterion("activity.acti_start_time in", values, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeNotIn(List<Date> values) {
            addCriterion("activity.acti_start_time not in", values, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeBetween(Date value1, Date value2) {
            addCriterion("activity.acti_start_time between", value1, value2, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.acti_start_time not between", value1, value2, "actiStartTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeIsNull() {
            addCriterion("activity.acti_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeIsNotNull() {
            addCriterion("activity.acti_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeEqualTo(Date value) {
            addCriterion("activity.acti_end_time =", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeNotEqualTo(Date value) {
            addCriterion("activity.acti_end_time <>", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeGreaterThan(Date value) {
            addCriterion("activity.acti_end_time >", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.acti_end_time >=", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeLessThan(Date value) {
            addCriterion("activity.acti_end_time <", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.acti_end_time <=", value, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeIn(List<Date> values) {
            addCriterion("activity.acti_end_time in", values, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeNotIn(List<Date> values) {
            addCriterion("activity.acti_end_time not in", values, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeBetween(Date value1, Date value2) {
            addCriterion("activity.acti_end_time between", value1, value2, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andActiEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.acti_end_time not between", value1, value2, "actiEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNull() {
            addCriterion("activity.apply_start_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNotNull() {
            addCriterion("activity.apply_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeEqualTo(Date value) {
            addCriterion("activity.apply_start_time =", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotEqualTo(Date value) {
            addCriterion("activity.apply_start_time <>", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThan(Date value) {
            addCriterion("activity.apply_start_time >", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.apply_start_time >=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThan(Date value) {
            addCriterion("activity.apply_start_time <", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.apply_start_time <=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIn(List<Date> values) {
            addCriterion("activity.apply_start_time in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotIn(List<Date> values) {
            addCriterion("activity.apply_start_time not in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeBetween(Date value1, Date value2) {
            addCriterion("activity.apply_start_time between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.apply_start_time not between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIsNull() {
            addCriterion("activity.apply_end_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIsNotNull() {
            addCriterion("activity.apply_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeEqualTo(Date value) {
            addCriterion("activity.apply_end_time =", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotEqualTo(Date value) {
            addCriterion("activity.apply_end_time <>", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeGreaterThan(Date value) {
            addCriterion("activity.apply_end_time >", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.apply_end_time >=", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeLessThan(Date value) {
            addCriterion("activity.apply_end_time <", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.apply_end_time <=", value, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeIn(List<Date> values) {
            addCriterion("activity.apply_end_time in", values, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotIn(List<Date> values) {
            addCriterion("activity.apply_end_time not in", values, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeBetween(Date value1, Date value2) {
            addCriterion("activity.apply_end_time between", value1, value2, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andApplyEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.apply_end_time not between", value1, value2, "applyEndTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeIsNull() {
            addCriterion("activity.mes_send_time is null");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeIsNotNull() {
            addCriterion("activity.mes_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeEqualTo(Date value) {
            addCriterion("activity.mes_send_time =", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeNotEqualTo(Date value) {
            addCriterion("activity.mes_send_time <>", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeGreaterThan(Date value) {
            addCriterion("activity.mes_send_time >", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.mes_send_time >=", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeLessThan(Date value) {
            addCriterion("activity.mes_send_time <", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.mes_send_time <=", value, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeIn(List<Date> values) {
            addCriterion("activity.mes_send_time in", values, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeNotIn(List<Date> values) {
            addCriterion("activity.mes_send_time not in", values, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeBetween(Date value1, Date value2) {
            addCriterion("activity.mes_send_time between", value1, value2, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andMesSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.mes_send_time not between", value1, value2, "mesSendTime");
            return (Criteria) this;
        }

        public Criteria andActiAddressIsNull() {
            addCriterion("activity.acti_address is null");
            return (Criteria) this;
        }

        public Criteria andActiAddressIsNotNull() {
            addCriterion("activity.acti_address is not null");
            return (Criteria) this;
        }

        public Criteria andActiAddressEqualTo(String value) {
            addCriterion("activity.acti_address =", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotEqualTo(String value) {
            addCriterion("activity.acti_address <>", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressGreaterThan(String value) {
            addCriterion("activity.acti_address >", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("activity.acti_address >=", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressLessThan(String value) {
            addCriterion("activity.acti_address <", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressLessThanOrEqualTo(String value) {
            addCriterion("activity.acti_address <=", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressLike(String value) {
            addCriterion("activity.acti_address like", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotLike(String value) {
            addCriterion("activity.acti_address not like", value, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressIn(List<String> values) {
            addCriterion("activity.acti_address in", values, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotIn(List<String> values) {
            addCriterion("activity.acti_address not in", values, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressBetween(String value1, String value2) {
            addCriterion("activity.acti_address between", value1, value2, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiAddressNotBetween(String value1, String value2) {
            addCriterion("activity.acti_address not between", value1, value2, "actiAddress");
            return (Criteria) this;
        }

        public Criteria andActiCostIsNull() {
            addCriterion("activity.acti_cost is null");
            return (Criteria) this;
        }

        public Criteria andActiCostIsNotNull() {
            addCriterion("activity.acti_cost is not null");
            return (Criteria) this;
        }

        public Criteria andActiCostEqualTo(BigDecimal value) {
            addCriterion("activity.acti_cost =", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostNotEqualTo(BigDecimal value) {
            addCriterion("activity.acti_cost <>", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostGreaterThan(BigDecimal value) {
            addCriterion("activity.acti_cost >", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("activity.acti_cost >=", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostLessThan(BigDecimal value) {
            addCriterion("activity.acti_cost <", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("activity.acti_cost <=", value, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostIn(List<BigDecimal> values) {
            addCriterion("activity.acti_cost in", values, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostNotIn(List<BigDecimal> values) {
            addCriterion("activity.acti_cost not in", values, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("activity.acti_cost between", value1, value2, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("activity.acti_cost not between", value1, value2, "actiCost");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerIsNull() {
            addCriterion("activity.acti_organizer is null");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerIsNotNull() {
            addCriterion("activity.acti_organizer is not null");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerEqualTo(String value) {
            addCriterion("activity.acti_organizer =", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotEqualTo(String value) {
            addCriterion("activity.acti_organizer <>", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerGreaterThan(String value) {
            addCriterion("activity.acti_organizer >", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("activity.acti_organizer >=", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerLessThan(String value) {
            addCriterion("activity.acti_organizer <", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerLessThanOrEqualTo(String value) {
            addCriterion("activity.acti_organizer <=", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerLike(String value) {
            addCriterion("activity.acti_organizer like", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotLike(String value) {
            addCriterion("activity.acti_organizer not like", value, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerIn(List<String> values) {
            addCriterion("activity.acti_organizer in", values, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotIn(List<String> values) {
            addCriterion("activity.acti_organizer not in", values, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerBetween(String value1, String value2) {
            addCriterion("activity.acti_organizer between", value1, value2, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiOrganizerNotBetween(String value1, String value2) {
            addCriterion("activity.acti_organizer not between", value1, value2, "actiOrganizer");
            return (Criteria) this;
        }

        public Criteria andActiNumberIsNull() {
            addCriterion("activity.acti_number is null");
            return (Criteria) this;
        }

        public Criteria andActiNumberIsNotNull() {
            addCriterion("activity.acti_number is not null");
            return (Criteria) this;
        }

        public Criteria andActiNumberEqualTo(Integer value) {
            addCriterion("activity.acti_number =", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberNotEqualTo(Integer value) {
            addCriterion("activity.acti_number <>", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberGreaterThan(Integer value) {
            addCriterion("activity.acti_number >", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_number >=", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberLessThan(Integer value) {
            addCriterion("activity.acti_number <", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberLessThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_number <=", value, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberIn(List<Integer> values) {
            addCriterion("activity.acti_number in", values, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberNotIn(List<Integer> values) {
            addCriterion("activity.acti_number not in", values, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_number between", value1, value2, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_number not between", value1, value2, "actiNumber");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlIsNull() {
            addCriterion("activity.acti_poster_url is null");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlIsNotNull() {
            addCriterion("activity.acti_poster_url is not null");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlEqualTo(String value) {
            addCriterion("activity.acti_poster_url =", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotEqualTo(String value) {
            addCriterion("activity.acti_poster_url <>", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlGreaterThan(String value) {
            addCriterion("activity.acti_poster_url >", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlGreaterThanOrEqualTo(String value) {
            addCriterion("activity.acti_poster_url >=", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlLessThan(String value) {
            addCriterion("activity.acti_poster_url <", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlLessThanOrEqualTo(String value) {
            addCriterion("activity.acti_poster_url <=", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlLike(String value) {
            addCriterion("activity.acti_poster_url like", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotLike(String value) {
            addCriterion("activity.acti_poster_url not like", value, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlIn(List<String> values) {
            addCriterion("activity.acti_poster_url in", values, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotIn(List<String> values) {
            addCriterion("activity.acti_poster_url not in", values, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlBetween(String value1, String value2) {
            addCriterion("activity.acti_poster_url between", value1, value2, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andActiPosterUrlNotBetween(String value1, String value2) {
            addCriterion("activity.acti_poster_url not between", value1, value2, "actiPosterUrl");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("activity.state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("activity.state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("activity.state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("activity.state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("activity.state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("activity.state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("activity.state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("activity.state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("activity.state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("activity.state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("activity.state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("activity.state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("activity.state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("activity.state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("activity.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("activity.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("activity.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("activity.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("activity.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("activity.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("activity.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("activity.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("activity.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNull() {
            addCriterion("activity.create_account is null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNotNull() {
            addCriterion("activity.create_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountEqualTo(String value) {
            addCriterion("activity.create_account =", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotEqualTo(String value) {
            addCriterion("activity.create_account <>", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThan(String value) {
            addCriterion("activity.create_account >", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("activity.create_account >=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThan(String value) {
            addCriterion("activity.create_account <", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThanOrEqualTo(String value) {
            addCriterion("activity.create_account <=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLike(String value) {
            addCriterion("activity.create_account like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotLike(String value) {
            addCriterion("activity.create_account not like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIn(List<String> values) {
            addCriterion("activity.create_account in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotIn(List<String> values) {
            addCriterion("activity.create_account not in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountBetween(String value1, String value2) {
            addCriterion("activity.create_account between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotBetween(String value1, String value2) {
            addCriterion("activity.create_account not between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("activity.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("activity.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("activity.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("activity.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("activity.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("activity.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("activity.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("activity.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("activity.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNull() {
            addCriterion("activity.update_account is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNotNull() {
            addCriterion("activity.update_account is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountEqualTo(String value) {
            addCriterion("activity.update_account =", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotEqualTo(String value) {
            addCriterion("activity.update_account <>", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThan(String value) {
            addCriterion("activity.update_account >", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("activity.update_account >=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThan(String value) {
            addCriterion("activity.update_account <", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThanOrEqualTo(String value) {
            addCriterion("activity.update_account <=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLike(String value) {
            addCriterion("activity.update_account like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotLike(String value) {
            addCriterion("activity.update_account not like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIn(List<String> values) {
            addCriterion("activity.update_account in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotIn(List<String> values) {
            addCriterion("activity.update_account not in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountBetween(String value1, String value2) {
            addCriterion("activity.update_account between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotBetween(String value1, String value2) {
            addCriterion("activity.update_account not between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andActiViewsIsNull() {
            addCriterion("activity.acti_views is null");
            return (Criteria) this;
        }

        public Criteria andActiViewsIsNotNull() {
            addCriterion("activity.acti_views is not null");
            return (Criteria) this;
        }

        public Criteria andActiViewsEqualTo(Integer value) {
            addCriterion("activity.acti_views =", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsNotEqualTo(Integer value) {
            addCriterion("activity.acti_views <>", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsGreaterThan(Integer value) {
            addCriterion("activity.acti_views >", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_views >=", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsLessThan(Integer value) {
            addCriterion("activity.acti_views <", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsLessThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_views <=", value, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsIn(List<Integer> values) {
            addCriterion("activity.acti_views in", values, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsNotIn(List<Integer> values) {
            addCriterion("activity.acti_views not in", values, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_views between", value1, value2, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_views not between", value1, value2, "actiViews");
            return (Criteria) this;
        }

        public Criteria andActiLikeIsNull() {
            addCriterion("activity.acti_like is null");
            return (Criteria) this;
        }

        public Criteria andActiLikeIsNotNull() {
            addCriterion("activity.acti_like is not null");
            return (Criteria) this;
        }

        public Criteria andActiLikeEqualTo(Integer value) {
            addCriterion("activity.acti_like =", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeNotEqualTo(Integer value) {
            addCriterion("activity.acti_like <>", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeGreaterThan(Integer value) {
            addCriterion("activity.acti_like >", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_like >=", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeLessThan(Integer value) {
            addCriterion("activity.acti_like <", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeLessThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_like <=", value, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeIn(List<Integer> values) {
            addCriterion("activity.acti_like in", values, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeNotIn(List<Integer> values) {
            addCriterion("activity.acti_like not in", values, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_like between", value1, value2, "actiLike");
            return (Criteria) this;
        }

        public Criteria andActiLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_like not between", value1, value2, "actiLike");
            return (Criteria) this;
        }

        public Criteria andApplyNumIsNull() {
            addCriterion("activity.apply_num is null");
            return (Criteria) this;
        }

        public Criteria andApplyNumIsNotNull() {
            addCriterion("activity.apply_num is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNumEqualTo(Integer value) {
            addCriterion("activity.apply_num =", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotEqualTo(Integer value) {
            addCriterion("activity.apply_num <>", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumGreaterThan(Integer value) {
            addCriterion("activity.apply_num >", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity.apply_num >=", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumLessThan(Integer value) {
            addCriterion("activity.apply_num <", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumLessThanOrEqualTo(Integer value) {
            addCriterion("activity.apply_num <=", value, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumIn(List<Integer> values) {
            addCriterion("activity.apply_num in", values, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotIn(List<Integer> values) {
            addCriterion("activity.apply_num not in", values, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumBetween(Integer value1, Integer value2) {
            addCriterion("activity.apply_num between", value1, value2, "applyNum");
            return (Criteria) this;
        }

        public Criteria andApplyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("activity.apply_num not between", value1, value2, "applyNum");
            return (Criteria) this;
        }

        public Criteria andParticNumIsNull() {
            addCriterion("activity.partic_num is null");
            return (Criteria) this;
        }

        public Criteria andParticNumIsNotNull() {
            addCriterion("activity.partic_num is not null");
            return (Criteria) this;
        }

        public Criteria andParticNumEqualTo(Integer value) {
            addCriterion("activity.partic_num =", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumNotEqualTo(Integer value) {
            addCriterion("activity.partic_num <>", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumGreaterThan(Integer value) {
            addCriterion("activity.partic_num >", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity.partic_num >=", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumLessThan(Integer value) {
            addCriterion("activity.partic_num <", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumLessThanOrEqualTo(Integer value) {
            addCriterion("activity.partic_num <=", value, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumIn(List<Integer> values) {
            addCriterion("activity.partic_num in", values, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumNotIn(List<Integer> values) {
            addCriterion("activity.partic_num not in", values, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumBetween(Integer value1, Integer value2) {
            addCriterion("activity.partic_num between", value1, value2, "particNum");
            return (Criteria) this;
        }

        public Criteria andParticNumNotBetween(Integer value1, Integer value2) {
            addCriterion("activity.partic_num not between", value1, value2, "particNum");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNull() {
            addCriterion("activity.is_top is null");
            return (Criteria) this;
        }

        public Criteria andIsTopIsNotNull() {
            addCriterion("activity.is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIsTopEqualTo(String value) {
            addCriterion("activity.is_top =", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotEqualTo(String value) {
            addCriterion("activity.is_top <>", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThan(String value) {
            addCriterion("activity.is_top >", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopGreaterThanOrEqualTo(String value) {
            addCriterion("activity.is_top >=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThan(String value) {
            addCriterion("activity.is_top <", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLessThanOrEqualTo(String value) {
            addCriterion("activity.is_top <=", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopLike(String value) {
            addCriterion("activity.is_top like", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotLike(String value) {
            addCriterion("activity.is_top not like", value, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopIn(List<String> values) {
            addCriterion("activity.is_top in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotIn(List<String> values) {
            addCriterion("activity.is_top not in", values, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopBetween(String value1, String value2) {
            addCriterion("activity.is_top between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andIsTopNotBetween(String value1, String value2) {
            addCriterion("activity.is_top not between", value1, value2, "isTop");
            return (Criteria) this;
        }

        public Criteria andTopTimeIsNull() {
            addCriterion("activity.top_time is null");
            return (Criteria) this;
        }

        public Criteria andTopTimeIsNotNull() {
            addCriterion("activity.top_time is not null");
            return (Criteria) this;
        }

        public Criteria andTopTimeEqualTo(Date value) {
            addCriterion("activity.top_time =", value, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeNotEqualTo(Date value) {
            addCriterion("activity.top_time <>", value, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeGreaterThan(Date value) {
            addCriterion("activity.top_time >", value, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity.top_time >=", value, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeLessThan(Date value) {
            addCriterion("activity.top_time <", value, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity.top_time <=", value, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeIn(List<Date> values) {
            addCriterion("activity.top_time in", values, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeNotIn(List<Date> values) {
            addCriterion("activity.top_time not in", values, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeBetween(Date value1, Date value2) {
            addCriterion("activity.top_time between", value1, value2, "topTime");
            return (Criteria) this;
        }

        public Criteria andTopTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity.top_time not between", value1, value2, "topTime");
            return (Criteria) this;
        }

        public Criteria andIsApplyIsNull() {
            addCriterion("activity.is_apply is null");
            return (Criteria) this;
        }

        public Criteria andIsApplyIsNotNull() {
            addCriterion("activity.is_apply is not null");
            return (Criteria) this;
        }

        public Criteria andIsApplyEqualTo(String value) {
            addCriterion("activity.is_apply =", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotEqualTo(String value) {
            addCriterion("activity.is_apply <>", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyGreaterThan(String value) {
            addCriterion("activity.is_apply >", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyGreaterThanOrEqualTo(String value) {
            addCriterion("activity.is_apply >=", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLessThan(String value) {
            addCriterion("activity.is_apply <", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLessThanOrEqualTo(String value) {
            addCriterion("activity.is_apply <=", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyLike(String value) {
            addCriterion("activity.is_apply like", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotLike(String value) {
            addCriterion("activity.is_apply not like", value, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyIn(List<String> values) {
            addCriterion("activity.is_apply in", values, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotIn(List<String> values) {
            addCriterion("activity.is_apply not in", values, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyBetween(String value1, String value2) {
            addCriterion("activity.is_apply between", value1, value2, "isApply");
            return (Criteria) this;
        }

        public Criteria andIsApplyNotBetween(String value1, String value2) {
            addCriterion("activity.is_apply not between", value1, value2, "isApply");
            return (Criteria) this;
        }

        public Criteria andActiOrderIsNull() {
            addCriterion("activity.acti_order is null");
            return (Criteria) this;
        }

        public Criteria andActiOrderIsNotNull() {
            addCriterion("activity.acti_order is not null");
            return (Criteria) this;
        }

        public Criteria andActiOrderEqualTo(Integer value) {
            addCriterion("activity.acti_order =", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderNotEqualTo(Integer value) {
            addCriterion("activity.acti_order <>", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderGreaterThan(Integer value) {
            addCriterion("activity.acti_order >", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_order >=", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderLessThan(Integer value) {
            addCriterion("activity.acti_order <", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderLessThanOrEqualTo(Integer value) {
            addCriterion("activity.acti_order <=", value, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderIn(List<Integer> values) {
            addCriterion("activity.acti_order in", values, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderNotIn(List<Integer> values) {
            addCriterion("activity.acti_order not in", values, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_order between", value1, value2, "actiOrder");
            return (Criteria) this;
        }

        public Criteria andActiOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("activity.acti_order not between", value1, value2, "actiOrder");
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