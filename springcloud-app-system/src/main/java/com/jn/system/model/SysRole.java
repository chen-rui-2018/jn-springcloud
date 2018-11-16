package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRole", description = "角色信息")
public class SysRole implements Serializable {
    private static final long serialVersionUID = -514084002440259994L;

    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空！")
    private String roleName;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 状态 1：有效，0：无效，-1：删除
     */
    @ApiModelProperty(value = "状态 1：有效，0：无效，-1：删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysRole)) {
            return false;
        }

        SysRole sysRole = (SysRole) o;

        if (id != null ? !id.equals(sysRole.id) : sysRole.id != null) {
            return false;
        }
        if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null) {
            return false;
        }
        if (creator != null ? !creator.equals(sysRole.creator) : sysRole.creator != null) {
            return false;
        }
        if (createTime != null ? !createTime.equals(sysRole.createTime) : sysRole.createTime != null) {
            return false;
        }
        return status != null ? status.equals(sysRole.status) : sysRole.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
