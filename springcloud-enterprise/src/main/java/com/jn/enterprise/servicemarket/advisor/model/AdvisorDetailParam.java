package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: jiangyl
 * @Date: 2019/2/27 10:20
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorDetailParam", description = "顾问认证资料信息")
public class AdvisorDetailParam implements Serializable {

    @ApiModelProperty(value = "业务领域")
    private String businessArea;
    @ApiModelProperty(value = "从业年限")
    @Size(max=50,message="从业年限只能是数值，且小于50")
    private Float workingYears;
    @ApiModelProperty(value = "毕业学校")
    private String graduatedSchool;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "个人简介")
    private String personalProfile;
    @ApiModelProperty(value = "联系手机")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;
    @ApiModelProperty(value = "联系邮箱")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",
            message = "{email:'邮箱验证出错'}")
    private String contactEmail;

    @ApiModelProperty(value = "荣誉资质")
    private List<ServiceHonor> serviceHonors;

    @ApiModelProperty(value = "项目经验")
    private List<ServiceProjectExperience> projectExperiences;

    @ApiModelProperty(value = "服务经验")
    private List<ServiceExperience> serviceExperiences;

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
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

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
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

    public List<ServiceHonor> getServiceHonors() {
        return serviceHonors;
    }

    public void setServiceHonors(List<ServiceHonor> serviceHonors) {
        this.serviceHonors = serviceHonors;
    }

    public List<ServiceProjectExperience> getProjectExperiences() {
        return projectExperiences;
    }

    public void setProjectExperiences(List<ServiceProjectExperience> projectExperiences) {
        this.projectExperiences = projectExperiences;
    }

    public List<ServiceExperience> getServiceExperiences() {
        return serviceExperiences;
    }

    public void setServiceExperiences(List<ServiceExperience> serviceExperiences) {
        this.serviceExperiences = serviceExperiences;
    }
}
