package com.jn.system.vo;

import java.util.Date;

/**
 * 权限表
 */
public class TbSysPermission {
    private String id; //id

    private String permissionName; //权限名称

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysPermission() {
    }

    public TbSysPermission(String id, String permissionName, Date createTime, String status) {
        this.id = id;
        this.permissionName = permissionName;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
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
        return "TbSysPermission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}