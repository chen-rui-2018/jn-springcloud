package com.jn.system.model;

import com.jn.common.model.Page;
import com.rabbitmq.client.AMQP;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 权限界面用于条件分页查询菜单信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 15:40
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionMenuPage", description = "权限界面用于条件分页查询菜单信息")
public class SysPermissionMenuPage extends Page implements Serializable {
    private static final long serialVersionUID = -2701575525843023524L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("菜单名称")
    private String menuName;

    public SysPermissionMenuPage() {
    }

    public SysPermissionMenuPage(String permissionId, String menuName) {
        this.permissionId = permissionId;
        this.menuName = menuName;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "SysPermissionMenuPage{" +
                "permissionId='" + permissionId + '\'' +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
