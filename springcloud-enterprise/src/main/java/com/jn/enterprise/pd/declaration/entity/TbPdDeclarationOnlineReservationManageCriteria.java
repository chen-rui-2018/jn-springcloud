package com.jn.enterprise.pd.declaration.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdDeclarationOnlineReservationManageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdDeclarationOnlineReservationManageCriteria() {
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

        public Criteria andAppointmentItemIdIsNull() {
            addCriterion("appointment_item_id is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdIsNotNull() {
            addCriterion("appointment_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdEqualTo(String value) {
            addCriterion("appointment_item_id =", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdNotEqualTo(String value) {
            addCriterion("appointment_item_id <>", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdGreaterThan(String value) {
            addCriterion("appointment_item_id >", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_item_id >=", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdLessThan(String value) {
            addCriterion("appointment_item_id <", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdLessThanOrEqualTo(String value) {
            addCriterion("appointment_item_id <=", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdLike(String value) {
            addCriterion("appointment_item_id like", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdNotLike(String value) {
            addCriterion("appointment_item_id not like", value, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdIn(List<String> values) {
            addCriterion("appointment_item_id in", values, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdNotIn(List<String> values) {
            addCriterion("appointment_item_id not in", values, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdBetween(String value1, String value2) {
            addCriterion("appointment_item_id between", value1, value2, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemIdNotBetween(String value1, String value2) {
            addCriterion("appointment_item_id not between", value1, value2, "appointmentItemId");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameIsNull() {
            addCriterion("appointment_item_name is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameIsNotNull() {
            addCriterion("appointment_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameEqualTo(String value) {
            addCriterion("appointment_item_name =", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameNotEqualTo(String value) {
            addCriterion("appointment_item_name <>", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameGreaterThan(String value) {
            addCriterion("appointment_item_name >", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("appointment_item_name >=", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameLessThan(String value) {
            addCriterion("appointment_item_name <", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameLessThanOrEqualTo(String value) {
            addCriterion("appointment_item_name <=", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameLike(String value) {
            addCriterion("appointment_item_name like", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameNotLike(String value) {
            addCriterion("appointment_item_name not like", value, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameIn(List<String> values) {
            addCriterion("appointment_item_name in", values, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameNotIn(List<String> values) {
            addCriterion("appointment_item_name not in", values, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameBetween(String value1, String value2) {
            addCriterion("appointment_item_name between", value1, value2, "appointmentItemName");
            return (Criteria) this;
        }

        public Criteria andAppointmentItemNameNotBetween(String value1, String value2) {
            addCriterion("appointment_item_name not between", value1, value2, "appointmentItemName");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentIsNull() {
            addCriterion("time_appointment is null");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentIsNotNull() {
            addCriterion("time_appointment is not null");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentEqualTo(Date value) {
            addCriterion("time_appointment =", value, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentNotEqualTo(Date value) {
            addCriterion("time_appointment <>", value, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentGreaterThan(Date value) {
            addCriterion("time_appointment >", value, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentGreaterThanOrEqualTo(Date value) {
            addCriterion("time_appointment >=", value, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentLessThan(Date value) {
            addCriterion("time_appointment <", value, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentLessThanOrEqualTo(Date value) {
            addCriterion("time_appointment <=", value, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentIn(List<Date> values) {
            addCriterion("time_appointment in", values, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentNotIn(List<Date> values) {
            addCriterion("time_appointment not in", values, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentBetween(Date value1, Date value2) {
            addCriterion("time_appointment between", value1, value2, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andTimeAppointmentNotBetween(Date value1, Date value2) {
            addCriterion("time_appointment not between", value1, value2, "timeAppointment");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseIsNull() {
            addCriterion("declare_enterprise is null");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseIsNotNull() {
            addCriterion("declare_enterprise is not null");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseEqualTo(String value) {
            addCriterion("declare_enterprise =", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseNotEqualTo(String value) {
            addCriterion("declare_enterprise <>", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseGreaterThan(String value) {
            addCriterion("declare_enterprise >", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseGreaterThanOrEqualTo(String value) {
            addCriterion("declare_enterprise >=", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseLessThan(String value) {
            addCriterion("declare_enterprise <", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseLessThanOrEqualTo(String value) {
            addCriterion("declare_enterprise <=", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseLike(String value) {
            addCriterion("declare_enterprise like", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseNotLike(String value) {
            addCriterion("declare_enterprise not like", value, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseIn(List<String> values) {
            addCriterion("declare_enterprise in", values, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseNotIn(List<String> values) {
            addCriterion("declare_enterprise not in", values, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseBetween(String value1, String value2) {
            addCriterion("declare_enterprise between", value1, value2, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareEnterpriseNotBetween(String value1, String value2) {
            addCriterion("declare_enterprise not between", value1, value2, "declareEnterprise");
            return (Criteria) this;
        }

        public Criteria andDeclareItemIsNull() {
            addCriterion("declare_item is null");
            return (Criteria) this;
        }

        public Criteria andDeclareItemIsNotNull() {
            addCriterion("declare_item is not null");
            return (Criteria) this;
        }

        public Criteria andDeclareItemEqualTo(String value) {
            addCriterion("declare_item =", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemNotEqualTo(String value) {
            addCriterion("declare_item <>", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemGreaterThan(String value) {
            addCriterion("declare_item >", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemGreaterThanOrEqualTo(String value) {
            addCriterion("declare_item >=", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemLessThan(String value) {
            addCriterion("declare_item <", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemLessThanOrEqualTo(String value) {
            addCriterion("declare_item <=", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemLike(String value) {
            addCriterion("declare_item like", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemNotLike(String value) {
            addCriterion("declare_item not like", value, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemIn(List<String> values) {
            addCriterion("declare_item in", values, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemNotIn(List<String> values) {
            addCriterion("declare_item not in", values, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemBetween(String value1, String value2) {
            addCriterion("declare_item between", value1, value2, "declareItem");
            return (Criteria) this;
        }

        public Criteria andDeclareItemNotBetween(String value1, String value2) {
            addCriterion("declare_item not between", value1, value2, "declareItem");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNull() {
            addCriterion("reply_status is null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNotNull() {
            addCriterion("reply_status is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusEqualTo(Byte value) {
            addCriterion("reply_status =", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotEqualTo(Byte value) {
            addCriterion("reply_status <>", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThan(Byte value) {
            addCriterion("reply_status >", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("reply_status >=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThan(Byte value) {
            addCriterion("reply_status <", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("reply_status <=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIn(List<Byte> values) {
            addCriterion("reply_status in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotIn(List<Byte> values) {
            addCriterion("reply_status not in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusBetween(Byte value1, Byte value2) {
            addCriterion("reply_status between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("reply_status not between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("reply_content =", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("reply_content >", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("reply_content <", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLike(String value) {
            addCriterion("reply_content like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("reply_content not like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(List<String> values) {
            addCriterion("reply_content in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(List<String> values) {
            addCriterion("reply_content not in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andPrintStatusIsNull() {
            addCriterion("print_status is null");
            return (Criteria) this;
        }

        public Criteria andPrintStatusIsNotNull() {
            addCriterion("print_status is not null");
            return (Criteria) this;
        }

        public Criteria andPrintStatusEqualTo(Byte value) {
            addCriterion("print_status =", value, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusNotEqualTo(Byte value) {
            addCriterion("print_status <>", value, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusGreaterThan(Byte value) {
            addCriterion("print_status >", value, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("print_status >=", value, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusLessThan(Byte value) {
            addCriterion("print_status <", value, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusLessThanOrEqualTo(Byte value) {
            addCriterion("print_status <=", value, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusIn(List<Byte> values) {
            addCriterion("print_status in", values, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusNotIn(List<Byte> values) {
            addCriterion("print_status not in", values, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusBetween(Byte value1, Byte value2) {
            addCriterion("print_status between", value1, value2, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("print_status not between", value1, value2, "printStatus");
            return (Criteria) this;
        }

        public Criteria andPrintCodeIsNull() {
            addCriterion("print_code is null");
            return (Criteria) this;
        }

        public Criteria andPrintCodeIsNotNull() {
            addCriterion("print_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrintCodeEqualTo(String value) {
            addCriterion("print_code =", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeNotEqualTo(String value) {
            addCriterion("print_code <>", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeGreaterThan(String value) {
            addCriterion("print_code >", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeGreaterThanOrEqualTo(String value) {
            addCriterion("print_code >=", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeLessThan(String value) {
            addCriterion("print_code <", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeLessThanOrEqualTo(String value) {
            addCriterion("print_code <=", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeLike(String value) {
            addCriterion("print_code like", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeNotLike(String value) {
            addCriterion("print_code not like", value, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeIn(List<String> values) {
            addCriterion("print_code in", values, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeNotIn(List<String> values) {
            addCriterion("print_code not in", values, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeBetween(String value1, String value2) {
            addCriterion("print_code between", value1, value2, "printCode");
            return (Criteria) this;
        }

        public Criteria andPrintCodeNotBetween(String value1, String value2) {
            addCriterion("print_code not between", value1, value2, "printCode");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentIsNull() {
            addCriterion("audit_department is null");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentIsNotNull() {
            addCriterion("audit_department is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentEqualTo(String value) {
            addCriterion("audit_department =", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentNotEqualTo(String value) {
            addCriterion("audit_department <>", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentGreaterThan(String value) {
            addCriterion("audit_department >", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("audit_department >=", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentLessThan(String value) {
            addCriterion("audit_department <", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentLessThanOrEqualTo(String value) {
            addCriterion("audit_department <=", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentLike(String value) {
            addCriterion("audit_department like", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentNotLike(String value) {
            addCriterion("audit_department not like", value, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentIn(List<String> values) {
            addCriterion("audit_department in", values, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentNotIn(List<String> values) {
            addCriterion("audit_department not in", values, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentBetween(String value1, String value2) {
            addCriterion("audit_department between", value1, value2, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andAuditDepartmentNotBetween(String value1, String value2) {
            addCriterion("audit_department not between", value1, value2, "auditDepartment");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeIsNull() {
            addCriterion("declare_type is null");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeIsNotNull() {
            addCriterion("declare_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeEqualTo(String value) {
            addCriterion("declare_type =", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotEqualTo(String value) {
            addCriterion("declare_type <>", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeGreaterThan(String value) {
            addCriterion("declare_type >", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("declare_type >=", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeLessThan(String value) {
            addCriterion("declare_type <", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeLessThanOrEqualTo(String value) {
            addCriterion("declare_type <=", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeLike(String value) {
            addCriterion("declare_type like", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotLike(String value) {
            addCriterion("declare_type not like", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeIn(List<String> values) {
            addCriterion("declare_type in", values, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotIn(List<String> values) {
            addCriterion("declare_type not in", values, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeBetween(String value1, String value2) {
            addCriterion("declare_type between", value1, value2, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotBetween(String value1, String value2) {
            addCriterion("declare_type not between", value1, value2, "declareType");
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