package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： shaobao
 * @date： Created on 2018/11/5 16:49
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupPage",description = "用户组分页及查询条件")
public class SysGroupPage extends Page implements Serializable {

    private static final long serialVersionUID = -2672024922368575734L;
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建状态")
    private String status;

    @ApiModelProperty("创建人")
    private String creator;

    public SysGroupPage() {
    }

    public SysGroupPage(String id, String groupName, Date createTime, String status, String creator) {
        this.id = id;
        this.groupName = groupName;
        this.createTime = createTime;
        this.status = status;
        this.creator = creator;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysGroupPage{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
