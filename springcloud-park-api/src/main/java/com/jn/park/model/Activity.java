package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 活动信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "Activity", description = "活动信息")
public class Activity extends Page implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动类型")
    private String actiType;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动开始时间")
    private String actiStartTime;
    @ApiModelProperty(value = "活动结束时间")
    private String actiEndTime;
    @ApiModelProperty(value = "活动报名开始时间")
    private String applyStartTime;
    @ApiModelProperty(value = "活动报名结束时间")
    private String applyEndTime;
    @ApiModelProperty(value = "活动消息发送时间")
    private String mesSendTime;
    @ApiModelProperty(value = "活动地址")
    private String actiAddress;
    @ApiModelProperty(value = "活动费用")
    private BigDecimal actiCost;
    @ApiModelProperty(value = "活动主办方")
    private String actiOrganizer;
    @ApiModelProperty(value = "活动人数")
    private Integer actiNumber;
    @ApiModelProperty(value = "活动海报路径")
    private String actiPosterUrl;
    @ApiModelProperty(value = "活动状态")
    private String state;
    @ApiModelProperty(value = "活动发布时间")
    private String createTime;
    @ApiModelProperty(value = "活动创建人ID")
    private String createUserId;
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "修改人")
    private String updateUserId;
    @ApiModelProperty(value = "阅读人数")
    private Integer actiViews;
    @ApiModelProperty(value = "点赞人数")
    private Integer actiLike;
    @ApiModelProperty(value = "报名人数")
    private Integer applyNum;
    @ApiModelProperty(value = "实际参加人数")
    private Integer particNum;
    @ApiModelProperty(value = "是否置顶")
    private String isTop;
    @ApiModelProperty(value = "置顶时间")
    private String topTime;
    @ApiModelProperty(value = "是否可报名")
    private String isApply;
    @ApiModelProperty(value = "排序")
    private Integer actiOrder;
    @ApiModelProperty(value = "活动类型名称")
    private String typeName;
    @ApiModelProperty(value = "活动详情")
    private String actiDetail;
    @ApiModelProperty(value = "活动报名人头像列表")
    private String avatar;

    public String getApplyList() {
        return avatar;
    }

    public void setApplyList(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActiType() {
        return actiType;
    }

    public void setActiType(String actiType) {
        this.actiType = actiType;
    }

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName;
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

    public String getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(String applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public String getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(String applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public String getMesSendTime() {
        return mesSendTime;
    }

    public void setMesSendTime(String mesSendTime) {
        this.mesSendTime = mesSendTime;
    }

    public String getActiAddress() {
        return actiAddress;
    }

    public void setActiAddress(String actiAddress) {
        this.actiAddress = actiAddress;
    }

    public BigDecimal getActiCost() {
        return actiCost;
    }

    public void setActiCost(BigDecimal actiCost) {
        this.actiCost = actiCost;
    }

    public String getActiOrganizer() {
        return actiOrganizer;
    }

    public void setActiOrganizer(String actiOrganizer) {
        this.actiOrganizer = actiOrganizer;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getActiViews() {
        return actiViews;
    }

    public void setActiViews(Integer actiViews) {
        this.actiViews = actiViews;
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

    public Integer getParticNum() {
        return particNum;
    }

    public void setParticNum(Integer particNum) {
        this.particNum = particNum;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getTopTime() {
        return topTime;
    }

    public void setTopTime(String topTime) {
        this.topTime = topTime;
    }

    public String getIsApply() {
        return isApply;
    }

    public void setIsApply(String isApply) {
        this.isApply = isApply;
    }

    public Integer getActiOrder() {
        return actiOrder;
    }

    public void setActiOrder(Integer actiOrder) {
        this.actiOrder = actiOrder;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getActiDetail() {
        return actiDetail;
    }

    public void setActiDetail(String actiDetail) {
        this.actiDetail = actiDetail;
    }
}