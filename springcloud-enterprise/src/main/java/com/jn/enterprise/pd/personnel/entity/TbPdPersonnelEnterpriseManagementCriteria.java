package com.jn.enterprise.pd.personnel.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdPersonnelEnterpriseManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdPersonnelEnterpriseManagementCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeIsNull() {
            addCriterion("business_income is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeIsNotNull() {
            addCriterion("business_income is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeEqualTo(BigDecimal value) {
            addCriterion("business_income =", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeNotEqualTo(BigDecimal value) {
            addCriterion("business_income <>", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeGreaterThan(BigDecimal value) {
            addCriterion("business_income >", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("business_income >=", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeLessThan(BigDecimal value) {
            addCriterion("business_income <", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("business_income <=", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeIn(List<BigDecimal> values) {
            addCriterion("business_income in", values, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeNotIn(List<BigDecimal> values) {
            addCriterion("business_income not in", values, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("business_income between", value1, value2, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("business_income not between", value1, value2, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentIsNull() {
            addCriterion("enterprise_investment is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentIsNotNull() {
            addCriterion("enterprise_investment is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentEqualTo(BigDecimal value) {
            addCriterion("enterprise_investment =", value, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentNotEqualTo(BigDecimal value) {
            addCriterion("enterprise_investment <>", value, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentGreaterThan(BigDecimal value) {
            addCriterion("enterprise_investment >", value, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("enterprise_investment >=", value, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentLessThan(BigDecimal value) {
            addCriterion("enterprise_investment <", value, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("enterprise_investment <=", value, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentIn(List<BigDecimal> values) {
            addCriterion("enterprise_investment in", values, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentNotIn(List<BigDecimal> values) {
            addCriterion("enterprise_investment not in", values, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enterprise_investment between", value1, value2, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andEnterpriseInvestmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enterprise_investment not between", value1, value2, "enterpriseInvestment");
            return (Criteria) this;
        }

        public Criteria andLaborCostIsNull() {
            addCriterion("labor_cost is null");
            return (Criteria) this;
        }

        public Criteria andLaborCostIsNotNull() {
            addCriterion("labor_cost is not null");
            return (Criteria) this;
        }

        public Criteria andLaborCostEqualTo(BigDecimal value) {
            addCriterion("labor_cost =", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostNotEqualTo(BigDecimal value) {
            addCriterion("labor_cost <>", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostGreaterThan(BigDecimal value) {
            addCriterion("labor_cost >", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("labor_cost >=", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostLessThan(BigDecimal value) {
            addCriterion("labor_cost <", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("labor_cost <=", value, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostIn(List<BigDecimal> values) {
            addCriterion("labor_cost in", values, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostNotIn(List<BigDecimal> values) {
            addCriterion("labor_cost not in", values, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labor_cost between", value1, value2, "laborCost");
            return (Criteria) this;
        }

        public Criteria andLaborCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("labor_cost not between", value1, value2, "laborCost");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesIsNull() {
            addCriterion("number_enterprises is null");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesIsNotNull() {
            addCriterion("number_enterprises is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesEqualTo(BigDecimal value) {
            addCriterion("number_enterprises =", value, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesNotEqualTo(BigDecimal value) {
            addCriterion("number_enterprises <>", value, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesGreaterThan(BigDecimal value) {
            addCriterion("number_enterprises >", value, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("number_enterprises >=", value, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesLessThan(BigDecimal value) {
            addCriterion("number_enterprises <", value, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("number_enterprises <=", value, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesIn(List<BigDecimal> values) {
            addCriterion("number_enterprises in", values, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesNotIn(List<BigDecimal> values) {
            addCriterion("number_enterprises not in", values, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number_enterprises between", value1, value2, "numberEnterprises");
            return (Criteria) this;
        }

        public Criteria andNumberEnterprisesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("number_enterprises not between", value1, value2, "numberEnterprises");
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

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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