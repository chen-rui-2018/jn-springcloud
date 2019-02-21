package com.jn.system.dept.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value = "SysPostType", description = "岗位类型实体")
public class SysPostType implements Serializable {
    private static final long serialVersionUID = -7630665836148323509L;

    @ApiModelProperty(value = "岗位类型id", required = true)
    private String id;
    @ApiModelProperty(value = "岗位类型名称", required = true)
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位类型名称校验失败")
    private String postTypeName;
    @ApiModelProperty(value = "创建者")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysPostType() {
    }

    public SysPostType(String id, String postTypeName, String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.postTypeName = postTypeName;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
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

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysPostType{" +
                "id='" + id + '\'' +
                ", postTypeName='" + postTypeName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
