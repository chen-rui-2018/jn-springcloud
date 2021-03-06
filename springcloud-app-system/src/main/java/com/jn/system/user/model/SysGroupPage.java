package com.jn.system.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户组分页及查询条件
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 16:49
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupPage", description = "用户组分页及查询条件")
public class SysGroupPage extends Page implements Serializable {

    private static final long serialVersionUID = -2672024922368575734L;

    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("创建状态")
    private Byte recordStatus;


    public SysGroupPage() {
    }

    public SysGroupPage(String groupName, Byte recordStatus) {
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
        return "SysGroupPage{" +
                "groupName='" + groupName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
