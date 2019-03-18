package com.jn.enterprise.pd.personnel.model;

import com.jn.enterprise.pd.personnel.enums.PersonnelFlowNodeEnum;
import com.jn.enterprise.pd.personnel.vo.PersonnelFlowNodeBaseAbstractVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *
 * @author： huangbq
 * @date： Created on 2019/3/15 1:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel("人才意向申报")
public class PersonnelFirstStart10Model extends PersonnelFlowNodeBaseAbstractVo implements Serializable {

    public PersonnelFirstStart10Model(String nodeNo) {
        //初始化流程 流程所在的节点
        super(PersonnelFlowNodeEnum.FIRST_START_10.getNodeNo());
    }

    @Override
    public String getNextFormAction() {
        return "/person/first/10";
    }


    @ApiModelProperty("企业（团队）名称")
    private String name;

    @ApiModelProperty("统一社会信用代码")
    private String unifiedSocialCredit;

    @ApiModelProperty("产业领域ID")
    private Integer industrialFieldId;

    @ApiModelProperty("产业领域名称")
    private String industrialFieldName;

    @ApiModelProperty("企业法人")
    private String enterpriseLegalPerson;

    @ApiModelProperty("公司地址")
    private String companyAddress;

    @ApiModelProperty("企业logo")
    private String companyLogo;

    @ApiModelProperty("企业简介")
    private String companyProfile;


    @ApiModelProperty("联系人姓名")
    private String contactName;

    @ApiModelProperty("联系人电话")
    private String contactTelephone;

    @ApiModelProperty("联系人电子邮箱")
    private String contactEmail;

    @ApiModelProperty("项目介绍书附件地址")
    private String projectIntroductionFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnifiedSocialCredit() {
        return unifiedSocialCredit;
    }

    public void setUnifiedSocialCredit(String unifiedSocialCredit) {
        this.unifiedSocialCredit = unifiedSocialCredit;
    }

    public Integer getIndustrialFieldId() {
        return industrialFieldId;
    }

    public void setIndustrialFieldId(Integer industrialFieldId) {
        this.industrialFieldId = industrialFieldId;
    }

    public String getIndustrialFieldName() {
        return industrialFieldName;
    }

    public void setIndustrialFieldName(String industrialFieldName) {
        this.industrialFieldName = industrialFieldName;
    }

    public String getEnterpriseLegalPerson() {
        return enterpriseLegalPerson;
    }

    public void setEnterpriseLegalPerson(String enterpriseLegalPerson) {
        this.enterpriseLegalPerson = enterpriseLegalPerson;
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

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getProjectIntroductionFile() {
        return projectIntroductionFile;
    }

    public void setProjectIntroductionFile(String projectIntroductionFile) {
        this.projectIntroductionFile = projectIntroductionFile;
    }
}
