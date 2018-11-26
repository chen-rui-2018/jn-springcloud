package com.jn.system.user.vo;

import com.jn.system.user.model.SysGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于用户界面返回用户具有的用户组信息及所有用户组信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/14 19:14
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserGroupVO", description = "用于用户界面返回用户具有的用户组信息及所有用户组信息")
public class SysUserGroupVO implements Serializable {
    private static final long serialVersionUID = -5046372835306323599L;
    @ApiModelProperty("用户具有的用户组")
    private List<SysGroup> sysGroupOfUserList;
    @ApiModelProperty("所有的用户组")
    private List<SysGroup> otherGroupList;

    public SysUserGroupVO() {
    }

    public SysUserGroupVO(List<SysGroup> sysGroupOfUserList, List<SysGroup> otherGroupList) {
        this.sysGroupOfUserList = sysGroupOfUserList;
        this.otherGroupList = otherGroupList;
    }

    public List<SysGroup> getSysGroupOfUserList() {
        return sysGroupOfUserList;
    }

    public void setSysGroupOfUserList(List<SysGroup> sysGroupOfUserList) {
        this.sysGroupOfUserList = sysGroupOfUserList;
    }

    public List<SysGroup> getOtherGroupList() {
        return otherGroupList;
    }

    public void setOtherGroupList(List<SysGroup> otherGroupList) {
        this.otherGroupList = otherGroupList;
    }

    @Override
    public String toString() {
        return "SysUserGroupVO{" +
                "sysGroupOfUserList=" + sysGroupOfUserList +
                ", otherGroupList=" + otherGroupList +
                '}';
    }
}
