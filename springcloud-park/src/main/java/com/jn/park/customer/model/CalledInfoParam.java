package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/23 0:12
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CalledInfoParam",description = "客服中心来电录入入参")
public class CalledInfoParam implements Serializable {
    @ApiModelProperty(value = "问题标题",required = true,example = "xxx问题")
    @Size(max=100,message = "问题标题不能超过100字")
    private String quesTitle;
    @ApiModelProperty(value = "问题描述",required = true,example = "xxx问题的具体描述...")
    @Size(max=300, message = "问题描述不能超过300字")
    private String quesDetails;
    @ApiModelProperty(value = "服务模块编码(从服务模块编码信息接口获取)",required = true,example = "service_consulting")
    private String serviceModule;
    @ApiModelProperty(value = "客户类型编码(1：个人    2：企业)",required = true,example = "1")
    @Pattern(regexp = "^[12]$", message = "{客户类型编码:'默认值只允许为1,2'}")
    private String clientType;
    @ApiModelProperty(value = "客户姓名",required = true,example = "张三")
    private String custName;
    @ApiModelProperty(value = "联系方式（手机号码/邮箱/座机号）",required = true,example = "18088888888")
    @Pattern(regexp = "([\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?) " +
            "|(^(((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8})$)"+"|(^0\\d{2,3}-[1-9]\\d{6,7}$)",
            message = "{'联系方式格式出错，只能是手机号，邮箱，座机号'}")
    private String contactWay;
    @ApiModelProperty(value = "当前来电号码（客服来电录入使用,其他情况忽略(1001-1005,8001-8005为测试号码)）",example = "18088888888")
    @Pattern(regexp = "(^(((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8})$)"
            +"|(^0\\d{2,3}-[1-9]\\d{6,7}$)"+"|(^0\\d{2,3}[1-9]\\d{6,7}$)"+"|(^100[1-5])"+"|(^800[1-5])"+"|(^8000[1-5])" +"|(\\s*)",
            message = "{'当前来电号码格式不正确的，只能是手机号(18888888888)，座机号(0256-9978827,025-66666666)'}")
    private String calledPhone;

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

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getCalledPhone() {
        return calledPhone;
    }

    public void setCalledPhone(String calledPhone) {
        this.calledPhone = calledPhone;
    }

    @Override
    public String toString() {
        return "CalledInfoParam{" +
                "quesTitle='" + quesTitle + '\'' +
                ", quesDetails='" + quesDetails + '\'' +
                ", serviceModule='" + serviceModule + '\'' +
                ", clientType='" + clientType + '\'' +
                ", custName='" + custName + '\'' +
                ", contactWay='" + contactWay + '\'' +
                ", calledPhone='" + calledPhone + '\'' +
                '}';
    }
}
