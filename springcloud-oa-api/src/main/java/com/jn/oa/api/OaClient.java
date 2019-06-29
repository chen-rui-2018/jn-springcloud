package com.jn.oa.api;

import com.jn.common.model.Result;
import com.jn.oa.model.*;
import com.jn.oa.vo.AttendanceApiVo;
import com.jn.oa.vo.LeaveApiVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * oa系统客户端
 *
 * @author： yuanyy
 * @date： Created on 2019/3/7 18:04
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-oa")
public interface OaClient {

    /**
     * 定时十分钟通知会议申请人
     *
     * @return
     */
    @RequestMapping(value = "/api/oa/notices", method = RequestMethod.POST)
    Result<String> noticesApplicationMeeting();

    /**
     * 更新会议状态
     *
     * @return
     */
    @RequestMapping(value = "/api/oa/meetingStatus", method = RequestMethod.POST)
    Result<String> updateMeetingStatusByTime();

    /**
     * 一键Email定时发送接口
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "/api/oa/regularSendEmail", method = RequestMethod.POST)
    Result<Boolean> regularSendEmail(@RequestBody Email email);

    /**
     * 工作计划提醒功能,每天定时提醒用户
     *
     * @return
     */
    @RequestMapping(value = "/api/oa/workPlanRemindEveryDay", method = RequestMethod.POST)
    Result<Boolean> workPlanRemindEveryDay();

    /**
     * 每天凌晨两点自动更新工作计划已延迟状态
     *
     * @return
     */
    @RequestMapping(value = "/api/oa/updateWorkPlanStatus", method = RequestMethod.POST)
    Result<Boolean> updateWorkPlanStatus();

    /**
     * 每天自动更新多部门协同状态信息
     *
     * @return
     */
    @RequestMapping(value = "/api/oa/updateMultiDeptOfficeStatus", method = RequestMethod.POST)
    Result<Boolean> updateMultiDeptOfficeStatus();


    /**
     * 多部门协同定时提醒功能
     *
     * @return
     */
    @RequestMapping(value = "/api/oa/multiDeptOfficeStatusRemind", method = RequestMethod.POST)
    Result<Boolean> multiDeptOfficeStatusRemind();


    /**
     * 根据条件查询请假列表
     *
     * @param leave
     * @return
     */
    @RequestMapping(value = "/api/oa/searchLeaveListByCondition", method = RequestMethod.POST)
    Result<List<LeaveApiVo>> searchLeaveListByCondition(@RequestBody Leave leave);

    /**
     * 根据条件查询考勤列表
     *
     * @param attendance
     * @return
     */
    @RequestMapping(value = "/api/oa/selectAttendanceListByCondition", method = RequestMethod.POST)
    Result<List<AttendanceApiVo>> selectAttendanceListByCondition(@RequestBody Attendance attendance);

    /**
     * 日程管理定时提醒用户功能
     *
     * @param Schedule
     * @return
     */
    @RequestMapping(value = "/api/oa/scheduleRemind", method = RequestMethod.POST)
    Result scheduleRemind(@RequestBody Schedule Schedule);

    /**
     * 钉钉修改用户通讯录回调
     * @param addressBookNotice
     * @return
     */
    @RequestMapping(value = "/api/oa/updateOrInsertDingTalkUser", method = RequestMethod.POST)
    Result updateOrInsertDingTalkUser(@RequestBody AddressBookNotice addressBookNotice);

    /**
     * 批量更新钉钉用户表
     * @return
     */
    @RequestMapping(value = "/api/oa/batchInsertDingTalkUser", method = RequestMethod.GET)
    Result batchInsertDingTalkUser();

    /**
     * 钉钉修改用户通讯录回调
     * @param workDateFrom
     * @param workDateTo
     * @return
     */
    @RequestMapping(value = "/api/oa/batchInsertDingTalkAttendance", method = RequestMethod.POST)
    Result batchInsertDingTalkAttendance(@RequestParam("workDateFrom")String workDateFrom, @RequestParam("workDateTo")String workDateTo);

    /**
     * 钉钉修改用户通讯录回调
     * @param workDateFrom
     * @param workDateTo
     * @return
     */
    @RequestMapping(value = "/api/oa/batchInsertDingTalkLeave", method = RequestMethod.POST)
    Result batchInsertDingTalkLeave(@RequestParam("workDateFrom") Date workDateFrom, @RequestParam("workDateTo")Date workDateTo);
}
