package com.jn.park.asset.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbAssetArticleLeaseOrdersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAssetArticleLeaseOrdersCriteria() {
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

        public Criteria andAssetNumberIsNull() {
            addCriterion("asset_number is null");
            return (Criteria) this;
        }

        public Criteria andAssetNumberIsNotNull() {
            addCriterion("asset_number is not null");
            return (Criteria) this;
        }

        public Criteria andAssetNumberEqualTo(String value) {
            addCriterion("asset_number =", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotEqualTo(String value) {
            addCriterion("asset_number <>", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberGreaterThan(String value) {
            addCriterion("asset_number >", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberGreaterThanOrEqualTo(String value) {
            addCriterion("asset_number >=", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberLessThan(String value) {
            addCriterion("asset_number <", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberLessThanOrEqualTo(String value) {
            addCriterion("asset_number <=", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberLike(String value) {
            addCriterion("asset_number like", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotLike(String value) {
            addCriterion("asset_number not like", value, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberIn(List<String> values) {
            addCriterion("asset_number in", values, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotIn(List<String> values) {
            addCriterion("asset_number not in", values, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberBetween(String value1, String value2) {
            addCriterion("asset_number between", value1, value2, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andAssetNumberNotBetween(String value1, String value2) {
            addCriterion("asset_number not between", value1, value2, "assetNumber");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(String value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(String value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(String value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(String value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLike(String value) {
            addCriterion("article_id like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotLike(String value) {
            addCriterion("article_id not like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<String> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<String> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNull() {
            addCriterion("asset_type is null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIsNotNull() {
            addCriterion("asset_type is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTypeEqualTo(String value) {
            addCriterion("asset_type =", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotEqualTo(String value) {
            addCriterion("asset_type <>", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThan(String value) {
            addCriterion("asset_type >", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_type >=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThan(String value) {
            addCriterion("asset_type <", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLessThanOrEqualTo(String value) {
            addCriterion("asset_type <=", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeLike(String value) {
            addCriterion("asset_type like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotLike(String value) {
            addCriterion("asset_type not like", value, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeIn(List<String> values) {
            addCriterion("asset_type in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotIn(List<String> values) {
            addCriterion("asset_type not in", values, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeBetween(String value1, String value2) {
            addCriterion("asset_type between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andAssetTypeNotBetween(String value1, String value2) {
            addCriterion("asset_type not between", value1, value2, "assetType");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNull() {
            addCriterion("article_name is null");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNotNull() {
            addCriterion("article_name is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNameEqualTo(String value) {
            addCriterion("article_name =", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotEqualTo(String value) {
            addCriterion("article_name <>", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThan(String value) {
            addCriterion("article_name >", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThanOrEqualTo(String value) {
            addCriterion("article_name >=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThan(String value) {
            addCriterion("article_name <", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThanOrEqualTo(String value) {
            addCriterion("article_name <=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLike(String value) {
            addCriterion("article_name like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotLike(String value) {
            addCriterion("article_name not like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameIn(List<String> values) {
            addCriterion("article_name in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotIn(List<String> values) {
            addCriterion("article_name not in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameBetween(String value1, String value2) {
            addCriterion("article_name between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotBetween(String value1, String value2) {
            addCriterion("article_name not between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleUrlIsNull() {
            addCriterion("article_url is null");
            return (Criteria) this;
        }

        public Criteria andArticleUrlIsNotNull() {
            addCriterion("article_url is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUrlEqualTo(String value) {
            addCriterion("article_url =", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotEqualTo(String value) {
            addCriterion("article_url <>", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlGreaterThan(String value) {
            addCriterion("article_url >", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("article_url >=", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlLessThan(String value) {
            addCriterion("article_url <", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlLessThanOrEqualTo(String value) {
            addCriterion("article_url <=", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlLike(String value) {
            addCriterion("article_url like", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotLike(String value) {
            addCriterion("article_url not like", value, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlIn(List<String> values) {
            addCriterion("article_url in", values, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotIn(List<String> values) {
            addCriterion("article_url not in", values, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlBetween(String value1, String value2) {
            addCriterion("article_url between", value1, value2, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleUrlNotBetween(String value1, String value2) {
            addCriterion("article_url not between", value1, value2, "articleUrl");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionIsNull() {
            addCriterion("article_introduction is null");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionIsNotNull() {
            addCriterion("article_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionEqualTo(String value) {
            addCriterion("article_introduction =", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionNotEqualTo(String value) {
            addCriterion("article_introduction <>", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionGreaterThan(String value) {
            addCriterion("article_introduction >", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("article_introduction >=", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionLessThan(String value) {
            addCriterion("article_introduction <", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionLessThanOrEqualTo(String value) {
            addCriterion("article_introduction <=", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionLike(String value) {
            addCriterion("article_introduction like", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionNotLike(String value) {
            addCriterion("article_introduction not like", value, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionIn(List<String> values) {
            addCriterion("article_introduction in", values, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionNotIn(List<String> values) {
            addCriterion("article_introduction not in", values, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionBetween(String value1, String value2) {
            addCriterion("article_introduction between", value1, value2, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andArticleIntroductionNotBetween(String value1, String value2) {
            addCriterion("article_introduction not between", value1, value2, "articleIntroduction");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdIsNull() {
            addCriterion("lease_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdIsNotNull() {
            addCriterion("lease_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdEqualTo(String value) {
            addCriterion("lease_enterprise_id =", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotEqualTo(String value) {
            addCriterion("lease_enterprise_id <>", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdGreaterThan(String value) {
            addCriterion("lease_enterprise_id >", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("lease_enterprise_id >=", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdLessThan(String value) {
            addCriterion("lease_enterprise_id <", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("lease_enterprise_id <=", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdLike(String value) {
            addCriterion("lease_enterprise_id like", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotLike(String value) {
            addCriterion("lease_enterprise_id not like", value, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdIn(List<String> values) {
            addCriterion("lease_enterprise_id in", values, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotIn(List<String> values) {
            addCriterion("lease_enterprise_id not in", values, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdBetween(String value1, String value2) {
            addCriterion("lease_enterprise_id between", value1, value2, "leaseEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andLeaseEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("lease_enterprise_id not between", value1, value2, "leaseEnterpriseId");
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

        public Criteria andLeaseCashIsNull() {
            addCriterion("lease_cash is null");
            return (Criteria) this;
        }

        public Criteria andLeaseCashIsNotNull() {
            addCriterion("lease_cash is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseCashEqualTo(BigDecimal value) {
            addCriterion("lease_cash =", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashNotEqualTo(BigDecimal value) {
            addCriterion("lease_cash <>", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashGreaterThan(BigDecimal value) {
            addCriterion("lease_cash >", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_cash >=", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashLessThan(BigDecimal value) {
            addCriterion("lease_cash <", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lease_cash <=", value, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashIn(List<BigDecimal> values) {
            addCriterion("lease_cash in", values, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashNotIn(List<BigDecimal> values) {
            addCriterion("lease_cash not in", values, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_cash between", value1, value2, "leaseCash");
            return (Criteria) this;
        }

        public Criteria andLeaseCashNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lease_cash not between", value1, value2, "leaseCash");
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

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(Byte value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(Byte value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(Byte value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(Byte value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(Byte value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<Byte> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<Byte> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(Byte value1, Byte value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(Byte value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(Byte value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(Byte value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(Byte value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<Byte> values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<Byte> values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(Byte value1, Byte value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
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