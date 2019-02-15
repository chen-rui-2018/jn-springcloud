package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 岗位添加
 *
 * @author： shaobao
 * @date： Created on 2018/11/8 16:41
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPostAdd", description = "岗位添加")
public class SysPostAdd implements Serializable {
    private static final long serialVersionUID = 7770105271133774300L;

    @ApiModelProperty("岗位名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位名称校验失败")
    private String postName;

    @ApiModelProperty("状态，0删除，1有效，2无效")
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    @ApiModelProperty("岗位类型id")
    @NotBlank(message = "岗位类型不能为空")
    private String postTypeId;

    public SysPostAdd() {
    }

    public SysPostAdd(String postName, Byte recordStatus, String postTypeId) {
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
        return "SysPostAdd{" +
                "postName='" + postName + '\'' +
                ", recordStatus=" + recordStatus +
                ", postTypeId='" + postTypeId + '\'' +
                '}';
    }
}
