package com.jn.oa.item.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 工作计划分页实体
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 16:14
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanPage", description = "工作计划分页实体")
public class WorkPlanPage extends Page implements Serializable {
    private static final long serialVersionUID = 6810932122166006955L;
    @ApiModelProperty(value = "工作计划名称",example = "工作")
    private String workPlanName;
    @ApiModelProperty(value = "项目名称",example = "\"10000\"")
    private String itemId;
    @ApiModelProperty(value = "用户账号",example = "wangsong")
    private String userAccount;
    @ApiModelProperty(value = "任务状态(0未开始,1进行中,2已挂起,3已完成,4已延期)",example = "1")
    private String workPlanStatus;

    public WorkPlanPage() {
    }

    public WorkPlanPage(String workPlanName, String itemId, String userAccount, String workPlanStatus) {
        this.workPlanName = workPlanName;
        this.itemId = itemId;
        this.userAccount = userAccount;
        this.workPlanStatus = workPlanStatus;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getWorkPlanStatus() {
        return workPlanStatus;
    }

    public void setWorkPlanStatus(String workPlanStatus) {
        this.workPlanStatus = workPlanStatus;
    }

    @Override
    public String toString() {
        return "WorkPlanPage{" +
                "workPlanName='" + workPlanName + '\'' +
                ", itemId='" + itemId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", workPlanStatus='" + workPlanStatus + '\'' +
                '}';
    }
}
