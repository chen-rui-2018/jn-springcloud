package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 权限条件分页
 * @author： shaobao
 * @date： Created on 2018/11/9 10:55
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionPage",description = "权限条件分页")
public class SysPermissionPage extends Page implements Serializable {
    private static final long serialVersionUID = 5250362586633368476L;
    @ApiModelProperty("权限名称")
    private String permissionName;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private Byte recordStatus;

    public SysPermissionPage() {
    }

    public SysPermissionPage(String permissionName, Byte recordStatus) {
        this.permissionName = permissionName;
        this.recordStatus = recordStatus;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysPermissionPage{" +
                "permissionName='" + permissionName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
