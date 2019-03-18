package com.jn.enterprise.pd.declaration.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdDeclarationOnlineReservationManage implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("预约项ID（关联公告ID）")*/
    private Integer appointmentItemId;

    /*@ApiModelProperty("预约项名称")*/
    private String appointmentItemName;

    /*@ApiModelProperty("联系人姓名")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactPhone;

    /*@ApiModelProperty("电子邮箱")*/
    private String email;

    /*@ApiModelProperty("附件")*/
    private String fileUrl;

    /*@ApiModelProperty("备注")*/
    private String remark;

    /*@ApiModelProperty("申报时间")*/
    private Date timeAppointment;

    /*@ApiModelProperty("申报企业")*/
    private String declareEnterprise;

    /*@ApiModelProperty("申报项目名称")*/
    private String declareItem;

    /*@ApiModelProperty("回复状态（1：已回复，2：未回复）")*/
    private Byte replyStatus;

    /*@ApiModelProperty("回复内容")*/
    private String replyContent;

    /*@ApiModelProperty("打印状态（1：已打印，2：未打印）")*/
    private Byte printStatus;

    /*@ApiModelProperty("打印编号")*/
    private String printCode;

    /*@ApiModelProperty("审核部门")*/
    private String auditDepartment;

    /*@ApiModelProperty("申报类型")*/
    private String declareType;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointmentItemId() {
        return appointmentItemId;
    }

    public void setAppointmentItemId(Integer appointmentItemId) {
        this.appointmentItemId = appointmentItemId;
    }

    public String getAppointmentItemName() {
        return appointmentItemName;
    }

    public void setAppointmentItemName(String appointmentItemName) {
        this.appointmentItemName = appointmentItemName == null ? null : appointmentItemName.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(Date timeAppointment) {
        this.timeAppointment = timeAppointment;
    }

    public String getDeclareEnterprise() {
        return declareEnterprise;
    }

    public void setDeclareEnterprise(String declareEnterprise) {
        this.declareEnterprise = declareEnterprise == null ? null : declareEnterprise.trim();
    }

    public String getDeclareItem() {
        return declareItem;
    }

    public void setDeclareItem(String declareItem) {
        this.declareItem = declareItem == null ? null : declareItem.trim();
    }

    public Byte getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Byte replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Byte getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(Byte printStatus) {
        this.printStatus = printStatus;
    }

    public String getPrintCode() {
        return printCode;
    }

    public void setPrintCode(String printCode) {
        this.printCode = printCode == null ? null : printCode.trim();
    }

    public String getAuditDepartment() {
        return auditDepartment;
    }

    public void setAuditDepartment(String auditDepartment) {
        this.auditDepartment = auditDepartment == null ? null : auditDepartment.trim();
    }

    public String getDeclareType() {
        return declareType;
    }

    public void setDeclareType(String declareType) {
        this.declareType = declareType == null ? null : declareType.trim();
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
        TbPdDeclarationOnlineReservationManage other = (TbPdDeclarationOnlineReservationManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppointmentItemId() == null ? other.getAppointmentItemId() == null : this.getAppointmentItemId().equals(other.getAppointmentItemId()))
            && (this.getAppointmentItemName() == null ? other.getAppointmentItemName() == null : this.getAppointmentItemName().equals(other.getAppointmentItemName()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTimeAppointment() == null ? other.getTimeAppointment() == null : this.getTimeAppointment().equals(other.getTimeAppointment()))
            && (this.getDeclareEnterprise() == null ? other.getDeclareEnterprise() == null : this.getDeclareEnterprise().equals(other.getDeclareEnterprise()))
            && (this.getDeclareItem() == null ? other.getDeclareItem() == null : this.getDeclareItem().equals(other.getDeclareItem()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getReplyContent() == null ? other.getReplyContent() == null : this.getReplyContent().equals(other.getReplyContent()))
            && (this.getPrintStatus() == null ? other.getPrintStatus() == null : this.getPrintStatus().equals(other.getPrintStatus()))
            && (this.getPrintCode() == null ? other.getPrintCode() == null : this.getPrintCode().equals(other.getPrintCode()))
            && (this.getAuditDepartment() == null ? other.getAuditDepartment() == null : this.getAuditDepartment().equals(other.getAuditDepartment()))
            && (this.getDeclareType() == null ? other.getDeclareType() == null : this.getDeclareType().equals(other.getDeclareType()))
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
        result = prime * result + ((getAppointmentItemId() == null) ? 0 : getAppointmentItemId().hashCode());
        result = prime * result + ((getAppointmentItemName() == null) ? 0 : getAppointmentItemName().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTimeAppointment() == null) ? 0 : getTimeAppointment().hashCode());
        result = prime * result + ((getDeclareEnterprise() == null) ? 0 : getDeclareEnterprise().hashCode());
        result = prime * result + ((getDeclareItem() == null) ? 0 : getDeclareItem().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getReplyContent() == null) ? 0 : getReplyContent().hashCode());
        result = prime * result + ((getPrintStatus() == null) ? 0 : getPrintStatus().hashCode());
        result = prime * result + ((getPrintCode() == null) ? 0 : getPrintCode().hashCode());
        result = prime * result + ((getAuditDepartment() == null) ? 0 : getAuditDepartment().hashCode());
        result = prime * result + ((getDeclareType() == null) ? 0 : getDeclareType().hashCode());
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
        sb.append(", appointmentItemId=").append(appointmentItemId);
        sb.append(", appointmentItemName=").append(appointmentItemName);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", email=").append(email);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", remark=").append(remark);
        sb.append(", timeAppointment=").append(timeAppointment);
        sb.append(", declareEnterprise=").append(declareEnterprise);
        sb.append(", declareItem=").append(declareItem);
        sb.append(", replyStatus=").append(replyStatus);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", printStatus=").append(printStatus);
        sb.append(", printCode=").append(printCode);
        sb.append(", auditDepartment=").append(auditDepartment);
        sb.append(", declareType=").append(declareType);
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