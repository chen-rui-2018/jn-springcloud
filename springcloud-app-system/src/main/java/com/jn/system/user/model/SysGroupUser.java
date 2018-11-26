package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
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
@ApiModel(value = "SysGroupUser",description = "用户组用户实体")
public class SysGroupUser implements Serializable {

    private static final long serialVersionUID = -3719419034027851775L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户组id")
    private String groupId;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("状态 1有效 0无效 -1删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysGroupUser() {
    }

    public SysGroupUser(String id, String groupId, String creator, String userId, Date createTime, String status) {
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
        return "SysGroupUser{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", creator='" + creator + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}