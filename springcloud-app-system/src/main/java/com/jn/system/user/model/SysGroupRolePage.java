package com.jn.system.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;

/**
 * 用户组界面条件分页查询角色
 * @author： shaobao
 * @date： Created on 2018/11/17 11:49
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupRolePage",description = "用户组界面条件分页查询角色")
public class SysGroupRolePage extends Page implements Serializable {
    private static final long serialVersionUID = 4760642234503520961L;
    @ApiModelProperty("用户组id")
    private String groupId;
    @ApiModelProperty("角色名称")
    private String roleName;

    public SysGroupRolePage() {
    }

    public SysGroupRolePage(String groupId, String roleName) {
        this.groupId = groupId;
        this.roleName = roleName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysGroupRolePage{" +
                "groupId='" + groupId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
