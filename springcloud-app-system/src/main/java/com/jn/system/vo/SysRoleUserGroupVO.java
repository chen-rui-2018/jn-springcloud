package com.jn.system.vo;

import com.jn.system.model.SysGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 返回角色具有的用户组信息及为具有的用户组信息
 * @author： shaobao
 * @date： Created on 2018/11/16 15:28
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleUserGroupVO",description = "返回角色具有的用户组信息及为具有的用户组信息")
public class SysRoleUserGroupVO implements Serializable {
    private static final long serialVersionUID = 2714645223774696946L;
    @ApiModelProperty("角色已有的用户组信息")
    private List<SysGroup> userGroupOfRoleList;
    @ApiModelProperty("角色未拥有的用户组信息")
    private List<SysGroup> otherUserGroupList;

    public SysRoleUserGroupVO() {
    }

    public SysRoleUserGroupVO(List<SysGroup> userGroupOfRoleList, List<SysGroup> otherUserGroupList) {
        this.userGroupOfRoleList = userGroupOfRoleList;
        this.otherUserGroupList = otherUserGroupList;
    }

    public List<SysGroup> getUserGroupOfRoleList() {
        return userGroupOfRoleList;
    }

    public void setUserGroupOfRoleList(List<SysGroup> userGroupOfRoleList) {
        this.userGroupOfRoleList = userGroupOfRoleList;
    }

    public List<SysGroup> getOtherUserGroupList() {
        return otherUserGroupList;
    }

    public void setOtherUserGroupList(List<SysGroup> otherUserGroupList) {
        this.otherUserGroupList = otherUserGroupList;
    }

    @Override
    public String toString() {
        return "SysRoleUserGroupVO{" +
                "userGroupOfRoleList=" + userGroupOfRoleList +
                ", otherUserGroupList=" + otherUserGroupList +
                '}';
    }
}
