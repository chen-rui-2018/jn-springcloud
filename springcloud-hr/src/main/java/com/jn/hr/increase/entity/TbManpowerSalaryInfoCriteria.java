package com.jn.hr.increase.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerSalaryInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerSalaryInfoCriteria() {
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

        public Criteria andProbationBasicWageIsNull() {
            addCriterion("probation_basic_wage is null");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageIsNotNull() {
            addCriterion("probation_basic_wage is not null");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageEqualTo(Double value) {
            addCriterion("probation_basic_wage =", value, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageNotEqualTo(Double value) {
            addCriterion("probation_basic_wage <>", value, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageGreaterThan(Double value) {
            addCriterion("probation_basic_wage >", value, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_basic_wage >=", value, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageLessThan(Double value) {
            addCriterion("probation_basic_wage <", value, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageLessThanOrEqualTo(Double value) {
            addCriterion("probation_basic_wage <=", value, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageIn(List<Double> values) {
            addCriterion("probation_basic_wage in", values, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageNotIn(List<Double> values) {
            addCriterion("probation_basic_wage not in", values, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageBetween(Double value1, Double value2) {
            addCriterion("probation_basic_wage between", value1, value2, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationBasicWageNotBetween(Double value1, Double value2) {
            addCriterion("probation_basic_wage not between", value1, value2, "probationBasicWage");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceIsNull() {
            addCriterion("probation_duty_allowance is null");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceIsNotNull() {
            addCriterion("probation_duty_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceEqualTo(Double value) {
            addCriterion("probation_duty_allowance =", value, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceNotEqualTo(Double value) {
            addCriterion("probation_duty_allowance <>", value, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceGreaterThan(Double value) {
            addCriterion("probation_duty_allowance >", value, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_duty_allowance >=", value, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceLessThan(Double value) {
            addCriterion("probation_duty_allowance <", value, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("probation_duty_allowance <=", value, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceIn(List<Double> values) {
            addCriterion("probation_duty_allowance in", values, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceNotIn(List<Double> values) {
            addCriterion("probation_duty_allowance not in", values, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceBetween(Double value1, Double value2) {
            addCriterion("probation_duty_allowance between", value1, value2, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationDutyAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("probation_duty_allowance not between", value1, value2, "probationDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceIsNull() {
            addCriterion("probation_professional_title_allowance is null");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceIsNotNull() {
            addCriterion("probation_professional_title_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceEqualTo(Double value) {
            addCriterion("probation_professional_title_allowance =", value, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceNotEqualTo(Double value) {
            addCriterion("probation_professional_title_allowance <>", value, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceGreaterThan(Double value) {
            addCriterion("probation_professional_title_allowance >", value, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_professional_title_allowance >=", value, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceLessThan(Double value) {
            addCriterion("probation_professional_title_allowance <", value, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("probation_professional_title_allowance <=", value, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceIn(List<Double> values) {
            addCriterion("probation_professional_title_allowance in", values, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceNotIn(List<Double> values) {
            addCriterion("probation_professional_title_allowance not in", values, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceBetween(Double value1, Double value2) {
            addCriterion("probation_professional_title_allowance between", value1, value2, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationProfessionalTitleAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("probation_professional_title_allowance not between", value1, value2, "probationProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageIsNull() {
            addCriterion("probation_seniority_wage is null");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageIsNotNull() {
            addCriterion("probation_seniority_wage is not null");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageEqualTo(Double value) {
            addCriterion("probation_seniority_wage =", value, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageNotEqualTo(Double value) {
            addCriterion("probation_seniority_wage <>", value, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageGreaterThan(Double value) {
            addCriterion("probation_seniority_wage >", value, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_seniority_wage >=", value, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageLessThan(Double value) {
            addCriterion("probation_seniority_wage <", value, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageLessThanOrEqualTo(Double value) {
            addCriterion("probation_seniority_wage <=", value, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageIn(List<Double> values) {
            addCriterion("probation_seniority_wage in", values, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageNotIn(List<Double> values) {
            addCriterion("probation_seniority_wage not in", values, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageBetween(Double value1, Double value2) {
            addCriterion("probation_seniority_wage between", value1, value2, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationSeniorityWageNotBetween(Double value1, Double value2) {
            addCriterion("probation_seniority_wage not between", value1, value2, "probationSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceIsNull() {
            addCriterion("probation_education_allowance is null");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceIsNotNull() {
            addCriterion("probation_education_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceEqualTo(Double value) {
            addCriterion("probation_education_allowance =", value, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceNotEqualTo(Double value) {
            addCriterion("probation_education_allowance <>", value, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceGreaterThan(Double value) {
            addCriterion("probation_education_allowance >", value, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_education_allowance >=", value, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceLessThan(Double value) {
            addCriterion("probation_education_allowance <", value, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("probation_education_allowance <=", value, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceIn(List<Double> values) {
            addCriterion("probation_education_allowance in", values, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceNotIn(List<Double> values) {
            addCriterion("probation_education_allowance not in", values, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceBetween(Double value1, Double value2) {
            addCriterion("probation_education_allowance between", value1, value2, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationEducationAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("probation_education_allowance not between", value1, value2, "probationEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyIsNull() {
            addCriterion("probation_work_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyIsNotNull() {
            addCriterion("probation_work_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyEqualTo(Double value) {
            addCriterion("probation_work_subsidy =", value, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyNotEqualTo(Double value) {
            addCriterion("probation_work_subsidy <>", value, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyGreaterThan(Double value) {
            addCriterion("probation_work_subsidy >", value, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_work_subsidy >=", value, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyLessThan(Double value) {
            addCriterion("probation_work_subsidy <", value, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("probation_work_subsidy <=", value, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyIn(List<Double> values) {
            addCriterion("probation_work_subsidy in", values, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyNotIn(List<Double> values) {
            addCriterion("probation_work_subsidy not in", values, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyBetween(Double value1, Double value2) {
            addCriterion("probation_work_subsidy between", value1, value2, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationWorkSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("probation_work_subsidy not between", value1, value2, "probationWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusIsNull() {
            addCriterion("probation_achievement_bonus is null");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusIsNotNull() {
            addCriterion("probation_achievement_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusEqualTo(Double value) {
            addCriterion("probation_achievement_bonus =", value, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusNotEqualTo(Double value) {
            addCriterion("probation_achievement_bonus <>", value, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusGreaterThan(Double value) {
            addCriterion("probation_achievement_bonus >", value, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusGreaterThanOrEqualTo(Double value) {
            addCriterion("probation_achievement_bonus >=", value, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusLessThan(Double value) {
            addCriterion("probation_achievement_bonus <", value, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusLessThanOrEqualTo(Double value) {
            addCriterion("probation_achievement_bonus <=", value, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusIn(List<Double> values) {
            addCriterion("probation_achievement_bonus in", values, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusNotIn(List<Double> values) {
            addCriterion("probation_achievement_bonus not in", values, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusBetween(Double value1, Double value2) {
            addCriterion("probation_achievement_bonus between", value1, value2, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationAchievementBonusNotBetween(Double value1, Double value2) {
            addCriterion("probation_achievement_bonus not between", value1, value2, "probationAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardIsNull() {
            addCriterion("probation_single_reward is null");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardIsNotNull() {
            addCriterion("probation_single_reward is not null");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardEqualTo(BigDecimal value) {
            addCriterion("probation_single_reward =", value, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardNotEqualTo(BigDecimal value) {
            addCriterion("probation_single_reward <>", value, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardGreaterThan(BigDecimal value) {
            addCriterion("probation_single_reward >", value, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("probation_single_reward >=", value, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardLessThan(BigDecimal value) {
            addCriterion("probation_single_reward <", value, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardLessThanOrEqualTo(BigDecimal value) {
            addCriterion("probation_single_reward <=", value, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardIn(List<BigDecimal> values) {
            addCriterion("probation_single_reward in", values, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardNotIn(List<BigDecimal> values) {
            addCriterion("probation_single_reward not in", values, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("probation_single_reward between", value1, value2, "probationSingleReward");
            return (Criteria) this;
        }

        public Criteria andProbationSingleRewardNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("probation_single_reward not between", value1, value2, "probationSingleReward");
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

        public Criteria andConversionBasicWageIsNull() {
            addCriterion("conversion_basic_wage is null");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageIsNotNull() {
            addCriterion("conversion_basic_wage is not null");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageEqualTo(Double value) {
            addCriterion("conversion_basic_wage =", value, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageNotEqualTo(Double value) {
            addCriterion("conversion_basic_wage <>", value, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageGreaterThan(Double value) {
            addCriterion("conversion_basic_wage >", value, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_basic_wage >=", value, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageLessThan(Double value) {
            addCriterion("conversion_basic_wage <", value, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageLessThanOrEqualTo(Double value) {
            addCriterion("conversion_basic_wage <=", value, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageIn(List<Double> values) {
            addCriterion("conversion_basic_wage in", values, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageNotIn(List<Double> values) {
            addCriterion("conversion_basic_wage not in", values, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageBetween(Double value1, Double value2) {
            addCriterion("conversion_basic_wage between", value1, value2, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionBasicWageNotBetween(Double value1, Double value2) {
            addCriterion("conversion_basic_wage not between", value1, value2, "conversionBasicWage");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceIsNull() {
            addCriterion("conversion_duty_allowance is null");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceIsNotNull() {
            addCriterion("conversion_duty_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceEqualTo(Double value) {
            addCriterion("conversion_duty_allowance =", value, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceNotEqualTo(Double value) {
            addCriterion("conversion_duty_allowance <>", value, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceGreaterThan(Double value) {
            addCriterion("conversion_duty_allowance >", value, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_duty_allowance >=", value, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceLessThan(Double value) {
            addCriterion("conversion_duty_allowance <", value, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("conversion_duty_allowance <=", value, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceIn(List<Double> values) {
            addCriterion("conversion_duty_allowance in", values, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceNotIn(List<Double> values) {
            addCriterion("conversion_duty_allowance not in", values, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceBetween(Double value1, Double value2) {
            addCriterion("conversion_duty_allowance between", value1, value2, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionDutyAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("conversion_duty_allowance not between", value1, value2, "conversionDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceIsNull() {
            addCriterion("conversion_professional_title_allowance is null");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceIsNotNull() {
            addCriterion("conversion_professional_title_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceEqualTo(Double value) {
            addCriterion("conversion_professional_title_allowance =", value, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceNotEqualTo(Double value) {
            addCriterion("conversion_professional_title_allowance <>", value, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceGreaterThan(Double value) {
            addCriterion("conversion_professional_title_allowance >", value, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_professional_title_allowance >=", value, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceLessThan(Double value) {
            addCriterion("conversion_professional_title_allowance <", value, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("conversion_professional_title_allowance <=", value, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceIn(List<Double> values) {
            addCriterion("conversion_professional_title_allowance in", values, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceNotIn(List<Double> values) {
            addCriterion("conversion_professional_title_allowance not in", values, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceBetween(Double value1, Double value2) {
            addCriterion("conversion_professional_title_allowance between", value1, value2, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionProfessionalTitleAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("conversion_professional_title_allowance not between", value1, value2, "conversionProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageIsNull() {
            addCriterion("conversion_seniority_wage is null");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageIsNotNull() {
            addCriterion("conversion_seniority_wage is not null");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageEqualTo(Double value) {
            addCriterion("conversion_seniority_wage =", value, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageNotEqualTo(Double value) {
            addCriterion("conversion_seniority_wage <>", value, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageGreaterThan(Double value) {
            addCriterion("conversion_seniority_wage >", value, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_seniority_wage >=", value, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageLessThan(Double value) {
            addCriterion("conversion_seniority_wage <", value, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageLessThanOrEqualTo(Double value) {
            addCriterion("conversion_seniority_wage <=", value, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageIn(List<Double> values) {
            addCriterion("conversion_seniority_wage in", values, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageNotIn(List<Double> values) {
            addCriterion("conversion_seniority_wage not in", values, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageBetween(Double value1, Double value2) {
            addCriterion("conversion_seniority_wage between", value1, value2, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionSeniorityWageNotBetween(Double value1, Double value2) {
            addCriterion("conversion_seniority_wage not between", value1, value2, "conversionSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceIsNull() {
            addCriterion("conversion_education_allowance is null");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceIsNotNull() {
            addCriterion("conversion_education_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceEqualTo(Double value) {
            addCriterion("conversion_education_allowance =", value, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceNotEqualTo(Double value) {
            addCriterion("conversion_education_allowance <>", value, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceGreaterThan(Double value) {
            addCriterion("conversion_education_allowance >", value, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_education_allowance >=", value, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceLessThan(Double value) {
            addCriterion("conversion_education_allowance <", value, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("conversion_education_allowance <=", value, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceIn(List<Double> values) {
            addCriterion("conversion_education_allowance in", values, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceNotIn(List<Double> values) {
            addCriterion("conversion_education_allowance not in", values, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceBetween(Double value1, Double value2) {
            addCriterion("conversion_education_allowance between", value1, value2, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionEducationAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("conversion_education_allowance not between", value1, value2, "conversionEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyIsNull() {
            addCriterion("conversion_work_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyIsNotNull() {
            addCriterion("conversion_work_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyEqualTo(Double value) {
            addCriterion("conversion_work_subsidy =", value, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyNotEqualTo(Double value) {
            addCriterion("conversion_work_subsidy <>", value, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyGreaterThan(Double value) {
            addCriterion("conversion_work_subsidy >", value, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_work_subsidy >=", value, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyLessThan(Double value) {
            addCriterion("conversion_work_subsidy <", value, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("conversion_work_subsidy <=", value, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyIn(List<Double> values) {
            addCriterion("conversion_work_subsidy in", values, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyNotIn(List<Double> values) {
            addCriterion("conversion_work_subsidy not in", values, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyBetween(Double value1, Double value2) {
            addCriterion("conversion_work_subsidy between", value1, value2, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionWorkSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("conversion_work_subsidy not between", value1, value2, "conversionWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusIsNull() {
            addCriterion("conversion_achievement_bonus is null");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusIsNotNull() {
            addCriterion("conversion_achievement_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusEqualTo(Double value) {
            addCriterion("conversion_achievement_bonus =", value, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusNotEqualTo(Double value) {
            addCriterion("conversion_achievement_bonus <>", value, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusGreaterThan(Double value) {
            addCriterion("conversion_achievement_bonus >", value, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_achievement_bonus >=", value, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusLessThan(Double value) {
            addCriterion("conversion_achievement_bonus <", value, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusLessThanOrEqualTo(Double value) {
            addCriterion("conversion_achievement_bonus <=", value, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusIn(List<Double> values) {
            addCriterion("conversion_achievement_bonus in", values, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusNotIn(List<Double> values) {
            addCriterion("conversion_achievement_bonus not in", values, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusBetween(Double value1, Double value2) {
            addCriterion("conversion_achievement_bonus between", value1, value2, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionAchievementBonusNotBetween(Double value1, Double value2) {
            addCriterion("conversion_achievement_bonus not between", value1, value2, "conversionAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardIsNull() {
            addCriterion("conversion_single_reward is null");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardIsNotNull() {
            addCriterion("conversion_single_reward is not null");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardEqualTo(Double value) {
            addCriterion("conversion_single_reward =", value, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardNotEqualTo(Double value) {
            addCriterion("conversion_single_reward <>", value, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardGreaterThan(Double value) {
            addCriterion("conversion_single_reward >", value, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardGreaterThanOrEqualTo(Double value) {
            addCriterion("conversion_single_reward >=", value, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardLessThan(Double value) {
            addCriterion("conversion_single_reward <", value, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardLessThanOrEqualTo(Double value) {
            addCriterion("conversion_single_reward <=", value, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardIn(List<Double> values) {
            addCriterion("conversion_single_reward in", values, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardNotIn(List<Double> values) {
            addCriterion("conversion_single_reward not in", values, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardBetween(Double value1, Double value2) {
            addCriterion("conversion_single_reward between", value1, value2, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andConversionSingleRewardNotBetween(Double value1, Double value2) {
            addCriterion("conversion_single_reward not between", value1, value2, "conversionSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageIsNull() {
            addCriterion("current_basic_wage is null");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageIsNotNull() {
            addCriterion("current_basic_wage is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageEqualTo(String value) {
            addCriterion("current_basic_wage =", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageNotEqualTo(String value) {
            addCriterion("current_basic_wage <>", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageGreaterThan(String value) {
            addCriterion("current_basic_wage >", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageGreaterThanOrEqualTo(String value) {
            addCriterion("current_basic_wage >=", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageLessThan(String value) {
            addCriterion("current_basic_wage <", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageLessThanOrEqualTo(String value) {
            addCriterion("current_basic_wage <=", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageLike(String value) {
            addCriterion("current_basic_wage like", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageNotLike(String value) {
            addCriterion("current_basic_wage not like", value, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageIn(List<String> values) {
            addCriterion("current_basic_wage in", values, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageNotIn(List<String> values) {
            addCriterion("current_basic_wage not in", values, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageBetween(String value1, String value2) {
            addCriterion("current_basic_wage between", value1, value2, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentBasicWageNotBetween(String value1, String value2) {
            addCriterion("current_basic_wage not between", value1, value2, "currentBasicWage");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceIsNull() {
            addCriterion("current_duty_allowance is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceIsNotNull() {
            addCriterion("current_duty_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceEqualTo(String value) {
            addCriterion("current_duty_allowance =", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceNotEqualTo(String value) {
            addCriterion("current_duty_allowance <>", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceGreaterThan(String value) {
            addCriterion("current_duty_allowance >", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("current_duty_allowance >=", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceLessThan(String value) {
            addCriterion("current_duty_allowance <", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceLessThanOrEqualTo(String value) {
            addCriterion("current_duty_allowance <=", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceLike(String value) {
            addCriterion("current_duty_allowance like", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceNotLike(String value) {
            addCriterion("current_duty_allowance not like", value, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceIn(List<String> values) {
            addCriterion("current_duty_allowance in", values, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceNotIn(List<String> values) {
            addCriterion("current_duty_allowance not in", values, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceBetween(String value1, String value2) {
            addCriterion("current_duty_allowance between", value1, value2, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentDutyAllowanceNotBetween(String value1, String value2) {
            addCriterion("current_duty_allowance not between", value1, value2, "currentDutyAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceIsNull() {
            addCriterion("current_professional_title_allowance is null");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceIsNotNull() {
            addCriterion("current_professional_title_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceEqualTo(String value) {
            addCriterion("current_professional_title_allowance =", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceNotEqualTo(String value) {
            addCriterion("current_professional_title_allowance <>", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceGreaterThan(String value) {
            addCriterion("current_professional_title_allowance >", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("current_professional_title_allowance >=", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceLessThan(String value) {
            addCriterion("current_professional_title_allowance <", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceLessThanOrEqualTo(String value) {
            addCriterion("current_professional_title_allowance <=", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceLike(String value) {
            addCriterion("current_professional_title_allowance like", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceNotLike(String value) {
            addCriterion("current_professional_title_allowance not like", value, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceIn(List<String> values) {
            addCriterion("current_professional_title_allowance in", values, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceNotIn(List<String> values) {
            addCriterion("current_professional_title_allowance not in", values, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceBetween(String value1, String value2) {
            addCriterion("current_professional_title_allowance between", value1, value2, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentProfessionalTitleAllowanceNotBetween(String value1, String value2) {
            addCriterion("current_professional_title_allowance not between", value1, value2, "currentProfessionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageIsNull() {
            addCriterion("current_seniority_wage is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageIsNotNull() {
            addCriterion("current_seniority_wage is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageEqualTo(String value) {
            addCriterion("current_seniority_wage =", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageNotEqualTo(String value) {
            addCriterion("current_seniority_wage <>", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageGreaterThan(String value) {
            addCriterion("current_seniority_wage >", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageGreaterThanOrEqualTo(String value) {
            addCriterion("current_seniority_wage >=", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageLessThan(String value) {
            addCriterion("current_seniority_wage <", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageLessThanOrEqualTo(String value) {
            addCriterion("current_seniority_wage <=", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageLike(String value) {
            addCriterion("current_seniority_wage like", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageNotLike(String value) {
            addCriterion("current_seniority_wage not like", value, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageIn(List<String> values) {
            addCriterion("current_seniority_wage in", values, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageNotIn(List<String> values) {
            addCriterion("current_seniority_wage not in", values, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageBetween(String value1, String value2) {
            addCriterion("current_seniority_wage between", value1, value2, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentSeniorityWageNotBetween(String value1, String value2) {
            addCriterion("current_seniority_wage not between", value1, value2, "currentSeniorityWage");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceIsNull() {
            addCriterion("current_education_allowance is null");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceIsNotNull() {
            addCriterion("current_education_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceEqualTo(String value) {
            addCriterion("current_education_allowance =", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceNotEqualTo(String value) {
            addCriterion("current_education_allowance <>", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceGreaterThan(String value) {
            addCriterion("current_education_allowance >", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("current_education_allowance >=", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceLessThan(String value) {
            addCriterion("current_education_allowance <", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceLessThanOrEqualTo(String value) {
            addCriterion("current_education_allowance <=", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceLike(String value) {
            addCriterion("current_education_allowance like", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceNotLike(String value) {
            addCriterion("current_education_allowance not like", value, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceIn(List<String> values) {
            addCriterion("current_education_allowance in", values, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceNotIn(List<String> values) {
            addCriterion("current_education_allowance not in", values, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceBetween(String value1, String value2) {
            addCriterion("current_education_allowance between", value1, value2, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentEducationAllowanceNotBetween(String value1, String value2) {
            addCriterion("current_education_allowance not between", value1, value2, "currentEducationAllowance");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyIsNull() {
            addCriterion("current_work_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyIsNotNull() {
            addCriterion("current_work_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyEqualTo(String value) {
            addCriterion("current_work_subsidy =", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyNotEqualTo(String value) {
            addCriterion("current_work_subsidy <>", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyGreaterThan(String value) {
            addCriterion("current_work_subsidy >", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("current_work_subsidy >=", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyLessThan(String value) {
            addCriterion("current_work_subsidy <", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyLessThanOrEqualTo(String value) {
            addCriterion("current_work_subsidy <=", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyLike(String value) {
            addCriterion("current_work_subsidy like", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyNotLike(String value) {
            addCriterion("current_work_subsidy not like", value, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyIn(List<String> values) {
            addCriterion("current_work_subsidy in", values, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyNotIn(List<String> values) {
            addCriterion("current_work_subsidy not in", values, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyBetween(String value1, String value2) {
            addCriterion("current_work_subsidy between", value1, value2, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentWorkSubsidyNotBetween(String value1, String value2) {
            addCriterion("current_work_subsidy not between", value1, value2, "currentWorkSubsidy");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusIsNull() {
            addCriterion("current_achievement_bonus is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusIsNotNull() {
            addCriterion("current_achievement_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusEqualTo(String value) {
            addCriterion("current_achievement_bonus =", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusNotEqualTo(String value) {
            addCriterion("current_achievement_bonus <>", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusGreaterThan(String value) {
            addCriterion("current_achievement_bonus >", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusGreaterThanOrEqualTo(String value) {
            addCriterion("current_achievement_bonus >=", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusLessThan(String value) {
            addCriterion("current_achievement_bonus <", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusLessThanOrEqualTo(String value) {
            addCriterion("current_achievement_bonus <=", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusLike(String value) {
            addCriterion("current_achievement_bonus like", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusNotLike(String value) {
            addCriterion("current_achievement_bonus not like", value, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusIn(List<String> values) {
            addCriterion("current_achievement_bonus in", values, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusNotIn(List<String> values) {
            addCriterion("current_achievement_bonus not in", values, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusBetween(String value1, String value2) {
            addCriterion("current_achievement_bonus between", value1, value2, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentAchievementBonusNotBetween(String value1, String value2) {
            addCriterion("current_achievement_bonus not between", value1, value2, "currentAchievementBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardIsNull() {
            addCriterion("current_single_reward is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardIsNotNull() {
            addCriterion("current_single_reward is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardEqualTo(String value) {
            addCriterion("current_single_reward =", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardNotEqualTo(String value) {
            addCriterion("current_single_reward <>", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardGreaterThan(String value) {
            addCriterion("current_single_reward >", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardGreaterThanOrEqualTo(String value) {
            addCriterion("current_single_reward >=", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardLessThan(String value) {
            addCriterion("current_single_reward <", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardLessThanOrEqualTo(String value) {
            addCriterion("current_single_reward <=", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardLike(String value) {
            addCriterion("current_single_reward like", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardNotLike(String value) {
            addCriterion("current_single_reward not like", value, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardIn(List<String> values) {
            addCriterion("current_single_reward in", values, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardNotIn(List<String> values) {
            addCriterion("current_single_reward not in", values, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardBetween(String value1, String value2) {
            addCriterion("current_single_reward between", value1, value2, "currentSingleReward");
            return (Criteria) this;
        }

        public Criteria andCurrentSingleRewardNotBetween(String value1, String value2) {
            addCriterion("current_single_reward not between", value1, value2, "currentSingleReward");
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