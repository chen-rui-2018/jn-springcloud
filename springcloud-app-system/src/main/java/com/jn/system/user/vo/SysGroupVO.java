package com.jn.system.user.vo;

import com.jn.system.permission.model.SysRole;
import com.jn.system.user.model.SysTUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户组实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupVO",description = "用户组VO")
public class SysGroupVO implements Serializable {

    private static final long serialVersionUID = 2758645323376032467L;
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
    private List<SysRole> sysRoleList;
    @ApiModelProperty("关联用户")
    private List<SysTUser> sysTUserList;

    public SysGroupVO() {
    }

    public SysGroupVO(String id, String groupName, Date createTime, String status, String creator,
                      List<SysRole> sysRoleList, List<SysTUser> sysTUserList) {
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

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    public List<SysTUser> getSysTUserList() {
        return sysTUserList;
    }

    public void setSysTUserList(List<SysTUser> sysTUserList) {
        this.sysTUserList = sysTUserList;
    }

    @Override
    public String toString() {
        return "SysGroupVO{" +
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