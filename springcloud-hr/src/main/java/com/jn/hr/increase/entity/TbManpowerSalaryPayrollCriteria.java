package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitIsNull() {
            addCriterion("issuing_unit is null");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitIsNotNull() {
            addCriterion("issuing_unit is not null");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitEqualTo(String value) {
            addCriterion("issuing_unit =", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitNotEqualTo(String value) {
            addCriterion("issuing_unit <>", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitGreaterThan(String value) {
            addCriterion("issuing_unit >", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitGreaterThanOrEqualTo(String value) {
            addCriterion("issuing_unit >=", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitLessThan(String value) {
            addCriterion("issuing_unit <", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitLessThanOrEqualTo(String value) {
            addCriterion("issuing_unit <=", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitLike(String value) {
            addCriterion("issuing_unit like", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitNotLike(String value) {
            addCriterion("issuing_unit not like", value, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitIn(List<String> values) {
            addCriterion("issuing_unit in", values, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitNotIn(List<String> values) {
            addCriterion("issuing_unit not in", values, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitBetween(String value1, String value2) {
            addCriterion("issuing_unit between", value1, value2, "issuingUnit");
            return (Criteria) this;
        }

        public Criteria andIssuingUnitNotBetween(String value1, String value2) {
            addCriterion("issuing_unit not between", value1, value2, "issuingUnit");
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

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryIsNull() {
            addCriterion("personnel_category is null");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryIsNotNull() {
            addCriterion("personnel_category is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryEqualTo(String value) {
            addCriterion("personnel_category =", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryNotEqualTo(String value) {
            addCriterion("personnel_category <>", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryGreaterThan(String value) {
            addCriterion("personnel_category >", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("personnel_category >=", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryLessThan(String value) {
            addCriterion("personnel_category <", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryLessThanOrEqualTo(String value) {
            addCriterion("personnel_category <=", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryLike(String value) {
            addCriterion("personnel_category like", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryNotLike(String value) {
            addCriterion("personnel_category not like", value, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryIn(List<String> values) {
            addCriterion("personnel_category in", values, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryNotIn(List<String> values) {
            addCriterion("personnel_category not in", values, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryBetween(String value1, String value2) {
            addCriterion("personnel_category between", value1, value2, "personnelCategory");
            return (Criteria) this;
        }

        public Criteria andPersonnelCategoryNotBetween(String value1, String value2) {
            addCriterion("personnel_category not between", value1, value2, "personnelCategory");
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

        public Criteria andWorkAllowanceIsNull() {
            addCriterion("work_allowance is null");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceIsNotNull() {
            addCriterion("work_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceEqualTo(Double value) {
            addCriterion("work_allowance =", value, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceNotEqualTo(Double value) {
            addCriterion("work_allowance <>", value, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceGreaterThan(Double value) {
            addCriterion("work_allowance >", value, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("work_allowance >=", value, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceLessThan(Double value) {
            addCriterion("work_allowance <", value, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("work_allowance <=", value, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceIn(List<Double> values) {
            addCriterion("work_allowance in", values, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceNotIn(List<Double> values) {
            addCriterion("work_allowance not in", values, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceBetween(Double value1, Double value2) {
            addCriterion("work_allowance between", value1, value2, "workAllowance");
            return (Criteria) this;
        }

        public Criteria andWorkAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("work_allowance not between", value1, value2, "workAllowance");
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

        public Criteria andJobAllowanceIsNull() {
            addCriterion("job_allowance is null");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceIsNotNull() {
            addCriterion("job_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceEqualTo(Double value) {
            addCriterion("job_allowance =", value, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceNotEqualTo(Double value) {
            addCriterion("job_allowance <>", value, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceGreaterThan(Double value) {
            addCriterion("job_allowance >", value, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceGreaterThanOrEqualTo(Double value) {
            addCriterion("job_allowance >=", value, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceLessThan(Double value) {
            addCriterion("job_allowance <", value, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceLessThanOrEqualTo(Double value) {
            addCriterion("job_allowance <=", value, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceIn(List<Double> values) {
            addCriterion("job_allowance in", values, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceNotIn(List<Double> values) {
            addCriterion("job_allowance not in", values, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceBetween(Double value1, Double value2) {
            addCriterion("job_allowance between", value1, value2, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andJobAllowanceNotBetween(Double value1, Double value2) {
            addCriterion("job_allowance not between", value1, value2, "jobAllowance");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyIsNull() {
            addCriterion("composite_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyIsNotNull() {
            addCriterion("composite_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyEqualTo(Double value) {
            addCriterion("composite_subsidy =", value, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyNotEqualTo(Double value) {
            addCriterion("composite_subsidy <>", value, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyGreaterThan(Double value) {
            addCriterion("composite_subsidy >", value, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("composite_subsidy >=", value, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyLessThan(Double value) {
            addCriterion("composite_subsidy <", value, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("composite_subsidy <=", value, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyIn(List<Double> values) {
            addCriterion("composite_subsidy in", values, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyNotIn(List<Double> values) {
            addCriterion("composite_subsidy not in", values, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyBetween(Double value1, Double value2) {
            addCriterion("composite_subsidy between", value1, value2, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andCompositeSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("composite_subsidy not between", value1, value2, "compositeSubsidy");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalIsNull() {
            addCriterion("basic_wage_total is null");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalIsNotNull() {
            addCriterion("basic_wage_total is not null");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalEqualTo(Double value) {
            addCriterion("basic_wage_total =", value, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalNotEqualTo(Double value) {
            addCriterion("basic_wage_total <>", value, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalGreaterThan(Double value) {
            addCriterion("basic_wage_total >", value, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("basic_wage_total >=", value, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalLessThan(Double value) {
            addCriterion("basic_wage_total <", value, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalLessThanOrEqualTo(Double value) {
            addCriterion("basic_wage_total <=", value, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalIn(List<Double> values) {
            addCriterion("basic_wage_total in", values, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalNotIn(List<Double> values) {
            addCriterion("basic_wage_total not in", values, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalBetween(Double value1, Double value2) {
            addCriterion("basic_wage_total between", value1, value2, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andBasicWageTotalNotBetween(Double value1, Double value2) {
            addCriterion("basic_wage_total not between", value1, value2, "basicWageTotal");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusIsNull() {
            addCriterion("season_bonus is null");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusIsNotNull() {
            addCriterion("season_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusEqualTo(Double value) {
            addCriterion("season_bonus =", value, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusNotEqualTo(Double value) {
            addCriterion("season_bonus <>", value, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusGreaterThan(Double value) {
            addCriterion("season_bonus >", value, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusGreaterThanOrEqualTo(Double value) {
            addCriterion("season_bonus >=", value, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusLessThan(Double value) {
            addCriterion("season_bonus <", value, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusLessThanOrEqualTo(Double value) {
            addCriterion("season_bonus <=", value, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusIn(List<Double> values) {
            addCriterion("season_bonus in", values, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusNotIn(List<Double> values) {
            addCriterion("season_bonus not in", values, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusBetween(Double value1, Double value2) {
            addCriterion("season_bonus between", value1, value2, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andSeasonBonusNotBetween(Double value1, Double value2) {
            addCriterion("season_bonus not between", value1, value2, "seasonBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusIsNull() {
            addCriterion("year_end_bonus is null");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusIsNotNull() {
            addCriterion("year_end_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusEqualTo(Double value) {
            addCriterion("year_end_bonus =", value, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusNotEqualTo(Double value) {
            addCriterion("year_end_bonus <>", value, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusGreaterThan(Double value) {
            addCriterion("year_end_bonus >", value, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusGreaterThanOrEqualTo(Double value) {
            addCriterion("year_end_bonus >=", value, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusLessThan(Double value) {
            addCriterion("year_end_bonus <", value, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusLessThanOrEqualTo(Double value) {
            addCriterion("year_end_bonus <=", value, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusIn(List<Double> values) {
            addCriterion("year_end_bonus in", values, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusNotIn(List<Double> values) {
            addCriterion("year_end_bonus not in", values, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusBetween(Double value1, Double value2) {
            addCriterion("year_end_bonus between", value1, value2, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andYearEndBonusNotBetween(Double value1, Double value2) {
            addCriterion("year_end_bonus not between", value1, value2, "yearEndBonus");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalIsNull() {
            addCriterion("salary_total is null");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalIsNotNull() {
            addCriterion("salary_total is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalEqualTo(Double value) {
            addCriterion("salary_total =", value, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalNotEqualTo(Double value) {
            addCriterion("salary_total <>", value, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalGreaterThan(Double value) {
            addCriterion("salary_total >", value, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("salary_total >=", value, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalLessThan(Double value) {
            addCriterion("salary_total <", value, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalLessThanOrEqualTo(Double value) {
            addCriterion("salary_total <=", value, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalIn(List<Double> values) {
            addCriterion("salary_total in", values, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalNotIn(List<Double> values) {
            addCriterion("salary_total not in", values, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalBetween(Double value1, Double value2) {
            addCriterion("salary_total between", value1, value2, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andSalaryTotalNotBetween(Double value1, Double value2) {
            addCriterion("salary_total not between", value1, value2, "salaryTotal");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationIsNull() {
            addCriterion("work_excitation is null");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationIsNotNull() {
            addCriterion("work_excitation is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationEqualTo(Double value) {
            addCriterion("work_excitation =", value, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationNotEqualTo(Double value) {
            addCriterion("work_excitation <>", value, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationGreaterThan(Double value) {
            addCriterion("work_excitation >", value, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationGreaterThanOrEqualTo(Double value) {
            addCriterion("work_excitation >=", value, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationLessThan(Double value) {
            addCriterion("work_excitation <", value, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationLessThanOrEqualTo(Double value) {
            addCriterion("work_excitation <=", value, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationIn(List<Double> values) {
            addCriterion("work_excitation in", values, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationNotIn(List<Double> values) {
            addCriterion("work_excitation not in", values, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationBetween(Double value1, Double value2) {
            addCriterion("work_excitation between", value1, value2, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andWorkExcitationNotBetween(Double value1, Double value2) {
            addCriterion("work_excitation not between", value1, value2, "workExcitation");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostIsNull() {
            addCriterion("overtime_cost is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostIsNotNull() {
            addCriterion("overtime_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostEqualTo(Double value) {
            addCriterion("overtime_cost =", value, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostNotEqualTo(Double value) {
            addCriterion("overtime_cost <>", value, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostGreaterThan(Double value) {
            addCriterion("overtime_cost >", value, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostGreaterThanOrEqualTo(Double value) {
            addCriterion("overtime_cost >=", value, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostLessThan(Double value) {
            addCriterion("overtime_cost <", value, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostLessThanOrEqualTo(Double value) {
            addCriterion("overtime_cost <=", value, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostIn(List<Double> values) {
            addCriterion("overtime_cost in", values, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostNotIn(List<Double> values) {
            addCriterion("overtime_cost not in", values, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostBetween(Double value1, Double value2) {
            addCriterion("overtime_cost between", value1, value2, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeCostNotBetween(Double value1, Double value2) {
            addCriterion("overtime_cost not between", value1, value2, "overtimeCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostIsNull() {
            addCriterion("on_duty_cost is null");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostIsNotNull() {
            addCriterion("on_duty_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostEqualTo(Double value) {
            addCriterion("on_duty_cost =", value, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostNotEqualTo(Double value) {
            addCriterion("on_duty_cost <>", value, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostGreaterThan(Double value) {
            addCriterion("on_duty_cost >", value, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostGreaterThanOrEqualTo(Double value) {
            addCriterion("on_duty_cost >=", value, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostLessThan(Double value) {
            addCriterion("on_duty_cost <", value, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostLessThanOrEqualTo(Double value) {
            addCriterion("on_duty_cost <=", value, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostIn(List<Double> values) {
            addCriterion("on_duty_cost in", values, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostNotIn(List<Double> values) {
            addCriterion("on_duty_cost not in", values, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostBetween(Double value1, Double value2) {
            addCriterion("on_duty_cost between", value1, value2, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOnDutyCostNotBetween(Double value1, Double value2) {
            addCriterion("on_duty_cost not between", value1, value2, "onDutyCost");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalIsNull() {
            addCriterion("overtime_total is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalIsNotNull() {
            addCriterion("overtime_total is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalEqualTo(Double value) {
            addCriterion("overtime_total =", value, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalNotEqualTo(Double value) {
            addCriterion("overtime_total <>", value, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalGreaterThan(Double value) {
            addCriterion("overtime_total >", value, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("overtime_total >=", value, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalLessThan(Double value) {
            addCriterion("overtime_total <", value, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalLessThanOrEqualTo(Double value) {
            addCriterion("overtime_total <=", value, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalIn(List<Double> values) {
            addCriterion("overtime_total in", values, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalNotIn(List<Double> values) {
            addCriterion("overtime_total not in", values, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalBetween(Double value1, Double value2) {
            addCriterion("overtime_total between", value1, value2, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andOvertimeTotalNotBetween(Double value1, Double value2) {
            addCriterion("overtime_total not between", value1, value2, "overtimeTotal");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyIsNull() {
            addCriterion("business_car_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyIsNotNull() {
            addCriterion("business_car_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyEqualTo(Double value) {
            addCriterion("business_car_subsidy =", value, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyNotEqualTo(Double value) {
            addCriterion("business_car_subsidy <>", value, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyGreaterThan(Double value) {
            addCriterion("business_car_subsidy >", value, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("business_car_subsidy >=", value, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyLessThan(Double value) {
            addCriterion("business_car_subsidy <", value, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("business_car_subsidy <=", value, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyIn(List<Double> values) {
            addCriterion("business_car_subsidy in", values, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyNotIn(List<Double> values) {
            addCriterion("business_car_subsidy not in", values, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyBetween(Double value1, Double value2) {
            addCriterion("business_car_subsidy between", value1, value2, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessCarSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("business_car_subsidy not between", value1, value2, "businessCarSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyIsNull() {
            addCriterion("site_overtime_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyIsNotNull() {
            addCriterion("site_overtime_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyEqualTo(Double value) {
            addCriterion("site_overtime_subsidy =", value, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyNotEqualTo(Double value) {
            addCriterion("site_overtime_subsidy <>", value, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyGreaterThan(Double value) {
            addCriterion("site_overtime_subsidy >", value, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("site_overtime_subsidy >=", value, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyLessThan(Double value) {
            addCriterion("site_overtime_subsidy <", value, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("site_overtime_subsidy <=", value, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyIn(List<Double> values) {
            addCriterion("site_overtime_subsidy in", values, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyNotIn(List<Double> values) {
            addCriterion("site_overtime_subsidy not in", values, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyBetween(Double value1, Double value2) {
            addCriterion("site_overtime_subsidy between", value1, value2, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andSiteOvertimeSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("site_overtime_subsidy not between", value1, value2, "siteOvertimeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsIsNull() {
            addCriterion("walk_door_bouns is null");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsIsNotNull() {
            addCriterion("walk_door_bouns is not null");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsEqualTo(Double value) {
            addCriterion("walk_door_bouns =", value, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsNotEqualTo(Double value) {
            addCriterion("walk_door_bouns <>", value, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsGreaterThan(Double value) {
            addCriterion("walk_door_bouns >", value, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsGreaterThanOrEqualTo(Double value) {
            addCriterion("walk_door_bouns >=", value, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsLessThan(Double value) {
            addCriterion("walk_door_bouns <", value, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsLessThanOrEqualTo(Double value) {
            addCriterion("walk_door_bouns <=", value, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsIn(List<Double> values) {
            addCriterion("walk_door_bouns in", values, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsNotIn(List<Double> values) {
            addCriterion("walk_door_bouns not in", values, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsBetween(Double value1, Double value2) {
            addCriterion("walk_door_bouns between", value1, value2, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andWalkDoorBounsNotBetween(Double value1, Double value2) {
            addCriterion("walk_door_bouns not between", value1, value2, "walkDoorBouns");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyIsNull() {
            addCriterion("demolition_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyIsNotNull() {
            addCriterion("demolition_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyEqualTo(Double value) {
            addCriterion("demolition_subsidy =", value, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyNotEqualTo(Double value) {
            addCriterion("demolition_subsidy <>", value, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyGreaterThan(Double value) {
            addCriterion("demolition_subsidy >", value, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("demolition_subsidy >=", value, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyLessThan(Double value) {
            addCriterion("demolition_subsidy <", value, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("demolition_subsidy <=", value, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyIn(List<Double> values) {
            addCriterion("demolition_subsidy in", values, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyNotIn(List<Double> values) {
            addCriterion("demolition_subsidy not in", values, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyBetween(Double value1, Double value2) {
            addCriterion("demolition_subsidy between", value1, value2, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("demolition_subsidy not between", value1, value2, "demolitionSubsidy");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalIsNull() {
            addCriterion("demolition_subsidy_total is null");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalIsNotNull() {
            addCriterion("demolition_subsidy_total is not null");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalEqualTo(Double value) {
            addCriterion("demolition_subsidy_total =", value, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalNotEqualTo(Double value) {
            addCriterion("demolition_subsidy_total <>", value, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalGreaterThan(Double value) {
            addCriterion("demolition_subsidy_total >", value, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("demolition_subsidy_total >=", value, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalLessThan(Double value) {
            addCriterion("demolition_subsidy_total <", value, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalLessThanOrEqualTo(Double value) {
            addCriterion("demolition_subsidy_total <=", value, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalIn(List<Double> values) {
            addCriterion("demolition_subsidy_total in", values, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalNotIn(List<Double> values) {
            addCriterion("demolition_subsidy_total not in", values, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalBetween(Double value1, Double value2) {
            addCriterion("demolition_subsidy_total between", value1, value2, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDemolitionSubsidyTotalNotBetween(Double value1, Double value2) {
            addCriterion("demolition_subsidy_total not between", value1, value2, "demolitionSubsidyTotal");
            return (Criteria) this;
        }

        public Criteria andDelayCostIsNull() {
            addCriterion("delay_cost is null");
            return (Criteria) this;
        }

        public Criteria andDelayCostIsNotNull() {
            addCriterion("delay_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDelayCostEqualTo(Double value) {
            addCriterion("delay_cost =", value, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostNotEqualTo(Double value) {
            addCriterion("delay_cost <>", value, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostGreaterThan(Double value) {
            addCriterion("delay_cost >", value, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostGreaterThanOrEqualTo(Double value) {
            addCriterion("delay_cost >=", value, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostLessThan(Double value) {
            addCriterion("delay_cost <", value, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostLessThanOrEqualTo(Double value) {
            addCriterion("delay_cost <=", value, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostIn(List<Double> values) {
            addCriterion("delay_cost in", values, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostNotIn(List<Double> values) {
            addCriterion("delay_cost not in", values, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostBetween(Double value1, Double value2) {
            addCriterion("delay_cost between", value1, value2, "delayCost");
            return (Criteria) this;
        }

        public Criteria andDelayCostNotBetween(Double value1, Double value2) {
            addCriterion("delay_cost not between", value1, value2, "delayCost");
            return (Criteria) this;
        }

        public Criteria andRewardWageIsNull() {
            addCriterion("reward_wage is null");
            return (Criteria) this;
        }

        public Criteria andRewardWageIsNotNull() {
            addCriterion("reward_wage is not null");
            return (Criteria) this;
        }

        public Criteria andRewardWageEqualTo(Double value) {
            addCriterion("reward_wage =", value, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageNotEqualTo(Double value) {
            addCriterion("reward_wage <>", value, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageGreaterThan(Double value) {
            addCriterion("reward_wage >", value, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageGreaterThanOrEqualTo(Double value) {
            addCriterion("reward_wage >=", value, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageLessThan(Double value) {
            addCriterion("reward_wage <", value, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageLessThanOrEqualTo(Double value) {
            addCriterion("reward_wage <=", value, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageIn(List<Double> values) {
            addCriterion("reward_wage in", values, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageNotIn(List<Double> values) {
            addCriterion("reward_wage not in", values, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageBetween(Double value1, Double value2) {
            addCriterion("reward_wage between", value1, value2, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andRewardWageNotBetween(Double value1, Double value2) {
            addCriterion("reward_wage not between", value1, value2, "rewardWage");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalIsNull() {
            addCriterion("other_one_total is null");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalIsNotNull() {
            addCriterion("other_one_total is not null");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalEqualTo(Double value) {
            addCriterion("other_one_total =", value, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalNotEqualTo(Double value) {
            addCriterion("other_one_total <>", value, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalGreaterThan(Double value) {
            addCriterion("other_one_total >", value, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("other_one_total >=", value, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalLessThan(Double value) {
            addCriterion("other_one_total <", value, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalLessThanOrEqualTo(Double value) {
            addCriterion("other_one_total <=", value, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalIn(List<Double> values) {
            addCriterion("other_one_total in", values, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalNotIn(List<Double> values) {
            addCriterion("other_one_total not in", values, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalBetween(Double value1, Double value2) {
            addCriterion("other_one_total between", value1, value2, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherOneTotalNotBetween(Double value1, Double value2) {
            addCriterion("other_one_total not between", value1, value2, "otherOneTotal");
            return (Criteria) this;
        }

        public Criteria andOtherWageIsNull() {
            addCriterion("other_wage is null");
            return (Criteria) this;
        }

        public Criteria andOtherWageIsNotNull() {
            addCriterion("other_wage is not null");
            return (Criteria) this;
        }

        public Criteria andOtherWageEqualTo(Double value) {
            addCriterion("other_wage =", value, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageNotEqualTo(Double value) {
            addCriterion("other_wage <>", value, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageGreaterThan(Double value) {
            addCriterion("other_wage >", value, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageGreaterThanOrEqualTo(Double value) {
            addCriterion("other_wage >=", value, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageLessThan(Double value) {
            addCriterion("other_wage <", value, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageLessThanOrEqualTo(Double value) {
            addCriterion("other_wage <=", value, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageIn(List<Double> values) {
            addCriterion("other_wage in", values, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageNotIn(List<Double> values) {
            addCriterion("other_wage not in", values, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageBetween(Double value1, Double value2) {
            addCriterion("other_wage between", value1, value2, "otherWage");
            return (Criteria) this;
        }

        public Criteria andOtherWageNotBetween(Double value1, Double value2) {
            addCriterion("other_wage not between", value1, value2, "otherWage");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalIsNull() {
            addCriterion("deserve_wage_total is null");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalIsNotNull() {
            addCriterion("deserve_wage_total is not null");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalEqualTo(Double value) {
            addCriterion("deserve_wage_total =", value, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalNotEqualTo(Double value) {
            addCriterion("deserve_wage_total <>", value, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalGreaterThan(Double value) {
            addCriterion("deserve_wage_total >", value, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("deserve_wage_total >=", value, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalLessThan(Double value) {
            addCriterion("deserve_wage_total <", value, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalLessThanOrEqualTo(Double value) {
            addCriterion("deserve_wage_total <=", value, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalIn(List<Double> values) {
            addCriterion("deserve_wage_total in", values, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalNotIn(List<Double> values) {
            addCriterion("deserve_wage_total not in", values, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalBetween(Double value1, Double value2) {
            addCriterion("deserve_wage_total between", value1, value2, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeserveWageTotalNotBetween(Double value1, Double value2) {
            addCriterion("deserve_wage_total not between", value1, value2, "deserveWageTotal");
            return (Criteria) this;
        }

        public Criteria andPensionWageIsNull() {
            addCriterion("pension_wage is null");
            return (Criteria) this;
        }

        public Criteria andPensionWageIsNotNull() {
            addCriterion("pension_wage is not null");
            return (Criteria) this;
        }

        public Criteria andPensionWageEqualTo(Double value) {
            addCriterion("pension_wage =", value, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageNotEqualTo(Double value) {
            addCriterion("pension_wage <>", value, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageGreaterThan(Double value) {
            addCriterion("pension_wage >", value, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageGreaterThanOrEqualTo(Double value) {
            addCriterion("pension_wage >=", value, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageLessThan(Double value) {
            addCriterion("pension_wage <", value, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageLessThanOrEqualTo(Double value) {
            addCriterion("pension_wage <=", value, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageIn(List<Double> values) {
            addCriterion("pension_wage in", values, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageNotIn(List<Double> values) {
            addCriterion("pension_wage not in", values, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageBetween(Double value1, Double value2) {
            addCriterion("pension_wage between", value1, value2, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andPensionWageNotBetween(Double value1, Double value2) {
            addCriterion("pension_wage not between", value1, value2, "pensionWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageIsNull() {
            addCriterion("unemployment_wage is null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageIsNotNull() {
            addCriterion("unemployment_wage is not null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageEqualTo(Double value) {
            addCriterion("unemployment_wage =", value, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageNotEqualTo(Double value) {
            addCriterion("unemployment_wage <>", value, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageGreaterThan(Double value) {
            addCriterion("unemployment_wage >", value, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageGreaterThanOrEqualTo(Double value) {
            addCriterion("unemployment_wage >=", value, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageLessThan(Double value) {
            addCriterion("unemployment_wage <", value, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageLessThanOrEqualTo(Double value) {
            addCriterion("unemployment_wage <=", value, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageIn(List<Double> values) {
            addCriterion("unemployment_wage in", values, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageNotIn(List<Double> values) {
            addCriterion("unemployment_wage not in", values, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageBetween(Double value1, Double value2) {
            addCriterion("unemployment_wage between", value1, value2, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andUnemploymentWageNotBetween(Double value1, Double value2) {
            addCriterion("unemployment_wage not between", value1, value2, "unemploymentWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageIsNull() {
            addCriterion("medical_wage is null");
            return (Criteria) this;
        }

        public Criteria andMedicalWageIsNotNull() {
            addCriterion("medical_wage is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalWageEqualTo(Double value) {
            addCriterion("medical_wage =", value, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageNotEqualTo(Double value) {
            addCriterion("medical_wage <>", value, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageGreaterThan(Double value) {
            addCriterion("medical_wage >", value, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageGreaterThanOrEqualTo(Double value) {
            addCriterion("medical_wage >=", value, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageLessThan(Double value) {
            addCriterion("medical_wage <", value, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageLessThanOrEqualTo(Double value) {
            addCriterion("medical_wage <=", value, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageIn(List<Double> values) {
            addCriterion("medical_wage in", values, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageNotIn(List<Double> values) {
            addCriterion("medical_wage not in", values, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageBetween(Double value1, Double value2) {
            addCriterion("medical_wage between", value1, value2, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMedicalWageNotBetween(Double value1, Double value2) {
            addCriterion("medical_wage not between", value1, value2, "medicalWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageIsNull() {
            addCriterion("major_illness_wage is null");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageIsNotNull() {
            addCriterion("major_illness_wage is not null");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageEqualTo(Double value) {
            addCriterion("major_illness_wage =", value, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageNotEqualTo(Double value) {
            addCriterion("major_illness_wage <>", value, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageGreaterThan(Double value) {
            addCriterion("major_illness_wage >", value, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageGreaterThanOrEqualTo(Double value) {
            addCriterion("major_illness_wage >=", value, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageLessThan(Double value) {
            addCriterion("major_illness_wage <", value, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageLessThanOrEqualTo(Double value) {
            addCriterion("major_illness_wage <=", value, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageIn(List<Double> values) {
            addCriterion("major_illness_wage in", values, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageNotIn(List<Double> values) {
            addCriterion("major_illness_wage not in", values, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageBetween(Double value1, Double value2) {
            addCriterion("major_illness_wage between", value1, value2, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andMajorIllnessWageNotBetween(Double value1, Double value2) {
            addCriterion("major_illness_wage not between", value1, value2, "majorIllnessWage");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalIsNull() {
            addCriterion("personal_social_security_wageTotal is null");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalIsNotNull() {
            addCriterion("personal_social_security_wageTotal is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalEqualTo(Double value) {
            addCriterion("personal_social_security_wageTotal =", value, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalNotEqualTo(Double value) {
            addCriterion("personal_social_security_wageTotal <>", value, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalGreaterThan(Double value) {
            addCriterion("personal_social_security_wageTotal >", value, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalGreaterThanOrEqualTo(Double value) {
            addCriterion("personal_social_security_wageTotal >=", value, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalLessThan(Double value) {
            addCriterion("personal_social_security_wageTotal <", value, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalLessThanOrEqualTo(Double value) {
            addCriterion("personal_social_security_wageTotal <=", value, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalIn(List<Double> values) {
            addCriterion("personal_social_security_wageTotal in", values, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalNotIn(List<Double> values) {
            addCriterion("personal_social_security_wageTotal not in", values, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalBetween(Double value1, Double value2) {
            addCriterion("personal_social_security_wageTotal between", value1, value2, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityWagetotalNotBetween(Double value1, Double value2) {
            addCriterion("personal_social_security_wageTotal not between", value1, value2, "personalSocialSecurityWagetotal");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageIsNull() {
            addCriterion("unit_society_wage is null");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageIsNotNull() {
            addCriterion("unit_society_wage is not null");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageEqualTo(Double value) {
            addCriterion("unit_society_wage =", value, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageNotEqualTo(Double value) {
            addCriterion("unit_society_wage <>", value, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageGreaterThan(Double value) {
            addCriterion("unit_society_wage >", value, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageGreaterThanOrEqualTo(Double value) {
            addCriterion("unit_society_wage >=", value, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageLessThan(Double value) {
            addCriterion("unit_society_wage <", value, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageLessThanOrEqualTo(Double value) {
            addCriterion("unit_society_wage <=", value, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageIn(List<Double> values) {
            addCriterion("unit_society_wage in", values, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageNotIn(List<Double> values) {
            addCriterion("unit_society_wage not in", values, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageBetween(Double value1, Double value2) {
            addCriterion("unit_society_wage between", value1, value2, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andUnitSocietyWageNotBetween(Double value1, Double value2) {
            addCriterion("unit_society_wage not between", value1, value2, "unitSocietyWage");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIsNull() {
            addCriterion("provident_fund is null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIsNotNull() {
            addCriterion("provident_fund is not null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundEqualTo(Double value) {
            addCriterion("provident_fund =", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotEqualTo(Double value) {
            addCriterion("provident_fund <>", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundGreaterThan(Double value) {
            addCriterion("provident_fund >", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundGreaterThanOrEqualTo(Double value) {
            addCriterion("provident_fund >=", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundLessThan(Double value) {
            addCriterion("provident_fund <", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundLessThanOrEqualTo(Double value) {
            addCriterion("provident_fund <=", value, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundIn(List<Double> values) {
            addCriterion("provident_fund in", values, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotIn(List<Double> values) {
            addCriterion("provident_fund not in", values, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundBetween(Double value1, Double value2) {
            addCriterion("provident_fund between", value1, value2, "providentFund");
            return (Criteria) this;
        }

        public Criteria andProvidentFundNotBetween(Double value1, Double value2) {
            addCriterion("provident_fund not between", value1, value2, "providentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundIsNull() {
            addCriterion("unit_provident_fund is null");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundIsNotNull() {
            addCriterion("unit_provident_fund is not null");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundEqualTo(Double value) {
            addCriterion("unit_provident_fund =", value, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundNotEqualTo(Double value) {
            addCriterion("unit_provident_fund <>", value, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundGreaterThan(Double value) {
            addCriterion("unit_provident_fund >", value, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundGreaterThanOrEqualTo(Double value) {
            addCriterion("unit_provident_fund >=", value, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundLessThan(Double value) {
            addCriterion("unit_provident_fund <", value, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundLessThanOrEqualTo(Double value) {
            addCriterion("unit_provident_fund <=", value, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundIn(List<Double> values) {
            addCriterion("unit_provident_fund in", values, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundNotIn(List<Double> values) {
            addCriterion("unit_provident_fund not in", values, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundBetween(Double value1, Double value2) {
            addCriterion("unit_provident_fund between", value1, value2, "unitProvidentFund");
            return (Criteria) this;
        }

        public Criteria andUnitProvidentFundNotBetween(Double value1, Double value2) {
            addCriterion("unit_provident_fund not between", value1, value2, "unitProvidentFund");
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

        public Criteria andMealFeeIsNull() {
            addCriterion("meal_fee is null");
            return (Criteria) this;
        }

        public Criteria andMealFeeIsNotNull() {
            addCriterion("meal_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMealFeeEqualTo(Double value) {
            addCriterion("meal_fee =", value, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeNotEqualTo(Double value) {
            addCriterion("meal_fee <>", value, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeGreaterThan(Double value) {
            addCriterion("meal_fee >", value, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("meal_fee >=", value, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeLessThan(Double value) {
            addCriterion("meal_fee <", value, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeLessThanOrEqualTo(Double value) {
            addCriterion("meal_fee <=", value, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeIn(List<Double> values) {
            addCriterion("meal_fee in", values, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeNotIn(List<Double> values) {
            addCriterion("meal_fee not in", values, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeBetween(Double value1, Double value2) {
            addCriterion("meal_fee between", value1, value2, "mealFee");
            return (Criteria) this;
        }

        public Criteria andMealFeeNotBetween(Double value1, Double value2) {
            addCriterion("meal_fee not between", value1, value2, "mealFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeIsNull() {
            addCriterion("leave_fee is null");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeIsNotNull() {
            addCriterion("leave_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeEqualTo(Double value) {
            addCriterion("leave_fee =", value, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeNotEqualTo(Double value) {
            addCriterion("leave_fee <>", value, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeGreaterThan(Double value) {
            addCriterion("leave_fee >", value, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("leave_fee >=", value, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeLessThan(Double value) {
            addCriterion("leave_fee <", value, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeLessThanOrEqualTo(Double value) {
            addCriterion("leave_fee <=", value, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeIn(List<Double> values) {
            addCriterion("leave_fee in", values, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeNotIn(List<Double> values) {
            addCriterion("leave_fee not in", values, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeBetween(Double value1, Double value2) {
            addCriterion("leave_fee between", value1, value2, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andLeaveFeeNotBetween(Double value1, Double value2) {
            addCriterion("leave_fee not between", value1, value2, "leaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeIsNull() {
            addCriterion("sick_leave_fee is null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeIsNotNull() {
            addCriterion("sick_leave_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeEqualTo(Double value) {
            addCriterion("sick_leave_fee =", value, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeNotEqualTo(Double value) {
            addCriterion("sick_leave_fee <>", value, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeGreaterThan(Double value) {
            addCriterion("sick_leave_fee >", value, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("sick_leave_fee >=", value, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeLessThan(Double value) {
            addCriterion("sick_leave_fee <", value, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeLessThanOrEqualTo(Double value) {
            addCriterion("sick_leave_fee <=", value, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeIn(List<Double> values) {
            addCriterion("sick_leave_fee in", values, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeNotIn(List<Double> values) {
            addCriterion("sick_leave_fee not in", values, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeBetween(Double value1, Double value2) {
            addCriterion("sick_leave_fee between", value1, value2, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andSickLeaveFeeNotBetween(Double value1, Double value2) {
            addCriterion("sick_leave_fee not between", value1, value2, "sickLeaveFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeIsNull() {
            addCriterion("penalty_fee is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeIsNotNull() {
            addCriterion("penalty_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeEqualTo(Double value) {
            addCriterion("penalty_fee =", value, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeNotEqualTo(Double value) {
            addCriterion("penalty_fee <>", value, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeGreaterThan(Double value) {
            addCriterion("penalty_fee >", value, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("penalty_fee >=", value, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeLessThan(Double value) {
            addCriterion("penalty_fee <", value, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeLessThanOrEqualTo(Double value) {
            addCriterion("penalty_fee <=", value, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeIn(List<Double> values) {
            addCriterion("penalty_fee in", values, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeNotIn(List<Double> values) {
            addCriterion("penalty_fee not in", values, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeBetween(Double value1, Double value2) {
            addCriterion("penalty_fee between", value1, value2, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andPenaltyFeeNotBetween(Double value1, Double value2) {
            addCriterion("penalty_fee not between", value1, value2, "penaltyFee");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalIsNull() {
            addCriterion("deduction_one_wage_total is null");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalIsNotNull() {
            addCriterion("deduction_one_wage_total is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalEqualTo(Double value) {
            addCriterion("deduction_one_wage_total =", value, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalNotEqualTo(Double value) {
            addCriterion("deduction_one_wage_total <>", value, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalGreaterThan(Double value) {
            addCriterion("deduction_one_wage_total >", value, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("deduction_one_wage_total >=", value, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalLessThan(Double value) {
            addCriterion("deduction_one_wage_total <", value, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalLessThanOrEqualTo(Double value) {
            addCriterion("deduction_one_wage_total <=", value, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalIn(List<Double> values) {
            addCriterion("deduction_one_wage_total in", values, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalNotIn(List<Double> values) {
            addCriterion("deduction_one_wage_total not in", values, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalBetween(Double value1, Double value2) {
            addCriterion("deduction_one_wage_total between", value1, value2, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneWageTotalNotBetween(Double value1, Double value2) {
            addCriterion("deduction_one_wage_total not between", value1, value2, "deductionOneWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionOneIsNull() {
            addCriterion("deduction_one is null");
            return (Criteria) this;
        }

        public Criteria andDeductionOneIsNotNull() {
            addCriterion("deduction_one is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionOneEqualTo(Double value) {
            addCriterion("deduction_one =", value, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneNotEqualTo(Double value) {
            addCriterion("deduction_one <>", value, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneGreaterThan(Double value) {
            addCriterion("deduction_one >", value, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneGreaterThanOrEqualTo(Double value) {
            addCriterion("deduction_one >=", value, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneLessThan(Double value) {
            addCriterion("deduction_one <", value, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneLessThanOrEqualTo(Double value) {
            addCriterion("deduction_one <=", value, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneIn(List<Double> values) {
            addCriterion("deduction_one in", values, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneNotIn(List<Double> values) {
            addCriterion("deduction_one not in", values, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneBetween(Double value1, Double value2) {
            addCriterion("deduction_one between", value1, value2, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionOneNotBetween(Double value1, Double value2) {
            addCriterion("deduction_one not between", value1, value2, "deductionOne");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoIsNull() {
            addCriterion("deduction_two is null");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoIsNotNull() {
            addCriterion("deduction_two is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoEqualTo(Double value) {
            addCriterion("deduction_two =", value, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoNotEqualTo(Double value) {
            addCriterion("deduction_two <>", value, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoGreaterThan(Double value) {
            addCriterion("deduction_two >", value, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("deduction_two >=", value, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoLessThan(Double value) {
            addCriterion("deduction_two <", value, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoLessThanOrEqualTo(Double value) {
            addCriterion("deduction_two <=", value, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoIn(List<Double> values) {
            addCriterion("deduction_two in", values, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoNotIn(List<Double> values) {
            addCriterion("deduction_two not in", values, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoBetween(Double value1, Double value2) {
            addCriterion("deduction_two between", value1, value2, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoNotBetween(Double value1, Double value2) {
            addCriterion("deduction_two not between", value1, value2, "deductionTwo");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalIsNull() {
            addCriterion("deduction_two_wage_total is null");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalIsNotNull() {
            addCriterion("deduction_two_wage_total is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalEqualTo(Double value) {
            addCriterion("deduction_two_wage_total =", value, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalNotEqualTo(Double value) {
            addCriterion("deduction_two_wage_total <>", value, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalGreaterThan(Double value) {
            addCriterion("deduction_two_wage_total >", value, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("deduction_two_wage_total >=", value, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalLessThan(Double value) {
            addCriterion("deduction_two_wage_total <", value, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalLessThanOrEqualTo(Double value) {
            addCriterion("deduction_two_wage_total <=", value, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalIn(List<Double> values) {
            addCriterion("deduction_two_wage_total in", values, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalNotIn(List<Double> values) {
            addCriterion("deduction_two_wage_total not in", values, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalBetween(Double value1, Double value2) {
            addCriterion("deduction_two_wage_total between", value1, value2, "deductionTwoWageTotal");
            return (Criteria) this;
        }

        public Criteria andDeductionTwoWageTotalNotBetween(Double value1, Double value2) {
            addCriterion("deduction_two_wage_total not between", value1, value2, "deductionTwoWageTotal");
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

        public Criteria andDepositPersonalAccountIsNull() {
            addCriterion("deposit_personal_account is null");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountIsNotNull() {
            addCriterion("deposit_personal_account is not null");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountEqualTo(Double value) {
            addCriterion("deposit_personal_account =", value, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountNotEqualTo(Double value) {
            addCriterion("deposit_personal_account <>", value, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountGreaterThan(Double value) {
            addCriterion("deposit_personal_account >", value, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountGreaterThanOrEqualTo(Double value) {
            addCriterion("deposit_personal_account >=", value, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountLessThan(Double value) {
            addCriterion("deposit_personal_account <", value, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountLessThanOrEqualTo(Double value) {
            addCriterion("deposit_personal_account <=", value, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountIn(List<Double> values) {
            addCriterion("deposit_personal_account in", values, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountNotIn(List<Double> values) {
            addCriterion("deposit_personal_account not in", values, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountBetween(Double value1, Double value2) {
            addCriterion("deposit_personal_account between", value1, value2, "depositPersonalAccount");
            return (Criteria) this;
        }

        public Criteria andDepositPersonalAccountNotBetween(Double value1, Double value2) {
            addCriterion("deposit_personal_account not between", value1, value2, "depositPersonalAccount");
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