package com.jn.park.spPower.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* @author： zhuyz
* @date： Created on 2019/4/11 17:26
* @version： v1.0
* @modified By:
*/
@ApiModel(value = "SpAdModel",description = "行政审批广告")
public class SpAdModel implements Serializable {
    //
    private static final long serialVersionUID = -8446089038948886372L;
    @ApiModelProperty(value = "主键",example = "565912101348966400")
    private String id;

    @ApiModelProperty(value = "广告图名称")
    private String adName;

    @ApiModelProperty(value = "广告图地址")
    private String adAddress;

    @ApiModelProperty(value = "广告图链接")
    private String adUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdAddress() {
        return adAddress;
    }

    public void setAdAddress(String adAddress) {
        this.adAddress = adAddress;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }
}
