package com.jn.system.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 文件添加文件组
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 16:51
 * @version： v1.0
 * @modified By:
 */
public class SysFileAddFileGroup implements Serializable {

    private static final long serialVersionUID = -6923429557226417911L;

    /**
     * 文件组id
     */
    @ApiModelProperty(value = "文件组id")
    private String[] fileGroupId;

    /**
     * 文件id
     */
    @ApiModelProperty(value = "文件id")
    private String fileId;

    public String[] getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String[] fileGroupId) {
        this.fileGroupId = fileGroupId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}
