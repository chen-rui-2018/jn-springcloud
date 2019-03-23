package com.jn.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户已报名的活动列表
 * @author： chenr
 * @date： Created on 2019/3/22 11:55
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityListApplyed" ,description = "用户已报名的活动列表")
public class ActivityListApplyed implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动类型名称")
    private String typeName;
    @ApiModelProperty(value = "活动费用,费用为0,则显示免费")
    private BigDecimal actiCost;
    @ApiModelProperty(value = "活动主办方")
    private String actiOrganizer;
    @ApiModelProperty(value = "活动园区名称")
    private String parkName;
    @ApiModelProperty(value = "活动地址")
    private String actiAddress;
    @ApiModelProperty(value = "活动开始时间")
    private Date actiStartTime;
    @ApiModelProperty(value = "活动状态 , 2报名中 3活动结束4活动取消")
    private String actiStatus;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getActiAddress() {
        return actiAddress;
    }

    public void setActiAddress(String actiAddress) {
        this.actiAddress = actiAddress;
    }

    public Date getActiStartTime() {
        return actiStartTime;
    }

    public void setActiStartTime(Date actiStartTime) {
        this.actiStartTime = actiStartTime;
    }

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
    }
}
