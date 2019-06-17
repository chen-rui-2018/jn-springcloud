package com.jn.hr.employee.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerMobilizationManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerMobilizationManagementCriteria() {
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
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id_ not between", value1, value2, "id");
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

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNull() {
            addCriterion("rank_name is null");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNotNull() {
            addCriterion("rank_name is not null");
            return (Criteria) this;
        }

        public Criteria andRankNameEqualTo(String value) {
            addCriterion("rank_name =", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotEqualTo(String value) {
            addCriterion("rank_name <>", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThan(String value) {
            addCriterion("rank_name >", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThanOrEqualTo(String value) {
            addCriterion("rank_name >=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThan(String value) {
            addCriterion("rank_name <", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThanOrEqualTo(String value) {
            addCriterion("rank_name <=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLike(String value) {
            addCriterion("rank_name like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotLike(String value) {
            addCriterion("rank_name not like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameIn(List<String> values) {
            addCriterion("rank_name in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotIn(List<String> values) {
            addCriterion("rank_name not in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameBetween(String value1, String value2) {
            addCriterion("rank_name between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotBetween(String value1, String value2) {
            addCriterion("rank_name not between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(Double value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(Double value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(Double value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(Double value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(Double value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(Double value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<Double> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<Double> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(Double value1, Double value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(Double value1, Double value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNull() {
            addCriterion("contact_number is null");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNotNull() {
            addCriterion("contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualTo(String value) {
            addCriterion("contact_number =", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualTo(String value) {
            addCriterion("contact_number <>", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThan(String value) {
            addCriterion("contact_number >", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contact_number >=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThan(String value) {
            addCriterion("contact_number <", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualTo(String value) {
            addCriterion("contact_number <=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLike(String value) {
            addCriterion("contact_number like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotLike(String value) {
            addCriterion("contact_number not like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberIn(List<String> values) {
            addCriterion("contact_number in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotIn(List<String> values) {
            addCriterion("contact_number not in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberBetween(String value1, String value2) {
            addCriterion("contact_number between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotBetween(String value1, String value2) {
            addCriterion("contact_number not between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderIsNull() {
            addCriterion("directly_leader is null");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderIsNotNull() {
            addCriterion("directly_leader is not null");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderEqualTo(String value) {
            addCriterion("directly_leader =", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderNotEqualTo(String value) {
            addCriterion("directly_leader <>", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderGreaterThan(String value) {
            addCriterion("directly_leader >", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("directly_leader >=", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderLessThan(String value) {
            addCriterion("directly_leader <", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderLessThanOrEqualTo(String value) {
            addCriterion("directly_leader <=", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderLike(String value) {
            addCriterion("directly_leader like", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderNotLike(String value) {
            addCriterion("directly_leader not like", value, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderIn(List<String> values) {
            addCriterion("directly_leader in", values, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderNotIn(List<String> values) {
            addCriterion("directly_leader not in", values, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderBetween(String value1, String value2) {
            addCriterion("directly_leader between", value1, value2, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andDirectlyLeaderNotBetween(String value1, String value2) {
            addCriterion("directly_leader not between", value1, value2, "directlyLeader");
            return (Criteria) this;
        }

        public Criteria andEnclosureIsNull() {
            addCriterion("enclosure is null");
            return (Criteria) this;
        }

        public Criteria andEnclosureIsNotNull() {
            addCriterion("enclosure is not null");
            return (Criteria) this;
        }

        public Criteria andEnclosureEqualTo(String value) {
            addCriterion("enclosure =", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotEqualTo(String value) {
            addCriterion("enclosure <>", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureGreaterThan(String value) {
            addCriterion("enclosure >", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureGreaterThanOrEqualTo(String value) {
            addCriterion("enclosure >=", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLessThan(String value) {
            addCriterion("enclosure <", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLessThanOrEqualTo(String value) {
            addCriterion("enclosure <=", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureLike(String value) {
            addCriterion("enclosure like", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotLike(String value) {
            addCriterion("enclosure not like", value, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureIn(List<String> values) {
            addCriterion("enclosure in", values, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotIn(List<String> values) {
            addCriterion("enclosure not in", values, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureBetween(String value1, String value2) {
            addCriterion("enclosure between", value1, value2, "enclosure");
            return (Criteria) this;
        }

        public Criteria andEnclosureNotBetween(String value1, String value2) {
            addCriterion("enclosure not between", value1, value2, "enclosure");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIsNull() {
            addCriterion("application_reason is null");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIsNotNull() {
            addCriterion("application_reason is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonEqualTo(String value) {
            addCriterion("application_reason =", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotEqualTo(String value) {
            addCriterion("application_reason <>", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonGreaterThan(String value) {
            addCriterion("application_reason >", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonGreaterThanOrEqualTo(String value) {
            addCriterion("application_reason >=", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLessThan(String value) {
            addCriterion("application_reason <", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLessThanOrEqualTo(String value) {
            addCriterion("application_reason <=", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLike(String value) {
            addCriterion("application_reason like", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotLike(String value) {
            addCriterion("application_reason not like", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIn(List<String> values) {
            addCriterion("application_reason in", values, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotIn(List<String> values) {
            addCriterion("application_reason not in", values, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonBetween(String value1, String value2) {
            addCriterion("application_reason between", value1, value2, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotBetween(String value1, String value2) {
            addCriterion("application_reason not between", value1, value2, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateIsNull() {
            addCriterion("take_effect_date is null");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateIsNotNull() {
            addCriterion("take_effect_date is not null");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateEqualTo(Date value) {
            addCriterion("take_effect_date =", value, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateNotEqualTo(Date value) {
            addCriterion("take_effect_date <>", value, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateGreaterThan(Date value) {
            addCriterion("take_effect_date >", value, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateGreaterThanOrEqualTo(Date value) {
            addCriterion("take_effect_date >=", value, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateLessThan(Date value) {
            addCriterion("take_effect_date <", value, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateLessThanOrEqualTo(Date value) {
            addCriterion("take_effect_date <=", value, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateIn(List<Date> values) {
            addCriterion("take_effect_date in", values, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateNotIn(List<Date> values) {
            addCriterion("take_effect_date not in", values, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateBetween(Date value1, Date value2) {
            addCriterion("take_effect_date between", value1, value2, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andTakeEffectDateNotBetween(Date value1, Date value2) {
            addCriterion("take_effect_date not between", value1, value2, "takeEffectDate");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentIsNull() {
            addCriterion("new_department is null");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentIsNotNull() {
            addCriterion("new_department is not null");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentEqualTo(String value) {
            addCriterion("new_department =", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentNotEqualTo(String value) {
            addCriterion("new_department <>", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentGreaterThan(String value) {
            addCriterion("new_department >", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("new_department >=", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentLessThan(String value) {
            addCriterion("new_department <", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentLessThanOrEqualTo(String value) {
            addCriterion("new_department <=", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentLike(String value) {
            addCriterion("new_department like", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentNotLike(String value) {
            addCriterion("new_department not like", value, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentIn(List<String> values) {
            addCriterion("new_department in", values, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentNotIn(List<String> values) {
            addCriterion("new_department not in", values, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentBetween(String value1, String value2) {
            addCriterion("new_department between", value1, value2, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewDepartmentNotBetween(String value1, String value2) {
            addCriterion("new_department not between", value1, value2, "newDepartment");
            return (Criteria) this;
        }

        public Criteria andNewJobNameIsNull() {
            addCriterion("new_job_name is null");
            return (Criteria) this;
        }

        public Criteria andNewJobNameIsNotNull() {
            addCriterion("new_job_name is not null");
            return (Criteria) this;
        }

        public Criteria andNewJobNameEqualTo(String value) {
            addCriterion("new_job_name =", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameNotEqualTo(String value) {
            addCriterion("new_job_name <>", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameGreaterThan(String value) {
            addCriterion("new_job_name >", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("new_job_name >=", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameLessThan(String value) {
            addCriterion("new_job_name <", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameLessThanOrEqualTo(String value) {
            addCriterion("new_job_name <=", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameLike(String value) {
            addCriterion("new_job_name like", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameNotLike(String value) {
            addCriterion("new_job_name not like", value, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameIn(List<String> values) {
            addCriterion("new_job_name in", values, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameNotIn(List<String> values) {
            addCriterion("new_job_name not in", values, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameBetween(String value1, String value2) {
            addCriterion("new_job_name between", value1, value2, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewJobNameNotBetween(String value1, String value2) {
            addCriterion("new_job_name not between", value1, value2, "newJobName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameIsNull() {
            addCriterion("new_rank_name is null");
            return (Criteria) this;
        }

        public Criteria andNewRankNameIsNotNull() {
            addCriterion("new_rank_name is not null");
            return (Criteria) this;
        }

        public Criteria andNewRankNameEqualTo(String value) {
            addCriterion("new_rank_name =", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameNotEqualTo(String value) {
            addCriterion("new_rank_name <>", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameGreaterThan(String value) {
            addCriterion("new_rank_name >", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameGreaterThanOrEqualTo(String value) {
            addCriterion("new_rank_name >=", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameLessThan(String value) {
            addCriterion("new_rank_name <", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameLessThanOrEqualTo(String value) {
            addCriterion("new_rank_name <=", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameLike(String value) {
            addCriterion("new_rank_name like", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameNotLike(String value) {
            addCriterion("new_rank_name not like", value, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameIn(List<String> values) {
            addCriterion("new_rank_name in", values, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameNotIn(List<String> values) {
            addCriterion("new_rank_name not in", values, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameBetween(String value1, String value2) {
            addCriterion("new_rank_name between", value1, value2, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewRankNameNotBetween(String value1, String value2) {
            addCriterion("new_rank_name not between", value1, value2, "newRankName");
            return (Criteria) this;
        }

        public Criteria andNewSalaryIsNull() {
            addCriterion("new_salary is null");
            return (Criteria) this;
        }

        public Criteria andNewSalaryIsNotNull() {
            addCriterion("new_salary is not null");
            return (Criteria) this;
        }

        public Criteria andNewSalaryEqualTo(BigDecimal value) {
            addCriterion("new_salary =", value, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryNotEqualTo(BigDecimal value) {
            addCriterion("new_salary <>", value, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryGreaterThan(BigDecimal value) {
            addCriterion("new_salary >", value, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("new_salary >=", value, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryLessThan(BigDecimal value) {
            addCriterion("new_salary <", value, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("new_salary <=", value, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryIn(List<BigDecimal> values) {
            addCriterion("new_salary in", values, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryNotIn(List<BigDecimal> values) {
            addCriterion("new_salary not in", values, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_salary between", value1, value2, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_salary not between", value1, value2, "newSalary");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberIsNull() {
            addCriterion("new_contact_number is null");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberIsNotNull() {
            addCriterion("new_contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberEqualTo(String value) {
            addCriterion("new_contact_number =", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberNotEqualTo(String value) {
            addCriterion("new_contact_number <>", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberGreaterThan(String value) {
            addCriterion("new_contact_number >", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("new_contact_number >=", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberLessThan(String value) {
            addCriterion("new_contact_number <", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberLessThanOrEqualTo(String value) {
            addCriterion("new_contact_number <=", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberLike(String value) {
            addCriterion("new_contact_number like", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberNotLike(String value) {
            addCriterion("new_contact_number not like", value, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberIn(List<String> values) {
            addCriterion("new_contact_number in", values, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberNotIn(List<String> values) {
            addCriterion("new_contact_number not in", values, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberBetween(String value1, String value2) {
            addCriterion("new_contact_number between", value1, value2, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewContactNumberNotBetween(String value1, String value2) {
            addCriterion("new_contact_number not between", value1, value2, "newContactNumber");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceIsNull() {
            addCriterion("new_work_place is null");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceIsNotNull() {
            addCriterion("new_work_place is not null");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceEqualTo(String value) {
            addCriterion("new_work_place =", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceNotEqualTo(String value) {
            addCriterion("new_work_place <>", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceGreaterThan(String value) {
            addCriterion("new_work_place >", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("new_work_place >=", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceLessThan(String value) {
            addCriterion("new_work_place <", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("new_work_place <=", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceLike(String value) {
            addCriterion("new_work_place like", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceNotLike(String value) {
            addCriterion("new_work_place not like", value, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceIn(List<String> values) {
            addCriterion("new_work_place in", values, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceNotIn(List<String> values) {
            addCriterion("new_work_place not in", values, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceBetween(String value1, String value2) {
            addCriterion("new_work_place between", value1, value2, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("new_work_place not between", value1, value2, "newWorkPlace");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderIsNull() {
            addCriterion("new_directly_leader is null");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderIsNotNull() {
            addCriterion("new_directly_leader is not null");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderEqualTo(String value) {
            addCriterion("new_directly_leader =", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderNotEqualTo(String value) {
            addCriterion("new_directly_leader <>", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderGreaterThan(String value) {
            addCriterion("new_directly_leader >", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("new_directly_leader >=", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderLessThan(String value) {
            addCriterion("new_directly_leader <", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderLessThanOrEqualTo(String value) {
            addCriterion("new_directly_leader <=", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderLike(String value) {
            addCriterion("new_directly_leader like", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderNotLike(String value) {
            addCriterion("new_directly_leader not like", value, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderIn(List<String> values) {
            addCriterion("new_directly_leader in", values, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderNotIn(List<String> values) {
            addCriterion("new_directly_leader not in", values, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderBetween(String value1, String value2) {
            addCriterion("new_directly_leader between", value1, value2, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andNewDirectlyLeaderNotBetween(String value1, String value2) {
            addCriterion("new_directly_leader not between", value1, value2, "newDirectlyLeader");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeIsNull() {
            addCriterion("applicate_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeIsNotNull() {
            addCriterion("applicate_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeEqualTo(Date value) {
            addCriterion("applicate_time =", value, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeNotEqualTo(Date value) {
            addCriterion("applicate_time <>", value, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeGreaterThan(Date value) {
            addCriterion("applicate_time >", value, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applicate_time >=", value, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeLessThan(Date value) {
            addCriterion("applicate_time <", value, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeLessThanOrEqualTo(Date value) {
            addCriterion("applicate_time <=", value, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeIn(List<Date> values) {
            addCriterion("applicate_time in", values, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeNotIn(List<Date> values) {
            addCriterion("applicate_time not in", values, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeBetween(Date value1, Date value2) {
            addCriterion("applicate_time between", value1, value2, "applicateTime");
            return (Criteria) this;
        }

        public Criteria andApplicateTimeNotBetween(Date value1, Date value2) {
            addCriterion("applicate_time not between", value1, value2, "applicateTime");
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