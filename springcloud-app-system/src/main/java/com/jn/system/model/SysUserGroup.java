package com.jn.system.model;

import java.io.Serializable;
import java.util.Date;

/**
 *用户组用户实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysUserGroup implements Serializable {

    private static final long serialVersionUID = -3719419034027851775L;
    /**
     * id
     */
    private String id;
    /**
     * 用户组id
     */
    private String groupId;
    /**
     * 创造者
     */
    private String creator;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1删除
     */
    private String status;

    public SysUserGroup() {
    }

    public SysUserGroup(String id, String groupId, String creator, String userId, Date createTime, String status) {
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
        return "SysUserGroup{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", creator='" + creator + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}