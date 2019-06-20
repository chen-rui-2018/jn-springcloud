package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerResumeDatabaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerResumeDatabaseCriteria() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNull() {
            addCriterion("mailbox is null");
            return (Criteria) this;
        }

        public Criteria andMailboxIsNotNull() {
            addCriterion("mailbox is not null");
            return (Criteria) this;
        }

        public Criteria andMailboxEqualTo(String value) {
            addCriterion("mailbox =", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotEqualTo(String value) {
            addCriterion("mailbox <>", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThan(String value) {
            addCriterion("mailbox >", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxGreaterThanOrEqualTo(String value) {
            addCriterion("mailbox >=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThan(String value) {
            addCriterion("mailbox <", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLessThanOrEqualTo(String value) {
            addCriterion("mailbox <=", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxLike(String value) {
            addCriterion("mailbox like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotLike(String value) {
            addCriterion("mailbox not like", value, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxIn(List<String> values) {
            addCriterion("mailbox in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotIn(List<String> values) {
            addCriterion("mailbox not in", values, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxBetween(String value1, String value2) {
            addCriterion("mailbox between", value1, value2, "mailbox");
            return (Criteria) this;
        }

        public Criteria andMailboxNotBetween(String value1, String value2) {
            addCriterion("mailbox not between", value1, value2, "mailbox");
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

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(String value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(String value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(String value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(String value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(String value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(String value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLike(String value) {
            addCriterion("job_id like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotLike(String value) {
            addCriterion("job_id not like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<String> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<String> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(String value1, String value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(String value1, String value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
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

        public Criteria andCertificateIdIsNull() {
            addCriterion("certificate_id is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIdIsNotNull() {
            addCriterion("certificate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateIdEqualTo(String value) {
            addCriterion("certificate_id =", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdNotEqualTo(String value) {
            addCriterion("certificate_id <>", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdGreaterThan(String value) {
            addCriterion("certificate_id >", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_id >=", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdLessThan(String value) {
            addCriterion("certificate_id <", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdLessThanOrEqualTo(String value) {
            addCriterion("certificate_id <=", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdLike(String value) {
            addCriterion("certificate_id like", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdNotLike(String value) {
            addCriterion("certificate_id not like", value, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdIn(List<String> values) {
            addCriterion("certificate_id in", values, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdNotIn(List<String> values) {
            addCriterion("certificate_id not in", values, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdBetween(String value1, String value2) {
            addCriterion("certificate_id between", value1, value2, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateIdNotBetween(String value1, String value2) {
            addCriterion("certificate_id not between", value1, value2, "certificateId");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNull() {
            addCriterion("certificate_type is null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("certificate_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeEqualTo(String value) {
            addCriterion("certificate_type =", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotEqualTo(String value) {
            addCriterion("certificate_type <>", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThan(String value) {
            addCriterion("certificate_type >", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_type >=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThan(String value) {
            addCriterion("certificate_type <", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThanOrEqualTo(String value) {
            addCriterion("certificate_type <=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLike(String value) {
            addCriterion("certificate_type like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotLike(String value) {
            addCriterion("certificate_type not like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIn(List<String> values) {
            addCriterion("certificate_type in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotIn(List<String> values) {
            addCriterion("certificate_type not in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeBetween(String value1, String value2) {
            addCriterion("certificate_type between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotBetween(String value1, String value2) {
            addCriterion("certificate_type not between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNull() {
            addCriterion("certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNotNull() {
            addCriterion("certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberEqualTo(String value) {
            addCriterion("certificate_number =", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotEqualTo(String value) {
            addCriterion("certificate_number <>", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThan(String value) {
            addCriterion("certificate_number >", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_number >=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThan(String value) {
            addCriterion("certificate_number <", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("certificate_number <=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLike(String value) {
            addCriterion("certificate_number like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotLike(String value) {
            addCriterion("certificate_number not like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIn(List<String> values) {
            addCriterion("certificate_number in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotIn(List<String> values) {
            addCriterion("certificate_number not in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberBetween(String value1, String value2) {
            addCriterion("certificate_number between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("certificate_number not between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andEducationIdIsNull() {
            addCriterion("education_id is null");
            return (Criteria) this;
        }

        public Criteria andEducationIdIsNotNull() {
            addCriterion("education_id is not null");
            return (Criteria) this;
        }

        public Criteria andEducationIdEqualTo(String value) {
            addCriterion("education_id =", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotEqualTo(String value) {
            addCriterion("education_id <>", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdGreaterThan(String value) {
            addCriterion("education_id >", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdGreaterThanOrEqualTo(String value) {
            addCriterion("education_id >=", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdLessThan(String value) {
            addCriterion("education_id <", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdLessThanOrEqualTo(String value) {
            addCriterion("education_id <=", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdLike(String value) {
            addCriterion("education_id like", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotLike(String value) {
            addCriterion("education_id not like", value, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdIn(List<String> values) {
            addCriterion("education_id in", values, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotIn(List<String> values) {
            addCriterion("education_id not in", values, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdBetween(String value1, String value2) {
            addCriterion("education_id between", value1, value2, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationIdNotBetween(String value1, String value2) {
            addCriterion("education_id not between", value1, value2, "educationId");
            return (Criteria) this;
        }

        public Criteria andEducationNameIsNull() {
            addCriterion("education_name is null");
            return (Criteria) this;
        }

        public Criteria andEducationNameIsNotNull() {
            addCriterion("education_name is not null");
            return (Criteria) this;
        }

        public Criteria andEducationNameEqualTo(String value) {
            addCriterion("education_name =", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotEqualTo(String value) {
            addCriterion("education_name <>", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameGreaterThan(String value) {
            addCriterion("education_name >", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameGreaterThanOrEqualTo(String value) {
            addCriterion("education_name >=", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameLessThan(String value) {
            addCriterion("education_name <", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameLessThanOrEqualTo(String value) {
            addCriterion("education_name <=", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameLike(String value) {
            addCriterion("education_name like", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotLike(String value) {
            addCriterion("education_name not like", value, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameIn(List<String> values) {
            addCriterion("education_name in", values, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotIn(List<String> values) {
            addCriterion("education_name not in", values, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameBetween(String value1, String value2) {
            addCriterion("education_name between", value1, value2, "educationName");
            return (Criteria) this;
        }

        public Criteria andEducationNameNotBetween(String value1, String value2) {
            addCriterion("education_name not between", value1, value2, "educationName");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyIsNull() {
            addCriterion("gradua_academy is null");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyIsNotNull() {
            addCriterion("gradua_academy is not null");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyEqualTo(String value) {
            addCriterion("gradua_academy =", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyNotEqualTo(String value) {
            addCriterion("gradua_academy <>", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyGreaterThan(String value) {
            addCriterion("gradua_academy >", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyGreaterThanOrEqualTo(String value) {
            addCriterion("gradua_academy >=", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyLessThan(String value) {
            addCriterion("gradua_academy <", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyLessThanOrEqualTo(String value) {
            addCriterion("gradua_academy <=", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyLike(String value) {
            addCriterion("gradua_academy like", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyNotLike(String value) {
            addCriterion("gradua_academy not like", value, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyIn(List<String> values) {
            addCriterion("gradua_academy in", values, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyNotIn(List<String> values) {
            addCriterion("gradua_academy not in", values, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyBetween(String value1, String value2) {
            addCriterion("gradua_academy between", value1, value2, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andGraduaAcademyNotBetween(String value1, String value2) {
            addCriterion("gradua_academy not between", value1, value2, "graduaAcademy");
            return (Criteria) this;
        }

        public Criteria andResumeInfoIsNull() {
            addCriterion("resume_info is null");
            return (Criteria) this;
        }

        public Criteria andResumeInfoIsNotNull() {
            addCriterion("resume_info is not null");
            return (Criteria) this;
        }

        public Criteria andResumeInfoEqualTo(String value) {
            addCriterion("resume_info =", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoNotEqualTo(String value) {
            addCriterion("resume_info <>", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoGreaterThan(String value) {
            addCriterion("resume_info >", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("resume_info >=", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoLessThan(String value) {
            addCriterion("resume_info <", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoLessThanOrEqualTo(String value) {
            addCriterion("resume_info <=", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoLike(String value) {
            addCriterion("resume_info like", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoNotLike(String value) {
            addCriterion("resume_info not like", value, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoIn(List<String> values) {
            addCriterion("resume_info in", values, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoNotIn(List<String> values) {
            addCriterion("resume_info not in", values, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoBetween(String value1, String value2) {
            addCriterion("resume_info between", value1, value2, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andResumeInfoNotBetween(String value1, String value2) {
            addCriterion("resume_info not between", value1, value2, "resumeInfo");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestIsNull() {
            addCriterion("is_background_invest is null");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestIsNotNull() {
            addCriterion("is_background_invest is not null");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestEqualTo(Byte value) {
            addCriterion("is_background_invest =", value, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestNotEqualTo(Byte value) {
            addCriterion("is_background_invest <>", value, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestGreaterThan(Byte value) {
            addCriterion("is_background_invest >", value, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_background_invest >=", value, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestLessThan(Byte value) {
            addCriterion("is_background_invest <", value, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestLessThanOrEqualTo(Byte value) {
            addCriterion("is_background_invest <=", value, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestIn(List<Byte> values) {
            addCriterion("is_background_invest in", values, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestNotIn(List<Byte> values) {
            addCriterion("is_background_invest not in", values, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestBetween(Byte value1, Byte value2) {
            addCriterion("is_background_invest between", value1, value2, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andIsBackgroundInvestNotBetween(Byte value1, Byte value2) {
            addCriterion("is_background_invest not between", value1, value2, "isBackgroundInvest");
            return (Criteria) this;
        }

        public Criteria andApplicationResultIsNull() {
            addCriterion("application_result is null");
            return (Criteria) this;
        }

        public Criteria andApplicationResultIsNotNull() {
            addCriterion("application_result is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationResultEqualTo(Byte value) {
            addCriterion("application_result =", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultNotEqualTo(Byte value) {
            addCriterion("application_result <>", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultGreaterThan(Byte value) {
            addCriterion("application_result >", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("application_result >=", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultLessThan(Byte value) {
            addCriterion("application_result <", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultLessThanOrEqualTo(Byte value) {
            addCriterion("application_result <=", value, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultIn(List<Byte> values) {
            addCriterion("application_result in", values, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultNotIn(List<Byte> values) {
            addCriterion("application_result not in", values, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultBetween(Byte value1, Byte value2) {
            addCriterion("application_result between", value1, value2, "applicationResult");
            return (Criteria) this;
        }

        public Criteria andApplicationResultNotBetween(Byte value1, Byte value2) {
            addCriterion("application_result not between", value1, value2, "applicationResult");
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