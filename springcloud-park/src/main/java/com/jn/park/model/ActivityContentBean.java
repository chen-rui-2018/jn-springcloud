package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author： jiangyl
 * @date： Created on 2018/12/18 9:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityContentBean", description = "活动基本信息")
public class ActivityContentBean extends Page implements Serializable {
    @ApiModelProperty(value = "活动ID(新增时传空，修改时必传)")
    private String id;
    @ApiModelProperty(value = "活动类型(传通过/findActivityTypeList查询出的活动类型值)")
    private String actiType;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)")
    private String actiStartTime;
    @ApiModelProperty(value = "活动结束时间")
    private String actiEndTime;
    @ApiModelProperty(value = "活动报名结束时间")
    private String applyEndTime;
    @ApiModelProperty(value = "活动消息发送时间")
    private String mesSendTime;
    @ApiModelProperty(value = "活动园区(传通过/getParkCodeByType查询的园区列表值)")
    private String parkId;
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
    @ApiModelProperty(value = "活动状态(修改只能修改活动状态state为1(草稿)的数据。新增活动为草稿时，必填字段只为活动名，当发布活动时，会校验所有必填字段。)")
    private String state;
    @ApiModelProperty(value = "是否首页展示")
    private String isIndex;
    @ApiModelProperty(value = "排序-若排序字段为空，后台自动对其排序为0(靠后排序)")
    private Integer actiOrder;
    @ApiModelProperty(value = "活动详情")
    private String actiDetail;
    @ApiModelProperty(value = "是否展示报名人-0否1是")
    private String showApplyNum;

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

    public String getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(String isIndex) {
        this.isIndex = isIndex;
    }

    public Integer getActiOrder() {
        return actiOrder;
    }

    public void setActiOrder(Integer actiOrder) {
        this.actiOrder = actiOrder;
    }

    public String getActiDetail() {
        return actiDetail;
    }

    public void setActiDetail(String actiDetail) {
        this.actiDetail = actiDetail;
    }

    public String getShowApplyNum() {
        return showApplyNum;
    }

    public void setShowApplyNum(String showApplyNum) {
        this.showApplyNum = showApplyNum;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }
}
