package com.jn.enterprise.pd.declaration.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdDeclarationPushInformationManageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdDeclarationPushInformationManageCriteria() {
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

        public Criteria andPushTitleIsNull() {
            addCriterion("push_title is null");
            return (Criteria) this;
        }

        public Criteria andPushTitleIsNotNull() {
            addCriterion("push_title is not null");
            return (Criteria) this;
        }

        public Criteria andPushTitleEqualTo(String value) {
            addCriterion("push_title =", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotEqualTo(String value) {
            addCriterion("push_title <>", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleGreaterThan(String value) {
            addCriterion("push_title >", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleGreaterThanOrEqualTo(String value) {
            addCriterion("push_title >=", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleLessThan(String value) {
            addCriterion("push_title <", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleLessThanOrEqualTo(String value) {
            addCriterion("push_title <=", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleLike(String value) {
            addCriterion("push_title like", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotLike(String value) {
            addCriterion("push_title not like", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleIn(List<String> values) {
            addCriterion("push_title in", values, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotIn(List<String> values) {
            addCriterion("push_title not in", values, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleBetween(String value1, String value2) {
            addCriterion("push_title between", value1, value2, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotBetween(String value1, String value2) {
            addCriterion("push_title not between", value1, value2, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushContentIsNull() {
            addCriterion("push_content is null");
            return (Criteria) this;
        }

        public Criteria andPushContentIsNotNull() {
            addCriterion("push_content is not null");
            return (Criteria) this;
        }

        public Criteria andPushContentEqualTo(String value) {
            addCriterion("push_content =", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentNotEqualTo(String value) {
            addCriterion("push_content <>", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentGreaterThan(String value) {
            addCriterion("push_content >", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentGreaterThanOrEqualTo(String value) {
            addCriterion("push_content >=", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentLessThan(String value) {
            addCriterion("push_content <", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentLessThanOrEqualTo(String value) {
            addCriterion("push_content <=", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentLike(String value) {
            addCriterion("push_content like", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentNotLike(String value) {
            addCriterion("push_content not like", value, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentIn(List<String> values) {
            addCriterion("push_content in", values, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentNotIn(List<String> values) {
            addCriterion("push_content not in", values, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentBetween(String value1, String value2) {
            addCriterion("push_content between", value1, value2, "pushContent");
            return (Criteria) this;
        }

        public Criteria andPushContentNotBetween(String value1, String value2) {
            addCriterion("push_content not between", value1, value2, "pushContent");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdIsNull() {
            addCriterion("receive_enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdIsNotNull() {
            addCriterion("receive_enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdEqualTo(String value) {
            addCriterion("receive_enterprise_id =", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdNotEqualTo(String value) {
            addCriterion("receive_enterprise_id <>", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdGreaterThan(String value) {
            addCriterion("receive_enterprise_id >", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdGreaterThanOrEqualTo(String value) {
            addCriterion("receive_enterprise_id >=", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdLessThan(String value) {
            addCriterion("receive_enterprise_id <", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdLessThanOrEqualTo(String value) {
            addCriterion("receive_enterprise_id <=", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdLike(String value) {
            addCriterion("receive_enterprise_id like", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdNotLike(String value) {
            addCriterion("receive_enterprise_id not like", value, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdIn(List<String> values) {
            addCriterion("receive_enterprise_id in", values, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdNotIn(List<String> values) {
            addCriterion("receive_enterprise_id not in", values, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdBetween(String value1, String value2) {
            addCriterion("receive_enterprise_id between", value1, value2, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIdNotBetween(String value1, String value2) {
            addCriterion("receive_enterprise_id not between", value1, value2, "receiveEnterpriseId");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIsNull() {
            addCriterion("receive_enterprise is null");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIsNotNull() {
            addCriterion("receive_enterprise is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseEqualTo(String value) {
            addCriterion("receive_enterprise =", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseNotEqualTo(String value) {
            addCriterion("receive_enterprise <>", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseGreaterThan(String value) {
            addCriterion("receive_enterprise >", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("receive_enterprise >=", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseLessThan(String value) {
            addCriterion("receive_enterprise <", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("receive_enterprise <=", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseLike(String value) {
            addCriterion("receive_enterprise like", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseNotLike(String value) {
            addCriterion("receive_enterprise not like", value, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseIn(List<String> values) {
            addCriterion("receive_enterprise in", values, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseNotIn(List<String> values) {
            addCriterion("receive_enterprise not in", values, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseBetween(String value1, String value2) {
            addCriterion("receive_enterprise between", value1, value2, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceiveEnterpriseNotBetween(String value1, String value2) {
            addCriterion("receive_enterprise not between", value1, value2, "receiveEnterprise");
            return (Criteria) this;
        }

        public Criteria andReceivePersonIsNull() {
            addCriterion("receive_person is null");
            return (Criteria) this;
        }

        public Criteria andReceivePersonIsNotNull() {
            addCriterion("receive_person is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePersonEqualTo(String value) {
            addCriterion("receive_person =", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonNotEqualTo(String value) {
            addCriterion("receive_person <>", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonGreaterThan(String value) {
            addCriterion("receive_person >", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonGreaterThanOrEqualTo(String value) {
            addCriterion("receive_person >=", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonLessThan(String value) {
            addCriterion("receive_person <", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonLessThanOrEqualTo(String value) {
            addCriterion("receive_person <=", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonLike(String value) {
            addCriterion("receive_person like", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonNotLike(String value) {
            addCriterion("receive_person not like", value, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonIn(List<String> values) {
            addCriterion("receive_person in", values, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonNotIn(List<String> values) {
            addCriterion("receive_person not in", values, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonBetween(String value1, String value2) {
            addCriterion("receive_person between", value1, value2, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePersonNotBetween(String value1, String value2) {
            addCriterion("receive_person not between", value1, value2, "receivePerson");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNull() {
            addCriterion("receive_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNotNull() {
            addCriterion("receive_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneEqualTo(String value) {
            addCriterion("receive_phone =", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotEqualTo(String value) {
            addCriterion("receive_phone <>", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThan(String value) {
            addCriterion("receive_phone >", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receive_phone >=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThan(String value) {
            addCriterion("receive_phone <", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
            addCriterion("receive_phone <=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLike(String value) {
            addCriterion("receive_phone like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotLike(String value) {
            addCriterion("receive_phone not like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIn(List<String> values) {
            addCriterion("receive_phone in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotIn(List<String> values) {
            addCriterion("receive_phone not in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneBetween(String value1, String value2) {
            addCriterion("receive_phone between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotBetween(String value1, String value2) {
            addCriterion("receive_phone not between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andPushPersonIsNull() {
            addCriterion("push_person is null");
            return (Criteria) this;
        }

        public Criteria andPushPersonIsNotNull() {
            addCriterion("push_person is not null");
            return (Criteria) this;
        }

        public Criteria andPushPersonEqualTo(String value) {
            addCriterion("push_person =", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonNotEqualTo(String value) {
            addCriterion("push_person <>", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonGreaterThan(String value) {
            addCriterion("push_person >", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonGreaterThanOrEqualTo(String value) {
            addCriterion("push_person >=", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonLessThan(String value) {
            addCriterion("push_person <", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonLessThanOrEqualTo(String value) {
            addCriterion("push_person <=", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonLike(String value) {
            addCriterion("push_person like", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonNotLike(String value) {
            addCriterion("push_person not like", value, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonIn(List<String> values) {
            addCriterion("push_person in", values, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonNotIn(List<String> values) {
            addCriterion("push_person not in", values, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonBetween(String value1, String value2) {
            addCriterion("push_person between", value1, value2, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushPersonNotBetween(String value1, String value2) {
            addCriterion("push_person not between", value1, value2, "pushPerson");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushSourceIsNull() {
            addCriterion("push_source is null");
            return (Criteria) this;
        }

        public Criteria andPushSourceIsNotNull() {
            addCriterion("push_source is not null");
            return (Criteria) this;
        }

        public Criteria andPushSourceEqualTo(Byte value) {
            addCriterion("push_source =", value, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceNotEqualTo(Byte value) {
            addCriterion("push_source <>", value, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceGreaterThan(Byte value) {
            addCriterion("push_source >", value, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("push_source >=", value, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceLessThan(Byte value) {
            addCriterion("push_source <", value, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceLessThanOrEqualTo(Byte value) {
            addCriterion("push_source <=", value, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceIn(List<Byte> values) {
            addCriterion("push_source in", values, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceNotIn(List<Byte> values) {
            addCriterion("push_source not in", values, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceBetween(Byte value1, Byte value2) {
            addCriterion("push_source between", value1, value2, "pushSource");
            return (Criteria) this;
        }

        public Criteria andPushSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("push_source not between", value1, value2, "pushSource");
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

        public Criteria andPushIdIsNull() {
            addCriterion("push_id is null");
            return (Criteria) this;
        }

        public Criteria andPushIdIsNotNull() {
            addCriterion("push_id is not null");
            return (Criteria) this;
        }

        public Criteria andPushIdEqualTo(String value) {
            addCriterion("push_id =", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotEqualTo(String value) {
            addCriterion("push_id <>", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdGreaterThan(String value) {
            addCriterion("push_id >", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdGreaterThanOrEqualTo(String value) {
            addCriterion("push_id >=", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdLessThan(String value) {
            addCriterion("push_id <", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdLessThanOrEqualTo(String value) {
            addCriterion("push_id <=", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdLike(String value) {
            addCriterion("push_id like", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotLike(String value) {
            addCriterion("push_id not like", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdIn(List<String> values) {
            addCriterion("push_id in", values, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotIn(List<String> values) {
            addCriterion("push_id not in", values, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdBetween(String value1, String value2) {
            addCriterion("push_id between", value1, value2, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotBetween(String value1, String value2) {
            addCriterion("push_id not between", value1, value2, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushSmsIsNull() {
            addCriterion("push_sms is null");
            return (Criteria) this;
        }

        public Criteria andPushSmsIsNotNull() {
            addCriterion("push_sms is not null");
            return (Criteria) this;
        }

        public Criteria andPushSmsEqualTo(String value) {
            addCriterion("push_sms =", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsNotEqualTo(String value) {
            addCriterion("push_sms <>", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsGreaterThan(String value) {
            addCriterion("push_sms >", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsGreaterThanOrEqualTo(String value) {
            addCriterion("push_sms >=", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsLessThan(String value) {
            addCriterion("push_sms <", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsLessThanOrEqualTo(String value) {
            addCriterion("push_sms <=", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsLike(String value) {
            addCriterion("push_sms like", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsNotLike(String value) {
            addCriterion("push_sms not like", value, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsIn(List<String> values) {
            addCriterion("push_sms in", values, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsNotIn(List<String> values) {
            addCriterion("push_sms not in", values, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsBetween(String value1, String value2) {
            addCriterion("push_sms between", value1, value2, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushSmsNotBetween(String value1, String value2) {
            addCriterion("push_sms not between", value1, value2, "pushSms");
            return (Criteria) this;
        }

        public Criteria andPushEmailIsNull() {
            addCriterion("push_email is null");
            return (Criteria) this;
        }

        public Criteria andPushEmailIsNotNull() {
            addCriterion("push_email is not null");
            return (Criteria) this;
        }

        public Criteria andPushEmailEqualTo(String value) {
            addCriterion("push_email =", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailNotEqualTo(String value) {
            addCriterion("push_email <>", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailGreaterThan(String value) {
            addCriterion("push_email >", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailGreaterThanOrEqualTo(String value) {
            addCriterion("push_email >=", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailLessThan(String value) {
            addCriterion("push_email <", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailLessThanOrEqualTo(String value) {
            addCriterion("push_email <=", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailLike(String value) {
            addCriterion("push_email like", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailNotLike(String value) {
            addCriterion("push_email not like", value, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailIn(List<String> values) {
            addCriterion("push_email in", values, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailNotIn(List<String> values) {
            addCriterion("push_email not in", values, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailBetween(String value1, String value2) {
            addCriterion("push_email between", value1, value2, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushEmailNotBetween(String value1, String value2) {
            addCriterion("push_email not between", value1, value2, "pushEmail");
            return (Criteria) this;
        }

        public Criteria andPushWxIsNull() {
            addCriterion("push_wx is null");
            return (Criteria) this;
        }

        public Criteria andPushWxIsNotNull() {
            addCriterion("push_wx is not null");
            return (Criteria) this;
        }

        public Criteria andPushWxEqualTo(String value) {
            addCriterion("push_wx =", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxNotEqualTo(String value) {
            addCriterion("push_wx <>", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxGreaterThan(String value) {
            addCriterion("push_wx >", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxGreaterThanOrEqualTo(String value) {
            addCriterion("push_wx >=", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxLessThan(String value) {
            addCriterion("push_wx <", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxLessThanOrEqualTo(String value) {
            addCriterion("push_wx <=", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxLike(String value) {
            addCriterion("push_wx like", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxNotLike(String value) {
            addCriterion("push_wx not like", value, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxIn(List<String> values) {
            addCriterion("push_wx in", values, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxNotIn(List<String> values) {
            addCriterion("push_wx not in", values, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxBetween(String value1, String value2) {
            addCriterion("push_wx between", value1, value2, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushWxNotBetween(String value1, String value2) {
            addCriterion("push_wx not between", value1, value2, "pushWx");
            return (Criteria) this;
        }

        public Criteria andPushAppIsNull() {
            addCriterion("push_app is null");
            return (Criteria) this;
        }

        public Criteria andPushAppIsNotNull() {
            addCriterion("push_app is not null");
            return (Criteria) this;
        }

        public Criteria andPushAppEqualTo(String value) {
            addCriterion("push_app =", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppNotEqualTo(String value) {
            addCriterion("push_app <>", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppGreaterThan(String value) {
            addCriterion("push_app >", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppGreaterThanOrEqualTo(String value) {
            addCriterion("push_app >=", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppLessThan(String value) {
            addCriterion("push_app <", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppLessThanOrEqualTo(String value) {
            addCriterion("push_app <=", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppLike(String value) {
            addCriterion("push_app like", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppNotLike(String value) {
            addCriterion("push_app not like", value, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppIn(List<String> values) {
            addCriterion("push_app in", values, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppNotIn(List<String> values) {
            addCriterion("push_app not in", values, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppBetween(String value1, String value2) {
            addCriterion("push_app between", value1, value2, "pushApp");
            return (Criteria) this;
        }

        public Criteria andPushAppNotBetween(String value1, String value2) {
            addCriterion("push_app not between", value1, value2, "pushApp");
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