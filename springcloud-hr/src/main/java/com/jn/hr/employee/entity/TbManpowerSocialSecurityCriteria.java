package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerSocialSecurityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerSocialSecurityCriteria() {
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

        public Criteria andSalaryBankIsNull() {
            addCriterion("salary_bank is null");
            return (Criteria) this;
        }

        public Criteria andSalaryBankIsNotNull() {
            addCriterion("salary_bank is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryBankEqualTo(String value) {
            addCriterion("salary_bank =", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankNotEqualTo(String value) {
            addCriterion("salary_bank <>", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankGreaterThan(String value) {
            addCriterion("salary_bank >", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankGreaterThanOrEqualTo(String value) {
            addCriterion("salary_bank >=", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankLessThan(String value) {
            addCriterion("salary_bank <", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankLessThanOrEqualTo(String value) {
            addCriterion("salary_bank <=", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankLike(String value) {
            addCriterion("salary_bank like", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankNotLike(String value) {
            addCriterion("salary_bank not like", value, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankIn(List<String> values) {
            addCriterion("salary_bank in", values, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankNotIn(List<String> values) {
            addCriterion("salary_bank not in", values, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankBetween(String value1, String value2) {
            addCriterion("salary_bank between", value1, value2, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryBankNotBetween(String value1, String value2) {
            addCriterion("salary_bank not between", value1, value2, "salaryBank");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberIsNull() {
            addCriterion("salary_number is null");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberIsNotNull() {
            addCriterion("salary_number is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberEqualTo(String value) {
            addCriterion("salary_number =", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberNotEqualTo(String value) {
            addCriterion("salary_number <>", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberGreaterThan(String value) {
            addCriterion("salary_number >", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberGreaterThanOrEqualTo(String value) {
            addCriterion("salary_number >=", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberLessThan(String value) {
            addCriterion("salary_number <", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberLessThanOrEqualTo(String value) {
            addCriterion("salary_number <=", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberLike(String value) {
            addCriterion("salary_number like", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberNotLike(String value) {
            addCriterion("salary_number not like", value, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberIn(List<String> values) {
            addCriterion("salary_number in", values, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberNotIn(List<String> values) {
            addCriterion("salary_number not in", values, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberBetween(String value1, String value2) {
            addCriterion("salary_number between", value1, value2, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andSalaryNumberNotBetween(String value1, String value2) {
            addCriterion("salary_number not between", value1, value2, "salaryNumber");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountIsNull() {
            addCriterion("provident_fund_account is null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountIsNotNull() {
            addCriterion("provident_fund_account is not null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountEqualTo(String value) {
            addCriterion("provident_fund_account =", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountNotEqualTo(String value) {
            addCriterion("provident_fund_account <>", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountGreaterThan(String value) {
            addCriterion("provident_fund_account >", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountGreaterThanOrEqualTo(String value) {
            addCriterion("provident_fund_account >=", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountLessThan(String value) {
            addCriterion("provident_fund_account <", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountLessThanOrEqualTo(String value) {
            addCriterion("provident_fund_account <=", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountLike(String value) {
            addCriterion("provident_fund_account like", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountNotLike(String value) {
            addCriterion("provident_fund_account not like", value, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountIn(List<String> values) {
            addCriterion("provident_fund_account in", values, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountNotIn(List<String> values) {
            addCriterion("provident_fund_account not in", values, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountBetween(String value1, String value2) {
            addCriterion("provident_fund_account between", value1, value2, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundAccountNotBetween(String value1, String value2) {
            addCriterion("provident_fund_account not between", value1, value2, "providentFundAccount");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentIsNull() {
            addCriterion("provident_fund_payment is null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentIsNotNull() {
            addCriterion("provident_fund_payment is not null");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentEqualTo(String value) {
            addCriterion("provident_fund_payment =", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentNotEqualTo(String value) {
            addCriterion("provident_fund_payment <>", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentGreaterThan(String value) {
            addCriterion("provident_fund_payment >", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("provident_fund_payment >=", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentLessThan(String value) {
            addCriterion("provident_fund_payment <", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentLessThanOrEqualTo(String value) {
            addCriterion("provident_fund_payment <=", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentLike(String value) {
            addCriterion("provident_fund_payment like", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentNotLike(String value) {
            addCriterion("provident_fund_payment not like", value, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentIn(List<String> values) {
            addCriterion("provident_fund_payment in", values, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentNotIn(List<String> values) {
            addCriterion("provident_fund_payment not in", values, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentBetween(String value1, String value2) {
            addCriterion("provident_fund_payment between", value1, value2, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andProvidentFundPaymentNotBetween(String value1, String value2) {
            addCriterion("provident_fund_payment not between", value1, value2, "providentFundPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountIsNull() {
            addCriterion("social_security_account is null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountIsNotNull() {
            addCriterion("social_security_account is not null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountEqualTo(String value) {
            addCriterion("social_security_account =", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountNotEqualTo(String value) {
            addCriterion("social_security_account <>", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountGreaterThan(String value) {
            addCriterion("social_security_account >", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountGreaterThanOrEqualTo(String value) {
            addCriterion("social_security_account >=", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountLessThan(String value) {
            addCriterion("social_security_account <", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountLessThanOrEqualTo(String value) {
            addCriterion("social_security_account <=", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountLike(String value) {
            addCriterion("social_security_account like", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountNotLike(String value) {
            addCriterion("social_security_account not like", value, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountIn(List<String> values) {
            addCriterion("social_security_account in", values, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountNotIn(List<String> values) {
            addCriterion("social_security_account not in", values, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountBetween(String value1, String value2) {
            addCriterion("social_security_account between", value1, value2, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityAccountNotBetween(String value1, String value2) {
            addCriterion("social_security_account not between", value1, value2, "socialSecurityAccount");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentIsNull() {
            addCriterion("social_security_payment is null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentIsNotNull() {
            addCriterion("social_security_payment is not null");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentEqualTo(String value) {
            addCriterion("social_security_payment =", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentNotEqualTo(String value) {
            addCriterion("social_security_payment <>", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentGreaterThan(String value) {
            addCriterion("social_security_payment >", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("social_security_payment >=", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentLessThan(String value) {
            addCriterion("social_security_payment <", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentLessThanOrEqualTo(String value) {
            addCriterion("social_security_payment <=", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentLike(String value) {
            addCriterion("social_security_payment like", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentNotLike(String value) {
            addCriterion("social_security_payment not like", value, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentIn(List<String> values) {
            addCriterion("social_security_payment in", values, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentNotIn(List<String> values) {
            addCriterion("social_security_payment not in", values, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentBetween(String value1, String value2) {
            addCriterion("social_security_payment between", value1, value2, "socialSecurityPayment");
            return (Criteria) this;
        }

        public Criteria andSocialSecurityPaymentNotBetween(String value1, String value2) {
            addCriterion("social_security_payment not between", value1, value2, "socialSecurityPayment");
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