package com.jn.park.fileimg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 15:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FileImg",description = "图片文件")
public class FileImg {

    @ApiModelProperty(value = "图片地址",required = true,example = "**/**/**.png")
    @NotNull(message="图片地址不能为空")
    private String imgUrl;

    @ApiModelProperty(value = "图片说明",notes = "可为空")
    private String imgRemark;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark;
    }
}
