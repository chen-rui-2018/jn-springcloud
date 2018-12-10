package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用于菜单添加
 *
 * @author： shaobao
 * @date： Created on 2018/11/19 10:34
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenuAdd",description = "用于菜单添加")
public class SysMenuAdd implements Serializable {
    private static final long serialVersionUID = -5712604602274725873L;

    @ApiModelProperty(value = "菜单名称" )
    @NotBlank(message = "菜单名称不能为空！")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "菜单名称校验失败")
    private String menuName;

    @ApiModelProperty(value = "菜单URL" )
    @NotBlank(message = "菜单路径不能为空！")
    @Size(max = 50,message = "菜单路径长度不能超度50字")
    private String menuUrl;

    @ApiModelProperty(value = "父级菜单ID" )
    @NotBlank(message = "父级菜单ID不能为空！")
    private String parentId;

    public SysMenuAdd() {
    }

    public SysMenuAdd(String menuName, String menuUrl, String parentId) {
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "SysMenuAdd{" +
                "menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
