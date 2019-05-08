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
@ApiModel(value = "ParkingSpaceModel",description = "停车位")
public class ParkingSpaceModel implements Serializable {
    @ApiModelProperty(value = "车位ID[新增传空，修改必传]",example = "82uew2***")
    private String spaceId;

    @ApiModelProperty(value = "车位编码",required = true,example = "A0515")
    @NotNull(message = "车位编码不能为空")
    private String spaceSerial;

    @ApiModelProperty(value = "停车场ID",required = true,example = "82uew3***")
    @NotNull(message = "停车场ID不能为空")
    private String areaId;

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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
