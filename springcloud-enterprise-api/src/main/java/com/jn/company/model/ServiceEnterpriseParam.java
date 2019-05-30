package com.jn.company.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/5/24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceEnterpriseParam", description = "企业简介查询入参")
public class ServiceEnterpriseParam extends Page implements Serializable {

    private static final long serialVersionUID = 5085520769089005087L;

    @ApiModelProperty(value = "企业名称[模糊搜索]", example = "南京")
    private String comName;

    @Pattern(regexp = "^[12]$", message = "企业来源校验错误")
    @ApiModelProperty(value = "企业来源[1人才企业2招商企业]]", example = "1")
    private String comSource;

    @ApiModelProperty(value = "所属园区(传园区的id)", example = "0001")
    private String affiliatedPark;

    @ApiModelProperty(value = "产业领域", example = "cloud_computing")
    private String induType;

    @ApiModelProperty(value = "排序字段")
    private String orderByClause;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark;
    }

    public String getInduType() {
        return induType;
    }

    public void setInduType(String induType) {
        this.induType = induType;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Override
    public String toString() {
        return "ServiceEnterpriseParam{" +
                "comName='" + comName + '\'' +
                ", comSource='" + comSource + '\'' +
                ", affiliatedPark='" + affiliatedPark + '\'' +
                ", induType='" + induType + '\'' +
                ", orderByClause='" + orderByClause + '\'' +
                '}';
    }
}
