package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 岗位类型增加实体
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 11:43
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostTypeAdd", description = "岗位类型增加实体")
public class SysPostTypeAdd implements Serializable {
    private static final long serialVersionUID = 5217124202179996206L;

    @ApiModelProperty("岗位类型名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位类型名称校验失败")
    private String postTypeName;

    @ApiModelProperty("状态，0删除，1有效，2无效")
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    public SysPostTypeAdd() {
    }

    public SysPostTypeAdd(String postTypeName, Byte recordStatus) {
        this.postTypeName = postTypeName;
        this.recordStatus = recordStatus;
    }

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysPostTypeAdd{" +
                "postTypeName='" + postTypeName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
