package com.jn.hardware.model.dingtalk.attendance;

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
    private  Boolean has_more;

    /**
     * 是否有更多数据
     * */
    private List<LeaveStatusInfo> leave_status;

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    public List<LeaveStatusInfo> getLeave_status() {
        return leave_status;
    }

    public void setLeave_status(List<LeaveStatusInfo> leave_status) {
        this.leave_status = leave_status;
    }

    @Override
    public String toString() {
        return "LeaveStatusList{" +
                "has_more=" + has_more +
                ", leave_status=" + leave_status +
                '}';
    }
}
