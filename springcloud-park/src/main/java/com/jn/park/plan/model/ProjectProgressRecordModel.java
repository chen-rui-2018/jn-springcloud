package com.jn.park.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: tangry
 * @Date: 2019/5/11
 * @Version 1.0
 */
@ApiModel(value = "ProjectProgressRecordModel",description = "工程项目进度记录")
public class ProjectProgressRecordModel implements Serializable {


    private static final long serialVersionUID = 1394564871080192292L;

    @ApiModelProperty(value = "记录时间")
    private String createdTime;

    @ApiModelProperty(value = "进度")
    private String progress;

    @ApiModelProperty(value = "当前月份")
    private String currentData;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getCurrentData() {
        return currentData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }


    @Override
    public String toString() {
        return "ProjectProgressRecordModel{" +
                "createdTime='" + createdTime + '\'' +
                ", progress='" + progress + '\'' +
                ", currentData='" + currentData + '\'' +
                '}';
    }
}
