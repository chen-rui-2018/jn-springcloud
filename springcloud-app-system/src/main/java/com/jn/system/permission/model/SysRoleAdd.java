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

    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysRoleAdd() {
    }

    public SysRoleAdd(String roleName, Byte recordStatus) {
        this.roleName = roleName;
        this.recordStatus = recordStatus;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysRoleAdd{" +
                "roleName='" + roleName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
