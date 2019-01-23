package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用于菜单名称在同一父菜单下进行名称校验
 *
 * @author： shaobao
 * @date： Created on 2018/11/20 16:51
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenuNameCheck", description = "用于菜单名称在同一父菜单下进行名称校验")
public class SysMenuNameCheck implements Serializable {
    private static final long serialVersionUID = -5501884405982377542L;
    @ApiModelProperty("菜单名称")
    private String menuName;
    @ApiModelProperty("菜单父级id")
    @NotBlank(message = "父级id不能为空")
    private String parentId;

    public SysMenuNameCheck() {
    }

    public SysMenuNameCheck(String menuName, String parentId) {
        this.menuName = menuName;
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "SysMenuNameCheck{" +
                "menuName='" + menuName + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
