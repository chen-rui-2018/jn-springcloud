package com.jn.user.userinfo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserCompanyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserCompanyCriteria() {
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("owner_ID =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("owner_ID <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("owner_ID >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_ID >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("owner_ID <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("owner_ID <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("owner_ID like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("owner_ID not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("owner_ID in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("owner_ID not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("owner_ID between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("owner_ID not between", value1, value2, "ownerId");
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

        public Criteria andRegCapitalEqualTo(Double value) {
            addCriterion("reg_capital =", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotEqualTo(Double value) {
            addCriterion("reg_capital <>", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThan(Double value) {
            addCriterion("reg_capital >", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThanOrEqualTo(Double value) {
            addCriterion("reg_capital >=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThan(Double value) {
            addCriterion("reg_capital <", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThanOrEqualTo(Double value) {
            addCriterion("reg_capital <=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIn(List<Double> values) {
            addCriterion("reg_capital in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotIn(List<Double> values) {
            addCriterion("reg_capital not in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalBetween(Double value1, Double value2) {
            addCriterion("reg_capital between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotBetween(Double value1, Double value2) {
            addCriterion("reg_capital not between", value1, value2, "regCapital");
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

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
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

        public Criteria andComAdressIsNull() {
            addCriterion("com_adress is null");
            return (Criteria) this;
        }

        public Criteria andComAdressIsNotNull() {
            addCriterion("com_adress is not null");
            return (Criteria) this;
        }

        public Criteria andComAdressEqualTo(String value) {
            addCriterion("com_adress =", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressNotEqualTo(String value) {
            addCriterion("com_adress <>", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressGreaterThan(String value) {
            addCriterion("com_adress >", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressGreaterThanOrEqualTo(String value) {
            addCriterion("com_adress >=", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressLessThan(String value) {
            addCriterion("com_adress <", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressLessThanOrEqualTo(String value) {
            addCriterion("com_adress <=", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressLike(String value) {
            addCriterion("com_adress like", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressNotLike(String value) {
            addCriterion("com_adress not like", value, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressIn(List<String> values) {
            addCriterion("com_adress in", values, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressNotIn(List<String> values) {
            addCriterion("com_adress not in", values, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressBetween(String value1, String value2) {
            addCriterion("com_adress between", value1, value2, "comAdress");
            return (Criteria) this;
        }

        public Criteria andComAdressNotBetween(String value1, String value2) {
            addCriterion("com_adress not between", value1, value2, "comAdress");
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

        public Criteria andCreditPointsIsNull() {
            addCriterion("credit_points is null");
            return (Criteria) this;
        }

        public Criteria andCreditPointsIsNotNull() {
            addCriterion("credit_points is not null");
            return (Criteria) this;
        }

        public Criteria andCreditPointsEqualTo(Double value) {
            addCriterion("credit_points =", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsNotEqualTo(Double value) {
            addCriterion("credit_points <>", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsGreaterThan(Double value) {
            addCriterion("credit_points >", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsGreaterThanOrEqualTo(Double value) {
            addCriterion("credit_points >=", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsLessThan(Double value) {
            addCriterion("credit_points <", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsLessThanOrEqualTo(Double value) {
            addCriterion("credit_points <=", value, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsIn(List<Double> values) {
            addCriterion("credit_points in", values, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsNotIn(List<Double> values) {
            addCriterion("credit_points not in", values, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsBetween(Double value1, Double value2) {
            addCriterion("credit_points between", value1, value2, "creditPoints");
            return (Criteria) this;
        }

        public Criteria andCreditPointsNotBetween(Double value1, Double value2) {
            addCriterion("credit_points not between", value1, value2, "creditPoints");
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

        public Criteria andCheckerIsNull() {
            addCriterion("checker is null");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNotNull() {
            addCriterion("checker is not null");
            return (Criteria) this;
        }

        public Criteria andCheckerEqualTo(String value) {
            addCriterion("checker =", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotEqualTo(String value) {
            addCriterion("checker <>", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThan(String value) {
            addCriterion("checker >", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThanOrEqualTo(String value) {
            addCriterion("checker >=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThan(String value) {
            addCriterion("checker <", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThanOrEqualTo(String value) {
            addCriterion("checker <=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLike(String value) {
            addCriterion("checker like", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotLike(String value) {
            addCriterion("checker not like", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerIn(List<String> values) {
            addCriterion("checker in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotIn(List<String> values) {
            addCriterion("checker not in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerBetween(String value1, String value2) {
            addCriterion("checker between", value1, value2, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotBetween(String value1, String value2) {
            addCriterion("checker not between", value1, value2, "checker");
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