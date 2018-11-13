package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位添加
 * @author： shaobao
 * @date： Created on 2018/11/8 16:41
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostAdd",description = "岗位添加")
public class SysPostAdd implements Serializable {
    private static final long serialVersionUID = 7770105271133774300L;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("状态")
    private String status;

    public SysPostAdd() {
    }

    public SysPostAdd(String postName, String status) {
        this.postName = postName;
        this.status = status;
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

    @Override
    public String toString() {
        return "SysPostAdd{" +
                "postName='" + postName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
