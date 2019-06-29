package com.jn.hardware.server;

import com.jn.common.model.Result;
import com.jn.hardware.api.DingTalkClient;
import com.jn.hardware.ding.service.DingTalkAttendanceService;
import com.jn.hardware.ding.service.DingTalkBaseService;
import com.jn.hardware.ding.service.DingTalkDepartmentService;
import com.jn.hardware.ding.service.DingTalkUserService;
import com.jn.hardware.model.dingtalk.BaseResult;
import com.jn.hardware.model.dingtalk.attendance.*;
import com.jn.hardware.model.dingtalk.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 钉钉：内部接口实现类
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 14:57
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class DingTalkController implements DingTalkClient {

    @Autowired
    private DingTalkBaseService dingTalkBaseService;
    @Autowired
    private DingTalkUserService dingTalkUserService;
    @Autowired
    private DingTalkDepartmentService dingTalkDepartmentService;
    @Autowired
    private DingTalkAttendanceService dingTalkAttendanceService;


    /**
     * 强制获取access_token
     * @return
     */
    @Override
    public Result<String> getAccessToken() {
        return new Result(dingTalkBaseService.getAccessToken());
    }


    @Override
    public Result<DepartmentUserInfoResult> getDepartUserByPage(@RequestBody DepartmentUserInfoParam departmentUserInfoParam) {
        Result<DepartmentUserInfoResult> result = new Result<>();
        DepartmentUserInfoResult departmentUserInfoResult = dingTalkUserService.getDepartUserByPage(departmentUserInfoParam);
        if(!BaseResult.SUCCESS_CODE.equals(departmentUserInfoResult.getErrcode())) {
            result.setCode(departmentUserInfoResult.getErrcode());
            result.setResult(departmentUserInfoResult.getErrmsg());
        }
        result.setData(departmentUserInfoResult);
        return result;
    }

    @Override
    public Result<DepartmentListResult> getDepartmentList(@RequestBody DepartmentListParam departmentListParam) {
        Result<DepartmentListResult> result = new Result<>();
        DepartmentListResult departmentListResult = dingTalkDepartmentService.getDepartmentList(departmentListParam);
        if(!BaseResult.SUCCESS_CODE.equals(departmentListResult.getErrcode())) {
            result.setCode(departmentListResult.getErrcode());
            result.setResult(departmentListResult.getErrmsg());
        }
        result.setData(departmentListResult);
        return result;
    }

    /**
     * 获取打卡结果列表
     * @param clockInInfoParam
     * @return
     */
    @Override
    public Result<ClockInListResult> getClockInResultList(@RequestBody ClockInListParam clockInInfoParam) {
        Result<ClockInListResult> result = new Result<>();
        ClockInListResult clockInInfoResult = dingTalkAttendanceService.getClockInResultList(clockInInfoParam);

        if(!BaseResult.SUCCESS_CODE.equals(clockInInfoResult.getErrcode())) {
            result.setCode(clockInInfoResult.getErrcode());
            result.setResult(clockInInfoResult.getErrmsg());
        }
        result.setData(clockInInfoResult);
        return result;
    }

    /**
     * 获取请假状态
     * @param leaveStatusListParam
     * @return
     */
    @Override
    public Result<LeaveStatusListResult> getLeaveStatusList(@RequestBody LeaveStatusListParam leaveStatusListParam) {
        Result<LeaveStatusListResult> result = new Result<>();
        LeaveStatusListResult leaveStatusListResult = dingTalkAttendanceService.getLeaveStatusList(leaveStatusListParam);

        if(!BaseResult.SUCCESS_CODE.equals(leaveStatusListResult.getErrcode())) {
            result.setCode(leaveStatusListResult.getErrcode());
            result.setResult(leaveStatusListResult.getErrmsg());
        }
        result.setData(leaveStatusListResult);
        return result;

    }

    /**
     * 获取请假时长
     * @param leaveApproveduRationParam
     * @return
     */
    @Override
    public Result<LeaveApproveDurationResult> getLeaveApproveDuration(@RequestBody LeaveApproveDurationParam leaveApproveduRationParam) {
        Result<LeaveApproveDurationResult> result = new Result<>();
        LeaveApproveDurationResult leaveApproveduRationResult = dingTalkAttendanceService.getLeaveApproveDuration(leaveApproveduRationParam);

        if(!BaseResult.SUCCESS_CODE.equals(leaveApproveduRationResult.getErrcode())) {
            result.setCode(leaveApproveduRationResult.getErrcode());
            result.setResult(leaveApproveduRationResult.getErrmsg());
        }
        result.setData(leaveApproveduRationResult);
        return result;
    }

    /**
     * 获取用户详情
     * @param userInfoParam
     * @return
     */
    @Override
    public Result<UserDetailsInfoResult> getUserInfo(@RequestBody UserDetailsInfoParam userInfoParam) {
        Result<UserDetailsInfoResult> result = new Result<>();
        UserDetailsInfoResult userInfoResult = dingTalkUserService.getUserInfo(userInfoParam);

        if(!BaseResult.SUCCESS_CODE.equals(userInfoResult.getErrcode())) {
            result.setCode(userInfoResult.getErrcode());
            result.setResult(userInfoResult.getErrmsg());
        }
        result.setData(userInfoResult);
        return result;
    }

    /**
     * 获取部门详情
     * @param departmentDetailsInfoParam
     * @return
     */
    @Override
    public Result<DepartmentDetailsInfoResult> getDepartmentDetails(@RequestBody DepartmentDetailsInfoParam departmentDetailsInfoParam) {
        Result<DepartmentDetailsInfoResult> result = new Result<>();
        DepartmentDetailsInfoResult departmentDetailsInfoResult = dingTalkDepartmentService.getDepartmentDetails(departmentDetailsInfoParam);

        if(!BaseResult.SUCCESS_CODE.equals(departmentDetailsInfoResult.getErrcode())) {
            result.setCode(departmentDetailsInfoResult.getErrcode());
            result.setResult(departmentDetailsInfoResult.getErrmsg());
        }
        result.setData(departmentDetailsInfoResult);
        return result;
    }
}
