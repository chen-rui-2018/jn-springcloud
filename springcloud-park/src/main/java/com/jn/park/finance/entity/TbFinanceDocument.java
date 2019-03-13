package com.jn.park.finance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbFinanceDocument implements Serializable {
    /*@ApiModelProperty("序列")*/
    private Integer id;

    /*@ApiModelProperty("")*/
    private String docId;

    /*@ApiModelProperty("部门")*/
    private String departmentId;

    /*@ApiModelProperty("部门名称")*/
    private String departmentName;

    /*@ApiModelProperty("文档名称")*/
    private String docName;

    /*@ApiModelProperty("文件上传人")*/
    private String docUploader;

    /*@ApiModelProperty("文件上传时间")*/
    private Date docUploadTime;

    /*@ApiModelProperty("说明")*/
    private String comment;

    /*@ApiModelProperty("附件名称-存储用户上传时的文件名称")*/
    private String docFilename;

    /*@ApiModelProperty("附件编码-对应数据库存储文件的ID")*/
    private String docFilecode;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("录入人")*/
    private String creatorAccount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getDocUploader() {
        return docUploader;
    }

    public void setDocUploader(String docUploader) {
        this.docUploader = docUploader == null ? null : docUploader.trim();
    }

    public Date getDocUploadTime() {
        return docUploadTime;
    }

    public void setDocUploadTime(Date docUploadTime) {
        this.docUploadTime = docUploadTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getDocFilename() {
        return docFilename;
    }

    public void setDocFilename(String docFilename) {
        this.docFilename = docFilename == null ? null : docFilename.trim();
    }

    public String getDocFilecode() {
        return docFilecode;
    }

    public void setDocFilecode(String docFilecode) {
        this.docFilecode = docFilecode == null ? null : docFilecode.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        TbFinanceDocument other = (TbFinanceDocument) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDocId() == null ? other.getDocId() == null : this.getDocId().equals(other.getDocId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getDocName() == null ? other.getDocName() == null : this.getDocName().equals(other.getDocName()))
            && (this.getDocUploader() == null ? other.getDocUploader() == null : this.getDocUploader().equals(other.getDocUploader()))
            && (this.getDocUploadTime() == null ? other.getDocUploadTime() == null : this.getDocUploadTime().equals(other.getDocUploadTime()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getDocFilename() == null ? other.getDocFilename() == null : this.getDocFilename().equals(other.getDocFilename()))
            && (this.getDocFilecode() == null ? other.getDocFilecode() == null : this.getDocFilecode().equals(other.getDocFilecode()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDocId() == null) ? 0 : getDocId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getDocName() == null) ? 0 : getDocName().hashCode());
        result = prime * result + ((getDocUploader() == null) ? 0 : getDocUploader().hashCode());
        result = prime * result + ((getDocUploadTime() == null) ? 0 : getDocUploadTime().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getDocFilename() == null) ? 0 : getDocFilename().hashCode());
        result = prime * result + ((getDocFilecode() == null) ? 0 : getDocFilecode().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", docId=").append(docId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", docName=").append(docName);
        sb.append(", docUploader=").append(docUploader);
        sb.append(", docUploadTime=").append(docUploadTime);
        sb.append(", comment=").append(comment);
        sb.append(", docFilename=").append(docFilename);
        sb.append(", docFilecode=").append(docFilecode);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}