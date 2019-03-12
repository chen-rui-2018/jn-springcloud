package com.jn.park.approve.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbApproveDictGuideMaterialCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbApproveDictGuideMaterialCriteria() {
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
            addCriterion("dgm.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("dgm.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("dgm.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("dgm.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("dgm.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dgm.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("dgm.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("dgm.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("dgm.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("dgm.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("dgm.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dgm.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("dgm.name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("dgm.name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("dgm.name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("dgm.name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("dgm.name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("dgm.name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("dgm.name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("dgm.name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("dgm.name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("dgm.name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("dgm.name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("dgm.name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("dgm.name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("dgm.name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSampleIsNull() {
            addCriterion("dgm.sample is null");
            return (Criteria) this;
        }

        public Criteria andSampleIsNotNull() {
            addCriterion("dgm.sample is not null");
            return (Criteria) this;
        }

        public Criteria andSampleEqualTo(String value) {
            addCriterion("dgm.sample =", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotEqualTo(String value) {
            addCriterion("dgm.sample <>", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleGreaterThan(String value) {
            addCriterion("dgm.sample >", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleGreaterThanOrEqualTo(String value) {
            addCriterion("dgm.sample >=", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleLessThan(String value) {
            addCriterion("dgm.sample <", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleLessThanOrEqualTo(String value) {
            addCriterion("dgm.sample <=", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleLike(String value) {
            addCriterion("dgm.sample like", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotLike(String value) {
            addCriterion("dgm.sample not like", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleIn(List<String> values) {
            addCriterion("dgm.sample in", values, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotIn(List<String> values) {
            addCriterion("dgm.sample not in", values, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleBetween(String value1, String value2) {
            addCriterion("dgm.sample between", value1, value2, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotBetween(String value1, String value2) {
            addCriterion("dgm.sample not between", value1, value2, "sample");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityIsNull() {
            addCriterion("dgm.paper_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityIsNotNull() {
            addCriterion("dgm.paper_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityEqualTo(String value) {
            addCriterion("dgm.paper_quantity =", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityNotEqualTo(String value) {
            addCriterion("dgm.paper_quantity <>", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityGreaterThan(String value) {
            addCriterion("dgm.paper_quantity >", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("dgm.paper_quantity >=", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityLessThan(String value) {
            addCriterion("dgm.paper_quantity <", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityLessThanOrEqualTo(String value) {
            addCriterion("dgm.paper_quantity <=", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityLike(String value) {
            addCriterion("dgm.paper_quantity like", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityNotLike(String value) {
            addCriterion("dgm.paper_quantity not like", value, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityIn(List<String> values) {
            addCriterion("dgm.paper_quantity in", values, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityNotIn(List<String> values) {
            addCriterion("dgm.paper_quantity not in", values, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityBetween(String value1, String value2) {
            addCriterion("dgm.paper_quantity between", value1, value2, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andPaperQuantityNotBetween(String value1, String value2) {
            addCriterion("dgm.paper_quantity not between", value1, value2, "paperQuantity");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicIsNull() {
            addCriterion("dgm.is_need_electronic is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicIsNotNull() {
            addCriterion("dgm.is_need_electronic is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicEqualTo(Byte value) {
            addCriterion("dgm.is_need_electronic =", value, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicNotEqualTo(Byte value) {
            addCriterion("dgm.is_need_electronic <>", value, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicGreaterThan(Byte value) {
            addCriterion("dgm.is_need_electronic >", value, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicGreaterThanOrEqualTo(Byte value) {
            addCriterion("dgm.is_need_electronic >=", value, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicLessThan(Byte value) {
            addCriterion("dgm.is_need_electronic <", value, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicLessThanOrEqualTo(Byte value) {
            addCriterion("dgm.is_need_electronic <=", value, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicIn(List<Byte> values) {
            addCriterion("dgm.is_need_electronic in", values, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicNotIn(List<Byte> values) {
            addCriterion("dgm.is_need_electronic not in", values, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicBetween(Byte value1, Byte value2) {
            addCriterion("dgm.is_need_electronic between", value1, value2, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsNeedElectronicNotBetween(Byte value1, Byte value2) {
            addCriterion("dgm.is_need_electronic not between", value1, value2, "isNeedElectronic");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNull() {
            addCriterion("dgm.is_required is null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNotNull() {
            addCriterion("dgm.is_required is not null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredEqualTo(Byte value) {
            addCriterion("dgm.is_required =", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotEqualTo(Byte value) {
            addCriterion("dgm.is_required <>", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThan(Byte value) {
            addCriterion("dgm.is_required >", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("dgm.is_required >=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThan(Byte value) {
            addCriterion("dgm.is_required <", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThanOrEqualTo(Byte value) {
            addCriterion("dgm.is_required <=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIn(List<Byte> values) {
            addCriterion("dgm.is_required in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotIn(List<Byte> values) {
            addCriterion("dgm.is_required not in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredBetween(Byte value1, Byte value2) {
            addCriterion("dgm.is_required between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotBetween(Byte value1, Byte value2) {
            addCriterion("dgm.is_required not between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("dgm.show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("dgm.show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(String value) {
            addCriterion("dgm.show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(String value) {
            addCriterion("dgm.show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(String value) {
            addCriterion("dgm.show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("dgm.show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(String value) {
            addCriterion("dgm.show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(String value) {
            addCriterion("dgm.show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLike(String value) {
            addCriterion("dgm.show_status like", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotLike(String value) {
            addCriterion("dgm.show_status not like", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<String> values) {
            addCriterion("dgm.show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<String> values) {
            addCriterion("dgm.show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(String value1, String value2) {
            addCriterion("dgm.show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(String value1, String value2) {
            addCriterion("dgm.show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("dgm.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("dgm.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("dgm.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("dgm.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("dgm.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("dgm.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("dgm.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("dgm.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("dgm.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("dgm.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("dgm.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("dgm.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("dgm.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("dgm.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("dgm.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("dgm.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("dgm.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("dgm.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("dgm.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("dgm.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("dgm.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("dgm.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("dgm.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("dgm.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("dgm.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("dgm.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("dgm.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("dgm.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("dgm.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("dgm.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("dgm.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dgm.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("dgm.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("dgm.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("dgm.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("dgm.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("dgm.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("dgm.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("dgm.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("dgm.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("dgm.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("dgm.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("dgm.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("dgm.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("dgm.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("dgm.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("dgm.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("dgm.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("dgm.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("dgm.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("dgm.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("dgm.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("dgm.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("dgm.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("dgm.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("dgm.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("dgm.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dgm.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("dgm.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("dgm.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("dgm.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("dgm.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("dgm.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("dgm.modified_time not between", value1, value2, "modifiedTime");
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