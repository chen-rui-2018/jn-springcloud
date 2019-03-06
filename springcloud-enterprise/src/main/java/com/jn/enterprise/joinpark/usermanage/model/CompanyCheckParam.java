package com.jn.enterprise.joinpark.usermanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 升级企业入参Bean
 * @author： jiangyl
 * @date： Created on 2019/3/5 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyCheckParam",description = "升级企业入参")
public class CompanyCheckParam implements Serializable {
    @NotNull(message = "企业名称不能为空")
    @ApiModelProperty(value = "企业名称")
    private String comName;
    @NotNull(message = "企业简称不能为空")
    @ApiModelProperty(value = "企业简称")
    private String comNameShort;
    @NotNull(message = "企业logo不能为空")
    @ApiModelProperty(value = "企业logo")
    private String avatar;
    @NotNull(message = "企业领域不能为空")
    @ApiModelProperty(value = "企业领域")
    private String induType;
    @NotNull(message = "企业法人不能为空")
    @ApiModelProperty(value = "企业法人")
    private String ownerLaw;
    @NotNull(message = "一级业务领域不能为空")
    @ApiModelProperty(value = "法人身份证号")
    private String ownerId;
    @NotNull(message = "联系电话不能为空")
    @ApiModelProperty(value = "联系电话")
    private String conPhone;
    @NotNull(message = "注册时间不能为空")
    @ApiModelProperty(value = "注册时间yyyy-MM-dd")
    private String foundingTime;
    @NotNull(message = "落地时间不能为空")
    @ApiModelProperty(value = "落地时间yyyy-MM-dd")
    private String runTime;
    @NotNull(message = "公司注册地址不能为空")
    @ApiModelProperty(value = "公司注册地址")
    private String comAddress;
    @NotNull(message = "实际经营地址不能为空")
    @ApiModelProperty(value = "实际经营地址（园区地址）")
    private String addrPark;
    @ApiModelProperty(value = "固定电话")
    private String comTele;
    @NotNull(message = "注册资金不能为空")
    @ApiModelProperty(value = "注册资金（万元）")
    private Long regCapital;
    @NotNull(message = "企业规模不能为空")
    @ApiModelProperty(value = "企业规模（万元）")
    private Long comScale;
    @NotNull(message = "统一社会信用代码不能为空")
    @ApiModelProperty(value = "统一社会信用代码")
    private String unifyCode;
    @NotNull(message = "三证一体或营业执照照片不能为空")
    @ApiModelProperty(value = "三证一体或营业执照照片")
    private String businessLicense;
    @NotNull(message = "企业性质不能为空")
    @ApiModelProperty(value = "企业性质")
    private String comProperty;
    @NotNull(message = "企业来源不能为空")
    @ApiModelProperty(value = "企业来源")
    private String comSource;
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码")
    private String checkCode;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComNameShort() {
        return comNameShort;
    }

    public void setComNameShort(String comNameShort) {
        this.comNameShort = comNameShort;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getInduType() {
        return induType;
    }

    public void setInduType(String induType) {
        this.induType = induType;
    }

    public String getOwnerLaw() {
        return ownerLaw;
    }

    public void setOwnerLaw(String ownerLaw) {
        this.ownerLaw = ownerLaw;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(String foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele;
    }

    public Long getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Long regCapital) {
        this.regCapital = regCapital;
    }

    public Long getComScale() {
        return comScale;
    }

    public void setComScale(Long comScale) {
        this.comScale = comScale;
    }

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty;
    }

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
