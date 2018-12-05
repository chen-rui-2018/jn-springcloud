package com.jn.portals.activity.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbActivityFileCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbActivityFileCriteria() {
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
            addCriterion("activityFile.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("activityFile.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("activityFile.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("activityFile.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("activityFile.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityFile.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("activityFile.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("activityFile.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("activityFile.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("activityFile.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("activityFile.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("activityFile.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("activityFile.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("activityFile.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("activityFile.type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("activityFile.type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("activityFile.type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("activityFile.type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("activityFile.type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("activityFile.type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("activityFile.type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("activityFile.type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("activityFile.type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("activityFile.type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("activityFile.type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("activityFile.type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("activityFile.type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("activityFile.type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andFileSrcIsNull() {
            addCriterion("activityFile.file_src is null");
            return (Criteria) this;
        }

        public Criteria andFileSrcIsNotNull() {
            addCriterion("activityFile.file_src is not null");
            return (Criteria) this;
        }

        public Criteria andFileSrcEqualTo(String value) {
            addCriterion("activityFile.file_src =", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcNotEqualTo(String value) {
            addCriterion("activityFile.file_src <>", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcGreaterThan(String value) {
            addCriterion("activityFile.file_src >", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcGreaterThanOrEqualTo(String value) {
            addCriterion("activityFile.file_src >=", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcLessThan(String value) {
            addCriterion("activityFile.file_src <", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcLessThanOrEqualTo(String value) {
            addCriterion("activityFile.file_src <=", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcLike(String value) {
            addCriterion("activityFile.file_src like", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcNotLike(String value) {
            addCriterion("activityFile.file_src not like", value, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcIn(List<String> values) {
            addCriterion("activityFile.file_src in", values, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcNotIn(List<String> values) {
            addCriterion("activityFile.file_src not in", values, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcBetween(String value1, String value2) {
            addCriterion("activityFile.file_src between", value1, value2, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andFileSrcNotBetween(String value1, String value2) {
            addCriterion("activityFile.file_src not between", value1, value2, "fileSrc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("activityFile.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("activityFile.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("activityFile.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("activityFile.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("activityFile.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityFile.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("activityFile.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("activityFile.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("activityFile.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("activityFile.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("activityFile.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("activityFile.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNull() {
            addCriterion("activityFile.update_account is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIsNotNull() {
            addCriterion("activityFile.update_account is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountEqualTo(String value) {
            addCriterion("activityFile.update_account =", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotEqualTo(String value) {
            addCriterion("activityFile.update_account <>", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThan(String value) {
            addCriterion("activityFile.update_account >", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("activityFile.update_account >=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThan(String value) {
            addCriterion("activityFile.update_account <", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLessThanOrEqualTo(String value) {
            addCriterion("activityFile.update_account <=", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountLike(String value) {
            addCriterion("activityFile.update_account like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotLike(String value) {
            addCriterion("activityFile.update_account not like", value, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountIn(List<String> values) {
            addCriterion("activityFile.update_account in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotIn(List<String> values) {
            addCriterion("activityFile.update_account not in", values, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountBetween(String value1, String value2) {
            addCriterion("activityFile.update_account between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateAccountNotBetween(String value1, String value2) {
            addCriterion("activityFile.update_account not between", value1, value2, "updateAccount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("activityFile.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("activityFile.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("activityFile.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("activityFile.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("activityFile.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityFile.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("activityFile.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("activityFile.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("activityFile.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("activityFile.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("activityFile.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("activityFile.update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("activityFile.state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("activityFile.state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("activityFile.state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("activityFile.state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("activityFile.state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("activityFile.state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("activityFile.state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("activityFile.state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("activityFile.state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("activityFile.state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("activityFile.state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("activityFile.state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("activityFile.state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("activityFile.state not between", value1, value2, "state");
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