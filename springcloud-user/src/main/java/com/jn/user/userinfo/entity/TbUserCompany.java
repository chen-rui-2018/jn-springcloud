package com.jn.user.userinfo.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserCompany implements Serializable {
    private String id;

    private String account;

    private String phone;

    private String email;

    private String comName;

    private String avatar;

    private String unifyCode;

    private String owners;

    private String owner;

    private String ownerId;

    private String bankName;

    private String bankAccount;

    private String products;

    private String material;

    private String comProperty;

    private Double regCapital;

    private Date foundingTime;

    private String induType;

    private String industry;

    private Date licStarttime;

    private Date licEndtime;

    private String orgCode;

    private String contact;

    private String conPhone;

    private String conAddress;

    private String postcode;

    private String comAdress;

    private String comTele;

    private String addrPark;

    private Double creditPoints;

    private String comType;

    private String checker;

    private Date createdTime;

    private String checkStatus;

    private Date checkTime;

    private String creatorAccount;

    private String modifierAccount;

    private Date modifiedTime;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
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

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners == null ? null : owners.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
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
        this.induType = induType == null ? null : induType.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
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
        this.orgCode = orgCode == null ? null : orgCode.trim();
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

    public String getComAdress() {
        return comAdress;
    }

    public void setComAdress(String comAdress) {
        this.comAdress = comAdress == null ? null : comAdress.trim();
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele == null ? null : comTele.trim();
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark == null ? null : addrPark.trim();
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
        this.comType = comType == null ? null : comType.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
        TbUserCompany other = (TbUserCompany) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getComName() == null ? other.getComName() == null : this.getComName().equals(other.getComName()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getUnifyCode() == null ? other.getUnifyCode() == null : this.getUnifyCode().equals(other.getUnifyCode()))
            && (this.getOwners() == null ? other.getOwners() == null : this.getOwners().equals(other.getOwners()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getProducts() == null ? other.getProducts() == null : this.getProducts().equals(other.getProducts()))
            && (this.getMaterial() == null ? other.getMaterial() == null : this.getMaterial().equals(other.getMaterial()))
            && (this.getComProperty() == null ? other.getComProperty() == null : this.getComProperty().equals(other.getComProperty()))
            && (this.getRegCapital() == null ? other.getRegCapital() == null : this.getRegCapital().equals(other.getRegCapital()))
            && (this.getFoundingTime() == null ? other.getFoundingTime() == null : this.getFoundingTime().equals(other.getFoundingTime()))
            && (this.getInduType() == null ? other.getInduType() == null : this.getInduType().equals(other.getInduType()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getLicStarttime() == null ? other.getLicStarttime() == null : this.getLicStarttime().equals(other.getLicStarttime()))
            && (this.getLicEndtime() == null ? other.getLicEndtime() == null : this.getLicEndtime().equals(other.getLicEndtime()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getConPhone() == null ? other.getConPhone() == null : this.getConPhone().equals(other.getConPhone()))
            && (this.getConAddress() == null ? other.getConAddress() == null : this.getConAddress().equals(other.getConAddress()))
            && (this.getPostcode() == null ? other.getPostcode() == null : this.getPostcode().equals(other.getPostcode()))
            && (this.getComAdress() == null ? other.getComAdress() == null : this.getComAdress().equals(other.getComAdress()))
            && (this.getComTele() == null ? other.getComTele() == null : this.getComTele().equals(other.getComTele()))
            && (this.getAddrPark() == null ? other.getAddrPark() == null : this.getAddrPark().equals(other.getAddrPark()))
            && (this.getCreditPoints() == null ? other.getCreditPoints() == null : this.getCreditPoints().equals(other.getCreditPoints()))
            && (this.getComType() == null ? other.getComType() == null : this.getComType().equals(other.getComType()))
            && (this.getChecker() == null ? other.getChecker() == null : this.getChecker().equals(other.getChecker()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getComName() == null) ? 0 : getComName().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getUnifyCode() == null) ? 0 : getUnifyCode().hashCode());
        result = prime * result + ((getOwners() == null) ? 0 : getOwners().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getProducts() == null) ? 0 : getProducts().hashCode());
        result = prime * result + ((getMaterial() == null) ? 0 : getMaterial().hashCode());
        result = prime * result + ((getComProperty() == null) ? 0 : getComProperty().hashCode());
        result = prime * result + ((getRegCapital() == null) ? 0 : getRegCapital().hashCode());
        result = prime * result + ((getFoundingTime() == null) ? 0 : getFoundingTime().hashCode());
        result = prime * result + ((getInduType() == null) ? 0 : getInduType().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getLicStarttime() == null) ? 0 : getLicStarttime().hashCode());
        result = prime * result + ((getLicEndtime() == null) ? 0 : getLicEndtime().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getConPhone() == null) ? 0 : getConPhone().hashCode());
        result = prime * result + ((getConAddress() == null) ? 0 : getConAddress().hashCode());
        result = prime * result + ((getPostcode() == null) ? 0 : getPostcode().hashCode());
        result = prime * result + ((getComAdress() == null) ? 0 : getComAdress().hashCode());
        result = prime * result + ((getComTele() == null) ? 0 : getComTele().hashCode());
        result = prime * result + ((getAddrPark() == null) ? 0 : getAddrPark().hashCode());
        result = prime * result + ((getCreditPoints() == null) ? 0 : getCreditPoints().hashCode());
        result = prime * result + ((getComType() == null) ? 0 : getComType().hashCode());
        result = prime * result + ((getChecker() == null) ? 0 : getChecker().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
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
        sb.append(", account=").append(account);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", comName=").append(comName);
        sb.append(", avatar=").append(avatar);
        sb.append(", unifyCode=").append(unifyCode);
        sb.append(", owners=").append(owners);
        sb.append(", owner=").append(owner);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", products=").append(products);
        sb.append(", material=").append(material);
        sb.append(", comProperty=").append(comProperty);
        sb.append(", regCapital=").append(regCapital);
        sb.append(", foundingTime=").append(foundingTime);
        sb.append(", induType=").append(induType);
        sb.append(", industry=").append(industry);
        sb.append(", licStarttime=").append(licStarttime);
        sb.append(", licEndtime=").append(licEndtime);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", contact=").append(contact);
        sb.append(", conPhone=").append(conPhone);
        sb.append(", conAddress=").append(conAddress);
        sb.append(", postcode=").append(postcode);
        sb.append(", comAdress=").append(comAdress);
        sb.append(", comTele=").append(comTele);
        sb.append(", addrPark=").append(addrPark);
        sb.append(", creditPoints=").append(creditPoints);
        sb.append(", comType=").append(comType);
        sb.append(", checker=").append(checker);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}