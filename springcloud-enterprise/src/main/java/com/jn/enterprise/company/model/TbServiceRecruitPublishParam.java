package com.jn.enterprise.company.model;

import java.io.Serializable;

public class TbServiceRecruitPublishParam implements Serializable {
    private String id;

    private String recruitNo;

    private String comId;

    private String comName;

    private String post;

    private String salary;

    private String num;

    private String type;

    private String details;

    private String status;

    private String viewCount;

    private String approvalStatus;

    private String creatorAccount;

    private String createdTime;

    private String modifierAccount;

    private String modifiedTime;

    private String recordStatus;

    private static final long serialVersionUID = 1L;

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecruitNo() {
        return recruitNo;
    }

    public void setRecruitNo(String recruitNo) {
        this.recruitNo = recruitNo;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "TbServiceRecruitPublishParam{" +
                "id='" + id + '\'' +
                ", recruitNo='" + recruitNo + '\'' +
                ", comId='" + comId + '\'' +
                ", comName='" + comName + '\'' +
                ", post='" + post + '\'' +
                ", salary='" + salary + '\'' +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                '}';
    }
}