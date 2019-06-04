package com.jn.park.parking.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbParkingPreferentialCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbParkingPreferentialCriteria() {
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

        public Criteria andPolicyIdIsNull() {
            addCriterion("policy_id_ is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("policy_id_ is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(String value) {
            addCriterion("policy_id_ =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(String value) {
            addCriterion("policy_id_ <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(String value) {
            addCriterion("policy_id_ >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(String value) {
            addCriterion("policy_id_ >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(String value) {
            addCriterion("policy_id_ <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(String value) {
            addCriterion("policy_id_ <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLike(String value) {
            addCriterion("policy_id_ like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotLike(String value) {
            addCriterion("policy_id_ not like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<String> values) {
            addCriterion("policy_id_ in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<String> values) {
            addCriterion("policy_id_ not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(String value1, String value2) {
            addCriterion("policy_id_ between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(String value1, String value2) {
            addCriterion("policy_id_ not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIsNull() {
            addCriterion("policy_type is null");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIsNotNull() {
            addCriterion("policy_type is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeEqualTo(String value) {
            addCriterion("policy_type =", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotEqualTo(String value) {
            addCriterion("policy_type <>", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeGreaterThan(String value) {
            addCriterion("policy_type >", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("policy_type >=", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLessThan(String value) {
            addCriterion("policy_type <", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLessThanOrEqualTo(String value) {
            addCriterion("policy_type <=", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLike(String value) {
            addCriterion("policy_type like", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotLike(String value) {
            addCriterion("policy_type not like", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIn(List<String> values) {
            addCriterion("policy_type in", values, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotIn(List<String> values) {
            addCriterion("policy_type not in", values, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeBetween(String value1, String value2) {
            addCriterion("policy_type between", value1, value2, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotBetween(String value1, String value2) {
            addCriterion("policy_type not between", value1, value2, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeIsNull() {
            addCriterion("policy_user_type is null");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeIsNotNull() {
            addCriterion("policy_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeEqualTo(String value) {
            addCriterion("policy_user_type =", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeNotEqualTo(String value) {
            addCriterion("policy_user_type <>", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeGreaterThan(String value) {
            addCriterion("policy_user_type >", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("policy_user_type >=", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeLessThan(String value) {
            addCriterion("policy_user_type <", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeLessThanOrEqualTo(String value) {
            addCriterion("policy_user_type <=", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeLike(String value) {
            addCriterion("policy_user_type like", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeNotLike(String value) {
            addCriterion("policy_user_type not like", value, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeIn(List<String> values) {
            addCriterion("policy_user_type in", values, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeNotIn(List<String> values) {
            addCriterion("policy_user_type not in", values, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeBetween(String value1, String value2) {
            addCriterion("policy_user_type between", value1, value2, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyUserTypeNotBetween(String value1, String value2) {
            addCriterion("policy_user_type not between", value1, value2, "policyUserType");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeIsNull() {
            addCriterion("policy_code is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeIsNotNull() {
            addCriterion("policy_code is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeEqualTo(String value) {
            addCriterion("policy_code =", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotEqualTo(String value) {
            addCriterion("policy_code <>", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeGreaterThan(String value) {
            addCriterion("policy_code >", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("policy_code >=", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeLessThan(String value) {
            addCriterion("policy_code <", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeLessThanOrEqualTo(String value) {
            addCriterion("policy_code <=", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeLike(String value) {
            addCriterion("policy_code like", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotLike(String value) {
            addCriterion("policy_code not like", value, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeIn(List<String> values) {
            addCriterion("policy_code in", values, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotIn(List<String> values) {
            addCriterion("policy_code not in", values, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeBetween(String value1, String value2) {
            addCriterion("policy_code between", value1, value2, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCodeNotBetween(String value1, String value2) {
            addCriterion("policy_code not between", value1, value2, "policyCode");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsIsNull() {
            addCriterion("policy_comments is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsIsNotNull() {
            addCriterion("policy_comments is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsEqualTo(String value) {
            addCriterion("policy_comments =", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsNotEqualTo(String value) {
            addCriterion("policy_comments <>", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsGreaterThan(String value) {
            addCriterion("policy_comments >", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("policy_comments >=", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsLessThan(String value) {
            addCriterion("policy_comments <", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsLessThanOrEqualTo(String value) {
            addCriterion("policy_comments <=", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsLike(String value) {
            addCriterion("policy_comments like", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsNotLike(String value) {
            addCriterion("policy_comments not like", value, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsIn(List<String> values) {
            addCriterion("policy_comments in", values, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsNotIn(List<String> values) {
            addCriterion("policy_comments not in", values, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsBetween(String value1, String value2) {
            addCriterion("policy_comments between", value1, value2, "policyComments");
            return (Criteria) this;
        }

        public Criteria andPolicyCommentsNotBetween(String value1, String value2) {
            addCriterion("policy_comments not between", value1, value2, "policyComments");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIsNull() {
            addCriterion("offer_price is null");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIsNotNull() {
            addCriterion("offer_price is not null");
            return (Criteria) this;
        }

        public Criteria andOfferPriceEqualTo(Double value) {
            addCriterion("offer_price =", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotEqualTo(Double value) {
            addCriterion("offer_price <>", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThan(Double value) {
            addCriterion("offer_price >", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("offer_price >=", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThan(Double value) {
            addCriterion("offer_price <", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThanOrEqualTo(Double value) {
            addCriterion("offer_price <=", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIn(List<Double> values) {
            addCriterion("offer_price in", values, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotIn(List<Double> values) {
            addCriterion("offer_price not in", values, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceBetween(Double value1, Double value2) {
            addCriterion("offer_price between", value1, value2, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotBetween(Double value1, Double value2) {
            addCriterion("offer_price not between", value1, value2, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferRatioIsNull() {
            addCriterion("offer_ratio is null");
            return (Criteria) this;
        }

        public Criteria andOfferRatioIsNotNull() {
            addCriterion("offer_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andOfferRatioEqualTo(Double value) {
            addCriterion("offer_ratio =", value, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioNotEqualTo(Double value) {
            addCriterion("offer_ratio <>", value, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioGreaterThan(Double value) {
            addCriterion("offer_ratio >", value, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioGreaterThanOrEqualTo(Double value) {
            addCriterion("offer_ratio >=", value, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioLessThan(Double value) {
            addCriterion("offer_ratio <", value, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioLessThanOrEqualTo(Double value) {
            addCriterion("offer_ratio <=", value, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioIn(List<Double> values) {
            addCriterion("offer_ratio in", values, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioNotIn(List<Double> values) {
            addCriterion("offer_ratio not in", values, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioBetween(Double value1, Double value2) {
            addCriterion("offer_ratio between", value1, value2, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andOfferRatioNotBetween(Double value1, Double value2) {
            addCriterion("offer_ratio not between", value1, value2, "offerRatio");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusIsNull() {
            addCriterion("policy_status is null");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusIsNotNull() {
            addCriterion("policy_status is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusEqualTo(String value) {
            addCriterion("policy_status =", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotEqualTo(String value) {
            addCriterion("policy_status <>", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusGreaterThan(String value) {
            addCriterion("policy_status >", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("policy_status >=", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusLessThan(String value) {
            addCriterion("policy_status <", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusLessThanOrEqualTo(String value) {
            addCriterion("policy_status <=", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusLike(String value) {
            addCriterion("policy_status like", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotLike(String value) {
            addCriterion("policy_status not like", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusIn(List<String> values) {
            addCriterion("policy_status in", values, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotIn(List<String> values) {
            addCriterion("policy_status not in", values, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusBetween(String value1, String value2) {
            addCriterion("policy_status between", value1, value2, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotBetween(String value1, String value2) {
            addCriterion("policy_status not between", value1, value2, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andDayConditionsIsNull() {
            addCriterion("day_conditions is null");
            return (Criteria) this;
        }

        public Criteria andDayConditionsIsNotNull() {
            addCriterion("day_conditions is not null");
            return (Criteria) this;
        }

        public Criteria andDayConditionsEqualTo(Integer value) {
            addCriterion("day_conditions =", value, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsNotEqualTo(Integer value) {
            addCriterion("day_conditions <>", value, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsGreaterThan(Integer value) {
            addCriterion("day_conditions >", value, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_conditions >=", value, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsLessThan(Integer value) {
            addCriterion("day_conditions <", value, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsLessThanOrEqualTo(Integer value) {
            addCriterion("day_conditions <=", value, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsIn(List<Integer> values) {
            addCriterion("day_conditions in", values, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsNotIn(List<Integer> values) {
            addCriterion("day_conditions not in", values, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsBetween(Integer value1, Integer value2) {
            addCriterion("day_conditions between", value1, value2, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andDayConditionsNotBetween(Integer value1, Integer value2) {
            addCriterion("day_conditions not between", value1, value2, "dayConditions");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisIsNull() {
            addCriterion("taxt_basis is null");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisIsNotNull() {
            addCriterion("taxt_basis is not null");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisEqualTo(BigDecimal value) {
            addCriterion("taxt_basis =", value, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisNotEqualTo(BigDecimal value) {
            addCriterion("taxt_basis <>", value, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisGreaterThan(BigDecimal value) {
            addCriterion("taxt_basis >", value, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taxt_basis >=", value, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisLessThan(BigDecimal value) {
            addCriterion("taxt_basis <", value, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taxt_basis <=", value, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisIn(List<BigDecimal> values) {
            addCriterion("taxt_basis in", values, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisNotIn(List<BigDecimal> values) {
            addCriterion("taxt_basis not in", values, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxt_basis between", value1, value2, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andTaxtBasisNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxt_basis not between", value1, value2, "taxtBasis");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumIsNull() {
            addCriterion("policy_car_num is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumIsNotNull() {
            addCriterion("policy_car_num is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumEqualTo(Integer value) {
            addCriterion("policy_car_num =", value, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumNotEqualTo(Integer value) {
            addCriterion("policy_car_num <>", value, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumGreaterThan(Integer value) {
            addCriterion("policy_car_num >", value, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("policy_car_num >=", value, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumLessThan(Integer value) {
            addCriterion("policy_car_num <", value, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumLessThanOrEqualTo(Integer value) {
            addCriterion("policy_car_num <=", value, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumIn(List<Integer> values) {
            addCriterion("policy_car_num in", values, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumNotIn(List<Integer> values) {
            addCriterion("policy_car_num not in", values, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumBetween(Integer value1, Integer value2) {
            addCriterion("policy_car_num between", value1, value2, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarNumNotBetween(Integer value1, Integer value2) {
            addCriterion("policy_car_num not between", value1, value2, "policyCarNum");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxIsNull() {
            addCriterion("policy_car_max is null");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxIsNotNull() {
            addCriterion("policy_car_max is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxEqualTo(Integer value) {
            addCriterion("policy_car_max =", value, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxNotEqualTo(Integer value) {
            addCriterion("policy_car_max <>", value, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxGreaterThan(Integer value) {
            addCriterion("policy_car_max >", value, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("policy_car_max >=", value, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxLessThan(Integer value) {
            addCriterion("policy_car_max <", value, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxLessThanOrEqualTo(Integer value) {
            addCriterion("policy_car_max <=", value, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxIn(List<Integer> values) {
            addCriterion("policy_car_max in", values, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxNotIn(List<Integer> values) {
            addCriterion("policy_car_max not in", values, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxBetween(Integer value1, Integer value2) {
            addCriterion("policy_car_max between", value1, value2, "policyCarMax");
            return (Criteria) this;
        }

        public Criteria andPolicyCarMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("policy_car_max not between", value1, value2, "policyCarMax");
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