package com.jn.hr.exam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbManpowerExaminaBankCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerExaminaBankCriteria() {
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

        public Criteria andTestQuestionIdIsNull() {
            addCriterion("test_question_id is null");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdIsNotNull() {
            addCriterion("test_question_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdEqualTo(String value) {
            addCriterion("test_question_id =", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotEqualTo(String value) {
            addCriterion("test_question_id <>", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdGreaterThan(String value) {
            addCriterion("test_question_id >", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdGreaterThanOrEqualTo(String value) {
            addCriterion("test_question_id >=", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdLessThan(String value) {
            addCriterion("test_question_id <", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdLessThanOrEqualTo(String value) {
            addCriterion("test_question_id <=", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdLike(String value) {
            addCriterion("test_question_id like", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotLike(String value) {
            addCriterion("test_question_id not like", value, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdIn(List<String> values) {
            addCriterion("test_question_id in", values, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotIn(List<String> values) {
            addCriterion("test_question_id not in", values, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdBetween(String value1, String value2) {
            addCriterion("test_question_id between", value1, value2, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andTestQuestionIdNotBetween(String value1, String value2) {
            addCriterion("test_question_id not between", value1, value2, "testQuestionId");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionIsNull() {
            addCriterion("examination_question is null");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionIsNotNull() {
            addCriterion("examination_question is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionEqualTo(String value) {
            addCriterion("examination_question =", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionNotEqualTo(String value) {
            addCriterion("examination_question <>", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionGreaterThan(String value) {
            addCriterion("examination_question >", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("examination_question >=", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionLessThan(String value) {
            addCriterion("examination_question <", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionLessThanOrEqualTo(String value) {
            addCriterion("examination_question <=", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionLike(String value) {
            addCriterion("examination_question like", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionNotLike(String value) {
            addCriterion("examination_question not like", value, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionIn(List<String> values) {
            addCriterion("examination_question in", values, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionNotIn(List<String> values) {
            addCriterion("examination_question not in", values, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionBetween(String value1, String value2) {
            addCriterion("examination_question between", value1, value2, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andExaminationQuestionNotBetween(String value1, String value2) {
            addCriterion("examination_question not between", value1, value2, "examinationQuestion");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeIsNull() {
            addCriterion("test_question_type is null");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeIsNotNull() {
            addCriterion("test_question_type is not null");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeEqualTo(String value) {
            addCriterion("test_question_type =", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeNotEqualTo(String value) {
            addCriterion("test_question_type <>", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeGreaterThan(String value) {
            addCriterion("test_question_type >", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("test_question_type >=", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeLessThan(String value) {
            addCriterion("test_question_type <", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeLessThanOrEqualTo(String value) {
            addCriterion("test_question_type <=", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeLike(String value) {
            addCriterion("test_question_type like", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeNotLike(String value) {
            addCriterion("test_question_type not like", value, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeIn(List<String> values) {
            addCriterion("test_question_type in", values, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeNotIn(List<String> values) {
            addCriterion("test_question_type not in", values, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeBetween(String value1, String value2) {
            addCriterion("test_question_type between", value1, value2, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andTestQuestionTypeNotBetween(String value1, String value2) {
            addCriterion("test_question_type not between", value1, value2, "testQuestionType");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyIsNull() {
            addCriterion("examination_difficulty is null");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyIsNotNull() {
            addCriterion("examination_difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyEqualTo(String value) {
            addCriterion("examination_difficulty =", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyNotEqualTo(String value) {
            addCriterion("examination_difficulty <>", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyGreaterThan(String value) {
            addCriterion("examination_difficulty >", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyGreaterThanOrEqualTo(String value) {
            addCriterion("examination_difficulty >=", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyLessThan(String value) {
            addCriterion("examination_difficulty <", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyLessThanOrEqualTo(String value) {
            addCriterion("examination_difficulty <=", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyLike(String value) {
            addCriterion("examination_difficulty like", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyNotLike(String value) {
            addCriterion("examination_difficulty not like", value, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyIn(List<String> values) {
            addCriterion("examination_difficulty in", values, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyNotIn(List<String> values) {
            addCriterion("examination_difficulty not in", values, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyBetween(String value1, String value2) {
            addCriterion("examination_difficulty between", value1, value2, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andExaminationDifficultyNotBetween(String value1, String value2) {
            addCriterion("examination_difficulty not between", value1, value2, "examinationDifficulty");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerIsNull() {
            addCriterion("standard_answer is null");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerIsNotNull() {
            addCriterion("standard_answer is not null");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerEqualTo(String value) {
            addCriterion("standard_answer =", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerNotEqualTo(String value) {
            addCriterion("standard_answer <>", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerGreaterThan(String value) {
            addCriterion("standard_answer >", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("standard_answer >=", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerLessThan(String value) {
            addCriterion("standard_answer <", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerLessThanOrEqualTo(String value) {
            addCriterion("standard_answer <=", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerLike(String value) {
            addCriterion("standard_answer like", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerNotLike(String value) {
            addCriterion("standard_answer not like", value, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerIn(List<String> values) {
            addCriterion("standard_answer in", values, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerNotIn(List<String> values) {
            addCriterion("standard_answer not in", values, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerBetween(String value1, String value2) {
            addCriterion("standard_answer between", value1, value2, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andStandardAnswerNotBetween(String value1, String value2) {
            addCriterion("standard_answer not between", value1, value2, "standardAnswer");
            return (Criteria) this;
        }

        public Criteria andFractionIsNull() {
            addCriterion("fraction is null");
            return (Criteria) this;
        }

        public Criteria andFractionIsNotNull() {
            addCriterion("fraction is not null");
            return (Criteria) this;
        }

        public Criteria andFractionEqualTo(String value) {
            addCriterion("fraction =", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotEqualTo(String value) {
            addCriterion("fraction <>", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThan(String value) {
            addCriterion("fraction >", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThanOrEqualTo(String value) {
            addCriterion("fraction >=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThan(String value) {
            addCriterion("fraction <", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThanOrEqualTo(String value) {
            addCriterion("fraction <=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLike(String value) {
            addCriterion("fraction like", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotLike(String value) {
            addCriterion("fraction not like", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionIn(List<String> values) {
            addCriterion("fraction in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotIn(List<String> values) {
            addCriterion("fraction not in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionBetween(String value1, String value2) {
            addCriterion("fraction between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotBetween(String value1, String value2) {
            addCriterion("fraction not between", value1, value2, "fraction");
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

        public Criteria andItemAnalysisIsNull() {
            addCriterion("item_analysis is null");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisIsNotNull() {
            addCriterion("item_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisEqualTo(String value) {
            addCriterion("item_analysis =", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisNotEqualTo(String value) {
            addCriterion("item_analysis <>", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisGreaterThan(String value) {
            addCriterion("item_analysis >", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisGreaterThanOrEqualTo(String value) {
            addCriterion("item_analysis >=", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisLessThan(String value) {
            addCriterion("item_analysis <", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisLessThanOrEqualTo(String value) {
            addCriterion("item_analysis <=", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisLike(String value) {
            addCriterion("item_analysis like", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisNotLike(String value) {
            addCriterion("item_analysis not like", value, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisIn(List<String> values) {
            addCriterion("item_analysis in", values, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisNotIn(List<String> values) {
            addCriterion("item_analysis not in", values, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisBetween(String value1, String value2) {
            addCriterion("item_analysis between", value1, value2, "itemAnalysis");
            return (Criteria) this;
        }

        public Criteria andItemAnalysisNotBetween(String value1, String value2) {
            addCriterion("item_analysis not between", value1, value2, "itemAnalysis");
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