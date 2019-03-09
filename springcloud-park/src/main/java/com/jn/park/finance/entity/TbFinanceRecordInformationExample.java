package com.jn.park.finance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFinanceRecordInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFinanceRecordInformationExample() {
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

        public Criteria andFlowTypeIsNull() {
            addCriterion("flow_type is null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNotNull() {
            addCriterion("flow_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeEqualTo(String value) {
            addCriterion("flow_type =", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotEqualTo(String value) {
            addCriterion("flow_type <>", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThan(String value) {
            addCriterion("flow_type >", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("flow_type >=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThan(String value) {
            addCriterion("flow_type <", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThanOrEqualTo(String value) {
            addCriterion("flow_type <=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLike(String value) {
            addCriterion("flow_type like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotLike(String value) {
            addCriterion("flow_type not like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIn(List<String> values) {
            addCriterion("flow_type in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotIn(List<String> values) {
            addCriterion("flow_type not in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeBetween(String value1, String value2) {
            addCriterion("flow_type between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotBetween(String value1, String value2) {
            addCriterion("flow_type not between", value1, value2, "flowType");
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

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andCreateStateIsNull() {
            addCriterion("create_state is null");
            return (Criteria) this;
        }

        public Criteria andCreateStateIsNotNull() {
            addCriterion("create_state is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStateEqualTo(Byte value) {
            addCriterion("create_state =", value, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateNotEqualTo(Byte value) {
            addCriterion("create_state <>", value, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateGreaterThan(Byte value) {
            addCriterion("create_state >", value, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("create_state >=", value, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateLessThan(Byte value) {
            addCriterion("create_state <", value, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateLessThanOrEqualTo(Byte value) {
            addCriterion("create_state <=", value, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateIn(List<Byte> values) {
            addCriterion("create_state in", values, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateNotIn(List<Byte> values) {
            addCriterion("create_state not in", values, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateBetween(Byte value1, Byte value2) {
            addCriterion("create_state between", value1, value2, "createState");
            return (Criteria) this;
        }

        public Criteria andCreateStateNotBetween(Byte value1, Byte value2) {
            addCriterion("create_state not between", value1, value2, "createState");
            return (Criteria) this;
        }

        public Criteria andFinancerSureIsNull() {
            addCriterion("financer_sure is null");
            return (Criteria) this;
        }

        public Criteria andFinancerSureIsNotNull() {
            addCriterion("financer_sure is not null");
            return (Criteria) this;
        }

        public Criteria andFinancerSureEqualTo(Byte value) {
            addCriterion("financer_sure =", value, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureNotEqualTo(Byte value) {
            addCriterion("financer_sure <>", value, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureGreaterThan(Byte value) {
            addCriterion("financer_sure >", value, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureGreaterThanOrEqualTo(Byte value) {
            addCriterion("financer_sure >=", value, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureLessThan(Byte value) {
            addCriterion("financer_sure <", value, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureLessThanOrEqualTo(Byte value) {
            addCriterion("financer_sure <=", value, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureIn(List<Byte> values) {
            addCriterion("financer_sure in", values, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureNotIn(List<Byte> values) {
            addCriterion("financer_sure not in", values, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureBetween(Byte value1, Byte value2) {
            addCriterion("financer_sure between", value1, value2, "financerSure");
            return (Criteria) this;
        }

        public Criteria andFinancerSureNotBetween(Byte value1, Byte value2) {
            addCriterion("financer_sure not between", value1, value2, "financerSure");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningIsNull() {
            addCriterion("early_warning is null");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningIsNotNull() {
            addCriterion("early_warning is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningEqualTo(Byte value) {
            addCriterion("early_warning =", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningNotEqualTo(Byte value) {
            addCriterion("early_warning <>", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningGreaterThan(Byte value) {
            addCriterion("early_warning >", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningGreaterThanOrEqualTo(Byte value) {
            addCriterion("early_warning >=", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningLessThan(Byte value) {
            addCriterion("early_warning <", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningLessThanOrEqualTo(Byte value) {
            addCriterion("early_warning <=", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningIn(List<Byte> values) {
            addCriterion("early_warning in", values, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningNotIn(List<Byte> values) {
            addCriterion("early_warning not in", values, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningBetween(Byte value1, Byte value2) {
            addCriterion("early_warning between", value1, value2, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningNotBetween(Byte value1, Byte value2) {
            addCriterion("early_warning not between", value1, value2, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningIsNull() {
            addCriterion("leader_early_warning is null");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningIsNotNull() {
            addCriterion("leader_early_warning is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningEqualTo(Byte value) {
            addCriterion("leader_early_warning =", value, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningNotEqualTo(Byte value) {
            addCriterion("leader_early_warning <>", value, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningGreaterThan(Byte value) {
            addCriterion("leader_early_warning >", value, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningGreaterThanOrEqualTo(Byte value) {
            addCriterion("leader_early_warning >=", value, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningLessThan(Byte value) {
            addCriterion("leader_early_warning <", value, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningLessThanOrEqualTo(Byte value) {
            addCriterion("leader_early_warning <=", value, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningIn(List<Byte> values) {
            addCriterion("leader_early_warning in", values, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningNotIn(List<Byte> values) {
            addCriterion("leader_early_warning not in", values, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningBetween(Byte value1, Byte value2) {
            addCriterion("leader_early_warning between", value1, value2, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andLeaderEarlyWarningNotBetween(Byte value1, Byte value2) {
            addCriterion("leader_early_warning not between", value1, value2, "leaderEarlyWarning");
            return (Criteria) this;
        }

        public Criteria andFileCodeIsNull() {
            addCriterion("file_code is null");
            return (Criteria) this;
        }

        public Criteria andFileCodeIsNotNull() {
            addCriterion("file_code is not null");
            return (Criteria) this;
        }

        public Criteria andFileCodeEqualTo(String value) {
            addCriterion("file_code =", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotEqualTo(String value) {
            addCriterion("file_code <>", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeGreaterThan(String value) {
            addCriterion("file_code >", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeGreaterThanOrEqualTo(String value) {
            addCriterion("file_code >=", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeLessThan(String value) {
            addCriterion("file_code <", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeLessThanOrEqualTo(String value) {
            addCriterion("file_code <=", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeLike(String value) {
            addCriterion("file_code like", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotLike(String value) {
            addCriterion("file_code not like", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeIn(List<String> values) {
            addCriterion("file_code in", values, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotIn(List<String> values) {
            addCriterion("file_code not in", values, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeBetween(String value1, String value2) {
            addCriterion("file_code between", value1, value2, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotBetween(String value1, String value2) {
            addCriterion("file_code not between", value1, value2, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(String value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(String value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(String value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(String value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLike(String value) {
            addCriterion("creator_id like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotLike(String value) {
            addCriterion("creator_id not like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<String> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<String> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(String value1, String value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(String value1, String value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andIsWarningIsNull() {
            addCriterion("is_warning is null");
            return (Criteria) this;
        }

        public Criteria andIsWarningIsNotNull() {
            addCriterion("is_warning is not null");
            return (Criteria) this;
        }

        public Criteria andIsWarningEqualTo(Byte value) {
            addCriterion("is_warning =", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotEqualTo(Byte value) {
            addCriterion("is_warning <>", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningGreaterThan(Byte value) {
            addCriterion("is_warning >", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_warning >=", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningLessThan(Byte value) {
            addCriterion("is_warning <", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningLessThanOrEqualTo(Byte value) {
            addCriterion("is_warning <=", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningIn(List<Byte> values) {
            addCriterion("is_warning in", values, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotIn(List<Byte> values) {
            addCriterion("is_warning not in", values, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningBetween(Byte value1, Byte value2) {
            addCriterion("is_warning between", value1, value2, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotBetween(Byte value1, Byte value2) {
            addCriterion("is_warning not between", value1, value2, "isWarning");
            return (Criteria) this;
        }

        public Criteria andWarningRateIsNull() {
            addCriterion("warning_rate is null");
            return (Criteria) this;
        }

        public Criteria andWarningRateIsNotNull() {
            addCriterion("warning_rate is not null");
            return (Criteria) this;
        }

        public Criteria andWarningRateEqualTo(Byte value) {
            addCriterion("warning_rate =", value, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateNotEqualTo(Byte value) {
            addCriterion("warning_rate <>", value, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateGreaterThan(Byte value) {
            addCriterion("warning_rate >", value, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateGreaterThanOrEqualTo(Byte value) {
            addCriterion("warning_rate >=", value, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateLessThan(Byte value) {
            addCriterion("warning_rate <", value, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateLessThanOrEqualTo(Byte value) {
            addCriterion("warning_rate <=", value, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateIn(List<Byte> values) {
            addCriterion("warning_rate in", values, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateNotIn(List<Byte> values) {
            addCriterion("warning_rate not in", values, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateBetween(Byte value1, Byte value2) {
            addCriterion("warning_rate between", value1, value2, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningRateNotBetween(Byte value1, Byte value2) {
            addCriterion("warning_rate not between", value1, value2, "warningRate");
            return (Criteria) this;
        }

        public Criteria andWarningObjectIsNull() {
            addCriterion("warning_object is null");
            return (Criteria) this;
        }

        public Criteria andWarningObjectIsNotNull() {
            addCriterion("warning_object is not null");
            return (Criteria) this;
        }

        public Criteria andWarningObjectEqualTo(Byte value) {
            addCriterion("warning_object =", value, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectNotEqualTo(Byte value) {
            addCriterion("warning_object <>", value, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectGreaterThan(Byte value) {
            addCriterion("warning_object >", value, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectGreaterThanOrEqualTo(Byte value) {
            addCriterion("warning_object >=", value, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectLessThan(Byte value) {
            addCriterion("warning_object <", value, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectLessThanOrEqualTo(Byte value) {
            addCriterion("warning_object <=", value, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectIn(List<Byte> values) {
            addCriterion("warning_object in", values, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectNotIn(List<Byte> values) {
            addCriterion("warning_object not in", values, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectBetween(Byte value1, Byte value2) {
            addCriterion("warning_object between", value1, value2, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningObjectNotBetween(Byte value1, Byte value2) {
            addCriterion("warning_object not between", value1, value2, "warningObject");
            return (Criteria) this;
        }

        public Criteria andWarningMethodIsNull() {
            addCriterion("warning_method is null");
            return (Criteria) this;
        }

        public Criteria andWarningMethodIsNotNull() {
            addCriterion("warning_method is not null");
            return (Criteria) this;
        }

        public Criteria andWarningMethodEqualTo(Byte value) {
            addCriterion("warning_method =", value, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodNotEqualTo(Byte value) {
            addCriterion("warning_method <>", value, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodGreaterThan(Byte value) {
            addCriterion("warning_method >", value, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("warning_method >=", value, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodLessThan(Byte value) {
            addCriterion("warning_method <", value, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodLessThanOrEqualTo(Byte value) {
            addCriterion("warning_method <=", value, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodIn(List<Byte> values) {
            addCriterion("warning_method in", values, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodNotIn(List<Byte> values) {
            addCriterion("warning_method not in", values, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodBetween(Byte value1, Byte value2) {
            addCriterion("warning_method between", value1, value2, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("warning_method not between", value1, value2, "warningMethod");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysIsNull() {
            addCriterion("warning-before_days is null");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysIsNotNull() {
            addCriterion("warning-before_days is not null");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysEqualTo(Integer value) {
            addCriterion("warning-before_days =", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotEqualTo(Integer value) {
            addCriterion("warning-before_days <>", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysGreaterThan(Integer value) {
            addCriterion("warning-before_days >", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("warning-before_days >=", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysLessThan(Integer value) {
            addCriterion("warning-before_days <", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysLessThanOrEqualTo(Integer value) {
            addCriterion("warning-before_days <=", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysIn(List<Integer> values) {
            addCriterion("warning-before_days in", values, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotIn(List<Integer> values) {
            addCriterion("warning-before_days not in", values, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysBetween(Integer value1, Integer value2) {
            addCriterion("warning-before_days between", value1, value2, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("warning-before_days not between", value1, value2, "warningBeforeDays");
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