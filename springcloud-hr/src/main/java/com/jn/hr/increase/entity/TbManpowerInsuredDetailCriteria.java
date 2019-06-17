package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerInsuredDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerInsuredDetailCriteria() {
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

        public Criteria andCreatDateIsNull() {
            addCriterion("creat_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNotNull() {
            addCriterion("creat_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatDateEqualTo(String value) {
            addCriterion("creat_date =", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotEqualTo(String value) {
            addCriterion("creat_date <>", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThan(String value) {
            addCriterion("creat_date >", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThanOrEqualTo(String value) {
            addCriterion("creat_date >=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThan(String value) {
            addCriterion("creat_date <", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThanOrEqualTo(String value) {
            addCriterion("creat_date <=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLike(String value) {
            addCriterion("creat_date like", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotLike(String value) {
            addCriterion("creat_date not like", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateIn(List<String> values) {
            addCriterion("creat_date in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotIn(List<String> values) {
            addCriterion("creat_date not in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateBetween(String value1, String value2) {
            addCriterion("creat_date between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotBetween(String value1, String value2) {
            addCriterion("creat_date not between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthIsNull() {
            addCriterion("insured_month is null");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthIsNotNull() {
            addCriterion("insured_month is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthEqualTo(String value) {
            addCriterion("insured_month =", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotEqualTo(String value) {
            addCriterion("insured_month <>", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthGreaterThan(String value) {
            addCriterion("insured_month >", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthGreaterThanOrEqualTo(String value) {
            addCriterion("insured_month >=", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthLessThan(String value) {
            addCriterion("insured_month <", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthLessThanOrEqualTo(String value) {
            addCriterion("insured_month <=", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthLike(String value) {
            addCriterion("insured_month like", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotLike(String value) {
            addCriterion("insured_month not like", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthIn(List<String> values) {
            addCriterion("insured_month in", values, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotIn(List<String> values) {
            addCriterion("insured_month not in", values, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthBetween(String value1, String value2) {
            addCriterion("insured_month between", value1, value2, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotBetween(String value1, String value2) {
            addCriterion("insured_month not between", value1, value2, "insuredMonth");
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

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("city_id like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("city_id not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityIsNull() {
            addCriterion("personal_social_security is null");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityIsNotNull() {
            addCriterion("personal_social_security is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityEqualTo(Double value) {
            addCriterion("personal_social_security =", value, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityNotEqualTo(Double value) {
            addCriterion("personal_social_security <>", value, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityGreaterThan(Double value) {
            addCriterion("personal_social_security >", value, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityGreaterThanOrEqualTo(Double value) {
            addCriterion("personal_social_security >=", value, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityLessThan(Double value) {
            addCriterion("personal_social_security <", value, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityLessThanOrEqualTo(Double value) {
            addCriterion("personal_social_security <=", value, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityIn(List<Double> values) {
            addCriterion("personal_social_security in", values, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityNotIn(List<Double> values) {
            addCriterion("personal_social_security not in", values, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityBetween(Double value1, Double value2) {
            addCriterion("personal_social_security between", value1, value2, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalSocialSecurityNotBetween(Double value1, Double value2) {
            addCriterion("personal_social_security not between", value1, value2, "personalSocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityIsNull() {
            addCriterion("company_social_security is null");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityIsNotNull() {
            addCriterion("company_social_security is not null");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityEqualTo(Double value) {
            addCriterion("company_social_security =", value, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityNotEqualTo(Double value) {
            addCriterion("company_social_security <>", value, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityGreaterThan(Double value) {
            addCriterion("company_social_security >", value, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityGreaterThanOrEqualTo(Double value) {
            addCriterion("company_social_security >=", value, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityLessThan(Double value) {
            addCriterion("company_social_security <", value, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityLessThanOrEqualTo(Double value) {
            addCriterion("company_social_security <=", value, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityIn(List<Double> values) {
            addCriterion("company_social_security in", values, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityNotIn(List<Double> values) {
            addCriterion("company_social_security not in", values, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityBetween(Double value1, Double value2) {
            addCriterion("company_social_security between", value1, value2, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andCompanySocialSecurityNotBetween(Double value1, Double value2) {
            addCriterion("company_social_security not between", value1, value2, "companySocialSecurity");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundIsNull() {
            addCriterion("personal_accumulation_fund is null");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundIsNotNull() {
            addCriterion("personal_accumulation_fund is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundEqualTo(Double value) {
            addCriterion("personal_accumulation_fund =", value, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundNotEqualTo(Double value) {
            addCriterion("personal_accumulation_fund <>", value, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundGreaterThan(Double value) {
            addCriterion("personal_accumulation_fund >", value, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundGreaterThanOrEqualTo(Double value) {
            addCriterion("personal_accumulation_fund >=", value, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundLessThan(Double value) {
            addCriterion("personal_accumulation_fund <", value, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundLessThanOrEqualTo(Double value) {
            addCriterion("personal_accumulation_fund <=", value, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundIn(List<Double> values) {
            addCriterion("personal_accumulation_fund in", values, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundNotIn(List<Double> values) {
            addCriterion("personal_accumulation_fund not in", values, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundBetween(Double value1, Double value2) {
            addCriterion("personal_accumulation_fund between", value1, value2, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andPersonalAccumulationFundNotBetween(Double value1, Double value2) {
            addCriterion("personal_accumulation_fund not between", value1, value2, "personalAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundIsNull() {
            addCriterion("company_accumulation_fund is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundIsNotNull() {
            addCriterion("company_accumulation_fund is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundEqualTo(Double value) {
            addCriterion("company_accumulation_fund =", value, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundNotEqualTo(Double value) {
            addCriterion("company_accumulation_fund <>", value, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundGreaterThan(Double value) {
            addCriterion("company_accumulation_fund >", value, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundGreaterThanOrEqualTo(Double value) {
            addCriterion("company_accumulation_fund >=", value, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundLessThan(Double value) {
            addCriterion("company_accumulation_fund <", value, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundLessThanOrEqualTo(Double value) {
            addCriterion("company_accumulation_fund <=", value, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundIn(List<Double> values) {
            addCriterion("company_accumulation_fund in", values, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundNotIn(List<Double> values) {
            addCriterion("company_accumulation_fund not in", values, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundBetween(Double value1, Double value2) {
            addCriterion("company_accumulation_fund between", value1, value2, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andCompanyAccumulationFundNotBetween(Double value1, Double value2) {
            addCriterion("company_accumulation_fund not between", value1, value2, "companyAccumulationFund");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIsNull() {
            addCriterion("scheme_id is null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIsNotNull() {
            addCriterion("scheme_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeIdEqualTo(String value) {
            addCriterion("scheme_id =", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotEqualTo(String value) {
            addCriterion("scheme_id <>", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThan(String value) {
            addCriterion("scheme_id >", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdGreaterThanOrEqualTo(String value) {
            addCriterion("scheme_id >=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThan(String value) {
            addCriterion("scheme_id <", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLessThanOrEqualTo(String value) {
            addCriterion("scheme_id <=", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdLike(String value) {
            addCriterion("scheme_id like", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotLike(String value) {
            addCriterion("scheme_id not like", value, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdIn(List<String> values) {
            addCriterion("scheme_id in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotIn(List<String> values) {
            addCriterion("scheme_id not in", values, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdBetween(String value1, String value2) {
            addCriterion("scheme_id between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andSchemeIdNotBetween(String value1, String value2) {
            addCriterion("scheme_id not between", value1, value2, "schemeId");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveIsNull() {
            addCriterion("is_effective is null");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveIsNotNull() {
            addCriterion("is_effective is not null");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveEqualTo(Byte value) {
            addCriterion("is_effective =", value, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveNotEqualTo(Byte value) {
            addCriterion("is_effective <>", value, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveGreaterThan(Byte value) {
            addCriterion("is_effective >", value, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_effective >=", value, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveLessThan(Byte value) {
            addCriterion("is_effective <", value, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveLessThanOrEqualTo(Byte value) {
            addCriterion("is_effective <=", value, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveIn(List<Byte> values) {
            addCriterion("is_effective in", values, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveNotIn(List<Byte> values) {
            addCriterion("is_effective not in", values, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveBetween(Byte value1, Byte value2) {
            addCriterion("is_effective between", value1, value2, "isEffective");
            return (Criteria) this;
        }

        public Criteria andIsEffectiveNotBetween(Byte value1, Byte value2) {
            addCriterion("is_effective not between", value1, value2, "isEffective");
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