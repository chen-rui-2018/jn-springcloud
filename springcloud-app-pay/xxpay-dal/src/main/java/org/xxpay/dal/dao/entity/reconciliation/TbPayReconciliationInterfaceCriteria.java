package org.xxpay.dal.dao.entity.reconciliation;

import java.util.ArrayList;
import java.util.List;

public class TbPayReconciliationInterfaceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayReconciliationInterfaceCriteria() {
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

        public Criteria andInterfaceNameIsNull() {
            addCriterion("interface_name is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIsNotNull() {
            addCriterion("interface_name is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameEqualTo(String value) {
            addCriterion("interface_name =", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotEqualTo(String value) {
            addCriterion("interface_name <>", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThan(String value) {
            addCriterion("interface_name >", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("interface_name >=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThan(String value) {
            addCriterion("interface_name <", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLessThanOrEqualTo(String value) {
            addCriterion("interface_name <=", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameLike(String value) {
            addCriterion("interface_name like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotLike(String value) {
            addCriterion("interface_name not like", value, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameIn(List<String> values) {
            addCriterion("interface_name in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotIn(List<String> values) {
            addCriterion("interface_name not in", values, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameBetween(String value1, String value2) {
            addCriterion("interface_name between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceNameNotBetween(String value1, String value2) {
            addCriterion("interface_name not between", value1, value2, "interfaceName");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeIsNull() {
            addCriterion("interface_code is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeIsNotNull() {
            addCriterion("interface_code is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeEqualTo(String value) {
            addCriterion("interface_code =", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotEqualTo(String value) {
            addCriterion("interface_code <>", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeGreaterThan(String value) {
            addCriterion("interface_code >", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("interface_code >=", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeLessThan(String value) {
            addCriterion("interface_code <", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeLessThanOrEqualTo(String value) {
            addCriterion("interface_code <=", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeLike(String value) {
            addCriterion("interface_code like", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotLike(String value) {
            addCriterion("interface_code not like", value, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeIn(List<String> values) {
            addCriterion("interface_code in", values, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotIn(List<String> values) {
            addCriterion("interface_code not in", values, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeBetween(String value1, String value2) {
            addCriterion("interface_code between", value1, value2, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceCodeNotBetween(String value1, String value2) {
            addCriterion("interface_code not between", value1, value2, "interfaceCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescIsNull() {
            addCriterion("interface_desc is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescIsNotNull() {
            addCriterion("interface_desc is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescEqualTo(String value) {
            addCriterion("interface_desc =", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotEqualTo(String value) {
            addCriterion("interface_desc <>", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescGreaterThan(String value) {
            addCriterion("interface_desc >", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescGreaterThanOrEqualTo(String value) {
            addCriterion("interface_desc >=", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescLessThan(String value) {
            addCriterion("interface_desc <", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescLessThanOrEqualTo(String value) {
            addCriterion("interface_desc <=", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescLike(String value) {
            addCriterion("interface_desc like", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotLike(String value) {
            addCriterion("interface_desc not like", value, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescIn(List<String> values) {
            addCriterion("interface_desc in", values, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotIn(List<String> values) {
            addCriterion("interface_desc not in", values, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescBetween(String value1, String value2) {
            addCriterion("interface_desc between", value1, value2, "interfaceDesc");
            return (Criteria) this;
        }

        public Criteria andInterfaceDescNotBetween(String value1, String value2) {
            addCriterion("interface_desc not between", value1, value2, "interfaceDesc");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBillDayIsNull() {
            addCriterion("bill_day is null");
            return (Criteria) this;
        }

        public Criteria andBillDayIsNotNull() {
            addCriterion("bill_day is not null");
            return (Criteria) this;
        }

        public Criteria andBillDayEqualTo(Integer value) {
            addCriterion("bill_day =", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotEqualTo(Integer value) {
            addCriterion("bill_day <>", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayGreaterThan(Integer value) {
            addCriterion("bill_day >", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_day >=", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayLessThan(Integer value) {
            addCriterion("bill_day <", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayLessThanOrEqualTo(Integer value) {
            addCriterion("bill_day <=", value, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayIn(List<Integer> values) {
            addCriterion("bill_day in", values, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotIn(List<Integer> values) {
            addCriterion("bill_day not in", values, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayBetween(Integer value1, Integer value2) {
            addCriterion("bill_day between", value1, value2, "billDay");
            return (Criteria) this;
        }

        public Criteria andBillDayNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_day not between", value1, value2, "billDay");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
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