package com.jn.system.dept.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 岗位分页
 *
 * @author： shaobao
 * @date： Created on 2018/11/8 17:03
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostPage", description = "岗位分页")
public class SysPostPage extends Page implements Serializable {
    private static final long serialVersionUID = 4641296367346454971L;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;
    @ApiModelProperty("岗位类型id")
    private String postTypeId;

    public SysPostPage() {
    }

    public SysPostPage(String postName, Byte recordStatus, String postTypeId) {
        this.postName = postName;
        this.recordStatus = recordStatus;
        this.postTypeId = postTypeId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
                ", recordStatus=" + recordStatus +
                ", postTypeId='" + postTypeId + '\'' +
                '}';
    }
}
