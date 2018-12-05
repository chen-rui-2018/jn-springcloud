package com.jn.portals.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动点评信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityComment", description = "活动报名信息")
public class ActivityComment implements Serializable {
    @ApiModelProperty(value = "点评ID")
    private String id;
    @ApiModelProperty(value = "点评父ID(点评ID/活动ID)")
    private String pId;
    @ApiModelProperty(value = "点评人")
    private String comUserId;
    @ApiModelProperty(value = "点评时间")
    private Date comTime;
    @ApiModelProperty(value = "点评点赞数")
    private Integer likeNum;
    @ApiModelProperty(value = "点评状态")
    private String state;
    @ApiModelProperty(value = "点评类型(0：活动点评，1：服务点评...)")
    private String comType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public String getComUserId() {
        return comUserId;
    }

    public void setComUserId(String comUserId) {
        this.comUserId = comUserId == null ? null : comUserId.trim();
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType == null ? null : comType.trim();
    }

}