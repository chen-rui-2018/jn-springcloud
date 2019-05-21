package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerEducationExperienceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerEducationExperienceCriteria() {
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

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeIsNull() {
            addCriterion("admission_time is null");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeIsNotNull() {
            addCriterion("admission_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeEqualTo(Date value) {
            addCriterion("admission_time =", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeNotEqualTo(Date value) {
            addCriterion("admission_time <>", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeGreaterThan(Date value) {
            addCriterion("admission_time >", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("admission_time >=", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeLessThan(Date value) {
            addCriterion("admission_time <", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeLessThanOrEqualTo(Date value) {
            addCriterion("admission_time <=", value, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeIn(List<Date> values) {
            addCriterion("admission_time in", values, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeNotIn(List<Date> values) {
            addCriterion("admission_time not in", values, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeBetween(Date value1, Date value2) {
            addCriterion("admission_time between", value1, value2, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andAdmissionTimeNotBetween(Date value1, Date value2) {
            addCriterion("admission_time not between", value1, value2, "admissionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeIsNull() {
            addCriterion("completion_time is null");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeIsNotNull() {
            addCriterion("completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeEqualTo(Date value) {
            addCriterion("completion_time =", value, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeNotEqualTo(Date value) {
            addCriterion("completion_time <>", value, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeGreaterThan(Date value) {
            addCriterion("completion_time >", value, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("completion_time >=", value, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeLessThan(Date value) {
            addCriterion("completion_time <", value, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeLessThanOrEqualTo(Date value) {
            addCriterion("completion_time <=", value, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeIn(List<Date> values) {
            addCriterion("completion_time in", values, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeNotIn(List<Date> values) {
            addCriterion("completion_time not in", values, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeBetween(Date value1, Date value2) {
            addCriterion("completion_time between", value1, value2, "completionTime");
            return (Criteria) this;
        }

        public Criteria andCompletionTimeNotBetween(Date value1, Date value2) {
            addCriterion("completion_time not between", value1, value2, "completionTime");
            return (Criteria) this;
        }

        public Criteria andEducationCodeIsNull() {
            addCriterion("education_code is null");
            return (Criteria) this;
        }

        public Criteria andEducationCodeIsNotNull() {
            addCriterion("education_code is not null");
            return (Criteria) this;
        }

        public Criteria andEducationCodeEqualTo(String value) {
            addCriterion("education_code =", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeNotEqualTo(String value) {
            addCriterion("education_code <>", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeGreaterThan(String value) {
            addCriterion("education_code >", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("education_code >=", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeLessThan(String value) {
            addCriterion("education_code <", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeLessThanOrEqualTo(String value) {
            addCriterion("education_code <=", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeLike(String value) {
            addCriterion("education_code like", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeNotLike(String value) {
            addCriterion("education_code not like", value, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeIn(List<String> values) {
            addCriterion("education_code in", values, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeNotIn(List<String> values) {
            addCriterion("education_code not in", values, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeBetween(String value1, String value2) {
            addCriterion("education_code between", value1, value2, "educationCode");
            return (Criteria) this;
        }

        public Criteria andEducationCodeNotBetween(String value1, String value2) {
            addCriterion("education_code not between", value1, value2, "educationCode");
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

        public Criteria andIsAcademicDegreeIsNull() {
            addCriterion("is_academic_degree is null");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeIsNotNull() {
            addCriterion("is_academic_degree is not null");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeEqualTo(Byte value) {
            addCriterion("is_academic_degree =", value, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeNotEqualTo(Byte value) {
            addCriterion("is_academic_degree <>", value, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeGreaterThan(Byte value) {
            addCriterion("is_academic_degree >", value, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_academic_degree >=", value, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeLessThan(Byte value) {
            addCriterion("is_academic_degree <", value, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeLessThanOrEqualTo(Byte value) {
            addCriterion("is_academic_degree <=", value, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeIn(List<Byte> values) {
            addCriterion("is_academic_degree in", values, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeNotIn(List<Byte> values) {
            addCriterion("is_academic_degree not in", values, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeBetween(Byte value1, Byte value2) {
            addCriterion("is_academic_degree between", value1, value2, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andIsAcademicDegreeNotBetween(Byte value1, Byte value2) {
            addCriterion("is_academic_degree not between", value1, value2, "isAcademicDegree");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneIsNull() {
            addCriterion("certificate_educa_url_one is null");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneIsNotNull() {
            addCriterion("certificate_educa_url_one is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneEqualTo(String value) {
            addCriterion("certificate_educa_url_one =", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneNotEqualTo(String value) {
            addCriterion("certificate_educa_url_one <>", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneGreaterThan(String value) {
            addCriterion("certificate_educa_url_one >", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_educa_url_one >=", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneLessThan(String value) {
            addCriterion("certificate_educa_url_one <", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneLessThanOrEqualTo(String value) {
            addCriterion("certificate_educa_url_one <=", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneLike(String value) {
            addCriterion("certificate_educa_url_one like", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneNotLike(String value) {
            addCriterion("certificate_educa_url_one not like", value, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneIn(List<String> values) {
            addCriterion("certificate_educa_url_one in", values, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneNotIn(List<String> values) {
            addCriterion("certificate_educa_url_one not in", values, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneBetween(String value1, String value2) {
            addCriterion("certificate_educa_url_one between", value1, value2, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlOneNotBetween(String value1, String value2) {
            addCriterion("certificate_educa_url_one not between", value1, value2, "certificateEducaUrlOne");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoIsNull() {
            addCriterion("certificate_educa_url_two is null");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoIsNotNull() {
            addCriterion("certificate_educa_url_two is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoEqualTo(String value) {
            addCriterion("certificate_educa_url_two =", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoNotEqualTo(String value) {
            addCriterion("certificate_educa_url_two <>", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoGreaterThan(String value) {
            addCriterion("certificate_educa_url_two >", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_educa_url_two >=", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoLessThan(String value) {
            addCriterion("certificate_educa_url_two <", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoLessThanOrEqualTo(String value) {
            addCriterion("certificate_educa_url_two <=", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoLike(String value) {
            addCriterion("certificate_educa_url_two like", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoNotLike(String value) {
            addCriterion("certificate_educa_url_two not like", value, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoIn(List<String> values) {
            addCriterion("certificate_educa_url_two in", values, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoNotIn(List<String> values) {
            addCriterion("certificate_educa_url_two not in", values, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoBetween(String value1, String value2) {
            addCriterion("certificate_educa_url_two between", value1, value2, "certificateEducaUrlTwo");
            return (Criteria) this;
        }

        public Criteria andCertificateEducaUrlTwoNotBetween(String value1, String value2) {
            addCriterion("certificate_educa_url_two not between", value1, value2, "certificateEducaUrlTwo");
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