package org.xxpay.dal.dao.entity.reconciliation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbPayReconciliationCheckBatchCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPayReconciliationCheckBatchCriteria() {
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

        public Criteria andBillTypeIsNull() {
            addCriterion("bill_type is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("bill_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(String value) {
            addCriterion("bill_type =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(String value) {
            addCriterion("bill_type <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(String value) {
            addCriterion("bill_type >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_type >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(String value) {
            addCriterion("bill_type <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_type <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLike(String value) {
            addCriterion("bill_type like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotLike(String value) {
            addCriterion("bill_type not like", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<String> values) {
            addCriterion("bill_type in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<String> values) {
            addCriterion("bill_type not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(String value1, String value2) {
            addCriterion("bill_type between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(String value1, String value2) {
            addCriterion("bill_type not between", value1, value2, "billType");
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

        public Criteria andMistakeCountIsNull() {
            addCriterion("mistake_count is null");
            return (Criteria) this;
        }

        public Criteria andMistakeCountIsNotNull() {
            addCriterion("mistake_count is not null");
            return (Criteria) this;
        }

        public Criteria andMistakeCountEqualTo(Integer value) {
            addCriterion("mistake_count =", value, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountNotEqualTo(Integer value) {
            addCriterion("mistake_count <>", value, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountGreaterThan(Integer value) {
            addCriterion("mistake_count >", value, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("mistake_count >=", value, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountLessThan(Integer value) {
            addCriterion("mistake_count <", value, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("mistake_count <=", value, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountIn(List<Integer> values) {
            addCriterion("mistake_count in", values, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountNotIn(List<Integer> values) {
            addCriterion("mistake_count not in", values, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountBetween(Integer value1, Integer value2) {
            addCriterion("mistake_count between", value1, value2, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andMistakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("mistake_count not between", value1, value2, "mistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountIsNull() {
            addCriterion("unhandle_mistake_count is null");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountIsNotNull() {
            addCriterion("unhandle_mistake_count is not null");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountEqualTo(Integer value) {
            addCriterion("unhandle_mistake_count =", value, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountNotEqualTo(Integer value) {
            addCriterion("unhandle_mistake_count <>", value, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountGreaterThan(Integer value) {
            addCriterion("unhandle_mistake_count >", value, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("unhandle_mistake_count >=", value, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountLessThan(Integer value) {
            addCriterion("unhandle_mistake_count <", value, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountLessThanOrEqualTo(Integer value) {
            addCriterion("unhandle_mistake_count <=", value, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountIn(List<Integer> values) {
            addCriterion("unhandle_mistake_count in", values, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountNotIn(List<Integer> values) {
            addCriterion("unhandle_mistake_count not in", values, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountBetween(Integer value1, Integer value2) {
            addCriterion("unhandle_mistake_count between", value1, value2, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andUnhandleMistakeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("unhandle_mistake_count not between", value1, value2, "unhandleMistakeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNull() {
            addCriterion("trade_count is null");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNotNull() {
            addCriterion("trade_count is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCountEqualTo(Integer value) {
            addCriterion("trade_count =", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotEqualTo(Integer value) {
            addCriterion("trade_count <>", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThan(Integer value) {
            addCriterion("trade_count >", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_count >=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThan(Integer value) {
            addCriterion("trade_count <", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThanOrEqualTo(Integer value) {
            addCriterion("trade_count <=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountIn(List<Integer> values) {
            addCriterion("trade_count in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotIn(List<Integer> values) {
            addCriterion("trade_count not in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountBetween(Integer value1, Integer value2) {
            addCriterion("trade_count between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_count not between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountIsNull() {
            addCriterion("bank_trade_count is null");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountIsNotNull() {
            addCriterion("bank_trade_count is not null");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountEqualTo(Integer value) {
            addCriterion("bank_trade_count =", value, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountNotEqualTo(Integer value) {
            addCriterion("bank_trade_count <>", value, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountGreaterThan(Integer value) {
            addCriterion("bank_trade_count >", value, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bank_trade_count >=", value, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountLessThan(Integer value) {
            addCriterion("bank_trade_count <", value, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountLessThanOrEqualTo(Integer value) {
            addCriterion("bank_trade_count <=", value, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountIn(List<Integer> values) {
            addCriterion("bank_trade_count in", values, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountNotIn(List<Integer> values) {
            addCriterion("bank_trade_count not in", values, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountBetween(Integer value1, Integer value2) {
            addCriterion("bank_trade_count between", value1, value2, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andBankTradeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bank_trade_count not between", value1, value2, "bankTradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(BigDecimal value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(BigDecimal value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(BigDecimal value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(BigDecimal value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<BigDecimal> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<BigDecimal> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountIsNull() {
            addCriterion("bank_trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountIsNotNull() {
            addCriterion("bank_trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountEqualTo(BigDecimal value) {
            addCriterion("bank_trade_amount =", value, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountNotEqualTo(BigDecimal value) {
            addCriterion("bank_trade_amount <>", value, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountGreaterThan(BigDecimal value) {
            addCriterion("bank_trade_amount >", value, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_trade_amount >=", value, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountLessThan(BigDecimal value) {
            addCriterion("bank_trade_amount <", value, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bank_trade_amount <=", value, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountIn(List<BigDecimal> values) {
            addCriterion("bank_trade_amount in", values, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountNotIn(List<BigDecimal> values) {
            addCriterion("bank_trade_amount not in", values, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_trade_amount between", value1, value2, "bankTradeAmount");
            return (Criteria) this;
        }

        public Criteria andBankTradeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bank_trade_amount not between", value1, value2, "bankTradeAmount");
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

        public Criteria andOrgCheckFilePathIsNull() {
            addCriterion("org_check_file_path is null");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathIsNotNull() {
            addCriterion("org_check_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathEqualTo(String value) {
            addCriterion("org_check_file_path =", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathNotEqualTo(String value) {
            addCriterion("org_check_file_path <>", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathGreaterThan(String value) {
            addCriterion("org_check_file_path >", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("org_check_file_path >=", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathLessThan(String value) {
            addCriterion("org_check_file_path <", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathLessThanOrEqualTo(String value) {
            addCriterion("org_check_file_path <=", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathLike(String value) {
            addCriterion("org_check_file_path like", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathNotLike(String value) {
            addCriterion("org_check_file_path not like", value, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathIn(List<String> values) {
            addCriterion("org_check_file_path in", values, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathNotIn(List<String> values) {
            addCriterion("org_check_file_path not in", values, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathBetween(String value1, String value2) {
            addCriterion("org_check_file_path between", value1, value2, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andOrgCheckFilePathNotBetween(String value1, String value2) {
            addCriterion("org_check_file_path not between", value1, value2, "orgCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathIsNull() {
            addCriterion("release_check_file_path is null");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathIsNotNull() {
            addCriterion("release_check_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathEqualTo(String value) {
            addCriterion("release_check_file_path =", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathNotEqualTo(String value) {
            addCriterion("release_check_file_path <>", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathGreaterThan(String value) {
            addCriterion("release_check_file_path >", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("release_check_file_path >=", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathLessThan(String value) {
            addCriterion("release_check_file_path <", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathLessThanOrEqualTo(String value) {
            addCriterion("release_check_file_path <=", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathLike(String value) {
            addCriterion("release_check_file_path like", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathNotLike(String value) {
            addCriterion("release_check_file_path not like", value, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathIn(List<String> values) {
            addCriterion("release_check_file_path in", values, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathNotIn(List<String> values) {
            addCriterion("release_check_file_path not in", values, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathBetween(String value1, String value2) {
            addCriterion("release_check_file_path between", value1, value2, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseCheckFilePathNotBetween(String value1, String value2) {
            addCriterion("release_check_file_path not between", value1, value2, "releaseCheckFilePath");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusIsNull() {
            addCriterion("release_status is null");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusIsNotNull() {
            addCriterion("release_status is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusEqualTo(String value) {
            addCriterion("release_status =", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusNotEqualTo(String value) {
            addCriterion("release_status <>", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusGreaterThan(String value) {
            addCriterion("release_status >", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("release_status >=", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusLessThan(String value) {
            addCriterion("release_status <", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusLessThanOrEqualTo(String value) {
            addCriterion("release_status <=", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusLike(String value) {
            addCriterion("release_status like", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusNotLike(String value) {
            addCriterion("release_status not like", value, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusIn(List<String> values) {
            addCriterion("release_status in", values, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusNotIn(List<String> values) {
            addCriterion("release_status not in", values, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusBetween(String value1, String value2) {
            addCriterion("release_status between", value1, value2, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andReleaseStatusNotBetween(String value1, String value2) {
            addCriterion("release_status not between", value1, value2, "releaseStatus");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgIsNull() {
            addCriterion("check_fail_msg is null");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgIsNotNull() {
            addCriterion("check_fail_msg is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgEqualTo(String value) {
            addCriterion("check_fail_msg =", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgNotEqualTo(String value) {
            addCriterion("check_fail_msg <>", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgGreaterThan(String value) {
            addCriterion("check_fail_msg >", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgGreaterThanOrEqualTo(String value) {
            addCriterion("check_fail_msg >=", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgLessThan(String value) {
            addCriterion("check_fail_msg <", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgLessThanOrEqualTo(String value) {
            addCriterion("check_fail_msg <=", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgLike(String value) {
            addCriterion("check_fail_msg like", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgNotLike(String value) {
            addCriterion("check_fail_msg not like", value, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgIn(List<String> values) {
            addCriterion("check_fail_msg in", values, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgNotIn(List<String> values) {
            addCriterion("check_fail_msg not in", values, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgBetween(String value1, String value2) {
            addCriterion("check_fail_msg between", value1, value2, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andCheckFailMsgNotBetween(String value1, String value2) {
            addCriterion("check_fail_msg not between", value1, value2, "checkFailMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgIsNull() {
            addCriterion("bank_err_msg is null");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgIsNotNull() {
            addCriterion("bank_err_msg is not null");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgEqualTo(String value) {
            addCriterion("bank_err_msg =", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgNotEqualTo(String value) {
            addCriterion("bank_err_msg <>", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgGreaterThan(String value) {
            addCriterion("bank_err_msg >", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgGreaterThanOrEqualTo(String value) {
            addCriterion("bank_err_msg >=", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgLessThan(String value) {
            addCriterion("bank_err_msg <", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgLessThanOrEqualTo(String value) {
            addCriterion("bank_err_msg <=", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgLike(String value) {
            addCriterion("bank_err_msg like", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgNotLike(String value) {
            addCriterion("bank_err_msg not like", value, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgIn(List<String> values) {
            addCriterion("bank_err_msg in", values, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgNotIn(List<String> values) {
            addCriterion("bank_err_msg not in", values, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgBetween(String value1, String value2) {
            addCriterion("bank_err_msg between", value1, value2, "bankErrMsg");
            return (Criteria) this;
        }

        public Criteria andBankErrMsgNotBetween(String value1, String value2) {
            addCriterion("bank_err_msg not between", value1, value2, "bankErrMsg");
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