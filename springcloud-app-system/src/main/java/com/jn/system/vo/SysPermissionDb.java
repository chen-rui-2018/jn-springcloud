package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:数据权限实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysPermissionDb implements Serializable {
    private static final long serialVersionUID = 3262404933946559706L;
    /**
     * id
     */
    private String id;
    /**
     * 部门id
     */
    private String departmentId;
    /**
     * 岗位id
     */
    private String postId;
    /**
     * 父id
     */
    private String parentId;
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

    public SysPermissionDb() {
    }

    public SysPermissionDb(String id, String departmentId, String postId, String parentId,
                           String creator, Date createTime, String status) {
        this.id = id;
        this.departmentId = departmentId;
        this.postId = postId;
        this.parentId = parentId;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysPermissionDb{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", postId='" + postId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}