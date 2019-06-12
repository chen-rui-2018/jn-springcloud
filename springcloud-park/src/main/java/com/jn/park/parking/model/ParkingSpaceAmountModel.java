package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceAmountModel",description = "租车位价格计算")
public class ParkingSpaceAmountModel implements Serializable {
    @ApiModelProperty(value = "停车场ID",required = true,example = "24518153833")
    @NotNull(message = "停车场ID不能为空")
    private String areaId;

    @ApiModelProperty(value = "优惠标识",example = "we23eew32452r2")
    private String policyId;

    @ApiModelProperty(value = "租赁开始时间[yyyy-MM-dd]",required = true,example = "2019-01-01")
    @NotNull(message = "租赁开始时间不能为空")
    private String startTime;

    @ApiModelProperty(value = "租赁结束时间[yyyy-MM-dd]",required = true,example = "2020-01-01")
    @NotNull(message = "租赁结束时间不能为空")
    private String endTime;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
}
