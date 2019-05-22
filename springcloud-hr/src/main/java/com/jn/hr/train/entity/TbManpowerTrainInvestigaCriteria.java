package com.jn.hr.train.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerTrainInvestigaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerTrainInvestigaCriteria() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andResearchProjectIsNull() {
            addCriterion("research_project is null");
            return (Criteria) this;
        }

        public Criteria andResearchProjectIsNotNull() {
            addCriterion("research_project is not null");
            return (Criteria) this;
        }

        public Criteria andResearchProjectEqualTo(String value) {
            addCriterion("research_project =", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectNotEqualTo(String value) {
            addCriterion("research_project <>", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectGreaterThan(String value) {
            addCriterion("research_project >", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectGreaterThanOrEqualTo(String value) {
            addCriterion("research_project >=", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectLessThan(String value) {
            addCriterion("research_project <", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectLessThanOrEqualTo(String value) {
            addCriterion("research_project <=", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectLike(String value) {
            addCriterion("research_project like", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectNotLike(String value) {
            addCriterion("research_project not like", value, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectIn(List<String> values) {
            addCriterion("research_project in", values, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectNotIn(List<String> values) {
            addCriterion("research_project not in", values, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectBetween(String value1, String value2) {
            addCriterion("research_project between", value1, value2, "researchProject");
            return (Criteria) this;
        }

        public Criteria andResearchProjectNotBetween(String value1, String value2) {
            addCriterion("research_project not between", value1, value2, "researchProject");
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

        public Criteria andTrainerIsNull() {
            addCriterion("trainer is null");
            return (Criteria) this;
        }

        public Criteria andTrainerIsNotNull() {
            addCriterion("trainer is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerEqualTo(String value) {
            addCriterion("trainer =", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerNotEqualTo(String value) {
            addCriterion("trainer <>", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerGreaterThan(String value) {
            addCriterion("trainer >", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerGreaterThanOrEqualTo(String value) {
            addCriterion("trainer >=", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerLessThan(String value) {
            addCriterion("trainer <", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerLessThanOrEqualTo(String value) {
            addCriterion("trainer <=", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerLike(String value) {
            addCriterion("trainer like", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerNotLike(String value) {
            addCriterion("trainer not like", value, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerIn(List<String> values) {
            addCriterion("trainer in", values, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerNotIn(List<String> values) {
            addCriterion("trainer not in", values, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerBetween(String value1, String value2) {
            addCriterion("trainer between", value1, value2, "trainer");
            return (Criteria) this;
        }

        public Criteria andTrainerNotBetween(String value1, String value2) {
            addCriterion("trainer not between", value1, value2, "trainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerIsNull() {
            addCriterion("is_show_trainer is null");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerIsNotNull() {
            addCriterion("is_show_trainer is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerEqualTo(Byte value) {
            addCriterion("is_show_trainer =", value, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerNotEqualTo(Byte value) {
            addCriterion("is_show_trainer <>", value, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerGreaterThan(Byte value) {
            addCriterion("is_show_trainer >", value, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_trainer >=", value, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerLessThan(Byte value) {
            addCriterion("is_show_trainer <", value, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_trainer <=", value, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerIn(List<Byte> values) {
            addCriterion("is_show_trainer in", values, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerNotIn(List<Byte> values) {
            addCriterion("is_show_trainer not in", values, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerBetween(Byte value1, Byte value2) {
            addCriterion("is_show_trainer between", value1, value2, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainerNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_trainer not between", value1, value2, "isShowTrainer");
            return (Criteria) this;
        }

        public Criteria andTrainDateIsNull() {
            addCriterion("train_date is null");
            return (Criteria) this;
        }

        public Criteria andTrainDateIsNotNull() {
            addCriterion("train_date is not null");
            return (Criteria) this;
        }

        public Criteria andTrainDateEqualTo(Date value) {
            addCriterion("train_date =", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotEqualTo(Date value) {
            addCriterion("train_date <>", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateGreaterThan(Date value) {
            addCriterion("train_date >", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateGreaterThanOrEqualTo(Date value) {
            addCriterion("train_date >=", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateLessThan(Date value) {
            addCriterion("train_date <", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateLessThanOrEqualTo(Date value) {
            addCriterion("train_date <=", value, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateIn(List<Date> values) {
            addCriterion("train_date in", values, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotIn(List<Date> values) {
            addCriterion("train_date not in", values, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateBetween(Date value1, Date value2) {
            addCriterion("train_date between", value1, value2, "trainDate");
            return (Criteria) this;
        }

        public Criteria andTrainDateNotBetween(Date value1, Date value2) {
            addCriterion("train_date not between", value1, value2, "trainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateIsNull() {
            addCriterion("is_show_train_date is null");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateIsNotNull() {
            addCriterion("is_show_train_date is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateEqualTo(Byte value) {
            addCriterion("is_show_train_date =", value, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateNotEqualTo(Byte value) {
            addCriterion("is_show_train_date <>", value, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateGreaterThan(Byte value) {
            addCriterion("is_show_train_date >", value, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_train_date >=", value, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateLessThan(Byte value) {
            addCriterion("is_show_train_date <", value, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_train_date <=", value, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateIn(List<Byte> values) {
            addCriterion("is_show_train_date in", values, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateNotIn(List<Byte> values) {
            addCriterion("is_show_train_date not in", values, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateBetween(Byte value1, Byte value2) {
            addCriterion("is_show_train_date between", value1, value2, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andIsShowTrainDateNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_train_date not between", value1, value2, "isShowTrainDate");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalIsNull() {
            addCriterion("survey_dimensional is null");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalIsNotNull() {
            addCriterion("survey_dimensional is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalEqualTo(String value) {
            addCriterion("survey_dimensional =", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalNotEqualTo(String value) {
            addCriterion("survey_dimensional <>", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalGreaterThan(String value) {
            addCriterion("survey_dimensional >", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalGreaterThanOrEqualTo(String value) {
            addCriterion("survey_dimensional >=", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalLessThan(String value) {
            addCriterion("survey_dimensional <", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalLessThanOrEqualTo(String value) {
            addCriterion("survey_dimensional <=", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalLike(String value) {
            addCriterion("survey_dimensional like", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalNotLike(String value) {
            addCriterion("survey_dimensional not like", value, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalIn(List<String> values) {
            addCriterion("survey_dimensional in", values, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalNotIn(List<String> values) {
            addCriterion("survey_dimensional not in", values, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalBetween(String value1, String value2) {
            addCriterion("survey_dimensional between", value1, value2, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyDimensionalNotBetween(String value1, String value2) {
            addCriterion("survey_dimensional not between", value1, value2, "surveyDimensional");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlIsNull() {
            addCriterion("survey_url is null");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlIsNotNull() {
            addCriterion("survey_url is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlEqualTo(String value) {
            addCriterion("survey_url =", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlNotEqualTo(String value) {
            addCriterion("survey_url <>", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlGreaterThan(String value) {
            addCriterion("survey_url >", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("survey_url >=", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlLessThan(String value) {
            addCriterion("survey_url <", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlLessThanOrEqualTo(String value) {
            addCriterion("survey_url <=", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlLike(String value) {
            addCriterion("survey_url like", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlNotLike(String value) {
            addCriterion("survey_url not like", value, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlIn(List<String> values) {
            addCriterion("survey_url in", values, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlNotIn(List<String> values) {
            addCriterion("survey_url not in", values, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlBetween(String value1, String value2) {
            addCriterion("survey_url between", value1, value2, "surveyUrl");
            return (Criteria) this;
        }

        public Criteria andSurveyUrlNotBetween(String value1, String value2) {
            addCriterion("survey_url not between", value1, value2, "surveyUrl");
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