package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 权限界面用于角色信息条件查询
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 14:34
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionRolePage", description = "权限界面用于角色信息条件查询")
public class SysPermissionRolePage extends Page implements Serializable {

    private static final long serialVersionUID = 1092667102413895469L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("角色名称")
    private String roleName;

    public SysPermissionRolePage() {
    }

    public SysPermissionRolePage(String permissionId, String roleName) {
        this.permissionId = permissionId;
        this.roleName = roleName;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysPermissionRolePage{" +
                "permissionId='" + permissionId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
