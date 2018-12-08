package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用于菜单界面校验功能名称是否存在
 *
 * @author： shaobao
 * @date： Created on 2018/11/19 9:32
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysResourceCheckName",description = "用于菜单界面校验功能名称是否存在")
public class SysResourceCheckName implements Serializable {
    private static final long serialVersionUID = -8238684478373749160L;
    @ApiModelProperty("页面功能名称")
    @NotBlank(message = "功能名称不能为空")
    private String resourceName;
    @ApiModelProperty("菜单id")
    @NotBlank(message = "菜单id不能为空")
    private String menuId;

    public SysResourceCheckName() {
    }

    public SysResourceCheckName(String resourceName, String menuId) {
        this.resourceName = resourceName;
        this.menuId = menuId;
    }


    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SysResourceCheckName{" +
                "resourceName='" + resourceName + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
