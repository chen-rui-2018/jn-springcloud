package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/27 10:20
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorBaseInfo", description = "顾问资料基本信息")
public class AdvisorBaseInfo  implements Serializable {
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "机构Id")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "顾问账号",required = true)
    @NotNull(message="顾问账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "从业年限")
    @Size(max=50,message="从业年限只能是数值，且小于50")
    private Double workingYears;
    @ApiModelProperty(value = "毕业学校")
    private String graduatedSchool;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "联系手机")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;
    @ApiModelProperty(value = "联系邮箱")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",
            message = "{email:'邮箱验证出错'}")
    private String contactEmail;
    @ApiModelProperty(value = "执业资质")
    private String practiceQualification;
    @ApiModelProperty(value = "业务擅长")
    private String goodAtBusiness;
    @ApiModelProperty(value = "业务领域")
    private String businessArea;
    @ApiModelProperty(value = "个人简介")
    private String personalProfile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPracticeQualification() {
        return practiceQualification;
    }

    public void setPracticeQualification(String practiceQualification) {
        this.practiceQualification = practiceQualification;
    }

    public String getGoodAtBusiness() {
        return goodAtBusiness;
    }

    public void setGoodAtBusiness(String goodAtBusiness) {
        this.goodAtBusiness = goodAtBusiness;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    @Override
    public String toString() {
        return "AdvisorBaseInfo{" +
                "advisorAccount='" + advisorAccount + '\'' +
                ", workingYears=" + workingYears +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", practiceQualification='" + practiceQualification + '\'' +
                ", goodAtBusiness='" + goodAtBusiness + '\'' +
                ", businessArea='" + businessArea + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                '}';
    }
}
