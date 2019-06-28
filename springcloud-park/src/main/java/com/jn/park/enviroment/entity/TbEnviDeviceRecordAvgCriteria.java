package com.jn.park.enviroment.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbEnviDeviceRecordAvgCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEnviDeviceRecordAvgCriteria() {
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

        public Criteria andHourIsNull() {
            addCriterion("hour is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("hour is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(Integer value) {
            addCriterion("hour =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(Integer value) {
            addCriterion("hour <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(Integer value) {
            addCriterion("hour >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(Integer value) {
            addCriterion("hour <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(Integer value) {
            addCriterion("hour <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<Integer> values) {
            addCriterion("hour in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<Integer> values) {
            addCriterion("hour not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(Integer value1, Integer value2) {
            addCriterion("hour between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(Integer value1, Integer value2) {
            addCriterion("hour not between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHumIsNull() {
            addCriterion("hum is null");
            return (Criteria) this;
        }

        public Criteria andHumIsNotNull() {
            addCriterion("hum is not null");
            return (Criteria) this;
        }

        public Criteria andHumEqualTo(String value) {
            addCriterion("hum =", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumNotEqualTo(String value) {
            addCriterion("hum <>", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumGreaterThan(String value) {
            addCriterion("hum >", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumGreaterThanOrEqualTo(String value) {
            addCriterion("hum >=", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumLessThan(String value) {
            addCriterion("hum <", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumLessThanOrEqualTo(String value) {
            addCriterion("hum <=", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumLike(String value) {
            addCriterion("hum like", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumNotLike(String value) {
            addCriterion("hum not like", value, "hum");
            return (Criteria) this;
        }

        public Criteria andHumIn(List<String> values) {
            addCriterion("hum in", values, "hum");
            return (Criteria) this;
        }

        public Criteria andHumNotIn(List<String> values) {
            addCriterion("hum not in", values, "hum");
            return (Criteria) this;
        }

        public Criteria andHumBetween(String value1, String value2) {
            addCriterion("hum between", value1, value2, "hum");
            return (Criteria) this;
        }

        public Criteria andHumNotBetween(String value1, String value2) {
            addCriterion("hum not between", value1, value2, "hum");
            return (Criteria) this;
        }

        public Criteria andTemperIsNull() {
            addCriterion("temper is null");
            return (Criteria) this;
        }

        public Criteria andTemperIsNotNull() {
            addCriterion("temper is not null");
            return (Criteria) this;
        }

        public Criteria andTemperEqualTo(String value) {
            addCriterion("temper =", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperNotEqualTo(String value) {
            addCriterion("temper <>", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperGreaterThan(String value) {
            addCriterion("temper >", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperGreaterThanOrEqualTo(String value) {
            addCriterion("temper >=", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperLessThan(String value) {
            addCriterion("temper <", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperLessThanOrEqualTo(String value) {
            addCriterion("temper <=", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperLike(String value) {
            addCriterion("temper like", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperNotLike(String value) {
            addCriterion("temper not like", value, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperIn(List<String> values) {
            addCriterion("temper in", values, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperNotIn(List<String> values) {
            addCriterion("temper not in", values, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperBetween(String value1, String value2) {
            addCriterion("temper between", value1, value2, "temper");
            return (Criteria) this;
        }

        public Criteria andTemperNotBetween(String value1, String value2) {
            addCriterion("temper not between", value1, value2, "temper");
            return (Criteria) this;
        }

        public Criteria andPm25IsNull() {
            addCriterion("pm25 is null");
            return (Criteria) this;
        }

        public Criteria andPm25IsNotNull() {
            addCriterion("pm25 is not null");
            return (Criteria) this;
        }

        public Criteria andPm25EqualTo(String value) {
            addCriterion("pm25 =", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotEqualTo(String value) {
            addCriterion("pm25 <>", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThan(String value) {
            addCriterion("pm25 >", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25GreaterThanOrEqualTo(String value) {
            addCriterion("pm25 >=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThan(String value) {
            addCriterion("pm25 <", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25LessThanOrEqualTo(String value) {
            addCriterion("pm25 <=", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Like(String value) {
            addCriterion("pm25 like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotLike(String value) {
            addCriterion("pm25 not like", value, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25In(List<String> values) {
            addCriterion("pm25 in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotIn(List<String> values) {
            addCriterion("pm25 not in", values, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25Between(String value1, String value2) {
            addCriterion("pm25 between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm25NotBetween(String value1, String value2) {
            addCriterion("pm25 not between", value1, value2, "pm25");
            return (Criteria) this;
        }

        public Criteria andPm10IsNull() {
            addCriterion("pm10 is null");
            return (Criteria) this;
        }

        public Criteria andPm10IsNotNull() {
            addCriterion("pm10 is not null");
            return (Criteria) this;
        }

        public Criteria andPm10EqualTo(String value) {
            addCriterion("pm10 =", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotEqualTo(String value) {
            addCriterion("pm10 <>", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThan(String value) {
            addCriterion("pm10 >", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10GreaterThanOrEqualTo(String value) {
            addCriterion("pm10 >=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThan(String value) {
            addCriterion("pm10 <", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10LessThanOrEqualTo(String value) {
            addCriterion("pm10 <=", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Like(String value) {
            addCriterion("pm10 like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotLike(String value) {
            addCriterion("pm10 not like", value, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10In(List<String> values) {
            addCriterion("pm10 in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotIn(List<String> values) {
            addCriterion("pm10 not in", values, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10Between(String value1, String value2) {
            addCriterion("pm10 between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andPm10NotBetween(String value1, String value2) {
            addCriterion("pm10 not between", value1, value2, "pm10");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityIsNull() {
            addCriterion("park_air_quality is null");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityIsNotNull() {
            addCriterion("park_air_quality is not null");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityEqualTo(String value) {
            addCriterion("park_air_quality =", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityNotEqualTo(String value) {
            addCriterion("park_air_quality <>", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityGreaterThan(String value) {
            addCriterion("park_air_quality >", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityGreaterThanOrEqualTo(String value) {
            addCriterion("park_air_quality >=", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLessThan(String value) {
            addCriterion("park_air_quality <", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLessThanOrEqualTo(String value) {
            addCriterion("park_air_quality <=", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLike(String value) {
            addCriterion("park_air_quality like", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityNotLike(String value) {
            addCriterion("park_air_quality not like", value, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityIn(List<String> values) {
            addCriterion("park_air_quality in", values, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityNotIn(List<String> values) {
            addCriterion("park_air_quality not in", values, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityBetween(String value1, String value2) {
            addCriterion("park_air_quality between", value1, value2, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityNotBetween(String value1, String value2) {
            addCriterion("park_air_quality not between", value1, value2, "parkAirQuality");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelIsNull() {
            addCriterion("park_air_quality_level is null");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelIsNotNull() {
            addCriterion("park_air_quality_level is not null");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelEqualTo(String value) {
            addCriterion("park_air_quality_level =", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelNotEqualTo(String value) {
            addCriterion("park_air_quality_level <>", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelGreaterThan(String value) {
            addCriterion("park_air_quality_level >", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("park_air_quality_level >=", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelLessThan(String value) {
            addCriterion("park_air_quality_level <", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("park_air_quality_level <=", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelLike(String value) {
            addCriterion("park_air_quality_level like", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelNotLike(String value) {
            addCriterion("park_air_quality_level not like", value, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelIn(List<String> values) {
            addCriterion("park_air_quality_level in", values, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelNotIn(List<String> values) {
            addCriterion("park_air_quality_level not in", values, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelBetween(String value1, String value2) {
            addCriterion("park_air_quality_level between", value1, value2, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andParkAirQualityLevelNotBetween(String value1, String value2) {
            addCriterion("park_air_quality_level not between", value1, value2, "parkAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityIsNull() {
            addCriterion("city_air_quality is null");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityIsNotNull() {
            addCriterion("city_air_quality is not null");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityEqualTo(String value) {
            addCriterion("city_air_quality =", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityNotEqualTo(String value) {
            addCriterion("city_air_quality <>", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityGreaterThan(String value) {
            addCriterion("city_air_quality >", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityGreaterThanOrEqualTo(String value) {
            addCriterion("city_air_quality >=", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLessThan(String value) {
            addCriterion("city_air_quality <", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLessThanOrEqualTo(String value) {
            addCriterion("city_air_quality <=", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLike(String value) {
            addCriterion("city_air_quality like", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityNotLike(String value) {
            addCriterion("city_air_quality not like", value, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityIn(List<String> values) {
            addCriterion("city_air_quality in", values, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityNotIn(List<String> values) {
            addCriterion("city_air_quality not in", values, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityBetween(String value1, String value2) {
            addCriterion("city_air_quality between", value1, value2, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityNotBetween(String value1, String value2) {
            addCriterion("city_air_quality not between", value1, value2, "cityAirQuality");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelIsNull() {
            addCriterion("city_air_quality_level is null");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelIsNotNull() {
            addCriterion("city_air_quality_level is not null");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelEqualTo(String value) {
            addCriterion("city_air_quality_level =", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelNotEqualTo(String value) {
            addCriterion("city_air_quality_level <>", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelGreaterThan(String value) {
            addCriterion("city_air_quality_level >", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("city_air_quality_level >=", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelLessThan(String value) {
            addCriterion("city_air_quality_level <", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("city_air_quality_level <=", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelLike(String value) {
            addCriterion("city_air_quality_level like", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelNotLike(String value) {
            addCriterion("city_air_quality_level not like", value, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelIn(List<String> values) {
            addCriterion("city_air_quality_level in", values, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelNotIn(List<String> values) {
            addCriterion("city_air_quality_level not in", values, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelBetween(String value1, String value2) {
            addCriterion("city_air_quality_level between", value1, value2, "cityAirQualityLevel");
            return (Criteria) this;
        }

        public Criteria andCityAirQualityLevelNotBetween(String value1, String value2) {
            addCriterion("city_air_quality_level not between", value1, value2, "cityAirQualityLevel");
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