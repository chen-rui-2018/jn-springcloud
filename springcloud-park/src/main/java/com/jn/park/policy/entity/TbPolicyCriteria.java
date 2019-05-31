package com.jn.park.policy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPolicyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPolicyCriteria() {
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
            addCriterion("policy_id is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("policy_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(String value) {
            addCriterion("policy_id =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(String value) {
            addCriterion("policy_id <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(String value) {
            addCriterion("policy_id >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(String value) {
            addCriterion("policy_id >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(String value) {
            addCriterion("policy_id <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(String value) {
            addCriterion("policy_id <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLike(String value) {
            addCriterion("policy_id like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotLike(String value) {
            addCriterion("policy_id not like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<String> values) {
            addCriterion("policy_id in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<String> values) {
            addCriterion("policy_id not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(String value1, String value2) {
            addCriterion("policy_id between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(String value1, String value2) {
            addCriterion("policy_id not between", value1, value2, "policyId");
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

        public Criteria andPolicyLevelCodeIsNull() {
            addCriterion("policy_level_code is null");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeIsNotNull() {
            addCriterion("policy_level_code is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeEqualTo(String value) {
            addCriterion("policy_level_code =", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeNotEqualTo(String value) {
            addCriterion("policy_level_code <>", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeGreaterThan(String value) {
            addCriterion("policy_level_code >", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("policy_level_code >=", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeLessThan(String value) {
            addCriterion("policy_level_code <", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeLessThanOrEqualTo(String value) {
            addCriterion("policy_level_code <=", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeLike(String value) {
            addCriterion("policy_level_code like", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeNotLike(String value) {
            addCriterion("policy_level_code not like", value, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeIn(List<String> values) {
            addCriterion("policy_level_code in", values, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeNotIn(List<String> values) {
            addCriterion("policy_level_code not in", values, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeBetween(String value1, String value2) {
            addCriterion("policy_level_code between", value1, value2, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelCodeNotBetween(String value1, String value2) {
            addCriterion("policy_level_code not between", value1, value2, "policyLevelCode");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameIsNull() {
            addCriterion("policy_level_name is null");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameIsNotNull() {
            addCriterion("policy_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameEqualTo(String value) {
            addCriterion("policy_level_name =", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameNotEqualTo(String value) {
            addCriterion("policy_level_name <>", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameGreaterThan(String value) {
            addCriterion("policy_level_name >", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("policy_level_name >=", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameLessThan(String value) {
            addCriterion("policy_level_name <", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameLessThanOrEqualTo(String value) {
            addCriterion("policy_level_name <=", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameLike(String value) {
            addCriterion("policy_level_name like", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameNotLike(String value) {
            addCriterion("policy_level_name not like", value, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameIn(List<String> values) {
            addCriterion("policy_level_name in", values, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameNotIn(List<String> values) {
            addCriterion("policy_level_name not in", values, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameBetween(String value1, String value2) {
            addCriterion("policy_level_name between", value1, value2, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyLevelNameNotBetween(String value1, String value2) {
            addCriterion("policy_level_name not between", value1, value2, "policyLevelName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeIsNull() {
            addCriterion("policy_class_code is null");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeIsNotNull() {
            addCriterion("policy_class_code is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeEqualTo(String value) {
            addCriterion("policy_class_code =", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeNotEqualTo(String value) {
            addCriterion("policy_class_code <>", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeGreaterThan(String value) {
            addCriterion("policy_class_code >", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("policy_class_code >=", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeLessThan(String value) {
            addCriterion("policy_class_code <", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeLessThanOrEqualTo(String value) {
            addCriterion("policy_class_code <=", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeLike(String value) {
            addCriterion("policy_class_code like", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeNotLike(String value) {
            addCriterion("policy_class_code not like", value, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeIn(List<String> values) {
            addCriterion("policy_class_code in", values, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeNotIn(List<String> values) {
            addCriterion("policy_class_code not in", values, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeBetween(String value1, String value2) {
            addCriterion("policy_class_code between", value1, value2, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassCodeNotBetween(String value1, String value2) {
            addCriterion("policy_class_code not between", value1, value2, "policyClassCode");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameIsNull() {
            addCriterion("policy_class_name is null");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameIsNotNull() {
            addCriterion("policy_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameEqualTo(String value) {
            addCriterion("policy_class_name =", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameNotEqualTo(String value) {
            addCriterion("policy_class_name <>", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameGreaterThan(String value) {
            addCriterion("policy_class_name >", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("policy_class_name >=", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameLessThan(String value) {
            addCriterion("policy_class_name <", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameLessThanOrEqualTo(String value) {
            addCriterion("policy_class_name <=", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameLike(String value) {
            addCriterion("policy_class_name like", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameNotLike(String value) {
            addCriterion("policy_class_name not like", value, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameIn(List<String> values) {
            addCriterion("policy_class_name in", values, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameNotIn(List<String> values) {
            addCriterion("policy_class_name not in", values, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameBetween(String value1, String value2) {
            addCriterion("policy_class_name between", value1, value2, "policyClassName");
            return (Criteria) this;
        }

        public Criteria andPolicyClassNameNotBetween(String value1, String value2) {
            addCriterion("policy_class_name not between", value1, value2, "policyClassName");
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

        public Criteria andPolicyDiagramUrlIsNull() {
            addCriterion("policy_diagram_url is null");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlIsNotNull() {
            addCriterion("policy_diagram_url is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlEqualTo(String value) {
            addCriterion("policy_diagram_url =", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlNotEqualTo(String value) {
            addCriterion("policy_diagram_url <>", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlGreaterThan(String value) {
            addCriterion("policy_diagram_url >", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlGreaterThanOrEqualTo(String value) {
            addCriterion("policy_diagram_url >=", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlLessThan(String value) {
            addCriterion("policy_diagram_url <", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlLessThanOrEqualTo(String value) {
            addCriterion("policy_diagram_url <=", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlLike(String value) {
            addCriterion("policy_diagram_url like", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlNotLike(String value) {
            addCriterion("policy_diagram_url not like", value, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlIn(List<String> values) {
            addCriterion("policy_diagram_url in", values, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlNotIn(List<String> values) {
            addCriterion("policy_diagram_url not in", values, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlBetween(String value1, String value2) {
            addCriterion("policy_diagram_url between", value1, value2, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andPolicyDiagramUrlNotBetween(String value1, String value2) {
            addCriterion("policy_diagram_url not between", value1, value2, "policyDiagramUrl");
            return (Criteria) this;
        }

        public Criteria andThematicTypeIsNull() {
            addCriterion("thematic_type is null");
            return (Criteria) this;
        }

        public Criteria andThematicTypeIsNotNull() {
            addCriterion("thematic_type is not null");
            return (Criteria) this;
        }

        public Criteria andThematicTypeEqualTo(String value) {
            addCriterion("thematic_type =", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeNotEqualTo(String value) {
            addCriterion("thematic_type <>", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeGreaterThan(String value) {
            addCriterion("thematic_type >", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("thematic_type >=", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeLessThan(String value) {
            addCriterion("thematic_type <", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeLessThanOrEqualTo(String value) {
            addCriterion("thematic_type <=", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeLike(String value) {
            addCriterion("thematic_type like", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeNotLike(String value) {
            addCriterion("thematic_type not like", value, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeIn(List<String> values) {
            addCriterion("thematic_type in", values, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeNotIn(List<String> values) {
            addCriterion("thematic_type not in", values, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeBetween(String value1, String value2) {
            addCriterion("thematic_type between", value1, value2, "thematicType");
            return (Criteria) this;
        }

        public Criteria andThematicTypeNotBetween(String value1, String value2) {
            addCriterion("thematic_type not between", value1, value2, "thematicType");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleIsNull() {
            addCriterion("policy_title is null");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleIsNotNull() {
            addCriterion("policy_title is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleEqualTo(String value) {
            addCriterion("policy_title =", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleNotEqualTo(String value) {
            addCriterion("policy_title <>", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleGreaterThan(String value) {
            addCriterion("policy_title >", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("policy_title >=", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleLessThan(String value) {
            addCriterion("policy_title <", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleLessThanOrEqualTo(String value) {
            addCriterion("policy_title <=", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleLike(String value) {
            addCriterion("policy_title like", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleNotLike(String value) {
            addCriterion("policy_title not like", value, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleIn(List<String> values) {
            addCriterion("policy_title in", values, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleNotIn(List<String> values) {
            addCriterion("policy_title not in", values, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleBetween(String value1, String value2) {
            addCriterion("policy_title between", value1, value2, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyTitleNotBetween(String value1, String value2) {
            addCriterion("policy_title not between", value1, value2, "policyTitle");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumIsNull() {
            addCriterion("policy_issu_num is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumIsNotNull() {
            addCriterion("policy_issu_num is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumEqualTo(String value) {
            addCriterion("policy_issu_num =", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumNotEqualTo(String value) {
            addCriterion("policy_issu_num <>", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumGreaterThan(String value) {
            addCriterion("policy_issu_num >", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumGreaterThanOrEqualTo(String value) {
            addCriterion("policy_issu_num >=", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumLessThan(String value) {
            addCriterion("policy_issu_num <", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumLessThanOrEqualTo(String value) {
            addCriterion("policy_issu_num <=", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumLike(String value) {
            addCriterion("policy_issu_num like", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumNotLike(String value) {
            addCriterion("policy_issu_num not like", value, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumIn(List<String> values) {
            addCriterion("policy_issu_num in", values, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumNotIn(List<String> values) {
            addCriterion("policy_issu_num not in", values, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumBetween(String value1, String value2) {
            addCriterion("policy_issu_num between", value1, value2, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andPolicyIssuNumNotBetween(String value1, String value2) {
            addCriterion("policy_issu_num not between", value1, value2, "policyIssuNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("read_num is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("read_num is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Integer value) {
            addCriterion("read_num =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Integer value) {
            addCriterion("read_num <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Integer value) {
            addCriterion("read_num >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_num >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Integer value) {
            addCriterion("read_num <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Integer value) {
            addCriterion("read_num <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Integer> values) {
            addCriterion("read_num in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Integer> values) {
            addCriterion("read_num not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Integer value1, Integer value2) {
            addCriterion("read_num between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("read_num not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(Date value) {
            addCriterion("release_date =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(Date value) {
            addCriterion("release_date <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(Date value) {
            addCriterion("release_date >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("release_date >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(Date value) {
            addCriterion("release_date <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(Date value) {
            addCriterion("release_date <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<Date> values) {
            addCriterion("release_date in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<Date> values) {
            addCriterion("release_date not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(Date value1, Date value2) {
            addCriterion("release_date between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(Date value1, Date value2) {
            addCriterion("release_date not between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSupportMethodIsNull() {
            addCriterion("support_method is null");
            return (Criteria) this;
        }

        public Criteria andSupportMethodIsNotNull() {
            addCriterion("support_method is not null");
            return (Criteria) this;
        }

        public Criteria andSupportMethodEqualTo(String value) {
            addCriterion("support_method =", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodNotEqualTo(String value) {
            addCriterion("support_method <>", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodGreaterThan(String value) {
            addCriterion("support_method >", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodGreaterThanOrEqualTo(String value) {
            addCriterion("support_method >=", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodLessThan(String value) {
            addCriterion("support_method <", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodLessThanOrEqualTo(String value) {
            addCriterion("support_method <=", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodLike(String value) {
            addCriterion("support_method like", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodNotLike(String value) {
            addCriterion("support_method not like", value, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodIn(List<String> values) {
            addCriterion("support_method in", values, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodNotIn(List<String> values) {
            addCriterion("support_method not in", values, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodBetween(String value1, String value2) {
            addCriterion("support_method between", value1, value2, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportMethodNotBetween(String value1, String value2) {
            addCriterion("support_method not between", value1, value2, "supportMethod");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryIsNull() {
            addCriterion("support_industry is null");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryIsNotNull() {
            addCriterion("support_industry is not null");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryEqualTo(String value) {
            addCriterion("support_industry =", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryNotEqualTo(String value) {
            addCriterion("support_industry <>", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryGreaterThan(String value) {
            addCriterion("support_industry >", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("support_industry >=", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryLessThan(String value) {
            addCriterion("support_industry <", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryLessThanOrEqualTo(String value) {
            addCriterion("support_industry <=", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryLike(String value) {
            addCriterion("support_industry like", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryNotLike(String value) {
            addCriterion("support_industry not like", value, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryIn(List<String> values) {
            addCriterion("support_industry in", values, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryNotIn(List<String> values) {
            addCriterion("support_industry not in", values, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryBetween(String value1, String value2) {
            addCriterion("support_industry between", value1, value2, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andSupportIndustryNotBetween(String value1, String value2) {
            addCriterion("support_industry not between", value1, value2, "supportIndustry");
            return (Criteria) this;
        }

        public Criteria andIssueUnitIsNull() {
            addCriterion("issue_unit is null");
            return (Criteria) this;
        }

        public Criteria andIssueUnitIsNotNull() {
            addCriterion("issue_unit is not null");
            return (Criteria) this;
        }

        public Criteria andIssueUnitEqualTo(String value) {
            addCriterion("issue_unit =", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitNotEqualTo(String value) {
            addCriterion("issue_unit <>", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitGreaterThan(String value) {
            addCriterion("issue_unit >", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitGreaterThanOrEqualTo(String value) {
            addCriterion("issue_unit >=", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitLessThan(String value) {
            addCriterion("issue_unit <", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitLessThanOrEqualTo(String value) {
            addCriterion("issue_unit <=", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitLike(String value) {
            addCriterion("issue_unit like", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitNotLike(String value) {
            addCriterion("issue_unit not like", value, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitIn(List<String> values) {
            addCriterion("issue_unit in", values, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitNotIn(List<String> values) {
            addCriterion("issue_unit not in", values, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitBetween(String value1, String value2) {
            addCriterion("issue_unit between", value1, value2, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIssueUnitNotBetween(String value1, String value2) {
            addCriterion("issue_unit not between", value1, value2, "issueUnit");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramIsNull() {
            addCriterion("is_policy_diagram is null");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramIsNotNull() {
            addCriterion("is_policy_diagram is not null");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramEqualTo(String value) {
            addCriterion("is_policy_diagram =", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramNotEqualTo(String value) {
            addCriterion("is_policy_diagram <>", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramGreaterThan(String value) {
            addCriterion("is_policy_diagram >", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramGreaterThanOrEqualTo(String value) {
            addCriterion("is_policy_diagram >=", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramLessThan(String value) {
            addCriterion("is_policy_diagram <", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramLessThanOrEqualTo(String value) {
            addCriterion("is_policy_diagram <=", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramLike(String value) {
            addCriterion("is_policy_diagram like", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramNotLike(String value) {
            addCriterion("is_policy_diagram not like", value, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramIn(List<String> values) {
            addCriterion("is_policy_diagram in", values, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramNotIn(List<String> values) {
            addCriterion("is_policy_diagram not in", values, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramBetween(String value1, String value2) {
            addCriterion("is_policy_diagram between", value1, value2, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andIsPolicyDiagramNotBetween(String value1, String value2) {
            addCriterion("is_policy_diagram not between", value1, value2, "isPolicyDiagram");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdIsNull() {
            addCriterion("relation_policy_diagram_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdIsNotNull() {
            addCriterion("relation_policy_diagram_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdEqualTo(String value) {
            addCriterion("relation_policy_diagram_id =", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdNotEqualTo(String value) {
            addCriterion("relation_policy_diagram_id <>", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdGreaterThan(String value) {
            addCriterion("relation_policy_diagram_id >", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdGreaterThanOrEqualTo(String value) {
            addCriterion("relation_policy_diagram_id >=", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdLessThan(String value) {
            addCriterion("relation_policy_diagram_id <", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdLessThanOrEqualTo(String value) {
            addCriterion("relation_policy_diagram_id <=", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdLike(String value) {
            addCriterion("relation_policy_diagram_id like", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdNotLike(String value) {
            addCriterion("relation_policy_diagram_id not like", value, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdIn(List<String> values) {
            addCriterion("relation_policy_diagram_id in", values, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdNotIn(List<String> values) {
            addCriterion("relation_policy_diagram_id not in", values, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdBetween(String value1, String value2) {
            addCriterion("relation_policy_diagram_id between", value1, value2, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyDiagramIdNotBetween(String value1, String value2) {
            addCriterion("relation_policy_diagram_id not between", value1, value2, "relationPolicyDiagramId");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalIsNull() {
            addCriterion("is_policy_original is null");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalIsNotNull() {
            addCriterion("is_policy_original is not null");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalEqualTo(String value) {
            addCriterion("is_policy_original =", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalNotEqualTo(String value) {
            addCriterion("is_policy_original <>", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalGreaterThan(String value) {
            addCriterion("is_policy_original >", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalGreaterThanOrEqualTo(String value) {
            addCriterion("is_policy_original >=", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalLessThan(String value) {
            addCriterion("is_policy_original <", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalLessThanOrEqualTo(String value) {
            addCriterion("is_policy_original <=", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalLike(String value) {
            addCriterion("is_policy_original like", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalNotLike(String value) {
            addCriterion("is_policy_original not like", value, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalIn(List<String> values) {
            addCriterion("is_policy_original in", values, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalNotIn(List<String> values) {
            addCriterion("is_policy_original not in", values, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalBetween(String value1, String value2) {
            addCriterion("is_policy_original between", value1, value2, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andIsPolicyOriginalNotBetween(String value1, String value2) {
            addCriterion("is_policy_original not between", value1, value2, "isPolicyOriginal");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdIsNull() {
            addCriterion("relation_policy_original_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdIsNotNull() {
            addCriterion("relation_policy_original_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdEqualTo(String value) {
            addCriterion("relation_policy_original_id =", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdNotEqualTo(String value) {
            addCriterion("relation_policy_original_id <>", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdGreaterThan(String value) {
            addCriterion("relation_policy_original_id >", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdGreaterThanOrEqualTo(String value) {
            addCriterion("relation_policy_original_id >=", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdLessThan(String value) {
            addCriterion("relation_policy_original_id <", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdLessThanOrEqualTo(String value) {
            addCriterion("relation_policy_original_id <=", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdLike(String value) {
            addCriterion("relation_policy_original_id like", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdNotLike(String value) {
            addCriterion("relation_policy_original_id not like", value, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdIn(List<String> values) {
            addCriterion("relation_policy_original_id in", values, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdNotIn(List<String> values) {
            addCriterion("relation_policy_original_id not in", values, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdBetween(String value1, String value2) {
            addCriterion("relation_policy_original_id between", value1, value2, "relationPolicyOriginalId");
            return (Criteria) this;
        }

        public Criteria andRelationPolicyOriginalIdNotBetween(String value1, String value2) {
            addCriterion("relation_policy_original_id not between", value1, value2, "relationPolicyOriginalId");
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