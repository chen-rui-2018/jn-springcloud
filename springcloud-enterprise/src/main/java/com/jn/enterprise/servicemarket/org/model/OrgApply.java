package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务机构申请基本信息
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgApply",description = "服务机构申请基本信息")
public class OrgApply {
    @ApiModelProperty(value = "机构ID")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "业务领域")
    private String businessType;
    @ApiModelProperty(value = "机构组织机构代码")
    private String orgCode;
    @ApiModelProperty(value = "机构注册时间")
    private String orgRegisterTime;
    @ApiModelProperty(value = "申请时间")
    private String createdTime;
    @ApiModelProperty(value = "审核状态")
    private String orgStatus;
    @ApiModelProperty(value = "申请人账号")
    private String orgAccount;
    @ApiModelProperty(value = "申请人姓名")
    private String name;
    @ApiModelProperty(value = "申请人手机号")
    private String phone;
    @ApiModelProperty(value = "申请人电子邮箱")
    private String email;

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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgRegisterTime() {
        return orgRegisterTime;
    }

    public void setOrgRegisterTime(String orgRegisterTime) {
        this.orgRegisterTime = orgRegisterTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getOrgAccount() {
        return orgAccount;
    }

    public void setOrgAccount(String orgAccount) {
        this.orgAccount = orgAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
