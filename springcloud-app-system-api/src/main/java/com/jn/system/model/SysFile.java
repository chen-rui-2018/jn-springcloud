package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import java.io.Serializable;

/**
 * 文件实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFile1", description = "文件")
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
     * 文件组id
     */
    @ApiModelProperty("文件组id")
    private String fileGroupId;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String fileGroupId) {
        this.fileGroupId = fileGroupId;
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

}