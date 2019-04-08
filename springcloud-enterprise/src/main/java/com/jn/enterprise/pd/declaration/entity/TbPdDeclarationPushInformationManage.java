package com.jn.enterprise.pd.declaration.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdDeclarationPushInformationManage implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("推送标题")*/
    private String pushTitle;

    /*@ApiModelProperty("推送内容")*/
    private String pushContent;

    /*@ApiModelProperty("接收企业")*/
    private String receiveEnterprise;

    /*@ApiModelProperty("接收人")*/
    private String receivePerson;

    /*@ApiModelProperty("接收人电话")*/
    private String receivePhone;

    /*@ApiModelProperty("推送人")*/
    private String pushPerson;

    /*@ApiModelProperty("推送时间")*/
    private Date pushTime;

    /*@ApiModelProperty("推送状态（1：推送成功，2：推送失败）")*/
    private Byte pushStatus;

    /*@ApiModelProperty("推送来源（1：申报公告）")*/
    private Byte pushSource;

    /*@ApiModelProperty("")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle == null ? null : pushTitle.trim();
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent == null ? null : pushContent.trim();
    }

    public String getReceiveEnterprise() {
        return receiveEnterprise;
    }

    public void setReceiveEnterprise(String receiveEnterprise) {
        this.receiveEnterprise = receiveEnterprise == null ? null : receiveEnterprise.trim();
    }

    public String getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson == null ? null : receivePerson.trim();
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    public String getPushPerson() {
        return pushPerson;
    }

    public void setPushPerson(String pushPerson) {
        this.pushPerson = pushPerson == null ? null : pushPerson.trim();
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Byte getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Byte pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Byte getPushSource() {
        return pushSource;
    }

    public void setPushSource(Byte pushSource) {
        this.pushSource = pushSource;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbPdDeclarationPushInformationManage other = (TbPdDeclarationPushInformationManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPushTitle() == null ? other.getPushTitle() == null : this.getPushTitle().equals(other.getPushTitle()))
            && (this.getPushContent() == null ? other.getPushContent() == null : this.getPushContent().equals(other.getPushContent()))
            && (this.getReceiveEnterprise() == null ? other.getReceiveEnterprise() == null : this.getReceiveEnterprise().equals(other.getReceiveEnterprise()))
            && (this.getReceivePerson() == null ? other.getReceivePerson() == null : this.getReceivePerson().equals(other.getReceivePerson()))
            && (this.getReceivePhone() == null ? other.getReceivePhone() == null : this.getReceivePhone().equals(other.getReceivePhone()))
            && (this.getPushPerson() == null ? other.getPushPerson() == null : this.getPushPerson().equals(other.getPushPerson()))
            && (this.getPushTime() == null ? other.getPushTime() == null : this.getPushTime().equals(other.getPushTime()))
            && (this.getPushStatus() == null ? other.getPushStatus() == null : this.getPushStatus().equals(other.getPushStatus()))
            && (this.getPushSource() == null ? other.getPushSource() == null : this.getPushSource().equals(other.getPushSource()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPushTitle() == null) ? 0 : getPushTitle().hashCode());
        result = prime * result + ((getPushContent() == null) ? 0 : getPushContent().hashCode());
        result = prime * result + ((getReceiveEnterprise() == null) ? 0 : getReceiveEnterprise().hashCode());
        result = prime * result + ((getReceivePerson() == null) ? 0 : getReceivePerson().hashCode());
        result = prime * result + ((getReceivePhone() == null) ? 0 : getReceivePhone().hashCode());
        result = prime * result + ((getPushPerson() == null) ? 0 : getPushPerson().hashCode());
        result = prime * result + ((getPushTime() == null) ? 0 : getPushTime().hashCode());
        result = prime * result + ((getPushStatus() == null) ? 0 : getPushStatus().hashCode());
        result = prime * result + ((getPushSource() == null) ? 0 : getPushSource().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pushTitle=").append(pushTitle);
        sb.append(", pushContent=").append(pushContent);
        sb.append(", receiveEnterprise=").append(receiveEnterprise);
        sb.append(", receivePerson=").append(receivePerson);
        sb.append(", receivePhone=").append(receivePhone);
        sb.append(", pushPerson=").append(pushPerson);
        sb.append(", pushTime=").append(pushTime);
        sb.append(", pushStatus=").append(pushStatus);
        sb.append(", pushSource=").append(pushSource);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}