package com.jn.park.hatch.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbHatchIncubatorEnterpriseAndTeamCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHatchIncubatorEnterpriseAndTeamCriteria() {
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

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeIsNull() {
            addCriterion("establish_time is null");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeIsNotNull() {
            addCriterion("establish_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeEqualTo(Date value) {
            addCriterion("establish_time =", value, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeNotEqualTo(Date value) {
            addCriterion("establish_time <>", value, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeGreaterThan(Date value) {
            addCriterion("establish_time >", value, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("establish_time >=", value, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeLessThan(Date value) {
            addCriterion("establish_time <", value, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeLessThanOrEqualTo(Date value) {
            addCriterion("establish_time <=", value, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeIn(List<Date> values) {
            addCriterion("establish_time in", values, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeNotIn(List<Date> values) {
            addCriterion("establish_time not in", values, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeBetween(Date value1, Date value2) {
            addCriterion("establish_time between", value1, value2, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEstablishTimeNotBetween(Date value1, Date value2) {
            addCriterion("establish_time not between", value1, value2, "establishTime");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlIsNull() {
            addCriterion("enter_person_html is null");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlIsNotNull() {
            addCriterion("enter_person_html is not null");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlEqualTo(String value) {
            addCriterion("enter_person_html =", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlNotEqualTo(String value) {
            addCriterion("enter_person_html <>", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlGreaterThan(String value) {
            addCriterion("enter_person_html >", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlGreaterThanOrEqualTo(String value) {
            addCriterion("enter_person_html >=", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlLessThan(String value) {
            addCriterion("enter_person_html <", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlLessThanOrEqualTo(String value) {
            addCriterion("enter_person_html <=", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlLike(String value) {
            addCriterion("enter_person_html like", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlNotLike(String value) {
            addCriterion("enter_person_html not like", value, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlIn(List<String> values) {
            addCriterion("enter_person_html in", values, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlNotIn(List<String> values) {
            addCriterion("enter_person_html not in", values, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlBetween(String value1, String value2) {
            addCriterion("enter_person_html between", value1, value2, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andEnterPersonHtmlNotBetween(String value1, String value2) {
            addCriterion("enter_person_html not between", value1, value2, "enterPersonHtml");
            return (Criteria) this;
        }

        public Criteria andAreaCoverIsNull() {
            addCriterion("area_cover is null");
            return (Criteria) this;
        }

        public Criteria andAreaCoverIsNotNull() {
            addCriterion("area_cover is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCoverEqualTo(Double value) {
            addCriterion("area_cover =", value, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverNotEqualTo(Double value) {
            addCriterion("area_cover <>", value, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverGreaterThan(Double value) {
            addCriterion("area_cover >", value, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverGreaterThanOrEqualTo(Double value) {
            addCriterion("area_cover >=", value, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverLessThan(Double value) {
            addCriterion("area_cover <", value, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverLessThanOrEqualTo(Double value) {
            addCriterion("area_cover <=", value, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverIn(List<Double> values) {
            addCriterion("area_cover in", values, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverNotIn(List<Double> values) {
            addCriterion("area_cover not in", values, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverBetween(Double value1, Double value2) {
            addCriterion("area_cover between", value1, value2, "areaCover");
            return (Criteria) this;
        }

        public Criteria andAreaCoverNotBetween(Double value1, Double value2) {
            addCriterion("area_cover not between", value1, value2, "areaCover");
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

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlIsNull() {
            addCriterion("team_html is null");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlIsNotNull() {
            addCriterion("team_html is not null");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlEqualTo(String value) {
            addCriterion("team_html =", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlNotEqualTo(String value) {
            addCriterion("team_html <>", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlGreaterThan(String value) {
            addCriterion("team_html >", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlGreaterThanOrEqualTo(String value) {
            addCriterion("team_html >=", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlLessThan(String value) {
            addCriterion("team_html <", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlLessThanOrEqualTo(String value) {
            addCriterion("team_html <=", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlLike(String value) {
            addCriterion("team_html like", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlNotLike(String value) {
            addCriterion("team_html not like", value, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlIn(List<String> values) {
            addCriterion("team_html in", values, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlNotIn(List<String> values) {
            addCriterion("team_html not in", values, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlBetween(String value1, String value2) {
            addCriterion("team_html between", value1, value2, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andTeamHtmlNotBetween(String value1, String value2) {
            addCriterion("team_html not between", value1, value2, "teamHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlIsNull() {
            addCriterion("product_html is null");
            return (Criteria) this;
        }

        public Criteria andProductHtmlIsNotNull() {
            addCriterion("product_html is not null");
            return (Criteria) this;
        }

        public Criteria andProductHtmlEqualTo(String value) {
            addCriterion("product_html =", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlNotEqualTo(String value) {
            addCriterion("product_html <>", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlGreaterThan(String value) {
            addCriterion("product_html >", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlGreaterThanOrEqualTo(String value) {
            addCriterion("product_html >=", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlLessThan(String value) {
            addCriterion("product_html <", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlLessThanOrEqualTo(String value) {
            addCriterion("product_html <=", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlLike(String value) {
            addCriterion("product_html like", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlNotLike(String value) {
            addCriterion("product_html not like", value, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlIn(List<String> values) {
            addCriterion("product_html in", values, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlNotIn(List<String> values) {
            addCriterion("product_html not in", values, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlBetween(String value1, String value2) {
            addCriterion("product_html between", value1, value2, "productHtml");
            return (Criteria) this;
        }

        public Criteria andProductHtmlNotBetween(String value1, String value2) {
            addCriterion("product_html not between", value1, value2, "productHtml");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlIsNull() {
            addCriterion("license_url is null");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlIsNotNull() {
            addCriterion("license_url is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlEqualTo(String value) {
            addCriterion("license_url =", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlNotEqualTo(String value) {
            addCriterion("license_url <>", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlGreaterThan(String value) {
            addCriterion("license_url >", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("license_url >=", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlLessThan(String value) {
            addCriterion("license_url <", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlLessThanOrEqualTo(String value) {
            addCriterion("license_url <=", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlLike(String value) {
            addCriterion("license_url like", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlNotLike(String value) {
            addCriterion("license_url not like", value, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlIn(List<String> values) {
            addCriterion("license_url in", values, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlNotIn(List<String> values) {
            addCriterion("license_url not in", values, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlBetween(String value1, String value2) {
            addCriterion("license_url between", value1, value2, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andLicenseUrlNotBetween(String value1, String value2) {
            addCriterion("license_url not between", value1, value2, "licenseUrl");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
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

        public Criteria andEnterpriseNatureIdIsNull() {
            addCriterion("enterprise_nature_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdIsNotNull() {
            addCriterion("enterprise_nature_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdEqualTo(String value) {
            addCriterion("enterprise_nature_id =", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdNotEqualTo(String value) {
            addCriterion("enterprise_nature_id <>", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdGreaterThan(String value) {
            addCriterion("enterprise_nature_id >", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_nature_id >=", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdLessThan(String value) {
            addCriterion("enterprise_nature_id <", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_nature_id <=", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdLike(String value) {
            addCriterion("enterprise_nature_id like", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdNotLike(String value) {
            addCriterion("enterprise_nature_id not like", value, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdIn(List<String> values) {
            addCriterion("enterprise_nature_id in", values, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdNotIn(List<String> values) {
            addCriterion("enterprise_nature_id not in", values, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdBetween(String value1, String value2) {
            addCriterion("enterprise_nature_id between", value1, value2, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_nature_id not between", value1, value2, "enterpriseNatureId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameIsNull() {
            addCriterion("enterprise_nature_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameIsNotNull() {
            addCriterion("enterprise_nature_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameEqualTo(String value) {
            addCriterion("enterprise_nature_name =", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameNotEqualTo(String value) {
            addCriterion("enterprise_nature_name <>", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameGreaterThan(String value) {
            addCriterion("enterprise_nature_name >", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_nature_name >=", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameLessThan(String value) {
            addCriterion("enterprise_nature_name <", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_nature_name <=", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameLike(String value) {
            addCriterion("enterprise_nature_name like", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameNotLike(String value) {
            addCriterion("enterprise_nature_name not like", value, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameIn(List<String> values) {
            addCriterion("enterprise_nature_name in", values, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameNotIn(List<String> values) {
            addCriterion("enterprise_nature_name not in", values, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameBetween(String value1, String value2) {
            addCriterion("enterprise_nature_name between", value1, value2, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNatureNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_nature_name not between", value1, value2, "enterpriseNatureName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdIsNull() {
            addCriterion("enterprise_type_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdIsNotNull() {
            addCriterion("enterprise_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdEqualTo(String value) {
            addCriterion("enterprise_type_id =", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotEqualTo(String value) {
            addCriterion("enterprise_type_id <>", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdGreaterThan(String value) {
            addCriterion("enterprise_type_id >", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_type_id >=", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdLessThan(String value) {
            addCriterion("enterprise_type_id <", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_type_id <=", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdLike(String value) {
            addCriterion("enterprise_type_id like", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotLike(String value) {
            addCriterion("enterprise_type_id not like", value, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdIn(List<String> values) {
            addCriterion("enterprise_type_id in", values, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotIn(List<String> values) {
            addCriterion("enterprise_type_id not in", values, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdBetween(String value1, String value2) {
            addCriterion("enterprise_type_id between", value1, value2, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_type_id not between", value1, value2, "enterpriseTypeId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameIsNull() {
            addCriterion("enterprise_type_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameIsNotNull() {
            addCriterion("enterprise_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameEqualTo(String value) {
            addCriterion("enterprise_type_name =", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotEqualTo(String value) {
            addCriterion("enterprise_type_name <>", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameGreaterThan(String value) {
            addCriterion("enterprise_type_name >", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_type_name >=", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameLessThan(String value) {
            addCriterion("enterprise_type_name <", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_type_name <=", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameLike(String value) {
            addCriterion("enterprise_type_name like", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotLike(String value) {
            addCriterion("enterprise_type_name not like", value, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameIn(List<String> values) {
            addCriterion("enterprise_type_name in", values, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotIn(List<String> values) {
            addCriterion("enterprise_type_name not in", values, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameBetween(String value1, String value2) {
            addCriterion("enterprise_type_name between", value1, value2, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_type_name not between", value1, value2, "enterpriseTypeName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdIsNull() {
            addCriterion("enterprise_tech_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdIsNotNull() {
            addCriterion("enterprise_tech_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdEqualTo(String value) {
            addCriterion("enterprise_tech_id =", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotEqualTo(String value) {
            addCriterion("enterprise_tech_id <>", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdGreaterThan(String value) {
            addCriterion("enterprise_tech_id >", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_id >=", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdLessThan(String value) {
            addCriterion("enterprise_tech_id <", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdLessThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_id <=", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdLike(String value) {
            addCriterion("enterprise_tech_id like", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotLike(String value) {
            addCriterion("enterprise_tech_id not like", value, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdIn(List<String> values) {
            addCriterion("enterprise_tech_id in", values, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotIn(List<String> values) {
            addCriterion("enterprise_tech_id not in", values, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdBetween(String value1, String value2) {
            addCriterion("enterprise_tech_id between", value1, value2, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechIdNotBetween(String value1, String value2) {
            addCriterion("enterprise_tech_id not between", value1, value2, "enterpriseTechId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameIsNull() {
            addCriterion("enterprise_tech_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameIsNotNull() {
            addCriterion("enterprise_tech_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameEqualTo(String value) {
            addCriterion("enterprise_tech_name =", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotEqualTo(String value) {
            addCriterion("enterprise_tech_name <>", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameGreaterThan(String value) {
            addCriterion("enterprise_tech_name >", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_name >=", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameLessThan(String value) {
            addCriterion("enterprise_tech_name <", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_tech_name <=", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameLike(String value) {
            addCriterion("enterprise_tech_name like", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotLike(String value) {
            addCriterion("enterprise_tech_name not like", value, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameIn(List<String> values) {
            addCriterion("enterprise_tech_name in", values, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotIn(List<String> values) {
            addCriterion("enterprise_tech_name not in", values, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameBetween(String value1, String value2) {
            addCriterion("enterprise_tech_name between", value1, value2, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTechNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_tech_name not between", value1, value2, "enterpriseTechName");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationIsNull() {
            addCriterion("office_location is null");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationIsNotNull() {
            addCriterion("office_location is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationEqualTo(String value) {
            addCriterion("office_location =", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationNotEqualTo(String value) {
            addCriterion("office_location <>", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationGreaterThan(String value) {
            addCriterion("office_location >", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationGreaterThanOrEqualTo(String value) {
            addCriterion("office_location >=", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationLessThan(String value) {
            addCriterion("office_location <", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationLessThanOrEqualTo(String value) {
            addCriterion("office_location <=", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationLike(String value) {
            addCriterion("office_location like", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationNotLike(String value) {
            addCriterion("office_location not like", value, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationIn(List<String> values) {
            addCriterion("office_location in", values, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationNotIn(List<String> values) {
            addCriterion("office_location not in", values, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationBetween(String value1, String value2) {
            addCriterion("office_location between", value1, value2, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andOfficeLocationNotBetween(String value1, String value2) {
            addCriterion("office_location not between", value1, value2, "officeLocation");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdIsNull() {
            addCriterion("enter_inc_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdIsNotNull() {
            addCriterion("enter_inc_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdEqualTo(String value) {
            addCriterion("enter_inc_id =", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdNotEqualTo(String value) {
            addCriterion("enter_inc_id <>", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdGreaterThan(String value) {
            addCriterion("enter_inc_id >", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdGreaterThanOrEqualTo(String value) {
            addCriterion("enter_inc_id >=", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdLessThan(String value) {
            addCriterion("enter_inc_id <", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdLessThanOrEqualTo(String value) {
            addCriterion("enter_inc_id <=", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdLike(String value) {
            addCriterion("enter_inc_id like", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdNotLike(String value) {
            addCriterion("enter_inc_id not like", value, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdIn(List<String> values) {
            addCriterion("enter_inc_id in", values, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdNotIn(List<String> values) {
            addCriterion("enter_inc_id not in", values, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdBetween(String value1, String value2) {
            addCriterion("enter_inc_id between", value1, value2, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncIdNotBetween(String value1, String value2) {
            addCriterion("enter_inc_id not between", value1, value2, "enterIncId");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameIsNull() {
            addCriterion("enter_inc_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameIsNotNull() {
            addCriterion("enter_inc_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameEqualTo(String value) {
            addCriterion("enter_inc_name =", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameNotEqualTo(String value) {
            addCriterion("enter_inc_name <>", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameGreaterThan(String value) {
            addCriterion("enter_inc_name >", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameGreaterThanOrEqualTo(String value) {
            addCriterion("enter_inc_name >=", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameLessThan(String value) {
            addCriterion("enter_inc_name <", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameLessThanOrEqualTo(String value) {
            addCriterion("enter_inc_name <=", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameLike(String value) {
            addCriterion("enter_inc_name like", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameNotLike(String value) {
            addCriterion("enter_inc_name not like", value, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameIn(List<String> values) {
            addCriterion("enter_inc_name in", values, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameNotIn(List<String> values) {
            addCriterion("enter_inc_name not in", values, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameBetween(String value1, String value2) {
            addCriterion("enter_inc_name between", value1, value2, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andEnterIncNameNotBetween(String value1, String value2) {
            addCriterion("enter_inc_name not between", value1, value2, "enterIncName");
            return (Criteria) this;
        }

        public Criteria andDataSourcesIsNull() {
            addCriterion("data_sources is null");
            return (Criteria) this;
        }

        public Criteria andDataSourcesIsNotNull() {
            addCriterion("data_sources is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourcesEqualTo(String value) {
            addCriterion("data_sources =", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesNotEqualTo(String value) {
            addCriterion("data_sources <>", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesGreaterThan(String value) {
            addCriterion("data_sources >", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesGreaterThanOrEqualTo(String value) {
            addCriterion("data_sources >=", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesLessThan(String value) {
            addCriterion("data_sources <", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesLessThanOrEqualTo(String value) {
            addCriterion("data_sources <=", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesLike(String value) {
            addCriterion("data_sources like", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesNotLike(String value) {
            addCriterion("data_sources not like", value, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesIn(List<String> values) {
            addCriterion("data_sources in", values, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesNotIn(List<String> values) {
            addCriterion("data_sources not in", values, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesBetween(String value1, String value2) {
            addCriterion("data_sources between", value1, value2, "dataSources");
            return (Criteria) this;
        }

        public Criteria andDataSourcesNotBetween(String value1, String value2) {
            addCriterion("data_sources not between", value1, value2, "dataSources");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Date value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Date value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Date value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Date> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Date> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
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

        public Criteria andRecordStatusIsNull() {
            addCriterion("record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(String value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(String value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(String value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(String value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(String value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(String value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLike(String value) {
            addCriterion("record_status like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotLike(String value) {
            addCriterion("record_status not like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<String> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<String> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(String value1, String value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(String value1, String value2) {
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

        public Criteria andIsTalentIsNull() {
            addCriterion("is_talent is null");
            return (Criteria) this;
        }

        public Criteria andIsTalentIsNotNull() {
            addCriterion("is_talent is not null");
            return (Criteria) this;
        }

        public Criteria andIsTalentEqualTo(String value) {
            addCriterion("is_talent =", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentNotEqualTo(String value) {
            addCriterion("is_talent <>", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentGreaterThan(String value) {
            addCriterion("is_talent >", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentGreaterThanOrEqualTo(String value) {
            addCriterion("is_talent >=", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentLessThan(String value) {
            addCriterion("is_talent <", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentLessThanOrEqualTo(String value) {
            addCriterion("is_talent <=", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentLike(String value) {
            addCriterion("is_talent like", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentNotLike(String value) {
            addCriterion("is_talent not like", value, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentIn(List<String> values) {
            addCriterion("is_talent in", values, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentNotIn(List<String> values) {
            addCriterion("is_talent not in", values, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentBetween(String value1, String value2) {
            addCriterion("is_talent between", value1, value2, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTalentNotBetween(String value1, String value2) {
            addCriterion("is_talent not between", value1, value2, "isTalent");
            return (Criteria) this;
        }

        public Criteria andIsTechIsNull() {
            addCriterion("is_tech is null");
            return (Criteria) this;
        }

        public Criteria andIsTechIsNotNull() {
            addCriterion("is_tech is not null");
            return (Criteria) this;
        }

        public Criteria andIsTechEqualTo(String value) {
            addCriterion("is_tech =", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechNotEqualTo(String value) {
            addCriterion("is_tech <>", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechGreaterThan(String value) {
            addCriterion("is_tech >", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechGreaterThanOrEqualTo(String value) {
            addCriterion("is_tech >=", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechLessThan(String value) {
            addCriterion("is_tech <", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechLessThanOrEqualTo(String value) {
            addCriterion("is_tech <=", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechLike(String value) {
            addCriterion("is_tech like", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechNotLike(String value) {
            addCriterion("is_tech not like", value, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechIn(List<String> values) {
            addCriterion("is_tech in", values, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechNotIn(List<String> values) {
            addCriterion("is_tech not in", values, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechBetween(String value1, String value2) {
            addCriterion("is_tech between", value1, value2, "isTech");
            return (Criteria) this;
        }

        public Criteria andIsTechNotBetween(String value1, String value2) {
            addCriterion("is_tech not between", value1, value2, "isTech");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountIsNull() {
            addCriterion("rentfree_amount is null");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountIsNotNull() {
            addCriterion("rentfree_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountEqualTo(BigDecimal value) {
            addCriterion("rentfree_amount =", value, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountNotEqualTo(BigDecimal value) {
            addCriterion("rentfree_amount <>", value, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountGreaterThan(BigDecimal value) {
            addCriterion("rentfree_amount >", value, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rentfree_amount >=", value, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountLessThan(BigDecimal value) {
            addCriterion("rentfree_amount <", value, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rentfree_amount <=", value, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountIn(List<BigDecimal> values) {
            addCriterion("rentfree_amount in", values, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountNotIn(List<BigDecimal> values) {
            addCriterion("rentfree_amount not in", values, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rentfree_amount between", value1, value2, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRentfreeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rentfree_amount not between", value1, value2, "rentfreeAmount");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdIsNull() {
            addCriterion("request_inc_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdIsNotNull() {
            addCriterion("request_inc_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdEqualTo(String value) {
            addCriterion("request_inc_id =", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdNotEqualTo(String value) {
            addCriterion("request_inc_id <>", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdGreaterThan(String value) {
            addCriterion("request_inc_id >", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdGreaterThanOrEqualTo(String value) {
            addCriterion("request_inc_id >=", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdLessThan(String value) {
            addCriterion("request_inc_id <", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdLessThanOrEqualTo(String value) {
            addCriterion("request_inc_id <=", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdLike(String value) {
            addCriterion("request_inc_id like", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdNotLike(String value) {
            addCriterion("request_inc_id not like", value, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdIn(List<String> values) {
            addCriterion("request_inc_id in", values, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdNotIn(List<String> values) {
            addCriterion("request_inc_id not in", values, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdBetween(String value1, String value2) {
            addCriterion("request_inc_id between", value1, value2, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncIdNotBetween(String value1, String value2) {
            addCriterion("request_inc_id not between", value1, value2, "requestIncId");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameIsNull() {
            addCriterion("request_inc_name is null");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameIsNotNull() {
            addCriterion("request_inc_name is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameEqualTo(String value) {
            addCriterion("request_inc_name =", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameNotEqualTo(String value) {
            addCriterion("request_inc_name <>", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameGreaterThan(String value) {
            addCriterion("request_inc_name >", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameGreaterThanOrEqualTo(String value) {
            addCriterion("request_inc_name >=", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameLessThan(String value) {
            addCriterion("request_inc_name <", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameLessThanOrEqualTo(String value) {
            addCriterion("request_inc_name <=", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameLike(String value) {
            addCriterion("request_inc_name like", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameNotLike(String value) {
            addCriterion("request_inc_name not like", value, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameIn(List<String> values) {
            addCriterion("request_inc_name in", values, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameNotIn(List<String> values) {
            addCriterion("request_inc_name not in", values, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameBetween(String value1, String value2) {
            addCriterion("request_inc_name between", value1, value2, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andRequestIncNameNotBetween(String value1, String value2) {
            addCriterion("request_inc_name not between", value1, value2, "requestIncName");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProSynopsisIsNull() {
            addCriterion("pro_synopsis is null");
            return (Criteria) this;
        }

        public Criteria andProSynopsisIsNotNull() {
            addCriterion("pro_synopsis is not null");
            return (Criteria) this;
        }

        public Criteria andProSynopsisEqualTo(String value) {
            addCriterion("pro_synopsis =", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisNotEqualTo(String value) {
            addCriterion("pro_synopsis <>", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisGreaterThan(String value) {
            addCriterion("pro_synopsis >", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("pro_synopsis >=", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisLessThan(String value) {
            addCriterion("pro_synopsis <", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisLessThanOrEqualTo(String value) {
            addCriterion("pro_synopsis <=", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisLike(String value) {
            addCriterion("pro_synopsis like", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisNotLike(String value) {
            addCriterion("pro_synopsis not like", value, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisIn(List<String> values) {
            addCriterion("pro_synopsis in", values, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisNotIn(List<String> values) {
            addCriterion("pro_synopsis not in", values, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisBetween(String value1, String value2) {
            addCriterion("pro_synopsis between", value1, value2, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andProSynopsisNotBetween(String value1, String value2) {
            addCriterion("pro_synopsis not between", value1, value2, "proSynopsis");
            return (Criteria) this;
        }

        public Criteria andIsFinancIsNull() {
            addCriterion("is_financ is null");
            return (Criteria) this;
        }

        public Criteria andIsFinancIsNotNull() {
            addCriterion("is_financ is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinancEqualTo(String value) {
            addCriterion("is_financ =", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancNotEqualTo(String value) {
            addCriterion("is_financ <>", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancGreaterThan(String value) {
            addCriterion("is_financ >", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancGreaterThanOrEqualTo(String value) {
            addCriterion("is_financ >=", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancLessThan(String value) {
            addCriterion("is_financ <", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancLessThanOrEqualTo(String value) {
            addCriterion("is_financ <=", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancLike(String value) {
            addCriterion("is_financ like", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancNotLike(String value) {
            addCriterion("is_financ not like", value, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancIn(List<String> values) {
            addCriterion("is_financ in", values, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancNotIn(List<String> values) {
            addCriterion("is_financ not in", values, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancBetween(String value1, String value2) {
            addCriterion("is_financ between", value1, value2, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andIsFinancNotBetween(String value1, String value2) {
            addCriterion("is_financ not between", value1, value2, "isFinanc");
            return (Criteria) this;
        }

        public Criteria andFinancNumIsNull() {
            addCriterion("financ_num is null");
            return (Criteria) this;
        }

        public Criteria andFinancNumIsNotNull() {
            addCriterion("financ_num is not null");
            return (Criteria) this;
        }

        public Criteria andFinancNumEqualTo(BigDecimal value) {
            addCriterion("financ_num =", value, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumNotEqualTo(BigDecimal value) {
            addCriterion("financ_num <>", value, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumGreaterThan(BigDecimal value) {
            addCriterion("financ_num >", value, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financ_num >=", value, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumLessThan(BigDecimal value) {
            addCriterion("financ_num <", value, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financ_num <=", value, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumIn(List<BigDecimal> values) {
            addCriterion("financ_num in", values, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumNotIn(List<BigDecimal> values) {
            addCriterion("financ_num not in", values, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financ_num between", value1, value2, "financNum");
            return (Criteria) this;
        }

        public Criteria andFinancNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financ_num not between", value1, value2, "financNum");
            return (Criteria) this;
        }

        public Criteria andProIntroducIsNull() {
            addCriterion("pro_introduc is null");
            return (Criteria) this;
        }

        public Criteria andProIntroducIsNotNull() {
            addCriterion("pro_introduc is not null");
            return (Criteria) this;
        }

        public Criteria andProIntroducEqualTo(String value) {
            addCriterion("pro_introduc =", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducNotEqualTo(String value) {
            addCriterion("pro_introduc <>", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducGreaterThan(String value) {
            addCriterion("pro_introduc >", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducGreaterThanOrEqualTo(String value) {
            addCriterion("pro_introduc >=", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducLessThan(String value) {
            addCriterion("pro_introduc <", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducLessThanOrEqualTo(String value) {
            addCriterion("pro_introduc <=", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducLike(String value) {
            addCriterion("pro_introduc like", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducNotLike(String value) {
            addCriterion("pro_introduc not like", value, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducIn(List<String> values) {
            addCriterion("pro_introduc in", values, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducNotIn(List<String> values) {
            addCriterion("pro_introduc not in", values, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducBetween(String value1, String value2) {
            addCriterion("pro_introduc between", value1, value2, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andProIntroducNotBetween(String value1, String value2) {
            addCriterion("pro_introduc not between", value1, value2, "proIntroduc");
            return (Criteria) this;
        }

        public Criteria andTaxValueIsNull() {
            addCriterion("tax_value is null");
            return (Criteria) this;
        }

        public Criteria andTaxValueIsNotNull() {
            addCriterion("tax_value is not null");
            return (Criteria) this;
        }

        public Criteria andTaxValueEqualTo(BigDecimal value) {
            addCriterion("tax_value =", value, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueNotEqualTo(BigDecimal value) {
            addCriterion("tax_value <>", value, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueGreaterThan(BigDecimal value) {
            addCriterion("tax_value >", value, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_value >=", value, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueLessThan(BigDecimal value) {
            addCriterion("tax_value <", value, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_value <=", value, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueIn(List<BigDecimal> values) {
            addCriterion("tax_value in", values, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueNotIn(List<BigDecimal> values) {
            addCriterion("tax_value not in", values, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_value between", value1, value2, "taxValue");
            return (Criteria) this;
        }

        public Criteria andTaxValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_value not between", value1, value2, "taxValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueIsNull() {
            addCriterion("revenue_value is null");
            return (Criteria) this;
        }

        public Criteria andRevenueValueIsNotNull() {
            addCriterion("revenue_value is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueValueEqualTo(BigDecimal value) {
            addCriterion("revenue_value =", value, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueNotEqualTo(BigDecimal value) {
            addCriterion("revenue_value <>", value, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueGreaterThan(BigDecimal value) {
            addCriterion("revenue_value >", value, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue_value >=", value, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueLessThan(BigDecimal value) {
            addCriterion("revenue_value <", value, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue_value <=", value, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueIn(List<BigDecimal> values) {
            addCriterion("revenue_value in", values, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueNotIn(List<BigDecimal> values) {
            addCriterion("revenue_value not in", values, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue_value between", value1, value2, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andRevenueValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue_value not between", value1, value2, "revenueValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueIsNull() {
            addCriterion("financ_value is null");
            return (Criteria) this;
        }

        public Criteria andFinancValueIsNotNull() {
            addCriterion("financ_value is not null");
            return (Criteria) this;
        }

        public Criteria andFinancValueEqualTo(BigDecimal value) {
            addCriterion("financ_value =", value, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueNotEqualTo(BigDecimal value) {
            addCriterion("financ_value <>", value, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueGreaterThan(BigDecimal value) {
            addCriterion("financ_value >", value, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financ_value >=", value, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueLessThan(BigDecimal value) {
            addCriterion("financ_value <", value, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financ_value <=", value, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueIn(List<BigDecimal> values) {
            addCriterion("financ_value in", values, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueNotIn(List<BigDecimal> values) {
            addCriterion("financ_value not in", values, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financ_value between", value1, value2, "financValue");
            return (Criteria) this;
        }

        public Criteria andFinancValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financ_value not between", value1, value2, "financValue");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratIsNull() {
            addCriterion("policy_declarat is null");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratIsNotNull() {
            addCriterion("policy_declarat is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratEqualTo(String value) {
            addCriterion("policy_declarat =", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratNotEqualTo(String value) {
            addCriterion("policy_declarat <>", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratGreaterThan(String value) {
            addCriterion("policy_declarat >", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratGreaterThanOrEqualTo(String value) {
            addCriterion("policy_declarat >=", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratLessThan(String value) {
            addCriterion("policy_declarat <", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratLessThanOrEqualTo(String value) {
            addCriterion("policy_declarat <=", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratLike(String value) {
            addCriterion("policy_declarat like", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratNotLike(String value) {
            addCriterion("policy_declarat not like", value, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratIn(List<String> values) {
            addCriterion("policy_declarat in", values, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratNotIn(List<String> values) {
            addCriterion("policy_declarat not in", values, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratBetween(String value1, String value2) {
            addCriterion("policy_declarat between", value1, value2, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andPolicyDeclaratNotBetween(String value1, String value2) {
            addCriterion("policy_declarat not between", value1, value2, "policyDeclarat");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesIsNull() {
            addCriterion("enrolment_activities is null");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesIsNotNull() {
            addCriterion("enrolment_activities is not null");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesEqualTo(String value) {
            addCriterion("enrolment_activities =", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesNotEqualTo(String value) {
            addCriterion("enrolment_activities <>", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesGreaterThan(String value) {
            addCriterion("enrolment_activities >", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesGreaterThanOrEqualTo(String value) {
            addCriterion("enrolment_activities >=", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesLessThan(String value) {
            addCriterion("enrolment_activities <", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesLessThanOrEqualTo(String value) {
            addCriterion("enrolment_activities <=", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesLike(String value) {
            addCriterion("enrolment_activities like", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesNotLike(String value) {
            addCriterion("enrolment_activities not like", value, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesIn(List<String> values) {
            addCriterion("enrolment_activities in", values, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesNotIn(List<String> values) {
            addCriterion("enrolment_activities not in", values, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesBetween(String value1, String value2) {
            addCriterion("enrolment_activities between", value1, value2, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andEnrolmentActivitiesNotBetween(String value1, String value2) {
            addCriterion("enrolment_activities not between", value1, value2, "enrolmentActivities");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusIsNull() {
            addCriterion("graduate_status is null");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusIsNotNull() {
            addCriterion("graduate_status is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusEqualTo(String value) {
            addCriterion("graduate_status =", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusNotEqualTo(String value) {
            addCriterion("graduate_status <>", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusGreaterThan(String value) {
            addCriterion("graduate_status >", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_status >=", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusLessThan(String value) {
            addCriterion("graduate_status <", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusLessThanOrEqualTo(String value) {
            addCriterion("graduate_status <=", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusLike(String value) {
            addCriterion("graduate_status like", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusNotLike(String value) {
            addCriterion("graduate_status not like", value, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusIn(List<String> values) {
            addCriterion("graduate_status in", values, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusNotIn(List<String> values) {
            addCriterion("graduate_status not in", values, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusBetween(String value1, String value2) {
            addCriterion("graduate_status between", value1, value2, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateStatusNotBetween(String value1, String value2) {
            addCriterion("graduate_status not between", value1, value2, "graduateStatus");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsIsNull() {
            addCriterion("graduate_requirements is null");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsIsNotNull() {
            addCriterion("graduate_requirements is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsEqualTo(String value) {
            addCriterion("graduate_requirements =", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsNotEqualTo(String value) {
            addCriterion("graduate_requirements <>", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsGreaterThan(String value) {
            addCriterion("graduate_requirements >", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_requirements >=", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsLessThan(String value) {
            addCriterion("graduate_requirements <", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsLessThanOrEqualTo(String value) {
            addCriterion("graduate_requirements <=", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsLike(String value) {
            addCriterion("graduate_requirements like", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsNotLike(String value) {
            addCriterion("graduate_requirements not like", value, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsIn(List<String> values) {
            addCriterion("graduate_requirements in", values, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsNotIn(List<String> values) {
            addCriterion("graduate_requirements not in", values, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsBetween(String value1, String value2) {
            addCriterion("graduate_requirements between", value1, value2, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduateRequirementsNotBetween(String value1, String value2) {
            addCriterion("graduate_requirements not between", value1, value2, "graduateRequirements");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeIsNull() {
            addCriterion("graduatie_time is null");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeIsNotNull() {
            addCriterion("graduatie_time is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeEqualTo(Date value) {
            addCriterion("graduatie_time =", value, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeNotEqualTo(Date value) {
            addCriterion("graduatie_time <>", value, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeGreaterThan(Date value) {
            addCriterion("graduatie_time >", value, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("graduatie_time >=", value, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeLessThan(Date value) {
            addCriterion("graduatie_time <", value, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeLessThanOrEqualTo(Date value) {
            addCriterion("graduatie_time <=", value, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeIn(List<Date> values) {
            addCriterion("graduatie_time in", values, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeNotIn(List<Date> values) {
            addCriterion("graduatie_time not in", values, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeBetween(Date value1, Date value2) {
            addCriterion("graduatie_time between", value1, value2, "graduatieTime");
            return (Criteria) this;
        }

        public Criteria andGraduatieTimeNotBetween(Date value1, Date value2) {
            addCriterion("graduatie_time not between", value1, value2, "graduatieTime");
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