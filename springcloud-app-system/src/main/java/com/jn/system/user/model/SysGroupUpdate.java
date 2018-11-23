package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户组更新实体
 * @author： shaobao
 * @date： Created on 2018/11/19 19:37
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupUpdate",description = "用户组更新实体")
public class SysGroupUpdate implements Serializable {
    private static final long serialVersionUID = -6740363506874538711L;
    @ApiModelProperty("用户组id")
    @NotBlank(message = "用户组id不能为空")
    private String id;
    @ApiModelProperty("用户组名称")
    private String groupName;
    @ApiModelProperty("状态")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysGroupUpdate() {
    }

    public SysGroupUpdate(String id, String groupName, String status) {
        this.id = id;
        this.groupName = groupName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "SysGroupUpdate{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
