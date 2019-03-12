package com.jn.park.approve.entity;

import java.io.Serializable;
import java.util.Date;

public class TbApproveGuideMessage implements Serializable {
    /*@ApiModelProperty("主键")*/
    private Integer id;

    /*@ApiModelProperty("公司名称")*/
    private String companyName;

    /*@ApiModelProperty("联系人姓名")*/
    private Byte concatName;

    /*@ApiModelProperty("联系名电话")*/
    private String concatPhone;

    /*@ApiModelProperty("咨询名称（企业名+联系人）")*/
    private String title;

    /*@ApiModelProperty("留言内容")*/
    private String message;

    /*@ApiModelProperty("要资料的审批指南ID")*/
    private Integer guideId;

    /*@ApiModelProperty("回复状态")*/
    private String replyStatus;

    /*@ApiModelProperty("回复者账号")*/
    private Integer replyUserAccount;

    /*@ApiModelProperty("回复时间")*/
    private Date replyTime;

    /*@ApiModelProperty("回复内容")*/
    private String replyMessage;

    /*@ApiModelProperty("解决状态（已解决、未解决、其他内容）")*/
    private String solutionStatus;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("留言者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Byte getConcatName() {
        return concatName;
    }

    public void setConcatName(Byte concatName) {
        this.concatName = concatName;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone == null ? null : concatPhone.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus == null ? null : replyStatus.trim();
    }

    public Integer getReplyUserAccount() {
        return replyUserAccount;
    }

    public void setReplyUserAccount(Integer replyUserAccount) {
        this.replyUserAccount = replyUserAccount;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage == null ? null : replyMessage.trim();
    }

    public String getSolutionStatus() {
        return solutionStatus;
    }

    public void setSolutionStatus(String solutionStatus) {
        this.solutionStatus = solutionStatus == null ? null : solutionStatus.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        TbApproveGuideMessage other = (TbApproveGuideMessage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getConcatName() == null ? other.getConcatName() == null : this.getConcatName().equals(other.getConcatName()))
            && (this.getConcatPhone() == null ? other.getConcatPhone() == null : this.getConcatPhone().equals(other.getConcatPhone()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getGuideId() == null ? other.getGuideId() == null : this.getGuideId().equals(other.getGuideId()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getReplyUserAccount() == null ? other.getReplyUserAccount() == null : this.getReplyUserAccount().equals(other.getReplyUserAccount()))
            && (this.getReplyTime() == null ? other.getReplyTime() == null : this.getReplyTime().equals(other.getReplyTime()))
            && (this.getReplyMessage() == null ? other.getReplyMessage() == null : this.getReplyMessage().equals(other.getReplyMessage()))
            && (this.getSolutionStatus() == null ? other.getSolutionStatus() == null : this.getSolutionStatus().equals(other.getSolutionStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getConcatName() == null) ? 0 : getConcatName().hashCode());
        result = prime * result + ((getConcatPhone() == null) ? 0 : getConcatPhone().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getGuideId() == null) ? 0 : getGuideId().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getReplyUserAccount() == null) ? 0 : getReplyUserAccount().hashCode());
        result = prime * result + ((getReplyTime() == null) ? 0 : getReplyTime().hashCode());
        result = prime * result + ((getReplyMessage() == null) ? 0 : getReplyMessage().hashCode());
        result = prime * result + ((getSolutionStatus() == null) ? 0 : getSolutionStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", companyName=").append(companyName);
        sb.append(", concatName=").append(concatName);
        sb.append(", concatPhone=").append(concatPhone);
        sb.append(", title=").append(title);
        sb.append(", message=").append(message);
        sb.append(", guideId=").append(guideId);
        sb.append(", replyStatus=").append(replyStatus);
        sb.append(", replyUserAccount=").append(replyUserAccount);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", replyMessage=").append(replyMessage);
        sb.append(", solutionStatus=").append(solutionStatus);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}