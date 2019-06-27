package com.jn.api;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.oa.api.OaClient;
import com.jn.oa.attendance.service.AttendanceService;
import com.jn.oa.dingTalk.service.DingTalkAttendanceService;
import com.jn.oa.dingTalk.service.DingTalkLeaveService;
import com.jn.oa.dingTalk.service.DingTalkUserService;
import com.jn.oa.email.service.EmailService;
import com.jn.oa.item.service.WorkPlanService;
import com.jn.oa.leave.service.LeaveService;
import com.jn.oa.meeting.service.MeetingService;
import com.jn.oa.model.*;
import com.jn.oa.multiDeptOffice.service.MultiDeptOfficeService;
import com.jn.oa.schedule.service.ScheduleService;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.oa.vo.LeaveApiVo;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 提供内部使用的API接口
 *
 * @author： yuanyy
 * @date： Created on 2019/3/7 18:09
 * @version： v1.0
 * @modified By:
 */
@RestController
public class OaController extends BaseController implements OaClient {
    private static Logger logger = LoggerFactory.getLogger(OaController.class);

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private WorkPlanService workPlanService;

    @Autowired
    private MultiDeptOfficeService multiDeptOfficeService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private DingTalkUserService dingTalkUserService;

    @Autowired
    private DingTalkLeaveService dingTalkLeaveService;

    @Autowired
    private DingTalkAttendanceService dingTalkAttendanceService;

    /**
     * 定时十分钟通知会议申请人
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "定时十分钟通知会议申请人")
    public Result<String> noticesApplicationMeeting() {
        logger.info("进入定时十分钟通知会议申请人");
        meetingService.noticesApplicationMeeting();
        return new Result();
    }

    /**
     * 更新会议状态运行中
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "更新会议状态运行中")
    public Result<String> updateMeetingStatusByTime() {
        logger.info("更新会议状态");
        meetingService.updateMeetingStatusByTime();
        return new Result();
    }

    /**
     * 一键Email定时发送接口
     *
     * @param email
     * @return
     */
    @Override
    @ControllerLog(doAction = "一键Email定时发送接口")
    public Result<Boolean> regularSendEmail(@RequestBody Email email) {
        Boolean result = emailService.regularSendEmail(email);
        return new Result(result);
    }

    /**
     * 工作计划提醒功能,每天定时提醒用户
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "工作计划提醒功能")
    public Result<Boolean> workPlanRemindEveryDay() {
        Boolean result = workPlanService.workPlanRemindEveryDay();
        return new Result<>(result);
    }

    /**
     * 每天陵城两点自动更新工作计划状态
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "每天陵城两点自动更新工作计划状态")
    public Result<Boolean> updateWorkPlanStatus() {
        workPlanService.updateWorkPlanIsExpire();
        return new Result<>(true);
    }

    /**
     * 每天自动更新多部门协同任务状态
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "每天自动更新多部门协同任务状态")
    public Result<Boolean> updateMultiDeptOfficeStatus() {
        multiDeptOfficeService.updateMultiDeptOfficeStatus();
        return new Result<>(true);
    }

    /**
     * 多部门协同定时提醒功能
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "多部门协同定时提醒功能")
    public Result<Boolean> multiDeptOfficeStatusRemind() {
        multiDeptOfficeService.remind();
        return new Result<>(true);
    }

    /**
     * 根据条件查询请假列表
     *
     * @param leave
     * @return
     */
    @Override
    @ControllerLog(doAction = "根据条件查询请假列表")
    public Result<List<LeaveApiVo>> searchLeaveListByCondition(@RequestBody Leave leave) {
        List<LeaveApiVo> result = leaveService.searchLeaveListByCondition(leave);
        return new Result(result);
    }

    /**
     * 根据条件查询考勤列表
     *
     * @param attendance
     * @return
     */
    @Override
    @ControllerLog(doAction = "根据条件查询考勤列表")
    public Result<List<AttendanceApiVo>> selectAttendanceListByCondition(@RequestBody Attendance attendance) {
        List<AttendanceApiVo> result = attendanceService.selectApiAttendanceListByCondition(attendance);
        return new Result(result);
    }

    /**
     * 日程管理定时提醒功能
     *
     * @param Schedule
     * @return
     */
    @Override
    @ControllerLog(doAction = "日程管理定时提醒功能")
    public Result scheduleRemind(@RequestBody Schedule Schedule) {
        scheduleService.scheduleRemind(Schedule);
        return null;
    }
    /**
     * 钉钉修改用户通讯录回调
     *
     * @param addressBookNotice
     * @return
     */
    @Override
    @ControllerLog(doAction = "钉钉修改用户通讯录回调")
    public Result updateOrInsertDingTalkUser(@RequestBody AddressBookNotice addressBookNotice) {
        dingTalkUserService.updateOrInsertDingTalkUser(addressBookNotice);
        return new Result();
    }

    /**
     * 批量更新钉钉用户表
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "批量更新钉钉用户表")
    public Result batchInsertDingTalkUser() {
        dingTalkUserService.batchInsertDingTalkUser();
        return new Result();
    }

    /**
     * 批量更新钉钉考勤
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "批量更新钉钉考勤")
    public Result batchInsertDingTalkAttendance(@RequestParam("workDateFrom")String workDateFrom, @RequestParam("workDateTo")String workDateTo) {
        dingTalkAttendanceService.batchInsertDingTalkAttendance(workDateFrom,workDateTo);
        return new Result();
    }

    /**
     * 批量更新钉钉考请假
     *
     * @return
     */
    @Override
    @ControllerLog(doAction = "批量更新钉钉考请假")
    public Result batchInsertDingTalkLeave(@RequestParam("workDateFrom")Date workDateFrom, @RequestParam("workDateTo")Date workDateTo) {
        dingTalkLeaveService.batchInsertDingTalkLeave(workDateFrom,workDateTo);
        return new Result();
    }


}
