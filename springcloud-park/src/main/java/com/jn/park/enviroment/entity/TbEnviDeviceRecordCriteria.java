package com.jn.park.enviroment.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbEnviDeviceRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbEnviDeviceRecordCriteria() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeIsNull() {
            addCriterion("device_record_time is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeIsNotNull() {
            addCriterion("device_record_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeEqualTo(Date value) {
            addCriterion("device_record_time =", value, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeNotEqualTo(Date value) {
            addCriterion("device_record_time <>", value, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeGreaterThan(Date value) {
            addCriterion("device_record_time >", value, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_record_time >=", value, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeLessThan(Date value) {
            addCriterion("device_record_time <", value, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("device_record_time <=", value, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeIn(List<Date> values) {
            addCriterion("device_record_time in", values, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeNotIn(List<Date> values) {
            addCriterion("device_record_time not in", values, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeBetween(Date value1, Date value2) {
            addCriterion("device_record_time between", value1, value2, "deviceRecordTime");
            return (Criteria) this;
        }

        public Criteria andDeviceRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("device_record_time not between", value1, value2, "deviceRecordTime");
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

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLightIsNull() {
            addCriterion("light is null");
            return (Criteria) this;
        }

        public Criteria andLightIsNotNull() {
            addCriterion("light is not null");
            return (Criteria) this;
        }

        public Criteria andLightEqualTo(String value) {
            addCriterion("light =", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotEqualTo(String value) {
            addCriterion("light <>", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightGreaterThan(String value) {
            addCriterion("light >", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightGreaterThanOrEqualTo(String value) {
            addCriterion("light >=", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightLessThan(String value) {
            addCriterion("light <", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightLessThanOrEqualTo(String value) {
            addCriterion("light <=", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightLike(String value) {
            addCriterion("light like", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotLike(String value) {
            addCriterion("light not like", value, "light");
            return (Criteria) this;
        }

        public Criteria andLightIn(List<String> values) {
            addCriterion("light in", values, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotIn(List<String> values) {
            addCriterion("light not in", values, "light");
            return (Criteria) this;
        }

        public Criteria andLightBetween(String value1, String value2) {
            addCriterion("light between", value1, value2, "light");
            return (Criteria) this;
        }

        public Criteria andLightNotBetween(String value1, String value2) {
            addCriterion("light not between", value1, value2, "light");
            return (Criteria) this;
        }

        public Criteria andLogIsNull() {
            addCriterion("log is null");
            return (Criteria) this;
        }

        public Criteria andLogIsNotNull() {
            addCriterion("log is not null");
            return (Criteria) this;
        }

        public Criteria andLogEqualTo(String value) {
            addCriterion("log =", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotEqualTo(String value) {
            addCriterion("log <>", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogGreaterThan(String value) {
            addCriterion("log >", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogGreaterThanOrEqualTo(String value) {
            addCriterion("log >=", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogLessThan(String value) {
            addCriterion("log <", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogLessThanOrEqualTo(String value) {
            addCriterion("log <=", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogLike(String value) {
            addCriterion("log like", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotLike(String value) {
            addCriterion("log not like", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogIn(List<String> values) {
            addCriterion("log in", values, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotIn(List<String> values) {
            addCriterion("log not in", values, "log");
            return (Criteria) this;
        }

        public Criteria andLogBetween(String value1, String value2) {
            addCriterion("log between", value1, value2, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotBetween(String value1, String value2) {
            addCriterion("log not between", value1, value2, "log");
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

        public Criteria andRemoteIpIsNull() {
            addCriterion("remote_ip is null");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIsNotNull() {
            addCriterion("remote_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteIpEqualTo(String value) {
            addCriterion("remote_ip =", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotEqualTo(String value) {
            addCriterion("remote_ip <>", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpGreaterThan(String value) {
            addCriterion("remote_ip >", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpGreaterThanOrEqualTo(String value) {
            addCriterion("remote_ip >=", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLessThan(String value) {
            addCriterion("remote_ip <", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLessThanOrEqualTo(String value) {
            addCriterion("remote_ip <=", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLike(String value) {
            addCriterion("remote_ip like", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotLike(String value) {
            addCriterion("remote_ip not like", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIn(List<String> values) {
            addCriterion("remote_ip in", values, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotIn(List<String> values) {
            addCriterion("remote_ip not in", values, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpBetween(String value1, String value2) {
            addCriterion("remote_ip between", value1, value2, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotBetween(String value1, String value2) {
            addCriterion("remote_ip not between", value1, value2, "remoteIp");
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