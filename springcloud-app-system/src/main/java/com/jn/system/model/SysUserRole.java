package com.jn.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户角色关系
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 15:24
 * @version： v1.0
 * @modified By:
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 6938418955984330913L;
    private String id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getCreateTime() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
