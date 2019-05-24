package com.jn.hr.train.entity;

import java.util.ArrayList;
import java.util.List;

public class TbManpowerTrainResearchSetCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbManpowerTrainResearchSetCriteria() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andResearchMethodIsNull() {
            addCriterion("research_method is null");
            return (Criteria) this;
        }

        public Criteria andResearchMethodIsNotNull() {
            addCriterion("research_method is not null");
            return (Criteria) this;
        }

        public Criteria andResearchMethodEqualTo(Byte value) {
            addCriterion("research_method =", value, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodNotEqualTo(Byte value) {
            addCriterion("research_method <>", value, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodGreaterThan(Byte value) {
            addCriterion("research_method >", value, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("research_method >=", value, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodLessThan(Byte value) {
            addCriterion("research_method <", value, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodLessThanOrEqualTo(Byte value) {
            addCriterion("research_method <=", value, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodIn(List<Byte> values) {
            addCriterion("research_method in", values, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodNotIn(List<Byte> values) {
            addCriterion("research_method not in", values, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodBetween(Byte value1, Byte value2) {
            addCriterion("research_method between", value1, value2, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andResearchMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("research_method not between", value1, value2, "researchMethod");
            return (Criteria) this;
        }

        public Criteria andIsShowNameIsNull() {
            addCriterion("is_show_name is null");
            return (Criteria) this;
        }

        public Criteria andIsShowNameIsNotNull() {
            addCriterion("is_show_name is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowNameEqualTo(Byte value) {
            addCriterion("is_show_name =", value, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameNotEqualTo(Byte value) {
            addCriterion("is_show_name <>", value, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameGreaterThan(Byte value) {
            addCriterion("is_show_name >", value, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_name >=", value, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameLessThan(Byte value) {
            addCriterion("is_show_name <", value, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_name <=", value, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameIn(List<Byte> values) {
            addCriterion("is_show_name in", values, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameNotIn(List<Byte> values) {
            addCriterion("is_show_name not in", values, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameBetween(Byte value1, Byte value2) {
            addCriterion("is_show_name between", value1, value2, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowNameNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_name not between", value1, value2, "isShowName");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberIsNull() {
            addCriterion("is_show_job_number is null");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberIsNotNull() {
            addCriterion("is_show_job_number is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberEqualTo(Byte value) {
            addCriterion("is_show_job_number =", value, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberNotEqualTo(Byte value) {
            addCriterion("is_show_job_number <>", value, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberGreaterThan(Byte value) {
            addCriterion("is_show_job_number >", value, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_job_number >=", value, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberLessThan(Byte value) {
            addCriterion("is_show_job_number <", value, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_job_number <=", value, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberIn(List<Byte> values) {
            addCriterion("is_show_job_number in", values, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberNotIn(List<Byte> values) {
            addCriterion("is_show_job_number not in", values, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberBetween(Byte value1, Byte value2) {
            addCriterion("is_show_job_number between", value1, value2, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowJobNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_job_number not between", value1, value2, "isShowJobNumber");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneIsNull() {
            addCriterion("is_show_phone is null");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneIsNotNull() {
            addCriterion("is_show_phone is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneEqualTo(Byte value) {
            addCriterion("is_show_phone =", value, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneNotEqualTo(Byte value) {
            addCriterion("is_show_phone <>", value, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneGreaterThan(Byte value) {
            addCriterion("is_show_phone >", value, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_phone >=", value, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneLessThan(Byte value) {
            addCriterion("is_show_phone <", value, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_phone <=", value, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneIn(List<Byte> values) {
            addCriterion("is_show_phone in", values, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneNotIn(List<Byte> values) {
            addCriterion("is_show_phone not in", values, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneBetween(Byte value1, Byte value2) {
            addCriterion("is_show_phone between", value1, value2, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andIsShowPhoneNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_phone not between", value1, value2, "isShowPhone");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitIsNull() {
            addCriterion("frequency_limit is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitIsNotNull() {
            addCriterion("frequency_limit is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitEqualTo(Byte value) {
            addCriterion("frequency_limit =", value, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitNotEqualTo(Byte value) {
            addCriterion("frequency_limit <>", value, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitGreaterThan(Byte value) {
            addCriterion("frequency_limit >", value, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitGreaterThanOrEqualTo(Byte value) {
            addCriterion("frequency_limit >=", value, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitLessThan(Byte value) {
            addCriterion("frequency_limit <", value, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitLessThanOrEqualTo(Byte value) {
            addCriterion("frequency_limit <=", value, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitIn(List<Byte> values) {
            addCriterion("frequency_limit in", values, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitNotIn(List<Byte> values) {
            addCriterion("frequency_limit not in", values, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitBetween(Byte value1, Byte value2) {
            addCriterion("frequency_limit between", value1, value2, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andFrequencyLimitNotBetween(Byte value1, Byte value2) {
            addCriterion("frequency_limit not between", value1, value2, "frequencyLimit");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsIsNull() {
            addCriterion("is_show_tips is null");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsIsNotNull() {
            addCriterion("is_show_tips is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsEqualTo(Byte value) {
            addCriterion("is_show_tips =", value, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsNotEqualTo(Byte value) {
            addCriterion("is_show_tips <>", value, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsGreaterThan(Byte value) {
            addCriterion("is_show_tips >", value, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show_tips >=", value, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsLessThan(Byte value) {
            addCriterion("is_show_tips <", value, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsLessThanOrEqualTo(Byte value) {
            addCriterion("is_show_tips <=", value, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsIn(List<Byte> values) {
            addCriterion("is_show_tips in", values, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsNotIn(List<Byte> values) {
            addCriterion("is_show_tips not in", values, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsBetween(Byte value1, Byte value2) {
            addCriterion("is_show_tips between", value1, value2, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andIsShowTipsNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show_tips not between", value1, value2, "isShowTips");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageIsNull() {
            addCriterion("prompting_language is null");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageIsNotNull() {
            addCriterion("prompting_language is not null");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageEqualTo(String value) {
            addCriterion("prompting_language =", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageNotEqualTo(String value) {
            addCriterion("prompting_language <>", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageGreaterThan(String value) {
            addCriterion("prompting_language >", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("prompting_language >=", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageLessThan(String value) {
            addCriterion("prompting_language <", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageLessThanOrEqualTo(String value) {
            addCriterion("prompting_language <=", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageLike(String value) {
            addCriterion("prompting_language like", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageNotLike(String value) {
            addCriterion("prompting_language not like", value, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageIn(List<String> values) {
            addCriterion("prompting_language in", values, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageNotIn(List<String> values) {
            addCriterion("prompting_language not in", values, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageBetween(String value1, String value2) {
            addCriterion("prompting_language between", value1, value2, "promptingLanguage");
            return (Criteria) this;
        }

        public Criteria andPromptingLanguageNotBetween(String value1, String value2) {
            addCriterion("prompting_language not between", value1, value2, "promptingLanguage");
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