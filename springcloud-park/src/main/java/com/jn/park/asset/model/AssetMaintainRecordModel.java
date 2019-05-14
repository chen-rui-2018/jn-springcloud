package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
* 维保记录model
* @author： zhuyz
* @date： Created on 2019/5/10 11:50
* @version： v1.0
* @modified By:
*/
public class AssetMaintainRecordModel implements Serializable {
    private static final long serialVersionUID = 6251468465612761433L;

    @ApiModelProperty(value = "主键",example = "575786950632407040")
    private String id;

    @ApiModelProperty(value = "资产编号",example = "575786950632407040")
    private String assetNumber;

    @ApiModelProperty(value = "维保时间",example = "2019-04-27")
    private String maintenanceTime;

    @ApiModelProperty(value = "备注",example = "加了雪种")
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(String maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
