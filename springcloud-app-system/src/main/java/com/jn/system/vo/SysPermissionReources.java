package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:权限功能实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysPermissionReources implements Serializable {
    private static final long serialVersionUID = 8368246755722203118L;
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
    private String reourcesId;
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

    public SysPermissionReources() {
    }

    public SysPermissionReources(String id, String permissionId, String reourcesId,
                                 String creator, Date createTime, String status) {
        this.id = id;
        this.permissionId = permissionId;
        this.reourcesId = reourcesId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysPermissionReources{" +
                "id='" + id + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", reourcesId='" + reourcesId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}