package com.jn.hr.train.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerTrainRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerTrainRecordCriteria() {
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

        public Criteria andManagementIdIsNull() {
            addCriterion("management_id is null");
            return (Criteria) this;
        }

        public Criteria andManagementIdIsNotNull() {
            addCriterion("management_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagementIdEqualTo(String value) {
            addCriterion("management_id =", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdNotEqualTo(String value) {
            addCriterion("management_id <>", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdGreaterThan(String value) {
            addCriterion("management_id >", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdGreaterThanOrEqualTo(String value) {
            addCriterion("management_id >=", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdLessThan(String value) {
            addCriterion("management_id <", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdLessThanOrEqualTo(String value) {
            addCriterion("management_id <=", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdLike(String value) {
            addCriterion("management_id like", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdNotLike(String value) {
            addCriterion("management_id not like", value, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdIn(List<String> values) {
            addCriterion("management_id in", values, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdNotIn(List<String> values) {
            addCriterion("management_id not in", values, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdBetween(String value1, String value2) {
            addCriterion("management_id between", value1, value2, "managementId");
            return (Criteria) this;
        }

        public Criteria andManagementIdNotBetween(String value1, String value2) {
            addCriterion("management_id not between", value1, value2, "managementId");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentIsNull() {
            addCriterion("trainer_department is null");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentIsNotNull() {
            addCriterion("trainer_department is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentEqualTo(String value) {
            addCriterion("trainer_department =", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentNotEqualTo(String value) {
            addCriterion("trainer_department <>", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentGreaterThan(String value) {
            addCriterion("trainer_department >", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("trainer_department >=", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentLessThan(String value) {
            addCriterion("trainer_department <", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentLessThanOrEqualTo(String value) {
            addCriterion("trainer_department <=", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentLike(String value) {
            addCriterion("trainer_department like", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentNotLike(String value) {
            addCriterion("trainer_department not like", value, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentIn(List<String> values) {
            addCriterion("trainer_department in", values, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentNotIn(List<String> values) {
            addCriterion("trainer_department not in", values, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentBetween(String value1, String value2) {
            addCriterion("trainer_department between", value1, value2, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerDepartmentNotBetween(String value1, String value2) {
            addCriterion("trainer_department not between", value1, value2, "trainerDepartment");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberIsNull() {
            addCriterion("trainer_job_number is null");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberIsNotNull() {
            addCriterion("trainer_job_number is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberEqualTo(String value) {
            addCriterion("trainer_job_number =", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberNotEqualTo(String value) {
            addCriterion("trainer_job_number <>", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberGreaterThan(String value) {
            addCriterion("trainer_job_number >", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberGreaterThanOrEqualTo(String value) {
            addCriterion("trainer_job_number >=", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberLessThan(String value) {
            addCriterion("trainer_job_number <", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberLessThanOrEqualTo(String value) {
            addCriterion("trainer_job_number <=", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberLike(String value) {
            addCriterion("trainer_job_number like", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberNotLike(String value) {
            addCriterion("trainer_job_number not like", value, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberIn(List<String> values) {
            addCriterion("trainer_job_number in", values, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberNotIn(List<String> values) {
            addCriterion("trainer_job_number not in", values, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberBetween(String value1, String value2) {
            addCriterion("trainer_job_number between", value1, value2, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerJobNumberNotBetween(String value1, String value2) {
            addCriterion("trainer_job_number not between", value1, value2, "trainerJobNumber");
            return (Criteria) this;
        }

        public Criteria andTrainerNameIsNull() {
            addCriterion("trainer_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainerNameIsNotNull() {
            addCriterion("trainer_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainerNameEqualTo(String value) {
            addCriterion("trainer_name =", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotEqualTo(String value) {
            addCriterion("trainer_name <>", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameGreaterThan(String value) {
            addCriterion("trainer_name >", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameGreaterThanOrEqualTo(String value) {
            addCriterion("trainer_name >=", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameLessThan(String value) {
            addCriterion("trainer_name <", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameLessThanOrEqualTo(String value) {
            addCriterion("trainer_name <=", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameLike(String value) {
            addCriterion("trainer_name like", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotLike(String value) {
            addCriterion("trainer_name not like", value, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameIn(List<String> values) {
            addCriterion("trainer_name in", values, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotIn(List<String> values) {
            addCriterion("trainer_name not in", values, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameBetween(String value1, String value2) {
            addCriterion("trainer_name between", value1, value2, "trainerName");
            return (Criteria) this;
        }

        public Criteria andTrainerNameNotBetween(String value1, String value2) {
            addCriterion("trainer_name not between", value1, value2, "trainerName");
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