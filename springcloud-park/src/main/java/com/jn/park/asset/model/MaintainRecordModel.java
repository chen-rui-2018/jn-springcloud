package com.jn.park.asset.model;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class MaintainRecordModel implements Serializable {
    private static final long serialVersionUID = 402050908337276395L;

    @ApiModelProperty(value = "资产编号",example = "572058527984517120")
    private String assetNumber;

    @ApiModelProperty(value = "备注",example = "加了雪种")
    private String message;

    @ApiModelProperty(value = "登记照片",example = "url")
    private String imgUrl;

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "MaintainRecordModel{" +
                "assetNumber='" + assetNumber + '\'' +
                ", message='" + message + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

