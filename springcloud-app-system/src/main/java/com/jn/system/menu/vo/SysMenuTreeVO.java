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
    private String id;
    @ApiModelProperty("菜单名称")
    private String label ;
    @ApiModelProperty("菜单路径")
    private String menuUrl;
    @ApiModelProperty("排序,菜单目录,默认排序为0,子菜单排序从1,往后开始递增")
    private String sort;
    @ApiModelProperty("是否是文件夹,1是,0不是")
    private String isDir;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("父级id父级名称")
    private String parentName;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("子菜单的集合")
    private List<SysMenuTreeVO> children;

    public SysMenuTreeVO() {
    }

    public SysMenuTreeVO(String id, String label, String menuUrl, String sort, String isDir, String parentId,
                         String parentName, String createTime, List<SysMenuTreeVO> children) {
        this.id = id;
        this.label = label;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", sort='" + sort + '\'' +
                ", isDir='" + isDir + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", children=" + children +
                '}';
    }
}
