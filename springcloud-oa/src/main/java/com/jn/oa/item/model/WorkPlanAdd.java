package com.jn.oa.item.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel(value = "WorkPlanAdd", description = "工作计划分页实体")
public class WorkPlanAdd implements Serializable {
    private static final long serialVersionUID = 6739102264810728892L;

    @ApiModelProperty(value = "工作计划id")
    private String id;

    @ApiModelProperty(value = "项目id", required = true,example = "\"10000\"")
    @NotNull(message = "项目id不能为空")
    private String itemId;

    @ApiModelProperty(value = "项目负责人账号，多账号用','分开", required = true,example = "liuxiong,wangsong")
    @NotNull(message = "项目负责人不能为空")
    private String responsibleUserAccount;

    @ApiModelProperty(value = "工作计划名称", required = true,example = "工作计划")
    @NotNull(message = "工作计划名称不能为空")
    private String workPlanName;

    @ApiModelProperty(value = "任务内容", required = true,example = "工作计划内容测试")
    private String content;

    @ApiModelProperty(value = "需求描述", required = true,example = "工作计划需求测试")
    private String demandDescribe;

    @ApiModelProperty(value = "计划开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)",
            required = true,example = "2019-12-12 12:12:12")
    @NotNull(message = "计划开始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;

    @ApiModelProperty(value = "计划结束时间(时间统一格式为yyyy-MM-dd HH:mm:ss)",
            required = true,example = "2019-12-13 12:12:12")
    @NotNull(message = "计划结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;

    @ApiModelProperty(value = "计划工时", required = true,example = "10")
    @NotNull(message = "计划工时不能为空")
    private Integer planTime;

    @ApiModelProperty(value = "附件(格式:[{'title':'附件名称','url':'附件路径'}])", required = false,
            example = "\"[{\"title\":\"附件\",\"url\":\"https://www.baidu.com/img/dong_09e2cf5ed88fbc0093809ab8d37faf6e.gif\"}]\"")
    private String attachment;

    public WorkPlanAdd() {
    }

    public WorkPlanAdd(String id, String itemId, String responsibleUserAccount, String workPlanName, String content,
                       String demandDescribe, Date planStartTime, Date planEndTime, Integer planTime, String attachment) {
        this.id = id;
        this.itemId = itemId;
        this.responsibleUserAccount = responsibleUserAccount;
        this.workPlanName = workPlanName;
        this.content = content;
        this.demandDescribe = demandDescribe;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.planTime = planTime;
        this.attachment = attachment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getResponsibleUserAccount() {
        return responsibleUserAccount;
    }

    public void setResponsibleUserAccount(String responsibleUserAccount) {
        this.responsibleUserAccount = responsibleUserAccount;
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

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
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
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", responsibleUserAccount='" + responsibleUserAccount + '\'' +
                ", workPlanName='" + workPlanName + '\'' +
                ", content='" + content + '\'' +
                ", demandDescribe='" + demandDescribe + '\'' +
                ", planStartTime=" + planStartTime +
                ", planEndTime=" + planEndTime +
                ", planTime=" + planTime +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
