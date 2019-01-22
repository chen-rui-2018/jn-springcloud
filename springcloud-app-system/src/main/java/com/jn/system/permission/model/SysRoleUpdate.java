package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "角色名称校验失败")
    private String roleName;

    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysRoleUpdate() {
    }

    public SysRoleUpdate(String id, String roleName, Byte recordStatus) {
        this.id = id;
        this.roleName = roleName;
        this.recordStatus = recordStatus;
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysRoleUpdate{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
