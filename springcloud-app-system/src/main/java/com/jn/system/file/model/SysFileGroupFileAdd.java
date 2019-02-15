package com.jn.system.file.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 文件组添加文件
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 16:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileGroupFileAdd", description = "文件组添加文件")
public class SysFileGroupFileAdd implements Serializable {

    private static final long serialVersionUID = -6923429557226417911L;

    /**
     * 文件组id
     */
    @ApiModelProperty(value = "文件组id")
    private String fileGroupId;

    /**
     * 文件id
     */
    @ApiModelProperty(value = "文件id")
    private String[] fileId;

    public SysFileGroupFileAdd() {
    }

    public SysFileGroupFileAdd(String fileGroupId, String[] fileId) {
        this.fileGroupId = fileGroupId;
        this.fileId = fileId;
    }

    public String getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String fileGroupId) {
        this.fileGroupId = fileGroupId;
    }

    public String[] getFileId() {
        return fileId;
    }

    public void setFileId(String[] fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "SysFileGroupFileAdd{" +
                "fileGroupId='" + fileGroupId + '\'' +
                ", fileId=" + Arrays.toString(fileId) +
                '}';
    }
}
