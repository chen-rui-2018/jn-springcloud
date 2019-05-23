package com.jn.oa.meeting.controller;

import com.jn.common.controller.BaseController;

import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.oa.meeting.enums.MeetingRoomStatusEnums;
import com.jn.oa.meeting.model.OaMeetingPage;

import com.jn.oa.meeting.model.OaMeetingRoomPage;
import com.jn.oa.meeting.service.MeetingRoomService;
import com.jn.oa.meeting.service.MeetingService;

import com.jn.oa.meeting.vo.OaMeetingRoomVo;
import com.jn.oa.meeting.vo.OaMeetingVo;
import com.jn.system.log.annotation.ControllerLog;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * 会议管理controller
 *
 * @author： yuanyy
 * @date： Created on 2019/1/29 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "会议申请展示")
@RestController
@RequestMapping("/guest/oaMeeting")
public class MeetingGuestController extends BaseController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingRoomService meetingRoomService;




    @ControllerLog(doAction = "查询会议申请展示列表")
    @ApiOperation(value = "查询会议申请展示列表")
    @RequestMapping(value = "/showList", method = RequestMethod.POST)
    public Result<List<OaMeetingVo>> showList(@Validated @RequestBody OaMeetingPage oaMeetingPage) {
        Assert.notNull(oaMeetingPage.getMeetingRoomId(), "会议室ID不能为空");
        //获取当前登录用户信息
        oaMeetingPage.setCurrentTime(new Date());
        List<OaMeetingVo> data = meetingService.selectShowOaMeetingListBySearchKey(oaMeetingPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询会议列表")
    @ApiOperation(value = "查询会议列表")
    @RequestMapping(value = "/showMeetingRoomList", method = RequestMethod.POST)
    public Result<List<OaMeetingRoomVo>> showMeetingRoomList() {
        OaMeetingRoomPage oaMeetingRoomPage=new OaMeetingRoomPage();
        oaMeetingRoomPage.setRecordStatus(MeetingRoomStatusEnums.EFFECTIVE.getCode());
        List<OaMeetingRoomVo> data = meetingRoomService.selectOaMeetingRoomListBySearchKeyNoPage(oaMeetingRoomPage);
        return new Result(data);
    }





}
