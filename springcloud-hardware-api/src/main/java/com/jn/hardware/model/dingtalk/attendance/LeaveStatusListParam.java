package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName：钉钉：获取请假状态入参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 15:51
 * @Version： v1.0
 * @Modified By:
 */
public class LeaveStatusListParam implements Serializable {

    private static final long serialVersionUID = -3732838933945102262L;

    /**
     * 查询用户id列表，支持最多100个用户的批量查询 示例值：123,121
    * */
    @JsonProperty("userid_list")
    @NotBlank(message = "待查询用户id列表不能为空！，示例值：123,121 ")
    private String useridList;

    /**
     * 开始时间(UNIX时间戳)，支持最多180天的查询 ,示例值：1538323200000
     * */
    @JsonProperty("start_time")
    @NotNull(message = "开始时间(UNIX时间戳) 不能为空!")
    private Long startTime;

    /**
     * 结束时间(UNIX时间戳)，支持最多180天的查询时间 示例值：1538323200000
    * */
    @JsonProperty("end_time")
    @NotNull(message = "结束时间(UNIX时间戳) 不能为空!")
    private Long endTime;

    /**
     * 分页偏移，非负整数 示例值：0
    * */
    @NotNull(message = "分页偏移不能为空！ 非负整数 示例值：0 ")
    private Long offset;

    /**
     * 分页大小，正整数，最大20
     * */
    @NotNull(message = "分页大小不能为空! 正整数，最大20")
    private Long size;

    public String getUseridList() {
        return useridList;
    }

    public void setUseridList(String useridList) {
        this.useridList = useridList;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "LeaveStatusListParam{" +
                "useridList='" + useridList + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", offset=" + offset +
                ", size=" + size +
                '}';
    }
}
