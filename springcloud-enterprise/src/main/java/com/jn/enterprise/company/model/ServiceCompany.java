package com.jn.enterprise.company.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业实体
 * @author： shaobao
 * @date： Created on 2019/5/28 19:21
 * @version： v1.0
 * @modified By: huxw
 **/
@ApiModel(value = "ServiceCompany",description = "企业实体")
public class ServiceCompany implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "公司名称")
    private String comName;
    @ApiModelProperty(value = "公司简称")
    private String comNameShort;
    @ApiModelProperty(value = "企业logo")
    private String avatar;
    @ApiModelProperty(value = "企业管理员")
    private String comAdmin;
    @ApiModelProperty(value = "统一社会信用代码")
    private String unifyCode;
    @ApiModelProperty(value = "投资人")
    private String owners;
    @ApiModelProperty(value = "企业法人")
    private String ownerLaw;
    @ApiModelProperty(value = "法人身份证号")
    private String ownerId;
    @ApiModelProperty(value = "法人联系电话")
    private String ownerPhone;
    @ApiModelProperty(value = "法人微信")
    private String ownerWechat;
    @ApiModelProperty(value = "法人QQ")
    private String ownerQq;
    @ApiModelProperty(value = "开户银行")
    private String bankName;
    @ApiModelProperty(value = "银行账号")
    private String bankAccount;
    @ApiModelProperty(value = "主要产品")
    private String products;
    @ApiModelProperty(value = "主要原材料")
    private String material;
    @ApiModelProperty(value = "企业性质")
    private String comProperty;
    @ApiModelProperty(value = "注册资本（万元）")
    private BigDecimal regCapital;
    @ApiModelProperty(value = "增资情况")
    private String addCapital;
    @ApiModelProperty(value = "企业规模")
    private String comScale;
    @ApiModelProperty(value = "成立时间（注册时间）")
    private Date foundingTime;
    @ApiModelProperty(value = "落地时间（实际运营时间）")
    private Date runTime;
    @ApiModelProperty(value = "行业分类")
    private String induType;
    @ApiModelProperty(value = "行业代码")
    private String induCode;
    @ApiModelProperty(value = "营业执照")
    private String businessLicense;
    @ApiModelProperty(value = "企业宣传图（多个")
    private String propagandaPicture;

    @ApiModelProperty(value = "营业执照开始时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date licStarttime;

    @ApiModelProperty(value = "营业执照到期时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date licEndtime;
    @ApiModelProperty(value = "注册登记类型")
    private String registerType;
    @ApiModelProperty(value = "组织机构代码")
    private String orgCode;
    @ApiModelProperty(value = "主要产品")
    private String mainProducts;
    @ApiModelProperty(value = "业务范围")
    private String businessScope;
    @ApiModelProperty(value = "联系人")
    private String contact;
    @ApiModelProperty(value = "联系人手机号")
    private String conPhone;
    @ApiModelProperty(value = "联系人微信")
    private String conWechat;
    @ApiModelProperty(value = "联系人QQ")
    private String conQq;
    @ApiModelProperty(value = "联系人地址")
    private String conAddress;
    @ApiModelProperty(value = "邮编")
    private String postcode;
    @ApiModelProperty(value = "公司地址")
    private String comAddress;
    @ApiModelProperty(value = "公司电话")
    private String comTele;
    @ApiModelProperty(value = "公司网址")
    private String comWeb;
    @ApiModelProperty(value = "我的需求")
    private String comServer;
    @ApiModelProperty(value = "企业类型")
    private String comDemand;
    @ApiModelProperty(value = "公司园区地址（实际经营地址）")
    private String addrPark;
    @ApiModelProperty(value = "公司简介")
    private String comSynopsis;
    @ApiModelProperty(value = "园区楼宇ID")
    private String parkBuildId;
    @ApiModelProperty(value = "园区楼宇名称")
    private String parkBuildName;
    @ApiModelProperty(value = "信用积分")
    private BigDecimal creditPoints;

    @ApiModelProperty(value = "信用扥更新时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creditUpdateTime;

    @ApiModelProperty(value = "企业类型")
    private String comType;

    @ApiModelProperty(value = "是否加入园区活动")
    private String isJoinActivity;

    @ApiModelProperty(value = "审核状态")
    private String checkStatus;

    @ApiModelProperty(value = "审核时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;
    @ApiModelProperty(value = "企业来源")
    private String comSource;

    @ApiModelProperty(value = "所属园区id")
    private String affiliatedPark;

    @ApiModelProperty(value = "所属园区名称")
    private String affiliatedName;

    @ApiModelProperty(value = "浏览次数")
    private String browseNumber;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "最新更信任账号")
    private String modifierAccount;

    @ApiModelProperty(value = "创建时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value = "是否删除")
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
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

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
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

    public BigDecimal getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(BigDecimal regCapital) {
        this.regCapital = regCapital;
    }

    public String getAddCapital() {
        return addCapital;
    }

    public void setAddCapital(String addCapital) {
        this.addCapital = addCapital;
    }

    public String getComScale() {
        return comScale;
    }

    public void setComScale(String comScale) {
        this.comScale = comScale;
    }

    public Date getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(Date foundingTime) {
        this.foundingTime = foundingTime;
    }

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    public String getInduType() {
        return induType;
    }

    public void setInduType(String induType) {
        this.induType = induType;
    }

    public String getInduCode() {
        return induCode;
    }

    public void setInduCode(String induCode) {
        this.induCode = induCode;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getPropagandaPicture() {
        return propagandaPicture;
    }

    public void setPropagandaPicture(String propagandaPicture) {
        this.propagandaPicture = propagandaPicture;
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

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
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

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat;
    }

    public String getConQq() {
        return conQq;
    }

    public void setConQq(String conQq) {
        this.conQq = conQq;
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

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele;
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

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis;
    }

    public String getParkBuildId() {
        return parkBuildId;
    }

    public void setParkBuildId(String parkBuildId) {
        this.parkBuildId = parkBuildId;
    }

    public String getParkBuildName() {
        return parkBuildName;
    }

    public void setParkBuildName(String parkBuildName) {
        this.parkBuildName = parkBuildName;
    }

    public BigDecimal getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(BigDecimal creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Date getCreditUpdateTime() {
        return creditUpdateTime;
    }

    public void setCreditUpdateTime(Date creditUpdateTime) {
        this.creditUpdateTime = creditUpdateTime;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getIsJoinActivity() {
        return isJoinActivity;
    }

    public void setIsJoinActivity(String isJoinActivity) {
        this.isJoinActivity = isJoinActivity;
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

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark;
    }

    public String getAffiliatedName() {
        return affiliatedName;
    }

    public void setAffiliatedName(String affiliatedName) {
        this.affiliatedName = affiliatedName;
    }

    public String getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(String browseNumber) {
        this.browseNumber = browseNumber;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "ServiceCompany{" +
                "id='" + id + '\'' +
                ", comName='" + comName + '\'' +
                ", comNameShort='" + comNameShort + '\'' +
                ", avatar='" + avatar + '\'' +
                ", comAdmin='" + comAdmin + '\'' +
                ", unifyCode='" + unifyCode + '\'' +
                ", owners='" + owners + '\'' +
                ", ownerLaw='" + ownerLaw + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", ownerWechat='" + ownerWechat + '\'' +
                ", ownerQq='" + ownerQq + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", products='" + products + '\'' +
                ", material='" + material + '\'' +
                ", comProperty='" + comProperty + '\'' +
                ", regCapital=" + regCapital +
                ", addCapital='" + addCapital + '\'' +
                ", comScale='" + comScale + '\'' +
                ", foundingTime=" + foundingTime +
                ", runTime=" + runTime +
                ", induType='" + induType + '\'' +
                ", induCode='" + induCode + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", propagandaPicture='" + propagandaPicture + '\'' +
                ", licStarttime=" + licStarttime +
                ", licEndtime=" + licEndtime +
                ", registerType='" + registerType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", mainProducts='" + mainProducts + '\'' +
                ", businessScope='" + businessScope + '\'' +
                ", contact='" + contact + '\'' +
                ", conPhone='" + conPhone + '\'' +
                ", conWechat='" + conWechat + '\'' +
                ", conQq='" + conQq + '\'' +
                ", conAddress='" + conAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", comAddress='" + comAddress + '\'' +
                ", comTele='" + comTele + '\'' +
                ", comWeb='" + comWeb + '\'' +
                ", comServer='" + comServer + '\'' +
                ", comDemand='" + comDemand + '\'' +
                ", addrPark='" + addrPark + '\'' +
                ", comSynopsis='" + comSynopsis + '\'' +
                ", parkBuildId='" + parkBuildId + '\'' +
                ", parkBuildName='" + parkBuildName + '\'' +
                ", creditPoints=" + creditPoints +
                ", creditUpdateTime=" + creditUpdateTime +
                ", comType='" + comType + '\'' +
                ", isJoinActivity='" + isJoinActivity + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkTime=" + checkTime +
                ", comSource='" + comSource + '\'' +
                ", affiliatedPark='" + affiliatedPark + '\'' +
                ", affiliatedName='" + affiliatedName + '\'' +
                ", browseNumber='" + browseNumber + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}