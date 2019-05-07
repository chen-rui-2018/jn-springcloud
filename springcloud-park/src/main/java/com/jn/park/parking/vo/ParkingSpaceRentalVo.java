package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceRentalVo",description = "车位租赁详情")
public class ParkingSpaceRentalVo implements Serializable {

    @ApiModelProperty(value = "出租记录ID",example = "e2ew2***")
    private String rentId;
    @ApiModelProperty(value = "停车位ID",example = "e2ew3***")
    private String spaceId;
    @ApiModelProperty(value = "车位编号",example = "A00001")
    private String spaceSerial;
    @ApiModelProperty(value = "车主账号",example = "wangsong")
    private String account;
    @ApiModelProperty(value = "车主姓名",example = "王松")
    private String name;
    @ApiModelProperty(value = "联系电话",example = "18155559999")
    private String phone;
    @ApiModelProperty(value = "价格(单位元/年)",example = "2100")
    private String rentPrice;
    @ApiModelProperty(value = "优惠政策标识",example = "e2ew3***")
    private String policyId;
    @ApiModelProperty(value = "开始日期",example = "2019-01-01")
    private String startTime;
    @ApiModelProperty(value = "结束日期",example = "2020-01-01")
    private String endTime;
    @ApiModelProperty(value = "应缴金额",example = "2100")
    private Double dueMoney;
    @ApiModelProperty(value = "减免金额",example = "300")
    private Double deductionMoney;
    @ApiModelProperty(value = "实缴金额",example = "1800")
    private Double actualMoney;
    @ApiModelProperty(value = "缴费单号",example = "TCJF-20190101225548")
    private String orderBillNum;
    @ApiModelProperty(value = "审批人账号",example = "wangsong")
    private String approvalAccount;
    @ApiModelProperty(value = "审批人姓名",example = "王松")
    private String approvalName;
    @ApiModelProperty(value = "审批意见",example = "符合优惠条件，审批通过")
    private String approvalComments;
    @ApiModelProperty(value = "车位状态[0待审核,1审批中,2审核通过(待缴费),3审批不通过，4待支付，5支付中，6支付成功，7已取消]",example = "0")
    private String approvalStatus;
    @ApiModelProperty(value = "优惠政策编码",example = "gxrcyh")
    private String policyCode;
    @ApiModelProperty(value = "优惠政策名称",example = "高新人才优惠")
    private String policyComments;
    @ApiModelProperty(value = "合同附件名称",example = "A0001.pdf")
    private String contractAttachment;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceSerial() {
        return spaceSerial;
    }

    public void setSpaceSerial(String spaceSerial) {
        this.spaceSerial = spaceSerial;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Double deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getOrderBillNum() {
        return orderBillNum;
    }

    public void setOrderBillNum(String orderBillNum) {
        this.orderBillNum = orderBillNum;
    }

    public String getApprovalAccount() {
        return approvalAccount;
    }

    public void setApprovalAccount(String approvalAccount) {
        this.approvalAccount = approvalAccount;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalComments() {
        return approvalComments;
    }

    public void setApprovalComments(String approvalComments) {
        this.approvalComments = approvalComments;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getPolicyComments() {
        return policyComments;
    }

    public void setPolicyComments(String policyComments) {
        this.policyComments = policyComments;
    }

    public String getContractAttachment() {
        return contractAttachment;
    }

    public void setContractAttachment(String contractAttachment) {
        this.contractAttachment = contractAttachment;
    }
}
