package com.jn.system.vo;

import java.util.Date;

/**
 * 权限文件组关联表
 */
public class TbSysPermissionFiles {
    private String id;

    private String permissionId; //权限id

    private String fileGroupId; //文件组id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysPermissionFiles() {
    }

    public TbSysPermissionFiles(String id, String permissionId, String fileGroupId,
                                Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.fileGroupId = fileGroupId;
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

    public String getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String fileGroupId) {
        this.fileGroupId = fileGroupId;
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
        return "TbSysPermissionFiles{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", fileGroupId='" + fileGroupId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}