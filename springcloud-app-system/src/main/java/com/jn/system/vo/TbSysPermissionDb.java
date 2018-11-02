package com.jn.system.vo;

import java.util.Date;

/**
 * 数据权限表
 */
public class TbSysPermissionDb {
    private String id;

    private String departmentId; //部门id

    private String postId; //岗位id

    private String parentId; //父id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysPermissionDb() {
    }

    public TbSysPermissionDb(String id, String departmentId, String postId, String parentId,
                             Date createTime, String status) {
        this.id = id;
        this.departmentId = departmentId;
        this.postId = postId;
        this.parentId = parentId;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        return "TbSysPermissionDb{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", postId='" + postId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}