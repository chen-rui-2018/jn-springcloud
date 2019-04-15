package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
