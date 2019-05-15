package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/14 15:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DynamicLikeOperate",description ="动态点赞/取消点赞实体" )
public class DynamicLikeOperate implements Serializable {

    private static final long serialVersionUID = 1920641982092896995L;
    @ApiModelProperty(value = "目标动态id",required = true,example = "dtid123...")
    private String dynamicId;
    @ApiModelProperty(value = "状态码 ,1:点赞, 0;取消点赞",required = true,example = "1")
    private String likeStatus;

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(String likeStatus) {
        this.likeStatus = likeStatus;
    }

    @Override
    public String toString() {
        return "DynamicLikeOperate{" +
                "dynamicId='" + dynamicId + '\'' +
                ", likeStatus='" + likeStatus + '\'' +
                '}';
    }
}
