package com.jn.park.parking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParkingAreaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkingAreaCriteria() {
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

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id_ is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(String value) {
            addCriterion("area_id_ =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(String value) {
            addCriterion("area_id_ <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(String value) {
            addCriterion("area_id_ >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(String value) {
            addCriterion("area_id_ >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(String value) {
            addCriterion("area_id_ <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(String value) {
            addCriterion("area_id_ <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLike(String value) {
            addCriterion("area_id_ like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotLike(String value) {
            addCriterion("area_id_ not like", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<String> values) {
            addCriterion("area_id_ in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<String> values) {
            addCriterion("area_id_ not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(String value1, String value2) {
            addCriterion("area_id_ between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(String value1, String value2) {
            addCriterion("area_id_ not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaAddressIsNull() {
            addCriterion("area_address is null");
            return (Criteria) this;
        }

        public Criteria andAreaAddressIsNotNull() {
            addCriterion("area_address is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAddressEqualTo(String value) {
            addCriterion("area_address =", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotEqualTo(String value) {
            addCriterion("area_address <>", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressGreaterThan(String value) {
            addCriterion("area_address >", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressGreaterThanOrEqualTo(String value) {
            addCriterion("area_address >=", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressLessThan(String value) {
            addCriterion("area_address <", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressLessThanOrEqualTo(String value) {
            addCriterion("area_address <=", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressLike(String value) {
            addCriterion("area_address like", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotLike(String value) {
            addCriterion("area_address not like", value, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressIn(List<String> values) {
            addCriterion("area_address in", values, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotIn(List<String> values) {
            addCriterion("area_address not in", values, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressBetween(String value1, String value2) {
            addCriterion("area_address between", value1, value2, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andAreaAddressNotBetween(String value1, String value2) {
            addCriterion("area_address not between", value1, value2, "areaAddress");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberIsNull() {
            addCriterion("leisure_number is null");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberIsNotNull() {
            addCriterion("leisure_number is not null");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberEqualTo(Integer value) {
            addCriterion("leisure_number =", value, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberNotEqualTo(Integer value) {
            addCriterion("leisure_number <>", value, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberGreaterThan(Integer value) {
            addCriterion("leisure_number >", value, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("leisure_number >=", value, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberLessThan(Integer value) {
            addCriterion("leisure_number <", value, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberLessThanOrEqualTo(Integer value) {
            addCriterion("leisure_number <=", value, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberIn(List<Integer> values) {
            addCriterion("leisure_number in", values, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberNotIn(List<Integer> values) {
            addCriterion("leisure_number not in", values, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberBetween(Integer value1, Integer value2) {
            addCriterion("leisure_number between", value1, value2, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andLeisureNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("leisure_number not between", value1, value2, "leisureNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberIsNull() {
            addCriterion("rent_number is null");
            return (Criteria) this;
        }

        public Criteria andRentNumberIsNotNull() {
            addCriterion("rent_number is not null");
            return (Criteria) this;
        }

        public Criteria andRentNumberEqualTo(Integer value) {
            addCriterion("rent_number =", value, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberNotEqualTo(Integer value) {
            addCriterion("rent_number <>", value, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberGreaterThan(Integer value) {
            addCriterion("rent_number >", value, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_number >=", value, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberLessThan(Integer value) {
            addCriterion("rent_number <", value, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("rent_number <=", value, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberIn(List<Integer> values) {
            addCriterion("rent_number in", values, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberNotIn(List<Integer> values) {
            addCriterion("rent_number not in", values, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberBetween(Integer value1, Integer value2) {
            addCriterion("rent_number between", value1, value2, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andRentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_number not between", value1, value2, "rentNumber");
            return (Criteria) this;
        }

        public Criteria andParkingTotalIsNull() {
            addCriterion("parking_total is null");
            return (Criteria) this;
        }

        public Criteria andParkingTotalIsNotNull() {
            addCriterion("parking_total is not null");
            return (Criteria) this;
        }

        public Criteria andParkingTotalEqualTo(Integer value) {
            addCriterion("parking_total =", value, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalNotEqualTo(Integer value) {
            addCriterion("parking_total <>", value, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalGreaterThan(Integer value) {
            addCriterion("parking_total >", value, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_total >=", value, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalLessThan(Integer value) {
            addCriterion("parking_total <", value, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalLessThanOrEqualTo(Integer value) {
            addCriterion("parking_total <=", value, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalIn(List<Integer> values) {
            addCriterion("parking_total in", values, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalNotIn(List<Integer> values) {
            addCriterion("parking_total not in", values, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalBetween(Integer value1, Integer value2) {
            addCriterion("parking_total between", value1, value2, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andParkingTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_total not between", value1, value2, "parkingTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictIsNull() {
            addCriterion("temp_price_depict is null");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictIsNotNull() {
            addCriterion("temp_price_depict is not null");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictEqualTo(String value) {
            addCriterion("temp_price_depict =", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictNotEqualTo(String value) {
            addCriterion("temp_price_depict <>", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictGreaterThan(String value) {
            addCriterion("temp_price_depict >", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictGreaterThanOrEqualTo(String value) {
            addCriterion("temp_price_depict >=", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictLessThan(String value) {
            addCriterion("temp_price_depict <", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictLessThanOrEqualTo(String value) {
            addCriterion("temp_price_depict <=", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictLike(String value) {
            addCriterion("temp_price_depict like", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictNotLike(String value) {
            addCriterion("temp_price_depict not like", value, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictIn(List<String> values) {
            addCriterion("temp_price_depict in", values, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictNotIn(List<String> values) {
            addCriterion("temp_price_depict not in", values, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictBetween(String value1, String value2) {
            addCriterion("temp_price_depict between", value1, value2, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempPriceDepictNotBetween(String value1, String value2) {
            addCriterion("temp_price_depict not between", value1, value2, "tempPriceDepict");
            return (Criteria) this;
        }

        public Criteria andTempNumberIsNull() {
            addCriterion("temp_number is null");
            return (Criteria) this;
        }

        public Criteria andTempNumberIsNotNull() {
            addCriterion("temp_number is not null");
            return (Criteria) this;
        }

        public Criteria andTempNumberEqualTo(Integer value) {
            addCriterion("temp_number =", value, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberNotEqualTo(Integer value) {
            addCriterion("temp_number <>", value, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberGreaterThan(Integer value) {
            addCriterion("temp_number >", value, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp_number >=", value, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberLessThan(Integer value) {
            addCriterion("temp_number <", value, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberLessThanOrEqualTo(Integer value) {
            addCriterion("temp_number <=", value, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberIn(List<Integer> values) {
            addCriterion("temp_number in", values, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberNotIn(List<Integer> values) {
            addCriterion("temp_number not in", values, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberBetween(Integer value1, Integer value2) {
            addCriterion("temp_number between", value1, value2, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("temp_number not between", value1, value2, "tempNumber");
            return (Criteria) this;
        }

        public Criteria andTempPriceIsNull() {
            addCriterion("temp_price is null");
            return (Criteria) this;
        }

        public Criteria andTempPriceIsNotNull() {
            addCriterion("temp_price is not null");
            return (Criteria) this;
        }

        public Criteria andTempPriceEqualTo(Double value) {
            addCriterion("temp_price =", value, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceNotEqualTo(Double value) {
            addCriterion("temp_price <>", value, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceGreaterThan(Double value) {
            addCriterion("temp_price >", value, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("temp_price >=", value, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceLessThan(Double value) {
            addCriterion("temp_price <", value, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceLessThanOrEqualTo(Double value) {
            addCriterion("temp_price <=", value, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceIn(List<Double> values) {
            addCriterion("temp_price in", values, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceNotIn(List<Double> values) {
            addCriterion("temp_price not in", values, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceBetween(Double value1, Double value2) {
            addCriterion("temp_price between", value1, value2, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceNotBetween(Double value1, Double value2) {
            addCriterion("temp_price not between", value1, value2, "tempPrice");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitIsNull() {
            addCriterion("temp_price_unit is null");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitIsNotNull() {
            addCriterion("temp_price_unit is not null");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitEqualTo(String value) {
            addCriterion("temp_price_unit =", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitNotEqualTo(String value) {
            addCriterion("temp_price_unit <>", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitGreaterThan(String value) {
            addCriterion("temp_price_unit >", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitGreaterThanOrEqualTo(String value) {
            addCriterion("temp_price_unit >=", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitLessThan(String value) {
            addCriterion("temp_price_unit <", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitLessThanOrEqualTo(String value) {
            addCriterion("temp_price_unit <=", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitLike(String value) {
            addCriterion("temp_price_unit like", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitNotLike(String value) {
            addCriterion("temp_price_unit not like", value, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitIn(List<String> values) {
            addCriterion("temp_price_unit in", values, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitNotIn(List<String> values) {
            addCriterion("temp_price_unit not in", values, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitBetween(String value1, String value2) {
            addCriterion("temp_price_unit between", value1, value2, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceUnitNotBetween(String value1, String value2) {
            addCriterion("temp_price_unit not between", value1, value2, "tempPriceUnit");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalIsNull() {
            addCriterion("temp_price_total is null");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalIsNotNull() {
            addCriterion("temp_price_total is not null");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalEqualTo(Double value) {
            addCriterion("temp_price_total =", value, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalNotEqualTo(Double value) {
            addCriterion("temp_price_total <>", value, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalGreaterThan(Double value) {
            addCriterion("temp_price_total >", value, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("temp_price_total >=", value, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalLessThan(Double value) {
            addCriterion("temp_price_total <", value, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalLessThanOrEqualTo(Double value) {
            addCriterion("temp_price_total <=", value, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalIn(List<Double> values) {
            addCriterion("temp_price_total in", values, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalNotIn(List<Double> values) {
            addCriterion("temp_price_total not in", values, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalBetween(Double value1, Double value2) {
            addCriterion("temp_price_total between", value1, value2, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempPriceTotalNotBetween(Double value1, Double value2) {
            addCriterion("temp_price_total not between", value1, value2, "tempPriceTotal");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeIsNull() {
            addCriterion("temp_free_time is null");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeIsNotNull() {
            addCriterion("temp_free_time is not null");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeEqualTo(Integer value) {
            addCriterion("temp_free_time =", value, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeNotEqualTo(Integer value) {
            addCriterion("temp_free_time <>", value, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeGreaterThan(Integer value) {
            addCriterion("temp_free_time >", value, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp_free_time >=", value, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeLessThan(Integer value) {
            addCriterion("temp_free_time <", value, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("temp_free_time <=", value, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeIn(List<Integer> values) {
            addCriterion("temp_free_time in", values, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeNotIn(List<Integer> values) {
            addCriterion("temp_free_time not in", values, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeBetween(Integer value1, Integer value2) {
            addCriterion("temp_free_time between", value1, value2, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andTempFreeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("temp_free_time not between", value1, value2, "tempFreeTime");
            return (Criteria) this;
        }

        public Criteria andRentPriceIsNull() {
            addCriterion("rent_price is null");
            return (Criteria) this;
        }

        public Criteria andRentPriceIsNotNull() {
            addCriterion("rent_price is not null");
            return (Criteria) this;
        }

        public Criteria andRentPriceEqualTo(Double value) {
            addCriterion("rent_price =", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotEqualTo(Double value) {
            addCriterion("rent_price <>", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceGreaterThan(Double value) {
            addCriterion("rent_price >", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("rent_price >=", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceLessThan(Double value) {
            addCriterion("rent_price <", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceLessThanOrEqualTo(Double value) {
            addCriterion("rent_price <=", value, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceIn(List<Double> values) {
            addCriterion("rent_price in", values, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotIn(List<Double> values) {
            addCriterion("rent_price not in", values, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceBetween(Double value1, Double value2) {
            addCriterion("rent_price between", value1, value2, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andRentPriceNotBetween(Double value1, Double value2) {
            addCriterion("rent_price not between", value1, value2, "rentPrice");
            return (Criteria) this;
        }

        public Criteria andAreaPictureIsNull() {
            addCriterion("area_picture is null");
            return (Criteria) this;
        }

        public Criteria andAreaPictureIsNotNull() {
            addCriterion("area_picture is not null");
            return (Criteria) this;
        }

        public Criteria andAreaPictureEqualTo(String value) {
            addCriterion("area_picture =", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureNotEqualTo(String value) {
            addCriterion("area_picture <>", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureGreaterThan(String value) {
            addCriterion("area_picture >", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureGreaterThanOrEqualTo(String value) {
            addCriterion("area_picture >=", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureLessThan(String value) {
            addCriterion("area_picture <", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureLessThanOrEqualTo(String value) {
            addCriterion("area_picture <=", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureLike(String value) {
            addCriterion("area_picture like", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureNotLike(String value) {
            addCriterion("area_picture not like", value, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureIn(List<String> values) {
            addCriterion("area_picture in", values, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureNotIn(List<String> values) {
            addCriterion("area_picture not in", values, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureBetween(String value1, String value2) {
            addCriterion("area_picture between", value1, value2, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andAreaPictureNotBetween(String value1, String value2) {
            addCriterion("area_picture not between", value1, value2, "areaPicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureIsNull() {
            addCriterion("space_picture is null");
            return (Criteria) this;
        }

        public Criteria andSpacePictureIsNotNull() {
            addCriterion("space_picture is not null");
            return (Criteria) this;
        }

        public Criteria andSpacePictureEqualTo(String value) {
            addCriterion("space_picture =", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureNotEqualTo(String value) {
            addCriterion("space_picture <>", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureGreaterThan(String value) {
            addCriterion("space_picture >", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureGreaterThanOrEqualTo(String value) {
            addCriterion("space_picture >=", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureLessThan(String value) {
            addCriterion("space_picture <", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureLessThanOrEqualTo(String value) {
            addCriterion("space_picture <=", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureLike(String value) {
            addCriterion("space_picture like", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureNotLike(String value) {
            addCriterion("space_picture not like", value, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureIn(List<String> values) {
            addCriterion("space_picture in", values, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureNotIn(List<String> values) {
            addCriterion("space_picture not in", values, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureBetween(String value1, String value2) {
            addCriterion("space_picture between", value1, value2, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andSpacePictureNotBetween(String value1, String value2) {
            addCriterion("space_picture not between", value1, value2, "spacePicture");
            return (Criteria) this;
        }

        public Criteria andGateFactoryIsNull() {
            addCriterion("gate_factory is null");
            return (Criteria) this;
        }

        public Criteria andGateFactoryIsNotNull() {
            addCriterion("gate_factory is not null");
            return (Criteria) this;
        }

        public Criteria andGateFactoryEqualTo(String value) {
            addCriterion("gate_factory =", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryNotEqualTo(String value) {
            addCriterion("gate_factory <>", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryGreaterThan(String value) {
            addCriterion("gate_factory >", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("gate_factory >=", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryLessThan(String value) {
            addCriterion("gate_factory <", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryLessThanOrEqualTo(String value) {
            addCriterion("gate_factory <=", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryLike(String value) {
            addCriterion("gate_factory like", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryNotLike(String value) {
            addCriterion("gate_factory not like", value, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryIn(List<String> values) {
            addCriterion("gate_factory in", values, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryNotIn(List<String> values) {
            addCriterion("gate_factory not in", values, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryBetween(String value1, String value2) {
            addCriterion("gate_factory between", value1, value2, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateFactoryNotBetween(String value1, String value2) {
            addCriterion("gate_factory not between", value1, value2, "gateFactory");
            return (Criteria) this;
        }

        public Criteria andGateIdIsNull() {
            addCriterion("gate_id is null");
            return (Criteria) this;
        }

        public Criteria andGateIdIsNotNull() {
            addCriterion("gate_id is not null");
            return (Criteria) this;
        }

        public Criteria andGateIdEqualTo(String value) {
            addCriterion("gate_id =", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdNotEqualTo(String value) {
            addCriterion("gate_id <>", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdGreaterThan(String value) {
            addCriterion("gate_id >", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdGreaterThanOrEqualTo(String value) {
            addCriterion("gate_id >=", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdLessThan(String value) {
            addCriterion("gate_id <", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdLessThanOrEqualTo(String value) {
            addCriterion("gate_id <=", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdLike(String value) {
            addCriterion("gate_id like", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdNotLike(String value) {
            addCriterion("gate_id not like", value, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdIn(List<String> values) {
            addCriterion("gate_id in", values, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdNotIn(List<String> values) {
            addCriterion("gate_id not in", values, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdBetween(String value1, String value2) {
            addCriterion("gate_id between", value1, value2, "gateId");
            return (Criteria) this;
        }

        public Criteria andGateIdNotBetween(String value1, String value2) {
            addCriterion("gate_id not between", value1, value2, "gateId");
            return (Criteria) this;
        }

        public Criteria andAreaStatusIsNull() {
            addCriterion("area_status is null");
            return (Criteria) this;
        }

        public Criteria andAreaStatusIsNotNull() {
            addCriterion("area_status is not null");
            return (Criteria) this;
        }

        public Criteria andAreaStatusEqualTo(String value) {
            addCriterion("area_status =", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotEqualTo(String value) {
            addCriterion("area_status <>", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusGreaterThan(String value) {
            addCriterion("area_status >", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusGreaterThanOrEqualTo(String value) {
            addCriterion("area_status >=", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusLessThan(String value) {
            addCriterion("area_status <", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusLessThanOrEqualTo(String value) {
            addCriterion("area_status <=", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusLike(String value) {
            addCriterion("area_status like", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotLike(String value) {
            addCriterion("area_status not like", value, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusIn(List<String> values) {
            addCriterion("area_status in", values, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotIn(List<String> values) {
            addCriterion("area_status not in", values, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusBetween(String value1, String value2) {
            addCriterion("area_status between", value1, value2, "areaStatus");
            return (Criteria) this;
        }

        public Criteria andAreaStatusNotBetween(String value1, String value2) {
            addCriterion("area_status not between", value1, value2, "areaStatus");
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