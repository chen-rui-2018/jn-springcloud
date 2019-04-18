package com.jn.enterprise.propaganda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPropagandaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPropagandaCriteria() {
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
            addCriterion("id_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdIsNull() {
            addCriterion("propaganda_id is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdIsNotNull() {
            addCriterion("propaganda_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdEqualTo(String value) {
            addCriterion("propaganda_id =", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdNotEqualTo(String value) {
            addCriterion("propaganda_id <>", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdGreaterThan(String value) {
            addCriterion("propaganda_id >", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdGreaterThanOrEqualTo(String value) {
            addCriterion("propaganda_id >=", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdLessThan(String value) {
            addCriterion("propaganda_id <", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdLessThanOrEqualTo(String value) {
            addCriterion("propaganda_id <=", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdLike(String value) {
            addCriterion("propaganda_id like", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdNotLike(String value) {
            addCriterion("propaganda_id not like", value, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdIn(List<String> values) {
            addCriterion("propaganda_id in", values, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdNotIn(List<String> values) {
            addCriterion("propaganda_id not in", values, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdBetween(String value1, String value2) {
            addCriterion("propaganda_id between", value1, value2, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaIdNotBetween(String value1, String value2) {
            addCriterion("propaganda_id not between", value1, value2, "propagandaId");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeIsNull() {
            addCriterion("propaganda_code is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeIsNotNull() {
            addCriterion("propaganda_code is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeEqualTo(String value) {
            addCriterion("propaganda_code =", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeNotEqualTo(String value) {
            addCriterion("propaganda_code <>", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeGreaterThan(String value) {
            addCriterion("propaganda_code >", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("propaganda_code >=", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeLessThan(String value) {
            addCriterion("propaganda_code <", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeLessThanOrEqualTo(String value) {
            addCriterion("propaganda_code <=", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeLike(String value) {
            addCriterion("propaganda_code like", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeNotLike(String value) {
            addCriterion("propaganda_code not like", value, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeIn(List<String> values) {
            addCriterion("propaganda_code in", values, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeNotIn(List<String> values) {
            addCriterion("propaganda_code not in", values, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeBetween(String value1, String value2) {
            addCriterion("propaganda_code between", value1, value2, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaCodeNotBetween(String value1, String value2) {
            addCriterion("propaganda_code not between", value1, value2, "propagandaCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleIsNull() {
            addCriterion("propaganda_title is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleIsNotNull() {
            addCriterion("propaganda_title is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleEqualTo(String value) {
            addCriterion("propaganda_title =", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleNotEqualTo(String value) {
            addCriterion("propaganda_title <>", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleGreaterThan(String value) {
            addCriterion("propaganda_title >", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleGreaterThanOrEqualTo(String value) {
            addCriterion("propaganda_title >=", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleLessThan(String value) {
            addCriterion("propaganda_title <", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleLessThanOrEqualTo(String value) {
            addCriterion("propaganda_title <=", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleLike(String value) {
            addCriterion("propaganda_title like", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleNotLike(String value) {
            addCriterion("propaganda_title not like", value, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleIn(List<String> values) {
            addCriterion("propaganda_title in", values, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleNotIn(List<String> values) {
            addCriterion("propaganda_title not in", values, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleBetween(String value1, String value2) {
            addCriterion("propaganda_title between", value1, value2, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTitleNotBetween(String value1, String value2) {
            addCriterion("propaganda_title not between", value1, value2, "propagandaTitle");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeIsNull() {
            addCriterion("propaganda_type is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeIsNotNull() {
            addCriterion("propaganda_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeEqualTo(String value) {
            addCriterion("propaganda_type =", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeNotEqualTo(String value) {
            addCriterion("propaganda_type <>", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeGreaterThan(String value) {
            addCriterion("propaganda_type >", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("propaganda_type >=", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeLessThan(String value) {
            addCriterion("propaganda_type <", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeLessThanOrEqualTo(String value) {
            addCriterion("propaganda_type <=", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeLike(String value) {
            addCriterion("propaganda_type like", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeNotLike(String value) {
            addCriterion("propaganda_type not like", value, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeIn(List<String> values) {
            addCriterion("propaganda_type in", values, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeNotIn(List<String> values) {
            addCriterion("propaganda_type not in", values, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeBetween(String value1, String value2) {
            addCriterion("propaganda_type between", value1, value2, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andPropagandaTypeNotBetween(String value1, String value2) {
            addCriterion("propaganda_type not between", value1, value2, "propagandaType");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformIsNull() {
            addCriterion("issue_platform is null");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformIsNotNull() {
            addCriterion("issue_platform is not null");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformEqualTo(String value) {
            addCriterion("issue_platform =", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformNotEqualTo(String value) {
            addCriterion("issue_platform <>", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformGreaterThan(String value) {
            addCriterion("issue_platform >", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformGreaterThanOrEqualTo(String value) {
            addCriterion("issue_platform >=", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformLessThan(String value) {
            addCriterion("issue_platform <", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformLessThanOrEqualTo(String value) {
            addCriterion("issue_platform <=", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformLike(String value) {
            addCriterion("issue_platform like", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformNotLike(String value) {
            addCriterion("issue_platform not like", value, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformIn(List<String> values) {
            addCriterion("issue_platform in", values, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformNotIn(List<String> values) {
            addCriterion("issue_platform not in", values, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformBetween(String value1, String value2) {
            addCriterion("issue_platform between", value1, value2, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andIssuePlatformNotBetween(String value1, String value2) {
            addCriterion("issue_platform not between", value1, value2, "issuePlatform");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNull() {
            addCriterion("effective_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNotNull() {
            addCriterion("effective_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateEqualTo(Date value) {
            addCriterion("effective_date =", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotEqualTo(Date value) {
            addCriterion("effective_date <>", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThan(Date value) {
            addCriterion("effective_date >", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_date >=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThan(Date value) {
            addCriterion("effective_date <", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThanOrEqualTo(Date value) {
            addCriterion("effective_date <=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIn(List<Date> values) {
            addCriterion("effective_date in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotIn(List<Date> values) {
            addCriterion("effective_date not in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateBetween(Date value1, Date value2) {
            addCriterion("effective_date between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotBetween(Date value1, Date value2) {
            addCriterion("effective_date not between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateIsNull() {
            addCriterion("invalid_date is null");
            return (Criteria) this;
        }

        public Criteria andInvalidDateIsNotNull() {
            addCriterion("invalid_date is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidDateEqualTo(Date value) {
            addCriterion("invalid_date =", value, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateNotEqualTo(Date value) {
            addCriterion("invalid_date <>", value, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateGreaterThan(Date value) {
            addCriterion("invalid_date >", value, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateGreaterThanOrEqualTo(Date value) {
            addCriterion("invalid_date >=", value, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateLessThan(Date value) {
            addCriterion("invalid_date <", value, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateLessThanOrEqualTo(Date value) {
            addCriterion("invalid_date <=", value, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateIn(List<Date> values) {
            addCriterion("invalid_date in", values, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateNotIn(List<Date> values) {
            addCriterion("invalid_date not in", values, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateBetween(Date value1, Date value2) {
            addCriterion("invalid_date between", value1, value2, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andInvalidDateNotBetween(Date value1, Date value2) {
            addCriterion("invalid_date not between", value1, value2, "invalidDate");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaIsNull() {
            addCriterion("propaganda_area is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaIsNotNull() {
            addCriterion("propaganda_area is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaEqualTo(String value) {
            addCriterion("propaganda_area =", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaNotEqualTo(String value) {
            addCriterion("propaganda_area <>", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaGreaterThan(String value) {
            addCriterion("propaganda_area >", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaGreaterThanOrEqualTo(String value) {
            addCriterion("propaganda_area >=", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaLessThan(String value) {
            addCriterion("propaganda_area <", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaLessThanOrEqualTo(String value) {
            addCriterion("propaganda_area <=", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaLike(String value) {
            addCriterion("propaganda_area like", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaNotLike(String value) {
            addCriterion("propaganda_area not like", value, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaIn(List<String> values) {
            addCriterion("propaganda_area in", values, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaNotIn(List<String> values) {
            addCriterion("propaganda_area not in", values, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaBetween(String value1, String value2) {
            addCriterion("propaganda_area between", value1, value2, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPropagandaAreaNotBetween(String value1, String value2) {
            addCriterion("propaganda_area not between", value1, value2, "propagandaArea");
            return (Criteria) this;
        }

        public Criteria andPosterUrlIsNull() {
            addCriterion("poster_url is null");
            return (Criteria) this;
        }

        public Criteria andPosterUrlIsNotNull() {
            addCriterion("poster_url is not null");
            return (Criteria) this;
        }

        public Criteria andPosterUrlEqualTo(String value) {
            addCriterion("poster_url =", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlNotEqualTo(String value) {
            addCriterion("poster_url <>", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlGreaterThan(String value) {
            addCriterion("poster_url >", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlGreaterThanOrEqualTo(String value) {
            addCriterion("poster_url >=", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlLessThan(String value) {
            addCriterion("poster_url <", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlLessThanOrEqualTo(String value) {
            addCriterion("poster_url <=", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlLike(String value) {
            addCriterion("poster_url like", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlNotLike(String value) {
            addCriterion("poster_url not like", value, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlIn(List<String> values) {
            addCriterion("poster_url in", values, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlNotIn(List<String> values) {
            addCriterion("poster_url not in", values, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlBetween(String value1, String value2) {
            addCriterion("poster_url between", value1, value2, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andPosterUrlNotBetween(String value1, String value2) {
            addCriterion("poster_url not between", value1, value2, "posterUrl");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeIsNull() {
            addCriterion("pro_fee_rule_code is null");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeIsNotNull() {
            addCriterion("pro_fee_rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeEqualTo(String value) {
            addCriterion("pro_fee_rule_code =", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotEqualTo(String value) {
            addCriterion("pro_fee_rule_code <>", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeGreaterThan(String value) {
            addCriterion("pro_fee_rule_code >", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_fee_rule_code >=", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeLessThan(String value) {
            addCriterion("pro_fee_rule_code <", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeLessThanOrEqualTo(String value) {
            addCriterion("pro_fee_rule_code <=", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeLike(String value) {
            addCriterion("pro_fee_rule_code like", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotLike(String value) {
            addCriterion("pro_fee_rule_code not like", value, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeIn(List<String> values) {
            addCriterion("pro_fee_rule_code in", values, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotIn(List<String> values) {
            addCriterion("pro_fee_rule_code not in", values, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeBetween(String value1, String value2) {
            addCriterion("pro_fee_rule_code between", value1, value2, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andProFeeRuleCodeNotBetween(String value1, String value2) {
            addCriterion("pro_fee_rule_code not between", value1, value2, "proFeeRuleCode");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeIsNull() {
            addCriterion("propaganda_fee is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeIsNotNull() {
            addCriterion("propaganda_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeEqualTo(Long value) {
            addCriterion("propaganda_fee =", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeNotEqualTo(Long value) {
            addCriterion("propaganda_fee <>", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeGreaterThan(Long value) {
            addCriterion("propaganda_fee >", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("propaganda_fee >=", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeLessThan(Long value) {
            addCriterion("propaganda_fee <", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeLessThanOrEqualTo(Long value) {
            addCriterion("propaganda_fee <=", value, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeIn(List<Long> values) {
            addCriterion("propaganda_fee in", values, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeNotIn(List<Long> values) {
            addCriterion("propaganda_fee not in", values, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeBetween(Long value1, Long value2) {
            addCriterion("propaganda_fee between", value1, value2, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andPropagandaFeeNotBetween(Long value1, Long value2) {
            addCriterion("propaganda_fee not between", value1, value2, "propagandaFee");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(String value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(String value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(String value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(String value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(String value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLike(String value) {
            addCriterion("approval_status like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotLike(String value) {
            addCriterion("approval_status not like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<String> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<String> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(String value1, String value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(String value1, String value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIsNull() {
            addCriterion("approval_desc is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIsNotNull() {
            addCriterion("approval_desc is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDescEqualTo(String value) {
            addCriterion("approval_desc =", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotEqualTo(String value) {
            addCriterion("approval_desc <>", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescGreaterThan(String value) {
            addCriterion("approval_desc >", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescGreaterThanOrEqualTo(String value) {
            addCriterion("approval_desc >=", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLessThan(String value) {
            addCriterion("approval_desc <", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLessThanOrEqualTo(String value) {
            addCriterion("approval_desc <=", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescLike(String value) {
            addCriterion("approval_desc like", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotLike(String value) {
            addCriterion("approval_desc not like", value, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescIn(List<String> values) {
            addCriterion("approval_desc in", values, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotIn(List<String> values) {
            addCriterion("approval_desc not in", values, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescBetween(String value1, String value2) {
            addCriterion("approval_desc between", value1, value2, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andApprovalDescNotBetween(String value1, String value2) {
            addCriterion("approval_desc not between", value1, value2, "approvalDesc");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
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