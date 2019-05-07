package com.jn.enterprise.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 人才申报实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/28 15:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PersonnelProject", description = "人才申报实体类")
public class PersonnelProject extends Page implements Serializable {
    private static final long serialVersionUID = -7170411209882050318L;

    @ApiModelProperty(value = "企业（团队）名称",example = "企业测试")
    private String name;

    @ApiModelProperty(value = "统一社会信用代码",example = "0000001")
    private String creditCode;

    @ApiModelProperty(value = "类型",example = "1")
    private String type;

    @ApiModelProperty(value = "产业领域",example = "1000_1")
    private String industrial;

    @ApiModelProperty(value = "企业法人",example = "张三")
    private String companyPerson;

    @ApiModelProperty(value = "公司地址",example = "")
    private String companyAddress;

    @ApiModelProperty(value = "企业LOGO",example = "")
    private String companyLogo;

    @ApiModelProperty(value = "企业简介",example = "")
    private String companyIntroduce;

    @ApiModelProperty(value = "项目名称（团队）",example = "")
    private String projectName;

    @ApiModelProperty(value = "联系人姓名",example = "")
    private String contactName;

    @ApiModelProperty(value = "联系人电话",example = "")
    private String contactPhone;

    @ApiModelProperty(value = "联系人电子邮箱",example = "")
    private String contactEmail;

    @ApiModelProperty(value = "所在阶段ID",example = "8060")
    private Short stepId;

    @ApiModelProperty(value = "创建人",example = "")
    private String createBy;

    @ApiModelProperty(value = "创建时间", example = "2019-03-22 12:12:12")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新人",example = "")
    private String updateBy;

    @ApiModelProperty(value = "更新时间", example = "2019-03-22 12:12:12")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndustrial() {
        return industrial;
    }

    public void setIndustrial(String industrial) {
        this.industrial = industrial;
    }

    public String getCompanyPerson() {
        return companyPerson;
    }

    public void setCompanyPerson(String companyPerson) {
        this.companyPerson = companyPerson;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Short getStepId() {
        return stepId;
    }

    public void setStepId(Short stepId) {
        this.stepId = stepId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
