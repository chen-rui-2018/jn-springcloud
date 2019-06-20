package com.jn.hr.employee.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author dt
 * @create 2019-04-23 上午 10:36
 */
@ApiModel(value = "HonorWall", description = "荣誉墙实体")
public class HonorWall {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "工号",required = true)
    private String jobNumber;
    @ApiModelProperty(value = "荣誉图片")
    private String honoraryPictures;
    @ApiModelProperty(value = "荣誉文件")
    private String honoraryFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getHonoraryPictures() {
        return honoraryPictures;
    }

    public void setHonoraryPictures(String honoraryPictures) {
        this.honoraryPictures = honoraryPictures;
    }

    public String getHonoraryFile() {
        return honoraryFile;
    }

    public void setHonoraryFile(String honoraryFile) {
        this.honoraryFile = honoraryFile;
    }

    @Override
    public String toString() {
        return "HonorWall{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", honoraryPictures='" + honoraryPictures + '\'' +
                ", honoraryFile='" + honoraryFile + '\'' +
                '}';
    }
}
