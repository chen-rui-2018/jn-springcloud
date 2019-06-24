package com.jn.hardware.ding.service;

import com.jn.hardware.model.dingtalk.attendance.*;

/**
 * @ClassName：钉钉：考勤相关接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 11:35
 * @Version： v1.0
 * @Modified By:
 */
public interface DingTalkAttendanceService {

    /**
     * 获取打卡结果列表接口url
     */
    String GET_CLOCK_IN_RESULT_LIST_URL = "https://oapi.dingtalk.com/attendance/list?access_token=%s";
    /**
     * 获取请假状态接口url
     */
    String GET_LEAVE_STATUS_LIST_URL = "https://oapi.dingtalk.com/topapi/attendance/getleavestatus?access_token=%s";
    /**
     * 获取请假时长接口url
     */
    String GET_LEAVE_APPROVE_DURATION_URL = "https://oapi.dingtalk.com/topapi/attendance/getleaveapproveduration?access_token=%s";

    /**
     * 获取打卡结果列表
     * @param clockInInfoParam
     * @return
     */
    ClockInListResult getClockInResultList(ClockInListParam clockInInfoParam);

    /**
     * 获取请假状态列表
     * @param leaveStatusListParam
     * @return
     */
    LeaveStatusListResult getLeaveStatusList(LeaveStatusListParam leaveStatusListParam);

    /**
     * 获取请假时长列表
     * @param leaveApproveduRationParam
     * @return
     */
    LeaveApproveDurationResult getLeaveApproveDuration(LeaveApproveDurationParam leaveApproveduRationParam);
}
