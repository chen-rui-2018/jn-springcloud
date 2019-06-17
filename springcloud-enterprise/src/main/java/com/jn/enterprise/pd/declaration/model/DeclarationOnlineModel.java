package com.jn.enterprise.pd.declaration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约申报返回实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/17 15:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DeclarationOnlineModel", description = "预约申报返回实体类")
public class DeclarationOnlineModel implements Serializable {

    @ApiModelProperty("唯一标识符")
    private String id;

    @ApiModelProperty("预约项ID（关联公告ID）")
    private String appointmentItemId;

    @ApiModelProperty("预约项名称")
    private String appointmentItemName;

    @ApiModelProperty("联系人姓名")
    private String contactName;

    @ApiModelProperty("联系人电话")
    private String contactPhone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("附件")
    private String fileUrl;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("申报时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeAppointment;

    @ApiModelProperty("申报企业")
    private String declareEnterprise;

    @ApiModelProperty("申报项目名称")
    private String declareItem;

    @ApiModelProperty("回复状态（1：已回复，2：未回复）")
    private Byte replyStatus;

    @ApiModelProperty("回复内容")
    private String replyContent;

    @ApiModelProperty("打印状态（1：已打印，2：未打印）")
    private Byte printStatus;

    @ApiModelProperty("打印编号")
    private String printCode;

    @ApiModelProperty("审核部门")
    private String auditDepartment;

    @ApiModelProperty("申报类型")
    private String declareType;

    @ApiModelProperty("是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty("创建者账号")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty("最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty("最新更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppointmentItemId() {
        return appointmentItemId;
    }

    public void setAppointmentItemId(String appointmentItemId) {
        this.appointmentItemId = appointmentItemId;
    }

    public String getAppointmentItemName() {
        return appointmentItemName;
    }

    public void setAppointmentItemName(String appointmentItemName) {
        this.appointmentItemName = appointmentItemName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.declareEnterprise = declareEnterprise;
    }

    public String getDeclareItem() {
        return declareItem;
    }

    public void setDeclareItem(String declareItem) {
        this.declareItem = declareItem;
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
        this.replyContent = replyContent;
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
        this.printCode = printCode;
    }

    public String getAuditDepartment() {
        return auditDepartment;
    }

    public void setAuditDepartment(String auditDepartment) {
        this.auditDepartment = auditDepartment;
    }

    public String getDeclareType() {
        return declareType;
    }

    public void setDeclareType(String declareType) {
        this.declareType = declareType;
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
        this.creatorAccount = creatorAccount;
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
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
