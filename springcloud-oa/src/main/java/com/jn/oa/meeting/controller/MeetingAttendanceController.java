package com.jn.oa.meeting.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.meeting.model.OaMeetingAttendancePage;
import com.jn.oa.meeting.model.OaMeetingParticipantsAttendance;
import com.jn.oa.meeting.service.MeetingAttendanceService;
import com.jn.oa.meeting.vo.OaMeetingAttendanceVo;
import com.jn.oa.meeting.vo.OaMeetingParticipantsAttendanceVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 会议考勤管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/1/29 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "会议考勤管理")
@RestController
@RequestMapping("/oa/oaMeetingAttendance")
public class MeetingAttendanceController extends BaseController {

    @Autowired
    private MeetingAttendanceService meetingAttendanceService;


    @ControllerLog(doAction = "会议考勤签到、签退接口")
    @ApiOperation(value = "会议考勤签到、签退接口" , notes = "会议考勤签到/签退类型:1:签到，2：签退")
    @RequestMapping(value = "/attendance", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingAttendance/attendance")
    public Result attendance(@Validated @RequestBody OaMeetingParticipantsAttendance oaMeetingParticipantsAttendance) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        meetingAttendanceService.meetingAttendanceSignIn(oaMeetingParticipantsAttendance,user);
        return new Result();
    }

    @ControllerLog(doAction = "会议考勤列表查询")
    @ApiOperation(value = "会议考勤列表查询" , notes = "根据查询条件分页查询会议考勤列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/oa/oaMeetingAttendance/list")
    public Result<List<OaMeetingParticipantsAttendanceVo>> list(@Validated @RequestBody OaMeetingAttendancePage oaMeetingAttendancePage) {
        PaginationData data=meetingAttendanceService.selectMeetingAttendanceList(oaMeetingAttendancePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "根据ID查询会议考勤")
    @ApiOperation(value = "根据ID查询会议考勤",notes = "根据id查询会议考勤与会议详情")
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @RequiresPermissions("/oa/oaMeetingAttendance/selectById")
    public Result<OaMeetingAttendanceVo> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "会议考勤ID不能为空");
        OaMeetingAttendanceVo data = meetingAttendanceService.selectMeetingAttendanceById(id);
        return new Result(data);
    }


}
