package com.jn.hr.exam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerExaminaResultInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerExaminaResultInfoCriteria() {
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

        public Criteria andExaminaIdIsNull() {
            addCriterion("examina_id is null");
            return (Criteria) this;
        }

        public Criteria andExaminaIdIsNotNull() {
            addCriterion("examina_id is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaIdEqualTo(String value) {
            addCriterion("examina_id =", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotEqualTo(String value) {
            addCriterion("examina_id <>", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdGreaterThan(String value) {
            addCriterion("examina_id >", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdGreaterThanOrEqualTo(String value) {
            addCriterion("examina_id >=", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdLessThan(String value) {
            addCriterion("examina_id <", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdLessThanOrEqualTo(String value) {
            addCriterion("examina_id <=", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdLike(String value) {
            addCriterion("examina_id like", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotLike(String value) {
            addCriterion("examina_id not like", value, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdIn(List<String> values) {
            addCriterion("examina_id in", values, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotIn(List<String> values) {
            addCriterion("examina_id not in", values, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdBetween(String value1, String value2) {
            addCriterion("examina_id between", value1, value2, "examinaId");
            return (Criteria) this;
        }

        public Criteria andExaminaIdNotBetween(String value1, String value2) {
            addCriterion("examina_id not between", value1, value2, "examinaId");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNull() {
            addCriterion("job_number is null");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNotNull() {
            addCriterion("job_number is not null");
            return (Criteria) this;
        }

        public Criteria andJobNumberEqualTo(String value) {
            addCriterion("job_number =", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotEqualTo(String value) {
            addCriterion("job_number <>", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThan(String value) {
            addCriterion("job_number >", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThanOrEqualTo(String value) {
            addCriterion("job_number >=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThan(String value) {
            addCriterion("job_number <", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThanOrEqualTo(String value) {
            addCriterion("job_number <=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLike(String value) {
            addCriterion("job_number like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotLike(String value) {
            addCriterion("job_number not like", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberIn(List<String> values) {
            addCriterion("job_number in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotIn(List<String> values) {
            addCriterion("job_number not in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberBetween(String value1, String value2) {
            addCriterion("job_number between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotBetween(String value1, String value2) {
            addCriterion("job_number not between", value1, value2, "jobNumber");
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

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Integer value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Integer value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Integer value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Integer value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Integer> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Integer> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Integer value1, Integer value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andAchievementIsNull() {
            addCriterion("achievement is null");
            return (Criteria) this;
        }

        public Criteria andAchievementIsNotNull() {
            addCriterion("achievement is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementEqualTo(Integer value) {
            addCriterion("achievement =", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotEqualTo(Integer value) {
            addCriterion("achievement <>", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementGreaterThan(Integer value) {
            addCriterion("achievement >", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementGreaterThanOrEqualTo(Integer value) {
            addCriterion("achievement >=", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementLessThan(Integer value) {
            addCriterion("achievement <", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementLessThanOrEqualTo(Integer value) {
            addCriterion("achievement <=", value, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementIn(List<Integer> values) {
            addCriterion("achievement in", values, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotIn(List<Integer> values) {
            addCriterion("achievement not in", values, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementBetween(Integer value1, Integer value2) {
            addCriterion("achievement between", value1, value2, "achievement");
            return (Criteria) this;
        }

        public Criteria andAchievementNotBetween(Integer value1, Integer value2) {
            addCriterion("achievement not between", value1, value2, "achievement");
            return (Criteria) this;
        }

        public Criteria andIsAdoptIsNull() {
            addCriterion("is_adopt is null");
            return (Criteria) this;
        }

        public Criteria andIsAdoptIsNotNull() {
            addCriterion("is_adopt is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdoptEqualTo(Byte value) {
            addCriterion("is_adopt =", value, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptNotEqualTo(Byte value) {
            addCriterion("is_adopt <>", value, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptGreaterThan(Byte value) {
            addCriterion("is_adopt >", value, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_adopt >=", value, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptLessThan(Byte value) {
            addCriterion("is_adopt <", value, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptLessThanOrEqualTo(Byte value) {
            addCriterion("is_adopt <=", value, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptIn(List<Byte> values) {
            addCriterion("is_adopt in", values, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptNotIn(List<Byte> values) {
            addCriterion("is_adopt not in", values, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptBetween(Byte value1, Byte value2) {
            addCriterion("is_adopt between", value1, value2, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andIsAdoptNotBetween(Byte value1, Byte value2) {
            addCriterion("is_adopt not between", value1, value2, "isAdopt");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodIsNull() {
            addCriterion("examina_method is null");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodIsNotNull() {
            addCriterion("examina_method is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodEqualTo(Byte value) {
            addCriterion("examina_method =", value, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodNotEqualTo(Byte value) {
            addCriterion("examina_method <>", value, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodGreaterThan(Byte value) {
            addCriterion("examina_method >", value, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("examina_method >=", value, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodLessThan(Byte value) {
            addCriterion("examina_method <", value, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodLessThanOrEqualTo(Byte value) {
            addCriterion("examina_method <=", value, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodIn(List<Byte> values) {
            addCriterion("examina_method in", values, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodNotIn(List<Byte> values) {
            addCriterion("examina_method not in", values, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodBetween(Byte value1, Byte value2) {
            addCriterion("examina_method between", value1, value2, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andExaminaMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("examina_method not between", value1, value2, "examinaMethod");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
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

        public Criteria andExaminaStartTimeIsNull() {
            addCriterion("examina_start_time is null");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeIsNotNull() {
            addCriterion("examina_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeEqualTo(Date value) {
            addCriterion("examina_start_time =", value, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeNotEqualTo(Date value) {
            addCriterion("examina_start_time <>", value, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeGreaterThan(Date value) {
            addCriterion("examina_start_time >", value, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examina_start_time >=", value, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeLessThan(Date value) {
            addCriterion("examina_start_time <", value, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("examina_start_time <=", value, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeIn(List<Date> values) {
            addCriterion("examina_start_time in", values, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeNotIn(List<Date> values) {
            addCriterion("examina_start_time not in", values, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeBetween(Date value1, Date value2) {
            addCriterion("examina_start_time between", value1, value2, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("examina_start_time not between", value1, value2, "examinaStartTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeIsNull() {
            addCriterion("examina_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeIsNotNull() {
            addCriterion("examina_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeEqualTo(Date value) {
            addCriterion("examina_end_time =", value, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeNotEqualTo(Date value) {
            addCriterion("examina_end_time <>", value, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeGreaterThan(Date value) {
            addCriterion("examina_end_time >", value, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examina_end_time >=", value, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeLessThan(Date value) {
            addCriterion("examina_end_time <", value, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("examina_end_time <=", value, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeIn(List<Date> values) {
            addCriterion("examina_end_time in", values, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeNotIn(List<Date> values) {
            addCriterion("examina_end_time not in", values, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeBetween(Date value1, Date value2) {
            addCriterion("examina_end_time between", value1, value2, "examinaEndTime");
            return (Criteria) this;
        }

        public Criteria andExaminaEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("examina_end_time not between", value1, value2, "examinaEndTime");
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