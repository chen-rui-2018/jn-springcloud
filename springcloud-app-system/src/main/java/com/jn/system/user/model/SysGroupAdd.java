package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    @Size(max = 20,message = "用户组名称字数不能超过20个")
    private String groupName;
    @ApiModelProperty("状态")
    @Pattern(regexp = "^\\-1|[01]$", message = "{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysGroupAdd() {
    }

    public SysGroupAdd(String groupName, String status) {
        this.groupName = groupName;
        this.status = status;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "SysGroupAdd{" +
                "groupName='" + groupName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
