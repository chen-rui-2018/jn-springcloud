package com.jn.system.vo;

import com.jn.system.model.SysRole;
import com.jn.system.model.SysTUser;
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
    private Date createTime;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private String status;
    @ApiModelProperty("创建人")
    private String creator;
    @ApiModelProperty("关联角色")
    private List<String> sysRoleList;
    @ApiModelProperty("关联用户")
    private List<String> sysTUserList;

    public SysGroupUserRoleVO() {
    }

    public SysGroupUserRoleVO(String id, String groupName, Date createTime, String status,
                              String creator, List<String> sysRoleList, List<String> sysTUserList) {
        this.id = id;
        this.groupName = groupName;
        this.createTime = createTime;
        this.status = status;
        this.creator = creator;
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
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", creator='" + creator + '\'' +
                ", sysRoleList=" + sysRoleList +
                ", sysTUserList=" + sysTUserList +
                '}';
    }
}
