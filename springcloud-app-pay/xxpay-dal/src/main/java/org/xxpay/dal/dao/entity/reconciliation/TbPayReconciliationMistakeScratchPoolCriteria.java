package org.xxpay.dal.dao.entity.reconciliation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPayReconciliationMistakeScratchPoolCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayReconciliationMistakeScratchPoolCriteria() {
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andEditorIsNull() {
            addCriterion("editor is null");
            return (Criteria) this;
        }

        public Criteria andEditorIsNotNull() {
            addCriterion("editor is not null");
            return (Criteria) this;
        }

        public Criteria andEditorEqualTo(String value) {
            addCriterion("editor =", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotEqualTo(String value) {
            addCriterion("editor <>", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThan(String value) {
            addCriterion("editor >", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThanOrEqualTo(String value) {
            addCriterion("editor >=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThan(String value) {
            addCriterion("editor <", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThanOrEqualTo(String value) {
            addCriterion("editor <=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLike(String value) {
            addCriterion("editor like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotLike(String value) {
            addCriterion("editor not like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorIn(List<String> values) {
            addCriterion("editor in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotIn(List<String> values) {
            addCriterion("editor not in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorBetween(String value1, String value2) {
            addCriterion("editor between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotBetween(String value1, String value2) {
            addCriterion("editor not between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(Date value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(Date value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(Date value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(Date value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<Date> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<Date> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(Date value1, Date value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIsNull() {
            addCriterion("merchant_order_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIsNotNull() {
            addCriterion("merchant_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoEqualTo(String value) {
            addCriterion("merchant_order_no =", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotEqualTo(String value) {
            addCriterion("merchant_order_no <>", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoGreaterThan(String value) {
            addCriterion("merchant_order_no >", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_order_no >=", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLessThan(String value) {
            addCriterion("merchant_order_no <", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_order_no <=", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLike(String value) {
            addCriterion("merchant_order_no like", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotLike(String value) {
            addCriterion("merchant_order_no not like", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIn(List<String> values) {
            addCriterion("merchant_order_no in", values, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotIn(List<String> values) {
            addCriterion("merchant_order_no not in", values, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoBetween(String value1, String value2) {
            addCriterion("merchant_order_no between", value1, value2, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotBetween(String value1, String value2) {
            addCriterion("merchant_order_no not between", value1, value2, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoIsNull() {
            addCriterion("trx_no is null");
            return (Criteria) this;
        }

        public Criteria andTrxNoIsNotNull() {
            addCriterion("trx_no is not null");
            return (Criteria) this;
        }

        public Criteria andTrxNoEqualTo(String value) {
            addCriterion("trx_no =", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoNotEqualTo(String value) {
            addCriterion("trx_no <>", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoGreaterThan(String value) {
            addCriterion("trx_no >", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoGreaterThanOrEqualTo(String value) {
            addCriterion("trx_no >=", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoLessThan(String value) {
            addCriterion("trx_no <", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoLessThanOrEqualTo(String value) {
            addCriterion("trx_no <=", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoLike(String value) {
            addCriterion("trx_no like", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoNotLike(String value) {
            addCriterion("trx_no not like", value, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoIn(List<String> values) {
            addCriterion("trx_no in", values, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoNotIn(List<String> values) {
            addCriterion("trx_no not in", values, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoBetween(String value1, String value2) {
            addCriterion("trx_no between", value1, value2, "trxNo");
            return (Criteria) this;
        }

        public Criteria andTrxNoNotBetween(String value1, String value2) {
            addCriterion("trx_no not between", value1, value2, "trxNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoIsNull() {
            addCriterion("bank_order_no is null");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoIsNotNull() {
            addCriterion("bank_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoEqualTo(String value) {
            addCriterion("bank_order_no =", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoNotEqualTo(String value) {
            addCriterion("bank_order_no <>", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoGreaterThan(String value) {
            addCriterion("bank_order_no >", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_order_no >=", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoLessThan(String value) {
            addCriterion("bank_order_no <", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoLessThanOrEqualTo(String value) {
            addCriterion("bank_order_no <=", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoLike(String value) {
            addCriterion("bank_order_no like", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoNotLike(String value) {
            addCriterion("bank_order_no not like", value, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoIn(List<String> values) {
            addCriterion("bank_order_no in", values, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoNotIn(List<String> values) {
            addCriterion("bank_order_no not in", values, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoBetween(String value1, String value2) {
            addCriterion("bank_order_no between", value1, value2, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankOrderNoNotBetween(String value1, String value2) {
            addCriterion("bank_order_no not between", value1, value2, "bankOrderNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoIsNull() {
            addCriterion("bank_trx_no is null");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoIsNotNull() {
            addCriterion("bank_trx_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoEqualTo(String value) {
            addCriterion("bank_trx_no =", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoNotEqualTo(String value) {
            addCriterion("bank_trx_no <>", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoGreaterThan(String value) {
            addCriterion("bank_trx_no >", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_trx_no >=", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoLessThan(String value) {
            addCriterion("bank_trx_no <", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoLessThanOrEqualTo(String value) {
            addCriterion("bank_trx_no <=", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoLike(String value) {
            addCriterion("bank_trx_no like", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoNotLike(String value) {
            addCriterion("bank_trx_no not like", value, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoIn(List<String> values) {
            addCriterion("bank_trx_no in", values, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoNotIn(List<String> values) {
            addCriterion("bank_trx_no not in", values, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoBetween(String value1, String value2) {
            addCriterion("bank_trx_no between", value1, value2, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andBankTrxNoNotBetween(String value1, String value2) {
            addCriterion("bank_trx_no not between", value1, value2, "bankTrxNo");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeIsNull() {
            addCriterion("plat_income is null");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeIsNotNull() {
            addCriterion("plat_income is not null");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeEqualTo(BigDecimal value) {
            addCriterion("plat_income =", value, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeNotEqualTo(BigDecimal value) {
            addCriterion("plat_income <>", value, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeGreaterThan(BigDecimal value) {
            addCriterion("plat_income >", value, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plat_income >=", value, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeLessThan(BigDecimal value) {
            addCriterion("plat_income <", value, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plat_income <=", value, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeIn(List<BigDecimal> values) {
            addCriterion("plat_income in", values, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeNotIn(List<BigDecimal> values) {
            addCriterion("plat_income not in", values, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plat_income between", value1, value2, "platIncome");
            return (Criteria) this;
        }

        public Criteria andPlatIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plat_income not between", value1, value2, "platIncome");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNull() {
            addCriterion("fee_rate is null");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNotNull() {
            addCriterion("fee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRateEqualTo(BigDecimal value) {
            addCriterion("fee_rate =", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotEqualTo(BigDecimal value) {
            addCriterion("fee_rate <>", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThan(BigDecimal value) {
            addCriterion("fee_rate >", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_rate >=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThan(BigDecimal value) {
            addCriterion("fee_rate <", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_rate <=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateIn(List<BigDecimal> values) {
            addCriterion("fee_rate in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotIn(List<BigDecimal> values) {
            addCriterion("fee_rate not in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_rate between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_rate not between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andPlatCostIsNull() {
            addCriterion("plat_cost is null");
            return (Criteria) this;
        }

        public Criteria andPlatCostIsNotNull() {
            addCriterion("plat_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPlatCostEqualTo(BigDecimal value) {
            addCriterion("plat_cost =", value, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostNotEqualTo(BigDecimal value) {
            addCriterion("plat_cost <>", value, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostGreaterThan(BigDecimal value) {
            addCriterion("plat_cost >", value, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plat_cost >=", value, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostLessThan(BigDecimal value) {
            addCriterion("plat_cost <", value, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plat_cost <=", value, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostIn(List<BigDecimal> values) {
            addCriterion("plat_cost in", values, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostNotIn(List<BigDecimal> values) {
            addCriterion("plat_cost not in", values, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plat_cost between", value1, value2, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plat_cost not between", value1, value2, "platCost");
            return (Criteria) this;
        }

        public Criteria andPlatProfitIsNull() {
            addCriterion("plat_profit is null");
            return (Criteria) this;
        }

        public Criteria andPlatProfitIsNotNull() {
            addCriterion("plat_profit is not null");
            return (Criteria) this;
        }

        public Criteria andPlatProfitEqualTo(BigDecimal value) {
            addCriterion("plat_profit =", value, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitNotEqualTo(BigDecimal value) {
            addCriterion("plat_profit <>", value, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitGreaterThan(BigDecimal value) {
            addCriterion("plat_profit >", value, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plat_profit >=", value, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitLessThan(BigDecimal value) {
            addCriterion("plat_profit <", value, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plat_profit <=", value, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitIn(List<BigDecimal> values) {
            addCriterion("plat_profit in", values, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitNotIn(List<BigDecimal> values) {
            addCriterion("plat_profit not in", values, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plat_profit between", value1, value2, "platProfit");
            return (Criteria) this;
        }

        public Criteria andPlatProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plat_profit not between", value1, value2, "platProfit");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeIsNull() {
            addCriterion("pay_way_code is null");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeIsNotNull() {
            addCriterion("pay_way_code is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeEqualTo(String value) {
            addCriterion("pay_way_code =", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotEqualTo(String value) {
            addCriterion("pay_way_code <>", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeGreaterThan(String value) {
            addCriterion("pay_way_code >", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_code >=", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeLessThan(String value) {
            addCriterion("pay_way_code <", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeLessThanOrEqualTo(String value) {
            addCriterion("pay_way_code <=", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeLike(String value) {
            addCriterion("pay_way_code like", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotLike(String value) {
            addCriterion("pay_way_code not like", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeIn(List<String> values) {
            addCriterion("pay_way_code in", values, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotIn(List<String> values) {
            addCriterion("pay_way_code not in", values, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeBetween(String value1, String value2) {
            addCriterion("pay_way_code between", value1, value2, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotBetween(String value1, String value2) {
            addCriterion("pay_way_code not between", value1, value2, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayNameIsNull() {
            addCriterion("pay_way_name is null");
            return (Criteria) this;
        }

        public Criteria andPayWayNameIsNotNull() {
            addCriterion("pay_way_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayNameEqualTo(String value) {
            addCriterion("pay_way_name =", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotEqualTo(String value) {
            addCriterion("pay_way_name <>", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameGreaterThan(String value) {
            addCriterion("pay_way_name >", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_name >=", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameLessThan(String value) {
            addCriterion("pay_way_name <", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameLessThanOrEqualTo(String value) {
            addCriterion("pay_way_name <=", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameLike(String value) {
            addCriterion("pay_way_name like", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotLike(String value) {
            addCriterion("pay_way_name not like", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameIn(List<String> values) {
            addCriterion("pay_way_name in", values, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotIn(List<String> values) {
            addCriterion("pay_way_name not in", values, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameBetween(String value1, String value2) {
            addCriterion("pay_way_name between", value1, value2, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotBetween(String value1, String value2) {
            addCriterion("pay_way_name not between", value1, value2, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIsNull() {
            addCriterion("pay_success_time is null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIsNotNull() {
            addCriterion("pay_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeEqualTo(Date value) {
            addCriterion("pay_success_time =", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotEqualTo(Date value) {
            addCriterion("pay_success_time <>", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeGreaterThan(Date value) {
            addCriterion("pay_success_time >", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_success_time >=", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeLessThan(Date value) {
            addCriterion("pay_success_time <", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_success_time <=", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIn(List<Date> values) {
            addCriterion("pay_success_time in", values, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotIn(List<Date> values) {
            addCriterion("pay_success_time not in", values, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeBetween(Date value1, Date value2) {
            addCriterion("pay_success_time between", value1, value2, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_success_time not between", value1, value2, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(Date value) {
            addCriterion("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(Date value) {
            addCriterion("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(Date value) {
            addCriterion("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(Date value) {
            addCriterion("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<Date> values) {
            addCriterion("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<Date> values) {
            addCriterion("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(Date value1, Date value2) {
            addCriterion("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("complete_time not between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNull() {
            addCriterion("is_refund is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNotNull() {
            addCriterion("is_refund is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundEqualTo(String value) {
            addCriterion("is_refund =", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotEqualTo(String value) {
            addCriterion("is_refund <>", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThan(String value) {
            addCriterion("is_refund >", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThanOrEqualTo(String value) {
            addCriterion("is_refund >=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThan(String value) {
            addCriterion("is_refund <", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThanOrEqualTo(String value) {
            addCriterion("is_refund <=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLike(String value) {
            addCriterion("is_refund like", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotLike(String value) {
            addCriterion("is_refund not like", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundIn(List<String> values) {
            addCriterion("is_refund in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotIn(List<String> values) {
            addCriterion("is_refund not in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundBetween(String value1, String value2) {
            addCriterion("is_refund between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotBetween(String value1, String value2) {
            addCriterion("is_refund not between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andRefundTimesIsNull() {
            addCriterion("refund_times is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimesIsNotNull() {
            addCriterion("refund_times is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimesEqualTo(Short value) {
            addCriterion("refund_times =", value, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesNotEqualTo(Short value) {
            addCriterion("refund_times <>", value, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesGreaterThan(Short value) {
            addCriterion("refund_times >", value, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("refund_times >=", value, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesLessThan(Short value) {
            addCriterion("refund_times <", value, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesLessThanOrEqualTo(Short value) {
            addCriterion("refund_times <=", value, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesIn(List<Short> values) {
            addCriterion("refund_times in", values, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesNotIn(List<Short> values) {
            addCriterion("refund_times not in", values, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesBetween(Short value1, Short value2) {
            addCriterion("refund_times between", value1, value2, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andRefundTimesNotBetween(Short value1, Short value2) {
            addCriterion("refund_times not between", value1, value2, "refundTimes");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountIsNull() {
            addCriterion("success_refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountIsNotNull() {
            addCriterion("success_refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountEqualTo(BigDecimal value) {
            addCriterion("success_refund_amount =", value, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("success_refund_amount <>", value, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("success_refund_amount >", value, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("success_refund_amount >=", value, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountLessThan(BigDecimal value) {
            addCriterion("success_refund_amount <", value, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("success_refund_amount <=", value, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountIn(List<BigDecimal> values) {
            addCriterion("success_refund_amount in", values, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("success_refund_amount not in", values, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_refund_amount between", value1, value2, "successRefundAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("success_refund_amount not between", value1, value2, "successRefundAmount");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNull() {
            addCriterion("bill_date is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(Date value) {
            addCriterion("bill_date =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(Date value) {
            addCriterion("bill_date <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(Date value) {
            addCriterion("bill_date >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_date >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(Date value) {
            addCriterion("bill_date <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(Date value) {
            addCriterion("bill_date <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<Date> values) {
            addCriterion("bill_date in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<Date> values) {
            addCriterion("bill_date not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(Date value1, Date value2) {
            addCriterion("bill_date between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(Date value1, Date value2) {
            addCriterion("bill_date not between", value1, value2, "billDate");
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