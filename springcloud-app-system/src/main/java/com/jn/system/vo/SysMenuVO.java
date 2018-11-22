package com.jn.system.vo;

import com.jn.common.util.enums.EnumUtil;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.SysResources;

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
public class SysMenuVO implements Serializable {

    private static final long serialVersionUID = -8616863673820865812L;

    private String menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * 父级菜单ID
     */
    private String parentId;
    /**
     * 父级菜单名称
     */
    private String parentMenuName;

    /**
     * 排序
     */
    private String sort;

    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;

    /**
     * 是否目录 1:目录 0:文件
     */
    private String isDir;



    /**
     * 菜单层级
     */
    private String level;



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
}
