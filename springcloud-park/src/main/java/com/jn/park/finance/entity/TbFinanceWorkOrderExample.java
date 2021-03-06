package com.jn.park.finance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFinanceWorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFinanceWorkOrderExample() {
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
            addCriterion("wo.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("wo.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("wo.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("wo.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("wo.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wo.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("wo.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("wo.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("wo.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("wo.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("wo.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wo.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("wo.order_Id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("wo.order_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("wo.order_Id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("wo.order_Id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("wo.order_Id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("wo.order_Id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("wo.order_Id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("wo.order_Id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("wo.order_Id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("wo.order_Id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("wo.order_Id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("wo.order_Id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("wo.order_Id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("wo.order_Id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("wo.department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("wo.department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("wo.department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("wo.department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("wo.department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("wo.department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("wo.department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("wo.department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("wo.department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("wo.department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("wo.department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("wo.department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("wo.department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("wo.department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("wo.department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("wo.department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("wo.department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("wo.department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("wo.department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("wo.department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("wo.department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("wo.department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("wo.department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("wo.department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("wo.department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("wo.department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("wo.department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("wo.department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNull() {
            addCriterion("wo.order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("wo.order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("wo.order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("wo.order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("wo.order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("wo.order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("wo.order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("wo.order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("wo.order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("wo.order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("wo.order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("wo.order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("wo.order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("wo.order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("wo.order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("wo.order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Byte value) {
            addCriterion("wo.order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Byte value) {
            addCriterion("wo.order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Byte value) {
            addCriterion("wo.order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("wo.order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Byte value) {
            addCriterion("wo.order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Byte value) {
            addCriterion("wo.order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Byte> values) {
            addCriterion("wo.order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Byte> values) {
            addCriterion("wo.order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Byte value1, Byte value2) {
            addCriterion("wo.order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("wo.order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherIsNull() {
            addCriterion("wo.order_publisher is null");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherIsNotNull() {
            addCriterion("wo.order_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherEqualTo(String value) {
            addCriterion("wo.order_publisher =", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherNotEqualTo(String value) {
            addCriterion("wo.order_publisher <>", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherGreaterThan(String value) {
            addCriterion("wo.order_publisher >", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("wo.order_publisher >=", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherLessThan(String value) {
            addCriterion("wo.order_publisher <", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherLessThanOrEqualTo(String value) {
            addCriterion("wo.order_publisher <=", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherLike(String value) {
            addCriterion("wo.order_publisher like", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherNotLike(String value) {
            addCriterion("wo.order_publisher not like", value, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherIn(List<String> values) {
            addCriterion("wo.order_publisher in", values, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherNotIn(List<String> values) {
            addCriterion("wo.order_publisher not in", values, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherBetween(String value1, String value2) {
            addCriterion("wo.order_publisher between", value1, value2, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherNotBetween(String value1, String value2) {
            addCriterion("wo.order_publisher not between", value1, value2, "orderPublisher");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeIsNull() {
            addCriterion("wo.order_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeIsNotNull() {
            addCriterion("wo.order_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeEqualTo(Date value) {
            addCriterion("wo.order_publish_time =", value, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeNotEqualTo(Date value) {
            addCriterion("wo.order_publish_time <>", value, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeGreaterThan(Date value) {
            addCriterion("wo.order_publish_time >", value, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wo.order_publish_time >=", value, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeLessThan(Date value) {
            addCriterion("wo.order_publish_time <", value, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("wo.order_publish_time <=", value, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeIn(List<Date> values) {
            addCriterion("wo.order_publish_time in", values, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeNotIn(List<Date> values) {
            addCriterion("wo.order_publish_time not in", values, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeBetween(Date value1, Date value2) {
            addCriterion("wo.order_publish_time between", value1, value2, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("wo.order_publish_time not between", value1, value2, "orderPublishTime");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentIsNull() {
            addCriterion("wo.order_publisher_comment is null");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentIsNotNull() {
            addCriterion("wo.order_publisher_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentEqualTo(String value) {
            addCriterion("wo.order_publisher_comment =", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentNotEqualTo(String value) {
            addCriterion("wo.order_publisher_comment <>", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentGreaterThan(String value) {
            addCriterion("wo.order_publisher_comment >", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentGreaterThanOrEqualTo(String value) {
            addCriterion("wo.order_publisher_comment >=", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentLessThan(String value) {
            addCriterion("wo.order_publisher_comment <", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentLessThanOrEqualTo(String value) {
            addCriterion("wo.order_publisher_comment <=", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentLike(String value) {
            addCriterion("wo.order_publisher_comment like", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentNotLike(String value) {
            addCriterion("wo.order_publisher_comment not like", value, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentIn(List<String> values) {
            addCriterion("wo.order_publisher_comment in", values, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentNotIn(List<String> values) {
            addCriterion("wo.order_publisher_comment not in", values, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentBetween(String value1, String value2) {
            addCriterion("wo.order_publisher_comment between", value1, value2, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderPublisherCommentNotBetween(String value1, String value2) {
            addCriterion("wo.order_publisher_comment not between", value1, value2, "orderPublisherComment");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateIsNull() {
            addCriterion("wo.order_auditing_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateIsNotNull() {
            addCriterion("wo.order_auditing_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateEqualTo(Byte value) {
            addCriterion("wo.order_auditing_state =", value, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateNotEqualTo(Byte value) {
            addCriterion("wo.order_auditing_state <>", value, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateGreaterThan(Byte value) {
            addCriterion("wo.order_auditing_state >", value, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("wo.order_auditing_state >=", value, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateLessThan(Byte value) {
            addCriterion("wo.order_auditing_state <", value, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateLessThanOrEqualTo(Byte value) {
            addCriterion("wo.order_auditing_state <=", value, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateIn(List<Byte> values) {
            addCriterion("wo.order_auditing_state in", values, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateNotIn(List<Byte> values) {
            addCriterion("wo.order_auditing_state not in", values, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateBetween(Byte value1, Byte value2) {
            addCriterion("wo.order_auditing_state between", value1, value2, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderAuditingStateNotBetween(Byte value1, Byte value2) {
            addCriterion("wo.order_auditing_state not between", value1, value2, "orderAuditingState");
            return (Criteria) this;
        }

        public Criteria andOrderDataIsNull() {
            addCriterion("wo.order_data is null");
            return (Criteria) this;
        }

        public Criteria andOrderDataIsNotNull() {
            addCriterion("wo.order_data is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDataEqualTo(String value) {
            addCriterion("wo.order_data =", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotEqualTo(String value) {
            addCriterion("wo.order_data <>", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataGreaterThan(String value) {
            addCriterion("wo.order_data >", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataGreaterThanOrEqualTo(String value) {
            addCriterion("wo.order_data >=", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataLessThan(String value) {
            addCriterion("wo.order_data <", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataLessThanOrEqualTo(String value) {
            addCriterion("wo.order_data <=", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataLike(String value) {
            addCriterion("wo.order_data like", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotLike(String value) {
            addCriterion("wo.order_data not like", value, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataIn(List<String> values) {
            addCriterion("wo.order_data in", values, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotIn(List<String> values) {
            addCriterion("wo.order_data not in", values, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataBetween(String value1, String value2) {
            addCriterion("wo.order_data between", value1, value2, "orderData");
            return (Criteria) this;
        }

        public Criteria andOrderDataNotBetween(String value1, String value2) {
            addCriterion("wo.order_data not between", value1, value2, "orderData");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("wo.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("wo.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("wo.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("wo.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("wo.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("wo.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("wo.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("wo.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("wo.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("wo.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("wo.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("wo.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("wo.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("wo.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("wo.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("wo.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("wo.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wo.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("wo.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("wo.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("wo.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("wo.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("wo.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("wo.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("wo.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("wo.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("wo.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("wo.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("wo.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("wo.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("wo.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wo.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("wo.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("wo.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("wo.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("wo.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("wo.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("wo.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("wo.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("wo.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("wo.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("wo.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("wo.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("wo.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("wo.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("wo.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("wo.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("wo.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("wo.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("wo.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("wo.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("wo.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("wo.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("wo.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("wo.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("wo.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("wo.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wo.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("wo.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("wo.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("wo.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("wo.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("wo.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("wo.modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andCheckProgressIsNull() {
            addCriterion("wo.check_progress is null");
            return (Criteria) this;
        }

        public Criteria andCheckProgressIsNotNull() {
            addCriterion("wo.check_progress is not null");
            return (Criteria) this;
        }

        public Criteria andCheckProgressEqualTo(String value) {
            addCriterion("wo.check_progress =", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressNotEqualTo(String value) {
            addCriterion("wo.check_progress <>", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressGreaterThan(String value) {
            addCriterion("wo.check_progress >", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressGreaterThanOrEqualTo(String value) {
            addCriterion("wo.check_progress >=", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressLessThan(String value) {
            addCriterion("wo.check_progress <", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressLessThanOrEqualTo(String value) {
            addCriterion("wo.check_progress <=", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressLike(String value) {
            addCriterion("wo.check_progress like", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressNotLike(String value) {
            addCriterion("wo.check_progress not like", value, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressIn(List<String> values) {
            addCriterion("wo.check_progress in", values, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressNotIn(List<String> values) {
            addCriterion("wo.check_progress not in", values, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressBetween(String value1, String value2) {
            addCriterion("wo.check_progress between", value1, value2, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckProgressNotBetween(String value1, String value2) {
            addCriterion("wo.check_progress not between", value1, value2, "checkProgress");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNull() {
            addCriterion("wo.check_state is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNotNull() {
            addCriterion("wo.check_state is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateEqualTo(Byte value) {
            addCriterion("wo.check_state =", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotEqualTo(Byte value) {
            addCriterion("wo.check_state <>", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThan(Byte value) {
            addCriterion("wo.check_state >", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("wo.check_state >=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThan(Byte value) {
            addCriterion("wo.check_state <", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThanOrEqualTo(Byte value) {
            addCriterion("wo.check_state <=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateIn(List<Byte> values) {
            addCriterion("wo.check_state in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotIn(List<Byte> values) {
            addCriterion("wo.check_state not in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateBetween(Byte value1, Byte value2) {
            addCriterion("wo.check_state between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotBetween(Byte value1, Byte value2) {
            addCriterion("wo.check_state not between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIsNull() {
            addCriterion("wo.check_comment is null");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIsNotNull() {
            addCriterion("wo.check_comment is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCommentEqualTo(String value) {
            addCriterion("wo.check_comment =", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotEqualTo(String value) {
            addCriterion("wo.check_comment <>", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentGreaterThan(String value) {
            addCriterion("wo.check_comment >", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentGreaterThanOrEqualTo(String value) {
            addCriterion("wo.check_comment >=", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLessThan(String value) {
            addCriterion("wo.check_comment <", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLessThanOrEqualTo(String value) {
            addCriterion("wo.check_comment <=", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLike(String value) {
            addCriterion("wo.check_comment like", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotLike(String value) {
            addCriterion("wo.check_comment not like", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIn(List<String> values) {
            addCriterion("wo.check_comment in", values, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotIn(List<String> values) {
            addCriterion("wo.check_comment not in", values, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentBetween(String value1, String value2) {
            addCriterion("wo.check_comment between", value1, value2, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotBetween(String value1, String value2) {
            addCriterion("wo.check_comment not between", value1, value2, "checkComment");
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