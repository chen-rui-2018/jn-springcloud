package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/15 14:40
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceModuleShow",description = "客服中心在线客服服务模块信息")
public class ServiceModuleShow implements Serializable {
    @ApiModelProperty(value = "模块id")
    private String serviceModule;
    @ApiModelProperty(value = "模块名称")
    private String serviceModuleName;

    public String getServiceModule() {
        return serviceModule;
    }

    public void setServiceModule(String serviceModule) {
        this.serviceModule = serviceModule;
    }

    public String getServiceModuleName() {
        return serviceModuleName;
    }

    public void setServiceModuleName(String serviceModuleName) {
        this.serviceModuleName = serviceModuleName;
    }

    @Override
    public String toString() {
        return "ServiceModuleShow{" +
                "serviceModule='" + serviceModule + '\'' +
                ", serviceModuleName='" + serviceModuleName + '\'' +
                '}';
    }
}
