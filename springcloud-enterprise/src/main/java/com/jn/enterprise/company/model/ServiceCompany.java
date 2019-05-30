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
 *
 * @author： shaobao
 * @date： Created on 2019/5/28 19:21
 * @version： v1.0
 * @modified By:
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
    private Long regCapital;
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
        this.id = id == null ? null : id.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getComNameShort() {
        return comNameShort;
    }

    public void setComNameShort(String comNameShort) {
        this.comNameShort = comNameShort == null ? null : comNameShort.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin == null ? null : comAdmin.trim();
    }

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode == null ? null : unifyCode.trim();
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners == null ? null : owners.trim();
    }

    public String getOwnerLaw() {
        return ownerLaw;
    }

    public void setOwnerLaw(String ownerLaw) {
        this.ownerLaw = ownerLaw == null ? null : ownerLaw.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone == null ? null : ownerPhone.trim();
    }

    public String getOwnerWechat() {
        return ownerWechat;
    }

    public void setOwnerWechat(String ownerWechat) {
        this.ownerWechat = ownerWechat == null ? null : ownerWechat.trim();
    }

    public String getOwnerQq() {
        return ownerQq;
    }

    public void setOwnerQq(String ownerQq) {
        this.ownerQq = ownerQq == null ? null : ownerQq.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products == null ? null : products.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty == null ? null : comProperty.trim();
    }

    public Long getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Long regCapital) {
        this.regCapital = regCapital;
    }

    public String getAddCapital() {
        return addCapital;
    }

    public void setAddCapital(String addCapital) {
        this.addCapital = addCapital == null ? null : addCapital.trim();
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
        this.induType = induType == null ? null : induType.trim();
    }

    public String getInduCode() {
        return induCode;
    }

    public void setInduCode(String induCode) {
        this.induCode = induCode == null ? null : induCode.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getPropagandaPicture() {
        return propagandaPicture;
    }

    public void setPropagandaPicture(String propagandaPicture) {
        this.propagandaPicture = propagandaPicture == null ? null : propagandaPicture.trim();
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
        this.registerType = registerType == null ? null : registerType.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts == null ? null : mainProducts.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone == null ? null : conPhone.trim();
    }

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat == null ? null : conWechat.trim();
    }

    public String getConQq() {
        return conQq;
    }

    public void setConQq(String conQq) {
        this.conQq = conQq == null ? null : conQq.trim();
    }

    public String getConAddress() {
        return conAddress;
    }

    public void setConAddress(String conAddress) {
        this.conAddress = conAddress == null ? null : conAddress.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress == null ? null : comAddress.trim();
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele == null ? null : comTele.trim();
    }

    public String getComWeb() {
        return comWeb;
    }

    public void setComWeb(String comWeb) {
        this.comWeb = comWeb == null ? null : comWeb.trim();
    }

    public String getComServer() {
        return comServer;
    }

    public void setComServer(String comServer) {
        this.comServer = comServer == null ? null : comServer.trim();
    }

    public String getComDemand() {
        return comDemand;
    }

    public void setComDemand(String comDemand) {
        this.comDemand = comDemand == null ? null : comDemand.trim();
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark == null ? null : addrPark.trim();
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis == null ? null : comSynopsis.trim();
    }

    public String getParkBuildId() {
        return parkBuildId;
    }

    public void setParkBuildId(String parkBuildId) {
        this.parkBuildId = parkBuildId == null ? null : parkBuildId.trim();
    }

    public String getParkBuildName() {
        return parkBuildName;
    }

    public void setParkBuildName(String parkBuildName) {
        this.parkBuildName = parkBuildName == null ? null : parkBuildName.trim();
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
        this.comType = comType == null ? null : comType.trim();
    }

    public String getIsJoinActivity() {
        return isJoinActivity;
    }

    public void setIsJoinActivity(String isJoinActivity) {
        this.isJoinActivity = isJoinActivity == null ? null : isJoinActivity.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
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
        this.comSource = comSource == null ? null : comSource.trim();
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark == null ? null : affiliatedPark.trim();
    }

    public String getAffiliatedName() {
        return affiliatedName;
    }

    public void setAffiliatedName(String affiliatedName) {
        this.affiliatedName = affiliatedName == null ? null : affiliatedName.trim();
    }

    public String getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(String browseNumber) {
        this.browseNumber = browseNumber == null ? null : browseNumber.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ServiceCompany other = (ServiceCompany) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getComName() == null ? other.getComName() == null : this.getComName().equals(other.getComName()))
                && (this.getComNameShort() == null ? other.getComNameShort() == null : this.getComNameShort().equals(other.getComNameShort()))
                && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
                && (this.getComAdmin() == null ? other.getComAdmin() == null : this.getComAdmin().equals(other.getComAdmin()))
                && (this.getUnifyCode() == null ? other.getUnifyCode() == null : this.getUnifyCode().equals(other.getUnifyCode()))
                && (this.getOwners() == null ? other.getOwners() == null : this.getOwners().equals(other.getOwners()))
                && (this.getOwnerLaw() == null ? other.getOwnerLaw() == null : this.getOwnerLaw().equals(other.getOwnerLaw()))
                && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
                && (this.getOwnerPhone() == null ? other.getOwnerPhone() == null : this.getOwnerPhone().equals(other.getOwnerPhone()))
                && (this.getOwnerWechat() == null ? other.getOwnerWechat() == null : this.getOwnerWechat().equals(other.getOwnerWechat()))
                && (this.getOwnerQq() == null ? other.getOwnerQq() == null : this.getOwnerQq().equals(other.getOwnerQq()))
                && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
                && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
                && (this.getProducts() == null ? other.getProducts() == null : this.getProducts().equals(other.getProducts()))
                && (this.getMaterial() == null ? other.getMaterial() == null : this.getMaterial().equals(other.getMaterial()))
                && (this.getComProperty() == null ? other.getComProperty() == null : this.getComProperty().equals(other.getComProperty()))
                && (this.getRegCapital() == null ? other.getRegCapital() == null : this.getRegCapital().equals(other.getRegCapital()))
                && (this.getAddCapital() == null ? other.getAddCapital() == null : this.getAddCapital().equals(other.getAddCapital()))
                && (this.getComScale() == null ? other.getComScale() == null : this.getComScale().equals(other.getComScale()))
                && (this.getFoundingTime() == null ? other.getFoundingTime() == null : this.getFoundingTime().equals(other.getFoundingTime()))
                && (this.getRunTime() == null ? other.getRunTime() == null : this.getRunTime().equals(other.getRunTime()))
                && (this.getInduType() == null ? other.getInduType() == null : this.getInduType().equals(other.getInduType()))
                && (this.getInduCode() == null ? other.getInduCode() == null : this.getInduCode().equals(other.getInduCode()))
                && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
                && (this.getPropagandaPicture() == null ? other.getPropagandaPicture() == null : this.getPropagandaPicture().equals(other.getPropagandaPicture()))
                && (this.getLicStarttime() == null ? other.getLicStarttime() == null : this.getLicStarttime().equals(other.getLicStarttime()))
                && (this.getLicEndtime() == null ? other.getLicEndtime() == null : this.getLicEndtime().equals(other.getLicEndtime()))
                && (this.getRegisterType() == null ? other.getRegisterType() == null : this.getRegisterType().equals(other.getRegisterType()))
                && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
                && (this.getMainProducts() == null ? other.getMainProducts() == null : this.getMainProducts().equals(other.getMainProducts()))
                && (this.getBusinessScope() == null ? other.getBusinessScope() == null : this.getBusinessScope().equals(other.getBusinessScope()))
                && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
                && (this.getConPhone() == null ? other.getConPhone() == null : this.getConPhone().equals(other.getConPhone()))
                && (this.getConWechat() == null ? other.getConWechat() == null : this.getConWechat().equals(other.getConWechat()))
                && (this.getConQq() == null ? other.getConQq() == null : this.getConQq().equals(other.getConQq()))
                && (this.getConAddress() == null ? other.getConAddress() == null : this.getConAddress().equals(other.getConAddress()))
                && (this.getPostcode() == null ? other.getPostcode() == null : this.getPostcode().equals(other.getPostcode()))
                && (this.getComAddress() == null ? other.getComAddress() == null : this.getComAddress().equals(other.getComAddress()))
                && (this.getComTele() == null ? other.getComTele() == null : this.getComTele().equals(other.getComTele()))
                && (this.getComWeb() == null ? other.getComWeb() == null : this.getComWeb().equals(other.getComWeb()))
                && (this.getComServer() == null ? other.getComServer() == null : this.getComServer().equals(other.getComServer()))
                && (this.getComDemand() == null ? other.getComDemand() == null : this.getComDemand().equals(other.getComDemand()))
                && (this.getAddrPark() == null ? other.getAddrPark() == null : this.getAddrPark().equals(other.getAddrPark()))
                && (this.getComSynopsis() == null ? other.getComSynopsis() == null : this.getComSynopsis().equals(other.getComSynopsis()))
                && (this.getParkBuildId() == null ? other.getParkBuildId() == null : this.getParkBuildId().equals(other.getParkBuildId()))
                && (this.getParkBuildName() == null ? other.getParkBuildName() == null : this.getParkBuildName().equals(other.getParkBuildName()))
                && (this.getCreditPoints() == null ? other.getCreditPoints() == null : this.getCreditPoints().equals(other.getCreditPoints()))
                && (this.getCreditUpdateTime() == null ? other.getCreditUpdateTime() == null : this.getCreditUpdateTime().equals(other.getCreditUpdateTime()))
                && (this.getComType() == null ? other.getComType() == null : this.getComType().equals(other.getComType()))
                && (this.getIsJoinActivity() == null ? other.getIsJoinActivity() == null : this.getIsJoinActivity().equals(other.getIsJoinActivity()))
                && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
                && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
                && (this.getComSource() == null ? other.getComSource() == null : this.getComSource().equals(other.getComSource()))
                && (this.getAffiliatedPark() == null ? other.getAffiliatedPark() == null : this.getAffiliatedPark().equals(other.getAffiliatedPark()))
                && (this.getAffiliatedName() == null ? other.getAffiliatedName() == null : this.getAffiliatedName().equals(other.getAffiliatedName()))
                && (this.getBrowseNumber() == null ? other.getBrowseNumber() == null : this.getBrowseNumber().equals(other.getBrowseNumber()))
                && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
                && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
                && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
                && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
                && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComName() == null) ? 0 : getComName().hashCode());
        result = prime * result + ((getComNameShort() == null) ? 0 : getComNameShort().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getComAdmin() == null) ? 0 : getComAdmin().hashCode());
        result = prime * result + ((getUnifyCode() == null) ? 0 : getUnifyCode().hashCode());
        result = prime * result + ((getOwners() == null) ? 0 : getOwners().hashCode());
        result = prime * result + ((getOwnerLaw() == null) ? 0 : getOwnerLaw().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getOwnerPhone() == null) ? 0 : getOwnerPhone().hashCode());
        result = prime * result + ((getOwnerWechat() == null) ? 0 : getOwnerWechat().hashCode());
        result = prime * result + ((getOwnerQq() == null) ? 0 : getOwnerQq().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getProducts() == null) ? 0 : getProducts().hashCode());
        result = prime * result + ((getMaterial() == null) ? 0 : getMaterial().hashCode());
        result = prime * result + ((getComProperty() == null) ? 0 : getComProperty().hashCode());
        result = prime * result + ((getRegCapital() == null) ? 0 : getRegCapital().hashCode());
        result = prime * result + ((getAddCapital() == null) ? 0 : getAddCapital().hashCode());
        result = prime * result + ((getComScale() == null) ? 0 : getComScale().hashCode());
        result = prime * result + ((getFoundingTime() == null) ? 0 : getFoundingTime().hashCode());
        result = prime * result + ((getRunTime() == null) ? 0 : getRunTime().hashCode());
        result = prime * result + ((getInduType() == null) ? 0 : getInduType().hashCode());
        result = prime * result + ((getInduCode() == null) ? 0 : getInduCode().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
        result = prime * result + ((getPropagandaPicture() == null) ? 0 : getPropagandaPicture().hashCode());
        result = prime * result + ((getLicStarttime() == null) ? 0 : getLicStarttime().hashCode());
        result = prime * result + ((getLicEndtime() == null) ? 0 : getLicEndtime().hashCode());
        result = prime * result + ((getRegisterType() == null) ? 0 : getRegisterType().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getMainProducts() == null) ? 0 : getMainProducts().hashCode());
        result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getConPhone() == null) ? 0 : getConPhone().hashCode());
        result = prime * result + ((getConWechat() == null) ? 0 : getConWechat().hashCode());
        result = prime * result + ((getConQq() == null) ? 0 : getConQq().hashCode());
        result = prime * result + ((getConAddress() == null) ? 0 : getConAddress().hashCode());
        result = prime * result + ((getPostcode() == null) ? 0 : getPostcode().hashCode());
        result = prime * result + ((getComAddress() == null) ? 0 : getComAddress().hashCode());
        result = prime * result + ((getComTele() == null) ? 0 : getComTele().hashCode());
        result = prime * result + ((getComWeb() == null) ? 0 : getComWeb().hashCode());
        result = prime * result + ((getComServer() == null) ? 0 : getComServer().hashCode());
        result = prime * result + ((getComDemand() == null) ? 0 : getComDemand().hashCode());
        result = prime * result + ((getAddrPark() == null) ? 0 : getAddrPark().hashCode());
        result = prime * result + ((getComSynopsis() == null) ? 0 : getComSynopsis().hashCode());
        result = prime * result + ((getParkBuildId() == null) ? 0 : getParkBuildId().hashCode());
        result = prime * result + ((getParkBuildName() == null) ? 0 : getParkBuildName().hashCode());
        result = prime * result + ((getCreditPoints() == null) ? 0 : getCreditPoints().hashCode());
        result = prime * result + ((getCreditUpdateTime() == null) ? 0 : getCreditUpdateTime().hashCode());
        result = prime * result + ((getComType() == null) ? 0 : getComType().hashCode());
        result = prime * result + ((getIsJoinActivity() == null) ? 0 : getIsJoinActivity().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getComSource() == null) ? 0 : getComSource().hashCode());
        result = prime * result + ((getAffiliatedPark() == null) ? 0 : getAffiliatedPark().hashCode());
        result = prime * result + ((getAffiliatedName() == null) ? 0 : getAffiliatedName().hashCode());
        result = prime * result + ((getBrowseNumber() == null) ? 0 : getBrowseNumber().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comName=").append(comName);
        sb.append(", comNameShort=").append(comNameShort);
        sb.append(", avatar=").append(avatar);
        sb.append(", comAdmin=").append(comAdmin);
        sb.append(", unifyCode=").append(unifyCode);
        sb.append(", owners=").append(owners);
        sb.append(", ownerLaw=").append(ownerLaw);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", ownerPhone=").append(ownerPhone);
        sb.append(", ownerWechat=").append(ownerWechat);
        sb.append(", ownerQq=").append(ownerQq);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", products=").append(products);
        sb.append(", material=").append(material);
        sb.append(", comProperty=").append(comProperty);
        sb.append(", regCapital=").append(regCapital);
        sb.append(", addCapital=").append(addCapital);
        sb.append(", comScale=").append(comScale);
        sb.append(", foundingTime=").append(foundingTime);
        sb.append(", runTime=").append(runTime);
        sb.append(", induType=").append(induType);
        sb.append(", induCode=").append(induCode);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", propagandaPicture=").append(propagandaPicture);
        sb.append(", licStarttime=").append(licStarttime);
        sb.append(", licEndtime=").append(licEndtime);
        sb.append(", registerType=").append(registerType);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", mainProducts=").append(mainProducts);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", contact=").append(contact);
        sb.append(", conPhone=").append(conPhone);
        sb.append(", conWechat=").append(conWechat);
        sb.append(", conQq=").append(conQq);
        sb.append(", conAddress=").append(conAddress);
        sb.append(", postcode=").append(postcode);
        sb.append(", comAddress=").append(comAddress);
        sb.append(", comTele=").append(comTele);
        sb.append(", comWeb=").append(comWeb);
        sb.append(", comServer=").append(comServer);
        sb.append(", comDemand=").append(comDemand);
        sb.append(", addrPark=").append(addrPark);
        sb.append(", comSynopsis=").append(comSynopsis);
        sb.append(", parkBuildId=").append(parkBuildId);
        sb.append(", parkBuildName=").append(parkBuildName);
        sb.append(", creditPoints=").append(creditPoints);
        sb.append(", creditUpdateTime=").append(creditUpdateTime);
        sb.append(", comType=").append(comType);
        sb.append(", isJoinActivity=").append(isJoinActivity);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", comSource=").append(comSource);
        sb.append(", affiliatedPark=").append(affiliatedPark);
        sb.append(", affiliatedName=").append(affiliatedName);
        sb.append(", browseNumber=").append(browseNumber);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}