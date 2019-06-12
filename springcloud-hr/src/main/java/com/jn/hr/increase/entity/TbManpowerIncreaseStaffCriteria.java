package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerIncreaseStaffCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerIncreaseStaffCriteria() {
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

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(String value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(String value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(String value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(String value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(String value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLike(String value) {
            addCriterion("plan_type like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotLike(String value) {
            addCriterion("plan_type not like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<String> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<String> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(String value1, String value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(String value1, String value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
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

        public Criteria andInsuredCityIdIsNull() {
            addCriterion("insured_city_id is null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdIsNotNull() {
            addCriterion("insured_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdEqualTo(String value) {
            addCriterion("insured_city_id =", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotEqualTo(String value) {
            addCriterion("insured_city_id <>", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdGreaterThan(String value) {
            addCriterion("insured_city_id >", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("insured_city_id >=", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdLessThan(String value) {
            addCriterion("insured_city_id <", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdLessThanOrEqualTo(String value) {
            addCriterion("insured_city_id <=", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdLike(String value) {
            addCriterion("insured_city_id like", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotLike(String value) {
            addCriterion("insured_city_id not like", value, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdIn(List<String> values) {
            addCriterion("insured_city_id in", values, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotIn(List<String> values) {
            addCriterion("insured_city_id not in", values, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdBetween(String value1, String value2) {
            addCriterion("insured_city_id between", value1, value2, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityIdNotBetween(String value1, String value2) {
            addCriterion("insured_city_id not between", value1, value2, "insuredCityId");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameIsNull() {
            addCriterion("insured_city_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameIsNotNull() {
            addCriterion("insured_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameEqualTo(String value) {
            addCriterion("insured_city_name =", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotEqualTo(String value) {
            addCriterion("insured_city_name <>", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameGreaterThan(String value) {
            addCriterion("insured_city_name >", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_city_name >=", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameLessThan(String value) {
            addCriterion("insured_city_name <", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameLessThanOrEqualTo(String value) {
            addCriterion("insured_city_name <=", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameLike(String value) {
            addCriterion("insured_city_name like", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotLike(String value) {
            addCriterion("insured_city_name not like", value, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameIn(List<String> values) {
            addCriterion("insured_city_name in", values, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotIn(List<String> values) {
            addCriterion("insured_city_name not in", values, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameBetween(String value1, String value2) {
            addCriterion("insured_city_name between", value1, value2, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredCityNameNotBetween(String value1, String value2) {
            addCriterion("insured_city_name not between", value1, value2, "insuredCityName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdIsNull() {
            addCriterion("insured_programme_id is null");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdIsNotNull() {
            addCriterion("insured_programme_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdEqualTo(String value) {
            addCriterion("insured_programme_id =", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdNotEqualTo(String value) {
            addCriterion("insured_programme_id <>", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdGreaterThan(String value) {
            addCriterion("insured_programme_id >", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdGreaterThanOrEqualTo(String value) {
            addCriterion("insured_programme_id >=", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdLessThan(String value) {
            addCriterion("insured_programme_id <", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdLessThanOrEqualTo(String value) {
            addCriterion("insured_programme_id <=", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdLike(String value) {
            addCriterion("insured_programme_id like", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdNotLike(String value) {
            addCriterion("insured_programme_id not like", value, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdIn(List<String> values) {
            addCriterion("insured_programme_id in", values, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdNotIn(List<String> values) {
            addCriterion("insured_programme_id not in", values, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdBetween(String value1, String value2) {
            addCriterion("insured_programme_id between", value1, value2, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeIdNotBetween(String value1, String value2) {
            addCriterion("insured_programme_id not between", value1, value2, "insuredProgrammeId");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameIsNull() {
            addCriterion("insured_programme_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameIsNotNull() {
            addCriterion("insured_programme_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameEqualTo(String value) {
            addCriterion("insured_programme_name =", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameNotEqualTo(String value) {
            addCriterion("insured_programme_name <>", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameGreaterThan(String value) {
            addCriterion("insured_programme_name >", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_programme_name >=", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameLessThan(String value) {
            addCriterion("insured_programme_name <", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameLessThanOrEqualTo(String value) {
            addCriterion("insured_programme_name <=", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameLike(String value) {
            addCriterion("insured_programme_name like", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameNotLike(String value) {
            addCriterion("insured_programme_name not like", value, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameIn(List<String> values) {
            addCriterion("insured_programme_name in", values, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameNotIn(List<String> values) {
            addCriterion("insured_programme_name not in", values, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameBetween(String value1, String value2) {
            addCriterion("insured_programme_name between", value1, value2, "insuredProgrammeName");
            return (Criteria) this;
        }

        public Criteria andInsuredProgrammeNameNotBetween(String value1, String value2) {
            addCriterion("insured_programme_name not between", value1, value2, "insuredProgrammeName");
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