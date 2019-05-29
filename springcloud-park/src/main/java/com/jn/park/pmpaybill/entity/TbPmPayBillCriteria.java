package com.jn.park.pmpaybill.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPmPayBillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPmPayBillCriteria() {
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("building_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("building_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("building_name =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("building_name <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("building_name >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("building_name >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("building_name <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("building_name <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("building_name like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("building_name not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("building_name in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("building_name not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("building_name between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("building_name not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNull() {
            addCriterion("deal_date is null");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNotNull() {
            addCriterion("deal_date is not null");
            return (Criteria) this;
        }

        public Criteria andDealDateEqualTo(String value) {
            addCriterion("deal_date =", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotEqualTo(String value) {
            addCriterion("deal_date <>", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThan(String value) {
            addCriterion("deal_date >", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThanOrEqualTo(String value) {
            addCriterion("deal_date >=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThan(String value) {
            addCriterion("deal_date <", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThanOrEqualTo(String value) {
            addCriterion("deal_date <=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLike(String value) {
            addCriterion("deal_date like", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotLike(String value) {
            addCriterion("deal_date not like", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateIn(List<String> values) {
            addCriterion("deal_date in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotIn(List<String> values) {
            addCriterion("deal_date not in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateBetween(String value1, String value2) {
            addCriterion("deal_date between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotBetween(String value1, String value2) {
            addCriterion("deal_date not between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNull() {
            addCriterion("bill_amount is null");
            return (Criteria) this;
        }

        public Criteria andBillAmountIsNotNull() {
            addCriterion("bill_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBillAmountEqualTo(BigDecimal value) {
            addCriterion("bill_amount =", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotEqualTo(BigDecimal value) {
            addCriterion("bill_amount <>", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThan(BigDecimal value) {
            addCriterion("bill_amount >", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_amount >=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThan(BigDecimal value) {
            addCriterion("bill_amount <", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_amount <=", value, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountIn(List<BigDecimal> values) {
            addCriterion("bill_amount in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotIn(List<BigDecimal> values) {
            addCriterion("bill_amount not in", values, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_amount between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andBillAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_amount not between", value1, value2, "billAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountIsNull() {
            addCriterion("free_amount is null");
            return (Criteria) this;
        }

        public Criteria andFreeAmountIsNotNull() {
            addCriterion("free_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFreeAmountEqualTo(BigDecimal value) {
            addCriterion("free_amount =", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountNotEqualTo(BigDecimal value) {
            addCriterion("free_amount <>", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountGreaterThan(BigDecimal value) {
            addCriterion("free_amount >", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("free_amount >=", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountLessThan(BigDecimal value) {
            addCriterion("free_amount <", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("free_amount <=", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountIn(List<BigDecimal> values) {
            addCriterion("free_amount in", values, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountNotIn(List<BigDecimal> values) {
            addCriterion("free_amount not in", values, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_amount between", value1, value2, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_amount not between", value1, value2, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeIsNull() {
            addCriterion("last_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeIsNotNull() {
            addCriterion("last_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeEqualTo(Date value) {
            addCriterion("last_pay_time =", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeNotEqualTo(Date value) {
            addCriterion("last_pay_time <>", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeGreaterThan(Date value) {
            addCriterion("last_pay_time >", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_pay_time >=", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeLessThan(Date value) {
            addCriterion("last_pay_time <", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_pay_time <=", value, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeIn(List<Date> values) {
            addCriterion("last_pay_time in", values, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeNotIn(List<Date> values) {
            addCriterion("last_pay_time not in", values, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeBetween(Date value1, Date value2) {
            addCriterion("last_pay_time between", value1, value2, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andLastPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_pay_time not between", value1, value2, "lastPayTime");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Byte value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Byte value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Byte value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Byte value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Byte value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Byte> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Byte> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Byte value1, Byte value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andIsExpireIsNull() {
            addCriterion("is_expire is null");
            return (Criteria) this;
        }

        public Criteria andIsExpireIsNotNull() {
            addCriterion("is_expire is not null");
            return (Criteria) this;
        }

        public Criteria andIsExpireEqualTo(Byte value) {
            addCriterion("is_expire =", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotEqualTo(Byte value) {
            addCriterion("is_expire <>", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireGreaterThan(Byte value) {
            addCriterion("is_expire >", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_expire >=", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireLessThan(Byte value) {
            addCriterion("is_expire <", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireLessThanOrEqualTo(Byte value) {
            addCriterion("is_expire <=", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireIn(List<Byte> values) {
            addCriterion("is_expire in", values, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotIn(List<Byte> values) {
            addCriterion("is_expire not in", values, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireBetween(Byte value1, Byte value2) {
            addCriterion("is_expire between", value1, value2, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotBetween(Byte value1, Byte value2) {
            addCriterion("is_expire not between", value1, value2, "isExpire");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusIsNull() {
            addCriterion("generate_satus is null");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusIsNotNull() {
            addCriterion("generate_satus is not null");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusEqualTo(Byte value) {
            addCriterion("generate_satus =", value, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusNotEqualTo(Byte value) {
            addCriterion("generate_satus <>", value, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusGreaterThan(Byte value) {
            addCriterion("generate_satus >", value, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("generate_satus >=", value, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusLessThan(Byte value) {
            addCriterion("generate_satus <", value, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusLessThanOrEqualTo(Byte value) {
            addCriterion("generate_satus <=", value, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusIn(List<Byte> values) {
            addCriterion("generate_satus in", values, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusNotIn(List<Byte> values) {
            addCriterion("generate_satus not in", values, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusBetween(Byte value1, Byte value2) {
            addCriterion("generate_satus between", value1, value2, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andGenerateSatusNotBetween(Byte value1, Byte value2) {
            addCriterion("generate_satus not between", value1, value2, "generateSatus");
            return (Criteria) this;
        }

        public Criteria andDerateStateIsNull() {
            addCriterion("derate_state is null");
            return (Criteria) this;
        }

        public Criteria andDerateStateIsNotNull() {
            addCriterion("derate_state is not null");
            return (Criteria) this;
        }

        public Criteria andDerateStateEqualTo(Byte value) {
            addCriterion("derate_state =", value, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateNotEqualTo(Byte value) {
            addCriterion("derate_state <>", value, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateGreaterThan(Byte value) {
            addCriterion("derate_state >", value, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("derate_state >=", value, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateLessThan(Byte value) {
            addCriterion("derate_state <", value, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateLessThanOrEqualTo(Byte value) {
            addCriterion("derate_state <=", value, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateIn(List<Byte> values) {
            addCriterion("derate_state in", values, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateNotIn(List<Byte> values) {
            addCriterion("derate_state not in", values, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateBetween(Byte value1, Byte value2) {
            addCriterion("derate_state between", value1, value2, "derateState");
            return (Criteria) this;
        }

        public Criteria andDerateStateNotBetween(Byte value1, Byte value2) {
            addCriterion("derate_state not between", value1, value2, "derateState");
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