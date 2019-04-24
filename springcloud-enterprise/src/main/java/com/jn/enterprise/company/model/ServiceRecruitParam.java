package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:35:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRecruitParam", description = "企业招聘入参（后台）")
public class ServiceRecruitParam extends ServiceWebRecruitParam implements Serializable {
    @ApiModelProperty(value = "企业ID", example = "2220112212")
    private String comId;
    @ApiModelProperty(value = "状态（1：已上架[默认] 0：已下架 2：全部）", example = "1")
    private String status;
    @ApiModelProperty(value = "开始查询日期yyyy-MM-dd", example = "2019-01-01")
    private String beginDate;
    @ApiModelProperty(value = "结束查询日期yyyy-MM-dd", example = "2019-01-01")
    private String endDate;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
