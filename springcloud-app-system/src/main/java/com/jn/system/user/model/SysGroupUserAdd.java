package com.jn.system.user.model;

import com.jn.system.common.enums.SysStatusEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 用户组添加用户实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/6 9:23
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupUserAdd", description = "用户组添加用户实体")
public class SysGroupUserAdd implements Serializable {
    private static final long serialVersionUID = 910510404898260992L;

    @ApiModelProperty("用户id数组")
    private String[] userIds;
    @NotBlank(message = "用户组id不能为空")
    @ApiModelProperty("用户组id")
    private String groupId;

    public SysGroupUserAdd() {
    }

    public SysGroupUserAdd(String[] userIds, String groupId) {
        this.userIds = userIds;
        this.groupId = groupId;
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "SysGroupUserAdd{" +
                "userIds=" + Arrays.toString(userIds) +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
