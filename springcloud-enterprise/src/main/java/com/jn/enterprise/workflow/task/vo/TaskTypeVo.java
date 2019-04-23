package com.jn.enterprise.workflow.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * TODO:未添加类描述
 *
 * @author： yuanyy
 * @date： Created on 2019/4/19 10:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TaskTypeVo", description = "事项任务")
public class TaskTypeVo implements Serializable {

    private static final long serialVersionUID = -567180905345364233L;
    @ApiModelProperty(value = "事项分类：1：数据上报、2：综合缴费、3：综合租赁")
    private String type;

    @ApiModelProperty(value = "事项分类总条数")
    private String total;

    @ApiModelProperty(value = "事项分类预警条数")
    private String warnNum;


    @ApiModelProperty(value = "事项列表")
    private List<TaskVo> taskList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWarnNum() {
        return warnNum;
    }

    public void setWarnNum(String warnNum) {
        this.warnNum = warnNum;
    }

    public List<TaskVo> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskVo> taskList) {
        this.taskList = taskList;
    }
}
