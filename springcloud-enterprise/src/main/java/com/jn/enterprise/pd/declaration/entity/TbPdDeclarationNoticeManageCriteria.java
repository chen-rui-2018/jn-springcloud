package com.jn.enterprise.pd.declaration.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPdDeclarationNoticeManageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPdDeclarationNoticeManageCriteria() {
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

        public Criteria andTitleNameIsNull() {
            addCriterion("title_name is null");
            return (Criteria) this;
        }

        public Criteria andTitleNameIsNotNull() {
            addCriterion("title_name is not null");
            return (Criteria) this;
        }

        public Criteria andTitleNameEqualTo(String value) {
            addCriterion("title_name =", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotEqualTo(String value) {
            addCriterion("title_name <>", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThan(String value) {
            addCriterion("title_name >", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("title_name >=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThan(String value) {
            addCriterion("title_name <", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLessThanOrEqualTo(String value) {
            addCriterion("title_name <=", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameLike(String value) {
            addCriterion("title_name like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotLike(String value) {
            addCriterion("title_name not like", value, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameIn(List<String> values) {
            addCriterion("title_name in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotIn(List<String> values) {
            addCriterion("title_name not in", values, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameBetween(String value1, String value2) {
            addCriterion("title_name between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andTitleNameNotBetween(String value1, String value2) {
            addCriterion("title_name not between", value1, value2, "titleName");
            return (Criteria) this;
        }

        public Criteria andRangeIdIsNull() {
            addCriterion("range_id is null");
            return (Criteria) this;
        }

        public Criteria andRangeIdIsNotNull() {
            addCriterion("range_id is not null");
            return (Criteria) this;
        }

        public Criteria andRangeIdEqualTo(String value) {
            addCriterion("range_id =", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotEqualTo(String value) {
            addCriterion("range_id <>", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdGreaterThan(String value) {
            addCriterion("range_id >", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdGreaterThanOrEqualTo(String value) {
            addCriterion("range_id >=", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdLessThan(String value) {
            addCriterion("range_id <", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdLessThanOrEqualTo(String value) {
            addCriterion("range_id <=", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdLike(String value) {
            addCriterion("range_id like", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotLike(String value) {
            addCriterion("range_id not like", value, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdIn(List<String> values) {
            addCriterion("range_id in", values, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotIn(List<String> values) {
            addCriterion("range_id not in", values, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdBetween(String value1, String value2) {
            addCriterion("range_id between", value1, value2, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeIdNotBetween(String value1, String value2) {
            addCriterion("range_id not between", value1, value2, "rangeId");
            return (Criteria) this;
        }

        public Criteria andRangeNameIsNull() {
            addCriterion("range_name is null");
            return (Criteria) this;
        }

        public Criteria andRangeNameIsNotNull() {
            addCriterion("range_name is not null");
            return (Criteria) this;
        }

        public Criteria andRangeNameEqualTo(String value) {
            addCriterion("range_name =", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameNotEqualTo(String value) {
            addCriterion("range_name <>", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameGreaterThan(String value) {
            addCriterion("range_name >", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameGreaterThanOrEqualTo(String value) {
            addCriterion("range_name >=", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameLessThan(String value) {
            addCriterion("range_name <", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameLessThanOrEqualTo(String value) {
            addCriterion("range_name <=", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameLike(String value) {
            addCriterion("range_name like", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameNotLike(String value) {
            addCriterion("range_name not like", value, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameIn(List<String> values) {
            addCriterion("range_name in", values, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameNotIn(List<String> values) {
            addCriterion("range_name not in", values, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameBetween(String value1, String value2) {
            addCriterion("range_name between", value1, value2, "rangeName");
            return (Criteria) this;
        }

        public Criteria andRangeNameNotBetween(String value1, String value2) {
            addCriterion("range_name not between", value1, value2, "rangeName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdIsNull() {
            addCriterion("subordinate_platform_id is null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdIsNotNull() {
            addCriterion("subordinate_platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdEqualTo(String value) {
            addCriterion("subordinate_platform_id =", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotEqualTo(String value) {
            addCriterion("subordinate_platform_id <>", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdGreaterThan(String value) {
            addCriterion("subordinate_platform_id >", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdGreaterThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_id >=", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdLessThan(String value) {
            addCriterion("subordinate_platform_id <", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdLessThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_id <=", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdLike(String value) {
            addCriterion("subordinate_platform_id like", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotLike(String value) {
            addCriterion("subordinate_platform_id not like", value, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdIn(List<String> values) {
            addCriterion("subordinate_platform_id in", values, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotIn(List<String> values) {
            addCriterion("subordinate_platform_id not in", values, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdBetween(String value1, String value2) {
            addCriterion("subordinate_platform_id between", value1, value2, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformIdNotBetween(String value1, String value2) {
            addCriterion("subordinate_platform_id not between", value1, value2, "subordinatePlatformId");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameIsNull() {
            addCriterion("subordinate_platform_name is null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameIsNotNull() {
            addCriterion("subordinate_platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameEqualTo(String value) {
            addCriterion("subordinate_platform_name =", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotEqualTo(String value) {
            addCriterion("subordinate_platform_name <>", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameGreaterThan(String value) {
            addCriterion("subordinate_platform_name >", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_name >=", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameLessThan(String value) {
            addCriterion("subordinate_platform_name <", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameLessThanOrEqualTo(String value) {
            addCriterion("subordinate_platform_name <=", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameLike(String value) {
            addCriterion("subordinate_platform_name like", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotLike(String value) {
            addCriterion("subordinate_platform_name not like", value, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameIn(List<String> values) {
            addCriterion("subordinate_platform_name in", values, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotIn(List<String> values) {
            addCriterion("subordinate_platform_name not in", values, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameBetween(String value1, String value2) {
            addCriterion("subordinate_platform_name between", value1, value2, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andSubordinatePlatformNameNotBetween(String value1, String value2) {
            addCriterion("subordinate_platform_name not between", value1, value2, "subordinatePlatformName");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andTimeNodeIsNull() {
            addCriterion("time_node is null");
            return (Criteria) this;
        }

        public Criteria andTimeNodeIsNotNull() {
            addCriterion("time_node is not null");
            return (Criteria) this;
        }

        public Criteria andTimeNodeEqualTo(String value) {
            addCriterion("time_node =", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeNotEqualTo(String value) {
            addCriterion("time_node <>", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeGreaterThan(String value) {
            addCriterion("time_node >", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeGreaterThanOrEqualTo(String value) {
            addCriterion("time_node >=", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeLessThan(String value) {
            addCriterion("time_node <", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeLessThanOrEqualTo(String value) {
            addCriterion("time_node <=", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeLike(String value) {
            addCriterion("time_node like", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeNotLike(String value) {
            addCriterion("time_node not like", value, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeIn(List<String> values) {
            addCriterion("time_node in", values, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeNotIn(List<String> values) {
            addCriterion("time_node not in", values, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeBetween(String value1, String value2) {
            addCriterion("time_node between", value1, value2, "timeNode");
            return (Criteria) this;
        }

        public Criteria andTimeNodeNotBetween(String value1, String value2) {
            addCriterion("time_node not between", value1, value2, "timeNode");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementIsNull() {
            addCriterion("is_roof_placement is null");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementIsNotNull() {
            addCriterion("is_roof_placement is not null");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementEqualTo(Byte value) {
            addCriterion("is_roof_placement =", value, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementNotEqualTo(Byte value) {
            addCriterion("is_roof_placement <>", value, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementGreaterThan(Byte value) {
            addCriterion("is_roof_placement >", value, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_roof_placement >=", value, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementLessThan(Byte value) {
            addCriterion("is_roof_placement <", value, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementLessThanOrEqualTo(Byte value) {
            addCriterion("is_roof_placement <=", value, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementIn(List<Byte> values) {
            addCriterion("is_roof_placement in", values, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementNotIn(List<Byte> values) {
            addCriterion("is_roof_placement not in", values, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementBetween(Byte value1, Byte value2) {
            addCriterion("is_roof_placement between", value1, value2, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andIsRoofPlacementNotBetween(Byte value1, Byte value2) {
            addCriterion("is_roof_placement not between", value1, value2, "isRoofPlacement");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationIsNull() {
            addCriterion("contact_phone_configuration is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationIsNotNull() {
            addCriterion("contact_phone_configuration is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationEqualTo(String value) {
            addCriterion("contact_phone_configuration =", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationNotEqualTo(String value) {
            addCriterion("contact_phone_configuration <>", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationGreaterThan(String value) {
            addCriterion("contact_phone_configuration >", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone_configuration >=", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationLessThan(String value) {
            addCriterion("contact_phone_configuration <", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationLessThanOrEqualTo(String value) {
            addCriterion("contact_phone_configuration <=", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationLike(String value) {
            addCriterion("contact_phone_configuration like", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationNotLike(String value) {
            addCriterion("contact_phone_configuration not like", value, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationIn(List<String> values) {
            addCriterion("contact_phone_configuration in", values, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationNotIn(List<String> values) {
            addCriterion("contact_phone_configuration not in", values, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationBetween(String value1, String value2) {
            addCriterion("contact_phone_configuration between", value1, value2, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andContactPhoneConfigurationNotBetween(String value1, String value2) {
            addCriterion("contact_phone_configuration not between", value1, value2, "contactPhoneConfiguration");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentIsNull() {
            addCriterion("announcement_content is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentIsNotNull() {
            addCriterion("announcement_content is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentEqualTo(String value) {
            addCriterion("announcement_content =", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotEqualTo(String value) {
            addCriterion("announcement_content <>", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentGreaterThan(String value) {
            addCriterion("announcement_content >", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentGreaterThanOrEqualTo(String value) {
            addCriterion("announcement_content >=", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentLessThan(String value) {
            addCriterion("announcement_content <", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentLessThanOrEqualTo(String value) {
            addCriterion("announcement_content <=", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentLike(String value) {
            addCriterion("announcement_content like", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotLike(String value) {
            addCriterion("announcement_content not like", value, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentIn(List<String> values) {
            addCriterion("announcement_content in", values, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotIn(List<String> values) {
            addCriterion("announcement_content not in", values, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentBetween(String value1, String value2) {
            addCriterion("announcement_content between", value1, value2, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andAnnouncementContentNotBetween(String value1, String value2) {
            addCriterion("announcement_content not between", value1, value2, "announcementContent");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesIsNull() {
            addCriterion("browse_times is null");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesIsNotNull() {
            addCriterion("browse_times is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesEqualTo(Integer value) {
            addCriterion("browse_times =", value, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesNotEqualTo(Integer value) {
            addCriterion("browse_times <>", value, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesGreaterThan(Integer value) {
            addCriterion("browse_times >", value, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_times >=", value, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesLessThan(Integer value) {
            addCriterion("browse_times <", value, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("browse_times <=", value, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesIn(List<Integer> values) {
            addCriterion("browse_times in", values, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesNotIn(List<Integer> values) {
            addCriterion("browse_times not in", values, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesBetween(Integer value1, Integer value2) {
            addCriterion("browse_times between", value1, value2, "browseTimes");
            return (Criteria) this;
        }

        public Criteria andBrowseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_times not between", value1, value2, "browseTimes");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
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

        public Criteria andBriefIntroductIsNull() {
            addCriterion("brief_introduct is null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductIsNotNull() {
            addCriterion("brief_introduct is not null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductEqualTo(String value) {
            addCriterion("brief_introduct =", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductNotEqualTo(String value) {
            addCriterion("brief_introduct <>", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductGreaterThan(String value) {
            addCriterion("brief_introduct >", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductGreaterThanOrEqualTo(String value) {
            addCriterion("brief_introduct >=", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductLessThan(String value) {
            addCriterion("brief_introduct <", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductLessThanOrEqualTo(String value) {
            addCriterion("brief_introduct <=", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductLike(String value) {
            addCriterion("brief_introduct like", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductNotLike(String value) {
            addCriterion("brief_introduct not like", value, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductIn(List<String> values) {
            addCriterion("brief_introduct in", values, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductNotIn(List<String> values) {
            addCriterion("brief_introduct not in", values, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductBetween(String value1, String value2) {
            addCriterion("brief_introduct between", value1, value2, "briefIntroduct");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductNotBetween(String value1, String value2) {
            addCriterion("brief_introduct not between", value1, value2, "briefIntroduct");
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