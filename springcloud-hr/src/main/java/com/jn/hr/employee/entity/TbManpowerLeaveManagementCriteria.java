package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerLeaveManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerLeaveManagementCriteria() {
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

        public Criteria andApplicationDateIsNull() {
            addCriterion("application_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNotNull() {
            addCriterion("application_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateEqualTo(Date value) {
            addCriterion("application_date =", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotEqualTo(Date value) {
            addCriterion("application_date <>", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThan(Date value) {
            addCriterion("application_date >", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("application_date >=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThan(Date value) {
            addCriterion("application_date <", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThanOrEqualTo(Date value) {
            addCriterion("application_date <=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIn(List<Date> values) {
            addCriterion("application_date in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotIn(List<Date> values) {
            addCriterion("application_date not in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateBetween(Date value1, Date value2) {
            addCriterion("application_date between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotBetween(Date value1, Date value2) {
            addCriterion("application_date not between", value1, value2, "applicationDate");
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

        public Criteria andTurnoverTypeIsNull() {
            addCriterion("turnover_type is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeIsNotNull() {
            addCriterion("turnover_type is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeEqualTo(Byte value) {
            addCriterion("turnover_type =", value, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeNotEqualTo(Byte value) {
            addCriterion("turnover_type <>", value, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeGreaterThan(Byte value) {
            addCriterion("turnover_type >", value, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("turnover_type >=", value, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeLessThan(Byte value) {
            addCriterion("turnover_type <", value, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeLessThanOrEqualTo(Byte value) {
            addCriterion("turnover_type <=", value, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeIn(List<Byte> values) {
            addCriterion("turnover_type in", values, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeNotIn(List<Byte> values) {
            addCriterion("turnover_type not in", values, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeBetween(Byte value1, Byte value2) {
            addCriterion("turnover_type between", value1, value2, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andTurnoverTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("turnover_type not between", value1, value2, "turnoverType");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavIsNull() {
            addCriterion("reasons_leav is null");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavIsNotNull() {
            addCriterion("reasons_leav is not null");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavEqualTo(String value) {
            addCriterion("reasons_leav =", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavNotEqualTo(String value) {
            addCriterion("reasons_leav <>", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavGreaterThan(String value) {
            addCriterion("reasons_leav >", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavGreaterThanOrEqualTo(String value) {
            addCriterion("reasons_leav >=", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavLessThan(String value) {
            addCriterion("reasons_leav <", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavLessThanOrEqualTo(String value) {
            addCriterion("reasons_leav <=", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavLike(String value) {
            addCriterion("reasons_leav like", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavNotLike(String value) {
            addCriterion("reasons_leav not like", value, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavIn(List<String> values) {
            addCriterion("reasons_leav in", values, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavNotIn(List<String> values) {
            addCriterion("reasons_leav not in", values, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavBetween(String value1, String value2) {
            addCriterion("reasons_leav between", value1, value2, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andReasonsLeavNotBetween(String value1, String value2) {
            addCriterion("reasons_leav not between", value1, value2, "reasonsLeav");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateIsNull() {
            addCriterion("estimate_leave_date is null");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateIsNotNull() {
            addCriterion("estimate_leave_date is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateEqualTo(Date value) {
            addCriterion("estimate_leave_date =", value, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateNotEqualTo(Date value) {
            addCriterion("estimate_leave_date <>", value, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateGreaterThan(Date value) {
            addCriterion("estimate_leave_date >", value, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("estimate_leave_date >=", value, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateLessThan(Date value) {
            addCriterion("estimate_leave_date <", value, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateLessThanOrEqualTo(Date value) {
            addCriterion("estimate_leave_date <=", value, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateIn(List<Date> values) {
            addCriterion("estimate_leave_date in", values, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateNotIn(List<Date> values) {
            addCriterion("estimate_leave_date not in", values, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateBetween(Date value1, Date value2) {
            addCriterion("estimate_leave_date between", value1, value2, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andEstimateLeaveDateNotBetween(Date value1, Date value2) {
            addCriterion("estimate_leave_date not between", value1, value2, "estimateLeaveDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateIsNull() {
            addCriterion("final_work_date is null");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateIsNotNull() {
            addCriterion("final_work_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateEqualTo(Date value) {
            addCriterion("final_work_date =", value, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateNotEqualTo(Date value) {
            addCriterion("final_work_date <>", value, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateGreaterThan(Date value) {
            addCriterion("final_work_date >", value, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateGreaterThanOrEqualTo(Date value) {
            addCriterion("final_work_date >=", value, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateLessThan(Date value) {
            addCriterion("final_work_date <", value, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateLessThanOrEqualTo(Date value) {
            addCriterion("final_work_date <=", value, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateIn(List<Date> values) {
            addCriterion("final_work_date in", values, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateNotIn(List<Date> values) {
            addCriterion("final_work_date not in", values, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateBetween(Date value1, Date value2) {
            addCriterion("final_work_date between", value1, value2, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andFinalWorkDateNotBetween(Date value1, Date value2) {
            addCriterion("final_work_date not between", value1, value2, "finalWorkDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateIsNull() {
            addCriterion("salary_settlement_date is null");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateIsNotNull() {
            addCriterion("salary_settlement_date is not null");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateEqualTo(Date value) {
            addCriterion("salary_settlement_date =", value, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateNotEqualTo(Date value) {
            addCriterion("salary_settlement_date <>", value, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateGreaterThan(Date value) {
            addCriterion("salary_settlement_date >", value, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateGreaterThanOrEqualTo(Date value) {
            addCriterion("salary_settlement_date >=", value, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateLessThan(Date value) {
            addCriterion("salary_settlement_date <", value, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateLessThanOrEqualTo(Date value) {
            addCriterion("salary_settlement_date <=", value, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateIn(List<Date> values) {
            addCriterion("salary_settlement_date in", values, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateNotIn(List<Date> values) {
            addCriterion("salary_settlement_date not in", values, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateBetween(Date value1, Date value2) {
            addCriterion("salary_settlement_date between", value1, value2, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andSalarySettlementDateNotBetween(Date value1, Date value2) {
            addCriterion("salary_settlement_date not between", value1, value2, "salarySettlementDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(Byte value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(Byte value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(Byte value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(Byte value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(Byte value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<Byte> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<Byte> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(Byte value1, Byte value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
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