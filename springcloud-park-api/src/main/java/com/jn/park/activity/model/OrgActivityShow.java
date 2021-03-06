package com.jn.park.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 15:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgActivityShow", description = "机构活动信息")
public class OrgActivityShow  implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动地址")
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
    @ApiModelProperty(value = "报名人头像列表串,以逗号分隔")
    private String avatar;
    @ApiModelProperty(value = "报名人头像列表")
    private List<String> avatarList;
    @ApiModelProperty(value = "是否已报名此活动 0 否 : 1 是")
    private String applyStatus;
    @ApiModelProperty(value = "活动状态（1草稿 2报名中 3活动结束4活动取消）")
    private String actiStatus;
    @ApiModelProperty(value = "活动总数")
    private String actiNum;
    @ApiModelProperty(value = "最近一月活动数")
    private String monthNum;
    @ApiModelProperty(value = "最近一周活动数")
    private String weekNum;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public List<String> getAvatarList() {
        return avatarList;
    }

    public void setAvatarList(List<String> avatarList) {
        this.avatarList = avatarList;
    }

    public String getActiNum() {
        return actiNum;
    }

    public void setActiNum(String actiNum) {
        this.actiNum = actiNum;
    }

    public String getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(String monthNum) {
        this.monthNum = monthNum;
    }

    public String getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum;
    }

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

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "OrgActivityShow{" +
                "id='" + id + '\'' +
                ", actiName='" + actiName + '\'' +
                ", actiAddress='" + actiAddress + '\'' +
                ", actiStartTime='" + actiStartTime + '\'' +
                ", actiEndTime='" + actiEndTime + '\'' +
                ", actiNumber=" + actiNumber +
                ", actiPosterUrl='" + actiPosterUrl + '\'' +
                ", actiLike=" + actiLike +
                ", applyNum=" + applyNum +
                ", avatar='" + avatar + '\'' +
                ", avatarList='" + avatarList + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", actiStatus='" + actiStatus + '\'' +
                ", actiNum='" + actiNum + '\'' +
                ", monthNum='" + monthNum + '\'' +
                ", weekNum='" + weekNum + '\'' +
                '}';
    }
}
