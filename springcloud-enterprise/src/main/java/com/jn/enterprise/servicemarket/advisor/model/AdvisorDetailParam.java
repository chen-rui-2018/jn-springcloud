package com.jn.enterprise.servicemarket.advisor.model;

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
@ApiModel(value = "AdvisorDetailParam", description = "专员认证资料信息")
public class AdvisorDetailParam implements Serializable {
    @ApiModelProperty(value = "机构Id",required = true,example = "123xxx")
    @NotNull(message = "机构id不能为空")
    private String orgId;
    @ApiModelProperty(value = "机构名称",example = "xxx机构")
    private String orgName;
    @NotNull(message="业务领域不能为空")
    @ApiModelProperty(value = "业务领域",required = true,example = "technology_finance")
    private String businessArea;
    @NotNull(message="从业年限不能为空")
    @Pattern(regexp = "^([0-9]*)|([0-9]*)(\\.[0-9]{0,2})$",message = "workingYears:从业年限只能输入的数字和小数点")
    @Size(max=60,message = "从业年限最多为60年")
    @ApiModelProperty(value = "从业年限",required = true,example = "10")
    private String workingYears;
    @NotNull(message="毕业学校不能为空")
    @ApiModelProperty(value = "毕业学校",required = true,example = "xxx学校")
    private String graduatedSchool;
    @ApiModelProperty(value = "学历",required = true,example = "本科")
    @NotNull(message="学历不能为空")
    private String education;
    @ApiModelProperty(value = "个人简介", required = true,example = "xxx个人简介")
    @NotNull(message="个人简介不能为空")
    private String personalProfile;
    @ApiModelProperty(value = "联系手机",required = true,example = "18088888888")
    @NotNull(message="联系手机不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;
    @ApiModelProperty(value = "联系邮箱",required = true,example = "123@126.com")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",
            message = "{email:'邮箱验证出错'}")
    private String contactEmail;

    @ApiModelProperty(value = "荣誉资质")
    private List<ServiceHonorParam> serviceHonors;

    @ApiModelProperty(value = "项目经验")
    private List<ServiceProjectExperienceParam> projectExperiences;

    @ApiModelProperty(value = "服务经验")
    private List<ServiceExperienceParam> serviceExperiences;

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

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
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

    public List<ServiceHonorParam> getServiceHonors() {
        return serviceHonors;
    }

    public void setServiceHonors(List<ServiceHonorParam> serviceHonors) {
        this.serviceHonors = serviceHonors;
    }

    public List<ServiceProjectExperienceParam> getProjectExperiences() {
        return projectExperiences;
    }

    public void setProjectExperiences(List<ServiceProjectExperienceParam> projectExperiences) {
        this.projectExperiences = projectExperiences;
    }

    public List<ServiceExperienceParam> getServiceExperiences() {
        return serviceExperiences;
    }

    public void setServiceExperiences(List<ServiceExperienceParam> serviceExperiences) {
        this.serviceExperiences = serviceExperiences;
    }
}
