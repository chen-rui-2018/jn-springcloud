package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerBackgroundInvestCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerBackgroundInvestCriteria() {
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

        public Criteria andIdentityCheckIsNull() {
            addCriterion("identity_check is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckIsNotNull() {
            addCriterion("identity_check is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckEqualTo(Byte value) {
            addCriterion("identity_check =", value, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckNotEqualTo(Byte value) {
            addCriterion("identity_check <>", value, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckGreaterThan(Byte value) {
            addCriterion("identity_check >", value, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("identity_check >=", value, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckLessThan(Byte value) {
            addCriterion("identity_check <", value, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckLessThanOrEqualTo(Byte value) {
            addCriterion("identity_check <=", value, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckIn(List<Byte> values) {
            addCriterion("identity_check in", values, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckNotIn(List<Byte> values) {
            addCriterion("identity_check not in", values, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckBetween(Byte value1, Byte value2) {
            addCriterion("identity_check between", value1, value2, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andIdentityCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("identity_check not between", value1, value2, "identityCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckIsNull() {
            addCriterion("education_check is null");
            return (Criteria) this;
        }

        public Criteria andEducationCheckIsNotNull() {
            addCriterion("education_check is not null");
            return (Criteria) this;
        }

        public Criteria andEducationCheckEqualTo(Byte value) {
            addCriterion("education_check =", value, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckNotEqualTo(Byte value) {
            addCriterion("education_check <>", value, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckGreaterThan(Byte value) {
            addCriterion("education_check >", value, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("education_check >=", value, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckLessThan(Byte value) {
            addCriterion("education_check <", value, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckLessThanOrEqualTo(Byte value) {
            addCriterion("education_check <=", value, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckIn(List<Byte> values) {
            addCriterion("education_check in", values, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckNotIn(List<Byte> values) {
            addCriterion("education_check not in", values, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckBetween(Byte value1, Byte value2) {
            addCriterion("education_check between", value1, value2, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andEducationCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("education_check not between", value1, value2, "educationCheck");
            return (Criteria) this;
        }

        public Criteria andCorporateNameIsNull() {
            addCriterion("corporate_name is null");
            return (Criteria) this;
        }

        public Criteria andCorporateNameIsNotNull() {
            addCriterion("corporate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateNameEqualTo(String value) {
            addCriterion("corporate_name =", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotEqualTo(String value) {
            addCriterion("corporate_name <>", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameGreaterThan(String value) {
            addCriterion("corporate_name >", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_name >=", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameLessThan(String value) {
            addCriterion("corporate_name <", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameLessThanOrEqualTo(String value) {
            addCriterion("corporate_name <=", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameLike(String value) {
            addCriterion("corporate_name like", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotLike(String value) {
            addCriterion("corporate_name not like", value, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameIn(List<String> values) {
            addCriterion("corporate_name in", values, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotIn(List<String> values) {
            addCriterion("corporate_name not in", values, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameBetween(String value1, String value2) {
            addCriterion("corporate_name between", value1, value2, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateNameNotBetween(String value1, String value2) {
            addCriterion("corporate_name not between", value1, value2, "corporateName");
            return (Criteria) this;
        }

        public Criteria andCorporateJobIsNull() {
            addCriterion("corporate_job is null");
            return (Criteria) this;
        }

        public Criteria andCorporateJobIsNotNull() {
            addCriterion("corporate_job is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateJobEqualTo(String value) {
            addCriterion("corporate_job =", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobNotEqualTo(String value) {
            addCriterion("corporate_job <>", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobGreaterThan(String value) {
            addCriterion("corporate_job >", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_job >=", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobLessThan(String value) {
            addCriterion("corporate_job <", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobLessThanOrEqualTo(String value) {
            addCriterion("corporate_job <=", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobLike(String value) {
            addCriterion("corporate_job like", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobNotLike(String value) {
            addCriterion("corporate_job not like", value, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobIn(List<String> values) {
            addCriterion("corporate_job in", values, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobNotIn(List<String> values) {
            addCriterion("corporate_job not in", values, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobBetween(String value1, String value2) {
            addCriterion("corporate_job between", value1, value2, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCorporateJobNotBetween(String value1, String value2) {
            addCriterion("corporate_job not between", value1, value2, "corporateJob");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierIsNull() {
            addCriterion("company_certifier is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierIsNotNull() {
            addCriterion("company_certifier is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierEqualTo(String value) {
            addCriterion("company_certifier =", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierNotEqualTo(String value) {
            addCriterion("company_certifier <>", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierGreaterThan(String value) {
            addCriterion("company_certifier >", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierGreaterThanOrEqualTo(String value) {
            addCriterion("company_certifier >=", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierLessThan(String value) {
            addCriterion("company_certifier <", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierLessThanOrEqualTo(String value) {
            addCriterion("company_certifier <=", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierLike(String value) {
            addCriterion("company_certifier like", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierNotLike(String value) {
            addCriterion("company_certifier not like", value, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierIn(List<String> values) {
            addCriterion("company_certifier in", values, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierNotIn(List<String> values) {
            addCriterion("company_certifier not in", values, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierBetween(String value1, String value2) {
            addCriterion("company_certifier between", value1, value2, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andCompanyCertifierNotBetween(String value1, String value2) {
            addCriterion("company_certifier not between", value1, value2, "companyCertifier");
            return (Criteria) this;
        }

        public Criteria andInspectorsIsNull() {
            addCriterion("inspectors is null");
            return (Criteria) this;
        }

        public Criteria andInspectorsIsNotNull() {
            addCriterion("inspectors is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorsEqualTo(String value) {
            addCriterion("inspectors =", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsNotEqualTo(String value) {
            addCriterion("inspectors <>", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsGreaterThan(String value) {
            addCriterion("inspectors >", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsGreaterThanOrEqualTo(String value) {
            addCriterion("inspectors >=", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsLessThan(String value) {
            addCriterion("inspectors <", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsLessThanOrEqualTo(String value) {
            addCriterion("inspectors <=", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsLike(String value) {
            addCriterion("inspectors like", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsNotLike(String value) {
            addCriterion("inspectors not like", value, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsIn(List<String> values) {
            addCriterion("inspectors in", values, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsNotIn(List<String> values) {
            addCriterion("inspectors not in", values, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsBetween(String value1, String value2) {
            addCriterion("inspectors between", value1, value2, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsNotBetween(String value1, String value2) {
            addCriterion("inspectors not between", value1, value2, "inspectors");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneIsNull() {
            addCriterion("inspectors_phone is null");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneIsNotNull() {
            addCriterion("inspectors_phone is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneEqualTo(String value) {
            addCriterion("inspectors_phone =", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneNotEqualTo(String value) {
            addCriterion("inspectors_phone <>", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneGreaterThan(String value) {
            addCriterion("inspectors_phone >", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("inspectors_phone >=", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneLessThan(String value) {
            addCriterion("inspectors_phone <", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneLessThanOrEqualTo(String value) {
            addCriterion("inspectors_phone <=", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneLike(String value) {
            addCriterion("inspectors_phone like", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneNotLike(String value) {
            addCriterion("inspectors_phone not like", value, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneIn(List<String> values) {
            addCriterion("inspectors_phone in", values, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneNotIn(List<String> values) {
            addCriterion("inspectors_phone not in", values, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneBetween(String value1, String value2) {
            addCriterion("inspectors_phone between", value1, value2, "inspectorsPhone");
            return (Criteria) this;
        }

        public Criteria andInspectorsPhoneNotBetween(String value1, String value2) {
            addCriterion("inspectors_phone not between", value1, value2, "inspectorsPhone");
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