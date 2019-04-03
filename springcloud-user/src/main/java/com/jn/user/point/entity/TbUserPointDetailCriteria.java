package com.jn.user.point.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserPointDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserPointDetailCriteria() {
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

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameIsNull() {
            addCriterion("rule_type_name is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameIsNotNull() {
            addCriterion("rule_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameEqualTo(String value) {
            addCriterion("rule_type_name =", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameNotEqualTo(String value) {
            addCriterion("rule_type_name <>", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameGreaterThan(String value) {
            addCriterion("rule_type_name >", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_type_name >=", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameLessThan(String value) {
            addCriterion("rule_type_name <", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameLessThanOrEqualTo(String value) {
            addCriterion("rule_type_name <=", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameLike(String value) {
            addCriterion("rule_type_name like", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameNotLike(String value) {
            addCriterion("rule_type_name not like", value, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameIn(List<String> values) {
            addCriterion("rule_type_name in", values, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameNotIn(List<String> values) {
            addCriterion("rule_type_name not in", values, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameBetween(String value1, String value2) {
            addCriterion("rule_type_name between", value1, value2, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNameNotBetween(String value1, String value2) {
            addCriterion("rule_type_name not between", value1, value2, "ruleTypeName");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdIsNull() {
            addCriterion("rule_type_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdIsNotNull() {
            addCriterion("rule_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdEqualTo(String value) {
            addCriterion("rule_type_id =", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdNotEqualTo(String value) {
            addCriterion("rule_type_id <>", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdGreaterThan(String value) {
            addCriterion("rule_type_id >", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("rule_type_id >=", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdLessThan(String value) {
            addCriterion("rule_type_id <", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdLessThanOrEqualTo(String value) {
            addCriterion("rule_type_id <=", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdLike(String value) {
            addCriterion("rule_type_id like", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdNotLike(String value) {
            addCriterion("rule_type_id not like", value, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdIn(List<String> values) {
            addCriterion("rule_type_id in", values, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdNotIn(List<String> values) {
            addCriterion("rule_type_id not in", values, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdBetween(String value1, String value2) {
            addCriterion("rule_type_id between", value1, value2, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIdNotBetween(String value1, String value2) {
            addCriterion("rule_type_id not between", value1, value2, "ruleTypeId");
            return (Criteria) this;
        }

        public Criteria andPointtypeIsNull() {
            addCriterion("pointtype is null");
            return (Criteria) this;
        }

        public Criteria andPointtypeIsNotNull() {
            addCriterion("pointtype is not null");
            return (Criteria) this;
        }

        public Criteria andPointtypeEqualTo(String value) {
            addCriterion("pointtype =", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeNotEqualTo(String value) {
            addCriterion("pointtype <>", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeGreaterThan(String value) {
            addCriterion("pointtype >", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeGreaterThanOrEqualTo(String value) {
            addCriterion("pointtype >=", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeLessThan(String value) {
            addCriterion("pointtype <", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeLessThanOrEqualTo(String value) {
            addCriterion("pointtype <=", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeLike(String value) {
            addCriterion("pointtype like", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeNotLike(String value) {
            addCriterion("pointtype not like", value, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeIn(List<String> values) {
            addCriterion("pointtype in", values, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeNotIn(List<String> values) {
            addCriterion("pointtype not in", values, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeBetween(String value1, String value2) {
            addCriterion("pointtype between", value1, value2, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointtypeNotBetween(String value1, String value2) {
            addCriterion("pointtype not between", value1, value2, "pointtype");
            return (Criteria) this;
        }

        public Criteria andPointNumIsNull() {
            addCriterion("point_num is null");
            return (Criteria) this;
        }

        public Criteria andPointNumIsNotNull() {
            addCriterion("point_num is not null");
            return (Criteria) this;
        }

        public Criteria andPointNumEqualTo(Double value) {
            addCriterion("point_num =", value, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumNotEqualTo(Double value) {
            addCriterion("point_num <>", value, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumGreaterThan(Double value) {
            addCriterion("point_num >", value, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumGreaterThanOrEqualTo(Double value) {
            addCriterion("point_num >=", value, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumLessThan(Double value) {
            addCriterion("point_num <", value, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumLessThanOrEqualTo(Double value) {
            addCriterion("point_num <=", value, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumIn(List<Double> values) {
            addCriterion("point_num in", values, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumNotIn(List<Double> values) {
            addCriterion("point_num not in", values, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumBetween(Double value1, Double value2) {
            addCriterion("point_num between", value1, value2, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointNumNotBetween(Double value1, Double value2) {
            addCriterion("point_num not between", value1, value2, "pointNum");
            return (Criteria) this;
        }

        public Criteria andPointBalanceIsNull() {
            addCriterion("point_balance is null");
            return (Criteria) this;
        }

        public Criteria andPointBalanceIsNotNull() {
            addCriterion("point_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPointBalanceEqualTo(Double value) {
            addCriterion("point_balance =", value, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceNotEqualTo(Double value) {
            addCriterion("point_balance <>", value, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceGreaterThan(Double value) {
            addCriterion("point_balance >", value, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("point_balance >=", value, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceLessThan(Double value) {
            addCriterion("point_balance <", value, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceLessThanOrEqualTo(Double value) {
            addCriterion("point_balance <=", value, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceIn(List<Double> values) {
            addCriterion("point_balance in", values, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceNotIn(List<Double> values) {
            addCriterion("point_balance not in", values, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceBetween(Double value1, Double value2) {
            addCriterion("point_balance between", value1, value2, "pointBalance");
            return (Criteria) this;
        }

        public Criteria andPointBalanceNotBetween(Double value1, Double value2) {
            addCriterion("point_balance not between", value1, value2, "pointBalance");
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