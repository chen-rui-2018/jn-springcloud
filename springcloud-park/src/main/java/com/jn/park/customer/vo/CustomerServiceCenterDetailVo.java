package com.jn.park.customer.vo;

import com.jn.park.customer.model.ExecuteHistoryShow;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/17 14:26
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CustomerServiceCenterDetailVo",description = "客服中心园区用户问题详情入参")
public class CustomerServiceCenterDetailVo implements Serializable {
    @ApiModelProperty("流程实例id(启动工作流后的流程实例id)")
    private String processInsId;
    @ApiModelProperty("问题编码")
    private String quesCode;
    @ApiModelProperty("问题标题")
    private String quesTitle;
    @ApiModelProperty("问题详情")
    private String quesDetails;
    @ApiModelProperty("问题描述url(最多允许三张图片)")
    private String quesUrl;
    @ApiModelProperty("服务模块编码")
    private String serviceModule;
    @ApiModelProperty("服务模块名称")
    private String serviceModuleName;
    @ApiModelProperty("客户类型编码(1：个人    2：企业)")
    private String clientType;
    @ApiModelProperty("联系方式（手机号码/邮箱）")
    private String contactWay;
    @ApiModelProperty("处理状态(0：待处理  1:处理中 2：已处理,3:无法处理)")
    private String status;
    @ApiModelProperty("问题处理记录")
    private List<ExecuteHistoryShow> executeHistoryShowList;

    public String getProcessInsId() {
        return processInsId;
    }

    public void setProcessInsId(String processInsId) {
        this.processInsId = processInsId;
    }

    public String getQuesCode() {
        return quesCode;
    }

    public void setQuesCode(String quesCode) {
        this.quesCode = quesCode;
    }

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

    public String getQuesUrl() {
        return quesUrl;
    }

    public void setQuesUrl(String quesUrl) {
        this.quesUrl = quesUrl;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ExecuteHistoryShow> getExecuteHistoryShowList() {
        return executeHistoryShowList;
    }

    public void setExecuteHistoryShowList(List<ExecuteHistoryShow> executeHistoryShowList) {
        this.executeHistoryShowList = executeHistoryShowList;
    }

    @Override
    public String toString() {
        return "CustomerServiceCenterDetailVo{" +
                "processInsId='" + processInsId + '\'' +
                ", quesCode='" + quesCode + '\'' +
                ", quesTitle='" + quesTitle + '\'' +
                ", quesDetails='" + quesDetails + '\'' +
                ", quesUrl='" + quesUrl + '\'' +
                ", serviceModule='" + serviceModule + '\'' +
                ", serviceModuleName='" + serviceModuleName + '\'' +
                ", clientType='" + clientType + '\'' +
                ", contactWay='" + contactWay + '\'' +
                ", status='" + status + '\'' +
                ", executeHistoryShowList=" + executeHistoryShowList +
                '}';
    }
}
