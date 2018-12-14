package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 岗位类型实体
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 14:56
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostType",description = "岗位类型实体")
public class SysPostType implements Serializable {
    private static final long serialVersionUID = -7630665836148323509L;

    @ApiModelProperty(value = "岗位类型id",required = true)
    private String id;
    @ApiModelProperty(value = "岗位类型名称",required = true)
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位类型名称校验失败")
    private String postTypeName;
    @ApiModelProperty(value = "创建者")
    private String creator;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "状态: 1有效,0无效,-1删除")
    @Pattern(regexp="^\\-1|[01]$",message="状态值只允许为0,1,-1")
    private String status;

    public SysPostType() {
    }

    public SysPostType(String id, String postTypeName, String creator, Date createTime, String status) {
        this.id = id;
        this.postTypeName = postTypeName;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        return "SysPostType{" +
                "id='" + id + '\'' +
                ", postTypeName='" + postTypeName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
