package com.jn.system.user.model;

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
    private Date createdTime;
    @ApiModelProperty("状态")
    private Byte recordStatus;

    public SysGroup() {
    }

    public SysGroup(String groupId, String groupName, Date createdTime, Byte recordStatus) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysGroup{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
