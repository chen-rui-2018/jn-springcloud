package com.jn.oa.attendance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOaAttendanceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOaAttendanceCriteria() {
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

        public Criteria andSignInAttendanceTimeIsNull() {
            addCriterion("sign_in_attendance_time is null");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeIsNotNull() {
            addCriterion("sign_in_attendance_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeEqualTo(Date value) {
            addCriterion("sign_in_attendance_time =", value, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeNotEqualTo(Date value) {
            addCriterion("sign_in_attendance_time <>", value, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeGreaterThan(Date value) {
            addCriterion("sign_in_attendance_time >", value, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_in_attendance_time >=", value, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeLessThan(Date value) {
            addCriterion("sign_in_attendance_time <", value, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_in_attendance_time <=", value, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeIn(List<Date> values) {
            addCriterion("sign_in_attendance_time in", values, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeNotIn(List<Date> values) {
            addCriterion("sign_in_attendance_time not in", values, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeBetween(Date value1, Date value2) {
            addCriterion("sign_in_attendance_time between", value1, value2, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_in_attendance_time not between", value1, value2, "signInAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformIsNull() {
            addCriterion("sign_in_attendance_platform is null");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformIsNotNull() {
            addCriterion("sign_in_attendance_platform is not null");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformEqualTo(String value) {
            addCriterion("sign_in_attendance_platform =", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformNotEqualTo(String value) {
            addCriterion("sign_in_attendance_platform <>", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformGreaterThan(String value) {
            addCriterion("sign_in_attendance_platform >", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_attendance_platform >=", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformLessThan(String value) {
            addCriterion("sign_in_attendance_platform <", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformLessThanOrEqualTo(String value) {
            addCriterion("sign_in_attendance_platform <=", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformLike(String value) {
            addCriterion("sign_in_attendance_platform like", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformNotLike(String value) {
            addCriterion("sign_in_attendance_platform not like", value, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformIn(List<String> values) {
            addCriterion("sign_in_attendance_platform in", values, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformNotIn(List<String> values) {
            addCriterion("sign_in_attendance_platform not in", values, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformBetween(String value1, String value2) {
            addCriterion("sign_in_attendance_platform between", value1, value2, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInAttendancePlatformNotBetween(String value1, String value2) {
            addCriterion("sign_in_attendance_platform not between", value1, value2, "signInAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeIsNull() {
            addCriterion("sign_in_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeIsNotNull() {
            addCriterion("sign_in_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeEqualTo(String value) {
            addCriterion("sign_in_longitude =", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeNotEqualTo(String value) {
            addCriterion("sign_in_longitude <>", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeGreaterThan(String value) {
            addCriterion("sign_in_longitude >", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_longitude >=", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeLessThan(String value) {
            addCriterion("sign_in_longitude <", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeLessThanOrEqualTo(String value) {
            addCriterion("sign_in_longitude <=", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeLike(String value) {
            addCriterion("sign_in_longitude like", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeNotLike(String value) {
            addCriterion("sign_in_longitude not like", value, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeIn(List<String> values) {
            addCriterion("sign_in_longitude in", values, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeNotIn(List<String> values) {
            addCriterion("sign_in_longitude not in", values, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeBetween(String value1, String value2) {
            addCriterion("sign_in_longitude between", value1, value2, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLongitudeNotBetween(String value1, String value2) {
            addCriterion("sign_in_longitude not between", value1, value2, "signInLongitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeIsNull() {
            addCriterion("sign_in_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeIsNotNull() {
            addCriterion("sign_in_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeEqualTo(String value) {
            addCriterion("sign_in_latitude =", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeNotEqualTo(String value) {
            addCriterion("sign_in_latitude <>", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeGreaterThan(String value) {
            addCriterion("sign_in_latitude >", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_latitude >=", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeLessThan(String value) {
            addCriterion("sign_in_latitude <", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeLessThanOrEqualTo(String value) {
            addCriterion("sign_in_latitude <=", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeLike(String value) {
            addCriterion("sign_in_latitude like", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeNotLike(String value) {
            addCriterion("sign_in_latitude not like", value, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeIn(List<String> values) {
            addCriterion("sign_in_latitude in", values, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeNotIn(List<String> values) {
            addCriterion("sign_in_latitude not in", values, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeBetween(String value1, String value2) {
            addCriterion("sign_in_latitude between", value1, value2, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInLatitudeNotBetween(String value1, String value2) {
            addCriterion("sign_in_latitude not between", value1, value2, "signInLatitude");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpIsNull() {
            addCriterion("sign_in_attendance_ip is null");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpIsNotNull() {
            addCriterion("sign_in_attendance_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpEqualTo(String value) {
            addCriterion("sign_in_attendance_ip =", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpNotEqualTo(String value) {
            addCriterion("sign_in_attendance_ip <>", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpGreaterThan(String value) {
            addCriterion("sign_in_attendance_ip >", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpGreaterThanOrEqualTo(String value) {
            addCriterion("sign_in_attendance_ip >=", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpLessThan(String value) {
            addCriterion("sign_in_attendance_ip <", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpLessThanOrEqualTo(String value) {
            addCriterion("sign_in_attendance_ip <=", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpLike(String value) {
            addCriterion("sign_in_attendance_ip like", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpNotLike(String value) {
            addCriterion("sign_in_attendance_ip not like", value, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpIn(List<String> values) {
            addCriterion("sign_in_attendance_ip in", values, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpNotIn(List<String> values) {
            addCriterion("sign_in_attendance_ip not in", values, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpBetween(String value1, String value2) {
            addCriterion("sign_in_attendance_ip between", value1, value2, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignInAttendanceIpNotBetween(String value1, String value2) {
            addCriterion("sign_in_attendance_ip not between", value1, value2, "signInAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeIsNull() {
            addCriterion("sign_out_attendance_time is null");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeIsNotNull() {
            addCriterion("sign_out_attendance_time is not null");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeEqualTo(Date value) {
            addCriterion("sign_out_attendance_time =", value, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeNotEqualTo(Date value) {
            addCriterion("sign_out_attendance_time <>", value, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeGreaterThan(Date value) {
            addCriterion("sign_out_attendance_time >", value, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_out_attendance_time >=", value, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeLessThan(Date value) {
            addCriterion("sign_out_attendance_time <", value, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("sign_out_attendance_time <=", value, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeIn(List<Date> values) {
            addCriterion("sign_out_attendance_time in", values, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeNotIn(List<Date> values) {
            addCriterion("sign_out_attendance_time not in", values, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeBetween(Date value1, Date value2) {
            addCriterion("sign_out_attendance_time between", value1, value2, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("sign_out_attendance_time not between", value1, value2, "signOutAttendanceTime");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformIsNull() {
            addCriterion("sign_out_attendance_platform is null");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformIsNotNull() {
            addCriterion("sign_out_attendance_platform is not null");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformEqualTo(String value) {
            addCriterion("sign_out_attendance_platform =", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformNotEqualTo(String value) {
            addCriterion("sign_out_attendance_platform <>", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformGreaterThan(String value) {
            addCriterion("sign_out_attendance_platform >", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformGreaterThanOrEqualTo(String value) {
            addCriterion("sign_out_attendance_platform >=", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformLessThan(String value) {
            addCriterion("sign_out_attendance_platform <", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformLessThanOrEqualTo(String value) {
            addCriterion("sign_out_attendance_platform <=", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformLike(String value) {
            addCriterion("sign_out_attendance_platform like", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformNotLike(String value) {
            addCriterion("sign_out_attendance_platform not like", value, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformIn(List<String> values) {
            addCriterion("sign_out_attendance_platform in", values, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformNotIn(List<String> values) {
            addCriterion("sign_out_attendance_platform not in", values, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformBetween(String value1, String value2) {
            addCriterion("sign_out_attendance_platform between", value1, value2, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendancePlatformNotBetween(String value1, String value2) {
            addCriterion("sign_out_attendance_platform not between", value1, value2, "signOutAttendancePlatform");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeIsNull() {
            addCriterion("sign_out_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeIsNotNull() {
            addCriterion("sign_out_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeEqualTo(String value) {
            addCriterion("sign_out_longitude =", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeNotEqualTo(String value) {
            addCriterion("sign_out_longitude <>", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeGreaterThan(String value) {
            addCriterion("sign_out_longitude >", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_out_longitude >=", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeLessThan(String value) {
            addCriterion("sign_out_longitude <", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeLessThanOrEqualTo(String value) {
            addCriterion("sign_out_longitude <=", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeLike(String value) {
            addCriterion("sign_out_longitude like", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeNotLike(String value) {
            addCriterion("sign_out_longitude not like", value, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeIn(List<String> values) {
            addCriterion("sign_out_longitude in", values, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeNotIn(List<String> values) {
            addCriterion("sign_out_longitude not in", values, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeBetween(String value1, String value2) {
            addCriterion("sign_out_longitude between", value1, value2, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLongitudeNotBetween(String value1, String value2) {
            addCriterion("sign_out_longitude not between", value1, value2, "signOutLongitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeIsNull() {
            addCriterion("sign_out_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeIsNotNull() {
            addCriterion("sign_out_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeEqualTo(String value) {
            addCriterion("sign_out_latitude =", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeNotEqualTo(String value) {
            addCriterion("sign_out_latitude <>", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeGreaterThan(String value) {
            addCriterion("sign_out_latitude >", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_out_latitude >=", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeLessThan(String value) {
            addCriterion("sign_out_latitude <", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeLessThanOrEqualTo(String value) {
            addCriterion("sign_out_latitude <=", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeLike(String value) {
            addCriterion("sign_out_latitude like", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeNotLike(String value) {
            addCriterion("sign_out_latitude not like", value, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeIn(List<String> values) {
            addCriterion("sign_out_latitude in", values, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeNotIn(List<String> values) {
            addCriterion("sign_out_latitude not in", values, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeBetween(String value1, String value2) {
            addCriterion("sign_out_latitude between", value1, value2, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutLatitudeNotBetween(String value1, String value2) {
            addCriterion("sign_out_latitude not between", value1, value2, "signOutLatitude");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpIsNull() {
            addCriterion("sign_out_attendance_ip is null");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpIsNotNull() {
            addCriterion("sign_out_attendance_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpEqualTo(String value) {
            addCriterion("sign_out_attendance_ip =", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpNotEqualTo(String value) {
            addCriterion("sign_out_attendance_ip <>", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpGreaterThan(String value) {
            addCriterion("sign_out_attendance_ip >", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpGreaterThanOrEqualTo(String value) {
            addCriterion("sign_out_attendance_ip >=", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpLessThan(String value) {
            addCriterion("sign_out_attendance_ip <", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpLessThanOrEqualTo(String value) {
            addCriterion("sign_out_attendance_ip <=", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpLike(String value) {
            addCriterion("sign_out_attendance_ip like", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpNotLike(String value) {
            addCriterion("sign_out_attendance_ip not like", value, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpIn(List<String> values) {
            addCriterion("sign_out_attendance_ip in", values, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpNotIn(List<String> values) {
            addCriterion("sign_out_attendance_ip not in", values, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpBetween(String value1, String value2) {
            addCriterion("sign_out_attendance_ip between", value1, value2, "signOutAttendanceIp");
            return (Criteria) this;
        }

        public Criteria andSignOutAttendanceIpNotBetween(String value1, String value2) {
            addCriterion("sign_out_attendance_ip not between", value1, value2, "signOutAttendanceIp");
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

        public Criteria andAttendanceUserIsNull() {
            addCriterion("attendance_user is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserIsNotNull() {
            addCriterion("attendance_user is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserEqualTo(String value) {
            addCriterion("attendance_user =", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserNotEqualTo(String value) {
            addCriterion("attendance_user <>", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserGreaterThan(String value) {
            addCriterion("attendance_user >", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserGreaterThanOrEqualTo(String value) {
            addCriterion("attendance_user >=", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserLessThan(String value) {
            addCriterion("attendance_user <", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserLessThanOrEqualTo(String value) {
            addCriterion("attendance_user <=", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserLike(String value) {
            addCriterion("attendance_user like", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserNotLike(String value) {
            addCriterion("attendance_user not like", value, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserIn(List<String> values) {
            addCriterion("attendance_user in", values, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserNotIn(List<String> values) {
            addCriterion("attendance_user not in", values, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserBetween(String value1, String value2) {
            addCriterion("attendance_user between", value1, value2, "attendanceUser");
            return (Criteria) this;
        }

        public Criteria andAttendanceUserNotBetween(String value1, String value2) {
            addCriterion("attendance_user not between", value1, value2, "attendanceUser");
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