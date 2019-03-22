package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceRecordsFindAllVo",description = "财务文档分页")
public class FinanceRecordsFindAllVo implements Serializable {


    private static final long serialVersionUID = -827662969262793447L;

    @ApiModelProperty(value = "备案治疗名称")
    private String name;
    @ApiModelProperty(value = "流程节点类型")
    private String flowType;
    @ApiModelProperty(value = "录入人")
    private String creatorAccount;
    @ApiModelProperty(value = "录入部门")
    private String departmentName;
    @ApiModelProperty(value = "要求录入时间")
    private String deadline;
    @ApiModelProperty(value = "录入状态")
    private String createState;
    @ApiModelProperty(value = "财务确认状态")
    private String financerSure;
    @ApiModelProperty(value = "负责人预警")
    private String earlyWarning;
    @ApiModelProperty(value = "相关领导预警")
    private String leadrEarlyWarning;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCreateState() {
        return createState;
    }

    public void setCreateState(String createState) {
        this.createState = createState;
    }

    public String getFinancerSure() {
        return financerSure;
    }

    public void setFinancerSure(String financerSure) {
        this.financerSure = financerSure;
    }

    public String getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(String earlyWarning) {
        this.earlyWarning = earlyWarning;
    }

    public String getLeadrEarlyWarning() {
        return leadrEarlyWarning;
    }

    public void setLeadrEarlyWarning(String leadrEarlyWarning) {
        this.leadrEarlyWarning = leadrEarlyWarning;
    }
}
