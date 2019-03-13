package com.jn.oa.item.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划添加实体
 *
 * @author： shaobao
 * @date： Created on 2019/2/25 9:13
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanPage", description = "工作计划分页实体")
public class WorkPlanAdd implements Serializable {
    private static final long serialVersionUID = 6739102264810728892L;
    @ApiModelProperty(value = "项目id",required = true)
    @NotNull(message = "项目id不能为空")
    private String itemId;
    @ApiModelProperty(value = "工作计划名称",required = true)
    @NotNull(message = "工作计划名称不能为空")
    private String workPlanName;
    @ApiModelProperty(value = "任务内容",required = true)
    private String content;
    @ApiModelProperty(value = "需求描述",required = true)
    private String demandDescribe;
    @ApiModelProperty(value = "计划开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)",required = true)
    @NotNull(message = "计划开始时间不能为空")
    private String planStartTime;
    @ApiModelProperty(value = "计划结束时间(时间统一格式为yyyy-MM-dd HH:mm:ss)",required = true)
    @NotNull(message = "计划结束时间不能为空")
    private String planEndTime;
    @ApiModelProperty(value = "计划工时",required = true)
    @NotNull(message = "计划工时不能为空")
    private Integer planTime;
    @ApiModelProperty(value = "附件(格式:[{'title':'附件名称','url':'附件路径'}])",required = false)
    private String attachment;

    public WorkPlanAdd() {
    }

    public WorkPlanAdd(String itemId, String workPlanName, String content, String demandDescribe, String planStartTime,
                       String planEndTime, Integer planTime, String attachment) {
        this.itemId = itemId;
        this.workPlanName = workPlanName;
        this.content = content;
        this.demandDescribe = demandDescribe;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.planTime = planTime;
        this.attachment = attachment;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDemandDescribe() {
        return demandDescribe;
    }

    public void setDemandDescribe(String demandDescribe) {
        this.demandDescribe = demandDescribe;
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Integer getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Integer planTime) {
        this.planTime = planTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }


    @Override
    public String toString() {
        return "WorkPlanAdd{" +
                "itemId='" + itemId + '\'' +
                ", workPlanName='" + workPlanName + '\'' +
                ", content='" + content + '\'' +
                ", demandDescribe='" + demandDescribe + '\'' +
                ", planStartTime='" + planStartTime + '\'' +
                ", planEndTime='" + planEndTime + '\'' +
                ", planTime=" + planTime +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
