package com.jn.park.customer.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbClientServiceCenterCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbClientServiceCenterCriteria() {
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

        public Criteria andProcessInsIdIsNull() {
            addCriterion("process_ins_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdIsNotNull() {
            addCriterion("process_ins_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdEqualTo(String value) {
            addCriterion("process_ins_id =", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdNotEqualTo(String value) {
            addCriterion("process_ins_id <>", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdGreaterThan(String value) {
            addCriterion("process_ins_id >", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_ins_id >=", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdLessThan(String value) {
            addCriterion("process_ins_id <", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdLessThanOrEqualTo(String value) {
            addCriterion("process_ins_id <=", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdLike(String value) {
            addCriterion("process_ins_id like", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdNotLike(String value) {
            addCriterion("process_ins_id not like", value, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdIn(List<String> values) {
            addCriterion("process_ins_id in", values, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdNotIn(List<String> values) {
            addCriterion("process_ins_id not in", values, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdBetween(String value1, String value2) {
            addCriterion("process_ins_id between", value1, value2, "processInsId");
            return (Criteria) this;
        }

        public Criteria andProcessInsIdNotBetween(String value1, String value2) {
            addCriterion("process_ins_id not between", value1, value2, "processInsId");
            return (Criteria) this;
        }

        public Criteria andQuesCodeIsNull() {
            addCriterion("ques_code is null");
            return (Criteria) this;
        }

        public Criteria andQuesCodeIsNotNull() {
            addCriterion("ques_code is not null");
            return (Criteria) this;
        }

        public Criteria andQuesCodeEqualTo(String value) {
            addCriterion("ques_code =", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeNotEqualTo(String value) {
            addCriterion("ques_code <>", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeGreaterThan(String value) {
            addCriterion("ques_code >", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ques_code >=", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeLessThan(String value) {
            addCriterion("ques_code <", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeLessThanOrEqualTo(String value) {
            addCriterion("ques_code <=", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeLike(String value) {
            addCriterion("ques_code like", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeNotLike(String value) {
            addCriterion("ques_code not like", value, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeIn(List<String> values) {
            addCriterion("ques_code in", values, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeNotIn(List<String> values) {
            addCriterion("ques_code not in", values, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeBetween(String value1, String value2) {
            addCriterion("ques_code between", value1, value2, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesCodeNotBetween(String value1, String value2) {
            addCriterion("ques_code not between", value1, value2, "quesCode");
            return (Criteria) this;
        }

        public Criteria andQuesTitleIsNull() {
            addCriterion("ques_title is null");
            return (Criteria) this;
        }

        public Criteria andQuesTitleIsNotNull() {
            addCriterion("ques_title is not null");
            return (Criteria) this;
        }

        public Criteria andQuesTitleEqualTo(String value) {
            addCriterion("ques_title =", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotEqualTo(String value) {
            addCriterion("ques_title <>", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleGreaterThan(String value) {
            addCriterion("ques_title >", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ques_title >=", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleLessThan(String value) {
            addCriterion("ques_title <", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleLessThanOrEqualTo(String value) {
            addCriterion("ques_title <=", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleLike(String value) {
            addCriterion("ques_title like", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotLike(String value) {
            addCriterion("ques_title not like", value, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleIn(List<String> values) {
            addCriterion("ques_title in", values, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotIn(List<String> values) {
            addCriterion("ques_title not in", values, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleBetween(String value1, String value2) {
            addCriterion("ques_title between", value1, value2, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesTitleNotBetween(String value1, String value2) {
            addCriterion("ques_title not between", value1, value2, "quesTitle");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsIsNull() {
            addCriterion("ques_details is null");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsIsNotNull() {
            addCriterion("ques_details is not null");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsEqualTo(String value) {
            addCriterion("ques_details =", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsNotEqualTo(String value) {
            addCriterion("ques_details <>", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsGreaterThan(String value) {
            addCriterion("ques_details >", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("ques_details >=", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsLessThan(String value) {
            addCriterion("ques_details <", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsLessThanOrEqualTo(String value) {
            addCriterion("ques_details <=", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsLike(String value) {
            addCriterion("ques_details like", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsNotLike(String value) {
            addCriterion("ques_details not like", value, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsIn(List<String> values) {
            addCriterion("ques_details in", values, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsNotIn(List<String> values) {
            addCriterion("ques_details not in", values, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsBetween(String value1, String value2) {
            addCriterion("ques_details between", value1, value2, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesDetailsNotBetween(String value1, String value2) {
            addCriterion("ques_details not between", value1, value2, "quesDetails");
            return (Criteria) this;
        }

        public Criteria andQuesUrlIsNull() {
            addCriterion("ques_url is null");
            return (Criteria) this;
        }

        public Criteria andQuesUrlIsNotNull() {
            addCriterion("ques_url is not null");
            return (Criteria) this;
        }

        public Criteria andQuesUrlEqualTo(String value) {
            addCriterion("ques_url =", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlNotEqualTo(String value) {
            addCriterion("ques_url <>", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlGreaterThan(String value) {
            addCriterion("ques_url >", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ques_url >=", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlLessThan(String value) {
            addCriterion("ques_url <", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlLessThanOrEqualTo(String value) {
            addCriterion("ques_url <=", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlLike(String value) {
            addCriterion("ques_url like", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlNotLike(String value) {
            addCriterion("ques_url not like", value, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlIn(List<String> values) {
            addCriterion("ques_url in", values, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlNotIn(List<String> values) {
            addCriterion("ques_url not in", values, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlBetween(String value1, String value2) {
            addCriterion("ques_url between", value1, value2, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andQuesUrlNotBetween(String value1, String value2) {
            addCriterion("ques_url not between", value1, value2, "quesUrl");
            return (Criteria) this;
        }

        public Criteria andServiceModuleIsNull() {
            addCriterion("service_module is null");
            return (Criteria) this;
        }

        public Criteria andServiceModuleIsNotNull() {
            addCriterion("service_module is not null");
            return (Criteria) this;
        }

        public Criteria andServiceModuleEqualTo(String value) {
            addCriterion("service_module =", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNotEqualTo(String value) {
            addCriterion("service_module <>", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleGreaterThan(String value) {
            addCriterion("service_module >", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleGreaterThanOrEqualTo(String value) {
            addCriterion("service_module >=", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleLessThan(String value) {
            addCriterion("service_module <", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleLessThanOrEqualTo(String value) {
            addCriterion("service_module <=", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleLike(String value) {
            addCriterion("service_module like", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNotLike(String value) {
            addCriterion("service_module not like", value, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleIn(List<String> values) {
            addCriterion("service_module in", values, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNotIn(List<String> values) {
            addCriterion("service_module not in", values, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleBetween(String value1, String value2) {
            addCriterion("service_module between", value1, value2, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNotBetween(String value1, String value2) {
            addCriterion("service_module not between", value1, value2, "serviceModule");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameIsNull() {
            addCriterion("service_module_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameIsNotNull() {
            addCriterion("service_module_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameEqualTo(String value) {
            addCriterion("service_module_name =", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameNotEqualTo(String value) {
            addCriterion("service_module_name <>", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameGreaterThan(String value) {
            addCriterion("service_module_name >", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_module_name >=", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameLessThan(String value) {
            addCriterion("service_module_name <", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameLessThanOrEqualTo(String value) {
            addCriterion("service_module_name <=", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameLike(String value) {
            addCriterion("service_module_name like", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameNotLike(String value) {
            addCriterion("service_module_name not like", value, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameIn(List<String> values) {
            addCriterion("service_module_name in", values, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameNotIn(List<String> values) {
            addCriterion("service_module_name not in", values, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameBetween(String value1, String value2) {
            addCriterion("service_module_name between", value1, value2, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andServiceModuleNameNotBetween(String value1, String value2) {
            addCriterion("service_module_name not between", value1, value2, "serviceModuleName");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNull() {
            addCriterion("client_type is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("client_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("client_type =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotEqualTo(String value) {
            addCriterion("client_type <>", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThan(String value) {
            addCriterion("client_type >", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("client_type >=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThan(String value) {
            addCriterion("client_type <", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("client_type <=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLike(String value) {
            addCriterion("client_type like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotLike(String value) {
            addCriterion("client_type not like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIn(List<String> values) {
            addCriterion("client_type in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotIn(List<String> values) {
            addCriterion("client_type not in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeBetween(String value1, String value2) {
            addCriterion("client_type between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("client_type not between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andContactWayIsNull() {
            addCriterion("contact_way is null");
            return (Criteria) this;
        }

        public Criteria andContactWayIsNotNull() {
            addCriterion("contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andContactWayEqualTo(String value) {
            addCriterion("contact_way =", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotEqualTo(String value) {
            addCriterion("contact_way <>", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayGreaterThan(String value) {
            addCriterion("contact_way >", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("contact_way >=", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLessThan(String value) {
            addCriterion("contact_way <", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLessThanOrEqualTo(String value) {
            addCriterion("contact_way <=", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLike(String value) {
            addCriterion("contact_way like", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotLike(String value) {
            addCriterion("contact_way not like", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayIn(List<String> values) {
            addCriterion("contact_way in", values, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotIn(List<String> values) {
            addCriterion("contact_way not in", values, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayBetween(String value1, String value2) {
            addCriterion("contact_way between", value1, value2, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotBetween(String value1, String value2) {
            addCriterion("contact_way not between", value1, value2, "contactWay");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerIsNull() {
            addCriterion("current_caller is null");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerIsNotNull() {
            addCriterion("current_caller is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerEqualTo(String value) {
            addCriterion("current_caller =", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerNotEqualTo(String value) {
            addCriterion("current_caller <>", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerGreaterThan(String value) {
            addCriterion("current_caller >", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerGreaterThanOrEqualTo(String value) {
            addCriterion("current_caller >=", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerLessThan(String value) {
            addCriterion("current_caller <", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerLessThanOrEqualTo(String value) {
            addCriterion("current_caller <=", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerLike(String value) {
            addCriterion("current_caller like", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerNotLike(String value) {
            addCriterion("current_caller not like", value, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerIn(List<String> values) {
            addCriterion("current_caller in", values, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerNotIn(List<String> values) {
            addCriterion("current_caller not in", values, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerBetween(String value1, String value2) {
            addCriterion("current_caller between", value1, value2, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCurrentCallerNotBetween(String value1, String value2) {
            addCriterion("current_caller not between", value1, value2, "currentCaller");
            return (Criteria) this;
        }

        public Criteria andCallerOwenIsNull() {
            addCriterion("caller_owen is null");
            return (Criteria) this;
        }

        public Criteria andCallerOwenIsNotNull() {
            addCriterion("caller_owen is not null");
            return (Criteria) this;
        }

        public Criteria andCallerOwenEqualTo(String value) {
            addCriterion("caller_owen =", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenNotEqualTo(String value) {
            addCriterion("caller_owen <>", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenGreaterThan(String value) {
            addCriterion("caller_owen >", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenGreaterThanOrEqualTo(String value) {
            addCriterion("caller_owen >=", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenLessThan(String value) {
            addCriterion("caller_owen <", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenLessThanOrEqualTo(String value) {
            addCriterion("caller_owen <=", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenLike(String value) {
            addCriterion("caller_owen like", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenNotLike(String value) {
            addCriterion("caller_owen not like", value, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenIn(List<String> values) {
            addCriterion("caller_owen in", values, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenNotIn(List<String> values) {
            addCriterion("caller_owen not in", values, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenBetween(String value1, String value2) {
            addCriterion("caller_owen between", value1, value2, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCallerOwenNotBetween(String value1, String value2) {
            addCriterion("caller_owen not between", value1, value2, "callerOwen");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNull() {
            addCriterion("cust_sex is null");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNotNull() {
            addCriterion("cust_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCustSexEqualTo(String value) {
            addCriterion("cust_sex =", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotEqualTo(String value) {
            addCriterion("cust_sex <>", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThan(String value) {
            addCriterion("cust_sex >", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThanOrEqualTo(String value) {
            addCriterion("cust_sex >=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThan(String value) {
            addCriterion("cust_sex <", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThanOrEqualTo(String value) {
            addCriterion("cust_sex <=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLike(String value) {
            addCriterion("cust_sex like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotLike(String value) {
            addCriterion("cust_sex not like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexIn(List<String> values) {
            addCriterion("cust_sex in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotIn(List<String> values) {
            addCriterion("cust_sex not in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexBetween(String value1, String value2) {
            addCriterion("cust_sex between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotBetween(String value1, String value2) {
            addCriterion("cust_sex not between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andIsTranPieIsNull() {
            addCriterion("is_tran_pie is null");
            return (Criteria) this;
        }

        public Criteria andIsTranPieIsNotNull() {
            addCriterion("is_tran_pie is not null");
            return (Criteria) this;
        }

        public Criteria andIsTranPieEqualTo(String value) {
            addCriterion("is_tran_pie =", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieNotEqualTo(String value) {
            addCriterion("is_tran_pie <>", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieGreaterThan(String value) {
            addCriterion("is_tran_pie >", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieGreaterThanOrEqualTo(String value) {
            addCriterion("is_tran_pie >=", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieLessThan(String value) {
            addCriterion("is_tran_pie <", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieLessThanOrEqualTo(String value) {
            addCriterion("is_tran_pie <=", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieLike(String value) {
            addCriterion("is_tran_pie like", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieNotLike(String value) {
            addCriterion("is_tran_pie not like", value, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieIn(List<String> values) {
            addCriterion("is_tran_pie in", values, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieNotIn(List<String> values) {
            addCriterion("is_tran_pie not in", values, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieBetween(String value1, String value2) {
            addCriterion("is_tran_pie between", value1, value2, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andIsTranPieNotBetween(String value1, String value2) {
            addCriterion("is_tran_pie not between", value1, value2, "isTranPie");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidIsNull() {
            addCriterion("executeDeptId is null");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidIsNotNull() {
            addCriterion("executeDeptId is not null");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidEqualTo(String value) {
            addCriterion("executeDeptId =", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidNotEqualTo(String value) {
            addCriterion("executeDeptId <>", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidGreaterThan(String value) {
            addCriterion("executeDeptId >", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidGreaterThanOrEqualTo(String value) {
            addCriterion("executeDeptId >=", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidLessThan(String value) {
            addCriterion("executeDeptId <", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidLessThanOrEqualTo(String value) {
            addCriterion("executeDeptId <=", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidLike(String value) {
            addCriterion("executeDeptId like", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidNotLike(String value) {
            addCriterion("executeDeptId not like", value, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidIn(List<String> values) {
            addCriterion("executeDeptId in", values, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidNotIn(List<String> values) {
            addCriterion("executeDeptId not in", values, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidBetween(String value1, String value2) {
            addCriterion("executeDeptId between", value1, value2, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutedeptidNotBetween(String value1, String value2) {
            addCriterion("executeDeptId not between", value1, value2, "executedeptid");
            return (Criteria) this;
        }

        public Criteria andExecutepersonIsNull() {
            addCriterion("executePerson is null");
            return (Criteria) this;
        }

        public Criteria andExecutepersonIsNotNull() {
            addCriterion("executePerson is not null");
            return (Criteria) this;
        }

        public Criteria andExecutepersonEqualTo(String value) {
            addCriterion("executePerson =", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonNotEqualTo(String value) {
            addCriterion("executePerson <>", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonGreaterThan(String value) {
            addCriterion("executePerson >", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonGreaterThanOrEqualTo(String value) {
            addCriterion("executePerson >=", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonLessThan(String value) {
            addCriterion("executePerson <", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonLessThanOrEqualTo(String value) {
            addCriterion("executePerson <=", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonLike(String value) {
            addCriterion("executePerson like", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonNotLike(String value) {
            addCriterion("executePerson not like", value, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonIn(List<String> values) {
            addCriterion("executePerson in", values, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonNotIn(List<String> values) {
            addCriterion("executePerson not in", values, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonBetween(String value1, String value2) {
            addCriterion("executePerson between", value1, value2, "executeperson");
            return (Criteria) this;
        }

        public Criteria andExecutepersonNotBetween(String value1, String value2) {
            addCriterion("executePerson not between", value1, value2, "executeperson");
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