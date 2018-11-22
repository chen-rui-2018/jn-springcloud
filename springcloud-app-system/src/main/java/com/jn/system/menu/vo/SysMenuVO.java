package com.jn.system.menu.vo;

import com.jn.system.menu.model.SysResources;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单功能vo
 *
 * @author： yuanyy
 * @date： Created on 2018/11/5 16:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysMenuVO", description = "菜单功能vo")
public class SysMenuVO implements Serializable {

    private static final long serialVersionUID = -8616863673820865812L;
    @ApiModelProperty("菜单id")
    private String menuId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /**
     * 菜单URL
     */
    @ApiModelProperty("菜单URL")
    private String menuUrl;

    /**
     * 父级菜单ID
     */
    @ApiModelProperty("父级菜单ID")
    private String parentId;
    /**
     * 父级菜单名称
     */
    @ApiModelProperty("父级菜单名称")
    private String parentMenuName;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private String sort;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creator;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty("菜单id")
    private String status;

    /**
     * 是否目录 1:目录 0:文件
     */
    @ApiModelProperty("是否目录 1:目录 0:文件")
    private String isDir;

    /**
     * 菜单层级
     */
    @ApiModelProperty("菜单层级")
    private String level;

    public SysMenuVO() {
    }

    public SysMenuVO(String menuId, String menuName, String menuUrl, String parentId, String parentMenuName,
                     String sort, String creator, Date createTime, String status,
                     String isDir, String level, List<SysResources> sysResources) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        this.parentMenuName = parentMenuName;
        this.sort = sort;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
        this.isDir = isDir;
        this.level = level;
        this.sysResources = sysResources;
    }

    private List<SysResources> sysResources;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }


    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SysResources> getSysResources() {
        return sysResources;
    }

    public void setSysResources(List<SysResources> sysResources) {
        this.sysResources = sysResources;
    }

    public String getIsDir() {
        return isDir;
    }

    public void setIsDir(String isDir) {
        this.isDir = isDir;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SysMenuVO{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentMenuName='" + parentMenuName + '\'' +
                ", sort='" + sort + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", isDir='" + isDir + '\'' +
                ", level='" + level + '\'' +
                ", sysResources=" + sysResources +
                '}';
    }
}
