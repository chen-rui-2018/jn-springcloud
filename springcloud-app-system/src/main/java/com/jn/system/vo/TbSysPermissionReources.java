package com.jn.system.vo;

import java.util.Date;

/**
 * 权限功能关联表
 */
public class TbSysPermissionReources {
    private String id;

    private String permissionId; //权限id

    private String reourcesId; // 菜单id

    private Date createTime; // 创建时间

    private String status; // 状态 1:有效 0:无效

    public TbSysPermissionReources() {
    }

    public TbSysPermissionReources(String id, String permissionId, String reourcesId,
                                   Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.reourcesId = reourcesId;
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

    public String getReourcesId() {
        return reourcesId;
    }

    public void setReourcesId(String reourcesId) {
        this.reourcesId = reourcesId;
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
        return "TbSysPermissionReources{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", reourcesId='" + reourcesId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}