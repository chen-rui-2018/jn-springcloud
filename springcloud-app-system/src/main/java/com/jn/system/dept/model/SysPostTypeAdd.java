package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 岗位类型增加实体
 * @author： shaobao
 * @date： Created on 2018/12/10 11:43
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostTypeAdd",description = "岗位类型增加实体")
public class SysPostTypeAdd implements Serializable {
    private static final long serialVersionUID = 5217124202179996206L;

    @ApiModelProperty("岗位类型名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位类型名称校验失败")
    private String postTypeName;

    @ApiModelProperty("状态")
    @Pattern(regexp="^\\-1|[01]$",message="状态值只允许为0,1,-1")
    private String status;

    public SysPostTypeAdd() {
    }

    public SysPostTypeAdd(String postTypeName, String status) {
        this.postTypeName = postTypeName;
        this.status = status;
    }

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysPostTypeAdd{" +
                "postTypeName='" + postTypeName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
