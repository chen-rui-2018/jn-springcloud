package com.jn.park.pmpaybill.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPmPayBillItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPmPayBillItemCriteria() {
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

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(String value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(String value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(String value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(String value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(String value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLike(String value) {
            addCriterion("bill_id like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotLike(String value) {
            addCriterion("bill_id not like", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<String> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<String> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(String value1, String value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(String value1, String value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
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

        public Criteria andCalcModeIsNull() {
            addCriterion("calc_mode is null");
            return (Criteria) this;
        }

        public Criteria andCalcModeIsNotNull() {
            addCriterion("calc_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCalcModeEqualTo(Byte value) {
            addCriterion("calc_mode =", value, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeNotEqualTo(Byte value) {
            addCriterion("calc_mode <>", value, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeGreaterThan(Byte value) {
            addCriterion("calc_mode >", value, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("calc_mode >=", value, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeLessThan(Byte value) {
            addCriterion("calc_mode <", value, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeLessThanOrEqualTo(Byte value) {
            addCriterion("calc_mode <=", value, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeIn(List<Byte> values) {
            addCriterion("calc_mode in", values, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeNotIn(List<Byte> values) {
            addCriterion("calc_mode not in", values, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeBetween(Byte value1, Byte value2) {
            addCriterion("calc_mode between", value1, value2, "calcMode");
            return (Criteria) this;
        }

        public Criteria andCalcModeNotBetween(Byte value1, Byte value2) {
            addCriterion("calc_mode not between", value1, value2, "calcMode");
            return (Criteria) this;
        }

        public Criteria andPayPeriodIsNull() {
            addCriterion("pay_period is null");
            return (Criteria) this;
        }

        public Criteria andPayPeriodIsNotNull() {
            addCriterion("pay_period is not null");
            return (Criteria) this;
        }

        public Criteria andPayPeriodEqualTo(String value) {
            addCriterion("pay_period =", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotEqualTo(String value) {
            addCriterion("pay_period <>", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodGreaterThan(String value) {
            addCriterion("pay_period >", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("pay_period >=", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodLessThan(String value) {
            addCriterion("pay_period <", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodLessThanOrEqualTo(String value) {
            addCriterion("pay_period <=", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodLike(String value) {
            addCriterion("pay_period like", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotLike(String value) {
            addCriterion("pay_period not like", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodIn(List<String> values) {
            addCriterion("pay_period in", values, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotIn(List<String> values) {
            addCriterion("pay_period not in", values, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodBetween(String value1, String value2) {
            addCriterion("pay_period between", value1, value2, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotBetween(String value1, String value2) {
            addCriterion("pay_period not between", value1, value2, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andBillAcountIsNull() {
            addCriterion("bill_acount is null");
            return (Criteria) this;
        }

        public Criteria andBillAcountIsNotNull() {
            addCriterion("bill_acount is not null");
            return (Criteria) this;
        }

        public Criteria andBillAcountEqualTo(BigDecimal value) {
            addCriterion("bill_acount =", value, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountNotEqualTo(BigDecimal value) {
            addCriterion("bill_acount <>", value, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountGreaterThan(BigDecimal value) {
            addCriterion("bill_acount >", value, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_acount >=", value, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountLessThan(BigDecimal value) {
            addCriterion("bill_acount <", value, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_acount <=", value, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountIn(List<BigDecimal> values) {
            addCriterion("bill_acount in", values, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountNotIn(List<BigDecimal> values) {
            addCriterion("bill_acount not in", values, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_acount between", value1, value2, "billAcount");
            return (Criteria) this;
        }

        public Criteria andBillAcountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_acount not between", value1, value2, "billAcount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNull() {
            addCriterion("fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNotNull() {
            addCriterion("fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountEqualTo(BigDecimal value) {
            addCriterion("fee_amount =", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotEqualTo(BigDecimal value) {
            addCriterion("fee_amount <>", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThan(BigDecimal value) {
            addCriterion("fee_amount >", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_amount >=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThan(BigDecimal value) {
            addCriterion("fee_amount <", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_amount <=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIn(List<BigDecimal> values) {
            addCriterion("fee_amount in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotIn(List<BigDecimal> values) {
            addCriterion("fee_amount not in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_amount between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_amount not between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeReasonIsNull() {
            addCriterion("fee_reason is null");
            return (Criteria) this;
        }

        public Criteria andFeeReasonIsNotNull() {
            addCriterion("fee_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFeeReasonEqualTo(String value) {
            addCriterion("fee_reason =", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonNotEqualTo(String value) {
            addCriterion("fee_reason <>", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonGreaterThan(String value) {
            addCriterion("fee_reason >", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonGreaterThanOrEqualTo(String value) {
            addCriterion("fee_reason >=", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonLessThan(String value) {
            addCriterion("fee_reason <", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonLessThanOrEqualTo(String value) {
            addCriterion("fee_reason <=", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonLike(String value) {
            addCriterion("fee_reason like", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonNotLike(String value) {
            addCriterion("fee_reason not like", value, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonIn(List<String> values) {
            addCriterion("fee_reason in", values, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonNotIn(List<String> values) {
            addCriterion("fee_reason not in", values, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonBetween(String value1, String value2) {
            addCriterion("fee_reason between", value1, value2, "feeReason");
            return (Criteria) this;
        }

        public Criteria andFeeReasonNotBetween(String value1, String value2) {
            addCriterion("fee_reason not between", value1, value2, "feeReason");
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

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Byte value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Byte value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Byte value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Byte value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Byte value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Byte> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Byte> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Byte value1, Byte value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusIsNull() {
            addCriterion("generate_status is null");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusIsNotNull() {
            addCriterion("generate_status is not null");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusEqualTo(Byte value) {
            addCriterion("generate_status =", value, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusNotEqualTo(Byte value) {
            addCriterion("generate_status <>", value, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusGreaterThan(Byte value) {
            addCriterion("generate_status >", value, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("generate_status >=", value, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusLessThan(Byte value) {
            addCriterion("generate_status <", value, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusLessThanOrEqualTo(Byte value) {
            addCriterion("generate_status <=", value, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusIn(List<Byte> values) {
            addCriterion("generate_status in", values, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusNotIn(List<Byte> values) {
            addCriterion("generate_status not in", values, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusBetween(Byte value1, Byte value2) {
            addCriterion("generate_status between", value1, value2, "generateStatus");
            return (Criteria) this;
        }

        public Criteria andGenerateStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("generate_status not between", value1, value2, "generateStatus");
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

        public Criteria andSendPayBillIsNull() {
            addCriterion("send_pay_bill is null");
            return (Criteria) this;
        }

        public Criteria andSendPayBillIsNotNull() {
            addCriterion("send_pay_bill is not null");
            return (Criteria) this;
        }

        public Criteria andSendPayBillEqualTo(Byte value) {
            addCriterion("send_pay_bill =", value, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillNotEqualTo(Byte value) {
            addCriterion("send_pay_bill <>", value, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillGreaterThan(Byte value) {
            addCriterion("send_pay_bill >", value, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_pay_bill >=", value, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillLessThan(Byte value) {
            addCriterion("send_pay_bill <", value, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillLessThanOrEqualTo(Byte value) {
            addCriterion("send_pay_bill <=", value, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillIn(List<Byte> values) {
            addCriterion("send_pay_bill in", values, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillNotIn(List<Byte> values) {
            addCriterion("send_pay_bill not in", values, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillBetween(Byte value1, Byte value2) {
            addCriterion("send_pay_bill between", value1, value2, "sendPayBill");
            return (Criteria) this;
        }

        public Criteria andSendPayBillNotBetween(Byte value1, Byte value2) {
            addCriterion("send_pay_bill not between", value1, value2, "sendPayBill");
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