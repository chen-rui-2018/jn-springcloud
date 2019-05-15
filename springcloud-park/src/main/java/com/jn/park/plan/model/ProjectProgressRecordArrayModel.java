package com.jn.park.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/5/11
 * @Version 1.0
 */
@ApiModel(value = "ProjectProgressRecordArrayModel",description = "工程项目进度记录Array")
public class ProjectProgressRecordArrayModel implements Serializable {


    private static final long serialVersionUID = 1394564871080192292L;

    @ApiModelProperty(value = "记录时间")
    List<String> createdTime;

    @ApiModelProperty(value = "进度")
    List<String> progress;

    @ApiModelProperty(value = "当前月份")
    String currentData;

    @Override
    public String toString() {
        return "ProjectProgressRecordArrayModel{" +
                "createdTime=" + createdTime +
                ", progress=" + progress +
                ", currentData='" + currentData + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(List<String> createdTime) {
        this.createdTime = createdTime;
    }

    public List<String> getProgress() {
        return progress;
    }

    public void setProgress(List<String> progress) {
        this.progress = progress;
    }

    public String getCurrentData() {
        return currentData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }
}
