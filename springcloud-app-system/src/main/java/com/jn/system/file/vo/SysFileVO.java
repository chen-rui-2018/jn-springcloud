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
    private String creator;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty("状态 1:有效 0:无效 -1:删除")
    private String status;

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

    public SysFileVO(String fileId, String fileName, String fileUrl, String creator, Date createTime,
                     String status, String statusDesc, List<String> fileGroupNameList) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", fileGroupNameList=" + fileGroupNameList +
                '}';
    }
}
