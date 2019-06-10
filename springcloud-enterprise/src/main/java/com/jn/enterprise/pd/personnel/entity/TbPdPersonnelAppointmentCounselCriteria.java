package com.jn.enterprise.pd.personnel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdPersonnelAppointmentCounselCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdPersonnelAppointmentCounselCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartIsNull() {
            addCriterion("park_appointment_time_start is null");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartIsNotNull() {
            addCriterion("park_appointment_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartEqualTo(Date value) {
            addCriterion("park_appointment_time_start =", value, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartNotEqualTo(Date value) {
            addCriterion("park_appointment_time_start <>", value, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartGreaterThan(Date value) {
            addCriterion("park_appointment_time_start >", value, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("park_appointment_time_start >=", value, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartLessThan(Date value) {
            addCriterion("park_appointment_time_start <", value, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("park_appointment_time_start <=", value, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartIn(List<Date> values) {
            addCriterion("park_appointment_time_start in", values, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartNotIn(List<Date> values) {
            addCriterion("park_appointment_time_start not in", values, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartBetween(Date value1, Date value2) {
            addCriterion("park_appointment_time_start between", value1, value2, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("park_appointment_time_start not between", value1, value2, "parkAppointmentTimeStart");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndIsNull() {
            addCriterion("park_appointment_time_end is null");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndIsNotNull() {
            addCriterion("park_appointment_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndEqualTo(Date value) {
            addCriterion("park_appointment_time_end =", value, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndNotEqualTo(Date value) {
            addCriterion("park_appointment_time_end <>", value, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndGreaterThan(Date value) {
            addCriterion("park_appointment_time_end >", value, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("park_appointment_time_end >=", value, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndLessThan(Date value) {
            addCriterion("park_appointment_time_end <", value, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("park_appointment_time_end <=", value, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndIn(List<Date> values) {
            addCriterion("park_appointment_time_end in", values, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndNotIn(List<Date> values) {
            addCriterion("park_appointment_time_end not in", values, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndBetween(Date value1, Date value2) {
            addCriterion("park_appointment_time_end between", value1, value2, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkAppointmentTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("park_appointment_time_end not between", value1, value2, "parkAppointmentTimeEnd");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressIsNull() {
            addCriterion("park_reservation_address is null");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressIsNotNull() {
            addCriterion("park_reservation_address is not null");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressEqualTo(String value) {
            addCriterion("park_reservation_address =", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressNotEqualTo(String value) {
            addCriterion("park_reservation_address <>", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressGreaterThan(String value) {
            addCriterion("park_reservation_address >", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressGreaterThanOrEqualTo(String value) {
            addCriterion("park_reservation_address >=", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressLessThan(String value) {
            addCriterion("park_reservation_address <", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressLessThanOrEqualTo(String value) {
            addCriterion("park_reservation_address <=", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressLike(String value) {
            addCriterion("park_reservation_address like", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressNotLike(String value) {
            addCriterion("park_reservation_address not like", value, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressIn(List<String> values) {
            addCriterion("park_reservation_address in", values, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressNotIn(List<String> values) {
            addCriterion("park_reservation_address not in", values, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressBetween(String value1, String value2) {
            addCriterion("park_reservation_address between", value1, value2, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andParkReservationAddressNotBetween(String value1, String value2) {
            addCriterion("park_reservation_address not between", value1, value2, "parkReservationAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartIsNull() {
            addCriterion("notify_counsel_time_start is null");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartIsNotNull() {
            addCriterion("notify_counsel_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartEqualTo(Date value) {
            addCriterion("notify_counsel_time_start =", value, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartNotEqualTo(Date value) {
            addCriterion("notify_counsel_time_start <>", value, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartGreaterThan(Date value) {
            addCriterion("notify_counsel_time_start >", value, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("notify_counsel_time_start >=", value, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartLessThan(Date value) {
            addCriterion("notify_counsel_time_start <", value, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("notify_counsel_time_start <=", value, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartIn(List<Date> values) {
            addCriterion("notify_counsel_time_start in", values, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartNotIn(List<Date> values) {
            addCriterion("notify_counsel_time_start not in", values, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartBetween(Date value1, Date value2) {
            addCriterion("notify_counsel_time_start between", value1, value2, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("notify_counsel_time_start not between", value1, value2, "notifyCounselTimeStart");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndIsNull() {
            addCriterion("notify_counsel_time_end is null");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndIsNotNull() {
            addCriterion("notify_counsel_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndEqualTo(Date value) {
            addCriterion("notify_counsel_time_end =", value, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndNotEqualTo(Date value) {
            addCriterion("notify_counsel_time_end <>", value, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndGreaterThan(Date value) {
            addCriterion("notify_counsel_time_end >", value, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("notify_counsel_time_end >=", value, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndLessThan(Date value) {
            addCriterion("notify_counsel_time_end <", value, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("notify_counsel_time_end <=", value, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndIn(List<Date> values) {
            addCriterion("notify_counsel_time_end in", values, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndNotIn(List<Date> values) {
            addCriterion("notify_counsel_time_end not in", values, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndBetween(Date value1, Date value2) {
            addCriterion("notify_counsel_time_end between", value1, value2, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("notify_counsel_time_end not between", value1, value2, "notifyCounselTimeEnd");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressIsNull() {
            addCriterion("notify_counsel_address is null");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressIsNotNull() {
            addCriterion("notify_counsel_address is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressEqualTo(String value) {
            addCriterion("notify_counsel_address =", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressNotEqualTo(String value) {
            addCriterion("notify_counsel_address <>", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressGreaterThan(String value) {
            addCriterion("notify_counsel_address >", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressGreaterThanOrEqualTo(String value) {
            addCriterion("notify_counsel_address >=", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressLessThan(String value) {
            addCriterion("notify_counsel_address <", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressLessThanOrEqualTo(String value) {
            addCriterion("notify_counsel_address <=", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressLike(String value) {
            addCriterion("notify_counsel_address like", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressNotLike(String value) {
            addCriterion("notify_counsel_address not like", value, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressIn(List<String> values) {
            addCriterion("notify_counsel_address in", values, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressNotIn(List<String> values) {
            addCriterion("notify_counsel_address not in", values, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressBetween(String value1, String value2) {
            addCriterion("notify_counsel_address between", value1, value2, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andNotifyCounselAddressNotBetween(String value1, String value2) {
            addCriterion("notify_counsel_address not between", value1, value2, "notifyCounselAddress");
            return (Criteria) this;
        }

        public Criteria andReservationLimitIsNull() {
            addCriterion("reservation_limit is null");
            return (Criteria) this;
        }

        public Criteria andReservationLimitIsNotNull() {
            addCriterion("reservation_limit is not null");
            return (Criteria) this;
        }

        public Criteria andReservationLimitEqualTo(Integer value) {
            addCriterion("reservation_limit =", value, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitNotEqualTo(Integer value) {
            addCriterion("reservation_limit <>", value, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitGreaterThan(Integer value) {
            addCriterion("reservation_limit >", value, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("reservation_limit >=", value, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitLessThan(Integer value) {
            addCriterion("reservation_limit <", value, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitLessThanOrEqualTo(Integer value) {
            addCriterion("reservation_limit <=", value, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitIn(List<Integer> values) {
            addCriterion("reservation_limit in", values, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitNotIn(List<Integer> values) {
            addCriterion("reservation_limit not in", values, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitBetween(Integer value1, Integer value2) {
            addCriterion("reservation_limit between", value1, value2, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andReservationLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("reservation_limit not between", value1, value2, "reservationLimit");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andCounselTypeIsNull() {
            addCriterion("counsel_type is null");
            return (Criteria) this;
        }

        public Criteria andCounselTypeIsNotNull() {
            addCriterion("counsel_type is not null");
            return (Criteria) this;
        }

        public Criteria andCounselTypeEqualTo(Byte value) {
            addCriterion("counsel_type =", value, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeNotEqualTo(Byte value) {
            addCriterion("counsel_type <>", value, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeGreaterThan(Byte value) {
            addCriterion("counsel_type >", value, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("counsel_type >=", value, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeLessThan(Byte value) {
            addCriterion("counsel_type <", value, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeLessThanOrEqualTo(Byte value) {
            addCriterion("counsel_type <=", value, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeIn(List<Byte> values) {
            addCriterion("counsel_type in", values, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeNotIn(List<Byte> values) {
            addCriterion("counsel_type not in", values, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeBetween(Byte value1, Byte value2) {
            addCriterion("counsel_type between", value1, value2, "counselType");
            return (Criteria) this;
        }

        public Criteria andCounselTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("counsel_type not between", value1, value2, "counselType");
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