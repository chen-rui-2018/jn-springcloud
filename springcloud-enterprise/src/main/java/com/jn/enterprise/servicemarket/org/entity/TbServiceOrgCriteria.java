package com.jn.enterprise.servicemarket.org.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbServiceOrgCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceOrgCriteria() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrgAccountIsNull() {
            addCriterion("org_account is null");
            return (Criteria) this;
        }

        public Criteria andOrgAccountIsNotNull() {
            addCriterion("org_account is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAccountEqualTo(String value) {
            addCriterion("org_account =", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountNotEqualTo(String value) {
            addCriterion("org_account <>", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountGreaterThan(String value) {
            addCriterion("org_account >", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountGreaterThanOrEqualTo(String value) {
            addCriterion("org_account >=", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountLessThan(String value) {
            addCriterion("org_account <", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountLessThanOrEqualTo(String value) {
            addCriterion("org_account <=", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountLike(String value) {
            addCriterion("org_account like", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountNotLike(String value) {
            addCriterion("org_account not like", value, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountIn(List<String> values) {
            addCriterion("org_account in", values, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountNotIn(List<String> values) {
            addCriterion("org_account not in", values, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountBetween(String value1, String value2) {
            addCriterion("org_account between", value1, value2, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgAccountNotBetween(String value1, String value2) {
            addCriterion("org_account not between", value1, value2, "orgAccount");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeIsNull() {
            addCriterion("org_register_time is null");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeIsNotNull() {
            addCriterion("org_register_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeEqualTo(Date value) {
            addCriterionForJDBCDate("org_register_time =", value, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("org_register_time <>", value, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("org_register_time >", value, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("org_register_time >=", value, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeLessThan(Date value) {
            addCriterionForJDBCDate("org_register_time <", value, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("org_register_time <=", value, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeIn(List<Date> values) {
            addCriterionForJDBCDate("org_register_time in", values, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("org_register_time not in", values, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("org_register_time between", value1, value2, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andOrgRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("org_register_time not between", value1, value2, "orgRegisterTime");
            return (Criteria) this;
        }

        public Criteria andIsApproveIsNull() {
            addCriterion("is_approve is null");
            return (Criteria) this;
        }

        public Criteria andIsApproveIsNotNull() {
            addCriterion("is_approve is not null");
            return (Criteria) this;
        }

        public Criteria andIsApproveEqualTo(String value) {
            addCriterion("is_approve =", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveNotEqualTo(String value) {
            addCriterion("is_approve <>", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveGreaterThan(String value) {
            addCriterion("is_approve >", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveGreaterThanOrEqualTo(String value) {
            addCriterion("is_approve >=", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveLessThan(String value) {
            addCriterion("is_approve <", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveLessThanOrEqualTo(String value) {
            addCriterion("is_approve <=", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveLike(String value) {
            addCriterion("is_approve like", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveNotLike(String value) {
            addCriterion("is_approve not like", value, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveIn(List<String> values) {
            addCriterion("is_approve in", values, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveNotIn(List<String> values) {
            addCriterion("is_approve not in", values, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveBetween(String value1, String value2) {
            addCriterion("is_approve between", value1, value2, "isApprove");
            return (Criteria) this;
        }

        public Criteria andIsApproveNotBetween(String value1, String value2) {
            addCriterion("is_approve not between", value1, value2, "isApprove");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisIsNull() {
            addCriterion("org_synopsis is null");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisIsNotNull() {
            addCriterion("org_synopsis is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisEqualTo(String value) {
            addCriterion("org_synopsis =", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisNotEqualTo(String value) {
            addCriterion("org_synopsis <>", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisGreaterThan(String value) {
            addCriterion("org_synopsis >", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("org_synopsis >=", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisLessThan(String value) {
            addCriterion("org_synopsis <", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisLessThanOrEqualTo(String value) {
            addCriterion("org_synopsis <=", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisLike(String value) {
            addCriterion("org_synopsis like", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisNotLike(String value) {
            addCriterion("org_synopsis not like", value, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisIn(List<String> values) {
            addCriterion("org_synopsis in", values, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisNotIn(List<String> values) {
            addCriterion("org_synopsis not in", values, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisBetween(String value1, String value2) {
            addCriterion("org_synopsis between", value1, value2, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgSynopsisNotBetween(String value1, String value2) {
            addCriterion("org_synopsis not between", value1, value2, "orgSynopsis");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessIsNull() {
            addCriterion("org_business is null");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessIsNotNull() {
            addCriterion("org_business is not null");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessEqualTo(String value) {
            addCriterion("org_business =", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessNotEqualTo(String value) {
            addCriterion("org_business <>", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessGreaterThan(String value) {
            addCriterion("org_business >", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("org_business >=", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessLessThan(String value) {
            addCriterion("org_business <", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessLessThanOrEqualTo(String value) {
            addCriterion("org_business <=", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessLike(String value) {
            addCriterion("org_business like", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessNotLike(String value) {
            addCriterion("org_business not like", value, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessIn(List<String> values) {
            addCriterion("org_business in", values, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessNotIn(List<String> values) {
            addCriterion("org_business not in", values, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessBetween(String value1, String value2) {
            addCriterion("org_business between", value1, value2, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgBusinessNotBetween(String value1, String value2) {
            addCriterion("org_business not between", value1, value2, "orgBusiness");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityIsNull() {
            addCriterion("org_speciality is null");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityIsNotNull() {
            addCriterion("org_speciality is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityEqualTo(String value) {
            addCriterion("org_speciality =", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityNotEqualTo(String value) {
            addCriterion("org_speciality <>", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityGreaterThan(String value) {
            addCriterion("org_speciality >", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("org_speciality >=", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityLessThan(String value) {
            addCriterion("org_speciality <", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityLessThanOrEqualTo(String value) {
            addCriterion("org_speciality <=", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityLike(String value) {
            addCriterion("org_speciality like", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityNotLike(String value) {
            addCriterion("org_speciality not like", value, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityIn(List<String> values) {
            addCriterion("org_speciality in", values, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityNotIn(List<String> values) {
            addCriterion("org_speciality not in", values, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityBetween(String value1, String value2) {
            addCriterion("org_speciality between", value1, value2, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgSpecialityNotBetween(String value1, String value2) {
            addCriterion("org_speciality not between", value1, value2, "orgSpeciality");
            return (Criteria) this;
        }

        public Criteria andOrgLogoIsNull() {
            addCriterion("org_logo is null");
            return (Criteria) this;
        }

        public Criteria andOrgLogoIsNotNull() {
            addCriterion("org_logo is not null");
            return (Criteria) this;
        }

        public Criteria andOrgLogoEqualTo(String value) {
            addCriterion("org_logo =", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoNotEqualTo(String value) {
            addCriterion("org_logo <>", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoGreaterThan(String value) {
            addCriterion("org_logo >", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoGreaterThanOrEqualTo(String value) {
            addCriterion("org_logo >=", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoLessThan(String value) {
            addCriterion("org_logo <", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoLessThanOrEqualTo(String value) {
            addCriterion("org_logo <=", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoLike(String value) {
            addCriterion("org_logo like", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoNotLike(String value) {
            addCriterion("org_logo not like", value, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoIn(List<String> values) {
            addCriterion("org_logo in", values, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoNotIn(List<String> values) {
            addCriterion("org_logo not in", values, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoBetween(String value1, String value2) {
            addCriterion("org_logo between", value1, value2, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgLogoNotBetween(String value1, String value2) {
            addCriterion("org_logo not between", value1, value2, "orgLogo");
            return (Criteria) this;
        }

        public Criteria andOrgShowIsNull() {
            addCriterion("org_show is null");
            return (Criteria) this;
        }

        public Criteria andOrgShowIsNotNull() {
            addCriterion("org_show is not null");
            return (Criteria) this;
        }

        public Criteria andOrgShowEqualTo(Integer value) {
            addCriterion("org_show =", value, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowNotEqualTo(Integer value) {
            addCriterion("org_show <>", value, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowGreaterThan(Integer value) {
            addCriterion("org_show >", value, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_show >=", value, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowLessThan(Integer value) {
            addCriterion("org_show <", value, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowLessThanOrEqualTo(Integer value) {
            addCriterion("org_show <=", value, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowIn(List<Integer> values) {
            addCriterion("org_show in", values, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowNotIn(List<Integer> values) {
            addCriterion("org_show not in", values, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowBetween(Integer value1, Integer value2) {
            addCriterion("org_show between", value1, value2, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgShowNotBetween(Integer value1, Integer value2) {
            addCriterion("org_show not between", value1, value2, "orgShow");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("org_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("org_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("org_type =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("org_type <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("org_type >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("org_type >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("org_type <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("org_type <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("org_type like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("org_type not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("org_type in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("org_type not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("org_type between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("org_type not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyIsNull() {
            addCriterion("org_hobby is null");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyIsNotNull() {
            addCriterion("org_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyEqualTo(String value) {
            addCriterion("org_hobby =", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyNotEqualTo(String value) {
            addCriterion("org_hobby <>", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyGreaterThan(String value) {
            addCriterion("org_hobby >", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("org_hobby >=", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyLessThan(String value) {
            addCriterion("org_hobby <", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyLessThanOrEqualTo(String value) {
            addCriterion("org_hobby <=", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyLike(String value) {
            addCriterion("org_hobby like", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyNotLike(String value) {
            addCriterion("org_hobby not like", value, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyIn(List<String> values) {
            addCriterion("org_hobby in", values, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyNotIn(List<String> values) {
            addCriterion("org_hobby not in", values, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyBetween(String value1, String value2) {
            addCriterion("org_hobby between", value1, value2, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgHobbyNotBetween(String value1, String value2) {
            addCriterion("org_hobby not between", value1, value2, "orgHobby");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNull() {
            addCriterion("org_status is null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNotNull() {
            addCriterion("org_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusEqualTo(String value) {
            addCriterion("org_status =", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotEqualTo(String value) {
            addCriterion("org_status <>", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThan(String value) {
            addCriterion("org_status >", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("org_status >=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThan(String value) {
            addCriterion("org_status <", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThanOrEqualTo(String value) {
            addCriterion("org_status <=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLike(String value) {
            addCriterion("org_status like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotLike(String value) {
            addCriterion("org_status not like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIn(List<String> values) {
            addCriterion("org_status in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotIn(List<String> values) {
            addCriterion("org_status not in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusBetween(String value1, String value2) {
            addCriterion("org_status between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotBetween(String value1, String value2) {
            addCriterion("org_status not between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeIsNull() {
            addCriterion("business_s_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeIsNotNull() {
            addCriterion("business_s_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeEqualTo(String value) {
            addCriterion("business_s_type =", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeNotEqualTo(String value) {
            addCriterion("business_s_type <>", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeGreaterThan(String value) {
            addCriterion("business_s_type >", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_s_type >=", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeLessThan(String value) {
            addCriterion("business_s_type <", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeLessThanOrEqualTo(String value) {
            addCriterion("business_s_type <=", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeLike(String value) {
            addCriterion("business_s_type like", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeNotLike(String value) {
            addCriterion("business_s_type not like", value, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeIn(List<String> values) {
            addCriterion("business_s_type in", values, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeNotIn(List<String> values) {
            addCriterion("business_s_type not in", values, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeBetween(String value1, String value2) {
            addCriterion("business_s_type between", value1, value2, "businessSType");
            return (Criteria) this;
        }

        public Criteria andBusinessSTypeNotBetween(String value1, String value2) {
            addCriterion("business_s_type not between", value1, value2, "businessSType");
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

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOperateStatusIsNull() {
            addCriterion("operate_status is null");
            return (Criteria) this;
        }

        public Criteria andOperateStatusIsNotNull() {
            addCriterion("operate_status is not null");
            return (Criteria) this;
        }

        public Criteria andOperateStatusEqualTo(String value) {
            addCriterion("operate_status =", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotEqualTo(String value) {
            addCriterion("operate_status <>", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusGreaterThan(String value) {
            addCriterion("operate_status >", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusGreaterThanOrEqualTo(String value) {
            addCriterion("operate_status >=", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusLessThan(String value) {
            addCriterion("operate_status <", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusLessThanOrEqualTo(String value) {
            addCriterion("operate_status <=", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusLike(String value) {
            addCriterion("operate_status like", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotLike(String value) {
            addCriterion("operate_status not like", value, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusIn(List<String> values) {
            addCriterion("operate_status in", values, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotIn(List<String> values) {
            addCriterion("operate_status not in", values, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusBetween(String value1, String value2) {
            addCriterion("operate_status between", value1, value2, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOperateStatusNotBetween(String value1, String value2) {
            addCriterion("operate_status not between", value1, value2, "operateStatus");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalIsNull() {
            addCriterion("org_principal is null");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalIsNotNull() {
            addCriterion("org_principal is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalEqualTo(String value) {
            addCriterion("org_principal =", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalNotEqualTo(String value) {
            addCriterion("org_principal <>", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalGreaterThan(String value) {
            addCriterion("org_principal >", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("org_principal >=", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalLessThan(String value) {
            addCriterion("org_principal <", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalLessThanOrEqualTo(String value) {
            addCriterion("org_principal <=", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalLike(String value) {
            addCriterion("org_principal like", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalNotLike(String value) {
            addCriterion("org_principal not like", value, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalIn(List<String> values) {
            addCriterion("org_principal in", values, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalNotIn(List<String> values) {
            addCriterion("org_principal not in", values, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalBetween(String value1, String value2) {
            addCriterion("org_principal between", value1, value2, "orgPrincipal");
            return (Criteria) this;
        }

        public Criteria andOrgPrincipalNotBetween(String value1, String value2) {
            addCriterion("org_principal not between", value1, value2, "orgPrincipal");
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