package com.jn.park.index.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 服务搜索入参
 * @author： huxw
 * @date： Created on 2019-4-16 16:27:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceSearchParam",description = "服务搜索入参")
public class ServiceSearchParam extends Page implements Serializable {

    @ApiModelProperty(value = "是否需要分页 1:分页 0:不分页[活动搜索必分页]", required = true, example = "1")
    @Pattern(regexp = "^[01]$", message = "默认值只允许为0,1")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    @ApiModelProperty(value = "关键字[模糊搜索]", required = true, example = "春天")
    @NotNull(message="搜索关键字不能为空")
    private String searchFiled;

    @ApiModelProperty(value = "搜索类型（0活动 1政策服务）", required = true, example = "0")
    @Pattern(regexp = "^[01]$", message = "搜索类型只允许为0,1")
    private String serviceType;

    @ApiModelProperty(value = "table类型(0:政策一览 1:图解政策 2:一号专题 3：民营专题)[默认0]", example = "0")
    @Pattern(regexp = "^[0-3]$", message = "table类型传参错误")
    private String tableType;

    @ApiModelProperty(value = "政策类型(0:普通政策  1:图解政策)[默认0]", example = "0")
    @Pattern(regexp = "^[0-1]$", message = "政策类型传参错误")
    private String policyType;

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    @Override
    public String toString() {
        return "ServiceSearchParam{" +
                "needPage='" + needPage + '\'' +
                ", searchFiled='" + searchFiled + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", tableType='" + tableType + '\'' +
                ", policyType='" + policyType + '\'' +
                '}';
    }
}
