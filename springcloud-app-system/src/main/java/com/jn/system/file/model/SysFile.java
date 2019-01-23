package com.jn.system.file.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFile", description = "文件")
public class SysFile implements Serializable {
    private static final long serialVersionUID = 1596374127179651417L;
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    @NotBlank(message = "文件名称不能为空！")
    private String fileName;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    @NotBlank(message = "文件路径不能为空！")
    private String fileUrl;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysFile(String id, String fileName, String fileUrl, String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
    }

    public SysFile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysFile)) {
            return false;
        }

        SysFile sysFile = (SysFile) o;

        if (id != null ? !id.equals(sysFile.id) : sysFile.id != null) {
            return false;
        }
        if (fileName != null ? !fileName.equals(sysFile.fileName) : sysFile.fileName != null) {
            return false;
        }
        if (fileUrl != null ? !fileUrl.equals(sysFile.fileUrl) : sysFile.fileUrl != null) {
            return false;
        }
        if (creatorAccount != null ? !creatorAccount.equals(sysFile.creatorAccount) : sysFile.creatorAccount != null) {
            return false;
        }
        if (createdTime != null ? !createdTime.equals(sysFile.createdTime) : sysFile.createdTime != null) {
            return false;
        }
        return recordStatus != null ? recordStatus.equals(sysFile.recordStatus) : sysFile.recordStatus == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileUrl != null ? fileUrl.hashCode() : 0);
        result = 31 * result + (creatorAccount != null ? creatorAccount.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (recordStatus != null ? recordStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SysFile{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}