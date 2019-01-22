package com.jn.system.file.model;

import com.jn.system.common.enums.SysStatusEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件组文件关联实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileGroupFile" ,description = "文件组文件关联")
public class SysFileGroupFile implements Serializable {

    private static final long serialVersionUID = 8698342402955891194L;
    private String id;

    /**
     * 文件组id
     */
    @ApiModelProperty(value = "文件组id" )
    private String fileGroupId;

    /**
     * 文件id
     */
    @ApiModelProperty(value = "文件id" )
    private String fileId;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdTime;

    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;


    public SysFileGroupFile(String id, String fileGroupId, String fileId, String creatorAccount,
                            Date createdTime, Byte recordStatus) {
        this.id = id;
        this.fileGroupId = fileGroupId;
        this.fileId = fileId;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
    }

    public SysFileGroupFile() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String fileGroupId) {
        this.fileGroupId = fileGroupId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
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
        if (!(o instanceof SysFileGroupFile)) {
            return false;
        }

        SysFileGroupFile that = (SysFileGroupFile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (fileGroupId != null ? !fileGroupId.equals(that.fileGroupId) : that.fileGroupId != null) {
            return false;
        }
        if (fileId != null ? !fileId.equals(that.fileId) : that.fileId != null) {
            return false;
        }
        if (creatorAccount != null ? !creatorAccount.equals(that.creatorAccount) : that.creatorAccount != null) {
            return false;
        }
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) {
            return false;
        }
        return recordStatus != null ? recordStatus.equals(that.recordStatus) : that.recordStatus == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileGroupId != null ? fileGroupId.hashCode() : 0);
        result = 31 * result + (fileId != null ? fileId.hashCode() : 0);
        result = 31 * result + (creatorAccount != null ? creatorAccount.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (recordStatus != null ? recordStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SysFileGroupFile{" +
                "id='" + id + '\'' +
                ", fileGroupId='" + fileGroupId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}