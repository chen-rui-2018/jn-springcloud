package com.jn.system.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户组信息及角色与用户信息
 * @author： shaobao
 * @date： Created on 2018/11/12 20:50
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupUserRoleVO",description = "用户组信息及角色与用户信息")
public class SysGroupUserRoleVO implements Serializable {

    private static final long serialVersionUID = 9020015308592136915L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("用户组名称")
    private String groupName;
    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private Byte recordStatus;
    @ApiModelProperty("创建人")
    private String creatorAccount;
    @ApiModelProperty("关联角色")
    private List<String> sysRoleList;
    @ApiModelProperty("关联用户")
    private List<String> sysTUserList;

    public SysGroupUserRoleVO() {
    }

    public SysGroupUserRoleVO(String id, String groupName, Date createdTime, Byte recordStatus, String creatorAccount,
                              List<String> sysRoleList, List<String> sysTUserList) {
        this.id = id;
        this.groupName = groupName;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.creatorAccount = creatorAccount;
        this.sysRoleList = sysRoleList;
        this.sysTUserList = sysTUserList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public List<String> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<String> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public List<String> getSysTUserList() {
        return sysTUserList;
    }

    public void setSysTUserList(List<String> sysTUserList) {
        this.sysTUserList = sysTUserList;
    }

    @Override
    public String toString() {
        return "SysGroupUserRoleVO{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", sysRoleList=" + sysRoleList +
                ", sysTUserList=" + sysTUserList +
                '}';
    }
}
