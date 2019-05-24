package com.jn.hr.increase.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerIncreaseDetailedCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerIncreaseDetailedCriteria() {
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

        public Criteria andInsuredMonthIsNull() {
            addCriterion("insured_month is null");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthIsNotNull() {
            addCriterion("insured_month is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthEqualTo(Date value) {
            addCriterion("insured_month =", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotEqualTo(Date value) {
            addCriterion("insured_month <>", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthGreaterThan(Date value) {
            addCriterion("insured_month >", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthGreaterThanOrEqualTo(Date value) {
            addCriterion("insured_month >=", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthLessThan(Date value) {
            addCriterion("insured_month <", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthLessThanOrEqualTo(Date value) {
            addCriterion("insured_month <=", value, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthIn(List<Date> values) {
            addCriterion("insured_month in", values, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotIn(List<Date> values) {
            addCriterion("insured_month not in", values, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthBetween(Date value1, Date value2) {
            addCriterion("insured_month between", value1, value2, "insuredMonth");
            return (Criteria) this;
        }

        public Criteria andInsuredMonthNotBetween(Date value1, Date value2) {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberIsNull() {
            addCriterion("default_cardinal_number is null");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberIsNotNull() {
            addCriterion("default_cardinal_number is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberEqualTo(Integer value) {
            addCriterion("default_cardinal_number =", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberNotEqualTo(Integer value) {
            addCriterion("default_cardinal_number <>", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberGreaterThan(Integer value) {
            addCriterion("default_cardinal_number >", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_cardinal_number >=", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberLessThan(Integer value) {
            addCriterion("default_cardinal_number <", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("default_cardinal_number <=", value, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberIn(List<Integer> values) {
            addCriterion("default_cardinal_number in", values, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberNotIn(List<Integer> values) {
            addCriterion("default_cardinal_number not in", values, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberBetween(Integer value1, Integer value2) {
            addCriterion("default_cardinal_number between", value1, value2, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andDefaultCardinalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("default_cardinal_number not between", value1, value2, "defaultCardinalNumber");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioIsNull() {
            addCriterion("corporate_contribution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioIsNotNull() {
            addCriterion("corporate_contribution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio =", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioNotEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio <>", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioGreaterThan(Integer value) {
            addCriterion("corporate_contribution_ratio >", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio >=", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioLessThan(Integer value) {
            addCriterion("corporate_contribution_ratio <", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioLessThanOrEqualTo(Integer value) {
            addCriterion("corporate_contribution_ratio <=", value, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioIn(List<Integer> values) {
            addCriterion("corporate_contribution_ratio in", values, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioNotIn(List<Integer> values) {
            addCriterion("corporate_contribution_ratio not in", values, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioBetween(Integer value1, Integer value2) {
            addCriterion("corporate_contribution_ratio between", value1, value2, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andCorporateContributionRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("corporate_contribution_ratio not between", value1, value2, "corporateContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioIsNull() {
            addCriterion("individual_contribution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioIsNotNull() {
            addCriterion("individual_contribution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio =", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioNotEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio <>", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioGreaterThan(Integer value) {
            addCriterion("individual_contribution_ratio >", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio >=", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioLessThan(Integer value) {
            addCriterion("individual_contribution_ratio <", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioLessThanOrEqualTo(Integer value) {
            addCriterion("individual_contribution_ratio <=", value, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioIn(List<Integer> values) {
            addCriterion("individual_contribution_ratio in", values, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioNotIn(List<Integer> values) {
            addCriterion("individual_contribution_ratio not in", values, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioBetween(Integer value1, Integer value2) {
            addCriterion("individual_contribution_ratio between", value1, value2, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andIndividualContributionRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("individual_contribution_ratio not between", value1, value2, "individualContributionRatio");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Byte value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Byte value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Byte value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Byte value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Byte value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Byte> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Byte> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Byte value1, Byte value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
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