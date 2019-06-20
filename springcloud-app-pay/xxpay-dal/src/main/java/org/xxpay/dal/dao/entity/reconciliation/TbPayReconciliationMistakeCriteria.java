package org.xxpay.dal.dao.entity.reconciliation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbPayReconciliationMistakeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayReconciliationMistakeCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andAccountCheckBatchNoIsNull() {
            addCriterion("account_check_batch_no is null");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoIsNotNull() {
            addCriterion("account_check_batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoEqualTo(String value) {
            addCriterion("account_check_batch_no =", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoNotEqualTo(String value) {
            addCriterion("account_check_batch_no <>", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoGreaterThan(String value) {
            addCriterion("account_check_batch_no >", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("account_check_batch_no >=", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoLessThan(String value) {
            addCriterion("account_check_batch_no <", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoLessThanOrEqualTo(String value) {
            addCriterion("account_check_batch_no <=", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoLike(String value) {
            addCriterion("account_check_batch_no like", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoNotLike(String value) {
            addCriterion("account_check_batch_no not like", value, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoIn(List<String> values) {
            addCriterion("account_check_batch_no in", values, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoNotIn(List<String> values) {
            addCriterion("account_check_batch_no not in", values, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoBetween(String value1, String value2) {
            addCriterion("account_check_batch_no between", value1, value2, "accountCheckBatchNo");
            return (Criteria) this;
        }

        public Criteria andAccountCheckBatchNoNotBetween(String value1, String value2) {
            addCriterion("account_check_batch_no not between", value1, value2, "accountCheckBatchNo");
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
            addCriterionForJDBCDate("bill_date =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bill_date <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(Date value) {
            addCriterionForJDBCDate("bill_date >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_date >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(Date value) {
            addCriterionForJDBCDate("bill_date <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bill_date <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<Date> values) {
            addCriterionForJDBCDate("bill_date in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bill_date not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_date between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bill_date not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNull() {
            addCriterion("bank_type is null");
            return (Criteria) this;
        }

        public Criteria andBankTypeIsNotNull() {
            addCriterion("bank_type is not null");
            return (Criteria) this;
        }

        public Criteria andBankTypeEqualTo(String value) {
            addCriterion("bank_type =", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotEqualTo(String value) {
            addCriterion("bank_type <>", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThan(String value) {
            addCriterion("bank_type >", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_type >=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThan(String value) {
            addCriterion("bank_type <", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLessThanOrEqualTo(String value) {
            addCriterion("bank_type <=", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeLike(String value) {
            addCriterion("bank_type like", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotLike(String value) {
            addCriterion("bank_type not like", value, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeIn(List<String> values) {
            addCriterion("bank_type in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotIn(List<String> values) {
            addCriterion("bank_type not in", values, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeBetween(String value1, String value2) {
            addCriterion("bank_type between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andBankTypeNotBetween(String value1, String value2) {
            addCriterion("bank_type not between", value1, value2, "bankType");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("merchant_name =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("merchant_name <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("merchant_name >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_name >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("merchant_name <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("merchant_name <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("merchant_name like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("merchant_name not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("merchant_name in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("merchant_name not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("merchant_name between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("merchant_name not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("merchant_no =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("merchant_no <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("merchant_no >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_no >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("merchant_no <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_no <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("merchant_no like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("merchant_no not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("merchant_no in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("merchant_no not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("merchant_no between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("merchant_no not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("trade_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("trade_time =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("trade_time <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("trade_time >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_time >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("trade_time <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("trade_time <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("trade_time in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("trade_time not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("trade_time between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("trade_time not between", value1, value2, "tradeTime");
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

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(BigDecimal value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(BigDecimal value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<BigDecimal> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("trade_status like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("trade_status not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeIsNull() {
            addCriterion("bank_trade_time is null");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeIsNotNull() {
            addCriterion("bank_trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeEqualTo(Date value) {
            addCriterion("bank_trade_time =", value, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeNotEqualTo(Date value) {
            addCriterion("bank_trade_time <>", value, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeGreaterThan(Date value) {
            addCriterion("bank_trade_time >", value, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bank_trade_time >=", value, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeLessThan(Date value) {
            addCriterion("bank_trade_time <", value, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("bank_trade_time <=", value, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeIn(List<Date> values) {
            addCriterion("bank_trade_time in", values, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeNotIn(List<Date> values) {
            addCriterion("bank_trade_time not in", values, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeBetween(Date value1, Date value2) {
            addCriterion("bank_trade_time between", value1, value2, "bankTradeTime");
            return (Criteria) this;
        }

        public Criteria andBankTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("bank_trade_time not between", value1, value2, "bankTradeTime");
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

        public Criteria andBankTradeStatusIsNull() {
            addCriterion("bank_trade_status is null");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusIsNotNull() {
            addCriterion("bank_trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusEqualTo(String value) {
            addCriterion("bank_trade_status =", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusNotEqualTo(String value) {
            addCriterion("bank_trade_status <>", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusGreaterThan(String value) {
            addCriterion("bank_trade_status >", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bank_trade_status >=", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusLessThan(String value) {
            addCriterion("bank_trade_status <", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("bank_trade_status <=", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusLike(String value) {
            addCriterion("bank_trade_status like", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusNotLike(String value) {
            addCriterion("bank_trade_status not like", value, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusIn(List<String> values) {
            addCriterion("bank_trade_status in", values, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusNotIn(List<String> values) {
            addCriterion("bank_trade_status not in", values, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusBetween(String value1, String value2) {
            addCriterion("bank_trade_status between", value1, value2, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankTradeStatusNotBetween(String value1, String value2) {
            addCriterion("bank_trade_status not between", value1, value2, "bankTradeStatus");
            return (Criteria) this;
        }

        public Criteria andBankAmountIsNull() {
            addCriterion("bank_amount is null");
            return (Criteria) this;
        }

        public Criteria andBankAmountIsNotNull() {
            addCriterion("bank_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBankAmountEqualTo(BigDecimal value) {
            addCriterion("bank_amount =", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountNotEqualTo(BigDecimal value) {
            addCriterion("bank_amount <>", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountGreaterThan(BigDecimal value) {
            addCriterion("bank_amount >", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_amount >=", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountLessThan(BigDecimal value) {
            addCriterion("bank_amount <", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_amount <=", value, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountIn(List<BigDecimal> values) {
            addCriterion("bank_amount in", values, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountNotIn(List<BigDecimal> values) {
            addCriterion("bank_amount not in", values, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_amount between", value1, value2, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_amount not between", value1, value2, "bankAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountIsNull() {
            addCriterion("bank_refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountIsNotNull() {
            addCriterion("bank_refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountEqualTo(BigDecimal value) {
            addCriterion("bank_refund_amount =", value, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("bank_refund_amount <>", value, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("bank_refund_amount >", value, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_refund_amount >=", value, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountLessThan(BigDecimal value) {
            addCriterion("bank_refund_amount <", value, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_refund_amount <=", value, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountIn(List<BigDecimal> values) {
            addCriterion("bank_refund_amount in", values, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("bank_refund_amount not in", values, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_refund_amount between", value1, value2, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_refund_amount not between", value1, value2, "bankRefundAmount");
            return (Criteria) this;
        }

        public Criteria andBankFeeIsNull() {
            addCriterion("bank_fee is null");
            return (Criteria) this;
        }

        public Criteria andBankFeeIsNotNull() {
            addCriterion("bank_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBankFeeEqualTo(BigDecimal value) {
            addCriterion("bank_fee =", value, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeNotEqualTo(BigDecimal value) {
            addCriterion("bank_fee <>", value, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeGreaterThan(BigDecimal value) {
            addCriterion("bank_fee >", value, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_fee >=", value, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeLessThan(BigDecimal value) {
            addCriterion("bank_fee <", value, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_fee <=", value, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeIn(List<BigDecimal> values) {
            addCriterion("bank_fee in", values, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeNotIn(List<BigDecimal> values) {
            addCriterion("bank_fee not in", values, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_fee between", value1, value2, "bankFee");
            return (Criteria) this;
        }

        public Criteria andBankFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_fee not between", value1, value2, "bankFee");
            return (Criteria) this;
        }

        public Criteria andErrTypeIsNull() {
            addCriterion("err_type is null");
            return (Criteria) this;
        }

        public Criteria andErrTypeIsNotNull() {
            addCriterion("err_type is not null");
            return (Criteria) this;
        }

        public Criteria andErrTypeEqualTo(String value) {
            addCriterion("err_type =", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotEqualTo(String value) {
            addCriterion("err_type <>", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeGreaterThan(String value) {
            addCriterion("err_type >", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("err_type >=", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLessThan(String value) {
            addCriterion("err_type <", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLessThanOrEqualTo(String value) {
            addCriterion("err_type <=", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLike(String value) {
            addCriterion("err_type like", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotLike(String value) {
            addCriterion("err_type not like", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeIn(List<String> values) {
            addCriterion("err_type in", values, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotIn(List<String> values) {
            addCriterion("err_type not in", values, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeBetween(String value1, String value2) {
            addCriterion("err_type between", value1, value2, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotBetween(String value1, String value2) {
            addCriterion("err_type not between", value1, value2, "errType");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNull() {
            addCriterion("handle_status is null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNotNull() {
            addCriterion("handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusEqualTo(String value) {
            addCriterion("handle_status =", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotEqualTo(String value) {
            addCriterion("handle_status <>", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThan(String value) {
            addCriterion("handle_status >", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("handle_status >=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThan(String value) {
            addCriterion("handle_status <", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThanOrEqualTo(String value) {
            addCriterion("handle_status <=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLike(String value) {
            addCriterion("handle_status like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotLike(String value) {
            addCriterion("handle_status not like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIn(List<String> values) {
            addCriterion("handle_status in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotIn(List<String> values) {
            addCriterion("handle_status not in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusBetween(String value1, String value2) {
            addCriterion("handle_status between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotBetween(String value1, String value2) {
            addCriterion("handle_status not between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleValueIsNull() {
            addCriterion("handle_value is null");
            return (Criteria) this;
        }

        public Criteria andHandleValueIsNotNull() {
            addCriterion("handle_value is not null");
            return (Criteria) this;
        }

        public Criteria andHandleValueEqualTo(String value) {
            addCriterion("handle_value =", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueNotEqualTo(String value) {
            addCriterion("handle_value <>", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueGreaterThan(String value) {
            addCriterion("handle_value >", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueGreaterThanOrEqualTo(String value) {
            addCriterion("handle_value >=", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueLessThan(String value) {
            addCriterion("handle_value <", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueLessThanOrEqualTo(String value) {
            addCriterion("handle_value <=", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueLike(String value) {
            addCriterion("handle_value like", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueNotLike(String value) {
            addCriterion("handle_value not like", value, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueIn(List<String> values) {
            addCriterion("handle_value in", values, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueNotIn(List<String> values) {
            addCriterion("handle_value not in", values, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueBetween(String value1, String value2) {
            addCriterion("handle_value between", value1, value2, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleValueNotBetween(String value1, String value2) {
            addCriterion("handle_value not between", value1, value2, "handleValue");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkIsNull() {
            addCriterion("handle_remark is null");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkIsNotNull() {
            addCriterion("handle_remark is not null");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkEqualTo(String value) {
            addCriterion("handle_remark =", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotEqualTo(String value) {
            addCriterion("handle_remark <>", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkGreaterThan(String value) {
            addCriterion("handle_remark >", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("handle_remark >=", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkLessThan(String value) {
            addCriterion("handle_remark <", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkLessThanOrEqualTo(String value) {
            addCriterion("handle_remark <=", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkLike(String value) {
            addCriterion("handle_remark like", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotLike(String value) {
            addCriterion("handle_remark not like", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkIn(List<String> values) {
            addCriterion("handle_remark in", values, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotIn(List<String> values) {
            addCriterion("handle_remark not in", values, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkBetween(String value1, String value2) {
            addCriterion("handle_remark between", value1, value2, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotBetween(String value1, String value2) {
            addCriterion("handle_remark not between", value1, value2, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoIsNull() {
            addCriterion("operator_account_no is null");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoIsNotNull() {
            addCriterion("operator_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoEqualTo(String value) {
            addCriterion("operator_account_no =", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoNotEqualTo(String value) {
            addCriterion("operator_account_no <>", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoGreaterThan(String value) {
            addCriterion("operator_account_no >", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("operator_account_no >=", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoLessThan(String value) {
            addCriterion("operator_account_no <", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoLessThanOrEqualTo(String value) {
            addCriterion("operator_account_no <=", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoLike(String value) {
            addCriterion("operator_account_no like", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoNotLike(String value) {
            addCriterion("operator_account_no not like", value, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoIn(List<String> values) {
            addCriterion("operator_account_no in", values, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoNotIn(List<String> values) {
            addCriterion("operator_account_no not in", values, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoBetween(String value1, String value2) {
            addCriterion("operator_account_no between", value1, value2, "operatorAccountNo");
            return (Criteria) this;
        }

        public Criteria andOperatorAccountNoNotBetween(String value1, String value2) {
            addCriterion("operator_account_no not between", value1, value2, "operatorAccountNo");
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