package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户组用户关联表
 */
public class TbSysUserGroup implements Serializable {

    private static final long serialVersionUID = -3719419034027851775L;
    private String id;

    private String groupId; //用户组id

    private String creator; // 创造者

    private String userId;  //用户id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysUserGroup() {
    }

    public TbSysUserGroup(String id, String groupId, String creator, String userId, Date createTime, String status) {
        this.id = id;
        this.groupId = groupId;
        this.creator = creator;
        this.userId = userId;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "TbSysUserGroup{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", creator='" + creator + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}