package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/22 10:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceUserCountVo",description = "用户停车位统计信息")
public class ParkingSpaceUserCountVo implements Serializable {

    @ApiModelProperty(value = "已停车位数",example = "3")
    private String useSpace;

    @ApiModelProperty(value = "总车位数",example = "6")
    private String spaceTotal;

    public String getUseSpace() {
        return useSpace;
    }

    public void setUseSpace(String useSpace) {
        this.useSpace = useSpace;
    }

    public String getSpaceTotal() {
        return spaceTotal;
    }

    public void setSpaceTotal(String spaceTotal) {
        this.spaceTotal = spaceTotal;
    }
}
