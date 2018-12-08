package com.jn.system.permission.vo;

import com.jn.system.menu.model.SysResources;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用于权限授权返回菜单树实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/19 14:39
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenuTreeOfPermissionVO",description = "用于权限授权返回菜单树实体类")
public class SysMenuTreeOfPermissionVO implements Serializable {
    private static final long serialVersionUID = -57546156581797863L;
    @ApiModelProperty("菜单id")
    private String id;
    @ApiModelProperty("菜单名称")
    private String label ;
    @ApiModelProperty("用于显示菜单图标")
    private String icon;
    @ApiModelProperty("菜单路径")
    private String menuUrl;
    @ApiModelProperty("排序,菜单目录,默认排序为0,子菜单排序从1,往后开始递增")
    private Integer sort;
    @ApiModelProperty("是否是文件夹,1是,0不是")
    private String isDir;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("父级id父级名称")
    private String parentName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("子集合,用于封装子菜单或功能信息")
    private List children;

    public SysMenuTreeOfPermissionVO() {
    }

    public SysMenuTreeOfPermissionVO(String id, String label, String icon, String menuUrl,
                                     Integer sort, String isDir, String parentId, String parentName,
                                     Date createTime, List children) {
        this.id = id;
        this.label = label;
        this.icon = icon;
        this.menuUrl = menuUrl;
        this.sort = sort;
        this.isDir = isDir;
        this.parentId = parentId;
        this.parentName = parentName;
        this.createTime = createTime;
        this.children = children;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysMenuTreeOfPermissionVO{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", icon='" + icon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", sort=" + sort +
                ", isDir='" + isDir + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", createTime=" + createTime +
                ", children=" + children +
                '}';
    }
}
