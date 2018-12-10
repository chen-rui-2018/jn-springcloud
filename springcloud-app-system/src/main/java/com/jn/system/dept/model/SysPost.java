package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 岗位
 * @author： shaobao
 * @date： Created on 2018/11/8 16:37
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPost",description = "岗位")
public class SysPost implements Serializable {
    private static final long serialVersionUID = -983797756680764097L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("岗位名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位名称校验失败")
    private String postName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysPost() {
    }

    public SysPost(String id, String postName, Date createTime, String status) {
        this.id = id;
        this.postName = postName;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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
        return "SysPost{" +
                "id='" + id + '\'' +
                ", postName='" + postName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
