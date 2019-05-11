package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 15:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgActivityShow", description = "机构活动信息")
public class OrgActivityParam extends Page implements Serializable {
    @ApiModelProperty(value="开始时间  格式:yyyy-MM-dd",example = "2019-04-01")
    private String startTime;
    @ApiModelProperty(value="结束时间  格式:yyyy-MM-dd",example = "2019-04-30")
    private String endTime;
    @ApiModelProperty(value="时间段: 1: 最近一月,2:最近一周,0则返回全部" ,example = "1")
    @Pattern(regexp = "^[0-2]$",message = "只能为1: 最近一月,2:最近一周,0全部")
    private String timeInterval;

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
