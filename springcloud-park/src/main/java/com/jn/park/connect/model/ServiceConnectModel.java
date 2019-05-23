package com.jn.park.connect.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/4/26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceConnectModel",description = "服务链接信息")
public class ServiceConnectModel implements Serializable {


    private static final long serialVersionUID = -1343971160099411648L;



    @ApiModelProperty(value = "入口名称")
    private String entranceName;

    @ApiModelProperty(value = "连接地址")
    private String connectAddress;

    @ApiModelProperty(value = "显示图片")
    private String showImg;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName;
    }

    public String getConnectAddress() {
        return connectAddress;
    }

    public void setConnectAddress(String connectAddress) {
        this.connectAddress = connectAddress;
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg;
    }


    @Override
    public String toString() {
        return "ServiceConnectModel{" +
                "entranceName='" + entranceName + '\'' +
                ", connectAddress='" + connectAddress + '\'' +
                ", showImg='" + showImg + '\'' +
                '}';
    }
}
