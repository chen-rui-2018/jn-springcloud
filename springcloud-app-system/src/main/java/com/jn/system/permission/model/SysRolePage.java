package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRolePage", description = "角色分页实体")
public class SysRolePage extends Page implements Serializable {

    private static final long serialVersionUID = -514084002440259994L;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    /**
     * 状态 1：有效，0：无效，-1：删除
     */
    @ApiModelProperty(value = "状态 1：有效，0：无效，-1：删除")
    private String status;

    public SysRolePage() {
    }

    public SysRolePage(String roleName, String status) {
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
        return "SysRolePage{" +
                "roleName='" + roleName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
