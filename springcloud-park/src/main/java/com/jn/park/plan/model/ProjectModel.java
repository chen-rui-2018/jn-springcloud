package com.jn.park.plan.model;


/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "ProjectModel",description = "工程项目")
public class ProjectModel extends Page implements Serializable {

    @ApiModelProperty(value = "工程状态(为空是查询全部;2 已完成;1 进行中;0 未开始)")
    private String projectState;

    @ApiModelProperty(value = "进度(为空是查询全部;0 正常;1 提前;2 延迟)")
    private String progress;

    @ApiModelProperty(value = "工程项目名称")
    private String projectName;

    @ApiModelProperty(value = "排序字段(空格隔开)desc/asc(project_no:项目编号/surplus_time:剩余工期/progress:进度)默认project_no desc",example = "project_no desc")
    private String orderByClause;


    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }


    @Override
    public String toString() {
        return "ProjectModel{" +
                "projectState='" + projectState + '\'' +
                ", progress='" + progress + '\'' +
                ", projectName='" + projectName + '\'' +
                ", orderByClause='" + orderByClause + '\'' +
                '}';
    }
}
