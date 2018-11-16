package com.jn.system.vo;

import com.jn.system.model.SysTUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用户用户组界面返回用户信息
 * @author： shaobao
 * @date： Created on 2018/11/15 10:16
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupUserVO",description = "用户用户组界面返回用户信息")
public class SysGroupUserVO implements Serializable {
    private static final long serialVersionUID = -2834508015331978496L;
    @ApiModelProperty("用户信息集合")
    private List<SysTUser> userList;
    @ApiModelProperty("用户组具有的用户信息集合")
    private List<SysTUser> userAllOfGroup;

    public SysGroupUserVO() {
    }

    public SysGroupUserVO(List<SysTUser> userList, List<SysTUser> userAllOfGroup) {
        this.userList = userList;
        this.userAllOfGroup = userAllOfGroup;
    }

    public List<SysTUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysTUser> userList) {
        this.userList = userList;
    }

    public List<SysTUser> getUserAllOfGroup() {
        return userAllOfGroup;
    }

    public void setUserAllOfGroup(List<SysTUser> userAllOfGroup) {
        this.userAllOfGroup = userAllOfGroup;
    }

    @Override
    public String toString() {
        return "SysGroupUserVO{" +
                "userList=" + userList +
                ", userAllOfGroup=" + userAllOfGroup +
                '}';
    }
}
