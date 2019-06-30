package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/23 17:48
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorManagementShow",description = "专员管理出参")
public class AdvisorManagementShow implements Serializable {
    @ApiModelProperty(value = "专员名称")
    private String advisorName;
    @ApiModelProperty(value = "专员账号（注册手机/邮箱）")
    private String advisorAccount;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "从业年限")
    private Float workingYears;
    @ApiModelProperty(value = "毕业学校")
    private String graduatedSchool;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "入驻日期")
    private String createdTime;
    @ApiModelProperty(value = "邀请状态(- 1：已拒绝    0：未反馈   1：待审批   2：审批通过  3：审批不通过  4：已解除)")
    private String approvalStatus;
    @ApiModelProperty(value = "头像")
    private String avatar;

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Float workingYears) {
        this.workingYears = workingYears;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "AdvisorManagementShow{" +
                "advisorName='" + advisorName + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", position='" + position + '\'' +
                ", workingYears=" + workingYears +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", education='" + education + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
