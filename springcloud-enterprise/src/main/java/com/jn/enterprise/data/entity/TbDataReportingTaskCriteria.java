package com.jn.enterprise.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbDataReportingTaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDataReportingTaskCriteria() {
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

        public Criteria andFillIdIsNull() {
            addCriterion("fill_id is null");
            return (Criteria) this;
        }

        public Criteria andFillIdIsNotNull() {
            addCriterion("fill_id is not null");
            return (Criteria) this;
        }

        public Criteria andFillIdEqualTo(String value) {
            addCriterion("fill_id =", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotEqualTo(String value) {
            addCriterion("fill_id <>", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdGreaterThan(String value) {
            addCriterion("fill_id >", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdGreaterThanOrEqualTo(String value) {
            addCriterion("fill_id >=", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdLessThan(String value) {
            addCriterion("fill_id <", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdLessThanOrEqualTo(String value) {
            addCriterion("fill_id <=", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdLike(String value) {
            addCriterion("fill_id like", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotLike(String value) {
            addCriterion("fill_id not like", value, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdIn(List<String> values) {
            addCriterion("fill_id in", values, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotIn(List<String> values) {
            addCriterion("fill_id not in", values, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdBetween(String value1, String value2) {
            addCriterion("fill_id between", value1, value2, "fillId");
            return (Criteria) this;
        }

        public Criteria andFillIdNotBetween(String value1, String value2) {
            addCriterion("fill_id not between", value1, value2, "fillId");
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

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(Byte value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(Byte value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(Byte value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(Byte value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(Byte value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<Byte> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<Byte> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(Byte value1, Byte value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
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

        public Criteria andFillInFormIdIsNull() {
            addCriterion("fill_in_form_id is null");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdIsNotNull() {
            addCriterion("fill_in_form_id is not null");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdEqualTo(String value) {
            addCriterion("fill_in_form_id =", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdNotEqualTo(String value) {
            addCriterion("fill_in_form_id <>", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdGreaterThan(String value) {
            addCriterion("fill_in_form_id >", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdGreaterThanOrEqualTo(String value) {
            addCriterion("fill_in_form_id >=", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdLessThan(String value) {
            addCriterion("fill_in_form_id <", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdLessThanOrEqualTo(String value) {
            addCriterion("fill_in_form_id <=", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdLike(String value) {
            addCriterion("fill_in_form_id like", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdNotLike(String value) {
            addCriterion("fill_in_form_id not like", value, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdIn(List<String> values) {
            addCriterion("fill_in_form_id in", values, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdNotIn(List<String> values) {
            addCriterion("fill_in_form_id not in", values, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdBetween(String value1, String value2) {
            addCriterion("fill_in_form_id between", value1, value2, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormIdNotBetween(String value1, String value2) {
            addCriterion("fill_in_form_id not between", value1, value2, "fillInFormId");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameIsNull() {
            addCriterion("fill_in_form_name is null");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameIsNotNull() {
            addCriterion("fill_in_form_name is not null");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameEqualTo(String value) {
            addCriterion("fill_in_form_name =", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameNotEqualTo(String value) {
            addCriterion("fill_in_form_name <>", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameGreaterThan(String value) {
            addCriterion("fill_in_form_name >", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameGreaterThanOrEqualTo(String value) {
            addCriterion("fill_in_form_name >=", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameLessThan(String value) {
            addCriterion("fill_in_form_name <", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameLessThanOrEqualTo(String value) {
            addCriterion("fill_in_form_name <=", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameLike(String value) {
            addCriterion("fill_in_form_name like", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameNotLike(String value) {
            addCriterion("fill_in_form_name not like", value, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameIn(List<String> values) {
            addCriterion("fill_in_form_name in", values, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameNotIn(List<String> values) {
            addCriterion("fill_in_form_name not in", values, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameBetween(String value1, String value2) {
            addCriterion("fill_in_form_name between", value1, value2, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFillInFormNameNotBetween(String value1, String value2) {
            addCriterion("fill_in_form_name not between", value1, value2, "fillInFormName");
            return (Criteria) this;
        }

        public Criteria andFormTimeIsNull() {
            addCriterion("form_time is null");
            return (Criteria) this;
        }

        public Criteria andFormTimeIsNotNull() {
            addCriterion("form_time is not null");
            return (Criteria) this;
        }

        public Criteria andFormTimeEqualTo(String value) {
            addCriterion("form_time =", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeNotEqualTo(String value) {
            addCriterion("form_time <>", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeGreaterThan(String value) {
            addCriterion("form_time >", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeGreaterThanOrEqualTo(String value) {
            addCriterion("form_time >=", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeLessThan(String value) {
            addCriterion("form_time <", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeLessThanOrEqualTo(String value) {
            addCriterion("form_time <=", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeLike(String value) {
            addCriterion("form_time like", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeNotLike(String value) {
            addCriterion("form_time not like", value, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeIn(List<String> values) {
            addCriterion("form_time in", values, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeNotIn(List<String> values) {
            addCriterion("form_time not in", values, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeBetween(String value1, String value2) {
            addCriterion("form_time between", value1, value2, "formTime");
            return (Criteria) this;
        }

        public Criteria andFormTimeNotBetween(String value1, String value2) {
            addCriterion("form_time not between", value1, value2, "formTime");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineIsNull() {
            addCriterion("fill_in_form_deadline is null");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineIsNotNull() {
            addCriterion("fill_in_form_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineEqualTo(String value) {
            addCriterion("fill_in_form_deadline =", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineNotEqualTo(String value) {
            addCriterion("fill_in_form_deadline <>", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineGreaterThan(String value) {
            addCriterion("fill_in_form_deadline >", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("fill_in_form_deadline >=", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineLessThan(String value) {
            addCriterion("fill_in_form_deadline <", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineLessThanOrEqualTo(String value) {
            addCriterion("fill_in_form_deadline <=", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineLike(String value) {
            addCriterion("fill_in_form_deadline like", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineNotLike(String value) {
            addCriterion("fill_in_form_deadline not like", value, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineIn(List<String> values) {
            addCriterion("fill_in_form_deadline in", values, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineNotIn(List<String> values) {
            addCriterion("fill_in_form_deadline not in", values, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineBetween(String value1, String value2) {
            addCriterion("fill_in_form_deadline between", value1, value2, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andFillInFormDeadlineNotBetween(String value1, String value2) {
            addCriterion("fill_in_form_deadline not between", value1, value2, "fillInFormDeadline");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeIsNull() {
            addCriterion("tab_clumn_type is null");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeIsNotNull() {
            addCriterion("tab_clumn_type is not null");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeEqualTo(Byte value) {
            addCriterion("tab_clumn_type =", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeNotEqualTo(Byte value) {
            addCriterion("tab_clumn_type <>", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeGreaterThan(Byte value) {
            addCriterion("tab_clumn_type >", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tab_clumn_type >=", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeLessThan(Byte value) {
            addCriterion("tab_clumn_type <", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeLessThanOrEqualTo(Byte value) {
            addCriterion("tab_clumn_type <=", value, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeIn(List<Byte> values) {
            addCriterion("tab_clumn_type in", values, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeNotIn(List<Byte> values) {
            addCriterion("tab_clumn_type not in", values, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeBetween(Byte value1, Byte value2) {
            addCriterion("tab_clumn_type between", value1, value2, "tabClumnType");
            return (Criteria) this;
        }

        public Criteria andTabClumnTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tab_clumn_type not between", value1, value2, "tabClumnType");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsIsNull() {
            addCriterion("garden_examine_stauts is null");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsIsNotNull() {
            addCriterion("garden_examine_stauts is not null");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsEqualTo(Byte value) {
            addCriterion("garden_examine_stauts =", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsNotEqualTo(Byte value) {
            addCriterion("garden_examine_stauts <>", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsGreaterThan(Byte value) {
            addCriterion("garden_examine_stauts >", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsGreaterThanOrEqualTo(Byte value) {
            addCriterion("garden_examine_stauts >=", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsLessThan(Byte value) {
            addCriterion("garden_examine_stauts <", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsLessThanOrEqualTo(Byte value) {
            addCriterion("garden_examine_stauts <=", value, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsIn(List<Byte> values) {
            addCriterion("garden_examine_stauts in", values, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsNotIn(List<Byte> values) {
            addCriterion("garden_examine_stauts not in", values, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsBetween(Byte value1, Byte value2) {
            addCriterion("garden_examine_stauts between", value1, value2, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andGardenExamineStautsNotBetween(Byte value1, Byte value2) {
            addCriterion("garden_examine_stauts not between", value1, value2, "gardenExamineStauts");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeIsNull() {
            addCriterion("tab_create_type is null");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeIsNotNull() {
            addCriterion("tab_create_type is not null");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeEqualTo(Byte value) {
            addCriterion("tab_create_type =", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeNotEqualTo(Byte value) {
            addCriterion("tab_create_type <>", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeGreaterThan(Byte value) {
            addCriterion("tab_create_type >", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tab_create_type >=", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeLessThan(Byte value) {
            addCriterion("tab_create_type <", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("tab_create_type <=", value, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeIn(List<Byte> values) {
            addCriterion("tab_create_type in", values, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeNotIn(List<Byte> values) {
            addCriterion("tab_create_type not in", values, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeBetween(Byte value1, Byte value2) {
            addCriterion("tab_create_type between", value1, value2, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andTabCreateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tab_create_type not between", value1, value2, "tabCreateType");
            return (Criteria) this;
        }

        public Criteria andCallingTimeIsNull() {
            addCriterion("calling_time is null");
            return (Criteria) this;
        }

        public Criteria andCallingTimeIsNotNull() {
            addCriterion("calling_time is not null");
            return (Criteria) this;
        }

        public Criteria andCallingTimeEqualTo(Date value) {
            addCriterion("calling_time =", value, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeNotEqualTo(Date value) {
            addCriterion("calling_time <>", value, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeGreaterThan(Date value) {
            addCriterion("calling_time >", value, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("calling_time >=", value, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeLessThan(Date value) {
            addCriterion("calling_time <", value, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeLessThanOrEqualTo(Date value) {
            addCriterion("calling_time <=", value, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeIn(List<Date> values) {
            addCriterion("calling_time in", values, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeNotIn(List<Date> values) {
            addCriterion("calling_time not in", values, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeBetween(Date value1, Date value2) {
            addCriterion("calling_time between", value1, value2, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimeNotBetween(Date value1, Date value2) {
            addCriterion("calling_time not between", value1, value2, "callingTime");
            return (Criteria) this;
        }

        public Criteria andCallingTimesIsNull() {
            addCriterion("calling_times is null");
            return (Criteria) this;
        }

        public Criteria andCallingTimesIsNotNull() {
            addCriterion("calling_times is not null");
            return (Criteria) this;
        }

        public Criteria andCallingTimesEqualTo(Integer value) {
            addCriterion("calling_times =", value, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesNotEqualTo(Integer value) {
            addCriterion("calling_times <>", value, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesGreaterThan(Integer value) {
            addCriterion("calling_times >", value, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("calling_times >=", value, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesLessThan(Integer value) {
            addCriterion("calling_times <", value, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesLessThanOrEqualTo(Integer value) {
            addCriterion("calling_times <=", value, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesIn(List<Integer> values) {
            addCriterion("calling_times in", values, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesNotIn(List<Integer> values) {
            addCriterion("calling_times not in", values, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesBetween(Integer value1, Integer value2) {
            addCriterion("calling_times between", value1, value2, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andCallingTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("calling_times not between", value1, value2, "callingTimes");
            return (Criteria) this;
        }

        public Criteria andFillerIsNull() {
            addCriterion("filler is null");
            return (Criteria) this;
        }

        public Criteria andFillerIsNotNull() {
            addCriterion("filler is not null");
            return (Criteria) this;
        }

        public Criteria andFillerEqualTo(String value) {
            addCriterion("filler =", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotEqualTo(String value) {
            addCriterion("filler <>", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThan(String value) {
            addCriterion("filler >", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThanOrEqualTo(String value) {
            addCriterion("filler >=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThan(String value) {
            addCriterion("filler <", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThanOrEqualTo(String value) {
            addCriterion("filler <=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLike(String value) {
            addCriterion("filler like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotLike(String value) {
            addCriterion("filler not like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerIn(List<String> values) {
            addCriterion("filler in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotIn(List<String> values) {
            addCriterion("filler not in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerBetween(String value1, String value2) {
            addCriterion("filler between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotBetween(String value1, String value2) {
            addCriterion("filler not between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNull() {
            addCriterion("up_time is null");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNotNull() {
            addCriterion("up_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpTimeEqualTo(Date value) {
            addCriterion("up_time =", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotEqualTo(Date value) {
            addCriterion("up_time <>", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThan(Date value) {
            addCriterion("up_time >", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("up_time >=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThan(Date value) {
            addCriterion("up_time <", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("up_time <=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeIn(List<Date> values) {
            addCriterion("up_time in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotIn(List<Date> values) {
            addCriterion("up_time not in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeBetween(Date value1, Date value2) {
            addCriterion("up_time between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("up_time not between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andFillerTelIsNull() {
            addCriterion("filler_tel is null");
            return (Criteria) this;
        }

        public Criteria andFillerTelIsNotNull() {
            addCriterion("filler_tel is not null");
            return (Criteria) this;
        }

        public Criteria andFillerTelEqualTo(String value) {
            addCriterion("filler_tel =", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotEqualTo(String value) {
            addCriterion("filler_tel <>", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelGreaterThan(String value) {
            addCriterion("filler_tel >", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelGreaterThanOrEqualTo(String value) {
            addCriterion("filler_tel >=", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelLessThan(String value) {
            addCriterion("filler_tel <", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelLessThanOrEqualTo(String value) {
            addCriterion("filler_tel <=", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelLike(String value) {
            addCriterion("filler_tel like", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotLike(String value) {
            addCriterion("filler_tel not like", value, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelIn(List<String> values) {
            addCriterion("filler_tel in", values, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotIn(List<String> values) {
            addCriterion("filler_tel not in", values, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelBetween(String value1, String value2) {
            addCriterion("filler_tel between", value1, value2, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andFillerTelNotBetween(String value1, String value2) {
            addCriterion("filler_tel not between", value1, value2, "fillerTel");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIsNull() {
            addCriterion("is_overdue is null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIsNotNull() {
            addCriterion("is_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueEqualTo(Byte value) {
            addCriterion("is_overdue =", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotEqualTo(Byte value) {
            addCriterion("is_overdue <>", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueGreaterThan(Byte value) {
            addCriterion("is_overdue >", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_overdue >=", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLessThan(Byte value) {
            addCriterion("is_overdue <", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLessThanOrEqualTo(Byte value) {
            addCriterion("is_overdue <=", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIn(List<Byte> values) {
            addCriterion("is_overdue in", values, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotIn(List<Byte> values) {
            addCriterion("is_overdue not in", values, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueBetween(Byte value1, Byte value2) {
            addCriterion("is_overdue between", value1, value2, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotBetween(Byte value1, Byte value2) {
            addCriterion("is_overdue not between", value1, value2, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysIsNull() {
            addCriterion("overdue_days is null");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysIsNotNull() {
            addCriterion("overdue_days is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysEqualTo(Integer value) {
            addCriterion("overdue_days =", value, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysNotEqualTo(Integer value) {
            addCriterion("overdue_days <>", value, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysGreaterThan(Integer value) {
            addCriterion("overdue_days >", value, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_days >=", value, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysLessThan(Integer value) {
            addCriterion("overdue_days <", value, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysLessThanOrEqualTo(Integer value) {
            addCriterion("overdue_days <=", value, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysIn(List<Integer> values) {
            addCriterion("overdue_days in", values, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysNotIn(List<Integer> values) {
            addCriterion("overdue_days not in", values, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysBetween(Integer value1, Integer value2) {
            addCriterion("overdue_days between", value1, value2, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andOverdueDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_days not between", value1, value2, "overdueDays");
            return (Criteria) this;
        }

        public Criteria andExamineCommentIsNull() {
            addCriterion("examine_comment is null");
            return (Criteria) this;
        }

        public Criteria andExamineCommentIsNotNull() {
            addCriterion("examine_comment is not null");
            return (Criteria) this;
        }

        public Criteria andExamineCommentEqualTo(String value) {
            addCriterion("examine_comment =", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotEqualTo(String value) {
            addCriterion("examine_comment <>", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentGreaterThan(String value) {
            addCriterion("examine_comment >", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentGreaterThanOrEqualTo(String value) {
            addCriterion("examine_comment >=", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentLessThan(String value) {
            addCriterion("examine_comment <", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentLessThanOrEqualTo(String value) {
            addCriterion("examine_comment <=", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentLike(String value) {
            addCriterion("examine_comment like", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotLike(String value) {
            addCriterion("examine_comment not like", value, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentIn(List<String> values) {
            addCriterion("examine_comment in", values, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotIn(List<String> values) {
            addCriterion("examine_comment not in", values, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentBetween(String value1, String value2) {
            addCriterion("examine_comment between", value1, value2, "examineComment");
            return (Criteria) this;
        }

        public Criteria andExamineCommentNotBetween(String value1, String value2) {
            addCriterion("examine_comment not between", value1, value2, "examineComment");
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

        public Criteria andTaskBatchIsNull() {
            addCriterion("task_batch is null");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIsNotNull() {
            addCriterion("task_batch is not null");
            return (Criteria) this;
        }

        public Criteria andTaskBatchEqualTo(String value) {
            addCriterion("task_batch =", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotEqualTo(String value) {
            addCriterion("task_batch <>", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchGreaterThan(String value) {
            addCriterion("task_batch >", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchGreaterThanOrEqualTo(String value) {
            addCriterion("task_batch >=", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLessThan(String value) {
            addCriterion("task_batch <", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLessThanOrEqualTo(String value) {
            addCriterion("task_batch <=", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchLike(String value) {
            addCriterion("task_batch like", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotLike(String value) {
            addCriterion("task_batch not like", value, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchIn(List<String> values) {
            addCriterion("task_batch in", values, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotIn(List<String> values) {
            addCriterion("task_batch not in", values, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchBetween(String value1, String value2) {
            addCriterion("task_batch between", value1, value2, "taskBatch");
            return (Criteria) this;
        }

        public Criteria andTaskBatchNotBetween(String value1, String value2) {
            addCriterion("task_batch not between", value1, value2, "taskBatch");
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

        public Criteria andModifiedAccountIsNull() {
            addCriterion("modified_account is null");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountIsNotNull() {
            addCriterion("modified_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountEqualTo(String value) {
            addCriterion("modified_account =", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountNotEqualTo(String value) {
            addCriterion("modified_account <>", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountGreaterThan(String value) {
            addCriterion("modified_account >", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountGreaterThanOrEqualTo(String value) {
            addCriterion("modified_account >=", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountLessThan(String value) {
            addCriterion("modified_account <", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountLessThanOrEqualTo(String value) {
            addCriterion("modified_account <=", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountLike(String value) {
            addCriterion("modified_account like", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountNotLike(String value) {
            addCriterion("modified_account not like", value, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountIn(List<String> values) {
            addCriterion("modified_account in", values, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountNotIn(List<String> values) {
            addCriterion("modified_account not in", values, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountBetween(String value1, String value2) {
            addCriterion("modified_account between", value1, value2, "modifiedAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedAccountNotBetween(String value1, String value2) {
            addCriterion("modified_account not between", value1, value2, "modifiedAccount");
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