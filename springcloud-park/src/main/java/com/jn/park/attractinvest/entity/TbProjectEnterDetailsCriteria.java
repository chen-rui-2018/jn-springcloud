package com.jn.park.attractinvest.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProjectEnterDetailsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProjectEnterDetailsCriteria() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andEnterTowerIsNull() {
            addCriterion("enter_tower is null");
            return (Criteria) this;
        }

        public Criteria andEnterTowerIsNotNull() {
            addCriterion("enter_tower is not null");
            return (Criteria) this;
        }

        public Criteria andEnterTowerEqualTo(String value) {
            addCriterion("enter_tower =", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerNotEqualTo(String value) {
            addCriterion("enter_tower <>", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerGreaterThan(String value) {
            addCriterion("enter_tower >", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerGreaterThanOrEqualTo(String value) {
            addCriterion("enter_tower >=", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerLessThan(String value) {
            addCriterion("enter_tower <", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerLessThanOrEqualTo(String value) {
            addCriterion("enter_tower <=", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerLike(String value) {
            addCriterion("enter_tower like", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerNotLike(String value) {
            addCriterion("enter_tower not like", value, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerIn(List<String> values) {
            addCriterion("enter_tower in", values, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerNotIn(List<String> values) {
            addCriterion("enter_tower not in", values, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerBetween(String value1, String value2) {
            addCriterion("enter_tower between", value1, value2, "enterTower");
            return (Criteria) this;
        }

        public Criteria andEnterTowerNotBetween(String value1, String value2) {
            addCriterion("enter_tower not between", value1, value2, "enterTower");
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

        public Criteria andCompactPeriodIsNull() {
            addCriterion("compact_period is null");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodIsNotNull() {
            addCriterion("compact_period is not null");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodEqualTo(String value) {
            addCriterion("compact_period =", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodNotEqualTo(String value) {
            addCriterion("compact_period <>", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodGreaterThan(String value) {
            addCriterion("compact_period >", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("compact_period >=", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodLessThan(String value) {
            addCriterion("compact_period <", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodLessThanOrEqualTo(String value) {
            addCriterion("compact_period <=", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodLike(String value) {
            addCriterion("compact_period like", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodNotLike(String value) {
            addCriterion("compact_period not like", value, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodIn(List<String> values) {
            addCriterion("compact_period in", values, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodNotIn(List<String> values) {
            addCriterion("compact_period not in", values, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodBetween(String value1, String value2) {
            addCriterion("compact_period between", value1, value2, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andCompactPeriodNotBetween(String value1, String value2) {
            addCriterion("compact_period not between", value1, value2, "compactPeriod");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceIsNull() {
            addCriterion("room_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceIsNotNull() {
            addCriterion("room_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceEqualTo(BigDecimal value) {
            addCriterion("room_unit_price =", value, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("room_unit_price <>", value, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("room_unit_price >", value, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("room_unit_price >=", value, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceLessThan(BigDecimal value) {
            addCriterion("room_unit_price <", value, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("room_unit_price <=", value, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceIn(List<BigDecimal> values) {
            addCriterion("room_unit_price in", values, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("room_unit_price not in", values, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("room_unit_price between", value1, value2, "roomUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRoomUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("room_unit_price not between", value1, value2, "roomUnitPrice");
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

        public Criteria andAccordingAreaAccoutIsNull() {
            addCriterion("according_area_accout is null");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutIsNotNull() {
            addCriterion("according_area_accout is not null");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutEqualTo(BigDecimal value) {
            addCriterion("according_area_accout =", value, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutNotEqualTo(BigDecimal value) {
            addCriterion("according_area_accout <>", value, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutGreaterThan(BigDecimal value) {
            addCriterion("according_area_accout >", value, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("according_area_accout >=", value, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutLessThan(BigDecimal value) {
            addCriterion("according_area_accout <", value, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("according_area_accout <=", value, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutIn(List<BigDecimal> values) {
            addCriterion("according_area_accout in", values, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutNotIn(List<BigDecimal> values) {
            addCriterion("according_area_accout not in", values, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("according_area_accout between", value1, value2, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingAreaAccoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("according_area_accout not between", value1, value2, "accordingAreaAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutIsNull() {
            addCriterion("according_comp_accout is null");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutIsNotNull() {
            addCriterion("according_comp_accout is not null");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutEqualTo(BigDecimal value) {
            addCriterion("according_comp_accout =", value, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutNotEqualTo(BigDecimal value) {
            addCriterion("according_comp_accout <>", value, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutGreaterThan(BigDecimal value) {
            addCriterion("according_comp_accout >", value, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("according_comp_accout >=", value, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutLessThan(BigDecimal value) {
            addCriterion("according_comp_accout <", value, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("according_comp_accout <=", value, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutIn(List<BigDecimal> values) {
            addCriterion("according_comp_accout in", values, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutNotIn(List<BigDecimal> values) {
            addCriterion("according_comp_accout not in", values, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("according_comp_accout between", value1, value2, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andAccordingCompAccoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("according_comp_accout not between", value1, value2, "accordingCompAccout");
            return (Criteria) this;
        }

        public Criteria andFreeAccountIsNull() {
            addCriterion("free_account is null");
            return (Criteria) this;
        }

        public Criteria andFreeAccountIsNotNull() {
            addCriterion("free_account is not null");
            return (Criteria) this;
        }

        public Criteria andFreeAccountEqualTo(BigDecimal value) {
            addCriterion("free_account =", value, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountNotEqualTo(BigDecimal value) {
            addCriterion("free_account <>", value, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountGreaterThan(BigDecimal value) {
            addCriterion("free_account >", value, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("free_account >=", value, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountLessThan(BigDecimal value) {
            addCriterion("free_account <", value, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("free_account <=", value, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountIn(List<BigDecimal> values) {
            addCriterion("free_account in", values, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountNotIn(List<BigDecimal> values) {
            addCriterion("free_account not in", values, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_account between", value1, value2, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andFreeAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_account not between", value1, value2, "freeAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountIsNull() {
            addCriterion("actual_account is null");
            return (Criteria) this;
        }

        public Criteria andActualAccountIsNotNull() {
            addCriterion("actual_account is not null");
            return (Criteria) this;
        }

        public Criteria andActualAccountEqualTo(BigDecimal value) {
            addCriterion("actual_account =", value, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountNotEqualTo(BigDecimal value) {
            addCriterion("actual_account <>", value, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountGreaterThan(BigDecimal value) {
            addCriterion("actual_account >", value, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_account >=", value, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountLessThan(BigDecimal value) {
            addCriterion("actual_account <", value, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_account <=", value, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountIn(List<BigDecimal> values) {
            addCriterion("actual_account in", values, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountNotIn(List<BigDecimal> values) {
            addCriterion("actual_account not in", values, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_account between", value1, value2, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andActualAccountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_account not between", value1, value2, "actualAccount");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceIsNull() {
            addCriterion("pm_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceIsNotNull() {
            addCriterion("pm_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceEqualTo(BigDecimal value) {
            addCriterion("pm_unit_price =", value, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("pm_unit_price <>", value, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("pm_unit_price >", value, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pm_unit_price >=", value, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceLessThan(BigDecimal value) {
            addCriterion("pm_unit_price <", value, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pm_unit_price <=", value, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceIn(List<BigDecimal> values) {
            addCriterion("pm_unit_price in", values, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("pm_unit_price not in", values, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pm_unit_price between", value1, value2, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPmUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pm_unit_price not between", value1, value2, "pmUnitPrice");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionIsNull() {
            addCriterion("electricity_consumption is null");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionIsNotNull() {
            addCriterion("electricity_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionEqualTo(BigDecimal value) {
            addCriterion("electricity_consumption =", value, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionNotEqualTo(BigDecimal value) {
            addCriterion("electricity_consumption <>", value, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionGreaterThan(BigDecimal value) {
            addCriterion("electricity_consumption >", value, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("electricity_consumption >=", value, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionLessThan(BigDecimal value) {
            addCriterion("electricity_consumption <", value, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("electricity_consumption <=", value, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionIn(List<BigDecimal> values) {
            addCriterion("electricity_consumption in", values, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionNotIn(List<BigDecimal> values) {
            addCriterion("electricity_consumption not in", values, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricity_consumption between", value1, value2, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andElectricityConsumptionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricity_consumption not between", value1, value2, "electricityConsumption");
            return (Criteria) this;
        }

        public Criteria andDepositCashIsNull() {
            addCriterion("deposit_cash is null");
            return (Criteria) this;
        }

        public Criteria andDepositCashIsNotNull() {
            addCriterion("deposit_cash is not null");
            return (Criteria) this;
        }

        public Criteria andDepositCashEqualTo(BigDecimal value) {
            addCriterion("deposit_cash =", value, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashNotEqualTo(BigDecimal value) {
            addCriterion("deposit_cash <>", value, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashGreaterThan(BigDecimal value) {
            addCriterion("deposit_cash >", value, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit_cash >=", value, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashLessThan(BigDecimal value) {
            addCriterion("deposit_cash <", value, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit_cash <=", value, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashIn(List<BigDecimal> values) {
            addCriterion("deposit_cash in", values, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashNotIn(List<BigDecimal> values) {
            addCriterion("deposit_cash not in", values, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit_cash between", value1, value2, "depositCash");
            return (Criteria) this;
        }

        public Criteria andDepositCashNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit_cash not between", value1, value2, "depositCash");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseIsNull() {
            addCriterion("tax_promise is null");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseIsNotNull() {
            addCriterion("tax_promise is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseEqualTo(String value) {
            addCriterion("tax_promise =", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseNotEqualTo(String value) {
            addCriterion("tax_promise <>", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseGreaterThan(String value) {
            addCriterion("tax_promise >", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseGreaterThanOrEqualTo(String value) {
            addCriterion("tax_promise >=", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseLessThan(String value) {
            addCriterion("tax_promise <", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseLessThanOrEqualTo(String value) {
            addCriterion("tax_promise <=", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseLike(String value) {
            addCriterion("tax_promise like", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseNotLike(String value) {
            addCriterion("tax_promise not like", value, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseIn(List<String> values) {
            addCriterion("tax_promise in", values, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseNotIn(List<String> values) {
            addCriterion("tax_promise not in", values, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseBetween(String value1, String value2) {
            addCriterion("tax_promise between", value1, value2, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andTaxPromiseNotBetween(String value1, String value2) {
            addCriterion("tax_promise not between", value1, value2, "taxPromise");
            return (Criteria) this;
        }

        public Criteria andFreeClauseIsNull() {
            addCriterion("free_clause is null");
            return (Criteria) this;
        }

        public Criteria andFreeClauseIsNotNull() {
            addCriterion("free_clause is not null");
            return (Criteria) this;
        }

        public Criteria andFreeClauseEqualTo(String value) {
            addCriterion("free_clause =", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseNotEqualTo(String value) {
            addCriterion("free_clause <>", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseGreaterThan(String value) {
            addCriterion("free_clause >", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseGreaterThanOrEqualTo(String value) {
            addCriterion("free_clause >=", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseLessThan(String value) {
            addCriterion("free_clause <", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseLessThanOrEqualTo(String value) {
            addCriterion("free_clause <=", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseLike(String value) {
            addCriterion("free_clause like", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseNotLike(String value) {
            addCriterion("free_clause not like", value, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseIn(List<String> values) {
            addCriterion("free_clause in", values, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseNotIn(List<String> values) {
            addCriterion("free_clause not in", values, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseBetween(String value1, String value2) {
            addCriterion("free_clause between", value1, value2, "freeClause");
            return (Criteria) this;
        }

        public Criteria andFreeClauseNotBetween(String value1, String value2) {
            addCriterion("free_clause not between", value1, value2, "freeClause");
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