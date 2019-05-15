package com.jn.park.plan.vo;


/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "ProjectPlanVo",description = "任务进展")
public class ProjectPlanVo implements Serializable {

    private static final long serialVersionUID = -5033939417834914862L;
    @ApiModelProperty(value = "总数")
    private String key;

    @ApiModelProperty(value = "未开始")
    private String value;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProjectPlanVo{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
