package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 权限界面用于条件分页查询文件组信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 14:51
 * @version： v1.0
 * @modified By:
 **/
public class SysPermissionFileGroupPage extends Page implements Serializable {
    private static final long serialVersionUID = 6279519585315732303L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("文件组名字")
    private String fileGroupName;

    public SysPermissionFileGroupPage() {
    }

    public SysPermissionFileGroupPage(String permissionId, String fileGroupName) {
        this.permissionId = permissionId;
        this.fileGroupName = fileGroupName;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getFileGroupName() {
        return fileGroupName;
    }

    public void setFileGroupName(String fileGroupName) {
        this.fileGroupName = fileGroupName;
    }

    @Override
    public String toString() {
        return "SysPermissionFileGroupPage{" +
                "permissionId='" + permissionId + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                '}';
    }
}
