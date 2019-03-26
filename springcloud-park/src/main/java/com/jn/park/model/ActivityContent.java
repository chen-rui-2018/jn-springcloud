package com.jn.park.model;

import javax.validation.constraints.NotNull;
import com.jn.common.model.Page;
import com.jn.common.util.Assert;
import com.jn.park.enums.ActivityExceptionEnum;
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
@ApiModel(value = "ActivityContent", description = "活动基本信息")
public class ActivityContent extends Page implements Serializable {

    @ApiModelProperty(value = "活动ID(新增时传空，修改时必传)")
    private String id;
    @ApiModelProperty(value = "活动类型(传通过/findActivityTypeList查询出的活动类型值)",notes = "保存草稿时可空，发布活动时必填",example = "a29e14a21352473ebf26420ddffb1c60")
    private String actiType;
    @NotNull(message = "活动名称不能为空")
    @ApiModelProperty(value = "活动名称",required = true,example = "***活动")
    private String actiName;
    @ApiModelProperty(value = "活动开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)",notes = "保存草稿时可空，发布活动时必填",example = "2019-03-03 10:00:00")
    private String actiStartTime;
    @ApiModelProperty(value = "活动结束时间",notes = "保存草稿时可空，发布活动时必填",example = "2019-03-03 10:00:00")
    private String actiEndTime;
    @ApiModelProperty(value = "活动报名结束时间",notes = "保存草稿时可空，发布活动时必填",example = "2019-03-03 10:00:00")
    private String applyEndTime;
    @ApiModelProperty(value = "活动消息发送时间",notes = "保存草稿时可空，发布活动时必填",example = "2019-03-03 10:00:00")
    private String mesSendTime;
    @ApiModelProperty(value = "活动园区(传通过/getParkCodeByType查询的园区列表值[codeValue])",notes = "保存草稿时可空，发布活动时必填",example = "002")
    private String parkId;
    @ApiModelProperty(value = "活动地址",notes = "保存草稿时可空，发布活动时必填",example = "***地址")
    private String actiAddress;
    @ApiModelProperty(value = "活动费用",notes = "保存草稿时可空，发布活动时必填",example = "0")
    private BigDecimal actiCost;
    @ApiModelProperty(value = "活动主办方",notes = "保存草稿时可空，发布活动时必填",example = "园区管委会")
    private String actiOrganizer;
    @ApiModelProperty(value = "活动人数",notes = "保存草稿时可空，发布活动时必填",example = "100")
    private Integer actiNumber;
    @ApiModelProperty(value = "活动海报路径",notes = "保存草稿时可空，发布活动时必填",example = "**/**/**.png")
    private String actiPosterUrl;
    @ApiModelProperty(value = "活动状态[1草稿 2报名中 3活动结束4活动取消 ]",example = "1",
            notes = "(修改只能修改活动状态actiStatus为1(草稿)的数据。新增活动为草稿时，必填字段只为活动名，当发布活动时，会校验所有必填字段。)")
    private String actiStatus;
    @ApiModelProperty(value = "是否首页展示（0：否，1：是）",notes = "保存草稿时可空，发布活动时必填",example = "1")
    private String isIndex;
    @ApiModelProperty(value = "排序-若排序字段为空，后台自动对其排序为0(靠后排序)",example = "0")
    private Integer actiOrder;
    @ApiModelProperty(value = "活动详情",notes = "保存草稿时可空，发布活动时必填",example = "活动详情详情....")
    private String actiDetail;
    @ApiModelProperty(value = "是否展示报名人-0否1是",notes = "保存草稿时可空，发布活动时必填",example = "1")
    private String showApplyNum;
    @ApiModelProperty(value = "报名是否需审核-0否1是",notes = "保存草稿时可空，发布活动时必填",example = "1")
    private String applyCheck;

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

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
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

    public String getApplyCheck() {
        return applyCheck;
    }

    public void setApplyCheck(String applyCheck) {
        this.applyCheck = applyCheck;
    }
}
