package com.jn.system.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户组页面添加用户时对用户进行分页查询
 * @author： shaobao
 * @date： Created on 2018/11/6 0:36
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupUserPage",description = "用户组页面添加用户时对用户进行分页查询")
public class SysGroupUserPage extends Page implements Serializable {
    private static final long serialVersionUID = 3736795853757277874L;

    @ApiModelProperty("用户组id")
    private String groupId;

    @ApiModelProperty("查询条件:用户名称")
    private String name;

    public SysGroupUserPage() {
    }

    public SysGroupUserPage(String groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysGroupUserPage{" +
                "groupId='" + groupId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
