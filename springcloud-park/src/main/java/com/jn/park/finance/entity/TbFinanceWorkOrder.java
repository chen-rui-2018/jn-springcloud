package com.jn.park.finance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbFinanceWorkOrder implements Serializable {
    /*@ApiModelProperty("序列")*/
    private Integer id;

    /*@ApiModelProperty("")*/
    private String orderId;

    /*@ApiModelProperty("部门")*/
    private String departmentId;

    /*@ApiModelProperty("部门名称")*/
    private String departmentName;

    /*@ApiModelProperty("工单名称")*/
    private String orderName;

    /*@ApiModelProperty("工单类型")*/
    private Byte orderType;

    /*@ApiModelProperty("工单发布人")*/
    private String orderPublisher;

    /*@ApiModelProperty("工单发布时间")*/
    private Date orderPublishTime;

    /*@ApiModelProperty("工单发布内容")*/
    private String orderPublisherComment;

    /*@ApiModelProperty("工单审批状态（0：未审批;1：审批不通过;2：审批通过）")*/
    private Byte orderAuditingState;

    /*@ApiModelProperty("工单附件")*/
    private String orderData;

    /*@ApiModelProperty("是否删除0标记删除，1正常")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("审批进度")*/
    private String checkProgress;

    /*@ApiModelProperty("审核状态（0：未审核；1：审核通过；2：审核不通过）")*/
    private Byte checkState;

    /*@ApiModelProperty("审批意见")*/
    private String checkComment;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public String getOrderPublisher() {
        return orderPublisher;
    }

    public void setOrderPublisher(String orderPublisher) {
        this.orderPublisher = orderPublisher == null ? null : orderPublisher.trim();
    }

    public Date getOrderPublishTime() {
        return orderPublishTime;
    }

    public void setOrderPublishTime(Date orderPublishTime) {
        this.orderPublishTime = orderPublishTime;
    }

    public String getOrderPublisherComment() {
        return orderPublisherComment;
    }

    public void setOrderPublisherComment(String orderPublisherComment) {
        this.orderPublisherComment = orderPublisherComment == null ? null : orderPublisherComment.trim();
    }

    public Byte getOrderAuditingState() {
        return orderAuditingState;
    }

    public void setOrderAuditingState(Byte orderAuditingState) {
        this.orderAuditingState = orderAuditingState;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData == null ? null : orderData.trim();
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

    public String getCheckProgress() {
        return checkProgress;
    }

    public void setCheckProgress(String checkProgress) {
        this.checkProgress = checkProgress == null ? null : checkProgress.trim();
    }

    public Byte getCheckState() {
        return checkState;
    }

    public void setCheckState(Byte checkState) {
        this.checkState = checkState;
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment == null ? null : checkComment.trim();
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
        TbFinanceWorkOrder other = (TbFinanceWorkOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getOrderName() == null ? other.getOrderName() == null : this.getOrderName().equals(other.getOrderName()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderPublisher() == null ? other.getOrderPublisher() == null : this.getOrderPublisher().equals(other.getOrderPublisher()))
            && (this.getOrderPublishTime() == null ? other.getOrderPublishTime() == null : this.getOrderPublishTime().equals(other.getOrderPublishTime()))
            && (this.getOrderPublisherComment() == null ? other.getOrderPublisherComment() == null : this.getOrderPublisherComment().equals(other.getOrderPublisherComment()))
            && (this.getOrderAuditingState() == null ? other.getOrderAuditingState() == null : this.getOrderAuditingState().equals(other.getOrderAuditingState()))
            && (this.getOrderData() == null ? other.getOrderData() == null : this.getOrderData().equals(other.getOrderData()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getCheckProgress() == null ? other.getCheckProgress() == null : this.getCheckProgress().equals(other.getCheckProgress()))
            && (this.getCheckState() == null ? other.getCheckState() == null : this.getCheckState().equals(other.getCheckState()))
            && (this.getCheckComment() == null ? other.getCheckComment() == null : this.getCheckComment().equals(other.getCheckComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getOrderName() == null) ? 0 : getOrderName().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderPublisher() == null) ? 0 : getOrderPublisher().hashCode());
        result = prime * result + ((getOrderPublishTime() == null) ? 0 : getOrderPublishTime().hashCode());
        result = prime * result + ((getOrderPublisherComment() == null) ? 0 : getOrderPublisherComment().hashCode());
        result = prime * result + ((getOrderAuditingState() == null) ? 0 : getOrderAuditingState().hashCode());
        result = prime * result + ((getOrderData() == null) ? 0 : getOrderData().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getCheckProgress() == null) ? 0 : getCheckProgress().hashCode());
        result = prime * result + ((getCheckState() == null) ? 0 : getCheckState().hashCode());
        result = prime * result + ((getCheckComment() == null) ? 0 : getCheckComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", orderName=").append(orderName);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderPublisher=").append(orderPublisher);
        sb.append(", orderPublishTime=").append(orderPublishTime);
        sb.append(", orderPublisherComment=").append(orderPublisherComment);
        sb.append(", orderAuditingState=").append(orderAuditingState);
        sb.append(", orderData=").append(orderData);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", checkProgress=").append(checkProgress);
        sb.append(", checkState=").append(checkState);
        sb.append(", checkComment=").append(checkComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}