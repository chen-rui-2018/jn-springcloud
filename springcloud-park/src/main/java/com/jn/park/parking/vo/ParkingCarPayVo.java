package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingCarPayVo",description = "临停发起支付VO")
public class ParkingCarPayVo implements Serializable {

    @ApiModelProperty(value = "出租记录ID",example = "e2ew2***")
    private String parkingId;
    @ApiModelProperty(value = "账单号",example = "TC-201904245258748")
    private String billNum;
    @ApiModelProperty(value = "账单Id",example = "e2ew4***")
    private String billId;
    @ApiModelProperty(value = "支付金额",example = "5.0")
    private Double dueMoney;
    @ApiModelProperty(value = "账单发起状态 0失败 1成功 2月租车无需支付 3缴费金额为0无需支付",example = "e2ew3***")
    private String createStatus;

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public String getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(String createStatus) {
        this.createStatus = createStatus;
    }
}
