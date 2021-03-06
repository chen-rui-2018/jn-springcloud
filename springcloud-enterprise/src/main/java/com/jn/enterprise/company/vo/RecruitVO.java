package com.jn.enterprise.company.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.util.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "RecruitVO", description = "招聘列表出参")
public class RecruitVO implements Serializable {
    @ApiModelProperty(value = "招聘ID")
    private String id;
    @ApiModelProperty(value = "招聘编号")
    private String recruitNo;
    @ApiModelProperty(value = "招聘岗位")
    private String post;
    @ApiModelProperty(value = "招聘人数")
    private Integer num;
    @ApiModelProperty(value = "状态（1：已上架 0：已下架）")
    private String status;
    @ApiModelProperty(value = "关注状态（1：已关注 0：未关注）")
    private String careStatus;
    @ApiModelProperty(value = "有效性")
    private String statusName;
    @ApiModelProperty(value = "浏览数")
    private Integer viewCount;
    @ApiModelProperty(value = "企业ID")
    private String comId;
    @ApiModelProperty(value = "企业名称")
    private String comName;
    @ApiModelProperty(value = "企业logo")
    private String comAvatar;
    @ApiModelProperty(value = "招聘类型名称")
    private String typeName;
    @ApiModelProperty(value = "招聘类型")
    private String type;
    @ApiModelProperty(value = "薪资待遇名称")
    private String salaryName;
    @ApiModelProperty(value = "薪资待遇")
    private String salary;
    @ApiModelProperty(value = "审批状态（0未审批 1审批中 2审批通过 3未通过审批）")
    private String approvalStatus;
    @ApiModelProperty(value = "招聘详情")
    private String details;
    @ApiModelProperty(value = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    private static final long serialVersionUID = 1L;

    {
        this.careStatus = "0";
    }

    public String getCareStatus() {
        return careStatus;
    }

    public void setCareStatus(String careStatus) {
        this.careStatus = careStatus;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComAvatar() {
        return comAvatar;
    }

    public void setComAvatar(String comAvatar) {
        this.comAvatar = comAvatar;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecruitNo() {
        return recruitNo;
    }

    public void setRecruitNo(String recruitNo) {
        this.recruitNo = recruitNo;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "RecruitVO{" +
                "id='" + id + '\'' +
                ", recruitNo='" + recruitNo + '\'' +
                ", post='" + post + '\'' +
                ", num=" + num +
                ", status='" + status + '\'' +
                ", careStatus='" + careStatus + '\'' +
                ", statusName='" + statusName + '\'' +
                ", viewCount=" + viewCount +
                ", comId='" + comId + '\'' +
                ", comName='" + comName + '\'' +
                ", comAvatar='" + comAvatar + '\'' +
                ", typeName='" + typeName + '\'' +
                ", type='" + type + '\'' +
                ", salaryName='" + salaryName + '\'' +
                ", salary='" + salary + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", details='" + details + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}