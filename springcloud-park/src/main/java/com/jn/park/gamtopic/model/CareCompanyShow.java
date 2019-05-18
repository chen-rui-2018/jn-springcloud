package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 关注企业列表出参
 * @author： huxw
 * @date： Created on 2019-5-17 10:23:45
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CareCompanyShow",description = "关注企业列表")
public class CareCompanyShow implements Serializable {
    @ApiModelProperty(value = "企业ID")
    private String comId;
    @ApiModelProperty(value = "企业logo")
    private String avatar;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "粉丝数")
    private String fansNum;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }
}
