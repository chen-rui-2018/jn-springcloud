package com.jn.hr.employee.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-30 下午 4:13
 */
@ApiModel(value = "DirectlyLeader", description = "直属领导实体")
public class DirectlyLeader extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "工号")
    @ExcelProperty(value = "工号", index = 0)
    private String jobNumber;
    @ApiModelProperty(value = "直属领导职级")
    private String directLeaderLevel;
    @ApiModelProperty(value = "直属领导职务")
    private String directLeadership;
    @ApiModelProperty(value = "直属领导姓名")
    @ExcelProperty(value = "直属领导姓名", index = 3)
    private String directLeaderName;
    @ApiModelProperty(value = "直属领导职级名称")
    @ExcelProperty(value = "直属领导职级", index = 1)
    private String directLeaderLevelName;
    @ApiModelProperty(value = "直属领导职务名称")
    @ExcelProperty(value = "直属领导职务", index = 2)
    private String directLeadershipName;

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

    public String getDirectLeaderLevel() {
        return directLeaderLevel;
    }

    public void setDirectLeaderLevel(String directLeaderLevel) {
        this.directLeaderLevel = directLeaderLevel;
    }

    public String getDirectLeadership() {
        return directLeadership;
    }

    public void setDirectLeadership(String directLeadership) {
        this.directLeadership = directLeadership;
    }

    public String getDirectLeaderName() {
        return directLeaderName;
    }

    public void setDirectLeaderName(String directLeaderName) {
        this.directLeaderName = directLeaderName;
    }

    public String getDirectLeaderLevelName() {
        return directLeaderLevelName;
    }

    public void setDirectLeaderLevelName(String directLeaderLevelName) {
        this.directLeaderLevelName = directLeaderLevelName;
    }

    public String getDirectLeadershipName() {
        return directLeadershipName;
    }

    public void setDirectLeadershipName(String directLeadershipName) {
        this.directLeadershipName = directLeadershipName;
    }
}
