package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/3/23 17:48
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorManagementShow",description = "顾问管理出参")
public class AdvisorManagementShow implements Serializable {
    @ApiModelProperty(value = "顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "顾问账号（注册手机/邮箱）")
    private String advisorAccount;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "从业年限")
    private Double workingYears;
    @ApiModelProperty(value = "毕业学校")
    private String graduatedSchool;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "入驻日期")
    private Date createdTime;
    @ApiModelProperty(value = "邀请状态(- 1：已拒绝    0：未反馈   1：待审批   2：审批通过  3：审批不通过  4：已解除)")
    private String approvalStatus;

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

    public Double getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Double workingYears) {
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
