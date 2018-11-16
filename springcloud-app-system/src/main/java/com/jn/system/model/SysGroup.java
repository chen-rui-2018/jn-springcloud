package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户组实体
 * @author： shaobao
 * @date： Created on 2018/11/16 15:08
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroup",description = "用户组实体")
public class SysGroup implements Serializable {
    private static final long serialVersionUID = -3123282206006153223L;
    @ApiModelProperty("用户组id")
    private String groupId;
    @ApiModelProperty("用户组名称")
    private String groupName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysGroup() {
    }

    public SysGroup(String groupId, String groupName, Date createTime, String status) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.createTime = createTime;
        this.status = status;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysGroup{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
