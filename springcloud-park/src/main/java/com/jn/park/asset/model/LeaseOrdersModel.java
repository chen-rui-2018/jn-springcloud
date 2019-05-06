package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Date;

/**
* 租赁订单model
* @author： zhuyz
* @date： Created on 2019/4/29 21:32
* @version： v1.0
* @modified By:
*/
public class LeaseOrdersModel implements Serializable {
    private static final long serialVersionUID = 2214128452191613168L;

    @ApiModelProperty(value ="主键",example = "2019050417220960019")
    private String id;

    @ApiModelProperty(value = "时间")
    private java.util.Date createTime;

    @ApiModelProperty(value = "创建时间",example = "2019-05-04 17:22:10")
    private String Time;

    @ApiModelProperty(value = "账单类型",example = "物品租赁")
    private String ordersType;

    @ApiModelProperty(value = "最迟缴费时间",example = "2019-05-04 18:22:10")
    private String lastPayTime;

    @ApiModelProperty(value = "资产编号",example = "572058527984517120")
    private String assetNumber;

    @ApiModelProperty(value = "物品名称",example = "空调")
    private String articleName;

    @ApiModelProperty(value = "资产类型",example = "空调")
    private String assetType;

    @ApiModelProperty(value = "规格",example = "1匹")
    private String specification;

    @ApiModelProperty(value = "单价",example = "200.00")
    private String leasePrice;

    @ApiModelProperty(value = "押金",example = "100.00")
    private String leaseCash;

    @ApiModelProperty(value = "开始时间",example = "2019-05-01")
    private Date startTime;

    @ApiModelProperty(value = "结束时间",example = "2019-05-04")
    private Date endTime;

    @ApiModelProperty(value = "合计",example = "900.00")
    private String paySum ;

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

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(String leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(String leaseCash) {
        this.leaseCash = leaseCash;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPaySum() {
        return paySum;
    }

    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }
}
