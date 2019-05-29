package com.jn.enterprise.company.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceCompanyModify implements Serializable {
    private String id;

    private String comId;

    private String comName;

    private String comNameShort;

    private String avatar;

    private String unifyCode;

    private String ownerLaw;

    private String ownerPhone;

    private String comProperty;

    private Long regCapital;

    private String comScale;

    private Date foundingTime;

    private Date runTime;

    private String induType;

    private String induCode;

    private String businessLicense;

    private String propagandaPicture;

    private String mainProducts;

    private String comAddress;

    private String comTele;

    private String comWeb;

    private String comServer;

    private String comDemand;

    private String addrPark;

    private String comSynopsis;

    private String checkStatus;

    private Date checkTime;

    private String comSource;

    private String affiliatedPark;

    private String creatorAccount;

    private Date createdTime;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
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

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode == null ? null : unifyCode.trim();
    }

    public String getOwnerLaw() {
        return ownerLaw;
    }

    public void setOwnerLaw(String ownerLaw) {
        this.ownerLaw = ownerLaw == null ? null : ownerLaw.trim();
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone == null ? null : ownerPhone.trim();
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

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts == null ? null : mainProducts.trim();
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
        TbServiceCompanyModify other = (TbServiceCompanyModify) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComId() == null ? other.getComId() == null : this.getComId().equals(other.getComId()))
            && (this.getComName() == null ? other.getComName() == null : this.getComName().equals(other.getComName()))
            && (this.getComNameShort() == null ? other.getComNameShort() == null : this.getComNameShort().equals(other.getComNameShort()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getUnifyCode() == null ? other.getUnifyCode() == null : this.getUnifyCode().equals(other.getUnifyCode()))
            && (this.getOwnerLaw() == null ? other.getOwnerLaw() == null : this.getOwnerLaw().equals(other.getOwnerLaw()))
            && (this.getOwnerPhone() == null ? other.getOwnerPhone() == null : this.getOwnerPhone().equals(other.getOwnerPhone()))
            && (this.getComProperty() == null ? other.getComProperty() == null : this.getComProperty().equals(other.getComProperty()))
            && (this.getRegCapital() == null ? other.getRegCapital() == null : this.getRegCapital().equals(other.getRegCapital()))
            && (this.getComScale() == null ? other.getComScale() == null : this.getComScale().equals(other.getComScale()))
            && (this.getFoundingTime() == null ? other.getFoundingTime() == null : this.getFoundingTime().equals(other.getFoundingTime()))
            && (this.getRunTime() == null ? other.getRunTime() == null : this.getRunTime().equals(other.getRunTime()))
            && (this.getInduType() == null ? other.getInduType() == null : this.getInduType().equals(other.getInduType()))
            && (this.getInduCode() == null ? other.getInduCode() == null : this.getInduCode().equals(other.getInduCode()))
            && (this.getBusinessLicense() == null ? other.getBusinessLicense() == null : this.getBusinessLicense().equals(other.getBusinessLicense()))
            && (this.getPropagandaPicture() == null ? other.getPropagandaPicture() == null : this.getPropagandaPicture().equals(other.getPropagandaPicture()))
            && (this.getMainProducts() == null ? other.getMainProducts() == null : this.getMainProducts().equals(other.getMainProducts()))
            && (this.getComAddress() == null ? other.getComAddress() == null : this.getComAddress().equals(other.getComAddress()))
            && (this.getComTele() == null ? other.getComTele() == null : this.getComTele().equals(other.getComTele()))
            && (this.getComWeb() == null ? other.getComWeb() == null : this.getComWeb().equals(other.getComWeb()))
            && (this.getComServer() == null ? other.getComServer() == null : this.getComServer().equals(other.getComServer()))
            && (this.getComDemand() == null ? other.getComDemand() == null : this.getComDemand().equals(other.getComDemand()))
            && (this.getAddrPark() == null ? other.getAddrPark() == null : this.getAddrPark().equals(other.getAddrPark()))
            && (this.getComSynopsis() == null ? other.getComSynopsis() == null : this.getComSynopsis().equals(other.getComSynopsis()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getComSource() == null ? other.getComSource() == null : this.getComSource().equals(other.getComSource()))
            && (this.getAffiliatedPark() == null ? other.getAffiliatedPark() == null : this.getAffiliatedPark().equals(other.getAffiliatedPark()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComId() == null) ? 0 : getComId().hashCode());
        result = prime * result + ((getComName() == null) ? 0 : getComName().hashCode());
        result = prime * result + ((getComNameShort() == null) ? 0 : getComNameShort().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getUnifyCode() == null) ? 0 : getUnifyCode().hashCode());
        result = prime * result + ((getOwnerLaw() == null) ? 0 : getOwnerLaw().hashCode());
        result = prime * result + ((getOwnerPhone() == null) ? 0 : getOwnerPhone().hashCode());
        result = prime * result + ((getComProperty() == null) ? 0 : getComProperty().hashCode());
        result = prime * result + ((getRegCapital() == null) ? 0 : getRegCapital().hashCode());
        result = prime * result + ((getComScale() == null) ? 0 : getComScale().hashCode());
        result = prime * result + ((getFoundingTime() == null) ? 0 : getFoundingTime().hashCode());
        result = prime * result + ((getRunTime() == null) ? 0 : getRunTime().hashCode());
        result = prime * result + ((getInduType() == null) ? 0 : getInduType().hashCode());
        result = prime * result + ((getInduCode() == null) ? 0 : getInduCode().hashCode());
        result = prime * result + ((getBusinessLicense() == null) ? 0 : getBusinessLicense().hashCode());
        result = prime * result + ((getPropagandaPicture() == null) ? 0 : getPropagandaPicture().hashCode());
        result = prime * result + ((getMainProducts() == null) ? 0 : getMainProducts().hashCode());
        result = prime * result + ((getComAddress() == null) ? 0 : getComAddress().hashCode());
        result = prime * result + ((getComTele() == null) ? 0 : getComTele().hashCode());
        result = prime * result + ((getComWeb() == null) ? 0 : getComWeb().hashCode());
        result = prime * result + ((getComServer() == null) ? 0 : getComServer().hashCode());
        result = prime * result + ((getComDemand() == null) ? 0 : getComDemand().hashCode());
        result = prime * result + ((getAddrPark() == null) ? 0 : getAddrPark().hashCode());
        result = prime * result + ((getComSynopsis() == null) ? 0 : getComSynopsis().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getComSource() == null) ? 0 : getComSource().hashCode());
        result = prime * result + ((getAffiliatedPark() == null) ? 0 : getAffiliatedPark().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
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
        sb.append(", comId=").append(comId);
        sb.append(", comName=").append(comName);
        sb.append(", comNameShort=").append(comNameShort);
        sb.append(", avatar=").append(avatar);
        sb.append(", unifyCode=").append(unifyCode);
        sb.append(", ownerLaw=").append(ownerLaw);
        sb.append(", ownerPhone=").append(ownerPhone);
        sb.append(", comProperty=").append(comProperty);
        sb.append(", regCapital=").append(regCapital);
        sb.append(", comScale=").append(comScale);
        sb.append(", foundingTime=").append(foundingTime);
        sb.append(", runTime=").append(runTime);
        sb.append(", induType=").append(induType);
        sb.append(", induCode=").append(induCode);
        sb.append(", businessLicense=").append(businessLicense);
        sb.append(", propagandaPicture=").append(propagandaPicture);
        sb.append(", mainProducts=").append(mainProducts);
        sb.append(", comAddress=").append(comAddress);
        sb.append(", comTele=").append(comTele);
        sb.append(", comWeb=").append(comWeb);
        sb.append(", comServer=").append(comServer);
        sb.append(", comDemand=").append(comDemand);
        sb.append(", addrPark=").append(addrPark);
        sb.append(", comSynopsis=").append(comSynopsis);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", comSource=").append(comSource);
        sb.append(", affiliatedPark=").append(affiliatedPark);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}