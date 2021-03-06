package com.jn.park.finance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFinanceDocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFinanceDocumentExample() {
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
            addCriterion("doc.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("doc.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("doc.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("doc.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("doc.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("doc.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("doc.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("doc.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("doc.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("doc.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doc.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNull() {
            addCriterion("doc.doc_Id is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("doc.doc_Id is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(String value) {
            addCriterion("doc.doc_Id =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(String value) {
            addCriterion("doc.doc_Id <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(String value) {
            addCriterion("doc.doc_Id >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("doc.doc_Id >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(String value) {
            addCriterion("doc.doc_Id <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(String value) {
            addCriterion("doc.doc_Id <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLike(String value) {
            addCriterion("doc.doc_Id like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotLike(String value) {
            addCriterion("doc.doc_Id not like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<String> values) {
            addCriterion("doc.doc_Id in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<String> values) {
            addCriterion("doc.doc_Id not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(String value1, String value2) {
            addCriterion("doc.doc_Id between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(String value1, String value2) {
            addCriterion("doc.doc_Id not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("doc.department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("doc.department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("doc.department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("doc.department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("doc.department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("doc.department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("doc.department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("doc.department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("doc.department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("doc.department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("doc.department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("doc.department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("doc.department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("doc.department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("doc.department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("doc.department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("doc.department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("doc.department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("doc.department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("doc.department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("doc.department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("doc.department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("doc.department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("doc.department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("doc.department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("doc.department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("doc.department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("doc.department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNull() {
            addCriterion("doc.doc_name is null");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNotNull() {
            addCriterion("doc.doc_name is not null");
            return (Criteria) this;
        }

        public Criteria andDocNameEqualTo(String value) {
            addCriterion("doc.doc_name =", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("doc.doc_name <>", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("doc.doc_name >", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("doc.doc_name >=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThan(String value) {
            addCriterion("doc.doc_name <", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("doc.doc_name <=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLike(String value) {
            addCriterion("doc.doc_name like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotLike(String value) {
            addCriterion("doc.doc_name not like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameIn(List<String> values) {
            addCriterion("doc.doc_name in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("doc.doc_name not in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("doc.doc_name between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("doc.doc_name not between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocUploaderIsNull() {
            addCriterion("doc.doc_uploader is null");
            return (Criteria) this;
        }

        public Criteria andDocUploaderIsNotNull() {
            addCriterion("doc.doc_uploader is not null");
            return (Criteria) this;
        }

        public Criteria andDocUploaderEqualTo(String value) {
            addCriterion("doc.doc_uploader =", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderNotEqualTo(String value) {
            addCriterion("doc.doc_uploader <>", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderGreaterThan(String value) {
            addCriterion("doc.doc_uploader >", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderGreaterThanOrEqualTo(String value) {
            addCriterion("doc.doc_uploader >=", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderLessThan(String value) {
            addCriterion("doc.doc_uploader <", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderLessThanOrEqualTo(String value) {
            addCriterion("doc.doc_uploader <=", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderLike(String value) {
            addCriterion("doc.doc_uploader like", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderNotLike(String value) {
            addCriterion("doc.doc_uploader not like", value, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderIn(List<String> values) {
            addCriterion("doc.doc_uploader in", values, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderNotIn(List<String> values) {
            addCriterion("doc.doc_uploader not in", values, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderBetween(String value1, String value2) {
            addCriterion("doc.doc_uploader between", value1, value2, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploaderNotBetween(String value1, String value2) {
            addCriterion("doc.doc_uploader not between", value1, value2, "docUploader");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeIsNull() {
            addCriterion("doc.doc_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeIsNotNull() {
            addCriterion("doc.doc_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeEqualTo(Date value) {
            addCriterion("doc.doc_upload_time =", value, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeNotEqualTo(Date value) {
            addCriterion("doc.doc_upload_time <>", value, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeGreaterThan(Date value) {
            addCriterion("doc.doc_upload_time >", value, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc.doc_upload_time >=", value, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeLessThan(Date value) {
            addCriterion("doc.doc_upload_time <", value, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc.doc_upload_time <=", value, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeIn(List<Date> values) {
            addCriterion("doc.doc_upload_time in", values, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeNotIn(List<Date> values) {
            addCriterion("doc.doc_upload_time not in", values, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeBetween(Date value1, Date value2) {
            addCriterion("doc.doc_upload_time between", value1, value2, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andDocUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc.doc_upload_time not between", value1, value2, "docUploadTime");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("doc.comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("doc.comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("doc.comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("doc.comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("doc.comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("doc.comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("doc.comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("doc.comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("doc.comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("doc.comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("doc.comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("doc.comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("doc.comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("doc.comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andDocFilenameIsNull() {
            addCriterion("doc.doc_filename is null");
            return (Criteria) this;
        }

        public Criteria andDocFilenameIsNotNull() {
            addCriterion("doc.doc_filename is not null");
            return (Criteria) this;
        }

        public Criteria andDocFilenameEqualTo(String value) {
            addCriterion("doc.doc_filename =", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameNotEqualTo(String value) {
            addCriterion("doc.doc_filename <>", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameGreaterThan(String value) {
            addCriterion("doc.doc_filename >", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("doc.doc_filename >=", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameLessThan(String value) {
            addCriterion("doc.doc_filename <", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameLessThanOrEqualTo(String value) {
            addCriterion("doc.doc_filename <=", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameLike(String value) {
            addCriterion("doc.doc_filename like", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameNotLike(String value) {
            addCriterion("doc.doc_filename not like", value, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameIn(List<String> values) {
            addCriterion("doc.doc_filename in", values, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameNotIn(List<String> values) {
            addCriterion("doc.doc_filename not in", values, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameBetween(String value1, String value2) {
            addCriterion("doc.doc_filename between", value1, value2, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilenameNotBetween(String value1, String value2) {
            addCriterion("doc.doc_filename not between", value1, value2, "docFilename");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeIsNull() {
            addCriterion("doc.doc_filecode is null");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeIsNotNull() {
            addCriterion("doc.doc_filecode is not null");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeEqualTo(String value) {
            addCriterion("doc.doc_filecode =", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeNotEqualTo(String value) {
            addCriterion("doc.doc_filecode <>", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeGreaterThan(String value) {
            addCriterion("doc.doc_filecode >", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeGreaterThanOrEqualTo(String value) {
            addCriterion("doc.doc_filecode >=", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeLessThan(String value) {
            addCriterion("doc.doc_filecode <", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeLessThanOrEqualTo(String value) {
            addCriterion("doc.doc_filecode <=", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeLike(String value) {
            addCriterion("doc.doc_filecode like", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeNotLike(String value) {
            addCriterion("doc.doc_filecode not like", value, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeIn(List<String> values) {
            addCriterion("doc.doc_filecode in", values, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeNotIn(List<String> values) {
            addCriterion("doc.doc_filecode not in", values, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeBetween(String value1, String value2) {
            addCriterion("doc.doc_filecode between", value1, value2, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andDocFilecodeNotBetween(String value1, String value2) {
            addCriterion("doc.doc_filecode not between", value1, value2, "docFilecode");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("doc.record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("doc.record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Byte value) {
            addCriterion("doc.record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Byte value) {
            addCriterion("doc.record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Byte value) {
            addCriterion("doc.record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("doc.record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Byte value) {
            addCriterion("doc.record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Byte value) {
            addCriterion("doc.record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Byte> values) {
            addCriterion("doc.record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Byte> values) {
            addCriterion("doc.record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Byte value1, Byte value2) {
            addCriterion("doc.record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("doc.record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("doc.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("doc.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("doc.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("doc.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("doc.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("doc.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("doc.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("doc.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("doc.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNull() {
            addCriterion("doc.modifier_account is null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIsNotNull() {
            addCriterion("doc.modifier_account is not null");
            return (Criteria) this;
        }

        public Criteria andModifierAccountEqualTo(String value) {
            addCriterion("doc.modifier_account =", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotEqualTo(String value) {
            addCriterion("doc.modifier_account <>", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThan(String value) {
            addCriterion("doc.modifier_account >", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountGreaterThanOrEqualTo(String value) {
            addCriterion("doc.modifier_account >=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThan(String value) {
            addCriterion("doc.modifier_account <", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLessThanOrEqualTo(String value) {
            addCriterion("doc.modifier_account <=", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountLike(String value) {
            addCriterion("doc.modifier_account like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotLike(String value) {
            addCriterion("doc.modifier_account not like", value, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountIn(List<String> values) {
            addCriterion("doc.modifier_account in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotIn(List<String> values) {
            addCriterion("doc.modifier_account not in", values, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountBetween(String value1, String value2) {
            addCriterion("doc.modifier_account between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifierAccountNotBetween(String value1, String value2) {
            addCriterion("doc.modifier_account not between", value1, value2, "modifierAccount");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("doc.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("doc.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("doc.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("doc.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("doc.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("doc.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("doc.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("doc.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("doc.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("doc.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("doc.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("doc.modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNull() {
            addCriterion("doc.creator_account is null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIsNotNull() {
            addCriterion("doc.creator_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountEqualTo(String value) {
            addCriterion("doc.creator_account =", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotEqualTo(String value) {
            addCriterion("doc.creator_account <>", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThan(String value) {
            addCriterion("doc.creator_account >", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountGreaterThanOrEqualTo(String value) {
            addCriterion("doc.creator_account >=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThan(String value) {
            addCriterion("doc.creator_account <", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLessThanOrEqualTo(String value) {
            addCriterion("doc.creator_account <=", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountLike(String value) {
            addCriterion("doc.creator_account like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotLike(String value) {
            addCriterion("doc.creator_account not like", value, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountIn(List<String> values) {
            addCriterion("doc.creator_account in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotIn(List<String> values) {
            addCriterion("doc.creator_account not in", values, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountBetween(String value1, String value2) {
            addCriterion("doc.creator_account between", value1, value2, "creatorAccount");
            return (Criteria) this;
        }

        public Criteria andCreatorAccountNotBetween(String value1, String value2) {
            addCriterion("doc.creator_account not between", value1, value2, "creatorAccount");
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