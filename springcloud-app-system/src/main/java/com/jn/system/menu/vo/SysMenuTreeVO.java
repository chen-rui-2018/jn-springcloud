package com.jn.system.menu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于返回菜单树实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/19 14:39
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenuTreeVO",description = "用于返回菜单树实体类")
public class SysMenuTreeVO implements Serializable {
    private static final long serialVersionUID = -6386235821868424583L;
    @ApiModelProperty("菜单id")
    private String value;
    @ApiModelProperty("菜单名称")
    private String label ;
    @ApiModelProperty("菜单路径")
    private String menuUrl;
    @ApiModelProperty("排序")
    private String sort;
    @ApiModelProperty("是否是文件夹,1是,0不是")
    private String isDir;
    @ApiModelProperty("子菜单的集合")
    private List<SysMenuTreeVO> children;

    public SysMenuTreeVO() {
    }

    public SysMenuTreeVO(String value, String label, String menuUrl, String sort,
                         String isDir, List<SysMenuTreeVO> children) {
        this.value = value;
        this.label = label;
        this.menuUrl = menuUrl;
        this.sort = sort;
        this.isDir = isDir;
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getIsDir() {
        return isDir;
    }

    public void setIsDir(String isDir) {
        this.isDir = isDir;
    }

    public List<SysMenuTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuTreeVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysMenuTreeVO{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", sort='" + sort + '\'' +
                ", isDir='" + isDir + '\'' +
                ", children=" + children +
                '}';
    }
}
