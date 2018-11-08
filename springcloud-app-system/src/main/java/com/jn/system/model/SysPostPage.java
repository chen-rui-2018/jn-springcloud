package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： shaobao
 * @date： Created on 2018/11/8 17:03
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostPage",description = "岗位分页")
public class SysPostPage extends Page implements Serializable {
    private static final long serialVersionUID = 4641296367346454971L;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("状态")
    private String status;

    public SysPostPage() {
    }

    public SysPostPage(String postName, String status) {
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
        return "SysPostPage{" +
                "postName='" + postName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
