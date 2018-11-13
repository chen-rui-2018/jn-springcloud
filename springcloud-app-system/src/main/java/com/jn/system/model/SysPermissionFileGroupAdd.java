package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 权限添加文件组
 * @author： shaobao
 * @date： Created on 2018/11/9 15:32
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionFileGroupAdd",description = "权限添加文件组")
public class SysPermissionFileGroupAdd implements Serializable {
    private static final long serialVersionUID = 4485524436556246969L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("文件组id")
    private String[] fileGroupIds;

    public SysPermissionFileGroupAdd() {
    }

    public SysPermissionFileGroupAdd(String permissionId, String[] fileGroupIds) {
        this.permissionId = permissionId;
        this.fileGroupIds = fileGroupIds;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String[] getFileGroupIds() {
        return fileGroupIds;
    }

    public void setFileGroupIds(String[] fileGroupIds) {
        this.fileGroupIds = fileGroupIds;
    }

    @Override
    public String toString() {
        return "SysPermissionFileGroupAdd{" +
                "permissionId='" + permissionId + '\'' +
                ", fileGroupIds=" + Arrays.toString(fileGroupIds) +
                '}';
    }
}
