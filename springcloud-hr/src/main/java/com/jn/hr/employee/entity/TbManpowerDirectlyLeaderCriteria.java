package com.jn.hr.employee.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerDirectlyLeaderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerDirectlyLeaderCriteria() {
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

        public Criteria andDirectLeaderLevelIsNull() {
            addCriterion("direct_leader_level is null");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelIsNotNull() {
            addCriterion("direct_leader_level is not null");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelEqualTo(String value) {
            addCriterion("direct_leader_level =", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNotEqualTo(String value) {
            addCriterion("direct_leader_level <>", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelGreaterThan(String value) {
            addCriterion("direct_leader_level >", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelGreaterThanOrEqualTo(String value) {
            addCriterion("direct_leader_level >=", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelLessThan(String value) {
            addCriterion("direct_leader_level <", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelLessThanOrEqualTo(String value) {
            addCriterion("direct_leader_level <=", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelLike(String value) {
            addCriterion("direct_leader_level like", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNotLike(String value) {
            addCriterion("direct_leader_level not like", value, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelIn(List<String> values) {
            addCriterion("direct_leader_level in", values, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNotIn(List<String> values) {
            addCriterion("direct_leader_level not in", values, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelBetween(String value1, String value2) {
            addCriterion("direct_leader_level between", value1, value2, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNotBetween(String value1, String value2) {
            addCriterion("direct_leader_level not between", value1, value2, "directLeaderLevel");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipIsNull() {
            addCriterion("direct_leadership is null");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipIsNotNull() {
            addCriterion("direct_leadership is not null");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipEqualTo(String value) {
            addCriterion("direct_leadership =", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNotEqualTo(String value) {
            addCriterion("direct_leadership <>", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipGreaterThan(String value) {
            addCriterion("direct_leadership >", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipGreaterThanOrEqualTo(String value) {
            addCriterion("direct_leadership >=", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipLessThan(String value) {
            addCriterion("direct_leadership <", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipLessThanOrEqualTo(String value) {
            addCriterion("direct_leadership <=", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipLike(String value) {
            addCriterion("direct_leadership like", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNotLike(String value) {
            addCriterion("direct_leadership not like", value, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipIn(List<String> values) {
            addCriterion("direct_leadership in", values, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNotIn(List<String> values) {
            addCriterion("direct_leadership not in", values, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipBetween(String value1, String value2) {
            addCriterion("direct_leadership between", value1, value2, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNotBetween(String value1, String value2) {
            addCriterion("direct_leadership not between", value1, value2, "directLeadership");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameIsNull() {
            addCriterion("direct_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameIsNotNull() {
            addCriterion("direct_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameEqualTo(String value) {
            addCriterion("direct_leader_name =", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameNotEqualTo(String value) {
            addCriterion("direct_leader_name <>", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameGreaterThan(String value) {
            addCriterion("direct_leader_name >", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("direct_leader_name >=", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameLessThan(String value) {
            addCriterion("direct_leader_name <", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("direct_leader_name <=", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameLike(String value) {
            addCriterion("direct_leader_name like", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameNotLike(String value) {
            addCriterion("direct_leader_name not like", value, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameIn(List<String> values) {
            addCriterion("direct_leader_name in", values, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameNotIn(List<String> values) {
            addCriterion("direct_leader_name not in", values, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameBetween(String value1, String value2) {
            addCriterion("direct_leader_name between", value1, value2, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderNameNotBetween(String value1, String value2) {
            addCriterion("direct_leader_name not between", value1, value2, "directLeaderName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameIsNull() {
            addCriterion("direct_leader_level_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameIsNotNull() {
            addCriterion("direct_leader_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameEqualTo(String value) {
            addCriterion("direct_leader_level_name =", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameNotEqualTo(String value) {
            addCriterion("direct_leader_level_name <>", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameGreaterThan(String value) {
            addCriterion("direct_leader_level_name >", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("direct_leader_level_name >=", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameLessThan(String value) {
            addCriterion("direct_leader_level_name <", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameLessThanOrEqualTo(String value) {
            addCriterion("direct_leader_level_name <=", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameLike(String value) {
            addCriterion("direct_leader_level_name like", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameNotLike(String value) {
            addCriterion("direct_leader_level_name not like", value, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameIn(List<String> values) {
            addCriterion("direct_leader_level_name in", values, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameNotIn(List<String> values) {
            addCriterion("direct_leader_level_name not in", values, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameBetween(String value1, String value2) {
            addCriterion("direct_leader_level_name between", value1, value2, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeaderLevelNameNotBetween(String value1, String value2) {
            addCriterion("direct_leader_level_name not between", value1, value2, "directLeaderLevelName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameIsNull() {
            addCriterion("direct_leadership_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameIsNotNull() {
            addCriterion("direct_leadership_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameEqualTo(String value) {
            addCriterion("direct_leadership_name =", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameNotEqualTo(String value) {
            addCriterion("direct_leadership_name <>", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameGreaterThan(String value) {
            addCriterion("direct_leadership_name >", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameGreaterThanOrEqualTo(String value) {
            addCriterion("direct_leadership_name >=", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameLessThan(String value) {
            addCriterion("direct_leadership_name <", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameLessThanOrEqualTo(String value) {
            addCriterion("direct_leadership_name <=", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameLike(String value) {
            addCriterion("direct_leadership_name like", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameNotLike(String value) {
            addCriterion("direct_leadership_name not like", value, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameIn(List<String> values) {
            addCriterion("direct_leadership_name in", values, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameNotIn(List<String> values) {
            addCriterion("direct_leadership_name not in", values, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameBetween(String value1, String value2) {
            addCriterion("direct_leadership_name between", value1, value2, "directLeadershipName");
            return (Criteria) this;
        }

        public Criteria andDirectLeadershipNameNotBetween(String value1, String value2) {
            addCriterion("direct_leadership_name not between", value1, value2, "directLeadershipName");
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