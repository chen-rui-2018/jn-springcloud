package com.jn.system.file.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFilePage", description = "文件分页实体")
public class SysFilePage extends Page implements Serializable {
    private static final long serialVersionUID = 7252981735944287742L;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String fileUrl;

    @ApiModelProperty(value = "状态 1:有效 0:无效 -1:删除")
    private String recordStatus;

    @ApiModelProperty(value = "文件组名称")
    private String fileGroupName;

    public SysFilePage() {
    }

    public SysFilePage(String fileName, String fileUrl, String recordStatus, String fileGroupName) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.recordStatus = recordStatus;
        this.fileGroupName = fileGroupName;
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

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getFileGroupName() {
        return fileGroupName;
    }

    public void setFileGroupName(String fileGroupName) {
        this.fileGroupName = fileGroupName;
    }

    @Override
    public String toString() {
        return "SysFilePage{" +
                "fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                '}';
    }
}
