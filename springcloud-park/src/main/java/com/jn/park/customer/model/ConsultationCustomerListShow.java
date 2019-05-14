package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/5/14 10:12
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ConsultationCustomerListShow",description = "客服中心园区用户咨询客服列表出参")
public class ConsultationCustomerListShow implements Serializable {
    @ApiModelProperty("任务id(启动工作流后的流程实例id)")
    private String taskId;
    @ApiModelProperty("问题编码")
    private String quesCode;
    @ApiModelProperty("问题标题")
    private String quesTitle;
    @ApiModelProperty("问题详情")
    private String quesDetails;
    @ApiModelProperty("处理状态(1：待处理   2：已处理)")
    private String status;
    @ApiModelProperty("发布时间")
    private Date createdTime;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ConsultationCustomerListShow{" +
                "taskId='" + taskId + '\'' +
                ", quesCode='" + quesCode + '\'' +
                ", quesTitle='" + quesTitle + '\'' +
                ", quesDetails='" + quesDetails + '\'' +
                ", status='" + status + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
