package com.jn.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @ApiModelProperty(value = "id",required = true)
    private String id;
    @ApiModelProperty(value ="岗位名称",required = true)
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "岗位名称校验失败")
    private String postName;
    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;
    @ApiModelProperty(value ="岗位类型id",required = true)
    private String postTypeId;
    @ApiModelProperty("岗位类型名称")
    private String postTypeName;
    @ApiModelProperty("等级")
    @NotNull(message = "等级不能为空")
    private Integer rank;

    public SysPost() {
    }

    public SysPost(String id, String postName, Date createdTime, Byte recordStatus,
                   String postTypeId, String postTypeName, Integer rank) {
        this.id = id;
        this.postName = postName;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.postTypeId = postTypeId;
        this.postTypeName = postTypeName;
        this.rank = rank;
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

    public String getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(String postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "SysPost{" +
                "id='" + id + '\'' +
                ", postName='" + postName + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", postTypeId='" + postTypeId + '\'' +
                ", postTypeName='" + postTypeName + '\'' +
                ", rank=" + rank +
                '}';
    }
}
