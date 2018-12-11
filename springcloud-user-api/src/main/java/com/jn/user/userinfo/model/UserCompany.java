package com.jn.user.userinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业用户扩展信息
 * @Author: yangph
 * @Date: 2018/12/10 16:10
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "UserExtension", description = "企业用户扩展信息")
public class UserCompany implements Serializable {
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "企业名称")
    private String comName;
    @ApiModelProperty(value = "企业logo")
    private String avatar;
    @ApiModelProperty(value = "统一社会信用代码")
    private String unifyCode;
    @ApiModelProperty(value = "投资人/股东")
    private String owners;
    @ApiModelProperty(value = "企业法人")
    private String owner;
    @ApiModelProperty(value = "法人身份证号")
    private String ownerId;
    @ApiModelProperty(value = "开户银行")
    private String bankName;
    @ApiModelProperty(value = "银行账号")
    private String bankAccount;
    @ApiModelProperty(value = "主营业务/主要产品")
    private String products;
    @ApiModelProperty(value = "主要原材料")
    private String material;
    @ApiModelProperty(value = "企业性质")
    private String comProperty;
    @ApiModelProperty(value = "注册资本")
    private Double regCapital;
    @ApiModelProperty(value = "成立时间")
    private Date foundingTime;
    @ApiModelProperty(value = "行业分类")
    private String induType;
    @ApiModelProperty(value = "行业")
    private String industry;
    @ApiModelProperty(value = "营业执照开始时间")
    private Date licStarttime;
    @ApiModelProperty(value = "营业执照到期时间")
    private Date licEndtime;
    @ApiModelProperty(value = "组织机构代码")
    private String orgCode;
    @ApiModelProperty(value = "联系人")
    private String contact;
    @ApiModelProperty(value = "联系人手机号")
    private String conPhone;
    @ApiModelProperty(value = "联系地址")
    private String conAddress;
    @ApiModelProperty(value = "邮编")
    private String postcode;
    @ApiModelProperty(value = "公司地址")
    private String comAdress;
    @ApiModelProperty(value = "公司座机")
    private String comTele;
    @ApiModelProperty(value = "公司园区地址")
    private String addrPark;
    @ApiModelProperty(value = "信用积分")
    private Double creditPoints;
    @ApiModelProperty(value = "企业类型")
    private String comType;
    @ApiModelProperty(value = "修改人")
    private String modifier;
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;
    @ApiModelProperty(value = "审核状态")
    private String checkStatus;
    @ApiModelProperty(value = "邮箱")
    private Date checkTime;
    @ApiModelProperty(value = "审核通过时间")
    private String checker;

    private static final long serialVersionUID = 1L;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty;
    }

    public Double getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Double regCapital) {
        this.regCapital = regCapital;
    }

    public Date getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(Date foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getInduType() {
        return induType;
    }

    public void setInduType(String induType) {
        this.induType = induType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getLicStarttime() {
        return licStarttime;
    }

    public void setLicStarttime(Date licStarttime) {
        this.licStarttime = licStarttime;
    }

    public Date getLicEndtime() {
        return licEndtime;
    }

    public void setLicEndtime(Date licEndtime) {
        this.licEndtime = licEndtime;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getConAddress() {
        return conAddress;
    }

    public void setConAddress(String conAddress) {
        this.conAddress = conAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getComAdress() {
        return comAdress;
    }

    public void setComAdress(String comAdress) {
        this.comAdress = comAdress;
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele;
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    public Double getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(Double creditPoints) {
        this.creditPoints = creditPoints;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }
}
