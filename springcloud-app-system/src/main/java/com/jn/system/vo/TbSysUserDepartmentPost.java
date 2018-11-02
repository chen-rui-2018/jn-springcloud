package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户部门岗位关联实体类
 */
public class TbSysUserDepartmentPost implements Serializable {
    private static final long serialVersionUID = -7989897535661328826L;
    private String id;

    private String userId; //用户id

    private String departmentId; //部门id

    private String postId; //岗位id

    private String isDefault; //是否默认

    private String creator; // 创造者

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysUserDepartmentPost() {
    }

    public TbSysUserDepartmentPost(String id, String userId, String departmentId, String postId,
                                   String isDefault, String creator, Date createTime, String status) {
        this.id = id;
        this.userId = userId;
        this.departmentId = departmentId;
        this.postId = postId;
        this.isDefault = isDefault;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
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
        return "TbSysUserDepartmentPost{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", postId='" + postId + '\'' +
                ", isDefault='" + isDefault + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}