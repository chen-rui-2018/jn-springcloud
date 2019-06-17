package com.jn.park.asset.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbRoomOrdersBillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoomOrdersBillCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(String value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(String value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(String value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(String value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLike(String value) {
            addCriterion("enterprise_id like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotLike(String value) {
            addCriterion("enterprise_id not like", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<String> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<String> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(String value1, String value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIsNull() {
            addCriterion("lease_enterprise is null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIsNotNull() {
            addCriterion("lease_enterprise is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseEqualTo(String value) {
            addCriterion("lease_enterprise =", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNotEqualTo(String value) {
            addCriterion("lease_enterprise <>", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseGreaterThan(String value) {
            addCriterion("lease_enterprise >", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("lease_enterprise >=", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseLessThan(String value) {
            addCriterion("lease_enterprise <", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("lease_enterprise <=", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseLike(String value) {
            addCriterion("lease_enterprise like", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNotLike(String value) {
            addCriterion("lease_enterprise not like", value, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIn(List<String> values) {
            addCriterion("lease_enterprise in", values, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNotIn(List<String> values) {
            addCriterion("lease_enterprise not in", values, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseBetween(String value1, String value2) {
            addCriterion("lease_enterprise between", value1, value2, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseNotBetween(String value1, String value2) {
            addCriterion("lease_enterprise not between", value1, value2, "leaseEnterprise");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNull() {
            addCriterion("bill_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIsNotNull() {
            addCriterion("bill_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("bill_create_time =", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bill_create_time <>", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bill_create_time >", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_create_time >=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("bill_create_time <", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_create_time <=", value, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bill_create_time in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bill_create_time not in", values, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_create_time between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andBillCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_create_time not between", value1, value2, "billCreateTime");
            return (Criteria) this;
        }

        public Criteria andRoomsIsNull() {
            addCriterion("rooms is null");
            return (Criteria) this;
        }

        public Criteria andRoomsIsNotNull() {
            addCriterion("rooms is not null");
            return (Criteria) this;
        }

        public Criteria andRoomsEqualTo(String value) {
            addCriterion("rooms =", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotEqualTo(String value) {
            addCriterion("rooms <>", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsGreaterThan(String value) {
            addCriterion("rooms >", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsGreaterThanOrEqualTo(String value) {
            addCriterion("rooms >=", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLessThan(String value) {
            addCriterion("rooms <", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLessThanOrEqualTo(String value) {
            addCriterion("rooms <=", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLike(String value) {
            addCriterion("rooms like", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotLike(String value) {
            addCriterion("rooms not like", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsIn(List<String> values) {
            addCriterion("rooms in", values, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotIn(List<String> values) {
            addCriterion("rooms not in", values, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsBetween(String value1, String value2) {
            addCriterion("rooms between", value1, value2, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotBetween(String value1, String value2) {
            addCriterion("rooms not between", value1, value2, "rooms");
            return (Criteria) this;
        }

        public Criteria andBillInitSumIsNull() {
            addCriterion("bill_init_sum is null");
            return (Criteria) this;
        }

        public Criteria andBillInitSumIsNotNull() {
            addCriterion("bill_init_sum is not null");
            return (Criteria) this;
        }

        public Criteria andBillInitSumEqualTo(BigDecimal value) {
            addCriterion("bill_init_sum =", value, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumNotEqualTo(BigDecimal value) {
            addCriterion("bill_init_sum <>", value, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumGreaterThan(BigDecimal value) {
            addCriterion("bill_init_sum >", value, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_init_sum >=", value, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumLessThan(BigDecimal value) {
            addCriterion("bill_init_sum <", value, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_init_sum <=", value, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumIn(List<BigDecimal> values) {
            addCriterion("bill_init_sum in", values, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumNotIn(List<BigDecimal> values) {
            addCriterion("bill_init_sum not in", values, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_init_sum between", value1, value2, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillInitSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_init_sum not between", value1, value2, "billInitSum");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(Byte value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(Byte value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(Byte value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(Byte value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(Byte value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<Byte> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<Byte> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(Byte value1, Byte value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillSumIsNull() {
            addCriterion("bill_sum is null");
            return (Criteria) this;
        }

        public Criteria andBillSumIsNotNull() {
            addCriterion("bill_sum is not null");
            return (Criteria) this;
        }

        public Criteria andBillSumEqualTo(BigDecimal value) {
            addCriterion("bill_sum =", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumNotEqualTo(BigDecimal value) {
            addCriterion("bill_sum <>", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumGreaterThan(BigDecimal value) {
            addCriterion("bill_sum >", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_sum >=", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumLessThan(BigDecimal value) {
            addCriterion("bill_sum <", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bill_sum <=", value, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumIn(List<BigDecimal> values) {
            addCriterion("bill_sum in", values, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumNotIn(List<BigDecimal> values) {
            addCriterion("bill_sum not in", values, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_sum between", value1, value2, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bill_sum not between", value1, value2, "billSum");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeIsNull() {
            addCriterion("bill_confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeIsNotNull() {
            addCriterion("bill_confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeEqualTo(Date value) {
            addCriterionForJDBCDate("bill_confirm_time =", value, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bill_confirm_time <>", value, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bill_confirm_time >", value, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_confirm_time >=", value, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeLessThan(Date value) {
            addCriterionForJDBCDate("bill_confirm_time <", value, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_confirm_time <=", value, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bill_confirm_time in", values, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bill_confirm_time not in", values, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_confirm_time between", value1, value2, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_confirm_time not between", value1, value2, "billConfirmTime");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameIsNull() {
            addCriterion("bill_confirm_name is null");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameIsNotNull() {
            addCriterion("bill_confirm_name is not null");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameEqualTo(String value) {
            addCriterion("bill_confirm_name =", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameNotEqualTo(String value) {
            addCriterion("bill_confirm_name <>", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameGreaterThan(String value) {
            addCriterion("bill_confirm_name >", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameGreaterThanOrEqualTo(String value) {
            addCriterion("bill_confirm_name >=", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameLessThan(String value) {
            addCriterion("bill_confirm_name <", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameLessThanOrEqualTo(String value) {
            addCriterion("bill_confirm_name <=", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameLike(String value) {
            addCriterion("bill_confirm_name like", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameNotLike(String value) {
            addCriterion("bill_confirm_name not like", value, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameIn(List<String> values) {
            addCriterion("bill_confirm_name in", values, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameNotIn(List<String> values) {
            addCriterion("bill_confirm_name not in", values, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameBetween(String value1, String value2) {
            addCriterion("bill_confirm_name between", value1, value2, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andBillConfirmNameNotBetween(String value1, String value2) {
            addCriterion("bill_confirm_name not between", value1, value2, "billConfirmName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andBillCycleIsNull() {
            addCriterion("bill_cycle is null");
            return (Criteria) this;
        }

        public Criteria andBillCycleIsNotNull() {
            addCriterion("bill_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andBillCycleEqualTo(String value) {
            addCriterion("bill_cycle =", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotEqualTo(String value) {
            addCriterion("bill_cycle <>", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleGreaterThan(String value) {
            addCriterion("bill_cycle >", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleGreaterThanOrEqualTo(String value) {
            addCriterion("bill_cycle >=", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleLessThan(String value) {
            addCriterion("bill_cycle <", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleLessThanOrEqualTo(String value) {
            addCriterion("bill_cycle <=", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleLike(String value) {
            addCriterion("bill_cycle like", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotLike(String value) {
            addCriterion("bill_cycle not like", value, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleIn(List<String> values) {
            addCriterion("bill_cycle in", values, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotIn(List<String> values) {
            addCriterion("bill_cycle not in", values, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleBetween(String value1, String value2) {
            addCriterion("bill_cycle between", value1, value2, "billCycle");
            return (Criteria) this;
        }

        public Criteria andBillCycleNotBetween(String value1, String value2) {
            addCriterion("bill_cycle not between", value1, value2, "billCycle");
            return (Criteria) this;
        }

        public Criteria andPaySumIsNull() {
            addCriterion("pay_sum is null");
            return (Criteria) this;
        }

        public Criteria andPaySumIsNotNull() {
            addCriterion("pay_sum is not null");
            return (Criteria) this;
        }

        public Criteria andPaySumEqualTo(Byte value) {
            addCriterion("pay_sum =", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotEqualTo(Byte value) {
            addCriterion("pay_sum <>", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumGreaterThan(Byte value) {
            addCriterion("pay_sum >", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_sum >=", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumLessThan(Byte value) {
            addCriterion("pay_sum <", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumLessThanOrEqualTo(Byte value) {
            addCriterion("pay_sum <=", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumIn(List<Byte> values) {
            addCriterion("pay_sum in", values, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotIn(List<Byte> values) {
            addCriterion("pay_sum not in", values, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumBetween(Byte value1, Byte value2) {
            addCriterion("pay_sum between", value1, value2, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_sum not between", value1, value2, "paySum");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andExplainIsNull() {
            addCriterion("explain_ is null");
            return (Criteria) this;
        }

        public Criteria andExplainIsNotNull() {
            addCriterion("explain_ is not null");
            return (Criteria) this;
        }

        public Criteria andExplainEqualTo(String value) {
            addCriterion("explain_ =", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotEqualTo(String value) {
            addCriterion("explain_ <>", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThan(String value) {
            addCriterion("explain_ >", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThanOrEqualTo(String value) {
            addCriterion("explain_ >=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThan(String value) {
            addCriterion("explain_ <", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThanOrEqualTo(String value) {
            addCriterion("explain_ <=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLike(String value) {
            addCriterion("explain_ like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotLike(String value) {
            addCriterion("explain_ not like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainIn(List<String> values) {
            addCriterion("explain_ in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotIn(List<String> values) {
            addCriterion("explain_ not in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainBetween(String value1, String value2) {
            addCriterion("explain_ between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotBetween(String value1, String value2) {
            addCriterion("explain_ not between", value1, value2, "explain");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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