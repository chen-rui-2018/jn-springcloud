package com.jn.park.pmpaybill.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TbPmPayBillItemPmListCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPmPayBillItemPmListCriteria() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andPmNameIsNull() {
            addCriterion("pm_name is null");
            return (Criteria) this;
        }

        public Criteria andPmNameIsNotNull() {
            addCriterion("pm_name is not null");
            return (Criteria) this;
        }

        public Criteria andPmNameEqualTo(String value) {
            addCriterion("pm_name =", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotEqualTo(String value) {
            addCriterion("pm_name <>", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameGreaterThan(String value) {
            addCriterion("pm_name >", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameGreaterThanOrEqualTo(String value) {
            addCriterion("pm_name >=", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLessThan(String value) {
            addCriterion("pm_name <", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLessThanOrEqualTo(String value) {
            addCriterion("pm_name <=", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLike(String value) {
            addCriterion("pm_name like", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotLike(String value) {
            addCriterion("pm_name not like", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameIn(List<String> values) {
            addCriterion("pm_name in", values, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotIn(List<String> values) {
            addCriterion("pm_name not in", values, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameBetween(String value1, String value2) {
            addCriterion("pm_name between", value1, value2, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotBetween(String value1, String value2) {
            addCriterion("pm_name not between", value1, value2, "pmName");
            return (Criteria) this;
        }

        public Criteria andRoomAddressIsNull() {
            addCriterion("room_address is null");
            return (Criteria) this;
        }

        public Criteria andRoomAddressIsNotNull() {
            addCriterion("room_address is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAddressEqualTo(String value) {
            addCriterion("room_address =", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotEqualTo(String value) {
            addCriterion("room_address <>", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressGreaterThan(String value) {
            addCriterion("room_address >", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressGreaterThanOrEqualTo(String value) {
            addCriterion("room_address >=", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressLessThan(String value) {
            addCriterion("room_address <", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressLessThanOrEqualTo(String value) {
            addCriterion("room_address <=", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressLike(String value) {
            addCriterion("room_address like", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotLike(String value) {
            addCriterion("room_address not like", value, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressIn(List<String> values) {
            addCriterion("room_address in", values, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotIn(List<String> values) {
            addCriterion("room_address not in", values, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressBetween(String value1, String value2) {
            addCriterion("room_address between", value1, value2, "roomAddress");
            return (Criteria) this;
        }

        public Criteria andRoomAddressNotBetween(String value1, String value2) {
            addCriterion("room_address not between", value1, value2, "roomAddress");
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andRentalAreaIsNull() {
            addCriterion("rental_area is null");
            return (Criteria) this;
        }

        public Criteria andRentalAreaIsNotNull() {
            addCriterion("rental_area is not null");
            return (Criteria) this;
        }

        public Criteria andRentalAreaEqualTo(BigDecimal value) {
            addCriterion("rental_area =", value, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaNotEqualTo(BigDecimal value) {
            addCriterion("rental_area <>", value, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaGreaterThan(BigDecimal value) {
            addCriterion("rental_area >", value, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rental_area >=", value, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaLessThan(BigDecimal value) {
            addCriterion("rental_area <", value, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rental_area <=", value, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaIn(List<BigDecimal> values) {
            addCriterion("rental_area in", values, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaNotIn(List<BigDecimal> values) {
            addCriterion("rental_area not in", values, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rental_area between", value1, value2, "rentalArea");
            return (Criteria) this;
        }

        public Criteria andRentalAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rental_area not between", value1, value2, "rentalArea");
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