package com.jn.hr.exam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerExaminaManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerExaminaManagementCriteria() {
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

        public Criteria andExaminaNameIsNull() {
            addCriterion("examina_name is null");
            return (Criteria) this;
        }

        public Criteria andExaminaNameIsNotNull() {
            addCriterion("examina_name is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaNameEqualTo(String value) {
            addCriterion("examina_name =", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameNotEqualTo(String value) {
            addCriterion("examina_name <>", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameGreaterThan(String value) {
            addCriterion("examina_name >", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameGreaterThanOrEqualTo(String value) {
            addCriterion("examina_name >=", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameLessThan(String value) {
            addCriterion("examina_name <", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameLessThanOrEqualTo(String value) {
            addCriterion("examina_name <=", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameLike(String value) {
            addCriterion("examina_name like", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameNotLike(String value) {
            addCriterion("examina_name not like", value, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameIn(List<String> values) {
            addCriterion("examina_name in", values, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameNotIn(List<String> values) {
            addCriterion("examina_name not in", values, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameBetween(String value1, String value2) {
            addCriterion("examina_name between", value1, value2, "examinaName");
            return (Criteria) this;
        }

        public Criteria andExaminaNameNotBetween(String value1, String value2) {
            addCriterion("examina_name not between", value1, value2, "examinaName");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartIsNull() {
            addCriterion("effective_time_start is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartIsNotNull() {
            addCriterion("effective_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartEqualTo(Date value) {
            addCriterion("effective_time_start =", value, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartNotEqualTo(Date value) {
            addCriterion("effective_time_start <>", value, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartGreaterThan(Date value) {
            addCriterion("effective_time_start >", value, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_time_start >=", value, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartLessThan(Date value) {
            addCriterion("effective_time_start <", value, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("effective_time_start <=", value, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartIn(List<Date> values) {
            addCriterion("effective_time_start in", values, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartNotIn(List<Date> values) {
            addCriterion("effective_time_start not in", values, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartBetween(Date value1, Date value2) {
            addCriterion("effective_time_start between", value1, value2, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("effective_time_start not between", value1, value2, "effectiveTimeStart");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndIsNull() {
            addCriterion("effective_time_end is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndIsNotNull() {
            addCriterion("effective_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndEqualTo(Date value) {
            addCriterion("effective_time_end =", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndNotEqualTo(Date value) {
            addCriterion("effective_time_end <>", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndGreaterThan(Date value) {
            addCriterion("effective_time_end >", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_time_end >=", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndLessThan(Date value) {
            addCriterion("effective_time_end <", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("effective_time_end <=", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndIn(List<Date> values) {
            addCriterion("effective_time_end in", values, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndNotIn(List<Date> values) {
            addCriterion("effective_time_end not in", values, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndBetween(Date value1, Date value2) {
            addCriterion("effective_time_end between", value1, value2, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("effective_time_end not between", value1, value2, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesIsNull() {
            addCriterion("examina_notes is null");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesIsNotNull() {
            addCriterion("examina_notes is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesEqualTo(String value) {
            addCriterion("examina_notes =", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesNotEqualTo(String value) {
            addCriterion("examina_notes <>", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesGreaterThan(String value) {
            addCriterion("examina_notes >", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesGreaterThanOrEqualTo(String value) {
            addCriterion("examina_notes >=", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesLessThan(String value) {
            addCriterion("examina_notes <", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesLessThanOrEqualTo(String value) {
            addCriterion("examina_notes <=", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesLike(String value) {
            addCriterion("examina_notes like", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesNotLike(String value) {
            addCriterion("examina_notes not like", value, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesIn(List<String> values) {
            addCriterion("examina_notes in", values, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesNotIn(List<String> values) {
            addCriterion("examina_notes not in", values, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesBetween(String value1, String value2) {
            addCriterion("examina_notes between", value1, value2, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andExaminaNotesNotBetween(String value1, String value2) {
            addCriterion("examina_notes not between", value1, value2, "examinaNotes");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreIsNull() {
            addCriterion("pass_score is null");
            return (Criteria) this;
        }

        public Criteria andPassScoreIsNotNull() {
            addCriterion("pass_score is not null");
            return (Criteria) this;
        }

        public Criteria andPassScoreEqualTo(Integer value) {
            addCriterion("pass_score =", value, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreNotEqualTo(Integer value) {
            addCriterion("pass_score <>", value, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreGreaterThan(Integer value) {
            addCriterion("pass_score >", value, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("pass_score >=", value, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreLessThan(Integer value) {
            addCriterion("pass_score <", value, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreLessThanOrEqualTo(Integer value) {
            addCriterion("pass_score <=", value, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreIn(List<Integer> values) {
            addCriterion("pass_score in", values, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreNotIn(List<Integer> values) {
            addCriterion("pass_score not in", values, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreBetween(Integer value1, Integer value2) {
            addCriterion("pass_score between", value1, value2, "passScore");
            return (Criteria) this;
        }

        public Criteria andPassScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("pass_score not between", value1, value2, "passScore");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeIsNull() {
            addCriterion("answer_time is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeIsNotNull() {
            addCriterion("answer_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeEqualTo(Integer value) {
            addCriterion("answer_time =", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeNotEqualTo(Integer value) {
            addCriterion("answer_time <>", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeGreaterThan(Integer value) {
            addCriterion("answer_time >", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_time >=", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeLessThan(Integer value) {
            addCriterion("answer_time <", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeLessThanOrEqualTo(Integer value) {
            addCriterion("answer_time <=", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeIn(List<Integer> values) {
            addCriterion("answer_time in", values, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeNotIn(List<Integer> values) {
            addCriterion("answer_time not in", values, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeBetween(Integer value1, Integer value2) {
            addCriterion("answer_time between", value1, value2, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_time not between", value1, value2, "answerTime");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalIsNull() {
            addCriterion("examina_dimensional is null");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalIsNotNull() {
            addCriterion("examina_dimensional is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalEqualTo(String value) {
            addCriterion("examina_dimensional =", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalNotEqualTo(String value) {
            addCriterion("examina_dimensional <>", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalGreaterThan(String value) {
            addCriterion("examina_dimensional >", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalGreaterThanOrEqualTo(String value) {
            addCriterion("examina_dimensional >=", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalLessThan(String value) {
            addCriterion("examina_dimensional <", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalLessThanOrEqualTo(String value) {
            addCriterion("examina_dimensional <=", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalLike(String value) {
            addCriterion("examina_dimensional like", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalNotLike(String value) {
            addCriterion("examina_dimensional not like", value, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalIn(List<String> values) {
            addCriterion("examina_dimensional in", values, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalNotIn(List<String> values) {
            addCriterion("examina_dimensional not in", values, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalBetween(String value1, String value2) {
            addCriterion("examina_dimensional between", value1, value2, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaDimensionalNotBetween(String value1, String value2) {
            addCriterion("examina_dimensional not between", value1, value2, "examinaDimensional");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlIsNull() {
            addCriterion("examina_url is null");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlIsNotNull() {
            addCriterion("examina_url is not null");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlEqualTo(String value) {
            addCriterion("examina_url =", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlNotEqualTo(String value) {
            addCriterion("examina_url <>", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlGreaterThan(String value) {
            addCriterion("examina_url >", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlGreaterThanOrEqualTo(String value) {
            addCriterion("examina_url >=", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlLessThan(String value) {
            addCriterion("examina_url <", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlLessThanOrEqualTo(String value) {
            addCriterion("examina_url <=", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlLike(String value) {
            addCriterion("examina_url like", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlNotLike(String value) {
            addCriterion("examina_url not like", value, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlIn(List<String> values) {
            addCriterion("examina_url in", values, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlNotIn(List<String> values) {
            addCriterion("examina_url not in", values, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlBetween(String value1, String value2) {
            addCriterion("examina_url between", value1, value2, "examinaUrl");
            return (Criteria) this;
        }

        public Criteria andExaminaUrlNotBetween(String value1, String value2) {
            addCriterion("examina_url not between", value1, value2, "examinaUrl");
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

        public Criteria andIsReleaseIsNull() {
            addCriterion("is_release is null");
            return (Criteria) this;
        }

        public Criteria andIsReleaseIsNotNull() {
            addCriterion("is_release is not null");
            return (Criteria) this;
        }

        public Criteria andIsReleaseEqualTo(Byte value) {
            addCriterion("is_release =", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseNotEqualTo(Byte value) {
            addCriterion("is_release <>", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseGreaterThan(Byte value) {
            addCriterion("is_release >", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_release >=", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseLessThan(Byte value) {
            addCriterion("is_release <", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseLessThanOrEqualTo(Byte value) {
            addCriterion("is_release <=", value, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseIn(List<Byte> values) {
            addCriterion("is_release in", values, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseNotIn(List<Byte> values) {
            addCriterion("is_release not in", values, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseBetween(Byte value1, Byte value2) {
            addCriterion("is_release between", value1, value2, "isRelease");
            return (Criteria) this;
        }

        public Criteria andIsReleaseNotBetween(Byte value1, Byte value2) {
            addCriterion("is_release not between", value1, value2, "isRelease");
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