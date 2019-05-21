package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @Author: yangph
 * @Date: 2019/5/15 11:51
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OnlineCustomerParam",description = "客服中心在线客服入参")
public class OnlineCustomerParam implements Serializable {
    @ApiModelProperty(value = "问题标题",required = true,example = "xxx问题")
    @Size(max=100,message = "问题标题不能超过100字")
    private String quesTitle;
    @ApiModelProperty(value = "问题描述",required = true,example = "xxx问题的具体描述...")
    @Size(max=300, message = "问题描述不能超过300字")
    private String quesDetails;
    @ApiModelProperty("问题描述url(最多允许三张图片)")
    private String[] quesUrl;
    @ApiModelProperty(value = "服务模块编码(从服务模块编码信息接口获取)",required = true,example = "service_consulting")
    private String serviceModule;
    @ApiModelProperty(value = "客户类型编码(1：个人    2：企业)",required = true,example = "1")
    @Pattern(regexp = "^[12]$", message = "{clientType:'默认值只允许为1,2'}")
    private String clientType;
    @ApiModelProperty(value = "联系方式（手机号码/邮箱）",required = true,example = "18088888888")
    @Pattern(regexp = "([\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?) " +
            "|(^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$)",
            message = "{contactWay:'手机号码/邮箱验证出错'}")
    private String contactWay;

    public String getQuesTitle() {
        return quesTitle;
    }

    public void setQuesTitle(String quesTitle) {
        this.quesTitle = quesTitle;
    }

    public String getQuesDetails() {
        return quesDetails;
    }

    public void setQuesDetails(String quesDetails) {
        this.quesDetails = quesDetails;
    }

    public String[] getQuesUrl() {
        return quesUrl;
    }

    public void setQuesUrl(String[] quesUrl) {
        this.quesUrl = quesUrl;
    }

    public String getServiceModule() {
        return serviceModule;
    }

    public void setServiceModule(String serviceModule) {
        this.serviceModule = serviceModule;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    @Override
    public String toString() {
        return "OnlineCustomerParam{" +
                "quesTitle='" + quesTitle + '\'' +
                ", quesDetails='" + quesDetails + '\'' +
                ", quesUrl=" + Arrays.toString(quesUrl) +
                ", serviceModule='" + serviceModule + '\'' +
                ", clientType='" + clientType + '\'' +
                ", contactWay='" + contactWay + '\'' +
                '}';
    }
}
