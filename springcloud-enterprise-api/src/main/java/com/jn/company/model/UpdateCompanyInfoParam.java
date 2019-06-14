package com.jn.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 企业缴费成功修改企业信息
 * @author： huxw
 * @date： Created on 2019/5/28 9:36
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "UpdateCompanyInfoParam",description = "企业缴费成功修改企业信息")
public class UpdateCompanyInfoParam implements Serializable {

    @ApiModelProperty(value = "企业ID", required = true)
    @NotNull(message = "企业ID不能为空")
    private String comId;

    @ApiModelProperty(value = "所属园区")
    private String affiliatedPark;

    @ApiModelProperty(value = "公司园区地址（实际经营地址）")
    private String addrPark;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark;
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    @Override
    public String toString() {
        return "UpdateCompanyInfoParam{" +
                "comId='" + comId + '\'' +
                ", affiliatedPark='" + affiliatedPark + '\'' +
                ", addrPark='" + addrPark + '\'' +
                '}';
    }
}
