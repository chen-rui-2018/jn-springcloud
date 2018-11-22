package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色更新实体
 * @author： shaobao
 * @date： Created on 2018/11/16 10:26
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleUpdate",description = "角色更新实体")
public class SysRoleUpdate implements Serializable {
    private static final long serialVersionUID = 6852019413530175809L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空！")
    private String roleName;

    @ApiModelProperty(value = "状态 1：有效，0：无效，-1：删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysRoleUpdate() {
    }

    public SysRoleUpdate(String id, String roleName, String status) {
        this.id = id;
        this.roleName = roleName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "SysRoleUpdate{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
