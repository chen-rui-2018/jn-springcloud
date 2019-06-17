package com.jn.enterprise.workflow.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 流程待办数据
 * @Author: huxw
 * @Date: 2019-5-25 15:21:59
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CommonTaskVO",description = "流程待办数据")
public class CommonTaskVO implements Serializable {
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("流程提交说明")
    private String subject;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "CommonTaskVO{" +
                "createTime='" + createTime + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
