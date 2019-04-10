package com.jn.enterprise.pd.personnel.vo;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业-完善申报资料
 *
 * @author： wzy
 * @date： Created on 2019/3/19 15:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel("企业-完善申报资料")
public class PersonnelFlow3010Vo extends PersonnelFlowNodeBaseAbstractVo implements Serializable {
    private static final long serialVersionUID = 57886291825587577L;

    @Override
    public PersonnelFlowNodeEnum getFlowNodeEnum() {
        return PersonnelFlowNodeEnum.THREE_ADD_INFO_10;
    }

    @ApiModelProperty("唯一标识符")
    private Integer id;

    @ApiModelProperty("申报人姓名")
    private String declarerName;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("产业领域ID")
    private String industrialFieldId;

    @ApiModelProperty("产业领域名称")
    private String industrialFieldName;

    @ApiModelProperty("身份证号")
    private String idNumber;

    @ApiModelProperty("毕业院校")
    private String graduateInstitutions;

    @ApiModelProperty("学历ID")
    private String educaId;

    @ApiModelProperty("学历名称")
    private String educaName;

    @ApiModelProperty("工作单位")
    private String workUnit;

    @ApiModelProperty("职务")
    private String business;

    @ApiModelProperty("是否有留学（1：是，2：否）")
    private Byte isOverseasStudy;

    @ApiModelProperty("是否有创业经历（1：是，2：否）")
    private Byte isEntrepreneurialExperience;

    @ApiModelProperty("是否注册落地（1：是，2：否）")
    private Byte isRegistrationLand;

    @ApiModelProperty("联系人")
    private String contactName;

    @ApiModelProperty("联系人电话")
    private String contactTelephone;

    @ApiModelProperty("项目简介")
    private String projectSynopsis;

    @ApiModelProperty("项目ID")
    private Integer projectId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeclarerName() {
        return declarerName;
    }

    public void setDeclarerName(String declarerName) {
        this.declarerName = declarerName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getIndustrialFieldId() {
        return industrialFieldId;
    }

    public void setIndustrialFieldId(String industrialFieldId) {
        this.industrialFieldId = industrialFieldId;
    }

    public String getIndustrialFieldName() {
        return industrialFieldName;
    }

    public void setIndustrialFieldName(String industrialFieldName) {
        this.industrialFieldName = industrialFieldName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions;
    }

    public String getEducaId() {
        return educaId;
    }

    public void setEducaId(String educaId) {
        this.educaId = educaId;
    }

    public String getEducaName() {
        return educaName;
    }

    public void setEducaName(String educaName) {
        this.educaName = educaName;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Byte getIsOverseasStudy() {
        return isOverseasStudy;
    }

    public void setIsOverseasStudy(Byte isOverseasStudy) {
        this.isOverseasStudy = isOverseasStudy;
    }

    public Byte getIsEntrepreneurialExperience() {
        return isEntrepreneurialExperience;
    }

    public void setIsEntrepreneurialExperience(Byte isEntrepreneurialExperience) {
        this.isEntrepreneurialExperience = isEntrepreneurialExperience;
    }

    public Byte getIsRegistrationLand() {
        return isRegistrationLand;
    }

    public void setIsRegistrationLand(Byte isRegistrationLand) {
        this.isRegistrationLand = isRegistrationLand;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getProjectSynopsis() {
        return projectSynopsis;
    }

    public void setProjectSynopsis(String projectSynopsis) {
        this.projectSynopsis = projectSynopsis;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
