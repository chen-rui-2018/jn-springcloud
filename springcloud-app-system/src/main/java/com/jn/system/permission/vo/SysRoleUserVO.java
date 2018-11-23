package com.jn.system.permission.vo;

import com.jn.system.user.model.SysTUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于角色界面角色授权时返回用户信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/16 14:44
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleUserVO", description = "用于角色界面角色授权时返回用户信息")
public class SysRoleUserVO implements Serializable {
    private static final long serialVersionUID = 8791813281954545136L;
    @ApiModelProperty("角色已经拥有的用户")
    private List<SysTUser> userOfRoleList;
    @ApiModelProperty("角色未拥有的用户")
    private List<SysTUser> otherUserList;

    public SysRoleUserVO() {
    }

    public SysRoleUserVO(List<SysTUser> userOfRoleList, List<SysTUser> otherUserList) {
        this.userOfRoleList = userOfRoleList;
        this.otherUserList = otherUserList;
    }

    public List<SysTUser> getUserOfRoleList() {
        return userOfRoleList;
    }

    public void setUserOfRoleList(List<SysTUser> userOfRoleList) {
        this.userOfRoleList = userOfRoleList;
    }

    public List<SysTUser> getOtherUserList() {
        return otherUserList;
    }

    public void setOtherUserList(List<SysTUser> otherUserList) {
        this.otherUserList = otherUserList;
    }

    @Override
    public String toString() {
        return "SysRoleUserVO{" +
                "userOfRoleList=" + userOfRoleList +
                ", otherUserList=" + otherUserList +
                '}';
    }
}
