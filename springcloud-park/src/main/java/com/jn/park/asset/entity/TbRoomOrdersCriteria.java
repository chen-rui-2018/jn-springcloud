package com.jn.park.asset.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbRoomOrdersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoomOrdersCriteria() {
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

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("room_id like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("room_id not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(String value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(String value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(String value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLike(String value) {
            addCriterion("floor like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotLike(String value) {
            addCriterion("floor not like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<String> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andTowerIdIsNull() {
            addCriterion("tower_id is null");
            return (Criteria) this;
        }

        public Criteria andTowerIdIsNotNull() {
            addCriterion("tower_id is not null");
            return (Criteria) this;
        }

        public Criteria andTowerIdEqualTo(String value) {
            addCriterion("tower_id =", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotEqualTo(String value) {
            addCriterion("tower_id <>", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdGreaterThan(String value) {
            addCriterion("tower_id >", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdGreaterThanOrEqualTo(String value) {
            addCriterion("tower_id >=", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdLessThan(String value) {
            addCriterion("tower_id <", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdLessThanOrEqualTo(String value) {
            addCriterion("tower_id <=", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdLike(String value) {
            addCriterion("tower_id like", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotLike(String value) {
            addCriterion("tower_id not like", value, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdIn(List<String> values) {
            addCriterion("tower_id in", values, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotIn(List<String> values) {
            addCriterion("tower_id not in", values, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdBetween(String value1, String value2) {
            addCriterion("tower_id between", value1, value2, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerIdNotBetween(String value1, String value2) {
            addCriterion("tower_id not between", value1, value2, "towerId");
            return (Criteria) this;
        }

        public Criteria andTowerNameIsNull() {
            addCriterion("tower_name is null");
            return (Criteria) this;
        }

        public Criteria andTowerNameIsNotNull() {
            addCriterion("tower_name is not null");
            return (Criteria) this;
        }

        public Criteria andTowerNameEqualTo(String value) {
            addCriterion("tower_name =", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotEqualTo(String value) {
            addCriterion("tower_name <>", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameGreaterThan(String value) {
            addCriterion("tower_name >", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("tower_name >=", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameLessThan(String value) {
            addCriterion("tower_name <", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameLessThanOrEqualTo(String value) {
            addCriterion("tower_name <=", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameLike(String value) {
            addCriterion("tower_name like", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotLike(String value) {
            addCriterion("tower_name not like", value, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameIn(List<String> values) {
            addCriterion("tower_name in", values, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotIn(List<String> values) {
            addCriterion("tower_name not in", values, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameBetween(String value1, String value2) {
            addCriterion("tower_name between", value1, value2, "towerName");
            return (Criteria) this;
        }

        public Criteria andTowerNameNotBetween(String value1, String value2) {
            addCriterion("tower_name not between", value1, value2, "towerName");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIsNull() {
            addCriterion("room_url is null");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIsNotNull() {
            addCriterion("room_url is not null");
            return (Criteria) this;
        }

        public Criteria andRoomUrlEqualTo(String value) {
            addCriterion("room_url =", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotEqualTo(String value) {
            addCriterion("room_url <>", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlGreaterThan(String value) {
            addCriterion("room_url >", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlGreaterThanOrEqualTo(String value) {
            addCriterion("room_url >=", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLessThan(String value) {
            addCriterion("room_url <", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLessThanOrEqualTo(String value) {
            addCriterion("room_url <=", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLike(String value) {
            addCriterion("room_url like", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotLike(String value) {
            addCriterion("room_url not like", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIn(List<String> values) {
            addCriterion("room_url in", values, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotIn(List<String> values) {
            addCriterion("room_url not in", values, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlBetween(String value1, String value2) {
            addCriterion("room_url between", value1, value2, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotBetween(String value1, String value2) {
            addCriterion("room_url not between", value1, value2, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeIsNull() {
            addCriterion("lease_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeIsNotNull() {
            addCriterion("lease_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time =", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time <>", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("lease_start_time >", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time >=", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("lease_start_time <", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_start_time <=", value, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("lease_start_time in", values, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("lease_start_time not in", values, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_start_time between", value1, value2, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_start_time not between", value1, value2, "leaseStartTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeIsNull() {
            addCriterion("lease_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeIsNotNull() {
            addCriterion("lease_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time =", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time <>", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("lease_end_time >", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time >=", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("lease_end_time <", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lease_end_time <=", value, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("lease_end_time in", values, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("lease_end_time not in", values, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_end_time between", value1, value2, "leaseEndTime");
            return (Criteria) this;
        }

        public Criteria andLeaseEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lease_end_time not between", value1, value2, "leaseEndTime");
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

        public Criteria andRoomAreaIsNull() {
            addCriterion("room_area is null");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIsNotNull() {
            addCriterion("room_area is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAreaEqualTo(String value) {
            addCriterion("room_area =", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotEqualTo(String value) {
            addCriterion("room_area <>", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaGreaterThan(String value) {
            addCriterion("room_area >", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaGreaterThanOrEqualTo(String value) {
            addCriterion("room_area >=", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLessThan(String value) {
            addCriterion("room_area <", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLessThanOrEqualTo(String value) {
            addCriterion("room_area <=", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLike(String value) {
            addCriterion("room_area like", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotLike(String value) {
            addCriterion("room_area not like", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIn(List<String> values) {
            addCriterion("room_area in", values, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotIn(List<String> values) {
            addCriterion("room_area not in", values, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaBetween(String value1, String value2) {
            addCriterion("room_area between", value1, value2, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotBetween(String value1, String value2) {
            addCriterion("room_area not between", value1, value2, "roomArea");
            return (Criteria) this;
        }

        public Criteria andLeasePriceIsNull() {
            addCriterion("lease_price is null");
            return (Criteria) this;
        }

        public Criteria andLeasePriceIsNotNull() {
            addCriterion("lease_price is not null");
            return (Criteria) this;
        }

        public Criteria andLeasePriceEqualTo(BigDecimal value) {
            addCriterion("lease_price =", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceNotEqualTo(BigDecimal value) {
            addCriterion("lease_price <>", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceGreaterThan(BigDecimal value) {
            addCriterion("lease_price >", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_price >=", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceLessThan(BigDecimal value) {
            addCriterion("lease_price <", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_price <=", value, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceIn(List<BigDecimal> values) {
            addCriterion("lease_price in", values, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceNotIn(List<BigDecimal> values) {
            addCriterion("lease_price not in", values, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_price between", value1, value2, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_price not between", value1, value2, "leasePrice");
            return (Criteria) this;
        }

        public Criteria andLeaseSumIsNull() {
            addCriterion("lease_sum is null");
            return (Criteria) this;
        }

        public Criteria andLeaseSumIsNotNull() {
            addCriterion("lease_sum is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseSumEqualTo(BigDecimal value) {
            addCriterion("lease_sum =", value, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumNotEqualTo(BigDecimal value) {
            addCriterion("lease_sum <>", value, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumGreaterThan(BigDecimal value) {
            addCriterion("lease_sum >", value, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_sum >=", value, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumLessThan(BigDecimal value) {
            addCriterion("lease_sum <", value, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_sum <=", value, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumIn(List<BigDecimal> values) {
            addCriterion("lease_sum in", values, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumNotIn(List<BigDecimal> values) {
            addCriterion("lease_sum not in", values, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_sum between", value1, value2, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andLeaseSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_sum not between", value1, value2, "leaseSum");
            return (Criteria) this;
        }

        public Criteria andPressPayIsNull() {
            addCriterion("press_pay is null");
            return (Criteria) this;
        }

        public Criteria andPressPayIsNotNull() {
            addCriterion("press_pay is not null");
            return (Criteria) this;
        }

        public Criteria andPressPayEqualTo(String value) {
            addCriterion("press_pay =", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayNotEqualTo(String value) {
            addCriterion("press_pay <>", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayGreaterThan(String value) {
            addCriterion("press_pay >", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayGreaterThanOrEqualTo(String value) {
            addCriterion("press_pay >=", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayLessThan(String value) {
            addCriterion("press_pay <", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayLessThanOrEqualTo(String value) {
            addCriterion("press_pay <=", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayLike(String value) {
            addCriterion("press_pay like", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayNotLike(String value) {
            addCriterion("press_pay not like", value, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayIn(List<String> values) {
            addCriterion("press_pay in", values, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayNotIn(List<String> values) {
            addCriterion("press_pay not in", values, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayBetween(String value1, String value2) {
            addCriterion("press_pay between", value1, value2, "pressPay");
            return (Criteria) this;
        }

        public Criteria andPressPayNotBetween(String value1, String value2) {
            addCriterion("press_pay not between", value1, value2, "pressPay");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseIsNull() {
            addCriterion("shortest_lease is null");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseIsNotNull() {
            addCriterion("shortest_lease is not null");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseEqualTo(String value) {
            addCriterion("shortest_lease =", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseNotEqualTo(String value) {
            addCriterion("shortest_lease <>", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseGreaterThan(String value) {
            addCriterion("shortest_lease >", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseGreaterThanOrEqualTo(String value) {
            addCriterion("shortest_lease >=", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseLessThan(String value) {
            addCriterion("shortest_lease <", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseLessThanOrEqualTo(String value) {
            addCriterion("shortest_lease <=", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseLike(String value) {
            addCriterion("shortest_lease like", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseNotLike(String value) {
            addCriterion("shortest_lease not like", value, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseIn(List<String> values) {
            addCriterion("shortest_lease in", values, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseNotIn(List<String> values) {
            addCriterion("shortest_lease not in", values, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseBetween(String value1, String value2) {
            addCriterion("shortest_lease between", value1, value2, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andShortestLeaseNotBetween(String value1, String value2) {
            addCriterion("shortest_lease not between", value1, value2, "shortestLease");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
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

        public Criteria andPaySumEqualTo(BigDecimal value) {
            addCriterion("pay_sum =", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotEqualTo(BigDecimal value) {
            addCriterion("pay_sum <>", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumGreaterThan(BigDecimal value) {
            addCriterion("pay_sum >", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_sum >=", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumLessThan(BigDecimal value) {
            addCriterion("pay_sum <", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_sum <=", value, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumIn(List<BigDecimal> values) {
            addCriterion("pay_sum in", values, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotIn(List<BigDecimal> values) {
            addCriterion("pay_sum not in", values, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_sum between", value1, value2, "paySum");
            return (Criteria) this;
        }

        public Criteria andPaySumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_sum not between", value1, value2, "paySum");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Byte value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Byte value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Byte value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Byte value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Byte value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Byte> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Byte> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Byte value1, Byte value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNull() {
            addCriterion("room_status is null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNotNull() {
            addCriterion("room_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusEqualTo(Byte value) {
            addCriterion("room_status =", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotEqualTo(Byte value) {
            addCriterion("room_status <>", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThan(Byte value) {
            addCriterion("room_status >", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("room_status >=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThan(Byte value) {
            addCriterion("room_status <", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThanOrEqualTo(Byte value) {
            addCriterion("room_status <=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIn(List<Byte> values) {
            addCriterion("room_status in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotIn(List<Byte> values) {
            addCriterion("room_status not in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusBetween(Byte value1, Byte value2) {
            addCriterion("room_status between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("room_status not between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeIsNull() {
            addCriterion("quit_apply_time is null");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeIsNotNull() {
            addCriterion("quit_apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("quit_apply_time =", value, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("quit_apply_time <>", value, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("quit_apply_time >", value, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("quit_apply_time >=", value, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeLessThan(Date value) {
            addCriterionForJDBCDate("quit_apply_time <", value, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("quit_apply_time <=", value, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("quit_apply_time in", values, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("quit_apply_time not in", values, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("quit_apply_time between", value1, value2, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitApplyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("quit_apply_time not between", value1, value2, "quitApplyTime");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumIsNull() {
            addCriterion("quit_penal_sum is null");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumIsNotNull() {
            addCriterion("quit_penal_sum is not null");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumEqualTo(BigDecimal value) {
            addCriterion("quit_penal_sum =", value, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumNotEqualTo(BigDecimal value) {
            addCriterion("quit_penal_sum <>", value, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumGreaterThan(BigDecimal value) {
            addCriterion("quit_penal_sum >", value, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("quit_penal_sum >=", value, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumLessThan(BigDecimal value) {
            addCriterion("quit_penal_sum <", value, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("quit_penal_sum <=", value, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumIn(List<BigDecimal> values) {
            addCriterion("quit_penal_sum in", values, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumNotIn(List<BigDecimal> values) {
            addCriterion("quit_penal_sum not in", values, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quit_penal_sum between", value1, value2, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitPenalSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quit_penal_sum not between", value1, value2, "quitPenalSum");
            return (Criteria) this;
        }

        public Criteria andQuitExplainIsNull() {
            addCriterion("quit_explain is null");
            return (Criteria) this;
        }

        public Criteria andQuitExplainIsNotNull() {
            addCriterion("quit_explain is not null");
            return (Criteria) this;
        }

        public Criteria andQuitExplainEqualTo(String value) {
            addCriterion("quit_explain =", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainNotEqualTo(String value) {
            addCriterion("quit_explain <>", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainGreaterThan(String value) {
            addCriterion("quit_explain >", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainGreaterThanOrEqualTo(String value) {
            addCriterion("quit_explain >=", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainLessThan(String value) {
            addCriterion("quit_explain <", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainLessThanOrEqualTo(String value) {
            addCriterion("quit_explain <=", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainLike(String value) {
            addCriterion("quit_explain like", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainNotLike(String value) {
            addCriterion("quit_explain not like", value, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainIn(List<String> values) {
            addCriterion("quit_explain in", values, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainNotIn(List<String> values) {
            addCriterion("quit_explain not in", values, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainBetween(String value1, String value2) {
            addCriterion("quit_explain between", value1, value2, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andQuitExplainNotBetween(String value1, String value2) {
            addCriterion("quit_explain not between", value1, value2, "quitExplain");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeIsNull() {
            addCriterion("practical_quit_time is null");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeIsNotNull() {
            addCriterion("practical_quit_time is not null");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeEqualTo(Date value) {
            addCriterionForJDBCDate("practical_quit_time =", value, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("practical_quit_time <>", value, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("practical_quit_time >", value, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("practical_quit_time >=", value, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeLessThan(Date value) {
            addCriterionForJDBCDate("practical_quit_time <", value, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("practical_quit_time <=", value, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeIn(List<Date> values) {
            addCriterionForJDBCDate("practical_quit_time in", values, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("practical_quit_time not in", values, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("practical_quit_time between", value1, value2, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andPracticalQuitTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("practical_quit_time not between", value1, value2, "practicalQuitTime");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusIsNull() {
            addCriterion("lease_apply_status is null");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusIsNotNull() {
            addCriterion("lease_apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusEqualTo(Byte value) {
            addCriterion("lease_apply_status =", value, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusNotEqualTo(Byte value) {
            addCriterion("lease_apply_status <>", value, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusGreaterThan(Byte value) {
            addCriterion("lease_apply_status >", value, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("lease_apply_status >=", value, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusLessThan(Byte value) {
            addCriterion("lease_apply_status <", value, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("lease_apply_status <=", value, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusIn(List<Byte> values) {
            addCriterion("lease_apply_status in", values, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusNotIn(List<Byte> values) {
            addCriterion("lease_apply_status not in", values, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusBetween(Byte value1, Byte value2) {
            addCriterion("lease_apply_status between", value1, value2, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLeaseApplyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("lease_apply_status not between", value1, value2, "leaseApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusIsNull() {
            addCriterion("quit_apply_status is null");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusIsNotNull() {
            addCriterion("quit_apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusEqualTo(Byte value) {
            addCriterion("quit_apply_status =", value, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusNotEqualTo(Byte value) {
            addCriterion("quit_apply_status <>", value, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusGreaterThan(Byte value) {
            addCriterion("quit_apply_status >", value, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("quit_apply_status >=", value, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusLessThan(Byte value) {
            addCriterion("quit_apply_status <", value, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("quit_apply_status <=", value, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusIn(List<Byte> values) {
            addCriterion("quit_apply_status in", values, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusNotIn(List<Byte> values) {
            addCriterion("quit_apply_status not in", values, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusBetween(Byte value1, Byte value2) {
            addCriterion("quit_apply_status between", value1, value2, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andQuitApplyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("quit_apply_status not between", value1, value2, "quitApplyStatus");
            return (Criteria) this;
        }

        public Criteria andIsReletIsNull() {
            addCriterion("is_relet is null");
            return (Criteria) this;
        }

        public Criteria andIsReletIsNotNull() {
            addCriterion("is_relet is not null");
            return (Criteria) this;
        }

        public Criteria andIsReletEqualTo(Byte value) {
            addCriterion("is_relet =", value, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletNotEqualTo(Byte value) {
            addCriterion("is_relet <>", value, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletGreaterThan(Byte value) {
            addCriterion("is_relet >", value, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_relet >=", value, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletLessThan(Byte value) {
            addCriterion("is_relet <", value, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletLessThanOrEqualTo(Byte value) {
            addCriterion("is_relet <=", value, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletIn(List<Byte> values) {
            addCriterion("is_relet in", values, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletNotIn(List<Byte> values) {
            addCriterion("is_relet not in", values, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletBetween(Byte value1, Byte value2) {
            addCriterion("is_relet between", value1, value2, "isRelet");
            return (Criteria) this;
        }

        public Criteria andIsReletNotBetween(Byte value1, Byte value2) {
            addCriterion("is_relet not between", value1, value2, "isRelet");
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