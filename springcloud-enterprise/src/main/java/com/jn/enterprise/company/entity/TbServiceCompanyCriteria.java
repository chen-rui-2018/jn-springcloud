package com.jn.enterprise.company.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbServiceCompanyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbServiceCompanyCriteria() {
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

        public Criteria andComAdminIsNull() {
            addCriterion("com_admin is null");
            return (Criteria) this;
        }

        public Criteria andComAdminIsNotNull() {
            addCriterion("com_admin is not null");
            return (Criteria) this;
        }

        public Criteria andComAdminEqualTo(String value) {
            addCriterion("com_admin =", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotEqualTo(String value) {
            addCriterion("com_admin <>", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminGreaterThan(String value) {
            addCriterion("com_admin >", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminGreaterThanOrEqualTo(String value) {
            addCriterion("com_admin >=", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminLessThan(String value) {
            addCriterion("com_admin <", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminLessThanOrEqualTo(String value) {
            addCriterion("com_admin <=", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminLike(String value) {
            addCriterion("com_admin like", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotLike(String value) {
            addCriterion("com_admin not like", value, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminIn(List<String> values) {
            addCriterion("com_admin in", values, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotIn(List<String> values) {
            addCriterion("com_admin not in", values, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminBetween(String value1, String value2) {
            addCriterion("com_admin between", value1, value2, "comAdmin");
            return (Criteria) this;
        }

        public Criteria andComAdminNotBetween(String value1, String value2) {
            addCriterion("com_admin not between", value1, value2, "comAdmin");
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

        public Criteria andOwnersIsNull() {
            addCriterion("owners is null");
            return (Criteria) this;
        }

        public Criteria andOwnersIsNotNull() {
            addCriterion("owners is not null");
            return (Criteria) this;
        }

        public Criteria andOwnersEqualTo(String value) {
            addCriterion("owners =", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersNotEqualTo(String value) {
            addCriterion("owners <>", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersGreaterThan(String value) {
            addCriterion("owners >", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersGreaterThanOrEqualTo(String value) {
            addCriterion("owners >=", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersLessThan(String value) {
            addCriterion("owners <", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersLessThanOrEqualTo(String value) {
            addCriterion("owners <=", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersLike(String value) {
            addCriterion("owners like", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersNotLike(String value) {
            addCriterion("owners not like", value, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersIn(List<String> values) {
            addCriterion("owners in", values, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersNotIn(List<String> values) {
            addCriterion("owners not in", values, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersBetween(String value1, String value2) {
            addCriterion("owners between", value1, value2, "owners");
            return (Criteria) this;
        }

        public Criteria andOwnersNotBetween(String value1, String value2) {
            addCriterion("owners not between", value1, value2, "owners");
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

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("owner_id like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("owner_id not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
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

        public Criteria andOwnerWechatIsNull() {
            addCriterion("owner_wechat is null");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatIsNotNull() {
            addCriterion("owner_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatEqualTo(String value) {
            addCriterion("owner_wechat =", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatNotEqualTo(String value) {
            addCriterion("owner_wechat <>", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatGreaterThan(String value) {
            addCriterion("owner_wechat >", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatGreaterThanOrEqualTo(String value) {
            addCriterion("owner_wechat >=", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatLessThan(String value) {
            addCriterion("owner_wechat <", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatLessThanOrEqualTo(String value) {
            addCriterion("owner_wechat <=", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatLike(String value) {
            addCriterion("owner_wechat like", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatNotLike(String value) {
            addCriterion("owner_wechat not like", value, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatIn(List<String> values) {
            addCriterion("owner_wechat in", values, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatNotIn(List<String> values) {
            addCriterion("owner_wechat not in", values, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatBetween(String value1, String value2) {
            addCriterion("owner_wechat between", value1, value2, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerWechatNotBetween(String value1, String value2) {
            addCriterion("owner_wechat not between", value1, value2, "ownerWechat");
            return (Criteria) this;
        }

        public Criteria andOwnerQqIsNull() {
            addCriterion("owner_qq is null");
            return (Criteria) this;
        }

        public Criteria andOwnerQqIsNotNull() {
            addCriterion("owner_qq is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerQqEqualTo(String value) {
            addCriterion("owner_qq =", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqNotEqualTo(String value) {
            addCriterion("owner_qq <>", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqGreaterThan(String value) {
            addCriterion("owner_qq >", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqGreaterThanOrEqualTo(String value) {
            addCriterion("owner_qq >=", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqLessThan(String value) {
            addCriterion("owner_qq <", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqLessThanOrEqualTo(String value) {
            addCriterion("owner_qq <=", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqLike(String value) {
            addCriterion("owner_qq like", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqNotLike(String value) {
            addCriterion("owner_qq not like", value, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqIn(List<String> values) {
            addCriterion("owner_qq in", values, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqNotIn(List<String> values) {
            addCriterion("owner_qq not in", values, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqBetween(String value1, String value2) {
            addCriterion("owner_qq between", value1, value2, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andOwnerQqNotBetween(String value1, String value2) {
            addCriterion("owner_qq not between", value1, value2, "ownerQq");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andProductsIsNull() {
            addCriterion("products is null");
            return (Criteria) this;
        }

        public Criteria andProductsIsNotNull() {
            addCriterion("products is not null");
            return (Criteria) this;
        }

        public Criteria andProductsEqualTo(String value) {
            addCriterion("products =", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsNotEqualTo(String value) {
            addCriterion("products <>", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsGreaterThan(String value) {
            addCriterion("products >", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsGreaterThanOrEqualTo(String value) {
            addCriterion("products >=", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsLessThan(String value) {
            addCriterion("products <", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsLessThanOrEqualTo(String value) {
            addCriterion("products <=", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsLike(String value) {
            addCriterion("products like", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsNotLike(String value) {
            addCriterion("products not like", value, "products");
            return (Criteria) this;
        }

        public Criteria andProductsIn(List<String> values) {
            addCriterion("products in", values, "products");
            return (Criteria) this;
        }

        public Criteria andProductsNotIn(List<String> values) {
            addCriterion("products not in", values, "products");
            return (Criteria) this;
        }

        public Criteria andProductsBetween(String value1, String value2) {
            addCriterion("products between", value1, value2, "products");
            return (Criteria) this;
        }

        public Criteria andProductsNotBetween(String value1, String value2) {
            addCriterion("products not between", value1, value2, "products");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
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

        public Criteria andRegCapitalEqualTo(BigDecimal value) {
            addCriterion("reg_capital =", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotEqualTo(BigDecimal value) {
            addCriterion("reg_capital <>", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThan(BigDecimal value) {
            addCriterion("reg_capital >", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reg_capital >=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThan(BigDecimal value) {
            addCriterion("reg_capital <", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reg_capital <=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIn(List<BigDecimal> values) {
            addCriterion("reg_capital in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotIn(List<BigDecimal> values) {
            addCriterion("reg_capital not in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reg_capital between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reg_capital not between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalIsNull() {
            addCriterion("add_capital is null");
            return (Criteria) this;
        }

        public Criteria andAddCapitalIsNotNull() {
            addCriterion("add_capital is not null");
            return (Criteria) this;
        }

        public Criteria andAddCapitalEqualTo(String value) {
            addCriterion("add_capital =", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalNotEqualTo(String value) {
            addCriterion("add_capital <>", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalGreaterThan(String value) {
            addCriterion("add_capital >", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("add_capital >=", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalLessThan(String value) {
            addCriterion("add_capital <", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalLessThanOrEqualTo(String value) {
            addCriterion("add_capital <=", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalLike(String value) {
            addCriterion("add_capital like", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalNotLike(String value) {
            addCriterion("add_capital not like", value, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalIn(List<String> values) {
            addCriterion("add_capital in", values, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalNotIn(List<String> values) {
            addCriterion("add_capital not in", values, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalBetween(String value1, String value2) {
            addCriterion("add_capital between", value1, value2, "addCapital");
            return (Criteria) this;
        }

        public Criteria andAddCapitalNotBetween(String value1, String value2) {
            addCriterion("add_capital not between", value1, value2, "addCapital");
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

        public Criteria andComScaleEqualTo(String value) {
            addCriterion("com_scale =", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotEqualTo(String value) {
            addCriterion("com_scale <>", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleGreaterThan(String value) {
            addCriterion("com_scale >", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleGreaterThanOrEqualTo(String value) {
            addCriterion("com_scale >=", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleLessThan(String value) {
            addCriterion("com_scale <", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleLessThanOrEqualTo(String value) {
            addCriterion("com_scale <=", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleLike(String value) {
            addCriterion("com_scale like", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotLike(String value) {
            addCriterion("com_scale not like", value, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleIn(List<String> values) {
            addCriterion("com_scale in", values, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotIn(List<String> values) {
            addCriterion("com_scale not in", values, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleBetween(String value1, String value2) {
            addCriterion("com_scale between", value1, value2, "comScale");
            return (Criteria) this;
        }

        public Criteria andComScaleNotBetween(String value1, String value2) {
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

        public Criteria andLicStarttimeIsNull() {
            addCriterion("lic_starttime is null");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeIsNotNull() {
            addCriterion("lic_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeEqualTo(Date value) {
            addCriterion("lic_starttime =", value, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeNotEqualTo(Date value) {
            addCriterion("lic_starttime <>", value, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeGreaterThan(Date value) {
            addCriterion("lic_starttime >", value, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lic_starttime >=", value, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeLessThan(Date value) {
            addCriterion("lic_starttime <", value, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("lic_starttime <=", value, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeIn(List<Date> values) {
            addCriterion("lic_starttime in", values, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeNotIn(List<Date> values) {
            addCriterion("lic_starttime not in", values, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeBetween(Date value1, Date value2) {
            addCriterion("lic_starttime between", value1, value2, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("lic_starttime not between", value1, value2, "licStarttime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeIsNull() {
            addCriterion("lic_endtime is null");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeIsNotNull() {
            addCriterion("lic_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeEqualTo(Date value) {
            addCriterion("lic_endtime =", value, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeNotEqualTo(Date value) {
            addCriterion("lic_endtime <>", value, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeGreaterThan(Date value) {
            addCriterion("lic_endtime >", value, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lic_endtime >=", value, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeLessThan(Date value) {
            addCriterion("lic_endtime <", value, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("lic_endtime <=", value, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeIn(List<Date> values) {
            addCriterion("lic_endtime in", values, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeNotIn(List<Date> values) {
            addCriterion("lic_endtime not in", values, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeBetween(Date value1, Date value2) {
            addCriterion("lic_endtime between", value1, value2, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andLicEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("lic_endtime not between", value1, value2, "licEndtime");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIsNull() {
            addCriterion("register_type is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIsNotNull() {
            addCriterion("register_type is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeEqualTo(String value) {
            addCriterion("register_type =", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotEqualTo(String value) {
            addCriterion("register_type <>", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeGreaterThan(String value) {
            addCriterion("register_type >", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("register_type >=", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLessThan(String value) {
            addCriterion("register_type <", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLessThanOrEqualTo(String value) {
            addCriterion("register_type <=", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLike(String value) {
            addCriterion("register_type like", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotLike(String value) {
            addCriterion("register_type not like", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIn(List<String> values) {
            addCriterion("register_type in", values, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotIn(List<String> values) {
            addCriterion("register_type not in", values, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeBetween(String value1, String value2) {
            addCriterion("register_type between", value1, value2, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotBetween(String value1, String value2) {
            addCriterion("register_type not between", value1, value2, "registerType");
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

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andConPhoneIsNull() {
            addCriterion("con_phone is null");
            return (Criteria) this;
        }

        public Criteria andConPhoneIsNotNull() {
            addCriterion("con_phone is not null");
            return (Criteria) this;
        }

        public Criteria andConPhoneEqualTo(String value) {
            addCriterion("con_phone =", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotEqualTo(String value) {
            addCriterion("con_phone <>", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneGreaterThan(String value) {
            addCriterion("con_phone >", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("con_phone >=", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneLessThan(String value) {
            addCriterion("con_phone <", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneLessThanOrEqualTo(String value) {
            addCriterion("con_phone <=", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneLike(String value) {
            addCriterion("con_phone like", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotLike(String value) {
            addCriterion("con_phone not like", value, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneIn(List<String> values) {
            addCriterion("con_phone in", values, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotIn(List<String> values) {
            addCriterion("con_phone not in", values, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneBetween(String value1, String value2) {
            addCriterion("con_phone between", value1, value2, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConPhoneNotBetween(String value1, String value2) {
            addCriterion("con_phone not between", value1, value2, "conPhone");
            return (Criteria) this;
        }

        public Criteria andConWechatIsNull() {
            addCriterion("con_wechat is null");
            return (Criteria) this;
        }

        public Criteria andConWechatIsNotNull() {
            addCriterion("con_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andConWechatEqualTo(String value) {
            addCriterion("con_wechat =", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotEqualTo(String value) {
            addCriterion("con_wechat <>", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatGreaterThan(String value) {
            addCriterion("con_wechat >", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatGreaterThanOrEqualTo(String value) {
            addCriterion("con_wechat >=", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatLessThan(String value) {
            addCriterion("con_wechat <", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatLessThanOrEqualTo(String value) {
            addCriterion("con_wechat <=", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatLike(String value) {
            addCriterion("con_wechat like", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotLike(String value) {
            addCriterion("con_wechat not like", value, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatIn(List<String> values) {
            addCriterion("con_wechat in", values, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotIn(List<String> values) {
            addCriterion("con_wechat not in", values, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatBetween(String value1, String value2) {
            addCriterion("con_wechat between", value1, value2, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConWechatNotBetween(String value1, String value2) {
            addCriterion("con_wechat not between", value1, value2, "conWechat");
            return (Criteria) this;
        }

        public Criteria andConQqIsNull() {
            addCriterion("con_qq is null");
            return (Criteria) this;
        }

        public Criteria andConQqIsNotNull() {
            addCriterion("con_qq is not null");
            return (Criteria) this;
        }

        public Criteria andConQqEqualTo(String value) {
            addCriterion("con_qq =", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotEqualTo(String value) {
            addCriterion("con_qq <>", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqGreaterThan(String value) {
            addCriterion("con_qq >", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqGreaterThanOrEqualTo(String value) {
            addCriterion("con_qq >=", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqLessThan(String value) {
            addCriterion("con_qq <", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqLessThanOrEqualTo(String value) {
            addCriterion("con_qq <=", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqLike(String value) {
            addCriterion("con_qq like", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotLike(String value) {
            addCriterion("con_qq not like", value, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqIn(List<String> values) {
            addCriterion("con_qq in", values, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotIn(List<String> values) {
            addCriterion("con_qq not in", values, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqBetween(String value1, String value2) {
            addCriterion("con_qq between", value1, value2, "conQq");
            return (Criteria) this;
        }

        public Criteria andConQqNotBetween(String value1, String value2) {
            addCriterion("con_qq not between", value1, value2, "conQq");
            return (Criteria) this;
        }

        public Criteria andConAddressIsNull() {
            addCriterion("con_address is null");
            return (Criteria) this;
        }

        public Criteria andConAddressIsNotNull() {
            addCriterion("con_address is not null");
            return (Criteria) this;
        }

        public Criteria andConAddressEqualTo(String value) {
            addCriterion("con_address =", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressNotEqualTo(String value) {
            addCriterion("con_address <>", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressGreaterThan(String value) {
            addCriterion("con_address >", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressGreaterThanOrEqualTo(String value) {
            addCriterion("con_address >=", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressLessThan(String value) {
            addCriterion("con_address <", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressLessThanOrEqualTo(String value) {
            addCriterion("con_address <=", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressLike(String value) {
            addCriterion("con_address like", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressNotLike(String value) {
            addCriterion("con_address not like", value, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressIn(List<String> values) {
            addCriterion("con_address in", values, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressNotIn(List<String> values) {
            addCriterion("con_address not in", values, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressBetween(String value1, String value2) {
            addCriterion("con_address between", value1, value2, "conAddress");
            return (Criteria) this;
        }

        public Criteria andConAddressNotBetween(String value1, String value2) {
            addCriterion("con_address not between", value1, value2, "conAddress");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
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

        public Criteria andParkBuildIdIsNull() {
            addCriterion("park_build_id is null");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdIsNotNull() {
            addCriterion("park_build_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdEqualTo(String value) {
            addCriterion("park_build_id =", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdNotEqualTo(String value) {
            addCriterion("park_build_id <>", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdGreaterThan(String value) {
            addCriterion("park_build_id >", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdGreaterThanOrEqualTo(String value) {
            addCriterion("park_build_id >=", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdLessThan(String value) {
            addCriterion("park_build_id <", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdLessThanOrEqualTo(String value) {
            addCriterion("park_build_id <=", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdLike(String value) {
            addCriterion("park_build_id like", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdNotLike(String value) {
            addCriterion("park_build_id not like", value, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdIn(List<String> values) {
            addCriterion("park_build_id in", values, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdNotIn(List<String> values) {
            addCriterion("park_build_id not in", values, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdBetween(String value1, String value2) {
            addCriterion("park_build_id between", value1, value2, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildIdNotBetween(String value1, String value2) {
            addCriterion("park_build_id not between", value1, value2, "parkBuildId");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameIsNull() {
            addCriterion("park_build_name is null");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameIsNotNull() {
            addCriterion("park_build_name is not null");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameEqualTo(String value) {
            addCriterion("park_build_name =", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameNotEqualTo(String value) {
            addCriterion("park_build_name <>", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameGreaterThan(String value) {
            addCriterion("park_build_name >", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameGreaterThanOrEqualTo(String value) {
            addCriterion("park_build_name >=", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameLessThan(String value) {
            addCriterion("park_build_name <", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameLessThanOrEqualTo(String value) {
            addCriterion("park_build_name <=", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameLike(String value) {
            addCriterion("park_build_name like", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameNotLike(String value) {
            addCriterion("park_build_name not like", value, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameIn(List<String> values) {
            addCriterion("park_build_name in", values, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameNotIn(List<String> values) {
            addCriterion("park_build_name not in", values, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameBetween(String value1, String value2) {
            addCriterion("park_build_name between", value1, value2, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andParkBuildNameNotBetween(String value1, String value2) {
            addCriterion("park_build_name not between", value1, value2, "parkBuildName");
            return (Criteria) this;
        }

        public Criteria andCreditPointsIsNull() {
            addCriterion("credit_points is null");
            return (Criteria) this;
        }

        public Criteria andCreditPointsIsNotNull() {
            addCriterion("credit_points is not null");
            return (Criteria) this;
        }

        public Criteria andCreditPointsEqualTo(BigDecimal value) {
            addCriterion("credit_points =", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsNotEqualTo(BigDecimal value) {
            addCriterion("credit_points <>", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsGreaterThan(BigDecimal value) {
            addCriterion("credit_points >", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_points >=", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsLessThan(BigDecimal value) {
            addCriterion("credit_points <", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_points <=", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsIn(List<BigDecimal> values) {
            addCriterion("credit_points in", values, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsNotIn(List<BigDecimal> values) {
            addCriterion("credit_points not in", values, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_points between", value1, value2, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_points not between", value1, value2, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeIsNull() {
            addCriterion("credit_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeIsNotNull() {
            addCriterion("credit_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeEqualTo(Date value) {
            addCriterion("credit_update_time =", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeNotEqualTo(Date value) {
            addCriterion("credit_update_time <>", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeGreaterThan(Date value) {
            addCriterion("credit_update_time >", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("credit_update_time >=", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeLessThan(Date value) {
            addCriterion("credit_update_time <", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("credit_update_time <=", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeIn(List<Date> values) {
            addCriterion("credit_update_time in", values, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeNotIn(List<Date> values) {
            addCriterion("credit_update_time not in", values, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("credit_update_time between", value1, value2, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("credit_update_time not between", value1, value2, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNull() {
            addCriterion("com_type is null");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNotNull() {
            addCriterion("com_type is not null");
            return (Criteria) this;
        }

        public Criteria andComTypeEqualTo(String value) {
            addCriterion("com_type =", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotEqualTo(String value) {
            addCriterion("com_type <>", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThan(String value) {
            addCriterion("com_type >", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThanOrEqualTo(String value) {
            addCriterion("com_type >=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThan(String value) {
            addCriterion("com_type <", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThanOrEqualTo(String value) {
            addCriterion("com_type <=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLike(String value) {
            addCriterion("com_type like", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotLike(String value) {
            addCriterion("com_type not like", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeIn(List<String> values) {
            addCriterion("com_type in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotIn(List<String> values) {
            addCriterion("com_type not in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeBetween(String value1, String value2) {
            addCriterion("com_type between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotBetween(String value1, String value2) {
            addCriterion("com_type not between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityIsNull() {
            addCriterion("is_join_activity is null");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityIsNotNull() {
            addCriterion("is_join_activity is not null");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityEqualTo(String value) {
            addCriterion("is_join_activity =", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityNotEqualTo(String value) {
            addCriterion("is_join_activity <>", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityGreaterThan(String value) {
            addCriterion("is_join_activity >", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityGreaterThanOrEqualTo(String value) {
            addCriterion("is_join_activity >=", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityLessThan(String value) {
            addCriterion("is_join_activity <", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityLessThanOrEqualTo(String value) {
            addCriterion("is_join_activity <=", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityLike(String value) {
            addCriterion("is_join_activity like", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityNotLike(String value) {
            addCriterion("is_join_activity not like", value, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityIn(List<String> values) {
            addCriterion("is_join_activity in", values, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityNotIn(List<String> values) {
            addCriterion("is_join_activity not in", values, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityBetween(String value1, String value2) {
            addCriterion("is_join_activity between", value1, value2, "isJoinActivity");
            return (Criteria) this;
        }

        public Criteria andIsJoinActivityNotBetween(String value1, String value2) {
            addCriterion("is_join_activity not between", value1, value2, "isJoinActivity");
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

        public Criteria andAffiliatedNameIsNull() {
            addCriterion("affiliated_name is null");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameIsNotNull() {
            addCriterion("affiliated_name is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameEqualTo(String value) {
            addCriterion("affiliated_name =", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameNotEqualTo(String value) {
            addCriterion("affiliated_name <>", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameGreaterThan(String value) {
            addCriterion("affiliated_name >", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameGreaterThanOrEqualTo(String value) {
            addCriterion("affiliated_name >=", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameLessThan(String value) {
            addCriterion("affiliated_name <", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameLessThanOrEqualTo(String value) {
            addCriterion("affiliated_name <=", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameLike(String value) {
            addCriterion("affiliated_name like", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameNotLike(String value) {
            addCriterion("affiliated_name not like", value, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameIn(List<String> values) {
            addCriterion("affiliated_name in", values, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameNotIn(List<String> values) {
            addCriterion("affiliated_name not in", values, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameBetween(String value1, String value2) {
            addCriterion("affiliated_name between", value1, value2, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andAffiliatedNameNotBetween(String value1, String value2) {
            addCriterion("affiliated_name not between", value1, value2, "affiliatedName");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberIsNull() {
            addCriterion("browse_number is null");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberIsNotNull() {
            addCriterion("browse_number is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberEqualTo(String value) {
            addCriterion("browse_number =", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotEqualTo(String value) {
            addCriterion("browse_number <>", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberGreaterThan(String value) {
            addCriterion("browse_number >", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("browse_number >=", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberLessThan(String value) {
            addCriterion("browse_number <", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberLessThanOrEqualTo(String value) {
            addCriterion("browse_number <=", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberLike(String value) {
            addCriterion("browse_number like", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotLike(String value) {
            addCriterion("browse_number not like", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberIn(List<String> values) {
            addCriterion("browse_number in", values, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotIn(List<String> values) {
            addCriterion("browse_number not in", values, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberBetween(String value1, String value2) {
            addCriterion("browse_number between", value1, value2, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotBetween(String value1, String value2) {
            addCriterion("browse_number not between", value1, value2, "browseNumber");
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