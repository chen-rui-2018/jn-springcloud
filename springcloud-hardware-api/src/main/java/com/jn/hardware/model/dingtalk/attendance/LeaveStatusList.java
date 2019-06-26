package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：钉钉：获取请假状态集合
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/19 16:12
 * @Version： v1.0
 * @Modified By:
 */
public class LeaveStatusList implements Serializable {

    private static final long serialVersionUID = -5667493613055330718L;

    /**
     * 是否有更多数据
    * */
    @JsonProperty("has_more")
    private  Boolean hasMore;

    /**
     * 是否有更多数据
     * */
    @JsonProperty("leave_status")
    private List<LeaveStatusInfo> leaveStatus;

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<LeaveStatusInfo> getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(List<LeaveStatusInfo> leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    @Override
    public String toString() {
        return "LeaveStatusList{" +
                "hasMore=" + hasMore +
                ", leaveStatus=" + leaveStatus +
                '}';
    }
}
