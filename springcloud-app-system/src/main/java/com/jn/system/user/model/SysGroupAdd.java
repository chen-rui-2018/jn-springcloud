package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户组添加实体类
 *
 * @author： shaobao
 * @date： Created on 2018/12/4 16:21
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupAdd", description = "用户组添加实体类")
public class SysGroupAdd implements Serializable {
    private static final long serialVersionUID = 4267579545005088033L;
    @ApiModelProperty("用户组名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "用户组名校验失败")
    private String groupName;
    @ApiModelProperty("状态")
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    public SysGroupAdd() {
    }

    public SysGroupAdd(String groupName, Byte recordStatus) {
        this.groupName = groupName;
        this.recordStatus = recordStatus;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysGroupAdd{" +
                "groupName='" + groupName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
