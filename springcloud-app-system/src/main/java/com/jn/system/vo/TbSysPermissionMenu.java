package com.jn.system.vo;

import java.util.Date;

/**
 * 权限菜单关联表
 */
public class TbSysPermissionMenu {
    private String id;

    private String permissionId; // 权限id

    private String menuId; // 菜单id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysPermissionMenu() {
    }

    public TbSysPermissionMenu(String id, String permissionId, String menuId, Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.menuId = menuId;
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

    @Override
    public String toString() {
        return "TbSysPermissionMenu{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}