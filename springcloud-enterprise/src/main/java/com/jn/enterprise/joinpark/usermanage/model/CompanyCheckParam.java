package com.jn.enterprise.joinpark.usermanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @ApiModelProperty(value = "企业领域[产业领域、所属行业]")
    private String induType;
    @NotNull(message = "企业法人不能为空")
    @ApiModelProperty(value = "企业法人")
    private String ownerLaw;
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
    @ApiModelProperty(value = "企业性质[多个用,分隔]")
    private String comProperty;
    @NotNull(message = "企业来源不能为空")
    @ApiModelProperty(value = "企业来源")
    private String comSource;
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码")
    private String checkCode;
    @ApiModelProperty(value = "法人微信")
    private String ownerWechat;
    @ApiModelProperty(value = "法人qq")
    private String ownerQq;
    @ApiModelProperty(value = "联系人微信")
    private String conWechat;
    @ApiModelProperty(value = "联系人")
    private String contact;
    @ApiModelProperty(value = "联系人电话")
    private String con_phone;
    @ApiModelProperty(value = "联系人qq")
    private String conQq;
    @ApiModelProperty(value = "行业代码")
    private String induCode;
    @ApiModelProperty(value = "增资情况")
    private String addCapital;
    @ApiModelProperty(value = "注册登记类型")
    private String registerType;
    @ApiModelProperty(value = "主要产品")
    private String mainProducts;
    @ApiModelProperty(value = "业务范围")
    private String businessScope;
    @ApiModelProperty(value = "企业官网地址")
    private String comWeb;
    @ApiModelProperty(value = "我的服务")
    private String comServer;
    @ApiModelProperty(value = "我的需求")
    private String comDemand;
    @ApiModelProperty(value = "公司需求")
    private String comSynopsis;
    @ApiModelProperty(value = "公司宣传头像")
    private List<CompanyProImgParam> imgParams;

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

    public String getOwnerWechat() {
        return ownerWechat;
    }

    public void setOwnerWechat(String ownerWechat) {
        this.ownerWechat = ownerWechat;
    }

    public String getOwnerQq() {
        return ownerQq;
    }

    public void setOwnerQq(String ownerQq) {
        this.ownerQq = ownerQq;
    }

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCon_phone() {
        return con_phone;
    }

    public void setCon_phone(String con_phone) {
        this.con_phone = con_phone;
    }

    public String getConQq() {
        return conQq;
    }

    public void setConQq(String conQq) {
        this.conQq = conQq;
    }

    public String getInduCode() {
        return induCode;
    }

    public void setInduCode(String induCode) {
        this.induCode = induCode;
    }

    public String getAddCapital() {
        return addCapital;
    }

    public void setAddCapital(String addCapital) {
        this.addCapital = addCapital;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getComWeb() {
        return comWeb;
    }

    public void setComWeb(String comWeb) {
        this.comWeb = comWeb;
    }

    public String getComServer() {
        return comServer;
    }

    public void setComServer(String comServer) {
        this.comServer = comServer;
    }

    public String getComDemand() {
        return comDemand;
    }

    public void setComDemand(String comDemand) {
        this.comDemand = comDemand;
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis;
    }

    public List<CompanyProImgParam> getImgParams() {
        return imgParams;
    }

    public void setImgParams(List<CompanyProImgParam> imgParams) {
        this.imgParams = imgParams;
    }
}
