package com.jn.park.electricmeter.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbElectricReadingSourceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbElectricReadingSourceCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMeterCodeIsNull() {
            addCriterion("meter_code is null");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIsNotNull() {
            addCriterion("meter_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeterCodeEqualTo(String value) {
            addCriterion("meter_code =", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotEqualTo(String value) {
            addCriterion("meter_code <>", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeGreaterThan(String value) {
            addCriterion("meter_code >", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("meter_code >=", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLessThan(String value) {
            addCriterion("meter_code <", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLessThanOrEqualTo(String value) {
            addCriterion("meter_code <=", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLike(String value) {
            addCriterion("meter_code like", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotLike(String value) {
            addCriterion("meter_code not like", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIn(List<String> values) {
            addCriterion("meter_code in", values, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotIn(List<String> values) {
            addCriterion("meter_code not in", values, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeBetween(String value1, String value2) {
            addCriterion("meter_code between", value1, value2, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotBetween(String value1, String value2) {
            addCriterion("meter_code not between", value1, value2, "meterCode");
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

        public Criteria andDealDateIsNull() {
            addCriterion("deal_date is null");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNotNull() {
            addCriterion("deal_date is not null");
            return (Criteria) this;
        }

        public Criteria andDealDateEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date =", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date <>", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThan(Date value) {
            addCriterionForJDBCDate("deal_date >", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date >=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThan(Date value) {
            addCriterionForJDBCDate("deal_date <", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date <=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateIn(List<Date> values) {
            addCriterionForJDBCDate("deal_date in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("deal_date not in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_date between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_date not between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffIsNull() {
            addCriterion("degree_diff is null");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffIsNotNull() {
            addCriterion("degree_diff is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffEqualTo(BigDecimal value) {
            addCriterion("degree_diff =", value, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffNotEqualTo(BigDecimal value) {
            addCriterion("degree_diff <>", value, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffGreaterThan(BigDecimal value) {
            addCriterion("degree_diff >", value, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("degree_diff >=", value, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffLessThan(BigDecimal value) {
            addCriterion("degree_diff <", value, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("degree_diff <=", value, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffIn(List<BigDecimal> values) {
            addCriterion("degree_diff in", values, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffNotIn(List<BigDecimal> values) {
            addCriterion("degree_diff not in", values, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("degree_diff between", value1, value2, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDegreeDiffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("degree_diff not between", value1, value2, "degreeDiff");
            return (Criteria) this;
        }

        public Criteria andDealHourIsNull() {
            addCriterion("deal_hour is null");
            return (Criteria) this;
        }

        public Criteria andDealHourIsNotNull() {
            addCriterion("deal_hour is not null");
            return (Criteria) this;
        }

        public Criteria andDealHourEqualTo(Byte value) {
            addCriterion("deal_hour =", value, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourNotEqualTo(Byte value) {
            addCriterion("deal_hour <>", value, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourGreaterThan(Byte value) {
            addCriterion("deal_hour >", value, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourGreaterThanOrEqualTo(Byte value) {
            addCriterion("deal_hour >=", value, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourLessThan(Byte value) {
            addCriterion("deal_hour <", value, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourLessThanOrEqualTo(Byte value) {
            addCriterion("deal_hour <=", value, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourIn(List<Byte> values) {
            addCriterion("deal_hour in", values, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourNotIn(List<Byte> values) {
            addCriterion("deal_hour not in", values, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourBetween(Byte value1, Byte value2) {
            addCriterion("deal_hour between", value1, value2, "dealHour");
            return (Criteria) this;
        }

        public Criteria andDealHourNotBetween(Byte value1, Byte value2) {
            addCriterion("deal_hour not between", value1, value2, "dealHour");
            return (Criteria) this;
        }

        public Criteria andReadingEndIsNull() {
            addCriterion("reading_end is null");
            return (Criteria) this;
        }

        public Criteria andReadingEndIsNotNull() {
            addCriterion("reading_end is not null");
            return (Criteria) this;
        }

        public Criteria andReadingEndEqualTo(BigDecimal value) {
            addCriterion("reading_end =", value, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndNotEqualTo(BigDecimal value) {
            addCriterion("reading_end <>", value, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndGreaterThan(BigDecimal value) {
            addCriterion("reading_end >", value, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reading_end >=", value, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndLessThan(BigDecimal value) {
            addCriterion("reading_end <", value, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reading_end <=", value, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndIn(List<BigDecimal> values) {
            addCriterion("reading_end in", values, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndNotIn(List<BigDecimal> values) {
            addCriterion("reading_end not in", values, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reading_end between", value1, value2, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andReadingEndNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reading_end not between", value1, value2, "readingEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndIsNull() {
            addCriterion("time_end is null");
            return (Criteria) this;
        }

        public Criteria andTimeEndIsNotNull() {
            addCriterion("time_end is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEndEqualTo(Date value) {
            addCriterion("time_end =", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotEqualTo(Date value) {
            addCriterion("time_end <>", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndGreaterThan(Date value) {
            addCriterion("time_end >", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("time_end >=", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndLessThan(Date value) {
            addCriterion("time_end <", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("time_end <=", value, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndIn(List<Date> values) {
            addCriterion("time_end in", values, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotIn(List<Date> values) {
            addCriterion("time_end not in", values, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndBetween(Date value1, Date value2) {
            addCriterion("time_end between", value1, value2, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("time_end not between", value1, value2, "timeEnd");
            return (Criteria) this;
        }

        public Criteria andParamIsNull() {
            addCriterion("param is null");
            return (Criteria) this;
        }

        public Criteria andParamIsNotNull() {
            addCriterion("param is not null");
            return (Criteria) this;
        }

        public Criteria andParamEqualTo(String value) {
            addCriterion("param =", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotEqualTo(String value) {
            addCriterion("param <>", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThan(String value) {
            addCriterion("param >", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThanOrEqualTo(String value) {
            addCriterion("param >=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThan(String value) {
            addCriterion("param <", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThanOrEqualTo(String value) {
            addCriterion("param <=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLike(String value) {
            addCriterion("param like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotLike(String value) {
            addCriterion("param not like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamIn(List<String> values) {
            addCriterion("param in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotIn(List<String> values) {
            addCriterion("param not in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamBetween(String value1, String value2) {
            addCriterion("param between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotBetween(String value1, String value2) {
            addCriterion("param not between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusMsgIsNull() {
            addCriterion("status_msg is null");
            return (Criteria) this;
        }

        public Criteria andStatusMsgIsNotNull() {
            addCriterion("status_msg is not null");
            return (Criteria) this;
        }

        public Criteria andStatusMsgEqualTo(String value) {
            addCriterion("status_msg =", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgNotEqualTo(String value) {
            addCriterion("status_msg <>", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgGreaterThan(String value) {
            addCriterion("status_msg >", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgGreaterThanOrEqualTo(String value) {
            addCriterion("status_msg >=", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgLessThan(String value) {
            addCriterion("status_msg <", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgLessThanOrEqualTo(String value) {
            addCriterion("status_msg <=", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgLike(String value) {
            addCriterion("status_msg like", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgNotLike(String value) {
            addCriterion("status_msg not like", value, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgIn(List<String> values) {
            addCriterion("status_msg in", values, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgNotIn(List<String> values) {
            addCriterion("status_msg not in", values, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgBetween(String value1, String value2) {
            addCriterion("status_msg between", value1, value2, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andStatusMsgNotBetween(String value1, String value2) {
            addCriterion("status_msg not between", value1, value2, "statusMsg");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIsNull() {
            addCriterion("task_batch is null");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIsNotNull() {
            addCriterion("task_batch is not null");
            return (Criteria) this;
        }

        public Criteria andTaskBatchEqualTo(String value) {
            addCriterion("task_batch =", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotEqualTo(String value) {
            addCriterion("task_batch <>", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchGreaterThan(String value) {
            addCriterion("task_batch >", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchGreaterThanOrEqualTo(String value) {
            addCriterion("task_batch >=", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLessThan(String value) {
            addCriterion("task_batch <", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLessThanOrEqualTo(String value) {
            addCriterion("task_batch <=", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLike(String value) {
            addCriterion("task_batch like", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotLike(String value) {
            addCriterion("task_batch not like", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIn(List<String> values) {
            addCriterion("task_batch in", values, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotIn(List<String> values) {
            addCriterion("task_batch not in", values, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchBetween(String value1, String value2) {
            addCriterion("task_batch between", value1, value2, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotBetween(String value1, String value2) {
            addCriterion("task_batch not between", value1, value2, "taskBatch");
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