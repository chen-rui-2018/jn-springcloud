package com.jn.system.menu.vo;

import com.jn.system.menu.model.SysResources;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
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
    private String id;
    @ApiModelProperty("菜单名称")
    private String label ;
    @ApiModelProperty("用于显示菜单图标")
    private String icon;
    @ApiModelProperty("菜单路径")
    private String menuUrl;
    @ApiModelProperty("菜单路径")
    private String path;
    @ApiModelProperty("排序,菜单目录,默认排序为0,子菜单排序从1,往后开始递增")
    private Integer sort;
    @ApiModelProperty("是否是文件夹,1是,0不是")
    private String isDir;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty(value = "菜单层级" )
    private String level;
    @ApiModelProperty("父级id父级名称")
    private String parentName;
    @ApiModelProperty("创建时间")
    private Date createdTime;
    @ApiModelProperty("子菜单的集合")
    private List children;
    @ApiModelProperty("菜单功能的集合")
    private List<SysResources> resourcesList;

    public SysMenuTreeVO() {
    }

    public SysMenuTreeVO(String id, String label, String icon, String menuUrl, String path, Integer sort, String isDir,
                         String parentId, String level, String parentName, Date createdTime,
                         List children, List<SysResources> resourcesList) {
        this.id = id;
        this.label = label;
        this.icon = icon;
        this.menuUrl = menuUrl;
        this.path = path;
        this.sort = sort;
        this.isDir = isDir;
        this.parentId = parentId;
        this.level = level;
        this.parentName = parentName;
        this.createdTime = createdTime;
        this.children = children;
        this.resourcesList = resourcesList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsDir() {
        return isDir;
    }

    public void setIsDir(String isDir) {
        this.isDir = isDir;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public List<SysResources> getResourcesList() {
        return resourcesList;
    }

    public void setResourcesList(List<SysResources> resourcesList) {
        this.resourcesList = resourcesList;
    }

    @Override
    public String toString() {
        return "SysMenuTreeVO{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", icon='" + icon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", path='" + path + '\'' +
                ", sort=" + sort +
                ", isDir='" + isDir + '\'' +
                ", parentId='" + parentId + '\'' +
                ", level='" + level + '\'' +
                ", parentName='" + parentName + '\'' +
                ", createdTime=" + createdTime +
                ", children=" + children +
                ", resourcesList=" + resourcesList +
                '}';
    }
}
