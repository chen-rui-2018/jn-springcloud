package com.jn.park.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 17:21
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="NoticePlatformShow",description = "平台类型展示")
public class NoticePlatformShow implements Serializable {
    @ApiModelProperty(value="平台类型(P001:全部-P002:App-P003:门户)")
    private String platformType;
    @ApiModelProperty(value="平台类型(全部/App/门户)")
    private String platformName;

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "NoticePlatformShow{" +
                "platformType='" + platformType + '\'' +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
