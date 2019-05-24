package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerAbroadManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerAbroadManagementCriteria() {
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

        public Criteria andAbroadReasonIsNull() {
            addCriterion("abroad_reason is null");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonIsNotNull() {
            addCriterion("abroad_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonEqualTo(String value) {
            addCriterion("abroad_reason =", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonNotEqualTo(String value) {
            addCriterion("abroad_reason <>", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonGreaterThan(String value) {
            addCriterion("abroad_reason >", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonGreaterThanOrEqualTo(String value) {
            addCriterion("abroad_reason >=", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonLessThan(String value) {
            addCriterion("abroad_reason <", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonLessThanOrEqualTo(String value) {
            addCriterion("abroad_reason <=", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonLike(String value) {
            addCriterion("abroad_reason like", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonNotLike(String value) {
            addCriterion("abroad_reason not like", value, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonIn(List<String> values) {
            addCriterion("abroad_reason in", values, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonNotIn(List<String> values) {
            addCriterion("abroad_reason not in", values, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonBetween(String value1, String value2) {
            addCriterion("abroad_reason between", value1, value2, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadReasonNotBetween(String value1, String value2) {
            addCriterion("abroad_reason not between", value1, value2, "abroadReason");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartIsNull() {
            addCriterion("abroad_time_start is null");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartIsNotNull() {
            addCriterion("abroad_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartEqualTo(Date value) {
            addCriterion("abroad_time_start =", value, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartNotEqualTo(Date value) {
            addCriterion("abroad_time_start <>", value, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartGreaterThan(Date value) {
            addCriterion("abroad_time_start >", value, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("abroad_time_start >=", value, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartLessThan(Date value) {
            addCriterion("abroad_time_start <", value, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("abroad_time_start <=", value, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartIn(List<Date> values) {
            addCriterion("abroad_time_start in", values, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartNotIn(List<Date> values) {
            addCriterion("abroad_time_start not in", values, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartBetween(Date value1, Date value2) {
            addCriterion("abroad_time_start between", value1, value2, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("abroad_time_start not between", value1, value2, "abroadTimeStart");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndIsNull() {
            addCriterion("abroad_time_end is null");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndIsNotNull() {
            addCriterion("abroad_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndEqualTo(Date value) {
            addCriterion("abroad_time_end =", value, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndNotEqualTo(Date value) {
            addCriterion("abroad_time_end <>", value, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndGreaterThan(Date value) {
            addCriterion("abroad_time_end >", value, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("abroad_time_end >=", value, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndLessThan(Date value) {
            addCriterion("abroad_time_end <", value, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("abroad_time_end <=", value, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndIn(List<Date> values) {
            addCriterion("abroad_time_end in", values, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndNotIn(List<Date> values) {
            addCriterion("abroad_time_end not in", values, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndBetween(Date value1, Date value2) {
            addCriterion("abroad_time_end between", value1, value2, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("abroad_time_end not between", value1, value2, "abroadTimeEnd");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationIsNull() {
            addCriterion("abroad_application is null");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationIsNotNull() {
            addCriterion("abroad_application is not null");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationEqualTo(String value) {
            addCriterion("abroad_application =", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationNotEqualTo(String value) {
            addCriterion("abroad_application <>", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationGreaterThan(String value) {
            addCriterion("abroad_application >", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("abroad_application >=", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationLessThan(String value) {
            addCriterion("abroad_application <", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationLessThanOrEqualTo(String value) {
            addCriterion("abroad_application <=", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationLike(String value) {
            addCriterion("abroad_application like", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationNotLike(String value) {
            addCriterion("abroad_application not like", value, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationIn(List<String> values) {
            addCriterion("abroad_application in", values, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationNotIn(List<String> values) {
            addCriterion("abroad_application not in", values, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationBetween(String value1, String value2) {
            addCriterion("abroad_application between", value1, value2, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadApplicationNotBetween(String value1, String value2) {
            addCriterion("abroad_application not between", value1, value2, "abroadApplication");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeIsNull() {
            addCriterion("abroad_type is null");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeIsNotNull() {
            addCriterion("abroad_type is not null");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeEqualTo(Byte value) {
            addCriterion("abroad_type =", value, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeNotEqualTo(Byte value) {
            addCriterion("abroad_type <>", value, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeGreaterThan(Byte value) {
            addCriterion("abroad_type >", value, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("abroad_type >=", value, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeLessThan(Byte value) {
            addCriterion("abroad_type <", value, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeLessThanOrEqualTo(Byte value) {
            addCriterion("abroad_type <=", value, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeIn(List<Byte> values) {
            addCriterion("abroad_type in", values, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeNotIn(List<Byte> values) {
            addCriterion("abroad_type not in", values, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeBetween(Byte value1, Byte value2) {
            addCriterion("abroad_type between", value1, value2, "abroadType");
            return (Criteria) this;
        }

        public Criteria andAbroadTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("abroad_type not between", value1, value2, "abroadType");
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