package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.dingtalk.attendance.*;
import com.jn.hardware.model.dingtalk.user.DepartmentListParam;
import com.jn.hardware.model.dingtalk.user.DepartmentListResult;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoParam;
import com.jn.hardware.model.dingtalk.user.DepartmentUserInfoResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 钉钉提供的内部服务接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:52
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-hardware")
public interface DingTalkClient {

    /**
     * 强制刷新钉钉access_token
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getAccessToken")
    Result<String> getAccessToken();

    /**
     * 分页获取部门用户详情
     * @param departmentUserInfoParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getDepartUserByPage")
    Result<DepartmentUserInfoResult> getDepartUserByPage(@RequestBody @Validated DepartmentUserInfoParam departmentUserInfoParam);

    /**
     * 获取部门列表信息
     * @param departmentListParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getDepartmentList")
    Result<DepartmentListResult> getDepartmentList(@RequestBody @Validated DepartmentListParam departmentListParam);

    /**
     * 获取打卡结果列表
     * @param clockInListParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getClockInResultList")
    Result<ClockInListResult> getClockInResultList(@RequestBody @Validated ClockInListParam clockInListParam);

    /**
     * 获取请假状态列表
     * @param leaveStatusListParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getLeaveStatusList")
    Result<LeaveStatusListResult> getLeaveStatusList(@RequestBody @Validated LeaveStatusListParam leaveStatusListParam);

    /**
     * 获取请假时长
     * @param leaveApproveduRationParam
     * @return
     */
    @RequestMapping(value = "/api/hardware/dingTalk/getLeaveApproveDuration")
    Result<LeaveApproveDurationResult> getLeaveApproveDuration(@RequestBody @Validated LeaveApproveDurationParam leaveApproveduRationParam);
}
