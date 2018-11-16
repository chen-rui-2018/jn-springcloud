package com.jn.system.vo;

import com.jn.system.entity.TbSysGroup;
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
    private List<TbSysGroup> sysGroupOfUser;
    @ApiModelProperty("所有的用户组")
    private List<TbSysGroup> sysGroupAll;

    public SysUserGroupVO() {
    }

    public SysUserGroupVO(List<TbSysGroup> sysGroupOfUser, List<TbSysGroup> sysGroupAll) {
        this.sysGroupOfUser = sysGroupOfUser;
        this.sysGroupAll = sysGroupAll;
    }

    public List<TbSysGroup> getSysGroupOfUser() {
        return sysGroupOfUser;
    }

    public void setSysGroupOfUser(List<TbSysGroup> sysGroupOfUser) {
        this.sysGroupOfUser = sysGroupOfUser;
    }

    public List<TbSysGroup> getSysGroupAll() {
        return sysGroupAll;
    }

    public void setSysGroupAll(List<TbSysGroup> sysGroupAll) {
        this.sysGroupAll = sysGroupAll;
    }


    @Override
    public String toString() {
        return "SysUserGroupVO{" +
                "sysGroupOfUser=" + sysGroupOfUser +
                ", sysGroupAll=" + sysGroupAll +
                '}';
    }
}
