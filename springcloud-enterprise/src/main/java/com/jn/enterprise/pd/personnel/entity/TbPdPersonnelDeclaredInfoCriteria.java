package com.jn.enterprise.pd.personnel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdPersonnelDeclaredInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdPersonnelDeclaredInfoCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameIsNull() {
            addCriterion("declarer_name is null");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameIsNotNull() {
            addCriterion("declarer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameEqualTo(String value) {
            addCriterion("declarer_name =", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameNotEqualTo(String value) {
            addCriterion("declarer_name <>", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameGreaterThan(String value) {
            addCriterion("declarer_name >", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameGreaterThanOrEqualTo(String value) {
            addCriterion("declarer_name >=", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameLessThan(String value) {
            addCriterion("declarer_name <", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameLessThanOrEqualTo(String value) {
            addCriterion("declarer_name <=", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameLike(String value) {
            addCriterion("declarer_name like", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameNotLike(String value) {
            addCriterion("declarer_name not like", value, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameIn(List<String> values) {
            addCriterion("declarer_name in", values, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameNotIn(List<String> values) {
            addCriterion("declarer_name not in", values, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameBetween(String value1, String value2) {
            addCriterion("declarer_name between", value1, value2, "declarerName");
            return (Criteria) this;
        }

        public Criteria andDeclarerNameNotBetween(String value1, String value2) {
            addCriterion("declarer_name not between", value1, value2, "declarerName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdIsNull() {
            addCriterion("industrial_field_id is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdIsNotNull() {
            addCriterion("industrial_field_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdEqualTo(String value) {
            addCriterion("industrial_field_id =", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotEqualTo(String value) {
            addCriterion("industrial_field_id <>", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdGreaterThan(String value) {
            addCriterion("industrial_field_id >", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdGreaterThanOrEqualTo(String value) {
            addCriterion("industrial_field_id >=", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdLessThan(String value) {
            addCriterion("industrial_field_id <", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdLessThanOrEqualTo(String value) {
            addCriterion("industrial_field_id <=", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdLike(String value) {
            addCriterion("industrial_field_id like", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotLike(String value) {
            addCriterion("industrial_field_id not like", value, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdIn(List<String> values) {
            addCriterion("industrial_field_id in", values, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotIn(List<String> values) {
            addCriterion("industrial_field_id not in", values, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdBetween(String value1, String value2) {
            addCriterion("industrial_field_id between", value1, value2, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldIdNotBetween(String value1, String value2) {
            addCriterion("industrial_field_id not between", value1, value2, "industrialFieldId");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameIsNull() {
            addCriterion("industrial_field_name is null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameIsNotNull() {
            addCriterion("industrial_field_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameEqualTo(String value) {
            addCriterion("industrial_field_name =", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotEqualTo(String value) {
            addCriterion("industrial_field_name <>", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameGreaterThan(String value) {
            addCriterion("industrial_field_name >", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("industrial_field_name >=", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameLessThan(String value) {
            addCriterion("industrial_field_name <", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameLessThanOrEqualTo(String value) {
            addCriterion("industrial_field_name <=", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameLike(String value) {
            addCriterion("industrial_field_name like", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotLike(String value) {
            addCriterion("industrial_field_name not like", value, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameIn(List<String> values) {
            addCriterion("industrial_field_name in", values, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotIn(List<String> values) {
            addCriterion("industrial_field_name not in", values, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameBetween(String value1, String value2) {
            addCriterion("industrial_field_name between", value1, value2, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIndustrialFieldNameNotBetween(String value1, String value2) {
            addCriterion("industrial_field_name not between", value1, value2, "industrialFieldName");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsIsNull() {
            addCriterion("graduate_institutions is null");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsIsNotNull() {
            addCriterion("graduate_institutions is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsEqualTo(String value) {
            addCriterion("graduate_institutions =", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotEqualTo(String value) {
            addCriterion("graduate_institutions <>", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsGreaterThan(String value) {
            addCriterion("graduate_institutions >", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_institutions >=", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsLessThan(String value) {
            addCriterion("graduate_institutions <", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsLessThanOrEqualTo(String value) {
            addCriterion("graduate_institutions <=", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsLike(String value) {
            addCriterion("graduate_institutions like", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotLike(String value) {
            addCriterion("graduate_institutions not like", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsIn(List<String> values) {
            addCriterion("graduate_institutions in", values, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotIn(List<String> values) {
            addCriterion("graduate_institutions not in", values, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsBetween(String value1, String value2) {
            addCriterion("graduate_institutions between", value1, value2, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotBetween(String value1, String value2) {
            addCriterion("graduate_institutions not between", value1, value2, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andEducaIdIsNull() {
            addCriterion("educa_id is null");
            return (Criteria) this;
        }

        public Criteria andEducaIdIsNotNull() {
            addCriterion("educa_id is not null");
            return (Criteria) this;
        }

        public Criteria andEducaIdEqualTo(String value) {
            addCriterion("educa_id =", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdNotEqualTo(String value) {
            addCriterion("educa_id <>", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdGreaterThan(String value) {
            addCriterion("educa_id >", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdGreaterThanOrEqualTo(String value) {
            addCriterion("educa_id >=", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdLessThan(String value) {
            addCriterion("educa_id <", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdLessThanOrEqualTo(String value) {
            addCriterion("educa_id <=", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdLike(String value) {
            addCriterion("educa_id like", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdNotLike(String value) {
            addCriterion("educa_id not like", value, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdIn(List<String> values) {
            addCriterion("educa_id in", values, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdNotIn(List<String> values) {
            addCriterion("educa_id not in", values, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdBetween(String value1, String value2) {
            addCriterion("educa_id between", value1, value2, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaIdNotBetween(String value1, String value2) {
            addCriterion("educa_id not between", value1, value2, "educaId");
            return (Criteria) this;
        }

        public Criteria andEducaNameIsNull() {
            addCriterion("educa_name is null");
            return (Criteria) this;
        }

        public Criteria andEducaNameIsNotNull() {
            addCriterion("educa_name is not null");
            return (Criteria) this;
        }

        public Criteria andEducaNameEqualTo(String value) {
            addCriterion("educa_name =", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameNotEqualTo(String value) {
            addCriterion("educa_name <>", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameGreaterThan(String value) {
            addCriterion("educa_name >", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameGreaterThanOrEqualTo(String value) {
            addCriterion("educa_name >=", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameLessThan(String value) {
            addCriterion("educa_name <", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameLessThanOrEqualTo(String value) {
            addCriterion("educa_name <=", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameLike(String value) {
            addCriterion("educa_name like", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameNotLike(String value) {
            addCriterion("educa_name not like", value, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameIn(List<String> values) {
            addCriterion("educa_name in", values, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameNotIn(List<String> values) {
            addCriterion("educa_name not in", values, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameBetween(String value1, String value2) {
            addCriterion("educa_name between", value1, value2, "educaName");
            return (Criteria) this;
        }

        public Criteria andEducaNameNotBetween(String value1, String value2) {
            addCriterion("educa_name not between", value1, value2, "educaName");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNull() {
            addCriterion("work_unit is null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNotNull() {
            addCriterion("work_unit is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitEqualTo(String value) {
            addCriterion("work_unit =", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotEqualTo(String value) {
            addCriterion("work_unit <>", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThan(String value) {
            addCriterion("work_unit >", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("work_unit >=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThan(String value) {
            addCriterion("work_unit <", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("work_unit <=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLike(String value) {
            addCriterion("work_unit like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotLike(String value) {
            addCriterion("work_unit not like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIn(List<String> values) {
            addCriterion("work_unit in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotIn(List<String> values) {
            addCriterion("work_unit not in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitBetween(String value1, String value2) {
            addCriterion("work_unit between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotBetween(String value1, String value2) {
            addCriterion("work_unit not between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNull() {
            addCriterion("business is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("business is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(String value) {
            addCriterion("business =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(String value) {
            addCriterion("business <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(String value) {
            addCriterion("business >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("business >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(String value) {
            addCriterion("business <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(String value) {
            addCriterion("business <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLike(String value) {
            addCriterion("business like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotLike(String value) {
            addCriterion("business not like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<String> values) {
            addCriterion("business in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<String> values) {
            addCriterion("business not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(String value1, String value2) {
            addCriterion("business between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(String value1, String value2) {
            addCriterion("business not between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyIsNull() {
            addCriterion("is_overseas_study is null");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyIsNotNull() {
            addCriterion("is_overseas_study is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyEqualTo(Byte value) {
            addCriterion("is_overseas_study =", value, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyNotEqualTo(Byte value) {
            addCriterion("is_overseas_study <>", value, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyGreaterThan(Byte value) {
            addCriterion("is_overseas_study >", value, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_overseas_study >=", value, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyLessThan(Byte value) {
            addCriterion("is_overseas_study <", value, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyLessThanOrEqualTo(Byte value) {
            addCriterion("is_overseas_study <=", value, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyIn(List<Byte> values) {
            addCriterion("is_overseas_study in", values, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyNotIn(List<Byte> values) {
            addCriterion("is_overseas_study not in", values, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyBetween(Byte value1, Byte value2) {
            addCriterion("is_overseas_study between", value1, value2, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsOverseasStudyNotBetween(Byte value1, Byte value2) {
            addCriterion("is_overseas_study not between", value1, value2, "isOverseasStudy");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceIsNull() {
            addCriterion("is_entrepreneurial_experience is null");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceIsNotNull() {
            addCriterion("is_entrepreneurial_experience is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceEqualTo(Byte value) {
            addCriterion("is_entrepreneurial_experience =", value, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceNotEqualTo(Byte value) {
            addCriterion("is_entrepreneurial_experience <>", value, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceGreaterThan(Byte value) {
            addCriterion("is_entrepreneurial_experience >", value, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_entrepreneurial_experience >=", value, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceLessThan(Byte value) {
            addCriterion("is_entrepreneurial_experience <", value, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceLessThanOrEqualTo(Byte value) {
            addCriterion("is_entrepreneurial_experience <=", value, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceIn(List<Byte> values) {
            addCriterion("is_entrepreneurial_experience in", values, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceNotIn(List<Byte> values) {
            addCriterion("is_entrepreneurial_experience not in", values, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceBetween(Byte value1, Byte value2) {
            addCriterion("is_entrepreneurial_experience between", value1, value2, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsEntrepreneurialExperienceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_entrepreneurial_experience not between", value1, value2, "isEntrepreneurialExperience");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandIsNull() {
            addCriterion("is_registration_land is null");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandIsNotNull() {
            addCriterion("is_registration_land is not null");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandEqualTo(Byte value) {
            addCriterion("is_registration_land =", value, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandNotEqualTo(Byte value) {
            addCriterion("is_registration_land <>", value, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandGreaterThan(Byte value) {
            addCriterion("is_registration_land >", value, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_registration_land >=", value, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandLessThan(Byte value) {
            addCriterion("is_registration_land <", value, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandLessThanOrEqualTo(Byte value) {
            addCriterion("is_registration_land <=", value, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandIn(List<Byte> values) {
            addCriterion("is_registration_land in", values, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandNotIn(List<Byte> values) {
            addCriterion("is_registration_land not in", values, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandBetween(Byte value1, Byte value2) {
            addCriterion("is_registration_land between", value1, value2, "isRegistrationLand");
            return (Criteria) this;
        }

        public Criteria andIsRegistrationLandNotBetween(Byte value1, Byte value2) {
            addCriterion("is_registration_land not between", value1, value2, "isRegistrationLand");
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

        public Criteria andContactTelephoneIsNull() {
            addCriterion("contact_telephone is null");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneIsNotNull() {
            addCriterion("contact_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneEqualTo(String value) {
            addCriterion("contact_telephone =", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotEqualTo(String value) {
            addCriterion("contact_telephone <>", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneGreaterThan(String value) {
            addCriterion("contact_telephone >", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_telephone >=", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneLessThan(String value) {
            addCriterion("contact_telephone <", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneLessThanOrEqualTo(String value) {
            addCriterion("contact_telephone <=", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneLike(String value) {
            addCriterion("contact_telephone like", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotLike(String value) {
            addCriterion("contact_telephone not like", value, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneIn(List<String> values) {
            addCriterion("contact_telephone in", values, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotIn(List<String> values) {
            addCriterion("contact_telephone not in", values, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneBetween(String value1, String value2) {
            addCriterion("contact_telephone between", value1, value2, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andContactTelephoneNotBetween(String value1, String value2) {
            addCriterion("contact_telephone not between", value1, value2, "contactTelephone");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisIsNull() {
            addCriterion("project_synopsis is null");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisIsNotNull() {
            addCriterion("project_synopsis is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisEqualTo(String value) {
            addCriterion("project_synopsis =", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisNotEqualTo(String value) {
            addCriterion("project_synopsis <>", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisGreaterThan(String value) {
            addCriterion("project_synopsis >", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("project_synopsis >=", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisLessThan(String value) {
            addCriterion("project_synopsis <", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisLessThanOrEqualTo(String value) {
            addCriterion("project_synopsis <=", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisLike(String value) {
            addCriterion("project_synopsis like", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisNotLike(String value) {
            addCriterion("project_synopsis not like", value, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisIn(List<String> values) {
            addCriterion("project_synopsis in", values, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisNotIn(List<String> values) {
            addCriterion("project_synopsis not in", values, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisBetween(String value1, String value2) {
            addCriterion("project_synopsis between", value1, value2, "projectSynopsis");
            return (Criteria) this;
        }

        public Criteria andProjectSynopsisNotBetween(String value1, String value2) {
            addCriterion("project_synopsis not between", value1, value2, "projectSynopsis");
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

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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