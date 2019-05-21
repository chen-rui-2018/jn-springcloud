package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
*
* @author： zhuyz
* @date： Created on 2019/5/8 15:05
* @version： v1.0
* @modified By:
*/
public class RoomPayOrdersModel implements Serializable {
    private static final long serialVersionUID = 7931481554400000727L;

    @ApiModelProperty(value = "订单明细信息")
    private List<RoomPayOrdersItemModel> roomPayOrdersItemModels;

    @ApiModelProperty(value ="主键(总订单id)",example = "")
    private String id;

    @ApiModelProperty(value = "时间")
    private java.util.Date createTime;

    @ApiModelProperty(value = "创建时间",example = "2019-05-04 17:22:10")
    private String Time;

    @ApiModelProperty(value = "账单类型",example = "房间租赁")
    private String ordersType;

    @ApiModelProperty(value = "最迟缴费时间",example = "2019-05-04 18:22:10")
    private String lastPayTime;

    @ApiModelProperty(value = "开始时间",example = "2019-05-01")
    private Date leaseStartTime;

    @ApiModelProperty(value = "结束时间",example = "2019-06-01")
    private Date leaseEndTime;

    @ApiModelProperty(value = "合计",example = "900.00")
    private BigDecimal paySum;

    public List<RoomPayOrdersItemModel> getRoomPayOrdersItemModels() {
        return roomPayOrdersItemModels;
    }

    public void setRoomPayOrdersItemModels(List<RoomPayOrdersItemModel> roomPayOrdersItemModels) {
        this.roomPayOrdersItemModels = roomPayOrdersItemModels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getOrdersType() {
        return ordersType;
    }

    public void setOrdersType(String ordersType) {
        this.ordersType = ordersType;
    }

    public String getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(String lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    @Override
    public String toString() {
        return "RoomPayOrdersModel{" +
                "roomPayOrdersItemModels=" + roomPayOrdersItemModels +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", Time='" + Time + '\'' +
                ", ordersType='" + ordersType + '\'' +
                ", lastPayTime='" + lastPayTime + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", paySum=" + paySum +
                '}';
    }
}
