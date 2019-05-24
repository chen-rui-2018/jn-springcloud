package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerSalaryPayrollCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerSalaryPayrollCriteria() {
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

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andBasicWageIsNull() {
            addCriterion("basic_wage is null");
            return (Criteria) this;
        }

        public Criteria andBasicWageIsNotNull() {
            addCriterion("basic_wage is not null");
            return (Criteria) this;
        }

        public Criteria andBasicWageEqualTo(Double value) {
            addCriterion("basic_wage =", value, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageNotEqualTo(Double value) {
            addCriterion("basic_wage <>", value, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageGreaterThan(Double value) {
            addCriterion("basic_wage >", value, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageGreaterThanOrEqualTo(Double value) {
            addCriterion("basic_wage >=", value, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageLessThan(Double value) {
            addCriterion("basic_wage <", value, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageLessThanOrEqualTo(Double value) {
            addCriterion("basic_wage <=", value, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageIn(List<Double> values) {
            addCriterion("basic_wage in", values, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageNotIn(List<Double> values) {
            addCriterion("basic_wage not in", values, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageBetween(Double value1, Double value2) {
            addCriterion("basic_wage between", value1, value2, "basicWage");
            return (Criteria) this;
        }

        public Criteria andBasicWageNotBetween(Double value1, Double value2) {
            addCriterion("basic_wage not between", value1, value2, "basicWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageIsNull() {
            addCriterion("seniority_wage is null");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageIsNotNull() {
            addCriterion("seniority_wage is not null");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageEqualTo(Double value) {
            addCriterion("seniority_wage =", value, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageNotEqualTo(Double value) {
            addCriterion("seniority_wage <>", value, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageGreaterThan(Double value) {
            addCriterion("seniority_wage >", value, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageGreaterThanOrEqualTo(Double value) {
            addCriterion("seniority_wage >=", value, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageLessThan(Double value) {
            addCriterion("seniority_wage <", value, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageLessThanOrEqualTo(Double value) {
            addCriterion("seniority_wage <=", value, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageIn(List<Double> values) {
            addCriterion("seniority_wage in", values, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageNotIn(List<Double> values) {
            addCriterion("seniority_wage not in", values, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageBetween(Double value1, Double value2) {
            addCriterion("seniority_wage between", value1, value2, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andSeniorityWageNotBetween(Double value1, Double value2) {
            addCriterion("seniority_wage not between", value1, value2, "seniorityWage");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceIsNull() {
            addCriterion("technical_allowance is null");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceIsNotNull() {
            addCriterion("technical_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceEqualTo(Double value) {
            addCriterion("technical_allowance =", value, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceNotEqualTo(Double value) {
            addCriterion("technical_allowance <>", value, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceGreaterThan(Double value) {
            addCriterion("technical_allowance >", value, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("technical_allowance >=", value, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceLessThan(Double value) {
            addCriterion("technical_allowance <", value, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("technical_allowance <=", value, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceIn(List<Double> values) {
            addCriterion("technical_allowance in", values, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceNotIn(List<Double> values) {
            addCriterion("technical_allowance not in", values, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceBetween(Double value1, Double value2) {
            addCriterion("technical_allowance between", value1, value2, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andTechnicalAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("technical_allowance not between", value1, value2, "technicalAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceIsNull() {
            addCriterion("duty_allowance is null");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceIsNotNull() {
            addCriterion("duty_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceEqualTo(Double value) {
            addCriterion("duty_allowance =", value, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceNotEqualTo(Double value) {
            addCriterion("duty_allowance <>", value, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceGreaterThan(Double value) {
            addCriterion("duty_allowance >", value, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("duty_allowance >=", value, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceLessThan(Double value) {
            addCriterion("duty_allowance <", value, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("duty_allowance <=", value, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceIn(List<Double> values) {
            addCriterion("duty_allowance in", values, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceNotIn(List<Double> values) {
            addCriterion("duty_allowance not in", values, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceBetween(Double value1, Double value2) {
            addCriterion("duty_allowance between", value1, value2, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andDutyAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("duty_allowance not between", value1, value2, "dutyAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyIsNull() {
            addCriterion("work_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyIsNotNull() {
            addCriterion("work_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyEqualTo(Double value) {
            addCriterion("work_subsidy =", value, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyNotEqualTo(Double value) {
            addCriterion("work_subsidy <>", value, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyGreaterThan(Double value) {
            addCriterion("work_subsidy >", value, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("work_subsidy >=", value, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyLessThan(Double value) {
            addCriterion("work_subsidy <", value, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("work_subsidy <=", value, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyIn(List<Double> values) {
            addCriterion("work_subsidy in", values, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyNotIn(List<Double> values) {
            addCriterion("work_subsidy not in", values, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyBetween(Double value1, Double value2) {
            addCriterion("work_subsidy between", value1, value2, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("work_subsidy not between", value1, value2, "workSubsidy");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceIsNull() {
            addCriterion("education_allowance is null");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceIsNotNull() {
            addCriterion("education_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceEqualTo(Double value) {
            addCriterion("education_allowance =", value, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceNotEqualTo(Double value) {
            addCriterion("education_allowance <>", value, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceGreaterThan(Double value) {
            addCriterion("education_allowance >", value, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("education_allowance >=", value, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceLessThan(Double value) {
            addCriterion("education_allowance <", value, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("education_allowance <=", value, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceIn(List<Double> values) {
            addCriterion("education_allowance in", values, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceNotIn(List<Double> values) {
            addCriterion("education_allowance not in", values, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceBetween(Double value1, Double value2) {
            addCriterion("education_allowance between", value1, value2, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andEducationAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("education_allowance not between", value1, value2, "educationAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceIsNull() {
            addCriterion("professional_title_allowance is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceIsNotNull() {
            addCriterion("professional_title_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceEqualTo(Double value) {
            addCriterion("professional_title_allowance =", value, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceNotEqualTo(Double value) {
            addCriterion("professional_title_allowance <>", value, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceGreaterThan(Double value) {
            addCriterion("professional_title_allowance >", value, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("professional_title_allowance >=", value, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceLessThan(Double value) {
            addCriterion("professional_title_allowance <", value, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("professional_title_allowance <=", value, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceIn(List<Double> values) {
            addCriterion("professional_title_allowance in", values, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceNotIn(List<Double> values) {
            addCriterion("professional_title_allowance not in", values, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceBetween(Double value1, Double value2) {
            addCriterion("professional_title_allowance between", value1, value2, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("professional_title_allowance not between", value1, value2, "professionalTitleAllowance");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyIsNull() {
            addCriterion("special_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyIsNotNull() {
            addCriterion("special_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyEqualTo(Double value) {
            addCriterion("special_subsidy =", value, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyNotEqualTo(Double value) {
            addCriterion("special_subsidy <>", value, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyGreaterThan(Double value) {
            addCriterion("special_subsidy >", value, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("special_subsidy >=", value, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyLessThan(Double value) {
            addCriterion("special_subsidy <", value, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("special_subsidy <=", value, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyIn(List<Double> values) {
            addCriterion("special_subsidy in", values, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyNotIn(List<Double> values) {
            addCriterion("special_subsidy not in", values, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyBetween(Double value1, Double value2) {
            addCriterion("special_subsidy between", value1, value2, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andSpecialSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("special_subsidy not between", value1, value2, "specialSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyIsNull() {
            addCriterion("meal_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyIsNotNull() {
            addCriterion("meal_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyEqualTo(Double value) {
            addCriterion("meal_subsidy =", value, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyNotEqualTo(Double value) {
            addCriterion("meal_subsidy <>", value, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyGreaterThan(Double value) {
            addCriterion("meal_subsidy >", value, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("meal_subsidy >=", value, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyLessThan(Double value) {
            addCriterion("meal_subsidy <", value, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("meal_subsidy <=", value, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyIn(List<Double> values) {
            addCriterion("meal_subsidy in", values, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyNotIn(List<Double> values) {
            addCriterion("meal_subsidy not in", values, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyBetween(Double value1, Double value2) {
            addCriterion("meal_subsidy between", value1, value2, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andMealSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("meal_subsidy not between", value1, value2, "mealSubsidy");
            return (Criteria) this;
        }

        public Criteria andDeserveWageIsNull() {
            addCriterion("deserve_wage is null");
            return (Criteria) this;
        }

        public Criteria andDeserveWageIsNotNull() {
            addCriterion("deserve_wage is not null");
            return (Criteria) this;
        }

        public Criteria andDeserveWageEqualTo(Double value) {
            addCriterion("deserve_wage =", value, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageNotEqualTo(Double value) {
            addCriterion("deserve_wage <>", value, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageGreaterThan(Double value) {
            addCriterion("deserve_wage >", value, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageGreaterThanOrEqualTo(Double value) {
            addCriterion("deserve_wage >=", value, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageLessThan(Double value) {
            addCriterion("deserve_wage <", value, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageLessThanOrEqualTo(Double value) {
            addCriterion("deserve_wage <=", value, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageIn(List<Double> values) {
            addCriterion("deserve_wage in", values, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageNotIn(List<Double> values) {
            addCriterion("deserve_wage not in", values, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageBetween(Double value1, Double value2) {
            addCriterion("deserve_wage between", value1, value2, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageNotBetween(Double value1, Double value2) {
            addCriterion("deserve_wage not between", value1, value2, "deserveWage");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceIsNull() {
            addCriterion("pending_socialpooling_Insurance is null");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceIsNotNull() {
            addCriterion("pending_socialpooling_Insurance is not null");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceEqualTo(Double value) {
            addCriterion("pending_socialpooling_Insurance =", value, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceNotEqualTo(Double value) {
            addCriterion("pending_socialpooling_Insurance <>", value, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceGreaterThan(Double value) {
            addCriterion("pending_socialpooling_Insurance >", value, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceGreaterThanOrEqualTo(Double value) {
            addCriterion("pending_socialpooling_Insurance >=", value, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceLessThan(Double value) {
            addCriterion("pending_socialpooling_Insurance <", value, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceLessThanOrEqualTo(Double value) {
            addCriterion("pending_socialpooling_Insurance <=", value, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceIn(List<Double> values) {
            addCriterion("pending_socialpooling_Insurance in", values, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceNotIn(List<Double> values) {
            addCriterion("pending_socialpooling_Insurance not in", values, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceBetween(Double value1, Double value2) {
            addCriterion("pending_socialpooling_Insurance between", value1, value2, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingSocialpoolingInsuranceNotBetween(Double value1, Double value2) {
            addCriterion("pending_socialpooling_Insurance not between", value1, value2, "pendingSocialpoolingInsurance");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundIsNull() {
            addCriterion("pending_providentfund is null");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundIsNotNull() {
            addCriterion("pending_providentfund is not null");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundEqualTo(Double value) {
            addCriterion("pending_providentfund =", value, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundNotEqualTo(Double value) {
            addCriterion("pending_providentfund <>", value, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundGreaterThan(Double value) {
            addCriterion("pending_providentfund >", value, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundGreaterThanOrEqualTo(Double value) {
            addCriterion("pending_providentfund >=", value, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundLessThan(Double value) {
            addCriterion("pending_providentfund <", value, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundLessThanOrEqualTo(Double value) {
            addCriterion("pending_providentfund <=", value, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundIn(List<Double> values) {
            addCriterion("pending_providentfund in", values, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundNotIn(List<Double> values) {
            addCriterion("pending_providentfund not in", values, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundBetween(Double value1, Double value2) {
            addCriterion("pending_providentfund between", value1, value2, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingProvidentfundNotBetween(Double value1, Double value2) {
            addCriterion("pending_providentfund not between", value1, value2, "pendingProvidentfund");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxIsNull() {
            addCriterion("pending_personal_tax is null");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxIsNotNull() {
            addCriterion("pending_personal_tax is not null");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxEqualTo(Double value) {
            addCriterion("pending_personal_tax =", value, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxNotEqualTo(Double value) {
            addCriterion("pending_personal_tax <>", value, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxGreaterThan(Double value) {
            addCriterion("pending_personal_tax >", value, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("pending_personal_tax >=", value, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxLessThan(Double value) {
            addCriterion("pending_personal_tax <", value, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxLessThanOrEqualTo(Double value) {
            addCriterion("pending_personal_tax <=", value, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxIn(List<Double> values) {
            addCriterion("pending_personal_tax in", values, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxNotIn(List<Double> values) {
            addCriterion("pending_personal_tax not in", values, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxBetween(Double value1, Double value2) {
            addCriterion("pending_personal_tax between", value1, value2, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andPendingPersonalTaxNotBetween(Double value1, Double value2) {
            addCriterion("pending_personal_tax not between", value1, value2, "pendingPersonalTax");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeIsNull() {
            addCriterion("canteen_meal_fee is null");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeIsNotNull() {
            addCriterion("canteen_meal_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeEqualTo(Double value) {
            addCriterion("canteen_meal_fee =", value, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeNotEqualTo(Double value) {
            addCriterion("canteen_meal_fee <>", value, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeGreaterThan(Double value) {
            addCriterion("canteen_meal_fee >", value, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("canteen_meal_fee >=", value, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeLessThan(Double value) {
            addCriterion("canteen_meal_fee <", value, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeLessThanOrEqualTo(Double value) {
            addCriterion("canteen_meal_fee <=", value, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeIn(List<Double> values) {
            addCriterion("canteen_meal_fee in", values, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeNotIn(List<Double> values) {
            addCriterion("canteen_meal_fee not in", values, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeBetween(Double value1, Double value2) {
            addCriterion("canteen_meal_fee between", value1, value2, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andCanteenMealFeeNotBetween(Double value1, Double value2) {
            addCriterion("canteen_meal_fee not between", value1, value2, "canteenMealFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeIsNull() {
            addCriterion("union_fee is null");
            return (Criteria) this;
        }

        public Criteria andUnionFeeIsNotNull() {
            addCriterion("union_fee is not null");
            return (Criteria) this;
        }

        public Criteria andUnionFeeEqualTo(Double value) {
            addCriterion("union_fee =", value, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeNotEqualTo(Double value) {
            addCriterion("union_fee <>", value, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeGreaterThan(Double value) {
            addCriterion("union_fee >", value, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("union_fee >=", value, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeLessThan(Double value) {
            addCriterion("union_fee <", value, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeLessThanOrEqualTo(Double value) {
            addCriterion("union_fee <=", value, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeIn(List<Double> values) {
            addCriterion("union_fee in", values, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeNotIn(List<Double> values) {
            addCriterion("union_fee not in", values, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeBetween(Double value1, Double value2) {
            addCriterion("union_fee between", value1, value2, "unionFee");
            return (Criteria) this;
        }

        public Criteria andUnionFeeNotBetween(Double value1, Double value2) {
            addCriterion("union_fee not between", value1, value2, "unionFee");
            return (Criteria) this;
        }

        public Criteria andRealWageIsNull() {
            addCriterion("real_wage is null");
            return (Criteria) this;
        }

        public Criteria andRealWageIsNotNull() {
            addCriterion("real_wage is not null");
            return (Criteria) this;
        }

        public Criteria andRealWageEqualTo(Double value) {
            addCriterion("real_wage =", value, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageNotEqualTo(Double value) {
            addCriterion("real_wage <>", value, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageGreaterThan(Double value) {
            addCriterion("real_wage >", value, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageGreaterThanOrEqualTo(Double value) {
            addCriterion("real_wage >=", value, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageLessThan(Double value) {
            addCriterion("real_wage <", value, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageLessThanOrEqualTo(Double value) {
            addCriterion("real_wage <=", value, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageIn(List<Double> values) {
            addCriterion("real_wage in", values, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageNotIn(List<Double> values) {
            addCriterion("real_wage not in", values, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageBetween(Double value1, Double value2) {
            addCriterion("real_wage between", value1, value2, "realWage");
            return (Criteria) this;
        }

        public Criteria andRealWageNotBetween(Double value1, Double value2) {
            addCriterion("real_wage not between", value1, value2, "realWage");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeIsNull() {
            addCriterion("account_entry_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeIsNotNull() {
            addCriterion("account_entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeEqualTo(String value) {
            addCriterion("account_entry_time =", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeNotEqualTo(String value) {
            addCriterion("account_entry_time <>", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeGreaterThan(String value) {
            addCriterion("account_entry_time >", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("account_entry_time >=", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeLessThan(String value) {
            addCriterion("account_entry_time <", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeLessThanOrEqualTo(String value) {
            addCriterion("account_entry_time <=", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeLike(String value) {
            addCriterion("account_entry_time like", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeNotLike(String value) {
            addCriterion("account_entry_time not like", value, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeIn(List<String> values) {
            addCriterion("account_entry_time in", values, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeNotIn(List<String> values) {
            addCriterion("account_entry_time not in", values, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeBetween(String value1, String value2) {
            addCriterion("account_entry_time between", value1, value2, "accountEntryTime");
            return (Criteria) this;
        }

        public Criteria andAccountEntryTimeNotBetween(String value1, String value2) {
            addCriterion("account_entry_time not between", value1, value2, "accountEntryTime");
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