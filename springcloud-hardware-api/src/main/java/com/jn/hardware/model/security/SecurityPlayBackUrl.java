package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 14:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityPlayBackUrl",description = "监控点回放取流URL实体")
public class SecurityPlayBackUrl implements Serializable {


    private static final long serialVersionUID = 362447730847356776L;
    @ApiModelProperty(value = "显示开始时间 录像片段的开始时间（IOS8601格式yyyy-MM-dd'T'HH:mm:ss.SSSzzz")
    private String beginTime;
    @ApiModelProperty(value = "显示结束时间 录像片段的开始时间（IOS8601格式yyyy-MM-dd'T'HH:mm:ss.SSSzzz")
    private String endTime;
    @ApiModelProperty(value = "显示录像片段大小 录像片段大小（单位：Byte）")
    private  Number size;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Number getSize() {
        return size;
    }

    public void setSize(Number size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "SecurityPlayBackUrl{" +
                "beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", size=" + size +
                '}';
    }
}
