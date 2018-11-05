package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:权限菜单实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysPermissionMenu implements Serializable {
    private static final long serialVersionUID = -7391040980927145164L;
    /**
     * id
     */
    private String id;
    /**
     * 权限id
     */
    private String permissionId;
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1删除
     */
    private String status;

    public SysPermissionMenu() {
    }

    public SysPermissionMenu(String id, String permissionId, String menuId, String creator,
                             Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.menuId = menuId;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysPermissionMenu{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}