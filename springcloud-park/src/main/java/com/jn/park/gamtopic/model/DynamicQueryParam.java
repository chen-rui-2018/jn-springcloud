package com.jn.park.gamtopic.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 16:23
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DynamicQueryParam" ,description = "动态列表查询的入参")
public class DynamicQueryParam extends Page implements Serializable {
    @ApiModelProperty(value="开始时间",example = "2019-04-03")
    private String startTime;
    @ApiModelProperty(value="结束时间",example = "2019-04-30")
    private String endTime;
    @ApiModelProperty(value="用户昵称",example = "喜洋洋")
    private String nickName;
    @ApiModelProperty(value="电话号码",example = "12345677896")
    private String phone;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
