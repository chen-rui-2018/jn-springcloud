package com.jn.oa.item.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOaItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOaItemCriteria() {
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

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIsNull() {
            addCriterion("responsible_id is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIsNotNull() {
            addCriterion("responsible_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdEqualTo(String value) {
            addCriterion("responsible_id =", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotEqualTo(String value) {
            addCriterion("responsible_id <>", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdGreaterThan(String value) {
            addCriterion("responsible_id >", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdGreaterThanOrEqualTo(String value) {
            addCriterion("responsible_id >=", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLessThan(String value) {
            addCriterion("responsible_id <", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLessThanOrEqualTo(String value) {
            addCriterion("responsible_id <=", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLike(String value) {
            addCriterion("responsible_id like", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotLike(String value) {
            addCriterion("responsible_id not like", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIn(List<String> values) {
            addCriterion("responsible_id in", values, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotIn(List<String> values) {
            addCriterion("responsible_id not in", values, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdBetween(String value1, String value2) {
            addCriterion("responsible_id between", value1, value2, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotBetween(String value1, String value2) {
            addCriterion("responsible_id not between", value1, value2, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNull() {
            addCriterion("item_status is null");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNotNull() {
            addCriterion("item_status is not null");
            return (Criteria) this;
        }

        public Criteria andItemStatusEqualTo(String value) {
            addCriterion("item_status =", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotEqualTo(String value) {
            addCriterion("item_status <>", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThan(String value) {
            addCriterion("item_status >", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThanOrEqualTo(String value) {
            addCriterion("item_status >=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThan(String value) {
            addCriterion("item_status <", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThanOrEqualTo(String value) {
            addCriterion("item_status <=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLike(String value) {
            addCriterion("item_status like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotLike(String value) {
            addCriterion("item_status not like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusIn(List<String> values) {
            addCriterion("item_status in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotIn(List<String> values) {
            addCriterion("item_status not in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusBetween(String value1, String value2) {
            addCriterion("item_status between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotBetween(String value1, String value2) {
            addCriterion("item_status not between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(String value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(String value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(String value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(String value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(String value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLike(String value) {
            addCriterion("approval_status like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotLike(String value) {
            addCriterion("approval_status not like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<String> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<String> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(String value1, String value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(String value1, String value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseIsNull() {
            addCriterion("approval_advise is null");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseIsNotNull() {
            addCriterion("approval_advise is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseEqualTo(String value) {
            addCriterion("approval_advise =", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseNotEqualTo(String value) {
            addCriterion("approval_advise <>", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseGreaterThan(String value) {
            addCriterion("approval_advise >", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseGreaterThanOrEqualTo(String value) {
            addCriterion("approval_advise >=", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseLessThan(String value) {
            addCriterion("approval_advise <", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseLessThanOrEqualTo(String value) {
            addCriterion("approval_advise <=", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseLike(String value) {
            addCriterion("approval_advise like", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseNotLike(String value) {
            addCriterion("approval_advise not like", value, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseIn(List<String> values) {
            addCriterion("approval_advise in", values, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseNotIn(List<String> values) {
            addCriterion("approval_advise not in", values, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseBetween(String value1, String value2) {
            addCriterion("approval_advise between", value1, value2, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andApprovalAdviseNotBetween(String value1, String value2) {
            addCriterion("approval_advise not between", value1, value2, "approvalAdvise");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeIsNull() {
            addCriterion("total_plan_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeIsNotNull() {
            addCriterion("total_plan_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeEqualTo(Double value) {
            addCriterion("total_plan_time =", value, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeNotEqualTo(Double value) {
            addCriterion("total_plan_time <>", value, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeGreaterThan(Double value) {
            addCriterion("total_plan_time >", value, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_plan_time >=", value, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeLessThan(Double value) {
            addCriterion("total_plan_time <", value, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeLessThanOrEqualTo(Double value) {
            addCriterion("total_plan_time <=", value, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeIn(List<Double> values) {
            addCriterion("total_plan_time in", values, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeNotIn(List<Double> values) {
            addCriterion("total_plan_time not in", values, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeBetween(Double value1, Double value2) {
            addCriterion("total_plan_time between", value1, value2, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalPlanTimeNotBetween(Double value1, Double value2) {
            addCriterion("total_plan_time not between", value1, value2, "totalPlanTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeIsNull() {
            addCriterion("total_consume_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeIsNotNull() {
            addCriterion("total_consume_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeEqualTo(Double value) {
            addCriterion("total_consume_time =", value, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeNotEqualTo(Double value) {
            addCriterion("total_consume_time <>", value, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeGreaterThan(Double value) {
            addCriterion("total_consume_time >", value, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_consume_time >=", value, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeLessThan(Double value) {
            addCriterion("total_consume_time <", value, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeLessThanOrEqualTo(Double value) {
            addCriterion("total_consume_time <=", value, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeIn(List<Double> values) {
            addCriterion("total_consume_time in", values, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeNotIn(List<Double> values) {
            addCriterion("total_consume_time not in", values, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeBetween(Double value1, Double value2) {
            addCriterion("total_consume_time between", value1, value2, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalConsumeTimeNotBetween(Double value1, Double value2) {
            addCriterion("total_consume_time not between", value1, value2, "totalConsumeTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeIsNull() {
            addCriterion("total_remain_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeIsNotNull() {
            addCriterion("total_remain_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeEqualTo(Double value) {
            addCriterion("total_remain_time =", value, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeNotEqualTo(Double value) {
            addCriterion("total_remain_time <>", value, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeGreaterThan(Double value) {
            addCriterion("total_remain_time >", value, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_remain_time >=", value, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeLessThan(Double value) {
            addCriterion("total_remain_time <", value, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeLessThanOrEqualTo(Double value) {
            addCriterion("total_remain_time <=", value, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeIn(List<Double> values) {
            addCriterion("total_remain_time in", values, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeNotIn(List<Double> values) {
            addCriterion("total_remain_time not in", values, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeBetween(Double value1, Double value2) {
            addCriterion("total_remain_time between", value1, value2, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andTotalRemainTimeNotBetween(Double value1, Double value2) {
            addCriterion("total_remain_time not between", value1, value2, "totalRemainTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("plan_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("plan_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(Date value) {
            addCriterion("plan_end_time =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(Date value) {
            addCriterion("plan_end_time <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(Date value) {
            addCriterion("plan_end_time >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_end_time >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(Date value) {
            addCriterion("plan_end_time <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_end_time <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<Date> values) {
            addCriterion("plan_end_time in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<Date> values) {
            addCriterion("plan_end_time not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("plan_end_time between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_end_time not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNull() {
            addCriterion("plan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIsNotNull() {
            addCriterion("plan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeEqualTo(Date value) {
            addCriterion("plan_start_time =", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotEqualTo(Date value) {
            addCriterion("plan_start_time <>", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThan(Date value) {
            addCriterion("plan_start_time >", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_start_time >=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThan(Date value) {
            addCriterion("plan_start_time <", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_start_time <=", value, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeIn(List<Date> values) {
            addCriterion("plan_start_time in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotIn(List<Date> values) {
            addCriterion("plan_start_time not in", values, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeBetween(Date value1, Date value2) {
            addCriterion("plan_start_time between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andPlanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_start_time not between", value1, value2, "planStartTime");
            return (Criteria) this;
        }

        public Criteria andItemProgressIsNull() {
            addCriterion("item_progress is null");
            return (Criteria) this;
        }

        public Criteria andItemProgressIsNotNull() {
            addCriterion("item_progress is not null");
            return (Criteria) this;
        }

        public Criteria andItemProgressEqualTo(String value) {
            addCriterion("item_progress =", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressNotEqualTo(String value) {
            addCriterion("item_progress <>", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressGreaterThan(String value) {
            addCriterion("item_progress >", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressGreaterThanOrEqualTo(String value) {
            addCriterion("item_progress >=", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressLessThan(String value) {
            addCriterion("item_progress <", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressLessThanOrEqualTo(String value) {
            addCriterion("item_progress <=", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressLike(String value) {
            addCriterion("item_progress like", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressNotLike(String value) {
            addCriterion("item_progress not like", value, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressIn(List<String> values) {
            addCriterion("item_progress in", values, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressNotIn(List<String> values) {
            addCriterion("item_progress not in", values, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressBetween(String value1, String value2) {
            addCriterion("item_progress between", value1, value2, "itemProgress");
            return (Criteria) this;
        }

        public Criteria andItemProgressNotBetween(String value1, String value2) {
            addCriterion("item_progress not between", value1, value2, "itemProgress");
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
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
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
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andIsExpireIsNull() {
            addCriterion("is_expire is null");
            return (Criteria) this;
        }

        public Criteria andIsExpireIsNotNull() {
            addCriterion("is_expire is not null");
            return (Criteria) this;
        }

        public Criteria andIsExpireEqualTo(String value) {
            addCriterion("is_expire =", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotEqualTo(String value) {
            addCriterion("is_expire <>", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireGreaterThan(String value) {
            addCriterion("is_expire >", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireGreaterThanOrEqualTo(String value) {
            addCriterion("is_expire >=", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireLessThan(String value) {
            addCriterion("is_expire <", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireLessThanOrEqualTo(String value) {
            addCriterion("is_expire <=", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireLike(String value) {
            addCriterion("is_expire like", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotLike(String value) {
            addCriterion("is_expire not like", value, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireIn(List<String> values) {
            addCriterion("is_expire in", values, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotIn(List<String> values) {
            addCriterion("is_expire not in", values, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireBetween(String value1, String value2) {
            addCriterion("is_expire between", value1, value2, "isExpire");
            return (Criteria) this;
        }

        public Criteria andIsExpireNotBetween(String value1, String value2) {
            addCriterion("is_expire not between", value1, value2, "isExpire");
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