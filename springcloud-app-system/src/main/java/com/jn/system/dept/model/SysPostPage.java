package com.jn.system.dept.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 岗位分页
 * @author： shaobao
 * @date： Created on 2018/11/8 17:03
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostPage",description = "岗位分页")
public class SysPostPage extends Page implements Serializable {
    private static final long serialVersionUID = 4641296367346454971L;
    @ApiModelProperty("岗位名称")
    @Pattern(regexp = "^$|[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位名称校验失败")
    private String postName;
    @ApiModelProperty("状态")
    @Pattern(regexp="^$|\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;
    @ApiModelProperty("岗位类型id")
    private String postTypeId;

    public SysPostPage() {
    }

    public SysPostPage(String postName, String status, String postTypeId) {
        this.postName = postName;
        this.status = status;
        this.postTypeId = postTypeId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(String postTypeId) {
        this.postTypeId = postTypeId;
    }

    @Override
    public String toString() {
        return "SysPostPage{" +
                "postName='" + postName + '\'' +
                ", status='" + status + '\'' +
                ", postTypeId='" + postTypeId + '\'' +
                '}';
    }
}
