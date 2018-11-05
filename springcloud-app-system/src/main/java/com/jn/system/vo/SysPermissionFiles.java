package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:权限文件组实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysPermissionFiles implements Serializable {
    private static final long serialVersionUID = -6038618277148450372L;
    /**
     * id
     */
    private String id;
    /**
     * 权限id
     */
    private String permissionId;
    /**
     * 文件组id
     */
    private String fileGroupId;
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

    public SysPermissionFiles() {
    }

    public SysPermissionFiles(String id, String permissionId, String fileGroupId, String creator, Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.fileGroupId = fileGroupId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysPermissionFiles{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", fileGroupId='" + fileGroupId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}