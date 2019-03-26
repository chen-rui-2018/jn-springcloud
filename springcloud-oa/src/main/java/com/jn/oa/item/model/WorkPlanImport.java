package com.jn.oa.item.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划导入实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/21 14:40
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanImport", description = "工作计划导入实体")
public class WorkPlanImport extends BaseRowModel implements Serializable {

    private static final long serialVersionUID = -5679596084509175330L;
    @ExcelProperty(value = "项目名称", index = 0)
    private String itemName;
    @ExcelProperty(value = "任务名称", index = 1)
    private String workPlanName;
    @ExcelProperty(value = "负责人", index = 2)
    private String userName;
    @ExcelProperty(value = "负责人邮箱", index = 3)
    private String email;
    @ExcelProperty(value = "开始时间", index = 4)
    private Date planStartTime;
    @ExcelProperty(value = "截止时间", index = 5)
    private Date planEndTime;
    @ExcelProperty(value = "预计工时", index = 6)
    private Integer planTime;
    @ExcelProperty(value = "任务内容", index = 7)
    private String content;
    @ExcelProperty(value = "需求描述", index = 8)
    private String demandDescribe;

    public WorkPlanImport() {
    }

    public WorkPlanImport(String itemName, String workPlanName, String userName, String email, Date planStartTime,
                          Date planEndTime, Integer planTime, String content, String demandDescribe) {
        this.itemName = itemName;
        this.workPlanName = workPlanName;
        this.userName = userName;
        this.email = email;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.planTime = planTime;
        this.content = content;
        this.demandDescribe = demandDescribe;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "WorkPlanImport{" +
                "itemName='" + itemName + '\'' +
                ", workPlanName='" + workPlanName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", planStartTime=" + planStartTime +
                ", planEndTime=" + planEndTime +
                ", planTime=" + planTime +
                ", content='" + content + '\'' +
                ", demandDescribe='" + demandDescribe + '\'' +
                '}';
    }
}
