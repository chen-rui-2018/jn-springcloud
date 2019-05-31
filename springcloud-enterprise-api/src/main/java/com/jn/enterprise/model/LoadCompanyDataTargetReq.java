package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 查询企业的上报数据 查询条件
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/24
 * </pre>
 */
@ApiModel(value = "LoadCompanyDataTargetReq",description = "查询企业的上报数据 查询条件")
public class LoadCompanyDataTargetReq implements Serializable {
    private static final long serialVersionUID = 967104402523863506L;

    @ApiModelProperty(value = "企业ID",example = "2220112212",required = true)
    @NotBlank
    private String enterpriseId;

    @ApiModelProperty(value = "指标ID（指标表：tb_data_reporting_snapshot_target）")
    String[] targetIds;

    @ApiModelProperty(value = "填报账期(月YYYYMM，年YYYY)")
    String dealTime;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String[] getTargetIds() {
        return targetIds;
    }

    public void setTargetIds(String[] targetIds) {
        this.targetIds = targetIds;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    @Override
    public String toString() {
        return "LoadCompanyDataTargetReq{" +
                "enterpriseId='" + enterpriseId + '\'' +
                ", targetIds=" + Arrays.toString(targetIds) +
                ", dealTime='" + dealTime + '\'' +
                '}';
    }
}
