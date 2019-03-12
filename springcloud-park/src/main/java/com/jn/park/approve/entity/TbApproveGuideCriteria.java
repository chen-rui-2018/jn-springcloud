package com.jn.park.approve.entity;

import java.util.ArrayList;
import java.util.List;

public class TbApproveGuideCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbApproveGuideCriteria() {
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
            addCriterion("g.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("g.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("g.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("g.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("g.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("g.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("g.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("g.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("g.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("g.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("g.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("g.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("g.name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("g.name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("g.name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("g.name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("g.name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("g.name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("g.name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("g.name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("g.name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("g.name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("g.name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("g.name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("g.name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("g.name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("g.parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("g.parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("g.parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("g.parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("g.parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("g.parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("g.parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("g.parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("g.parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("g.parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("g.parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("g.parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andRootNameIsNull() {
            addCriterion("g.root_name is null");
            return (Criteria) this;
        }

        public Criteria andRootNameIsNotNull() {
            addCriterion("g.root_name is not null");
            return (Criteria) this;
        }

        public Criteria andRootNameEqualTo(String value) {
            addCriterion("g.root_name =", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotEqualTo(String value) {
            addCriterion("g.root_name <>", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameGreaterThan(String value) {
            addCriterion("g.root_name >", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameGreaterThanOrEqualTo(String value) {
            addCriterion("g.root_name >=", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameLessThan(String value) {
            addCriterion("g.root_name <", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameLessThanOrEqualTo(String value) {
            addCriterion("g.root_name <=", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameLike(String value) {
            addCriterion("g.root_name like", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotLike(String value) {
            addCriterion("g.root_name not like", value, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameIn(List<String> values) {
            addCriterion("g.root_name in", values, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotIn(List<String> values) {
            addCriterion("g.root_name not in", values, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameBetween(String value1, String value2) {
            addCriterion("g.root_name between", value1, value2, "rootName");
            return (Criteria) this;
        }

        public Criteria andRootNameNotBetween(String value1, String value2) {
            addCriterion("g.root_name not between", value1, value2, "rootName");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("g.level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("g.level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Byte value) {
            addCriterion("g.level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Byte value) {
            addCriterion("g.level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Byte value) {
            addCriterion("g.level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("g.level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Byte value) {
            addCriterion("g.level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Byte value) {
            addCriterion("g.level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Byte> values) {
            addCriterion("g.level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Byte> values) {
            addCriterion("g.level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Byte value1, Byte value2) {
            addCriterion("g.level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("g.level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andIsPageIsNull() {
            addCriterion("g.is_page is null");
            return (Criteria) this;
        }

        public Criteria andIsPageIsNotNull() {
            addCriterion("g.is_page is not null");
            return (Criteria) this;
        }

        public Criteria andIsPageEqualTo(Byte value) {
            addCriterion("g.is_page =", value, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageNotEqualTo(Byte value) {
            addCriterion("g.is_page <>", value, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageGreaterThan(Byte value) {
            addCriterion("g.is_page >", value, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageGreaterThanOrEqualTo(Byte value) {
            addCriterion("g.is_page >=", value, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageLessThan(Byte value) {
            addCriterion("g.is_page <", value, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageLessThanOrEqualTo(Byte value) {
            addCriterion("g.is_page <=", value, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageIn(List<Byte> values) {
            addCriterion("g.is_page in", values, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageNotIn(List<Byte> values) {
            addCriterion("g.is_page not in", values, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageBetween(Byte value1, Byte value2) {
            addCriterion("g.is_page between", value1, value2, "isPage");
            return (Criteria) this;
        }

        public Criteria andIsPageNotBetween(Byte value1, Byte value2) {
            addCriterion("g.is_page not between", value1, value2, "isPage");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("g.code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("g.code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("g.code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("g.code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("g.code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("g.code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("g.code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("g.code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("g.code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("g.code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("g.code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("g.code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("g.code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("g.code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDefaultSortIsNull() {
            addCriterion("g.default_sort is null");
            return (Criteria) this;
        }

        public Criteria andDefaultSortIsNotNull() {
            addCriterion("g.default_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultSortEqualTo(Integer value) {
            addCriterion("g.default_sort =", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortNotEqualTo(Integer value) {
            addCriterion("g.default_sort <>", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortGreaterThan(Integer value) {
            addCriterion("g.default_sort >", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("g.default_sort >=", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortLessThan(Integer value) {
            addCriterion("g.default_sort <", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortLessThanOrEqualTo(Integer value) {
            addCriterion("g.default_sort <=", value, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortIn(List<Integer> values) {
            addCriterion("g.default_sort in", values, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortNotIn(List<Integer> values) {
            addCriterion("g.default_sort not in", values, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortBetween(Integer value1, Integer value2) {
            addCriterion("g.default_sort between", value1, value2, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andDefaultSortNotBetween(Integer value1, Integer value2) {
            addCriterion("g.default_sort not between", value1, value2, "defaultSort");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlIsNull() {
            addCriterion("g.type_image_url is null");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlIsNotNull() {
            addCriterion("g.type_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlEqualTo(String value) {
            addCriterion("g.type_image_url =", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlNotEqualTo(String value) {
            addCriterion("g.type_image_url <>", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlGreaterThan(String value) {
            addCriterion("g.type_image_url >", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("g.type_image_url >=", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlLessThan(String value) {
            addCriterion("g.type_image_url <", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlLessThanOrEqualTo(String value) {
            addCriterion("g.type_image_url <=", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlLike(String value) {
            addCriterion("g.type_image_url like", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlNotLike(String value) {
            addCriterion("g.type_image_url not like", value, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlIn(List<String> values) {
            addCriterion("g.type_image_url in", values, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlNotIn(List<String> values) {
            addCriterion("g.type_image_url not in", values, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlBetween(String value1, String value2) {
            addCriterion("g.type_image_url between", value1, value2, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andTypeImageUrlNotBetween(String value1, String value2) {
            addCriterion("g.type_image_url not between", value1, value2, "typeImageUrl");
            return (Criteria) this;
        }

        public Criteria andHomeSortIsNull() {
            addCriterion("g.home_sort is null");
            return (Criteria) this;
        }

        public Criteria andHomeSortIsNotNull() {
            addCriterion("g.home_sort is not null");
            return (Criteria) this;
        }

        public Criteria andHomeSortEqualTo(Integer value) {
            addCriterion("g.home_sort =", value, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortNotEqualTo(Integer value) {
            addCriterion("g.home_sort <>", value, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortGreaterThan(Integer value) {
            addCriterion("g.home_sort >", value, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("g.home_sort >=", value, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortLessThan(Integer value) {
            addCriterion("g.home_sort <", value, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortLessThanOrEqualTo(Integer value) {
            addCriterion("g.home_sort <=", value, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortIn(List<Integer> values) {
            addCriterion("g.home_sort in", values, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortNotIn(List<Integer> values) {
            addCriterion("g.home_sort not in", values, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortBetween(Integer value1, Integer value2) {
            addCriterion("g.home_sort between", value1, value2, "homeSort");
            return (Criteria) this;
        }

        public Criteria andHomeSortNotBetween(Integer value1, Integer value2) {
            addCriterion("g.home_sort not between", value1, value2, "homeSort");
            return (Criteria) this;
        }

        public Criteria andTopSortIsNull() {
            addCriterion("g.top_sort is null");
            return (Criteria) this;
        }

        public Criteria andTopSortIsNotNull() {
            addCriterion("g.top_sort is not null");
            return (Criteria) this;
        }

        public Criteria andTopSortEqualTo(Integer value) {
            addCriterion("g.top_sort =", value, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortNotEqualTo(Integer value) {
            addCriterion("g.top_sort <>", value, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortGreaterThan(Integer value) {
            addCriterion("g.top_sort >", value, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("g.top_sort >=", value, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortLessThan(Integer value) {
            addCriterion("g.top_sort <", value, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortLessThanOrEqualTo(Integer value) {
            addCriterion("g.top_sort <=", value, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortIn(List<Integer> values) {
            addCriterion("g.top_sort in", values, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortNotIn(List<Integer> values) {
            addCriterion("g.top_sort not in", values, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortBetween(Integer value1, Integer value2) {
            addCriterion("g.top_sort between", value1, value2, "topSort");
            return (Criteria) this;
        }

        public Criteria andTopSortNotBetween(Integer value1, Integer value2) {
            addCriterion("g.top_sort not between", value1, value2, "topSort");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("g.show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("g.show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(String value) {
            addCriterion("g.show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(String value) {
            addCriterion("g.show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(String value) {
            addCriterion("g.show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("g.show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(String value) {
            addCriterion("g.show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(String value) {
            addCriterion("g.show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLike(String value) {
            addCriterion("g.show_status like", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotLike(String value) {
            addCriterion("g.show_status not like", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<String> values) {
            addCriterion("g.show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<String> values) {
            addCriterion("g.show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(String value1, String value2) {
            addCriterion("g.show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(String value1, String value2) {
            addCriterion("g.show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("g.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("g.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("g.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("g.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("g.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("g.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("g.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("g.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("g.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("g.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("g.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("g.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("g.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("g.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("g.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("g.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("g.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("g.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("g.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("g.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("g.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("g.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("g.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("g.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("g.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("g.creator_account not between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("g.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("g.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(String value) {
            addCriterion("g.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(String value) {
            addCriterion("g.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(String value) {
            addCriterion("g.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("g.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(String value) {
            addCriterion("g.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(String value) {
            addCriterion("g.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLike(String value) {
            addCriterion("g.created_time like", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotLike(String value) {
            addCriterion("g.created_time not like", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<String> values) {
            addCriterion("g.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<String> values) {
            addCriterion("g.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(String value1, String value2) {
            addCriterion("g.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(String value1, String value2) {
            addCriterion("g.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("g.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("g.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("g.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("g.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("g.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("g.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("g.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("g.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("g.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("g.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("g.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("g.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("g.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("g.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("g.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("g.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(String value) {
            addCriterion("g.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(String value) {
            addCriterion("g.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(String value) {
            addCriterion("g.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("g.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(String value) {
            addCriterion("g.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(String value) {
            addCriterion("g.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLike(String value) {
            addCriterion("g.modified_time like", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotLike(String value) {
            addCriterion("g.modified_time not like", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<String> values) {
            addCriterion("g.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<String> values) {
            addCriterion("g.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(String value1, String value2) {
            addCriterion("g.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(String value1, String value2) {
            addCriterion("g.modified_time not between", value1, value2, "modifiedTime");
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