package com.jn.park.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * 活动信息部分字段
 *
 * @Author: chenr
 * @Date: 2018/12/11 11:15
 * @Version v1.0
 * @modified By:
 */
public class ActivitySlim {
    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动名称")
    private String actiAddress;
    @ApiModelProperty(value = "活动开始时间")
    private String  actiStartTime;
    @ApiModelProperty(value = "活动结束时间")
    private String  actiEndTime;
    @ApiModelProperty(value = "活动人数")
    private Integer actiNumber;
    @ApiModelProperty(value = "活动海报路径")
    private String actiPosterUrl;
    @ApiModelProperty(value = "点赞人数")
    private Integer actiLike;
    @ApiModelProperty(value = "报名人数")
    private Integer applyNum;
    @ApiModelProperty(value = "报名人头像列表")
    private List<String> avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName;
    }

    public String getActiAddress() {
        return actiAddress;
    }

    public void setActiAddress(String actiAddress) {
        this.actiAddress = actiAddress;
    }

    public String getActiStartTime() {
        return actiStartTime;
    }

    public void setActiStartTime(String actiStartTime) {
        this.actiStartTime = actiStartTime;
    }

    public String getActiEndTime() {
        return actiEndTime;
    }

    public void setActiEndTime(String actiEndTime) {
        this.actiEndTime = actiEndTime;
    }

    public Integer getActiNumber() {
        return actiNumber;
    }

    public void setActiNumber(Integer actiNumber) {
        this.actiNumber = actiNumber;
    }

    public String getActiPosterUrl() {
        return actiPosterUrl;
    }

    public void setActiPosterUrl(String actiPosterUrl) {
        this.actiPosterUrl = actiPosterUrl;
    }

    public Integer getActiLike() {
        return actiLike;
    }

    public void setActiLike(Integer actiLike) {
        this.actiLike = actiLike;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public List<String> getAvatar() {
        return avatar;
    }

    public void setAvatar(List<String> avatar) {
        this.avatar = avatar;
    }
}
