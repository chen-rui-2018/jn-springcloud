package com.jn.park.sp.vo;

import com.jn.park.sp.model.SpPowerBusiMaterialsModel;
import com.jn.park.sp.model.SpPowerBusiModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 22:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SpPowerBusiDetailVo",description = "业务明细内容")
public class SpPowerBusiDetailVo extends SpPowerBusiModel implements Serializable {
    private static final long serialVersionUID = -4442252254493162760L;

    @ApiModelProperty("办理材料清单")
    private List<SpPowerBusiMaterialsModel>materialsModelList;

    @ApiModelProperty("受理时间，例如：工作日  上午9：00 - 12：00   下午 13：30 - 17：30")
    private String dealTime;

    @ApiModelProperty("受理地址")
    private String dealAddress;

    @ApiModelProperty("在线受理地址，点击新开窗口跳转")
    private String dealUrl;

    @ApiModelProperty("联系电话")
    private String linkPhone;

    @ApiModelProperty("承诺办理时限方式（单位：工作日）")
    private Byte dealLimitDays;

    @ApiModelProperty("流程图")
    private String flowPic;

    @ApiModelProperty("设定依据")
    private String settingBasis;

    @ApiModelProperty("办理条件")
    private String dealConditions;

    @ApiModelProperty("收费标准")
    private String feeStandard;

    @ApiModelProperty("是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty("创建者账号")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private String Time;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SpPowerBusiMaterialsModel> getMaterialsModelList() {
        return materialsModelList;
    }

    public void setMaterialsModelList(List<SpPowerBusiMaterialsModel> materialsModelList) {
        this.materialsModelList = materialsModelList;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealAddress() {
        return dealAddress;
    }

    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress;
    }

    public String getDealUrl() {
        return dealUrl;
    }

    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Byte getDealLimitDays() {
        return dealLimitDays;
    }

    public void setDealLimitDays(Byte dealLimitDays) {
        this.dealLimitDays = dealLimitDays;
    }

    public String getFlowPic() {
        return flowPic;
    }

    public void setFlowPic(String flowPic) {
        this.flowPic = flowPic;
    }

    public String getFeeStandard() {
        return feeStandard;
    }

    public void setFeeStandard(String feeStandard) {
        this.feeStandard = feeStandard;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSettingBasis() {
        return settingBasis;
    }

    public void setSettingBasis(String settingBasis) {
        this.settingBasis = settingBasis;
    }

    public String getDealConditions() {
        return dealConditions;
    }

    public void setDealConditions(String dealConditions) {
        this.dealConditions = dealConditions;
    }
}
