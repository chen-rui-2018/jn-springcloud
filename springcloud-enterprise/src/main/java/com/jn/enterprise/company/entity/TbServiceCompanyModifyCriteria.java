package com.jn.enterprise.company.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceCompanyModifyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceCompanyModifyCriteria() {
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(String value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(String value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(String value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(String value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(String value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(String value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLike(String value) {
            addCriterion("com_id like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotLike(String value) {
            addCriterion("com_id not like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<String> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<String> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(String value1, String value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(String value1, String value2) {
            addCriterion("com_id not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComNameIsNull() {
            addCriterion("com_name is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("com_name is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("com_name =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("com_name <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("com_name >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_name >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("com_name <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("com_name <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("com_name like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("com_name not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("com_name in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("com_name not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("com_name between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("com_name not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameShortIsNull() {
            addCriterion("com_name_short is null");
            return (Criteria) this;
        }

        public Criteria andComNameShortIsNotNull() {
            addCriterion("com_name_short is not null");
            return (Criteria) this;
        }

        public Criteria andComNameShortEqualTo(String value) {
            addCriterion("com_name_short =", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotEqualTo(String value) {
            addCriterion("com_name_short <>", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortGreaterThan(String value) {
            addCriterion("com_name_short >", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortGreaterThanOrEqualTo(String value) {
            addCriterion("com_name_short >=", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortLessThan(String value) {
            addCriterion("com_name_short <", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortLessThanOrEqualTo(String value) {
            addCriterion("com_name_short <=", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortLike(String value) {
            addCriterion("com_name_short like", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotLike(String value) {
            addCriterion("com_name_short not like", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortIn(List<String> values) {
            addCriterion("com_name_short in", values, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotIn(List<String> values) {
            addCriterion("com_name_short not in", values, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortBetween(String value1, String value2) {
            addCriterion("com_name_short between", value1, value2, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotBetween(String value1, String value2) {
            addCriterion("com_name_short not between", value1, value2, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeIsNull() {
            addCriterion("unify_code is null");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeIsNotNull() {
            addCriterion("unify_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeEqualTo(String value) {
            addCriterion("unify_code =", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeNotEqualTo(String value) {
            addCriterion("unify_code <>", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeGreaterThan(String value) {
            addCriterion("unify_code >", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unify_code >=", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeLessThan(String value) {
            addCriterion("unify_code <", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeLessThanOrEqualTo(String value) {
            addCriterion("unify_code <=", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeLike(String value) {
            addCriterion("unify_code like", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeNotLike(String value) {
            addCriterion("unify_code not like", value, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeIn(List<String> values) {
            addCriterion("unify_code in", values, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeNotIn(List<String> values) {
            addCriterion("unify_code not in", values, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeBetween(String value1, String value2) {
            addCriterion("unify_code between", value1, value2, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andUnifyCodeNotBetween(String value1, String value2) {
            addCriterion("unify_code not between", value1, value2, "unifyCode");
            return (Criteria) this;
        }

        public Criteria andOwnerLawIsNull() {
            addCriterion("owner_law is null");
            return (Criteria) this;
        }

        public Criteria andOwnerLawIsNotNull() {
            addCriterion("owner_law is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerLawEqualTo(String value) {
            addCriterion("owner_law =", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawNotEqualTo(String value) {
            addCriterion("owner_law <>", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawGreaterThan(String value) {
            addCriterion("owner_law >", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawGreaterThanOrEqualTo(String value) {
            addCriterion("owner_law >=", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawLessThan(String value) {
            addCriterion("owner_law <", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawLessThanOrEqualTo(String value) {
            addCriterion("owner_law <=", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawLike(String value) {
            addCriterion("owner_law like", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawNotLike(String value) {
            addCriterion("owner_law not like", value, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawIn(List<String> values) {
            addCriterion("owner_law in", values, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawNotIn(List<String> values) {
            addCriterion("owner_law not in", values, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawBetween(String value1, String value2) {
            addCriterion("owner_law between", value1, value2, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerLawNotBetween(String value1, String value2) {
            addCriterion("owner_law not between", value1, value2, "ownerLaw");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIsNull() {
            addCriterion("owner_phone is null");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIsNotNull() {
            addCriterion("owner_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneEqualTo(String value) {
            addCriterion("owner_phone =", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotEqualTo(String value) {
            addCriterion("owner_phone <>", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThan(String value) {
            addCriterion("owner_phone >", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("owner_phone >=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThan(String value) {
            addCriterion("owner_phone <", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThanOrEqualTo(String value) {
            addCriterion("owner_phone <=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLike(String value) {
            addCriterion("owner_phone like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotLike(String value) {
            addCriterion("owner_phone not like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIn(List<String> values) {
            addCriterion("owner_phone in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotIn(List<String> values) {
            addCriterion("owner_phone not in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneBetween(String value1, String value2) {
            addCriterion("owner_phone between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotBetween(String value1, String value2) {
            addCriterion("owner_phone not between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andComPropertyIsNull() {
            addCriterion("com_property is null");
            return (Criteria) this;
        }

        public Criteria andComPropertyIsNotNull() {
            addCriterion("com_property is not null");
            return (Criteria) this;
        }

        public Criteria andComPropertyEqualTo(String value) {
            addCriterion("com_property =", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyNotEqualTo(String value) {
            addCriterion("com_property <>", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyGreaterThan(String value) {
            addCriterion("com_property >", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("com_property >=", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyLessThan(String value) {
            addCriterion("com_property <", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyLessThanOrEqualTo(String value) {
            addCriterion("com_property <=", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyLike(String value) {
            addCriterion("com_property like", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyNotLike(String value) {
            addCriterion("com_property not like", value, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyIn(List<String> values) {
            addCriterion("com_property in", values, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyNotIn(List<String> values) {
            addCriterion("com_property not in", values, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyBetween(String value1, String value2) {
            addCriterion("com_property between", value1, value2, "comProperty");
            return (Criteria) this;
        }

        public Criteria andComPropertyNotBetween(String value1, String value2) {
            addCriterion("com_property not between", value1, value2, "comProperty");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIsNull() {
            addCriterion("reg_capital is null");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIsNotNull() {
            addCriterion("reg_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapitalEqualTo(Long value) {
            addCriterion("reg_capital =", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotEqualTo(Long value) {
            addCriterion("reg_capital <>", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThan(Long value) {
            addCriterion("reg_capital >", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThanOrEqualTo(Long value) {
            addCriterion("reg_capital >=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThan(Long value) {
            addCriterion("reg_capital <", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThanOrEqualTo(Long value) {
            addCriterion("reg_capital <=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIn(List<Long> values) {
            addCriterion("reg_capital in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotIn(List<Long> values) {
            addCriterion("reg_capital not in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalBetween(Long value1, Long value2) {
            addCriterion("reg_capital between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotBetween(Long value1, Long value2) {
            addCriterion("reg_capital not between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andComScaleIsNull() {
            addCriterion("com_scale is null");
            return (Criteria) this;
        }

        public Criteria andComScaleIsNotNull() {
            addCriterion("com_scale is not null");
            return (Criteria) this;
        }

        public Criteria andComScaleEqualTo(Long value) {
            addCriterion("com_scale =", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotEqualTo(Long value) {
            addCriterion("com_scale <>", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleGreaterThan(Long value) {
            addCriterion("com_scale >", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleGreaterThanOrEqualTo(Long value) {
            addCriterion("com_scale >=", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleLessThan(Long value) {
            addCriterion("com_scale <", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleLessThanOrEqualTo(Long value) {
            addCriterion("com_scale <=", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleIn(List<Long> values) {
            addCriterion("com_scale in", values, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotIn(List<Long> values) {
            addCriterion("com_scale not in", values, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleBetween(Long value1, Long value2) {
            addCriterion("com_scale between", value1, value2, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotBetween(Long value1, Long value2) {
            addCriterion("com_scale not between", value1, value2, "comScale");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeIsNull() {
            addCriterion("founding_time is null");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeIsNotNull() {
            addCriterion("founding_time is not null");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeEqualTo(Date value) {
            addCriterion("founding_time =", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeNotEqualTo(Date value) {
            addCriterion("founding_time <>", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeGreaterThan(Date value) {
            addCriterion("founding_time >", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("founding_time >=", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeLessThan(Date value) {
            addCriterion("founding_time <", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeLessThanOrEqualTo(Date value) {
            addCriterion("founding_time <=", value, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeIn(List<Date> values) {
            addCriterion("founding_time in", values, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeNotIn(List<Date> values) {
            addCriterion("founding_time not in", values, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeBetween(Date value1, Date value2) {
            addCriterion("founding_time between", value1, value2, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andFoundingTimeNotBetween(Date value1, Date value2) {
            addCriterion("founding_time not between", value1, value2, "foundingTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeIsNull() {
            addCriterion("run_time is null");
            return (Criteria) this;
        }

        public Criteria andRunTimeIsNotNull() {
            addCriterion("run_time is not null");
            return (Criteria) this;
        }

        public Criteria andRunTimeEqualTo(Date value) {
            addCriterion("run_time =", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeNotEqualTo(Date value) {
            addCriterion("run_time <>", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeGreaterThan(Date value) {
            addCriterion("run_time >", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("run_time >=", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeLessThan(Date value) {
            addCriterion("run_time <", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("run_time <=", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeIn(List<Date> values) {
            addCriterion("run_time in", values, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeNotIn(List<Date> values) {
            addCriterion("run_time not in", values, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeBetween(Date value1, Date value2) {
            addCriterion("run_time between", value1, value2, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("run_time not between", value1, value2, "runTime");
            return (Criteria) this;
        }

        public Criteria andInduTypeIsNull() {
            addCriterion("indu_type is null");
            return (Criteria) this;
        }

        public Criteria andInduTypeIsNotNull() {
            addCriterion("indu_type is not null");
            return (Criteria) this;
        }

        public Criteria andInduTypeEqualTo(String value) {
            addCriterion("indu_type =", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeNotEqualTo(String value) {
            addCriterion("indu_type <>", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeGreaterThan(String value) {
            addCriterion("indu_type >", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeGreaterThanOrEqualTo(String value) {
            addCriterion("indu_type >=", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeLessThan(String value) {
            addCriterion("indu_type <", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeLessThanOrEqualTo(String value) {
            addCriterion("indu_type <=", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeLike(String value) {
            addCriterion("indu_type like", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeNotLike(String value) {
            addCriterion("indu_type not like", value, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeIn(List<String> values) {
            addCriterion("indu_type in", values, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeNotIn(List<String> values) {
            addCriterion("indu_type not in", values, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeBetween(String value1, String value2) {
            addCriterion("indu_type between", value1, value2, "induType");
            return (Criteria) this;
        }

        public Criteria andInduTypeNotBetween(String value1, String value2) {
            addCriterion("indu_type not between", value1, value2, "induType");
            return (Criteria) this;
        }

        public Criteria andInduCodeIsNull() {
            addCriterion("indu_code is null");
            return (Criteria) this;
        }

        public Criteria andInduCodeIsNotNull() {
            addCriterion("indu_code is not null");
            return (Criteria) this;
        }

        public Criteria andInduCodeEqualTo(String value) {
            addCriterion("indu_code =", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeNotEqualTo(String value) {
            addCriterion("indu_code <>", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeGreaterThan(String value) {
            addCriterion("indu_code >", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeGreaterThanOrEqualTo(String value) {
            addCriterion("indu_code >=", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeLessThan(String value) {
            addCriterion("indu_code <", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeLessThanOrEqualTo(String value) {
            addCriterion("indu_code <=", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeLike(String value) {
            addCriterion("indu_code like", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeNotLike(String value) {
            addCriterion("indu_code not like", value, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeIn(List<String> values) {
            addCriterion("indu_code in", values, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeNotIn(List<String> values) {
            addCriterion("indu_code not in", values, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeBetween(String value1, String value2) {
            addCriterion("indu_code between", value1, value2, "induCode");
            return (Criteria) this;
        }

        public Criteria andInduCodeNotBetween(String value1, String value2) {
            addCriterion("indu_code not between", value1, value2, "induCode");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureIsNull() {
            addCriterion("propaganda_picture is null");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureIsNotNull() {
            addCriterion("propaganda_picture is not null");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureEqualTo(String value) {
            addCriterion("propaganda_picture =", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureNotEqualTo(String value) {
            addCriterion("propaganda_picture <>", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureGreaterThan(String value) {
            addCriterion("propaganda_picture >", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureGreaterThanOrEqualTo(String value) {
            addCriterion("propaganda_picture >=", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureLessThan(String value) {
            addCriterion("propaganda_picture <", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureLessThanOrEqualTo(String value) {
            addCriterion("propaganda_picture <=", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureLike(String value) {
            addCriterion("propaganda_picture like", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureNotLike(String value) {
            addCriterion("propaganda_picture not like", value, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureIn(List<String> values) {
            addCriterion("propaganda_picture in", values, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureNotIn(List<String> values) {
            addCriterion("propaganda_picture not in", values, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureBetween(String value1, String value2) {
            addCriterion("propaganda_picture between", value1, value2, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andPropagandaPictureNotBetween(String value1, String value2) {
            addCriterion("propaganda_picture not between", value1, value2, "propagandaPicture");
            return (Criteria) this;
        }

        public Criteria andMainProductsIsNull() {
            addCriterion("main_products is null");
            return (Criteria) this;
        }

        public Criteria andMainProductsIsNotNull() {
            addCriterion("main_products is not null");
            return (Criteria) this;
        }

        public Criteria andMainProductsEqualTo(String value) {
            addCriterion("main_products =", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotEqualTo(String value) {
            addCriterion("main_products <>", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsGreaterThan(String value) {
            addCriterion("main_products >", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsGreaterThanOrEqualTo(String value) {
            addCriterion("main_products >=", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsLessThan(String value) {
            addCriterion("main_products <", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsLessThanOrEqualTo(String value) {
            addCriterion("main_products <=", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsLike(String value) {
            addCriterion("main_products like", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotLike(String value) {
            addCriterion("main_products not like", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsIn(List<String> values) {
            addCriterion("main_products in", values, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotIn(List<String> values) {
            addCriterion("main_products not in", values, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsBetween(String value1, String value2) {
            addCriterion("main_products between", value1, value2, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotBetween(String value1, String value2) {
            addCriterion("main_products not between", value1, value2, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNull() {
            addCriterion("com_address is null");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNotNull() {
            addCriterion("com_address is not null");
            return (Criteria) this;
        }

        public Criteria andComAddressEqualTo(String value) {
            addCriterion("com_address =", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotEqualTo(String value) {
            addCriterion("com_address <>", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThan(String value) {
            addCriterion("com_address >", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThanOrEqualTo(String value) {
            addCriterion("com_address >=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThan(String value) {
            addCriterion("com_address <", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThanOrEqualTo(String value) {
            addCriterion("com_address <=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLike(String value) {
            addCriterion("com_address like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotLike(String value) {
            addCriterion("com_address not like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressIn(List<String> values) {
            addCriterion("com_address in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotIn(List<String> values) {
            addCriterion("com_address not in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressBetween(String value1, String value2) {
            addCriterion("com_address between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotBetween(String value1, String value2) {
            addCriterion("com_address not between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComTeleIsNull() {
            addCriterion("com_tele is null");
            return (Criteria) this;
        }

        public Criteria andComTeleIsNotNull() {
            addCriterion("com_tele is not null");
            return (Criteria) this;
        }

        public Criteria andComTeleEqualTo(String value) {
            addCriterion("com_tele =", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleNotEqualTo(String value) {
            addCriterion("com_tele <>", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleGreaterThan(String value) {
            addCriterion("com_tele >", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleGreaterThanOrEqualTo(String value) {
            addCriterion("com_tele >=", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleLessThan(String value) {
            addCriterion("com_tele <", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleLessThanOrEqualTo(String value) {
            addCriterion("com_tele <=", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleLike(String value) {
            addCriterion("com_tele like", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleNotLike(String value) {
            addCriterion("com_tele not like", value, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleIn(List<String> values) {
            addCriterion("com_tele in", values, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleNotIn(List<String> values) {
            addCriterion("com_tele not in", values, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleBetween(String value1, String value2) {
            addCriterion("com_tele between", value1, value2, "comTele");
            return (Criteria) this;
        }

        public Criteria andComTeleNotBetween(String value1, String value2) {
            addCriterion("com_tele not between", value1, value2, "comTele");
            return (Criteria) this;
        }

        public Criteria andComWebIsNull() {
            addCriterion("com_web is null");
            return (Criteria) this;
        }

        public Criteria andComWebIsNotNull() {
            addCriterion("com_web is not null");
            return (Criteria) this;
        }

        public Criteria andComWebEqualTo(String value) {
            addCriterion("com_web =", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebNotEqualTo(String value) {
            addCriterion("com_web <>", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebGreaterThan(String value) {
            addCriterion("com_web >", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebGreaterThanOrEqualTo(String value) {
            addCriterion("com_web >=", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebLessThan(String value) {
            addCriterion("com_web <", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebLessThanOrEqualTo(String value) {
            addCriterion("com_web <=", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebLike(String value) {
            addCriterion("com_web like", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebNotLike(String value) {
            addCriterion("com_web not like", value, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebIn(List<String> values) {
            addCriterion("com_web in", values, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebNotIn(List<String> values) {
            addCriterion("com_web not in", values, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebBetween(String value1, String value2) {
            addCriterion("com_web between", value1, value2, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComWebNotBetween(String value1, String value2) {
            addCriterion("com_web not between", value1, value2, "comWeb");
            return (Criteria) this;
        }

        public Criteria andComServerIsNull() {
            addCriterion("com_server is null");
            return (Criteria) this;
        }

        public Criteria andComServerIsNotNull() {
            addCriterion("com_server is not null");
            return (Criteria) this;
        }

        public Criteria andComServerEqualTo(String value) {
            addCriterion("com_server =", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerNotEqualTo(String value) {
            addCriterion("com_server <>", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerGreaterThan(String value) {
            addCriterion("com_server >", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerGreaterThanOrEqualTo(String value) {
            addCriterion("com_server >=", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerLessThan(String value) {
            addCriterion("com_server <", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerLessThanOrEqualTo(String value) {
            addCriterion("com_server <=", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerLike(String value) {
            addCriterion("com_server like", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerNotLike(String value) {
            addCriterion("com_server not like", value, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerIn(List<String> values) {
            addCriterion("com_server in", values, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerNotIn(List<String> values) {
            addCriterion("com_server not in", values, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerBetween(String value1, String value2) {
            addCriterion("com_server between", value1, value2, "comServer");
            return (Criteria) this;
        }

        public Criteria andComServerNotBetween(String value1, String value2) {
            addCriterion("com_server not between", value1, value2, "comServer");
            return (Criteria) this;
        }

        public Criteria andComDemandIsNull() {
            addCriterion("com_demand is null");
            return (Criteria) this;
        }

        public Criteria andComDemandIsNotNull() {
            addCriterion("com_demand is not null");
            return (Criteria) this;
        }

        public Criteria andComDemandEqualTo(String value) {
            addCriterion("com_demand =", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandNotEqualTo(String value) {
            addCriterion("com_demand <>", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandGreaterThan(String value) {
            addCriterion("com_demand >", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandGreaterThanOrEqualTo(String value) {
            addCriterion("com_demand >=", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandLessThan(String value) {
            addCriterion("com_demand <", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandLessThanOrEqualTo(String value) {
            addCriterion("com_demand <=", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandLike(String value) {
            addCriterion("com_demand like", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandNotLike(String value) {
            addCriterion("com_demand not like", value, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandIn(List<String> values) {
            addCriterion("com_demand in", values, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandNotIn(List<String> values) {
            addCriterion("com_demand not in", values, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandBetween(String value1, String value2) {
            addCriterion("com_demand between", value1, value2, "comDemand");
            return (Criteria) this;
        }

        public Criteria andComDemandNotBetween(String value1, String value2) {
            addCriterion("com_demand not between", value1, value2, "comDemand");
            return (Criteria) this;
        }

        public Criteria andAddrParkIsNull() {
            addCriterion("addr_park is null");
            return (Criteria) this;
        }

        public Criteria andAddrParkIsNotNull() {
            addCriterion("addr_park is not null");
            return (Criteria) this;
        }

        public Criteria andAddrParkEqualTo(String value) {
            addCriterion("addr_park =", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkNotEqualTo(String value) {
            addCriterion("addr_park <>", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkGreaterThan(String value) {
            addCriterion("addr_park >", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkGreaterThanOrEqualTo(String value) {
            addCriterion("addr_park >=", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkLessThan(String value) {
            addCriterion("addr_park <", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkLessThanOrEqualTo(String value) {
            addCriterion("addr_park <=", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkLike(String value) {
            addCriterion("addr_park like", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkNotLike(String value) {
            addCriterion("addr_park not like", value, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkIn(List<String> values) {
            addCriterion("addr_park in", values, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkNotIn(List<String> values) {
            addCriterion("addr_park not in", values, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkBetween(String value1, String value2) {
            addCriterion("addr_park between", value1, value2, "addrPark");
            return (Criteria) this;
        }

        public Criteria andAddrParkNotBetween(String value1, String value2) {
            addCriterion("addr_park not between", value1, value2, "addrPark");
            return (Criteria) this;
        }

        public Criteria andComSynopsisIsNull() {
            addCriterion("com_synopsis is null");
            return (Criteria) this;
        }

        public Criteria andComSynopsisIsNotNull() {
            addCriterion("com_synopsis is not null");
            return (Criteria) this;
        }

        public Criteria andComSynopsisEqualTo(String value) {
            addCriterion("com_synopsis =", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisNotEqualTo(String value) {
            addCriterion("com_synopsis <>", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisGreaterThan(String value) {
            addCriterion("com_synopsis >", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("com_synopsis >=", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisLessThan(String value) {
            addCriterion("com_synopsis <", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisLessThanOrEqualTo(String value) {
            addCriterion("com_synopsis <=", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisLike(String value) {
            addCriterion("com_synopsis like", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisNotLike(String value) {
            addCriterion("com_synopsis not like", value, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisIn(List<String> values) {
            addCriterion("com_synopsis in", values, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisNotIn(List<String> values) {
            addCriterion("com_synopsis not in", values, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisBetween(String value1, String value2) {
            addCriterion("com_synopsis between", value1, value2, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andComSynopsisNotBetween(String value1, String value2) {
            addCriterion("com_synopsis not between", value1, value2, "comSynopsis");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("check_status like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("check_status not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
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

        public Criteria andComSourceIsNull() {
            addCriterion("com_source is null");
            return (Criteria) this;
        }

        public Criteria andComSourceIsNotNull() {
            addCriterion("com_source is not null");
            return (Criteria) this;
        }

        public Criteria andComSourceEqualTo(String value) {
            addCriterion("com_source =", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceNotEqualTo(String value) {
            addCriterion("com_source <>", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceGreaterThan(String value) {
            addCriterion("com_source >", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceGreaterThanOrEqualTo(String value) {
            addCriterion("com_source >=", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceLessThan(String value) {
            addCriterion("com_source <", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceLessThanOrEqualTo(String value) {
            addCriterion("com_source <=", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceLike(String value) {
            addCriterion("com_source like", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceNotLike(String value) {
            addCriterion("com_source not like", value, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceIn(List<String> values) {
            addCriterion("com_source in", values, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceNotIn(List<String> values) {
            addCriterion("com_source not in", values, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceBetween(String value1, String value2) {
            addCriterion("com_source between", value1, value2, "comSource");
            return (Criteria) this;
        }

        public Criteria andComSourceNotBetween(String value1, String value2) {
            addCriterion("com_source not between", value1, value2, "comSource");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkIsNull() {
            addCriterion("affiliated_park is null");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkIsNotNull() {
            addCriterion("affiliated_park is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkEqualTo(String value) {
            addCriterion("affiliated_park =", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkNotEqualTo(String value) {
            addCriterion("affiliated_park <>", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkGreaterThan(String value) {
            addCriterion("affiliated_park >", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkGreaterThanOrEqualTo(String value) {
            addCriterion("affiliated_park >=", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkLessThan(String value) {
            addCriterion("affiliated_park <", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkLessThanOrEqualTo(String value) {
            addCriterion("affiliated_park <=", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkLike(String value) {
            addCriterion("affiliated_park like", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkNotLike(String value) {
            addCriterion("affiliated_park not like", value, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkIn(List<String> values) {
            addCriterion("affiliated_park in", values, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkNotIn(List<String> values) {
            addCriterion("affiliated_park not in", values, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkBetween(String value1, String value2) {
            addCriterion("affiliated_park between", value1, value2, "affiliatedPark");
            return (Criteria) this;
        }

        public Criteria andAffiliatedParkNotBetween(String value1, String value2) {
            addCriterion("affiliated_park not between", value1, value2, "affiliatedPark");
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