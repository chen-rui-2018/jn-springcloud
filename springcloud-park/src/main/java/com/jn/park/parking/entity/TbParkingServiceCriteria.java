package com.jn.park.parking.entity;

import java.util.ArrayList;
import java.util.List;

public class TbParkingServiceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkingServiceCriteria() {
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

        public Criteria andParkingIdIsNull() {
            addCriterion("parking_id is null");
            return (Criteria) this;
        }

        public Criteria andParkingIdIsNotNull() {
            addCriterion("parking_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkingIdEqualTo(String value) {
            addCriterion("parking_id =", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotEqualTo(String value) {
            addCriterion("parking_id <>", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThan(String value) {
            addCriterion("parking_id >", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThanOrEqualTo(String value) {
            addCriterion("parking_id >=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThan(String value) {
            addCriterion("parking_id <", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThanOrEqualTo(String value) {
            addCriterion("parking_id <=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLike(String value) {
            addCriterion("parking_id like", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotLike(String value) {
            addCriterion("parking_id not like", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdIn(List<String> values) {
            addCriterion("parking_id in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotIn(List<String> values) {
            addCriterion("parking_id not in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdBetween(String value1, String value2) {
            addCriterion("parking_id between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotBetween(String value1, String value2) {
            addCriterion("parking_id not between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdIsNull() {
            addCriterion("server_type_id is null");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdIsNotNull() {
            addCriterion("server_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdEqualTo(String value) {
            addCriterion("server_type_id =", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdNotEqualTo(String value) {
            addCriterion("server_type_id <>", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdGreaterThan(String value) {
            addCriterion("server_type_id >", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("server_type_id >=", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdLessThan(String value) {
            addCriterion("server_type_id <", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdLessThanOrEqualTo(String value) {
            addCriterion("server_type_id <=", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdLike(String value) {
            addCriterion("server_type_id like", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdNotLike(String value) {
            addCriterion("server_type_id not like", value, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdIn(List<String> values) {
            addCriterion("server_type_id in", values, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdNotIn(List<String> values) {
            addCriterion("server_type_id not in", values, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdBetween(String value1, String value2) {
            addCriterion("server_type_id between", value1, value2, "serverTypeId");
            return (Criteria) this;
        }

        public Criteria andServerTypeIdNotBetween(String value1, String value2) {
            addCriterion("server_type_id not between", value1, value2, "serverTypeId");
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