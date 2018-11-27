package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 用于菜单更新
 * @author： shaobao
 * @date： Created on 2018/11/26 20:17
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenuUpdate",description = "用于菜单更新")
public class SysMenuUpdate implements Serializable {
    private static final long serialVersionUID = -6561531226340259780L;
    @ApiModelProperty(value = "id" )
    @NotBlank(message = "菜单名称不能为空！")
    private String id;

    @ApiModelProperty(value = "菜单名称" )
    @NotBlank(message = "菜单名称不能为空！")
    private String menuName;

    @ApiModelProperty(value = "菜单URL" )
    @NotBlank(message = "菜单路径不能为空！")
    private String menuUrl;

    @ApiModelProperty(value = "排序" )
    private Integer sort;

    public SysMenuUpdate() {
    }

    public SysMenuUpdate(String id, String menuName, String menuUrl, Integer sort) {
        this.id = id;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SysMenuUpdate{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", sort=" + sort +
                '}';
    }
}
