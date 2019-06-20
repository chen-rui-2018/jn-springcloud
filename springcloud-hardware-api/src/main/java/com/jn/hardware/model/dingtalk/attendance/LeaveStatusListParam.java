package com.jn.hardware.model.dingtalk.attendance;

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
    @NotBlank(message = "待查询用户id列表不能为空！，示例值：123,121 ")
    private String userid_list;

    /**
     * 开始时间(UNIX时间戳)，支持最多180天的查询 ,示例值：1538323200000
     * */
    @NotNull(message = "开始时间(UNIX时间戳) 不能为空!")
    private Long start_time;

    /**
     * 结束时间(UNIX时间戳)，支持最多180天的查询时间 示例值：1538323200000
    * */
    @NotNull(message = "结束时间(UNIX时间戳) 不能为空!")
    private Long end_time;

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

    public String getUserid_list() {
        return userid_list;
    }

    public void setUserid_list(String userid_list) {
        this.userid_list = userid_list;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
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
                "userid_list='" + userid_list + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", offset=" + offset +
                ", size=" + size +
                '}';
    }
}
