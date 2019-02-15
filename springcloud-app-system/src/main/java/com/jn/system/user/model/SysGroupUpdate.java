package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "用户组名校验失败")
    private String groupName;
    @ApiModelProperty("状态")
    private Byte recordStatus;

    public SysGroupUpdate() {
    }

    public SysGroupUpdate(String id, String groupName, Byte recordStatus) {
        this.id = id;
        this.groupName = groupName;
        this.recordStatus = recordStatus;
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysGroupUpdate{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
