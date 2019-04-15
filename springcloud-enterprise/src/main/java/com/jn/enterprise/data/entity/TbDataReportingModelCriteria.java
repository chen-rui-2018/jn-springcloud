package com.jn.enterprise.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDataReportingModelCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataReportingModelCriteria() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("model_id like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("model_id not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
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

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(Byte value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(Byte value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(Byte value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(Byte value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(Byte value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<Byte> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<Byte> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(Byte value1, Byte value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdIsNull() {
            addCriterion("model_form_target_id is null");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdIsNotNull() {
            addCriterion("model_form_target_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdEqualTo(String value) {
            addCriterion("model_form_target_id =", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdNotEqualTo(String value) {
            addCriterion("model_form_target_id <>", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdGreaterThan(String value) {
            addCriterion("model_form_target_id >", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdGreaterThanOrEqualTo(String value) {
            addCriterion("model_form_target_id >=", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdLessThan(String value) {
            addCriterion("model_form_target_id <", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdLessThanOrEqualTo(String value) {
            addCriterion("model_form_target_id <=", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdLike(String value) {
            addCriterion("model_form_target_id like", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdNotLike(String value) {
            addCriterion("model_form_target_id not like", value, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdIn(List<String> values) {
            addCriterion("model_form_target_id in", values, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdNotIn(List<String> values) {
            addCriterion("model_form_target_id not in", values, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdBetween(String value1, String value2) {
            addCriterion("model_form_target_id between", value1, value2, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelFormTargetIdNotBetween(String value1, String value2) {
            addCriterion("model_form_target_id not between", value1, value2, "modelFormTargetId");
            return (Criteria) this;
        }

        public Criteria andModelCycleIsNull() {
            addCriterion("model_cycle is null");
            return (Criteria) this;
        }

        public Criteria andModelCycleIsNotNull() {
            addCriterion("model_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andModelCycleEqualTo(String value) {
            addCriterion("model_cycle =", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleNotEqualTo(String value) {
            addCriterion("model_cycle <>", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleGreaterThan(String value) {
            addCriterion("model_cycle >", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleGreaterThanOrEqualTo(String value) {
            addCriterion("model_cycle >=", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleLessThan(String value) {
            addCriterion("model_cycle <", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleLessThanOrEqualTo(String value) {
            addCriterion("model_cycle <=", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleLike(String value) {
            addCriterion("model_cycle like", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleNotLike(String value) {
            addCriterion("model_cycle not like", value, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleIn(List<String> values) {
            addCriterion("model_cycle in", values, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleNotIn(List<String> values) {
            addCriterion("model_cycle not in", values, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleBetween(String value1, String value2) {
            addCriterion("model_cycle between", value1, value2, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andModelCycleNotBetween(String value1, String value2) {
            addCriterion("model_cycle not between", value1, value2, "modelCycle");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysIsNull() {
            addCriterion("warning_before_days is null");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysIsNotNull() {
            addCriterion("warning_before_days is not null");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysEqualTo(String value) {
            addCriterion("warning_before_days =", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotEqualTo(String value) {
            addCriterion("warning_before_days <>", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysGreaterThan(String value) {
            addCriterion("warning_before_days >", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysGreaterThanOrEqualTo(String value) {
            addCriterion("warning_before_days >=", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysLessThan(String value) {
            addCriterion("warning_before_days <", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysLessThanOrEqualTo(String value) {
            addCriterion("warning_before_days <=", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysLike(String value) {
            addCriterion("warning_before_days like", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotLike(String value) {
            addCriterion("warning_before_days not like", value, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysIn(List<String> values) {
            addCriterion("warning_before_days in", values, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotIn(List<String> values) {
            addCriterion("warning_before_days not in", values, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysBetween(String value1, String value2) {
            addCriterion("warning_before_days between", value1, value2, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningBeforeDaysNotBetween(String value1, String value2) {
            addCriterion("warning_before_days not between", value1, value2, "warningBeforeDays");
            return (Criteria) this;
        }

        public Criteria andWarningByIsNull() {
            addCriterion("warning_by is null");
            return (Criteria) this;
        }

        public Criteria andWarningByIsNotNull() {
            addCriterion("warning_by is not null");
            return (Criteria) this;
        }

        public Criteria andWarningByEqualTo(String value) {
            addCriterion("warning_by =", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByNotEqualTo(String value) {
            addCriterion("warning_by <>", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByGreaterThan(String value) {
            addCriterion("warning_by >", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByGreaterThanOrEqualTo(String value) {
            addCriterion("warning_by >=", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByLessThan(String value) {
            addCriterion("warning_by <", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByLessThanOrEqualTo(String value) {
            addCriterion("warning_by <=", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByLike(String value) {
            addCriterion("warning_by like", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByNotLike(String value) {
            addCriterion("warning_by not like", value, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByIn(List<String> values) {
            addCriterion("warning_by in", values, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByNotIn(List<String> values) {
            addCriterion("warning_by not in", values, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByBetween(String value1, String value2) {
            addCriterion("warning_by between", value1, value2, "warningBy");
            return (Criteria) this;
        }

        public Criteria andWarningByNotBetween(String value1, String value2) {
            addCriterion("warning_by not between", value1, value2, "warningBy");
            return (Criteria) this;
        }

        public Criteria andPcAdIsNull() {
            addCriterion("pc_ad is null");
            return (Criteria) this;
        }

        public Criteria andPcAdIsNotNull() {
            addCriterion("pc_ad is not null");
            return (Criteria) this;
        }

        public Criteria andPcAdEqualTo(String value) {
            addCriterion("pc_ad =", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdNotEqualTo(String value) {
            addCriterion("pc_ad <>", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdGreaterThan(String value) {
            addCriterion("pc_ad >", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdGreaterThanOrEqualTo(String value) {
            addCriterion("pc_ad >=", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdLessThan(String value) {
            addCriterion("pc_ad <", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdLessThanOrEqualTo(String value) {
            addCriterion("pc_ad <=", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdLike(String value) {
            addCriterion("pc_ad like", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdNotLike(String value) {
            addCriterion("pc_ad not like", value, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdIn(List<String> values) {
            addCriterion("pc_ad in", values, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdNotIn(List<String> values) {
            addCriterion("pc_ad not in", values, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdBetween(String value1, String value2) {
            addCriterion("pc_ad between", value1, value2, "pcAd");
            return (Criteria) this;
        }

        public Criteria andPcAdNotBetween(String value1, String value2) {
            addCriterion("pc_ad not between", value1, value2, "pcAd");
            return (Criteria) this;
        }

        public Criteria andAppAdIsNull() {
            addCriterion("app_ad is null");
            return (Criteria) this;
        }

        public Criteria andAppAdIsNotNull() {
            addCriterion("app_ad is not null");
            return (Criteria) this;
        }

        public Criteria andAppAdEqualTo(String value) {
            addCriterion("app_ad =", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdNotEqualTo(String value) {
            addCriterion("app_ad <>", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdGreaterThan(String value) {
            addCriterion("app_ad >", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdGreaterThanOrEqualTo(String value) {
            addCriterion("app_ad >=", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdLessThan(String value) {
            addCriterion("app_ad <", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdLessThanOrEqualTo(String value) {
            addCriterion("app_ad <=", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdLike(String value) {
            addCriterion("app_ad like", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdNotLike(String value) {
            addCriterion("app_ad not like", value, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdIn(List<String> values) {
            addCriterion("app_ad in", values, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdNotIn(List<String> values) {
            addCriterion("app_ad not in", values, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdBetween(String value1, String value2) {
            addCriterion("app_ad between", value1, value2, "appAd");
            return (Criteria) this;
        }

        public Criteria andAppAdNotBetween(String value1, String value2) {
            addCriterion("app_ad not between", value1, value2, "appAd");
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

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_Id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_Id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_Id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_Id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_Id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_Id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_Id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_Id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_Id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_Id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_Id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_Id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_Id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_Id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andOtherDataIsNull() {
            addCriterion("other_data is null");
            return (Criteria) this;
        }

        public Criteria andOtherDataIsNotNull() {
            addCriterion("other_data is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDataEqualTo(String value) {
            addCriterion("other_data =", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataNotEqualTo(String value) {
            addCriterion("other_data <>", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataGreaterThan(String value) {
            addCriterion("other_data >", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataGreaterThanOrEqualTo(String value) {
            addCriterion("other_data >=", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataLessThan(String value) {
            addCriterion("other_data <", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataLessThanOrEqualTo(String value) {
            addCriterion("other_data <=", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataLike(String value) {
            addCriterion("other_data like", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataNotLike(String value) {
            addCriterion("other_data not like", value, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataIn(List<String> values) {
            addCriterion("other_data in", values, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataNotIn(List<String> values) {
            addCriterion("other_data not in", values, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataBetween(String value1, String value2) {
            addCriterion("other_data between", value1, value2, "otherData");
            return (Criteria) this;
        }

        public Criteria andOtherDataNotBetween(String value1, String value2) {
            addCriterion("other_data not between", value1, value2, "otherData");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeIsNull() {
            addCriterion("task_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeIsNotNull() {
            addCriterion("task_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeEqualTo(String value) {
            addCriterion("task_create_time =", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotEqualTo(String value) {
            addCriterion("task_create_time <>", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeGreaterThan(String value) {
            addCriterion("task_create_time >", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("task_create_time >=", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeLessThan(String value) {
            addCriterion("task_create_time <", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("task_create_time <=", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeLike(String value) {
            addCriterion("task_create_time like", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotLike(String value) {
            addCriterion("task_create_time not like", value, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeIn(List<String> values) {
            addCriterion("task_create_time in", values, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotIn(List<String> values) {
            addCriterion("task_create_time not in", values, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeBetween(String value1, String value2) {
            addCriterion("task_create_time between", value1, value2, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andTaskCreateTimeNotBetween(String value1, String value2) {
            addCriterion("task_create_time not between", value1, value2, "taskCreateTime");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineIsNull() {
            addCriterion("filll_in_form_deadline is null");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineIsNotNull() {
            addCriterion("filll_in_form_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineEqualTo(String value) {
            addCriterion("filll_in_form_deadline =", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineNotEqualTo(String value) {
            addCriterion("filll_in_form_deadline <>", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineGreaterThan(String value) {
            addCriterion("filll_in_form_deadline >", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("filll_in_form_deadline >=", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineLessThan(String value) {
            addCriterion("filll_in_form_deadline <", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineLessThanOrEqualTo(String value) {
            addCriterion("filll_in_form_deadline <=", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineLike(String value) {
            addCriterion("filll_in_form_deadline like", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineNotLike(String value) {
            addCriterion("filll_in_form_deadline not like", value, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineIn(List<String> values) {
            addCriterion("filll_in_form_deadline in", values, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineNotIn(List<String> values) {
            addCriterion("filll_in_form_deadline not in", values, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineBetween(String value1, String value2) {
            addCriterion("filll_in_form_deadline between", value1, value2, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFilllInFormDeadlineNotBetween(String value1, String value2) {
            addCriterion("filll_in_form_deadline not between", value1, value2, "filllInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(String value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(String value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(String value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(String value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(String value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(String value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLike(String value) {
            addCriterion("order like", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotLike(String value) {
            addCriterion("order not like", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<String> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<String> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(String value1, String value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(String value1, String value2) {
            addCriterion("order not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andReminderIsNull() {
            addCriterion("reminder is null");
            return (Criteria) this;
        }

        public Criteria andReminderIsNotNull() {
            addCriterion("reminder is not null");
            return (Criteria) this;
        }

        public Criteria andReminderEqualTo(String value) {
            addCriterion("reminder =", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderNotEqualTo(String value) {
            addCriterion("reminder <>", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderGreaterThan(String value) {
            addCriterion("reminder >", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderGreaterThanOrEqualTo(String value) {
            addCriterion("reminder >=", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderLessThan(String value) {
            addCriterion("reminder <", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderLessThanOrEqualTo(String value) {
            addCriterion("reminder <=", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderLike(String value) {
            addCriterion("reminder like", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderNotLike(String value) {
            addCriterion("reminder not like", value, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderIn(List<String> values) {
            addCriterion("reminder in", values, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderNotIn(List<String> values) {
            addCriterion("reminder not in", values, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderBetween(String value1, String value2) {
            addCriterion("reminder between", value1, value2, "reminder");
            return (Criteria) this;
        }

        public Criteria andReminderNotBetween(String value1, String value2) {
            addCriterion("reminder not between", value1, value2, "reminder");
            return (Criteria) this;
        }

        public Criteria andRemindStatusIsNull() {
            addCriterion("remind_status is null");
            return (Criteria) this;
        }

        public Criteria andRemindStatusIsNotNull() {
            addCriterion("remind_status is not null");
            return (Criteria) this;
        }

        public Criteria andRemindStatusEqualTo(String value) {
            addCriterion("remind_status =", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusNotEqualTo(String value) {
            addCriterion("remind_status <>", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusGreaterThan(String value) {
            addCriterion("remind_status >", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusGreaterThanOrEqualTo(String value) {
            addCriterion("remind_status >=", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusLessThan(String value) {
            addCriterion("remind_status <", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusLessThanOrEqualTo(String value) {
            addCriterion("remind_status <=", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusLike(String value) {
            addCriterion("remind_status like", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusNotLike(String value) {
            addCriterion("remind_status not like", value, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusIn(List<String> values) {
            addCriterion("remind_status in", values, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusNotIn(List<String> values) {
            addCriterion("remind_status not in", values, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusBetween(String value1, String value2) {
            addCriterion("remind_status between", value1, value2, "remindStatus");
            return (Criteria) this;
        }

        public Criteria andRemindStatusNotBetween(String value1, String value2) {
            addCriterion("remind_status not between", value1, value2, "remindStatus");
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