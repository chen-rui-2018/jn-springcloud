package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 角色新增实体
 * @author： shaobao
 * @date： Created on 2018/11/16 10:16
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value ="SysRoleAdd",description = "角色新增实体")
public class SysRoleAdd implements Serializable {
    private static final long serialVersionUID = -120055469547530683L;

    @ApiModelProperty(value = "角色名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "角色名称校验失败")
    private String roleName;

    @ApiModelProperty(value = "状态 1：有效，0：无效，-1：删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysRoleAdd() {
    }

    public SysRoleAdd(String roleName, String status) {
        this.roleName = roleName;
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysRoleAdd{" +
                "roleName='" + roleName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
