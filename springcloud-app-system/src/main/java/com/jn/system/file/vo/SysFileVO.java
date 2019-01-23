package com.jn.system.file.vo;


import com.jn.system.file.model.SysFileGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文件vo
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileVO",description = "文件vo")
public class SysFileVO implements Serializable {
    private static final long serialVersionUID = -7789819491793048921L;
    /**
     * 文件id
     */
    @ApiModelProperty("文件id")
    private String fileId;

    /**
     * 文件名称
     */
    @ApiModelProperty("文件名称")
    private String fileName;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String fileUrl;

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

    /**
     * 状态描述
     */
    @ApiModelProperty("状态描述")
    private String statusDesc;

    /**
     * 文件所属文件组
     */
    @ApiModelProperty("文件所属文件组")
    private List<String> fileGroupNameList;


    public SysFileVO() {
    }

    public SysFileVO(String fileId, String fileName, String fileUrl, String creatorAccount, Date createdTime,
                     Byte recordStatus, String statusDesc, List<String> fileGroupNameList) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.statusDesc = statusDesc;
        this.fileGroupNameList = fileGroupNameList;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
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

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public List<String> getFileGroupNameList() {
        return fileGroupNameList;
    }

    public void setFileGroupNameList(List<String> fileGroupNameList) {
        this.fileGroupNameList = fileGroupNameList;
    }

    @Override
    public String toString() {
        return "SysFileVO{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", statusDesc='" + statusDesc + '\'' +
                ", fileGroupNameList=" + fileGroupNameList +
                '}';
    }
}
