package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 公司企业
 * @author： jiangyl
 * @date： Created on 2019/3/5 19:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyProImgParam",description = "公司企业宣传图片入参")
public class CompanyProImgParam implements Serializable {

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;
    @ApiModelProperty(value = "图片介绍")
    private String imgIntrod;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgIntrod() {
        return imgIntrod;
    }

    public void setImgIntrod(String imgIntrod) {
        this.imgIntrod = imgIntrod;
    }
}
